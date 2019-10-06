package p019d.p273h.p274a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: d.h.a.a */
/* compiled from: ApplicationContext */
public class C12723a {
    /* renamed from: f */
    public static String m41072f(Context context) {
        return context.getPackageName();
    }

    /* renamed from: c */
    public static boolean m41069c(Context context, String permissionToCheck) {
        boolean isPermissionValid = false;
        String str = "";
        if (!TextUtils.isEmpty(permissionToCheck)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), Opcodes.ACC_SYNTHETIC);
                if (packageInfo.requestedPermissions != null) {
                    for (int i = 0; i < packageInfo.requestedPermissions.length && !isPermissionValid; i++) {
                        isPermissionValid = permissionToCheck.equals(packageInfo.requestedPermissions[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isPermissionValid;
    }

    /* renamed from: b */
    public static boolean m41067b(Context context, String permission) {
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    /* renamed from: a */
    public static JSONObject m41065a(Context context, JSONArray permissionsFromController) {
        String GRANTED = "Granted";
        String REJECTED = "Rejected";
        String NOT_FOUND = "notFoundInManifest";
        JSONObject allPermissions = new JSONObject();
        if (VERSION.SDK_INT >= 16) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), Opcodes.ACC_SYNTHETIC);
                if (permissionsFromController.length() == 0) {
                    for (int index = 0; index < packageInfo.requestedPermissions.length; index++) {
                        allPermissions.put(packageInfo.requestedPermissions[index], (packageInfo.requestedPermissionsFlags[index] & 2) != 0 ? GRANTED : REJECTED);
                    }
                } else {
                    List<String> permissionsList = Arrays.asList(packageInfo.requestedPermissions);
                    for (int index2 = 0; index2 < permissionsFromController.length(); index2++) {
                        String permission = permissionsFromController.getString(index2);
                        int indexOfPermission = permissionsList.indexOf(permission);
                        if (indexOfPermission != -1) {
                            allPermissions.put(permission, (packageInfo.requestedPermissionsFlags[indexOfPermission] & 2) != 0 ? GRANTED : REJECTED);
                        } else {
                            allPermissions.put(permission, NOT_FOUND);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allPermissions;
    }

    /* renamed from: a */
    static PackageInfo m41063a(Context context) throws NameNotFoundException {
        return context.getPackageManager().getPackageInfo(m41072f(context), 0);
    }

    /* renamed from: c */
    public static long m41068c(Context context) {
        try {
            return m41063a(context).firstInstallTime;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: e */
    public static long m41071e(Context context) {
        try {
            return m41063a(context).lastUpdateTime;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: b */
    public static String m41066b(Context context) {
        try {
            return m41063a(context).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m41064a(Context context, String packageName) {
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: d */
    public static String m41070d(Context context) {
        String installer = null;
        try {
            installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Throwable th) {
        }
        return TextUtils.isEmpty(installer) ? "" : installer;
    }
}
