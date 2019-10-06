package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p001v7.appcompat.C0793R;

/* renamed from: android.support.design.widget.ea */
/* compiled from: ThemeUtils */
class C0289ea {

    /* renamed from: a */
    private static final int[] f1089a = {C0793R.attr.colorPrimary};

    /* renamed from: a */
    static void m1678a(Context context) {
        TypedArray a = context.obtainStyledAttributes(f1089a);
        boolean failed = !a.hasValue(0);
        a.recycle();
        if (failed) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
