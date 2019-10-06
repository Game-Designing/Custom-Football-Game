package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.home.apps.AppMapper;
import p005cm.aptoide.p006pt.home.apps.AppsManager;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.updates.UpdatesAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppsManagerFactory */
public final class FragmentModule_ProvidesAppsManagerFactory implements C13181b<AppsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppMapper> appMapperProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final FragmentModule module;
    private final Provider<UpdatesAnalytics> updatesAnalyticsProvider;
    private final Provider<UpdatesManager> updatesManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6013446351633626337L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppsManagerFactory", 15);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesAppsManagerFactory(FragmentModule module2, Provider<UpdatesManager> updatesManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<AppMapper> appMapperProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<UpdatesAnalytics> updatesAnalyticsProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.updatesManagerProvider = updatesManagerProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.appMapperProvider = appMapperProvider2;
        this.downloadAnalyticsProvider = downloadAnalyticsProvider2;
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.updatesAnalyticsProvider = updatesAnalyticsProvider2;
        this.downloadFactoryProvider = downloadFactoryProvider2;
        this.moPubAdsManagerProvider = moPubAdsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public AppsManager get() {
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
        Provider<UpdatesAnalytics> provider6 = this.updatesAnalyticsProvider;
        $jacocoInit[6] = true;
        UpdatesAnalytics updatesAnalytics = (UpdatesAnalytics) provider6.get();
        Provider<DownloadFactory> provider7 = this.downloadFactoryProvider;
        $jacocoInit[7] = true;
        DownloadFactory downloadFactory = (DownloadFactory) provider7.get();
        Provider<MoPubAdsManager> provider8 = this.moPubAdsManagerProvider;
        $jacocoInit[8] = true;
        MoPubAdsManager moPubAdsManager = (MoPubAdsManager) provider8.get();
        $jacocoInit[9] = true;
        AppsManager providesAppsManager = fragmentModule.providesAppsManager(updatesManager, installManager, appMapper, downloadAnalytics, installAnalytics, updatesAnalytics, downloadFactory, moPubAdsManager);
        $jacocoInit[10] = true;
        C13182c.m43111a(providesAppsManager, "Cannot return null from a non-@Nullable @Provides method");
        AppsManager appsManager = providesAppsManager;
        $jacocoInit[11] = true;
        return appsManager;
    }

    public static C13181b<AppsManager> create(FragmentModule module2, Provider<UpdatesManager> updatesManagerProvider2, Provider<InstallManager> installManagerProvider2, Provider<AppMapper> appMapperProvider2, Provider<DownloadAnalytics> downloadAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<UpdatesAnalytics> updatesAnalyticsProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesAppsManagerFactory fragmentModule_ProvidesAppsManagerFactory = new FragmentModule_ProvidesAppsManagerFactory(module2, updatesManagerProvider2, installManagerProvider2, appMapperProvider2, downloadAnalyticsProvider2, installAnalyticsProvider2, updatesAnalyticsProvider2, downloadFactoryProvider2, moPubAdsManagerProvider2);
        $jacocoInit[12] = true;
        return fragmentModule_ProvidesAppsManagerFactory;
    }

    public static AppsManager proxyProvidesAppsManager(FragmentModule instance, UpdatesManager updatesManager, InstallManager installManager, AppMapper appMapper, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, UpdatesAnalytics updatesAnalytics, DownloadFactory downloadFactory, MoPubAdsManager moPubAdsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsManager providesAppsManager = instance.providesAppsManager(updatesManager, installManager, appMapper, downloadAnalytics, installAnalytics, updatesAnalytics, downloadFactory, moPubAdsManager);
        $jacocoInit[13] = true;
        return providesAppsManager;
    }
}
