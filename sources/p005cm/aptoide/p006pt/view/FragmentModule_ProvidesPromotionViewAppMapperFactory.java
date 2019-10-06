package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.promotions.PromotionViewAppMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesPromotionViewAppMapperFactory */
public final class FragmentModule_ProvidesPromotionViewAppMapperFactory implements C13181b<PromotionViewAppMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-362602046781302864L, "cm/aptoide/pt/view/FragmentModule_ProvidesPromotionViewAppMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesPromotionViewAppMapperFactory(FragmentModule module2, Provider<DownloadStateParser> downloadStateParserProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.downloadStateParserProvider = downloadStateParserProvider2;
        $jacocoInit[0] = true;
    }

    public PromotionViewAppMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<DownloadStateParser> provider = this.downloadStateParserProvider;
        $jacocoInit[1] = true;
        PromotionViewAppMapper providesPromotionViewAppMapper = fragmentModule.providesPromotionViewAppMapper((DownloadStateParser) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesPromotionViewAppMapper, "Cannot return null from a non-@Nullable @Provides method");
        PromotionViewAppMapper promotionViewAppMapper = providesPromotionViewAppMapper;
        $jacocoInit[3] = true;
        return promotionViewAppMapper;
    }

    public static C13181b<PromotionViewAppMapper> create(FragmentModule module2, Provider<DownloadStateParser> downloadStateParserProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesPromotionViewAppMapperFactory fragmentModule_ProvidesPromotionViewAppMapperFactory = new FragmentModule_ProvidesPromotionViewAppMapperFactory(module2, downloadStateParserProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesPromotionViewAppMapperFactory;
    }

    public static PromotionViewAppMapper proxyProvidesPromotionViewAppMapper(FragmentModule instance, DownloadStateParser downloadStateParser) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewAppMapper providesPromotionViewAppMapper = instance.providesPromotionViewAppMapper(downloadStateParser);
        $jacocoInit[5] = true;
        return providesPromotionViewAppMapper;
    }
}
