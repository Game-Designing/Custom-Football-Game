package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.WeakHashMap;

public class MoPubVideoNativeAdRenderer implements MoPubAdRenderer<VideoNativeAd> {

    /* renamed from: a */
    private final MediaViewBinder f35911a;
    @VisibleForTesting

    /* renamed from: b */
    final WeakHashMap<View, C11522E> f35912b = new WeakHashMap<>();

    public MoPubVideoNativeAdRenderer(MediaViewBinder mediaViewBinder) {
        this.f35911a = mediaViewBinder;
    }

    public View createAdView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(this.f35911a.f35798a, parent, false);
    }

    public void renderAdView(View view, VideoNativeAd videoNativeAd) {
        C11522E mediaViewHolder = (C11522E) this.f35912b.get(view);
        if (mediaViewHolder == null) {
            mediaViewHolder = C11522E.m38110a(view, this.f35911a);
            this.f35912b.put(view, mediaViewHolder);
        }
        m38305a(mediaViewHolder, videoNativeAd);
        NativeRendererHelper.updateExtras(mediaViewHolder.f35626b, this.f35911a.f35805h, videoNativeAd.getExtras());
        m38304a(mediaViewHolder, 0);
        videoNativeAd.render((MediaLayout) view.findViewById(this.f35911a.f35799b));
    }

    public boolean supports(BaseNativeAd nativeAd) {
        Preconditions.checkNotNull(nativeAd);
        return nativeAd instanceof VideoNativeAd;
    }

    /* renamed from: a */
    private void m38305a(C11522E mediaViewHolder, VideoNativeAd videoNativeAd) {
        NativeRendererHelper.addTextView(mediaViewHolder.f35628d, videoNativeAd.getTitle());
        NativeRendererHelper.addTextView(mediaViewHolder.f35629e, videoNativeAd.getText());
        NativeRendererHelper.addCtaButton(mediaViewHolder.f35631g, mediaViewHolder.f35626b, videoNativeAd.getCallToAction());
        if (mediaViewHolder.f35627c != null) {
            NativeImageHelper.loadImageView(videoNativeAd.getMainImageUrl(), mediaViewHolder.f35627c.getMainImageView());
        }
        NativeImageHelper.loadImageView(videoNativeAd.getIconImageUrl(), mediaViewHolder.f35630f);
        NativeRendererHelper.addPrivacyInformationIcon(mediaViewHolder.f35632h, videoNativeAd.getPrivacyInformationIconImageUrl(), videoNativeAd.getPrivacyInformationIconClickThroughUrl());
    }

    /* renamed from: a */
    private void m38304a(C11522E mediaViewHolder, int visibility) {
        View view = mediaViewHolder.f35626b;
        if (view != null) {
            view.setVisibility(visibility);
        }
    }
}
