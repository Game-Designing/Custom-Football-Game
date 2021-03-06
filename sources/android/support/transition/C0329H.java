package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* renamed from: android.support.transition.H */
/* compiled from: RectEvaluator */
class C0329H implements TypeEvaluator<Rect> {

    /* renamed from: a */
    private Rect f1153a;

    C0329H() {
    }

    /* renamed from: a */
    public Rect evaluate(float fraction, Rect startValue, Rect endValue) {
        int i = startValue.left;
        int left = i + ((int) (((float) (endValue.left - i)) * fraction));
        int i2 = startValue.top;
        int top = i2 + ((int) (((float) (endValue.top - i2)) * fraction));
        int i3 = startValue.right;
        int right = i3 + ((int) (((float) (endValue.right - i3)) * fraction));
        int i4 = startValue.bottom;
        int bottom = i4 + ((int) (((float) (endValue.bottom - i4)) * fraction));
        Rect rect = this.f1153a;
        if (rect == null) {
            return new Rect(left, top, right, bottom);
        }
        rect.set(left, top, right, bottom);
        return this.f1153a;
    }
}
