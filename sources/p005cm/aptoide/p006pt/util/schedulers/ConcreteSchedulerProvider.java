package p005cm.aptoide.p006pt.util.schedulers;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0126V;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.util.schedulers.ConcreteSchedulerProvider */
public class ConcreteSchedulerProvider implements SchedulerProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static ConcreteSchedulerProvider INSTANCE;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8765526556261266561L, "cm/aptoide/pt/util/schedulers/ConcreteSchedulerProvider", 8);
        $jacocoData = probes;
        return probes;
    }

    private ConcreteSchedulerProvider() {
        $jacocoInit()[0] = true;
    }

    public static synchronized ConcreteSchedulerProvider getInstance() {
        ConcreteSchedulerProvider concreteSchedulerProvider;
        synchronized (ConcreteSchedulerProvider.class) {
            boolean[] $jacocoInit = $jacocoInit();
            if (INSTANCE != null) {
                $jacocoInit[1] = true;
            } else {
                $jacocoInit[2] = true;
                INSTANCE = new ConcreteSchedulerProvider();
                $jacocoInit[3] = true;
            }
            concreteSchedulerProvider = INSTANCE;
            $jacocoInit[4] = true;
        }
        return concreteSchedulerProvider;
    }

    public C0126V computation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V computation = Schedulers.computation();
        $jacocoInit[5] = true;
        return computation;
    }

    /* renamed from: io */
    public C0126V mo16824io() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V io = Schedulers.m776io();
        $jacocoInit[6] = true;
        return io;
    }

    /* renamed from: ui */
    public C0126V mo16825ui() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V a = C14522a.m46170a();
        $jacocoInit[7] = true;
        return a;
    }
}
