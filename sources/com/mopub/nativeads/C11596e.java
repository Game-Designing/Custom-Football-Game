package com.mopub.nativeads;

import android.os.Handler;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.PositioningSource.PositioningListener;

/* renamed from: com.mopub.nativeads.e */
/* compiled from: ClientPositioningSource */
class C11596e implements PositioningSource {

    /* renamed from: a */
    private final Handler f36134a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MoPubClientPositioning f36135b;

    C11596e(MoPubClientPositioning positioning) {
        this.f36135b = MoPubNativeAdPositioning.m38276a(positioning);
    }

    public void loadPositions(String adUnitId, PositioningListener listener) {
        this.f36134a.post(new C11593d(this, listener));
    }
}
