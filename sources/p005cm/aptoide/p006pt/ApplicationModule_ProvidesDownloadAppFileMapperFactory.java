package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppFileMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDownloadAppFileMapperFactory */
public final class ApplicationModule_ProvidesDownloadAppFileMapperFactory implements C13181b<DownloadAppFileMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8255359226989448609L, "cm/aptoide/pt/ApplicationModule_ProvidesDownloadAppFileMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDownloadAppFileMapperFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public DownloadAppFileMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        DownloadAppFileMapper providesDownloadAppFileMapper = applicationModule.providesDownloadAppFileMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesDownloadAppFileMapper, "Cannot return null from a non-@Nullable @Provides method");
        DownloadAppFileMapper downloadAppFileMapper = providesDownloadAppFileMapper;
        $jacocoInit[3] = true;
        return downloadAppFileMapper;
    }

    public static C13181b<DownloadAppFileMapper> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDownloadAppFileMapperFactory applicationModule_ProvidesDownloadAppFileMapperFactory = new ApplicationModule_ProvidesDownloadAppFileMapperFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesDownloadAppFileMapperFactory;
    }

    public static DownloadAppFileMapper proxyProvidesDownloadAppFileMapper(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAppFileMapper providesDownloadAppFileMapper = instance.providesDownloadAppFileMapper();
        $jacocoInit[5] = true;
        return providesDownloadAppFileMapper;
    }
}
