package p005cm.aptoide.p006pt.ads;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.ads.MoPubInterstitialAdListener */
public class MoPubInterstitialAdListener implements InterstitialAdListener {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C14963c<MoPubInterstitialAdClickType> interstitialClick;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1450565258631378479L, "cm/aptoide/pt/ads/MoPubInterstitialAdListener", 7);
        $jacocoData = probes;
        return probes;
    }

    public MoPubInterstitialAdListener(C14963c<MoPubInterstitialAdClickType> interstitialClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.interstitialClick = interstitialClick2;
        $jacocoInit[0] = true;
    }

    public void onInterstitialLoaded(MoPubInterstitial interstitial) {
        boolean[] $jacocoInit = $jacocoInit();
        this.interstitialClick.onNext(MoPubInterstitialAdClickType.INTERSTITIAL_LOADED);
        $jacocoInit[1] = true;
    }

    public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[2] = true;
        instance.mo2140e("Mopub_Interstitial", errorCode.toString());
        $jacocoInit[3] = true;
    }

    public void onInterstitialShown(MoPubInterstitial interstitial) {
        $jacocoInit()[4] = true;
    }

    public void onInterstitialClicked(MoPubInterstitial interstitial) {
        boolean[] $jacocoInit = $jacocoInit();
        this.interstitialClick.onNext(MoPubInterstitialAdClickType.INTERSTITIAL_CLICKED);
        $jacocoInit[5] = true;
    }

    public void onInterstitialDismissed(MoPubInterstitial interstitial) {
        $jacocoInit()[6] = true;
    }
}
