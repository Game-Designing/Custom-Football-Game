package p005cm.aptoide.p006pt.app.view.donations.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.app.view.donations.WalletService;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.app.view.donations.view.DonateDialogFragment_MembersInjector */
public final class DonateDialogFragment_MembersInjector implements C13183b<DonateDialogFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<DonationsAnalytics> donationsAnalyticsProvider;
    private final Provider<String> themeProvider;
    private final Provider<WalletService> walletServiceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3698065899001800287L, "cm/aptoide/pt/app/view/donations/view/DonateDialogFragment_MembersInjector", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((DonateDialogFragment) obj);
        $jacocoInit[10] = true;
    }

    public DonateDialogFragment_MembersInjector(Provider<WalletService> walletServiceProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<DonationsAnalytics> donationsAnalyticsProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletServiceProvider = walletServiceProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        this.donationsAnalyticsProvider = donationsAnalyticsProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<DonateDialogFragment> create(Provider<WalletService> walletServiceProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<DonationsAnalytics> donationsAnalyticsProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        DonateDialogFragment_MembersInjector donateDialogFragment_MembersInjector = new DonateDialogFragment_MembersInjector(walletServiceProvider2, appNavigatorProvider2, donationsAnalyticsProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return donateDialogFragment_MembersInjector;
    }

    public void injectMembers(DonateDialogFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectWalletService(instance, (WalletService) this.walletServiceProvider.get());
        $jacocoInit[2] = true;
        injectAppNavigator(instance, (AppNavigator) this.appNavigatorProvider.get());
        $jacocoInit[3] = true;
        injectDonationsAnalytics(instance, (DonationsAnalytics) this.donationsAnalyticsProvider.get());
        $jacocoInit[4] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectWalletService(DonateDialogFragment instance, WalletService walletService) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.walletService = walletService;
        $jacocoInit[6] = true;
    }

    public static void injectAppNavigator(DonateDialogFragment instance, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appNavigator = appNavigator;
        $jacocoInit[7] = true;
    }

    public static void injectDonationsAnalytics(DonateDialogFragment instance, DonationsAnalytics donationsAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.donationsAnalytics = donationsAnalytics;
        $jacocoInit[8] = true;
    }

    public static void injectTheme(DonateDialogFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[9] = true;
    }
}
