package p005cm.aptoide.p006pt.app.view;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.p000v4.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.ads.data.AptoideNativeAd;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.app.view.donations.view.DonateDialogFragment;
import p005cm.aptoide.p006pt.app.view.screenshots.ScreenshotsViewerFragment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.view.FragmentProvider;

/* renamed from: cm.aptoide.pt.app.view.AppViewNavigator */
public class AppViewNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityNavigator activityNavigator;
    private final AppNavigator appNavigator;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3610766426346742573L, "cm/aptoide/pt/app/view/AppViewNavigator", 37);
        $jacocoData = probes;
        return probes;
    }

    public AppViewNavigator(FragmentNavigator fragmentNavigator2, ActivityNavigator activityNavigator2, AppNavigator appNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.activityNavigator = activityNavigator2;
        this.appNavigator = appNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToScreenshots(ArrayList<String> imagesUris, int currentPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = ScreenshotsViewerFragment.newInstance(imagesUris, currentPosition);
        $jacocoInit[1] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[2] = true;
    }

    public void navigateToUri(Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityNavigator.navigateTo(uri);
        $jacocoInit[3] = true;
    }

    public void navigateToOtherVersions(String appName, String icon, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(OtherVersionsFragment.newInstance(appName, icon, packageName), true);
        $jacocoInit[4] = true;
    }

    public void navigateToAppView(long appId, String packageName, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAppId(appId, packageName, OpenType.OPEN_ONLY, tag);
        $jacocoInit[5] = true;
    }

    public void navigateToAd(AptoideNativeAd ad, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAd(new SearchAdResult(ad), tag);
        $jacocoInit[6] = true;
    }

    public void navigateToDescriptionReadMore(String name, String description, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[7] = true;
        Fragment fragment = fragmentProvider.newDescriptionFragment(name, description, theme);
        $jacocoInit[8] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[9] = true;
    }

    public void buyApp(long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = this.fragmentNavigator.peekLast();
        $jacocoInit[10] = true;
        if (fragment == null) {
            $jacocoInit[11] = true;
        } else if (!AppViewFragment.class.isAssignableFrom(fragment.getClass())) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            ((AppViewFragment) fragment).buyApp(appId);
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
    }

    public void navigateToStore(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[16] = true;
        String name = store.getName();
        Appearance appearance = store.getAppearance();
        $jacocoInit[17] = true;
        String theme = appearance.getTheme();
        $jacocoInit[18] = true;
        Fragment newStoreFragment = fragmentProvider.newStoreFragment(name, theme);
        $jacocoInit[19] = true;
        fragmentNavigator2.navigateTo(newStoreFragment, true);
        $jacocoInit[20] = true;
    }

    public void navigateToRateAndReview(long appId, String appName, String storeName, String packageName, String storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[21] = true;
        RateAndReviewsFragment newInstance = RateAndReviewsFragment.newInstance(appId, appName, storeName, packageName, storeTheme);
        $jacocoInit[22] = true;
        fragmentNavigator2.navigateTo(newInstance, true);
        $jacocoInit[23] = true;
    }

    public void navigateToAppCoinsInfo() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(new AppCoinsInfoFragment(), true);
        $jacocoInit[24] = true;
    }

    public void navigateToDonationsDialog(String packageName, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasWallet = hasWallet();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[25] = true;
        DonateDialogFragment newInstance = DonateDialogFragment.newInstance(packageName, hasWallet);
        $jacocoInit[26] = true;
        fragmentNavigator2.navigateToDialogFragment(newInstance);
        $jacocoInit[27] = true;
    }

    private boolean hasWallet() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent("android.intent.action.VIEW");
        $jacocoInit[28] = true;
        Uri uri = Uri.parse("ethereum:");
        $jacocoInit[29] = true;
        intent.setData(uri);
        $jacocoInit[30] = true;
        Activity activity = this.activityNavigator.getActivity();
        $jacocoInit[31] = true;
        PackageManager manager = activity.getPackageManager();
        $jacocoInit[32] = true;
        boolean z = false;
        List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
        $jacocoInit[33] = true;
        if (!infos.isEmpty()) {
            $jacocoInit[34] = true;
            z = true;
        } else {
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
        return z;
    }
}
