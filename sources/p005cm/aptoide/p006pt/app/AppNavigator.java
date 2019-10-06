package p005cm.aptoide.p006pt.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.parceler.C14377B;
import p005cm.aptoide.p006pt.app.view.AppViewFragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.BundleKeys;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;

/* renamed from: cm.aptoide.pt.app.AppNavigator */
public class AppNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4754299295919278015L, "cm/aptoide/pt/app/AppNavigator", 103);
        $jacocoData = probes;
        return probes;
    }

    public AppNavigator(FragmentNavigator fragmentNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateWithUname(String uname) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[1] = true;
        bundle.putString(BundleKeys.UNAME.name(), uname);
        $jacocoInit[2] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[3] = true;
        fragment.setArguments(bundle);
        $jacocoInit[4] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[5] = true;
    }

    public void navigateWithMd5(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[6] = true;
        bundle.putString(BundleKeys.MD5.name(), md5);
        $jacocoInit[7] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[8] = true;
        fragment.setArguments(bundle);
        $jacocoInit[9] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[10] = true;
    }

    public void navigateWithPackageName(String packageName, OpenType openType) {
        boolean[] $jacocoInit = $jacocoInit();
        navigateWithPackageAndStoreNames(packageName, null, openType);
        $jacocoInit[11] = true;
    }

    public void navigateWithPackageAndStoreNames(String packageName, String storeName, OpenType openType) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[12] = true;
        if (TextUtils.isEmpty(packageName)) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
            $jacocoInit[15] = true;
        }
        bundle.putSerializable(BundleKeys.SHOULD_INSTALL.name(), openType);
        $jacocoInit[16] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), storeName);
        $jacocoInit[17] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[18] = true;
        fragment.setArguments(bundle);
        $jacocoInit[19] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[20] = true;
    }

    public void navigateWithAppId(long appId, String packageName, OpenType openType, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[21] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[22] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[23] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[24] = true;
        bundle.putSerializable(BundleKeys.SHOULD_INSTALL.name(), openType);
        $jacocoInit[25] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[26] = true;
        fragment.setArguments(bundle);
        $jacocoInit[27] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[28] = true;
    }

    public void navigateWithDownloadUrlAndReward(long appId, String packageName, String tag, String downloadUrl, float appRewardAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[29] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[30] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[31] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[32] = true;
        bundle.putFloat(BundleKeys.APPC.name(), appRewardAppc);
        $jacocoInit[33] = true;
        bundle.putString(BundleKeys.DOWNLOAD_CONVERSION_URL.name(), downloadUrl);
        $jacocoInit[34] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[35] = true;
        fragment.setArguments(bundle);
        $jacocoInit[36] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[37] = true;
    }

    public void navigateWithStore(long appId, String packageName, String storeTheme, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[38] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[39] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[40] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), storeName);
        $jacocoInit[41] = true;
        bundle.putString(BundleKeys.STORE_THEME.name(), storeTheme);
        $jacocoInit[42] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[43] = true;
        fragment.setArguments(bundle);
        $jacocoInit[44] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[45] = true;
    }

    public void navigateWithStoreAndTag(long appId, String packageName, String storeTheme, String storeName, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[46] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[47] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[48] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[49] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), storeName);
        $jacocoInit[50] = true;
        bundle.putString(BundleKeys.STORE_THEME.name(), storeTheme);
        $jacocoInit[51] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[52] = true;
        fragment.setArguments(bundle);
        $jacocoInit[53] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[54] = true;
    }

    public void navigatewithEditorsPosition(long appId, String packageName, String storeTheme, String storeName, String tag, String editorsPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[55] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[56] = true;
        bundle.putString(BundleKeys.EDITORS_CHOICE_POSITION.name(), editorsPosition);
        $jacocoInit[57] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), appId);
        $jacocoInit[58] = true;
        bundle.putString(BundleKeys.PACKAGE_NAME.name(), packageName);
        $jacocoInit[59] = true;
        bundle.putString(BundleKeys.STORE_NAME.name(), storeName);
        $jacocoInit[60] = true;
        bundle.putString(BundleKeys.STORE_THEME.name(), storeTheme);
        $jacocoInit[61] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[62] = true;
        fragment.setArguments(bundle);
        $jacocoInit[63] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[64] = true;
    }

    public void navigateWithAd(SearchAdResult searchAdResult, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[65] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), searchAdResult.getAppId());
        $jacocoInit[66] = true;
        String name = BundleKeys.PACKAGE_NAME.name();
        $jacocoInit[67] = true;
        String packageName = searchAdResult.getPackageName();
        $jacocoInit[68] = true;
        bundle.putString(name, packageName);
        $jacocoInit[69] = true;
        String name2 = BundleKeys.MINIMAL_AD.name();
        $jacocoInit[70] = true;
        Parcelable a = C14377B.m45944a(searchAdResult);
        $jacocoInit[71] = true;
        bundle.putParcelable(name2, a);
        $jacocoInit[72] = true;
        if (tag == null) {
            $jacocoInit[73] = true;
        } else {
            bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
            $jacocoInit[74] = true;
        }
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[75] = true;
        fragment.setArguments(bundle);
        $jacocoInit[76] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[77] = true;
    }

    public void navigateWithAdAndTag(SearchAdResult searchAdResult, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[78] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), searchAdResult.getAppId());
        $jacocoInit[79] = true;
        String name = BundleKeys.PACKAGE_NAME.name();
        $jacocoInit[80] = true;
        String packageName = searchAdResult.getPackageName();
        $jacocoInit[81] = true;
        bundle.putString(name, packageName);
        $jacocoInit[82] = true;
        String name2 = BundleKeys.MINIMAL_AD.name();
        $jacocoInit[83] = true;
        Parcelable a = C14377B.m45944a(searchAdResult);
        $jacocoInit[84] = true;
        bundle.putParcelable(name2, a);
        $jacocoInit[85] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[86] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[87] = true;
        fragment.setArguments(bundle);
        $jacocoInit[88] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[89] = true;
    }

    public void navigateWithAdAndStoreTheme(SearchAdResult searchAdResult, String storeTheme, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[90] = true;
        bundle.putLong(BundleKeys.APP_ID.name(), searchAdResult.getAppId());
        $jacocoInit[91] = true;
        String name = BundleKeys.PACKAGE_NAME.name();
        $jacocoInit[92] = true;
        String packageName = searchAdResult.getPackageName();
        $jacocoInit[93] = true;
        bundle.putString(name, packageName);
        $jacocoInit[94] = true;
        String name2 = BundleKeys.MINIMAL_AD.name();
        $jacocoInit[95] = true;
        Parcelable a = C14377B.m45944a(searchAdResult);
        $jacocoInit[96] = true;
        bundle.putParcelable(name2, a);
        $jacocoInit[97] = true;
        bundle.putString(BundleKeys.STORE_THEME.name(), storeTheme);
        $jacocoInit[98] = true;
        bundle.putString(BundleKeys.ORIGIN_TAG.name(), tag);
        $jacocoInit[99] = true;
        AppViewFragment fragment = new AppViewFragment();
        $jacocoInit[100] = true;
        fragment.setArguments(bundle);
        $jacocoInit[101] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[102] = true;
    }
}
