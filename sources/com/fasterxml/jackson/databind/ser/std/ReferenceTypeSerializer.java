package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;

public abstract class ReferenceTypeSerializer<T> extends StdSerializer<T> implements ContextualSerializer {
    public static final Object MARKER_FOR_EMPTY = Include.NON_EMPTY;
    protected transient PropertySerializerMap _dynamicSerializers;
    protected final BeanProperty _property;
    protected final JavaType _referredType;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected final NameTransformer _unwrapper;
    protected final JsonSerializer<Object> _valueSerializer;
    protected final TypeSerializer _valueTypeSerializer;

    /* renamed from: com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer$1 */
    static /* synthetic */ class C68411 {
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

    /* access modifiers changed from: protected */
    public abstract Object _getReferenced(T t);

    /* access modifiers changed from: protected */
    public abstract Object _getReferencedIfPresent(T t);

    /* access modifiers changed from: protected */
    public abstract boolean _isValuePresent(T t);

    public abstract ReferenceTypeSerializer<T> withContentInclusion(Object obj, boolean z);

    /* access modifiers changed from: protected */
    public abstract ReferenceTypeSerializer<T> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer nameTransformer);

    public ReferenceTypeSerializer(ReferenceType fullType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> ser) {
        super((JavaType) fullType);
        this._referredType = fullType.getReferencedType();
        this._property = null;
        this._valueTypeSerializer = vts;
        this._valueSerializer = ser;
        this._unwrapper = null;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
    }

    protected ReferenceTypeSerializer(ReferenceTypeSerializer<?> base, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSer, NameTransformer unwrapper, Object suppressableValue, boolean suppressNulls) {
        super((StdSerializer<?>) base);
        this._referredType = base._referredType;
        this._dynamicSerializers = base._dynamicSerializers;
        this._property = property;
        this._valueTypeSerializer = vts;
        this._valueSerializer = valueSer;
        this._unwrapper = unwrapper;
        this._suppressableValue = suppressableValue;
        this._suppressNulls = suppressNulls;
    }

    public JsonSerializer<T> unwrappingSerializer(NameTransformer transformer) {
        JsonSerializer<Object> valueSer = this._valueSerializer;
        if (valueSer != null) {
            valueSer = valueSer.unwrappingSerializer(transformer);
        }
        NameTransformer nameTransformer = this._unwrapper;
        NameTransformer unwrapper = nameTransformer == null ? transformer : NameTransformer.chainedTransformer(transformer, nameTransformer);
        if (this._valueSerializer == valueSer && this._unwrapper == unwrapper) {
            return this;
        }
        return withResolved(this._property, this._valueTypeSerializer, valueSer, unwrapper);
    }

    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property) throws JsonMappingException {
        ReferenceTypeSerializer referenceTypeSerializer;
        boolean suppressNulls;
        Object valueToSuppress;
        TypeSerializer typeSer = this._valueTypeSerializer;
        if (typeSer != null) {
            typeSer = typeSer.forProperty(property);
        }
        JsonSerializer<Object> findAnnotatedContentSerializer = findAnnotatedContentSerializer(provider, property);
        if (findAnnotatedContentSerializer == null) {
            findAnnotatedContentSerializer = this._valueSerializer;
            if (findAnnotatedContentSerializer != null) {
                findAnnotatedContentSerializer = provider.handlePrimaryContextualization(findAnnotatedContentSerializer, property);
            } else if (_useStatic(provider, property, this._referredType)) {
                findAnnotatedContentSerializer = _findSerializer(provider, this._referredType, property);
            }
        }
        if (this._property == property && this._valueTypeSerializer == typeSer && this._valueSerializer == findAnnotatedContentSerializer) {
            referenceTypeSerializer = this;
        } else {
            referenceTypeSerializer = withResolved(property, typeSer, findAnnotatedContentSerializer, this._unwrapper);
        }
        if (property == null) {
            return referenceTypeSerializer;
        }
        Value inclV = property.findPropertyInclusion(provider.getConfig(), handledType());
        if (inclV == null) {
            return referenceTypeSerializer;
        }
        Include incl = inclV.getContentInclusion();
        if (incl == Include.USE_DEFAULTS) {
            return referenceTypeSerializer;
        }
        int i = C68411.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[incl.ordinal()];
        if (i != 1) {
            Object obj = null;
            if (i == 2) {
                if (this._referredType.isReferenceType()) {
                    obj = MARKER_FOR_EMPTY;
                }
                suppressNulls = true;
                valueToSuppress = obj;
            } else if (i == 3) {
                suppressNulls = true;
                valueToSuppress = MARKER_FOR_EMPTY;
            } else if (i == 4) {
                Object valueToSuppress2 = provider.includeFilterInstance(null, inclV.getContentFilter());
                if (valueToSuppress2 == null) {
                    Object obj2 = valueToSuppress2;
                    suppressNulls = true;
                    valueToSuppress = obj2;
                } else {
                    Object obj3 = valueToSuppress2;
                    suppressNulls = provider.includeFilterSuppressNulls(valueToSuppress2);
                    valueToSuppress = obj3;
                }
            } else if (i != 5) {
                valueToSuppress = null;
                suppressNulls = false;
            } else {
                valueToSuppress = null;
                suppressNulls = true;
            }
        } else {
            valueToSuppress = BeanUtil.getDefaultValue(this._referredType);
            suppressNulls = true;
            if (valueToSuppress != null && valueToSuppress.getClass().isArray()) {
                valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
            }
        }
        if (this._suppressableValue == valueToSuppress && this._suppressNulls == suppressNulls) {
            return referenceTypeSerializer;
        }
        return referenceTypeSerializer.withContentInclusion(valueToSuppress, suppressNulls);
    }

    /* access modifiers changed from: protected */
    public boolean _useStatic(SerializerProvider provider, BeanProperty property, JavaType referredType) {
        if (referredType.isJavaLangObject()) {
            return false;
        }
        if (referredType.isFinal() || referredType.useStaticType()) {
            return true;
        }
        AnnotationIntrospector intr = provider.getAnnotationIntrospector();
        if (!(intr == null || property == null || property.getMember() == null)) {
            Typing t = intr.findSerializationTyping(property.getMember());
            if (t == Typing.STATIC) {
                return true;
            }
            if (t == Typing.DYNAMIC) {
                return false;
            }
        }
        return provider.isEnabled(MapperFeature.USE_STATIC_TYPING);
    }

    public boolean isEmpty(SerializerProvider provider, T value) {
        if (!_isValuePresent(value)) {
            return true;
        }
        Object contents = _getReferenced(value);
        if (contents == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        JsonSerializer<Object> ser = this._valueSerializer;
        if (ser == null) {
            try {
                ser = _findCachedSerializer(provider, contents.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        Object obj = this._suppressableValue;
        if (obj == MARKER_FOR_EMPTY) {
            return ser.isEmpty(provider, contents);
        }
        return obj.equals(contents);
    }

    public boolean isUnwrappingSerializer() {
        return this._unwrapper != null;
    }

    public void serialize(T ref, JsonGenerator g, SerializerProvider provider) throws IOException {
        Object value = _getReferencedIfPresent(ref);
        if (value == null) {
            if (this._unwrapper == null) {
                provider.defaultSerializeNull(g);
            }
            return;
        }
        JsonSerializer<Object> ser = this._valueSerializer;
        if (ser == null) {
            ser = _findCachedSerializer(provider, value.getClass());
        }
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        if (typeSerializer != null) {
            ser.serializeWithType(value, g, provider, typeSerializer);
        } else {
            ser.serialize(value, g, provider);
        }
    }

    public void serializeWithType(T ref, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        Object value = _getReferencedIfPresent(ref);
        if (value == null) {
            if (this._unwrapper == null) {
                provider.defaultSerializeNull(g);
            }
            return;
        }
        JsonSerializer<Object> ser = this._valueSerializer;
        if (ser == null) {
            ser = _findCachedSerializer(provider, value.getClass());
        }
        ser.serializeWithType(value, g, provider, typeSer);
    }

    private final JsonSerializer<Object> _findCachedSerializer(SerializerProvider provider, Class<?> rawType) throws JsonMappingException {
        JsonSerializer<Object> ser = this._dynamicSerializers.serializerFor(rawType);
        if (ser == null) {
            if (this._referredType.hasGenericTypes()) {
                ser = provider.findValueSerializer(provider.constructSpecializedType(this._referredType, rawType), this._property);
            } else {
                ser = provider.findValueSerializer(rawType, this._property);
            }
            NameTransformer nameTransformer = this._unwrapper;
            if (nameTransformer != null) {
                ser = ser.unwrappingSerializer(nameTransformer);
            }
            this._dynamicSerializers = this._dynamicSerializers.newWith(rawType, ser);
        }
        return ser;
    }

    private final JsonSerializer<Object> _findSerializer(SerializerProvider provider, JavaType type, BeanProperty prop) throws JsonMappingException {
        return provider.findValueSerializer(type, prop);
    }
}
