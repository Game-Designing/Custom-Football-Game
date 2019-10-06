package android.support.p000v4.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.support.p000v4.app.C0465e;

/* renamed from: android.support.v4.content.k */
/* compiled from: PermissionChecker */
public final class C0527k {
    /* renamed from: a */
    public static int m2619a(Context context, String permission, int pid, int uid, String packageName) {
        if (context.checkPermission(permission, pid, uid) == -1) {
            return -1;
        }
        String op = C0465e.m2366a(permission);
        if (op == null) {
            return 0;
        }
        if (packageName == null) {
            String[] packageNames = context.getPackageManager().getPackagesForUid(uid);
            if (packageNames == null || packageNames.length <= 0) {
                return -1;
            }
            packageName = packageNames[0];
        }
        if (C0465e.m2365a(context, op, packageName) != 0) {
            return -2;
        }
        return 0;
    }

    /* renamed from: b */
    public static int m2620b(Context context, String permission) {
        return m2619a(context, permission, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /* renamed from: a */
    public static int m2618a(Context context, String permission) {
        return m2619a(context, permission, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }
}
