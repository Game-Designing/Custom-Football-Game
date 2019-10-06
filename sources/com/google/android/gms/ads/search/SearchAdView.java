package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbad;

@zzard
public final class SearchAdView extends ViewGroup {

    /* renamed from: a */
    private final zzabb f19249a;

    public SearchAdView(Context context) {
        super(context);
        this.f19249a = new zzabb(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19249a = new zzabb(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19249a = new zzabb(this, attributeSet, false);
    }

    public final void destroy() {
        this.f19249a.mo29426a();
    }

    public final AdListener getAdListener() {
        return this.f19249a.mo29438b();
    }

    public final AdSize getAdSize() {
        return this.f19249a.mo29440c();
    }

    public final String getAdUnitId() {
        return this.f19249a.mo29442e();
    }

    public final void loadAd(SearchAdRequest searchAdRequest) {
        this.f19249a.mo29432a(searchAdRequest.mo27027a());
    }

    public final void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.f19249a.mo29432a(dynamicHeightSearchAdRequest.mo26977a());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    public final void pause() {
        this.f19249a.mo29449l();
    }

    public final void resume() {
        this.f19249a.mo29451n();
    }

    public final void setAdListener(AdListener adListener) {
        this.f19249a.mo29427a(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.f19249a.mo29436a(adSize);
    }

    public final void setAdUnitId(String str) {
        this.f19249a.mo29434a(str);
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
