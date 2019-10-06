package p005cm.aptoide.p006pt.app.view;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.AppViewSimilarApp;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppClickEvent;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.app.view.AppViewSimilarAppsAdapter */
public class AppViewSimilarAppsAdapter extends C0970a<AppViewSimilarAppViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C14963c<SimilarAppClickEvent> appClicked;
    private DecimalFormat oneDecimalFormater;
    private List<AppViewSimilarApp> similarApps;
    private SimilarAppType type;

    /* renamed from: cm.aptoide.pt.app.view.AppViewSimilarAppsAdapter$SimilarAppType */
    public enum SimilarAppType {
        APPC_SIMILAR_APPS("appc_similar_apps"),
        SIMILAR_APPS("similar_apps");
        
        private final String description;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[4] = true;
        }

        private SimilarAppType(String description2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.description = description2;
            $jacocoInit[2] = true;
        }

        public String getDescription() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.description;
            $jacocoInit[3] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5904747922489318098L, "cm/aptoide/pt/app/view/AppViewSimilarAppsAdapter", 14);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((AppViewSimilarAppViewHolder) wVar, i);
        $jacocoInit[12] = true;
    }

    public AppViewSimilarAppsAdapter(List<AppViewSimilarApp> similarApps2, DecimalFormat oneDecimalFormater2, C14963c<SimilarAppClickEvent> appClicked2, SimilarAppType type2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.similarApps = similarApps2;
        this.oneDecimalFormater = oneDecimalFormater2;
        this.appClicked = appClicked2;
        this.type = type2;
        $jacocoInit[0] = true;
    }

    public AppViewSimilarAppViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        $jacocoInit[1] = true;
        AppViewSimilarAppViewHolder appViewSimilarAppViewHolder = new AppViewSimilarAppViewHolder(from.inflate(C1375R.layout.displayable_grid_ad, viewGroup, false), this.oneDecimalFormater, this.appClicked);
        $jacocoInit[2] = true;
        return appViewSimilarAppViewHolder;
    }

    public void onBindViewHolder(AppViewSimilarAppViewHolder appViewSimilarAppViewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.similarApps.get(position) == null) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            appViewSimilarAppViewHolder.setSimilarApp((AppViewSimilarApp) this.similarApps.get(position), this.type);
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewSimilarApp appViewSimilarApp = (AppViewSimilarApp) this.similarApps.get(position);
        $jacocoInit[7] = true;
        int networkAdType = appViewSimilarApp.getNetworkAdType();
        $jacocoInit[8] = true;
        return networkAdType;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.similarApps.size();
        $jacocoInit[9] = true;
        return size;
    }

    public void update(List<AppViewSimilarApp> apps) {
        boolean[] $jacocoInit = $jacocoInit();
        this.similarApps = apps;
        $jacocoInit[10] = true;
        notifyDataSetChanged();
        $jacocoInit[11] = true;
    }
}
