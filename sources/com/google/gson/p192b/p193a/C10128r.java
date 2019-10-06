package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: com.google.gson.b.a.r */
/* compiled from: SqlDateTypeAdapter */
public final class C10128r extends C10054C<Date> {

    /* renamed from: a */
    public static final C10055D f30769a = new C10127q();

    /* renamed from: b */
    private final DateFormat f30770b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: a */
    public synchronized Date m33019a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            return new Date(this.f30770b.parse(in.nextString()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    /* renamed from: a */
    public synchronized void mo33198a(JsonWriter out, Date value) throws IOException {
        out.value(value == null ? null : this.f30770b.format(value));
    }
}
