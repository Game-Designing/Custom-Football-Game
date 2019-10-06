package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.BitSet;

/* renamed from: com.google.gson.b.a.U */
/* compiled from: TypeAdapters */
class C10088U extends C10054C<BitSet> {
    C10088U() {
    }

    /* renamed from: a */
    public BitSet m32918a(JsonReader in) throws IOException {
        BitSet bitset = new BitSet();
        in.beginArray();
        int i = 0;
        JsonToken tokenType = in.peek();
        while (tokenType != JsonToken.END_ARRAY) {
            int i2 = C10101ca.f30679a[tokenType.ordinal()];
            boolean set = false;
            if (i2 != 1) {
                if (i2 == 2) {
                    set = in.nextBoolean();
                } else if (i2 == 3) {
                    String stringValue = in.nextString();
                    try {
                        if (Integer.parseInt(stringValue) != 0) {
                            set = true;
                        }
                    } catch (NumberFormatException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error: Expecting: bitset number value (1, 0), Found: ");
                        sb.append(stringValue);
                        throw new JsonSyntaxException(sb.toString());
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid bitset value type: ");
                    sb2.append(tokenType);
                    throw new JsonSyntaxException(sb2.toString());
                }
            } else if (in.nextInt() != 0) {
                set = true;
            }
            if (set) {
                bitset.set(i);
            }
            i++;
            tokenType = in.peek();
        }
        in.endArray();
        return bitset;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, BitSet src) throws IOException {
        out.beginArray();
        int length = src.length();
        for (int i = 0; i < length; i++) {
            out.value((long) src.get(i));
        }
        out.endArray();
    }
}
