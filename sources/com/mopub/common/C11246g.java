package com.mopub.common;

/* renamed from: com.mopub.common.g */
/* compiled from: CompositeSdkInitializationListener */
class C11246g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C11247h f34401a;

    C11246g(C11247h this$0) {
        this.f34401a = this$0;
    }

    public void run() {
        if (this.f34401a.f34402a != null) {
            this.f34401a.f34402a.onInitializationFinished();
            this.f34401a.f34402a = null;
        }
    }
}
