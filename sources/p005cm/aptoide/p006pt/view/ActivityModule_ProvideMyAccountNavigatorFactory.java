package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.settings.MyAccountNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideMyAccountNavigatorFactory */
public final class ActivityModule_ProvideMyAccountNavigatorFactory implements C13181b<MyAccountNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3454919710820973943L, "cm/aptoide/pt/view/ActivityModule_ProvideMyAccountNavigatorFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideMyAccountNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public MyAccountNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        Provider<AccountNavigator> provider2 = this.accountNavigatorProvider;
        $jacocoInit[2] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider2.get();
        Provider<AppNavigator> provider3 = this.appNavigatorProvider;
        $jacocoInit[3] = true;
        AppNavigator appNavigator = (AppNavigator) provider3.get();
        $jacocoInit[4] = true;
        MyAccountNavigator provideMyAccountNavigator = activityModule.provideMyAccountNavigator(fragmentNavigator, accountNavigator, appNavigator);
        $jacocoInit[5] = true;
        C13182c.m43111a(provideMyAccountNavigator, "Cannot return null from a non-@Nullable @Provides method");
        MyAccountNavigator myAccountNavigator = provideMyAccountNavigator;
        $jacocoInit[6] = true;
        return myAccountNavigator;
    }

    public static C13181b<MyAccountNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideMyAccountNavigatorFactory activityModule_ProvideMyAccountNavigatorFactory = new ActivityModule_ProvideMyAccountNavigatorFactory(module2, fragmentNavigatorProvider2, accountNavigatorProvider2, appNavigatorProvider2);
        $jacocoInit[7] = true;
        return activityModule_ProvideMyAccountNavigatorFactory;
    }

    public static MyAccountNavigator proxyProvideMyAccountNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountNavigator provideMyAccountNavigator = instance.provideMyAccountNavigator(fragmentNavigator, accountNavigator, appNavigator);
        $jacocoInit[8] = true;
        return provideMyAccountNavigator;
    }
}
