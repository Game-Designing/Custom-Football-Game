package p005cm.aptoide.p006pt.home;

import android.view.View;
import com.mopub.mobileads.MoPubView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.MoPubBannerAdListener;

/* renamed from: cm.aptoide.pt.home.SmallBannerAdBundleViewHolder */
class SmallBannerAdBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final MoPubView bannerView;
    private boolean hasLoaded = false;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6341802318920634866L, "cm/aptoide/pt/home/SmallBannerAdBundleViewHolder", 8);
        $jacocoData = probes;
        return probes;
    }

    public SmallBannerAdBundleViewHolder(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        $jacocoInit[0] = true;
        this.bannerView = (MoPubView) view.findViewById(C1375R.C1376id.banner);
        $jacocoInit[1] = true;
        this.bannerView.setBannerAdListener(new MoPubBannerAdListener());
        $jacocoInit[2] = true;
        this.bannerView.setAdUnitId("d225547d92b743179d8a04b75bf7d116");
        $jacocoInit[3] = true;
    }

    public void setBundle(HomeBundle homeBundle, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.hasLoaded) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            this.bannerView.loadAd();
            this.hasLoaded = true;
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
    }
}
