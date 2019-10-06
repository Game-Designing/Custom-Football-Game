package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: com.google.gson.b.a.t */
/* compiled from: TimeTypeAdapter */
public final class C10130t extends C10054C<Time> {

    /* renamed from: a */
    public static final C10055D f30771a = new C10129s();

    /* renamed from: b */
    private final DateFormat f30772b = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: a */
    public synchronized Time m33024a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            return new Time(this.f30772b.parse(in.nextString()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    /* renamed from: a */
    public synchronized void mo33198a(JsonWriter out, Time value) throws IOException {
        out.value(value == null ? null : this.f30772b.format(value));
    }
}
