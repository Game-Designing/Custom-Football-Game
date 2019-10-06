package p005cm.aptoide.p006pt.home;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.MoreBundleFragment;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment.BundleCons;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.HomeContainerNavigator */
public class HomeContainerNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String appsTag;
    private FragmentNavigator childFragmentNavigator;
    private String gamesTag;
    private String homeTag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8998851408601351515L, "cm/aptoide/pt/home/HomeContainerNavigator", 37);
        $jacocoData = probes;
        return probes;
    }

    public HomeContainerNavigator(FragmentNavigator childFragmentNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.childFragmentNavigator = childFragmentNavigator2;
        $jacocoInit[0] = true;
    }

    public void loadMainHomeContent() {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = this.childFragmentNavigator.getFragment(this.homeTag);
        if (fragment != null) {
            $jacocoInit[1] = true;
            this.childFragmentNavigator.navigateToWithoutBackSave(fragment, true);
            $jacocoInit[2] = true;
        } else {
            this.homeTag = this.childFragmentNavigator.navigateTo(new HomeFragment(), true);
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }

    public void loadGamesHomeContent() {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = new MoreBundleFragment();
        $jacocoInit[5] = true;
        Bundle args = new Bundle();
        FragmentNavigator fragmentNavigator = this.childFragmentNavigator;
        $jacocoInit[6] = true;
        Fragment fragment2 = fragmentNavigator.getFragment();
        $jacocoInit[7] = true;
        String string = fragment2.getString(C1375R.string.home_chip_games);
        $jacocoInit[8] = true;
        args.putString("title", string);
        $jacocoInit[9] = true;
        args.putString("action", "https://ws75.aptoide.com/api/7/getStoreWidgets/store_id=15/context=games/widget=apps_list%3A0%262%3Adownloads7d");
        $jacocoInit[10] = true;
        args.putBoolean(BundleCons.TOOLBAR, false);
        $jacocoInit[11] = true;
        fragment.setArguments(args);
        $jacocoInit[12] = true;
        Fragment gamesFragment = this.childFragmentNavigator.getFragment(this.gamesTag);
        if (gamesFragment != null) {
            $jacocoInit[13] = true;
            this.childFragmentNavigator.navigateToWithoutBackSave(gamesFragment, true);
            $jacocoInit[14] = true;
        } else {
            this.gamesTag = this.childFragmentNavigator.navigateTo(fragment, true);
            $jacocoInit[15] = true;
        }
        $jacocoInit[16] = true;
    }

    public void loadAppsHomeContent() {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = new MoreBundleFragment();
        $jacocoInit[17] = true;
        Bundle args = new Bundle();
        FragmentNavigator fragmentNavigator = this.childFragmentNavigator;
        $jacocoInit[18] = true;
        Fragment fragment2 = fragmentNavigator.getFragment();
        $jacocoInit[19] = true;
        String string = fragment2.getString(C1375R.string.home_chip_apps);
        $jacocoInit[20] = true;
        args.putString("title", string);
        $jacocoInit[21] = true;
        args.putString("action", "https://ws75.aptoide.com/api/7/getStoreWidgets/store_id=15/context=apps/widget=apps_list%3A0%261%3Apdownloads7d");
        $jacocoInit[22] = true;
        args.putBoolean(BundleCons.TOOLBAR, false);
        $jacocoInit[23] = true;
        fragment.setArguments(args);
        $jacocoInit[24] = true;
        Fragment appsFragment = this.childFragmentNavigator.getFragment(this.appsTag);
        if (appsFragment != null) {
            $jacocoInit[25] = true;
            this.childFragmentNavigator.navigateToWithoutBackSave(appsFragment, true);
            $jacocoInit[26] = true;
        } else {
            this.appsTag = this.childFragmentNavigator.navigateTo(fragment, true);
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
    }

    public C0120S<Boolean> navigateHome() {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = this.childFragmentNavigator.getFragment();
        if (!(fragment instanceof ScrollableView)) {
            $jacocoInit[29] = true;
        } else {
            ScrollableView view = (ScrollableView) fragment;
            $jacocoInit[30] = true;
            if (!view.isAtTop()) {
                $jacocoInit[31] = true;
            } else if (!(fragment instanceof MoreBundleFragment)) {
                $jacocoInit[32] = true;
            } else {
                $jacocoInit[33] = true;
                C0120S<Boolean> c = C0120S.m652c(Boolean.valueOf(true));
                $jacocoInit[34] = true;
                return c;
            }
            view.scrollToTop();
            $jacocoInit[35] = true;
        }
        C0120S<Boolean> c2 = C0120S.m652c(Boolean.valueOf(false));
        $jacocoInit[36] = true;
        return c2;
    }
}
