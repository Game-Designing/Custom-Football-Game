package p005cm.aptoide.p006pt.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0117M;

/* renamed from: cm.aptoide.pt.sync.Sync */
public abstract class Sync {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final boolean exact;

    /* renamed from: id */
    private final String f8824id;
    private final long interval;
    private final boolean periodic;
    private final long trigger;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8306718046519130447L, "cm/aptoide/pt/sync/Sync", 6);
        $jacocoData = probes;
        return probes;
    }

    public abstract C0117M execute();

    public Sync(String id, boolean periodic2, boolean exact2, long trigger2, long interval2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f8824id = id;
        this.periodic = periodic2;
        this.exact = exact2;
        this.trigger = trigger2;
        this.interval = interval2;
        $jacocoInit[0] = true;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f8824id;
        $jacocoInit[1] = true;
        return str;
    }

    public boolean isPeriodic() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.periodic;
        $jacocoInit[2] = true;
        return z;
    }

    public boolean isExact() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.exact;
        $jacocoInit[3] = true;
        return z;
    }

    public long getTrigger() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.trigger;
        $jacocoInit[4] = true;
        return j;
    }

    public long getInterval() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.interval;
        $jacocoInit[5] = true;
        return j;
    }
}
