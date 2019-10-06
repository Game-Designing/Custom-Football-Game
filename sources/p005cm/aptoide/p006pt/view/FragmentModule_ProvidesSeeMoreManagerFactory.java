package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.home.apps.AppMapper;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcManager;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesSeeMoreManagerFactory */
public final class FragmentModule_ProvidesSeeMoreManagerFactory implements C13181b<SeeMoreAppcManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppMapper> appMapperProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final FragmentModule module;
    private final Provider<UpdatesManager> updatesManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3648289273272683659L, "cm/aptoide/pt/view/FragmentModule_ProvidesSeeMoreManagerFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesSeeMoreManagerFactory(FragmentModule module2, Provider<UpdatesManager> updatesManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<AppMapper> appMapperProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<DownloadFactory> downloadFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.updatesManagerProvider = updatesManagerProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.appMapperProvider = appMapperProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.downloadFactoryProvider = downloadFactoryProvider2;
        $jacocoInit[0] = true;
    }

    public SeeMoreAppcManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<UpdatesManager> provider = this.updatesManagerProvider;
        $jacocoInit[1] = true;
        UpdatesManager updatesManager = (UpdatesManager) provider.get();
        Provider<InstallManager> provider2 = this.installManagerProvider;
        $jacocoInit[2] = true;
        InstallManager installManager = (InstallManager) provider2.get();
        Provider<AppMapper> provider3 = this.appMapperProvider;
        $jacocoInit[3] = true;
        AppMapper appMapper = (AppMapper) provider3.get();
        Provider<DownloadAnalytics> provider4 = this.downloadAnalyticsProvider;
        $jacocoInit[4] = true;
        DownloadAnalytics downloadAnalytics = (DownloadAnalytics) provider4.get();
        Provider<InstallAnalytics> provider5 = this.installAnalyticsProvider;
        $jacocoInit[5] = true;
        InstallAnalytics installAnalytics = (InstallAnalytics) provider5.get();
        Provider<DownloadFactory> provider6 = this.downloadFactoryProvider;
        $jacocoInit[6] = true;
        DownloadFactory downloadFactory = (DownloadFactory) provider6.get();
        $jacocoInit[7] = true;
        SeeMoreAppcManager providesSeeMoreManager = fragmentModule.providesSeeMoreManager(updatesManager, installManager, appMapper, downloadAnalytics, installAnalytics, downloadFactory);
        $jacocoInit[8] = true;
        C13182c.m43111a(providesSeeMoreManager, "Cannot return null from a non-@Nullable @Provides method");
        SeeMoreAppcManager seeMoreAppcManager = providesSeeMoreManager;
        $jacocoInit[9] = true;
        return seeMoreAppcManager;
    }

    public static C13181b<SeeMoreAppcManager> create(FragmentModule module2, Provider<UpdatesManager> updatesManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<AppMapper> appMapperProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<DownloadFactory> downloadFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesSeeMoreManagerFactory fragmentModule_ProvidesSeeMoreManagerFactory = new FragmentModule_ProvidesSeeMoreManagerFactory(module2, updatesManagerProvider2, installManagerProvider2, appMapperProvider2, downloadAnalyticsProvider2, installAnalyticsProvider2, downloadFactoryProvider2);
        $jacocoInit[10] = true;
        return fragmentModule_ProvidesSeeMoreManagerFactory;
    }

    public static SeeMoreAppcManager proxyProvidesSeeMoreManager(FragmentModule instance, UpdatesManager updatesManager, InstallManager installManager, AppMapper appMapper, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, DownloadFactory downloadFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        SeeMoreAppcManager providesSeeMoreManager = instance.providesSeeMoreManager(updatesManager, installManager, appMapper, downloadAnalytics, installAnalytics, downloadFactory);
        $jacocoInit[11] = true;
        return providesSeeMoreManager;
    }
}
