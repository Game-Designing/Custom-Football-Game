package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;

/* renamed from: com.google.gson.b.a.Z */
/* compiled from: TypeAdapters */
class C10093Z implements C10055D {

    /* renamed from: a */
    final /* synthetic */ Class f30665a;

    /* renamed from: b */
    final /* synthetic */ Class f30666b;

    /* renamed from: c */
    final /* synthetic */ C10054C f30667c;

    C10093Z(Class cls, Class cls2, C10054C c) {
        this.f30665a = cls;
        this.f30666b = cls2;
        this.f30667c = c;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        Class<? super T> rawType = typeToken.mo33420a();
        if (rawType == this.f30665a || rawType == this.f30666b) {
            return this.f30667c;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.f30665a.getName());
        sb.append("+");
        sb.append(this.f30666b.getName());
        sb.append(",adapter=");
        sb.append(this.f30667c);
        sb.append("]");
        return sb.toString();
    }
}
