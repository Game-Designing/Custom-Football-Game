package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public abstract class DefaultSerializerProvider extends SerializerProvider implements Serializable {
    protected transient JsonGenerator _generator;
    protected transient ArrayList<ObjectIdGenerator<?>> _objectIdGenerators;
    protected transient Map<Object, WritableObjectId> _seenObjectIds;

    public static final class Impl extends DefaultSerializerProvider {
        public Impl() {
        }

        protected Impl(SerializerProvider src, SerializationConfig config, SerializerFactory f) {
            super(src, config, f);
        }

        public Impl createInstance(SerializationConfig config, SerializerFactory jsf) {
            return new Impl(this, config, jsf);
        }
    }

    public abstract DefaultSerializerProvider createInstance(SerializationConfig serializationConfig, SerializerFactory serializerFactory);

    protected DefaultSerializerProvider() {
    }

    protected DefaultSerializerProvider(SerializerProvider src, SerializationConfig config, SerializerFactory f) {
        super(src, config, f);
    }

    public JsonSerializer<Object> serializerInstance(Annotated annotated, Object serDef) throws JsonMappingException {
        JsonSerializer<?> ser = null;
        if (serDef == null) {
            return null;
        }
        if (serDef instanceof JsonSerializer) {
            ser = (JsonSerializer) serDef;
        } else if (serDef instanceof Class) {
            Class<?> serClass = (Class) serDef;
            if (serClass == None.class || ClassUtil.isBogusClass(serClass)) {
                return null;
            }
            if (JsonSerializer.class.isAssignableFrom(serClass)) {
                HandlerInstantiator hi = this._config.getHandlerInstantiator();
                if (hi != null) {
                    ser = hi.serializerInstance(this._config, annotated, serClass);
                }
                if (ser == null) {
                    ser = (JsonSerializer) ClassUtil.createInstance(serClass, this._config.canOverrideAccessModifiers());
                }
            } else {
                JavaType type = annotated.getType();
                StringBuilder sb = new StringBuilder();
                sb.append("AnnotationIntrospector returned Class ");
                sb.append(serClass.getName());
                sb.append("; expected Class<JsonSerializer>");
                reportBadDefinition(type, sb.toString());
                throw null;
            }
        } else {
            JavaType type2 = annotated.getType();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AnnotationIntrospector returned serializer definition of type ");
            sb2.append(serDef.getClass().getName());
            sb2.append("; expected type JsonSerializer or Class<JsonSerializer> instead");
            reportBadDefinition(type2, sb2.toString());
            throw null;
        }
        _handleResolvable(ser);
        return ser;
    }

    public Object includeFilterInstance(BeanPropertyDefinition forProperty, Class<?> filterClass) {
        Object filter = null;
        if (filterClass == null) {
            return null;
        }
        HandlerInstantiator hi = this._config.getHandlerInstantiator();
        if (hi != null) {
            filter = hi.includeFilterInstance(this._config, forProperty, filterClass);
        }
        if (filter == null) {
            filter = ClassUtil.createInstance(filterClass, this._config.canOverrideAccessModifiers());
        }
        return filter;
    }

    public boolean includeFilterSuppressNulls(Object filter) throws JsonMappingException {
        if (filter == null) {
            return true;
        }
        try {
            return filter.equals(null);
        } catch (Throwable t) {
            reportBadDefinition(filter.getClass(), String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", new Object[]{filter.getClass().getName(), t.getClass().getName(), t.getMessage()}), t);
            throw null;
        }
    }

    public WritableObjectId findObjectId(Object forPojo, ObjectIdGenerator<?> generatorType) {
        Map<Object, WritableObjectId> map = this._seenObjectIds;
        if (map == null) {
            this._seenObjectIds = _createObjectIdMap();
        } else {
            WritableObjectId oid = (WritableObjectId) map.get(forPojo);
            if (oid != null) {
                return oid;
            }
        }
        ObjectIdGenerator<?> generator = null;
        ArrayList<ObjectIdGenerator<?>> arrayList = this._objectIdGenerators;
        if (arrayList != null) {
            int i = 0;
            int len = arrayList.size();
            while (true) {
                if (i >= len) {
                    break;
                }
                ObjectIdGenerator<?> gen = (ObjectIdGenerator) this._objectIdGenerators.get(i);
                if (gen.canUseFor(generatorType)) {
                    generator = gen;
                    break;
                }
                i++;
            }
        } else {
            this._objectIdGenerators = new ArrayList<>(8);
        }
        if (generator == null) {
            generator = generatorType.newForSerialization(this);
            this._objectIdGenerators.add(generator);
        }
        WritableObjectId oid2 = new WritableObjectId(generator);
        this._seenObjectIds.put(forPojo, oid2);
        return oid2;
    }

    /* access modifiers changed from: protected */
    public Map<Object, WritableObjectId> _createObjectIdMap() {
        if (isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID)) {
            return new HashMap();
        }
        return new IdentityHashMap();
    }

    public JsonGenerator getGenerator() {
        return this._generator;
    }

    public void serializeValue(JsonGenerator gen, Object value) throws IOException {
        this._generator = gen;
        if (value == null) {
            _serializeNull(gen);
            return;
        }
        Class<?> cls = value.getClass();
        JsonSerializer<Object> ser = findTypedValueSerializer(cls, true, (BeanProperty) null);
        PropertyName rootName = this._config.getFullRootName();
        if (rootName == null) {
            if (this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE)) {
                _serialize(gen, value, ser, this._config.findRootName(cls));
                return;
            }
        } else if (!rootName.isEmpty()) {
            _serialize(gen, value, ser, rootName);
            return;
        }
        _serialize(gen, value, ser);
    }

    public void serializeValue(JsonGenerator gen, Object value, JavaType rootType) throws IOException {
        this._generator = gen;
        if (value == null) {
            _serializeNull(gen);
            return;
        }
        if (!rootType.getRawClass().isAssignableFrom(value.getClass())) {
            _reportIncompatibleRootType(value, rootType);
        }
        JsonSerializer<Object> ser = findTypedValueSerializer(rootType, true, (BeanProperty) null);
        PropertyName rootName = this._config.getFullRootName();
        if (rootName == null) {
            if (this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE)) {
                _serialize(gen, value, ser, this._config.findRootName(rootType));
                return;
            }
        } else if (!rootName.isEmpty()) {
            _serialize(gen, value, ser, rootName);
            return;
        }
        _serialize(gen, value, ser);
    }

    public void serializeValue(JsonGenerator gen, Object value, JavaType rootType, JsonSerializer<Object> ser) throws IOException {
        this._generator = gen;
        if (value == null) {
            _serializeNull(gen);
            return;
        }
        if (rootType != null && !rootType.getRawClass().isAssignableFrom(value.getClass())) {
            _reportIncompatibleRootType(value, rootType);
        }
        if (ser == null) {
            ser = findTypedValueSerializer(rootType, true, (BeanProperty) null);
        }
        PropertyName rootName = this._config.getFullRootName();
        if (rootName == null) {
            if (this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE)) {
                _serialize(gen, value, ser, rootType == null ? this._config.findRootName(value.getClass()) : this._config.findRootName(rootType));
                return;
            }
        } else if (!rootName.isEmpty()) {
            _serialize(gen, value, ser, rootName);
            return;
        }
        _serialize(gen, value, ser);
    }

    public void serializePolymorphic(JsonGenerator gen, Object value, JavaType rootType, JsonSerializer<Object> valueSer, TypeSerializer typeSer) throws IOException {
        boolean wrap;
        this._generator = gen;
        if (value == null) {
            _serializeNull(gen);
            return;
        }
        if (rootType != null && !rootType.getRawClass().isAssignableFrom(value.getClass())) {
            _reportIncompatibleRootType(value, rootType);
        }
        if (valueSer == null) {
            if (rootType == null || !rootType.isContainerType()) {
                valueSer = findValueSerializer(value.getClass(), (BeanProperty) null);
            } else {
                valueSer = findValueSerializer(rootType, (BeanProperty) null);
            }
        }
        PropertyName rootName = this._config.getFullRootName();
        if (rootName == null) {
            wrap = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (wrap) {
                gen.writeStartObject();
                gen.writeFieldName(this._config.findRootName(value.getClass()).simpleAsEncoded(this._config));
            }
        } else if (rootName.isEmpty()) {
            wrap = false;
        } else {
            wrap = true;
            gen.writeStartObject();
            gen.writeFieldName(rootName.getSimpleName());
        }
        try {
            valueSer.serializeWithType(value, gen, this, typeSer);
            if (wrap) {
                gen.writeEndObject();
            }
        } catch (Exception e) {
            throw _wrapAsIOE(gen, e);
        }
    }

    private final void _serialize(JsonGenerator gen, Object value, JsonSerializer<Object> ser, PropertyName rootName) throws IOException {
        try {
            gen.writeStartObject();
            gen.writeFieldName(rootName.simpleAsEncoded(this._config));
            ser.serialize(value, gen, this);
            gen.writeEndObject();
        } catch (Exception e) {
            throw _wrapAsIOE(gen, e);
        }
    }

    private final void _serialize(JsonGenerator gen, Object value, JsonSerializer<Object> ser) throws IOException {
        try {
            ser.serialize(value, gen, this);
        } catch (Exception e) {
            throw _wrapAsIOE(gen, e);
        }
    }

    /* access modifiers changed from: protected */
    public void _serializeNull(JsonGenerator gen) throws IOException {
        try {
            getDefaultNullValueSerializer().serialize(null, gen, this);
        } catch (Exception e) {
            throw _wrapAsIOE(gen, e);
        }
    }

    private IOException _wrapAsIOE(JsonGenerator g, Exception e) {
        if (e instanceof IOException) {
            return (IOException) e;
        }
        String msg = e.getMessage();
        if (msg == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[no message for ");
            sb.append(e.getClass().getName());
            sb.append("]");
            msg = sb.toString();
        }
        return new JsonMappingException((Closeable) g, msg, (Throwable) e);
    }
}
