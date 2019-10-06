package com.mopub.network;

/* renamed from: com.mopub.network.d */
/* compiled from: AdLoader */
class C11670d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdResponse f36390a;

    /* renamed from: b */
    final /* synthetic */ AdLoader f36391b;

    C11670d(AdLoader this$0, AdResponse adResponse) {
        this.f36391b = this$0;
        this.f36390a = adResponse;
    }

    public void run() {
        this.f36391b.m38492a(this.f36390a);
    }
}
