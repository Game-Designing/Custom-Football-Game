package com.mopub.nativeads;

import com.mopub.nativeads.PositioningSource.PositioningListener;

/* renamed from: com.mopub.nativeads.d */
/* compiled from: ClientPositioningSource */
class C11593d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PositioningListener f36129a;

    /* renamed from: b */
    final /* synthetic */ C11596e f36130b;

    C11593d(C11596e this$0, PositioningListener positioningListener) {
        this.f36130b = this$0;
        this.f36129a = positioningListener;
    }

    public void run() {
        this.f36129a.onLoad(this.f36130b.f36135b);
    }
}
