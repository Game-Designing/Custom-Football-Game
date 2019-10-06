package p005cm.aptoide.p006pt.app.view;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.AppReview;

/* renamed from: cm.aptoide.pt.app.view.TopReviewsAdapter */
public class TopReviewsAdapter extends C0970a<MiniTopReviewViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppReview[] reviews;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6332827523715127314L, "cm/aptoide/pt/app/view/TopReviewsAdapter", 13);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((MiniTopReviewViewHolder) wVar, i);
        $jacocoInit[11] = true;
    }

    public /* bridge */ /* synthetic */ void onViewRecycled(C1000w wVar) {
        boolean[] $jacocoInit = $jacocoInit();
        onViewRecycled((MiniTopReviewViewHolder) wVar);
        $jacocoInit[10] = true;
    }

    public TopReviewsAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        this(null);
        $jacocoInit[0] = true;
    }

    public TopReviewsAdapter(AppReview[] reviews2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reviews = reviews2;
        $jacocoInit[1] = true;
    }

    public MiniTopReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        $jacocoInit[2] = true;
        MiniTopReviewViewHolder miniTopReviewViewHolder = new MiniTopReviewViewHolder(inflater.inflate(C1375R.layout.mini_top_comment, parent, false));
        $jacocoInit[3] = true;
        return miniTopReviewViewHolder;
    }

    public void onBindViewHolder(MiniTopReviewViewHolder holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.setup(this.reviews[position]);
        $jacocoInit[4] = true;
    }

    public int getItemCount() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        AppReview[] appReviewArr = this.reviews;
        if (appReviewArr == null) {
            i = 0;
            $jacocoInit[5] = true;
        } else {
            i = appReviewArr.length;
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
        return i;
    }

    public void onViewRecycled(MiniTopReviewViewHolder holder) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.cancelImageLoad();
        $jacocoInit[8] = true;
        super.onViewRecycled(holder);
        $jacocoInit[9] = true;
    }
}
