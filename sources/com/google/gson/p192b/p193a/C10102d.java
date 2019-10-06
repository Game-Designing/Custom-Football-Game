package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;
import java.util.Date;

/* renamed from: com.google.gson.b.a.d */
/* compiled from: DateTypeAdapter */
class C10102d implements C10055D {
    C10102d() {
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        if (typeToken.mo33420a() == Date.class) {
            return new C10104e();
        }
        return null;
    }
}
