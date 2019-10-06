package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.C10186q;
import com.google.gson.C10187r;
import com.google.gson.C10188s;
import com.google.gson.C10193w;
import com.google.gson.C10194x;
import com.google.gson.Gson;
import com.google.gson.p192b.C10060B;
import com.google.gson.p192b.C10068a;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.v */
/* compiled from: TreeTypeAdapter */
public final class C10132v<T> extends C10054C<T> {

    /* renamed from: a */
    private final C10194x<T> f30773a;

    /* renamed from: b */
    private final C10187r<T> f30774b;

    /* renamed from: c */
    final Gson f30775c;

    /* renamed from: d */
    private final C10172a<T> f30776d;

    /* renamed from: e */
    private final C10055D f30777e;

    /* renamed from: f */
    private final C10133a f30778f = new C10133a<>();

    /* renamed from: g */
    private C10054C<T> f30779g;

    /* renamed from: com.google.gson.b.a.v$a */
    /* compiled from: TreeTypeAdapter */
    private final class C10133a implements C10193w, C10186q {
        private C10133a() {
        }
    }

    /* renamed from: com.google.gson.b.a.v$b */
    /* compiled from: TreeTypeAdapter */
    private static final class C10134b implements C10055D {

        /* renamed from: a */
        private final C10172a<?> f30781a;

        /* renamed from: b */
        private final boolean f30782b;

        /* renamed from: c */
        private final Class<?> f30783c;

        /* renamed from: d */
        private final C10194x<?> f30784d;

        /* renamed from: e */
        private final C10187r<?> f30785e;

        C10134b(Object typeAdapter, C10172a<?> exactType, boolean matchRawType, Class<?> hierarchyType) {
            C10187r<?> rVar = null;
            this.f30784d = typeAdapter instanceof C10194x ? (C10194x) typeAdapter : null;
            if (typeAdapter instanceof C10187r) {
                rVar = (C10187r) typeAdapter;
            }
            this.f30785e = rVar;
            C10068a.m32843a((this.f30784d == null && this.f30785e == null) ? false : true);
            this.f30781a = exactType;
            this.f30782b = matchRawType;
            this.f30783c = hierarchyType;
        }

        /* renamed from: a */
        public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> type) {
            C10172a<?> aVar = this.f30781a;
            boolean matches = aVar != null ? aVar.equals(type) || (this.f30782b && this.f30781a.mo33421b() == type.mo33420a()) : this.f30783c.isAssignableFrom(type.mo33420a());
            if (!matches) {
                return null;
            }
            C10132v vVar = new C10132v(this.f30784d, this.f30785e, gson, type, this);
            return vVar;
        }
    }

    public C10132v(C10194x<T> serializer, C10187r<T> deserializer, Gson gson, C10172a<T> typeToken, C10055D skipPast) {
        this.f30773a = serializer;
        this.f30774b = deserializer;
        this.f30775c = gson;
        this.f30776d = typeToken;
        this.f30777e = skipPast;
    }

    /* renamed from: a */
    public T mo33197a(JsonReader in) throws IOException {
        if (this.f30774b == null) {
            return m33029b().mo33197a(in);
        }
        C10188s value = C10060B.m32832a(in);
        if (value.mo33448j()) {
            return null;
        }
        return this.f30774b.mo33443a(value, this.f30776d.mo33421b(), this.f30778f);
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, T value) throws IOException {
        C10194x<T> xVar = this.f30773a;
        if (xVar == null) {
            m33029b().mo33198a(out, value);
        } else if (value == null) {
            out.nullValue();
        } else {
            C10060B.m32834a(xVar.mo33486a(value, this.f30776d.mo33421b(), this.f30778f), out);
        }
    }

    /* renamed from: b */
    private C10054C<T> m33029b() {
        C10054C<T> c = this.f30779g;
        if (c != null) {
            return c;
        }
        C10054C<T> delegateAdapter = this.f30775c.getDelegateAdapter(this.f30777e, this.f30776d);
        this.f30779g = delegateAdapter;
        return delegateAdapter;
    }

    /* renamed from: a */
    public static C10055D m33027a(C10172a<?> exactType, Object typeAdapter) {
        return new C10134b(typeAdapter, exactType, exactType.mo33421b() == exactType.mo33420a(), null);
    }

    /* renamed from: a */
    public static C10055D m33028a(Class<?> hierarchyType, Object typeAdapter) {
        return new C10134b(typeAdapter, null, false, hierarchyType);
    }
}
