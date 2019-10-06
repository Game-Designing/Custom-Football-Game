package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* renamed from: com.google.gson.b.a.K */
/* compiled from: TypeAdapters */
class C10079K extends C10054C<URI> {
    C10079K() {
    }

    /* renamed from: a */
    public URI m32885a(JsonReader in) throws IOException {
        URI uri = null;
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            String nextString = in.nextString();
            if (!"null".equals(nextString)) {
                uri = new URI(nextString);
            }
            return uri;
        } catch (URISyntaxException e) {
            throw new JsonIOException((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, URI value) throws IOException {
        out.value(value == null ? null : value.toASCIIString());
    }
}
