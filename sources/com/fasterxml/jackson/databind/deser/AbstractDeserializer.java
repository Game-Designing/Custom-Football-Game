package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.ValueInstantiator.Base;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class AbstractDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer, Serializable {
    protected final boolean _acceptBoolean;
    protected final boolean _acceptDouble;
    protected final boolean _acceptInt;
    protected final boolean _acceptString;
    protected final Map<String, SettableBeanProperty> _backRefProperties;
    protected final JavaType _baseType;
    protected final ObjectIdReader _objectIdReader;
    protected transient Map<String, SettableBeanProperty> _properties;

    public AbstractDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, Map<String, SettableBeanProperty> backRefProps, Map<String, SettableBeanProperty> props) {
        this._baseType = beanDesc.getType();
        this._objectIdReader = builder.getObjectIdReader();
        this._backRefProperties = backRefProps;
        this._properties = props;
        Class<?> cls = this._baseType.getRawClass();
        this._acceptString = cls.isAssignableFrom(String.class);
        boolean z = false;
        this._acceptBoolean = cls == Boolean.TYPE || cls.isAssignableFrom(Boolean.class);
        this._acceptInt = cls == Integer.TYPE || cls.isAssignableFrom(Integer.class);
        if (cls == Double.TYPE || cls.isAssignableFrom(Double.class)) {
            z = true;
        }
        this._acceptDouble = z;
    }

    protected AbstractDeserializer(BeanDescription beanDesc) {
        this._baseType = beanDesc.getType();
        this._objectIdReader = null;
        this._backRefProperties = null;
        Class<?> cls = this._baseType.getRawClass();
        this._acceptString = cls.isAssignableFrom(String.class);
        boolean z = false;
        this._acceptBoolean = cls == Boolean.TYPE || cls.isAssignableFrom(Boolean.class);
        this._acceptInt = cls == Integer.TYPE || cls.isAssignableFrom(Integer.class);
        if (cls == Double.TYPE || cls.isAssignableFrom(Double.class)) {
            z = true;
        }
        this._acceptDouble = z;
    }

    protected AbstractDeserializer(AbstractDeserializer base, ObjectIdReader objectIdReader, Map<String, SettableBeanProperty> props) {
        this._baseType = base._baseType;
        this._backRefProperties = base._backRefProperties;
        this._acceptString = base._acceptString;
        this._acceptBoolean = base._acceptBoolean;
        this._acceptInt = base._acceptInt;
        this._acceptDouble = base._acceptDouble;
        this._objectIdReader = objectIdReader;
        this._properties = props;
    }

    public static AbstractDeserializer constructForNonPOJO(BeanDescription beanDesc) {
        return new AbstractDeserializer(beanDesc);
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JavaType idType;
        ObjectIdGenerator objectIdGenerator;
        DeserializationContext deserializationContext = ctxt;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (!(property == null || intr == null)) {
            AnnotatedMember accessor = property.getMember();
            if (accessor != null) {
                ObjectIdInfo objectIdInfo = intr.findObjectIdInfo(accessor);
                if (objectIdInfo != null) {
                    SettableBeanProperty idProp = null;
                    ObjectIdResolver resolver = deserializationContext.objectIdResolverInstance(accessor, objectIdInfo);
                    ObjectIdInfo objectIdInfo2 = intr.findObjectReferenceInfo(accessor, objectIdInfo);
                    Class<?> implClass = objectIdInfo2.getGeneratorType();
                    if (implClass == ObjectIdGenerators$PropertyGenerator.class) {
                        PropertyName propName = objectIdInfo2.getPropertyName();
                        Map<String, SettableBeanProperty> map = this._properties;
                        idProp = map == null ? null : (SettableBeanProperty) map.get(propName.getSimpleName());
                        if (idProp != null) {
                            idType = idProp.getType();
                            objectIdGenerator = new PropertyBasedObjectIdGenerator(objectIdInfo2.getScope());
                        } else {
                            deserializationContext.reportBadDefinition(this._baseType, String.format("Invalid Object Id definition for %s: cannot find property with name '%s'", new Object[]{handledType().getName(), propName}));
                            throw null;
                        }
                    } else {
                        resolver = deserializationContext.objectIdResolverInstance(accessor, objectIdInfo2);
                        idType = ctxt.getTypeFactory().findTypeParameters(deserializationContext.constructType(implClass), ObjectIdGenerator.class)[0];
                        objectIdGenerator = deserializationContext.objectIdGeneratorInstance(accessor, objectIdInfo2);
                    }
                    return new AbstractDeserializer(this, ObjectIdReader.construct(idType, objectIdInfo2.getPropertyName(), objectIdGenerator, deserializationContext.findRootValueDeserializer(idType), idProp, resolver), null);
                }
            }
        }
        if (this._properties == null) {
            return this;
        }
        return new AbstractDeserializer(this, this._objectIdReader, null);
    }

    public Class<?> handledType() {
        return this._baseType.getRawClass();
    }

    public boolean isCachable() {
        return true;
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return null;
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public SettableBeanProperty findBackReference(String logicalName) {
        Map<String, SettableBeanProperty> map = this._backRefProperties;
        if (map == null) {
            return null;
        }
        return (SettableBeanProperty) map.get(logicalName);
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        if (this._objectIdReader != null) {
            JsonToken t = p.getCurrentToken();
            if (t != null) {
                if (t.isScalarValue()) {
                    return _deserializeFromObjectId(p, ctxt);
                }
                if (t == JsonToken.START_OBJECT) {
                    t = p.nextToken();
                }
                if (t == JsonToken.FIELD_NAME && this._objectIdReader.maySerializeAsObject() && this._objectIdReader.isValidReferencePropertyName(p.getCurrentName(), p)) {
                    return _deserializeFromObjectId(p, ctxt);
                }
            }
        }
        Object result = _deserializeIfNatural(p, ctxt);
        if (result != null) {
            return result;
        }
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ctxt.handleMissingInstantiator(this._baseType.getRawClass(), new Base(this._baseType), p, "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public Object _deserializeIfNatural(JsonParser p, DeserializationContext ctxt) throws IOException {
        switch (p.getCurrentTokenId()) {
            case 6:
                if (this._acceptString) {
                    return p.getText();
                }
                break;
            case 7:
                if (this._acceptInt) {
                    return Integer.valueOf(p.getIntValue());
                }
                break;
            case 8:
                if (this._acceptDouble) {
                    return Double.valueOf(p.getDoubleValue());
                }
                break;
            case 9:
                if (this._acceptBoolean) {
                    return Boolean.TRUE;
                }
                break;
            case 10:
                if (this._acceptBoolean) {
                    return Boolean.FALSE;
                }
                break;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object _deserializeFromObjectId(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object id = this._objectIdReader.readObjectReference(p, ctxt);
        ObjectIdReader objectIdReader = this._objectIdReader;
        ReadableObjectId roid = ctxt.findObjectId(id, objectIdReader.generator, objectIdReader.resolver);
        Object pojo = roid.resolve();
        if (pojo != null) {
            return pojo;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not resolve Object Id [");
        sb.append(id);
        sb.append("] -- unresolved forward-reference?");
        throw new UnresolvedForwardReference(p, sb.toString(), p.getCurrentLocation(), roid);
    }
}
