package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDownloadStateParserFactory */
public final class ApplicationModule_ProvidesDownloadStateParserFactory implements C13181b<DownloadStateParser> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7620431726680004364L, "cm/aptoide/pt/ApplicationModule_ProvidesDownloadStateParserFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDownloadStateParserFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public DownloadStateParser get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        DownloadStateParser providesDownloadStateParser = applicationModule.providesDownloadStateParser();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesDownloadStateParser, "Cannot return null from a non-@Nullable @Provides method");
        DownloadStateParser downloadStateParser = providesDownloadStateParser;
        $jacocoInit[3] = true;
        return downloadStateParser;
    }

    public static C13181b<DownloadStateParser> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDownloadStateParserFactory applicationModule_ProvidesDownloadStateParserFactory = new ApplicationModule_ProvidesDownloadStateParserFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesDownloadStateParserFactory;
    }

    public static DownloadStateParser proxyProvidesDownloadStateParser(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser providesDownloadStateParser = instance.providesDownloadStateParser();
        $jacocoInit[5] = true;
        return providesDownloadStateParser;
    }
}
