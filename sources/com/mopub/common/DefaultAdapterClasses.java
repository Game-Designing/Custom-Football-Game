package com.mopub.common;

import java.util.HashSet;
import java.util.Set;

public enum DefaultAdapterClasses {
    AD_COLONY_ADAPTER_CONFIGURATION("com.mopub.mobileads.AdColonyAdapterConfiguration"),
    APPLOVIN_ADAPTER_CONFIGURATION("com.mopub.mobileads.AppLovinAdapterConfiguration"),
    CHARTBOOST_ADAPTER_CONFIGURATION("com.mopub.mobileads.ChartboostAdapterConfiguration"),
    FACEBOOK_ADAPTER_CONFIGURATION("com.mopub.mobileads.FacebookAdapterConfiguration"),
    FLURRY_ADAPTER_CONFIGURATION("com.mopub.mobileads.FlurryAdapterConfiguration"),
    IRON_SOURCE_ADAPTER_CONFIGURATION("com.mopub.mobileads.IronSourceAdapterConfiguration"),
    GOOGLE_PLAY_SERVICES_ADAPTER_CONFIGURATION("com.mopub.mobileads.GooglePlayServicesAdapterConfiguration"),
    TAPJOY_ADAPTER_CONFIGURATION("com.mopub.mobileads.TapjoyAdapterConfiguration"),
    UNITY_ADS_ADAPTER_CONFIGURATION("com.mopub.mobileads.UnityAdsAdapterConfiguration"),
    VERIZON_ADAPTER_CONFIGURATION("com.mopub.mobileads.VerizonAdapterConfiguration"),
    VUNGLE_ADAPTER_CONFIGURATION("com.mopub.mobileads.VungleAdapterConfiguration");
    

    /* renamed from: b */
    private final String f34278b;

    private DefaultAdapterClasses(String className) {
        this.f34278b = className;
    }

    public static Set<String> getClassNamesSet() {
        Set<String> adapterConfigurations = new HashSet<>();
        for (DefaultAdapterClasses adapterConfiguration : values()) {
            adapterConfigurations.add(adapterConfiguration.f34278b);
        }
        return adapterConfigurations;
    }
}
