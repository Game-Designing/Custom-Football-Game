package com.smaato.soma.p256e;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.facebook.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.millennialmedia.InlineAd;
import com.millennialmedia.MMException;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;

/* renamed from: com.smaato.soma.e.v */
/* compiled from: MediationFactory */
public class C12359v {

    /* renamed from: a */
    private static C12359v f38603a = null;

    /* renamed from: a */
    public static C12359v m40618a() {
        if (f38603a == null) {
            f38603a = new C12359v();
        }
        return f38603a;
    }

    /* renamed from: a */
    public MoPubInterstitial mo39779a(Activity activity, String adunitid) {
        return new MoPubInterstitial(activity, adunitid);
    }

    /* renamed from: c */
    public MoPubView mo39781c(Context context) {
        return new MoPubView(context);
    }

    /* renamed from: b */
    public InterstitialAd mo39780b(Context context) {
        return new InterstitialAd(context);
    }

    /* renamed from: a */
    public AdView mo39776a(Context context) {
        return new AdView(context);
    }

    /* renamed from: a */
    public com.facebook.ads.InterstitialAd mo39775a(Context context, String adunitid) {
        return new com.facebook.ads.InterstitialAd(context, adunitid);
    }

    /* renamed from: a */
    public com.facebook.ads.AdView mo39774a(Context context, String adunitid, AdSize adSize) {
        return new com.facebook.ads.AdView(context, adunitid, adSize);
    }

    /* renamed from: a */
    public InlineAd mo39777a(String adunitid, ViewGroup container) throws MMException {
        return InlineAd.createInstance(adunitid, container);
    }

    /* renamed from: a */
    public com.millennialmedia.InterstitialAd mo39778a(String adunitid) throws MMException {
        return com.millennialmedia.InterstitialAd.createInstance(adunitid);
    }
}
