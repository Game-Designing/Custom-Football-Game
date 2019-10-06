package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.view.wizard.WizardPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesWizardPresenterFactory */
public final class FragmentModule_ProvidesWizardPresenterFactory implements C13181b<WizardPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6904841033419235936L, "cm/aptoide/pt/view/FragmentModule_ProvidesWizardPresenterFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesWizardPresenterFactory(FragmentModule module2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.aptoideAccountManagerProvider = aptoideAccountManagerProvider2;
        this.crashReportProvider = crashReportProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public WizardPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AptoideAccountManager> provider = this.aptoideAccountManagerProvider;
        $jacocoInit[1] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider.get();
        Provider<CrashReport> provider2 = this.crashReportProvider;
        $jacocoInit[2] = true;
        CrashReport crashReport = (CrashReport) provider2.get();
        Provider<AccountAnalytics> provider3 = this.accountAnalyticsProvider;
        $jacocoInit[3] = true;
        AccountAnalytics accountAnalytics = (AccountAnalytics) provider3.get();
        $jacocoInit[4] = true;
        WizardPresenter providesWizardPresenter = fragmentModule.providesWizardPresenter(aptoideAccountManager, crashReport, accountAnalytics);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesWizardPresenter, "Cannot return null from a non-@Nullable @Provides method");
        WizardPresenter wizardPresenter = providesWizardPresenter;
        $jacocoInit[6] = true;
        return wizardPresenter;
    }

    public static C13181b<WizardPresenter> create(FragmentModule module2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesWizardPresenterFactory fragmentModule_ProvidesWizardPresenterFactory = new FragmentModule_ProvidesWizardPresenterFactory(module2, aptoideAccountManagerProvider2, crashReportProvider2, accountAnalyticsProvider2);
        $jacocoInit[7] = true;
        return fragmentModule_ProvidesWizardPresenterFactory;
    }

    public static WizardPresenter proxyProvidesWizardPresenter(FragmentModule instance, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        WizardPresenter providesWizardPresenter = instance.providesWizardPresenter(aptoideAccountManager, crashReport, accountAnalytics);
        $jacocoInit[8] = true;
        return providesWizardPresenter;
    }
}
