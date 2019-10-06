package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.view.app.ListStoreAppsNavigator */
public class ListStoreAppsNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppNavigator appNavigator;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6990126607936997253L, "cm/aptoide/pt/view/app/ListStoreAppsNavigator", 2);
        $jacocoData = probes;
        return probes;
    }

    public ListStoreAppsNavigator(FragmentNavigator fragmentNavigator2, AppNavigator appNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.appNavigator = appNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToAppView(long appId, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAppId(appId, packageName, OpenType.OPEN_ONLY, "");
        $jacocoInit[1] = true;
    }
}
