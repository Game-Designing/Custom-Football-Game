package p005cm.aptoide.p006pt.home;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.app.Application;
import p005cm.aptoide.p006pt.view.app.FeatureGraphicApplication;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.EditorsAppsAdapter */
class EditorsAppsAdapter extends C0970a<FeatureGraphicInBundleViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<HomeEvent> appClickedEvents;
    private List<Application> apps;
    private int bundlePosition = -1;
    private HomeBundle homeBundle = null;
    private final DecimalFormat oneDecimalFormatter;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4015880125058375216L, "cm/aptoide/pt/home/EditorsAppsAdapter", 10);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((FeatureGraphicInBundleViewHolder) wVar, i);
        $jacocoInit[8] = true;
    }

    public EditorsAppsAdapter(List<Application> apps2, DecimalFormat oneDecimalFormatter2, C14963c<HomeEvent> appClickedEvents2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apps = apps2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.appClickedEvents = appClickedEvents2;
        $jacocoInit[0] = true;
    }

    public FeatureGraphicInBundleViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        FeatureGraphicInBundleViewHolder featureGraphicInBundleViewHolder = new FeatureGraphicInBundleViewHolder(from.inflate(C1375R.layout.feature_graphic_home_item, parent, false), this.oneDecimalFormatter, this.appClickedEvents);
        $jacocoInit[2] = true;
        return featureGraphicInBundleViewHolder;
    }

    public void onBindViewHolder(FeatureGraphicInBundleViewHolder viewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        viewHolder.setFeatureGraphicApplication((FeatureGraphicApplication) this.apps.get(position), this.homeBundle, this.bundlePosition, position);
        $jacocoInit[3] = true;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.apps.size();
        $jacocoInit[4] = true;
        return size;
    }

    public void update(List<Application> apps2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apps = apps2;
        $jacocoInit[5] = true;
        notifyDataSetChanged();
        $jacocoInit[6] = true;
    }

    public void updateBundle(HomeBundle homeBundle2, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeBundle = homeBundle2;
        this.bundlePosition = position;
        $jacocoInit[7] = true;
    }
}
