package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;

/* renamed from: com.mopub.nativeads.W */
/* compiled from: MoPubCustomEventVideoNative */
class C11575W implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubVideoNativeAd f36097a;

    C11575W(MoPubVideoNativeAd this$0) {
        this.f36097a = this$0;
    }

    public void onClick(View v) {
        this.f36097a.m38251j();
        this.f36097a.f35849w.mo38026b();
        this.f36097a.f35849w.handleCtaClick(this.f36097a.f35841o);
    }
}
