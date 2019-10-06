package p005cm.aptoide.p006pt.utils;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.utils.SecurityUtils */
public final class SecurityUtils {
    public static final String AMAZON_STORE_APP_ID = "com.amazon.mShop.android";
    private static final String APP_SIGNATURE = "mKfMdjy9CFoKhOJqec3POh4yPFI=";
    public static final String APTOIDE_STORE_APP_ID = "cm.aptoide.pt";
    public static final int INVALID_APP_SIGNATURE = 1;
    public static final String PLAY_STORE_APP_ID = "com.android.vending";
    private static final String TAG = SecurityUtils.class.getName();
    public static final int VALID_APP_SIGNATURE = 0;
    public static final String XIAOMI_STORE_APP_ID = "com.xiaomi.market";

    /* renamed from: cm.aptoide.pt.utils.SecurityUtils$Store */
    public @interface Store {
    }

    public static int checkAppSignature(Context context) {
        Signature[] signatureArr;
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String currentSignature = Base64.encodeToString(md.digest(), 0);
                Logger.getInstance().mo2136d(TAG, String.format("Include this string as a value for SIGNATURE: %s", new Object[]{currentSignature}));
                if (TextUtils.equals(APP_SIGNATURE, currentSignature)) {
                    return 0;
                }
            }
        } catch (Exception e) {
            Logger.getInstance().mo2149w(TAG, "checkAppSignature(Context)", e);
        }
        return 1;
    }

    public static boolean checkEmulator() {
        try {
            boolean goldfish = getSystemProperty("ro.hardware").contains("goldfish");
            boolean emu = getSystemProperty("ro.kernel.qemu").length() > 0;
            boolean sdk = getSystemProperty("ro.product.model").equals("sdk");
            if (emu || goldfish || sdk) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    private static String getSystemProperty(String name) throws Exception {
        Class systemPropertyClazz = Class.forName("android.os.SystemProperties");
        return (String) systemPropertyClazz.getMethod("get", new Class[]{String.class}).invoke(systemPropertyClazz, new Object[]{name});
    }

    public static boolean checkDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean verifyInstallerForStore(Context context, String packageName, @Store String store) {
        String installer = getInstallerPackageName(context, packageName);
        return installer != null && installer.startsWith(store);
    }

    public static String getInstallerPackageName(Context context, String packageName) {
        return context.getPackageManager().getInstallerPackageName(packageName);
    }
}
