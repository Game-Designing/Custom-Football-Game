package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.DownloadStatusMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_DownloadStatusMapperFactory */
public final class ApplicationModule_DownloadStatusMapperFactory implements C13181b<DownloadStatusMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8064773036973041106L, "cm/aptoide/pt/ApplicationModule_DownloadStatusMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_DownloadStatusMapperFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public DownloadStatusMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        DownloadStatusMapper downloadStatusMapper = applicationModule.downloadStatusMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(downloadStatusMapper, "Cannot return null from a non-@Nullable @Provides method");
        DownloadStatusMapper downloadStatusMapper2 = downloadStatusMapper;
        $jacocoInit[3] = true;
        return downloadStatusMapper2;
    }

    public static C13181b<DownloadStatusMapper> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_DownloadStatusMapperFactory applicationModule_DownloadStatusMapperFactory = new ApplicationModule_DownloadStatusMapperFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_DownloadStatusMapperFactory;
    }

    public static DownloadStatusMapper proxyDownloadStatusMapper(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStatusMapper downloadStatusMapper = instance.downloadStatusMapper();
        $jacocoInit[5] = true;
        return downloadStatusMapper;
    }
}
