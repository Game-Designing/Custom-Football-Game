package p005cm.aptoide.p006pt.promotions;

import android.content.Intent;
import android.net.Uri;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionsNavigator */
public class ClaimPromotionsNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityResultNavigator activityResultNavigator;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3124832587604347757L, "cm/aptoide/pt/promotions/ClaimPromotionsNavigator", 5);
        $jacocoData = probes;
        return probes;
    }

    public ClaimPromotionsNavigator(FragmentNavigator fragmentNavigator2, ActivityResultNavigator activityResultNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.activityResultNavigator = activityResultNavigator2;
        $jacocoInit[0] = true;
    }

    public void popDialogWithResult(String packageName, int status) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        Intent intent = new Intent();
        $jacocoInit[1] = true;
        Result result = new Result(6666, status, intent.setPackage(packageName));
        $jacocoInit[2] = true;
        fragmentNavigator2.popDialogWithResult(result);
        $jacocoInit[3] = true;
    }

    public void fetchWalletAddressByIntent(String uriAction, int requestCode, String extraKey, String extraValue) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityResultNavigator.navigateForResult("android.intent.action.VIEW", Uri.parse(uriAction), requestCode, extraKey, extraValue);
        $jacocoInit[4] = true;
    }
}
