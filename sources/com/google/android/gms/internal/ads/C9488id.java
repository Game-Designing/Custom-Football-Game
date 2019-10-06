package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

@zzard
/* renamed from: com.google.android.gms.internal.ads.id */
final class C9488id extends C9532kd implements OnGlobalLayoutListener {

    /* renamed from: b */
    private final WeakReference<OnGlobalLayoutListener> f22541b;

    public C9488id(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f22541b = new WeakReference<>(onGlobalLayoutListener);
    }

    public final void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.f22541b.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            mo29029b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo28998a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo28999b(ViewTreeObserver viewTreeObserver) {
        zzk.zzli().mo30252a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }
}
