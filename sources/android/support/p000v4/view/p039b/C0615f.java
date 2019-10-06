package android.support.p000v4.view.p039b;

import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: android.support.v4.view.b.f */
/* compiled from: PathInterpolatorCompat */
public final class C0615f {
    /* renamed from: a */
    public static Interpolator m2854a(float controlX1, float controlY1, float controlX2, float controlY2) {
        if (VERSION.SDK_INT >= 21) {
            return new PathInterpolator(controlX1, controlY1, controlX2, controlY2);
        }
        return new C0614e(controlX1, controlY1, controlX2, controlY2);
    }
}
