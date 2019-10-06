package p005cm.aptoide.p006pt.account.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.presenter.LoginSignupCredentialsFlavorPresenter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment_MembersInjector */
public final class LoginSignUpCredentialsFragment_MembersInjector implements C13183b<LoginSignUpCredentialsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<ScreenOrientationManager> orientationManagerProvider;
    private final Provider<LoginSignupCredentialsFlavorPresenter> presenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-896163141620236028L, "cm/aptoide/pt/account/view/LoginSignUpCredentialsFragment_MembersInjector", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((LoginSignUpCredentialsFragment) obj);
        $jacocoInit[10] = true;
    }

    public LoginSignUpCredentialsFragment_MembersInjector(Provider<LoginSignupCredentialsFlavorPresenter> presenterProvider2, Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.orientationManagerProvider = orientationManagerProvider2;
        this.accountAnalyticsProvider = accountAnalyticsProvider2;
        this.marketNameProvider = marketNameProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<LoginSignUpCredentialsFragment> create(Provider<LoginSignupCredentialsFlavorPresenter> presenterProvider2, Provider<ScreenOrientationManager> orientationManagerProvider2, Provider<AccountAnalytics> accountAnalyticsProvider2, Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        LoginSignUpCredentialsFragment_MembersInjector loginSignUpCredentialsFragment_MembersInjector = new LoginSignUpCredentialsFragment_MembersInjector(presenterProvider2, orientationManagerProvider2, accountAnalyticsProvider2, marketNameProvider2);
        $jacocoInit[1] = true;
        return loginSignUpCredentialsFragment_MembersInjector;
    }

    public void injectMembers(LoginSignUpCredentialsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (LoginSignupCredentialsFlavorPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectOrientationManager(instance, (ScreenOrientationManager) this.orientationManagerProvider.get());
        $jacocoInit[3] = true;
        injectAccountAnalytics(instance, (AccountAnalytics) this.accountAnalyticsProvider.get());
        $jacocoInit[4] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectPresenter(LoginSignUpCredentialsFragment instance, LoginSignupCredentialsFlavorPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[6] = true;
    }

    public static void injectOrientationManager(LoginSignUpCredentialsFragment instance, ScreenOrientationManager orientationManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.orientationManager = orientationManager;
        $jacocoInit[7] = true;
    }

    public static void injectAccountAnalytics(LoginSignUpCredentialsFragment instance, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountAnalytics = accountAnalytics;
        $jacocoInit[8] = true;
    }

    public static void injectMarketName(LoginSignUpCredentialsFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[9] = true;
    }
}
