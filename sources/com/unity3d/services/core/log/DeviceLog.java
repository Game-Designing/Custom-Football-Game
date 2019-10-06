package com.unity3d.services.core.log;

import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DeviceLog {
    private static boolean FORCE_DEBUG_LOG = false;
    public static final int LOGLEVEL_DEBUG = 8;
    private static final int LOGLEVEL_ERROR = 1;
    public static final int LOGLEVEL_INFO = 4;
    private static final int LOGLEVEL_WARNING = 2;
    private static boolean LOG_DEBUG = true;
    private static boolean LOG_ERROR = true;
    private static boolean LOG_INFO = true;
    private static boolean LOG_WARNING = true;
    private static final int MAX_DEBUG_MSG_LENGTH = 3072;
    private static final HashMap<UnityAdsLogLevel, DeviceLogLevel> _deviceLogLevel = new HashMap<>();

    /* renamed from: com.unity3d.services.core.log.DeviceLog$1 */
    static /* synthetic */ class C126331 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel */
        static final /* synthetic */ int[] f39024xf32d8d1 = new int[UnityAdsLogLevel.values().length];

        static {
            try {
                f39024xf32d8d1[UnityAdsLogLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f39024xf32d8d1[UnityAdsLogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f39024xf32d8d1[UnityAdsLogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f39024xf32d8d1[UnityAdsLogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum UnityAdsLogLevel {
        INFO,
        DEBUG,
        WARNING,
        ERROR
    }

    static {
        FORCE_DEBUG_LOG = false;
        if (_deviceLogLevel.size() == 0) {
            _deviceLogLevel.put(UnityAdsLogLevel.INFO, new DeviceLogLevel("i"));
            _deviceLogLevel.put(UnityAdsLogLevel.DEBUG, new DeviceLogLevel("d"));
            _deviceLogLevel.put(UnityAdsLogLevel.WARNING, new DeviceLogLevel("w"));
            _deviceLogLevel.put(UnityAdsLogLevel.ERROR, new DeviceLogLevel("e"));
        }
        if (new File("/data/local/tmp/UnityAdsForceDebugMode").exists()) {
            FORCE_DEBUG_LOG = true;
        }
    }

    public static void setLogLevel(int newLevel) {
        if (newLevel >= 8) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = true;
            LOG_DEBUG = true;
        } else if (newLevel >= 4) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = true;
            LOG_DEBUG = false;
        } else if (newLevel >= 2) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = false;
            LOG_DEBUG = false;
        } else if (newLevel >= 1) {
            LOG_ERROR = true;
            LOG_WARNING = false;
            LOG_INFO = false;
            LOG_DEBUG = false;
        } else {
            LOG_ERROR = false;
            LOG_WARNING = false;
            LOG_INFO = false;
            LOG_DEBUG = false;
        }
    }

    public static void entered() {
        debug("ENTERED METHOD");
    }

    public static void info(String message) {
        write(UnityAdsLogLevel.INFO, checkMessage(message));
    }

    public static void info(String format, Object... args) {
        info(String.format(format, args));
    }

    public static void debug(String message) {
        if (!LOG_DEBUG && !FORCE_DEBUG_LOG) {
            return;
        }
        if (message.length() > MAX_DEBUG_MSG_LENGTH) {
            debug(message.substring(0, MAX_DEBUG_MSG_LENGTH));
            if (message.length() < 30720) {
                debug(message.substring(MAX_DEBUG_MSG_LENGTH));
            }
            return;
        }
        write(UnityAdsLogLevel.DEBUG, checkMessage(message));
    }

    public static void debug(String format, Object... args) {
        debug(String.format(format, args));
    }

    public static void warning(String message) {
        write(UnityAdsLogLevel.WARNING, checkMessage(message));
    }

    public static void warning(String format, Object... args) {
        warning(String.format(format, args));
    }

    public static void error(String message) {
        write(UnityAdsLogLevel.ERROR, checkMessage(message));
    }

    public static void exception(String message, Exception exception) {
        String finalMessage = "";
        if (message != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(finalMessage);
            sb.append(message);
            finalMessage = sb.toString();
        }
        String str = ": ";
        if (exception != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(finalMessage);
            sb2.append(str);
            sb2.append(exception.getMessage());
            finalMessage = sb2.toString();
        }
        if (!(exception == null || exception.getCause() == null)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(finalMessage);
            sb3.append(str);
            sb3.append(exception.getCause().getMessage());
            finalMessage = sb3.toString();
        }
        write(UnityAdsLogLevel.ERROR, finalMessage);
    }

    public static void error(String format, Object... args) {
        error(String.format(format, args));
    }

    private static void write(UnityAdsLogLevel level, String message) {
        boolean logThisMessage = true;
        int i = C126331.f39024xf32d8d1[level.ordinal()];
        if (i == 1) {
            logThisMessage = LOG_INFO;
        } else if (i == 2) {
            logThisMessage = LOG_DEBUG;
        } else if (i == 3) {
            logThisMessage = LOG_WARNING;
        } else if (i == 4) {
            logThisMessage = LOG_ERROR;
        }
        if (FORCE_DEBUG_LOG) {
            logThisMessage = true;
        }
        if (logThisMessage) {
            writeToLog(createLogEntry(level, message));
        }
    }

    private static String checkMessage(String message) {
        if (message == null || message.length() == 0) {
            return "DO NOT USE EMPTY MESSAGES, use DeviceLog.entered() instead";
        }
        return message;
    }

    private static DeviceLogLevel getLogLevel(UnityAdsLogLevel logLevel) {
        return (DeviceLogLevel) _deviceLogLevel.get(logLevel);
    }

    private static DeviceLogEntry createLogEntry(UnityAdsLogLevel level, String message) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        DeviceLogLevel logLevel = getLogLevel(level);
        if (logLevel == null) {
            return null;
        }
        boolean markedIndex = false;
        int callerIndex = 0;
        while (callerIndex < stack.length) {
            StackTraceElement e = stack[callerIndex];
            if (e.getClassName().equals(DeviceLog.class.getName())) {
                markedIndex = true;
            }
            if (!e.getClassName().equals(DeviceLog.class.getName()) && markedIndex) {
                break;
            }
            callerIndex++;
        }
        StackTraceElement e2 = null;
        if (callerIndex < stack.length) {
            e2 = stack[callerIndex];
        }
        if (e2 != null) {
            return new DeviceLogEntry(logLevel, message, e2);
        }
        return null;
    }

    private static void writeToLog(DeviceLogEntry logEntry) {
        String str = "Writing to log failed!";
        String str2 = "UnityAds";
        Method receivingMethod = null;
        if (logEntry != null && logEntry.getLogLevel() != null) {
            try {
                receivingMethod = Log.class.getMethod(logEntry.getLogLevel().getReceivingMethodName(), new Class[]{String.class, String.class});
            } catch (Exception e) {
                Log.e(str2, str, e);
            }
            if (receivingMethod != null) {
                try {
                    receivingMethod.invoke(null, new Object[]{logEntry.getLogLevel().getLogTag(), logEntry.getParsedMessage()});
                } catch (Exception e2) {
                    Log.e(str2, str, e2);
                }
            }
        }
    }
}
