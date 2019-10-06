package p005cm.aptoide.p006pt.home;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.app.AppViewHolder;
import p005cm.aptoide.p006pt.view.app.Application;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.TopBundleAdapter */
public class TopBundleAdapter extends C0970a<C1000w> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int TOP_APP = 2131427647;
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
        boolean[] probes = Offline.getProbes(-7832883360006385104L, "cm/aptoide/pt/home/TopBundleAdapter", 9);
        $jacocoData = probes;
        return probes;
    }

    TopBundleAdapter(List<Application> apps2, DecimalFormat oneDecimalFormatter2, C14963c<HomeEvent> appClickedEvents2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apps = apps2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.appClickedEvents = appClickedEvents2;
        $jacocoInit[0] = true;
    }

    public C1000w onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        TopAppViewHolder topAppViewHolder = new TopAppViewHolder(from.inflate(C1375R.layout.top_app_item, parent, false), this.appClickedEvents, this.oneDecimalFormatter);
        $jacocoInit[2] = true;
        return topAppViewHolder;
    }

    public void onBindViewHolder(C1000w holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        ((AppViewHolder) holder).setApp((Application) this.apps.get(position), this.homeBundle, this.bundlePosition, position);
        $jacocoInit[3] = true;
    }

    public int getItemViewType(int position) {
        $jacocoInit()[4] = true;
        return C1375R.layout.top_app_item;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.apps.size();
        $jacocoInit[5] = true;
        return size;
    }

    public void update(List<Application> apps2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apps = apps2;
        $jacocoInit[6] = true;
        notifyDataSetChanged();
        $jacocoInit[7] = true;
    }

    public void updateBundle(HomeBundle homeBundle2, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeBundle = homeBundle2;
        this.bundlePosition = position;
        $jacocoInit[8] = true;
    }
}
