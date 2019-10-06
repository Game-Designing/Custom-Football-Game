package p005cm.aptoide.p006pt.abtesting;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;

/* renamed from: cm.aptoide.pt.abtesting.ABTestImpressionResponse */
public class ABTestImpressionResponse extends BaseBody {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String assignment;
    private boolean cache;
    private String context;
    private String payload;
    private String status;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7627613496117920798L, "cm/aptoide/pt/abtesting/ABTestImpressionResponse", 11);
        $jacocoData = probes;
        return probes;
    }

    public ABTestImpressionResponse() {
        $jacocoInit()[0] = true;
    }

    public boolean isCache() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.cache;
        $jacocoInit[1] = true;
        return z;
    }

    public void setCache(boolean cache2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cache = cache2;
        $jacocoInit[2] = true;
    }

    public String getPayload() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.payload;
        $jacocoInit[3] = true;
        return str;
    }

    public void setPayload(String payload2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.payload = payload2;
        $jacocoInit[4] = true;
    }

    public String getAssignment() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.assignment;
        $jacocoInit[5] = true;
        return str;
    }

    public void setAssignment(String assignment2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.assignment = assignment2;
        $jacocoInit[6] = true;
    }

    public String getContext() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.context;
        $jacocoInit[7] = true;
        return str;
    }

    public void setContext(String context2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        $jacocoInit[8] = true;
    }

    public String getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.status;
        $jacocoInit[9] = true;
        return str;
    }

    public void setStatus(String status2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.status = status2;
        $jacocoInit[10] = true;
    }
}
