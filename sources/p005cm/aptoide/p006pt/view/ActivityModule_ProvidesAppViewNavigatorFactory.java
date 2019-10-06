package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesAppViewNavigatorFactory */
public final class ActivityModule_ProvidesAppViewNavigatorFactory implements C13181b<AppViewNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1573689619435611502L, "cm/aptoide/pt/view/ActivityModule_ProvidesAppViewNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesAppViewNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public AppViewNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        AppNavigator appNavigator = (AppNavigator) this.appNavigatorProvider.get();
        $jacocoInit[2] = true;
        AppViewNavigator providesAppViewNavigator = activityModule.providesAppViewNavigator(fragmentNavigator, appNavigator);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesAppViewNavigator, "Cannot return null from a non-@Nullable @Provides method");
        AppViewNavigator appViewNavigator = providesAppViewNavigator;
        $jacocoInit[4] = true;
        return appViewNavigator;
    }

    public static C13181b<AppViewNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesAppViewNavigatorFactory activityModule_ProvidesAppViewNavigatorFactory = new ActivityModule_ProvidesAppViewNavigatorFactory(module2, fragmentNavigatorProvider2, appNavigatorProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvidesAppViewNavigatorFactory;
    }

    public static AppViewNavigator proxyProvidesAppViewNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewNavigator providesAppViewNavigator = instance.providesAppViewNavigator(fragmentNavigator, appNavigator);
        $jacocoInit[6] = true;
        return providesAppViewNavigator;
    }
}
