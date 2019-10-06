package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;

/* renamed from: com.google.gson.b.a.V */
/* compiled from: TypeAdapters */
class C10089V implements C10055D {
    C10089V() {
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        Class<? super T> rawType = typeToken.mo33420a();
        if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
        }
        if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
        }
        return new C10119a(rawType);
    }
}
