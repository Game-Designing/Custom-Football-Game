package com.mopub.mobileads;

public interface VungleRouterListener {
    void onAdAvailabilityUpdate(String str, boolean z);

    void onAdEnd(String str, boolean z, boolean z2);

    void onAdStart(String str);

    void onUnableToPlayAd(String str, String str2);
}
