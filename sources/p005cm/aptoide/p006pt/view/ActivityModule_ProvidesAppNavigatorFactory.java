package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesAppNavigatorFactory */
public final class ActivityModule_ProvidesAppNavigatorFactory implements C13181b<AppNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4916999900762358741L, "cm/aptoide/pt/view/ActivityModule_ProvidesAppNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesAppNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public AppNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        AppNavigator providesAppNavigator = activityModule.providesAppNavigator((FragmentNavigator) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppNavigator, "Cannot return null from a non-@Nullable @Provides method");
        AppNavigator appNavigator = providesAppNavigator;
        $jacocoInit[3] = true;
        return appNavigator;
    }

    public static C13181b<AppNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesAppNavigatorFactory activityModule_ProvidesAppNavigatorFactory = new ActivityModule_ProvidesAppNavigatorFactory(module2, fragmentNavigatorProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesAppNavigatorFactory;
    }

    public static AppNavigator proxyProvidesAppNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppNavigator providesAppNavigator = instance.providesAppNavigator(fragmentNavigator);
        $jacocoInit[5] = true;
        return providesAppNavigator;
    }
}
