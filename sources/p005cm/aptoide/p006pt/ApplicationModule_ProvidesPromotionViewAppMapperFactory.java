package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.promotions.PromotionViewAppMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesPromotionViewAppMapperFactory */
public final class ApplicationModule_ProvidesPromotionViewAppMapperFactory implements C13181b<PromotionViewAppMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-765245995249511106L, "cm/aptoide/pt/ApplicationModule_ProvidesPromotionViewAppMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesPromotionViewAppMapperFactory(ApplicationModule module2, Provider<DownloadStateParser> downloadStateParserProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadStateParserProvider = downloadStateParserProvider2;
        $jacocoInit[0] = true;
    }

    public PromotionViewAppMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<DownloadStateParser> provider = this.downloadStateParserProvider;
        $jacocoInit[1] = true;
        PromotionViewAppMapper providesPromotionViewAppMapper = applicationModule.providesPromotionViewAppMapper((DownloadStateParser) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesPromotionViewAppMapper, "Cannot return null from a non-@Nullable @Provides method");
        PromotionViewAppMapper promotionViewAppMapper = providesPromotionViewAppMapper;
        $jacocoInit[3] = true;
        return promotionViewAppMapper;
    }

    public static C13181b<PromotionViewAppMapper> create(ApplicationModule module2, Provider<DownloadStateParser> downloadStateParserProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesPromotionViewAppMapperFactory applicationModule_ProvidesPromotionViewAppMapperFactory = new ApplicationModule_ProvidesPromotionViewAppMapperFactory(module2, downloadStateParserProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesPromotionViewAppMapperFactory;
    }

    public static PromotionViewAppMapper proxyProvidesPromotionViewAppMapper(ApplicationModule instance, DownloadStateParser downloadStateParser) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewAppMapper providesPromotionViewAppMapper = instance.providesPromotionViewAppMapper(downloadStateParser);
        $jacocoInit[5] = true;
        return providesPromotionViewAppMapper;
    }
}
