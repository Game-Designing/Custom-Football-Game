package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: com.google.gson.b.a.Q */
/* compiled from: TypeAdapters */
class C10085Q extends C10054C<Calendar> {
    C10085Q() {
    }

    /* renamed from: a */
    public Calendar m32906a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        int year = 0;
        int month = 0;
        int dayOfMonth = 0;
        int hourOfDay = 0;
        int minute = 0;
        int second = 0;
        while (in.peek() != JsonToken.END_OBJECT) {
            String name = in.nextName();
            int value = in.nextInt();
            if ("year".equals(name)) {
                year = value;
            } else if ("month".equals(name)) {
                month = value;
            } else if ("dayOfMonth".equals(name)) {
                dayOfMonth = value;
            } else if ("hourOfDay".equals(name)) {
                hourOfDay = value;
            } else if ("minute".equals(name)) {
                minute = value;
            } else if ("second".equals(name)) {
                second = value;
            }
        }
        in.endObject();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
        return gregorianCalendar;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Calendar value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("year");
        out.value((long) value.get(1));
        out.name("month");
        out.value((long) value.get(2));
        out.name("dayOfMonth");
        out.value((long) value.get(5));
        out.name("hourOfDay");
        out.value((long) value.get(11));
        out.name("minute");
        out.value((long) value.get(12));
        out.name("second");
        out.value((long) value.get(13));
        out.endObject();
    }
}
