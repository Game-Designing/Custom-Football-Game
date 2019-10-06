package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;

public abstract class InneractiveNativeAdEventsListenerAdapter implements InneractiveNativeAdEventsListener {
    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, AdDisplayError adDisplayError) {
    }
}
