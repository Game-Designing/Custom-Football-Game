package com.mopub.nativeads;

import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;

/* renamed from: com.mopub.nativeads.ka */
/* compiled from: NativeAdSource */
class C11615ka implements MoPubNativeNetworkListener {

    /* renamed from: a */
    final /* synthetic */ C11618la f36169a;

    C11615ka(C11618la this$0) {
        this.f36169a = this$0;
    }

    public void onNativeLoad(NativeAd nativeAd) {
        if (this.f36169a.f36185l != null) {
            C11618la laVar = this.f36169a;
            laVar.f36179f = false;
            laVar.f36181h++;
            laVar.mo38176f();
            this.f36169a.f36175b.add(new C11516Bb(nativeAd));
            if (this.f36169a.f36175b.size() == 1 && this.f36169a.f36183j != null) {
                this.f36169a.f36183j.onAdsAvailable();
            }
            this.f36169a.mo38175e();
        }
    }

    public void onNativeFail(NativeErrorCode errorCode) {
        C11618la laVar = this.f36169a;
        laVar.f36179f = false;
        if (laVar.f36182i >= C11618la.f36174a.length - 1) {
            laVar.mo38176f();
            return;
        }
        laVar.mo38177g();
        C11618la laVar2 = this.f36169a;
        laVar2.f36180g = true;
        laVar2.f36176c.postDelayed(this.f36169a.f36177d, (long) this.f36169a.mo38174d());
    }
}
