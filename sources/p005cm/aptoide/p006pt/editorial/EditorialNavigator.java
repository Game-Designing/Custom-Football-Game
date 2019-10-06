package p005cm.aptoide.p006pt.editorial;

import android.net.Uri;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;

/* renamed from: cm.aptoide.pt.editorial.EditorialNavigator */
public class EditorialNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountNavigator accountNavigator;
    private final ActivityNavigator activityNavigator;
    private final AppNavigator appNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8495272370340259728L, "cm/aptoide/pt/editorial/EditorialNavigator", 4);
        $jacocoData = probes;
        return probes;
    }

    public EditorialNavigator(ActivityNavigator activityNavigator2, AppNavigator appNavigator2, AccountNavigator accountNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityNavigator = activityNavigator2;
        this.appNavigator = appNavigator2;
        this.accountNavigator = accountNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToUri(String uri) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityNavigator.navigateTo(Uri.parse(uri));
        $jacocoInit[1] = true;
    }

    public void navigateToAppView(long appId, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAppId(appId, packageName, OpenType.OPEN_ONLY, "");
        $jacocoInit[2] = true;
    }

    public void navigateToLogIn() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.EDITORIAL);
        $jacocoInit[3] = true;
    }
}
