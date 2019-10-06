package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.adview.C5856b;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.DataKeys;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import java.util.Map;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7266p;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7268r;

public class AppLovinBanner extends CustomEventBanner {

    /* renamed from: b */
    private static final Handler f34675b = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: protected */
    public void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        C7266p.m15793a(MoPub.canCollectPersonalInformation(), context);
        C7257g adSize = m37270a(localExtras);
        if (adSize != null) {
            String adMarkup = (String) serverExtras.get(DataKeys.ADM_KEY);
            boolean hasAdMarkup = !TextUtils.isEmpty(adMarkup);
            StringBuilder sb = new StringBuilder();
            sb.append("Requesting AppLovin banner with serverExtras: ");
            sb.append(serverExtras);
            sb.append(", localExtras: ");
            sb.append(localExtras);
            sb.append(" and has ad markup: ");
            sb.append(hasAdMarkup);
            MoPubLog.m37080d(sb.toString());
            C7267q sdk = m37271a(serverExtras, context);
            sdk.mo23054b("MoPub-3.1.0");
            sdk.mo23045a(BuildConfig.SDK_NAME);
            C5856b adView = new C5856b(sdk, adSize, context);
            adView.setAdDisplayListener(new C11402g(this));
            adView.setAdClickListener(new C11405h(this, customEventBannerListener));
            adView.setAdViewEventListener(new C11408i(this, customEventBannerListener));
            C7254d adLoadListener = new C11421l(this, adView, customEventBannerListener);
            if (hasAdMarkup) {
                sdk.mo23037a().mo23014b(adMarkup, adLoadListener);
                return;
            }
            String zoneId = (String) serverExtras.get("zone_id");
            if (!TextUtils.isEmpty(zoneId)) {
                sdk.mo23037a().mo23010a(zoneId, adLoadListener);
            } else {
                sdk.mo23037a().mo23008a(adSize, adLoadListener);
            }
        } else {
            MoPubLog.m37080d("Unable to request AppLovin banner");
            if (customEventBannerListener != null) {
                customEventBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
    }

    /* renamed from: a */
    private C7257g m37270a(Map<String, Object> localExtras) {
        if (localExtras == null || localExtras.isEmpty()) {
            MoPubLog.m37080d("No serverExtras provided");
            return null;
        }
        try {
            int width = ((Integer) localExtras.get(DataKeys.AD_WIDTH)).intValue();
            int height = ((Integer) localExtras.get(DataKeys.AD_HEIGHT)).intValue();
            String str = ") provided";
            String str2 = ") and height (";
            if (width <= 0 || height <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid width (");
                sb.append(width);
                sb.append(str2);
                sb.append(height);
                sb.append(str);
                MoPubLog.m37080d(sb.toString());
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Valid width (");
            sb2.append(width);
            sb2.append(str2);
            sb2.append(height);
            sb2.append(str);
            MoPubLog.m37080d(sb2.toString());
            int bannerOffset = Math.abs(50 - height);
            int leaderOffset = Math.abs(90 - height);
            if (bannerOffset <= 10) {
                return C7257g.f14094a;
            }
            if (leaderOffset <= 16) {
                return C7257g.f14095b;
            }
            if (height <= C7257g.f14097d.mo23472a()) {
                return C7257g.f14097d;
            }
            MoPubLog.m37080d("Provided dimensions does not meet the dimensions required of banner or mrec ads");
            return null;
        } catch (Throwable th) {
            MoPubLog.m37081d("Encountered error while parsing width and height from serverExtras", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static MoPubErrorCode m37273b(int applovinErrorCode) {
        if (applovinErrorCode == 204) {
            return MoPubErrorCode.NETWORK_NO_FILL;
        }
        if (applovinErrorCode == -1) {
            return MoPubErrorCode.UNSPECIFIED;
        }
        if (applovinErrorCode == -103) {
            return MoPubErrorCode.NO_CONNECTION;
        }
        if (applovinErrorCode == -102) {
            return MoPubErrorCode.NETWORK_TIMEOUT;
        }
        return MoPubErrorCode.UNSPECIFIED;
    }

    /* renamed from: a */
    private static C7267q m37271a(Map<String, String> serverExtras, Context context) {
        String sdkKey = serverExtras != null ? (String) serverExtras.get("sdk_key") : null;
        if (!TextUtils.isEmpty(sdkKey)) {
            return C7267q.m15795a(sdkKey, new C7268r(), context);
        }
        return C7267q.m15794a(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m37274b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f34675b.post(runnable);
        }
    }
}
