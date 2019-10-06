package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@zzard
/* renamed from: com.google.android.gms.internal.ads.jd */
final class C9510jd extends C9532kd implements OnScrollChangedListener {

    /* renamed from: b */
    private final WeakReference<OnScrollChangedListener> f22590b;

    public C9510jd(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f22590b = new WeakReference<>(onScrollChangedListener);
    }

    public final void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.f22590b.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            mo29029b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo28998a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo28999b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }
}
