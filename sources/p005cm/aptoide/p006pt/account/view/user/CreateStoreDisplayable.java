package p005cm.aptoide.p006pt.account.view.user;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats.StatusData;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.account.view.user.CreateStoreDisplayable */
public class CreateStoreDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private StoreAnalytics storeAnalytics;
    private TimelineStats timelineStats;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-959231048956355973L, "cm/aptoide/pt/account/view/user/CreateStoreDisplayable", 9);
        $jacocoData = probes;
        return probes;
    }

    public CreateStoreDisplayable() {
        $jacocoInit()[0] = true;
    }

    public CreateStoreDisplayable(StoreAnalytics storeAnalytics2, TimelineStats timelineStats2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAnalytics = storeAnalytics2;
        this.timelineStats = timelineStats2;
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
        return C1375R.layout.create_store_displayable_layout;
    }

    public StoreAnalytics getStoreAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAnalytics storeAnalytics2 = this.storeAnalytics;
        $jacocoInit[4] = true;
        return storeAnalytics2;
    }

    public long getFollowers() {
        boolean[] $jacocoInit = $jacocoInit();
        StatusData data = this.timelineStats.getData();
        $jacocoInit[5] = true;
        long followers = data.getFollowers();
        $jacocoInit[6] = true;
        return followers;
    }

    public long getFollowings() {
        boolean[] $jacocoInit = $jacocoInit();
        StatusData data = this.timelineStats.getData();
        $jacocoInit[7] = true;
        long following = data.getFollowing();
        $jacocoInit[8] = true;
        return following;
    }
}
