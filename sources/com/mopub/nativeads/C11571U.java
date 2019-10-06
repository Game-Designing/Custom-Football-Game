package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;

/* renamed from: com.mopub.nativeads.U */
/* compiled from: MoPubCustomEventVideoNative */
class C11571U implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubVideoNativeAd f36065a;

    C11571U(MoPubVideoNativeAd this$0) {
        this.f36065a = this$0;
    }

    public void onClick(View v) {
        MoPubVideoNativeAd moPubVideoNativeAd = this.f36065a;
        moPubVideoNativeAd.f35839J = !moPubVideoNativeAd.f35839J;
        this.f36065a.m38249i();
    }
}
