package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;

public interface InneractiveNativeAdEventsListener extends EventsListener {
    void onAdClicked(InneractiveAdSpot inneractiveAdSpot);

    void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot);

    void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, AdDisplayError adDisplayError);

    void onAdExpanded(InneractiveAdSpot inneractiveAdSpot);

    void onAdImpression(InneractiveAdSpot inneractiveAdSpot);

    void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot);

    void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot);
}
