package p005cm.aptoide.p006pt.app.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.AppCoinsInfoPresenter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.app.view.AppCoinsInfoFragment_MembersInjector */
public final class AppCoinsInfoFragment_MembersInjector implements C13183b<AppCoinsInfoFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppCoinsInfoPresenter> appCoinsInfoPresenterProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7142697158113774192L, "cm/aptoide/pt/app/view/AppCoinsInfoFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((AppCoinsInfoFragment) obj);
        $jacocoInit[6] = true;
    }

    public AppCoinsInfoFragment_MembersInjector(Provider<AppCoinsInfoPresenter> appCoinsInfoPresenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appCoinsInfoPresenterProvider = appCoinsInfoPresenterProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<AppCoinsInfoFragment> create(Provider<AppCoinsInfoPresenter> appCoinsInfoPresenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsInfoFragment_MembersInjector appCoinsInfoFragment_MembersInjector = new AppCoinsInfoFragment_MembersInjector(appCoinsInfoPresenterProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return appCoinsInfoFragment_MembersInjector;
    }

    public void injectMembers(AppCoinsInfoFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAppCoinsInfoPresenter(instance, (AppCoinsInfoPresenter) this.appCoinsInfoPresenterProvider.get());
        $jacocoInit[2] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectAppCoinsInfoPresenter(AppCoinsInfoFragment instance, AppCoinsInfoPresenter appCoinsInfoPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appCoinsInfoPresenter = appCoinsInfoPresenter;
        $jacocoInit[4] = true;
    }

    public static void injectTheme(AppCoinsInfoFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[5] = true;
    }
}
