package p005cm.aptoide.p006pt.install;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationManager;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.install.InstalledIntentService_MembersInjector */
public final class InstalledIntentService_MembersInjector implements C13183b<InstalledIntentService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppcMigrationManager> appcMigrationManagerProvider;
    private final Provider<CampaignAnalytics> campaignAnalyticsProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8535972078197325031L, "cm/aptoide/pt/install/InstalledIntentService_MembersInjector", 9);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((InstalledIntentService) obj);
        $jacocoInit[8] = true;
    }

    public InstalledIntentService_MembersInjector(Provider<InstallAnalytics> installAnalyticsProvider2, Provider<CampaignAnalytics> campaignAnalyticsProvider2, Provider<AppcMigrationManager> appcMigrationManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installAnalyticsProvider = installAnalyticsProvider2;
        this.campaignAnalyticsProvider = campaignAnalyticsProvider2;
        this.appcMigrationManagerProvider = appcMigrationManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<InstalledIntentService> create(Provider<InstallAnalytics> installAnalyticsProvider2, Provider<CampaignAnalytics> campaignAnalyticsProvider2, Provider<AppcMigrationManager> appcMigrationManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledIntentService_MembersInjector installedIntentService_MembersInjector = new InstalledIntentService_MembersInjector(installAnalyticsProvider2, campaignAnalyticsProvider2, appcMigrationManagerProvider2);
        $jacocoInit[1] = true;
        return installedIntentService_MembersInjector;
    }

    public void injectMembers(InstalledIntentService instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectInstallAnalytics(instance, (InstallAnalytics) this.installAnalyticsProvider.get());
        $jacocoInit[2] = true;
        injectCampaignAnalytics(instance, (CampaignAnalytics) this.campaignAnalyticsProvider.get());
        $jacocoInit[3] = true;
        injectAppcMigrationManager(instance, (AppcMigrationManager) this.appcMigrationManagerProvider.get());
        $jacocoInit[4] = true;
    }

    public static void injectInstallAnalytics(InstalledIntentService instance, InstallAnalytics installAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.installAnalytics = installAnalytics;
        $jacocoInit[5] = true;
    }

    public static void injectCampaignAnalytics(InstalledIntentService instance, CampaignAnalytics campaignAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.campaignAnalytics = campaignAnalytics;
        $jacocoInit[6] = true;
    }

    public static void injectAppcMigrationManager(InstalledIntentService instance, AppcMigrationManager appcMigrationManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appcMigrationManager = appcMigrationManager;
        $jacocoInit[7] = true;
    }
}
