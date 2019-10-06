package p005cm.aptoide.p006pt.app.view.similar;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundle.BundleType;
import p005cm.aptoide.p006pt.app.view.similar.bundles.SimilarAppcAppsViewHolder;
import p005cm.aptoide.p006pt.app.view.similar.bundles.SimilarAppsViewHolder;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.app.view.similar.SimilarAppsBundleAdapter */
public class SimilarAppsBundleAdapter extends C0970a<SimilarBundleViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int APPC_APPS = 2131427396;
    private static final int APPS = 2131427397;
    private List<SimilarAppsBundle> bundles;
    private final DecimalFormat decimalFormat;
    private final C14963c<SimilarAppClickEvent> similarAppClick;

    /* renamed from: cm.aptoide.pt.app.view.similar.SimilarAppsBundleAdapter$1 */
    static /* synthetic */ class C22091 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$app$view$similar$SimilarAppsBundle$BundleType */
        static final /* synthetic */ int[] f5280x549d0114 = new int[BundleType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(2973102188651110069L, "cm/aptoide/pt/app/view/similar/SimilarAppsBundleAdapter$1", 6);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f5280x549d0114[BundleType.APPS.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            f5280x549d0114[BundleType.APPC_APPS.ordinal()] = 2;
            $jacocoInit[3] = true;
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1762921929345372737L, "cm/aptoide/pt/app/view/similar/SimilarAppsBundleAdapter", 24);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((SimilarBundleViewHolder) wVar, i);
        $jacocoInit[22] = true;
    }

    public SimilarAppsBundleAdapter(List<SimilarAppsBundle> bundles2, DecimalFormat decimalFormat2, C14963c<SimilarAppClickEvent> similarAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundles = bundles2;
        this.decimalFormat = decimalFormat2;
        this.similarAppClick = similarAppClick2;
        $jacocoInit[0] = true;
    }

    public SimilarBundleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (viewType) {
            case C1375R.layout.appview_similar_appc_layout /*2131427396*/:
                LayoutInflater from = LayoutInflater.from(parent.getContext());
                $jacocoInit[3] = true;
                SimilarAppcAppsViewHolder similarAppcAppsViewHolder = new SimilarAppcAppsViewHolder(from.inflate(C1375R.layout.appview_similar_appc_layout, parent, false), this.decimalFormat, this.similarAppClick);
                $jacocoInit[4] = true;
                return similarAppcAppsViewHolder;
            case C1375R.layout.appview_similar_layout /*2131427397*/:
                LayoutInflater from2 = LayoutInflater.from(parent.getContext());
                $jacocoInit[1] = true;
                SimilarAppsViewHolder similarAppsViewHolder = new SimilarAppsViewHolder(from2.inflate(C1375R.layout.appview_similar_layout, parent, false), this.decimalFormat, this.similarAppClick);
                $jacocoInit[2] = true;
                return similarAppsViewHolder;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid bundle view type");
                $jacocoInit[5] = true;
                throw illegalStateException;
        }
    }

    public void onBindViewHolder(SimilarBundleViewHolder holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.setBundle((SimilarAppsBundle) this.bundles.get(position), position);
        $jacocoInit[6] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        int[] iArr = C22091.f5280x549d0114;
        SimilarAppsBundle similarAppsBundle = (SimilarAppsBundle) this.bundles.get(position);
        $jacocoInit[7] = true;
        BundleType type = similarAppsBundle.getType();
        $jacocoInit[8] = true;
        int i = iArr[type.ordinal()];
        if (i == 1) {
            $jacocoInit[9] = true;
            return C1375R.layout.appview_similar_layout;
        } else if (i == 2) {
            $jacocoInit[10] = true;
            return C1375R.layout.appview_similar_appc_layout;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Bundle type not supported by the adapter: ");
            List<SimilarAppsBundle> list = this.bundles;
            $jacocoInit[11] = true;
            SimilarAppsBundle similarAppsBundle2 = (SimilarAppsBundle) list.get(position);
            $jacocoInit[12] = true;
            BundleType type2 = similarAppsBundle2.getType();
            $jacocoInit[13] = true;
            sb.append(type2.name());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[14] = true;
            throw illegalStateException;
        }
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.bundles.size();
        $jacocoInit[15] = true;
        return size;
    }

    public void update(List<SimilarAppsBundle> bundles2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundles = bundles2;
        $jacocoInit[16] = true;
        notifyDataSetChanged();
        $jacocoInit[17] = true;
    }

    public void add(SimilarAppsBundle bundles2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundles.add(bundles2);
        $jacocoInit[18] = true;
        notifyDataSetChanged();
        $jacocoInit[19] = true;
    }

    public void add(List<SimilarAppsBundle> bundles2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundles.addAll(bundles2);
        $jacocoInit[20] = true;
        notifyItemInserted(bundles2.size() - 1);
        $jacocoInit[21] = true;
    }
}
