package com.google.gson;

import com.google.gson.p192b.C10060B;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

/* renamed from: com.google.gson.s */
/* compiled from: JsonElement */
public abstract class C10188s {
    /* renamed from: i */
    public boolean mo33447i() {
        return this instanceof C10185p;
    }

    /* renamed from: k */
    public boolean mo33449k() {
        return this instanceof C10191u;
    }

    /* renamed from: l */
    public boolean mo33450l() {
        return this instanceof C10192v;
    }

    /* renamed from: j */
    public boolean mo33448j() {
        return this instanceof C10190t;
    }

    /* renamed from: e */
    public C10191u mo33445e() {
        if (mo33449k()) {
            return (C10191u) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Object: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: d */
    public C10185p mo33444d() {
        if (mo33447i()) {
            return (C10185p) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Array: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: f */
    public C10192v mo33446f() {
        if (mo33450l()) {
            return (C10192v) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Primitive: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public boolean mo33433a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: h */
    public String mo33439h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: b */
    public float mo33434b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: g */
    public long mo33437g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: c */
    public int mo33435c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            C10060B.m32834a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
