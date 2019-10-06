package com.mopub.nativeads;

import android.content.Context;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mopub.nativeads.j */
/* compiled from: GooglePlayServicesNative */
class C11611j implements OnUnifiedNativeAdLoadedListener {

    /* renamed from: a */
    final /* synthetic */ Context f36163a;

    /* renamed from: b */
    final /* synthetic */ C11529a f36164b;

    C11611j(C11529a this$0, Context context) {
        this.f36164b = this$0;
        this.f36163a = context;
    }

    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
        if (!this.f36164b.m38142a(unifiedNativeAd)) {
            MoPubLog.log(AdapterLogEvent.CUSTOM, GooglePlayServicesNative.f35660a, "The Google native unified ad is missing one or more required assets, failing request.");
            this.f36164b.f35675p.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, GooglePlayServicesNative.f35660a, Integer.valueOf(NativeErrorCode.NETWORK_NO_FILL.getIntCode()), NativeErrorCode.NETWORK_NO_FILL);
            return;
        }
        this.f36164b.f35676q = unifiedNativeAd;
        List<Image> images = unifiedNativeAd.getImages();
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add(((Image) images.get(0)).getUri().toString());
        imageUrls.add(unifiedNativeAd.getIcon().getUri().toString());
        this.f36164b.m38139a(this.f36163a, imageUrls);
    }
}
