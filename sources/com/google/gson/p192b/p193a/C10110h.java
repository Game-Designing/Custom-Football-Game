package com.google.gson.p192b.p193a;

import com.google.gson.C10185p;
import com.google.gson.C10188s;
import com.google.gson.C10190t;
import com.google.gson.C10191u;
import com.google.gson.C10192v;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.gson.b.a.h */
/* compiled from: JsonTreeReader */
public final class C10110h extends JsonReader {

    /* renamed from: a */
    private static final Reader f30684a = new C10108g();

    /* renamed from: b */
    private static final Object f30685b = new Object();
    private int[] pathIndices = new int[32];
    private String[] pathNames = new String[32];
    private Object[] stack = new Object[32];
    private int stackSize = 0;

    public C10110h(C10188s element) {
        super(f30684a);
        m32966a((Object) element);
    }

    public void beginArray() throws IOException {
        m32965a(JsonToken.BEGIN_ARRAY);
        m32966a((Object) ((C10185p) m32967b()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    public void endArray() throws IOException {
        m32965a(JsonToken.END_ARRAY);
        m32968c();
        m32968c();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public void beginObject() throws IOException {
        m32965a(JsonToken.BEGIN_OBJECT);
        m32966a((Object) ((C10191u) m32967b()).mo33476m().iterator());
    }

    public void endObject() throws IOException {
        m32965a(JsonToken.END_OBJECT);
        m32968c();
        m32968c();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public boolean hasNext() throws IOException {
        JsonToken token = peek();
        return (token == JsonToken.END_OBJECT || token == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() throws IOException {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object o = m32967b();
        if (o instanceof Iterator) {
            boolean isObject = this.stack[this.stackSize - 2] instanceof C10191u;
            Iterator<?> iterator = (Iterator) o;
            if (!iterator.hasNext()) {
                return isObject ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (isObject) {
                return JsonToken.NAME;
            } else {
                m32966a(iterator.next());
                return peek();
            }
        } else if (o instanceof C10191u) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (o instanceof C10185p) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (o instanceof C10192v) {
                C10192v primitive = (C10192v) o;
                if (primitive.mo33485r()) {
                    return JsonToken.STRING;
                }
                if (primitive.mo33483p()) {
                    return JsonToken.BOOLEAN;
                }
                if (primitive.mo33484q()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (o instanceof C10190t) {
                return JsonToken.NULL;
            } else {
                if (o == f30685b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    /* renamed from: b */
    private Object m32967b() {
        return this.stack[this.stackSize - 1];
    }

    /* renamed from: c */
    private Object m32968c() {
        Object[] objArr = this.stack;
        int i = this.stackSize - 1;
        this.stackSize = i;
        Object result = objArr[i];
        objArr[this.stackSize] = null;
        return result;
    }

    /* renamed from: a */
    private void m32965a(JsonToken expected) throws IOException {
        if (peek() != expected) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(expected);
            sb.append(" but was ");
            sb.append(peek());
            sb.append(locationString());
            throw new IllegalStateException(sb.toString());
        }
    }

    public String nextName() throws IOException {
        m32965a(JsonToken.NAME);
        Entry<?, ?> entry = (Entry) ((Iterator) m32967b()).next();
        String result = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = result;
        m32966a(entry.getValue());
        return result;
    }

    public String nextString() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.STRING || token == JsonToken.NUMBER) {
            String result = ((C10192v) m32968c()).mo33439h();
            int i = this.stackSize;
            if (i > 0) {
                int[] iArr = this.pathIndices;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(JsonToken.STRING);
        sb.append(" but was ");
        sb.append(token);
        sb.append(locationString());
        throw new IllegalStateException(sb.toString());
    }

    public boolean nextBoolean() throws IOException {
        m32965a(JsonToken.BOOLEAN);
        boolean result = ((C10192v) m32968c()).mo33433a();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return result;
    }

    public void nextNull() throws IOException {
        m32965a(JsonToken.NULL);
        m32968c();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public double nextDouble() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            double result = ((C10192v) m32967b()).mo33481n();
            if (isLenient() || (!Double.isNaN(result) && !Double.isInfinite(result))) {
                m32968c();
                int i = this.stackSize;
                if (i > 0) {
                    int[] iArr = this.pathIndices;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return result;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JSON forbids NaN and infinities: ");
            sb.append(result);
            throw new NumberFormatException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected ");
        sb2.append(JsonToken.NUMBER);
        sb2.append(" but was ");
        sb2.append(token);
        sb2.append(locationString());
        throw new IllegalStateException(sb2.toString());
    }

    public long nextLong() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            long result = ((C10192v) m32967b()).mo33437g();
            m32968c();
            int i = this.stackSize;
            if (i > 0) {
                int[] iArr = this.pathIndices;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(JsonToken.NUMBER);
        sb.append(" but was ");
        sb.append(token);
        sb.append(locationString());
        throw new IllegalStateException(sb.toString());
    }

    public int nextInt() throws IOException {
        JsonToken token = peek();
        if (token == JsonToken.NUMBER || token == JsonToken.STRING) {
            int result = ((C10192v) m32967b()).mo33435c();
            m32968c();
            int i = this.stackSize;
            if (i > 0) {
                int[] iArr = this.pathIndices;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(JsonToken.NUMBER);
        sb.append(" but was ");
        sb.append(token);
        sb.append(locationString());
        throw new IllegalStateException(sb.toString());
    }

    public void close() throws IOException {
        this.stack = new Object[]{f30685b};
        this.stackSize = 1;
    }

    public void skipValue() throws IOException {
        String str = "null";
        if (peek() == JsonToken.NAME) {
            nextName();
            this.pathNames[this.stackSize - 2] = str;
        } else {
            m32968c();
            int i = this.stackSize;
            if (i > 0) {
                this.pathNames[i - 1] = str;
            }
        }
        int i2 = this.stackSize;
        if (i2 > 0) {
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: a */
    public void mo33298a() throws IOException {
        m32965a(JsonToken.NAME);
        Entry<?, ?> entry = (Entry) ((Iterator) m32967b()).next();
        m32966a(entry.getValue());
        m32966a((Object) new C10192v((String) entry.getKey()));
    }

    /* renamed from: a */
    private void m32966a(Object newTop) {
        int i = this.stackSize;
        Object[] objArr = this.stack;
        if (i == objArr.length) {
            Object[] newStack = new Object[(i * 2)];
            int[] newPathIndices = new int[(i * 2)];
            String[] newPathNames = new String[(i * 2)];
            System.arraycopy(objArr, 0, newStack, 0, i);
            System.arraycopy(this.pathIndices, 0, newPathIndices, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, newPathNames, 0, this.stackSize);
            this.stack = newStack;
            this.pathIndices = newPathIndices;
            this.pathNames = newPathNames;
        }
        Object[] objArr2 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        objArr2[i2] = newTop;
    }

    public String getPath() {
        StringBuilder result = new StringBuilder().append('$');
        int i = 0;
        while (i < this.stackSize) {
            Object[] objArr = this.stack;
            if (objArr[i] instanceof C10185p) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    result.append('[');
                    result.append(this.pathIndices[i]);
                    result.append(']');
                }
            } else if (objArr[i] instanceof C10191u) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    result.append('.');
                    String[] strArr = this.pathNames;
                    if (strArr[i] != null) {
                        result.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return result.toString();
    }

    private String locationString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" at path ");
        sb.append(getPath());
        return sb.toString();
    }
}
