package android.support.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* renamed from: android.support.transition.j */
/* compiled from: ChangeBounds */
class C0372j extends Property<View, PointF> {
    C0372j(Class x0, String x1) {
        super(x0, x1);
    }

    /* renamed from: a */
    public void set(View view, PointF bottomRight) {
        C0375ka.m1933a(view, view.getLeft(), view.getTop(), Math.round(bottomRight.x), Math.round(bottomRight.y));
    }

    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }
}
