package android.support.p000v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.app.e */
/* compiled from: AppOpsManagerCompat */
public final class C0465e {
    /* renamed from: a */
    public static String m2366a(String permission) {
        if (VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(permission);
        }
        return null;
    }

    /* renamed from: a */
    public static int m2365a(Context context, String op, String proxiedPackageName) {
        if (VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(op, proxiedPackageName);
        }
        return 1;
    }
}
