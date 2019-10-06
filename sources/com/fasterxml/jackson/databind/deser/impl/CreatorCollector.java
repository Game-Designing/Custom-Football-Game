package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import p005cm.aptoide.p006pt.BuildConfig;

public class CreatorCollector {
    protected static final String[] TYPE_DESCS = {BuildConfig.APTOIDE_THEME, "from-String", "from-int", "from-long", "from-double", "from-boolean", "delegate", "property-based"};
    protected SettableBeanProperty[] _arrayDelegateArgs;
    protected final BeanDescription _beanDesc;
    protected final boolean _canFixAccess;
    protected final AnnotatedWithParams[] _creators = new AnnotatedWithParams[9];
    protected SettableBeanProperty[] _delegateArgs;
    protected int _explicitCreators = 0;
    protected final boolean _forceAccess;
    protected boolean _hasNonDefaultCreator = false;
    protected AnnotatedParameter _incompleteParameter;
    protected SettableBeanProperty[] _propertyBasedArgs;

    protected static final class StdTypeConstructor extends AnnotatedWithParams implements Serializable {
        private final AnnotatedWithParams _base;
        private final int _type;

        public StdTypeConstructor(AnnotatedWithParams base, int t) {
            super(base, null);
            this._base = base;
            this._type = t;
        }

        public static AnnotatedWithParams tryToOptimize(AnnotatedWithParams src) {
            if (src != null) {
                Class<?> rawType = src.getDeclaringClass();
                if (rawType == List.class || rawType == ArrayList.class) {
                    return new StdTypeConstructor(src, 1);
                }
                if (rawType == LinkedHashMap.class) {
                    return new StdTypeConstructor(src, 3);
                }
                if (rawType == HashMap.class) {
                    return new StdTypeConstructor(src, 2);
                }
            }
            return src;
        }

        /* access modifiers changed from: protected */
        public final Object _construct() {
            int i = this._type;
            if (i == 1) {
                return new ArrayList();
            }
            if (i == 2) {
                return new HashMap();
            }
            if (i == 3) {
                return new LinkedHashMap();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown type ");
            sb.append(this._type);
            throw new IllegalStateException(sb.toString());
        }

        public int getParameterCount() {
            return this._base.getParameterCount();
        }

        public Class<?> getRawParameterType(int index) {
            return this._base.getRawParameterType(index);
        }

        public JavaType getParameterType(int index) {
            return this._base.getParameterType(index);
        }

        public Object call() throws Exception {
            return _construct();
        }

        public Object call(Object[] args) throws Exception {
            return _construct();
        }

        public Object call1(Object arg) throws Exception {
            return _construct();
        }

        public Class<?> getDeclaringClass() {
            return this._base.getDeclaringClass();
        }

        public Member getMember() {
            return this._base.getMember();
        }

        public void setValue(Object pojo, Object value) throws UnsupportedOperationException, IllegalArgumentException {
            throw new UnsupportedOperationException();
        }

        public Object getValue(Object pojo) throws UnsupportedOperationException, IllegalArgumentException {
            throw new UnsupportedOperationException();
        }

        public Annotated withAnnotations(AnnotationMap fallback) {
            throw new UnsupportedOperationException();
        }

        public AnnotatedElement getAnnotated() {
            return this._base.getAnnotated();
        }

        public String getName() {
            return this._base.getName();
        }

        public JavaType getType() {
            return this._base.getType();
        }

        public Class<?> getRawType() {
            return this._base.getRawType();
        }

        public boolean equals(Object o) {
            return o == this;
        }

        public int hashCode() {
            return this._base.hashCode();
        }

        public String toString() {
            return this._base.toString();
        }
    }

    public CreatorCollector(BeanDescription beanDesc, MapperConfig<?> config) {
        this._beanDesc = beanDesc;
        this._canFixAccess = config.canOverrideAccessModifiers();
        this._forceAccess = config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    }

    public ValueInstantiator constructValueInstantiator(DeserializationConfig config) {
        JavaType delegateType = _computeDelegateType(this._creators[6], this._delegateArgs);
        JavaType arrayDelegateType = _computeDelegateType(this._creators[8], this._arrayDelegateArgs);
        JavaType type = this._beanDesc.getType();
        AnnotatedWithParams defaultCtor = StdTypeConstructor.tryToOptimize(this._creators[0]);
        StdValueInstantiator inst = new StdValueInstantiator(config, type);
        AnnotatedWithParams[] annotatedWithParamsArr = this._creators;
        inst.configureFromObjectSettings(defaultCtor, annotatedWithParamsArr[6], delegateType, this._delegateArgs, annotatedWithParamsArr[7], this._propertyBasedArgs);
        inst.configureFromArraySettings(this._creators[8], arrayDelegateType, this._arrayDelegateArgs);
        inst.configureFromStringCreator(this._creators[1]);
        inst.configureFromIntCreator(this._creators[2]);
        inst.configureFromLongCreator(this._creators[3]);
        inst.configureFromDoubleCreator(this._creators[4]);
        inst.configureFromBooleanCreator(this._creators[5]);
        inst.configureIncompleteParameter(this._incompleteParameter);
        return inst;
    }

    public void setDefaultCreator(AnnotatedWithParams creator) {
        AnnotatedWithParams[] annotatedWithParamsArr = this._creators;
        _fixAccess(creator);
        annotatedWithParamsArr[0] = creator;
    }

    public void addStringCreator(AnnotatedWithParams creator, boolean explicit) {
        verifyNonDup(creator, 1, explicit);
    }

    public void addIntCreator(AnnotatedWithParams creator, boolean explicit) {
        verifyNonDup(creator, 2, explicit);
    }

    public void addLongCreator(AnnotatedWithParams creator, boolean explicit) {
        verifyNonDup(creator, 3, explicit);
    }

    public void addDoubleCreator(AnnotatedWithParams creator, boolean explicit) {
        verifyNonDup(creator, 4, explicit);
    }

    public void addBooleanCreator(AnnotatedWithParams creator, boolean explicit) {
        verifyNonDup(creator, 5, explicit);
    }

    public void addDelegatingCreator(AnnotatedWithParams creator, boolean explicit, SettableBeanProperty[] injectables, int delegateeIndex) {
        if (creator.getParameterType(delegateeIndex).isCollectionLikeType()) {
            if (verifyNonDup(creator, 8, explicit)) {
                this._arrayDelegateArgs = injectables;
            }
        } else if (verifyNonDup(creator, 6, explicit)) {
            this._delegateArgs = injectables;
        }
    }

    public void addPropertyCreator(AnnotatedWithParams creator, boolean explicit, SettableBeanProperty[] properties) {
        if (verifyNonDup(creator, 7, explicit)) {
            if (properties.length > 1) {
                HashMap<String, Integer> names = new HashMap<>();
                int len = properties.length;
                for (int i = 0; i < len; i++) {
                    String name = properties[i].getName();
                    if (!name.isEmpty() || properties[i].getInjectableValueId() == null) {
                        Integer old = (Integer) names.put(name, Integer.valueOf(i));
                        if (old != null) {
                            throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d)", new Object[]{name, old, Integer.valueOf(i)}));
                        }
                    }
                }
            }
            this._propertyBasedArgs = properties;
        }
    }

    public boolean hasDefaultCreator() {
        return this._creators[0] != null;
    }

    public boolean hasDelegatingCreator() {
        return this._creators[6] != null;
    }

    public boolean hasPropertyBasedCreator() {
        return this._creators[7] != null;
    }

    private JavaType _computeDelegateType(AnnotatedWithParams creator, SettableBeanProperty[] delegateArgs) {
        if (!this._hasNonDefaultCreator || creator == null) {
            return null;
        }
        int ix = 0;
        if (delegateArgs != null) {
            int i = 0;
            int len = delegateArgs.length;
            while (true) {
                if (i >= len) {
                    break;
                } else if (delegateArgs[i] == null) {
                    ix = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        return creator.getParameterType(ix);
    }

    private <T extends AnnotatedMember> T _fixAccess(T member) {
        if (member != null && this._canFixAccess) {
            ClassUtil.checkAndFixAccess((Member) member.getAnnotated(), this._forceAccess);
        }
        return member;
    }

    /* access modifiers changed from: protected */
    public boolean verifyNonDup(AnnotatedWithParams newOne, int typeIndex, boolean explicit) {
        boolean verify;
        int mask = 1 << typeIndex;
        this._hasNonDefaultCreator = true;
        AnnotatedWithParams oldOne = this._creators[typeIndex];
        if (oldOne != null) {
            if ((this._explicitCreators & mask) == 0) {
                verify = !explicit;
            } else if (!explicit) {
                return false;
            } else {
                verify = true;
            }
            if (verify && oldOne.getClass() == newOne.getClass()) {
                Class<?> oldType = oldOne.getRawParameterType(0);
                Class<?> newType = newOne.getRawParameterType(0);
                if (oldType == newType) {
                    if (_isEnumValueOf(newOne)) {
                        return false;
                    }
                    if (!_isEnumValueOf(oldOne)) {
                        Object[] objArr = new Object[4];
                        objArr[0] = TYPE_DESCS[typeIndex];
                        objArr[1] = explicit ? "explicitly marked" : "implicitly discovered";
                        objArr[2] = oldOne;
                        objArr[3] = newOne;
                        throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", objArr));
                    }
                } else if (newType.isAssignableFrom(oldType)) {
                    return false;
                }
            }
        }
        if (explicit) {
            this._explicitCreators |= mask;
        }
        AnnotatedWithParams[] annotatedWithParamsArr = this._creators;
        _fixAccess(newOne);
        annotatedWithParamsArr[typeIndex] = newOne;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean _isEnumValueOf(AnnotatedWithParams creator) {
        if (creator.getDeclaringClass().isEnum()) {
            if ("valueOf".equals(creator.getName())) {
                return true;
            }
        }
        return false;
    }
}
