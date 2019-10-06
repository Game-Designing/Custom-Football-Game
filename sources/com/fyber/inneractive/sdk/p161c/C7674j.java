package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController.EventsListener;
import com.fyber.inneractive.sdk.util.C8017o;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: com.fyber.inneractive.sdk.c.j */
public abstract class C7674j<EventsListenerT extends EventsListener> implements InneractiveContentController<EventsListenerT> {
    protected WeakReference<InneractiveAdSpot> mAdSpot;
    protected EventsListenerT mEventsListener;

    public abstract boolean canControl(InneractiveAdSpot inneractiveAdSpot);

    public EventsListenerT getEventsListener() {
        return this.mEventsListener;
    }

    public void setEventsListener(EventsListenerT eventslistenert) {
        this.mEventsListener = eventslistenert;
    }

    public void destroy() {
        this.mEventsListener = null;
        this.mAdSpot = null;
    }

    public InneractiveAdSpot getAdSpot() {
        return (InneractiveAdSpot) C8017o.m18094a((Reference<T>) this.mAdSpot);
    }

    public void setAdSpot(InneractiveAdSpot inneractiveAdSpot) {
        this.mAdSpot = new WeakReference<>(inneractiveAdSpot);
    }
}
