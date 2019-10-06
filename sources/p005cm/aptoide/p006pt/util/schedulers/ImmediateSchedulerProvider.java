package p005cm.aptoide.p006pt.util.schedulers;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0126V;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.util.schedulers.ImmediateSchedulerProvider */
public class ImmediateSchedulerProvider implements SchedulerProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1202279729731683625L, "cm/aptoide/pt/util/schedulers/ImmediateSchedulerProvider", 4);
        $jacocoData = probes;
        return probes;
    }

    public ImmediateSchedulerProvider() {
        $jacocoInit()[0] = true;
    }

    public C0126V computation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V immediate = Schedulers.immediate();
        $jacocoInit[1] = true;
        return immediate;
    }

    /* renamed from: io */
    public C0126V mo16824io() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V immediate = Schedulers.immediate();
        $jacocoInit[2] = true;
        return immediate;
    }

    /* renamed from: ui */
    public C0126V mo16825ui() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V immediate = Schedulers.immediate();
        $jacocoInit[3] = true;
        return immediate;
    }
}
