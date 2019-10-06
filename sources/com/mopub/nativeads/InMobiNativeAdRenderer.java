package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.common.Preconditions;
import com.mopub.nativeads.InMobiNativeCustomEvent.InMobiNativeAd;
import java.util.Map;
import java.util.WeakHashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class InMobiNativeAdRenderer implements MoPubAdRenderer<InMobiNativeAd> {
    public static final String VIEW_BINDER_KEY_PRIMARY_AD_VIEW_LAYOUT = "primary_ad_view_layout";

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f35719a;

    /* renamed from: b */
    private final ViewBinder f35720b;

    /* renamed from: c */
    private final WeakHashMap<View, C11536a> f35721c = new WeakHashMap<>();

    /* renamed from: d */
    private View f35722d;

    /* renamed from: com.mopub.nativeads.InMobiNativeAdRenderer$a */
    static class C11536a {

        /* renamed from: a */
        private static transient /* synthetic */ boolean[] f35723a;

        /* renamed from: b */
        private final C11512Ab f35724b;

        /* renamed from: c */
        private final ViewGroup f35725c;

        /* renamed from: d */
        private final boolean f35726d;

        /* renamed from: a */
        private static /* synthetic */ boolean[] m38170a() {
            boolean[] zArr = f35723a;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-4253612426448908816L, "com/mopub/nativeads/InMobiNativeAdRenderer$InMobiNativeViewHolder", 19);
            f35723a = probes;
            return probes;
        }

        private C11536a(C11512Ab staticNativeViewHolder, ViewGroup primaryAdViewLayout, boolean mainImageViewInRelativeView) {
            boolean[] a = m38170a();
            this.f35724b = staticNativeViewHolder;
            this.f35725c = primaryAdViewLayout;
            this.f35726d = mainImageViewInRelativeView;
            a[0] = true;
        }

        /* renamed from: a */
        static C11536a m38169a(View view, ViewBinder viewBinder) {
            ViewGroup primaryAdViewLayout;
            boolean[] a = m38170a();
            a[1] = true;
            C11512Ab staticNativeViewHolder = C11512Ab.m38088a(view, viewBinder);
            View mainImageView = staticNativeViewHolder.f35594f;
            boolean mainImageViewInRelativeView = false;
            if (mainImageView == null) {
                a[2] = true;
            } else {
                a[3] = true;
                if (!(((ViewGroup) mainImageView.getParent()) instanceof RelativeLayout)) {
                    a[4] = true;
                } else {
                    mainImageViewInRelativeView = true;
                    a[5] = true;
                }
            }
            Map<String, Integer> map = viewBinder.f36088h;
            String str = InMobiNativeAdRenderer.VIEW_BINDER_KEY_PRIMARY_AD_VIEW_LAYOUT;
            if (map.get(str) != null) {
                Map<String, Integer> map2 = viewBinder.f36088h;
                a[6] = true;
                int intValue = ((Integer) map2.get(str)).intValue();
                a[7] = true;
                primaryAdViewLayout = (ViewGroup) view.findViewById(intValue);
                a[8] = true;
            } else {
                primaryAdViewLayout = null;
                a[9] = true;
            }
            C11536a aVar = new C11536a(staticNativeViewHolder, primaryAdViewLayout, mainImageViewInRelativeView);
            a[10] = true;
            return aVar;
        }

        public View getMainView() {
            boolean[] a = m38170a();
            View view = this.f35724b.f35590b;
            a[11] = true;
            return view;
        }

        public TextView getTitleView() {
            boolean[] a = m38170a();
            TextView textView = this.f35724b.f35591c;
            a[12] = true;
            return textView;
        }

        public TextView getTextView() {
            boolean[] a = m38170a();
            TextView textView = this.f35724b.f35592d;
            a[13] = true;
            return textView;
        }

        public TextView getCallToActionView() {
            boolean[] a = m38170a();
            TextView textView = this.f35724b.f35593e;
            a[14] = true;
            return textView;
        }

        public ImageView getMainImageView() {
            boolean[] a = m38170a();
            ImageView imageView = this.f35724b.f35594f;
            a[15] = true;
            return imageView;
        }

        public ImageView getIconImageView() {
            boolean[] a = m38170a();
            ImageView imageView = this.f35724b.f35595g;
            a[16] = true;
            return imageView;
        }

        public ViewGroup getPrimaryAdViewLayout() {
            boolean[] a = m38170a();
            ViewGroup viewGroup = this.f35725c;
            a[17] = true;
            return viewGroup;
        }

        public boolean isMainImageViewInRelativeView() {
            boolean[] a = m38170a();
            boolean z = this.f35726d;
            a[18] = true;
            return z;
        }
    }

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38168a() {
        boolean[] zArr = f35719a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9206552101394352661L, "com/mopub/nativeads/InMobiNativeAdRenderer", 60);
        f35719a = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void renderAdView(View view, BaseNativeAd baseNativeAd) {
        boolean[] a = m38168a();
        renderAdView(view, (InMobiNativeAd) baseNativeAd);
        a[59] = true;
    }

    public InMobiNativeAdRenderer(ViewBinder mViewBinder) {
        boolean[] a = m38168a();
        this.f35720b = mViewBinder;
        a[0] = true;
        a[1] = true;
    }

    /* renamed from: a */
    private static void m38166a(C11536a inMobiNativeViewHolder, int visibility) {
        boolean[] a = m38168a();
        if (inMobiNativeViewHolder.getMainView() == null) {
            a[2] = true;
        } else {
            a[3] = true;
            View mainView = inMobiNativeViewHolder.getMainView();
            a[4] = true;
            mainView.setVisibility(visibility);
            a[5] = true;
        }
        a[6] = true;
    }

    public View createAdView(Context context, ViewGroup parent) {
        boolean[] a = m38168a();
        LayoutInflater from = LayoutInflater.from(context);
        int i = this.f35720b.f36081a;
        a[7] = true;
        this.f35722d = from.inflate(i, parent, false);
        a[8] = true;
        View mainImageView = this.f35722d.findViewById(this.f35720b.f36085e);
        if (mainImageView == null) {
            View view = this.f35722d;
            a[9] = true;
            return view;
        }
        LayoutParams mainImageViewLayoutParams = mainImageView.getLayoutParams();
        a[10] = true;
        RelativeLayout.LayoutParams primaryViewLayoutParams = new RelativeLayout.LayoutParams(mainImageViewLayoutParams.width, mainImageViewLayoutParams.height);
        if (!(mainImageViewLayoutParams instanceof MarginLayoutParams)) {
            a[11] = true;
        } else {
            MarginLayoutParams marginParams = (MarginLayoutParams) mainImageViewLayoutParams;
            a[12] = true;
            primaryViewLayoutParams.setMargins(marginParams.leftMargin, marginParams.topMargin, marginParams.rightMargin, marginParams.bottomMargin);
            a[13] = true;
            primaryViewLayoutParams.addRule(3, this.f35720b.f36085e);
            a[14] = true;
        }
        if (!(mainImageViewLayoutParams instanceof RelativeLayout.LayoutParams)) {
            a[15] = true;
        } else {
            RelativeLayout.LayoutParams mainImageViewRelativeLayoutParams = (RelativeLayout.LayoutParams) mainImageViewLayoutParams;
            a[16] = true;
            int[] rules = mainImageViewRelativeLayoutParams.getRules();
            int i2 = 0;
            a[17] = true;
            while (i2 < rules.length) {
                a[19] = true;
                primaryViewLayoutParams.addRule(i2, rules[i2]);
                i2++;
                a[20] = true;
            }
            a[18] = true;
        }
        mainImageView.setVisibility(4);
        a[21] = true;
        Map<String, Integer> map = this.f35720b.f36088h;
        String str = VIEW_BINDER_KEY_PRIMARY_AD_VIEW_LAYOUT;
        if (map.get(str) == null) {
            a[22] = true;
        } else {
            View view2 = this.f35722d;
            Map<String, Integer> map2 = this.f35720b.f36088h;
            a[23] = true;
            ViewGroup primaryAdLayout = (ViewGroup) view2.findViewById(((Integer) map2.get(str)).intValue());
            if (primaryAdLayout == null) {
                a[24] = true;
            } else if (!(primaryAdLayout instanceof RelativeLayout)) {
                a[25] = true;
            } else {
                a[26] = true;
                primaryAdLayout.setLayoutParams(primaryViewLayoutParams);
                a[27] = true;
            }
        }
        View view3 = this.f35722d;
        a[28] = true;
        return view3;
    }

    public void renderAdView(View view, InMobiNativeAd inMobiNativeAd) {
        boolean[] a = m38168a();
        C11536a inMobiNativeViewHolder = (C11536a) this.f35721c.get(view);
        if (inMobiNativeViewHolder != null) {
            a[29] = true;
        } else {
            a[30] = true;
            inMobiNativeViewHolder = C11536a.m38169a(view, this.f35720b);
            a[31] = true;
            this.f35721c.put(view, inMobiNativeViewHolder);
            a[32] = true;
        }
        m38167a(inMobiNativeViewHolder, inMobiNativeAd);
        a[33] = true;
        m38166a(inMobiNativeViewHolder, 0);
        a[34] = true;
    }

    public boolean supports(BaseNativeAd nativeAd) {
        boolean[] a = m38168a();
        Preconditions.checkNotNull(nativeAd);
        boolean z = nativeAd instanceof InMobiNativeAd;
        a[35] = true;
        return z;
    }

    /* renamed from: a */
    private void m38167a(C11536a inMobiNativeViewHolder, InMobiNativeAd inMobiNativeAd) {
        boolean[] a = m38168a();
        ImageView mainImageView = inMobiNativeViewHolder.getMainImageView();
        a[36] = true;
        TextView titleView = inMobiNativeViewHolder.getTitleView();
        a[37] = true;
        String adTitle = inMobiNativeAd.getAdTitle();
        a[38] = true;
        NativeRendererHelper.addTextView(titleView, adTitle);
        a[39] = true;
        TextView textView = inMobiNativeViewHolder.getTextView();
        a[40] = true;
        String adDescription = inMobiNativeAd.getAdDescription();
        a[41] = true;
        NativeRendererHelper.addTextView(textView, adDescription);
        a[42] = true;
        TextView callToActionView = inMobiNativeViewHolder.getCallToActionView();
        a[43] = true;
        View mainView = inMobiNativeViewHolder.getMainView();
        String adCtaText = inMobiNativeAd.getAdCtaText();
        a[44] = true;
        NativeRendererHelper.addCtaButton(callToActionView, mainView, adCtaText);
        a[45] = true;
        String adIconUrl = inMobiNativeAd.getAdIconUrl();
        a[46] = true;
        ImageView iconImageView = inMobiNativeViewHolder.getIconImageView();
        a[47] = true;
        NativeImageHelper.loadImageView(adIconUrl, iconImageView);
        a[48] = true;
        this.f35722d.setOnClickListener(new C11628o(this, inMobiNativeAd));
        a[49] = true;
        ViewGroup primaryAdViewLayout = inMobiNativeViewHolder.getPrimaryAdViewLayout();
        if (primaryAdViewLayout == null) {
            a[50] = true;
        } else if (mainImageView == null) {
            a[51] = true;
        } else {
            a[52] = true;
            primaryAdViewLayout.removeAllViews();
            a[53] = true;
            ViewTreeObserver viewTreeObserver = primaryAdViewLayout.getViewTreeObserver();
            C11631p pVar = new C11631p(this, primaryAdViewLayout, inMobiNativeAd, inMobiNativeViewHolder);
            a[54] = true;
            viewTreeObserver.addOnGlobalLayoutListener(pVar);
            a[55] = true;
            primaryAdViewLayout.setVisibility(0);
            a[56] = true;
            mainImageView.setLayoutParams(primaryAdViewLayout.getLayoutParams());
            a[57] = true;
        }
        a[58] = true;
    }
}
