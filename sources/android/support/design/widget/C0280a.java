package android.support.design.widget;

import android.support.p000v4.view.p039b.C0610a;
import android.support.p000v4.view.p039b.C0611b;
import android.support.p000v4.view.p039b.C0612c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: android.support.design.widget.a */
/* compiled from: AnimationUtils */
class C0280a {

    /* renamed from: a */
    static final Interpolator f1074a = new LinearInterpolator();

    /* renamed from: b */
    static final Interpolator f1075b = new C0611b();

    /* renamed from: c */
    static final Interpolator f1076c = new C0610a();

    /* renamed from: d */
    static final Interpolator f1077d = new C0612c();

    /* renamed from: e */
    static final Interpolator f1078e = new DecelerateInterpolator();

    /* renamed from: a */
    static float m1676a(float startValue, float endValue, float fraction) {
        return ((endValue - startValue) * fraction) + startValue;
    }
}
