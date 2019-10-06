package p005cm.aptoide.p006pt.home.apps;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.home.apps.SeeMoreAppcFragment_MembersInjector */
public final class SeeMoreAppcFragment_MembersInjector implements C13183b<SeeMoreAppcFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<SeeMoreAppcPresenter> seeMoreAppcPresenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1571411477580718976L, "cm/aptoide/pt/home/apps/SeeMoreAppcFragment_MembersInjector", 5);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((SeeMoreAppcFragment) obj);
        $jacocoInit[4] = true;
    }

    public SeeMoreAppcFragment_MembersInjector(Provider<SeeMoreAppcPresenter> seeMoreAppcPresenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.seeMoreAppcPresenterProvider = seeMoreAppcPresenterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<SeeMoreAppcFragment> create(Provider<SeeMoreAppcPresenter> seeMoreAppcPresenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        SeeMoreAppcFragment_MembersInjector seeMoreAppcFragment_MembersInjector = new SeeMoreAppcFragment_MembersInjector(seeMoreAppcPresenterProvider2);
        $jacocoInit[1] = true;
        return seeMoreAppcFragment_MembersInjector;
    }

    public void injectMembers(SeeMoreAppcFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectSeeMoreAppcPresenter(instance, (SeeMoreAppcPresenter) this.seeMoreAppcPresenterProvider.get());
        $jacocoInit[2] = true;
    }

    public static void injectSeeMoreAppcPresenter(SeeMoreAppcFragment instance, SeeMoreAppcPresenter seeMoreAppcPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.seeMoreAppcPresenter = seeMoreAppcPresenter;
        $jacocoInit[3] = true;
    }
}
