package p005cm.aptoide.p006pt.view.splashscreen;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.splashscreen.SplashScreenFragment_MembersInjector */
public final class SplashScreenFragment_MembersInjector implements C13183b<SplashScreenFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<SplashScreenPresenter> presenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1306219985824757865L, "cm/aptoide/pt/view/splashscreen/SplashScreenFragment_MembersInjector", 5);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((SplashScreenFragment) obj);
        $jacocoInit[4] = true;
    }

    public SplashScreenFragment_MembersInjector(Provider<SplashScreenPresenter> presenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<SplashScreenFragment> create(Provider<SplashScreenPresenter> presenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        SplashScreenFragment_MembersInjector splashScreenFragment_MembersInjector = new SplashScreenFragment_MembersInjector(presenterProvider2);
        $jacocoInit[1] = true;
        return splashScreenFragment_MembersInjector;
    }

    public void injectMembers(SplashScreenFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (SplashScreenPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
    }

    public static void injectPresenter(SplashScreenFragment instance, SplashScreenPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[3] = true;
    }
}
