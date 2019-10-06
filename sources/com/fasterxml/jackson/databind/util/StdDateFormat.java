package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.p134io.NumberInput;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StdDateFormat extends DateFormat {
    protected static final String[] ALL_FORMATS;
    protected static final Calendar CALENDAR = new GregorianCalendar(DEFAULT_TIMEZONE, DEFAULT_LOCALE);
    protected static final DateFormat DATE_FORMAT_ISO8601;
    protected static final DateFormat DATE_FORMAT_RFC1123;
    protected static final Locale DEFAULT_LOCALE = Locale.US;
    protected static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("UTC");
    protected static final Pattern PATTERN_ISO8601 = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
    protected static final Pattern PATTERN_PLAIN = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");
    public static final StdDateFormat instance = new StdDateFormat();
    private transient Calendar _calendar;
    private transient DateFormat _formatRFC1123;
    protected Boolean _lenient;
    protected final Locale _locale;
    protected transient TimeZone _timezone;
    private boolean _tzSerializedWithColon;

    static {
        try {
            String str = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
            String str2 = "EEE, dd MMM yyyy HH:mm:ss zzz";
            ALL_FORMATS = new String[]{str, "yyyy-MM-dd'T'HH:mm:ss.SSS", str2, "yyyy-MM-dd"};
            DATE_FORMAT_RFC1123 = new SimpleDateFormat(str2, DEFAULT_LOCALE);
            DATE_FORMAT_RFC1123.setTimeZone(DEFAULT_TIMEZONE);
            DATE_FORMAT_ISO8601 = new SimpleDateFormat(str, DEFAULT_LOCALE);
            DATE_FORMAT_ISO8601.setTimeZone(DEFAULT_TIMEZONE);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public StdDateFormat() {
        this._tzSerializedWithColon = false;
        this._locale = DEFAULT_LOCALE;
    }

    protected StdDateFormat(TimeZone tz, Locale loc, Boolean lenient, boolean formatTzOffsetWithColon) {
        this._tzSerializedWithColon = false;
        this._timezone = tz;
        this._locale = loc;
        this._lenient = lenient;
        this._tzSerializedWithColon = formatTzOffsetWithColon;
    }

    public StdDateFormat withTimeZone(TimeZone tz) {
        if (tz == null) {
            tz = DEFAULT_TIMEZONE;
        }
        TimeZone timeZone = this._timezone;
        if (tz == timeZone || tz.equals(timeZone)) {
            return this;
        }
        return new StdDateFormat(tz, this._locale, this._lenient, this._tzSerializedWithColon);
    }

    public StdDateFormat withLocale(Locale loc) {
        if (loc.equals(this._locale)) {
            return this;
        }
        return new StdDateFormat(this._timezone, loc, this._lenient, this._tzSerializedWithColon);
    }

    public StdDateFormat withLenient(Boolean b) {
        if (_equals(b, this._lenient)) {
            return this;
        }
        return new StdDateFormat(this._timezone, this._locale, b, this._tzSerializedWithColon);
    }

    public StdDateFormat clone() {
        return new StdDateFormat(this._timezone, this._locale, this._lenient, this._tzSerializedWithColon);
    }

    public TimeZone getTimeZone() {
        return this._timezone;
    }

    public void setTimeZone(TimeZone tz) {
        if (!tz.equals(this._timezone)) {
            _clearFormats();
            this._timezone = tz;
        }
    }

    public void setLenient(boolean enabled) {
        Boolean newValue = Boolean.valueOf(enabled);
        if (!_equals(newValue, this._lenient)) {
            this._lenient = newValue;
            _clearFormats();
        }
    }

    public boolean isLenient() {
        Boolean bool = this._lenient;
        return bool == null || bool.booleanValue();
    }

    public Date parse(String dateStr) throws ParseException {
        String[] arr$;
        String dateStr2 = dateStr.trim();
        ParsePosition pos = new ParsePosition(0);
        Date dt = _parseDate(dateStr2, pos);
        if (dt != null) {
            return dt;
        }
        StringBuilder sb = new StringBuilder();
        for (String f : ALL_FORMATS) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(f);
        }
        sb.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{dateStr2, sb.toString()}), pos.getErrorIndex());
    }

    public Date parse(String dateStr, ParsePosition pos) {
        try {
            return _parseDate(dateStr, pos);
        } catch (ParseException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Date _parseDate(String dateStr, ParsePosition pos) throws ParseException {
        if (looksLikeISO8601(dateStr)) {
            return parseAsISO8601(dateStr, pos);
        }
        int i = dateStr.length();
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            char ch = dateStr.charAt(i);
            if ((ch < '0' || ch > '9') && (i > 0 || ch != '-')) {
                break;
            }
        }
        if (i >= 0 || (dateStr.charAt(0) != '-' && !NumberInput.inLongRange(dateStr, false))) {
            return parseAsRFC1123(dateStr, pos);
        }
        return _parseDateFromLong(dateStr, pos);
    }

    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        TimeZone tz = this._timezone;
        if (tz == null) {
            tz = DEFAULT_TIMEZONE;
        }
        _format(tz, this._locale, date, toAppendTo);
        return toAppendTo;
    }

    /* access modifiers changed from: protected */
    public void _format(TimeZone tz, Locale loc, Date date, StringBuffer buffer) {
        Calendar cal = _getCalendar(tz);
        cal.setTime(date);
        pad4(buffer, cal.get(1));
        char c = '-';
        buffer.append('-');
        pad2(buffer, cal.get(2) + 1);
        buffer.append('-');
        pad2(buffer, cal.get(5));
        buffer.append('T');
        pad2(buffer, cal.get(11));
        buffer.append(':');
        pad2(buffer, cal.get(12));
        buffer.append(':');
        pad2(buffer, cal.get(13));
        buffer.append('.');
        pad3(buffer, cal.get(14));
        int offset = tz.getOffset(cal.getTimeInMillis());
        if (offset != 0) {
            int hours = Math.abs((offset / 60000) / 60);
            int minutes = Math.abs((offset / 60000) % 60);
            if (offset >= 0) {
                c = '+';
            }
            buffer.append(c);
            pad2(buffer, hours);
            if (this._tzSerializedWithColon) {
                buffer.append(':');
            }
            pad2(buffer, minutes);
        } else if (this._tzSerializedWithColon) {
            buffer.append("+00:00");
        } else {
            buffer.append("+0000");
        }
    }

    private static void pad2(StringBuffer buffer, int value) {
        int tens = value / 10;
        if (tens == 0) {
            buffer.append('0');
        } else {
            buffer.append((char) (tens + 48));
            value -= tens * 10;
        }
        buffer.append((char) (value + 48));
    }

    private static void pad3(StringBuffer buffer, int value) {
        int h = value / 100;
        if (h == 0) {
            buffer.append('0');
        } else {
            buffer.append((char) (h + 48));
            value -= h * 100;
        }
        pad2(buffer, value);
    }

    private static void pad4(StringBuffer buffer, int value) {
        int h = value / 100;
        if (h == 0) {
            buffer.append('0');
            buffer.append('0');
        } else {
            pad2(buffer, h);
            value -= h * 100;
        }
        pad2(buffer, value);
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", new Object[]{getClass().getName(), this._timezone, this._locale, this._lenient});
    }

    public String toPattern() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("[one of: '");
        sb.append("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        sb.append("', '");
        sb.append("EEE, dd MMM yyyy HH:mm:ss zzz");
        sb.append("' (");
        sb.append(Boolean.FALSE.equals(this._lenient) ? "strict" : "lenient");
        sb.append(")]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        return o == this;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    /* access modifiers changed from: protected */
    public boolean looksLikeISO8601(String dateStr) {
        if (dateStr.length() < 7 || !Character.isDigit(dateStr.charAt(0)) || !Character.isDigit(dateStr.charAt(3)) || dateStr.charAt(4) != '-' || !Character.isDigit(dateStr.charAt(5))) {
            return false;
        }
        return true;
    }

    private Date _parseDateFromLong(String longStr, ParsePosition pos) throws ParseException {
        try {
            return new Date(NumberInput.parseLong(longStr));
        } catch (NumberFormatException e) {
            throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", new Object[]{longStr}), pos.getErrorIndex());
        }
    }

    /* access modifiers changed from: protected */
    public Date parseAsISO8601(String dateStr, ParsePosition pos) throws ParseException {
        try {
            return _parseAsISO8601(dateStr, pos);
        } catch (IllegalArgumentException e) {
            throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", new Object[]{dateStr, e.getMessage()}), pos.getErrorIndex());
        }
    }

    /* access modifiers changed from: protected */
    public Date _parseAsISO8601(String dateStr, ParsePosition bogus) throws IllegalArgumentException, ParseException {
        String formatStr;
        int seconds;
        int offsetSecs;
        String str = dateStr;
        int totalLen = dateStr.length();
        TimeZone tz = DEFAULT_TIMEZONE;
        if (!(this._timezone == null || 'Z' == str.charAt(totalLen - 1))) {
            tz = this._timezone;
        }
        Calendar cal = _getCalendar(tz);
        cal.clear();
        if (totalLen <= 10) {
            Matcher m = PATTERN_PLAIN.matcher(str);
            if (m.matches()) {
                Matcher matcher = m;
                cal.set(_parse4D(str, 0), _parse2D(str, 5) - 1, _parse2D(str, 8), 0, 0, 0);
                cal.set(14, 0);
                return cal.getTime();
            }
            formatStr = "yyyy-MM-dd";
            int i = totalLen;
        } else {
            Matcher m2 = PATTERN_ISO8601.matcher(str);
            if (m2.matches()) {
                int start = m2.start(2);
                int end = m2.end(2);
                int len = end - start;
                if (len > 1) {
                    int offsetSecs2 = _parse2D(str, start + 1) * 3600;
                    if (len >= 5) {
                        offsetSecs2 += _parse2D(str, end - 2) * 60;
                    }
                    if (str.charAt(start) == '-') {
                        offsetSecs = offsetSecs2 * -1000;
                    } else {
                        offsetSecs = offsetSecs2 * 1000;
                    }
                    cal.set(15, offsetSecs);
                    cal.set(16, 0);
                }
                int year = _parse4D(str, 0);
                int month = _parse2D(str, 5) - 1;
                int day = _parse2D(str, 8);
                int hour = _parse2D(str, 11);
                int minute = _parse2D(str, 14);
                if (totalLen <= 16 || str.charAt(16) != ':') {
                    seconds = 0;
                } else {
                    seconds = _parse2D(str, 17);
                }
                int i2 = len;
                int i3 = start;
                Matcher m3 = m2;
                cal.set(year, month, day, hour, minute, seconds);
                int start2 = m3.start(1) + 1;
                int end2 = m3.end(1);
                if (start2 >= end2) {
                    cal.set(14, 0);
                    int i4 = totalLen;
                } else {
                    int msecs = 0;
                    int fractLen = end2 - start2;
                    if (fractLen != 0) {
                        if (fractLen != 1) {
                            if (fractLen != 2) {
                                if (fractLen == 3) {
                                } else if (fractLen <= 9) {
                                    int i5 = totalLen;
                                } else {
                                    int i6 = totalLen;
                                    throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", new Object[]{str, m3.group(1).substring(1)}), start2);
                                }
                                msecs = 0 + (str.charAt(start2 + 2) - '0');
                            }
                            msecs += (str.charAt(start2 + 1) - '0') * 10;
                        }
                        msecs += (str.charAt(start2) - 48) * 100;
                    }
                    cal.set(14, msecs);
                }
                return cal.getTime();
            }
            Matcher matcher2 = m2;
            formatStr = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        }
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", new Object[]{str, formatStr, this._lenient}), 0);
    }

    private static int _parse4D(String str, int index) {
        return ((str.charAt(index) - '0') * 1000) + ((str.charAt(index + 1) - '0') * 100) + ((str.charAt(index + 2) - '0') * 10) + (str.charAt(index + 3) - '0');
    }

    private static int _parse2D(String str, int index) {
        return ((str.charAt(index) - '0') * 10) + (str.charAt(index + 1) - '0');
    }

    /* access modifiers changed from: protected */
    public Date parseAsRFC1123(String dateStr, ParsePosition pos) {
        if (this._formatRFC1123 == null) {
            this._formatRFC1123 = _cloneFormat(DATE_FORMAT_RFC1123, "EEE, dd MMM yyyy HH:mm:ss zzz", this._timezone, this._locale, this._lenient);
        }
        return this._formatRFC1123.parse(dateStr, pos);
    }

    private static final DateFormat _cloneFormat(DateFormat df, String format, TimeZone tz, Locale loc, Boolean lenient) {
        DateFormat df2;
        if (!loc.equals(DEFAULT_LOCALE)) {
            df2 = new SimpleDateFormat(format, loc);
            df2.setTimeZone(tz == null ? DEFAULT_TIMEZONE : tz);
        } else {
            df2 = (DateFormat) df.clone();
            if (tz != null) {
                df2.setTimeZone(tz);
            }
        }
        if (lenient != null) {
            df2.setLenient(lenient.booleanValue());
        }
        return df2;
    }

    /* access modifiers changed from: protected */
    public void _clearFormats() {
        this._formatRFC1123 = null;
    }

    /* access modifiers changed from: protected */
    public Calendar _getCalendar(TimeZone tz) {
        Calendar cal = this._calendar;
        if (cal == null) {
            Calendar calendar = (Calendar) CALENDAR.clone();
            cal = calendar;
            this._calendar = calendar;
        }
        if (!cal.getTimeZone().equals(tz)) {
            cal.setTimeZone(tz);
        }
        cal.setLenient(isLenient());
        return cal;
    }

    protected static <T> boolean _equals(T value1, T value2) {
        boolean z = true;
        if (value1 == value2) {
            return true;
        }
        if (value1 == null || !value1.equals(value2)) {
            z = false;
        }
        return z;
    }
}
