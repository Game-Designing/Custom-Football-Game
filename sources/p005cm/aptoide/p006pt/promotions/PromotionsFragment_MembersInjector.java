package p005cm.aptoide.p006pt.promotions;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.promotions.PromotionsFragment_MembersInjector */
public final class PromotionsFragment_MembersInjector implements C13183b<PromotionsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<PromotionsPresenter> promotionsPresenterProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4722642658567415654L, "cm/aptoide/pt/promotions/PromotionsFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((PromotionsFragment) obj);
        $jacocoInit[6] = true;
    }

    public PromotionsFragment_MembersInjector(Provider<PromotionsPresenter> promotionsPresenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsPresenterProvider = promotionsPresenterProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<PromotionsFragment> create(Provider<PromotionsPresenter> promotionsPresenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsFragment_MembersInjector promotionsFragment_MembersInjector = new PromotionsFragment_MembersInjector(promotionsPresenterProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return promotionsFragment_MembersInjector;
    }

    public void injectMembers(PromotionsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPromotionsPresenter(instance, (PromotionsPresenter) this.promotionsPresenterProvider.get());
        $jacocoInit[2] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectPromotionsPresenter(PromotionsFragment instance, PromotionsPresenter promotionsPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.promotionsPresenter = promotionsPresenter;
        $jacocoInit[4] = true;
    }

    public static void injectTheme(PromotionsFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[5] = true;
    }
}
