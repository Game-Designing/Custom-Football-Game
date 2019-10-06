package p005cm.aptoide.p006pt.abtesting;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.RealmExperiment;

/* renamed from: cm.aptoide.pt.abtesting.RealmExperimentMapper */
public class RealmExperimentMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6058244821826957618L, "cm/aptoide/pt/abtesting/RealmExperimentMapper", 6);
        $jacocoData = probes;
        return probes;
    }

    public RealmExperimentMapper() {
        $jacocoInit()[0] = true;
    }

    public RealmExperiment map(String experimentName, Experiment experiment) throws JsonProcessingException {
        boolean[] $jacocoInit = $jacocoInit();
        long requestTime = experiment.getRequestTime();
        $jacocoInit[1] = true;
        String assignment = experiment.getAssignment();
        String payload = experiment.getPayload();
        boolean isPartOfExperiment = experiment.isPartOfExperiment();
        $jacocoInit[2] = true;
        RealmExperiment realmExperiment = new RealmExperiment(experimentName, requestTime, assignment, payload, isPartOfExperiment, experiment.isExperimentOver());
        $jacocoInit[3] = true;
        return realmExperiment;
    }

    public Experiment map(RealmExperiment experiment) {
        boolean[] $jacocoInit = $jacocoInit();
        long requestTime = experiment.getRequestTime();
        String assignment = experiment.getAssignment();
        $jacocoInit[4] = true;
        Experiment experiment2 = new Experiment(requestTime, assignment, experiment.getPayload(), experiment.isPartOfExperiment(), experiment.isExperimentOver());
        $jacocoInit[5] = true;
        return experiment2;
    }
}
