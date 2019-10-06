package com.mopub.mobileads;

import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public class HtmlInterstitial extends ResponseBodyInterstitial {
    public static final String ADAPTER_NAME = HtmlInterstitial.class.getSimpleName();

    /* renamed from: g */
    private String f34788g;

    /* renamed from: h */
    private String f34789h;

    /* renamed from: i */
    private CreativeOrientation f34790i;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37028a(Map<String, String> serverExtras) {
        this.f34788g = (String) serverExtras.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        this.f34789h = (String) serverExtras.get(DataKeys.CLICKTHROUGH_URL_KEY);
        this.f34790i = CreativeOrientation.fromString((String) serverExtras.get(DataKeys.CREATIVE_ORIENTATION_KEY));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37027a(CustomEventInterstitialListener customEventInterstitialListener) {
        MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        MoPubActivity.m37422a(this, this.f34914c, this.f34915d, customEventInterstitialListener, this.f34789h, this.f34916e);
    }

    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
        MoPubActivity.start(this.f34914c, this.f34915d, this.f34789h, this.f34790i, this.f34916e);
    }
}
