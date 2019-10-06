package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcManager;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesSeeMoreAppcPresenterFactory */
public final class FragmentModule_ProvidesSeeMoreAppcPresenterFactory implements C13181b<SeeMoreAppcPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;
    private final Provider<SeeMoreAppcManager> seeMoreAppcManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2559591114862213205L, "cm/aptoide/pt/view/FragmentModule_ProvidesSeeMoreAppcPresenterFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesSeeMoreAppcPresenterFactory(FragmentModule module2, Provider<SeeMoreAppcManager> seeMoreAppcManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.seeMoreAppcManagerProvider = seeMoreAppcManagerProvider2;
        $jacocoInit[0] = true;
    }

    public SeeMoreAppcPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<SeeMoreAppcManager> provider = this.seeMoreAppcManagerProvider;
        $jacocoInit[1] = true;
        SeeMoreAppcPresenter providesSeeMoreAppcPresenter = fragmentModule.providesSeeMoreAppcPresenter((SeeMoreAppcManager) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSeeMoreAppcPresenter, "Cannot return null from a non-@Nullable @Provides method");
        SeeMoreAppcPresenter seeMoreAppcPresenter = providesSeeMoreAppcPresenter;
        $jacocoInit[3] = true;
        return seeMoreAppcPresenter;
    }

    public static C13181b<SeeMoreAppcPresenter> create(FragmentModule module2, Provider<SeeMoreAppcManager> seeMoreAppcManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesSeeMoreAppcPresenterFactory fragmentModule_ProvidesSeeMoreAppcPresenterFactory = new FragmentModule_ProvidesSeeMoreAppcPresenterFactory(module2, seeMoreAppcManagerProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesSeeMoreAppcPresenterFactory;
    }

    public static SeeMoreAppcPresenter proxyProvidesSeeMoreAppcPresenter(FragmentModule instance, SeeMoreAppcManager seeMoreAppcManager) {
        boolean[] $jacocoInit = $jacocoInit();
        SeeMoreAppcPresenter providesSeeMoreAppcPresenter = instance.providesSeeMoreAppcPresenter(seeMoreAppcManager);
        $jacocoInit[5] = true;
        return providesSeeMoreAppcPresenter;
    }
}
