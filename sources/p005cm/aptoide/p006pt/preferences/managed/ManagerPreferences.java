package p005cm.aptoide.p006pt.preferences.managed;

import android.content.SharedPreferences;

/* renamed from: cm.aptoide.pt.preferences.managed.ManagerPreferences */
public class ManagerPreferences {
    public static boolean getHWSpecsFilter(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(ManagedKeys.HWSPECS_FILTER, true);
    }

    public static void setHWSpecsFilter(boolean flag, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(ManagedKeys.HWSPECS_FILTER, flag).apply();
    }

    public static boolean getUpdatesFilterAlphaBetaKey(SharedPreferences sharedPreferences) {
        return !sharedPreferences.getBoolean(ManagedKeys.UPDATES_FILTER_ALPHA_BETA_KEY, false);
    }

    public static boolean getUpdatesSystemAppsKey(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(ManagedKeys.UPDATES_SYSTEM_APPS_KEY, false);
    }

    public static int getLastPushNotificationId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getInt(ManagedKeys.LAST_PUSH_NOTIFICATION_ID, 0);
    }

    public static void setLastPushNotificationId(int notificationId, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putInt(ManagedKeys.LAST_PUSH_NOTIFICATION_ID, notificationId).apply();
    }

    public static boolean getDownloadsWifiOnly(SharedPreferences sharedPreferences) {
        return true ^ sharedPreferences.getBoolean(ManagedKeys.GENERAL_DOWNLOADS_WIFI_ONLY, true);
    }

    public static boolean getAnimationsEnabledStatus(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getBoolean(ManagedKeys.ANIMATIONS_ENABLED, true);
    }

    public static boolean isCheckAutoUpdateEnable(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getBoolean(ManagedKeys.CHECK_AUTO_UPDATE, true);
    }

    public static boolean isAutoUpdateEnable(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getBoolean("auto_update", false);
    }

    public static void setAutoUpdateEnable(boolean state, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean("auto_update", state).apply();
    }

    public static int getLastUpdates(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getInt(ManagedKeys.LAST_UPDATES_KEY, 0);
    }

    public static void setLastUpdates(int lastUpdates, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putInt(ManagedKeys.LAST_UPDATES_KEY, lastUpdates).apply();
    }

    public static long getCacheLimit(SharedPreferences defaultSharedPreferences) {
        try {
            return Long.parseLong(defaultSharedPreferences.getString(ManagedKeys.MAX_FILE_CACHE, "300"));
        } catch (Exception e) {
            return 200;
        }
    }

    public static boolean getAndResetForceServerRefresh(SharedPreferences sharedPreferences) {
        boolean state = sharedPreferences.getBoolean(ManagedKeys.FORCE_SERVER_REFRESH_FLAG, false);
        if (state) {
            setForceServerRefreshFlag(false, sharedPreferences);
        }
        return state;
    }

    public static void setForceServerRefreshFlag(boolean state, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(ManagedKeys.FORCE_SERVER_REFRESH_FLAG, state).apply();
    }

    public static boolean needsSqliteDbMigration(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getBoolean(ManagedKeys.PREF_NEEDS_SQLITE_DB_MIGRATION, true);
    }

    public static void setNeedsSqliteDbMigration(boolean migrationNeeded, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(ManagedKeys.PREF_NEEDS_SQLITE_DB_MIGRATION, migrationNeeded).apply();
    }

    public static boolean isUpdateNotificationEnable(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getBoolean(ManagedKeys.PREF_SHOW_UPDATE_NOTIFICATION, true);
    }

    public static boolean allowRootInstallation(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getBoolean("allowRoot", false);
    }

    public static void setAllowRootInstallation(boolean allowRootInstallation, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean("allowRoot", allowRootInstallation).apply();
    }

    public static void setShowPreviewDialog(boolean showPreviewDialog, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(ManagedKeys.DONT_SHOW_ME_AGAIN, showPreviewDialog).apply();
    }

    public static String getPreviewDialogPrefVersionCleaned(SharedPreferences defaultSharedPreferences) {
        return defaultSharedPreferences.getString(ManagedKeys.DONT_SHOW_CLEANED_VERSION, "");
    }

    public static void setPreviewDialogPrefVersionCleaned(String previewDialogPrefCleaned, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString(ManagedKeys.DONT_SHOW_CLEANED_VERSION, previewDialogPrefCleaned).apply();
    }

    public static boolean isDebug(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("debugmode", false);
    }

    public static String getNotificationType(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("notificationtype", "");
    }
}
