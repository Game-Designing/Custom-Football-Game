package com.mopub.common;

/* renamed from: com.mopub.common.p */
/* compiled from: MoPub */
class C11256p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SdkInitializationListener f34430a;

    C11256p(SdkInitializationListener sdkInitializationListener) {
        this.f34430a = sdkInitializationListener;
    }

    public void run() {
        SdkInitializationListener sdkInitializationListener = this.f34430a;
        if (sdkInitializationListener != null) {
            sdkInitializationListener.onInitializationFinished();
        }
    }
}
