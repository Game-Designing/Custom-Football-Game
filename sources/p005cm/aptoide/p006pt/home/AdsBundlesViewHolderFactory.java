package p005cm.aptoide.p006pt.home;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.AdsBundlesViewHolderFactory */
public class AdsBundlesViewHolderFactory {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int ADS = 2131427363;
    private final C14963c<AdHomeEvent> adClickedEvents;
    private final String marketName;
    private final DecimalFormat oneDecimalFormatter;
    private final boolean showNatives;
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1553886865814599952L, "cm/aptoide/pt/home/AdsBundlesViewHolderFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public AdsBundlesViewHolderFactory(C14963c<HomeEvent> uiEventsListener2, C14963c<AdHomeEvent> adClickedEvents2, DecimalFormat oneDecimalFormatter2, String marketName2, boolean showNatives2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.uiEventsListener = uiEventsListener2;
        this.adClickedEvents = adClickedEvents2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.marketName = marketName2;
        this.showNatives = showNatives2;
        $jacocoInit[0] = true;
    }

    public AppBundleViewHolder createViewHolder(ViewGroup parent) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT < 21) {
            $jacocoInit[1] = true;
        } else if (!this.showNatives) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            $jacocoInit[4] = true;
            AdsWithMoPubBundleViewHolder adsWithMoPubBundleViewHolder = new AdsWithMoPubBundleViewHolder(from.inflate(C1375R.layout.ads_bundle_item, null, false), this.uiEventsListener, this.oneDecimalFormatter, this.adClickedEvents, this.marketName);
            $jacocoInit[5] = true;
            return adsWithMoPubBundleViewHolder;
        }
        LayoutInflater from2 = LayoutInflater.from(parent.getContext());
        $jacocoInit[6] = true;
        AdsBundleViewHolder adsBundleViewHolder = new AdsBundleViewHolder(from2.inflate(C1375R.layout.ads_bundle_item, parent, false), this.uiEventsListener, this.oneDecimalFormatter, this.adClickedEvents, this.marketName);
        $jacocoInit[7] = true;
        return adsBundleViewHolder;
    }
}
