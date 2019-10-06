package p005cm.aptoide.p006pt;

import com.facebook.p127a.C6638q;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAppEventsLoggerFactory */
public final class ApplicationModule_ProvideAppEventsLoggerFactory implements C13181b<C6638q> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5049913099783641948L, "cm/aptoide/pt/ApplicationModule_ProvideAppEventsLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAppEventsLoggerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public C6638q get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        C6638q provideAppEventsLogger = applicationModule.provideAppEventsLogger();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAppEventsLogger, "Cannot return null from a non-@Nullable @Provides method");
        C6638q qVar = provideAppEventsLogger;
        $jacocoInit[3] = true;
        return qVar;
    }

    public static C13181b<C6638q> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAppEventsLoggerFactory applicationModule_ProvideAppEventsLoggerFactory = new ApplicationModule_ProvideAppEventsLoggerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAppEventsLoggerFactory;
    }

    public static C6638q proxyProvideAppEventsLogger(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        C6638q provideAppEventsLogger = instance.provideAppEventsLogger();
        $jacocoInit[5] = true;
        return provideAppEventsLogger;
    }
}
