package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import p002b.p003c.p053g.p054a.C1199a;

/* renamed from: android.support.v7.widget.nb */
/* compiled from: ThemeUtils */
class C1092nb {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f3635a = new ThreadLocal<>();

    /* renamed from: b */
    static final int[] f3636b = {-16842910};

    /* renamed from: c */
    static final int[] f3637c = {16842908};

    /* renamed from: d */
    static final int[] f3638d = {16843518};

    /* renamed from: e */
    static final int[] f3639e = {16842919};

    /* renamed from: f */
    static final int[] f3640f = {16842912};

    /* renamed from: g */
    static final int[] f3641g = {16842913};

    /* renamed from: h */
    static final int[] f3642h = {-16842919, -16842908};

    /* renamed from: i */
    static final int[] f3643i = new int[0];

    /* renamed from: j */
    private static final int[] f3644j = new int[1];

    /* renamed from: b */
    public static int m5402b(Context context, int attr) {
        int[] iArr = f3644j;
        iArr[0] = attr;
        C1112sb a = C1112sb.m5455a(context, (AttributeSet) null, iArr);
        try {
            return a.mo8644a(0, 0);
        } finally {
            a.mo8647a();
        }
    }

    /* renamed from: c */
    public static ColorStateList m5403c(Context context, int attr) {
        int[] iArr = f3644j;
        iArr[0] = attr;
        C1112sb a = C1112sb.m5455a(context, (AttributeSet) null, iArr);
        try {
            return a.mo8645a(0);
        } finally {
            a.mo8647a();
        }
    }

    /* renamed from: a */
    public static int m5399a(Context context, int attr) {
        ColorStateList csl = m5403c(context, attr);
        if (csl != null && csl.isStateful()) {
            return csl.getColorForState(f3636b, csl.getDefaultColor());
        }
        TypedValue tv = m5401a();
        context.getTheme().resolveAttribute(16842803, tv, true);
        return m5400a(context, attr, tv.getFloat());
    }

    /* renamed from: a */
    private static TypedValue m5401a() {
        TypedValue typedValue = (TypedValue) f3635a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f3635a.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: a */
    static int m5400a(Context context, int attr, float alpha) {
        int color = m5402b(context, attr);
        return C1199a.m5722b(color, Math.round(((float) Color.alpha(color)) * alpha));
    }
}
