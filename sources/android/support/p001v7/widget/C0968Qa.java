package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.View;

/* renamed from: android.support.v7.widget.Qa */
/* compiled from: ScrollbarHelper */
class C0968Qa {
    /* renamed from: a */
    static int m4696a(C0997t state, C0916Ba orientation, View startChild, View endChild, C0981i lm, boolean smoothScrollbarEnabled, boolean reverseLayout) {
        int itemsBefore;
        if (lm.getChildCount() == 0 || state.mo7945a() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        int minPosition = Math.min(lm.getPosition(startChild), lm.getPosition(endChild));
        int maxPosition = Math.max(lm.getPosition(startChild), lm.getPosition(endChild));
        if (reverseLayout) {
            itemsBefore = Math.max(0, (state.mo7945a() - maxPosition) - 1);
        } else {
            itemsBefore = Math.max(0, minPosition);
        }
        if (!smoothScrollbarEnabled) {
            return itemsBefore;
        }
        return Math.round((((float) itemsBefore) * (((float) Math.abs(orientation.mo6967a(endChild) - orientation.mo6974d(startChild))) / ((float) (Math.abs(lm.getPosition(startChild) - lm.getPosition(endChild)) + 1)))) + ((float) (orientation.mo6977f() - orientation.mo6974d(startChild))));
    }

    /* renamed from: a */
    static int m4695a(C0997t state, C0916Ba orientation, View startChild, View endChild, C0981i lm, boolean smoothScrollbarEnabled) {
        if (lm.getChildCount() == 0 || state.mo7945a() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        if (!smoothScrollbarEnabled) {
            return Math.abs(lm.getPosition(startChild) - lm.getPosition(endChild)) + 1;
        }
        return Math.min(orientation.mo6979g(), orientation.mo6967a(endChild) - orientation.mo6974d(startChild));
    }

    /* renamed from: b */
    static int m4697b(C0997t state, C0916Ba orientation, View startChild, View endChild, C0981i lm, boolean smoothScrollbarEnabled) {
        if (lm.getChildCount() == 0 || state.mo7945a() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        if (!smoothScrollbarEnabled) {
            return state.mo7945a();
        }
        return (int) ((((float) (orientation.mo6967a(endChild) - orientation.mo6974d(startChild))) / ((float) (Math.abs(lm.getPosition(startChild) - lm.getPosition(endChild)) + 1))) * ((float) state.mo7945a()));
    }
}
