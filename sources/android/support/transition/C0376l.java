package android.support.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* renamed from: android.support.transition.l */
/* compiled from: ChangeBounds */
class C0376l extends Property<View, PointF> {
    C0376l(Class x0, String x1) {
        super(x0, x1);
    }

    /* renamed from: a */
    public void set(View view, PointF topLeft) {
        int left = Math.round(topLeft.x);
        int top = Math.round(topLeft.y);
        C0375ka.m1933a(view, left, top, view.getWidth() + left, view.getHeight() + top);
    }

    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }
}
