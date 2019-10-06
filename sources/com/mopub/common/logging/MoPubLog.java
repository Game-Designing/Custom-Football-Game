package com.mopub.common.logging;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Strings;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1268l;

public class MoPubLog {
    public static final String LOGTAG = "MoPub";

    /* renamed from: a */
    private static final MoPubLog f34412a = new MoPubLog();

    /* renamed from: b */
    private LogLevel f34413b = LogLevel.INFO;

    /* renamed from: c */
    private Map<MoPubLogger, LogLevel> f34414c = new HashMap();

    /* renamed from: d */
    private MoPubLogger f34415d = new MoPubDefaultLogger();

    public enum LogLevel implements LogLevelInt {
        DEBUG(20, r2),
        INFO(30, r3),
        NONE(70, r4);
        

        /* renamed from: b */
        private int f126b;

        /* renamed from: c */
        private String f127c;

        private LogLevel(int level, String levelString) {
            this.f126b = level;
            this.f127c = levelString;
        }

        public String toString() {
            return this.f127c;
        }

        public int intValue() {
            return this.f126b;
        }

        public static LogLevel valueOf(int level) {
            if (level == 20) {
                return DEBUG;
            }
            if (level != 30) {
                return NONE;
            }
            return INFO;
        }
    }

    public interface LogLevelInt {
        public static final int DEBUG_INT = 20;
        public static final int INFO_INT = 30;
        public static final int NONE_INT = 70;
    }

    public enum AdLogEvent implements C11252a {
        REQUESTED(LogLevel.DEBUG, "Ad requesting from AdServer: {0}\n{1}"),
        RESPONSE_RECEIVED(LogLevel.DEBUG, "Ad server responded with:\n{0}"),
        LOAD_ATTEMPTED(LogLevel.INFO, "Ad attempting to load"),
        LOAD_SUCCESS(LogLevel.INFO, "Ad loaded"),
        LOAD_FAILED(LogLevel.INFO, "Ad failed to load: ({0}) {1}"),
        SHOW_ATTEMPTED(LogLevel.INFO, "Attempting to show ad"),
        SHOW_SUCCESS(LogLevel.INFO, "Ad shown"),
        SHOW_FAILED(LogLevel.INFO, "Ad failed to show: ({0}) {1}"),
        EXPIRED(LogLevel.DEBUG, "Ad expired since it was not shown within {0} seconds of it being loaded"),
        CLICKED(LogLevel.DEBUG, "Ad clicked"),
        WILL_APPEAR(LogLevel.DEBUG, "Ad will appear"),
        DID_APPEAR(LogLevel.DEBUG, "Ad did appear"),
        WILL_DISAPPEAR(LogLevel.DEBUG, "Ad will disappear"),
        DID_DISAPPEAR(LogLevel.DEBUG, "Ad did disappear"),
        SHOULD_REWARD(LogLevel.DEBUG, "Ad should reward user with {0} {1}"),
        WILL_LEAVE_APPLICATION(LogLevel.DEBUG, "Ad will leave application"),
        CUSTOM(LogLevel.DEBUG, "Ad Log - {0}"),
        CUSTOM_WITH_THROWABLE(LogLevel.DEBUG, "Ad Log With Throwable - {0}, {1}");
        

        /* renamed from: b */
        private LogLevel f34417b;

        /* renamed from: c */
        private String f34418c;

        private AdLogEvent(LogLevel logLevel, String messageFormat) {
            Preconditions.checkNotNull(logLevel);
            Preconditions.checkNotNull(messageFormat);
            this.f34417b = logLevel;
            this.f34418c = messageFormat;
        }

        public String getMessage(Object... args) {
            return MessageFormat.format(this.f34418c, args);
        }

        public LogLevel getLogLevel() {
            return this.f34417b;
        }
    }

    public enum AdapterLogEvent implements C11252a {
        LOAD_ATTEMPTED(LogLevel.DEBUG, "Adapter {0} attempting to load ad{1}{2}"),
        LOAD_SUCCESS(LogLevel.DEBUG, "Adapter {0} successfully loaded ad"),
        LOAD_FAILED(LogLevel.DEBUG, "Adapter {0} failed to load ad: ({1}) {2}"),
        SHOW_ATTEMPTED(LogLevel.DEBUG, "Adapter {0} attempting to show ad"),
        SHOW_SUCCESS(LogLevel.DEBUG, "Adapter {0} successfully showed ad"),
        SHOW_FAILED(LogLevel.DEBUG, "Adapter {0} failed to show ad: ({1}) {2}"),
        EXPIRED(LogLevel.DEBUG, "Adapter {0} expired since it was not shown within {1} seconds of it being loaded"),
        CLICKED(LogLevel.DEBUG, "Adapter {0} clicked"),
        WILL_APPEAR(LogLevel.DEBUG, "Adapter {0} will appear"),
        DID_APPEAR(LogLevel.DEBUG, "Adapter {0} did appear"),
        WILL_DISAPPEAR(LogLevel.DEBUG, "Adapter {0} will disappear"),
        DID_DISAPPEAR(LogLevel.DEBUG, "Adapter {0} did disappear"),
        SHOULD_REWARD(LogLevel.DEBUG, "Adapter {0} should reward user with {1} {2}"),
        WILL_LEAVE_APPLICATION(LogLevel.DEBUG, "Adapter {0} will leave application"),
        CUSTOM(LogLevel.DEBUG, "Adapter {0} Log - {1}"),
        CUSTOM_WITH_THROWABLE(LogLevel.DEBUG, "Adapter Log With Throwable - {0}, {1}");
        

        /* renamed from: b */
        private LogLevel f34420b;

        /* renamed from: c */
        private String f34421c;

        private AdapterLogEvent(LogLevel logLevel, String messageFormat) {
            Preconditions.checkNotNull(logLevel);
            Preconditions.checkNotNull(messageFormat);
            this.f34420b = logLevel;
            this.f34421c = messageFormat;
        }

        public String getMessage(Object... args) {
            MessageFormat mf = new MessageFormat(this.f34421c);
            Object[] params = Arrays.copyOf(args, mf.getFormats().length);
            if (this == LOAD_ATTEMPTED) {
                String str = "";
                if (args.length <= 1 || args[1] == null || TextUtils.isEmpty(args[1].toString())) {
                    params[1] = str;
                } else {
                    params[1] = MessageFormat.format(" with DSP creative ID {0}", new Object[]{args[1].toString()});
                }
                if (args.length <= 2 || args[2] == null || TextUtils.isEmpty(args[2].toString())) {
                    params[2] = str;
                } else {
                    params[2] = MessageFormat.format(" with DSP name {0}", new Object[]{args[2].toString()});
                }
            }
            return mf.format(params);
        }

        public LogLevel getLogLevel() {
            return this.f34420b;
        }
    }

    public enum ConsentLogEvent implements C11252a {
        SYNC_ATTEMPTED(LogLevel.DEBUG, "Consent attempting to synchronize state"),
        SYNC_COMPLETED(LogLevel.DEBUG, "Consent synchronization completed: {0}"),
        SYNC_FAILED(LogLevel.DEBUG, "Consent synchronization failed: ({0}) {1}"),
        UPDATED(LogLevel.DEBUG, "Consent changed from {0} to {1}: PII {2} be collected. Reason: {3}"),
        SHOULD_SHOW_DIALOG(LogLevel.DEBUG, "Consent dialog should be shown"),
        LOAD_ATTEMPTED(LogLevel.DEBUG, "Consent attempting to load dialog"),
        LOAD_SUCCESS(LogLevel.DEBUG, "Consent dialog loaded"),
        LOAD_FAILED(LogLevel.DEBUG, "Consent dialog failed: ({0}) {1}"),
        SHOW_ATTEMPTED(LogLevel.DEBUG, "Consent dialog attempting to show"),
        SHOW_SUCCESS(LogLevel.DEBUG, "Consent successfully showed dialog"),
        SHOW_FAILED(LogLevel.DEBUG, "Consent dialog failed to show: ({0}) {1}"),
        CUSTOM(LogLevel.DEBUG, "Consent Log - {0}"),
        CUSTOM_WITH_THROWABLE(LogLevel.DEBUG, "Consent Log With Throwable - {0}, {1}");
        

        /* renamed from: b */
        private LogLevel f34423b;

        /* renamed from: c */
        private String f34424c;

        private ConsentLogEvent(LogLevel logLevel, String messageFormat) {
            Preconditions.checkNotNull(logLevel);
            Preconditions.checkNotNull(messageFormat);
            this.f34423b = logLevel;
            this.f34424c = messageFormat;
        }

        public String getMessage(Object... args) {
            if (this == UPDATED && args != null && args.length > 2) {
                args[2] = (!(args[2] instanceof Boolean) || !args[2].booleanValue()) ? "cannot" : "can";
            }
            return MessageFormat.format(this.f34424c, args);
        }

        public LogLevel getLogLevel() {
            return this.f34423b;
        }
    }

    public enum SdkLogEvent implements C11252a {
        INIT_STARTED(LogLevel.DEBUG, "SDK initialization started"),
        INIT_FINISHED(LogLevel.INFO, "SDK initialized and ready to display ads.\nInitialized adapters:\n{0}"),
        CUSTOM(LogLevel.DEBUG, "SDK Log - {0}"),
        CUSTOM_WITH_THROWABLE(LogLevel.DEBUG, "SDK Log With Throwable - {0}, {1}"),
        ERROR(LogLevel.DEBUG, "SDK Error Log - {0}, {1}");
        

        /* renamed from: b */
        private LogLevel f34426b;

        /* renamed from: c */
        private String f34427c;

        private SdkLogEvent(LogLevel logLevel, String messageFormat) {
            Preconditions.checkNotNull(logLevel);
            Preconditions.checkNotNull(messageFormat);
            this.f34426b = logLevel;
            this.f34427c = messageFormat;
        }

        public String getMessage(Object... args) {
            if (this == INIT_FINISHED && args.length > 0) {
                String adapters = Strings.getDelimitedString(args[0], "\n");
                if (TextUtils.isEmpty(adapters)) {
                    args[0] = "No adapters initialized.";
                } else {
                    args[0] = adapters;
                }
            }
            return MessageFormat.format(this.f34427c, args);
        }

        public LogLevel getLogLevel() {
            return this.f34426b;
        }
    }

    /* renamed from: com.mopub.common.logging.MoPubLog$a */
    private interface C11252a {
        LogLevel getLogLevel();

        String getMessage(Object... objArr);
    }

    private MoPubLog() {
    }

    /* renamed from: a */
    private static void m37077a(String message, Throwable throwable) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM_WITH_THROWABLE;
        Object[] objArr = new Object[2];
        objArr[0] = message;
        objArr[1] = throwable != null ? throwable.getMessage() : "";
        log(sdkLogEvent, objArr);
    }

    public static void addLogger(MoPubLogger logger) {
        addLogger(logger, f34412a.f34413b);
    }

    public static void addLogger(MoPubLogger logger, LogLevel logLevel) {
        f34412a.f34414c.put(logger, logLevel);
    }

    public static void setLogLevel(LogLevel logLevel) {
        Preconditions.checkNotNull(logLevel);
        MoPubLog moPubLog = f34412a;
        moPubLog.f34413b = logLevel;
        addLogger(moPubLog.f34415d, moPubLog.f34413b);
    }

    public static LogLevel getLogLevel() {
        return f34412a.f34413b;
    }

    public static void log(C11252a logEventType, Object... args) {
        m37076a(m37075a(), null, logEventType, args);
    }

    public static void log(String identifier, C11252a logEventType, Object... args) {
        m37076a(m37075a(), identifier, logEventType, args);
    }

    /* renamed from: a */
    private static void m37076a(C1268l<String, String> classAndMethodNames, String identifier, C11252a logEventType, Object... args) {
        Preconditions.checkNotNull(classAndMethodNames);
        if (logEventType != null) {
            for (MoPubLogger logger : f34412a.f34414c.keySet()) {
                if (f34412a.f34414c.get(logger) != null && ((LogLevel) f34412a.f34414c.get(logger)).intValue() <= logEventType.getLogLevel().intValue()) {
                    logger.log((String) classAndMethodNames.f4069a, (String) classAndMethodNames.f4070b, identifier, logEventType.getMessage(args));
                }
            }
        }
    }

    /* renamed from: a */
    private static C1268l<String, String> m37075a() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return new C1268l<>(stackTraceElements[4].getClassName(), stackTraceElements[4].getMethodName());
    }

    @Deprecated
    /* renamed from: c */
    public static void m37078c(String message) {
        m37079c(message, null);
    }

    @Deprecated
    /* renamed from: v */
    public static void m37086v(String message) {
        m37087v(message, null);
    }

    @Deprecated
    /* renamed from: d */
    public static void m37080d(String message) {
        m37081d(message, null);
    }

    @Deprecated
    /* renamed from: i */
    public static void m37084i(String message) {
        m37085i(message, null);
    }

    @Deprecated
    /* renamed from: w */
    public static void m37088w(String message) {
        m37089w(message, null);
    }

    @Deprecated
    /* renamed from: e */
    public static void m37082e(String message) {
        m37083e(message, null);
    }

    @Deprecated
    /* renamed from: c */
    public static void m37079c(String message, Throwable throwable) {
        m37077a(message, throwable);
    }

    @Deprecated
    /* renamed from: v */
    public static void m37087v(String message, Throwable throwable) {
        m37077a(message, throwable);
    }

    @Deprecated
    /* renamed from: d */
    public static void m37081d(String message, Throwable throwable) {
        m37077a(message, throwable);
    }

    @Deprecated
    /* renamed from: i */
    public static void m37085i(String message, Throwable throwable) {
        m37077a(message, throwable);
    }

    @Deprecated
    /* renamed from: w */
    public static void m37089w(String message, Throwable throwable) {
        m37077a(message, throwable);
    }

    @Deprecated
    /* renamed from: e */
    public static void m37083e(String message, Throwable throwable) {
        m37077a(message, throwable);
    }
}
