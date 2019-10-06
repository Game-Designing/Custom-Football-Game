package p005cm.aptoide.p006pt.preferences.secure;

import android.content.SharedPreferences;

/* renamed from: cm.aptoide.pt.preferences.secure.SecurePreferences */
public class SecurePreferences {
    public static boolean shouldRunApkFy(SharedPreferences securePreferences) {
        return securePreferences.getBoolean(SecureKeys.SHOULD_RUN_APK_FY, true);
    }

    public static void setApkFyRun(SharedPreferences securePreferences) {
        securePreferences.edit().putBoolean(SecureKeys.SHOULD_RUN_APK_FY, false).apply();
    }

    public static boolean isFirstRun(SharedPreferences securePreferences) {
        return securePreferences.getBoolean(SecureKeys.FIRST_RUN, true);
    }

    public static void setFirstRun(boolean b, SharedPreferences securePreferences) {
        securePreferences.edit().putBoolean(SecureKeys.FIRST_RUN, b).apply();
    }

    public static boolean isWizardAvailable(SharedPreferences securePreferences) {
        return securePreferences.getBoolean(SecureKeys.WIZARD_AVAILABLE, true);
    }

    public static void setWizardAvailable(boolean available, SharedPreferences securePreferences) {
        securePreferences.edit().putBoolean(SecureKeys.WIZARD_AVAILABLE, available).commit();
    }

    public static boolean isRootDialogShowed(SharedPreferences securePreferences) {
        return securePreferences.getBoolean(SecureKeys.ROOT_DIALOG_ShOWED, false);
    }

    public static void setRootDialogShowed(boolean displayed, SharedPreferences securePreferences) {
        securePreferences.edit().putBoolean(SecureKeys.ROOT_DIALOG_ShOWED, displayed).apply();
    }
}
