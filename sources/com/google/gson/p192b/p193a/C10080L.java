package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;

/* renamed from: com.google.gson.b.a.L */
/* compiled from: TypeAdapters */
class C10080L extends C10054C<InetAddress> {
    C10080L() {
    }

    /* renamed from: a */
    public InetAddress m32889a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return InetAddress.getByName(in.nextString());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, InetAddress value) throws IOException {
        out.value(value == null ? null : value.getHostAddress());
    }
}
