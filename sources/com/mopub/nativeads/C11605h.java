package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.factories.CustomEventNativeFactory;
import com.mopub.network.AdResponse;
import java.util.Map;

/* renamed from: com.mopub.nativeads.h */
/* compiled from: CustomEventNativeAdapter */
final class C11605h {

    /* renamed from: a */
    private final Handler f36149a = new Handler();

    /* renamed from: b */
    private final Runnable f36150b = new C11599f(this);

    /* renamed from: c */
    private CustomEventNative f36151c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CustomEventNativeListener f36152d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f36153e = false;

    C11605h(CustomEventNativeListener customEventNativeListener) {
        Preconditions.checkNotNull(customEventNativeListener);
        this.f36152d = customEventNativeListener;
    }

    public void loadNativeAd(Context context, Map<String, Object> localExtras, AdResponse adResponse) {
        String str = " and message ";
        String str2 = "loadNativeAd() failed with code ";
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(localExtras);
        Preconditions.checkNotNull(adResponse);
        String customEventNativeClassName = adResponse.getCustomEventClassName();
        MoPubLog.log(SdkLogEvent.CUSTOM, adResponse.getDspCreativeId());
        try {
            this.f36151c = CustomEventNativeFactory.create(customEventNativeClassName);
            if (adResponse.hasJson()) {
                localExtras.put(DataKeys.JSON_BODY_KEY, adResponse.getJsonBody());
            }
            localExtras.put(DataKeys.CLICK_TRACKING_URL_KEY, adResponse.getClickTrackingUrl());
            try {
                this.f36151c.loadNativeAd(context, m38424b(), localExtras, adResponse.getServerExtras());
                this.f36149a.postDelayed(this.f36150b, (long) adResponse.getAdTimeoutMillis(30000).intValue());
            } catch (Exception e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(MoPubErrorCode.ADAPTER_NOT_FOUND.getIntCode());
                sb.append(str);
                sb.append(MoPubErrorCode.ADAPTER_NOT_FOUND);
                MoPubLog.log(sdkLogEvent, sb.toString());
                this.f36152d.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
            }
        } catch (Exception e2) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(MoPubErrorCode.ADAPTER_NOT_FOUND.getIntCode());
            sb2.append(str);
            sb2.append(MoPubErrorCode.ADAPTER_NOT_FOUND);
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            this.f36152d.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
        }
    }

    /* renamed from: b */
    private CustomEventNativeListener m38424b() {
        return new C11602g(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38163a() {
        try {
            if (this.f36151c != null) {
                this.f36151c.mo37758a();
            }
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, e.toString());
        }
        m38426c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m38426c() {
        if (!this.f36153e) {
            this.f36153e = true;
            this.f36149a.removeCallbacks(this.f36150b);
            this.f36151c = null;
        }
    }
}
