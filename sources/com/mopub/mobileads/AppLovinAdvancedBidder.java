package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.MoPubAdvancedBidder;
import p019d.p143b.p150d.C7267q;

public class AppLovinAdvancedBidder implements MoPubAdvancedBidder {
    public String getCreativeNetworkName() {
        return "applovin_sdk";
    }

    public String getToken(Context context) {
        return C7267q.m15794a(context).mo23037a().mo23003a();
    }
}
