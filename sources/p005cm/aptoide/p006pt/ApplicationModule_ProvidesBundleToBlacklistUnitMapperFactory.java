package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.blacklist.BlacklistUnitMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory */
public final class ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory implements C13181b<BlacklistUnitMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4710024261278427244L, "cm/aptoide/pt/ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public BlacklistUnitMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        BlacklistUnitMapper providesBundleToBlacklistUnitMapper = applicationModule.providesBundleToBlacklistUnitMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBundleToBlacklistUnitMapper, "Cannot return null from a non-@Nullable @Provides method");
        BlacklistUnitMapper blacklistUnitMapper = providesBundleToBlacklistUnitMapper;
        $jacocoInit[3] = true;
        return blacklistUnitMapper;
    }

    public static C13181b<BlacklistUnitMapper> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory applicationModule_ProvidesBundleToBlacklistUnitMapperFactory = new ApplicationModule_ProvidesBundleToBlacklistUnitMapperFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesBundleToBlacklistUnitMapperFactory;
    }

    public static BlacklistUnitMapper proxyProvidesBundleToBlacklistUnitMapper(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistUnitMapper providesBundleToBlacklistUnitMapper = instance.providesBundleToBlacklistUnitMapper();
        $jacocoInit[5] = true;
        return providesBundleToBlacklistUnitMapper;
    }
}
