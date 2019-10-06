package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.gson.b.a.O */
/* compiled from: TypeAdapters */
class C10083O extends C10054C<Timestamp> {

    /* renamed from: a */
    final /* synthetic */ C10054C f30656a;

    /* renamed from: b */
    final /* synthetic */ C10084P f30657b;

    C10083O(C10084P this$0, C10054C c) {
        this.f30657b = this$0;
        this.f30656a = c;
    }

    /* renamed from: a */
    public Timestamp m32901a(JsonReader in) throws IOException {
        Date date = (Date) this.f30656a.mo33197a(in);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Timestamp value) throws IOException {
        this.f30656a.mo33198a(out, value);
    }
}
