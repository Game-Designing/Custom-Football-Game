package p019d.p143b.p144a.p146b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: d.b.a.b.Q */
class C6976Q implements AnimationListener {

    /* renamed from: a */
    final /* synthetic */ View f12935a;

    /* renamed from: b */
    final /* synthetic */ boolean f12936b;

    /* renamed from: c */
    final /* synthetic */ C6950D f12937c;

    C6976Q(C6950D d, View view, boolean z) {
        this.f12937c = d;
        this.f12935a = view;
        this.f12936b = z;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f12936b) {
            this.f12935a.setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.f12935a.setVisibility(0);
    }
}
