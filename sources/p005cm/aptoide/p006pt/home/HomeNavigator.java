package p005cm.aptoide.p006pt.home;

import android.app.Activity;
import android.os.Bundle;
import java.util.AbstractMap.SimpleEntry;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppCoinsInfoFragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.link.CustomTabsHelper;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionsFragment;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.HomeNavigator */
public class HomeNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = HomeNavigator.class.getSimpleName();
    private final AccountNavigator accountNavigator;
    private final ActivityNavigator activityNavigator;
    private final AppNavigator appNavigator;
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final FragmentNavigator fragmentNavigator;
    private final String theme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6948775991354779947L, "cm/aptoide/pt/home/HomeNavigator", 34);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[33] = true;
    }

    public HomeNavigator(FragmentNavigator fragmentNavigator2, AptoideBottomNavigator aptoideBottomNavigator2, BottomNavigationMapper bottomNavigationMapper2, AppNavigator appNavigator2, ActivityNavigator activityNavigator2, String theme2, AccountNavigator accountNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.aptoideBottomNavigator = aptoideBottomNavigator2;
        this.bottomNavigationMapper = bottomNavigationMapper2;
        this.appNavigator = appNavigator2;
        this.activityNavigator = activityNavigator2;
        this.theme = theme2;
        this.accountNavigator = accountNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToAppView(long appId, String packageName, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAppId(appId, packageName, OpenType.OPEN_ONLY, tag);
        $jacocoInit[1] = true;
    }

    public void navigateWithEditorsPosition(long appId, String packageName, String storeTheme, String storeName, String tag, String editorsPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigatewithEditorsPosition(appId, packageName, storeTheme, storeName, tag, editorsPosition);
        $jacocoInit[2] = true;
    }

    public void navigateWithDownloadUrlAndReward(long appId, String packageName, String tag, String downloadUrl, float reward) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithDownloadUrlAndReward(appId, packageName, tag, downloadUrl, reward);
        $jacocoInit[3] = true;
    }

    public void navigateWithAction(HomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        HomeBundle bundle = click.getBundle();
        $jacocoInit[4] = true;
        Event event = bundle.getEvent();
        Type type = click.getType();
        HomeBundle bundle2 = click.getBundle();
        $jacocoInit[5] = true;
        String title = bundle2.getTitle();
        HomeBundle bundle3 = click.getBundle();
        $jacocoInit[6] = true;
        String tag = bundle3.getTag();
        StoreContext storeContext = StoreContext.home;
        $jacocoInit[7] = true;
        fragmentNavigator2.navigateTo(StoreTabGridRecyclerFragment.newInstance(event, type, title, BuildConfig.APTOIDE_THEME, tag, storeContext), true);
        $jacocoInit[8] = true;
    }

    public void navigateToAppView(SimpleEntry<String, SearchAdResult> entry) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAdAndTag((SearchAdResult) entry.getValue(), (String) entry.getKey());
        $jacocoInit[9] = true;
    }

    public C0120S<Integer> bottomNavigation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigationEvent = this.aptoideBottomNavigator.navigationEvent();
        C3395Jb jb = new C3395Jb(this);
        $jacocoInit[10] = true;
        C0120S<Integer> d = navigationEvent.mo3653d((C0132p<? super T, Boolean>) jb);
        $jacocoInit[11] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14441a(Integer menuPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationItem mapItemClicked = this.bottomNavigationMapper.mapItemClicked(menuPosition);
        BottomNavigationItem bottomNavigationItem = BottomNavigationItem.HOME;
        $jacocoInit[30] = true;
        boolean equals = mapItemClicked.equals(bottomNavigationItem);
        $jacocoInit[31] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[32] = true;
        return valueOf;
    }

    public void navigateToMyAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
        $jacocoInit[12] = true;
    }

    public void navigateToAppCoinsInformationView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(new AppCoinsInfoFragment(), true);
        $jacocoInit[13] = true;
    }

    public void navigateToEditorial(String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[14] = true;
        bundle.putString("cardId", cardId);
        $jacocoInit[15] = true;
        bundle.putBoolean(EditorialFragment.FROM_HOME, true);
        $jacocoInit[16] = true;
        EditorialFragment fragment = new EditorialFragment();
        $jacocoInit[17] = true;
        fragment.setArguments(bundle);
        $jacocoInit[18] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[19] = true;
    }

    public void navigateToTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        ActivityNavigator activityNavigator2 = this.activityNavigator;
        $jacocoInit[20] = true;
        Activity activity = activityNavigator2.getActivity();
        $jacocoInit[21] = true;
        String string = activity.getString(C1375R.string.all_url_terms_conditions);
        Activity activity2 = this.activityNavigator.getActivity();
        String str = this.theme;
        $jacocoInit[22] = true;
        instance.openInChromeCustomTab(string, activity2, str);
        $jacocoInit[23] = true;
    }

    public void navigateToPrivacyPolicy() {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        ActivityNavigator activityNavigator2 = this.activityNavigator;
        $jacocoInit[24] = true;
        Activity activity = activityNavigator2.getActivity();
        $jacocoInit[25] = true;
        String string = activity.getString(C1375R.string.all_url_privacy_policy);
        Activity activity2 = this.activityNavigator.getActivity();
        String str = this.theme;
        $jacocoInit[26] = true;
        instance.openInChromeCustomTab(string, activity2, str);
        $jacocoInit[27] = true;
    }

    public void navigateToPromotions() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(new PromotionsFragment(), true);
        $jacocoInit[28] = true;
    }

    public void navigateToLogIn() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.EDITORIAL);
        $jacocoInit[29] = true;
    }
}
