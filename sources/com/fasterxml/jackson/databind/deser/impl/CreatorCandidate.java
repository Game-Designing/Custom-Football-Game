package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

public final class CreatorCandidate {
    protected final AnnotatedWithParams _creator;
    protected final AnnotationIntrospector _intr;
    protected final int _paramCount;
    protected final Param[] _params;

    public static final class Param {
        public final AnnotatedParameter annotated;
        public final Value injection;
        public final BeanPropertyDefinition propDef;

        public Param(AnnotatedParameter p, BeanPropertyDefinition pd, Value i) {
            this.annotated = p;
            this.propDef = pd;
            this.injection = i;
        }
    }

    protected CreatorCandidate(AnnotationIntrospector intr, AnnotatedWithParams ct, Param[] params, int count) {
        this._intr = intr;
        this._creator = ct;
        this._params = params;
        this._paramCount = count;
    }

    public static CreatorCandidate construct(AnnotationIntrospector intr, AnnotatedWithParams creator, BeanPropertyDefinition[] propDefs) {
        int pcount = creator.getParameterCount();
        Param[] params = new Param[pcount];
        int i = 0;
        while (i < pcount) {
            AnnotatedParameter annParam = creator.getParameter(i);
            params[i] = new Param(annParam, propDefs == null ? null : propDefs[i], intr.findInjectableValue(annParam));
            i++;
        }
        return new CreatorCandidate(intr, creator, params, pcount);
    }

    public AnnotatedWithParams creator() {
        return this._creator;
    }

    public int paramCount() {
        return this._paramCount;
    }

    public Value injection(int i) {
        return this._params[i].injection;
    }

    public AnnotatedParameter parameter(int i) {
        return this._params[i].annotated;
    }

    public BeanPropertyDefinition propertyDef(int i) {
        return this._params[i].propDef;
    }

    public PropertyName paramName(int i) {
        BeanPropertyDefinition propDef = this._params[i].propDef;
        if (propDef != null) {
            return propDef.getFullName();
        }
        return null;
    }

    public PropertyName explicitParamName(int i) {
        BeanPropertyDefinition propDef = this._params[i].propDef;
        if (propDef == null || !propDef.isExplicitlyNamed()) {
            return null;
        }
        return propDef.getFullName();
    }

    public PropertyName findImplicitParamName(int i) {
        String str = this._intr.findImplicitPropertyName(this._params[i].annotated);
        if (str == null || str.isEmpty()) {
            return null;
        }
        return PropertyName.construct(str);
    }

    public int findOnlyParamWithoutInjection() {
        int missing = -1;
        for (int i = 0; i < this._paramCount; i++) {
            if (this._params[i].injection == null) {
                if (missing >= 0) {
                    return -1;
                }
                missing = i;
            }
        }
        return missing;
    }

    public String toString() {
        return this._creator.toString();
    }
}
