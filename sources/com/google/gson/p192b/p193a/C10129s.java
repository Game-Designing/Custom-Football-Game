package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;
import java.sql.Time;

/* renamed from: com.google.gson.b.a.s */
/* compiled from: TimeTypeAdapter */
class C10129s implements C10055D {
    C10129s() {
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        if (typeToken.mo33420a() == Time.class) {
            return new C10130t();
        }
        return null;
    }
}
