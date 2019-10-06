package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.install.InstallManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppCoinsInfoPresenterFactory */
public final class FragmentModule_ProvidesAppCoinsInfoPresenterFactory implements C13181b<AppCoinsInfoPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppCoinsInfoNavigator> appCoinsInfoNavigatorProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4025832509736511535L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppCoinsInfoPresenterFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesAppCoinsInfoPresenterFactory(FragmentModule module2, Provider<AppCoinsInfoNavigator> appCoinsInfoNavigatorProvider2, Provider<InstallManager> installManagerProvider2, Provider<CrashReport> crashReportProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appCoinsInfoNavigatorProvider = appCoinsInfoNavigatorProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.crashReportProvider = crashReportProvider2;
        $jacocoInit[0] = true;
    }

    public AppCoinsInfoPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AppCoinsInfoNavigator> provider = this.appCoinsInfoNavigatorProvider;
        $jacocoInit[1] = true;
        AppCoinsInfoNavigator appCoinsInfoNavigator = (AppCoinsInfoNavigator) provider.get();
        Provider<InstallManager> provider2 = this.installManagerProvider;
        $jacocoInit[2] = true;
        InstallManager installManager = (InstallManager) provider2.get();
        Provider<CrashReport> provider3 = this.crashReportProvider;
        $jacocoInit[3] = true;
        CrashReport crashReport = (CrashReport) provider3.get();
        $jacocoInit[4] = true;
        AppCoinsInfoPresenter providesAppCoinsInfoPresenter = fragmentModule.providesAppCoinsInfoPresenter(appCoinsInfoNavigator, installManager, crashReport);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesAppCoinsInfoPresenter, "Cannot return null from a non-@Nullable @Provides method");
        AppCoinsInfoPresenter appCoinsInfoPresenter = providesAppCoinsInfoPresenter;
        $jacocoInit[6] = true;
        return appCoinsInfoPresenter;
    }

    public static C13181b<AppCoinsInfoPresenter> create(FragmentModule module2, Provider<AppCoinsInfoNavigator> appCoinsInfoNavigatorProvider2, Provider<InstallManager> installManagerProvider2, Provider<CrashReport> crashReportProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesAppCoinsInfoPresenterFactory fragmentModule_ProvidesAppCoinsInfoPresenterFactory = new FragmentModule_ProvidesAppCoinsInfoPresenterFactory(module2, appCoinsInfoNavigatorProvider2, installManagerProvider2, crashReportProvider2);
        $jacocoInit[7] = true;
        return fragmentModule_ProvidesAppCoinsInfoPresenterFactory;
    }

    public static AppCoinsInfoPresenter proxyProvidesAppCoinsInfoPresenter(FragmentModule instance, AppCoinsInfoNavigator appCoinsInfoNavigator, InstallManager installManager, CrashReport crashReport) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsInfoPresenter providesAppCoinsInfoPresenter = instance.providesAppCoinsInfoPresenter(appCoinsInfoNavigator, installManager, crashReport);
        $jacocoInit[8] = true;
        return providesAppCoinsInfoPresenter;
    }
}
