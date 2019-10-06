package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;

/* renamed from: com.mopub.nativeads.V */
/* compiled from: MoPubCustomEventVideoNative */
class C11573V implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubVideoNativeAd f36068a;

    C11573V(MoPubVideoNativeAd this$0) {
        this.f36068a = this$0;
    }

    public void onClick(View v) {
        MoPubLog.log(AdapterLogEvent.CLICKED, MoPubCustomEventVideoNative.ADAPTER_NAME);
        this.f36068a.m38251j();
        this.f36068a.f35849w.mo38026b();
        BaseVideoPlayerActivity.startNativeVideo(this.f36068a.f35841o, this.f36068a.f35831B, this.f36068a.f35851y);
    }
}
