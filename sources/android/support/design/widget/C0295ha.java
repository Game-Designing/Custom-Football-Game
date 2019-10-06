package android.support.design.widget;

import android.graphics.PorterDuff.Mode;

/* renamed from: android.support.design.widget.ha */
/* compiled from: ViewUtils */
class C0295ha {
    /* renamed from: a */
    static Mode m1689a(int value, Mode defaultMode) {
        if (value == 3) {
            return Mode.SRC_OVER;
        }
        if (value == 5) {
            return Mode.SRC_IN;
        }
        if (value == 9) {
            return Mode.SRC_ATOP;
        }
        if (value == 14) {
            return Mode.MULTIPLY;
        }
        if (value != 15) {
            return defaultMode;
        }
        return Mode.SCREEN;
    }
}
