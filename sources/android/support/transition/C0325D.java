package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.D */
/* compiled from: PropertyValuesHolderUtilsApi14 */
class C0325D implements C0327F {
    C0325D() {
    }

    /* renamed from: a */
    public PropertyValuesHolder mo4725a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofFloat(new C0323B(property, path), new float[]{0.0f, 1.0f});
    }
}
