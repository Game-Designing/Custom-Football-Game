package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.j */
/* compiled from: Gson */
class C10179j extends C10054C<Number> {

    /* renamed from: a */
    final /* synthetic */ Gson f30868a;

    C10179j(Gson this$0) {
        this.f30868a = this$0;
    }

    /* renamed from: a */
    public Double m33128a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return Double.valueOf(in.nextDouble());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Number value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        Gson.checkValidFloatingPoint(value.doubleValue());
        out.value(value);
    }
}
