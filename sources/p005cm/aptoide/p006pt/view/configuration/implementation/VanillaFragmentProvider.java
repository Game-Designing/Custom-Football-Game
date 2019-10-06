package p005cm.aptoide.p006pt.view.configuration.implementation;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14377B;
import p005cm.aptoide.p006pt.app.view.AppViewFragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.BundleKeys;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.reviews.LatestReviewsFragment;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.store.view.StoreFragment;
import p005cm.aptoide.p006pt.store.view.StoreFragment.OpenType;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowersFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowingFragment;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.fragment.DescriptionFragment;
import p005cm.aptoide.p006pt.view.settings.SettingsFragment;

/* renamed from: cm.aptoide.pt.view.configuration.implementation.VanillaFragmentProvider */
public class VanillaFragmentProvider implements FragmentProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8281764953402930853L, "cm/aptoide/pt/view/configuration/implementation/VanillaFragmentProvider", 59);
        $jacocoData = probes;
        return probes;
    }

    public VanillaFragmentProvider() {
        $jacocoInit()[0] = true;
    }

    public Fragment newStoreFragment(String storeName, String storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreFragment newInstance = StoreFragment.newInstance(storeName, storeTheme);
        $jacocoInit[1] = true;
        return newInstance;
    }

    public Fragment newStoreFragment(String storeName, String storeTheme, OpenType openType) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreFragment newInstance = StoreFragment.newInstance(storeName, storeTheme, openType);
        $jacocoInit[2] = true;
        return newInstance;
    }

    public Fragment newStoreFragment(long userId, String storeTheme, OpenType openType) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreFragment newInstance = StoreFragment.newInstance(userId, storeTheme, openType);
        $jacocoInit[3] = true;
        return newInstance;
    }

    public Fragment newAppViewFragment(long appId, String packageName, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[4] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[5] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[6] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[7] = true;
        bundle.putSerializable(BundleKeys.SHOULD_INSTALL.name(), AppViewFragment.OpenType.OPEN_ONLY);
        $jacocoInit[8] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[9] = true;
        fragment.setArguments(bundle);
        $jacocoInit[10] = true;
        return fragment;
    }

    public Fragment newAppViewFragment(long appId, String packageName, String storeTheme, String storeName, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[11] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[12] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[13] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[14] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), storeName);
        $jacocoInit[15] = true;
        bundle.putString(BundleKeys.STORE_THEME.name(), storeTheme);
        $jacocoInit[16] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[17] = true;
        fragment.setArguments(bundle);
        $jacocoInit[18] = true;
        return fragment;
    }

    public Fragment newAppViewFragment(long appId, String packageName, String storeTheme, String storeName, String tag, String editorsBrickPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[19] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[20] = true;
        bundle.putString(BundleKeys.EDITORS_CHOICE_POSITION.name(), editorsBrickPosition);
        $jacocoInit[21] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[22] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[23] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), storeName);
        $jacocoInit[24] = true;
        bundle.putString(BundleKeys.STORE_THEME.name(), storeTheme);
        $jacocoInit[25] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[26] = true;
        fragment.setArguments(bundle);
        $jacocoInit[27] = true;
        return fragment;
    }

    public Fragment newAppViewFragment(SearchAdResult searchAdResult, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[28] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), searchAdResult.getAppId());
        $jacocoInit[29] = true;
        String name = BundleKeys.PACKAGE_NAME.name();
        $jacocoInit[30] = true;
        String packageName = searchAdResult.getPackageName();
        $jacocoInit[31] = true;
        bundle.putString(name, packageName);
        $jacocoInit[32] = true;
        String name2 = BundleKeys.MINIMAL_AD.name();
        $jacocoInit[33] = true;
        Parcelable a = C14377B.m45944a(searchAdResult);
        $jacocoInit[34] = true;
        bundle.putParcelable(name2, a);
        $jacocoInit[35] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[36] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[37] = true;
        fragment.setArguments(bundle);
        $jacocoInit[38] = true;
        return fragment;
    }

    public Fragment newAppViewFragment(String packageName, AppViewFragment.OpenType openType) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[39] = true;
        if (TextUtils.isEmpty(packageName)) {
            $jacocoInit[40] = true;
        } else {
            $jacocoInit[41] = true;
            bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
            $jacocoInit[42] = true;
        }
        bundle.putSerializable(BundleKeys.SHOULD_INSTALL.name(), openType);
        $jacocoInit[43] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), null);
        $jacocoInit[44] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[45] = true;
        fragment.setArguments(bundle);
        $jacocoInit[46] = true;
        return fragment;
    }

    public Fragment newLatestReviewsFragment(long storeId, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        LatestReviewsFragment newInstance = LatestReviewsFragment.newInstance(storeId, storeContext);
        $jacocoInit[47] = true;
        return newInstance;
    }

    public Fragment newStoreTabGridRecyclerFragment(Event event, String storeTheme, String tag, StoreContext storeContext, boolean addAdultFilter) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment newInstance = StoreTabGridRecyclerFragment.newInstance(event, storeTheme, tag, storeContext);
        $jacocoInit[48] = true;
        return newInstance;
    }

    public Fragment newStoreTabGridRecyclerFragment(Event event, String title, String storeTheme, String tag, StoreContext storeContext, boolean addAdultFilter) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment newInstance = StoreTabGridRecyclerFragment.newInstance(event, title, storeTheme, tag, storeContext);
        $jacocoInit[49] = true;
        return newInstance;
    }

    public Fragment newSubscribedStoresFragment(Event event, String storeTheme, String tag, StoreContext storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresFragment newInstance = MyStoresFragment.newInstance(event, storeTheme, tag, storeName);
        $jacocoInit[50] = true;
        return newInstance;
    }

    public Fragment newRateAndReviewsFragment(long appId, String appName, String storeName, String packageName, long reviewId) {
        boolean[] $jacocoInit = $jacocoInit();
        RateAndReviewsFragment newInstance = RateAndReviewsFragment.newInstance(appId, appName, storeName, packageName, reviewId);
        $jacocoInit[51] = true;
        return newInstance;
    }

    public Fragment newDescriptionFragment(String appName, String description, String storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        DescriptionFragment newInstance = DescriptionFragment.newInstance(appName, description, storeTheme);
        $jacocoInit[52] = true;
        return newInstance;
    }

    public Fragment newSettingsFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment newInstance = SettingsFragment.newInstance();
        $jacocoInit[53] = true;
        return newInstance;
    }

    public Fragment newTimeLineFollowersUsingUserIdFragment(Long userId, String storeTheme, String title, StoreContext storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        TimeLineFollowFragment newInstanceUsingUser = TimeLineFollowersFragment.newInstanceUsingUser(userId, storeTheme, title, storeName);
        $jacocoInit[54] = true;
        return newInstanceUsingUser;
    }

    public Fragment newTimeLineFollowingFragmentUsingUserId(Long id, String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        TimeLineFollowFragment newInstanceUsingUserId = TimeLineFollowingFragment.newInstanceUsingUserId(id, storeTheme, title, storeContext);
        $jacocoInit[55] = true;
        return newInstanceUsingUserId;
    }

    public Fragment newTimeLineFollowersUsingStoreIdFragment(Long storeId, String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        TimeLineFollowFragment newInstanceUsingStore = TimeLineFollowersFragment.newInstanceUsingStore(storeId, storeTheme, title, storeContext);
        $jacocoInit[56] = true;
        return newInstanceUsingStore;
    }

    public Fragment newTimeLineFollowingFragmentUsingStoreId(Long id, String storeTheme, String title, StoreContext storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        TimeLineFollowFragment newInstanceUsingStoreId = TimeLineFollowingFragment.newInstanceUsingStoreId(id, storeTheme, title, storeName);
        $jacocoInit[57] = true;
        return newInstanceUsingStoreId;
    }

    public Fragment newTimeLineFollowersFragment(String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        TimeLineFollowFragment newInstanceUsingUser = TimeLineFollowersFragment.newInstanceUsingUser(storeTheme, title, storeContext);
        $jacocoInit[58] = true;
        return newInstanceUsingUser;
    }
}
