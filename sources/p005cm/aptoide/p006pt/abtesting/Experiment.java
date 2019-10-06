package p005cm.aptoide.p006pt.abtesting;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.abtesting.Experiment */
public class Experiment {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final long MAX_CACHE_TIME_IN_MILLIS = 2592000000L;
    private static final long TWENTY_FOUR_HOURS = 86400000;
    private String assignment;
    private boolean experimentOver;
    private boolean partOfExperiment;
    private String payload;
    private long requestTime;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5947903060159432783L, "cm/aptoide/pt/abtesting/Experiment", 13);
        $jacocoData = probes;
        return probes;
    }

    public Experiment(long requestTime2, String payload2, String assignment2, boolean experimentOver2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.requestTime = requestTime2;
        this.assignment = assignment2;
        this.payload = payload2;
        boolean z = false;
        if (assignment2 != null) {
            $jacocoInit[0] = true;
            z = true;
        } else {
            $jacocoInit[1] = true;
        }
        this.partOfExperiment = z;
        this.experimentOver = experimentOver2;
        $jacocoInit[2] = true;
    }

    public Experiment() {
        boolean[] $jacocoInit = $jacocoInit();
        this.requestTime = -1;
        String str = "";
        this.assignment = str;
        this.payload = str;
        this.partOfExperiment = false;
        $jacocoInit[3] = true;
    }

    public Experiment(long requestTime2, String assignment2, String payload2, boolean partOfExperiment2, boolean experimentOver2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.requestTime = requestTime2;
        this.assignment = assignment2;
        this.payload = payload2;
        this.partOfExperiment = partOfExperiment2;
        this.experimentOver = experimentOver2;
        $jacocoInit[4] = true;
    }

    public long getRequestTime() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.requestTime;
        $jacocoInit[5] = true;
        return j;
    }

    public boolean isExpired() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.requestTime < System.currentTimeMillis() - MAX_CACHE_TIME_IN_MILLIS) {
            $jacocoInit[6] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return z;
    }

    public String getAssignment() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.assignment;
        $jacocoInit[9] = true;
        return str;
    }

    public String getPayload() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.payload;
        $jacocoInit[10] = true;
        return str;
    }

    public boolean isPartOfExperiment() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.partOfExperiment;
        $jacocoInit[11] = true;
        return z;
    }

    public boolean isExperimentOver() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.experimentOver;
        $jacocoInit[12] = true;
        return z;
    }
}
