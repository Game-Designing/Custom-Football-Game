package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.AdMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAdMapperFactory */
public final class ApplicationModule_ProvidesAdMapperFactory implements C13181b<AdMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3969232903984681074L, "cm/aptoide/pt/ApplicationModule_ProvidesAdMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAdMapperFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AdMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AdMapper providesAdMapper = applicationModule.providesAdMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAdMapper, "Cannot return null from a non-@Nullable @Provides method");
        AdMapper adMapper = providesAdMapper;
        $jacocoInit[3] = true;
        return adMapper;
    }

    public static C13181b<AdMapper> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAdMapperFactory applicationModule_ProvidesAdMapperFactory = new ApplicationModule_ProvidesAdMapperFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAdMapperFactory;
    }

    public static AdMapper proxyProvidesAdMapper(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AdMapper providesAdMapper = instance.providesAdMapper();
        $jacocoInit[5] = true;
        return providesAdMapper;
    }
}
