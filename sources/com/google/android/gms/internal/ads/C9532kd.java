package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzard
/* renamed from: com.google.android.gms.internal.ads.kd */
abstract class C9532kd {

    /* renamed from: a */
    private final WeakReference<View> f22641a;

    public C9532kd(View view) {
        this.f22641a = new WeakReference<>(view);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo28998a(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo28999b(ViewTreeObserver viewTreeObserver);

    /* renamed from: a */
    public final void mo29028a() {
        ViewTreeObserver c = m23737c();
        if (c != null) {
            mo28998a(c);
        }
    }

    /* renamed from: b */
    public final void mo29029b() {
        ViewTreeObserver c = m23737c();
        if (c != null) {
            mo28999b(c);
        }
    }

    /* renamed from: c */
    private final ViewTreeObserver m23737c() {
        View view = (View) this.f22641a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
