package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;

/* renamed from: com.google.gson.b.a.Y */
/* compiled from: TypeAdapters */
class C10092Y implements C10055D {

    /* renamed from: a */
    final /* synthetic */ Class f30662a;

    /* renamed from: b */
    final /* synthetic */ Class f30663b;

    /* renamed from: c */
    final /* synthetic */ C10054C f30664c;

    C10092Y(Class cls, Class cls2, C10054C c) {
        this.f30662a = cls;
        this.f30663b = cls2;
        this.f30664c = c;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        Class<? super T> rawType = typeToken.mo33420a();
        if (rawType == this.f30662a || rawType == this.f30663b) {
            return this.f30664c;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.f30663b.getName());
        sb.append("+");
        sb.append(this.f30662a.getName());
        sb.append(",adapter=");
        sb.append(this.f30664c);
        sb.append("]");
        return sb.toString();
    }
}
