package p005cm.aptoide.p006pt.home;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.home.HomeContainerFragment_MembersInjector */
public final class HomeContainerFragment_MembersInjector implements C13183b<HomeContainerFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<HomeContainerPresenter> presenterProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5503258695045507135L, "cm/aptoide/pt/home/HomeContainerFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((HomeContainerFragment) obj);
        $jacocoInit[6] = true;
    }

    public HomeContainerFragment_MembersInjector(Provider<HomeContainerPresenter> presenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<HomeContainerFragment> create(Provider<HomeContainerPresenter> presenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeContainerFragment_MembersInjector homeContainerFragment_MembersInjector = new HomeContainerFragment_MembersInjector(presenterProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return homeContainerFragment_MembersInjector;
    }

    public void injectMembers(HomeContainerFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (HomeContainerPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectPresenter(HomeContainerFragment instance, HomeContainerPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[4] = true;
    }

    public static void injectTheme(HomeContainerFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[5] = true;
    }
}
