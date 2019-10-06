package android.support.p000v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: android.support.v4.app.da */
/* compiled from: OneShotPreDrawListener */
class C0464da implements OnPreDrawListener, OnAttachStateChangeListener {

    /* renamed from: a */
    private final View f1572a;

    /* renamed from: b */
    private ViewTreeObserver f1573b;

    /* renamed from: c */
    private final Runnable f1574c;

    private C0464da(View view, Runnable runnable) {
        this.f1572a = view;
        this.f1573b = view.getViewTreeObserver();
        this.f1574c = runnable;
    }

    /* renamed from: a */
    public static C0464da m2363a(View view, Runnable runnable) {
        C0464da listener = new C0464da(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(listener);
        view.addOnAttachStateChangeListener(listener);
        return listener;
    }

    public boolean onPreDraw() {
        mo5141a();
        this.f1574c.run();
        return true;
    }

    /* renamed from: a */
    public void mo5141a() {
        if (this.f1573b.isAlive()) {
            this.f1573b.removeOnPreDrawListener(this);
        } else {
            this.f1572a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1572a.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View v) {
        this.f1573b = v.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View v) {
        mo5141a();
    }
}
