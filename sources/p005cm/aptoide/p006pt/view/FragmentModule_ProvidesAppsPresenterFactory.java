package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.home.apps.AppsManager;
import p005cm.aptoide.p006pt.home.apps.AppsNavigator;
import p005cm.aptoide.p006pt.home.apps.AppsPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppsPresenterFactory */
public final class FragmentModule_ProvidesAppsPresenterFactory implements C13181b<AppsPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppsManager> appsManagerProvider;
    private final Provider<AppsNavigator> appsNavigatorProvider;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3751088295018062260L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppsPresenterFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesAppsPresenterFactory(FragmentModule module2, Provider<AppsManager> appsManagerProvider2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<AppsNavigator> appsNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appsManagerProvider = appsManagerProvider2;
        this.aptoideAccountManagerProvider = aptoideAccountManagerProvider2;
        this.appsNavigatorProvider = appsNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public AppsPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AppsManager> provider = this.appsManagerProvider;
        $jacocoInit[1] = true;
        AppsManager appsManager = (AppsManager) provider.get();
        Provider<AptoideAccountManager> provider2 = this.aptoideAccountManagerProvider;
        $jacocoInit[2] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider2.get();
        Provider<AppsNavigator> provider3 = this.appsNavigatorProvider;
        $jacocoInit[3] = true;
        AppsNavigator appsNavigator = (AppsNavigator) provider3.get();
        $jacocoInit[4] = true;
        AppsPresenter providesAppsPresenter = fragmentModule.providesAppsPresenter(appsManager, aptoideAccountManager, appsNavigator);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesAppsPresenter, "Cannot return null from a non-@Nullable @Provides method");
        AppsPresenter appsPresenter = providesAppsPresenter;
        $jacocoInit[6] = true;
        return appsPresenter;
    }

    public static C13181b<AppsPresenter> create(FragmentModule module2, Provider<AppsManager> appsManagerProvider2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<AppsNavigator> appsNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesAppsPresenterFactory fragmentModule_ProvidesAppsPresenterFactory = new FragmentModule_ProvidesAppsPresenterFactory(module2, appsManagerProvider2, aptoideAccountManagerProvider2, appsNavigatorProvider2);
        $jacocoInit[7] = true;
        return fragmentModule_ProvidesAppsPresenterFactory;
    }

    public static AppsPresenter proxyProvidesAppsPresenter(FragmentModule instance, AppsManager appsManager, AptoideAccountManager aptoideAccountManager, AppsNavigator appsNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsPresenter providesAppsPresenter = instance.providesAppsPresenter(appsManager, aptoideAccountManager, appsNavigator);
        $jacocoInit[8] = true;
        return providesAppsPresenter;
    }
}
