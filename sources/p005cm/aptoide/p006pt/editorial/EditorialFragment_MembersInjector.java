package p005cm.aptoide.p006pt.editorial;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.editorial.EditorialFragment_MembersInjector */
public final class EditorialFragment_MembersInjector implements C13183b<EditorialFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider;
    private final Provider<EditorialPresenter> presenterProvider;
    private final Provider<Float> screenHeightProvider;
    private final Provider<Float> screenWidthProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1859366556596975465L, "cm/aptoide/pt/editorial/EditorialFragment_MembersInjector", 13);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((EditorialFragment) obj);
        $jacocoInit[12] = true;
    }

    public EditorialFragment_MembersInjector(Provider<EditorialPresenter> presenterProvider2, Provider<Float> screenWidthProvider2, Provider<Float> screenHeightProvider2, Provider<String> themeProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.screenWidthProvider = screenWidthProvider2;
        this.screenHeightProvider = screenHeightProvider2;
        this.themeProvider = themeProvider2;
        this.captionBackgroundPainterProvider = captionBackgroundPainterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<EditorialFragment> create(Provider<EditorialPresenter> presenterProvider2, Provider<Float> screenWidthProvider2, Provider<Float> screenHeightProvider2, Provider<String> themeProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialFragment_MembersInjector editorialFragment_MembersInjector = new EditorialFragment_MembersInjector(presenterProvider2, screenWidthProvider2, screenHeightProvider2, themeProvider2, captionBackgroundPainterProvider2);
        $jacocoInit[1] = true;
        return editorialFragment_MembersInjector;
    }

    public void injectMembers(EditorialFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (EditorialPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectScreenWidth(instance, ((Float) this.screenWidthProvider.get()).floatValue());
        $jacocoInit[3] = true;
        injectScreenHeight(instance, ((Float) this.screenHeightProvider.get()).floatValue());
        $jacocoInit[4] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[5] = true;
        injectCaptionBackgroundPainter(instance, (CaptionBackgroundPainter) this.captionBackgroundPainterProvider.get());
        $jacocoInit[6] = true;
    }

    public static void injectPresenter(EditorialFragment instance, EditorialPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[7] = true;
    }

    public static void injectScreenWidth(EditorialFragment instance, float screenWidth) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.screenWidth = screenWidth;
        $jacocoInit[8] = true;
    }

    public static void injectScreenHeight(EditorialFragment instance, float screenHeight) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.screenHeight = screenHeight;
        $jacocoInit[9] = true;
    }

    public static void injectTheme(EditorialFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[10] = true;
    }

    public static void injectCaptionBackgroundPainter(EditorialFragment instance, CaptionBackgroundPainter captionBackgroundPainter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.captionBackgroundPainter = captionBackgroundPainter;
        $jacocoInit[11] = true;
    }
}
