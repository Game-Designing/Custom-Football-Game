package p005cm.aptoide.p006pt.view.settings;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.MyAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.settings.MyAccountFragment_MembersInjector */
public final class MyAccountFragment_MembersInjector implements C13183b<MyAccountFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<MarketResourceFormatter> marketFormatterProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MyAccountManager> myAccountManagerProvider;
    private final Provider<MyAccountNavigator> myAccountNavigatorProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2638184941984620498L, "cm/aptoide/pt/view/settings/MyAccountFragment_MembersInjector", 15);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((MyAccountFragment) obj);
        $jacocoInit[14] = true;
    }

    public MyAccountFragment_MembersInjector(Provider<MyAccountNavigator> myAccountNavigatorProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<MyAccountManager> myAccountManagerProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketFormatterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigatorProvider = myAccountNavigatorProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        this.myAccountManagerProvider = myAccountManagerProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.marketFormatterProvider = marketFormatterProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<MyAccountFragment> create(Provider<MyAccountNavigator> myAccountNavigatorProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<MyAccountManager> myAccountManagerProvider2, Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketFormatterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountFragment_MembersInjector myAccountFragment_MembersInjector = new MyAccountFragment_MembersInjector(myAccountNavigatorProvider2, accountAnalyticsProvider2, myAccountManagerProvider2, marketNameProvider2, marketFormatterProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return myAccountFragment_MembersInjector;
    }

    public void injectMembers(MyAccountFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMyAccountNavigator(instance, (MyAccountNavigator) this.myAccountNavigatorProvider.get());
        $jacocoInit[2] = true;
        injectAccountAnalytics(instance, (AccountAnalytics) this.accountAnalyticsProvider.get());
        $jacocoInit[3] = true;
        injectMyAccountManager(instance, (MyAccountManager) this.myAccountManagerProvider.get());
        $jacocoInit[4] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[5] = true;
        injectMarketFormatter(instance, (MarketResourceFormatter) this.marketFormatterProvider.get());
        $jacocoInit[6] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[7] = true;
    }

    public static void injectMyAccountNavigator(MyAccountFragment instance, MyAccountNavigator myAccountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.myAccountNavigator = myAccountNavigator;
        $jacocoInit[8] = true;
    }

    public static void injectAccountAnalytics(MyAccountFragment instance, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountAnalytics = accountAnalytics;
        $jacocoInit[9] = true;
    }

    public static void injectMyAccountManager(MyAccountFragment instance, MyAccountManager myAccountManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.myAccountManager = myAccountManager;
        $jacocoInit[10] = true;
    }

    public static void injectMarketName(MyAccountFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[11] = true;
    }

    public static void injectMarketFormatter(MyAccountFragment instance, MarketResourceFormatter marketFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketFormatter = marketFormatter;
        $jacocoInit[12] = true;
    }

    public static void injectTheme(MyAccountFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[13] = true;
    }
}
