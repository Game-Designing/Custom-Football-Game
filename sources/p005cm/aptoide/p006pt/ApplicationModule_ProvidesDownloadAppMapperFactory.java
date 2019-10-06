package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppFileMapper;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDownloadAppMapperFactory */
public final class ApplicationModule_ProvidesDownloadAppMapperFactory implements C13181b<DownloadAppMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadAppFileMapper> downloadAppFileMapperProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6824123784970287875L, "cm/aptoide/pt/ApplicationModule_ProvidesDownloadAppMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDownloadAppMapperFactory(ApplicationModule module2, Provider<DownloadAppFileMapper> downloadAppFileMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadAppFileMapperProvider = downloadAppFileMapperProvider2;
        $jacocoInit[0] = true;
    }

    public DownloadAppMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<DownloadAppFileMapper> provider = this.downloadAppFileMapperProvider;
        $jacocoInit[1] = true;
        DownloadAppMapper providesDownloadAppMapper = applicationModule.providesDownloadAppMapper((DownloadAppFileMapper) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesDownloadAppMapper, "Cannot return null from a non-@Nullable @Provides method");
        DownloadAppMapper downloadAppMapper = providesDownloadAppMapper;
        $jacocoInit[3] = true;
        return downloadAppMapper;
    }

    public static C13181b<DownloadAppMapper> create(ApplicationModule module2, Provider<DownloadAppFileMapper> downloadAppFileMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDownloadAppMapperFactory applicationModule_ProvidesDownloadAppMapperFactory = new ApplicationModule_ProvidesDownloadAppMapperFactory(module2, downloadAppFileMapperProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesDownloadAppMapperFactory;
    }

    public static DownloadAppMapper proxyProvidesDownloadAppMapper(ApplicationModule instance, DownloadAppFileMapper downloadAppFileMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAppMapper providesDownloadAppMapper = instance.providesDownloadAppMapper(downloadAppFileMapper);
        $jacocoInit[5] = true;
        return providesDownloadAppMapper;
    }
}
