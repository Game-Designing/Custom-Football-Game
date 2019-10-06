package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloaderProvider;
import p005cm.aptoide.p006pt.downloadmanager.RetryFileDownloaderProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesRetryFileDownloaderProviderFactory */
public final class ApplicationModule_ProvidesRetryFileDownloaderProviderFactory implements C13181b<RetryFileDownloaderProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FileDownloaderProvider> fileDownloaderProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5472838333091201888L, "cm/aptoide/pt/ApplicationModule_ProvidesRetryFileDownloaderProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesRetryFileDownloaderProviderFactory(ApplicationModule module2, Provider<FileDownloaderProvider> fileDownloaderProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fileDownloaderProvider = fileDownloaderProvider2;
        $jacocoInit[0] = true;
    }

    public RetryFileDownloaderProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<FileDownloaderProvider> provider = this.fileDownloaderProvider;
        $jacocoInit[1] = true;
        RetryFileDownloaderProvider providesRetryFileDownloaderProvider = applicationModule.providesRetryFileDownloaderProvider((FileDownloaderProvider) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesRetryFileDownloaderProvider, "Cannot return null from a non-@Nullable @Provides method");
        RetryFileDownloaderProvider retryFileDownloaderProvider = providesRetryFileDownloaderProvider;
        $jacocoInit[3] = true;
        return retryFileDownloaderProvider;
    }

    public static C13181b<RetryFileDownloaderProvider> create(ApplicationModule module2, Provider<FileDownloaderProvider> fileDownloaderProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesRetryFileDownloaderProviderFactory applicationModule_ProvidesRetryFileDownloaderProviderFactory = new ApplicationModule_ProvidesRetryFileDownloaderProviderFactory(module2, fileDownloaderProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesRetryFileDownloaderProviderFactory;
    }

    public static RetryFileDownloaderProvider proxyProvidesRetryFileDownloaderProvider(ApplicationModule instance, FileDownloaderProvider fileDownloaderProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        RetryFileDownloaderProvider providesRetryFileDownloaderProvider = instance.providesRetryFileDownloaderProvider(fileDownloaderProvider2);
        $jacocoInit[5] = true;
        return providesRetryFileDownloaderProvider;
    }
}
