package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesSplashScreenPresenterFactory */
public final class FragmentModule_ProvidesSplashScreenPresenterFactory implements C13181b<SplashScreenPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;
    private final Provider<SplashScreenNavigator> splashScreenNavigatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8855247546412714145L, "cm/aptoide/pt/view/FragmentModule_ProvidesSplashScreenPresenterFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesSplashScreenPresenterFactory(FragmentModule module2, Provider<SplashScreenNavigator> splashScreenNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.splashScreenNavigatorProvider = splashScreenNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public SplashScreenPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<SplashScreenNavigator> provider = this.splashScreenNavigatorProvider;
        $jacocoInit[1] = true;
        SplashScreenPresenter providesSplashScreenPresenter = fragmentModule.providesSplashScreenPresenter((SplashScreenNavigator) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSplashScreenPresenter, "Cannot return null from a non-@Nullable @Provides method");
        SplashScreenPresenter splashScreenPresenter = providesSplashScreenPresenter;
        $jacocoInit[3] = true;
        return splashScreenPresenter;
    }

    public static C13181b<SplashScreenPresenter> create(FragmentModule module2, Provider<SplashScreenNavigator> splashScreenNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesSplashScreenPresenterFactory fragmentModule_ProvidesSplashScreenPresenterFactory = new FragmentModule_ProvidesSplashScreenPresenterFactory(module2, splashScreenNavigatorProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesSplashScreenPresenterFactory;
    }

    public static SplashScreenPresenter proxyProvidesSplashScreenPresenter(FragmentModule instance, SplashScreenNavigator splashScreenNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        SplashScreenPresenter providesSplashScreenPresenter = instance.providesSplashScreenPresenter(splashScreenNavigator);
        $jacocoInit[5] = true;
        return providesSplashScreenPresenter;
    }
}
