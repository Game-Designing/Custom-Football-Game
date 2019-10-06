package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v4.view.h */
/* compiled from: MarginLayoutParamsCompat */
public final class C0627h {
    /* renamed from: b */
    public static int m2888b(MarginLayoutParams lp) {
        if (VERSION.SDK_INT >= 17) {
            return lp.getMarginStart();
        }
        return lp.leftMargin;
    }

    /* renamed from: a */
    public static int m2887a(MarginLayoutParams lp) {
        if (VERSION.SDK_INT >= 17) {
            return lp.getMarginEnd();
        }
        return lp.rightMargin;
    }
}
