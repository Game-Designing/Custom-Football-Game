package p005cm.aptoide.p006pt.timeline.view.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.timeline.view.displayable.FollowStoreDisplayable */
public class FollowStoreDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6856377623339276823L, "cm/aptoide/pt/timeline/view/displayable/FollowStoreDisplayable", 4);
        $jacocoData = probes;
        return probes;
    }

    public FollowStoreDisplayable() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        int defaultPerLineCount = Type.FOLLOW_STORE.getDefaultPerLineCount();
        Type type = Type.FOLLOW_STORE;
        $jacocoInit[1] = true;
        Configs configs = new Configs(this, defaultPerLineCount, type.isFixedPerLineCount());
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_grid_follow_store;
    }
}
