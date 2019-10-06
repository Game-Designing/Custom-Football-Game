package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* renamed from: android.support.transition.w */
/* compiled from: ObjectAnimatorUtils */
class C0402w {

    /* renamed from: a */
    private static final C0405z f1328a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f1328a = new C0404y();
        } else {
            f1328a = new C0403x();
        }
    }

    /* renamed from: a */
    static <T> ObjectAnimator m2018a(T target, Property<T, PointF> property, Path path) {
        return f1328a.mo4886a(target, property, path);
    }
}
