package p005cm.aptoide.p006pt.store.view;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.store.view.StoreLatestCommentsDisplayable */
public class StoreLatestCommentsDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<Comment> comments;
    private final long storeId;
    private String storeName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7798131038939875244L, "cm/aptoide/pt/store/view/StoreLatestCommentsDisplayable", 8);
        $jacocoData = probes;
        return probes;
    }

    public StoreLatestCommentsDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeId = -1;
        $jacocoInit[0] = true;
        this.comments = Collections.emptyList();
        $jacocoInit[1] = true;
    }

    public StoreLatestCommentsDisplayable(long storeId2, String storeName2, List<Comment> comments2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeId = storeId2;
        this.storeName = storeName2;
        this.comments = comments2;
        $jacocoInit[2] = true;
    }

    public List<Comment> getComments() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Comment> list = this.comments;
        $jacocoInit[3] = true;
        return list;
    }

    public long getStoreId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.storeId;
        $jacocoInit[4] = true;
        return j;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[5] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[6] = true;
        return C1375R.layout.displayable_grid_latest_store_comments;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[7] = true;
        return str;
    }
}
