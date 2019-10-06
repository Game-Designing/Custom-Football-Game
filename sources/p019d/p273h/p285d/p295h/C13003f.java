package p019d.p273h.p285d.p295h;

import android.util.Log;
import com.ironsource.sdk.data.C10894g;

/* renamed from: d.h.d.h.f */
/* compiled from: Logger */
public class C13003f {

    /* renamed from: a */
    private static boolean f39967a;

    /* renamed from: a */
    public static void m42435a(int mode) {
        if (C10894g.MODE_0.mo35660e() == mode) {
            f39967a = false;
        } else {
            f39967a = true;
        }
    }

    /* renamed from: c */
    public static void m42438c(String tag, String message) {
        if (f39967a) {
            Log.i(tag, message);
        }
    }

    /* renamed from: b */
    public static void m42437b(String tag, String message) {
        if (f39967a) {
            Log.e(tag, message);
        }
    }

    /* renamed from: a */
    public static void m42436a(String tag, String message) {
        if (f39967a) {
            Log.d(tag, message);
        }
    }
}
