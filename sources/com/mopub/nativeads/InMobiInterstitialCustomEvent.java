package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.LogLevel;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.json.JSONException;
import org.json.JSONObject;

public class InMobiInterstitialCustomEvent extends CustomEventInterstitial {

    /* renamed from: b */
    private static final String f35711b = InMobiInterstitialCustomEvent.class.getSimpleName();

    /* renamed from: c */
    private static boolean f35712c = false;

    /* renamed from: d */
    private static transient /* synthetic */ boolean[] f35713d;

    /* renamed from: e */
    private CustomEventInterstitialListener f35714e;

    /* renamed from: f */
    private JSONObject f35715f;

    /* renamed from: g */
    private String f35716g = "";

    /* renamed from: h */
    private long f35717h = -1;

    /* renamed from: i */
    private InMobiInterstitial f35718i;

    /* renamed from: g */
    private static /* synthetic */ boolean[] m38165g() {
        boolean[] zArr = f35713d;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9199017544387864160L, "com/mopub/nativeads/InMobiInterstitialCustomEvent", 44);
        f35713d = probes;
        return probes;
    }

    public InMobiInterstitialCustomEvent() {
        boolean[] g = m38165g();
        g[0] = true;
    }

    /* renamed from: a */
    static /* synthetic */ CustomEventInterstitialListener m38163a(InMobiInterstitialCustomEvent x0) {
        boolean[] g = m38165g();
        CustomEventInterstitialListener customEventInterstitialListener = x0.f35714e;
        g[42] = true;
        return customEventInterstitialListener;
    }

    /* renamed from: f */
    static /* synthetic */ String m38164f() {
        boolean[] g = m38165g();
        String str = f35711b;
        g[41] = true;
        return str;
    }

    static {
        boolean[] g = m38165g();
        g[43] = true;
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener interstitialListener, Map<String, Object> map, Map<String, String> serverExtras) {
        boolean[] g = m38165g();
        this.f35714e = interstitialListener;
        g[1] = true;
        InMobiSdk.setLogLevel(LogLevel.DEBUG);
        if (context == null) {
            g[2] = true;
        } else if (!(context instanceof Activity)) {
            g[3] = true;
        } else {
            Activity activity = (Activity) context;
            g[4] = true;
            try {
                this.f35715f = new JSONObject(serverExtras);
                g[7] = true;
            } catch (Exception e) {
                g[8] = true;
                Log.e(f35711b, "Could not parse server parameters");
                g[9] = true;
                e.printStackTrace();
                try {
                    g[10] = true;
                } catch (JSONException e1) {
                    g[13] = true;
                    e1.printStackTrace();
                    g[14] = true;
                }
            }
            this.f35716g = this.f35715f.getString("accountid");
            g[11] = true;
            this.f35717h = this.f35715f.getLong("placementid");
            g[12] = true;
            JSONObject gdprJson = new JSONObject();
            g[15] = true;
            if (!InMobiGDPR.isConsentUpdated()) {
                g[16] = true;
            } else {
                try {
                    g[17] = true;
                    gdprJson.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, InMobiGDPR.m38160a());
                    g[18] = true;
                    gdprJson.put("gdpr", InMobiGDPR.m38161b());
                    g[19] = true;
                } catch (JSONException e2) {
                    g[20] = true;
                    Log.d(f35711b, "Unable to set GDPR consent object");
                    g[21] = true;
                    Log.e(f35711b, e2.getMessage());
                    g[22] = true;
                }
            }
            if (f35712c) {
                g[23] = true;
            } else {
                try {
                    g[24] = true;
                    InMobiSdk.init(context, this.f35716g, gdprJson);
                    f35712c = true;
                    g[25] = true;
                } catch (Exception e3) {
                    g[26] = true;
                    e3.printStackTrace();
                    f35712c = false;
                    g[27] = true;
                    this.f35714e.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                    g[28] = true;
                    return;
                }
            }
            this.f35718i = new InMobiInterstitial((Context) activity, this.f35717h, (InterstitialAdEventListener) new C11625n(this));
            g[29] = true;
            Map<String, String> map2 = new HashMap<>();
            g[30] = true;
            map2.put("tp", "c_mopub");
            g[31] = true;
            map2.put("tp-ver", "5.7.1");
            g[32] = true;
            this.f35718i.setExtras(map2);
            g[33] = true;
            this.f35718i.load();
            g[34] = true;
            return;
        }
        Log.w(f35711b, "Context not an Activity. Returning error!");
        g[5] = true;
        this.f35714e.onInterstitialFailed(MoPubErrorCode.NO_FILL);
        g[6] = true;
    }

    public void showInterstitial() {
        boolean[] g = m38165g();
        InMobiInterstitial inMobiInterstitial = this.f35718i;
        if (inMobiInterstitial == null) {
            g[35] = true;
        } else if (!inMobiInterstitial.isReady()) {
            g[36] = true;
        } else {
            g[37] = true;
            this.f35718i.show();
            g[38] = true;
        }
        g[39] = true;
    }

    public void onInvalidate() {
        m38165g()[40] = true;
    }
}
