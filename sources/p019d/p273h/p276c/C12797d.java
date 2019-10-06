package p019d.p273h.p276c;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* renamed from: d.h.c.d */
/* compiled from: AdapterUtils */
public class C12797d {
    /* renamed from: a */
    public static boolean m41601a(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        float f = (float) displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        return f / f2 > 720.0f && ((float) displayMetrics.widthPixels) / f2 >= 728.0f;
    }

    /* renamed from: a */
    public static int m41600a(Activity activity, int dpSize) {
        return (int) TypedValue.applyDimension(1, (float) dpSize, activity.getResources().getDisplayMetrics());
    }
}
