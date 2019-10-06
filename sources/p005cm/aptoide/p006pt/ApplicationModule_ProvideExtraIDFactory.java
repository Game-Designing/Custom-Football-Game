package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideExtraIDFactory */
public final class ApplicationModule_ProvideExtraIDFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3608705353305483903L, "cm/aptoide/pt/ApplicationModule_ProvideExtraIDFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideExtraIDFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String provideExtraID = applicationModule.provideExtraID();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideExtraID, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideExtraID;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideExtraIDFactory applicationModule_ProvideExtraIDFactory = new ApplicationModule_ProvideExtraIDFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideExtraIDFactory;
    }

    public static String proxyProvideExtraID(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideExtraID = instance.provideExtraID();
        $jacocoInit[5] = true;
        return provideExtraID;
    }
}
