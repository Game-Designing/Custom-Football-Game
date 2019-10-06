package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

public final class UnifiedNativeAdView extends FrameLayout {

    /* renamed from: a */
    private final FrameLayout f19066a;

    /* renamed from: b */
    private final zzaem f19067b = m20822a();

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.f19066a = m20821a(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19066a = m20821a(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19066a = m20821a(context);
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f19066a = m20821a(context);
    }

    /* renamed from: a */
    private final void m20823a(String str, View view) {
        try {
            this.f19067b.mo29538b(str, ObjectWrapper.m22188a(view));
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setCallToActionView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setIconView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setBodyView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setAdvertiserView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setStoreView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.f19067b.mo29541e(ObjectWrapper.m22188a(view));
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setImageView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setStarRatingView(View view) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setMediaView(MediaView mediaView) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        m20823a(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.f19067b.mo29539d((IObjectWrapper) unifiedNativeAd.mo26573a());
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call setNativeAd on delegate", e);
        }
    }

    /* renamed from: a */
    private final View m20820a(String str) {
        try {
            IObjectWrapper f = this.f19067b.mo29542f(str);
            if (f != null) {
                return (View) ObjectWrapper.m22187H(f);
            }
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    public final View getHeadlineView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getCallToActionView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getIconView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getBodyView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getStoreView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    public final View getPriceView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getAdvertiserView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getImageView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final View getStarRatingView() {
        return m20820a(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final MediaView getMediaView() {
        View a = m20820a(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (a instanceof MediaView) {
            return (MediaView) a;
        }
        if (a != null) {
            zzbad.m26352a("View is not an instance of MediaView");
        }
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View a = m20820a(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (a instanceof AdChoicesView) {
            return (AdChoicesView) a;
        }
        return null;
    }

    public final void destroy() {
        try {
            this.f19067b.destroy();
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to destroy native ad view", e);
        }
    }

    /* renamed from: a */
    private final FrameLayout m20821a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    /* renamed from: a */
    private final zzaem m20822a() {
        Preconditions.m21858a(this.f19066a, (Object) "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzyt.m31533b().mo32387a(this.f19066a.getContext(), (FrameLayout) this, this.f19066a);
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f19066a);
    }

    public final void removeView(View view) {
        if (this.f19066a != view) {
            super.removeView(view);
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f19066a);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f19066a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaem zzaem = this.f19067b;
        if (zzaem != null) {
            try {
                zzaem.mo29537a(ObjectWrapper.m22188a(view), i);
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }
}
