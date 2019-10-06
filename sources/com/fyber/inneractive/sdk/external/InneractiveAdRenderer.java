package com.fyber.inneractive.sdk.external;

public interface InneractiveAdRenderer {
    boolean canRefreshAd();

    void destroy();

    void initialize(InneractiveAdSpot inneractiveAdSpot);
}
