package android.support.p000v4.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.v4.app.w */
/* compiled from: FragmentManager */
class C0492w extends C0411b {

    /* renamed from: b */
    final /* synthetic */ ViewGroup f1621b;

    /* renamed from: c */
    final /* synthetic */ Fragment f1622c;

    /* renamed from: d */
    final /* synthetic */ C0409A f1623d;

    C0492w(C0409A this$0, AnimationListener wrapped, ViewGroup viewGroup, Fragment fragment) {
        this.f1623d = this$0;
        this.f1621b = viewGroup;
        this.f1622c = fragment;
        super(wrapped, null);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        this.f1621b.post(new C0491v(this));
    }
}
