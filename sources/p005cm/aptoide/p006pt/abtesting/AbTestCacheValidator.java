package p005cm.aptoide.p006pt.abtesting;

import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.abtesting.AbTestCacheValidator */
public class AbTestCacheValidator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private HashMap<String, ExperimentModel> localCache;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-463846660339135166L, "cm/aptoide/pt/abtesting/AbTestCacheValidator", 24);
        $jacocoData = probes;
        return probes;
    }

    public AbTestCacheValidator(HashMap<String, ExperimentModel> localCache2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.localCache = localCache2;
        $jacocoInit[0] = true;
    }

    public boolean isCacheValid(String experimentId) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.localCache.containsKey(experimentId)) {
            $jacocoInit[1] = true;
        } else {
            ExperimentModel experimentModel = (ExperimentModel) this.localCache.get(experimentId);
            $jacocoInit[2] = true;
            if (experimentModel.hasError()) {
                $jacocoInit[3] = true;
            } else {
                ExperimentModel experimentModel2 = (ExperimentModel) this.localCache.get(experimentId);
                $jacocoInit[4] = true;
                Experiment experiment = experimentModel2.getExperiment();
                $jacocoInit[5] = true;
                if (experiment.isExperimentOver()) {
                    $jacocoInit[6] = true;
                } else {
                    ExperimentModel experimentModel3 = (ExperimentModel) this.localCache.get(experimentId);
                    $jacocoInit[7] = true;
                    Experiment experiment2 = experimentModel3.getExperiment();
                    $jacocoInit[8] = true;
                    if (!experiment2.isPartOfExperiment()) {
                        $jacocoInit[9] = true;
                    } else {
                        $jacocoInit[10] = true;
                        z = true;
                        $jacocoInit[12] = true;
                        return z;
                    }
                }
            }
        }
        z = false;
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
        return z;
    }

    public boolean isExperimentValid(String experimentId) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        ExperimentModel model = (ExperimentModel) this.localCache.get(experimentId);
        $jacocoInit[13] = true;
        Experiment experiment = model.getExperiment();
        $jacocoInit[14] = true;
        if (experiment.isExpired()) {
            $jacocoInit[15] = true;
        } else if (model.hasError()) {
            $jacocoInit[16] = true;
        } else {
            Experiment experiment2 = model.getExperiment();
            $jacocoInit[17] = true;
            if (experiment2.isExperimentOver()) {
                $jacocoInit[18] = true;
            } else {
                Experiment experiment3 = model.getExperiment();
                $jacocoInit[19] = true;
                if (!experiment3.isPartOfExperiment()) {
                    $jacocoInit[20] = true;
                } else {
                    $jacocoInit[21] = true;
                    z = true;
                    $jacocoInit[23] = true;
                    return z;
                }
            }
        }
        z = false;
        $jacocoInit[22] = true;
        $jacocoInit[23] = true;
        return z;
    }
}
