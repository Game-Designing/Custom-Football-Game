package p005cm.aptoide.p006pt.abtesting;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.abtesting.ExperimentModel */
public class ExperimentModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Experiment experiment;
    private boolean hasError;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4091239373994496341L, "cm/aptoide/pt/abtesting/ExperimentModel", 3);
        $jacocoData = probes;
        return probes;
    }

    public ExperimentModel(Experiment experiment2, boolean hasError2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.experiment = experiment2;
        this.hasError = hasError2;
        $jacocoInit[0] = true;
    }

    public Experiment getExperiment() {
        boolean[] $jacocoInit = $jacocoInit();
        Experiment experiment2 = this.experiment;
        $jacocoInit[1] = true;
        return experiment2;
    }

    public boolean hasError() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasError;
        $jacocoInit[2] = true;
        return z;
    }
}
