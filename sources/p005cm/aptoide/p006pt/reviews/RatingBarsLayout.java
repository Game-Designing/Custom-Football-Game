package p005cm.aptoide.p006pt.reviews;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats.Rating.Vote;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;

/* renamed from: cm.aptoide.pt.reviews.RatingBarsLayout */
public class RatingBarsLayout {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ProgressAndTextLayout[] progressAndTextLayouts = new ProgressAndTextLayout[5];

    /* renamed from: cm.aptoide.pt.reviews.RatingBarsLayout$ProgressAndTextLayout */
    private static class ProgressAndTextLayout {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private ProgressBar progressBar;
        private TextView text;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8066300192656600330L, "cm/aptoide/pt/reviews/RatingBarsLayout$ProgressAndTextLayout", 6);
            $jacocoData = probes;
            return probes;
        }

        public ProgressAndTextLayout(int progressId, int textId, View view) {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
            this.progressBar = (ProgressBar) view.findViewById(progressId);
            $jacocoInit[1] = true;
            this.text = (TextView) view.findViewById(textId);
            $jacocoInit[2] = true;
        }

        public void setup(int total, int count) {
            boolean[] $jacocoInit = $jacocoInit();
            this.progressBar.setMax(total);
            $jacocoInit[3] = true;
            this.progressBar.setProgress(count);
            $jacocoInit[4] = true;
            this.text.setText(StringU.withSuffix((long) count));
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7907787365848135966L, "cm/aptoide/pt/reviews/RatingBarsLayout", 11);
        $jacocoData = probes;
        return probes;
    }

    public RatingBarsLayout(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.progressAndTextLayouts[0] = new ProgressAndTextLayout(C1375R.C1376id.one_rate_star_progress, C1375R.C1376id.one_rate_star_count, view);
        $jacocoInit[1] = true;
        this.progressAndTextLayouts[1] = new ProgressAndTextLayout(C1375R.C1376id.two_rate_star_progress, C1375R.C1376id.two_rate_star_count, view);
        $jacocoInit[2] = true;
        this.progressAndTextLayouts[2] = new ProgressAndTextLayout(C1375R.C1376id.three_rate_star_progress, C1375R.C1376id.three_rate_star_count, view);
        $jacocoInit[3] = true;
        this.progressAndTextLayouts[3] = new ProgressAndTextLayout(C1375R.C1376id.four_rate_star_progress, C1375R.C1376id.four_rate_star_count, view);
        $jacocoInit[4] = true;
        this.progressAndTextLayouts[4] = new ProgressAndTextLayout(C1375R.C1376id.five_rate_star_progress, C1375R.C1376id.five_rate_star_count, view);
        $jacocoInit[5] = true;
    }

    public void setup(Rating rating) {
        boolean[] $jacocoInit = $jacocoInit();
        int total = rating.getTotal();
        $jacocoInit[6] = true;
        $jacocoInit[7] = true;
        for (Vote vote : rating.getVotes()) {
            $jacocoInit[8] = true;
            this.progressAndTextLayouts[vote.getValue() - 1].setup(total, vote.getCount());
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
    }
}
