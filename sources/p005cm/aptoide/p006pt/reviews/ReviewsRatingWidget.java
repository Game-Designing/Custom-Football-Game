package p005cm.aptoide.p006pt.reviews;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats.Rating;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.reviews.ReviewsRatingWidget */
public class ReviewsRatingWidget extends Widget<ReviewsRatingDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private RatingBarsLayout ratingBarsLayout;
    private RatingTotalsLayout ratingTotalsLayout;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6921941019838467477L, "cm/aptoide/pt/reviews/ReviewsRatingWidget", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((ReviewsRatingDisplayable) displayable, i);
        $jacocoInit[10] = true;
    }

    public ReviewsRatingWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.ratingTotalsLayout = new RatingTotalsLayout(itemView);
        $jacocoInit[1] = true;
        this.ratingBarsLayout = new RatingBarsLayout(itemView);
        $jacocoInit[2] = true;
    }

    public void bindView(ReviewsRatingDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        setupRating(displayable.getAppMeta());
        $jacocoInit[3] = true;
    }

    private void setupRating(App data) {
        boolean[] $jacocoInit = $jacocoInit();
        RatingTotalsLayout ratingTotalsLayout2 = this.ratingTotalsLayout;
        Stats stats = data.getStats();
        $jacocoInit[4] = true;
        Rating globalRating = stats.getGlobalRating();
        $jacocoInit[5] = true;
        ratingTotalsLayout2.setup(globalRating);
        $jacocoInit[6] = true;
        RatingBarsLayout ratingBarsLayout2 = this.ratingBarsLayout;
        Stats stats2 = data.getStats();
        $jacocoInit[7] = true;
        Rating globalRating2 = stats2.getGlobalRating();
        $jacocoInit[8] = true;
        ratingBarsLayout2.setup(globalRating2);
        $jacocoInit[9] = true;
    }
}
