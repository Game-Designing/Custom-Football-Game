package com.mopub.common;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.IllegalFormatException;

public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    public static final class NoThrow {

        /* renamed from: a */
        private static volatile boolean f34353a = false;

        public static void setStrictMode(boolean strictMode) {
            f34353a = strictMode;
        }

        public static boolean checkArgument(boolean expression) {
            return Preconditions.m37041c(expression, f34353a, "Illegal argument", "");
        }

        public static boolean checkArgument(boolean expression, String errorMessage) {
            return Preconditions.m37041c(expression, f34353a, errorMessage, "");
        }

        public static boolean checkArgument(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
            return Preconditions.m37041c(expression, f34353a, errorMessageTemplate, errorMessageArgs);
        }

        public static boolean checkState(boolean expression) {
            return Preconditions.m37042d(expression, f34353a, "Illegal state.", "");
        }

        public static boolean checkState(boolean expression, String errorMessage) {
            return Preconditions.m37042d(expression, f34353a, errorMessage, "");
        }

        public static boolean checkState(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
            return Preconditions.m37042d(expression, f34353a, errorMessageTemplate, errorMessageArgs);
        }

        public static boolean checkNotNull(Object reference) {
            return Preconditions.m37038b(reference, f34353a, "Object can not be null.", "");
        }

        public static boolean checkNotNull(Object reference, String errorMessage) {
            return Preconditions.m37038b(reference, f34353a, errorMessage, "");
        }

        public static boolean checkNotNull(Object reference, String errorMessageTemplate, Object... errorMessageArgs) {
            return Preconditions.m37038b(reference, f34353a, errorMessageTemplate, errorMessageArgs);
        }

        public static boolean checkUiThread() {
            return Preconditions.m37039b(f34353a, "This method must be called from the UI thread.", "");
        }

        public static boolean checkUiThread(String errorMessage) {
            return Preconditions.m37039b(f34353a, errorMessage, "");
        }

        public static boolean checkUiThread(String errorMessageTemplate, Object... errorMessageArgs) {
            return Preconditions.m37039b(false, errorMessageTemplate, errorMessageArgs);
        }
    }

    private Preconditions() {
    }

    public static void checkArgument(boolean expression) {
        m37041c(expression, true, "Illegal argument.", "");
    }

    public static void checkArgument(boolean expression, String errorMessage) {
        m37041c(expression, true, errorMessage, "");
    }

    public static void checkArgument(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        m37041c(expression, true, errorMessageTemplate, errorMessageArgs);
    }

    public static void checkState(boolean expression) {
        m37042d(expression, true, "Illegal state.", "");
    }

    public static void checkState(boolean expression, String errorMessage) {
        m37042d(expression, true, errorMessage, "");
    }

    public static void checkState(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        m37042d(expression, true, errorMessageTemplate, errorMessageArgs);
    }

    public static void checkNotNull(Object reference) {
        m37038b(reference, true, "Object can not be null.", "");
    }

    public static void checkNotNull(Object reference, String errorMessage) {
        m37038b(reference, true, errorMessage, "");
    }

    public static void checkNotNull(Object reference, String errorMessageTemplate, Object... errorMessageArgs) {
        m37038b(reference, true, errorMessageTemplate, errorMessageArgs);
    }

    public static void checkUiThread() {
        m37039b(true, "This method must be called from the UI thread.", "");
    }

    public static void checkUiThread(String errorMessage) {
        m37039b(true, errorMessage, "");
    }

    public static void checkUiThread(String errorMessageTemplate, Object... errorMessageArgs) {
        m37039b(true, errorMessageTemplate, errorMessageArgs);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m37041c(boolean expression, boolean allowThrow, String errorMessageTemplate, Object... errorMessageArgs) {
        if (expression) {
            return true;
        }
        String errorMessage = m37034a(errorMessageTemplate, errorMessageArgs);
        if (!allowThrow) {
            MoPubLog.log(SdkLogEvent.CUSTOM, errorMessage);
            return false;
        }
        throw new IllegalArgumentException(errorMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m37042d(boolean expression, boolean allowThrow, String errorMessageTemplate, Object... errorMessageArgs) {
        if (expression) {
            return true;
        }
        String errorMessage = m37034a(errorMessageTemplate, errorMessageArgs);
        if (!allowThrow) {
            MoPubLog.log(SdkLogEvent.CUSTOM, errorMessage);
            return false;
        }
        throw new IllegalStateException(errorMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m37038b(Object reference, boolean allowThrow, String errorMessageTemplate, Object... errorMessageArgs) {
        if (reference != null) {
            return true;
        }
        String errorMessage = m37034a(errorMessageTemplate, errorMessageArgs);
        if (!allowThrow) {
            MoPubLog.log(SdkLogEvent.CUSTOM, errorMessage);
            return false;
        }
        throw new NullPointerException(errorMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m37039b(boolean allowThrow, String errorMessageTemplate, Object... errorMessageArgs) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String errorMessage = m37034a(errorMessageTemplate, errorMessageArgs);
        if (!allowThrow) {
            MoPubLog.log(SdkLogEvent.CUSTOM, errorMessage);
            return false;
        }
        throw new IllegalStateException(errorMessage);
    }

    /* renamed from: a */
    private static String m37034a(String template, Object... args) {
        String template2 = String.valueOf(template);
        try {
            return String.format(template2, args);
        } catch (IllegalFormatException exception) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("MoPub preconditions had a format exception: ");
            sb.append(exception.getMessage());
            MoPubLog.log(sdkLogEvent, sb.toString());
            return template2;
        }
    }
}
