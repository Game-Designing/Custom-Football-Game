package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;

/* renamed from: com.google.gson.b.a.X */
/* compiled from: TypeAdapters */
class C10091X implements C10055D {

    /* renamed from: a */
    final /* synthetic */ Class f30660a;

    /* renamed from: b */
    final /* synthetic */ C10054C f30661b;

    C10091X(Class cls, C10054C c) {
        this.f30660a = cls;
        this.f30661b = c;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        if (typeToken.mo33420a() == this.f30660a) {
            return this.f30661b;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.f30660a.getName());
        sb.append(",adapter=");
        sb.append(this.f30661b);
        sb.append("]");
        return sb.toString();
    }
}
