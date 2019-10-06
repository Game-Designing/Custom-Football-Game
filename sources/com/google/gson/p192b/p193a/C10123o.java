package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/* renamed from: com.google.gson.b.a.o */
/* compiled from: ReflectiveTypeAdapterFactory */
class C10123o extends C10126b {

    /* renamed from: d */
    final /* synthetic */ Field f30753d;

    /* renamed from: e */
    final /* synthetic */ boolean f30754e;

    /* renamed from: f */
    final /* synthetic */ C10054C f30755f;

    /* renamed from: g */
    final /* synthetic */ Gson f30756g;

    /* renamed from: h */
    final /* synthetic */ C10172a f30757h;

    /* renamed from: i */
    final /* synthetic */ boolean f30758i;

    /* renamed from: j */
    final /* synthetic */ C10124p f30759j;

    C10123o(C10124p this$0, String name, boolean serialized, boolean deserialized, Field field, boolean z, C10054C c, Gson gson, C10172a aVar, boolean z2) {
        this.f30759j = this$0;
        this.f30753d = field;
        this.f30754e = z;
        this.f30755f = c;
        this.f30756g = gson;
        this.f30757h = aVar;
        this.f30758i = z2;
        super(name, serialized, deserialized);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33340a(JsonWriter writer, Object value) throws IOException, IllegalAccessException {
        C10054C t;
        Object fieldValue = this.f30753d.get(value);
        if (this.f30754e) {
            t = this.f30755f;
        } else {
            t = new C10135w(this.f30756g, this.f30755f, this.f30757h.mo33421b());
        }
        t.mo33198a(writer, fieldValue);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33339a(JsonReader reader, Object value) throws IOException, IllegalAccessException {
        Object fieldValue = this.f30755f.mo33197a(reader);
        if (fieldValue != null || !this.f30758i) {
            this.f30753d.set(value, fieldValue);
        }
    }

    /* renamed from: a */
    public boolean mo33341a(Object value) throws IOException, IllegalAccessException {
        boolean z = false;
        if (!this.f30767b) {
            return false;
        }
        if (this.f30753d.get(value) != value) {
            z = true;
        }
        return z;
    }
}
