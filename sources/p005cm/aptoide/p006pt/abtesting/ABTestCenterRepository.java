package p005cm.aptoide.p006pt.abtesting;

import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.abtesting.ABTestCenterRepository */
public class ABTestCenterRepository implements AbTestRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AbTestCacheValidator cacheValidator;
    private HashMap<String, ExperimentModel> localCache;
    private RealmExperimentPersistence persistence;
    private ABTestService service;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5357726400093144541L, "cm/aptoide/pt/abtesting/ABTestCenterRepository", 37);
        $jacocoData = probes;
        return probes;
    }

    public ABTestCenterRepository(ABTestService service2, HashMap<String, ExperimentModel> localCache2, RealmExperimentPersistence persistence2, AbTestCacheValidator cacheValidator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.localCache = localCache2;
        this.persistence = persistence2;
        this.cacheValidator = cacheValidator2;
        $jacocoInit[0] = true;
    }

    public C0120S<Experiment> getExperiment(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.localCache.containsKey(identifier)) {
            $jacocoInit[1] = true;
            if (this.cacheValidator.isExperimentValid(identifier)) {
                $jacocoInit[2] = true;
                ExperimentModel experimentModel = (ExperimentModel) this.localCache.get(identifier);
                $jacocoInit[3] = true;
                Experiment experiment = experimentModel.getExperiment();
                $jacocoInit[4] = true;
                C0120S<Experiment> c = C0120S.m652c(experiment);
                $jacocoInit[5] = true;
                return c;
            }
            C0120S experiment2 = this.service.getExperiment(identifier);
            C1383d dVar = new C1383d(this, identifier);
            $jacocoInit[6] = true;
            C0120S<Experiment> f = experiment2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dVar);
            $jacocoInit[7] = true;
            return f;
        }
        C0120S s = this.persistence.get(identifier);
        $jacocoInit[8] = true;
        C0120S a = s.mo3616a(Schedulers.m776io());
        C1388f fVar = new C1388f(this, identifier);
        $jacocoInit[9] = true;
        C0120S<Experiment> f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
        $jacocoInit[10] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo9481a(String identifier, ExperimentModel experimentToCache) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = cacheExperiment(experimentToCache, identifier).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C1382c<Object,Object>(experimentToCache));
        $jacocoInit[35] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6148a(ExperimentModel experimentToCache, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(experimentToCache.getExperiment());
        $jacocoInit[36] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo9482b(String identifier, ExperimentModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        if (model.hasError()) {
            $jacocoInit[23] = true;
        } else {
            Experiment experiment = model.getExperiment();
            $jacocoInit[24] = true;
            if (experiment.isExpired()) {
                $jacocoInit[25] = true;
            } else {
                $jacocoInit[26] = true;
                if (this.localCache.containsKey(identifier)) {
                    $jacocoInit[27] = true;
                } else {
                    $jacocoInit[28] = true;
                    this.localCache.put(identifier, model);
                    $jacocoInit[29] = true;
                }
                C0120S c = C0120S.m652c(model.getExperiment());
                $jacocoInit[30] = true;
                return c;
            }
        }
        C0120S experiment2 = this.service.getExperiment(identifier);
        C1380a aVar = new C1380a(this, identifier);
        $jacocoInit[31] = true;
        C0120S f = experiment2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        $jacocoInit[32] = true;
        return f;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo9483c(String identifier, ExperimentModel experimentToCache) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = cacheExperiment(experimentToCache, identifier).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C1381b<Object,Object>(experimentToCache));
        $jacocoInit[33] = true;
        return f;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m6149b(ExperimentModel experimentToCache, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(experimentToCache.getExperiment());
        $jacocoInit[34] = true;
        return c;
    }

    public C0120S<Boolean> recordImpression(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.cacheValidator.isCacheValid(identifier)) {
            $jacocoInit[11] = true;
            C0120S<Boolean> recordImpression = this.service.recordImpression(identifier);
            $jacocoInit[12] = true;
            return recordImpression;
        }
        C0120S<Boolean> c = C0120S.m652c(Boolean.valueOf(false));
        $jacocoInit[13] = true;
        return c;
    }

    public C0120S<Boolean> recordAction(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.cacheValidator.isCacheValid(identifier)) {
            $jacocoInit[14] = true;
            C0120S<Boolean> f = getExperiment(identifier).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C1384e<Object,Object>(this, identifier));
            $jacocoInit[15] = true;
            return f;
        }
        C0120S<Boolean> c = C0120S.m652c(Boolean.valueOf(false));
        $jacocoInit[16] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo9480a(String identifier, Experiment experiment) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S recordAction = this.service.recordAction(identifier, experiment.getAssignment());
        $jacocoInit[22] = true;
        return recordAction;
    }

    public C0120S<Boolean> recordAction(String identifier, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> recordAction = recordAction(identifier);
        $jacocoInit[17] = true;
        return recordAction;
    }

    public C0120S<Void> cacheExperiment(ExperimentModel experiment, String experimentName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.localCache.put(experimentName, experiment);
        $jacocoInit[18] = true;
        this.persistence.save(experimentName, experiment.getExperiment());
        $jacocoInit[19] = true;
        C0120S<Void> c = C0120S.m652c(null);
        $jacocoInit[20] = true;
        return c;
    }

    public C0120S<String> getExperimentId(String id) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<String> c = C0120S.m652c(id);
        $jacocoInit[21] = true;
        return c;
    }
}
