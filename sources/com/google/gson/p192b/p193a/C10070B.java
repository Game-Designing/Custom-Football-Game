package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.p192b.C10161u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.B */
/* compiled from: TypeAdapters */
class C10070B extends C10054C<Number> {
    C10070B() {
    }

    /* renamed from: a */
    public Number m32849a(JsonReader in) throws IOException {
        JsonToken jsonToken = in.peek();
        int i = C10101ca.f30679a[jsonToken.ordinal()];
        if (i == 1 || i == 3) {
            return new C10161u(in.nextString());
        }
        if (i == 4) {
            in.nextNull();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expecting number, got: ");
        sb.append(jsonToken);
        throw new JsonSyntaxException(sb.toString());
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Number value) throws IOException {
        out.value(value);
    }
}
