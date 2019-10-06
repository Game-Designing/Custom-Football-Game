package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;

/* renamed from: com.google.gson.b.a.ba */
/* compiled from: TypeAdapters */
class C10098ba implements C10055D {

    /* renamed from: a */
    final /* synthetic */ Class f30674a;

    /* renamed from: b */
    final /* synthetic */ C10054C f30675b;

    C10098ba(Class cls, C10054C c) {
        this.f30674a = cls;
        this.f30675b = c;
    }

    /* renamed from: a */
    public <T2> C10054C<T2> mo33201a(Gson gson, C10172a<T2> typeToken) {
        Class<? super T2> requestedType = typeToken.mo33420a();
        if (!this.f30674a.isAssignableFrom(requestedType)) {
            return null;
        }
        return new C10096aa(this, requestedType);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[typeHierarchy=");
        sb.append(this.f30674a.getName());
        sb.append(",adapter=");
        sb.append(this.f30675b);
        sb.append("]");
        return sb.toString();
    }
}
