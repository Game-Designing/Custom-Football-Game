package p005cm.aptoide.p006pt.reviews;

import android.view.View;
import android.widget.Spinner;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.reviews.ReviewsLanguageFilterWidget */
public class ReviewsLanguageFilterWidget extends Widget<ReviewsLanguageFilterDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Spinner spinner;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4382929596795692145L, "cm/aptoide/pt/reviews/ReviewsLanguageFilterWidget", 4);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((ReviewsLanguageFilterDisplayable) displayable, i);
        $jacocoInit[3] = true;
    }

    public ReviewsLanguageFilterWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.spinner = (Spinner) itemView.findViewById(C1375R.C1376id.comments_filter_language_spinner);
        $jacocoInit[1] = true;
    }

    public void bindView(ReviewsLanguageFilterDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        displayable.setup(this.spinner);
        $jacocoInit[2] = true;
    }
}
