package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.Named;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class DeserializationContext extends DatabindContext implements Serializable {
    protected transient ArrayBuilders _arrayBuilders;
    protected transient ContextAttributes _attributes;
    protected final DeserializerCache _cache;
    protected final DeserializationConfig _config;
    protected LinkedNode<JavaType> _currentType;
    protected transient DateFormat _dateFormat;
    protected final DeserializerFactory _factory;
    protected final int _featureFlags;
    protected final InjectableValues _injectableValues;
    protected transient ObjectBuffer _objectBuffer;
    protected transient JsonParser _parser;
    protected final Class<?> _view;

    public abstract JsonDeserializer<Object> deserializerInstance(Annotated annotated, Object obj) throws JsonMappingException;

    public abstract ReadableObjectId findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator, ObjectIdResolver objectIdResolver);

    public abstract KeyDeserializer keyDeserializerInstance(Annotated annotated, Object obj) throws JsonMappingException;

    protected DeserializationContext(DeserializerFactory df, DeserializerCache cache) {
        if (df != null) {
            this._factory = df;
            if (cache == null) {
                cache = new DeserializerCache();
            }
            this._cache = cache;
            this._featureFlags = 0;
            this._config = null;
            this._injectableValues = null;
            this._view = null;
            this._attributes = null;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null DeserializerFactory");
    }

    protected DeserializationContext(DeserializationContext src, DeserializationConfig config, JsonParser p, InjectableValues injectableValues) {
        this._cache = src._cache;
        this._factory = src._factory;
        this._config = config;
        this._featureFlags = config.getDeserializationFeatures();
        this._view = config.getActiveView();
        this._parser = p;
        this._injectableValues = injectableValues;
        this._attributes = config.getAttributes();
    }

    public DeserializationConfig getConfig() {
        return this._config;
    }

    public final Class<?> getActiveView() {
        return this._view;
    }

    public final boolean canOverrideAccessModifiers() {
        return this._config.canOverrideAccessModifiers();
    }

    public final boolean isEnabled(MapperFeature feature) {
        return this._config.isEnabled(feature);
    }

    public final Value getDefaultPropertyFormat(Class<?> baseType) {
        return this._config.getDefaultPropertyFormat(baseType);
    }

    public final AnnotationIntrospector getAnnotationIntrospector() {
        return this._config.getAnnotationIntrospector();
    }

    public final TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public Locale getLocale() {
        return this._config.getLocale();
    }

    public TimeZone getTimeZone() {
        return this._config.getTimeZone();
    }

    public final boolean isEnabled(DeserializationFeature feat) {
        return (this._featureFlags & feat.getMask()) != 0;
    }

    public final int getDeserializationFeatures() {
        return this._featureFlags;
    }

    public final boolean hasSomeOfFeatures(int featureMask) {
        return (this._featureFlags & featureMask) != 0;
    }

    public final JsonParser getParser() {
        return this._parser;
    }

    public final Object findInjectableValue(Object valueId, BeanProperty forProperty, Object beanInstance) throws JsonMappingException {
        if (this._injectableValues == null) {
            reportBadDefinition(ClassUtil.classOf(valueId), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", new Object[]{valueId}));
        }
        return this._injectableValues.findInjectableValue(valueId, this, forProperty, beanInstance);
    }

    public final Base64Variant getBase64Variant() {
        return this._config.getBase64Variant();
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._config.getNodeFactory();
    }

    public final JsonDeserializer<Object> findContextualValueDeserializer(JavaType type, BeanProperty prop) throws JsonMappingException {
        JsonDeserializer<Object> deser = this._cache.findValueDeserializer(this, this._factory, type);
        if (deser != null) {
            return handleSecondaryContextualization(deser, prop, type);
        }
        return deser;
    }

    public final JsonDeserializer<Object> findNonContextualValueDeserializer(JavaType type) throws JsonMappingException {
        return this._cache.findValueDeserializer(this, this._factory, type);
    }

    public final JsonDeserializer<Object> findRootValueDeserializer(JavaType type) throws JsonMappingException {
        JsonDeserializer<Object> deser = this._cache.findValueDeserializer(this, this._factory, type);
        if (deser == null) {
            return null;
        }
        JsonDeserializer<Object> deser2 = handleSecondaryContextualization(deser, null, type);
        TypeDeserializer typeDeser = this._factory.findTypeDeserializer(this._config, type);
        if (typeDeser != null) {
            return new TypeWrappedDeserializer(typeDeser.forProperty(null), deser2);
        }
        return deser2;
    }

    public final KeyDeserializer findKeyDeserializer(JavaType keyType, BeanProperty prop) throws JsonMappingException {
        KeyDeserializer kd = this._cache.findKeyDeserializer(this, this._factory, keyType);
        if (kd instanceof ContextualKeyDeserializer) {
            return ((ContextualKeyDeserializer) kd).createContextual(this, prop);
        }
        return kd;
    }

    public final JavaType constructType(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this._config.constructType(cls);
    }

    public Class<?> findClass(String className) throws ClassNotFoundException {
        return getTypeFactory().findClass(className);
    }

    public final ObjectBuffer leaseObjectBuffer() {
        ObjectBuffer buf = this._objectBuffer;
        if (buf == null) {
            return new ObjectBuffer();
        }
        this._objectBuffer = null;
        return buf;
    }

    public final void returnObjectBuffer(ObjectBuffer buf) {
        if (this._objectBuffer == null || buf.initialCapacity() >= this._objectBuffer.initialCapacity()) {
            this._objectBuffer = buf;
        }
    }

    public final ArrayBuilders getArrayBuilders() {
        if (this._arrayBuilders == null) {
            this._arrayBuilders = new ArrayBuilders();
        }
        return this._arrayBuilders;
    }

    public JsonDeserializer<?> handlePrimaryContextualization(JsonDeserializer<?> deser, BeanProperty prop, JavaType type) throws JsonMappingException {
        if (!(deser instanceof ContextualDeserializer)) {
            return deser;
        }
        this._currentType = new LinkedNode<>(type, this._currentType);
        try {
            return ((ContextualDeserializer) deser).createContextual(this, prop);
        } finally {
            this._currentType = this._currentType.next();
        }
    }

    public JsonDeserializer<?> handleSecondaryContextualization(JsonDeserializer<?> deser, BeanProperty prop, JavaType type) throws JsonMappingException {
        if (!(deser instanceof ContextualDeserializer)) {
            return deser;
        }
        this._currentType = new LinkedNode<>(type, this._currentType);
        try {
            return ((ContextualDeserializer) deser).createContextual(this, prop);
        } finally {
            this._currentType = this._currentType.next();
        }
    }

    public Date parseDate(String dateStr) throws IllegalArgumentException {
        try {
            return getDateFormat().parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", new Object[]{dateStr, e.getMessage()}));
        }
    }

    public Calendar constructCalendar(Date d) {
        Calendar c = Calendar.getInstance(getTimeZone());
        c.setTime(d);
        return c;
    }

    public boolean handleUnknownProperty(JsonParser p, JsonDeserializer<?> deser, Object instanceOrClass, String propName) throws IOException {
        for (LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers(); h != null; h = h.next()) {
            if (((DeserializationProblemHandler) h.value()).handleUnknownProperty(this, p, deser, instanceOrClass, propName)) {
                return true;
            }
        }
        if (!isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            p.skipChildren();
            return true;
        }
        throw UnrecognizedPropertyException.from(this._parser, instanceOrClass, propName, deser == null ? null : deser.getKnownPropertyNames());
    }

    public Object handleWeirdKey(Class<?> keyClass, String keyValue, String msg, Object... msgArgs) throws IOException {
        String msg2 = _format(msg, msgArgs);
        LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers();
        while (h != null) {
            Object key = ((DeserializationProblemHandler) h.value()).handleWeirdKey(this, keyClass, keyValue, msg2);
            if (key == DeserializationProblemHandler.NOT_HANDLED) {
                h = h.next();
            } else if (key == null || keyClass.isInstance(key)) {
                return key;
            } else {
                throw weirdStringException(keyValue, keyClass, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", new Object[]{keyClass, key.getClass()}));
            }
        }
        throw weirdKeyException(keyClass, keyValue, msg2);
    }

    public Object handleWeirdStringValue(Class<?> targetClass, String value, String msg, Object... msgArgs) throws IOException {
        String msg2 = _format(msg, msgArgs);
        LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers();
        while (h != null) {
            Object instance = ((DeserializationProblemHandler) h.value()).handleWeirdStringValue(this, targetClass, value, msg2);
            if (instance == DeserializationProblemHandler.NOT_HANDLED) {
                h = h.next();
            } else if (_isCompatible(targetClass, instance)) {
                return instance;
            } else {
                throw weirdStringException(value, targetClass, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", new Object[]{targetClass, instance.getClass()}));
            }
        }
        throw weirdStringException(value, targetClass, msg2);
    }

    public Object handleWeirdNumberValue(Class<?> targetClass, Number value, String msg, Object... msgArgs) throws IOException {
        String msg2 = _format(msg, msgArgs);
        LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers();
        while (h != null) {
            Object key = ((DeserializationProblemHandler) h.value()).handleWeirdNumberValue(this, targetClass, value, msg2);
            if (key == DeserializationProblemHandler.NOT_HANDLED) {
                h = h.next();
            } else if (_isCompatible(targetClass, key)) {
                return key;
            } else {
                throw weirdNumberException(value, targetClass, _format("DeserializationProblemHandler.handleWeirdNumberValue() for type %s returned value of type %s", targetClass, key.getClass()));
            }
        }
        throw weirdNumberException(value, targetClass, msg2);
    }

    public Object handleWeirdNativeValue(JavaType targetType, Object badValue, JsonParser p) throws IOException {
        LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers();
        Class<?> raw = targetType.getRawClass();
        while (h != null) {
            Object goodValue = ((DeserializationProblemHandler) h.value()).handleWeirdNativeValue(this, targetType, badValue, p);
            if (goodValue == DeserializationProblemHandler.NOT_HANDLED) {
                h = h.next();
            } else if (goodValue == null || raw.isInstance(goodValue)) {
                return goodValue;
            } else {
                throw JsonMappingException.from(p, _format("DeserializationProblemHandler.handleWeirdNativeValue() for type %s returned value of type %s", targetType, goodValue.getClass()));
            }
        }
        throw weirdNativeValueException(badValue, raw);
    }

    public Object handleMissingInstantiator(Class<?> instClass, ValueInstantiator valueInst, JsonParser p, String msg, Object... msgArgs) throws IOException {
        JsonParser p2;
        Class<?> cls = instClass;
        if (p == null) {
            p2 = getParser();
        } else {
            p2 = p;
        }
        String msg2 = _format(msg, msgArgs);
        LinkedNode problemHandlers = this._config.getProblemHandlers();
        while (problemHandlers != null) {
            Object instance = ((DeserializationProblemHandler) problemHandlers.value()).handleMissingInstantiator(this, instClass, valueInst, p2, msg2);
            if (instance == DeserializationProblemHandler.NOT_HANDLED) {
                problemHandlers = problemHandlers.next();
            } else if (_isCompatible(cls, instance)) {
                return instance;
            } else {
                reportBadDefinition(constructType(instClass), String.format("DeserializationProblemHandler.handleMissingInstantiator() for type %s returned value of type %s", new Object[]{cls, ClassUtil.classNameOf(instance)}));
                throw null;
            }
        }
        if (valueInst == null || valueInst.canInstantiate()) {
            reportInputMismatch(cls, String.format("Cannot construct instance of %s (although at least one Creator exists): %s", new Object[]{ClassUtil.nameOf(instClass), msg2}), new Object[0]);
            throw null;
        }
        reportBadDefinition(constructType(instClass), String.format("Cannot construct instance of %s (no Creators, like default construct, exist): %s", new Object[]{ClassUtil.nameOf(instClass), msg2}));
        throw null;
    }

    public Object handleInstantiationProblem(Class<?> instClass, Object argument, Throwable t) throws IOException {
        LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers();
        while (h != null) {
            Object instance = ((DeserializationProblemHandler) h.value()).handleInstantiationProblem(this, instClass, argument, t);
            if (instance == DeserializationProblemHandler.NOT_HANDLED) {
                h = h.next();
            } else if (_isCompatible(instClass, instance)) {
                return instance;
            } else {
                reportBadDefinition(constructType(instClass), String.format("DeserializationProblemHandler.handleInstantiationProblem() for type %s returned value of type %s", new Object[]{instClass, ClassUtil.classNameOf(instance)}));
                throw null;
            }
        }
        ClassUtil.throwIfIOE(t);
        throw instantiationException(instClass, t);
    }

    public Object handleUnexpectedToken(Class<?> instClass, JsonParser p) throws IOException {
        return handleUnexpectedToken(instClass, p.getCurrentToken(), p, null, new Object[0]);
    }

    public Object handleUnexpectedToken(Class<?> instClass, JsonToken t, JsonParser p, String msg, Object... msgArgs) throws IOException {
        Class<?> cls = instClass;
        String msg2 = _format(msg, msgArgs);
        LinkedNode problemHandlers = this._config.getProblemHandlers();
        while (problemHandlers != null) {
            Object instance = ((DeserializationProblemHandler) problemHandlers.value()).handleUnexpectedToken(this, instClass, t, p, msg2);
            if (instance == DeserializationProblemHandler.NOT_HANDLED) {
                problemHandlers = problemHandlers.next();
            } else if (_isCompatible(cls, instance)) {
                return instance;
            } else {
                reportBadDefinition(constructType(instClass), String.format("DeserializationProblemHandler.handleUnexpectedToken() for type %s returned value of type %s", new Object[]{ClassUtil.nameOf(instClass), ClassUtil.classNameOf(instance)}));
                throw null;
            }
        }
        if (msg2 == null) {
            if (t == null) {
                msg2 = String.format("Unexpected end-of-input when binding data into %s", new Object[]{ClassUtil.nameOf(instClass)});
            } else {
                msg2 = String.format("Cannot deserialize instance of %s out of %s token", new Object[]{ClassUtil.nameOf(instClass), t});
            }
        }
        reportInputMismatch(cls, msg2, new Object[0]);
        throw null;
    }

    public JavaType handleUnknownTypeId(JavaType baseType, String id, TypeIdResolver idResolver, String extraDesc) throws IOException {
        LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers();
        while (h != null) {
            JavaType type = ((DeserializationProblemHandler) h.value()).handleUnknownTypeId(this, baseType, id, idResolver, extraDesc);
            if (type == null) {
                h = h.next();
            } else if (type.hasRawClass(Void.class)) {
                return null;
            } else {
                if (type.isTypeOrSubTypeOf(baseType.getRawClass())) {
                    return type;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("problem handler tried to resolve into non-subtype: ");
                sb.append(type);
                throw invalidTypeIdException(baseType, id, sb.toString());
            }
        }
        if (!isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
            return null;
        }
        throw invalidTypeIdException(baseType, id, extraDesc);
    }

    public JavaType handleMissingTypeId(JavaType baseType, TypeIdResolver idResolver, String extraDesc) throws IOException {
        LinkedNode<DeserializationProblemHandler> h = this._config.getProblemHandlers();
        while (h != null) {
            JavaType type = ((DeserializationProblemHandler) h.value()).handleMissingTypeId(this, baseType, idResolver, extraDesc);
            if (type == null) {
                h = h.next();
            } else if (type.hasRawClass(Void.class)) {
                return null;
            } else {
                if (type.isTypeOrSubTypeOf(baseType.getRawClass())) {
                    return type;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("problem handler tried to resolve into non-subtype: ");
                sb.append(type);
                throw invalidTypeIdException(baseType, null, sb.toString());
            }
        }
        throw missingTypeIdException(baseType, extraDesc);
    }

    /* access modifiers changed from: protected */
    public boolean _isCompatible(Class<?> target, Object value) {
        boolean z = true;
        if (value == null || target.isInstance(value)) {
            return true;
        }
        if (!target.isPrimitive() || !ClassUtil.wrapperType(target).isInstance(value)) {
            z = false;
        }
        return z;
    }

    public void reportWrongTokenException(JsonDeserializer<?> deser, JsonToken expToken, String msg, Object... msgArgs) throws JsonMappingException {
        throw wrongTokenException(getParser(), deser.handledType(), expToken, _format(msg, msgArgs));
    }

    public void reportWrongTokenException(JavaType targetType, JsonToken expToken, String msg, Object... msgArgs) throws JsonMappingException {
        throw wrongTokenException(getParser(), targetType, expToken, _format(msg, msgArgs));
    }

    public void reportWrongTokenException(Class<?> targetType, JsonToken expToken, String msg, Object... msgArgs) throws JsonMappingException {
        throw wrongTokenException(getParser(), targetType, expToken, _format(msg, msgArgs));
    }

    public <T> T reportUnresolvedObjectId(ObjectIdReader oidReader, Object bean) throws JsonMappingException {
        reportInputMismatch((BeanProperty) oidReader.idProperty, String.format("No Object Id found for an instance of %s, to assign to property '%s'", new Object[]{ClassUtil.classNameOf(bean), oidReader.propertyName}), new Object[0]);
        throw null;
    }

    public <T> T reportInputMismatch(BeanProperty prop, String msg, Object... msgArgs) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), prop == null ? null : prop.getType(), _format(msg, msgArgs));
    }

    public <T> T reportInputMismatch(JsonDeserializer<?> src, String msg, Object... msgArgs) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), src.handledType(), _format(msg, msgArgs));
    }

    public <T> T reportInputMismatch(Class<?> targetType, String msg, Object... msgArgs) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), targetType, _format(msg, msgArgs));
    }

    public <T> T reportInputMismatch(JavaType targetType, String msg, Object... msgArgs) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), targetType, _format(msg, msgArgs));
    }

    public <T> T reportTrailingTokens(Class<?> targetType, JsonParser p, JsonToken trailingToken) throws JsonMappingException {
        throw MismatchedInputException.from(p, targetType, String.format("Trailing token (of type %s) found after value (bound as %s): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`", new Object[]{trailingToken, ClassUtil.nameOf(targetType)}));
    }

    public <T> T reportBadTypeDefinition(BeanDescription bean, String msg, Object... msgArgs) throws JsonMappingException {
        throw InvalidDefinitionException.from(this._parser, String.format("Invalid type definition for type %s: %s", new Object[]{ClassUtil.nameOf(bean.getBeanClass()), _format(msg, msgArgs)}), bean, (BeanPropertyDefinition) null);
    }

    public <T> T reportBadPropertyDefinition(BeanDescription bean, BeanPropertyDefinition prop, String msg, Object... msgArgs) throws JsonMappingException {
        String msg2 = _format(msg, msgArgs);
        throw InvalidDefinitionException.from(this._parser, String.format("Invalid definition for property %s (of type %s): %s", new Object[]{ClassUtil.nameOf((Named) prop), ClassUtil.nameOf(bean.getBeanClass()), msg2}), bean, prop);
    }

    public <T> T reportBadDefinition(JavaType type, String msg) throws JsonMappingException {
        throw InvalidDefinitionException.from(this._parser, msg, type);
    }

    public <T> T reportBadMerge(JsonDeserializer<?> deser) throws JsonMappingException {
        if (isEnabled(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            return null;
        }
        JavaType type = constructType(deser.handledType());
        throw InvalidDefinitionException.from(getParser(), String.format("Invalid configuration: values of type %s cannot be merged", new Object[]{type}), type);
    }

    public JsonMappingException wrongTokenException(JsonParser p, JavaType targetType, JsonToken expToken, String extra) {
        return MismatchedInputException.from(p, targetType, _colonConcat(String.format("Unexpected token (%s), expected %s", new Object[]{p.getCurrentToken(), expToken}), extra));
    }

    public JsonMappingException wrongTokenException(JsonParser p, Class<?> targetType, JsonToken expToken, String extra) {
        return MismatchedInputException.from(p, targetType, _colonConcat(String.format("Unexpected token (%s), expected %s", new Object[]{p.getCurrentToken(), expToken}), extra));
    }

    public JsonMappingException weirdKeyException(Class<?> keyClass, String keyValue, String msg) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize Map key of type %s from String %s: %s", new Object[]{ClassUtil.nameOf(keyClass), _quotedString(keyValue), msg}), keyValue, keyClass);
    }

    public JsonMappingException weirdStringException(String value, Class<?> instClass, String msg) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize value of type %s from String %s: %s", new Object[]{ClassUtil.nameOf(instClass), _quotedString(value), msg}), value, instClass);
    }

    public JsonMappingException weirdNumberException(Number value, Class<?> instClass, String msg) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize value of type %s from number %s: %s", new Object[]{ClassUtil.nameOf(instClass), String.valueOf(value), msg}), value, instClass);
    }

    public JsonMappingException weirdNativeValueException(Object value, Class<?> instClass) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize value of type %s from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type %s: incompatible types", new Object[]{ClassUtil.nameOf(instClass), ClassUtil.classNameOf(value)}), value, instClass);
    }

    public JsonMappingException instantiationException(Class<?> instClass, Throwable cause) {
        JavaType type = constructType(instClass);
        InvalidDefinitionException e = InvalidDefinitionException.from(this._parser, String.format("Cannot construct instance of %s, problem: %s", new Object[]{ClassUtil.nameOf(instClass), cause.getMessage()}), type);
        e.initCause(cause);
        return e;
    }

    public JsonMappingException invalidTypeIdException(JavaType baseType, String typeId, String extraDesc) {
        return InvalidTypeIdException.from(this._parser, _colonConcat(String.format("Could not resolve type id '%s' as a subtype of %s", new Object[]{typeId, baseType}), extraDesc), baseType, typeId);
    }

    public JsonMappingException missingTypeIdException(JavaType baseType, String extraDesc) {
        return InvalidTypeIdException.from(this._parser, _colonConcat(String.format("Missing type id when trying to resolve subtype of %s", new Object[]{baseType}), extraDesc), baseType, null);
    }

    /* access modifiers changed from: protected */
    public DateFormat getDateFormat() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config.getDateFormat().clone();
        DateFormat df = dateFormat2;
        this._dateFormat = dateFormat2;
        return df;
    }
}
