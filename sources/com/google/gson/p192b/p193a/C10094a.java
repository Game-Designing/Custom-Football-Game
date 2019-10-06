package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p192b.C10139b;
import com.google.gson.p195c.C10172a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: com.google.gson.b.a.a */
/* compiled from: ArrayTypeAdapter */
class C10094a implements C10055D {
    C10094a() {
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        Type type = typeToken.mo33421b();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type componentType = C10139b.m33064d(type);
        return new C10097b(gson, gson.getAdapter(C10172a.m33120a(componentType)), C10139b.m33065e(componentType));
    }
}
