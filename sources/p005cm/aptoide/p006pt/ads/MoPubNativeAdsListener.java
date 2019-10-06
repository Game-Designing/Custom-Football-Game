package p005cm.aptoide.p006pt.ads;

import com.mopub.nativeads.MoPubNativeAdLoadedListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.ads.MoPubNativeAdsListener */
public class MoPubNativeAdsListener implements MoPubNativeAdLoadedListener {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7484266508865732059L, "cm/aptoide/pt/ads/MoPubNativeAdsListener", 3);
        $jacocoData = probes;
        return probes;
    }

    public MoPubNativeAdsListener() {
        $jacocoInit()[0] = true;
    }

    public void onAdLoaded(int position) {
        $jacocoInit()[1] = true;
    }

    public void onAdRemoved(int position) {
        $jacocoInit()[2] = true;
    }
}
