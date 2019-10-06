package p005cm.aptoide.p006pt.billing.authorization;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingSyncScheduler;
import p005cm.aptoide.p006pt.billing.Customer;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.authorization.AuthorizationRepository */
public class AuthorizationRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationFactory authorizationFactory;
    private final AuthorizationPersistence authorizationPersistence;
    private final Customer customer;
    private final BillingSyncScheduler syncScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6064859420020233937L, "cm/aptoide/pt/billing/authorization/AuthorizationRepository", 18);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizationRepository(BillingSyncScheduler syncScheduler2, Customer customer2, AuthorizationPersistence authorizationPersistence2, AuthorizationFactory authorizationFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authorizationPersistence = authorizationPersistence2;
        this.syncScheduler = syncScheduler2;
        this.customer = customer2;
        this.authorizationFactory = authorizationFactory2;
        $jacocoInit[0] = true;
    }

    public C0120S<Authorization> getAuthorization(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2287d dVar = new C2287d(this, transactionId);
        $jacocoInit[1] = true;
        Single b = id.mo3695b((C0129b<? super T>) dVar);
        C2285b bVar = new C2285b(this, transactionId);
        $jacocoInit[2] = true;
        C0120S<Authorization> c = b.mo3697c(bVar);
        $jacocoInit[3] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11122a(String transactionId, String __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler.syncAuthorization(transactionId);
        $jacocoInit[17] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11123b(String transactionId, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S authorization = this.authorizationPersistence.getAuthorization(customerId, transactionId);
        $jacocoInit[16] = true;
        return authorization;
    }

    public C0117M updateAuthorization(String authorizationId, String metadata, Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2289f fVar = new C2289f(this, authorizationId, status, metadata);
        $jacocoInit[4] = true;
        Single a = id.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) fVar);
        $jacocoInit[5] = true;
        C0117M b = a.mo3692b();
        $jacocoInit[6] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11121a(String authorizationId, Status status, String metadata, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single updateAuthorization = this.authorizationPersistence.updateAuthorization(customerId, authorizationId, status, metadata);
        $jacocoInit[15] = true;
        return updateAuthorization;
    }

    public Single<Authorization> createAuthorization(String transactionId, Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2286c cVar = new C2286c(this, transactionId, status);
        $jacocoInit[7] = true;
        Single<Authorization> a = id.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) cVar);
        $jacocoInit[8] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11120a(String transactionId, Status status, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single createAuthorization = this.authorizationPersistence.createAuthorization(customerId, transactionId, status);
        $jacocoInit[14] = true;
        return createAuthorization;
    }

    public C0117M removeAuthorization(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2284a aVar = new C2284a(this, transactionId);
        $jacocoInit[9] = true;
        Single b = id.mo3695b((C0129b<? super T>) aVar);
        C2288e eVar = new C2288e(this, transactionId);
        $jacocoInit[10] = true;
        C0117M b2 = b.mo3693b((C0132p<? super T, ? extends C0117M>) eVar);
        $jacocoInit[11] = true;
        return b2;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11124c(String transactionId, String __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler.cancelAuthorizationSync(transactionId);
        $jacocoInit[13] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo11126d(String transactionId, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeAuthorizations = this.authorizationPersistence.removeAuthorizations(customerId, transactionId);
        $jacocoInit[12] = true;
        return removeAuthorizations;
    }
}
