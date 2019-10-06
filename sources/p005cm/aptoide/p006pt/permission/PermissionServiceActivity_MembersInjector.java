package p005cm.aptoide.p006pt.permission;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator_MembersInjector;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.permission.PermissionServiceActivity_MembersInjector */
public final class PermissionServiceActivity_MembersInjector implements C13183b<PermissionServiceActivity> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5013521739750760769L, "cm/aptoide/pt/permission/PermissionServiceActivity_MembersInjector", 8);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((PermissionServiceActivity) obj);
        $jacocoInit[7] = true;
    }

    public PermissionServiceActivity_MembersInjector(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<PermissionServiceActivity> create(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        PermissionServiceActivity_MembersInjector permissionServiceActivity_MembersInjector = new PermissionServiceActivity_MembersInjector(accountNavigatorProvider2, marketNameProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return permissionServiceActivity_MembersInjector;
    }

    public void injectMembers(PermissionServiceActivity instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AccountNavigator> provider = this.accountNavigatorProvider;
        $jacocoInit[2] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider.get();
        $jacocoInit[3] = true;
        ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
        $jacocoInit[4] = true;
        ActivityResultNavigator_MembersInjector.injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[5] = true;
        ActivityResultNavigator_MembersInjector.injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[6] = true;
    }
}
