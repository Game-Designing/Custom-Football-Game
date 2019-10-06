package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesCaptionBackgroundPainterFactory */
public final class ApplicationModule_ProvidesCaptionBackgroundPainterFactory implements C13181b<CaptionBackgroundPainter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4848913293586400256L, "cm/aptoide/pt/ApplicationModule_ProvidesCaptionBackgroundPainterFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesCaptionBackgroundPainterFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public CaptionBackgroundPainter get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        CaptionBackgroundPainter providesCaptionBackgroundPainter = applicationModule.providesCaptionBackgroundPainter();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesCaptionBackgroundPainter, "Cannot return null from a non-@Nullable @Provides method");
        CaptionBackgroundPainter captionBackgroundPainter = providesCaptionBackgroundPainter;
        $jacocoInit[3] = true;
        return captionBackgroundPainter;
    }

    public static C13181b<CaptionBackgroundPainter> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesCaptionBackgroundPainterFactory applicationModule_ProvidesCaptionBackgroundPainterFactory = new ApplicationModule_ProvidesCaptionBackgroundPainterFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesCaptionBackgroundPainterFactory;
    }

    public static CaptionBackgroundPainter proxyProvidesCaptionBackgroundPainter(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        CaptionBackgroundPainter providesCaptionBackgroundPainter = instance.providesCaptionBackgroundPainter();
        $jacocoInit[5] = true;
        return providesCaptionBackgroundPainter;
    }
}
