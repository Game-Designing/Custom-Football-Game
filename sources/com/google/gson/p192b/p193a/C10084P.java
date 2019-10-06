package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p195c.C10172a;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.gson.b.a.P */
/* compiled from: TypeAdapters */
class C10084P implements C10055D {
    C10084P() {
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        if (typeToken.mo33420a() != Timestamp.class) {
            return null;
        }
        return new C10083O(this, gson.getAdapter(Date.class));
    }
}
