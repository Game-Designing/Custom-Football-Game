package p005cm.aptoide.p006pt.abtesting;

import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* renamed from: cm.aptoide.pt.abtesting.ABTestService */
public class ABTestService {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String EXPERIMENT_DRAFT = "EXPERIMENT_IN_DRAFT_STATE";
    private static final String EXPERIMENT_NOT_FOUND = "EXPERIMENT_NOT_FOUND";
    private static final String EXPERIMENT_OVER = "EXPERIMENT_EXPIRED";
    private static final String EXPERIMENT_PAUSED = "EXPERIMENT_PAUSED";
    private static final String IMPRESSION = "IMPRESSION";
    private IdsRepository idsRepository;
    private C0126V scheduler;
    private ServiceV7 service;

    /* renamed from: cm.aptoide.pt.abtesting.ABTestService$ServiceV7 */
    public interface ServiceV7 {
        @GET("assignments/applications/Android/experiments/{experimentName}/users/{aptoideId}")
        C0120S<ABTestImpressionResponse> getExperiment(@Path("experimentName") String str, @Path("aptoideId") String str2);

        @POST("events/applications/Android/experiments/{experimentName}/users/{aptoideId}")
        C0120S<Response<Void>> recordAction(@Path("experimentName") String str, @Path("aptoideId") String str2, @Body ABTestRequestBody aBTestRequestBody);

        @POST("events/applications/Android/experiments/{experimentName}/users/{aptoideId}")
        C0120S<Response<Void>> recordImpression(@Path("experimentName") String str, @Path("aptoideId") String str2, @Body ABTestRequestBody aBTestRequestBody);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6038358643370312042L, "cm/aptoide/pt/abtesting/ABTestService", 46);
        $jacocoData = probes;
        return probes;
    }

    public ABTestService(ServiceV7 service2, IdsRepository idsRepository2, C0126V scheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.idsRepository = idsRepository2;
        this.scheduler = scheduler2;
        $jacocoInit[0] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo9509a(String identifier, String aptoideId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S experiment = this.service.getExperiment(identifier, aptoideId);
        $jacocoInit[45] = true;
        return experiment;
    }

    public C0120S<ExperimentModel> getExperiment(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = getAptoideId().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C1398p<Object,Object>(this, identifier));
        C1400r rVar = new C1400r(this);
        $jacocoInit[1] = true;
        C0120S j = f.mo3669j(rVar);
        C1389g gVar = C1389g.f4289a;
        $jacocoInit[2] = true;
        C0120S<ExperimentModel> l = j.mo3674l(gVar);
        $jacocoInit[3] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ ExperimentModel mo9507a(ABTestImpressionResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        ExperimentModel mapToExperimentModel = mapToExperimentModel(response, false);
        $jacocoInit[44] = true;
        return mapToExperimentModel;
    }

    /* renamed from: a */
    static /* synthetic */ ExperimentModel m6154a(Throwable response) {
        boolean[] $jacocoInit = $jacocoInit();
        ExperimentModel experimentModel = new ExperimentModel(new Experiment(), true);
        $jacocoInit[43] = true;
        return experimentModel;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo9511b(String identifier, String aptoideId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S recordImpression = this.service.recordImpression(identifier, aptoideId, new ABTestRequestBody(IMPRESSION));
        $jacocoInit[42] = true;
        return recordImpression;
    }

    public C0120S<Boolean> recordImpression(String identifier) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = getAptoideId().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C1391i<Object,Object>(this, identifier));
        C1390h hVar = new C1390h(this);
        $jacocoInit[4] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) hVar);
        C1395m mVar = C1395m.f4296a;
        $jacocoInit[5] = true;
        C0120S a = b.mo3621a((C0129b<? super Throwable>) mVar);
        C1399q qVar = C1399q.f4303a;
        $jacocoInit[6] = true;
        C0120S<Boolean> j = a.mo3669j(qVar);
        $jacocoInit[7] = true;
        return j;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9513c(Response voidResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[38] = true;
        Class cls = getClass();
        $jacocoInit[39] = true;
        String name = cls.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("response : ");
        sb.append(voidResponse.isSuccessful());
        String sb2 = sb.toString();
        $jacocoInit[40] = true;
        instance.mo2136d(name, sb2);
        $jacocoInit[41] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6157c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[37] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m6158d(Response __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(true);
        $jacocoInit[36] = true;
        return valueOf;
    }

    public C0120S<Boolean> recordAction(String identifier, String assignment) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = getAptoideId().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C1396n<Object,Object>(this, identifier, assignment));
        C1392j jVar = new C1392j(this);
        $jacocoInit[8] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) jVar);
        C1397o oVar = C1397o.f4300a;
        $jacocoInit[9] = true;
        C0120S a = b.mo3621a((C0129b<? super Throwable>) oVar);
        C1393k kVar = C1393k.f4294a;
        $jacocoInit[10] = true;
        C0120S<Boolean> j = a.mo3669j(kVar);
        $jacocoInit[11] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo9510a(String identifier, String assignment, String aptoideId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S recordAction = this.service.recordAction(identifier, aptoideId, new ABTestRequestBody(assignment));
        $jacocoInit[35] = true;
        return recordAction;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9512b(Response voidResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[31] = true;
        Class cls = getClass();
        $jacocoInit[32] = true;
        String name = cls.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("response : ");
        sb.append(voidResponse.isSuccessful());
        String sb2 = sb.toString();
        $jacocoInit[33] = true;
        instance.mo2136d(name, sb2);
        $jacocoInit[34] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6156b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[30] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6155a(Response __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(true);
        $jacocoInit[29] = true;
        return valueOf;
    }

    private ExperimentModel mapToExperimentModel(ABTestImpressionResponse response, boolean hasError) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[12] = true;
        long currentTimeMillis = System.currentTimeMillis();
        String payload = response.getPayload();
        String assignment = response.getAssignment();
        $jacocoInit[13] = true;
        Experiment experiment = new Experiment(currentTimeMillis, payload, assignment, mapExperimentStatus(response));
        ExperimentModel experimentModel = new ExperimentModel(experiment, hasError);
        $jacocoInit[14] = true;
        return experimentModel;
    }

    private boolean mapExperimentStatus(ABTestImpressionResponse response) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String status = response.getStatus();
        $jacocoInit[15] = true;
        if (status.equals(EXPERIMENT_OVER)) {
            $jacocoInit[16] = true;
        } else {
            String status2 = response.getStatus();
            $jacocoInit[17] = true;
            if (status2.equals(EXPERIMENT_PAUSED)) {
                $jacocoInit[18] = true;
            } else {
                String status3 = response.getStatus();
                $jacocoInit[19] = true;
                if (status3.equals(EXPERIMENT_NOT_FOUND)) {
                    $jacocoInit[20] = true;
                } else {
                    String status4 = response.getStatus();
                    $jacocoInit[21] = true;
                    if (status4.equals(EXPERIMENT_DRAFT)) {
                        $jacocoInit[22] = true;
                    } else {
                        z = false;
                        $jacocoInit[24] = true;
                        $jacocoInit[25] = true;
                        return z;
                    }
                }
            }
        }
        $jacocoInit[23] = true;
        z = true;
        $jacocoInit[25] = true;
        return z;
    }

    private C0120S<String> getAptoideId() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m633a((Callable<? extends T>) new C1394l<Object>(this));
        C0126V v = this.scheduler;
        $jacocoInit[26] = true;
        C0120S<String> b = a.mo3634b(v);
        $jacocoInit[27] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ String mo9508a() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        String uniqueIdentifier = this.idsRepository.getUniqueIdentifier();
        $jacocoInit[28] = true;
        return uniqueIdentifier;
    }
}
