package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.app.ListStoreAppsNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideListStoreAppsNavigatorFactory */
public final class ActivityModule_ProvideListStoreAppsNavigatorFactory implements C13181b<ListStoreAppsNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6688936622255679683L, "cm/aptoide/pt/view/ActivityModule_ProvideListStoreAppsNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideListStoreAppsNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public ListStoreAppsNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        AppNavigator appNavigator = (AppNavigator) this.appNavigatorProvider.get();
        $jacocoInit[2] = true;
        ListStoreAppsNavigator provideListStoreAppsNavigator = activityModule.provideListStoreAppsNavigator(fragmentNavigator, appNavigator);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideListStoreAppsNavigator, "Cannot return null from a non-@Nullable @Provides method");
        ListStoreAppsNavigator listStoreAppsNavigator = provideListStoreAppsNavigator;
        $jacocoInit[4] = true;
        return listStoreAppsNavigator;
    }

    public static C13181b<ListStoreAppsNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideListStoreAppsNavigatorFactory activityModule_ProvideListStoreAppsNavigatorFactory = new ActivityModule_ProvideListStoreAppsNavigatorFactory(module2, fragmentNavigatorProvider2, appNavigatorProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvideListStoreAppsNavigatorFactory;
    }

    public static ListStoreAppsNavigator proxyProvideListStoreAppsNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoreAppsNavigator provideListStoreAppsNavigator = instance.provideListStoreAppsNavigator(fragmentNavigator, appNavigator);
        $jacocoInit[6] = true;
        return provideListStoreAppsNavigator;
    }
}
