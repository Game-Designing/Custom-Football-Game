package android.support.p001v7.widget;

import java.util.Comparator;

/* renamed from: android.support.v7.widget.ma */
/* compiled from: GapWorker */
class C1086ma implements Comparator<C1091b> {
    C1086ma() {
    }

    /* renamed from: a */
    public int compare(C1091b lhs, C1091b rhs) {
        int i = 1;
        if ((lhs.f3633d == null) != (rhs.f3633d == null)) {
            if (lhs.f3633d != null) {
                i = -1;
            }
            return i;
        }
        boolean z = lhs.f3630a;
        if (z != rhs.f3630a) {
            if (z) {
                i = -1;
            }
            return i;
        }
        int deltaViewVelocity = rhs.f3631b - lhs.f3631b;
        if (deltaViewVelocity != 0) {
            return deltaViewVelocity;
        }
        int deltaDistanceToItem = lhs.f3632c - rhs.f3632c;
        if (deltaDistanceToItem != 0) {
            return deltaDistanceToItem;
        }
        return 0;
    }
}
