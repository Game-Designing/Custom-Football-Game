package p005cm.aptoide.p006pt.view.app;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.view.app.ListStoreAppsAdapter */
class ListStoreAppsAdapter extends C0970a<ListStoreAppViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<Application> appClicks;
    private List<Application> list;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1399234809522571402L, "cm/aptoide/pt/view/app/ListStoreAppsAdapter", 35);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((ListStoreAppViewHolder) wVar, i);
        $jacocoInit[33] = true;
    }

    public ListStoreAppsAdapter(List<Application> list2, C14963c<Application> appClicks2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.list = list2;
        this.appClicks = appClicks2;
        $jacocoInit[0] = true;
    }

    public ListStoreAppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        if (viewType == C1375R.layout.search_ad_loading_list_item) {
            $jacocoInit[1] = true;
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            $jacocoInit[2] = true;
            AppLoadingViewHolder appLoadingViewHolder = new AppLoadingViewHolder(from.inflate(C1375R.layout.search_ad_loading_list_item, parent, false));
            $jacocoInit[3] = true;
            return appLoadingViewHolder;
        }
        LayoutInflater from2 = LayoutInflater.from(parent.getContext());
        $jacocoInit[4] = true;
        ApplicationViewHolder applicationViewHolder = new ApplicationViewHolder(from2.inflate(C1375R.layout.displayable_grid_app, parent, false), this.appClicks);
        $jacocoInit[5] = true;
        return applicationViewHolder;
    }

    public void onBindViewHolder(ListStoreAppViewHolder holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.setApp((Application) this.list.get(position));
        $jacocoInit[6] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (((Application) this.list.get(position)) instanceof AppLoading) {
            $jacocoInit[7] = true;
            return C1375R.layout.search_ad_loading_list_item;
        }
        $jacocoInit[8] = true;
        return C1375R.layout.displayable_grid_app;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.list.size();
        $jacocoInit[9] = true;
        return size;
    }

    public void addApps(List<Application> applicationList) {
        int firstInsertedIndex;
        boolean[] $jacocoInit = $jacocoInit();
        int loadingPosition = getLoadingPosition();
        if (loadingPosition >= 0) {
            $jacocoInit[10] = true;
            this.list.addAll(loadingPosition, applicationList);
            firstInsertedIndex = loadingPosition;
            $jacocoInit[11] = true;
        } else {
            firstInsertedIndex = this.list.size();
            $jacocoInit[12] = true;
            this.list.addAll(applicationList);
            $jacocoInit[13] = true;
        }
        notifyItemRangeInserted(firstInsertedIndex, applicationList.size());
        $jacocoInit[14] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getLoadingPosition() >= 0) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            this.list.add(new AppLoading());
            $jacocoInit[17] = true;
            notifyItemInserted(this.list.size() - 1);
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        int loadingPosition = getLoadingPosition();
        if (loadingPosition < 0) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            this.list.remove(loadingPosition);
            $jacocoInit[22] = true;
            notifyItemRemoved(loadingPosition);
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
    }

    public int getLoadingPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.list.size() - 1;
        $jacocoInit[25] = true;
        while (i >= 0) {
            $jacocoInit[26] = true;
            if (((Application) this.list.get(i)) instanceof AppLoading) {
                $jacocoInit[27] = true;
                return i;
            }
            i--;
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
        return -1;
    }

    public Application getItem(int position) {
        Application application = (Application) this.list.get(position);
        $jacocoInit()[30] = true;
        return application;
    }

    public void setApps(List<Application> apps) {
        boolean[] $jacocoInit = $jacocoInit();
        this.list = apps;
        $jacocoInit[31] = true;
        notifyDataSetChanged();
        $jacocoInit[32] = true;
    }
}
