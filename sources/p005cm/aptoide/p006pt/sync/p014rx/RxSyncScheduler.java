package p005cm.aptoide.p006pt.sync.p014rx;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.CrashLogger;
import p005cm.aptoide.p006pt.sync.Sync;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.sync.rx.RxSyncScheduler */
public class RxSyncScheduler implements SyncScheduler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final CrashLogger consoleLogger;
    private final Map<String, C0137ja> subscriptionStorage;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8093968207709526164L, "cm/aptoide/pt/sync/rx/RxSyncScheduler", 33);
        $jacocoData = probes;
        return probes;
    }

    public RxSyncScheduler(Map<String, C0137ja> subscriptionStorage2, CrashLogger consoleLogger2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.subscriptionStorage = subscriptionStorage2;
        this.consoleLogger = consoleLogger2;
        $jacocoInit[0] = true;
    }

    public synchronized void schedule(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (sync.isPeriodic()) {
            $jacocoInit[1] = true;
            schedulePeriodicSync(sync);
            $jacocoInit[2] = true;
        } else {
            scheduleOneOffSync(sync);
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }

    public synchronized void cancel(String syncId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0137ja subscription = (C0137ja) this.subscriptionStorage.remove(syncId);
        if (subscription == null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            subscription.unsubscribe();
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    public synchronized void reschedule(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isSyncScheduled(sync.getId())) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            cancel(sync.getId());
            $jacocoInit[11] = true;
            schedule(sync);
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
    }

    private void scheduleOneOffSync(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, C0137ja> map = this.subscriptionStorage;
        String id = sync.getId();
        C0117M execute = sync.execute();
        C5109e eVar = new C5109e(this, sync);
        C5105a aVar = new C5105a(this);
        $jacocoInit[14] = true;
        C0137ja a = execute.mo3588a((C0128a) eVar, (C0129b<? super Throwable>) aVar);
        $jacocoInit[15] = true;
        map.put(id, a);
        $jacocoInit[16] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2363a(Sync sync) {
        C0137ja jaVar = (C0137ja) this.subscriptionStorage.remove(sync.getId());
        $jacocoInit()[32] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo2365b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.consoleLogger.log(throwable);
        $jacocoInit[31] = true;
    }

    private void schedulePeriodicSync(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isSyncScheduled(sync.getId())) {
            $jacocoInit[17] = true;
            return;
        }
        Map<String, C0137ja> map = this.subscriptionStorage;
        String id = sync.getId();
        $jacocoInit[18] = true;
        C0120S a = C0120S.m627a(sync.getTrigger(), sync.getInterval(), TimeUnit.MILLISECONDS);
        C5107c cVar = new C5107c(this, sync);
        $jacocoInit[19] = true;
        C0120S n = a.mo3677n(cVar);
        C5106b bVar = C5106b.f8832a;
        C5110f fVar = C5110f.f8838a;
        $jacocoInit[20] = true;
        C0137ja a2 = n.mo3626a((C0129b<? super T>) bVar, (C0129b<Throwable>) fVar);
        $jacocoInit[21] = true;
        map.put(id, a2);
        $jacocoInit[22] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2362a(Sync sync, Long __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M execute = sync.execute();
        C5108d dVar = new C5108d(this);
        $jacocoInit[26] = true;
        C0117M a = execute.mo3583a((C0129b<? super Throwable>) dVar);
        $jacocoInit[27] = true;
        C0117M d = a.mo3602d();
        $jacocoInit[28] = true;
        C0120S f = d.mo3604f();
        $jacocoInit[29] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2364a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.consoleLogger.log(throwable);
        $jacocoInit[30] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m501a(Object __) {
        $jacocoInit()[25] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m502c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[24] = true;
        throw onErrorNotImplementedException;
    }

    private boolean isSyncScheduled(String syncId) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean containsKey = this.subscriptionStorage.containsKey(syncId);
        $jacocoInit[23] = true;
        return containsKey;
    }
}
