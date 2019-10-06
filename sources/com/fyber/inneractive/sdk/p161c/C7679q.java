package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.external.VideoContentListener;

/* renamed from: com.fyber.inneractive.sdk.c.q */
public abstract class C7679q extends C7674j<VideoContentListener> implements VideoContentListener {
    protected boolean isOverlayOutside = true;

    public C7679q setOverlayOutside(boolean z) {
        this.isOverlayOutside = z;
        return this;
    }

    public boolean isOverlayOutside() {
        return this.isOverlayOutside;
    }

    public void onProgress(int i, int i2) {
        EventsListenerT eventslistenert = this.mEventsListener;
        if (eventslistenert != null) {
            ((VideoContentListener) eventslistenert).onProgress(i, i2);
        }
    }

    public void onCompleted() {
        EventsListenerT eventslistenert = this.mEventsListener;
        if (eventslistenert != null) {
            ((VideoContentListener) eventslistenert).onCompleted();
        }
    }

    public void onPlayerError() {
        EventsListenerT eventslistenert = this.mEventsListener;
        if (eventslistenert != null) {
            ((VideoContentListener) eventslistenert).onPlayerError();
        }
    }
}
