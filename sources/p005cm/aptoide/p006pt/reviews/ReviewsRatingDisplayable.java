package p005cm.aptoide.p006pt.reviews;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.reviews.ReviewsRatingDisplayable */
public class ReviewsRatingDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private App appMeta;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6838545919120555887L, "cm/aptoide/pt/reviews/ReviewsRatingDisplayable", 5);
        $jacocoData = probes;
        return probes;
    }

    public ReviewsRatingDisplayable() {
        $jacocoInit()[0] = true;
    }

    public ReviewsRatingDisplayable(App data) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appMeta = data;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.reviews_rating_displayable;
    }

    public App getAppMeta() {
        boolean[] $jacocoInit = $jacocoInit();
        App app = this.appMeta;
        $jacocoInit[4] = true;
        return app;
    }
}
