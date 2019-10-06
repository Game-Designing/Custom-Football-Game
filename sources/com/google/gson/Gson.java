package com.google.gson;

import com.google.gson.p192b.C10059A;
import com.google.gson.p192b.C10060B;
import com.google.gson.p192b.C10157q;
import com.google.gson.p192b.C10159s;
import com.google.gson.p192b.p193a.C10097b;
import com.google.gson.p192b.p193a.C10099c;
import com.google.gson.p192b.p193a.C10104e;
import com.google.gson.p192b.p193a.C10106f;
import com.google.gson.p192b.p193a.C10110h;
import com.google.gson.p192b.p193a.C10114j;
import com.google.gson.p192b.p193a.C10116k;
import com.google.gson.p192b.p193a.C10118ka;
import com.google.gson.p192b.p193a.C10122n;
import com.google.gson.p192b.p193a.C10124p;
import com.google.gson.p192b.p193a.C10128r;
import com.google.gson.p192b.p193a.C10130t;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final C10172a<?> NULL_KEY_SURROGATE = C10172a.m33119a(Object.class);
    private final ThreadLocal<Map<C10172a<?>, C10056a<?>>> calls;
    private final C10157q constructorConstructor;
    private final C10159s excluder;
    private final List<C10055D> factories;
    private final FieldNamingStrategy fieldNamingStrategy;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final C10106f jsonAdapterFactory;
    private final boolean lenient;
    private final boolean prettyPrinting;
    private final boolean serializeNulls;
    private final Map<C10172a<?>, C10054C<?>> typeTokenCache;

    /* renamed from: com.google.gson.Gson$a */
    static class C10056a<T> extends C10054C<T> {

        /* renamed from: a */
        private C10054C<T> f30642a;

        C10056a() {
        }

        /* renamed from: a */
        public void mo33229a(C10054C<T> typeAdapter) {
            if (this.f30642a == null) {
                this.f30642a = typeAdapter;
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public T mo33197a(JsonReader in) throws IOException {
            C10054C<T> c = this.f30642a;
            if (c != null) {
                return c.mo33197a(in);
            }
            throw new IllegalStateException();
        }

        /* renamed from: a */
        public void mo33198a(JsonWriter out, T value) throws IOException {
            C10054C<T> c = this.f30642a;
            if (c != null) {
                c.mo33198a(out, value);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public Gson() {
        this(C10159s.f30826a, C10178i.IDENTITY, Collections.emptyMap(), false, false, false, DEFAULT_ESCAPE_HTML, false, false, false, C10052A.DEFAULT, Collections.emptyList());
    }

    Gson(C10159s excluder2, FieldNamingStrategy fieldNamingStrategy2, Map<Type, C10184o<?>> instanceCreators, boolean serializeNulls2, boolean complexMapKeySerialization, boolean generateNonExecutableGson, boolean htmlSafe2, boolean prettyPrinting2, boolean lenient2, boolean serializeSpecialFloatingPointValues, C10052A longSerializationPolicy, List<C10055D> typeAdapterFactories) {
        C10159s sVar = excluder2;
        FieldNamingStrategy fieldNamingStrategy3 = fieldNamingStrategy2;
        boolean z = serializeSpecialFloatingPointValues;
        this.calls = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.constructorConstructor = new C10157q(instanceCreators);
        this.excluder = sVar;
        this.fieldNamingStrategy = fieldNamingStrategy3;
        this.serializeNulls = serializeNulls2;
        this.generateNonExecutableJson = generateNonExecutableGson;
        this.htmlSafe = htmlSafe2;
        this.prettyPrinting = prettyPrinting2;
        this.lenient = lenient2;
        List<TypeAdapterFactory> factories2 = new ArrayList<>();
        factories2.add(C10118ka.f30720Y);
        factories2.add(C10122n.f30751a);
        factories2.add(sVar);
        factories2.addAll(typeAdapterFactories);
        factories2.add(C10118ka.f30699D);
        factories2.add(C10118ka.f30734m);
        factories2.add(C10118ka.f30728g);
        factories2.add(C10118ka.f30730i);
        factories2.add(C10118ka.f30732k);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
        factories2.add(C10118ka.m32993a(Long.TYPE, Long.class, longAdapter));
        factories2.add(C10118ka.m32993a(Double.TYPE, Double.class, doubleAdapter(z)));
        factories2.add(C10118ka.m32993a(Float.TYPE, Float.class, floatAdapter(z)));
        factories2.add(C10118ka.f30745x);
        factories2.add(C10118ka.f30736o);
        factories2.add(C10118ka.f30738q);
        factories2.add(C10118ka.m32992a(AtomicLong.class, atomicLongAdapter(longAdapter)));
        factories2.add(C10118ka.m32992a(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        factories2.add(C10118ka.f30740s);
        factories2.add(C10118ka.f30747z);
        factories2.add(C10118ka.f30701F);
        factories2.add(C10118ka.f30703H);
        factories2.add(C10118ka.m32992a(BigDecimal.class, C10118ka.f30697B));
        factories2.add(C10118ka.m32992a(BigInteger.class, C10118ka.f30698C));
        factories2.add(C10118ka.f30705J);
        factories2.add(C10118ka.f30707L);
        factories2.add(C10118ka.f30711P);
        factories2.add(C10118ka.f30713R);
        factories2.add(C10118ka.f30718W);
        factories2.add(C10118ka.f30709N);
        factories2.add(C10118ka.f30725d);
        factories2.add(C10104e.f30680a);
        factories2.add(C10118ka.f30716U);
        factories2.add(C10130t.f30771a);
        factories2.add(C10128r.f30769a);
        factories2.add(C10118ka.f30714S);
        factories2.add(C10097b.f30671a);
        factories2.add(C10118ka.f30723b);
        factories2.add(new C10099c(this.constructorConstructor));
        factories2.add(new C10116k(this.constructorConstructor, complexMapKeySerialization));
        this.jsonAdapterFactory = new C10106f(this.constructorConstructor);
        factories2.add(this.jsonAdapterFactory);
        factories2.add(C10118ka.f30721Z);
        factories2.add(new C10124p(this.constructorConstructor, fieldNamingStrategy3, sVar, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList(factories2);
    }

    public C10159s excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    private C10054C<Number> doubleAdapter(boolean serializeSpecialFloatingPointValues) {
        if (serializeSpecialFloatingPointValues) {
            return C10118ka.f30743v;
        }
        return new C10179j(this);
    }

    private C10054C<Number> floatAdapter(boolean serializeSpecialFloatingPointValues) {
        if (serializeSpecialFloatingPointValues) {
            return C10118ka.f30742u;
        }
        return new C10180k(this);
    }

    static void checkValidFloatingPoint(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static C10054C<Number> longAdapter(C10052A longSerializationPolicy) {
        if (longSerializationPolicy == C10052A.DEFAULT) {
            return C10118ka.f30741t;
        }
        return new C10181l();
    }

    private static C10054C<AtomicLong> atomicLongAdapter(C10054C<Number> longAdapter) {
        return new C10182m(longAdapter).mo33199a();
    }

    private static C10054C<AtomicLongArray> atomicLongArrayAdapter(C10054C<Number> longAdapter) {
        return new C10183n(longAdapter).mo33199a();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.gson.c.a<T>, code=com.google.gson.c.a, for r9v0, types: [com.google.gson.c.a, java.lang.Object, com.google.gson.c.a<T>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.google.gson.C10054C<T> getAdapter(com.google.gson.p195c.C10172a r9) {
        /*
            r8 = this;
            java.util.Map<com.google.gson.c.a<?>, com.google.gson.C<?>> r0 = r8.typeTokenCache
            if (r9 != 0) goto L_0x0007
            com.google.gson.c.a<?> r1 = NULL_KEY_SURROGATE
            goto L_0x0008
        L_0x0007:
            r1 = r9
        L_0x0008:
            java.lang.Object r0 = r0.get(r1)
            com.google.gson.C r0 = (com.google.gson.C10054C) r0
            if (r0 == 0) goto L_0x0011
            return r0
        L_0x0011:
            java.lang.ThreadLocal<java.util.Map<com.google.gson.c.a<?>, com.google.gson.Gson$a<?>>> r1 = r8.calls
            java.lang.Object r1 = r1.get()
            java.util.Map r1 = (java.util.Map) r1
            r2 = 0
            if (r1 != 0) goto L_0x0028
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r1 = r3
            java.lang.ThreadLocal<java.util.Map<com.google.gson.c.a<?>, com.google.gson.Gson$a<?>>> r3 = r8.calls
            r3.set(r1)
            r2 = 1
        L_0x0028:
            java.lang.Object r3 = r1.get(r9)
            com.google.gson.Gson$a r3 = (com.google.gson.Gson.C10056a) r3
            if (r3 == 0) goto L_0x0031
            return r3
        L_0x0031:
            com.google.gson.Gson$a r4 = new com.google.gson.Gson$a     // Catch:{ all -> 0x007d }
            r4.<init>()     // Catch:{ all -> 0x007d }
            r1.put(r9, r4)     // Catch:{ all -> 0x007d }
            java.util.List<com.google.gson.D> r5 = r8.factories     // Catch:{ all -> 0x007d }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x007d }
        L_0x003f:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x007d }
            if (r6 == 0) goto L_0x0066
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x007d }
            com.google.gson.D r6 = (com.google.gson.C10055D) r6     // Catch:{ all -> 0x007d }
            com.google.gson.C r7 = r6.mo33201a(r8, r9)     // Catch:{ all -> 0x007d }
            if (r7 == 0) goto L_0x0065
            r4.mo33229a(r7)     // Catch:{ all -> 0x007d }
            java.util.Map<com.google.gson.c.a<?>, com.google.gson.C<?>> r5 = r8.typeTokenCache     // Catch:{ all -> 0x007d }
            r5.put(r9, r7)     // Catch:{ all -> 0x007d }
            r1.remove(r9)
            if (r2 == 0) goto L_0x0064
            java.lang.ThreadLocal<java.util.Map<com.google.gson.c.a<?>, com.google.gson.Gson$a<?>>> r5 = r8.calls
            r5.remove()
        L_0x0064:
            return r7
        L_0x0065:
            goto L_0x003f
        L_0x0066:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r6.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r7 = "GSON cannot handle "
            r6.append(r7)     // Catch:{ all -> 0x007d }
            r6.append(r9)     // Catch:{ all -> 0x007d }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x007d }
            r5.<init>(r6)     // Catch:{ all -> 0x007d }
            throw r5     // Catch:{ all -> 0x007d }
        L_0x007d:
            r4 = move-exception
            r1.remove(r9)
            if (r2 == 0) goto L_0x0088
            java.lang.ThreadLocal<java.util.Map<com.google.gson.c.a<?>, com.google.gson.Gson$a<?>>> r5 = r8.calls
            r5.remove()
        L_0x0088:
            goto L_0x008a
        L_0x0089:
            throw r4
        L_0x008a:
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.getAdapter(com.google.gson.c.a):com.google.gson.C");
    }

    public <T> C10054C<T> getDelegateAdapter(C10055D skipPast, C10172a<T> type) {
        if (!this.factories.contains(skipPast)) {
            skipPast = this.jsonAdapterFactory;
        }
        boolean skipPastFound = false;
        for (C10055D factory : this.factories) {
            if (skipPastFound) {
                TypeAdapter<T> candidate = factory.mo33201a(this, type);
                if (candidate != null) {
                    return candidate;
                }
            } else if (factory == skipPast) {
                skipPastFound = DEFAULT_ESCAPE_HTML;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("GSON cannot serialize ");
        sb.append(type);
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> C10054C<T> getAdapter(Class<T> type) {
        return getAdapter(C10172a.m33119a(type));
    }

    public C10188s toJsonTree(Object src) {
        if (src == null) {
            return C10190t.f30874a;
        }
        return toJsonTree(src, src.getClass());
    }

    public C10188s toJsonTree(Object src, Type typeOfSrc) {
        C10114j writer = new C10114j();
        toJson(src, typeOfSrc, (JsonWriter) writer);
        return writer.mo33321a();
    }

    public String toJson(Object src) {
        if (src == null) {
            return toJson((C10188s) C10190t.f30874a);
        }
        return toJson(src, (Type) src.getClass());
    }

    public String toJson(Object src, Type typeOfSrc) {
        StringWriter writer = new StringWriter();
        toJson(src, typeOfSrc, (Appendable) writer);
        return writer.toString();
    }

    public void toJson(Object src, Appendable writer) throws JsonIOException {
        if (src != null) {
            toJson(src, (Type) src.getClass(), writer);
        } else {
            toJson((C10188s) C10190t.f30874a, writer);
        }
    }

    public void toJson(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        try {
            toJson(src, typeOfSrc, newJsonWriter(C10060B.m32833a(writer)));
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        }
    }

    public void toJson(Object src, Type typeOfSrc, JsonWriter writer) throws JsonIOException {
        TypeAdapter<?> adapter = getAdapter(C10172a.m33120a(typeOfSrc));
        boolean oldLenient = writer.isLenient();
        writer.setLenient(DEFAULT_ESCAPE_HTML);
        boolean oldHtmlSafe = writer.isHtmlSafe();
        writer.setHtmlSafe(this.htmlSafe);
        boolean oldSerializeNulls = writer.getSerializeNulls();
        writer.setSerializeNulls(this.serializeNulls);
        try {
            adapter.mo33198a(writer, src);
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        } catch (Throwable th) {
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
            throw th;
        }
    }

    public String toJson(C10188s jsonElement) {
        StringWriter writer = new StringWriter();
        toJson(jsonElement, (Appendable) writer);
        return writer.toString();
    }

    public void toJson(C10188s jsonElement, Appendable writer) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(C10060B.m32833a(writer)));
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        }
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public void toJson(C10188s jsonElement, JsonWriter writer) throws JsonIOException {
        boolean oldLenient = writer.isLenient();
        writer.setLenient(DEFAULT_ESCAPE_HTML);
        boolean oldHtmlSafe = writer.isHtmlSafe();
        writer.setHtmlSafe(this.htmlSafe);
        boolean oldSerializeNulls = writer.getSerializeNulls();
        writer.setSerializeNulls(this.serializeNulls);
        try {
            C10060B.m32834a(jsonElement, writer);
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        } catch (Throwable th) {
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            writer.setSerializeNulls(oldSerializeNulls);
            throw th;
        }
    }

    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return C10059A.m32829a(classOfT).cast(fromJson(json, (Type) classOfT));
    }

    public <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return fromJson((Reader) new StringReader(json), typeOfT);
    }

    public <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReader = newJsonReader(json);
        Object object = fromJson(jsonReader, (Type) classOfT);
        assertFullConsumption(object, jsonReader);
        return C10059A.m32829a(classOfT).cast(object);
    }

    public <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        JsonReader jsonReader = newJsonReader(json);
        T object = fromJson(jsonReader, typeOfT);
        assertFullConsumption(object, jsonReader);
        return object;
    }

    private static void assertFullConsumption(Object obj, JsonReader reader) {
        if (obj != null) {
            try {
                if (reader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IOException e2) {
                throw new JsonIOException((Throwable) e2);
            }
        }
    }

    public <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        boolean oldLenient = reader.isLenient();
        reader.setLenient(DEFAULT_ESCAPE_HTML);
        try {
            reader.peek();
            T object = getAdapter((C10172a<T>) C10172a.m33120a(typeOfT)).mo33197a(reader);
            reader.setLenient(oldLenient);
            return object;
        } catch (EOFException e) {
            if (1 != 0) {
                reader.setLenient(oldLenient);
                return null;
            }
            throw new JsonSyntaxException((Throwable) e);
        } catch (IllegalStateException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        } catch (IOException e3) {
            throw new JsonSyntaxException((Throwable) e3);
        } catch (Throwable typeToken) {
            reader.setLenient(oldLenient);
            throw typeToken;
        }
    }

    public <T> T fromJson(C10188s json, Class<T> classOfT) throws JsonSyntaxException {
        return C10059A.m32829a(classOfT).cast(fromJson(json, (Type) classOfT));
    }

    public <T> T fromJson(C10188s json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return fromJson((JsonReader) new C10110h(json), typeOfT);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{serializeNulls:");
        sb.append(this.serializeNulls);
        sb.append(",factories:");
        sb.append(this.factories);
        sb.append(",instanceCreators:");
        sb.append(this.constructorConstructor);
        sb.append("}");
        return sb.toString();
    }
}
