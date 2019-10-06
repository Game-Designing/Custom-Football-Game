package p005cm.aptoide.p006pt.home;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd.Network;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.AdsInBundleAdapter */
class AdsInBundleAdapter extends C0970a<AdInBundleViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<AdHomeEvent> adClickedEvents;
    private List<AdClick> ads;
    private int bundlePosition = -1;
    private HomeBundle homeBundle = null;
    private final DecimalFormat oneDecimalFormatter;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6555811436944130803L, "cm/aptoide/pt/home/AdsInBundleAdapter", 14);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((AdInBundleViewHolder) wVar, i);
        $jacocoInit[12] = true;
    }

    public AdsInBundleAdapter(List<AdClick> ads2, DecimalFormat oneDecimalFormatter2, C14963c<AdHomeEvent> adClickedEvents2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.ads = ads2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.adClickedEvents = adClickedEvents2;
        $jacocoInit[0] = true;
    }

    public void update(List<AdClick> ads2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.ads = ads2;
        $jacocoInit[1] = true;
        notifyDataSetChanged();
        $jacocoInit[2] = true;
    }

    public void updateBundle(HomeBundle homeBundle2, int bundlePosition2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeBundle = homeBundle2;
        this.bundlePosition = bundlePosition2;
        $jacocoInit[3] = true;
    }

    public AdInBundleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[4] = true;
        AdInBundleViewHolder adInBundleViewHolder = new AdInBundleViewHolder(from.inflate(C1375R.layout.displayable_grid_ad, parent, false), this.adClickedEvents, this.oneDecimalFormatter);
        $jacocoInit[5] = true;
        return adInBundleViewHolder;
    }

    public void onBindViewHolder(AdInBundleViewHolder viewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        viewHolder.setApp((AdClick) this.ads.get(position), this.homeBundle, this.bundlePosition, position);
        $jacocoInit[6] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        AdClick adClick = (AdClick) this.ads.get(position);
        $jacocoInit[7] = true;
        ApplicationAd ad = adClick.getAd();
        $jacocoInit[8] = true;
        Network network = ad.getNetwork();
        $jacocoInit[9] = true;
        int ordinal = network.ordinal();
        $jacocoInit[10] = true;
        return ordinal;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.ads.size();
        $jacocoInit[11] = true;
        return size;
    }
}
