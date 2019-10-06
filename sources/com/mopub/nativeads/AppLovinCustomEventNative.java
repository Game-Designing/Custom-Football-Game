package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.mopub.common.MoPub;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p149c.C7250d;
import p019d.p143b.p150d.C7266p;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7268r;

public class AppLovinCustomEventNative extends CustomEventNative implements C7248b {

    /* renamed from: a */
    private static final Handler f35602a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f35603b;

    /* renamed from: c */
    private C7267q f35604c;

    /* renamed from: d */
    private CustomEventNativeListener f35605d;

    /* renamed from: e */
    private Context f35606e;

    /* renamed from: com.mopub.nativeads.AppLovinCustomEventNative$a */
    private class C11513a extends StaticNativeAd {

        /* renamed from: s */
        private static transient /* synthetic */ boolean[] f35607s;

        /* renamed from: t */
        private final C7247a f35608t;

        /* renamed from: u */
        private final Context f35609u;

        /* renamed from: v */
        private View f35610v;

        /* renamed from: w */
        final /* synthetic */ AppLovinCustomEventNative f35611w;

        /* renamed from: e */
        private static /* synthetic */ boolean[] m38101e() {
            boolean[] zArr = f35607s;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2152852889846312758L, "com/mopub/nativeads/AppLovinCustomEventNative$AppLovinMopubNativeAd", 11);
            f35607s = probes;
            return probes;
        }

        C11513a(AppLovinCustomEventNative appLovinCustomEventNative, C7247a nativeAd, Context context) {
            boolean[] e = m38101e();
            this.f35611w = appLovinCustomEventNative;
            this.f35608t = nativeAd;
            this.f35609u = context;
            e[0] = true;
            setTitle(nativeAd.getTitle());
            e[1] = true;
            setText(nativeAd.mo23128n());
            e[2] = true;
            setIconImageUrl(nativeAd.getIconUrl());
            e[3] = true;
            setMainImageUrl(nativeAd.mo23125k());
            e[4] = true;
            setCallToAction(nativeAd.mo23129o());
            e[5] = true;
            setStarRating(Double.valueOf((double) nativeAd.mo23124j()));
            e[6] = true;
            setClickDestinationUrl(nativeAd.mo23126l());
            e[7] = true;
        }

        public void prepare(View view) {
            boolean[] e = m38101e();
            this.f35608t.mo23112a(new C11590c(this));
            e[8] = true;
        }

        public void clear(View view) {
            boolean[] e = m38101e();
            this.f35610v = null;
            e[9] = true;
        }

        public void destroy() {
            boolean[] e = m38101e();
            AppLovinCustomEventNative.m38092a(this.f35611w, (CustomEventNativeListener) null);
            e[10] = true;
        }
    }

    /* renamed from: b */
    private static /* synthetic */ boolean[] m38100b() {
        boolean[] zArr = f35603b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6887488243963277480L, "com/mopub/nativeads/AppLovinCustomEventNative", 49);
        f35603b = probes;
        return probes;
    }

    public AppLovinCustomEventNative() {
        m38100b()[0] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Context m38091a(AppLovinCustomEventNative x0) {
        boolean[] b = m38100b();
        Context context = x0.f35606e;
        b[44] = true;
        return context;
    }

    /* renamed from: a */
    static /* synthetic */ CustomEventNativeListener m38092a(AppLovinCustomEventNative x0, CustomEventNativeListener x1) {
        boolean[] b = m38100b();
        x0.f35605d = x1;
        b[47] = true;
        return x1;
    }

    /* renamed from: a */
    static /* synthetic */ void m38095a(int x0, String x1) {
        boolean[] b = m38100b();
        m38099b(x0, x1);
        b[46] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m38096a(AppLovinCustomEventNative x0, C7247a x1) {
        boolean[] b = m38100b();
        x0.m38097a(x1);
        b[45] = true;
    }

    static {
        boolean[] b = m38100b();
        b[48] = true;
    }

    /* renamed from: b */
    private static void m38099b(int priority, String message) {
        boolean[] b = m38100b();
        Log.println(priority, "AppLovinNative", message);
        b[1] = true;
    }

    /* renamed from: a */
    private static NativeErrorCode m38093a(int applovinErrorCode) {
        boolean[] b = m38100b();
        if (applovinErrorCode == 204) {
            NativeErrorCode nativeErrorCode = NativeErrorCode.NETWORK_NO_FILL;
            b[2] = true;
            return nativeErrorCode;
        } else if (applovinErrorCode == -1) {
            NativeErrorCode nativeErrorCode2 = NativeErrorCode.NETWORK_INVALID_STATE;
            b[3] = true;
            return nativeErrorCode2;
        } else if (applovinErrorCode == -103) {
            NativeErrorCode nativeErrorCode3 = NativeErrorCode.CONNECTION_ERROR;
            b[4] = true;
            return nativeErrorCode3;
        } else if (applovinErrorCode == -102) {
            NativeErrorCode nativeErrorCode4 = NativeErrorCode.NETWORK_TIMEOUT;
            b[5] = true;
            return nativeErrorCode4;
        } else if (applovinErrorCode == -700) {
            NativeErrorCode nativeErrorCode5 = NativeErrorCode.INVALID_RESPONSE;
            b[6] = true;
            return nativeErrorCode5;
        } else {
            NativeErrorCode nativeErrorCode6 = NativeErrorCode.UNSPECIFIED;
            b[7] = true;
            return nativeErrorCode6;
        }
    }

    /* renamed from: a */
    private static void m38098a(Runnable runnable) {
        boolean[] b = m38100b();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b[8] = true;
            runnable.run();
            b[9] = true;
        } else {
            f35602a.post(runnable);
            b[10] = true;
        }
        b[11] = true;
    }

    /* renamed from: a */
    private static C7267q m38094a(Map<String, String> serverExtras, Context context) {
        String sdkKey;
        C7267q sdk;
        boolean[] b = m38100b();
        if (serverExtras != null) {
            sdkKey = (String) serverExtras.get("sdk_key");
            b[12] = true;
        } else {
            sdkKey = null;
            b[13] = true;
        }
        b[14] = true;
        if (!TextUtils.isEmpty(sdkKey)) {
            b[15] = true;
            sdk = C7267q.m15795a(sdkKey, new C7268r(), context);
            b[16] = true;
        } else {
            sdk = C7267q.m15794a(context);
            b[17] = true;
        }
        b[18] = true;
        return sdk;
    }

    public void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map<String, Object> map, Map<String, String> serverExtras) {
        boolean[] b = m38100b();
        StringBuilder sb = new StringBuilder();
        sb.append("Requesting AppLovin native ad with server extras: ");
        sb.append(serverExtras);
        m38099b(3, sb.toString());
        b[19] = true;
        PersonalInfoManager personalInfoManager = MoPub.getPersonalInformationManager();
        b[20] = true;
        if (personalInfoManager == null) {
            b[21] = true;
        } else if (!personalInfoManager.gdprApplies().booleanValue()) {
            b[22] = true;
        } else {
            b[23] = true;
            boolean canCollectPersonalInfo = personalInfoManager.canCollectPersonalInformation();
            b[24] = true;
            C7266p.m15793a(canCollectPersonalInfo, context);
            b[25] = true;
        }
        this.f35606e = context;
        this.f35605d = customEventNativeListener;
        b[26] = true;
        this.f35604c = m38094a(serverExtras, context);
        b[27] = true;
        this.f35604c.mo23054b("MoPub-3.0.0");
        b[28] = true;
        C7250d c = this.f35604c.mo23057c();
        b[29] = true;
        c.mo22979a(1, this);
        b[30] = true;
    }

    public void onNativeAdsLoaded(List nativeAds) {
        boolean[] b = m38100b();
        C7247a nativeAd = (C7247a) nativeAds.get(0);
        b[31] = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Native ad did load ad: ");
        sb.append(nativeAd.mo23127m());
        m38099b(3, sb.toString());
        b[32] = true;
        List<String> imageUrls = new ArrayList<>(2);
        b[33] = true;
        if (nativeAd.getIconUrl() == null) {
            b[34] = true;
        } else {
            imageUrls.add(nativeAd.getIconUrl());
            b[35] = true;
        }
        if (nativeAd.mo23125k() == null) {
            b[36] = true;
        } else {
            imageUrls.add(nativeAd.mo23125k());
            b[37] = true;
        }
        m38098a((Runnable) new C11587b(this, imageUrls, nativeAd));
        b[38] = true;
    }

    public void onNativeAdsFailedToLoad(int errorCode) {
        boolean[] b = m38100b();
        StringBuilder sb = new StringBuilder();
        sb.append("Native ad video failed to load with error: ");
        sb.append(errorCode);
        m38099b(6, sb.toString());
        b[39] = true;
        this.f35605d.onNativeAdFailed(m38093a(errorCode));
        b[40] = true;
    }

    /* renamed from: a */
    private void m38097a(C7247a nativeAd) {
        boolean[] b = m38100b();
        m38099b(3, "Native ad done precaching");
        b[41] = true;
        C11513a appLovinMopubNativeAd = new C11513a(this, nativeAd, this.f35606e);
        b[42] = true;
        this.f35605d.onNativeAdLoaded(appLovinMopubNativeAd);
        b[43] = true;
    }
}
