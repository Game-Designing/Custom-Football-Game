package p005cm.aptoide.p006pt.sync.alarm;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0117M;

/* renamed from: cm.aptoide.pt.sync.alarm.OneOffSyncWrapper */
public class OneOffSyncWrapper extends Sync {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Sync sync;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3095384954702255160L, "cm/aptoide/pt/sync/alarm/OneOffSyncWrapper", 2);
        $jacocoData = probes;
        return probes;
    }

    public OneOffSyncWrapper(Sync sync2, long trigger) {
        boolean[] $jacocoInit = $jacocoInit();
        super(sync2.getId(), sync2.isPeriodic(), sync2.isExact(), trigger, 0);
        this.sync = sync2;
        $jacocoInit[0] = true;
    }

    public C0117M execute() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M execute = this.sync.execute();
        $jacocoInit[1] = true;
        return execute;
    }
}
