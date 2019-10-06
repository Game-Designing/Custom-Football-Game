package com.inmobi.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.ads.s */
/* compiled from: DecorViewVisibilityTracker */
final class C10596s extends C10523ce {

    /* renamed from: d */
    private static final String f32279d = C10596s.class.getSimpleName();

    /* renamed from: e */
    private OnPreDrawListener f32280e;

    /* renamed from: f */
    private final WeakReference<View> f32281f;

    C10596s(C10524a aVar, Activity activity) {
        super(aVar);
        View decorView = activity.getWindow().getDecorView();
        this.f32281f = new WeakReference<>(decorView);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f32280e = new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    C10596s.this.mo34251g();
                    return true;
                }
            };
            viewTreeObserver.addOnPreDrawListener(this.f32280e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo34169a() {
        return 100;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo34170b() {
    }

    /* renamed from: c */
    public final void mo34247c() {
        if (!this.f32088a) {
            m34749h();
            super.mo34247c();
        }
    }

    /* renamed from: d */
    public final void mo34248d() {
        if (this.f32088a) {
            View view = (View) this.f32281f.get();
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(this.f32280e);
                }
            }
            super.mo34248d();
        }
    }

    /* renamed from: h */
    private void m34749h() {
        View view = (View) this.f32281f.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f32280e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo34249e() {
        m34749h();
        super.mo34249e();
    }
}
