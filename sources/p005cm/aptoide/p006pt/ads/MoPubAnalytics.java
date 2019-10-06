package p005cm.aptoide.p006pt.ads;

import android.os.Bundle;
import com.facebook.C6817z;
import com.facebook.GraphRequest.C6545b;
import com.facebook.p127a.C6638q;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.logger.Logger;
import p019d.p020e.p021a.C7294e;

/* renamed from: cm.aptoide.pt.ads.MoPubAnalytics */
public class MoPubAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.ads.MoPubAnalytics$1 */
    static /* synthetic */ class C16501 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$ads$WalletAdsOfferManager$OfferResponseStatus */
        static final /* synthetic */ int[] f4596x788a6a9d = new int[OfferResponseStatus.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2019119070600075414L, "cm/aptoide/pt/ads/MoPubAnalytics$1", 8);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f4596x788a6a9d[OfferResponseStatus.NO_ADS.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        $jacocoInit[6] = true;
                    }
                }
            }
            f4596x788a6a9d[OfferResponseStatus.ADS_HIDE.ordinal()] = 2;
            $jacocoInit[3] = true;
            f4596x788a6a9d[OfferResponseStatus.ADS_SHOW.ordinal()] = 3;
            $jacocoInit[5] = true;
            $jacocoInit[7] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.ads.MoPubAnalytics$AdsVisibility */
    private enum AdsVisibility {
        ADS_BLOCKED_BY_OFFER("ads blocked by offer"),
        CONTROL("control"),
        HAS_ADS("has ads");
        
        private final String type;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[4] = true;
        }

        private AdsVisibility(String type2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = type2;
            $jacocoInit[2] = true;
        }

        public String getType() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.type;
            $jacocoInit[3] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4001595465261672327L, "cm/aptoide/pt/ads/MoPubAnalytics", 22);
        $jacocoData = probes;
        return probes;
    }

    public MoPubAnalytics() {
        $jacocoInit()[0] = true;
    }

    public void setMoPubAbTestGroup(boolean isControlGroup) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[1] = true;
        String str2 = "a_without_mopub";
        String str3 = "b_with_mopub";
        if (isControlGroup) {
            $jacocoInit[2] = true;
            str = str2;
        } else {
            $jacocoInit[3] = true;
            str = str3;
        }
        String str4 = "ASV-1377-MoPub-Ads";
        bundle.putString(str4, str);
        $jacocoInit[4] = true;
        C6638q.m13217a(bundle, (C6545b) C1676y.f4629a);
        $jacocoInit[5] = true;
        if (isControlGroup) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            str2 = str3;
        }
        C7294e.m15866a(str4, str2);
        $jacocoInit[8] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6405b(C6817z response) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[20] = true;
        instance.mo2136d("Facebook Analytics: ", response.toString());
        $jacocoInit[21] = true;
    }

    public void setAdsVisibilityUserProperty(OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[9] = true;
        String ads = mapToAdsVisibility(offerResponseStatus).getType();
        $jacocoInit[10] = true;
        String str = "ads";
        bundle.putString(str, ads);
        $jacocoInit[11] = true;
        C6638q.m13217a(bundle, (C6545b) C1677z.f4630a);
        $jacocoInit[12] = true;
        C7294e.m15866a(str, ads);
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6404a(C6817z response) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[18] = true;
        instance.mo2136d("Facebook Analytics: ", response.toString());
        $jacocoInit[19] = true;
    }

    private AdsVisibility mapToAdsVisibility(OfferResponseStatus status) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C16501.f4596x788a6a9d[status.ordinal()];
        if (i == 1) {
            AdsVisibility adsVisibility = AdsVisibility.CONTROL;
            $jacocoInit[14] = true;
            return adsVisibility;
        } else if (i == 2) {
            AdsVisibility adsVisibility2 = AdsVisibility.ADS_BLOCKED_BY_OFFER;
            $jacocoInit[15] = true;
            return adsVisibility2;
        } else if (i == 3) {
            AdsVisibility adsVisibility3 = AdsVisibility.HAS_ADS;
            $jacocoInit[16] = true;
            return adsVisibility3;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Invalid OfferResponseStatus");
            $jacocoInit[17] = true;
            throw illegalStateException;
        }
    }
}
