package com.mopub.mobileads.factories;

import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubView;
import java.util.Map;

public class CustomEventBannerAdapterFactory {

    /* renamed from: a */
    protected static CustomEventBannerAdapterFactory f35259a = new CustomEventBannerAdapterFactory();

    @Deprecated
    public static void setInstance(CustomEventBannerAdapterFactory factory) {
        f35259a = factory;
    }

    public static CustomEventBannerAdapter create(MoPubView moPubView, String className, Map<String, String> serverExtras, long broadcastIdentifier, AdReport adReport) {
        return f35259a.mo37461a(moPubView, className, serverExtras, broadcastIdentifier, adReport);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomEventBannerAdapter mo37461a(MoPubView moPubView, String className, Map<String, String> serverExtras, long broadcastIdentifier, AdReport adReport) {
        CustomEventBannerAdapter customEventBannerAdapter = new CustomEventBannerAdapter(moPubView, className, serverExtras, broadcastIdentifier, adReport);
        return customEventBannerAdapter;
    }
}
