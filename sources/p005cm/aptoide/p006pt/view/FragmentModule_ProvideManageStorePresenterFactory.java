package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreNavigator;
import p005cm.aptoide.p006pt.account.view.store.ManageStorePresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideManageStorePresenterFactory */
public final class FragmentModule_ProvideManageStorePresenterFactory implements C13181b<ManageStorePresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<ManageStoreErrorMapper> manageStoreErrorMapperProvider;
    private final Provider<ManageStoreNavigator> manageStoreNavigatorProvider;
    private final FragmentModule module;
    private final Provider<UriToPathResolver> uriToPathResolverProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3862887029249086164L, "cm/aptoide/pt/view/FragmentModule_ProvideManageStorePresenterFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideManageStorePresenterFactory(FragmentModule module2, Provider<UriToPathResolver> uriToPathResolverProvider2, Provider<ManageStoreNavigator> manageStoreNavigatorProvider2, Provider<ManageStoreErrorMapper> manageStoreErrorMapperProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.uriToPathResolverProvider = uriToPathResolverProvider2;
        this.manageStoreNavigatorProvider = manageStoreNavigatorProvider2;
        this.manageStoreErrorMapperProvider = manageStoreErrorMapperProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public ManageStorePresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<UriToPathResolver> provider = this.uriToPathResolverProvider;
        $jacocoInit[1] = true;
        UriToPathResolver uriToPathResolver = (UriToPathResolver) provider.get();
        Provider<ManageStoreNavigator> provider2 = this.manageStoreNavigatorProvider;
        $jacocoInit[2] = true;
        ManageStoreNavigator manageStoreNavigator = (ManageStoreNavigator) provider2.get();
        Provider<ManageStoreErrorMapper> provider3 = this.manageStoreErrorMapperProvider;
        $jacocoInit[3] = true;
        ManageStoreErrorMapper manageStoreErrorMapper = (ManageStoreErrorMapper) provider3.get();
        Provider<AptoideAccountManager> provider4 = this.accountManagerProvider;
        $jacocoInit[4] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider4.get();
        Provider<AccountAnalytics> provider5 = this.accountAnalyticsProvider;
        $jacocoInit[5] = true;
        AccountAnalytics accountAnalytics = (AccountAnalytics) provider5.get();
        $jacocoInit[6] = true;
        ManageStorePresenter provideManageStorePresenter = fragmentModule.provideManageStorePresenter(uriToPathResolver, manageStoreNavigator, manageStoreErrorMapper, aptoideAccountManager, accountAnalytics);
        $jacocoInit[7] = true;
        C13182c.m43111a(provideManageStorePresenter, "Cannot return null from a non-@Nullable @Provides method");
        ManageStorePresenter manageStorePresenter = provideManageStorePresenter;
        $jacocoInit[8] = true;
        return manageStorePresenter;
    }

    public static C13181b<ManageStorePresenter> create(FragmentModule module2, Provider<UriToPathResolver> uriToPathResolverProvider2, Provider<ManageStoreNavigator> manageStoreNavigatorProvider2, Provider<ManageStoreErrorMapper> manageStoreErrorMapperProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideManageStorePresenterFactory fragmentModule_ProvideManageStorePresenterFactory = new FragmentModule_ProvideManageStorePresenterFactory(module2, uriToPathResolverProvider2, manageStoreNavigatorProvider2, manageStoreErrorMapperProvider2, accountManagerProvider2, accountAnalyticsProvider2);
        $jacocoInit[9] = true;
        return fragmentModule_ProvideManageStorePresenterFactory;
    }

    public static ManageStorePresenter proxyProvideManageStorePresenter(FragmentModule instance, UriToPathResolver uriToPathResolver, ManageStoreNavigator manageStoreNavigator, ManageStoreErrorMapper manageStoreErrorMapper, AptoideAccountManager accountManager, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStorePresenter provideManageStorePresenter = instance.provideManageStorePresenter(uriToPathResolver, manageStoreNavigator, manageStoreErrorMapper, accountManager, accountAnalytics);
        $jacocoInit[10] = true;
        return provideManageStorePresenter;
    }
}
