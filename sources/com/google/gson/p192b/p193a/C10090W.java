package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;

/* renamed from: com.google.gson.b.a.W */
/* compiled from: TypeAdapters */
class C10090W implements C10055D {

    /* renamed from: a */
    final /* synthetic */ C10172a f30658a;

    /* renamed from: b */
    final /* synthetic */ C10054C f30659b;

    C10090W(C10172a aVar, C10054C c) {
        this.f30658a = aVar;
        this.f30659b = c;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        if (typeToken.equals(this.f30658a)) {
            return this.f30659b;
        }
        return null;
    }
}
