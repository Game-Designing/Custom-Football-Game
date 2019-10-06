package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

/* renamed from: com.google.gson.b.a.J */
/* compiled from: TypeAdapters */
class C10078J extends C10054C<URL> {
    C10078J() {
    }

    /* renamed from: a */
    public URL m32881a(JsonReader in) throws IOException {
        URL url = null;
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        String nextString = in.nextString();
        if (!"null".equals(nextString)) {
            url = new URL(nextString);
        }
        return url;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, URL value) throws IOException {
        out.value(value == null ? null : value.toExternalForm());
    }
}
