package p005cm.aptoide.p006pt.ads;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.ads.MoPubBannerAdListener */
public class MoPubBannerAdListener implements BannerAdListener {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7929135688061437482L, "cm/aptoide/pt/ads/MoPubBannerAdListener", 11);
        $jacocoData = probes;
        return probes;
    }

    public MoPubBannerAdListener() {
        $jacocoInit()[0] = true;
    }

    public void onBannerLoaded(MoPubView banner) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[1] = true;
        instance.mo2136d("Mopub", "Banner loaded");
        $jacocoInit[2] = true;
    }

    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Banner error : ");
        $jacocoInit[3] = true;
        sb.append(errorCode.toString());
        instance.mo2140e("Mopub", sb.toString());
        $jacocoInit[4] = true;
    }

    public void onBannerClicked(MoPubView banner) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[5] = true;
        instance.mo2136d("Mopub", "Banner clicked");
        $jacocoInit[6] = true;
    }

    public void onBannerExpanded(MoPubView banner) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[7] = true;
        instance.mo2136d("Mopub", "Banner expanded");
        $jacocoInit[8] = true;
    }

    public void onBannerCollapsed(MoPubView banner) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[9] = true;
        instance.mo2136d("Mopub", "Banner collapsed");
        $jacocoInit[10] = true;
    }
}
