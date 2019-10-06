package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.y */
/* compiled from: ObjectAnimatorUtilsApi21 */
class C0404y implements C0405z {
    C0404y() {
    }

    /* renamed from: a */
    public <T> ObjectAnimator mo4886a(T target, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(target, property, null, path);
    }
}
