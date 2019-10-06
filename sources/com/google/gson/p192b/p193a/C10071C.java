package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.C */
/* compiled from: TypeAdapters */
class C10071C extends C10054C<Character> {
    C10071C() {
    }

    /* renamed from: a */
    public Character m32853a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        String str = in.nextString();
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expecting character, got: ");
        sb.append(str);
        throw new JsonSyntaxException(sb.toString());
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Character value) throws IOException {
        out.value(value == null ? null : String.valueOf(value));
    }
}
