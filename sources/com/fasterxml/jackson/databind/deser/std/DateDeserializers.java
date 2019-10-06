package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.TimeZone;

public class DateDeserializers {
    private static final HashSet<String> _classNames = new HashSet<>();

    @JacksonStdImpl
    public static class CalendarDeserializer extends DateBasedDeserializer<Calendar> {
        protected final Constructor<Calendar> _defaultCtor;

        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext x0, BeanProperty x1) throws JsonMappingException {
            return super.createContextual(x0, x1);
        }

        public CalendarDeserializer() {
            super(Calendar.class);
            this._defaultCtor = null;
        }

        public CalendarDeserializer(Class<? extends Calendar> cc) {
            super(cc);
            this._defaultCtor = ClassUtil.findConstructor(cc, false);
        }

        public CalendarDeserializer(CalendarDeserializer src, DateFormat df, String formatString) {
            super(src, df, formatString);
            this._defaultCtor = src._defaultCtor;
        }

        /* access modifiers changed from: protected */
        public CalendarDeserializer withDateFormat(DateFormat df, String formatString) {
            return new CalendarDeserializer(this, df, formatString);
        }

        public Calendar deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Date d = _parseDate(p, ctxt);
            if (d == null) {
                return null;
            }
            Constructor<Calendar> constructor = this._defaultCtor;
            if (constructor == null) {
                return ctxt.constructCalendar(d);
            }
            try {
                Calendar c = (Calendar) constructor.newInstance(new Object[0]);
                c.setTimeInMillis(d.getTime());
                TimeZone tz = ctxt.getTimeZone();
                if (tz != null) {
                    c.setTimeZone(tz);
                }
                return c;
            } catch (Exception e) {
                return (Calendar) ctxt.handleInstantiationProblem(handledType(), d, e);
            }
        }
    }

    protected static abstract class DateBasedDeserializer<T> extends StdScalarDeserializer<T> implements ContextualDeserializer {
        protected final DateFormat _customFormat;
        protected final String _formatString;

        /* access modifiers changed from: protected */
        public abstract DateBasedDeserializer<T> withDateFormat(DateFormat dateFormat, String str);

        protected DateBasedDeserializer(Class<?> clz) {
            super(clz);
            this._customFormat = null;
            this._formatString = null;
        }

        protected DateBasedDeserializer(DateBasedDeserializer<T> base, DateFormat format, String formatStr) {
            super(base._valueClass);
            this._customFormat = format;
            this._formatString = formatStr;
        }

        /* JADX WARNING: type inference failed for: r5v15 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.fasterxml.jackson.databind.JsonDeserializer<?> createContextual(com.fasterxml.jackson.databind.DeserializationContext r8, com.fasterxml.jackson.databind.BeanProperty r9) throws com.fasterxml.jackson.databind.JsonMappingException {
            /*
                r7 = this;
                java.lang.Class r0 = r7.handledType()
                com.fasterxml.jackson.annotation.JsonFormat$Value r0 = r7.findFormatOverrides(r8, r9, r0)
                if (r0 == 0) goto L_0x00d7
                java.util.TimeZone r1 = r0.getTimeZone()
                java.lang.Boolean r2 = r0.getLenient()
                boolean r3 = r0.hasPattern()
                if (r3 == 0) goto L_0x0047
                java.lang.String r3 = r0.getPattern()
                boolean r4 = r0.hasLocale()
                if (r4 == 0) goto L_0x0027
                java.util.Locale r4 = r0.getLocale()
                goto L_0x002b
            L_0x0027:
                java.util.Locale r4 = r8.getLocale()
            L_0x002b:
                java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
                r5.<init>(r3, r4)
                if (r1 != 0) goto L_0x0036
                java.util.TimeZone r1 = r8.getTimeZone()
            L_0x0036:
                r5.setTimeZone(r1)
                if (r2 == 0) goto L_0x0042
                boolean r6 = r2.booleanValue()
                r5.setLenient(r6)
            L_0x0042:
                com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer r6 = r7.withDateFormat(r5, r3)
                return r6
            L_0x0047:
                if (r1 == 0) goto L_0x0095
                com.fasterxml.jackson.databind.DeserializationConfig r3 = r8.getConfig()
                java.text.DateFormat r3 = r3.getDateFormat()
                java.lang.Class r4 = r3.getClass()
                java.lang.Class<com.fasterxml.jackson.databind.util.StdDateFormat> r5 = com.fasterxml.jackson.databind.util.StdDateFormat.class
                if (r4 != r5) goto L_0x007b
                boolean r4 = r0.hasLocale()
                if (r4 == 0) goto L_0x0064
                java.util.Locale r4 = r0.getLocale()
                goto L_0x0068
            L_0x0064:
                java.util.Locale r4 = r8.getLocale()
            L_0x0068:
                r5 = r3
                com.fasterxml.jackson.databind.util.StdDateFormat r5 = (com.fasterxml.jackson.databind.util.StdDateFormat) r5
                com.fasterxml.jackson.databind.util.StdDateFormat r5 = r5.withTimeZone(r1)
                com.fasterxml.jackson.databind.util.StdDateFormat r5 = r5.withLocale(r4)
                if (r2 == 0) goto L_0x0079
                com.fasterxml.jackson.databind.util.StdDateFormat r5 = r5.withLenient(r2)
            L_0x0079:
                r3 = r5
                goto L_0x008e
            L_0x007b:
                java.lang.Object r4 = r3.clone()
                r3 = r4
                java.text.DateFormat r3 = (java.text.DateFormat) r3
                r3.setTimeZone(r1)
                if (r2 == 0) goto L_0x008e
                boolean r4 = r2.booleanValue()
                r3.setLenient(r4)
            L_0x008e:
                java.lang.String r4 = r7._formatString
                com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer r4 = r7.withDateFormat(r3, r4)
                return r4
            L_0x0095:
                if (r2 == 0) goto L_0x00d7
                com.fasterxml.jackson.databind.DeserializationConfig r3 = r8.getConfig()
                java.text.DateFormat r3 = r3.getDateFormat()
                java.lang.String r4 = r7._formatString
                java.lang.Class r5 = r3.getClass()
                java.lang.Class<com.fasterxml.jackson.databind.util.StdDateFormat> r6 = com.fasterxml.jackson.databind.util.StdDateFormat.class
                if (r5 != r6) goto L_0x00b6
                r5 = r3
                com.fasterxml.jackson.databind.util.StdDateFormat r5 = (com.fasterxml.jackson.databind.util.StdDateFormat) r5
                com.fasterxml.jackson.databind.util.StdDateFormat r5 = r5.withLenient(r2)
                r3 = r5
                java.lang.String r4 = r5.toPattern()
                goto L_0x00ce
            L_0x00b6:
                java.lang.Object r5 = r3.clone()
                r3 = r5
                java.text.DateFormat r3 = (java.text.DateFormat) r3
                boolean r5 = r2.booleanValue()
                r3.setLenient(r5)
                boolean r5 = r3 instanceof java.text.SimpleDateFormat
                if (r5 == 0) goto L_0x00ce
                r5 = r3
                java.text.SimpleDateFormat r5 = (java.text.SimpleDateFormat) r5
                r5.toPattern()
            L_0x00ce:
                if (r4 != 0) goto L_0x00d2
                java.lang.String r4 = "[unknown]"
            L_0x00d2:
                com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer r5 = r7.withDateFormat(r3, r4)
                return r5
            L_0x00d7:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer.createContextual(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonDeserializer");
        }

        /* access modifiers changed from: protected */
        public Date _parseDate(JsonParser p, DeserializationContext ctxt) throws IOException {
            Date parse;
            if (this._customFormat == null || !p.hasToken(JsonToken.VALUE_STRING)) {
                return super._parseDate(p, ctxt);
            }
            String str = p.getText().trim();
            if (str.length() == 0) {
                return (Date) getEmptyValue(ctxt);
            }
            synchronized (this._customFormat) {
                try {
                    parse = this._customFormat.parse(str);
                } catch (ParseException e) {
                    return (Date) ctxt.handleWeirdStringValue(handledType(), str, "expected format \"%s\"", this._formatString);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parse;
        }
    }

    @JacksonStdImpl
    public static class DateDeserializer extends DateBasedDeserializer<Date> {
        public static final DateDeserializer instance = new DateDeserializer();

        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext x0, BeanProperty x1) throws JsonMappingException {
            return super.createContextual(x0, x1);
        }

        public DateDeserializer() {
            super(Date.class);
        }

        public DateDeserializer(DateDeserializer base, DateFormat df, String formatString) {
            super(base, df, formatString);
        }

        /* access modifiers changed from: protected */
        public DateDeserializer withDateFormat(DateFormat df, String formatString) {
            return new DateDeserializer(this, df, formatString);
        }

        public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return _parseDate(p, ctxt);
        }
    }

    public static class SqlDateDeserializer extends DateBasedDeserializer<java.sql.Date> {
        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext x0, BeanProperty x1) throws JsonMappingException {
            return super.createContextual(x0, x1);
        }

        public SqlDateDeserializer() {
            super(java.sql.Date.class);
        }

        public SqlDateDeserializer(SqlDateDeserializer src, DateFormat df, String formatString) {
            super(src, df, formatString);
        }

        /* access modifiers changed from: protected */
        public SqlDateDeserializer withDateFormat(DateFormat df, String formatString) {
            return new SqlDateDeserializer(this, df, formatString);
        }

        public java.sql.Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Date d = _parseDate(p, ctxt);
            if (d == null) {
                return null;
            }
            return new java.sql.Date(d.getTime());
        }
    }

    public static class TimestampDeserializer extends DateBasedDeserializer<Timestamp> {
        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext x0, BeanProperty x1) throws JsonMappingException {
            return super.createContextual(x0, x1);
        }

        public TimestampDeserializer() {
            super(Timestamp.class);
        }

        public TimestampDeserializer(TimestampDeserializer src, DateFormat df, String formatString) {
            super(src, df, formatString);
        }

        /* access modifiers changed from: protected */
        public TimestampDeserializer withDateFormat(DateFormat df, String formatString) {
            return new TimestampDeserializer(this, df, formatString);
        }

        public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Date d = _parseDate(p, ctxt);
            if (d == null) {
                return null;
            }
            return new Timestamp(d.getTime());
        }
    }

    static {
        for (Class name : new Class[]{Calendar.class, GregorianCalendar.class, java.sql.Date.class, Date.class, Timestamp.class}) {
            _classNames.add(name.getName());
        }
    }

    public static JsonDeserializer<?> find(Class<?> rawType, String clsName) {
        if (_classNames.contains(clsName)) {
            if (rawType == Calendar.class) {
                return new CalendarDeserializer();
            }
            if (rawType == Date.class) {
                return DateDeserializer.instance;
            }
            if (rawType == java.sql.Date.class) {
                return new SqlDateDeserializer();
            }
            if (rawType == Timestamp.class) {
                return new TimestampDeserializer();
            }
            if (rawType == GregorianCalendar.class) {
                return new CalendarDeserializer(GregorianCalendar.class);
            }
        }
        return null;
    }
}
