package com.inmobi.ads.listeners;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import java.util.Map;

public abstract class InterstitialAdEventListener {
    public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
    }

    public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
    }

    public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
    }

    public void onAdClicked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
    }

    public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
    }

    public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
    }

    public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
    }

    public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
    }

    public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
    }

    public void onRewardsUnlocked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
    }

    public void onRequestPayloadCreated(byte[] bArr) {
    }

    public void onRequestPayloadCreationFailed(InMobiAdRequestStatus inMobiAdRequestStatus) {
    }
}
