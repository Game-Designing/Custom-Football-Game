package p005cm.aptoide.p006pt.view.recycler;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessResponse;

/* renamed from: cm.aptoide.pt.view.recycler.MultiLangPatch */
public class MultiLangPatch {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int total;
    private int totalWaiting;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6113528846349522116L, "cm/aptoide/pt/view/recycler/MultiLangPatch", 4);
        $jacocoData = probes;
        return probes;
    }

    public MultiLangPatch() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: 0000 */
    public void updateTotal(BaseV7EndlessResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        this.totalWaiting += response.getTotal();
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: 0000 */
    public void updateOffset() {
        boolean[] $jacocoInit = $jacocoInit();
        this.total = this.totalWaiting;
        $jacocoInit[2] = true;
    }

    public int getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.total;
        $jacocoInit[3] = true;
        return i;
    }
}
