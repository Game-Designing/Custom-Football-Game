package com.moat.analytics.mobile.sma;

import android.app.Activity;

public interface WebAdTracker {
    @Deprecated
    void setActivity(Activity activity);

    void startTracking();

    void stopTracking();
}
