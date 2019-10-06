package p005cm.aptoide.p006pt.analytics.analytics;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.EventsPersistence;
import p005cm.aptoide.analytics.implementation.data.Event;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.realm.RealmEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C14502N;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.analytics.analytics.RealmEventPersistence */
public class RealmEventPersistence implements EventsPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Database database;
    private final RealmEventMapper mapper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2501650396662913963L, "cm/aptoide/pt/analytics/analytics/RealmEventPersistence", 28);
        $jacocoData = probes;
        return probes;
    }

    public RealmEventPersistence(Database database2, RealmEventMapper mapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.database = database2;
        this.mapper = mapper2;
        $jacocoInit[0] = true;
    }

    public C0117M save(Event event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m598c((C0129b<C14502N>) new C1683d<C14502N>(this, event));
        $jacocoInit[1] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10068a(Event event, C14502N completableEmitter) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            this.database.insert(this.mapper.map(event));
            $jacocoInit[23] = true;
            completableEmitter.onCompleted();
            $jacocoInit[24] = true;
        } catch (JsonProcessingException e) {
            $jacocoInit[25] = true;
            completableEmitter.onError(e);
            $jacocoInit[26] = true;
        }
        $jacocoInit[27] = true;
    }

    public C0117M save(List<Event> events) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) events);
        C1681b bVar = new C1681b(this);
        $jacocoInit[2] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) bVar);
        $jacocoInit[3] = true;
        C0120S m = g.mo3675m();
        $jacocoInit[4] = true;
        C0117M l = m.mo3673l();
        $jacocoInit[5] = true;
        return l;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo10070b(Event event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = save(event);
        $jacocoInit[22] = true;
        return save;
    }

    public C0120S<List<Event>> getAll() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.database.getAll(RealmEvent.class);
        C1685f fVar = new C1685f(this);
        $jacocoInit[6] = true;
        C0120S<List<Event>> f = all.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
        $jacocoInit[7] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10067a(List realmEvents) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            C0120S c = C0120S.m652c(this.mapper.map(realmEvents));
            $jacocoInit[19] = true;
            return c;
        } catch (IOException e) {
            $jacocoInit[20] = true;
            C0120S a = C0120S.m631a((Throwable) e);
            $jacocoInit[21] = true;
            return a;
        }
    }

    public C0117M remove(List<Event> events) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) events);
        C1684e eVar = new C1684e(this);
        $jacocoInit[8] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eVar);
        C1682c cVar = new C1682c(this);
        $jacocoInit[9] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) cVar);
        $jacocoInit[10] = true;
        C0120S m = b.mo3675m();
        $jacocoInit[11] = true;
        C0117M l = m.mo3673l();
        $jacocoInit[12] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10066a(Event event) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            C0120S c = C0120S.m652c(this.mapper.map(event));
            $jacocoInit[16] = true;
            return c;
        } catch (JsonProcessingException e) {
            $jacocoInit[17] = true;
            C0120S a = C0120S.m631a((Throwable) e);
            $jacocoInit[18] = true;
            return a;
        }
    }

    /* renamed from: a */
    public /* synthetic */ void mo10069a(RealmEvent realmEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = RealmEvent.PRIMARY_KEY_NAME;
        $jacocoInit[13] = true;
        Long valueOf = Long.valueOf(realmEvent.getTimestamp());
        $jacocoInit[14] = true;
        this.database.delete(RealmEvent.class, str, valueOf);
        $jacocoInit[15] = true;
    }
}
