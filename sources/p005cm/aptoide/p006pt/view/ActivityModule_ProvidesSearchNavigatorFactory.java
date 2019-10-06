package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesSearchNavigatorFactory */
public final class ActivityModule_ProvidesSearchNavigatorFactory implements C13181b<SearchNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3173270226945895969L, "cm/aptoide/pt/view/ActivityModule_ProvidesSearchNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesSearchNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public SearchNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        SearchNavigator providesSearchNavigator = activityModule.providesSearchNavigator((FragmentNavigator) provider.get(), (AppNavigator) this.appNavigatorProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSearchNavigator, "Cannot return null from a non-@Nullable @Provides method");
        SearchNavigator searchNavigator = providesSearchNavigator;
        $jacocoInit[3] = true;
        return searchNavigator;
    }

    public static C13181b<SearchNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesSearchNavigatorFactory activityModule_ProvidesSearchNavigatorFactory = new ActivityModule_ProvidesSearchNavigatorFactory(module2, fragmentNavigatorProvider2, appNavigatorProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesSearchNavigatorFactory;
    }

    public static SearchNavigator proxyProvidesSearchNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchNavigator providesSearchNavigator = instance.providesSearchNavigator(fragmentNavigator, appNavigator);
        $jacocoInit[5] = true;
        return providesSearchNavigator;
    }
}
