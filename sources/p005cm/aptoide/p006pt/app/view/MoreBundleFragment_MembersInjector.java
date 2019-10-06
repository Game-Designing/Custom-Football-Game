package p005cm.aptoide.p006pt.app.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.app.view.MoreBundleFragment_MembersInjector */
public final class MoreBundleFragment_MembersInjector implements C13183b<MoreBundleFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MoreBundlePresenter> presenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4006770973075187186L, "cm/aptoide/pt/app/view/MoreBundleFragment_MembersInjector", 9);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((MoreBundleFragment) obj);
        $jacocoInit[8] = true;
    }

    public MoreBundleFragment_MembersInjector(Provider<MoreBundlePresenter> presenterProvider2, Provider<String> marketNameProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.captionBackgroundPainterProvider = captionBackgroundPainterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<MoreBundleFragment> create(Provider<MoreBundlePresenter> presenterProvider2, Provider<String> marketNameProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        MoreBundleFragment_MembersInjector moreBundleFragment_MembersInjector = new MoreBundleFragment_MembersInjector(presenterProvider2, marketNameProvider2, captionBackgroundPainterProvider2);
        $jacocoInit[1] = true;
        return moreBundleFragment_MembersInjector;
    }

    public void injectMembers(MoreBundleFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (MoreBundlePresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[3] = true;
        injectCaptionBackgroundPainter(instance, (CaptionBackgroundPainter) this.captionBackgroundPainterProvider.get());
        $jacocoInit[4] = true;
    }

    public static void injectPresenter(MoreBundleFragment instance, MoreBundlePresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[5] = true;
    }

    public static void injectMarketName(MoreBundleFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[6] = true;
    }

    public static void injectCaptionBackgroundPainter(MoreBundleFragment instance, CaptionBackgroundPainter captionBackgroundPainter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.captionBackgroundPainter = captionBackgroundPainter;
        $jacocoInit[7] = true;
    }
}
