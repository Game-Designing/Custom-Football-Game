package p005cm.aptoide.p006pt.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AppShortcutsAnalytics;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.DeepLinkAnalytics;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksTargets;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreViewModel;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppCoinsInfoFragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Type;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Layout;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionsFragment;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.search.SearchNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.analytics.SearchSource;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.store.view.StoreFragment;
import p005cm.aptoide.p006pt.store.view.StoreFragment.OpenType;
import p005cm.aptoide.p006pt.store.view.StoreTabFragmentChooser;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.DeepLinkManager */
public class DeepLinkManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String APP_SHORTCUT = "App_Shortcut";
    public static final String DEEPLINK_KEY = "Deeplink";
    private static final String TAG = DeepLinkManager.class.getName();
    private final AptoideAccountManager accountManager;
    private final AdsRepository adsRepository;
    private final AppNavigator appNavigator;
    private final AppShortcutsAnalytics appShortcutsAnalytics;
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final DeepLinkAnalytics deepLinkAnalytics;
    private final DeepLinkMessages deepLinkMessages;
    private final String defaultTheme;
    private final FragmentNavigator fragmentNavigator;
    private final NavigationTracker navigationTracker;
    private final NotificationAnalytics notificationAnalytics;
    private final SearchAnalytics searchAnalytics;
    private final SearchNavigator searchNavigator;
    private final SharedPreferences sharedPreferences;
    private final StoreAccessor storeAccessor;
    private final StoreAnalytics storeAnalytics;
    private final StoreRepository storeRepository;
    private final StoreUtilsProxy storeUtilsProxy;
    private final C0136c subscriptions = new C0136c();

    /* renamed from: cm.aptoide.pt.view.DeepLinkManager$DeepLinkMessages */
    public interface DeepLinkMessages {
        void showStoreAlreadyAdded();

        void showStoreFollowed(String str);
    }

    /* renamed from: cm.aptoide.pt.view.DeepLinkManager$ShortcutDestinations */
    private static final class ShortcutDestinations {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        private static final String MY_STORE = "My_Store";
        private static final String MY_STORE_NOT_LOGGED_IN = "My_Store_Not_Logged_In";
        private static final String SEARCH = "Search";

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8077489165156351678L, "cm/aptoide/pt/view/DeepLinkManager$ShortcutDestinations", 1);
            $jacocoData = probes;
            return probes;
        }

        private ShortcutDestinations() {
            $jacocoInit()[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3468830581963620511L, "cm/aptoide/pt/view/DeepLinkManager", 210);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[209] = true;
    }

    public DeepLinkManager(StoreUtilsProxy storeUtilsProxy2, StoreRepository storeRepository2, FragmentNavigator fragmentNavigator2, BottomNavigationNavigator bottomNavigationNavigator2, SearchNavigator searchNavigator2, DeepLinkMessages deepLinkMessages2, SharedPreferences sharedPreferences2, StoreAccessor storeAccessor2, String defaultTheme2, NotificationAnalytics notificationAnalytics2, NavigationTracker navigationTracker2, SearchAnalytics searchAnalytics2, AppShortcutsAnalytics appShortcutsAnalytics2, AptoideAccountManager accountManager2, DeepLinkAnalytics deepLinkAnalytics2, StoreAnalytics storeAnalytics2, AdsRepository adsRepository2, AppNavigator appNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeUtilsProxy = storeUtilsProxy2;
        this.storeRepository = storeRepository2;
        this.fragmentNavigator = fragmentNavigator2;
        this.bottomNavigationNavigator = bottomNavigationNavigator2;
        this.searchNavigator = searchNavigator2;
        this.deepLinkMessages = deepLinkMessages2;
        this.sharedPreferences = sharedPreferences2;
        this.storeAccessor = storeAccessor2;
        this.defaultTheme = defaultTheme2;
        this.navigationTracker = navigationTracker2;
        this.notificationAnalytics = notificationAnalytics2;
        this.searchAnalytics = searchAnalytics2;
        this.appShortcutsAnalytics = appShortcutsAnalytics2;
        this.accountManager = accountManager2;
        this.deepLinkAnalytics = deepLinkAnalytics2;
        this.storeAnalytics = storeAnalytics2;
        this.adsRepository = adsRepository2;
        this.appNavigator = appNavigator2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    public boolean showDeepLink(Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        if (intent.hasExtra(DeepLinksTargets.APP_VIEW_FRAGMENT)) {
            $jacocoInit[2] = true;
            String str = "md5";
            if (intent.hasExtra(str)) {
                $jacocoInit[3] = true;
                appViewDeepLink(intent.getStringExtra(str));
                $jacocoInit[4] = true;
            } else {
                String str2 = "appId";
                String str3 = "packageName";
                if (intent.hasExtra(str2)) {
                    $jacocoInit[5] = true;
                    long longExtra = intent.getLongExtra(str2, -1);
                    $jacocoInit[6] = true;
                    String stringExtra = intent.getStringExtra(str3);
                    $jacocoInit[7] = true;
                    boolean booleanExtra = intent.getBooleanExtra(DeepLinksKeys.APK_FY, false);
                    $jacocoInit[8] = true;
                    appViewDeepLink(longExtra, stringExtra, true, booleanExtra);
                    $jacocoInit[9] = true;
                } else if (intent.hasExtra(str3)) {
                    $jacocoInit[10] = true;
                    String stringExtra2 = intent.getStringExtra(str3);
                    $jacocoInit[11] = true;
                    String stringExtra3 = intent.getStringExtra("storeName");
                    $jacocoInit[12] = true;
                    boolean booleanExtra2 = intent.getBooleanExtra(DeepLinksKeys.SHOW_AUTO_INSTALL_POPUP, true);
                    $jacocoInit[13] = true;
                    appViewDeepLink(stringExtra2, stringExtra3, booleanExtra2);
                    $jacocoInit[14] = true;
                } else {
                    String str4 = DeepLinksKeys.UNAME;
                    if (!intent.hasExtra(str4)) {
                        $jacocoInit[15] = true;
                    } else {
                        $jacocoInit[16] = true;
                        appViewDeepLinkUname(intent.getStringExtra(str4));
                        $jacocoInit[17] = true;
                    }
                }
            }
        } else if (intent.hasExtra(DeepLinksTargets.SEARCH_FRAGMENT)) {
            $jacocoInit[18] = true;
            String stringExtra4 = intent.getStringExtra("query");
            $jacocoInit[19] = true;
            boolean booleanExtra3 = intent.getBooleanExtra(DeepLinkIntentReceiver.FROM_SHORTCUT, false);
            $jacocoInit[20] = true;
            searchDeepLink(stringExtra4, booleanExtra3);
            $jacocoInit[21] = true;
        } else {
            String str5 = DeepLinksTargets.NEW_REPO;
            if (intent.hasExtra(str5)) {
                $jacocoInit[22] = true;
                Bundle extras = intent.getExtras();
                $jacocoInit[23] = true;
                ArrayList stringArrayList = extras.getStringArrayList(str5);
                StoreAccessor storeAccessor2 = this.storeAccessor;
                $jacocoInit[24] = true;
                newRepoDeepLink(intent, stringArrayList, storeAccessor2);
                $jacocoInit[25] = true;
            } else if (intent.hasExtra(DeepLinksTargets.FROM_DOWNLOAD_NOTIFICATION)) {
                $jacocoInit[26] = true;
                downloadNotificationDeepLink();
                $jacocoInit[27] = true;
            } else if (intent.hasExtra(DeepLinksTargets.HOME_DEEPLINK)) {
                $jacocoInit[28] = true;
                fromHomeDeepLink();
                $jacocoInit[29] = true;
            } else if (intent.hasExtra(DeepLinksTargets.NEW_UPDATES)) {
                $jacocoInit[30] = true;
                newUpdatesDeepLink();
                $jacocoInit[31] = true;
            } else if (intent.hasExtra(DeepLinksTargets.GENERIC_DEEPLINK)) {
                $jacocoInit[32] = true;
                genericDeepLink((Uri) intent.getParcelableExtra(DeepLinksKeys.URI));
                $jacocoInit[33] = true;
            } else {
                String str6 = DeepLinksTargets.USER_DEEPLINK;
                if (intent.hasExtra(str6)) {
                    $jacocoInit[34] = true;
                    long longExtra2 = intent.getLongExtra(str6, -1);
                    $jacocoInit[35] = true;
                    openUserProfile(longExtra2);
                    $jacocoInit[36] = true;
                } else if (intent.hasExtra(DeepLinksTargets.MY_STORE_DEEPLINK)) {
                    $jacocoInit[37] = true;
                    myStoreDeepLink();
                    $jacocoInit[38] = true;
                } else if (intent.hasExtra(DeepLinksTargets.PICK_APP_DEEPLINK)) {
                    $jacocoInit[39] = true;
                    pickAppDeeplink();
                    $jacocoInit[40] = true;
                } else if (intent.hasExtra(DeepLinksTargets.PROMOTIONS_DEEPLINK)) {
                    $jacocoInit[41] = true;
                    promotionsDeepLink();
                    $jacocoInit[42] = true;
                } else if (intent.hasExtra(DeepLinksTargets.EDITORIAL_DEEPLINK)) {
                    $jacocoInit[43] = true;
                    editorialDeepLink(intent.getStringExtra("cardId"));
                    $jacocoInit[44] = true;
                } else if (intent.hasExtra(DeepLinksTargets.APPC_INFO_VIEW)) {
                    $jacocoInit[45] = true;
                    appcInfoDeepLink();
                    $jacocoInit[46] = true;
                } else {
                    this.deepLinkAnalytics.launcher();
                    $jacocoInit[47] = true;
                    return false;
                }
            }
        }
        List<ScreenTagHistory> screenHistory = this.navigationTracker.getHistoryList();
        $jacocoInit[48] = true;
        if (screenHistory.size() == 0) {
            $jacocoInit[49] = true;
            this.navigationTracker.registerScreen(Builder.build(APP_SHORTCUT));
            $jacocoInit[50] = true;
        } else {
            ScreenTagHistory screenTagHistory = (ScreenTagHistory) screenHistory.get(screenHistory.size() - 1);
            $jacocoInit[51] = true;
            String fragment = screenTagHistory.getFragment();
            $jacocoInit[52] = true;
            String str7 = "Notification";
            if (fragment.equals(str7)) {
                $jacocoInit[53] = true;
                this.navigationTracker.registerScreen(Builder.build(str7));
                $jacocoInit[54] = true;
            } else {
                this.navigationTracker.registerScreen(Builder.build(DEEPLINK_KEY));
                $jacocoInit[55] = true;
            }
        }
        $jacocoInit[56] = true;
        return true;
    }

    private void appcInfoDeepLink() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(new AppCoinsInfoFragment(), true);
        $jacocoInit[57] = true;
    }

    private void editorialDeepLink(String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[58] = true;
        bundle.putString("cardId", cardId);
        $jacocoInit[59] = true;
        EditorialFragment fragment = new EditorialFragment();
        $jacocoInit[60] = true;
        fragment.setArguments(bundle);
        $jacocoInit[61] = true;
        this.fragmentNavigator.navigateTo(fragment, true);
        $jacocoInit[62] = true;
    }

    private void openUserProfile(long userId) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        OpenType openType = OpenType.GetHome;
        $jacocoInit[63] = true;
        StoreFragment newInstance = StoreFragment.newInstance(userId, BuildConfig.APTOIDE_THEME, openType);
        $jacocoInit[64] = true;
        fragmentNavigator2.navigateTo(newInstance, true);
        $jacocoInit[65] = true;
    }

    private void appViewDeepLinkUname(String uname) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithUname(uname);
        $jacocoInit[66] = true;
    }

    private void appViewDeepLink(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithMd5(md5);
        $jacocoInit[67] = true;
    }

    private void appViewDeepLink(long appId, String packageName, boolean showPopup, boolean isApkfy) {
        AppViewFragment.OpenType openType;
        boolean[] $jacocoInit = $jacocoInit();
        if (isApkfy) {
            openType = AppViewFragment.OpenType.APK_FY_INSTALL_POPUP;
            $jacocoInit[68] = true;
        } else {
            if (showPopup) {
                openType = AppViewFragment.OpenType.OPEN_WITH_INSTALL_POPUP;
                $jacocoInit[69] = true;
            } else {
                openType = AppViewFragment.OpenType.OPEN_ONLY;
                $jacocoInit[70] = true;
            }
            $jacocoInit[71] = true;
        }
        this.appNavigator.navigateWithAppId(appId, packageName, openType, "");
        $jacocoInit[72] = true;
    }

    private void appViewDeepLink(String packageName, String storeName, boolean showPopup) {
        AppViewFragment.OpenType openType;
        boolean[] $jacocoInit = $jacocoInit();
        if (showPopup) {
            openType = AppViewFragment.OpenType.OPEN_WITH_INSTALL_POPUP;
            $jacocoInit[73] = true;
        } else {
            openType = AppViewFragment.OpenType.OPEN_ONLY;
            $jacocoInit[74] = true;
        }
        $jacocoInit[75] = true;
        this.appNavigator.navigateWithPackageAndStoreNames(packageName, storeName, openType);
        $jacocoInit[76] = true;
    }

    private void searchDeepLink(String query, boolean shortcutNavigation) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator.navigateToSearch(this.searchNavigator.resolveFragment(query));
        $jacocoInit[77] = true;
        if (query == null) {
            $jacocoInit[78] = true;
        } else if (query.isEmpty()) {
            $jacocoInit[79] = true;
        } else {
            this.searchAnalytics.searchStart(SearchSource.DEEP_LINK, false);
            $jacocoInit[84] = true;
            $jacocoInit[85] = true;
        }
        if (shortcutNavigation) {
            $jacocoInit[80] = true;
            this.searchAnalytics.searchStart(SearchSource.SHORTCUT, false);
            $jacocoInit[81] = true;
            this.appShortcutsAnalytics.shortcutNavigation(SearchAnalytics.SEARCH);
            $jacocoInit[82] = true;
        } else {
            this.searchAnalytics.searchStart(SearchSource.WIDGET, false);
            $jacocoInit[83] = true;
        }
        $jacocoInit[85] = true;
    }

    private void newRepoDeepLink(Intent intent, ArrayList<String> repos, StoreAccessor storeAccessor2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (repos == null) {
            $jacocoInit[86] = true;
        } else {
            $jacocoInit[87] = true;
            C0136c cVar = this.subscriptions;
            C0120S a = C0120S.m629a((Iterable<? extends T>) repos);
            C5212B b = new C5212B(this, storeAccessor2);
            $jacocoInit[88] = true;
            C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) b);
            $jacocoInit[89] = true;
            C0120S m = f.mo3675m();
            C5565z zVar = new C5565z(this);
            $jacocoInit[90] = true;
            C0120S f2 = m.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zVar);
            C5564y yVar = C5564y.f9377a;
            C5547t tVar = C5547t.f9359a;
            $jacocoInit[91] = true;
            C0137ja a2 = f2.mo3626a((C0129b<? super T>) yVar, (C0129b<Throwable>) tVar);
            $jacocoInit[92] = true;
            cVar.mo3713a(a2);
            $jacocoInit[93] = true;
            intent.removeExtra(DeepLinksTargets.NEW_REPO);
            $jacocoInit[94] = true;
        }
        $jacocoInit[95] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16894a(StoreAccessor storeAccessor2, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isSubscribedStore = StoreUtils.isSubscribedStore(storeName, storeAccessor2);
        $jacocoInit[197] = true;
        C0120S d = isSubscribedStore.mo3647d();
        $jacocoInit[198] = true;
        C0120S a = d.mo3616a(C14522a.m46170a());
        C5549v vVar = new C5549v(this, storeName);
        $jacocoInit[199] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vVar);
        C5357p pVar = new C5357p(storeName);
        $jacocoInit[200] = true;
        C0120S j = f.mo3669j(pVar);
        $jacocoInit[201] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16895a(String storeName, Boolean isFollowed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isFollowed.booleanValue()) {
            $jacocoInit[203] = true;
            C0120S a = C0120S.m633a((Callable<? extends T>) new C5213C<Object>(this));
            $jacocoInit[204] = true;
            return a;
        }
        C0120S subscribeStoreObservable = this.storeUtilsProxy.subscribeStoreObservable(storeName);
        C5548u uVar = new C5548u(this, storeName);
        $jacocoInit[205] = true;
        C0120S b = subscribeStoreObservable.mo3636b((C0129b<? super T>) uVar);
        $jacocoInit[206] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ GetStoreMeta mo16892a() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        this.deepLinkMessages.showStoreAlreadyAdded();
        $jacocoInit[208] = true;
        return null;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16898a(String storeName, GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        this.deepLinkMessages.showStoreFollowed(storeName);
        $jacocoInit[207] = true;
    }

    /* renamed from: b */
    static /* synthetic */ String m9501b(String storeName, GetStoreMeta isSubscribed) {
        $jacocoInit()[202] = true;
        return storeName;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16896a(List stores) {
        boolean[] $jacocoInit = $jacocoInit();
        if (stores.size() == 1) {
            $jacocoInit[188] = true;
            C0120S byName = this.storeRepository.getByName((String) stores.get(0));
            C5215D d = new C5215D(this);
            $jacocoInit[189] = true;
            C0120S g = byName.mo3663g((C0132p<? super T, ? extends C0117M>) d);
            C5216E e = new C5216E(stores);
            $jacocoInit[190] = true;
            C0120S j = g.mo3669j(e);
            $jacocoInit[191] = true;
            return j;
        }
        C0120S f = navigateToStores().mo3604f();
        C5359r rVar = new C5359r(stores);
        $jacocoInit[192] = true;
        C0120S j2 = f.mo3669j(rVar);
        $jacocoInit[193] = true;
        return j2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo16893a(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M openStore = openStore(store);
        $jacocoInit[196] = true;
        return openStore;
    }

    /* renamed from: a */
    static /* synthetic */ List m9498a(List stores, Store success) {
        $jacocoInit()[195] = true;
        return stores;
    }

    /* renamed from: a */
    static /* synthetic */ List m9499a(List stores, Object success) {
        $jacocoInit()[194] = true;
        return stores;
    }

    /* renamed from: b */
    static /* synthetic */ void m9503b(List stores) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[186] = true;
        instance.mo2136d(str, "newrepoDeepLink: all stores added");
        $jacocoInit[187] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9502b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("newrepoDeepLink: ");
        sb.append(throwable);
        String sb2 = sb.toString();
        $jacocoInit[182] = true;
        instance.mo2140e(str, sb2);
        $jacocoInit[183] = true;
        CrashReport instance2 = CrashReport.getInstance();
        $jacocoInit[184] = true;
        instance2.log(throwable);
        $jacocoInit[185] = true;
    }

    private C0117M navigateToStores() {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationNavigator bottomNavigationNavigator2 = this.bottomNavigationNavigator;
        bottomNavigationNavigator2.getClass();
        C0117M c = C0117M.m597c((C0128a) new C5221I(bottomNavigationNavigator2));
        $jacocoInit[96] = true;
        return c;
    }

    private C0117M openStore(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C5550w(this, store));
        $jacocoInit[97] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16900b(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[178] = true;
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[179] = true;
        Fragment newStoreFragment = fragmentProvider.newStoreFragment(store.getStoreName(), store.getTheme());
        $jacocoInit[180] = true;
        fragmentNavigator2.navigateTo(newStoreFragment, true);
        $jacocoInit[181] = true;
    }

    private void downloadNotificationDeepLink() {
        boolean[] $jacocoInit = $jacocoInit();
        this.deepLinkAnalytics.downloadingUpdates();
        $jacocoInit[98] = true;
        this.bottomNavigationNavigator.navigateToApps();
        $jacocoInit[99] = true;
    }

    private void fromHomeDeepLink() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator.navigateToHome();
        $jacocoInit[100] = true;
    }

    private void newUpdatesDeepLink() {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationAnalytics.sendUpdatesNotificationClickEvent();
        $jacocoInit[101] = true;
        this.deepLinkAnalytics.newUpdatesNotification();
        $jacocoInit[102] = true;
        this.bottomNavigationNavigator.navigateToApps();
        $jacocoInit[103] = true;
    }

    private void genericDeepLink(Uri uri) {
        String str;
        Uri uri2 = uri;
        boolean[] $jacocoInit = $jacocoInit();
        Event event = new Event();
        $jacocoInit[104] = true;
        Event event2 = event;
        String queryType = uri2.getQueryParameter("type");
        $jacocoInit[105] = true;
        String queryLayout = uri2.getQueryParameter("layout");
        $jacocoInit[106] = true;
        String queryName = uri2.getQueryParameter("name");
        $jacocoInit[107] = true;
        String queryAction = uri2.getQueryParameter("action");
        $jacocoInit[108] = true;
        if (!validateDeepLinkRequiredArgs(queryType, queryLayout, queryName, queryAction)) {
            $jacocoInit[109] = true;
        } else {
            try {
                $jacocoInit[110] = true;
                String queryAction2 = URLDecoder.decode(queryAction, "UTF-8");
                if (queryAction2 != null) {
                    try {
                        SharedPreferences sharedPreferences2 = this.sharedPreferences;
                        $jacocoInit[111] = true;
                        str = queryAction2.replace(C0044V7.getHost(sharedPreferences2), "");
                        $jacocoInit[112] = true;
                    } catch (UnsupportedEncodingException | IllegalArgumentException e) {
                        e = e;
                        String str2 = queryAction2;
                    }
                } else {
                    str = null;
                    try {
                        $jacocoInit[113] = true;
                    } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
                        e = e2;
                        String str3 = queryAction2;
                        $jacocoInit[125] = true;
                        e.printStackTrace();
                        $jacocoInit[126] = true;
                        $jacocoInit[127] = true;
                    }
                }
                event2.setAction(str);
                $jacocoInit[114] = true;
                event2.setType(Type.valueOf(queryType));
                $jacocoInit[115] = true;
                event2.setName(Name.valueOf(queryName));
                $jacocoInit[116] = true;
                Data data = new Data();
                $jacocoInit[117] = true;
                data.setLayout(Layout.valueOf(queryLayout));
                $jacocoInit[118] = true;
                event2.setData(data);
                $jacocoInit[119] = true;
                FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
                FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
                $jacocoInit[120] = true;
                String queryParameter = uri2.getQueryParameter("title");
                String str4 = DeepLinksKeys.STORE_THEME;
                $jacocoInit[121] = true;
                String queryParameter2 = uri2.getQueryParameter(str4);
                String str5 = this.defaultTheme;
                StoreContext storeContext = StoreContext.home;
                $jacocoInit[122] = true;
                FragmentNavigator fragmentNavigator3 = fragmentNavigator2;
                StoreContext storeContext2 = storeContext;
                String queryAction3 = queryAction2;
                try {
                    Fragment newStoreTabGridRecyclerFragment = fragmentProvider.newStoreTabGridRecyclerFragment(event2, queryParameter, queryParameter2, str5, storeContext2, true);
                    $jacocoInit[123] = true;
                    fragmentNavigator3.navigateTo(newStoreTabGridRecyclerFragment, true);
                    $jacocoInit[124] = true;
                    String str6 = queryAction3;
                } catch (UnsupportedEncodingException | IllegalArgumentException e3) {
                    e = e3;
                    String str7 = queryAction3;
                    $jacocoInit[125] = true;
                    e.printStackTrace();
                    $jacocoInit[126] = true;
                    $jacocoInit[127] = true;
                }
            } catch (UnsupportedEncodingException | IllegalArgumentException e4) {
                e = e4;
                $jacocoInit[125] = true;
                e.printStackTrace();
                $jacocoInit[126] = true;
                $jacocoInit[127] = true;
            }
        }
        $jacocoInit[127] = true;
    }

    private void myStoreDeepLink() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[128] = true;
        C0120S d = accountStatus.mo3647d();
        C5395s sVar = C5395s.f9208a;
        $jacocoInit[129] = true;
        C0120S j = d.mo3669j(sVar);
        $jacocoInit[130] = true;
        C0120S a = j.mo3616a(C14522a.m46170a());
        C5356o oVar = new C5356o(this);
        C5563x xVar = C5563x.f9376a;
        $jacocoInit[131] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) oVar, (C0129b<Throwable>) xVar);
        $jacocoInit[132] = true;
        cVar.mo3713a(a2);
        $jacocoInit[133] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Account m9497a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (account.isLoggedIn()) {
            $jacocoInit[176] = true;
            return account;
        }
        $jacocoInit[177] = true;
        return null;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16899b(Account navigation) {
        boolean[] $jacocoInit = $jacocoInit();
        if (navigation != null) {
            $jacocoInit[160] = true;
            this.appShortcutsAnalytics.shortcutNavigation("My_Store");
            $jacocoInit[161] = true;
            if (!navigation.hasStore()) {
                $jacocoInit[162] = true;
                FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
                ManageStoreViewModel manageStoreViewModel = new ManageStoreViewModel();
                $jacocoInit[163] = true;
                ManageStoreFragment newInstance = ManageStoreFragment.newInstance(manageStoreViewModel, true);
                $jacocoInit[164] = true;
                fragmentNavigator2.navigateTo(newInstance, true);
                $jacocoInit[165] = true;
            } else {
                StoreAnalytics storeAnalytics2 = this.storeAnalytics;
                p005cm.aptoide.accountmanager.Store store = navigation.getStore();
                $jacocoInit[166] = true;
                String name = store.getName();
                $jacocoInit[167] = true;
                storeAnalytics2.sendStoreOpenEvent(APP_SHORTCUT, name, false);
                $jacocoInit[168] = true;
                FragmentNavigator fragmentNavigator3 = this.fragmentNavigator;
                p005cm.aptoide.accountmanager.Store store2 = navigation.getStore();
                $jacocoInit[169] = true;
                String name2 = store2.getName();
                p005cm.aptoide.accountmanager.Store store3 = navigation.getStore();
                $jacocoInit[170] = true;
                String theme = store3.getTheme();
                OpenType openType = OpenType.GetHome;
                $jacocoInit[171] = true;
                fragmentNavigator3.navigateTo(StoreFragment.newInstance(name2, theme, openType), true);
                $jacocoInit[172] = true;
            }
        } else {
            this.appShortcutsAnalytics.shortcutNavigation("My_Store_Not_Logged_In");
            $jacocoInit[173] = true;
            this.bottomNavigationNavigator.navigateToStore();
            $jacocoInit[174] = true;
        }
        $jacocoInit[175] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9500a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("myStoreDeepLink: ");
        sb.append(throwable);
        String sb2 = sb.toString();
        $jacocoInit[158] = true;
        instance.mo2140e(str, sb2);
        $jacocoInit[159] = true;
    }

    private void pickAppDeeplink() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S adForShortcut = this.adsRepository.getAdForShortcut();
        C5211A a = new C5211A(this);
        C5358q qVar = C5358q.f9156a;
        $jacocoInit[134] = true;
        C0137ja a2 = adForShortcut.mo3626a((C0129b<? super T>) a, (C0129b<Throwable>) qVar);
        $jacocoInit[135] = true;
        cVar.mo3713a(a2);
        $jacocoInit[136] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16897a(MinimalAd ad) {
        boolean[] $jacocoInit = $jacocoInit();
        appViewDeepLink(ad.getAppId().longValue(), ad.getPackageName(), false, false);
        $jacocoInit[157] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9504c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("pickAppDeepLink: ");
        sb.append(throwable);
        String sb2 = sb.toString();
        $jacocoInit[155] = true;
        instance.mo2140e(str, sb2);
        $jacocoInit[156] = true;
    }

    private void promotionsDeepLink() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(new PromotionsFragment(), true);
        $jacocoInit[137] = true;
    }

    private boolean validateDeepLinkRequiredArgs(String queryType, String queryLayout, String queryName, String queryAction) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(queryType)) {
            $jacocoInit[138] = true;
        } else {
            $jacocoInit[139] = true;
            if (TextUtils.isEmpty(queryLayout)) {
                $jacocoInit[140] = true;
            } else {
                $jacocoInit[141] = true;
                if (TextUtils.isEmpty(queryName)) {
                    $jacocoInit[142] = true;
                } else {
                    $jacocoInit[143] = true;
                    if (TextUtils.isEmpty(queryAction)) {
                        $jacocoInit[144] = true;
                    } else {
                        $jacocoInit[145] = true;
                        if (!StoreTabFragmentChooser.validateAcceptedName(Name.valueOf(queryName))) {
                            $jacocoInit[146] = true;
                        } else {
                            $jacocoInit[147] = true;
                            z = true;
                            $jacocoInit[149] = true;
                            return z;
                        }
                    }
                }
            }
        }
        z = false;
        $jacocoInit[148] = true;
        $jacocoInit[149] = true;
        return z;
    }

    public void freeSubscriptions() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.subscriptions.mo3715b()) {
            $jacocoInit[150] = true;
        } else if (this.subscriptions.isUnsubscribed()) {
            $jacocoInit[151] = true;
        } else {
            $jacocoInit[152] = true;
            this.subscriptions.unsubscribe();
            $jacocoInit[153] = true;
        }
        $jacocoInit[154] = true;
    }
}
