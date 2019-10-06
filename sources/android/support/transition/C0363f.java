package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.f */
/* compiled from: ChangeBounds */
class C0363f extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ ViewGroup f1232a;

    /* renamed from: b */
    final /* synthetic */ BitmapDrawable f1233b;

    /* renamed from: c */
    final /* synthetic */ View f1234c;

    /* renamed from: d */
    final /* synthetic */ float f1235d;

    /* renamed from: e */
    final /* synthetic */ C0384p f1236e;

    C0363f(C0384p this$0, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
        this.f1236e = this$0;
        this.f1232a = viewGroup;
        this.f1233b = bitmapDrawable;
        this.f1234c = view;
        this.f1235d = f;
    }

    public void onAnimationEnd(Animator animation) {
        C0375ka.m1935b(this.f1232a).mo4804b(this.f1233b);
        C0375ka.m1931a(this.f1234c, this.f1235d);
    }
}
