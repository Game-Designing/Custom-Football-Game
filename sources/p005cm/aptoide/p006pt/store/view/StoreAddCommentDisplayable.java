package p005cm.aptoide.p006pt.store.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.store.view.StoreAddCommentDisplayable */
public class StoreAddCommentDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final long storeId;
    private final String storeName;
    private final StoreTheme storeTheme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3280051817209644738L, "cm/aptoide/pt/store/view/StoreAddCommentDisplayable", 7);
        $jacocoData = probes;
        return probes;
    }

    public StoreAddCommentDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeId = -1;
        this.storeName = "";
        this.storeTheme = StoreTheme.DEFAULT;
        $jacocoInit[0] = true;
    }

    public StoreAddCommentDisplayable(long storeId2, String storeName2, StoreTheme storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeId = storeId2;
        this.storeName = storeName2;
        this.storeTheme = storeTheme2;
        $jacocoInit[1] = true;
    }

    public long getStoreId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.storeId;
        $jacocoInit[2] = true;
        return j;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[3] = true;
        return str;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[4] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[5] = true;
        return C1375R.layout.displayable_grid_add_store_comment;
    }

    public StoreTheme getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTheme storeTheme2 = this.storeTheme;
        $jacocoInit[6] = true;
        return storeTheme2;
    }
}
