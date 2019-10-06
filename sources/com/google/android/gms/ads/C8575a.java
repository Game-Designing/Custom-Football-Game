package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzxr;

/* renamed from: com.google.android.gms.ads.a */
class C8575a extends ViewGroup {

    /* renamed from: a */
    protected final zzabb f19037a;

    public C8575a(Context context, int i) {
        super(context);
        this.f19037a = new zzabb(this, i);
    }

    public C8575a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f19037a = new zzabb(this, attributeSet, false, i);
    }

    public C8575a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f19037a = new zzabb(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.f19037a.mo29426a();
    }

    public AdListener getAdListener() {
        return this.f19037a.mo29438b();
    }

    public AdSize getAdSize() {
        return this.f19037a.mo29440c();
    }

    public String getAdUnitId() {
        return this.f19037a.mo29442e();
    }

    public void loadAd(AdRequest adRequest) {
        this.f19037a.mo29432a(adRequest.zzde());
    }

    public void pause() {
        this.f19037a.mo29449l();
    }

    public void resume() {
        this.f19037a.mo29451n();
    }

    public boolean isLoading() {
        return this.f19037a.mo29448k();
    }

    public void setAdListener(AdListener adListener) {
        this.f19037a.mo29427a(adListener);
        if (adListener == null) {
            this.f19037a.mo29433a((zzxr) null);
            this.f19037a.mo29430a((AppEventListener) null);
            return;
        }
        if (adListener instanceof zzxr) {
            this.f19037a.mo29433a((zzxr) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.f19037a.mo29430a((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f19037a.mo29436a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f19037a.mo29434a(str);
    }

    public String getMediationAdapterClassName() {
        return this.f19037a.mo29444g();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    public void onMeasure(int i, int i2) {
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
