package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.introspect.Annotated;

public class PropertyBuilder {
    private static final Object NO_DEFAULT_MARKER = Boolean.FALSE;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final BeanDescription _beanDesc;
    protected final SerializationConfig _config;
    protected Object _defaultBean;
    protected final Value _defaultInclusion;
    protected final boolean _useRealPropertyDefaults;

    /* renamed from: com.fasterxml.jackson.databind.ser.PropertyBuilder$1 */
    static /* synthetic */ class C68361 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include = new int[Include.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[Include.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public PropertyBuilder(SerializationConfig config, BeanDescription beanDesc) {
        this._config = config;
        this._beanDesc = beanDesc;
        Value inclPerType = Value.merge(beanDesc.findPropertyInclusion(Value.empty()), config.getDefaultPropertyInclusion(beanDesc.getBeanClass(), Value.empty()));
        this._defaultInclusion = Value.merge(config.getDefaultPropertyInclusion(), inclPerType);
        this._useRealPropertyDefaults = inclPerType.getValueInclusion() == Include.NON_DEFAULT;
        this._annotationIntrospector = this._config.getAnnotationIntrospector();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.ser.BeanPropertyWriter buildWriter(com.fasterxml.jackson.databind.SerializerProvider r27, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r28, com.fasterxml.jackson.databind.JavaType r29, com.fasterxml.jackson.databind.JsonSerializer<?> r30, com.fasterxml.jackson.databind.jsontype.TypeSerializer r31, com.fasterxml.jackson.databind.jsontype.TypeSerializer r32, com.fasterxml.jackson.databind.introspect.AnnotatedMember r33, boolean r34) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r14 = r28
            r15 = r29
            r0 = r32
            r13 = r33
            r3 = 0
            r4 = 0
            r12 = r34
            com.fasterxml.jackson.databind.JavaType r5 = r1.findSerializationType(r13, r12, r15)     // Catch:{ JsonMappingException -> 0x019b }
            if (r0 == 0) goto L_0x0049
            if (r5 != 0) goto L_0x001b
            r5 = r29
        L_0x001b:
            com.fasterxml.jackson.databind.JavaType r6 = r5.getContentType()
            if (r6 == 0) goto L_0x002b
            com.fasterxml.jackson.databind.JavaType r5 = r5.withContentTypeHandler(r0)
            r5.getContentType()
            r16 = r5
            goto L_0x004b
        L_0x002b:
            com.fasterxml.jackson.databind.BeanDescription r0 = r1._beanDesc
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "serialization type "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = " has no content"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r2.reportBadPropertyDefinition(r0, r14, r5, r3)
            throw r4
        L_0x0049:
            r16 = r5
        L_0x004b:
            r5 = 0
            r6 = 0
            if (r16 != 0) goto L_0x0051
            r7 = r15
            goto L_0x0053
        L_0x0051:
            r7 = r16
        L_0x0053:
            r17 = r7
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r18 = r28.getAccessor()
            if (r18 == 0) goto L_0x0191
            java.lang.Class r11 = r18.getRawType()
            com.fasterxml.jackson.databind.SerializationConfig r3 = r1._config
            java.lang.Class r7 = r17.getRawClass()
            com.fasterxml.jackson.annotation.JsonInclude$Value r8 = r1._defaultInclusion
            com.fasterxml.jackson.annotation.JsonInclude$Value r3 = r3.getDefaultInclusion(r7, r11, r8)
            com.fasterxml.jackson.annotation.JsonInclude$Value r7 = r28.findInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Value r19 = r3.withOverrides(r7)
            com.fasterxml.jackson.annotation.JsonInclude$Include r3 = r19.getValueInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Include r7 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS
            if (r3 != r7) goto L_0x0080
            com.fasterxml.jackson.annotation.JsonInclude$Include r3 = com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS
            r20 = r3
            goto L_0x0082
        L_0x0080:
            r20 = r3
        L_0x0082:
            int[] r3 = com.fasterxml.jackson.databind.ser.PropertyBuilder.C68361.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include
            int r7 = r20.ordinal()
            r3 = r3[r7]
            r7 = 1
            if (r3 == r7) goto L_0x00f0
            r4 = 2
            if (r3 == r4) goto L_0x00dd
            r4 = 3
            if (r3 == r4) goto L_0x00d4
            r4 = 4
            if (r3 == r4) goto L_0x00b9
            r4 = 5
            if (r3 == r4) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r6 = 1
        L_0x009b:
            boolean r3 = r17.isContainerType()
            if (r3 == 0) goto L_0x00b3
            com.fasterxml.jackson.databind.SerializationConfig r3 = r1._config
            com.fasterxml.jackson.databind.SerializationFeature r4 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS
            boolean r3 = r3.isEnabled(r4)
            if (r3 != 0) goto L_0x00b3
            java.lang.Object r3 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
            r22 = r3
            r21 = r6
            goto L_0x0142
        L_0x00b3:
            r22 = r5
            r21 = r6
            goto L_0x0142
        L_0x00b9:
            java.lang.Class r3 = r19.getValueFilter()
            java.lang.Object r3 = r2.includeFilterInstance(r14, r3)
            if (r3 != 0) goto L_0x00ca
            r4 = 1
            r22 = r3
            r21 = r4
            goto L_0x0142
        L_0x00ca:
            boolean r4 = r2.includeFilterSuppressNulls(r3)
            r22 = r3
            r21 = r4
            goto L_0x0142
        L_0x00d4:
            r3 = 1
            java.lang.Object r4 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
            r21 = r3
            r22 = r4
            goto L_0x0142
        L_0x00dd:
            r3 = 1
            boolean r4 = r17.isReferenceType()
            if (r4 == 0) goto L_0x00eb
            java.lang.Object r4 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
            r21 = r3
            r22 = r4
            goto L_0x0142
        L_0x00eb:
            r21 = r3
            r22 = r5
            goto L_0x0142
        L_0x00f0:
            boolean r3 = r1._useRealPropertyDefaults
            if (r3 == 0) goto L_0x011e
            java.lang.Object r3 = r26.getDefaultBean()
            r7 = r3
            if (r3 == 0) goto L_0x011e
            com.fasterxml.jackson.databind.MapperFeature r3 = com.fasterxml.jackson.databind.MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r3 = r2.isEnabled(r3)
            if (r3 == 0) goto L_0x010e
            com.fasterxml.jackson.databind.SerializationConfig r3 = r1._config
            com.fasterxml.jackson.databind.MapperFeature r8 = com.fasterxml.jackson.databind.MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r3 = r3.isEnabled(r8)
            r13.fixAccess(r3)
        L_0x010e:
            java.lang.Object r3 = r13.getValue(r7)     // Catch:{ Exception -> 0x0113 }
            goto L_0x0123
        L_0x0113:
            r0 = move-exception
            r2 = r0
            r0 = r2
            java.lang.String r2 = r28.getName()
            r1._throwWrapped(r0, r2, r7)
            throw r4
        L_0x011e:
            java.lang.Object r3 = com.fasterxml.jackson.databind.util.BeanUtil.getDefaultValue(r17)
            r6 = 1
        L_0x0123:
            if (r3 != 0) goto L_0x012b
            r4 = 1
            r22 = r3
            r21 = r4
            goto L_0x0142
        L_0x012b:
            java.lang.Class r4 = r3.getClass()
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L_0x013e
            java.lang.Object r3 = com.fasterxml.jackson.databind.util.ArrayBuilders.getArrayComparator(r3)
            r22 = r3
            r21 = r6
            goto L_0x0142
        L_0x013e:
            r22 = r3
            r21 = r6
        L_0x0142:
            java.lang.Class[] r3 = r28.findViews()
            if (r3 != 0) goto L_0x0151
            com.fasterxml.jackson.databind.BeanDescription r4 = r1._beanDesc
            java.lang.Class[] r3 = r4.findDefaultViews()
            r23 = r3
            goto L_0x0153
        L_0x0151:
            r23 = r3
        L_0x0153:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r24 = new com.fasterxml.jackson.databind.ser.BeanPropertyWriter
            com.fasterxml.jackson.databind.BeanDescription r3 = r1._beanDesc
            com.fasterxml.jackson.databind.util.Annotations r6 = r3.getClassAnnotations()
            r3 = r24
            r4 = r28
            r5 = r33
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r16
            r25 = r11
            r11 = r21
            r12 = r22
            r0 = r13
            r13 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.fasterxml.jackson.databind.AnnotationIntrospector r4 = r1._annotationIntrospector
            java.lang.Object r4 = r4.findNullSerializer(r0)
            if (r4 == 0) goto L_0x0184
            com.fasterxml.jackson.databind.JsonSerializer r5 = r2.serializerInstance(r0, r4)
            r3.assignNullSerializer(r5)
        L_0x0184:
            com.fasterxml.jackson.databind.AnnotationIntrospector r5 = r1._annotationIntrospector
            com.fasterxml.jackson.databind.util.NameTransformer r5 = r5.findUnwrappingNameTransformer(r0)
            if (r5 == 0) goto L_0x0190
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r3 = r3.unwrappingWriter(r5)
        L_0x0190:
            return r3
        L_0x0191:
            com.fasterxml.jackson.databind.BeanDescription r0 = r1._beanDesc
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r5 = "could not determine property type"
            r2.reportBadPropertyDefinition(r0, r14, r5, r3)
            throw r4
        L_0x019b:
            r0 = move-exception
            r5 = r0
            r0 = r5
            if (r14 != 0) goto L_0x01a8
            java.lang.String r0 = r0.getMessage()
            r2.reportBadDefinition(r15, r0)
            throw r4
        L_0x01a8:
            com.fasterxml.jackson.databind.BeanDescription r5 = r1._beanDesc
            java.lang.String r0 = r0.getMessage()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r2.reportBadPropertyDefinition(r5, r14, r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.PropertyBuilder.buildWriter(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.introspect.AnnotatedMember, boolean):com.fasterxml.jackson.databind.ser.BeanPropertyWriter");
    }

    /* access modifiers changed from: protected */
    public JavaType findSerializationType(Annotated a, boolean useStaticTyping, JavaType declaredType) throws JsonMappingException {
        JavaType secondary = this._annotationIntrospector.refineSerializationType(this._config, a, declaredType);
        if (secondary != declaredType) {
            Class<?> serClass = secondary.getRawClass();
            Class<?> rawDeclared = declaredType.getRawClass();
            if (!serClass.isAssignableFrom(rawDeclared) && !rawDeclared.isAssignableFrom(serClass)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal concrete-type annotation for method '");
                sb.append(a.getName());
                sb.append("': class ");
                sb.append(serClass.getName());
                sb.append(" not a super-type of (declared) class ");
                sb.append(rawDeclared.getName());
                throw new IllegalArgumentException(sb.toString());
            }
            useStaticTyping = true;
            declaredType = secondary;
        }
        Typing typing = this._annotationIntrospector.findSerializationTyping(a);
        if (!(typing == null || typing == Typing.DEFAULT_TYPING)) {
            useStaticTyping = typing == Typing.STATIC;
        }
        if (useStaticTyping) {
            return declaredType.withStaticTyping();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object getDefaultBean() {
        Object def = this._defaultBean;
        if (def == null) {
            def = this._beanDesc.instantiateBean(this._config.canOverrideAccessModifiers());
            if (def == null) {
                def = NO_DEFAULT_MARKER;
            }
            this._defaultBean = def;
        }
        if (def == NO_DEFAULT_MARKER) {
            return null;
        }
        return this._defaultBean;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Exception, code=java.lang.Throwable, for r5v0, types: [java.lang.Throwable, java.lang.Exception] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object _throwWrapped(java.lang.Throwable r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r0 = r5
        L_0x0001:
            java.lang.Throwable r1 = r0.getCause()
            if (r1 == 0) goto L_0x000c
            java.lang.Throwable r0 = r0.getCause()
            goto L_0x0001
        L_0x000c:
            com.fasterxml.jackson.databind.util.ClassUtil.throwIfError(r0)
            com.fasterxml.jackson.databind.util.ClassUtil.throwIfRTE(r0)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to get property '"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = "' of default "
            r2.append(r3)
            java.lang.Class r3 = r7.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = " instance"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            goto L_0x003f
        L_0x003e:
            throw r1
        L_0x003f:
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.PropertyBuilder._throwWrapped(java.lang.Exception, java.lang.String, java.lang.Object):java.lang.Object");
    }
}
