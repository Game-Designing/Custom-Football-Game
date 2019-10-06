package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;

public final class PublisherInterstitialAd {

    /* renamed from: a */
    private final zzabd f19041a;

    public PublisherInterstitialAd(Context context) {
        this.f19041a = new zzabd(context, this);
        Preconditions.m21858a(context, (Object) "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.f19041a.mo29453a();
    }

    public final String getAdUnitId() {
        return this.f19041a.mo29466c();
    }

    public final AppEventListener getAppEventListener() {
        return this.f19041a.mo29467d();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f19041a.mo29469f();
    }

    public final boolean isLoaded() {
        return this.f19041a.mo29470g();
    }

    public final boolean isLoading() {
        return this.f19041a.mo29471h();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f19041a.mo29460a(publisherAdRequest.zzde());
    }

    public final void setAdListener(AdListener adListener) {
        this.f19041a.mo29454a(adListener);
    }

    public final void setAdUnitId(String str) {
        this.f19041a.mo29462a(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.f19041a.mo29456a(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f19041a.mo29457a(onCustomRenderedAdLoadedListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.f19041a.mo29455a(correlator);
    }

    public final String getMediationAdapterClassName() {
        return this.f19041a.mo29468e();
    }

    public final void show() {
        this.f19041a.mo29472i();
    }

    public final void setImmersiveMode(boolean z) {
        this.f19041a.mo29463a(z);
    }
}
