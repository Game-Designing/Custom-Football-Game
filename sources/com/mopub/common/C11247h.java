package com.mopub.common;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.mopub.common.h */
/* compiled from: CompositeSdkInitializationListener */
class C11247h implements SdkInitializationListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SdkInitializationListener f34402a;

    /* renamed from: b */
    private int f34403b;

    public C11247h(SdkInitializationListener sdkInitializationListener, int times) {
        Preconditions.checkNotNull(sdkInitializationListener);
        this.f34402a = sdkInitializationListener;
        this.f34403b = times;
    }

    public void onInitializationFinished() {
        this.f34403b--;
        if (this.f34403b <= 0) {
            new Handler(Looper.getMainLooper()).post(new C11246g(this));
        }
    }
}
