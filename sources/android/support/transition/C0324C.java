package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* renamed from: android.support.transition.C */
/* compiled from: PropertyValuesHolderUtils */
class C0324C {

    /* renamed from: a */
    private static final C0327F f1152a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f1152a = new C0326E();
        } else {
            f1152a = new C0325D();
        }
    }

    /* renamed from: a */
    static PropertyValuesHolder m1740a(Property<?, PointF> property, Path path) {
        return f1152a.mo4725a(property, path);
    }
}
