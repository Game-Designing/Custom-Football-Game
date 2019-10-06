package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JacksonStdImpl
public class UntypedObjectDeserializer extends StdDeserializer<Object> implements ResolvableDeserializer, ContextualDeserializer {
    protected static final Object[] NO_OBJECTS = new Object[0];
    protected JsonDeserializer<Object> _listDeserializer;
    protected JavaType _listType;
    protected JsonDeserializer<Object> _mapDeserializer;
    protected JavaType _mapType;
    protected final boolean _nonMerging;
    protected JsonDeserializer<Object> _numberDeserializer;
    protected JsonDeserializer<Object> _stringDeserializer;

    @JacksonStdImpl
    public static class Vanilla extends StdDeserializer<Object> {
        public static final Vanilla std = new Vanilla();
        protected final boolean _nonMerging;

        public Vanilla() {
            this(false);
        }

        protected Vanilla(boolean nonMerging) {
            super(Object.class);
            this._nonMerging = nonMerging;
        }

        public static Vanilla instance(boolean nonMerging) {
            if (nonMerging) {
                return new Vanilla(true);
            }
            return std;
        }

        public Boolean supportsUpdate(DeserializationConfig config) {
            if (this._nonMerging) {
                return Boolean.FALSE;
            }
            return null;
        }

        public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            switch (p.getCurrentTokenId()) {
                case 1:
                    if (p.nextToken() == JsonToken.END_OBJECT) {
                        return new LinkedHashMap(2);
                    }
                    break;
                case 2:
                    return new LinkedHashMap(2);
                case 3:
                    if (p.nextToken() == JsonToken.END_ARRAY) {
                        if (ctxt.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                            return UntypedObjectDeserializer.NO_OBJECTS;
                        }
                        return new ArrayList(2);
                    } else if (ctxt.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                        return mapArrayToArray(p, ctxt);
                    } else {
                        return mapArray(p, ctxt);
                    }
                case 5:
                    break;
                case 6:
                    return p.getText();
                case 7:
                    if (ctxt.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS)) {
                        return _coerceIntegral(p, ctxt);
                    }
                    return p.getNumberValue();
                case 8:
                    if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return p.getDecimalValue();
                    }
                    return p.getNumberValue();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return p.getEmbeddedObject();
                default:
                    return ctxt.handleUnexpectedToken(Object.class, p);
            }
            return mapObject(p, ctxt);
        }

        public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
            int currentTokenId = p.getCurrentTokenId();
            if (!(currentTokenId == 1 || currentTokenId == 3)) {
                switch (currentTokenId) {
                    case 5:
                        break;
                    case 6:
                        return p.getText();
                    case 7:
                        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                            return p.getBigIntegerValue();
                        }
                        return p.getNumberValue();
                    case 8:
                        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                            return p.getDecimalValue();
                        }
                        return p.getNumberValue();
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    case 12:
                        return p.getEmbeddedObject();
                    default:
                        return ctxt.handleUnexpectedToken(Object.class, p);
                }
            }
            return typeDeserializer.deserializeTypedFromAny(p, ctxt);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            if (r0 != 5) goto L_0x0071;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object deserialize(com.fasterxml.jackson.core.JsonParser r5, com.fasterxml.jackson.databind.DeserializationContext r6, java.lang.Object r7) throws java.io.IOException {
            /*
                r4 = this;
                boolean r0 = r4._nonMerging
                if (r0 == 0) goto L_0x0009
                java.lang.Object r0 = r4.deserialize(r5, r6)
                return r0
            L_0x0009:
                int r0 = r5.getCurrentTokenId()
                r1 = 1
                if (r0 == r1) goto L_0x003e
                r1 = 2
                if (r0 == r1) goto L_0x003d
                r1 = 3
                if (r0 == r1) goto L_0x001d
                r1 = 4
                if (r0 == r1) goto L_0x003d
                r1 = 5
                if (r0 == r1) goto L_0x0047
                goto L_0x0071
            L_0x001d:
                com.fasterxml.jackson.core.JsonToken r0 = r5.nextToken()
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_ARRAY
                if (r0 != r1) goto L_0x0026
                return r7
            L_0x0026:
                boolean r0 = r7 instanceof java.util.Collection
                if (r0 == 0) goto L_0x0071
                r0 = r7
                java.util.Collection r0 = (java.util.Collection) r0
            L_0x002d:
                java.lang.Object r1 = r4.deserialize(r5, r6)
                r0.add(r1)
                com.fasterxml.jackson.core.JsonToken r1 = r5.nextToken()
                com.fasterxml.jackson.core.JsonToken r2 = com.fasterxml.jackson.core.JsonToken.END_ARRAY
                if (r1 != r2) goto L_0x002d
                return r7
            L_0x003d:
                return r7
            L_0x003e:
                com.fasterxml.jackson.core.JsonToken r0 = r5.nextToken()
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_OBJECT
                if (r0 != r1) goto L_0x0047
                return r7
            L_0x0047:
                boolean r0 = r7 instanceof java.util.Map
                if (r0 == 0) goto L_0x0071
                r0 = r7
                java.util.Map r0 = (java.util.Map) r0
                java.lang.String r1 = r5.getCurrentName()
            L_0x0052:
                r5.nextToken()
                java.lang.Object r2 = r0.get(r1)
                if (r2 == 0) goto L_0x0060
                java.lang.Object r3 = r4.deserialize(r5, r6, r2)
                goto L_0x0064
            L_0x0060:
                java.lang.Object r3 = r4.deserialize(r5, r6)
            L_0x0064:
                if (r3 == r2) goto L_0x0069
                r0.put(r1, r3)
            L_0x0069:
                java.lang.String r2 = r5.nextFieldName()
                r1 = r2
                if (r2 != 0) goto L_0x0052
                return r7
            L_0x0071:
                java.lang.Object r0 = r4.deserialize(r5, r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.Object):java.lang.Object");
        }

        /* access modifiers changed from: protected */
        public Object mapArray(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = deserialize(p, ctxt);
            if (p.nextToken() == JsonToken.END_ARRAY) {
                ArrayList<Object> l = new ArrayList<>(2);
                l.add(value);
                return l;
            }
            Object value2 = deserialize(p, ctxt);
            if (p.nextToken() == JsonToken.END_ARRAY) {
                ArrayList<Object> l2 = new ArrayList<>(2);
                l2.add(value);
                l2.add(value2);
                return l2;
            }
            ObjectBuffer buffer = ctxt.leaseObjectBuffer();
            Object[] values = buffer.resetAndStart();
            int ptr = 0 + 1;
            values[0] = value;
            int ptr2 = ptr + 1;
            values[ptr] = value2;
            int totalSize = ptr2;
            while (true) {
                Object value3 = deserialize(p, ctxt);
                totalSize++;
                if (ptr2 >= values.length) {
                    values = buffer.appendCompletedChunk(values);
                    ptr2 = 0;
                }
                int ptr3 = ptr2 + 1;
                values[ptr2] = value3;
                if (p.nextToken() == JsonToken.END_ARRAY) {
                    ArrayList<Object> result = new ArrayList<>(totalSize);
                    buffer.completeAndClearBuffer(values, ptr3, (List<Object>) result);
                    return result;
                }
                ptr2 = ptr3;
            }
        }

        /* access modifiers changed from: protected */
        public Object[] mapArrayToArray(JsonParser p, DeserializationContext ctxt) throws IOException {
            ObjectBuffer buffer = ctxt.leaseObjectBuffer();
            Object[] values = buffer.resetAndStart();
            int ptr = 0;
            while (true) {
                Object value = deserialize(p, ctxt);
                if (ptr >= values.length) {
                    values = buffer.appendCompletedChunk(values);
                    ptr = 0;
                }
                int ptr2 = ptr + 1;
                values[ptr] = value;
                if (p.nextToken() == JsonToken.END_ARRAY) {
                    return buffer.completeAndClearBuffer(values, ptr2);
                }
                ptr = ptr2;
            }
        }

        /* access modifiers changed from: protected */
        public Object mapObject(JsonParser p, DeserializationContext ctxt) throws IOException {
            String nextFieldName;
            String key1 = p.getText();
            p.nextToken();
            Object value1 = deserialize(p, ctxt);
            String key2 = p.nextFieldName();
            if (key2 == null) {
                LinkedHashMap<String, Object> result = new LinkedHashMap<>(2);
                result.put(key1, value1);
                return result;
            }
            p.nextToken();
            Object value2 = deserialize(p, ctxt);
            String key = p.nextFieldName();
            if (key == null) {
                LinkedHashMap<String, Object> result2 = new LinkedHashMap<>(4);
                result2.put(key1, value1);
                result2.put(key2, value2);
                return result2;
            }
            LinkedHashMap<String, Object> result3 = new LinkedHashMap<>();
            result3.put(key1, value1);
            result3.put(key2, value2);
            do {
                p.nextToken();
                result3.put(key, deserialize(p, ctxt));
                nextFieldName = p.nextFieldName();
                key = nextFieldName;
            } while (nextFieldName != null);
            return result3;
        }
    }

    @Deprecated
    public UntypedObjectDeserializer() {
        this((JavaType) null, (JavaType) null);
    }

    public UntypedObjectDeserializer(JavaType listType, JavaType mapType) {
        super(Object.class);
        this._listType = listType;
        this._mapType = mapType;
        this._nonMerging = false;
    }

    protected UntypedObjectDeserializer(UntypedObjectDeserializer base, boolean nonMerging) {
        super(Object.class);
        this._mapDeserializer = base._mapDeserializer;
        this._listDeserializer = base._listDeserializer;
        this._stringDeserializer = base._stringDeserializer;
        this._numberDeserializer = base._numberDeserializer;
        this._listType = base._listType;
        this._mapType = base._mapType;
        this._nonMerging = nonMerging;
    }

    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        JavaType obType = ctxt.constructType(Object.class);
        JavaType stringType = ctxt.constructType(String.class);
        TypeFactory tf = ctxt.getTypeFactory();
        JavaType javaType = this._listType;
        if (javaType == null) {
            this._listDeserializer = _clearIfStdImpl(_findCustomDeser(ctxt, tf.constructCollectionType(List.class, obType)));
        } else {
            this._listDeserializer = _findCustomDeser(ctxt, javaType);
        }
        JavaType javaType2 = this._mapType;
        if (javaType2 == null) {
            this._mapDeserializer = _clearIfStdImpl(_findCustomDeser(ctxt, tf.constructMapType(Map.class, stringType, obType)));
        } else {
            this._mapDeserializer = _findCustomDeser(ctxt, javaType2);
        }
        this._stringDeserializer = _clearIfStdImpl(_findCustomDeser(ctxt, stringType));
        this._numberDeserializer = _clearIfStdImpl(_findCustomDeser(ctxt, tf.constructType((Type) Number.class)));
        JavaType unknown = TypeFactory.unknownType();
        this._mapDeserializer = ctxt.handleSecondaryContextualization(this._mapDeserializer, null, unknown);
        this._listDeserializer = ctxt.handleSecondaryContextualization(this._listDeserializer, null, unknown);
        this._stringDeserializer = ctxt.handleSecondaryContextualization(this._stringDeserializer, null, unknown);
        this._numberDeserializer = ctxt.handleSecondaryContextualization(this._numberDeserializer, null, unknown);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findCustomDeser(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        return ctxt.findNonContextualValueDeserializer(type);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _clearIfStdImpl(JsonDeserializer<Object> deser) {
        if (ClassUtil.isJacksonStdImpl((Object) deser)) {
            return null;
        }
        return deser;
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        boolean preventMerge = property == null && Boolean.FALSE.equals(ctxt.getConfig().getDefaultMergeable(Object.class));
        if (this._stringDeserializer == null && this._numberDeserializer == null && this._mapDeserializer == null && this._listDeserializer == null && getClass() == UntypedObjectDeserializer.class) {
            return Vanilla.instance(preventMerge);
        }
        if (preventMerge != this._nonMerging) {
            return new UntypedObjectDeserializer(this, preventMerge);
        }
        return this;
    }

    public boolean isCachable() {
        return true;
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return null;
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        switch (p.getCurrentTokenId()) {
            case 1:
            case 2:
            case 5:
                JsonDeserializer<Object> jsonDeserializer = this._mapDeserializer;
                if (jsonDeserializer != null) {
                    return jsonDeserializer.deserialize(p, ctxt);
                }
                return mapObject(p, ctxt);
            case 3:
                if (ctxt.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(p, ctxt);
                }
                JsonDeserializer<Object> jsonDeserializer2 = this._listDeserializer;
                if (jsonDeserializer2 != null) {
                    return jsonDeserializer2.deserialize(p, ctxt);
                }
                return mapArray(p, ctxt);
            case 6:
                JsonDeserializer<Object> jsonDeserializer3 = this._stringDeserializer;
                if (jsonDeserializer3 != null) {
                    return jsonDeserializer3.deserialize(p, ctxt);
                }
                return p.getText();
            case 7:
                JsonDeserializer<Object> jsonDeserializer4 = this._numberDeserializer;
                if (jsonDeserializer4 != null) {
                    return jsonDeserializer4.deserialize(p, ctxt);
                }
                if (ctxt.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(p, ctxt);
                }
                return p.getNumberValue();
            case 8:
                JsonDeserializer<Object> jsonDeserializer5 = this._numberDeserializer;
                if (jsonDeserializer5 != null) {
                    return jsonDeserializer5.deserialize(p, ctxt);
                }
                if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return p.getDecimalValue();
                }
                return p.getNumberValue();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return p.getEmbeddedObject();
            default:
                return ctxt.handleUnexpectedToken(Object.class, p);
        }
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        int currentTokenId = p.getCurrentTokenId();
        if (!(currentTokenId == 1 || currentTokenId == 3)) {
            switch (currentTokenId) {
                case 5:
                    break;
                case 6:
                    JsonDeserializer<Object> jsonDeserializer = this._stringDeserializer;
                    if (jsonDeserializer != null) {
                        return jsonDeserializer.deserialize(p, ctxt);
                    }
                    return p.getText();
                case 7:
                    JsonDeserializer<Object> jsonDeserializer2 = this._numberDeserializer;
                    if (jsonDeserializer2 != null) {
                        return jsonDeserializer2.deserialize(p, ctxt);
                    }
                    if (ctxt.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS)) {
                        return _coerceIntegral(p, ctxt);
                    }
                    return p.getNumberValue();
                case 8:
                    JsonDeserializer<Object> jsonDeserializer3 = this._numberDeserializer;
                    if (jsonDeserializer3 != null) {
                        return jsonDeserializer3.deserialize(p, ctxt);
                    }
                    if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return p.getDecimalValue();
                    }
                    return p.getNumberValue();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return p.getEmbeddedObject();
                default:
                    return ctxt.handleUnexpectedToken(Object.class, p);
            }
        }
        return typeDeserializer.deserializeTypedFromAny(p, ctxt);
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt, Object intoValue) throws IOException {
        if (this._nonMerging) {
            return deserialize(p, ctxt);
        }
        switch (p.getCurrentTokenId()) {
            case 1:
            case 2:
            case 5:
                JsonDeserializer<Object> jsonDeserializer = this._mapDeserializer;
                if (jsonDeserializer != null) {
                    return jsonDeserializer.deserialize(p, ctxt, intoValue);
                }
                if (!(intoValue instanceof Map)) {
                    return mapObject(p, ctxt);
                }
                Map map = (Map) intoValue;
                mapObject(p, ctxt, map);
                return map;
            case 3:
                JsonDeserializer<Object> jsonDeserializer2 = this._listDeserializer;
                if (jsonDeserializer2 != null) {
                    return jsonDeserializer2.deserialize(p, ctxt, intoValue);
                }
                if (intoValue instanceof Collection) {
                    Collection collection = (Collection) intoValue;
                    mapArray(p, ctxt, collection);
                    return collection;
                } else if (ctxt.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(p, ctxt);
                } else {
                    return mapArray(p, ctxt);
                }
            case 6:
                JsonDeserializer<Object> jsonDeserializer3 = this._stringDeserializer;
                if (jsonDeserializer3 != null) {
                    return jsonDeserializer3.deserialize(p, ctxt, intoValue);
                }
                return p.getText();
            case 7:
                JsonDeserializer<Object> jsonDeserializer4 = this._numberDeserializer;
                if (jsonDeserializer4 != null) {
                    return jsonDeserializer4.deserialize(p, ctxt, intoValue);
                }
                if (ctxt.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(p, ctxt);
                }
                return p.getNumberValue();
            case 8:
                JsonDeserializer<Object> jsonDeserializer5 = this._numberDeserializer;
                if (jsonDeserializer5 != null) {
                    return jsonDeserializer5.deserialize(p, ctxt, intoValue);
                }
                if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return p.getDecimalValue();
                }
                return p.getNumberValue();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return p.getEmbeddedObject();
            default:
                return deserialize(p, ctxt);
        }
    }

    /* access modifiers changed from: protected */
    public Object mapArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.nextToken() == JsonToken.END_ARRAY) {
            return new ArrayList(2);
        }
        Object value = deserialize(p, ctxt);
        if (p.nextToken() == JsonToken.END_ARRAY) {
            ArrayList<Object> l = new ArrayList<>(2);
            l.add(value);
            return l;
        }
        Object value2 = deserialize(p, ctxt);
        if (p.nextToken() == JsonToken.END_ARRAY) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(value);
            arrayList.add(value2);
            return arrayList;
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        Object[] values = buffer.resetAndStart();
        int ptr = 0 + 1;
        values[0] = value;
        int ptr2 = ptr + 1;
        values[ptr] = value2;
        int totalSize = ptr2;
        while (true) {
            Object value3 = deserialize(p, ctxt);
            totalSize++;
            if (ptr2 >= values.length) {
                values = buffer.appendCompletedChunk(values);
                ptr2 = 0;
            }
            int ptr3 = ptr2 + 1;
            values[ptr2] = value3;
            if (p.nextToken() == JsonToken.END_ARRAY) {
                ArrayList<Object> result = new ArrayList<>(totalSize);
                buffer.completeAndClearBuffer(values, ptr3, (List<Object>) result);
                return result;
            }
            ptr2 = ptr3;
        }
    }

    /* access modifiers changed from: protected */
    public Object mapArray(JsonParser p, DeserializationContext ctxt, Collection<Object> result) throws IOException {
        while (p.nextToken() != JsonToken.END_ARRAY) {
            result.add(deserialize(p, ctxt));
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public Object mapObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        String key1;
        String nextFieldName;
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT) {
            key1 = p.nextFieldName();
        } else if (t == JsonToken.FIELD_NAME) {
            key1 = p.getCurrentName();
        } else if (t != JsonToken.END_OBJECT) {
            return ctxt.handleUnexpectedToken(handledType(), p);
        } else {
            key1 = null;
        }
        if (key1 == null) {
            return new LinkedHashMap(2);
        }
        p.nextToken();
        Object value1 = deserialize(p, ctxt);
        String key2 = p.nextFieldName();
        if (key2 == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put(key1, value1);
            return linkedHashMap;
        }
        p.nextToken();
        Object value2 = deserialize(p, ctxt);
        String key = p.nextFieldName();
        if (key == null) {
            LinkedHashMap<String, Object> result = new LinkedHashMap<>(4);
            result.put(key1, value1);
            result.put(key2, value2);
            return result;
        }
        LinkedHashMap<String, Object> result2 = new LinkedHashMap<>();
        result2.put(key1, value1);
        result2.put(key2, value2);
        do {
            p.nextToken();
            result2.put(key, deserialize(p, ctxt));
            nextFieldName = p.nextFieldName();
            key = nextFieldName;
        } while (nextFieldName != null);
        return result2;
    }

    /* access modifiers changed from: protected */
    public Object[] mapArrayToArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.nextToken() == JsonToken.END_ARRAY) {
            return NO_OBJECTS;
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        Object[] values = buffer.resetAndStart();
        int ptr = 0;
        while (true) {
            Object value = deserialize(p, ctxt);
            if (ptr >= values.length) {
                values = buffer.appendCompletedChunk(values);
                ptr = 0;
            }
            int ptr2 = ptr + 1;
            values[ptr] = value;
            if (p.nextToken() == JsonToken.END_ARRAY) {
                return buffer.completeAndClearBuffer(values, ptr2);
            }
            ptr = ptr2;
        }
    }

    /* access modifiers changed from: protected */
    public Object mapObject(JsonParser p, DeserializationContext ctxt, Map<Object, Object> m) throws IOException {
        Object newV;
        String nextFieldName;
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT) {
            t = p.nextToken();
        }
        if (t == JsonToken.END_OBJECT) {
            return m;
        }
        String key = p.getCurrentName();
        do {
            p.nextToken();
            Object old = m.get(key);
            if (old != null) {
                newV = deserialize(p, ctxt, old);
            } else {
                newV = deserialize(p, ctxt);
            }
            if (newV != old) {
                m.put(key, newV);
            }
            nextFieldName = p.nextFieldName();
            key = nextFieldName;
        } while (nextFieldName != null);
        return m;
    }
}
