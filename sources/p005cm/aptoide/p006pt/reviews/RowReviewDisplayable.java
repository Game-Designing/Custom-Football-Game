package p005cm.aptoide.p006pt.reviews;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.FullReview;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.reviews.RowReviewDisplayable */
public class RowReviewDisplayable extends DisplayablePojo<FullReview> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private StoreAnalytics storeAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5868243785563729932L, "cm/aptoide/pt/reviews/RowReviewDisplayable", 5);
        $jacocoData = probes;
        return probes;
    }

    public RowReviewDisplayable() {
        $jacocoInit()[0] = true;
    }

    public RowReviewDisplayable(FullReview pojo, StoreAnalytics storeAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.storeAnalytics = storeAnalytics2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, false);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_row_review;
    }

    public StoreAnalytics getStoreAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAnalytics storeAnalytics2 = this.storeAnalytics;
        $jacocoInit[4] = true;
        return storeAnalytics2;
    }
}
