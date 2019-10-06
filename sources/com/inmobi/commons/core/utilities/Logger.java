package com.inmobi.commons.core.utilities;

import android.util.Log;

public final class Logger {

    /* renamed from: a */
    private static InternalLogLevel f32596a = ("row".contains("staging") ? InternalLogLevel.INTERNAL : InternalLogLevel.NONE);

    /* renamed from: com.inmobi.commons.core.utilities.Logger$1 */
    static /* synthetic */ class C106801 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32597a = new int[InternalLogLevel.values().length];

        static {
            try {
                f32597a[InternalLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f32597a[InternalLogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f32597a[InternalLogLevel.INTERNAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum InternalLogLevel {
        NONE,
        ERROR,
        DEBUG,
        INTERNAL
    }

    /* renamed from: a */
    public static void m35065a(InternalLogLevel internalLogLevel, String str, String str2) {
        if (internalLogLevel.ordinal() <= f32596a.ordinal()) {
            int i = C106801.f32597a[internalLogLevel.ordinal()];
            String str3 = "[InMobi]";
            if (i == 1) {
                Log.e(str3, str2);
            } else if (i == 2) {
                Log.d(str3, str2);
            } else if (i == 3) {
                if (str2.length() > 4000) {
                    while (str2.length() > 4000) {
                        Log.d(str, str2.substring(0, 4000));
                        str2 = str2.substring(4000);
                    }
                    Log.d(str, str2);
                    return;
                }
                Log.d(str, str2);
            }
        }
    }

    /* renamed from: a */
    public static void m35066a(InternalLogLevel internalLogLevel, String str, String str2, Throwable th) {
        if (internalLogLevel.ordinal() <= f32596a.ordinal()) {
            int i = C106801.f32597a[internalLogLevel.ordinal()];
            String str3 = "[InMobi]";
            if (i == 1) {
                Log.e(str3, str2, th);
            } else if (i == 2) {
                Log.d(str3, str2, th);
            } else if (i == 3) {
                Log.d(str, str2, th);
            }
        }
    }

    /* renamed from: a */
    public static void m35064a(InternalLogLevel internalLogLevel) {
        f32596a = internalLogLevel;
    }
}
