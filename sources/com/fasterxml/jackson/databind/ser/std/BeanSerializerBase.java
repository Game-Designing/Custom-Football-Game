package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BeanSerializerBase extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer, JsonFormatVisitable, SchemaAware {
    protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
    protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
    protected final AnyGetterWriter _anyGetterWriter;
    protected final JavaType _beanType;
    protected final BeanPropertyWriter[] _filteredProps;
    protected final ObjectIdWriter _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final BeanPropertyWriter[] _props;
    protected final Shape _serializationShape;
    protected final AnnotatedMember _typeId;

    /* renamed from: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase$1 */
    static /* synthetic */ class C68381 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape = new int[Shape.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[Shape.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[Shape.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[Shape.NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract BeanSerializerBase asArraySerializer();

    public abstract BeanSerializerBase withFilterId(Object obj);

    /* access modifiers changed from: protected */
    public abstract BeanSerializerBase withIgnorals(Set<String> set);

    public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter);

    protected BeanSerializerBase(JavaType type, BeanSerializerBuilder builder, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties) {
        super(type);
        this._beanType = type;
        this._props = properties;
        this._filteredProps = filteredProperties;
        Shape shape = null;
        if (builder == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = builder.getTypeId();
        this._anyGetterWriter = builder.getAnyGetter();
        this._propertyFilterId = builder.getFilterId();
        this._objectIdWriter = builder.getObjectIdWriter();
        Value format = builder.getBeanDescription().findExpectedFormat(null);
        if (format != null) {
            shape = format.getShape();
        }
        this._serializationShape = shape;
    }

    public BeanSerializerBase(BeanSerializerBase src, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties) {
        super(src._handledType);
        this._beanType = src._beanType;
        this._props = properties;
        this._filteredProps = filteredProperties;
        this._typeId = src._typeId;
        this._anyGetterWriter = src._anyGetterWriter;
        this._objectIdWriter = src._objectIdWriter;
        this._propertyFilterId = src._propertyFilterId;
        this._serializationShape = src._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase src, ObjectIdWriter objectIdWriter) {
        this(src, objectIdWriter, src._propertyFilterId);
    }

    protected BeanSerializerBase(BeanSerializerBase src, ObjectIdWriter objectIdWriter, Object filterId) {
        super(src._handledType);
        this._beanType = src._beanType;
        this._props = src._props;
        this._filteredProps = src._filteredProps;
        this._typeId = src._typeId;
        this._anyGetterWriter = src._anyGetterWriter;
        this._objectIdWriter = objectIdWriter;
        this._propertyFilterId = filterId;
        this._serializationShape = src._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase src, Set<String> toIgnore) {
        super(src._handledType);
        this._beanType = src._beanType;
        BeanPropertyWriter[] propsIn = src._props;
        BeanPropertyWriter[] fpropsIn = src._filteredProps;
        int len = propsIn.length;
        ArrayList<BeanPropertyWriter> propsOut = new ArrayList<>(len);
        BeanPropertyWriter[] beanPropertyWriterArr = null;
        ArrayList arrayList = fpropsIn == null ? null : new ArrayList(len);
        for (int i = 0; i < len; i++) {
            BeanPropertyWriter bpw = propsIn[i];
            if (toIgnore == null || !toIgnore.contains(bpw.getName())) {
                propsOut.add(bpw);
                if (fpropsIn != null) {
                    arrayList.add(fpropsIn[i]);
                }
            }
        }
        this._props = (BeanPropertyWriter[]) propsOut.toArray(new BeanPropertyWriter[propsOut.size()]);
        if (arrayList != null) {
            beanPropertyWriterArr = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        }
        this._filteredProps = beanPropertyWriterArr;
        this._typeId = src._typeId;
        this._anyGetterWriter = src._anyGetterWriter;
        this._objectIdWriter = src._objectIdWriter;
        this._propertyFilterId = src._propertyFilterId;
        this._serializationShape = src._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase src, NameTransformer unwrapper) {
        this(src, rename(src._props, unwrapper), rename(src._filteredProps, unwrapper));
    }

    private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] props, NameTransformer transformer) {
        if (props == null || props.length == 0 || transformer == null || transformer == NameTransformer.NOP) {
            return props;
        }
        int len = props.length;
        BeanPropertyWriter[] result = new BeanPropertyWriter[len];
        for (int i = 0; i < len; i++) {
            BeanPropertyWriter bpw = props[i];
            if (bpw != null) {
                result[i] = bpw.rename(transformer);
            }
        }
        return result;
    }

    public void resolve(SerializerProvider provider) throws JsonMappingException {
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        int filteredCount = beanPropertyWriterArr == null ? 0 : beanPropertyWriterArr.length;
        int len = this._props.length;
        for (int i = 0; i < len; i++) {
            BeanPropertyWriter prop = this._props[i];
            if (!prop.willSuppressNulls() && !prop.hasNullSerializer()) {
                JsonSerializer<Object> nullSer = provider.findNullValueSerializer(prop);
                if (nullSer != null) {
                    prop.assignNullSerializer(nullSer);
                    if (i < filteredCount) {
                        BeanPropertyWriter w2 = this._filteredProps[i];
                        if (w2 != null) {
                            w2.assignNullSerializer(nullSer);
                        }
                    }
                }
            }
            if (!prop.hasSerializer()) {
                JsonSerializer<Object> ser = findConvertingSerializer(provider, prop);
                if (ser == null) {
                    JavaType type = prop.getSerializationType();
                    if (type == null) {
                        type = prop.getType();
                        if (!type.isFinal()) {
                            if (type.isContainerType() || type.containedTypeCount() > 0) {
                                prop.setNonTrivialBaseType(type);
                            }
                        }
                    }
                    ser = provider.findValueSerializer(type, (BeanProperty) prop);
                    if (type.isContainerType()) {
                        TypeSerializer typeSer = (TypeSerializer) type.getContentType().getTypeHandler();
                        if (typeSer != null && (ser instanceof ContainerSerializer)) {
                            ser = ((ContainerSerializer) ser).withValueTypeSerializer(typeSer);
                        }
                    }
                }
                if (i < filteredCount) {
                    BeanPropertyWriter w22 = this._filteredProps[i];
                    if (w22 != null) {
                        w22.assignSerializer(ser);
                    }
                }
                prop.assignSerializer(ser);
            }
        }
        AnyGetterWriter anyGetterWriter = this._anyGetterWriter;
        if (anyGetterWriter != null) {
            anyGetterWriter.resolve(provider);
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> findConvertingSerializer(SerializerProvider provider, BeanPropertyWriter prop) throws JsonMappingException {
        AnnotationIntrospector intr = provider.getAnnotationIntrospector();
        JsonSerializer<?> ser = null;
        if (intr != null) {
            AnnotatedMember m = prop.getMember();
            if (m != null) {
                Object convDef = intr.findSerializationConverter(m);
                if (convDef != null) {
                    Converter<Object, Object> conv = provider.converterInstance(prop.getMember(), convDef);
                    JavaType delegateType = conv.getOutputType(provider.getTypeFactory());
                    if (!delegateType.isJavaLangObject()) {
                        ser = provider.findValueSerializer(delegateType, (BeanProperty) prop);
                    }
                    return new StdDelegatingSerializer(conv, delegateType, ser);
                }
            }
        }
        return null;
    }

    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property) throws JsonMappingException {
        Shape shape;
        Object newFilterId;
        Set set;
        SerializerProvider serializerProvider = provider;
        BeanProperty beanProperty = property;
        AnnotationIntrospector intr = provider.getAnnotationIntrospector();
        Annotated member = (beanProperty == null || intr == null) ? null : property.getMember();
        SerializationConfig config = provider.getConfig();
        Value format = findFormatOverrides(serializerProvider, beanProperty, handledType());
        if (format == null || !format.hasShape()) {
            shape = null;
        } else {
            shape = format.getShape();
            if (!(shape == Shape.ANY || shape == this._serializationShape)) {
                if (this._handledType.isEnum()) {
                    int i = C68381.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[shape.ordinal()];
                    if (i == 1 || i == 2 || i == 3) {
                        return serializerProvider.handlePrimaryContextualization(EnumSerializer.construct(this._beanType.getRawClass(), provider.getConfig(), config.introspectClassAnnotations(this._beanType), format), beanProperty);
                    }
                } else if (shape == Shape.NATURAL && ((!this._beanType.isMapLikeType() || !Map.class.isAssignableFrom(this._handledType)) && Entry.class.isAssignableFrom(this._handledType))) {
                    JavaType mapEntryType = this._beanType.findSuperType(Entry.class);
                    MapEntrySerializer mapEntrySerializer = new MapEntrySerializer(this._beanType, mapEntryType.containedTypeOrUnknown(0), mapEntryType.containedTypeOrUnknown(1), false, null, property);
                    return serializerProvider.handlePrimaryContextualization(mapEntrySerializer, beanProperty);
                }
            }
        }
        ObjectIdWriter oiw = this._objectIdWriter;
        Set set2 = null;
        Object newFilterId2 = null;
        if (member != null) {
            JsonIgnoreProperties.Value ignorals = intr.findPropertyIgnorals(member);
            if (ignorals != null) {
                set2 = ignorals.findIgnoredForSerialization();
            }
            ObjectIdInfo objectIdInfo = intr.findObjectIdInfo(member);
            if (objectIdInfo != null) {
                ObjectIdInfo objectIdInfo2 = intr.findObjectReferenceInfo(member, objectIdInfo);
                Class<?> implClass = objectIdInfo2.getGeneratorType();
                JavaType type = serializerProvider.constructType(implClass);
                ObjectIdWriter objectIdWriter = oiw;
                JavaType idType = provider.getTypeFactory().findTypeParameters(type, ObjectIdGenerator.class)[0];
                if (implClass == ObjectIdGenerators$PropertyGenerator.class) {
                    String propName = objectIdInfo2.getPropertyName().getSimpleName();
                    Class cls = implClass;
                    int len = this._props.length;
                    JavaType javaType = type;
                    int i2 = 0;
                    while (i2 != len) {
                        int len2 = len;
                        BeanPropertyWriter prop = this._props[i2];
                        set = set2;
                        if (propName.equals(prop.getName())) {
                            BeanPropertyWriter idProp = prop;
                            if (i2 > 0) {
                                BeanPropertyWriter beanPropertyWriter = prop;
                                BeanPropertyWriter[] beanPropertyWriterArr = this._props;
                                newFilterId = null;
                                SerializationConfig serializationConfig = config;
                                System.arraycopy(beanPropertyWriterArr, 0, beanPropertyWriterArr, 1, i2);
                                this._props[0] = idProp;
                                BeanPropertyWriter[] beanPropertyWriterArr2 = this._filteredProps;
                                if (beanPropertyWriterArr2 != null) {
                                    BeanPropertyWriter fp = beanPropertyWriterArr2[i2];
                                    System.arraycopy(beanPropertyWriterArr2, 0, beanPropertyWriterArr2, 1, i2);
                                    this._filteredProps[0] = fp;
                                }
                            } else {
                                newFilterId = null;
                                SerializationConfig serializationConfig2 = config;
                            }
                            oiw = ObjectIdWriter.construct(idProp.getType(), null, new PropertyBasedObjectIdGenerator<>(objectIdInfo2, idProp), objectIdInfo2.getAlwaysAsId());
                        } else {
                            BeanPropertyWriter beanPropertyWriter2 = prop;
                            SerializationConfig serializationConfig3 = config;
                            i2++;
                            len = len2;
                            set2 = set;
                        }
                    }
                    serializerProvider.reportBadDefinition(this._beanType, String.format("Invalid Object Id definition for %s: cannot find property with name '%s'", new Object[]{handledType().getName(), propName}));
                    throw null;
                }
                Class cls2 = implClass;
                JavaType javaType2 = type;
                set = set2;
                newFilterId = null;
                SerializationConfig serializationConfig4 = config;
                oiw = ObjectIdWriter.construct(idType, objectIdInfo2.getPropertyName(), serializerProvider.objectIdGeneratorInstance(member, objectIdInfo2), objectIdInfo2.getAlwaysAsId());
            } else if (oiw != null) {
                ObjectIdInfo objectIdInfo3 = intr.findObjectReferenceInfo(member, null);
                if (objectIdInfo3 != null) {
                    oiw = this._objectIdWriter.withAlwaysAsId(objectIdInfo3.getAlwaysAsId());
                    set = set2;
                    newFilterId = null;
                    SerializationConfig serializationConfig5 = config;
                } else {
                    set = set2;
                    newFilterId = null;
                    SerializationConfig serializationConfig6 = config;
                }
            } else {
                set = set2;
                newFilterId = null;
                SerializationConfig serializationConfig7 = config;
            }
            Object filterId = intr.findFilterId(member);
            if (filterId != null) {
                Object obj = this._propertyFilterId;
                if (obj == null || !filterId.equals(obj)) {
                    newFilterId2 = filterId;
                    set2 = set;
                }
            }
            set2 = set;
            newFilterId2 = newFilterId;
        } else {
            ObjectIdWriter objectIdWriter2 = oiw;
            SerializationConfig serializationConfig8 = config;
        }
        BeanSerializerBase contextual = this;
        if (oiw != null) {
            ObjectIdWriter oiw2 = oiw.withSerializer(serializerProvider.findValueSerializer(oiw.idType, beanProperty));
            if (oiw2 != this._objectIdWriter) {
                contextual = contextual.withObjectIdWriter(oiw2);
            }
        }
        if (set2 != null && !set2.isEmpty()) {
            contextual = contextual.withIgnorals(set2);
        }
        if (newFilterId2 != null) {
            contextual = contextual.withFilterId(newFilterId2);
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        if (shape == Shape.ARRAY) {
            return contextual.asArraySerializer();
        }
        return contextual;
    }

    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    public void serializeWithType(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        if (this._objectIdWriter != null) {
            gen.setCurrentValue(bean);
            _serializeWithObjectId(bean, gen, provider, typeSer);
            return;
        }
        gen.setCurrentValue(bean);
        WritableTypeId typeIdDef = _typeIdDef(typeSer, bean, JsonToken.START_OBJECT);
        typeSer.writeTypePrefix(gen, typeIdDef);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(bean, gen, provider);
        } else {
            serializeFields(bean, gen, provider);
        }
        typeSer.writeTypeSuffix(gen, typeIdDef);
    }

    /* access modifiers changed from: protected */
    public final void _serializeWithObjectId(Object bean, JsonGenerator gen, SerializerProvider provider, boolean startEndObject) throws IOException {
        ObjectIdWriter w = this._objectIdWriter;
        WritableObjectId objectId = provider.findObjectId(bean, w.generator);
        if (!objectId.writeAsId(gen, provider, w)) {
            Object id = objectId.generateId(bean);
            if (w.alwaysAsId) {
                w.serializer.serialize(id, gen, provider);
                return;
            }
            if (startEndObject) {
                gen.writeStartObject(bean);
            }
            objectId.writeAsField(gen, provider, w);
            if (this._propertyFilterId != null) {
                serializeFieldsFiltered(bean, gen, provider);
            } else {
                serializeFields(bean, gen, provider);
            }
            if (startEndObject) {
                gen.writeEndObject();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void _serializeWithObjectId(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        ObjectIdWriter w = this._objectIdWriter;
        WritableObjectId objectId = provider.findObjectId(bean, w.generator);
        if (!objectId.writeAsId(gen, provider, w)) {
            Object id = objectId.generateId(bean);
            if (w.alwaysAsId) {
                w.serializer.serialize(id, gen, provider);
            } else {
                _serializeObjectId(bean, gen, provider, typeSer, objectId);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _serializeObjectId(Object bean, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer, WritableObjectId objectId) throws IOException {
        ObjectIdWriter w = this._objectIdWriter;
        WritableTypeId typeIdDef = _typeIdDef(typeSer, bean, JsonToken.START_OBJECT);
        typeSer.writeTypePrefix(g, typeIdDef);
        objectId.writeAsField(g, provider, w);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(bean, g, provider);
        } else {
            serializeFields(bean, g, provider);
        }
        typeSer.writeTypeSuffix(g, typeIdDef);
    }

    /* access modifiers changed from: protected */
    public final WritableTypeId _typeIdDef(TypeSerializer typeSer, Object bean, JsonToken valueShape) {
        AnnotatedMember annotatedMember = this._typeId;
        if (annotatedMember == null) {
            return typeSer.typeId(bean, valueShape);
        }
        Object typeId = annotatedMember.getValue(bean);
        if (typeId == null) {
            typeId = "";
        }
        return typeSer.typeId(bean, valueShape, typeId);
    }

    /* JADX INFO: used method not loaded: com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(com.fasterxml.jackson.databind.SerializerProvider, java.lang.Throwable, java.lang.Object, java.lang.String):null, types can be incorrect */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        r0 = r1[r2].getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (r2 != r1.length) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        r0 = r1[r2].getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0055, code lost:
        wrapAndThrow(r9, (java.lang.Throwable) r8, r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
        throw null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004a A[ExcHandler: Exception (r8v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), PHI: r2 
      PHI: (r2v1 'i' int) = (r2v0 'i' int), (r2v4 'i' int), (r2v4 'i' int), (r2v4 'i' int), (r2v4 'i' int), (r2v4 'i' int), (r2v4 'i' int) binds: [B:7:0x0012, B:16:0x0022, B:17:?, B:19:0x0026, B:20:?, B:12:0x0019, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void serializeFields(java.lang.Object r7, com.fasterxml.jackson.core.JsonGenerator r8, com.fasterxml.jackson.databind.SerializerProvider r9) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "[anySetter]"
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r1 = r6._filteredProps
            if (r1 == 0) goto L_0x000f
            java.lang.Class r1 = r9.getActiveView()
            if (r1 == 0) goto L_0x000f
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r1 = r6._filteredProps
            goto L_0x0011
        L_0x000f:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r1 = r6._props
        L_0x0011:
            r2 = 0
            int r3 = r1.length     // Catch:{ Exception -> 0x004a, StackOverflowError -> 0x002f }
        L_0x0013:
            if (r2 >= r3) goto L_0x0022
            r4 = r1[r2]     // Catch:{ Exception -> 0x004a, StackOverflowError -> 0x002f }
            if (r4 == 0) goto L_0x001f
            r4.serializeAsField(r7, r8, r9)     // Catch:{ Exception -> 0x004a, StackOverflowError -> 0x001d }
            goto L_0x001f
        L_0x001d:
            r3 = move-exception
            goto L_0x0030
        L_0x001f:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0022:
            com.fasterxml.jackson.databind.ser.AnyGetterWriter r3 = r6._anyGetterWriter     // Catch:{ Exception -> 0x004a, StackOverflowError -> 0x002d }
            if (r3 == 0) goto L_0x002b
            com.fasterxml.jackson.databind.ser.AnyGetterWriter r3 = r6._anyGetterWriter     // Catch:{ Exception -> 0x004a, StackOverflowError -> 0x002f }
            r3.getAndSerialize(r7, r8, r9)     // Catch:{ Exception -> 0x004a, StackOverflowError -> 0x002f }
        L_0x002b:
            return
        L_0x002d:
            r3 = move-exception
            goto L_0x0030
        L_0x002f:
            r3 = move-exception
        L_0x0030:
            com.fasterxml.jackson.databind.JsonMappingException r4 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.String r5 = "Infinite recursion (StackOverflowError)"
            r4.<init>(r8, r5, r3)
            int r5 = r1.length
            if (r2 != r5) goto L_0x003b
            goto L_0x0041
        L_0x003b:
            r0 = r1[r2]
            java.lang.String r0 = r0.getName()
        L_0x0041:
            com.fasterxml.jackson.databind.JsonMappingException$Reference r5 = new com.fasterxml.jackson.databind.JsonMappingException$Reference
            r5.<init>(r7, r0)
            r4.prependPath(r5)
            throw r4
        L_0x004a:
            r8 = move-exception
            int r3 = r1.length
            if (r2 != r3) goto L_0x004f
            goto L_0x0055
        L_0x004f:
            r0 = r1[r2]
            java.lang.String r0 = r0.getName()
        L_0x0055:
            r6.wrapAndThrow(r9, r8, r7, r0)
            r7 = 0
            goto L_0x005b
        L_0x005a:
            throw r7
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
    }

    /* JADX INFO: used method not loaded: com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(com.fasterxml.jackson.databind.SerializerProvider, java.lang.Throwable, java.lang.Object, java.lang.String):null, types can be incorrect */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0047, code lost:
        r0 = r1[r3].getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0056, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0058, code lost:
        if (r3 != r1.length) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
        r0 = r1[r3].getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0061, code lost:
        wrapAndThrow(r10, (java.lang.Throwable) r9, r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0066, code lost:
        throw null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0056 A[ExcHandler: Exception (r9v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), PHI: r3 
      PHI: (r3v1 'i' int) = (r3v0 'i' int), (r3v4 'i' int), (r3v4 'i' int), (r3v4 'i' int), (r3v4 'i' int), (r3v4 'i' int), (r3v4 'i' int) binds: [B:11:0x001e, B:20:0x002e, B:21:?, B:23:0x0032, B:24:?, B:16:0x0025, B:17:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void serializeFieldsFiltered(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r7 = this;
            java.lang.String r0 = "[anySetter]"
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r1 = r7._filteredProps
            if (r1 == 0) goto L_0x000f
            java.lang.Class r1 = r10.getActiveView()
            if (r1 == 0) goto L_0x000f
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r1 = r7._filteredProps
            goto L_0x0011
        L_0x000f:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r1 = r7._props
        L_0x0011:
            java.lang.Object r2 = r7._propertyFilterId
            com.fasterxml.jackson.databind.ser.PropertyFilter r2 = r7.findPropertyFilter(r10, r2, r8)
            if (r2 != 0) goto L_0x001d
            r7.serializeFields(r8, r9, r10)
            return
        L_0x001d:
            r3 = 0
            int r4 = r1.length     // Catch:{ Exception -> 0x0056, StackOverflowError -> 0x003b }
        L_0x001f:
            if (r3 >= r4) goto L_0x002e
            r5 = r1[r3]     // Catch:{ Exception -> 0x0056, StackOverflowError -> 0x003b }
            if (r5 == 0) goto L_0x002b
            r2.serializeAsField(r8, r9, r10, r5)     // Catch:{ Exception -> 0x0056, StackOverflowError -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            r4 = move-exception
            goto L_0x003c
        L_0x002b:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x002e:
            com.fasterxml.jackson.databind.ser.AnyGetterWriter r4 = r7._anyGetterWriter     // Catch:{ Exception -> 0x0056, StackOverflowError -> 0x0039 }
            if (r4 == 0) goto L_0x0037
            com.fasterxml.jackson.databind.ser.AnyGetterWriter r4 = r7._anyGetterWriter     // Catch:{ Exception -> 0x0056, StackOverflowError -> 0x003b }
            r4.getAndFilter(r8, r9, r10, r2)     // Catch:{ Exception -> 0x0056, StackOverflowError -> 0x003b }
        L_0x0037:
            return
        L_0x0039:
            r4 = move-exception
            goto L_0x003c
        L_0x003b:
            r4 = move-exception
        L_0x003c:
            com.fasterxml.jackson.databind.JsonMappingException r5 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.String r6 = "Infinite recursion (StackOverflowError)"
            r5.<init>(r9, r6, r4)
            int r6 = r1.length
            if (r3 != r6) goto L_0x0047
            goto L_0x004d
        L_0x0047:
            r0 = r1[r3]
            java.lang.String r0 = r0.getName()
        L_0x004d:
            com.fasterxml.jackson.databind.JsonMappingException$Reference r6 = new com.fasterxml.jackson.databind.JsonMappingException$Reference
            r6.<init>(r8, r0)
            r5.prependPath(r6)
            throw r5
        L_0x0056:
            r9 = move-exception
            int r2 = r1.length
            if (r3 != r2) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            r0 = r1[r3]
            java.lang.String r0 = r0.getName()
        L_0x0061:
            r7.wrapAndThrow(r10, r9, r8, r0)
            r8 = 0
            goto L_0x0067
        L_0x0066:
            throw r8
        L_0x0067:
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFieldsFiltered(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
    }
}
