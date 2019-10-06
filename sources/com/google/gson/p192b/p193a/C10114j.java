package com.google.gson.p192b.p193a;

import com.google.gson.C10185p;
import com.google.gson.C10188s;
import com.google.gson.C10190t;
import com.google.gson.C10191u;
import com.google.gson.C10192v;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.gson.b.a.j */
/* compiled from: JsonTreeWriter */
public final class C10114j extends JsonWriter {

    /* renamed from: a */
    private static final Writer f30686a = new C10112i();

    /* renamed from: b */
    private static final C10192v f30687b = new C10192v("closed");

    /* renamed from: c */
    private String f30688c;

    /* renamed from: d */
    private C10188s f30689d = C10190t.f30874a;
    private final List<C10188s> stack = new ArrayList();

    public C10114j() {
        super(f30686a);
    }

    /* renamed from: a */
    public C10188s mo33321a() {
        if (this.stack.isEmpty()) {
            return this.f30689d;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected one JSON element but was ");
        sb.append(this.stack);
        throw new IllegalStateException(sb.toString());
    }

    private C10188s peek() {
        List<C10188s> list = this.stack;
        return (C10188s) list.get(list.size() - 1);
    }

    /* renamed from: a */
    private void m32978a(C10188s value) {
        if (this.f30688c != null) {
            if (!value.mo33448j() || getSerializeNulls()) {
                ((C10191u) peek()).mo33467a(this.f30688c, value);
            }
            this.f30688c = null;
        } else if (this.stack.isEmpty()) {
            this.f30689d = value;
        } else {
            C10188s element = peek();
            if (element instanceof C10185p) {
                ((C10185p) element).mo33431a(value);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public JsonWriter beginArray() throws IOException {
        C10185p array = new C10185p();
        m32978a(array);
        this.stack.add(array);
        return this;
    }

    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty() || this.f30688c != null) {
            throw new IllegalStateException();
        } else if (peek() instanceof C10185p) {
            List<C10188s> list = this.stack;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter beginObject() throws IOException {
        C10191u object = new C10191u();
        m32978a(object);
        this.stack.add(object);
        return this;
    }

    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty() || this.f30688c != null) {
            throw new IllegalStateException();
        } else if (peek() instanceof C10191u) {
            List<C10188s> list = this.stack;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter name(String name) throws IOException {
        if (this.stack.isEmpty() || this.f30688c != null) {
            throw new IllegalStateException();
        } else if (peek() instanceof C10191u) {
            this.f30688c = name;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter value(String value) throws IOException {
        if (value == null) {
            nullValue();
            return this;
        }
        m32978a(new C10192v(value));
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        m32978a(C10190t.f30874a);
        return this;
    }

    public JsonWriter value(boolean value) throws IOException {
        m32978a(new C10192v(Boolean.valueOf(value)));
        return this;
    }

    public JsonWriter value(Boolean value) throws IOException {
        if (value == null) {
            nullValue();
            return this;
        }
        m32978a(new C10192v(value));
        return this;
    }

    public JsonWriter value(double value) throws IOException {
        if (isLenient() || (!Double.isNaN(value) && !Double.isInfinite(value))) {
            m32978a(new C10192v((Number) Double.valueOf(value)));
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JSON forbids NaN and infinities: ");
        sb.append(value);
        throw new IllegalArgumentException(sb.toString());
    }

    public JsonWriter value(long value) throws IOException {
        m32978a(new C10192v((Number) Long.valueOf(value)));
        return this;
    }

    public JsonWriter value(Number value) throws IOException {
        if (value == null) {
            nullValue();
            return this;
        }
        if (!isLenient()) {
            double d = value.doubleValue();
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSON forbids NaN and infinities: ");
                sb.append(value);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        m32978a(new C10192v(value));
        return this;
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
        if (this.stack.isEmpty()) {
            this.stack.add(f30687b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
