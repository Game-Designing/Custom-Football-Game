package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideMarketResourceFormatterFactory */
public final class ApplicationModule_ProvideMarketResourceFormatterFactory implements C13181b<MarketResourceFormatter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> marketNameProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7671441893885327994L, "cm/aptoide/pt/ApplicationModule_ProvideMarketResourceFormatterFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideMarketResourceFormatterFactory(ApplicationModule module2, Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.marketNameProvider = marketNameProvider2;
        $jacocoInit[0] = true;
    }

    public MarketResourceFormatter get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[1] = true;
        MarketResourceFormatter provideMarketResourceFormatter = applicationModule.provideMarketResourceFormatter((String) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideMarketResourceFormatter, "Cannot return null from a non-@Nullable @Provides method");
        MarketResourceFormatter marketResourceFormatter = provideMarketResourceFormatter;
        $jacocoInit[3] = true;
        return marketResourceFormatter;
    }

    public static C13181b<MarketResourceFormatter> create(ApplicationModule module2, Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideMarketResourceFormatterFactory applicationModule_ProvideMarketResourceFormatterFactory = new ApplicationModule_ProvideMarketResourceFormatterFactory(module2, marketNameProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideMarketResourceFormatterFactory;
    }

    public static MarketResourceFormatter proxyProvideMarketResourceFormatter(ApplicationModule instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        MarketResourceFormatter provideMarketResourceFormatter = instance.provideMarketResourceFormatter(marketName);
        $jacocoInit[5] = true;
        return provideMarketResourceFormatter;
    }
}
