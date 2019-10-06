package p005cm.aptoide.p006pt.view;

import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.AppViewFragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.BundleKeys;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.view.AppCoinsInfoNavigator */
public class AppCoinsInfoNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final String APPC_WALLET_PACKAGE_NAME = "com.appcoins.wallet";
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8436532425909059051L, "cm/aptoide/pt/view/AppCoinsInfoNavigator", 7);
        $jacocoData = probes;
        return probes;
    }

    public AppCoinsInfoNavigator(FragmentNavigator fragmentNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToAppCoinsWallet() {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewFragment appViewFragment = new AppViewFragment();
        $jacocoInit[1] = true;
        Bundle bundle = new Bundle();
        $jacocoInit[2] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), APPC_WALLET_PACKAGE_NAME);
        $jacocoInit[3] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), "catappult");
        $jacocoInit[4] = true;
        appViewFragment.setArguments(bundle);
        $jacocoInit[5] = true;
        this.fragmentNavigator.navigateTo(appViewFragment, true);
        $jacocoInit[6] = true;
    }
}
