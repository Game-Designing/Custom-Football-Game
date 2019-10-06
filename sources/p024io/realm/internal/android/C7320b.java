package p024io.realm.internal.android;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* renamed from: io.realm.internal.android.b */
/* compiled from: ISO8601Utils */
public class C7320b {

    /* renamed from: a */
    private static final TimeZone f14283a = TimeZone.getTimeZone("UTC");

    /* renamed from: b */
    private static final TimeZone f14284b = f14283a;

    /* renamed from: a */
    public static Date m16081a(String date, ParsePosition pos) throws ParseException {
        String input;
        TimeZone timezone;
        int offset;
        int offset2;
        int offset3;
        String str = date;
        ParsePosition parsePosition = pos;
        String str2 = "'";
        try {
            int offset4 = pos.getIndex();
            int offset5 = offset4 + 4;
            int year = m16080a(str, offset4, offset5);
            if (m16082a(str, offset5, '-')) {
                offset5++;
            }
            int offset6 = offset5 + 2;
            int month = m16080a(str, offset5, offset6);
            if (m16082a(str, offset6, '-')) {
                offset6++;
            }
            int offset7 = offset6 + 2;
            int day = m16080a(str, offset6, offset7);
            int hour = 0;
            int minutes = 0;
            int seconds = 0;
            int milliseconds = 0;
            boolean hasT = m16082a(str, offset7, 'T');
            if (hasT || date.length() > offset7) {
                if (hasT) {
                    int offset8 = offset7 + 1;
                    int offset9 = offset8 + 2;
                    hour = m16080a(str, offset8, offset9);
                    if (m16082a(str, offset9, ':')) {
                        offset9++;
                    }
                    int offset10 = offset9 + 2;
                    minutes = m16080a(str, offset9, offset10);
                    if (m16082a(str, offset10, ':')) {
                        offset7 = offset10 + 1;
                    } else {
                        offset7 = offset10;
                    }
                    if (date.length() > offset7) {
                        char c = str.charAt(offset7);
                        if (c == 'Z' || c == '+' || c == '-') {
                        } else {
                            int offset11 = offset7 + 2;
                            int seconds2 = m16080a(str, offset7, offset11);
                            if (seconds2 <= 59 || seconds2 >= 63) {
                                seconds = seconds2;
                            } else {
                                seconds = 59;
                            }
                            if (m16082a(str, offset11, '.')) {
                                int offset12 = offset11 + 1;
                                offset7 = m16079a(str, offset12 + 1);
                                int parseEndOffset = Math.min(offset7, offset12 + 3);
                                int fraction = m16080a(str, offset12, parseEndOffset);
                                int i = parseEndOffset - offset12;
                                char c2 = c;
                                if (i == 1) {
                                    milliseconds = fraction * 100;
                                } else if (i != 2) {
                                    milliseconds = fraction;
                                } else {
                                    milliseconds = fraction * 10;
                                }
                                int milliseconds2 = offset7;
                            } else {
                                offset7 = offset11;
                            }
                        }
                    }
                }
                if (date.length() > offset7) {
                    char timezoneIndicator = str.charAt(offset7);
                    if (timezoneIndicator == 'Z') {
                        timezone = f14284b;
                        offset = offset7 + 1;
                        char c3 = timezoneIndicator;
                        boolean z = hasT;
                    } else {
                        if (timezoneIndicator != '+') {
                            if (timezoneIndicator != '-') {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Invalid time zone indicator '");
                                sb.append(timezoneIndicator);
                                sb.append(str2);
                                throw new IndexOutOfBoundsException(sb.toString());
                            }
                        }
                        String timezoneOffset = str.substring(offset7);
                        int offset13 = offset7 + timezoneOffset.length();
                        if ("+0000".equals(timezoneOffset)) {
                            offset3 = offset13;
                            boolean z2 = hasT;
                        } else if ("+00:00".equals(timezoneOffset)) {
                            char c4 = timezoneIndicator;
                            offset3 = offset13;
                            boolean z3 = hasT;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("GMT");
                            sb2.append(timezoneOffset);
                            String timezoneId = sb2.toString();
                            TimeZone timezone2 = TimeZone.getTimeZone(timezoneId);
                            char c5 = timezoneIndicator;
                            String act = timezone2.getID();
                            if (!act.equals(timezoneId)) {
                                offset2 = offset13;
                                boolean z4 = hasT;
                                String cleaned = act.replace(":", "");
                                if (!cleaned.equals(timezoneId)) {
                                    String str3 = act;
                                    StringBuilder sb3 = new StringBuilder();
                                    String str4 = cleaned;
                                    sb3.append("Mismatching time zone indicator: ");
                                    sb3.append(timezoneId);
                                    sb3.append(" given, resolves to ");
                                    sb3.append(timezone2.getID());
                                    throw new IndexOutOfBoundsException(sb3.toString());
                                }
                            } else {
                                offset2 = offset13;
                                boolean z5 = hasT;
                            }
                            timezone = timezone2;
                            offset = offset2;
                        }
                        timezone = f14284b;
                        offset = offset2;
                    }
                    Calendar calendar = new GregorianCalendar(timezone);
                    calendar.setLenient(false);
                    calendar.set(1, year);
                    calendar.set(2, month - 1);
                    calendar.set(5, day);
                    calendar.set(11, hour);
                    calendar.set(12, minutes);
                    calendar.set(13, seconds);
                    calendar.set(14, milliseconds);
                    parsePosition.setIndex(offset);
                    return calendar.getTime();
                }
                throw new IllegalArgumentException("No time zone indicator");
            }
            Calendar calendar2 = new GregorianCalendar(year, month - 1, day);
            parsePosition.setIndex(offset7);
            return calendar2.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException fail) {
            if (str == null) {
                input = null;
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append('\"');
                sb4.append(str);
                sb4.append(str2);
                input = sb4.toString();
            }
            String msg = fail.getMessage();
            if (msg == null || msg.isEmpty()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("(");
                sb5.append(fail.getClass().getName());
                sb5.append(")");
                msg = sb5.toString();
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Failed to parse date [");
            sb6.append(input);
            sb6.append("]: ");
            sb6.append(msg);
            ParseException ex = new ParseException(sb6.toString(), pos.getIndex());
            ex.initCause(fail);
            throw ex;
        }
    }

    /* renamed from: a */
    private static boolean m16082a(String value, int offset, char expected) {
        return offset < value.length() && value.charAt(offset) == expected;
    }

    /* renamed from: a */
    private static int m16080a(String value, int beginIndex, int endIndex) throws NumberFormatException {
        if (beginIndex < 0 || endIndex > value.length() || beginIndex > endIndex) {
            throw new NumberFormatException(value);
        }
        int digit = beginIndex;
        int result = 0;
        String str = "Invalid number: ";
        if (digit < endIndex) {
            int i = digit + 1;
            int digit2 = Character.digit(value.charAt(digit), 10);
            if (digit2 >= 0) {
                result = -digit2;
                digit = i;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(value.substring(beginIndex, endIndex));
                throw new NumberFormatException(sb.toString());
            }
        }
        while (digit < endIndex) {
            int i2 = digit + 1;
            int digit3 = Character.digit(value.charAt(digit), 10);
            if (digit3 >= 0) {
                result = (result * 10) - digit3;
                digit = i2;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(value.substring(beginIndex, endIndex));
                throw new NumberFormatException(sb2.toString());
            }
        }
        return -result;
    }

    /* renamed from: a */
    private static int m16079a(String string, int offset) {
        for (int i = offset; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return i;
            }
        }
        return string.length();
    }
}
