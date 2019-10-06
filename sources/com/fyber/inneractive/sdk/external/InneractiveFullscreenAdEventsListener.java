package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;

public interface InneractiveFullscreenAdEventsListener extends EventsListener {
    void onAdClicked(InneractiveAdSpot inneractiveAdSpot);

    void onAdDismissed(InneractiveAdSpot inneractiveAdSpot);

    void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, AdDisplayError adDisplayError);

    void onAdImpression(InneractiveAdSpot inneractiveAdSpot);

    void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot);

    void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot);
}
