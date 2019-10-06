package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;
import java.sql.Date;

/* renamed from: com.google.gson.b.a.q */
/* compiled from: SqlDateTypeAdapter */
class C10127q implements C10055D {
    C10127q() {
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        if (typeToken.mo33420a() == Date.class) {
            return new C10128r();
        }
        return null;
    }
}
