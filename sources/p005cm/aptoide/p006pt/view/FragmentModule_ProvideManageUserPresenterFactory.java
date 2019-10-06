package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.account.view.user.CreateUserErrorMapper;
import p005cm.aptoide.p006pt.account.view.user.ManageUserNavigator;
import p005cm.aptoide.p006pt.account.view.user.ManageUserPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideManageUserPresenterFactory */
public final class FragmentModule_ProvideManageUserPresenterFactory implements C13181b<ManageUserPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<CreateUserErrorMapper> errorMapperProvider;
    private final Provider<ManageUserNavigator> manageUserNavigatorProvider;
    private final FragmentModule module;
    private final Provider<UriToPathResolver> uriToPathResolverProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2953659630282483035L, "cm/aptoide/pt/view/FragmentModule_ProvideManageUserPresenterFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideManageUserPresenterFactory(FragmentModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<CreateUserErrorMapper> errorMapperProvider2, Provider<ManageUserNavigator> manageUserNavigatorProvider2, Provider<UriToPathResolver> uriToPathResolverProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountManagerProvider = accountManagerProvider2;
        this.errorMapperProvider = errorMapperProvider2;
        this.manageUserNavigatorProvider = manageUserNavigatorProvider2;
        this.uriToPathResolverProvider = uriToPathResolverProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public ManageUserPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AptoideAccountManager> provider = this.accountManagerProvider;
        $jacocoInit[1] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider.get();
        Provider<CreateUserErrorMapper> provider2 = this.errorMapperProvider;
        $jacocoInit[2] = true;
        CreateUserErrorMapper createUserErrorMapper = (CreateUserErrorMapper) provider2.get();
        Provider<ManageUserNavigator> provider3 = this.manageUserNavigatorProvider;
        $jacocoInit[3] = true;
        ManageUserNavigator manageUserNavigator = (ManageUserNavigator) provider3.get();
        Provider<UriToPathResolver> provider4 = this.uriToPathResolverProvider;
        $jacocoInit[4] = true;
        UriToPathResolver uriToPathResolver = (UriToPathResolver) provider4.get();
        Provider<AccountAnalytics> provider5 = this.accountAnalyticsProvider;
        $jacocoInit[5] = true;
        AccountAnalytics accountAnalytics = (AccountAnalytics) provider5.get();
        $jacocoInit[6] = true;
        ManageUserPresenter provideManageUserPresenter = fragmentModule.provideManageUserPresenter(aptoideAccountManager, createUserErrorMapper, manageUserNavigator, uriToPathResolver, accountAnalytics);
        $jacocoInit[7] = true;
        C13182c.m43111a(provideManageUserPresenter, "Cannot return null from a non-@Nullable @Provides method");
        ManageUserPresenter manageUserPresenter = provideManageUserPresenter;
        $jacocoInit[8] = true;
        return manageUserPresenter;
    }

    public static C13181b<ManageUserPresenter> create(FragmentModule module2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<CreateUserErrorMapper> errorMapperProvider2, Provider<ManageUserNavigator> manageUserNavigatorProvider2, Provider<UriToPathResolver> uriToPathResolverProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideManageUserPresenterFactory fragmentModule_ProvideManageUserPresenterFactory = new FragmentModule_ProvideManageUserPresenterFactory(module2, accountManagerProvider2, errorMapperProvider2, manageUserNavigatorProvider2, uriToPathResolverProvider2, accountAnalyticsProvider2);
        $jacocoInit[9] = true;
        return fragmentModule_ProvideManageUserPresenterFactory;
    }

    public static ManageUserPresenter proxyProvideManageUserPresenter(FragmentModule instance, AptoideAccountManager accountManager, CreateUserErrorMapper errorMapper, ManageUserNavigator manageUserNavigator, UriToPathResolver uriToPathResolver, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageUserPresenter provideManageUserPresenter = instance.provideManageUserPresenter(accountManager, errorMapper, manageUserNavigator, uriToPathResolver, accountAnalytics);
        $jacocoInit[10] = true;
        return provideManageUserPresenter;
    }
}
