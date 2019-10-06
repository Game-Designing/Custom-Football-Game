package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.JsonSyntaxException;
import com.google.gson.p192b.p193a.p194a.C10095a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.google.gson.b.a.e */
/* compiled from: DateTypeAdapter */
public final class C10104e extends C10054C<Date> {

    /* renamed from: a */
    public static final C10055D f30680a = new C10102d();

    /* renamed from: b */
    private final DateFormat f30681b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c */
    private final DateFormat f30682c = DateFormat.getDateTimeInstance(2, 2);

    /* renamed from: a */
    public Date m32948a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return m32946a(in.nextString());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    private synchronized Date m32946a(String json) {
        try {
        } catch (ParseException e) {
            try {
                return this.f30681b.parse(json);
            } catch (ParseException e2) {
                try {
                    return C10095a.m32929a(json, new ParsePosition(0));
                } catch (ParseException e3) {
                    throw new JsonSyntaxException(json, e3);
                }
            }
        }
        return this.f30682c.parse(json);
    }

    /* renamed from: a */
    public synchronized void mo33198a(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(this.f30681b.format(value));
        }
    }
}
