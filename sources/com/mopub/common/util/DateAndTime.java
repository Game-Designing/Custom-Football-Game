package com.mopub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateAndTime {

    /* renamed from: a */
    protected static DateAndTime f34583a = new DateAndTime();

    @Deprecated
    public static void setInstance(DateAndTime newInstance) {
        f34583a = newInstance;
    }

    public static TimeZone localTimeZone() {
        return f34583a.internalLocalTimeZone();
    }

    public static Date now() {
        return f34583a.internalNow();
    }

    public static String getTimeZoneOffsetString() {
        SimpleDateFormat format = new SimpleDateFormat("Z", Locale.US);
        format.setTimeZone(localTimeZone());
        return format.format(now());
    }

    public TimeZone internalLocalTimeZone() {
        return TimeZone.getDefault();
    }

    public Date internalNow() {
        return new Date();
    }
}
