package android.support.p000v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* renamed from: android.support.v4.view.f */
/* compiled from: GravityCompat */
public final class C0623f {
    /* renamed from: a */
    public static void m2882a(int gravity, int w, int h, Rect container, Rect outRect, int layoutDirection) {
        if (VERSION.SDK_INT >= 17) {
            Gravity.apply(gravity, w, h, container, outRect, layoutDirection);
        } else {
            Gravity.apply(gravity, w, h, container, outRect);
        }
    }

    /* renamed from: a */
    public static int m2881a(int gravity, int layoutDirection) {
        if (VERSION.SDK_INT >= 17) {
            return Gravity.getAbsoluteGravity(gravity, layoutDirection);
        }
        return -8388609 & gravity;
    }
}
