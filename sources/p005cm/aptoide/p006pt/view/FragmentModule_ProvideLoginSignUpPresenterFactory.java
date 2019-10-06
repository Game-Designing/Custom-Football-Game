package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountErrorMapper;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.presenter.LoginSignupCredentialsFlavorPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideLoginSignUpPresenterFactory */
public final class FragmentModule_ProvideLoginSignUpPresenterFactory implements C13181b<LoginSignupCredentialsFlavorPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AccountErrorMapper> errorMapperProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6519011754167867159L, "cm/aptoide/pt/view/FragmentModule_ProvideLoginSignUpPresenterFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideLoginSignUpPresenterFactory(FragmentModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AccountErrorMapper> errorMapperProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountManagerProvider = accountManagerProvider2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.errorMapperProvider = errorMapperProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public LoginSignupCredentialsFlavorPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AptoideAccountManager> provider = this.accountManagerProvider;
        $jacocoInit[1] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider.get();
        Provider<AccountNavigator> provider2 = this.accountNavigatorProvider;
        $jacocoInit[2] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider2.get();
        Provider<AccountErrorMapper> provider3 = this.errorMapperProvider;
        $jacocoInit[3] = true;
        AccountErrorMapper accountErrorMapper = (AccountErrorMapper) provider3.get();
        Provider<AccountAnalytics> provider4 = this.accountAnalyticsProvider;
        $jacocoInit[4] = true;
        AccountAnalytics accountAnalytics = (AccountAnalytics) provider4.get();
        $jacocoInit[5] = true;
        LoginSignupCredentialsFlavorPresenter provideLoginSignUpPresenter = fragmentModule.provideLoginSignUpPresenter(aptoideAccountManager, accountNavigator, accountErrorMapper, accountAnalytics);
        $jacocoInit[6] = true;
        C13182c.m43111a(provideLoginSignUpPresenter, "Cannot return null from a non-@Nullable @Provides method");
        LoginSignupCredentialsFlavorPresenter loginSignupCredentialsFlavorPresenter = provideLoginSignUpPresenter;
        $jacocoInit[7] = true;
        return loginSignupCredentialsFlavorPresenter;
    }

    public static C13181b<LoginSignupCredentialsFlavorPresenter> create(FragmentModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AccountErrorMapper> errorMapperProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideLoginSignUpPresenterFactory fragmentModule_ProvideLoginSignUpPresenterFactory = new FragmentModule_ProvideLoginSignUpPresenterFactory(module2, accountManagerProvider2, accountNavigatorProvider2, errorMapperProvider2, accountAnalyticsProvider2);
        $jacocoInit[8] = true;
        return fragmentModule_ProvideLoginSignUpPresenterFactory;
    }

    public static LoginSignupCredentialsFlavorPresenter proxyProvideLoginSignUpPresenter(FragmentModule instance, AptoideAccountManager accountManager, AccountNavigator accountNavigator, AccountErrorMapper errorMapper, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        LoginSignupCredentialsFlavorPresenter provideLoginSignUpPresenter = instance.provideLoginSignUpPresenter(accountManager, accountNavigator, errorMapper, accountAnalytics);
        $jacocoInit[9] = true;
        return provideLoginSignUpPresenter;
    }
}
