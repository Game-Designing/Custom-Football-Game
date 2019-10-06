package p005cm.aptoide.p006pt.home.apps;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.home.apps.AppsFragment_MembersInjector */
public final class AppsFragment_MembersInjector implements C13183b<AppsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppsPresenter> appsPresenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2708618217450761517L, "cm/aptoide/pt/home/apps/AppsFragment_MembersInjector", 5);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((AppsFragment) obj);
        $jacocoInit[4] = true;
    }

    public AppsFragment_MembersInjector(Provider<AppsPresenter> appsPresenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsPresenterProvider = appsPresenterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<AppsFragment> create(Provider<AppsPresenter> appsPresenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsFragment_MembersInjector appsFragment_MembersInjector = new AppsFragment_MembersInjector(appsPresenterProvider2);
        $jacocoInit[1] = true;
        return appsFragment_MembersInjector;
    }

    public void injectMembers(AppsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAppsPresenter(instance, (AppsPresenter) this.appsPresenterProvider.get());
        $jacocoInit[2] = true;
    }

    public static void injectAppsPresenter(AppsFragment instance, AppsPresenter appsPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appsPresenter = appsPresenter;
        $jacocoInit[3] = true;
    }
}
