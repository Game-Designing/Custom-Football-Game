package p005cm.aptoide.p006pt.promotions;

import android.content.Intent;
import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.HomeContainerFragment;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.promotions.PromotionsNavigator */
public class PromotionsNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final int CLAIM_REQUEST_CODE = 6666;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5327159818966236493L, "cm/aptoide/pt/promotions/PromotionsNavigator", 16);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsNavigator(FragmentNavigator fragmentNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToClaimDialog(String packageName, String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionDialogFragment fragment = new ClaimPromotionDialogFragment();
        $jacocoInit[1] = true;
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putString("package_name", packageName);
        $jacocoInit[3] = true;
        args.putString("promotion_id", promotionId);
        $jacocoInit[4] = true;
        fragment.setArguments(args);
        $jacocoInit[5] = true;
        this.fragmentNavigator.navigateToDialogForResult(fragment, CLAIM_REQUEST_CODE);
        $jacocoInit[6] = true;
    }

    public C0120S<ClaimDialogResultWrapper> claimDialogResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S results = this.fragmentNavigator.results(CLAIM_REQUEST_CODE);
        C4503Za za = C4503Za.f8119a;
        $jacocoInit[7] = true;
        C0120S<ClaimDialogResultWrapper> j = results.mo3669j(za);
        $jacocoInit[8] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ ClaimDialogResultWrapper m8893a(Result result) {
        String str;
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getData() != null) {
            Intent data = result.getData();
            $jacocoInit[10] = true;
            str = data.getPackage();
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            str = "";
        }
        if (result.getResultCode() == -1) {
            $jacocoInit[13] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[14] = true;
        }
        ClaimDialogResultWrapper claimDialogResultWrapper = new ClaimDialogResultWrapper(str, z);
        $jacocoInit[15] = true;
        return claimDialogResultWrapper;
    }

    public void navigateToHome() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateToCleaningBackStack(new HomeContainerFragment(), true);
        $jacocoInit[9] = true;
    }
}
