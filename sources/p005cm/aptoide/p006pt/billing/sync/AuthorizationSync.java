package p005cm.aptoide.p006pt.billing.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Customer;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationPersistence;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationService;
import p005cm.aptoide.p006pt.billing.authorization.LocalIdGenerator;
import p005cm.aptoide.p006pt.billing.authorization.MetadataAuthorization;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.sync.AuthorizationSync */
public class AuthorizationSync extends Sync {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationPersistence authorizationPersistence;
    private final AuthorizationService authorizationService;
    private final Customer customer;
    private final LocalIdGenerator idGenerator;
    private final String transactionId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4486230276781280067L, "cm/aptoide/pt/billing/sync/AuthorizationSync", 25);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizationSync(String id, Customer customer2, String transactionId2, AuthorizationService authorizationService2, AuthorizationPersistence authorizationPersistence2, boolean periodic, boolean exact, long interval, long trigger, LocalIdGenerator idGenerator2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, periodic, exact, trigger, interval);
        this.transactionId = transactionId2;
        this.customer = customer2;
        this.authorizationService = authorizationService2;
        this.authorizationPersistence = authorizationPersistence2;
        this.idGenerator = idGenerator2;
        $jacocoInit[0] = true;
    }

    public C0117M execute() {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2373d dVar = new C2373d(this);
        $jacocoInit[1] = true;
        C0117M b = id.mo3693b((C0132p<? super T, ? extends C0117M>) dVar);
        $jacocoInit[2] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11240a(String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M d = syncRemoteAuthorization(customerId, this.transactionId).mo3602d();
        String str = this.transactionId;
        $jacocoInit[23] = true;
        C0117M a = d.mo3580a(syncMetadataAuthorization(customerId, str));
        $jacocoInit[24] = true;
        return a;
    }

    private C0117M syncMetadataAuthorization(String customerId, String transactionId2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S authorization = this.authorizationPersistence.getAuthorization(customerId, transactionId2);
        $jacocoInit[3] = true;
        C0120S d = authorization.mo3647d();
        C2375f fVar = C2375f.f5529a;
        $jacocoInit[4] = true;
        $jacocoInit[5] = true;
        C0120S a = d.mo3653d((C0132p<? super T, Boolean>) fVar).mo3611a(MetadataAuthorization.class);
        C2371b bVar = C2371b.f5525a;
        $jacocoInit[6] = true;
        C0120S d2 = a.mo3653d((C0132p<? super T, Boolean>) bVar);
        C2370a aVar = new C2370a(this, customerId);
        $jacocoInit[7] = true;
        C0120S i = d2.mo3668i(aVar);
        C2374e eVar = new C2374e(this);
        $jacocoInit[8] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) eVar);
        $jacocoInit[9] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[10] = true;
        return l;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7038a(Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(authorization instanceof MetadataAuthorization);
        $jacocoInit[22] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7039a(MetadataAuthorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(authorization.isPendingSync());
        $jacocoInit[21] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11241a(String customerId, MetadataAuthorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizationService authorizationService2 = this.authorizationService;
        $jacocoInit[18] = true;
        String transactionId2 = authorization.getTransactionId();
        String metadata = authorization.getMetadata();
        $jacocoInit[19] = true;
        Single updateAuthorization = authorizationService2.updateAuthorization(customerId, transactionId2, metadata);
        $jacocoInit[20] = true;
        return updateAuthorization;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo11242b(Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M saveAuthorization = this.authorizationPersistence.saveAuthorization(authorization);
        $jacocoInit[17] = true;
        return saveAuthorization;
    }

    private C0117M syncRemoteAuthorization(String customerId, String transactionId2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.idGenerator.isLocal(transactionId2)) {
            $jacocoInit[11] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[12] = true;
            return b;
        }
        Single authorization = this.authorizationService.getAuthorization(transactionId2, customerId);
        C2372c cVar = new C2372c(this);
        $jacocoInit[13] = true;
        C0117M b2 = authorization.mo3693b((C0132p<? super T, ? extends C0117M>) cVar);
        $jacocoInit[14] = true;
        return b2;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo11243c(Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M saveAuthorization = this.authorizationPersistence.saveAuthorization(authorization);
        $jacocoInit[16] = true;
        return saveAuthorization;
    }

    public String getTransactionId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.transactionId;
        $jacocoInit[15] = true;
        return str;
    }
}
