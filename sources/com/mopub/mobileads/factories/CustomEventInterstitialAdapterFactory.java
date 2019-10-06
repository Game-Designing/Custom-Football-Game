package com.mopub.mobileads.factories;

import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.MoPubInterstitial;
import java.util.Map;

public class CustomEventInterstitialAdapterFactory {

    /* renamed from: a */
    protected static CustomEventInterstitialAdapterFactory f35261a = new CustomEventInterstitialAdapterFactory();

    @Deprecated
    public static void setInstance(CustomEventInterstitialAdapterFactory factory) {
        f35261a = factory;
    }

    public static CustomEventInterstitialAdapter create(MoPubInterstitial moPubInterstitial, String className, Map<String, String> serverExtras, long broadcastIdentifier, AdReport adReport) {
        return f35261a.mo37463a(moPubInterstitial, className, serverExtras, broadcastIdentifier, adReport);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomEventInterstitialAdapter mo37463a(MoPubInterstitial moPubInterstitial, String className, Map<String, String> serverExtras, long broadcastIdentifier, AdReport adReport) {
        CustomEventInterstitialAdapter customEventInterstitialAdapter = new CustomEventInterstitialAdapter(moPubInterstitial, className, serverExtras, broadcastIdentifier, adReport);
        return customEventInterstitialAdapter;
    }
}
