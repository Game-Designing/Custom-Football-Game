package android.support.transition;

import android.graphics.Rect;
import android.support.p000v4.view.C0646w;
import android.util.Property;
import android.view.View;

/* renamed from: android.support.transition.ja */
/* compiled from: ViewUtils */
class C0373ja extends Property<View, Rect> {
    C0373ja(Class x0, String x1) {
        super(x0, x1);
    }

    /* renamed from: a */
    public Rect get(View view) {
        return C0646w.m2969d(view);
    }

    /* renamed from: a */
    public void set(View view, Rect clipBounds) {
        C0646w.m2953a(view, clipBounds);
    }
}
