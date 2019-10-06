package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.E */
/* compiled from: PropertyValuesHolderUtilsApi21 */
class C0326E implements C0327F {
    C0326E() {
    }

    /* renamed from: a */
    public PropertyValuesHolder mo4725a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofObject(property, null, path);
    }
}
