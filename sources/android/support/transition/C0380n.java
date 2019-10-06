package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.support.p000v4.view.C0646w;
import android.view.View;

/* renamed from: android.support.transition.n */
/* compiled from: ChangeBounds */
class C0380n extends AnimatorListenerAdapter {

    /* renamed from: a */
    private boolean f1252a;

    /* renamed from: b */
    final /* synthetic */ View f1253b;

    /* renamed from: c */
    final /* synthetic */ Rect f1254c;

    /* renamed from: d */
    final /* synthetic */ int f1255d;

    /* renamed from: e */
    final /* synthetic */ int f1256e;

    /* renamed from: f */
    final /* synthetic */ int f1257f;

    /* renamed from: g */
    final /* synthetic */ int f1258g;

    /* renamed from: h */
    final /* synthetic */ C0384p f1259h;

    C0380n(C0384p this$0, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.f1259h = this$0;
        this.f1253b = view;
        this.f1254c = rect;
        this.f1255d = i;
        this.f1256e = i2;
        this.f1257f = i3;
        this.f1258g = i4;
    }

    public void onAnimationCancel(Animator animation) {
        this.f1252a = true;
    }

    public void onAnimationEnd(Animator animation) {
        if (!this.f1252a) {
            C0646w.m2953a(this.f1253b, this.f1254c);
            C0375ka.m1933a(this.f1253b, this.f1255d, this.f1256e, this.f1257f, this.f1258g);
        }
    }
}
