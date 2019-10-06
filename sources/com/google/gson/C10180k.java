package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.k */
/* compiled from: Gson */
class C10180k extends C10054C<Number> {

    /* renamed from: a */
    final /* synthetic */ Gson f30869a;

    C10180k(Gson this$0) {
        this.f30869a = this$0;
    }

    /* renamed from: a */
    public Float m33132a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return Float.valueOf((float) in.nextDouble());
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
        Gson.checkValidFloatingPoint((double) value.floatValue());
        out.value(value);
    }
}
