package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.x */
/* compiled from: ObjectAnimatorUtilsApi14 */
class C0403x implements C0405z {
    C0403x() {
    }

    /* renamed from: a */
    public <T> ObjectAnimator mo4886a(T target, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofFloat(target, new C0323B(property, path), new float[]{0.0f, 1.0f});
    }
}
