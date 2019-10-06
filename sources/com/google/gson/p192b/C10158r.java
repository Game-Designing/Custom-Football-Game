package com.google.gson.p192b;

import com.google.gson.C10054C;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.r */
/* compiled from: Excluder */
class C10158r extends C10054C<T> {

    /* renamed from: a */
    private C10054C<T> f30820a;

    /* renamed from: b */
    final /* synthetic */ boolean f30821b;

    /* renamed from: c */
    final /* synthetic */ boolean f30822c;

    /* renamed from: d */
    final /* synthetic */ Gson f30823d;

    /* renamed from: e */
    final /* synthetic */ C10172a f30824e;

    /* renamed from: f */
    final /* synthetic */ C10159s f30825f;

    C10158r(C10159s this$0, boolean z, boolean z2, Gson gson, C10172a aVar) {
        this.f30825f = this$0;
        this.f30821b = z;
        this.f30822c = z2;
        this.f30823d = gson;
        this.f30824e = aVar;
    }

    /* renamed from: a */
    public T mo33197a(JsonReader in) throws IOException {
        if (!this.f30821b) {
            return m33087b().mo33197a(in);
        }
        in.skipValue();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, T value) throws IOException {
        if (this.f30822c) {
            out.nullValue();
        } else {
            m33087b().mo33198a(out, value);
        }
    }

    /* renamed from: b */
    private C10054C<T> m33087b() {
        C10054C<T> c = this.f30820a;
        if (c != null) {
            return c;
        }
        C10054C<T> delegateAdapter = this.f30823d.getDelegateAdapter(this.f30825f, this.f30824e);
        this.f30820a = delegateAdapter;
        return delegateAdapter;
    }
}
