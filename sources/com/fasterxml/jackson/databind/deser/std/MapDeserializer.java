package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties.Value;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JacksonStdImpl
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements ContextualDeserializer, ResolvableDeserializer {
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected Set<String> _ignorableProperties;
    protected final KeyDeserializer _keyDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    static class MapReferring extends Referring {
        private final MapReferringAccumulator _parent;
        public final Object key;
        public final Map<Object, Object> next = new LinkedHashMap();

        MapReferring(MapReferringAccumulator parent, UnresolvedForwardReference ref, Class<?> valueType, Object key2) {
            super(ref, valueType);
            this._parent = parent;
            this.key = key2;
        }

        public void handleResolvedForwardReference(Object id, Object value) throws IOException {
            this._parent.resolveForwardReference(id, value);
        }
    }

    private static final class MapReferringAccumulator {
        private List<MapReferring> _accumulator = new ArrayList();
        private Map<Object, Object> _result;
        private final Class<?> _valueType;

        public MapReferringAccumulator(Class<?> valueType, Map<Object, Object> result) {
            this._valueType = valueType;
            this._result = result;
        }

        public void put(Object key, Object value) {
            if (this._accumulator.isEmpty()) {
                this._result.put(key, value);
                return;
            }
            List<MapReferring> list = this._accumulator;
            ((MapReferring) list.get(list.size() - 1)).next.put(key, value);
        }

        public Referring handleUnresolvedReference(UnresolvedForwardReference reference, Object key) {
            MapReferring id = new MapReferring(this, reference, this._valueType, key);
            this._accumulator.add(id);
            return id;
        }

        public void resolveForwardReference(Object id, Object value) throws IOException {
            Iterator<MapReferring> iterator = this._accumulator.iterator();
            Map<Object, Object> previous = this._result;
            while (iterator.hasNext()) {
                MapReferring ref = (MapReferring) iterator.next();
                if (ref.hasId(id)) {
                    iterator.remove();
                    previous.put(ref.key, value);
                    previous.putAll(ref.next);
                    return;
                }
                previous = ref.next;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to resolve a forward reference with id [");
            sb.append(id);
            sb.append("] that wasn't previously seen as unresolved.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public MapDeserializer(JavaType mapType, ValueInstantiator valueInstantiator, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser) {
        super(mapType, (NullValueProvider) null, (Boolean) null);
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = valueTypeDeser;
        this._valueInstantiator = valueInstantiator;
        this._hasDefaultCreator = valueInstantiator.canCreateUsingDefault();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = _isStdKeyDeser(mapType, keyDeser);
    }

    protected MapDeserializer(MapDeserializer src, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, NullValueProvider nuller, Set<String> ignorable) {
        super((ContainerDeserializerBase<?>) src, nuller, src._unwrapSingle);
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = valueTypeDeser;
        this._valueInstantiator = src._valueInstantiator;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._hasDefaultCreator = src._hasDefaultCreator;
        this._ignorableProperties = ignorable;
        this._standardStringKey = _isStdKeyDeser(this._containerType, keyDeser);
    }

    /* access modifiers changed from: protected */
    public MapDeserializer withResolved(KeyDeserializer keyDeser, TypeDeserializer valueTypeDeser, JsonDeserializer<?> valueDeser, NullValueProvider nuller, Set<String> ignorable) {
        if (this._keyDeserializer == keyDeser && this._valueDeserializer == valueDeser && this._valueTypeDeserializer == valueTypeDeser && this._nullProvider == nuller && this._ignorableProperties == ignorable) {
            return this;
        }
        MapDeserializer mapDeserializer = new MapDeserializer(this, keyDeser, valueDeser, valueTypeDeser, nuller, ignorable);
        return mapDeserializer;
    }

    /* access modifiers changed from: protected */
    public final boolean _isStdKeyDeser(JavaType mapType, KeyDeserializer keyDeser) {
        boolean z = true;
        if (keyDeser == null) {
            return true;
        }
        JavaType keyType = mapType.getKeyType();
        if (keyType == null) {
            return true;
        }
        Class<?> rawKeyType = keyType.getRawClass();
        if (!(rawKeyType == String.class || rawKeyType == Object.class) || !isDefaultKeyDeserializer(keyDeser)) {
            z = false;
        }
        return z;
    }

    public void setIgnorableProperties(Set<String> ignorable) {
        this._ignorableProperties = (ignorable == null || ignorable.size() == 0) ? null : ignorable;
    }

    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(ctxt.getConfig());
            if (delegateType != null) {
                this._delegateDeserializer = findDeserializer(ctxt, delegateType, null);
            } else {
                JavaType javaType = this._containerType;
                ctxt.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{javaType, this._valueInstantiator.getClass().getName()}));
                throw null;
            }
        } else if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType delegateType2 = this._valueInstantiator.getArrayDelegateType(ctxt.getConfig());
            if (delegateType2 != null) {
                this._delegateDeserializer = findDeserializer(ctxt, delegateType2, null);
            } else {
                JavaType delegateType3 = this._containerType;
                ctxt.reportBadDefinition(delegateType3, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{delegateType3, this._valueInstantiator.getClass().getName()}));
                throw null;
            }
        }
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            this._propertyBasedCreator = PropertyBasedCreator.construct(ctxt, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(ctxt.getConfig()), ctxt.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this._standardStringKey = _isStdKeyDeser(this._containerType, this._keyDeserializer);
    }

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> valueDeser;
        TypeDeserializer vtd;
        Set<String> ignored;
        KeyDeserializer keyDeser = this._keyDeserializer;
        if (keyDeser == null) {
            keyDeser = ctxt.findKeyDeserializer(this._containerType.getKeyType(), property);
        } else if (keyDeser instanceof ContextualKeyDeserializer) {
            keyDeser = ((ContextualKeyDeserializer) keyDeser).createContextual(ctxt, property);
        }
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        if (property != null) {
            jsonDeserializer = findConvertingContentDeserializer(ctxt, property, jsonDeserializer);
        }
        JavaType vt = this._containerType.getContentType();
        if (jsonDeserializer == null) {
            valueDeser = ctxt.findContextualValueDeserializer(vt, property);
        } else {
            valueDeser = ctxt.handleSecondaryContextualization(jsonDeserializer, property, vt);
        }
        TypeDeserializer vtd2 = this._valueTypeDeserializer;
        if (vtd2 != null) {
            vtd = vtd2.forProperty(property);
        } else {
            vtd = vtd2;
        }
        Set<String> ignored2 = this._ignorableProperties;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (StdDeserializer._neitherNull(intr, property)) {
            AnnotatedMember member = property.getMember();
            if (member != null) {
                Value ignorals = intr.findPropertyIgnorals(member);
                if (ignorals != null) {
                    Set<String> ignoresToAdd = ignorals.findIgnoredForDeserialization();
                    if (!ignoresToAdd.isEmpty()) {
                        Set<String> ignored3 = ignored2 == null ? new HashSet() : new HashSet(ignored2);
                        for (String str : ignoresToAdd) {
                            ignored3.add(str);
                        }
                        ignored = ignored3;
                        return withResolved(keyDeser, vtd, valueDeser, findContentNullProvider(ctxt, property, valueDeser), ignored);
                    }
                }
            }
        }
        ignored = ignored2;
        return withResolved(keyDeser, vtd, valueDeser, findContentNullProvider(ctxt, property, valueDeser), ignored);
    }

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null && this._ignorableProperties == null;
    }

    public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(p, ctxt);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return (Map) this._valueInstantiator.createUsingDelegate(ctxt, jsonDeserializer.deserialize(p, ctxt));
        }
        if (!this._hasDefaultCreator) {
            return (Map) ctxt.handleMissingInstantiator(getMapClass(), getValueInstantiator(), p, "no default constructor found", new Object[0]);
        }
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT || t == JsonToken.FIELD_NAME || t == JsonToken.END_OBJECT) {
            Map<Object, Object> result = (Map) this._valueInstantiator.createUsingDefault(ctxt);
            if (this._standardStringKey) {
                _readAndBindStringKeyMap(p, ctxt, result);
                return result;
            }
            _readAndBind(p, ctxt, result);
            return result;
        } else if (t == JsonToken.VALUE_STRING) {
            return (Map) this._valueInstantiator.createFromString(ctxt, p.getText());
        } else {
            return (Map) _deserializeFromEmpty(p, ctxt);
        }
    }

    public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        p.setCurrentValue(result);
        JsonToken t = p.getCurrentToken();
        if (t != JsonToken.START_OBJECT && t != JsonToken.FIELD_NAME) {
            return (Map) ctxt.handleUnexpectedToken(getMapClass(), p);
        }
        if (this._standardStringKey) {
            _readAndUpdateStringKeyMap(p, ctxt, result);
            return result;
        }
        _readAndUpdate(p, ctxt, result);
        return result;
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }

    public final Class<?> getMapClass() {
        return this._containerType.getRawClass();
    }

    public JavaType getValueType() {
        return this._containerType;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007f, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
        wrapAndThrow(r11, r13, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0083, code lost:
        throw null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f A[ExcHandler: Exception (r11v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:21:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void _readAndBind(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12, java.util.Map<java.lang.Object, java.lang.Object> r13) throws java.io.IOException {
        /*
            r10 = this;
            com.fasterxml.jackson.databind.KeyDeserializer r0 = r10._keyDeserializer
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> r1 = r10._valueDeserializer
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r2 = r10._valueTypeDeserializer
            r3 = 0
            com.fasterxml.jackson.databind.deser.impl.ObjectIdReader r4 = r1.getObjectIdReader()
            r5 = 0
            if (r4 == 0) goto L_0x0010
            r4 = 1
            goto L_0x0011
        L_0x0010:
            r4 = 0
        L_0x0011:
            if (r4 == 0) goto L_0x0023
            com.fasterxml.jackson.databind.deser.std.MapDeserializer$MapReferringAccumulator r6 = new com.fasterxml.jackson.databind.deser.std.MapDeserializer$MapReferringAccumulator
            com.fasterxml.jackson.databind.JavaType r7 = r10._containerType
            com.fasterxml.jackson.databind.JavaType r7 = r7.getContentType()
            java.lang.Class r7 = r7.getRawClass()
            r6.<init>(r7, r13)
            r3 = r6
        L_0x0023:
            boolean r6 = r11.isExpectedStartObjectToken()
            r7 = 0
            if (r6 == 0) goto L_0x002f
            java.lang.String r5 = r11.nextFieldName()
            goto L_0x0040
        L_0x002f:
            com.fasterxml.jackson.core.JsonToken r6 = r11.getCurrentToken()
            com.fasterxml.jackson.core.JsonToken r8 = com.fasterxml.jackson.core.JsonToken.END_OBJECT
            if (r6 != r8) goto L_0x0038
            return
        L_0x0038:
            com.fasterxml.jackson.core.JsonToken r8 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            if (r6 != r8) goto L_0x008f
            java.lang.String r5 = r11.getCurrentName()
        L_0x0040:
            if (r5 == 0) goto L_0x008e
            java.lang.Object r6 = r0.deserializeKey(r5, r12)
            com.fasterxml.jackson.core.JsonToken r8 = r11.nextToken()
            java.util.Set<java.lang.String> r9 = r10._ignorableProperties
            if (r9 == 0) goto L_0x0058
            boolean r9 = r9.contains(r5)
            if (r9 == 0) goto L_0x0058
            r11.skipChildren()
            goto L_0x0089
        L_0x0058:
            com.fasterxml.jackson.core.JsonToken r9 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL     // Catch:{ UnresolvedForwardReference -> 0x0084, Exception -> 0x007f }
            if (r8 != r9) goto L_0x006a
            boolean r9 = r10._skipNullValues     // Catch:{ UnresolvedForwardReference -> 0x0068, Exception -> 0x007f }
            if (r9 == 0) goto L_0x0061
            goto L_0x0089
        L_0x0061:
            com.fasterxml.jackson.databind.deser.NullValueProvider r9 = r10._nullProvider     // Catch:{ UnresolvedForwardReference -> 0x0068, Exception -> 0x007f }
            java.lang.Object r9 = r9.getNullValue(r12)     // Catch:{ UnresolvedForwardReference -> 0x0068, Exception -> 0x007f }
            goto L_0x0075
        L_0x0068:
            r9 = move-exception
            goto L_0x0085
        L_0x006a:
            if (r2 != 0) goto L_0x0071
            java.lang.Object r9 = r1.deserialize(r11, r12)     // Catch:{ UnresolvedForwardReference -> 0x0068, Exception -> 0x007f }
            goto L_0x0075
        L_0x0071:
            java.lang.Object r9 = r1.deserializeWithType(r11, r12, r2)     // Catch:{ UnresolvedForwardReference -> 0x0068, Exception -> 0x007f }
        L_0x0075:
            if (r4 == 0) goto L_0x007b
            r3.put(r6, r9)     // Catch:{ UnresolvedForwardReference -> 0x0068, Exception -> 0x007f }
            goto L_0x007e
        L_0x007b:
            r13.put(r6, r9)     // Catch:{ UnresolvedForwardReference -> 0x0068, Exception -> 0x007f }
        L_0x007e:
            goto L_0x0089
        L_0x007f:
            r11 = move-exception
            r10.wrapAndThrow(r11, r13, r5)
            throw r7
        L_0x0084:
            r9 = move-exception
        L_0x0085:
            r10.handleUnresolvedReference(r12, r3, r6, r9)
        L_0x0089:
            java.lang.String r5 = r11.nextFieldName()
            goto L_0x0040
        L_0x008e:
            return
        L_0x008f:
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r12.reportWrongTokenException(r10, r8, r7, r11)
            goto L_0x0096
        L_0x0095:
            throw r7
        L_0x0096:
            goto L_0x0095
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.MapDeserializer._readAndBind(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.util.Map):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007a, code lost:
        wrapAndThrow(r9, r11, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007d, code lost:
        throw null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079 A[ExcHandler: Exception (r9v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:21:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void _readAndBindStringKeyMap(com.fasterxml.jackson.core.JsonParser r9, com.fasterxml.jackson.databind.DeserializationContext r10, java.util.Map<java.lang.Object, java.lang.Object> r11) throws java.io.IOException {
        /*
            r8 = this;
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> r0 = r8._valueDeserializer
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r1 = r8._valueTypeDeserializer
            r2 = 0
            com.fasterxml.jackson.databind.deser.impl.ObjectIdReader r3 = r0.getObjectIdReader()
            r4 = 0
            if (r3 == 0) goto L_0x000e
            r3 = 1
            goto L_0x000f
        L_0x000e:
            r3 = 0
        L_0x000f:
            if (r3 == 0) goto L_0x0021
            com.fasterxml.jackson.databind.deser.std.MapDeserializer$MapReferringAccumulator r5 = new com.fasterxml.jackson.databind.deser.std.MapDeserializer$MapReferringAccumulator
            com.fasterxml.jackson.databind.JavaType r6 = r8._containerType
            com.fasterxml.jackson.databind.JavaType r6 = r6.getContentType()
            java.lang.Class r6 = r6.getRawClass()
            r5.<init>(r6, r11)
            r2 = r5
        L_0x0021:
            boolean r5 = r9.isExpectedStartObjectToken()
            r6 = 0
            if (r5 == 0) goto L_0x002d
            java.lang.String r4 = r9.nextFieldName()
            goto L_0x003e
        L_0x002d:
            com.fasterxml.jackson.core.JsonToken r5 = r9.getCurrentToken()
            com.fasterxml.jackson.core.JsonToken r7 = com.fasterxml.jackson.core.JsonToken.END_OBJECT
            if (r5 != r7) goto L_0x0036
            return
        L_0x0036:
            com.fasterxml.jackson.core.JsonToken r7 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            if (r5 != r7) goto L_0x0089
            java.lang.String r4 = r9.getCurrentName()
        L_0x003e:
            if (r4 == 0) goto L_0x0088
            com.fasterxml.jackson.core.JsonToken r5 = r9.nextToken()
            java.util.Set<java.lang.String> r7 = r8._ignorableProperties
            if (r7 == 0) goto L_0x0052
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L_0x0052
            r9.skipChildren()
            goto L_0x0083
        L_0x0052:
            com.fasterxml.jackson.core.JsonToken r7 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL     // Catch:{ UnresolvedForwardReference -> 0x007e, Exception -> 0x0079 }
            if (r5 != r7) goto L_0x0064
            boolean r7 = r8._skipNullValues     // Catch:{ UnresolvedForwardReference -> 0x0062, Exception -> 0x0079 }
            if (r7 == 0) goto L_0x005b
            goto L_0x0083
        L_0x005b:
            com.fasterxml.jackson.databind.deser.NullValueProvider r7 = r8._nullProvider     // Catch:{ UnresolvedForwardReference -> 0x0062, Exception -> 0x0079 }
            java.lang.Object r7 = r7.getNullValue(r10)     // Catch:{ UnresolvedForwardReference -> 0x0062, Exception -> 0x0079 }
            goto L_0x006f
        L_0x0062:
            r7 = move-exception
            goto L_0x007f
        L_0x0064:
            if (r1 != 0) goto L_0x006b
            java.lang.Object r7 = r0.deserialize(r9, r10)     // Catch:{ UnresolvedForwardReference -> 0x0062, Exception -> 0x0079 }
            goto L_0x006f
        L_0x006b:
            java.lang.Object r7 = r0.deserializeWithType(r9, r10, r1)     // Catch:{ UnresolvedForwardReference -> 0x0062, Exception -> 0x0079 }
        L_0x006f:
            if (r3 == 0) goto L_0x0075
            r2.put(r4, r7)     // Catch:{ UnresolvedForwardReference -> 0x0062, Exception -> 0x0079 }
            goto L_0x0078
        L_0x0075:
            r11.put(r4, r7)     // Catch:{ UnresolvedForwardReference -> 0x0062, Exception -> 0x0079 }
        L_0x0078:
            goto L_0x0083
        L_0x0079:
            r9 = move-exception
            r8.wrapAndThrow(r9, r11, r4)
            throw r6
        L_0x007e:
            r7 = move-exception
        L_0x007f:
            r8.handleUnresolvedReference(r10, r2, r4, r7)
        L_0x0083:
            java.lang.String r4 = r9.nextFieldName()
            goto L_0x003e
        L_0x0088:
            return
        L_0x0089:
            java.lang.Object[] r9 = new java.lang.Object[r4]
            r10.reportWrongTokenException(r8, r7, r6, r9)
            goto L_0x0090
        L_0x008f:
            throw r6
        L_0x0090:
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.MapDeserializer._readAndBindStringKeyMap(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.util.Map):void");
    }

    public Map<Object, Object> _deserializeUsingCreator(JsonParser p, DeserializationContext ctxt) throws IOException {
        String key;
        Object value;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, null);
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else if (p.hasToken(JsonToken.FIELD_NAME)) {
            key = p.getCurrentName();
        } else {
            key = null;
        }
        while (key != null) {
            JsonToken t = p.nextToken();
            Set<String> set = this._ignorableProperties;
            if (set == null || !set.contains(key)) {
                SettableBeanProperty prop = creator.findCreatorProperty(key);
                if (prop == null) {
                    Object actualKey = this._keyDeserializer.deserializeKey(key, ctxt);
                    try {
                        if (t == JsonToken.VALUE_NULL) {
                            if (!this._skipNullValues) {
                                value = this._nullProvider.getNullValue(ctxt);
                            }
                        } else if (typeDeser == null) {
                            value = valueDes.deserialize(p, ctxt);
                        } else {
                            value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                        }
                        buffer.bufferMapProperty(actualKey, value);
                    } catch (Exception e) {
                        wrapAndThrow(e, this._containerType.getRawClass(), key);
                        throw null;
                    }
                } else if (buffer.assignParameter(prop, prop.deserialize(p, ctxt))) {
                    p.nextToken();
                    try {
                        Map map = (Map) creator.build(ctxt, buffer);
                        _readAndBind(p, ctxt, map);
                        return map;
                    } catch (Exception e2) {
                        wrapAndThrow(e2, this._containerType.getRawClass(), key);
                        throw null;
                    }
                }
            } else {
                p.skipChildren();
            }
            key = p.nextFieldName();
        }
        try {
            return (Map) creator.build(ctxt, buffer);
        } catch (Exception e3) {
            wrapAndThrow(e3, this._containerType.getRawClass(), key);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final void _readAndUpdate(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        String keyStr;
        Object value;
        KeyDeserializer keyDes = this._keyDeserializer;
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (p.isExpectedStartObjectToken()) {
            keyStr = p.nextFieldName();
        } else {
            JsonToken t = p.getCurrentToken();
            if (t != JsonToken.END_OBJECT) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (t == jsonToken) {
                    keyStr = p.getCurrentName();
                } else {
                    ctxt.reportWrongTokenException((JsonDeserializer<?>) this, jsonToken, (String) null, new Object[0]);
                    throw null;
                }
            } else {
                return;
            }
        }
        while (keyStr != null) {
            Object key = keyDes.deserializeKey(keyStr, ctxt);
            JsonToken t2 = p.nextToken();
            Set<String> set = this._ignorableProperties;
            if (set == null || !set.contains(keyStr)) {
                try {
                    if (t2 != JsonToken.VALUE_NULL) {
                        Object old = result.get(key);
                        if (old != null) {
                            value = valueDes.deserialize(p, ctxt, old);
                        } else if (typeDeser == null) {
                            value = valueDes.deserialize(p, ctxt);
                        } else {
                            value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                        }
                        if (value != old) {
                            result.put(key, value);
                        }
                    } else if (!this._skipNullValues) {
                        result.put(key, this._nullProvider.getNullValue(ctxt));
                    }
                } catch (Exception e) {
                    wrapAndThrow(e, result, keyStr);
                    throw null;
                }
            } else {
                p.skipChildren();
            }
            keyStr = p.nextFieldName();
        }
    }

    /* access modifiers changed from: protected */
    public final void _readAndUpdateStringKeyMap(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        String key;
        Object value;
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else {
            JsonToken t = p.getCurrentToken();
            if (t != JsonToken.END_OBJECT) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (t == jsonToken) {
                    key = p.getCurrentName();
                } else {
                    ctxt.reportWrongTokenException((JsonDeserializer<?>) this, jsonToken, (String) null, new Object[0]);
                    throw null;
                }
            } else {
                return;
            }
        }
        while (key != null) {
            JsonToken t2 = p.nextToken();
            Set<String> set = this._ignorableProperties;
            if (set == null || !set.contains(key)) {
                try {
                    if (t2 != JsonToken.VALUE_NULL) {
                        Object old = result.get(key);
                        if (old != null) {
                            value = valueDes.deserialize(p, ctxt, old);
                        } else if (typeDeser == null) {
                            value = valueDes.deserialize(p, ctxt);
                        } else {
                            value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                        }
                        if (value != old) {
                            result.put(key, value);
                        }
                    } else if (!this._skipNullValues) {
                        result.put(key, this._nullProvider.getNullValue(ctxt));
                    }
                } catch (Exception e) {
                    wrapAndThrow(e, result, key);
                    throw null;
                }
            } else {
                p.skipChildren();
            }
            key = p.nextFieldName();
        }
    }

    private void handleUnresolvedReference(DeserializationContext ctxt, MapReferringAccumulator accumulator, Object key, UnresolvedForwardReference reference) throws JsonMappingException {
        if (accumulator != null) {
            reference.getRoid().appendReferring(accumulator.handleUnresolvedReference(reference, key));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unresolved forward reference but no identity info: ");
        sb.append(reference);
        ctxt.reportInputMismatch((JsonDeserializer<?>) this, sb.toString(), new Object[0]);
        throw null;
    }
}
