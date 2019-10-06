package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.util.EnumMap;

public class EnumMapDeserializer extends ContainerDeserializerBase<EnumMap<?, ?>> implements ContextualDeserializer, ResolvableDeserializer {
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected final Class<?> _enumClass;
    protected KeyDeserializer _keyDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public EnumMapDeserializer(JavaType mapType, ValueInstantiator valueInst, KeyDeserializer keyDeser, JsonDeserializer<?> valueDeser, TypeDeserializer vtd, NullValueProvider nuller) {
        super(mapType, nuller, (Boolean) null);
        this._enumClass = mapType.getKeyType().getRawClass();
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = vtd;
        this._valueInstantiator = valueInst;
    }

    protected EnumMapDeserializer(EnumMapDeserializer base, KeyDeserializer keyDeser, JsonDeserializer<?> valueDeser, TypeDeserializer vtd, NullValueProvider nuller) {
        super((ContainerDeserializerBase<?>) base, nuller, base._unwrapSingle);
        this._enumClass = base._enumClass;
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = vtd;
        this._valueInstantiator = base._valueInstantiator;
        this._delegateDeserializer = base._delegateDeserializer;
        this._propertyBasedCreator = base._propertyBasedCreator;
    }

    public EnumMapDeserializer withResolved(KeyDeserializer keyDeserializer, JsonDeserializer<?> valueDeserializer, TypeDeserializer valueTypeDeser, NullValueProvider nuller) {
        if (keyDeserializer == this._keyDeserializer && nuller == this._nullProvider && valueDeserializer == this._valueDeserializer && valueTypeDeser == this._valueTypeDeserializer) {
            return this;
        }
        EnumMapDeserializer enumMapDeserializer = new EnumMapDeserializer(this, keyDeserializer, valueDeserializer, valueTypeDeser, nuller);
        return enumMapDeserializer;
    }

    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator == null) {
            return;
        }
        if (valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(ctxt.getConfig());
            if (delegateType != null) {
                this._delegateDeserializer = findDeserializer(ctxt, delegateType, null);
                return;
            }
            JavaType javaType = this._containerType;
            ctxt.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{javaType, this._valueInstantiator.getClass().getName()}));
            throw null;
        } else if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType delegateType2 = this._valueInstantiator.getArrayDelegateType(ctxt.getConfig());
            if (delegateType2 != null) {
                this._delegateDeserializer = findDeserializer(ctxt, delegateType2, null);
                return;
            }
            JavaType javaType2 = this._containerType;
            ctxt.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{javaType2, this._valueInstantiator.getClass().getName()}));
            throw null;
        } else if (this._valueInstantiator.canCreateFromObjectWith()) {
            this._propertyBasedCreator = PropertyBasedCreator.construct(ctxt, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(ctxt.getConfig()), ctxt.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> valueDeser;
        KeyDeserializer keyDeser = this._keyDeserializer;
        if (keyDeser == null) {
            keyDeser = ctxt.findKeyDeserializer(this._containerType.getKeyType(), property);
        }
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        JavaType vt = this._containerType.getContentType();
        if (jsonDeserializer == null) {
            valueDeser = ctxt.findContextualValueDeserializer(vt, property);
        } else {
            valueDeser = ctxt.handleSecondaryContextualization(jsonDeserializer, property, vt);
        }
        TypeDeserializer vtd = this._valueTypeDeserializer;
        if (vtd != null) {
            vtd = vtd.forProperty(property);
        }
        return withResolved(keyDeser, valueDeser, vtd, findContentNullProvider(ctxt, property, valueDeser));
    }

    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null;
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return constructMap(ctxt);
    }

    public EnumMap<?, ?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingProperties(p, ctxt);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return (EnumMap) this._valueInstantiator.createUsingDelegate(ctxt, jsonDeserializer.deserialize(p, ctxt));
        }
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT || t == JsonToken.FIELD_NAME || t == JsonToken.END_OBJECT) {
            return deserialize(p, ctxt, constructMap(ctxt));
        }
        if (t == JsonToken.VALUE_STRING) {
            return (EnumMap) this._valueInstantiator.createFromString(ctxt, p.getText());
        }
        return (EnumMap) _deserializeFromEmpty(p, ctxt);
    }

    public EnumMap<?, ?> deserialize(JsonParser p, DeserializationContext ctxt, EnumMap result) throws IOException {
        Object value;
        p.setCurrentValue(result);
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        while (true) {
            String nextFieldName = p.nextFieldName();
            String keyName = nextFieldName;
            if (nextFieldName == null) {
                return result;
            }
            Enum<?> key = (Enum) this._keyDeserializer.deserializeKey(keyName, ctxt);
            if (key != null) {
                try {
                    if (p.nextToken() == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            value = this._nullProvider.getNullValue(ctxt);
                        }
                    } else if (typeDeser == null) {
                        value = valueDes.deserialize(p, ctxt);
                    } else {
                        value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                    }
                    result.put(key, value);
                } catch (Exception e) {
                    wrapAndThrow(e, result, keyName);
                    throw null;
                }
            } else if (!ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return (EnumMap) ctxt.handleWeirdStringValue(this._enumClass, keyName, "value not one of declared Enum instance names for %s", this._containerType.getKeyType());
            } else {
                p.nextToken();
                p.skipChildren();
            }
        }
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }

    /* access modifiers changed from: protected */
    public EnumMap<?, ?> constructMap(DeserializationContext ctxt) throws JsonMappingException {
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator == null) {
            return new EnumMap<>(this._enumClass);
        }
        try {
            if (valueInstantiator.canCreateUsingDefault()) {
                return (EnumMap) this._valueInstantiator.createUsingDefault(ctxt);
            }
            return (EnumMap) ctxt.handleMissingInstantiator(handledType(), getValueInstantiator(), null, "no default constructor found", new Object[0]);
        } catch (IOException e) {
            ClassUtil.throwAsMappingException(ctxt, e);
            throw null;
        }
    }

    public EnumMap<?, ?> _deserializeUsingProperties(JsonParser p, DeserializationContext ctxt) throws IOException {
        String keyName;
        Object value;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, null);
        if (p.isExpectedStartObjectToken()) {
            keyName = p.nextFieldName();
        } else if (p.hasToken(JsonToken.FIELD_NAME)) {
            keyName = p.getCurrentName();
        } else {
            keyName = null;
        }
        while (keyName != null) {
            JsonToken t = p.nextToken();
            SettableBeanProperty prop = creator.findCreatorProperty(keyName);
            if (prop == null) {
                Enum<?> key = (Enum) this._keyDeserializer.deserializeKey(keyName, ctxt);
                if (key != null) {
                    try {
                        if (t == JsonToken.VALUE_NULL) {
                            if (!this._skipNullValues) {
                                value = this._nullProvider.getNullValue(ctxt);
                            }
                        } else if (this._valueTypeDeserializer == null) {
                            value = this._valueDeserializer.deserialize(p, ctxt);
                        } else {
                            value = this._valueDeserializer.deserializeWithType(p, ctxt, this._valueTypeDeserializer);
                        }
                        buffer.bufferMapProperty(key, value);
                    } catch (Exception e) {
                        wrapAndThrow(e, this._containerType.getRawClass(), keyName);
                        throw null;
                    }
                } else if (!ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    return (EnumMap) ctxt.handleWeirdStringValue(this._enumClass, keyName, "value not one of declared Enum instance names for %s", this._containerType.getKeyType());
                } else {
                    p.nextToken();
                    p.skipChildren();
                }
            } else if (buffer.assignParameter(prop, prop.deserialize(p, ctxt))) {
                try {
                    return deserialize(p, ctxt, (EnumMap) creator.build(ctxt, buffer));
                } catch (Exception e2) {
                    wrapAndThrow(e2, this._containerType.getRawClass(), keyName);
                    throw null;
                }
            }
            keyName = p.nextFieldName();
        }
        try {
            return (EnumMap) creator.build(ctxt, buffer);
        } catch (Exception e3) {
            wrapAndThrow(e3, this._containerType.getRawClass(), keyName);
            throw null;
        }
    }
}
