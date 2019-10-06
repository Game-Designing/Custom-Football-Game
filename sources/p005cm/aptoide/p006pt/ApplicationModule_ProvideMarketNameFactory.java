package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideMarketNameFactory */
public final class ApplicationModule_ProvideMarketNameFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5607821971930673599L, "cm/aptoide/pt/ApplicationModule_ProvideMarketNameFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideMarketNameFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String provideMarketName = applicationModule.provideMarketName();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideMarketName, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideMarketName;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideMarketNameFactory applicationModule_ProvideMarketNameFactory = new ApplicationModule_ProvideMarketNameFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideMarketNameFactory;
    }

    public static String proxyProvideMarketName(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideMarketName = instance.provideMarketName();
        $jacocoInit[5] = true;
        return provideMarketName;
    }
}
