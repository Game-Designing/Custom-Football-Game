package p005cm.aptoide.p006pt.navigator;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.navigator.ActivityResultNavigator_MembersInjector */
public final class ActivityResultNavigator_MembersInjector implements C13183b<ActivityResultNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2896910883399685790L, "cm/aptoide/pt/navigator/ActivityResultNavigator_MembersInjector", 9);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ActivityResultNavigator) obj);
        $jacocoInit[8] = true;
    }

    public ActivityResultNavigator_MembersInjector(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ActivityResultNavigator> create(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityResultNavigator_MembersInjector activityResultNavigator_MembersInjector = new ActivityResultNavigator_MembersInjector(accountNavigatorProvider2, marketNameProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return activityResultNavigator_MembersInjector;
    }

    public void injectMembers(ActivityResultNavigator instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAccountNavigator(instance, (AccountNavigator) this.accountNavigatorProvider.get());
        $jacocoInit[2] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[3] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[4] = true;
    }

    public static void injectAccountNavigator(ActivityResultNavigator instance, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountNavigator = accountNavigator;
        $jacocoInit[5] = true;
    }

    public static void injectMarketName(ActivityResultNavigator instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[6] = true;
    }

    public static void injectTheme(ActivityResultNavigator instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[7] = true;
    }
}
