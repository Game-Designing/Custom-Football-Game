package p005cm.aptoide.p006pt.account.view.user;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.LoginSignupManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.account.view.user.ProfileStepTwoFragment_MembersInjector */
public final class ProfileStepTwoFragment_MembersInjector implements C13183b<ProfileStepTwoFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<LoginSignupManager> loginSignupManagerProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2190344184995459612L, "cm/aptoide/pt/account/view/user/ProfileStepTwoFragment_MembersInjector", 9);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ProfileStepTwoFragment) obj);
        $jacocoInit[8] = true;
    }

    public ProfileStepTwoFragment_MembersInjector(Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<LoginSignupManager> loginSignupManagerProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        this.loginSignupManagerProvider = loginSignupManagerProvider2;
        this.marketResourceFormatterProvider = marketResourceFormatterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ProfileStepTwoFragment> create(Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<LoginSignupManager> loginSignupManagerProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ProfileStepTwoFragment_MembersInjector profileStepTwoFragment_MembersInjector = new ProfileStepTwoFragment_MembersInjector(accountAnalyticsProvider2, loginSignupManagerProvider2, marketResourceFormatterProvider2);
        $jacocoInit[1] = true;
        return profileStepTwoFragment_MembersInjector;
    }

    public void injectMembers(ProfileStepTwoFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAccountAnalytics(instance, (AccountAnalytics) this.accountAnalyticsProvider.get());
        $jacocoInit[2] = true;
        injectLoginSignupManager(instance, (LoginSignupManager) this.loginSignupManagerProvider.get());
        $jacocoInit[3] = true;
        injectMarketResourceFormatter(instance, (MarketResourceFormatter) this.marketResourceFormatterProvider.get());
        $jacocoInit[4] = true;
    }

    public static void injectAccountAnalytics(ProfileStepTwoFragment instance, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountAnalytics = accountAnalytics;
        $jacocoInit[5] = true;
    }

    public static void injectLoginSignupManager(ProfileStepTwoFragment instance, LoginSignupManager loginSignupManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.loginSignupManager = loginSignupManager;
        $jacocoInit[6] = true;
    }

    public static void injectMarketResourceFormatter(ProfileStepTwoFragment instance, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketResourceFormatter = marketResourceFormatter;
        $jacocoInit[7] = true;
    }
}
