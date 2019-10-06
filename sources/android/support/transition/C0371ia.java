package android.support.transition;

import android.util.Property;
import android.view.View;

/* renamed from: android.support.transition.ia */
/* compiled from: ViewUtils */
class C0371ia extends Property<View, Float> {
    C0371ia(Class x0, String x1) {
        super(x0, x1);
    }

    /* renamed from: a */
    public Float get(View view) {
        return Float.valueOf(C0375ka.m1937c(view));
    }

    /* renamed from: a */
    public void set(View view, Float alpha) {
        C0375ka.m1931a(view, alpha.floatValue());
    }
}
