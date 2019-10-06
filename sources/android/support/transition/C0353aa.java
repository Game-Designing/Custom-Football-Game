package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* renamed from: android.support.transition.aa */
/* compiled from: ViewGroupUtils */
class C0353aa {

    /* renamed from: a */
    private static final C0362ea f1223a;

    static {
        if (VERSION.SDK_INT >= 18) {
            f1223a = new C0360da();
        } else {
            f1223a = new C0358ca();
        }
    }

    /* renamed from: a */
    static C0351Z m1881a(ViewGroup group) {
        return f1223a.mo4811a(group);
    }

    /* renamed from: a */
    static void m1882a(ViewGroup group, boolean suppress) {
        f1223a.mo4812a(group, suppress);
    }
}
