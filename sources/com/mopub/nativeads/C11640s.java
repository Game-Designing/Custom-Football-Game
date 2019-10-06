package com.mopub.nativeads;

import android.util.Log;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.mopub.nativeads.InMobiNativeCustomEvent.InMobiNativeAd;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.s */
/* compiled from: InMobiNativeCustomEvent */
class C11640s extends NativeAdEventListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36230a;

    /* renamed from: b */
    final /* synthetic */ InMobiNativeAd f36231b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38466a() {
        boolean[] zArr = f36230a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4359290662568228712L, "com/mopub/nativeads/InMobiNativeCustomEvent$InMobiNativeAd$1", 57);
        f36230a = probes;
        return probes;
    }

    C11640s(InMobiNativeAd this$0) {
        boolean[] a = m38466a();
        this.f36231b = this$0;
        a[0] = true;
    }

    public void onAdLoadSucceeded(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onAdLoadSucceeded(inMobiNative);
        a[1] = true;
        Log.i("InMobiNativeAd", "InMobi Native Ad loaded successfully");
        a[2] = true;
        List<String> imageUrls = new ArrayList<>();
        a[3] = true;
        String iconImageUrl = this.f36231b.getAdIconUrl();
        if (iconImageUrl == null) {
            a[4] = true;
        } else {
            a[5] = true;
            imageUrls.add(iconImageUrl);
            a[6] = true;
        }
        NativeImageHelper.preCacheImages(InMobiNativeAd.m38173a(this.f36231b), imageUrls, new C11637r(this));
        a[7] = true;
        InMobiNativeCustomEvent.m38171b().remove(Integer.valueOf(hashCode()));
        a[8] = true;
    }

    public void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus) {
        String errorMessage;
        boolean[] a = m38466a();
        super.onAdLoadFailed(inMobiNative, inMobiAdRequestStatus);
        String errorMessage2 = "Failed to load Native Strand:";
        a[9] = true;
        switch (C11634q.f36218a[inMobiAdRequestStatus.getStatusCode().ordinal()]) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append(errorMessage2);
                sb.append("INTERNAL_ERROR");
                errorMessage = sb.toString();
                a[10] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
                a[11] = true;
                break;
            case 2:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(errorMessage2);
                sb2.append("INVALID_REQUEST");
                errorMessage = sb2.toString();
                a[12] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_REQUEST);
                a[13] = true;
                break;
            case 3:
                StringBuilder sb3 = new StringBuilder();
                sb3.append(errorMessage2);
                sb3.append("NETWORK_UNREACHABLE");
                errorMessage = sb3.toString();
                a[14] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.CONNECTION_ERROR);
                a[15] = true;
                break;
            case 4:
                StringBuilder sb4 = new StringBuilder();
                sb4.append(errorMessage2);
                sb4.append("NO_FILL");
                errorMessage = sb4.toString();
                a[16] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
                a[17] = true;
                break;
            case 5:
                StringBuilder sb5 = new StringBuilder();
                sb5.append(errorMessage2);
                sb5.append("REQUEST_PENDING");
                errorMessage = sb5.toString();
                a[18] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                a[19] = true;
                break;
            case 6:
                StringBuilder sb6 = new StringBuilder();
                sb6.append(errorMessage2);
                sb6.append("REQUEST_TIMED_OUT");
                errorMessage = sb6.toString();
                a[20] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.NETWORK_TIMEOUT);
                a[21] = true;
                break;
            case 7:
                StringBuilder sb7 = new StringBuilder();
                sb7.append(errorMessage2);
                sb7.append("SERVER_ERROR");
                errorMessage = sb7.toString();
                a[22] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
                a[23] = true;
                break;
            case 8:
                StringBuilder sb8 = new StringBuilder();
                sb8.append(errorMessage2);
                sb8.append("AD_ACTIVE");
                errorMessage = sb8.toString();
                a[24] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                a[25] = true;
                break;
            case 9:
                StringBuilder sb9 = new StringBuilder();
                sb9.append(errorMessage2);
                sb9.append("EARLY_REFRESH_REQUEST");
                errorMessage = sb9.toString();
                a[26] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                a[27] = true;
                break;
            default:
                StringBuilder sb10 = new StringBuilder();
                sb10.append("UNKNOWN_ERROR");
                sb10.append(inMobiAdRequestStatus.getStatusCode());
                errorMessage = sb10.toString();
                a[28] = true;
                InMobiNativeAd.m38175b(this.f36231b).onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                a[29] = true;
                break;
        }
        Log.w("InMobiNativeAd", errorMessage);
        a[30] = true;
        InMobiNativeCustomEvent.m38171b().remove(Integer.valueOf(hashCode()));
        a[31] = true;
        this.f36231b.destroy();
        a[32] = true;
    }

    public void onAdFullScreenDismissed(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onAdFullScreenDismissed(inMobiNative);
        a[33] = true;
        Log.d("InMobiNativeAd", "InMobi Native ad onAdFullScreenDismissed");
        a[34] = true;
    }

    public void onAdFullScreenWillDisplay(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onAdFullScreenWillDisplay(inMobiNative);
        a[35] = true;
        Log.d("InMobiNativeAd", "InMobi Native ad onAdFullScreenWillDisplay");
        a[36] = true;
    }

    public void onAdFullScreenDisplayed(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onAdFullScreenDisplayed(inMobiNative);
        a[37] = true;
        Log.d("InMobiNativeAd", "InMobi Native ad onAdFullScreenDisplayed");
        a[38] = true;
    }

    public void onUserWillLeaveApplication(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onUserWillLeaveApplication(inMobiNative);
        a[39] = true;
        Log.d("InMobiNativeAd", "InMobi Native ad onUserWillLeaveApplication");
        a[40] = true;
    }

    public void onAdImpressed(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onAdImpressed(inMobiNative);
        a[41] = true;
        Log.d("InMobiNativeAd", "InMobi Native ad is displayed");
        a[42] = true;
        if (InMobiNativeAd.m38177c(this.f36231b)) {
            a[43] = true;
        } else {
            a[44] = true;
            InMobiNativeAd.m38174a(this.f36231b, true);
            a[45] = true;
            this.f36231b.mo37750d();
            a[46] = true;
        }
        a[47] = true;
    }

    public void onAdClicked(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onAdClicked(inMobiNative);
        a[48] = true;
        Log.d("InMobiNativeAd", "InMobi Native ad is clicked");
        a[49] = true;
        if (InMobiNativeAd.m38178d(this.f36231b)) {
            a[50] = true;
        } else {
            a[51] = true;
            this.f36231b.mo37749c();
            a[52] = true;
            InMobiNativeAd.m38176b(this.f36231b, true);
            a[53] = true;
        }
        a[54] = true;
    }

    public void onAdStatusChanged(InMobiNative inMobiNative) {
        boolean[] a = m38466a();
        super.onAdStatusChanged(inMobiNative);
        a[55] = true;
        Log.d("InMobiNativeAd", "InMobi Native ad onAdStatusChanged");
        a[56] = true;
    }
}
