package p005cm.aptoide.p006pt.account.view.user;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.LoginSignupManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.account.view.user.ProfileStepOneFragment_MembersInjector */
public final class ProfileStepOneFragment_MembersInjector implements C13183b<ProfileStepOneFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<LoginSignupManager> loginSignupManagerProvider;
    private final Provider<ScreenOrientationManager> orientationManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(616439368533175975L, "cm/aptoide/pt/account/view/user/ProfileStepOneFragment_MembersInjector", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ProfileStepOneFragment) obj);
        $jacocoInit[10] = true;
    }

    public ProfileStepOneFragment_MembersInjector(Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<LoginSignupManager> loginSignupManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManagerProvider = orientationManagerProvider2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        this.loginSignupManagerProvider = loginSignupManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ProfileStepOneFragment> create(Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<LoginSignupManager> loginSignupManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ProfileStepOneFragment_MembersInjector profileStepOneFragment_MembersInjector = new ProfileStepOneFragment_MembersInjector(orientationManagerProvider2, accountNavigatorProvider2, accountAnalyticsProvider2, loginSignupManagerProvider2);
        $jacocoInit[1] = true;
        return profileStepOneFragment_MembersInjector;
    }

    public void injectMembers(ProfileStepOneFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectOrientationManager(instance, (ScreenOrientationManager) this.orientationManagerProvider.get());
        $jacocoInit[2] = true;
        injectAccountNavigator(instance, (AccountNavigator) this.accountNavigatorProvider.get());
        $jacocoInit[3] = true;
        injectAccountAnalytics(instance, (AccountAnalytics) this.accountAnalyticsProvider.get());
        $jacocoInit[4] = true;
        injectLoginSignupManager(instance, (LoginSignupManager) this.loginSignupManagerProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectOrientationManager(ProfileStepOneFragment instance, ScreenOrientationManager orientationManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.orientationManager = orientationManager;
        $jacocoInit[6] = true;
    }

    public static void injectAccountNavigator(ProfileStepOneFragment instance, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountNavigator = accountNavigator;
        $jacocoInit[7] = true;
    }

    public static void injectAccountAnalytics(ProfileStepOneFragment instance, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountAnalytics = accountAnalytics;
        $jacocoInit[8] = true;
    }

    public static void injectLoginSignupManager(ProfileStepOneFragment instance, LoginSignupManager loginSignupManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.loginSignupManager = loginSignupManager;
        $jacocoInit[9] = true;
    }
}
