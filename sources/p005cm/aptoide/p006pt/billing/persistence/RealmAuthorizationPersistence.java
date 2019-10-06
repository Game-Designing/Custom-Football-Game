package p005cm.aptoide.p006pt.billing.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationFactory;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationPersistence;
import p005cm.aptoide.p006pt.billing.authorization.LocalIdGenerator;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p019d.p022i.p023b.C0100e;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.RealmAuthorizationPersistence */
public class RealmAuthorizationPersistence implements AuthorizationPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationFactory authorizationFactory;
    private final RealmAuthorizationMapper authorizationMapper;
    private final C0100e<List<Authorization>> authorizationRelay;
    private final Map<String, Authorization> authorizations;
    private final Database database;
    private final LocalIdGenerator idGenerator;
    private final C0126V scheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7472972630099150733L, "cm/aptoide/pt/billing/persistence/RealmAuthorizationPersistence", 109);
        $jacocoData = probes;
        return probes;
    }

    public RealmAuthorizationPersistence(Map<String, Authorization> authorizations2, C0100e<List<Authorization>> authorizationRelay2, Database database2, RealmAuthorizationMapper authorizationMapper2, C0126V scheduler2, AuthorizationFactory authorizationFactory2, LocalIdGenerator idGenerator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authorizations = authorizations2;
        this.authorizationRelay = authorizationRelay2;
        this.database = database2;
        this.authorizationMapper = authorizationMapper2;
        this.scheduler = scheduler2;
        this.authorizationFactory = authorizationFactory2;
        this.idGenerator = idGenerator2;
        $jacocoInit[0] = true;
    }

    public C0117M saveAuthorization(Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2361j(this, authorization));
        C0126V v = this.scheduler;
        $jacocoInit[1] = true;
        C0117M b = c.mo3593b(v);
        $jacocoInit[2] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11222b(Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        if (authorization.isPendingSync()) {
            $jacocoInit[105] = true;
            this.database.insert(this.authorizationMapper.map(authorization));
            $jacocoInit[106] = true;
        } else {
            this.authorizations.put(authorization.getId(), authorization);
            $jacocoInit[107] = true;
        }
        this.authorizationRelay.call(getAuthorizations());
        $jacocoInit[108] = true;
    }

    public C0120S<Authorization> getAuthorization(String customerId, String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S e = this.authorizationRelay.mo3656e(getAuthorizations());
        C2364m mVar = new C2364m(customerId, transactionId);
        $jacocoInit[3] = true;
        C0120S f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mVar);
        C0126V v = this.scheduler;
        $jacocoInit[4] = true;
        C0120S<Authorization> b = f.mo3634b(v);
        $jacocoInit[5] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7031a(String customerId, String transactionId, List authorizations2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) authorizations2);
        C2366o oVar = new C2366o(customerId, transactionId);
        $jacocoInit[96] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) oVar);
        $jacocoInit[97] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7028a(String customerId, String transactionId, Authorization authorization) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String customerId2 = authorization.getCustomerId();
        $jacocoInit[98] = true;
        if (!customerId2.equals(customerId)) {
            $jacocoInit[99] = true;
        } else {
            String transactionId2 = authorization.getTransactionId();
            $jacocoInit[100] = true;
            if (!transactionId2.equals(transactionId)) {
                $jacocoInit[101] = true;
            } else {
                $jacocoInit[102] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[104] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[103] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[104] = true;
        return valueOf2;
    }

    public Single<Authorization> updateAuthorization(String customerId, String authorizationId, Status status, String metadata) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) getAuthorizations());
        C2359h hVar = new C2359h(customerId, authorizationId);
        $jacocoInit[6] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) hVar);
        $jacocoInit[7] = true;
        C0120S d2 = d.mo3647d();
        $jacocoInit[8] = true;
        Single n = d2.mo3678n();
        C2360i iVar = new C2360i(this, status, metadata);
        $jacocoInit[9] = true;
        Single<Authorization> a2 = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) iVar);
        $jacocoInit[10] = true;
        return a2;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7033c(String customerId, String authorizationId, Authorization authorization) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String customerId2 = authorization.getCustomerId();
        $jacocoInit[89] = true;
        if (!customerId2.equals(customerId)) {
            $jacocoInit[90] = true;
        } else {
            String id = authorization.getId();
            $jacocoInit[91] = true;
            if (!id.equals(authorizationId)) {
                $jacocoInit[92] = true;
            } else {
                $jacocoInit[93] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[95] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[94] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[95] = true;
        return valueOf2;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11219a(Status status, String metadata, Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
        $jacocoInit[83] = true;
        String id = authorization.getId();
        String customerId = authorization.getCustomerId();
        AuthorizationFactory authorizationFactory3 = this.authorizationFactory;
        $jacocoInit[84] = true;
        String type = authorizationFactory3.getType(authorization);
        $jacocoInit[85] = true;
        String transactionId = authorization.getTransactionId();
        $jacocoInit[86] = true;
        Authorization updatedAuthorization = authorizationFactory2.create(id, customerId, type, status, null, null, metadata, null, null, transactionId, null);
        $jacocoInit[87] = true;
        Single a = saveAuthorization(updatedAuthorization).mo3587a(Single.m734a(updatedAuthorization));
        $jacocoInit[88] = true;
        return a;
    }

    public Single<Authorization> createAuthorization(String customerId, String transactionId, Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
        LocalIdGenerator localIdGenerator = this.idGenerator;
        $jacocoInit[11] = true;
        Authorization authorization = authorizationFactory2.create(localIdGenerator.generate(), customerId, null, status, null, null, null, null, null, transactionId, null);
        $jacocoInit[12] = true;
        Single<Authorization> a = saveAuthorization(authorization).mo3587a(Single.m734a(authorization));
        $jacocoInit[13] = true;
        return a;
    }

    public C0117M removeAuthorizations(String customerId, String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) getAuthorizations());
        C2362k kVar = new C2362k(customerId, transactionId);
        $jacocoInit[14] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) kVar);
        C2357f fVar = C2357f.f5501a;
        $jacocoInit[15] = true;
        C0120S j = d.mo3669j(fVar);
        $jacocoInit[16] = true;
        C0120S m = j.mo3675m();
        C2365n nVar = C2365n.f5516a;
        $jacocoInit[17] = true;
        C0120S h = m.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) nVar);
        C2363l lVar = new C2363l(this);
        $jacocoInit[18] = true;
        C0120S g = h.mo3663g((C0132p<? super T, ? extends C0117M>) lVar);
        $jacocoInit[19] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[20] = true;
        return l;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7032b(String customerId, String transactionId, Authorization authorization) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String customerId2 = authorization.getCustomerId();
        $jacocoInit[76] = true;
        if (!customerId2.equals(customerId)) {
            $jacocoInit[77] = true;
        } else {
            String transactionId2 = authorization.getTransactionId();
            $jacocoInit[78] = true;
            if (!transactionId2.equals(transactionId)) {
                $jacocoInit[79] = true;
            } else {
                $jacocoInit[80] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[82] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[81] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[82] = true;
        return valueOf2;
    }

    /* renamed from: a */
    static /* synthetic */ String m7030a(Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        String id = authorization.getId();
        $jacocoInit[75] = true;
        return id;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m7029a(List ids) {
        $jacocoInit()[74] = true;
        return ids;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo11221b(String id) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeAuthorization = removeAuthorization(id);
        $jacocoInit[73] = true;
        return removeAuthorization;
    }

    private C0117M removeAuthorization(String authorizationId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2358g(this, authorizationId));
        $jacocoInit[21] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11220a(String authorizationId) {
        boolean[] $jacocoInit = $jacocoInit();
        removeLocalAuthorization(authorizationId);
        $jacocoInit[71] = true;
        this.authorizations.remove(authorizationId);
        $jacocoInit[72] = true;
    }

    private List<Authorization> getAuthorizations() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Authorization> resolvedAuthorizations = new HashMap<>(this.authorizations);
        $jacocoInit[22] = true;
        $jacocoInit[23] = true;
        for (Authorization localAuthorization : getLocalAuthorization()) {
            $jacocoInit[24] = true;
            String id = localAuthorization.getId();
            Map<String, Authorization> map = this.authorizations;
            $jacocoInit[25] = true;
            Authorization resolveAuthorization = resolveAuthorization((Authorization) map.get(localAuthorization.getId()), localAuthorization);
            $jacocoInit[26] = true;
            resolvedAuthorizations.put(id, resolveAuthorization);
            $jacocoInit[27] = true;
        }
        ArrayList arrayList = new ArrayList(resolvedAuthorizations.values());
        $jacocoInit[28] = true;
        return arrayList;
    }

    private Authorization resolveAuthorization(Authorization authorization, Authorization localAuthorization) {
        boolean[] $jacocoInit = $jacocoInit();
        if (authorization == null) {
            $jacocoInit[29] = true;
            return localAuthorization;
        }
        if (localAuthorization == null) {
            $jacocoInit[30] = true;
        } else {
            $jacocoInit[31] = true;
            if (authorization.isProcessing()) {
                $jacocoInit[32] = true;
            } else {
                $jacocoInit[33] = true;
                if (authorization.isActive()) {
                    $jacocoInit[34] = true;
                } else {
                    $jacocoInit[35] = true;
                    if (authorization.isFailed()) {
                        $jacocoInit[36] = true;
                    } else {
                        $jacocoInit[38] = true;
                        return localAuthorization;
                    }
                }
            }
        }
        $jacocoInit[37] = true;
        return authorization;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeLocalAuthorization(java.lang.String r7) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.database.accessors.Database r1 = r6.database
            io.realm.F r1 = r1.get()
            r2 = 39
            r3 = 1
            r0[r2] = r3     // Catch:{ all -> 0x0061 }
            java.lang.Class<cm.aptoide.pt.database.realm.RealmAuthorization> r2 = p005cm.aptoide.p006pt.database.realm.RealmAuthorization.class
            io.realm.ca r2 = r1.mo43540c(r2)     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "id"
            r5 = 40
            r0[r5] = r3     // Catch:{ all -> 0x005f }
            r2.mo43671a(r4, r7)     // Catch:{ all -> 0x005f }
            r4 = 41
            r0[r4] = r3     // Catch:{ all -> 0x005f }
            io.realm.Y r2 = r2.mo43682c()     // Catch:{ all -> 0x005f }
            cm.aptoide.pt.database.realm.RealmAuthorization r2 = (p005cm.aptoide.p006pt.database.realm.RealmAuthorization) r2     // Catch:{ all -> 0x005f }
            if (r2 != 0) goto L_0x002f
            r4 = 42
            r0[r4] = r3     // Catch:{ all -> 0x005f }
            goto L_0x0048
        L_0x002f:
            r4 = 43
            r0[r4] = r3     // Catch:{ all -> 0x005f }
            r1.mo43533a()     // Catch:{ all -> 0x005f }
            r4 = 44
            r0[r4] = r3     // Catch:{ all -> 0x005f }
            r2.deleteFromRealm()     // Catch:{ all -> 0x005f }
            r4 = 45
            r0[r4] = r3     // Catch:{ all -> 0x005f }
            r1.mo43543g()     // Catch:{ all -> 0x005f }
            r4 = 46
            r0[r4] = r3     // Catch:{ all -> 0x005f }
        L_0x0048:
            if (r1 != 0) goto L_0x004f
            r2 = 47
            r0[r2] = r3
            goto L_0x005a
        L_0x004f:
            r2 = 48
            r0[r2] = r3
            r1.close()
            r2 = 49
            r0[r2] = r3
        L_0x005a:
            r2 = 54
            r0[r2] = r3
            return
        L_0x005f:
            r2 = move-exception
            goto L_0x0062
        L_0x0061:
            r2 = move-exception
        L_0x0062:
            if (r1 != 0) goto L_0x0069
            r4 = 50
            r0[r4] = r3
            goto L_0x0074
        L_0x0069:
            r4 = 51
            r0[r4] = r3
            r1.close()
            r4 = 52
            r0[r4] = r3
        L_0x0074:
            r4 = 53
            r0[r4] = r3
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.persistence.RealmAuthorizationPersistence.removeLocalAuthorization(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<p005cm.aptoide.p006pt.billing.authorization.Authorization> getLocalAuthorization() {
        /*
            r8 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.database.accessors.Database r1 = r8.database
            io.realm.F r1 = r1.get()
            r2 = 55
            r3 = 1
            r0[r2] = r3     // Catch:{ all -> 0x0073 }
            java.lang.Class<cm.aptoide.pt.database.realm.RealmAuthorization> r2 = p005cm.aptoide.p006pt.database.realm.RealmAuthorization.class
            r4 = 56
            r0[r4] = r3     // Catch:{ all -> 0x0071 }
            io.realm.ca r2 = r1.mo43540c(r2)     // Catch:{ all -> 0x0071 }
            r4 = 57
            r0[r4] = r3     // Catch:{ all -> 0x0071 }
            io.realm.da r2 = r2.mo43681b()     // Catch:{ all -> 0x0071 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0071 }
            r5 = 58
            r0[r5] = r3     // Catch:{ all -> 0x0071 }
            int r5 = r2.size()     // Catch:{ all -> 0x0071 }
            r4.<init>(r5)     // Catch:{ all -> 0x0071 }
            r5 = 59
            r0[r5] = r3     // Catch:{ all -> 0x0071 }
            java.util.Iterator r5 = r2.iterator()     // Catch:{ all -> 0x0071 }
            r6 = 60
            r0[r6] = r3     // Catch:{ all -> 0x0071 }
        L_0x003a:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0071 }
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0071 }
            cm.aptoide.pt.database.realm.RealmAuthorization r6 = (p005cm.aptoide.p006pt.database.realm.RealmAuthorization) r6     // Catch:{ all -> 0x0071 }
            r7 = 61
            r0[r7] = r3     // Catch:{ all -> 0x0071 }
            cm.aptoide.pt.billing.persistence.RealmAuthorizationMapper r7 = r8.authorizationMapper     // Catch:{ all -> 0x0071 }
            cm.aptoide.pt.billing.authorization.Authorization r7 = r7.map(r6)     // Catch:{ all -> 0x0071 }
            r4.add(r7)     // Catch:{ all -> 0x0071 }
            r6 = 62
            r0[r6] = r3     // Catch:{ all -> 0x0071 }
            goto L_0x003a
        L_0x0059:
            if (r1 != 0) goto L_0x0061
            r5 = 63
            r0[r5] = r3
            goto L_0x006c
        L_0x0061:
            r5 = 64
            r0[r5] = r3
            r1.close()
            r5 = 65
            r0[r5] = r3
        L_0x006c:
            r5 = 66
            r0[r5] = r3
            return r4
        L_0x0071:
            r2 = move-exception
            goto L_0x0074
        L_0x0073:
            r2 = move-exception
        L_0x0074:
            if (r1 != 0) goto L_0x007b
            r4 = 67
            r0[r4] = r3
            goto L_0x0086
        L_0x007b:
            r4 = 68
            r0[r4] = r3
            r1.close()
            r4 = 69
            r0[r4] = r3
        L_0x0086:
            r4 = 70
            r0[r4] = r3
            goto L_0x008c
        L_0x008b:
            throw r2
        L_0x008c:
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.persistence.RealmAuthorizationPersistence.getLocalAuthorization():java.util.List");
    }
}
