package com.mopub.mraid;

import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import java.util.Map;

class MraidInterstitial extends ResponseBodyInterstitial {
    public static final String ADAPTER_NAME = MraidInterstitial.class.getSimpleName();

    /* renamed from: g */
    protected String f35529g;

    /* renamed from: h */
    private CreativeOrientation f35530h;

    MraidInterstitial() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37028a(Map<String, String> serverExtras) {
        this.f35529g = (String) serverExtras.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        this.f35530h = CreativeOrientation.fromString((String) serverExtras.get(DataKeys.CREATIVE_ORIENTATION_KEY));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37027a(CustomEventInterstitialListener customEventInterstitialListener) {
        MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        MraidActivity.preRenderHtml(this, this.f34914c, customEventInterstitialListener, Long.valueOf(this.f34916e), this.f34915d);
    }

    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
        MraidActivity.start(this.f34914c, this.f34915d, this.f34916e, this.f35530h);
    }
}
