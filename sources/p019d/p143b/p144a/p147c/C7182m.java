package p019d.p143b.p144a.p147c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.Display;
import android.view.WindowManager;
import com.applovin.adview.AppLovinInterstitialActivity;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: d.b.a.c.m */
public class C7182m {
    /* renamed from: a */
    static void m15318a() {
        try {
            if (VERSION.SDK_INT >= 9) {
                StrictMode.setThreadPolicy(new Builder().permitAll().build());
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static boolean m15319a(Context context) {
        try {
            return C7209sc.m15477a(context.getPackageManager().getActivityInfo(new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName()), 0).configChanges, (int) Opcodes.ACC_ABSTRACT);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m15320a(Class<?> cls, Context context) {
        return context.getPackageManager().resolveActivity(new Intent(context, cls), 0) != null;
    }

    /* renamed from: a */
    public static boolean m15321a(String str, Context context) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    public static boolean m15322b() {
        return VERSION.SDK_INT >= 11;
    }

    /* renamed from: b */
    public static boolean m15323b(Context context) {
        try {
            return C7209sc.m15477a(context.getPackageManager().getActivityInfo(new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName()), 0).configChanges, 128);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c */
    public static Point m15324c(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        } catch (Throwable th) {
        }
        return point;
    }

    /* renamed from: c */
    public static boolean m15325c() {
        return VERSION.SDK_INT >= 14;
    }

    /* renamed from: d */
    public static boolean m15326d() {
        return VERSION.SDK_INT >= 16;
    }

    /* renamed from: e */
    public static boolean m15327e() {
        return VERSION.SDK_INT >= 17;
    }

    /* renamed from: f */
    public static boolean m15328f() {
        return VERSION.SDK_INT >= 19;
    }

    /* renamed from: g */
    public static boolean m15329g() {
        return VERSION.SDK_INT >= 21;
    }

    /* renamed from: h */
    public static boolean m15330h() {
        return VERSION.SDK_INT >= 23;
    }
}
