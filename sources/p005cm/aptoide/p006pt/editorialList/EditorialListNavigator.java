package p005cm.aptoide.p006pt.editorialList;

import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListNavigator */
public class EditorialListNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountNavigator accountNavigator;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8862402317465004346L, "cm/aptoide/pt/editorialList/EditorialListNavigator", 9);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListNavigator(FragmentNavigator fragmentNavigator2, AccountNavigator accountNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.accountNavigator = accountNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToEditorial(String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[1] = true;
        bundle.putString("cardId", cardId);
        $jacocoInit[2] = true;
        bundle.putBoolean(EditorialFragment.FROM_HOME, false);
        $jacocoInit[3] = true;
        EditorialFragment fragment = new EditorialFragment();
        $jacocoInit[4] = true;
        fragment.setArguments(bundle);
        $jacocoInit[5] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[6] = true;
    }

    public void navigateToMyAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
        $jacocoInit[7] = true;
    }

    public void navigateToLogIn() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.EDITORIAL);
        $jacocoInit[8] = true;
    }
}
