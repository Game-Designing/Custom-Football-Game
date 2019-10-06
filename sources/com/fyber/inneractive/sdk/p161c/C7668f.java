package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.p174i.C7907g;

/* renamed from: com.fyber.inneractive.sdk.c.f */
public abstract class C7668f<T extends C7907g> {
    protected InneractiveAdRequest mAdRequest;
    protected T mResponseData;
    protected final C7712j mUnitConfig;

    public abstract void destroy();

    public abstract String getClickThroughUrl();

    public abstract boolean isVideoAd();

    protected C7668f(C7712j jVar) {
        this.mUnitConfig = jVar;
    }

    public T getResponseData() {
        return this.mResponseData;
    }

    public void setResponseData(T t) {
        this.mResponseData = t;
    }

    public InneractiveAdRequest getAdRequest() {
        return this.mAdRequest;
    }

    public void setAdRequest(InneractiveAdRequest inneractiveAdRequest) {
        this.mAdRequest = inneractiveAdRequest;
    }

    public C7712j getUnitConfig() {
        return this.mUnitConfig;
    }

    public boolean isFullscreenAd() {
        return this.mUnitConfig.mo24208d() != null ? false : false;
    }
}
