package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig.Gender;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;

public class InneractiveBannerCustomEvent extends CustomEventBanner {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f35746b;

    /* renamed from: c */
    CustomEventBannerListener f35747c;

    /* renamed from: d */
    InneractiveAdSpot f35748d;

    /* renamed from: c */
    private static /* synthetic */ boolean[] m38187c() {
        boolean[] zArr = f35746b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3988063825598041656L, "com/mopub/nativeads/InneractiveBannerCustomEvent", 57);
        f35746b = probes;
        return probes;
    }

    public InneractiveBannerCustomEvent() {
        m38187c()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        boolean[] c = m38187c();
        String str = InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG;
        Log.d(str, "IABannerForMopub - loadBanner");
        c[1] = true;
        mo36956a(false);
        this.f35747c = customEventBannerListener;
        String resultSpotId = null;
        String resultKeywords = null;
        String str2 = "keywords";
        if (serverExtras == null) {
            c[2] = true;
        } else {
            c[3] = true;
            resultSpotId = (String) serverExtras.get(InneractiveMediationDefs.REMOTE_KEY_SPOT_ID);
            c[4] = true;
            resultKeywords = (String) serverExtras.get(str2);
            c[5] = true;
        }
        if (!TextUtils.isEmpty(resultSpotId)) {
            c[6] = true;
        } else {
            resultSpotId = BuildConfig.MOPUB_FYBER_BANNER_SPOT_ID;
            c[7] = true;
            if (!TextUtils.isEmpty(resultSpotId)) {
                c[8] = true;
            } else {
                c[9] = true;
                customEventBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                c[10] = true;
                return;
            }
        }
        Gender gender = null;
        int age = 0;
        String zipCode = null;
        if (localExtras == null) {
            c[11] = true;
        } else {
            c[12] = true;
            if (!localExtras.containsKey(str2)) {
                c[13] = true;
            } else if (!TextUtils.isEmpty(resultKeywords)) {
                c[14] = true;
            } else {
                c[15] = true;
                resultKeywords = (String) localExtras.get(str2);
                c[16] = true;
            }
            String str3 = InneractiveMediationDefs.KEY_AGE;
            if (!localExtras.containsKey(str3)) {
                c[17] = true;
            } else {
                try {
                    c[18] = true;
                    Object obj = localExtras.get(str3);
                    c[19] = true;
                    String obj2 = obj.toString();
                    c[20] = true;
                    int age2 = Integer.valueOf(obj2).intValue();
                    c[21] = true;
                    age = age2;
                } catch (NumberFormatException e) {
                    c[22] = true;
                    Log.d(str, "IABannerForMopub Invalid Age");
                    c[23] = true;
                }
            }
            String str4 = InneractiveMediationDefs.KEY_GENDER;
            if (!localExtras.containsKey(str4)) {
                c[24] = true;
            } else {
                c[25] = true;
                Object obj3 = localExtras.get(str4);
                c[26] = true;
                String genderStr = obj3.toString();
                c[27] = true;
                if (InneractiveMediationDefs.GENDER_MALE.equals(genderStr)) {
                    Gender gender2 = Gender.MALE;
                    c[28] = true;
                    gender = gender2;
                } else if (!InneractiveMediationDefs.GENDER_FEMALE.equals(genderStr)) {
                    c[29] = true;
                } else {
                    Gender gender3 = Gender.FEMALE;
                    c[30] = true;
                    gender = gender3;
                }
            }
            String genderStr2 = InneractiveMediationDefs.KEY_ZIPCODE;
            if (!localExtras.containsKey(genderStr2)) {
                c[31] = true;
            } else {
                c[32] = true;
                zipCode = (String) localExtras.get(genderStr2);
                c[33] = true;
            }
        }
        InneractiveAdSpot inneractiveAdSpot = this.f35748d;
        if (inneractiveAdSpot == null) {
            c[34] = true;
        } else {
            c[35] = true;
            inneractiveAdSpot.destroy();
            c[36] = true;
        }
        InneractiveAdSpotManager inneractiveAdSpotManager = InneractiveAdSpotManager.get();
        c[37] = true;
        this.f35748d = inneractiveAdSpotManager.createSpot();
        c[38] = true;
        this.f35748d.setMediationName(InneractiveMediationName.MOPUB);
        c[39] = true;
        InneractiveAdViewUnitController controller = new InneractiveAdViewUnitController();
        c[40] = true;
        this.f35748d.addUnitController(controller);
        c[41] = true;
        InneractiveAdRequest request = new InneractiveAdRequest(resultSpotId);
        c[42] = true;
        InneractiveUserConfig gender4 = new InneractiveUserConfig().setGender(gender);
        c[43] = true;
        InneractiveUserConfig zipCode2 = gender4.setZipCode(zipCode);
        c[44] = true;
        InneractiveUserConfig age3 = zipCode2.setAge(age);
        c[45] = true;
        request.setUserParams(age3);
        c[46] = true;
        if (resultKeywords == null) {
            c[47] = true;
        } else if (resultKeywords.length() <= 0) {
            c[48] = true;
        } else {
            c[49] = true;
            request.setKeywords(resultKeywords.toString());
            c[50] = true;
        }
        this.f35748d.setRequestListener(new C11655x(this, context));
        c[51] = true;
        this.f35748d.requestAd(request);
        c[52] = true;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        boolean[] c = m38187c();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - onInvalidate");
        InneractiveAdSpot inneractiveAdSpot = this.f35748d;
        if (inneractiveAdSpot == null) {
            c[53] = true;
        } else {
            c[54] = true;
            inneractiveAdSpot.destroy();
            this.f35748d = null;
            c[55] = true;
        }
        c[56] = true;
    }
}
