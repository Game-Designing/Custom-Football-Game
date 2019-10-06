package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiNative.NativeAdListener;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.LogLevel;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.json.JSONException;
import org.json.JSONObject;

public class InMobiNativeCustomEvent extends CustomEventNative {
    public static final String TAG = InMobiNativeCustomEvent.class.getSimpleName();

    /* renamed from: a */
    private static boolean f35727a = false;

    /* renamed from: b */
    private static ConcurrentHashMap<Integer, InMobiNativeAd> f35728b = new ConcurrentHashMap<>(10, 0.9f, 10);

    /* renamed from: c */
    private static transient /* synthetic */ boolean[] f35729c;

    /* renamed from: d */
    private InMobiNativeAd f35730d;

    public static class InMobiNativeAd extends BaseNativeAd implements NativeAdListener {

        /* renamed from: e */
        private static transient /* synthetic */ boolean[] f35731e;

        /* renamed from: f */
        private final CustomEventNativeListener f35732f;

        /* renamed from: g */
        private final NativeClickHandler f35733g;

        /* renamed from: h */
        private final InMobiNative f35734h;

        /* renamed from: i */
        private final Context f35735i;

        /* renamed from: j */
        private boolean f35736j = false;

        /* renamed from: k */
        private boolean f35737k = false;

        /* renamed from: l */
        private NativeAdEventListener f35738l;

        /* renamed from: f */
        private static /* synthetic */ boolean[] m38179f() {
            boolean[] zArr = f35731e;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6372615691111110386L, "com/mopub/nativeads/InMobiNativeCustomEvent$InMobiNativeAd", 75);
            f35731e = probes;
            return probes;
        }

        /* renamed from: a */
        static /* synthetic */ Context m38173a(InMobiNativeAd x0) {
            boolean[] f = m38179f();
            Context context = x0.f35735i;
            f[69] = true;
            return context;
        }

        /* renamed from: a */
        static /* synthetic */ boolean m38174a(InMobiNativeAd x0, boolean x1) {
            boolean[] f = m38179f();
            x0.f35736j = x1;
            f[72] = true;
            return x1;
        }

        /* renamed from: b */
        static /* synthetic */ CustomEventNativeListener m38175b(InMobiNativeAd x0) {
            boolean[] f = m38179f();
            CustomEventNativeListener customEventNativeListener = x0.f35732f;
            f[70] = true;
            return customEventNativeListener;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m38176b(InMobiNativeAd x0, boolean x1) {
            boolean[] f = m38179f();
            x0.f35737k = x1;
            f[74] = true;
            return x1;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m38177c(InMobiNativeAd x0) {
            boolean[] f = m38179f();
            boolean z = x0.f35736j;
            f[71] = true;
            return z;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m38178d(InMobiNativeAd x0) {
            boolean[] f = m38179f();
            boolean z = x0.f35737k;
            f[73] = true;
            return z;
        }

        InMobiNativeAd(Context context, CustomEventNativeListener customEventNativeListener, long placementId) {
            boolean[] f = m38179f();
            f[0] = true;
            this.f35738l = new C11640s(this);
            this.f35735i = context;
            f[1] = true;
            this.f35733g = new NativeClickHandler(context);
            this.f35732f = customEventNativeListener;
            if (context instanceof Activity) {
                f[2] = true;
                this.f35734h = new InMobiNative((Context) (Activity) context, placementId, this.f35738l);
                f[3] = true;
            } else {
                this.f35734h = new InMobiNative(context, placementId, this.f35738l);
                f[4] = true;
            }
            f[5] = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo37834a(Map<String, String> map) {
            boolean[] f = m38179f();
            this.f35734h.setExtras(map);
            f[6] = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo37835e() {
            boolean[] f = m38179f();
            this.f35734h.setVideoEventListener(new C11643t(this));
            f[7] = true;
            this.f35734h.load();
            f[8] = true;
        }

        public final String getAdTitle() {
            boolean[] f = m38179f();
            String adTitle = this.f35734h.getAdTitle();
            f[9] = true;
            return adTitle;
        }

        public final String getAdDescription() {
            boolean[] f = m38179f();
            String adDescription = this.f35734h.getAdDescription();
            f[10] = true;
            return adDescription;
        }

        public final String getAdIconUrl() {
            boolean[] f = m38179f();
            String adIconUrl = this.f35734h.getAdIconUrl();
            f[11] = true;
            return adIconUrl;
        }

        public final String getAdCtaText() {
            boolean[] f = m38179f();
            String adCtaText = this.f35734h.getAdCtaText();
            f[12] = true;
            return adCtaText;
        }

        public final Float getAdRating() {
            boolean[] f = m38179f();
            Float valueOf = Float.valueOf(this.f35734h.getAdRating());
            f[13] = true;
            return valueOf;
        }

        public final View getPrimaryAdView(ViewGroup parent) {
            boolean[] f = m38179f();
            float width = (float) parent.getWidth();
            Context context = this.f35735i;
            f[14] = true;
            Resources resources = context.getResources();
            f[15] = true;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            f[16] = true;
            int width2 = (int) TypedValue.applyDimension(0, width, displayMetrics);
            f[17] = true;
            View primaryViewOfWidth = this.f35734h.getPrimaryViewOfWidth(parent.getContext(), null, parent, width2);
            f[18] = true;
            return primaryViewOfWidth;
        }

        public final void onCtaClick() {
            boolean[] f = m38179f();
            this.f35734h.reportAdClickAndOpenLandingPage();
            f[19] = true;
        }

        public void prepare(View view) {
            m38179f()[20] = true;
        }

        public void clear(View view) {
            boolean[] f = m38179f();
            this.f35733g.clearOnClickListener(view);
            f[21] = true;
        }

        public void destroy() {
            boolean[] f = m38179f();
            this.f35734h.destroy();
            f[22] = true;
        }

        public void onAdLoadSucceeded(InMobiNative inMobiNative) {
            boolean[] f = m38179f();
            Log.i("InMobiNativeAd", "InMobi Native Ad loaded successfully");
            f[23] = true;
            List<String> imageUrls = new ArrayList<>();
            f[24] = true;
            String iconImageUrl = getAdIconUrl();
            if (iconImageUrl == null) {
                f[25] = true;
            } else {
                f[26] = true;
                imageUrls.add(iconImageUrl);
                f[27] = true;
            }
            NativeImageHelper.preCacheImages(this.f35735i, imageUrls, new C11646u(this));
            f[28] = true;
            InMobiNativeCustomEvent.m38171b().remove(Integer.valueOf(hashCode()));
            f[29] = true;
        }

        public void onAdLoadFailed(InMobiNative InMobiNative, InMobiAdRequestStatus requestStatus) {
            String errorMessage;
            boolean[] f = m38179f();
            String errorMessage2 = "Failed to load Native Strand:";
            f[30] = true;
            switch (C11634q.f36218a[requestStatus.getStatusCode().ordinal()]) {
                case 1:
                    StringBuilder sb = new StringBuilder();
                    sb.append(errorMessage2);
                    sb.append("INTERNAL_ERROR");
                    errorMessage = sb.toString();
                    f[31] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
                    f[32] = true;
                    break;
                case 2:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(errorMessage2);
                    sb2.append("INVALID_REQUEST");
                    errorMessage = sb2.toString();
                    f[33] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_REQUEST);
                    f[34] = true;
                    break;
                case 3:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(errorMessage2);
                    sb3.append("NETWORK_UNREACHABLE");
                    errorMessage = sb3.toString();
                    f[35] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.CONNECTION_ERROR);
                    f[36] = true;
                    break;
                case 4:
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(errorMessage2);
                    sb4.append("NO_FILL");
                    errorMessage = sb4.toString();
                    f[37] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
                    f[38] = true;
                    break;
                case 5:
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(errorMessage2);
                    sb5.append("REQUEST_PENDING");
                    errorMessage = sb5.toString();
                    f[39] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                    f[40] = true;
                    break;
                case 6:
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(errorMessage2);
                    sb6.append("REQUEST_TIMED_OUT");
                    errorMessage = sb6.toString();
                    f[41] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.NETWORK_TIMEOUT);
                    f[42] = true;
                    break;
                case 7:
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(errorMessage2);
                    sb7.append("SERVER_ERROR");
                    errorMessage = sb7.toString();
                    f[43] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
                    f[44] = true;
                    break;
                case 8:
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(errorMessage2);
                    sb8.append("AD_ACTIVE");
                    errorMessage = sb8.toString();
                    f[45] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                    f[46] = true;
                    break;
                case 9:
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(errorMessage2);
                    sb9.append("EARLY_REFRESH_REQUEST");
                    errorMessage = sb9.toString();
                    f[47] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                    f[48] = true;
                    break;
                default:
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("UNKNOWN_ERROR");
                    sb10.append(requestStatus.getStatusCode());
                    errorMessage = sb10.toString();
                    f[49] = true;
                    this.f35732f.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                    f[50] = true;
                    break;
            }
            Log.w("InMobiNativeAd", errorMessage);
            f[51] = true;
            InMobiNativeCustomEvent.m38171b().remove(Integer.valueOf(hashCode()));
            f[52] = true;
            destroy();
            f[53] = true;
        }

        public void onAdFullScreenDismissed(InMobiNative inMobiNative) {
            m38179f()[54] = true;
        }

        public void onAdFullScreenWillDisplay(InMobiNative inMobiNative) {
            m38179f()[55] = true;
        }

        public void onAdFullScreenDisplayed(InMobiNative inMobiNative) {
            m38179f()[56] = true;
        }

        public void onUserWillLeaveApplication(InMobiNative inMobiNative) {
            m38179f()[57] = true;
        }

        public void onAdImpressed(InMobiNative InMobiNative) {
            boolean[] f = m38179f();
            if (this.f35736j) {
                f[58] = true;
            } else {
                this.f35736j = true;
                f[59] = true;
                mo37750d();
                f[60] = true;
            }
            f[61] = true;
        }

        public void onAdClicked(InMobiNative InMobiNative) {
            boolean[] f = m38179f();
            if (this.f35737k) {
                f[62] = true;
            } else {
                f[63] = true;
                mo37749c();
                this.f35737k = true;
                f[64] = true;
            }
            f[65] = true;
        }

        public void onMediaPlaybackComplete(InMobiNative inMobiNative) {
            m38179f()[66] = true;
        }

        public void onAdStatusChanged(InMobiNative inMobiNative) {
            m38179f()[67] = true;
        }

        public void onUserSkippedMedia(InMobiNative inMobiNative) {
            m38179f()[68] = true;
        }
    }

    /* renamed from: c */
    private static /* synthetic */ boolean[] m38172c() {
        boolean[] zArr = f35729c;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6356643558535991176L, "com/mopub/nativeads/InMobiNativeCustomEvent", 30);
        f35729c = probes;
        return probes;
    }

    public InMobiNativeCustomEvent() {
        m38172c()[0] = true;
    }

    /* renamed from: b */
    static /* synthetic */ ConcurrentHashMap m38171b() {
        boolean[] c = m38172c();
        ConcurrentHashMap<Integer, InMobiNativeAd> concurrentHashMap = f35728b;
        c[27] = true;
        return concurrentHashMap;
    }

    static {
        boolean[] c = m38172c();
        c[28] = true;
        c[29] = true;
    }

    /* access modifiers changed from: protected */
    public void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map<String, Object> map, Map<String, String> serverExtras) {
        boolean[] c = m38172c();
        String accountId = (String) serverExtras.get("accountid");
        c[1] = true;
        long placementId = Long.parseLong((String) serverExtras.get("placementid"));
        c[2] = true;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Server Extras: Account ID:");
        sb.append(accountId);
        sb.append(" Placement ID:");
        sb.append(placementId);
        Log.d(str, sb.toString());
        c[3] = true;
        JSONObject gdprJson = new JSONObject();
        c[4] = true;
        if (!InMobiGDPR.isConsentUpdated()) {
            c[5] = true;
        } else {
            try {
                c[6] = true;
                gdprJson.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, InMobiGDPR.m38160a());
                c[7] = true;
                gdprJson.put("gdpr", InMobiGDPR.m38161b());
                c[8] = true;
            } catch (JSONException e) {
                c[9] = true;
                Log.d(TAG, "Unable to set GDPR consent object");
                c[10] = true;
                Log.e(TAG, e.getMessage());
                c[11] = true;
            }
        }
        if (f35727a) {
            c[12] = true;
        } else {
            try {
                c[13] = true;
                InMobiSdk.init(context, accountId);
                f35727a = true;
                c[14] = true;
            } catch (Exception e2) {
                c[15] = true;
                e2.printStackTrace();
                f35727a = false;
                c[16] = true;
                customEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
                c[17] = true;
                return;
            }
        }
        InMobiSdk.updateGDPRConsent(gdprJson);
        c[18] = true;
        InMobiSdk.setLogLevel(LogLevel.ERROR);
        c[19] = true;
        Map<String, String> map2 = new HashMap<>();
        c[20] = true;
        map2.put("tp", "c_mopub");
        c[21] = true;
        map2.put("tp-ver", "5.7.1");
        c[22] = true;
        this.f35730d = new InMobiNativeAd(context, customEventNativeListener, placementId);
        c[23] = true;
        this.f35730d.mo37834a(map2);
        c[24] = true;
        this.f35730d.mo37835e();
        c[25] = true;
        f35728b.putIfAbsent(Integer.valueOf(this.f35730d.hashCode()), this.f35730d);
        c[26] = true;
    }
}
