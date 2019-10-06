package p005cm.aptoide.p006pt.preferences.toolbox;

import android.content.SharedPreferences;

/* renamed from: cm.aptoide.pt.preferences.toolbox.ToolboxManager */
public class ToolboxManager {
    public static boolean isDebug(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("debugmode", false);
    }

    public static void setDebug(boolean debug, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean("debugmode", debug).apply();
    }

    public static String getForceCountry(SharedPreferences sharedPreferences) {
        String defaultValue = "";
        return isDebug(sharedPreferences) ? sharedPreferences.getString(ToolboxKeys.FORCE_COUNTRY, defaultValue) : defaultValue;
    }

    public static void setForceCountry(String forcedCountry, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString(ToolboxKeys.FORCE_COUNTRY, forcedCountry).apply();
    }

    public static boolean isToolboxEnableHttpScheme(SharedPreferences sharedPreferences) {
        if (isDebug(sharedPreferences)) {
            return sharedPreferences.getBoolean(ToolboxKeys.TOOLBOX_ENABLE_HTTP_SCHEME, false);
        }
        return false;
    }

    public static void setToolboxEnableHttpScheme(boolean toolboxEnableHttp, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(ToolboxKeys.TOOLBOX_ENABLE_HTTP_SCHEME, toolboxEnableHttp).apply();
    }

    public static boolean isToolboxEnableRetrofitLogs(SharedPreferences sharedPreferences) {
        if (isDebug(sharedPreferences)) {
            return sharedPreferences.getBoolean(ToolboxKeys.TOOLBOX_RETROFIT_LOGS, false);
        }
        return false;
    }

    public static void setToolboxEnableRetrofitLogs(boolean toolboxEnableRetrofitLogs, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(ToolboxKeys.TOOLBOX_RETROFIT_LOGS, toolboxEnableRetrofitLogs).apply();
    }

    public static String getNotificationType(SharedPreferences sharedPreferences) {
        String defaultValue = "";
        return isDebug(sharedPreferences) ? sharedPreferences.getString("notificationtype", defaultValue) : defaultValue;
    }

    public static void setNotificationType(String notificationType, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString("notificationtype", notificationType).apply();
    }

    public static long getPushNotificationPullingInterval(SharedPreferences sharedPreferences) {
        if (isDebug(sharedPreferences)) {
            return sharedPreferences.getLong(ToolboxKeys.PUSH_NOTIFICATION_PULL_INTERVAL, -1);
        }
        return -1;
    }

    public static void setPushNotificationPullingInterval(long intervalTime, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putLong(ToolboxKeys.PUSH_NOTIFICATION_PULL_INTERVAL, intervalTime).apply();
    }
}
