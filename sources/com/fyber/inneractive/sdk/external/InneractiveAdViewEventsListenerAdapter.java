package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;

public abstract class InneractiveAdViewEventsListenerAdapter implements InneractiveAdViewEventsListener {
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

    public void onAdExpanded(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdResized(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot) {
    }
}
