package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectReader extends ObjectCodec implements Versioned, Serializable {
    private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
    protected final DeserializationConfig _config;
    protected final DefaultDeserializationContext _context;
    protected final DataFormatReaders _dataFormatReaders = null;
    private final TokenFilter _filter = null;
    protected final InjectableValues _injectableValues;
    protected final JsonFactory _parserFactory;
    protected final JsonDeserializer<Object> _rootDeserializer;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    protected final FormatSchema _schema;
    protected final boolean _unwrapRoot;
    protected final Object _valueToUpdate;
    protected final JavaType _valueType;

    protected ObjectReader(ObjectMapper mapper, DeserializationConfig config, JavaType valueType, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues) {
        this._config = config;
        this._context = mapper._deserializationContext;
        this._rootDeserializers = mapper._rootDeserializers;
        this._parserFactory = mapper._jsonFactory;
        this._valueType = valueType;
        this._valueToUpdate = valueToUpdate;
        this._schema = schema;
        this._injectableValues = injectableValues;
        this._unwrapRoot = config.useRootWrapping();
        this._rootDeserializer = _prefetchRootDeserializer(valueType);
    }

    /* access modifiers changed from: protected */
    public JsonToken _initForReading(DeserializationContext ctxt, JsonParser p) throws IOException {
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            p.setSchema(formatSchema);
        }
        this._config.initialize(p);
        JsonToken t = p.getCurrentToken();
        if (t == null) {
            t = p.nextToken();
            if (t == null) {
                ctxt.reportInputMismatch(this._valueType, "No content to map due to end-of-input", new Object[0]);
                throw null;
            }
        }
        return t;
    }

    public <T> T readValue(Reader src) throws IOException {
        if (this._dataFormatReaders == null) {
            return _bindAndClose(_considerFilter(this._parserFactory.createParser(src), false));
        }
        _reportUndetectableSource(src);
        throw null;
    }

    public void writeValue(JsonGenerator gen, Object value) throws IOException {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r0 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0068, code lost:
        if (r1 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object _bindAndClose(com.fasterxml.jackson.core.JsonParser r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = r8
            r1 = 0
            com.fasterxml.jackson.databind.deser.DefaultDeserializationContext r2 = r7.createDeserializationContext(r0)     // Catch:{ Throwable -> 0x0064 }
            com.fasterxml.jackson.core.JsonToken r3 = r7._initForReading(r2, r0)     // Catch:{ Throwable -> 0x0064 }
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL     // Catch:{ Throwable -> 0x0064 }
            if (r3 != r4) goto L_0x001e
            java.lang.Object r4 = r7._valueToUpdate     // Catch:{ Throwable -> 0x0064 }
            if (r4 != 0) goto L_0x001b
            com.fasterxml.jackson.databind.JsonDeserializer r4 = r7._findRootDeserializer(r2)     // Catch:{ Throwable -> 0x0064 }
            java.lang.Object r4 = r4.getNullValue(r2)     // Catch:{ Throwable -> 0x0064 }
            goto L_0x004c
        L_0x001b:
            java.lang.Object r4 = r7._valueToUpdate     // Catch:{ Throwable -> 0x0064 }
            goto L_0x004c
        L_0x001e:
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.END_ARRAY     // Catch:{ Throwable -> 0x0064 }
            if (r3 == r4) goto L_0x004a
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.END_OBJECT     // Catch:{ Throwable -> 0x0064 }
            if (r3 != r4) goto L_0x0027
            goto L_0x004a
        L_0x0027:
            com.fasterxml.jackson.databind.JsonDeserializer r4 = r7._findRootDeserializer(r2)     // Catch:{ Throwable -> 0x0064 }
            boolean r5 = r7._unwrapRoot     // Catch:{ Throwable -> 0x0064 }
            if (r5 == 0) goto L_0x0037
            com.fasterxml.jackson.databind.JavaType r5 = r7._valueType     // Catch:{ Throwable -> 0x0064 }
            java.lang.Object r5 = r7._unwrapAndDeserialize(r0, r2, r5, r4)     // Catch:{ Throwable -> 0x0064 }
            r4 = r5
            goto L_0x004c
        L_0x0037:
            java.lang.Object r5 = r7._valueToUpdate     // Catch:{ Throwable -> 0x0064 }
            if (r5 != 0) goto L_0x0041
            java.lang.Object r5 = r4.deserialize(r0, r2)     // Catch:{ Throwable -> 0x0064 }
            r4 = r5
            goto L_0x004c
        L_0x0041:
            java.lang.Object r5 = r7._valueToUpdate     // Catch:{ Throwable -> 0x0064 }
            r4.deserialize(r0, r2, r5)     // Catch:{ Throwable -> 0x0064 }
            java.lang.Object r5 = r7._valueToUpdate     // Catch:{ Throwable -> 0x0064 }
            r4 = r5
            goto L_0x004c
        L_0x004a:
            java.lang.Object r4 = r7._valueToUpdate     // Catch:{ Throwable -> 0x0064 }
        L_0x004c:
            com.fasterxml.jackson.databind.DeserializationConfig r5 = r7._config     // Catch:{ Throwable -> 0x0064 }
            com.fasterxml.jackson.databind.DeserializationFeature r6 = com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_TRAILING_TOKENS     // Catch:{ Throwable -> 0x0064 }
            boolean r5 = r5.isEnabled(r6)     // Catch:{ Throwable -> 0x0064 }
            if (r5 == 0) goto L_0x005b
            com.fasterxml.jackson.databind.JavaType r5 = r7._valueType     // Catch:{ Throwable -> 0x0064 }
            r7._verifyNoTrailingTokens(r0, r2, r5)     // Catch:{ Throwable -> 0x0064 }
        L_0x005b:
            if (r0 == 0) goto L_0x0061
            r0.close()
        L_0x0061:
            return r4
        L_0x0062:
            r2 = move-exception
            goto L_0x0066
        L_0x0064:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0062 }
        L_0x0066:
            if (r0 == 0) goto L_0x0073
            if (r1 == 0) goto L_0x0070
            r0.close()     // Catch:{ Throwable -> 0x006e }
            goto L_0x0073
        L_0x006e:
            r1 = move-exception
            goto L_0x0073
        L_0x0070:
            r0.close()
        L_0x0073:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectReader._bindAndClose(com.fasterxml.jackson.core.JsonParser):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object _unwrapAndDeserialize(JsonParser p, DeserializationContext ctxt, JavaType rootType, JsonDeserializer<Object> deser) throws IOException {
        Object result;
        String expSimpleName = this._config.findRootName(rootType).getSimpleName();
        JsonToken currentToken = p.getCurrentToken();
        JsonToken jsonToken = JsonToken.START_OBJECT;
        if (currentToken == jsonToken) {
            JsonToken nextToken = p.nextToken();
            JsonToken jsonToken2 = JsonToken.FIELD_NAME;
            if (nextToken == jsonToken2) {
                String actualName = p.getCurrentName();
                if (expSimpleName.equals(actualName)) {
                    p.nextToken();
                    Object result2 = this._valueToUpdate;
                    if (result2 == null) {
                        result = deser.deserialize(p, ctxt);
                    } else {
                        deser.deserialize(p, ctxt, result2);
                        result = this._valueToUpdate;
                    }
                    JsonToken nextToken2 = p.nextToken();
                    JsonToken jsonToken3 = JsonToken.END_OBJECT;
                    if (nextToken2 == jsonToken3) {
                        if (this._config.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
                            _verifyNoTrailingTokens(p, ctxt, this._valueType);
                        }
                        return result;
                    }
                    ctxt.reportWrongTokenException(rootType, jsonToken3, "Current token not END_OBJECT (to match wrapper object with root name '%s'), but %s", expSimpleName, p.getCurrentToken());
                    throw null;
                }
                ctxt.reportInputMismatch(rootType, "Root name '%s' does not match expected ('%s') for type %s", actualName, expSimpleName, rootType);
                throw null;
            }
            ctxt.reportWrongTokenException(rootType, jsonToken2, "Current token not FIELD_NAME (to contain expected root name '%s'), but %s", expSimpleName, p.getCurrentToken());
            throw null;
        }
        ctxt.reportWrongTokenException(rootType, jsonToken, "Current token not START_OBJECT (needed to unwrap root name '%s'), but %s", expSimpleName, p.getCurrentToken());
        throw null;
    }

    /* access modifiers changed from: protected */
    public JsonParser _considerFilter(JsonParser p, boolean multiValue) {
        return (this._filter == null || FilteringParserDelegate.class.isInstance(p)) ? p : new FilteringParserDelegate(p, this._filter, false, multiValue);
    }

    /* access modifiers changed from: protected */
    public final void _verifyNoTrailingTokens(JsonParser p, DeserializationContext ctxt, JavaType bindType) throws IOException {
        JsonToken t = p.nextToken();
        if (t != null) {
            Class<?> bt = ClassUtil.rawClass(bindType);
            if (bt == null) {
                Object obj = this._valueToUpdate;
                if (obj != null) {
                    bt = obj.getClass();
                }
            }
            ctxt.reportTrailingTokens(bt, p, t);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public DefaultDeserializationContext createDeserializationContext(JsonParser p) {
        return this._context.createInstance(this._config, p, this._injectableValues);
    }

    /* access modifiers changed from: protected */
    public void _reportUndetectableSource(Object src) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot use source of type ");
        sb.append(src.getClass().getName());
        sb.append(" with format auto-detection: must be byte- not char-based");
        throw new JsonParseException(null, sb.toString());
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findRootDeserializer(DeserializationContext ctxt) throws JsonMappingException {
        JsonDeserializer<Object> jsonDeserializer = this._rootDeserializer;
        if (jsonDeserializer != null) {
            return jsonDeserializer;
        }
        JavaType t = this._valueType;
        if (t != null) {
            JsonDeserializer<Object> deser = (JsonDeserializer) this._rootDeserializers.get(t);
            if (deser != null) {
                return deser;
            }
            JsonDeserializer<Object> deser2 = ctxt.findRootValueDeserializer(t);
            if (deser2 != null) {
                this._rootDeserializers.put(t, deser2);
                return deser2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find a deserializer for type ");
            sb.append(t);
            ctxt.reportBadDefinition(t, sb.toString());
            throw null;
        }
        ctxt.reportBadDefinition(null, "No value type configured for ObjectReader");
        throw null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _prefetchRootDeserializer(JavaType valueType) {
        if (valueType == null || !this._config.isEnabled(DeserializationFeature.EAGER_DESERIALIZER_FETCH)) {
            return null;
        }
        JsonDeserializer<Object> deser = (JsonDeserializer) this._rootDeserializers.get(valueType);
        if (deser == null) {
            try {
                JsonDeserializer findRootValueDeserializer = createDeserializationContext(null).findRootValueDeserializer(valueType);
                if (findRootValueDeserializer != null) {
                    this._rootDeserializers.put(valueType, findRootValueDeserializer);
                }
                return findRootValueDeserializer;
            } catch (JsonProcessingException e) {
            }
        }
        return deser;
    }
}
