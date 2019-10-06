package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.common.privacy.PersonalInfoManager;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.services.banners.UnityBanners;
import java.util.Map;

public class UnityRouter {

    /* renamed from: a */
    private static final String f34967a = UnityRouter.class.getSimpleName();

    /* renamed from: b */
    private static final UnityInterstitialCallbackRouter f34968b = new UnityInterstitialCallbackRouter();

    /* renamed from: c */
    private static final UnityBannerCallbackRouter f34969c = new UnityBannerCallbackRouter();

    /* renamed from: com.mopub.mobileads.UnityRouter$a */
    static final class C11355a {
        /* renamed from: a */
        static MoPubErrorCode m37553a(UnityAdsError unityAdsError) {
            int i = C11464wa.f35448a[unityAdsError.ordinal()];
            if (i == 1) {
                return MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
            }
            if (i == 2) {
                return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            }
            if (i != 3) {
                return MoPubErrorCode.NETWORK_NO_FILL;
            }
            return MoPubErrorCode.NETWORK_INVALID_STATE;
        }
    }

    /* renamed from: a */
    static boolean m37551a(Map<String, String> serverExtras, Activity launcherActivity) {
        m37549a(launcherActivity);
        String gameId = (String) serverExtras.get("gameId");
        if (gameId == null || gameId.isEmpty()) {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f34967a, "gameId is missing or entered incorrectly in the MoPub UI");
            return false;
        }
        m37550a((Context) launcherActivity);
        UnityBanners.setBannerListener(f34969c);
        UnityAds.initialize(launcherActivity, gameId, f34968b);
        return true;
    }

    /* renamed from: a */
    static void m37549a(Activity activity) {
        PersonalInfoManager personalInfoManager = MoPub.getPersonalInformationManager();
        boolean canCollectPersonalInfo = MoPub.canCollectPersonalInformation();
        boolean shouldAllowLegitimateInterest = MoPub.shouldAllowLegitimateInterest();
        if (personalInfoManager != null && personalInfoManager.gdprApplies() == Boolean.TRUE) {
            MetaData gdprMetaData = new MetaData(activity.getApplicationContext());
            String str = "gdpr.consent";
            if (!shouldAllowLegitimateInterest) {
                gdprMetaData.set(str, Boolean.valueOf(canCollectPersonalInfo));
            } else if (personalInfoManager.getPersonalInfoConsentStatus() == ConsentStatus.EXPLICIT_NO || personalInfoManager.getPersonalInfoConsentStatus() == ConsentStatus.DNT) {
                gdprMetaData.set(str, Boolean.valueOf(false));
            } else {
                gdprMetaData.set(str, Boolean.valueOf(true));
            }
            gdprMetaData.commit();
        }
    }

    /* renamed from: a */
    static void m37550a(Context context) {
        MediationMetaData mediationMetaData = new MediationMetaData(context);
        mediationMetaData.setName(MoPubLog.LOGTAG);
        mediationMetaData.setVersion("5.5.0");
        mediationMetaData.commit();
    }

    /* renamed from: a */
    static String m37548a(Map<String, String> serverExtras, String defaultPlacementId) {
        String placementId = null;
        String str = "placementId";
        if (serverExtras.containsKey(str)) {
            placementId = (String) serverExtras.get(str);
        } else {
            String str2 = "zoneId";
            if (serverExtras.containsKey(str2)) {
                placementId = (String) serverExtras.get(str2);
            }
        }
        return TextUtils.isEmpty(placementId) ? defaultPlacementId : placementId;
    }

    /* renamed from: b */
    static UnityInterstitialCallbackRouter m37552b() {
        return f34968b;
    }

    /* renamed from: a */
    static UnityBannerCallbackRouter m37547a() {
        return f34969c;
    }
}
