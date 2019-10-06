package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;

/* renamed from: com.mopub.nativeads.T */
/* compiled from: MoPubCustomEventVideoNative */
class C11569T implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubVideoNativeAd f36062a;

    C11569T(MoPubVideoNativeAd this$0) {
        this.f36062a = this$0;
    }

    public void onClick(View v) {
        this.f36062a.f35852z.resetProgress();
        this.f36062a.f35849w.seekTo(0);
        this.f36062a.f35840K = false;
        this.f36062a.f35832C = false;
    }
}
