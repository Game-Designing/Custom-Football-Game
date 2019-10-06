package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import java.util.Map;
import java.util.WeakHashMap;

public class GooglePlayServicesAdRenderer implements MoPubAdRenderer<C11529a> {

    /* renamed from: a */
    private static final String f35644a = GooglePlayServicesAdRenderer.class.getSimpleName();

    /* renamed from: b */
    private final MediaViewBinder f35645b;

    /* renamed from: c */
    private final WeakHashMap<View, C11528a> f35646c = new WeakHashMap<>();

    /* renamed from: com.mopub.nativeads.GooglePlayServicesAdRenderer$a */
    private static class C11528a {

        /* renamed from: a */
        private static final C11528a f35647a = new C11528a();

        /* renamed from: b */
        View f35648b;

        /* renamed from: c */
        TextView f35649c;

        /* renamed from: d */
        TextView f35650d;

        /* renamed from: e */
        TextView f35651e;

        /* renamed from: f */
        ImageView f35652f;

        /* renamed from: g */
        ImageView f35653g;

        /* renamed from: h */
        TextView f35654h;

        /* renamed from: i */
        TextView f35655i;

        /* renamed from: j */
        TextView f35656j;

        /* renamed from: k */
        TextView f35657k;

        /* renamed from: l */
        FrameLayout f35658l;

        /* renamed from: m */
        MediaLayout f35659m;

        private C11528a() {
        }

        public static C11528a fromViewBinder(View view, MediaViewBinder viewBinder) {
            C11528a viewHolder = new C11528a();
            viewHolder.f35648b = view;
            try {
                viewHolder.f35649c = (TextView) view.findViewById(viewBinder.f35800c);
                viewHolder.f35650d = (TextView) view.findViewById(viewBinder.f35801d);
                viewHolder.f35651e = (TextView) view.findViewById(viewBinder.f35802e);
                viewHolder.f35652f = (ImageView) view.findViewById(viewBinder.f35803f);
                viewHolder.f35653g = (ImageView) view.findViewById(viewBinder.f35804g);
                viewHolder.f35659m = (MediaLayout) view.findViewById(viewBinder.f35799b);
                Map<String, Integer> extraViews = viewBinder.f35805h;
                Integer starRatingTextViewId = (Integer) extraViews.get("key_star_rating");
                if (starRatingTextViewId != null) {
                    viewHolder.f35654h = (TextView) view.findViewById(starRatingTextViewId.intValue());
                }
                Integer advertiserTextViewId = (Integer) extraViews.get("key_advertiser");
                if (advertiserTextViewId != null) {
                    viewHolder.f35655i = (TextView) view.findViewById(advertiserTextViewId.intValue());
                }
                Integer storeTextViewId = (Integer) extraViews.get("key_store");
                if (storeTextViewId != null) {
                    viewHolder.f35656j = (TextView) view.findViewById(storeTextViewId.intValue());
                }
                Integer priceTextViewId = (Integer) extraViews.get("key_price");
                if (priceTextViewId != null) {
                    viewHolder.f35657k = (TextView) view.findViewById(priceTextViewId.intValue());
                }
                Integer adChoicesIconViewId = (Integer) extraViews.get("ad_choices_container");
                if (adChoicesIconViewId != null) {
                    viewHolder.f35658l = (FrameLayout) view.findViewById(adChoicesIconViewId.intValue());
                }
                return viewHolder;
            } catch (ClassCastException exception) {
                MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Could not cast from id in ViewBinder to expected View type", exception);
                return f35647a;
            }
        }
    }

    public GooglePlayServicesAdRenderer(MediaViewBinder viewBinder) {
        this.f35645b = viewBinder;
    }

    public View createAdView(Context context, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(this.f35645b.f35798a, parent, false);
        FrameLayout wrappingView = new FrameLayout(context);
        wrappingView.setId(1001);
        wrappingView.addView(view);
        MoPubLog.log(AdapterLogEvent.CUSTOM, f35644a, "Ad view created.");
        return wrappingView;
    }

    public void renderAdView(View view, C11529a nativeAd) {
        C11528a viewHolder = (C11528a) this.f35646c.get(view);
        if (viewHolder == null) {
            viewHolder = C11528a.fromViewBinder(view, this.f35645b);
            this.f35646c.put(view, viewHolder);
        }
        UnifiedNativeAdView unifiedAdView = new UnifiedNativeAdView(view.getContext());
        m38134a(nativeAd, viewHolder, unifiedAdView);
        m38133a(unifiedAdView, view, nativeAd.shouldSwapMargins());
    }

    /* renamed from: a */
    private static void m38133a(UnifiedNativeAdView googleUnifiedAdView, View moPubNativeAdView, boolean swapMargins) {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f35644a);
        if (!(moPubNativeAdView instanceof FrameLayout) || moPubNativeAdView.getId() != 1001) {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f35644a, "Couldn't add Google native ad view. Wrapping view not found.");
            return;
        }
        googleUnifiedAdView.setId(1002);
        FrameLayout outerFrame = (FrameLayout) moPubNativeAdView;
        View actualView = outerFrame.getChildAt(0);
        if (swapMargins) {
            LayoutParams googleNativeAdViewParams = new LayoutParams(-1, -1);
            LayoutParams actualViewParams = (LayoutParams) actualView.getLayoutParams();
            googleNativeAdViewParams.setMargins(actualViewParams.leftMargin, actualViewParams.topMargin, actualViewParams.rightMargin, actualViewParams.bottomMargin);
            googleUnifiedAdView.setLayoutParams(googleNativeAdViewParams);
            actualViewParams.setMargins(0, 0, 0, 0);
        } else {
            googleUnifiedAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        outerFrame.removeView(actualView);
        googleUnifiedAdView.addView(actualView);
        outerFrame.addView(googleUnifiedAdView);
    }

    /* renamed from: a */
    private void m38134a(C11529a staticNativeAd, C11528a staticNativeViewHolder, UnifiedNativeAdView unifiedAdView) {
        NativeRendererHelper.addTextView(staticNativeViewHolder.f35649c, staticNativeAd.getTitle());
        unifiedAdView.setHeadlineView(staticNativeViewHolder.f35649c);
        NativeRendererHelper.addTextView(staticNativeViewHolder.f35650d, staticNativeAd.getText());
        unifiedAdView.setBodyView(staticNativeViewHolder.f35650d);
        if (staticNativeViewHolder.f35659m != null) {
            MediaView mediaview = new MediaView(unifiedAdView.getContext());
            staticNativeViewHolder.f35659m.removeAllViews();
            staticNativeViewHolder.f35659m.addView(mediaview);
            unifiedAdView.setMediaView(mediaview);
        }
        NativeRendererHelper.addTextView(staticNativeViewHolder.f35651e, staticNativeAd.getCallToAction());
        unifiedAdView.setCallToActionView(staticNativeViewHolder.f35651e);
        NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), staticNativeViewHolder.f35652f);
        unifiedAdView.setImageView(staticNativeViewHolder.f35652f);
        if (staticNativeAd.getAdvertiser() != null) {
            NativeRendererHelper.addTextView(staticNativeViewHolder.f35655i, staticNativeAd.getAdvertiser());
            unifiedAdView.setAdvertiserView(staticNativeViewHolder.f35655i);
        }
        if (staticNativeViewHolder.f35658l != null) {
            AdChoicesView adChoicesView = new AdChoicesView(unifiedAdView.getContext());
            staticNativeViewHolder.f35658l.removeAllViews();
            staticNativeViewHolder.f35658l.addView(adChoicesView);
            unifiedAdView.setAdChoicesView(adChoicesView);
        }
        NativeRendererHelper.addPrivacyInformationIcon(staticNativeViewHolder.f35653g, null, null);
        unifiedAdView.setNativeAd(staticNativeAd.getUnifiedNativeAd());
    }

    public boolean supports(BaseNativeAd nativeAd) {
        return nativeAd instanceof C11529a;
    }
}
