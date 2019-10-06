package com.google.gson;

import com.google.gson.p192b.p193a.p194a.C10095a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.google.gson.a */
/* compiled from: DefaultDateTypeAdapter */
final class C10057a extends C10054C<Date> {

    /* renamed from: a */
    private final Class<? extends Date> f30643a;

    /* renamed from: b */
    private final DateFormat f30644b;

    /* renamed from: c */
    private final DateFormat f30645c;

    C10057a(Class<? extends Date> dateType, String datePattern) {
        this(dateType, (DateFormat) new SimpleDateFormat(datePattern, Locale.US), (DateFormat) new SimpleDateFormat(datePattern));
    }

    public C10057a(Class<? extends Date> dateType, int dateStyle, int timeStyle) {
        this(dateType, DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.US), DateFormat.getDateTimeInstance(dateStyle, timeStyle));
    }

    C10057a(Class<? extends Date> dateType, DateFormat enUsFormat, DateFormat localFormat) {
        if (dateType == Date.class || dateType == java.sql.Date.class || dateType == Timestamp.class) {
            this.f30643a = dateType;
            this.f30644b = enUsFormat;
            this.f30645c = localFormat;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Date type must be one of ");
        sb.append(Date.class);
        sb.append(", ");
        sb.append(Timestamp.class);
        sb.append(", or ");
        sb.append(java.sql.Date.class);
        sb.append(" but was ");
        sb.append(dateType);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        synchronized (this.f30645c) {
            out.value(this.f30644b.format(value));
        }
    }

    /* renamed from: a */
    public Date m32824a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        Date date = m32822a(in.nextString());
        Class<? extends Date> cls = this.f30643a;
        if (cls == Date.class) {
            return date;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(date.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(date.getTime());
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private Date m32822a(String s) {
        Date parse;
        synchronized (this.f30645c) {
            try {
                parse = this.f30645c.parse(s);
            } catch (ParseException e) {
                try {
                    return this.f30644b.parse(s);
                } catch (ParseException e2) {
                    throw new JsonSyntaxException(s, e2);
                } catch (ParseException e3) {
                    return C10095a.m32929a(s, new ParsePosition(0));
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DefaultDateTypeAdapter");
        sb.append('(');
        sb.append(this.f30645c.getClass().getSimpleName());
        sb.append(')');
        return sb.toString();
    }
}
