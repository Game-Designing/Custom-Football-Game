package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TypeDeserializerBase extends TypeDeserializer implements Serializable {
    protected final JavaType _baseType;
    protected final JavaType _defaultImpl;
    protected JsonDeserializer<Object> _defaultImplDeserializer;
    protected final Map<String, JsonDeserializer<Object>> _deserializers;
    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;
    protected final boolean _typeIdVisible;
    protected final String _typePropertyName;

    protected TypeDeserializerBase(JavaType baseType, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, JavaType defaultImpl) {
        this._baseType = baseType;
        this._idResolver = idRes;
        this._typePropertyName = ClassUtil.nonNullString(typePropertyName);
        this._typeIdVisible = typeIdVisible;
        this._deserializers = new ConcurrentHashMap(16, 0.75f, 2);
        this._defaultImpl = defaultImpl;
        this._property = null;
    }

    protected TypeDeserializerBase(TypeDeserializerBase src, BeanProperty property) {
        this._baseType = src._baseType;
        this._idResolver = src._idResolver;
        this._typePropertyName = src._typePropertyName;
        this._typeIdVisible = src._typeIdVisible;
        this._deserializers = src._deserializers;
        this._defaultImpl = src._defaultImpl;
        this._defaultImplDeserializer = src._defaultImplDeserializer;
        this._property = property;
    }

    public String baseTypeName() {
        return this._baseType.getRawClass().getName();
    }

    public final String getPropertyName() {
        return this._typePropertyName;
    }

    public TypeIdResolver getTypeIdResolver() {
        return this._idResolver;
    }

    public Class<?> getDefaultImpl() {
        return ClassUtil.rawClass(this._defaultImpl);
    }

    public JavaType baseType() {
        return this._baseType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(getClass().getName());
        sb.append("; base-type:");
        sb.append(this._baseType);
        sb.append("; id-resolver: ");
        sb.append(this._idResolver);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final JsonDeserializer<Object> _findDeserializer(DeserializationContext ctxt, String typeId) throws IOException {
        JsonDeserializer<Object> deser = (JsonDeserializer) this._deserializers.get(typeId);
        if (deser == null) {
            JavaType type = this._idResolver.typeFromId(ctxt, typeId);
            if (type == null) {
                deser = _findDefaultImplDeserializer(ctxt);
                if (deser == null) {
                    JavaType actual = _handleUnknownTypeId(ctxt, typeId);
                    if (actual == null) {
                        return null;
                    }
                    deser = ctxt.findContextualValueDeserializer(actual, this._property);
                }
            } else {
                JavaType javaType = this._baseType;
                if (javaType != null && javaType.getClass() == type.getClass() && !type.hasGenericTypes()) {
                    type = ctxt.getTypeFactory().constructSpecializedType(this._baseType, type.getRawClass());
                }
                deser = ctxt.findContextualValueDeserializer(type, this._property);
            }
            this._deserializers.put(typeId, deser);
        }
        return deser;
    }

    /* access modifiers changed from: protected */
    public final JsonDeserializer<Object> _findDefaultImplDeserializer(DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> jsonDeserializer;
        JavaType javaType = this._defaultImpl;
        if (javaType == null) {
            if (!ctxt.isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
                return NullifyingDeserializer.instance;
            }
            return null;
        } else if (ClassUtil.isBogusClass(javaType.getRawClass())) {
            return NullifyingDeserializer.instance;
        } else {
            synchronized (this._defaultImpl) {
                if (this._defaultImplDeserializer == null) {
                    this._defaultImplDeserializer = ctxt.findContextualValueDeserializer(this._defaultImpl, this._property);
                }
                jsonDeserializer = this._defaultImplDeserializer;
            }
            return jsonDeserializer;
        }
    }

    /* access modifiers changed from: protected */
    public Object _deserializeWithNativeTypeId(JsonParser jp, DeserializationContext ctxt, Object typeId) throws IOException {
        JsonDeserializer<Object> deser;
        if (typeId == null) {
            deser = _findDefaultImplDeserializer(ctxt);
            if (deser == null) {
                ctxt.reportInputMismatch(baseType(), "No (native) type id found when one was expected for polymorphic type handling", new Object[0]);
                throw null;
            }
        } else {
            deser = _findDeserializer(ctxt, typeId instanceof String ? (String) typeId : String.valueOf(typeId));
        }
        return deser.deserialize(jp, ctxt);
    }

    /* access modifiers changed from: protected */
    public JavaType _handleUnknownTypeId(DeserializationContext ctxt, String typeId) throws IOException {
        String extraDesc;
        String extraDesc2 = this._idResolver.getDescForKnownTypeIds();
        if (extraDesc2 == null) {
            extraDesc = "type ids are not statically known";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("known type ids = ");
            sb.append(extraDesc2);
            extraDesc = sb.toString();
        }
        BeanProperty beanProperty = this._property;
        if (beanProperty != null) {
            extraDesc = String.format("%s (for POJO property '%s')", new Object[]{extraDesc, beanProperty.getName()});
        }
        return ctxt.handleUnknownTypeId(this._baseType, typeId, this._idResolver, extraDesc);
    }

    /* access modifiers changed from: protected */
    public JavaType _handleMissingTypeId(DeserializationContext ctxt, String extraDesc) throws IOException {
        return ctxt.handleMissingTypeId(this._baseType, this._idResolver, extraDesc);
    }
}
