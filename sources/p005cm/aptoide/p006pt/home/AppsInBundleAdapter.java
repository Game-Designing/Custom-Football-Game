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

/* renamed from: cm.aptoide.pt.home.AppsInBundleAdapter */
class AppsInBundleAdapter extends C0970a<C1000w> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int APP = 2131427367;
    private static final int REWARD_APP = 2131427613;
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
        boolean[] probes = Offline.getProbes(-1403704305555375663L, "cm/aptoide/pt/home/AppsInBundleAdapter", 13);
        $jacocoData = probes;
        return probes;
    }

    AppsInBundleAdapter(List<Application> apps2, DecimalFormat oneDecimalFormatter2, C14963c<HomeEvent> appClickedEvents2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apps = apps2;
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.appClickedEvents = appClickedEvents2;
        $jacocoInit[0] = true;
    }

    public C1000w onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        if (viewType == C1375R.layout.app_home_item) {
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            $jacocoInit[3] = true;
            AppInBundleViewHolder appInBundleViewHolder = new AppInBundleViewHolder(from.inflate(C1375R.layout.app_home_item, parent, false), this.appClickedEvents, this.oneDecimalFormatter);
            $jacocoInit[4] = true;
            return appInBundleViewHolder;
        } else if (viewType == C1375R.layout.reward_app_home_item) {
            LayoutInflater from2 = LayoutInflater.from(parent.getContext());
            $jacocoInit[1] = true;
            RewardAppInBundleViewHolder rewardAppInBundleViewHolder = new RewardAppInBundleViewHolder(from2.inflate(C1375R.layout.reward_app_home_item, parent, false), this.appClickedEvents);
            $jacocoInit[2] = true;
            return rewardAppInBundleViewHolder;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong type of App");
            $jacocoInit[5] = true;
            throw illegalArgumentException;
        }
    }

    public void onBindViewHolder(C1000w viewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        ((AppViewHolder) viewHolder).setApp((Application) this.apps.get(position), this.homeBundle, this.bundlePosition, position);
        $jacocoInit[6] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.apps.get(position) instanceof RewardApp) {
            $jacocoInit[7] = true;
            return C1375R.layout.reward_app_home_item;
        }
        $jacocoInit[8] = true;
        return C1375R.layout.app_home_item;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.apps.size();
        $jacocoInit[9] = true;
        return size;
    }

    public void update(List<Application> apps2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apps = apps2;
        $jacocoInit[10] = true;
        notifyDataSetChanged();
        $jacocoInit[11] = true;
    }

    public void updateBundle(HomeBundle homeBundle2, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeBundle = homeBundle2;
        this.bundlePosition = position;
        $jacocoInit[12] = true;
    }
}
