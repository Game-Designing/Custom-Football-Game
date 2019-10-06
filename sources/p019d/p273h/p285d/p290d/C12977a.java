package p019d.p273h.p285d.p290d;

import com.ironsource.sdk.data.C10895h;

/* renamed from: d.h.d.d.a */
/* compiled from: Constants */
public class C12977a {

    /* renamed from: a */
    public String f39932a;

    /* renamed from: b */
    public String f39933b;

    /* renamed from: c */
    public String f39934c;

    /* renamed from: a */
    public static C12977a m42323a(C10895h type) {
        C12977a initMethod = new C12977a();
        if (type == C10895h.RewardedVideo) {
            initMethod.f39932a = "initRewardedVideo";
            initMethod.f39933b = "onInitRewardedVideoSuccess";
            initMethod.f39934c = "onInitRewardedVideoFail";
        } else if (type == C10895h.Interstitial) {
            initMethod.f39932a = "initInterstitial";
            initMethod.f39933b = "onInitInterstitialSuccess";
            initMethod.f39934c = "onInitInterstitialFail";
        } else if (type == C10895h.OfferWall) {
            initMethod.f39932a = "initOfferWall";
            initMethod.f39933b = "onInitOfferWallSuccess";
            initMethod.f39934c = "onInitOfferWallFail";
        } else if (type == C10895h.Banner) {
            initMethod.f39932a = "initBanner";
            initMethod.f39933b = "onInitBannerSuccess";
            initMethod.f39934c = "onInitBannerFail";
        }
        return initMethod;
    }

    /* renamed from: b */
    public static C12977a m42324b(C10895h type) {
        C12977a showMethod = new C12977a();
        if (type == C10895h.RewardedVideo) {
            showMethod.f39932a = "showRewardedVideo";
            showMethod.f39933b = "onShowRewardedVideoSuccess";
            showMethod.f39934c = "onShowRewardedVideoFail";
        } else if (type == C10895h.Interstitial) {
            showMethod.f39932a = "showInterstitial";
            showMethod.f39933b = "onShowInterstitialSuccess";
            showMethod.f39934c = "onShowInterstitialFail";
        } else if (type == C10895h.OfferWall) {
            showMethod.f39932a = "showOfferWall";
            showMethod.f39933b = "onShowOfferWallSuccess";
            showMethod.f39934c = "onInitOfferWallFail";
        }
        return showMethod;
    }
}
