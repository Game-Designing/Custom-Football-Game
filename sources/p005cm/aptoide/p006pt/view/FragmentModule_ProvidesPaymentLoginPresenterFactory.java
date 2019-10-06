package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountErrorMapper;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginFlavorPresenter;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesPaymentLoginPresenterFactory */
public final class FragmentModule_ProvidesPaymentLoginPresenterFactory implements C13181b<PaymentLoginFlavorPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AccountErrorMapper> accountErrorMapperProvider;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final FragmentModule module;
    private final Provider<ScreenOrientationManager> screenOrientationManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7109077707321154863L, "cm/aptoide/pt/view/FragmentModule_ProvidesPaymentLoginPresenterFactory", 13);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesPaymentLoginPresenterFactory(FragmentModule module2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<AccountErrorMapper> accountErrorMapperProvider2, Provider<ScreenOrientationManager> screenOrientationManagerProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.crashReportProvider = crashReportProvider2;
        this.accountErrorMapperProvider = accountErrorMapperProvider2;
        this.screenOrientationManagerProvider = screenOrientationManagerProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public PaymentLoginFlavorPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AccountNavigator> provider = this.accountNavigatorProvider;
        $jacocoInit[1] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider.get();
        Provider<AptoideAccountManager> provider2 = this.accountManagerProvider;
        $jacocoInit[2] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider2.get();
        Provider<CrashReport> provider3 = this.crashReportProvider;
        $jacocoInit[3] = true;
        CrashReport crashReport = (CrashReport) provider3.get();
        Provider<AccountErrorMapper> provider4 = this.accountErrorMapperProvider;
        $jacocoInit[4] = true;
        AccountErrorMapper accountErrorMapper = (AccountErrorMapper) provider4.get();
        Provider<ScreenOrientationManager> provider5 = this.screenOrientationManagerProvider;
        $jacocoInit[5] = true;
        ScreenOrientationManager screenOrientationManager = (ScreenOrientationManager) provider5.get();
        Provider<AccountAnalytics> provider6 = this.accountAnalyticsProvider;
        $jacocoInit[6] = true;
        AccountAnalytics accountAnalytics = (AccountAnalytics) provider6.get();
        $jacocoInit[7] = true;
        PaymentLoginFlavorPresenter providesPaymentLoginPresenter = fragmentModule.providesPaymentLoginPresenter(accountNavigator, aptoideAccountManager, crashReport, accountErrorMapper, screenOrientationManager, accountAnalytics);
        $jacocoInit[8] = true;
        C13182c.m43111a(providesPaymentLoginPresenter, "Cannot return null from a non-@Nullable @Provides method");
        PaymentLoginFlavorPresenter paymentLoginFlavorPresenter = providesPaymentLoginPresenter;
        $jacocoInit[9] = true;
        return paymentLoginFlavorPresenter;
    }

    public static C13181b<PaymentLoginFlavorPresenter> create(FragmentModule module2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<AccountErrorMapper> accountErrorMapperProvider2, Provider<ScreenOrientationManager> screenOrientationManagerProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesPaymentLoginPresenterFactory fragmentModule_ProvidesPaymentLoginPresenterFactory = new FragmentModule_ProvidesPaymentLoginPresenterFactory(module2, accountNavigatorProvider2, accountManagerProvider2, crashReportProvider2, accountErrorMapperProvider2, screenOrientationManagerProvider2, accountAnalyticsProvider2);
        $jacocoInit[10] = true;
        return fragmentModule_ProvidesPaymentLoginPresenterFactory;
    }

    public static PaymentLoginFlavorPresenter proxyProvidesPaymentLoginPresenter(FragmentModule instance, AccountNavigator accountNavigator, AptoideAccountManager accountManager, CrashReport crashReport, AccountErrorMapper accountErrorMapper, ScreenOrientationManager screenOrientationManager, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        PaymentLoginFlavorPresenter providesPaymentLoginPresenter = instance.providesPaymentLoginPresenter(accountNavigator, accountManager, crashReport, accountErrorMapper, screenOrientationManager, accountAnalytics);
        $jacocoInit[11] = true;
        return providesPaymentLoginPresenter;
    }
}
