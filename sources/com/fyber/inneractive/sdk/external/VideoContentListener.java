package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.external.InneractiveContentController.EventsListener;

public interface VideoContentListener extends EventsListener {
    void onCompleted();

    void onPlayerError();

    void onProgress(int i, int i2);
}
