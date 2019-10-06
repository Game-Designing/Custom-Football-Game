package p005cm.aptoide.p006pt.home;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogView;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.home.HomeFragment_MembersInjector */
public final class HomeFragment_MembersInjector implements C13183b<HomeFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider;
    private final Provider<MoPubConsentDialogView> consentDialogViewProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<HomePresenter> presenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8577296890624925326L, "cm/aptoide/pt/home/HomeFragment_MembersInjector", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((HomeFragment) obj);
        $jacocoInit[10] = true;
    }

    public HomeFragment_MembersInjector(Provider<HomePresenter> presenterProvider2, Provider<String> marketNameProvider2, Provider<MoPubConsentDialogView> consentDialogViewProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.consentDialogViewProvider = consentDialogViewProvider2;
        this.captionBackgroundPainterProvider = captionBackgroundPainterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<HomeFragment> create(Provider<HomePresenter> presenterProvider2, Provider<String> marketNameProvider2, Provider<MoPubConsentDialogView> consentDialogViewProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeFragment_MembersInjector homeFragment_MembersInjector = new HomeFragment_MembersInjector(presenterProvider2, marketNameProvider2, consentDialogViewProvider2, captionBackgroundPainterProvider2);
        $jacocoInit[1] = true;
        return homeFragment_MembersInjector;
    }

    public void injectMembers(HomeFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (HomePresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[3] = true;
        injectConsentDialogView(instance, (MoPubConsentDialogView) this.consentDialogViewProvider.get());
        $jacocoInit[4] = true;
        injectCaptionBackgroundPainter(instance, (CaptionBackgroundPainter) this.captionBackgroundPainterProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectPresenter(HomeFragment instance, HomePresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[6] = true;
    }

    public static void injectMarketName(HomeFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[7] = true;
    }

    public static void injectConsentDialogView(HomeFragment instance, MoPubConsentDialogView consentDialogView) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.consentDialogView = consentDialogView;
        $jacocoInit[8] = true;
    }

    public static void injectCaptionBackgroundPainter(HomeFragment instance, CaptionBackgroundPainter captionBackgroundPainter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.captionBackgroundPainter = captionBackgroundPainter;
        $jacocoInit[9] = true;
    }
}
