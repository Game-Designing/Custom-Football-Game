package p005cm.aptoide.p006pt.abtesting;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.abtesting.ABTestManager */
public class ABTestManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AbTestRepository abTestRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3135916063737322879L, "cm/aptoide/pt/abtesting/ABTestManager", 7);
        $jacocoData = probes;
        return probes;
    }

    public ABTestManager(AbTestRepository abTestRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.abTestRepository = abTestRepository2;
        $jacocoInit[0] = true;
    }

    public C0120S<Experiment> getExperiment(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S experiment = this.abTestRepository.getExperiment(identifier);
        $jacocoInit[1] = true;
        C0120S<Experiment> d = experiment.mo3647d();
        $jacocoInit[2] = true;
        return d;
    }

    public C0120S<Boolean> recordImpression(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> recordImpression = this.abTestRepository.recordImpression(identifier);
        $jacocoInit[3] = true;
        return recordImpression;
    }

    public C0120S<Boolean> recordAction(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> recordAction = this.abTestRepository.recordAction(identifier);
        $jacocoInit[4] = true;
        return recordAction;
    }

    public C0120S<Boolean> recordAction(String identifier, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> recordAction = this.abTestRepository.recordAction(identifier, position);
        $jacocoInit[5] = true;
        return recordAction;
    }

    public C0120S<String> getExperimentId(String id) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<String> experimentId = this.abTestRepository.getExperimentId(id);
        $jacocoInit[6] = true;
        return experimentId;
    }
}
