package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;
import p005cm.aptoide.p006pt.editorial.EditorialManager;
import p005cm.aptoide.p006pt.editorial.EditorialRepository;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialManagerFactory */
public final class FragmentModule_ProvidesEditorialManagerFactory implements C13181b<EditorialManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final Provider<EditorialAnalytics> editorialAnalyticsProvider;
    private final Provider<EditorialRepository> editorialRepositoryProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final FragmentModule module;
    private final Provider<NotificationAnalytics> notificationAnalyticsProvider;
    private final Provider<ReactionsManager> reactionsManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6926119825661591808L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialManagerFactory", 16);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialManagerFactory(FragmentModule module2, Provider<EditorialRepository> editorialRepositoryProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<EditorialAnalytics> editorialAnalyticsProvider2, Provider<ReactionsManager> reactionsManagerProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.editorialRepositoryProvider = editorialRepositoryProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.downloadFactoryProvider = downloadFactoryProvider2;
        this.downloadStateParserProvider = downloadStateParserProvider2;
        this.notificationAnalyticsProvider = notificationAnalyticsProvider2;
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.editorialAnalyticsProvider = editorialAnalyticsProvider2;
        this.reactionsManagerProvider = reactionsManagerProvider2;
        this.moPubAdsManagerProvider = moPubAdsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<EditorialRepository> provider = this.editorialRepositoryProvider;
        $jacocoInit[1] = true;
        EditorialRepository editorialRepository = (EditorialRepository) provider.get();
        Provider<InstallManager> provider2 = this.installManagerProvider;
        $jacocoInit[2] = true;
        InstallManager installManager = (InstallManager) provider2.get();
        Provider<DownloadFactory> provider3 = this.downloadFactoryProvider;
        $jacocoInit[3] = true;
        DownloadFactory downloadFactory = (DownloadFactory) provider3.get();
        Provider<DownloadStateParser> provider4 = this.downloadStateParserProvider;
        $jacocoInit[4] = true;
        DownloadStateParser downloadStateParser = (DownloadStateParser) provider4.get();
        Provider<NotificationAnalytics> provider5 = this.notificationAnalyticsProvider;
        $jacocoInit[5] = true;
        NotificationAnalytics notificationAnalytics = (NotificationAnalytics) provider5.get();
        Provider<InstallAnalytics> provider6 = this.installAnalyticsProvider;
        $jacocoInit[6] = true;
        InstallAnalytics installAnalytics = (InstallAnalytics) provider6.get();
        Provider<EditorialAnalytics> provider7 = this.editorialAnalyticsProvider;
        $jacocoInit[7] = true;
        EditorialAnalytics editorialAnalytics = (EditorialAnalytics) provider7.get();
        Provider<ReactionsManager> provider8 = this.reactionsManagerProvider;
        $jacocoInit[8] = true;
        ReactionsManager reactionsManager = (ReactionsManager) provider8.get();
        Provider<MoPubAdsManager> provider9 = this.moPubAdsManagerProvider;
        $jacocoInit[9] = true;
        MoPubAdsManager moPubAdsManager = (MoPubAdsManager) provider9.get();
        $jacocoInit[10] = true;
        EditorialManager providesEditorialManager = fragmentModule.providesEditorialManager(editorialRepository, installManager, downloadFactory, downloadStateParser, notificationAnalytics, installAnalytics, editorialAnalytics, reactionsManager, moPubAdsManager);
        $jacocoInit[11] = true;
        C13182c.m43111a(providesEditorialManager, "Cannot return null from a non-@Nullable @Provides method");
        EditorialManager editorialManager = providesEditorialManager;
        $jacocoInit[12] = true;
        return editorialManager;
    }

    public static C13181b<EditorialManager> create(FragmentModule module2, Provider<EditorialRepository> editorialRepositoryProvider2, Provider<InstallManager> installManagerProvider2, Provider<DownloadFactory> downloadFactoryProvider2, Provider<DownloadStateParser> downloadStateParserProvider2, Provider<NotificationAnalytics> notificationAnalyticsProvider2, Provider<InstallAnalytics> installAnalyticsProvider2, Provider<EditorialAnalytics> editorialAnalyticsProvider2, Provider<ReactionsManager> reactionsManagerProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialManagerFactory fragmentModule_ProvidesEditorialManagerFactory = new FragmentModule_ProvidesEditorialManagerFactory(module2, editorialRepositoryProvider2, installManagerProvider2, downloadFactoryProvider2, downloadStateParserProvider2, notificationAnalyticsProvider2, installAnalyticsProvider2, editorialAnalyticsProvider2, reactionsManagerProvider2, moPubAdsManagerProvider2);
        $jacocoInit[13] = true;
        return fragmentModule_ProvidesEditorialManagerFactory;
    }

    public static EditorialManager proxyProvidesEditorialManager(FragmentModule instance, EditorialRepository editorialRepository, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, EditorialAnalytics editorialAnalytics, ReactionsManager reactionsManager, MoPubAdsManager moPubAdsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialManager providesEditorialManager = instance.providesEditorialManager(editorialRepository, installManager, downloadFactory, downloadStateParser, notificationAnalytics, installAnalytics, editorialAnalytics, reactionsManager, moPubAdsManager);
        $jacocoInit[14] = true;
        return providesEditorialManager;
    }
}
