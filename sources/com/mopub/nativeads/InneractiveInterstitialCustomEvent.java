package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig.Gender;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;

public class InneractiveInterstitialCustomEvent extends CustomEventInterstitial {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f35749b;

    /* renamed from: c */
    InneractiveAdSpot f35750c;

    /* renamed from: d */
    Context f35751d;

    /* renamed from: e */
    private CustomEventInterstitialListener f35752e;

    /* renamed from: f */
    private static /* synthetic */ boolean[] m38189f() {
        boolean[] zArr = f35749b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1185397869242422323L, "com/mopub/nativeads/InneractiveInterstitialCustomEvent", 71);
        f35749b = probes;
        return probes;
    }

    public InneractiveInterstitialCustomEvent() {
        m38189f()[0] = true;
    }

    /* renamed from: a */
    static /* synthetic */ CustomEventInterstitialListener m38188a(InneractiveInterstitialCustomEvent x0) {
        boolean[] f = m38189f();
        CustomEventInterstitialListener customEventInterstitialListener = x0.f35752e;
        f[70] = true;
        return customEventInterstitialListener;
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener listener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        boolean[] f = m38189f();
        String str = InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG;
        Log.d(str, "IAInterstitialForMopub - loadInterstitial");
        f[1] = true;
        mo36971a(false);
        String resultSpotId = null;
        String resultKeywords = null;
        String str2 = "keywords";
        if (serverExtras == null) {
            f[2] = true;
        } else {
            f[3] = true;
            resultSpotId = (String) serverExtras.get(InneractiveMediationDefs.REMOTE_KEY_SPOT_ID);
            f[4] = true;
            if (TextUtils.isEmpty((CharSequence) serverExtras.get(str2))) {
                f[5] = true;
            } else {
                f[6] = true;
                resultKeywords = (String) serverExtras.get(str2);
                f[7] = true;
            }
        }
        if (!TextUtils.isEmpty(resultSpotId)) {
            f[8] = true;
        } else {
            resultSpotId = BuildConfig.MOPUB_FYBER_INTERSTITIAL_SPOT_ID;
            f[9] = true;
            if (!TextUtils.isEmpty(resultSpotId)) {
                f[10] = true;
            } else {
                f[11] = true;
                listener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                f[12] = true;
                return;
            }
        }
        if (!(context instanceof Activity)) {
            f[13] = true;
            listener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            f[14] = true;
            return;
        }
        this.f35752e = listener;
        this.f35751d = context;
        Gender gender = null;
        int age = 0;
        String zipCode = null;
        if (localExtras == null) {
            f[15] = true;
        } else {
            f[16] = true;
            if (!localExtras.containsKey(str2)) {
                f[17] = true;
            } else if (!TextUtils.isEmpty(resultKeywords)) {
                f[18] = true;
            } else {
                f[19] = true;
                resultKeywords = (String) localExtras.get(str2);
                f[20] = true;
            }
            String str3 = InneractiveMediationDefs.KEY_AGE;
            if (!localExtras.containsKey(str3)) {
                f[21] = true;
            } else {
                try {
                    f[22] = true;
                    Object obj = localExtras.get(str3);
                    f[23] = true;
                    String obj2 = obj.toString();
                    f[24] = true;
                    int age2 = Integer.valueOf(obj2).intValue();
                    f[25] = true;
                    age = age2;
                } catch (NumberFormatException e) {
                    f[26] = true;
                    Log.d(str, "IAInterstitialForMopub Invalid Age");
                    f[27] = true;
                }
            }
            String str4 = InneractiveMediationDefs.KEY_GENDER;
            if (!localExtras.containsKey(str4)) {
                f[28] = true;
            } else {
                f[29] = true;
                Object obj3 = localExtras.get(str4);
                f[30] = true;
                String genderStr = obj3.toString();
                f[31] = true;
                if (genderStr.equals(InneractiveMediationDefs.GENDER_MALE)) {
                    Gender gender2 = Gender.MALE;
                    f[32] = true;
                    gender = gender2;
                } else if (!genderStr.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                    f[33] = true;
                } else {
                    Gender gender3 = Gender.FEMALE;
                    f[34] = true;
                    gender = gender3;
                }
            }
            String genderStr2 = InneractiveMediationDefs.KEY_ZIPCODE;
            if (!localExtras.containsKey(genderStr2)) {
                f[35] = true;
            } else {
                f[36] = true;
                zipCode = (String) localExtras.get(genderStr2);
                f[37] = true;
            }
        }
        InneractiveAdSpot inneractiveAdSpot = this.f35750c;
        if (inneractiveAdSpot == null) {
            f[38] = true;
        } else {
            f[39] = true;
            inneractiveAdSpot.destroy();
            f[40] = true;
        }
        InneractiveAdSpotManager inneractiveAdSpotManager = InneractiveAdSpotManager.get();
        f[41] = true;
        this.f35750c = inneractiveAdSpotManager.createSpot();
        f[42] = true;
        this.f35750c.setMediationName(InneractiveMediationName.MOPUB);
        f[43] = true;
        InneractiveFullscreenUnitController fullscreenUnitController = new InneractiveFullscreenUnitController();
        f[44] = true;
        this.f35750c.addUnitController(fullscreenUnitController);
        f[45] = true;
        InneractiveAdRequest request = new InneractiveAdRequest(resultSpotId);
        f[46] = true;
        InneractiveUserConfig gender4 = new InneractiveUserConfig().setGender(gender);
        f[47] = true;
        InneractiveUserConfig zipCode2 = gender4.setZipCode(zipCode);
        f[48] = true;
        InneractiveUserConfig age3 = zipCode2.setAge(age);
        f[49] = true;
        request.setUserParams(age3);
        f[50] = true;
        if (resultKeywords == null) {
            f[51] = true;
        } else if (resultKeywords.length() <= 0) {
            f[52] = true;
        } else {
            f[53] = true;
            request.setKeywords(resultKeywords.toString());
            f[54] = true;
        }
        this.f35750c.setRequestListener(new C11658y(this));
        f[55] = true;
        this.f35750c.requestAd(request);
        f[56] = true;
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        boolean[] f = m38189f();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IAInterstitialForMopub - showInterstitial");
        f[57] = true;
        InneractiveAdSpot inneractiveAdSpot = this.f35750c;
        if (inneractiveAdSpot == null) {
            f[58] = true;
        } else if (!inneractiveAdSpot.isReady()) {
            f[59] = true;
        } else {
            InneractiveAdSpot inneractiveAdSpot2 = this.f35750c;
            f[60] = true;
            InneractiveFullscreenUnitController fullscreenUnitController = (InneractiveFullscreenUnitController) inneractiveAdSpot2.getSelectedUnitController();
            f[61] = true;
            fullscreenUnitController.setEventsListener(new C11661z(this));
            f[62] = true;
            InneractiveFullscreenVideoContentController videoContentController = new InneractiveFullscreenVideoContentController();
            f[63] = true;
            videoContentController.setEventsListener(new C11510A(this));
            f[64] = true;
            fullscreenUnitController.addContentController(videoContentController);
            f[65] = true;
            fullscreenUnitController.show((Activity) this.f35751d);
            f[66] = true;
            f[68] = true;
        }
        Log.d(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, "The Interstitial ad is not ready yet.");
        f[67] = true;
        f[68] = true;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        boolean[] f = m38189f();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IAInterstitialForMopub - onInvalidate");
        f[69] = true;
    }
}
