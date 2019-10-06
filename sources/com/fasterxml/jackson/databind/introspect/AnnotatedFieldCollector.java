package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnnotatedFieldCollector extends CollectorBase {
    private final MixInResolver _mixInResolver;
    private final TypeFactory _typeFactory;

    private static final class FieldBuilder {
        public AnnotationCollector annotations = AnnotationCollector.emptyCollector();
        public final Field field;
        public final TypeResolutionContext typeContext;

        public FieldBuilder(TypeResolutionContext tc, Field f) {
            this.typeContext = tc;
            this.field = f;
        }

        public AnnotatedField build() {
            return new AnnotatedField(this.typeContext, this.field, this.annotations.asAnnotationMap());
        }
    }

    AnnotatedFieldCollector(AnnotationIntrospector intr, TypeFactory types, MixInResolver mixins) {
        super(intr);
        this._typeFactory = types;
        this._mixInResolver = intr == null ? null : mixins;
    }

    public static List<AnnotatedField> collectFields(AnnotationIntrospector intr, TypeResolutionContext tc, MixInResolver mixins, TypeFactory types, JavaType type) {
        return new AnnotatedFieldCollector(intr, types, mixins).collect(tc, type);
    }

    /* access modifiers changed from: 0000 */
    public List<AnnotatedField> collect(TypeResolutionContext tc, JavaType type) {
        Map<String, FieldBuilder> foundFields = _findFields(tc, type, null);
        if (foundFields == null) {
            return Collections.emptyList();
        }
        List<AnnotatedField> result = new ArrayList<>(foundFields.size());
        for (FieldBuilder b : foundFields.values()) {
            result.add(b.build());
        }
        return result;
    }

    private Map<String, FieldBuilder> _findFields(TypeResolutionContext tc, JavaType type, Map<String, FieldBuilder> fields) {
        Field[] arr$;
        JavaType parent = type.getSuperClass();
        if (parent == null) {
            return fields;
        }
        Class<?> cls = type.getRawClass();
        Map<String, FieldBuilder> fields2 = _findFields(new Basic(this._typeFactory, parent.getBindings()), parent, fields);
        for (Field f : ClassUtil.getDeclaredFields(cls)) {
            if (_isIncludableField(f)) {
                if (fields2 == null) {
                    fields2 = new LinkedHashMap<>();
                }
                FieldBuilder b = new FieldBuilder(tc, f);
                if (this._intr != null) {
                    b.annotations = collectAnnotations(b.annotations, f.getDeclaredAnnotations());
                }
                fields2.put(f.getName(), b);
            }
        }
        MixInResolver mixInResolver = this._mixInResolver;
        if (mixInResolver != null) {
            Class<?> mixin = mixInResolver.findMixInClassFor(cls);
            if (mixin != null) {
                _addFieldMixIns(mixin, cls, fields2);
            }
        }
        return fields2;
    }

    private void _addFieldMixIns(Class<?> mixInCls, Class<?> targetClass, Map<String, FieldBuilder> fields) {
        Field[] arr$;
        for (Class<?> mixin : ClassUtil.findSuperClasses(mixInCls, targetClass, true)) {
            for (Field mixinField : ClassUtil.getDeclaredFields(mixin)) {
                if (_isIncludableField(mixinField)) {
                    FieldBuilder b = (FieldBuilder) fields.get(mixinField.getName());
                    if (b != null) {
                        b.annotations = collectAnnotations(b.annotations, mixinField.getDeclaredAnnotations());
                    }
                }
            }
        }
    }

    private boolean _isIncludableField(Field f) {
        if (!f.isSynthetic() && !Modifier.isStatic(f.getModifiers())) {
            return true;
        }
        return false;
    }
}
