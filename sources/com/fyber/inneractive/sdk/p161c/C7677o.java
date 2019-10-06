package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.fyber.inneractive.sdk.c.o */
public abstract class C7677o<EL extends EventsListener> implements InneractiveUnitController<EL> {
    protected WeakReference<C7673i> mAdSpot;
    protected Set<InneractiveContentController> mContentControllers = new HashSet();
    protected EL mEventsListener;
    protected InneractiveContentController mSelectedContentController;

    public abstract boolean supports(InneractiveAdSpot inneractiveAdSpot);

    public abstract boolean supportsRefresh();

    protected C7677o() {
    }

    public void setEventsListener(EL el) {
        this.mEventsListener = el;
    }

    public EL getEventsListener() {
        return this.mEventsListener;
    }

    public InneractiveAdSpot getAdSpot() {
        return (C7673i) C8017o.m18094a((Reference<T>) this.mAdSpot);
    }

    public void addContentController(InneractiveContentController inneractiveContentController) {
        this.mContentControllers.add(inneractiveContentController);
    }

    public InneractiveContentController getSelectedContentController() {
        return this.mSelectedContentController;
    }

    public void setAdSpot(C7673i iVar) {
        this.mAdSpot = new WeakReference<>(iVar);
    }

    /* access modifiers changed from: protected */
    public void selectContentController() {
        InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) C8017o.m18094a((Reference<T>) this.mAdSpot);
        if (inneractiveAdSpot == null) {
            IAlog.m18023d("selectContentController called, but ad spot is null");
            return;
        }
        for (InneractiveContentController inneractiveContentController : this.mContentControllers) {
            C7674j jVar = (C7674j) inneractiveContentController;
            if (jVar.canControl(inneractiveAdSpot)) {
                this.mSelectedContentController = inneractiveContentController;
                jVar.setAdSpot(inneractiveAdSpot);
            }
        }
    }

    public void destroy() {
        for (InneractiveContentController destroy : this.mContentControllers) {
            destroy.destroy();
        }
        this.mContentControllers.clear();
        this.mSelectedContentController = null;
        this.mAdSpot = null;
    }

    public boolean canRefreshAd() {
        return supportsRefresh();
    }

    /* access modifiers changed from: protected */
    public String logPrefix() {
        return IAlog.m18018a((Object) this);
    }
}
