package android.support.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* renamed from: android.support.transition.k */
/* compiled from: ChangeBounds */
class C0374k extends Property<View, PointF> {
    C0374k(Class x0, String x1) {
        super(x0, x1);
    }

    /* renamed from: a */
    public void set(View view, PointF topLeft) {
        C0375ka.m1933a(view, Math.round(topLeft.x), Math.round(topLeft.y), view.getRight(), view.getBottom());
    }

    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }
}
