package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.WeakHashMap;

public class MoPubStaticNativeAdRenderer implements MoPubAdRenderer<StaticNativeAd> {

    /* renamed from: a */
    private final ViewBinder f35890a;
    @VisibleForTesting

    /* renamed from: b */
    final WeakHashMap<View, C11512Ab> f35891b = new WeakHashMap<>();

    public MoPubStaticNativeAdRenderer(ViewBinder viewBinder) {
        this.f35890a = viewBinder;
    }

    public View createAdView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(this.f35890a.f36081a, parent, false);
    }

    public void renderAdView(View view, StaticNativeAd staticNativeAd) {
        C11512Ab staticNativeViewHolder = (C11512Ab) this.f35891b.get(view);
        if (staticNativeViewHolder == null) {
            staticNativeViewHolder = C11512Ab.m38088a(view, this.f35890a);
            this.f35891b.put(view, staticNativeViewHolder);
        }
        m38291a(staticNativeViewHolder, staticNativeAd);
        NativeRendererHelper.updateExtras(staticNativeViewHolder.f35590b, this.f35890a.f36088h, staticNativeAd.getExtras());
        m38290a(staticNativeViewHolder, 0);
    }

    public boolean supports(BaseNativeAd nativeAd) {
        Preconditions.checkNotNull(nativeAd);
        return nativeAd instanceof StaticNativeAd;
    }

    /* renamed from: a */
    private void m38291a(C11512Ab staticNativeViewHolder, StaticNativeAd staticNativeAd) {
        NativeRendererHelper.addTextView(staticNativeViewHolder.f35591c, staticNativeAd.getTitle());
        NativeRendererHelper.addTextView(staticNativeViewHolder.f35592d, staticNativeAd.getText());
        NativeRendererHelper.addTextView(staticNativeViewHolder.f35593e, staticNativeAd.getCallToAction());
        NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(), staticNativeViewHolder.f35594f);
        NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), staticNativeViewHolder.f35595g);
        NativeRendererHelper.addPrivacyInformationIcon(staticNativeViewHolder.f35596h, staticNativeAd.getPrivacyInformationIconImageUrl(), staticNativeAd.getPrivacyInformationIconClickThroughUrl());
    }

    /* renamed from: a */
    private void m38290a(C11512Ab staticNativeViewHolder, int visibility) {
        View view = staticNativeViewHolder.f35590b;
        if (view != null) {
            view.setVisibility(visibility);
        }
    }
}
