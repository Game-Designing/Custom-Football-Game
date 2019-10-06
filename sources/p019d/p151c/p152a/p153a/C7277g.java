package p019d.p151c.p152a.p153a;

import android.content.Context;
import android.os.Vibrator;

/* renamed from: d.c.a.a.g */
/* compiled from: VibrationHelper */
public class C7277g {
    /* renamed from: a */
    public static void m15845a(Context context, int duration) {
        if (m15846a(context)) {
            ((Vibrator) context.getSystemService("vibrator")).vibrate((long) duration);
        }
    }

    /* renamed from: a */
    public static boolean m15846a(Context context) {
        return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
    }
}
