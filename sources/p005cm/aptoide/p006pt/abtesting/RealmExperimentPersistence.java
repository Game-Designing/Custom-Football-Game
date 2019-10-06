package p005cm.aptoide.p006pt.abtesting;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.realm.RealmExperiment;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.abtesting.RealmExperimentPersistence */
public class RealmExperimentPersistence implements ExperimentPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Database database;
    private final RealmExperimentMapper mapper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9033803889703919175L, "cm/aptoide/pt/abtesting/RealmExperimentPersistence", 9);
        $jacocoData = probes;
        return probes;
    }

    public RealmExperimentPersistence(Database database2, RealmExperimentMapper mapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.database = database2;
        this.mapper = mapper2;
        $jacocoInit[0] = true;
    }

    public void save(String experimentName, Experiment experiment) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            this.database.insert(this.mapper.map(experimentName, experiment));
            $jacocoInit[1] = true;
        } catch (JsonProcessingException e) {
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
    }

    public C0120S<ExperimentModel> get(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.database.get(RealmExperiment.class, RealmExperiment.PRIMARY_KEY_NAME, identifier);
        C1401s sVar = new C1401s(this);
        $jacocoInit[4] = true;
        C0120S<ExperimentModel> j = s.mo3669j(sVar);
        $jacocoInit[5] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ ExperimentModel mo9534a(RealmExperiment experiment) {
        boolean[] $jacocoInit = $jacocoInit();
        if (experiment == null) {
            $jacocoInit[6] = true;
            ExperimentModel experimentModel = new ExperimentModel(new Experiment(), true);
            $jacocoInit[7] = true;
            return experimentModel;
        }
        ExperimentModel experimentModel2 = new ExperimentModel(this.mapper.map(experiment), false);
        $jacocoInit[8] = true;
        return experimentModel2;
    }
}
