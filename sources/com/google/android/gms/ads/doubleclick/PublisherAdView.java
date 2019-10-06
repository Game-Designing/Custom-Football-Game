package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzzk;

public final class PublisherAdView extends ViewGroup {

    /* renamed from: a */
    private final zzabb f19040a;

    public PublisherAdView(Context context) {
        super(context);
        this.f19040a = new zzabb(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19040a = new zzabb(this, attributeSet, true);
        Preconditions.m21858a(context, (Object) "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19040a = new zzabb(this, attributeSet, true);
    }

    public final VideoController getVideoController() {
        return this.f19040a.mo29446i();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.f19040a.mo29429a(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.f19040a.mo29447j();
    }

    public final void destroy() {
        this.f19040a.mo29426a();
    }

    public final AdListener getAdListener() {
        return this.f19040a.mo29438b();
    }

    public final AdSize getAdSize() {
        return this.f19040a.mo29440c();
    }

    public final AdSize[] getAdSizes() {
        return this.f19040a.mo29441d();
    }

    public final String getAdUnitId() {
        return this.f19040a.mo29442e();
    }

    public final AppEventListener getAppEventListener() {
        return this.f19040a.mo29443f();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f19040a.mo29445h();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f19040a.mo29432a(publisherAdRequest.zzde());
    }

    public final void pause() {
        this.f19040a.mo29449l();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.f19040a.mo29435a(z);
    }

    public final void recordManualImpression() {
        this.f19040a.mo29450m();
    }

    public final void resume() {
        this.f19040a.mo29451n();
    }

    public final void setAdListener(AdListener adListener) {
        this.f19040a.mo29427a(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f19040a.mo29439b(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.f19040a.mo29434a(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.f19040a.mo29430a(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.f19040a.mo29428a(correlator);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f19040a.mo29431a(onCustomRenderedAdLoadedListener);
    }

    public final String getMediationAdapterClassName() {
        return this.f19040a.mo29444g();
    }

    public final boolean isLoading() {
        return this.f19040a.mo29448k();
    }

    public final boolean zza(zzzk zzzk) {
        return this.f19040a.mo29437a(zzzk);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbad.m26356b("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
