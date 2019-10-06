package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.WeakHashMap;

/* renamed from: com.mopub.nativeads.ma */
/* compiled from: NativeAdViewHelper */
class C11622ma {

    /* renamed from: a */
    private static final WeakHashMap<View, NativeAd> f36191a = new WeakHashMap<>();

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.ma$a */
    /* compiled from: NativeAdViewHelper */
    enum C11623a {
        EMPTY,
        AD
    }

    /* renamed from: a */
    static View m38451a(View convertView, ViewGroup parent, Context context, NativeAd nativeAd) {
        if (convertView != null) {
            m38452a(convertView);
        }
        if (nativeAd == null || nativeAd.isDestroyed()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "NativeAd null or invalid. Returning empty view");
            if (convertView != null && C11623a.EMPTY.equals(convertView.getTag())) {
                return convertView;
            }
            View convertView2 = new View(context);
            convertView2.setTag(C11623a.EMPTY);
            convertView2.setVisibility(8);
            return convertView2;
        }
        if (convertView == null || !C11623a.AD.equals(convertView.getTag())) {
            convertView = nativeAd.createAdView(context, parent);
            convertView.setTag(C11623a.AD);
        }
        m38453a(convertView, nativeAd);
        nativeAd.renderAdView(convertView);
        return convertView;
    }

    /* renamed from: a */
    private static void m38452a(View view) {
        NativeAd nativeAd = (NativeAd) f36191a.get(view);
        if (nativeAd != null) {
            nativeAd.clear(view);
        }
    }

    /* renamed from: a */
    private static void m38453a(View view, NativeAd nativeAd) {
        f36191a.put(view, nativeAd);
        nativeAd.prepare(view);
    }
}
