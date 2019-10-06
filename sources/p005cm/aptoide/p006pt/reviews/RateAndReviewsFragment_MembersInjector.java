package p005cm.aptoide.p006pt.reviews;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.reviews.RateAndReviewsFragment_MembersInjector */
public final class RateAndReviewsFragment_MembersInjector implements C13183b<RateAndReviewsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4083924910428020721L, "cm/aptoide/pt/reviews/RateAndReviewsFragment_MembersInjector", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((RateAndReviewsFragment) obj);
        $jacocoInit[10] = true;
    }

    public RateAndReviewsFragment_MembersInjector(Provider<AppNavigator> appNavigatorProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigatorProvider = appNavigatorProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.marketResourceFormatterProvider = marketResourceFormatterProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<RateAndReviewsFragment> create(Provider<AppNavigator> appNavigatorProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        RateAndReviewsFragment_MembersInjector rateAndReviewsFragment_MembersInjector = new RateAndReviewsFragment_MembersInjector(appNavigatorProvider2, marketNameProvider2, marketResourceFormatterProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return rateAndReviewsFragment_MembersInjector;
    }

    public void injectMembers(RateAndReviewsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAppNavigator(instance, (AppNavigator) this.appNavigatorProvider.get());
        $jacocoInit[2] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[3] = true;
        injectMarketResourceFormatter(instance, (MarketResourceFormatter) this.marketResourceFormatterProvider.get());
        $jacocoInit[4] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectAppNavigator(RateAndReviewsFragment instance, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appNavigator = appNavigator;
        $jacocoInit[6] = true;
    }

    public static void injectMarketName(RateAndReviewsFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[7] = true;
    }

    public static void injectMarketResourceFormatter(RateAndReviewsFragment instance, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketResourceFormatter = marketResourceFormatter;
        $jacocoInit[8] = true;
    }

    public static void injectTheme(RateAndReviewsFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[9] = true;
    }
}
