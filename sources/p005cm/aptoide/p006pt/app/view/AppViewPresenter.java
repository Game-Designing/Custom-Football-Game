package p005cm.aptoide.p006pt.app.view;

import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.ads.MoPubInterstitialAdClickType;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd.Network;
import p005cm.aptoide.p006pt.ads.data.AptoideNativeAd;
import p005cm.aptoide.p006pt.app.AppCoinsAdvertisingModel;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.app.AppViewManager;
import p005cm.aptoide.p006pt.app.AppViewSimilarApp;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p005cm.aptoide.p006pt.app.DownloadAppViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.PromotionViewModel;
import p005cm.aptoide.p006pt.app.ReviewsViewModel;
import p005cm.aptoide.p006pt.app.SimilarAppsViewModel;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;
import p005cm.aptoide.p006pt.app.view.screenshots.ScreenShotClickEvent;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppClickEvent;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundle;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundle.BundleType;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Rank;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.promotions.ClaimDialogResultWrapper;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction;
import p005cm.aptoide.p006pt.promotions.PromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.app.AppDeveloper;
import p005cm.aptoide.p006pt.view.app.AppMedia;
import p005cm.aptoide.p006pt.view.app.AppRating;
import p005cm.aptoide.p006pt.view.app.Application;
import p005cm.aptoide.p006pt.view.app.FlagsVote.VoteType;
import p019d.p022i.p296a.p305c.C13045l;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.app.view.AppViewPresenter */
public class AppViewPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String TAG = AppViewPresenter.class.getSimpleName();
    private static final long TIME_BETWEEN_SCROLL = 2000;
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;
    private AppViewAnalytics appViewAnalytics;
    private AppViewManager appViewManager;
    private AppViewNavigator appViewNavigator;
    private CampaignAnalytics campaignAnalytics;
    private CrashReport crashReport;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final PromotionsNavigator promotionsNavigator;
    private AppViewView view;
    private C0126V viewScheduler;

    /* renamed from: cm.aptoide.pt.app.view.AppViewPresenter$1 */
    static /* synthetic */ class C17611 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8864017044162867083L, "cm/aptoide/pt/app/view/AppViewPresenter$1", 14);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    $jacocoInit[12] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.OPEN.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.PAY.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.MIGRATE.ordinal()] = 6;
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3516118352217820808L, "cm/aptoide/pt/app/view/AppViewPresenter", 1254);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1253] = true;
    }

    public AppViewPresenter(AppViewView view2, AccountNavigator accountNavigator2, AppViewAnalytics appViewAnalytics2, CampaignAnalytics campaignAnalytics2, AppViewNavigator appViewNavigator2, AppViewManager appViewManager2, AptoideAccountManager accountManager2, C0126V viewScheduler2, CrashReport crashReport2, PermissionManager permissionManager2, PermissionService permissionService2, PromotionsNavigator promotionsNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.accountNavigator = accountNavigator2;
        this.appViewAnalytics = appViewAnalytics2;
        this.campaignAnalytics = campaignAnalytics2;
        this.appViewNavigator = appViewNavigator2;
        this.appViewManager = appViewManager2;
        this.accountManager = accountManager2;
        this.viewScheduler = viewScheduler2;
        this.crashReport = crashReport2;
        this.permissionManager = permissionManager2;
        this.permissionService = permissionService2;
        this.promotionsNavigator = promotionsNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleFirstLoad();
        $jacocoInit[1] = true;
        handleReviewAutoScroll();
        $jacocoInit[2] = true;
        handleClickOnScreenshot();
        $jacocoInit[3] = true;
        handleClickOnVideo();
        $jacocoInit[4] = true;
        handleClickOnDescriptionReadMore();
        $jacocoInit[5] = true;
        handleClickOnDeveloperWebsite();
        $jacocoInit[6] = true;
        handleClickOnDeveloperEmail();
        $jacocoInit[7] = true;
        handleClickOnDeveloperPrivacy();
        $jacocoInit[8] = true;
        handleClickOnDeveloperPermissions();
        $jacocoInit[9] = true;
        handleClickOnStoreLayout();
        $jacocoInit[10] = true;
        handleClickOnFollowStore();
        $jacocoInit[11] = true;
        handleClickOnOtherVersions();
        $jacocoInit[12] = true;
        handleClickOnTrustedBadge();
        $jacocoInit[13] = true;
        handleClickOnRateApp();
        $jacocoInit[14] = true;
        handleClickReadReviews();
        $jacocoInit[15] = true;
        handleClickFlags();
        $jacocoInit[16] = true;
        handleClickLoginSnack();
        $jacocoInit[17] = true;
        handleClickOnAppcInfo();
        $jacocoInit[18] = true;
        handleClickOnSimilarApps();
        $jacocoInit[19] = true;
        handleClickOnToolbar();
        $jacocoInit[20] = true;
        handleClickOnRetry();
        $jacocoInit[21] = true;
        handleOnScroll();
        $jacocoInit[22] = true;
        handleOnSimilarAppsVisible();
        $jacocoInit[23] = true;
        handleInstallButtonClick();
        $jacocoInit[24] = true;
        pauseDownload();
        $jacocoInit[25] = true;
        resumeDownload();
        $jacocoInit[26] = true;
        cancelDownload();
        $jacocoInit[27] = true;
        loadDownloadApp();
        $jacocoInit[28] = true;
        handleAppBought();
        $jacocoInit[29] = true;
        handleApkfyDialogPositiveClick();
        $jacocoInit[30] = true;
        handleClickOnTopDonorsDonate();
        $jacocoInit[31] = true;
        handleDonateCardImpressions();
        $jacocoInit[32] = true;
        handleInterstitialAdClick();
        $jacocoInit[33] = true;
        handleAppcPromotion();
        $jacocoInit[34] = true;
        handleDismissWalletPromotion();
        $jacocoInit[35] = true;
        handleInstallWalletPromotion();
        $jacocoInit[36] = true;
        claimApp();
        $jacocoInit[37] = true;
        handlePromotionClaimResult();
        $jacocoInit[38] = true;
        resumeWalletDownload();
        $jacocoInit[39] = true;
        cancelPromotionDownload();
        $jacocoInit[40] = true;
        pauseWalletDownload();
        $jacocoInit[41] = true;
        loadInterstitialAd();
        $jacocoInit[42] = true;
        showInterstitial();
        $jacocoInit[43] = true;
        handleDownloadingSimilarApp();
        $jacocoInit[44] = true;
        handleMoPubConsentDialog();
        $jacocoInit[45] = true;
    }

    private void handleMoPubConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1899Pg pg = C1899Pg.f4913a;
        $jacocoInit[46] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) pg);
        C2113jb jbVar = new C2113jb(this);
        $jacocoInit[47] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jbVar);
        C2102ia iaVar = new C2102ia(this);
        $jacocoInit[48] = true;
        C0120S i = f.mo3668i(iaVar);
        C2132la laVar = C2132la.f5195a;
        $jacocoInit[49] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) laVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[50] = true;
        C0120S a = d2.mo3616a(v);
        C2205se seVar = new C2205se(this);
        $jacocoInit[51] = true;
        C0120S i2 = a.mo3668i(seVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[52] = true;
        C0120S a2 = i2.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1763Ba ba = C1763Ba.f4755a;
        C1977Ye ye = new C1977Ye(this);
        $jacocoInit[53] = true;
        a2.mo3626a((C0129b<? super T>) ba, (C0129b<Throwable>) ye);
        $jacocoInit[54] = true;
    }

    /* renamed from: pa */
    static /* synthetic */ Boolean m6655pa(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[1250] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1251] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1252] = true;
        return valueOf;
    }

    /* renamed from: qa */
    public /* synthetic */ C0120S mo10716qa(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isAppViewReadyToDownload = this.view.isAppViewReadyToDownload();
        $jacocoInit[1249] = true;
        return isAppViewReadyToDownload;
    }

    /* renamed from: s */
    public /* synthetic */ Single mo10721s(Void model) {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadInterstitialAd = this.appViewManager.shouldLoadInterstitialAd();
        $jacocoInit[1248] = true;
        return shouldLoadInterstitialAd;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m6636h(Boolean loadInterstitial) {
        $jacocoInit()[1247] = true;
        return loadInterstitial;
    }

    /* renamed from: i */
    public /* synthetic */ Single mo10684i(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single handleConsentDialog = handleConsentDialog();
        $jacocoInit[1246] = true;
        return handleConsentDialog;
    }

    /* renamed from: j */
    static /* synthetic */ void m6640j(Boolean __) {
        $jacocoInit()[1245] = true;
    }

    /* renamed from: H */
    public /* synthetic */ void mo10550H(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1244] = true;
    }

    private void handleDownloadingSimilarApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1754Ad ad = C1754Ad.f4748a;
        $jacocoInit[55] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ad);
        C1949Vd vd = new C1949Vd(this);
        $jacocoInit[56] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vd);
        C1903Qb qb = new C1903Qb(this);
        $jacocoInit[57] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qb);
        C0126V v = this.viewScheduler;
        $jacocoInit[58] = true;
        C0120S a = f2.mo3616a(v);
        C1950Ve ve = new C1950Ve(this);
        $jacocoInit[59] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) ve);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[60] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2262ye yeVar = C2262ye.f5336a;
        C2236vg vgVar = new C2236vg(this);
        $jacocoInit[61] = true;
        a2.mo3626a((C0129b<? super T>) yeVar, (C0129b<Throwable>) vgVar);
        $jacocoInit[62] = true;
    }

    /* renamed from: ea */
    static /* synthetic */ Boolean m6627ea(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[1241] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1242] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1243] = true;
        return valueOf;
    }

    /* renamed from: fa */
    public /* synthetic */ C0120S mo10673fa(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isAppViewReadyToDownload = this.view.isAppViewReadyToDownload();
        $jacocoInit[1240] = true;
        return isAppViewReadyToDownload;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo10718r(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S downloadInRange = downloadInRange(0, 100);
        $jacocoInit[1239] = true;
        return downloadInRange;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10634b(DownloadModel __) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AppViewView appViewView = this.view;
        AppViewManager appViewManager2 = this.appViewManager;
        $jacocoInit[1231] = true;
        SimilarAppsViewModel cachedAppcSimilarAppsViewModel = appViewManager2.getCachedAppcSimilarAppsViewModel();
        $jacocoInit[1232] = true;
        if (cachedAppcSimilarAppsViewModel.hasSimilarApps()) {
            $jacocoInit[1233] = true;
        } else {
            SimilarAppsViewModel cachedSimilarAppsViewModel = this.appViewManager.getCachedSimilarAppsViewModel();
            $jacocoInit[1234] = true;
            if (cachedSimilarAppsViewModel.hasSimilarApps()) {
                $jacocoInit[1235] = true;
            } else {
                z = false;
                $jacocoInit[1237] = true;
                appViewView.showDownloadingSimilarApps(z);
                $jacocoInit[1238] = true;
            }
        }
        $jacocoInit[1236] = true;
        z = true;
        appViewView.showDownloadingSimilarApps(z);
        $jacocoInit[1238] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6611c(DownloadModel __) {
        $jacocoInit()[1230] = true;
    }

    /* renamed from: C */
    public /* synthetic */ void mo10538C(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1229] = true;
    }

    private void showInterstitial() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2194rf rfVar = C2194rf.f5262a;
        $jacocoInit[63] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) rfVar);
        C1775Cd cd = new C1775Cd(this);
        $jacocoInit[64] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cd);
        C1938Ub ub = new C1938Ub(this);
        $jacocoInit[65] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ub);
        C1757Ag ag = C1757Ag.f4751a;
        $jacocoInit[66] = true;
        C0120S d2 = f2.mo3653d((C0132p<? super T, Boolean>) ag);
        C2166oe oeVar = new C2166oe(this);
        $jacocoInit[67] = true;
        C0120S f3 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oeVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[68] = true;
        C0120S a = f3.mo3616a(v);
        C1911Rb rb = new C1911Rb(this);
        $jacocoInit[69] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) rb);
        C1975Yc yc = new C1975Yc(this);
        $jacocoInit[70] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) yc);
        C2213tb tbVar = new C2213tb(this);
        $jacocoInit[71] = true;
        C0120S i = b2.mo3668i(tbVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[72] = true;
        C0120S a2 = i.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1990_a _aVar = C1990_a.f5024a;
        C1855Lc lc = new C1855Lc(this);
        $jacocoInit[73] = true;
        a2.mo3626a((C0129b<? super T>) _aVar, (C0129b<Throwable>) lc);
        $jacocoInit[74] = true;
    }

    /* renamed from: La */
    static /* synthetic */ Boolean m6551La(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[1226] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1227] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1228] = true;
        return valueOf;
    }

    /* renamed from: Ma */
    public /* synthetic */ C0120S mo10563Ma(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isAppViewReadyToDownload = this.view.isAppViewReadyToDownload();
        $jacocoInit[1225] = true;
        return isAppViewReadyToDownload;
    }

    /* renamed from: E */
    public /* synthetic */ C0120S mo10543E(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1223] = true;
        C0120S c = loadAppViewViewModel.mo3696c();
        $jacocoInit[1224] = true;
        return c;
    }

    /* renamed from: da */
    static /* synthetic */ Boolean m6621da(AppViewViewModel appViewViewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!appViewViewModel.isAppCoinApp()) {
            $jacocoInit[1220] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1221] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1222] = true;
        return valueOf;
    }

    /* renamed from: ea */
    public /* synthetic */ C0120S mo10669ea(AppViewViewModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m650b(downloadInRange(5, 100), this.view.interstitialAdLoaded(), (C14541q<? super T1, ? super T2, ? extends R>) C1823Hg.f4822a);
        $jacocoInit[1218] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6585a(DownloadModel downloadAppViewModel, MoPubInterstitialAdClickType moPubInterstitialAdClickType) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(downloadAppViewModel);
        $jacocoInit[1219] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10618a(C0120S __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showInterstitialAd();
        $jacocoInit[1217] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10639b(C0120S __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.installInterstitialImpression();
        $jacocoInit[1216] = true;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo10649c(C0120S __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single recordInterstitialImpression = this.appViewManager.recordInterstitialImpression();
        $jacocoInit[1215] = true;
        return recordInterstitialImpression;
    }

    /* renamed from: v */
    static /* synthetic */ void m6665v(Boolean __) {
        $jacocoInit()[1214] = true;
    }

    /* renamed from: V */
    public /* synthetic */ void mo10577V(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1213] = true;
    }

    private C0120S<DownloadModel> downloadInRange(int min, int max) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S downloadStarted = this.appViewManager.downloadStarted();
        C1984Zc zc = C1984Zc.f5016a;
        $jacocoInit[75] = true;
        C0120S j = downloadStarted.mo3669j(zc);
        C2258ya yaVar = C2258ya.f5332a;
        $jacocoInit[76] = true;
        C0120S d = j.mo3653d((C0132p<? super T, Boolean>) yaVar);
        C1795Ef ef = new C1795Ef(min, max);
        $jacocoInit[77] = true;
        C0120S d2 = d.mo3653d((C0132p<? super T, Boolean>) ef);
        $jacocoInit[78] = true;
        C0120S<DownloadModel> d3 = d2.mo3647d();
        $jacocoInit[79] = true;
        return d3;
    }

    /* renamed from: a */
    static /* synthetic */ DownloadModel m6573a(DownloadAppViewModel downloadAppViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = downloadAppViewModel.getDownloadModel();
        $jacocoInit[1212] = true;
        return downloadModel;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6577a(DownloadModel downloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(downloadModel.isDownloading());
        $jacocoInit[1211] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6575a(int min, int max, DownloadModel downloadModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (downloadModel.getProgress() < min) {
            $jacocoInit[1205] = true;
        } else {
            $jacocoInit[1206] = true;
            if (downloadModel.getProgress() >= max) {
                $jacocoInit[1207] = true;
            } else {
                $jacocoInit[1208] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[1210] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[1209] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[1210] = true;
        return valueOf2;
    }

    private void loadInterstitialAd() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2165od odVar = C2165od.f5231a;
        $jacocoInit[80] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) odVar);
        C2185qf qfVar = new C2185qf(this);
        $jacocoInit[81] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qfVar);
        C1835Ja ja = new C1835Ja(this);
        $jacocoInit[82] = true;
        C0120S i = f.mo3668i(ja);
        C2128kg kgVar = C2128kg.f5191a;
        $jacocoInit[83] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) kgVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[84] = true;
        C0120S a = d2.mo3616a(v);
        C1838Jd jd = new C1838Jd(this);
        $jacocoInit[85] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) jd);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[86] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1820Hd hd = C1820Hd.f4819a;
        C2245wg wgVar = C2245wg.f5319a;
        $jacocoInit[87] = true;
        a2.mo3626a((C0129b<? super T>) hd, (C0129b<Throwable>) wgVar);
        $jacocoInit[88] = true;
    }

    /* renamed from: Ba */
    static /* synthetic */ Boolean m6533Ba(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[1202] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1203] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1204] = true;
        return valueOf;
    }

    /* renamed from: Ca */
    public /* synthetic */ C0120S mo10539Ca(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isAppViewReadyToDownload = this.view.isAppViewReadyToDownload();
        $jacocoInit[1201] = true;
        return isAppViewReadyToDownload;
    }

    /* renamed from: u */
    public /* synthetic */ Single mo10732u(Void model) {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadInterstitialAd = this.appViewManager.shouldLoadInterstitialAd();
        $jacocoInit[1200] = true;
        return shouldLoadInterstitialAd;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m6647m(Boolean loadInterstitial) {
        $jacocoInit()[1199] = true;
        return loadInterstitial;
    }

    /* renamed from: n */
    public /* synthetic */ void mo10705n(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.initInterstitialAd();
        $jacocoInit[1198] = true;
    }

    /* renamed from: o */
    static /* synthetic */ void m6652o(Boolean created) {
        $jacocoInit()[1197] = true;
    }

    /* renamed from: N */
    static /* synthetic */ void m6554N(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[1196] = true;
        throw onErrorNotImplementedException;
    }

    private Single<Boolean> handleConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldShowConsentDialog = this.appViewManager.shouldShowConsentDialog();
        C0126V v = this.viewScheduler;
        $jacocoInit[89] = true;
        Single a = shouldShowConsentDialog.mo3686a(v);
        C2029da daVar = new C2029da(this);
        $jacocoInit[90] = true;
        Single<Boolean> d = a.mo3698d(daVar);
        $jacocoInit[91] = true;
        return d;
    }

    /* renamed from: f */
    public /* synthetic */ Boolean mo10670f(Boolean shouldShowConsent) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!shouldShowConsent.booleanValue()) {
            $jacocoInit[1192] = true;
        } else {
            $jacocoInit[1193] = true;
            this.view.showConsentDialog();
            $jacocoInit[1194] = true;
        }
        Boolean valueOf = Boolean.valueOf(true);
        $jacocoInit[1195] = true;
        return valueOf;
    }

    private C0117M showBannerAd() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadBannerAd = this.appViewManager.shouldLoadBannerAd();
        C0126V v = this.viewScheduler;
        $jacocoInit[92] = true;
        Single a = shouldLoadBannerAd.mo3686a(v);
        C2199sb sbVar = new C2199sb(this);
        $jacocoInit[93] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) sbVar);
        $jacocoInit[94] = true;
        return b;
    }

    /* renamed from: u */
    public /* synthetic */ C0117M mo10730u(Boolean shouldLoadBanner) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!shouldLoadBanner.booleanValue()) {
            $jacocoInit[1188] = true;
        } else {
            $jacocoInit[1189] = true;
            this.view.showBannerAd();
            $jacocoInit[1190] = true;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[1191] = true;
        return b;
    }

    private void handleInterstitialAdClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2013be beVar = C2013be.f5051a;
        $jacocoInit[95] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) beVar);
        C2177pg pgVar = new C2177pg(this);
        $jacocoInit[96] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pgVar);
        C1904Qc qc = new C1904Qc(this);
        $jacocoInit[97] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) qc);
        $jacocoInit[98] = true;
        C0120S a = b.mo3616a(Schedulers.m776io());
        C1837Jc jc = new C1837Jc(this);
        $jacocoInit[99] = true;
        C0120S i = a.mo3668i(jc);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[100] = true;
        C0120S a2 = i.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2116je jeVar = C2116je.f5177a;
        C1878Nf nf = new C1878Nf(this);
        $jacocoInit[101] = true;
        a2.mo3626a((C0129b<? super T>) jeVar, (C0129b<Throwable>) nf);
        $jacocoInit[102] = true;
    }

    /* renamed from: na */
    static /* synthetic */ Boolean m6649na(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1187] = true;
        return valueOf;
    }

    /* renamed from: oa */
    public /* synthetic */ C0120S mo10708oa(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S InterstitialAdClicked = this.view.InterstitialAdClicked();
        $jacocoInit[1186] = true;
        return InterstitialAdClicked;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10604a(MoPubInterstitialAdClickType __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.installInterstitialClick();
        $jacocoInit[1185] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10629b(MoPubInterstitialAdClickType __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single recordInterstitialClick = this.appViewManager.recordInterstitialClick();
        $jacocoInit[1184] = true;
        return recordInterstitialClick;
    }

    /* renamed from: g */
    static /* synthetic */ void m6634g(Boolean __) {
        $jacocoInit()[1183] = true;
    }

    /* renamed from: G */
    public /* synthetic */ void mo10547G(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1182] = true;
    }

    private void handleOnSimilarAppsVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1766Bd bd = C1766Bd.f4758a;
        $jacocoInit[103] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bd);
        C1973Ya ya = new C1973Ya(this);
        $jacocoInit[104] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ya);
        $jacocoInit[105] = true;
        C0120S a = f.mo3616a(Schedulers.m776io());
        C1874Nb nb = new C1874Nb(this);
        $jacocoInit[106] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) nb);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[107] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1882Oa oa = C1882Oa.f4893a;
        C2134lc lcVar = new C2134lc(this);
        $jacocoInit[108] = true;
        a2.mo3626a((C0129b<? super T>) oa, (C0129b<Throwable>) lcVar);
        $jacocoInit[109] = true;
    }

    /* renamed from: ta */
    static /* synthetic */ Boolean m6662ta(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1181] = true;
        return valueOf;
    }

    /* renamed from: ua */
    public /* synthetic */ C0120S mo10734ua(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S similarAppsVisibility = this.view.similarAppsVisibility();
        $jacocoInit[1180] = true;
        return similarAppsVisibility;
    }

    /* renamed from: k */
    public /* synthetic */ void mo10693k(Boolean similarAppsVisible) {
        boolean[] $jacocoInit = $jacocoInit();
        sendSimilarAppsAdImpressionEvent(this.appViewManager.getCachedSimilarAppsViewModel());
        $jacocoInit[1178] = true;
        sendSimilarAppcAppsImpressionEvent(this.appViewManager.getCachedAppcSimilarAppsViewModel());
        $jacocoInit[1179] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m6644l(Boolean __) {
        $jacocoInit()[1177] = true;
    }

    /* renamed from: J */
    public /* synthetic */ void mo10556J(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1176] = true;
    }

    private void sendSimilarAppcAppsImpressionEvent(SimilarAppsViewModel appcSimilarAppsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (appcSimilarAppsViewModel == null) {
            $jacocoInit[110] = true;
        } else {
            $jacocoInit[111] = true;
            this.appViewAnalytics.similarAppcAppBundleImpression();
            $jacocoInit[112] = true;
        }
        $jacocoInit[113] = true;
    }

    private void sendSimilarAppsAdImpressionEvent(SimilarAppsViewModel similarAppsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (similarAppsViewModel == null) {
            $jacocoInit[114] = true;
        } else {
            $jacocoInit[115] = true;
            if (!similarAppsViewModel.hasAd()) {
                $jacocoInit[116] = true;
            } else {
                $jacocoInit[117] = true;
                if (similarAppsViewModel.hasRecordedAdImpression()) {
                    $jacocoInit[118] = true;
                } else {
                    $jacocoInit[119] = true;
                    similarAppsViewModel.setHasRecordedAdImpression(true);
                    AppViewAnalytics appViewAnalytics2 = this.appViewAnalytics;
                    $jacocoInit[120] = true;
                    ApplicationAd ad = similarAppsViewModel.getAd();
                    $jacocoInit[121] = true;
                    Network network = ad.getNetwork();
                    $jacocoInit[122] = true;
                    appViewAnalytics2.similarAppBundleImpression(network, true);
                    $jacocoInit[123] = true;
                }
            }
        }
        $jacocoInit[124] = true;
    }

    public void handleFirstLoad() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2112ja jaVar = C2112ja.f5173a;
        $jacocoInit[125] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jaVar);
        C2207sg sgVar = new C2207sg(this);
        $jacocoInit[126] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) sgVar);
        C2181qb qbVar = new C2181qb(this);
        $jacocoInit[127] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qbVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[128] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2063eb ebVar = C2063eb.f5112a;
        C1809Gb gb = new C1809Gb(this);
        $jacocoInit[129] = true;
        a.mo3626a((C0129b<? super T>) ebVar, (C0129b<Throwable>) gb);
        $jacocoInit[130] = true;
    }

    /* renamed from: ga */
    static /* synthetic */ Boolean m6635ga(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1175] = true;
        return valueOf;
    }

    /* renamed from: ha */
    public /* synthetic */ void mo10681ha(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[1174] = true;
    }

    /* renamed from: Z */
    public /* synthetic */ Single mo10584Z(AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M showBannerAd = showBannerAd();
        $jacocoInit[1168] = true;
        Single f = manageOrganicAds(appViewViewModel.getMinimalAd()).mo3700f(C1902Qa.f4916a);
        C2158ng ngVar = new C2158ng(appViewViewModel);
        $jacocoInit[1169] = true;
        Single d = f.mo3698d(ngVar);
        $jacocoInit[1170] = true;
        Single a = showBannerAd.mo3587a(d);
        $jacocoInit[1171] = true;
        return a;
    }

    /* renamed from: ia */
    public /* synthetic */ C0120S mo10687ia(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S i = loadApp().mo3668i(new C2108ig(this));
        C2192rd rdVar = new C2192rd(this);
        $jacocoInit[1158] = true;
        C0120S i2 = i.mo3668i(rdVar);
        $jacocoInit[1159] = true;
        return i2;
    }

    /* renamed from: Q */
    static /* synthetic */ SearchAdResult m6558Q(Throwable __1) {
        $jacocoInit()[1173] = true;
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ AppViewViewModel m6569a(AppViewViewModel appViewViewModel, SearchAdResult __1) {
        $jacocoInit()[1172] = true;
        return appViewViewModel;
    }

    /* renamed from: aa */
    public /* synthetic */ Single mo10619aa(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        if (app.hasDonations()) {
            $jacocoInit[1160] = true;
            Single topDonations = this.appViewManager.getTopDonations(app.getPackageName());
            C0126V v = this.viewScheduler;
            $jacocoInit[1161] = true;
            Single a = topDonations.mo3686a(v);
            C2009ba baVar = new C2009ba(this);
            $jacocoInit[1162] = true;
            Single b = a.mo3695b((C0129b<? super T>) baVar);
            C1818Hb hb = new C1818Hb(app);
            $jacocoInit[1163] = true;
            Single d = b.mo3698d(hb);
            $jacocoInit[1164] = true;
            return d;
        }
        Single a2 = Single.m734a(app);
        $jacocoInit[1165] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10617a(List donations) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showDonations(donations);
        $jacocoInit[1167] = true;
    }

    /* renamed from: a */
    static /* synthetic */ AppViewViewModel m6570a(AppViewViewModel app, List donations) {
        $jacocoInit()[1166] = true;
        return app;
    }

    /* renamed from: H */
    static /* synthetic */ void m6545H(AppViewViewModel __) {
        $jacocoInit()[1157] = true;
    }

    /* renamed from: D */
    public /* synthetic */ void mo10542D(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1156] = true;
    }

    public void handleAppcPromotion() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2030db dbVar = C2030db.f5073a;
        $jacocoInit[131] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) dbVar);
        C1884Oc oc = new C1884Oc(this);
        $jacocoInit[132] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oc);
        C1857Le le = new C1857Le(this);
        $jacocoInit[133] = true;
        C0120S i = f.mo3668i(le);
        C2117jf jfVar = C2117jf.f5178a;
        $jacocoInit[134] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) jfVar);
        C1769Bg bg = new C1769Bg(this);
        $jacocoInit[135] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bg);
        C0126V v = this.viewScheduler;
        $jacocoInit[136] = true;
        C0120S a = f2.mo3616a(v);
        C1958Wd wd = new C1958Wd(this);
        $jacocoInit[137] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) wd);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[138] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2104ic icVar = C2104ic.f5163a;
        C1805Fg fg = C1805Fg.f4801a;
        $jacocoInit[139] = true;
        a2.mo3626a((C0129b<? super T>) icVar, (C0129b<Throwable>) fg);
        $jacocoInit[140] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m6642k(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1155] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo10696l(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isAppViewReadyToDownload = this.view.isAppViewReadyToDownload();
        $jacocoInit[1154] = true;
        return isAppViewReadyToDownload;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10631b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1153] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6608c(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (app.hasBilling()) {
            $jacocoInit[1148] = true;
        } else if (app.hasAdvertising()) {
            $jacocoInit[1149] = true;
        } else {
            z = false;
            $jacocoInit[1151] = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[1152] = true;
            return valueOf;
        }
        $jacocoInit[1150] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[1152] = true;
        return valueOf2;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo10657d(AppViewViewModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadPromotionViewModel = this.appViewManager.loadPromotionViewModel();
        $jacocoInit[1147] = true;
        return loadPromotionViewModel;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void mo10608a(p005cm.aptoide.p006pt.app.PromotionViewModel r13) {
        /*
            r12 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.app.DownloadModel r1 = r13.getAppDownloadModel()
            r2 = 1
            r3 = 1120(0x460, float:1.57E-42)
            r0[r3] = r2
            cm.aptoide.pt.view.app.DetailedApp r3 = r13.getApp()
            cm.aptoide.pt.promotions.Promotion$ClaimAction r4 = p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction.INSTALL
            if (r1 != 0) goto L_0x001a
            r5 = 1121(0x461, float:1.571E-42)
            r0[r5] = r2
            goto L_0x002a
        L_0x001a:
            r5 = 1122(0x462, float:1.572E-42)
            r0[r5] = r2
            cm.aptoide.pt.app.DownloadModel$Action r5 = r1.getAction()
            cm.aptoide.pt.app.DownloadModel$Action r6 = p005cm.aptoide.p006pt.app.DownloadModel.Action.MIGRATE
            if (r5 == r6) goto L_0x0054
            r5 = 1123(0x463, float:1.574E-42)
            r0[r5] = r2
        L_0x002a:
            boolean r5 = r13.isAppMigrated()
            if (r5 != 0) goto L_0x0035
            r5 = 1125(0x465, float:1.576E-42)
            r0[r5] = r2
            goto L_0x005a
        L_0x0035:
            if (r1 != 0) goto L_0x003c
            r5 = 1126(0x466, float:1.578E-42)
            r0[r5] = r2
            goto L_0x005a
        L_0x003c:
            r5 = 1127(0x467, float:1.579E-42)
            r0[r5] = r2
            cm.aptoide.pt.app.DownloadModel$Action r5 = r1.getAction()
            cm.aptoide.pt.app.DownloadModel$Action r6 = p005cm.aptoide.p006pt.app.DownloadModel.Action.OPEN
            if (r5 == r6) goto L_0x004d
            r5 = 1128(0x468, float:1.58E-42)
            r0[r5] = r2
            goto L_0x005a
        L_0x004d:
            cm.aptoide.pt.promotions.Promotion$ClaimAction r4 = p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction.MIGRATE
            r5 = 1129(0x469, float:1.582E-42)
            r0[r5] = r2
            goto L_0x005a
        L_0x0054:
            cm.aptoide.pt.promotions.Promotion$ClaimAction r4 = p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction.MIGRATE
            r5 = 1124(0x464, float:1.575E-42)
            r0[r5] = r2
        L_0x005a:
            cm.aptoide.pt.app.AppViewManager r5 = r12.appViewManager
            r6 = 1130(0x46a, float:1.583E-42)
            r0[r6] = r2
            java.util.List r6 = r13.getPromotions()
            cm.aptoide.pt.promotions.Promotion r5 = r5.getClaimablePromotion(r6, r4)
            if (r5 != 0) goto L_0x0070
            r6 = 1131(0x46b, float:1.585E-42)
            r0[r6] = r2
            goto L_0x00f9
        L_0x0070:
            r6 = 1132(0x46c, float:1.586E-42)
            r0[r6] = r2
            cm.aptoide.pt.app.view.AppViewView r6 = r12.view
            cm.aptoide.pt.promotions.WalletApp r7 = r13.getWalletApp()
            r6.showAppcWalletPromotionView(r5, r7, r4, r1)
            r6 = 1133(0x46d, float:1.588E-42)
            r0[r6] = r2
            cm.aptoide.pt.app.AppViewManager r6 = r12.appViewManager
            boolean r6 = r6.isAppcPromotionImpressionSent()
            if (r6 == 0) goto L_0x008e
            r6 = 1134(0x46e, float:1.589E-42)
            r0[r6] = r2
            goto L_0x00a8
        L_0x008e:
            r6 = 1135(0x46f, float:1.59E-42)
            r0[r6] = r2
            cm.aptoide.pt.app.AppViewAnalytics r6 = r12.appViewAnalytics
            java.lang.String r7 = r5.getPromotionId()
            r6.sendPromotionImpression(r7)
            r6 = 1136(0x470, float:1.592E-42)
            r0[r6] = r2
            cm.aptoide.pt.app.AppViewManager r6 = r12.appViewManager
            r6.setAppcPromotionImpressionSent()
            r6 = 1137(0x471, float:1.593E-42)
            r0[r6] = r2
        L_0x00a8:
            cm.aptoide.pt.promotions.WalletApp r6 = r13.getWalletApp()
            r7 = 1138(0x472, float:1.595E-42)
            r0[r7] = r2
            boolean r6 = r6.isInstalled()
            if (r6 != 0) goto L_0x00bb
            r6 = 1139(0x473, float:1.596E-42)
            r0[r6] = r2
            goto L_0x00f9
        L_0x00bb:
            cm.aptoide.pt.app.DownloadModel$Action r6 = r1.getAction()
            cm.aptoide.pt.app.DownloadModel$Action r7 = p005cm.aptoide.p006pt.app.DownloadModel.Action.OPEN
            if (r6 == r7) goto L_0x00c8
            r6 = 1140(0x474, float:1.597E-42)
            r0[r6] = r2
            goto L_0x00f9
        L_0x00c8:
            r6 = 1141(0x475, float:1.599E-42)
            r0[r6] = r2
            cm.aptoide.pt.app.AppViewManager r6 = r12.appViewManager
            float r7 = r5.getAppc()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8 = 1142(0x476, float:1.6E-42)
            r0[r8] = r2
            java.lang.String r8 = r3.getIcon()
            java.lang.String r9 = r3.getPackageName()
            cm.aptoide.pt.dataprovider.model.v7.store.Store r10 = r3.getStore()
            r11 = 1143(0x477, float:1.602E-42)
            r0[r11] = r2
            java.lang.String r10 = r10.getName()
            r11 = 1144(0x478, float:1.603E-42)
            r0[r11] = r2
            r6.scheduleNotification(r7, r8, r9, r10)
            r6 = 1145(0x479, float:1.604E-42)
            r0[r6] = r2
        L_0x00f9:
            r6 = 1146(0x47a, float:1.606E-42)
            r0[r6] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.app.view.AppViewPresenter.mo10608a(cm.aptoide.pt.app.PromotionViewModel):void");
    }

    /* renamed from: b */
    static /* synthetic */ void m6599b(PromotionViewModel walletPromotionViewModel) {
        $jacocoInit()[1119] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m6630f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[1118] = true;
        throw onErrorNotImplementedException;
    }

    private Single<SearchAdResult> manageOrganicAds(SearchAdResult searchAdResult) {
        boolean[] $jacocoInit = $jacocoInit();
        if (searchAdResult == null) {
            $jacocoInit[141] = true;
            Single loadAdsFromAppView = this.appViewManager.loadAdsFromAppView();
            C2021cc ccVar = new C2021cc(this);
            $jacocoInit[142] = true;
            Single b = loadAdsFromAppView.mo3695b((C0129b<? super T>) ccVar);
            C2094hc hcVar = new C2094hc(this);
            $jacocoInit[143] = true;
            Single<SearchAdResult> a = b.mo3687a((C0129b<Throwable>) hcVar);
            $jacocoInit[144] = true;
            return a;
        }
        Single<SearchAdResult> a2 = Single.m734a(null);
        $jacocoInit[145] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10613a(SearchAdResult ad) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewManager.setSearchAdResult(ad);
        $jacocoInit[1116] = true;
        handleAdsLogic(this.appViewManager.getSearchAdResult());
        $jacocoInit[1117] = true;
    }

    /* renamed from: O */
    public /* synthetic */ void mo10566O(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1115] = true;
    }

    private void handleOnScroll() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1859Lg lg = C1859Lg.f4867a;
        $jacocoInit[146] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) lg);
        C2270zd zdVar = new C2270zd(this);
        $jacocoInit[147] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zdVar);
        C1888Og og = new C1888Og(this);
        $jacocoInit[148] = true;
        C0120S p = f.mo3680p(og);
        $jacocoInit[149] = true;
        C0120S a = p.mo3616a(Schedulers.m776io());
        C2105id idVar = new C2105id(this);
        $jacocoInit[150] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) idVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[151] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1765Bc bc = C1765Bc.f4757a;
        C1845Kb kb = new C1845Kb(this);
        $jacocoInit[152] = true;
        a2.mo3626a((C0129b<? super T>) bc, (C0129b<Throwable>) kb);
        $jacocoInit[153] = true;
    }

    /* renamed from: ra */
    static /* synthetic */ Boolean m6659ra(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1114] = true;
        return valueOf;
    }

    /* renamed from: sa */
    public /* synthetic */ C0120S mo10724sa(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S scrollVisibleSimilarApps = this.view.scrollVisibleSimilarApps();
        $jacocoInit[1113] = true;
        return scrollVisibleSimilarApps;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo10585a(C13045l __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.view.isSimilarAppsVisible());
        $jacocoInit[1112] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10636b(C13045l __) {
        boolean[] $jacocoInit = $jacocoInit();
        sendSimilarAppInteractEvent(this.appViewManager.getCachedSimilarAppsViewModel());
        $jacocoInit[1110] = true;
        sendSimilarAppcAppsImpressionEvent(this.appViewManager.getCachedAppcSimilarAppsViewModel());
        $jacocoInit[1111] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6613c(C13045l __) {
        $jacocoInit()[1109] = true;
    }

    /* renamed from: I */
    public /* synthetic */ void mo10552I(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1108] = true;
    }

    private void sendSimilarAppInteractEvent(SimilarAppsViewModel similarAppsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        sendSimilarAppsAdImpressionEvent(similarAppsViewModel);
        $jacocoInit[154] = true;
        this.appViewAnalytics.similarAppBundleImpression(null, false);
        $jacocoInit[155] = true;
    }

    private void handleAdsLogic(SearchAdResult searchAdResult) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewManager.handleAdsLogic(searchAdResult);
        $jacocoInit[156] = true;
        this.view.extractReferrer(searchAdResult);
        $jacocoInit[157] = true;
    }

    private void handleReviewAutoScroll() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2004af afVar = C2004af.f5042a;
        $jacocoInit[158] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) afVar);
        C2252xd xdVar = new C2252xd(this);
        $jacocoInit[159] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xdVar);
        C1995_f _fVar = new C1995_f(this);
        $jacocoInit[160] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) _fVar);
        C2195rg rgVar = C2195rg.f5263a;
        C1906Qe qe = new C1906Qe(this);
        $jacocoInit[161] = true;
        f2.mo3626a((C0129b<? super T>) rgVar, (C0129b<Throwable>) qe);
        $jacocoInit[162] = true;
    }

    /* renamed from: xa */
    static /* synthetic */ Boolean m6670xa(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1107] = true;
        return valueOf;
    }

    /* renamed from: ya */
    public /* synthetic */ C0120S mo10746ya(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S scrollReviewsResponse = this.view.scrollReviewsResponse();
        $jacocoInit[1106] = true;
        return scrollReviewsResponse;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10599a(Integer reviews) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S scheduleAnimations = scheduleAnimations(reviews.intValue());
        $jacocoInit[1105] = true;
        return scheduleAnimations;
    }

    /* renamed from: b */
    static /* synthetic */ void m6603b(Integer __) {
        $jacocoInit()[1104] = true;
    }

    /* renamed from: L */
    public /* synthetic */ void mo10561L(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[1103] = true;
    }

    private void handleClickOnScreenshot() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2176pf pfVar = C2176pf.f5243a;
        $jacocoInit[163] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) pfVar);
        C2230va vaVar = new C2230va(this);
        $jacocoInit[164] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vaVar);
        C1858Lf lf = C1858Lf.f4866a;
        $jacocoInit[165] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) lf);
        C1774Cc cc = new C1774Cc(this);
        $jacocoInit[166] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) cc);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[167] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1819Hc hc = C1819Hc.f4818a;
        C1983Zb zb = new C1983Zb(this);
        $jacocoInit[168] = true;
        a.mo3626a((C0129b<? super T>) hc, (C0129b<Throwable>) zb);
        $jacocoInit[169] = true;
    }

    /* renamed from: K */
    static /* synthetic */ Boolean m6549K(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1102] = true;
        return valueOf;
    }

    /* renamed from: L */
    public /* synthetic */ C0120S mo10559L(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S screenshotClickEvent = this.view.getScreenshotClickEvent();
        $jacocoInit[1101] = true;
        return screenshotClickEvent;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6579a(ScreenShotClickEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!event.isVideo()) {
            $jacocoInit[1098] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1099] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1100] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10635b(ScreenShotClickEvent imageClick) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendOpenScreenshotEvent();
        $jacocoInit[1094] = true;
        AppViewNavigator appViewNavigator2 = this.appViewNavigator;
        ArrayList imagesUris = imageClick.getImagesUris();
        $jacocoInit[1095] = true;
        int imagesIndex = imageClick.getImagesIndex();
        $jacocoInit[1096] = true;
        appViewNavigator2.navigateToScreenshots(imagesUris, imagesIndex);
        $jacocoInit[1097] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6612c(ScreenShotClickEvent __) {
        $jacocoInit()[1093] = true;
    }

    /* renamed from: s */
    public /* synthetic */ void mo10723s(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1092] = true;
    }

    private void handleClickOnVideo() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2062ea eaVar = C2062ea.f5111a;
        $jacocoInit[170] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) eaVar);
        C1849Kf kf = new C1849Kf(this);
        $jacocoInit[171] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kf);
        C1930Tc tc = C1930Tc.f4948a;
        $jacocoInit[172] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) tc);
        C1873Na na = new C1873Na(this);
        $jacocoInit[173] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) na);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[174] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1933Tf tf = C1933Tf.f4952a;
        C2183qd qdVar = new C2183qd(this);
        $jacocoInit[175] = true;
        a.mo3626a((C0129b<? super T>) tf, (C0129b<Throwable>) qdVar);
        $jacocoInit[176] = true;
    }

    /* renamed from: W */
    static /* synthetic */ Boolean m6567W(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1091] = true;
        return valueOf;
    }

    /* renamed from: X */
    public /* synthetic */ C0120S mo10581X(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S screenshotClickEvent = this.view.getScreenshotClickEvent();
        $jacocoInit[1090] = true;
        return screenshotClickEvent;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m6617d(ScreenShotClickEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.isVideo());
        $jacocoInit[1089] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ void mo10667e(ScreenShotClickEvent videoClick) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendOpenVideoEvent();
        $jacocoInit[1087] = true;
        this.appViewNavigator.navigateToUri(videoClick.getUri());
        $jacocoInit[1088] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m6629f(ScreenShotClickEvent __) {
        $jacocoInit()[1086] = true;
    }

    /* renamed from: y */
    public /* synthetic */ void mo10745y(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1085] = true;
    }

    private void handleClickOnDescriptionReadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1756Af af = C1756Af.f4750a;
        $jacocoInit[177] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) af);
        C2225ue ueVar = new C2225ue(this);
        $jacocoInit[178] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ueVar);
        C2244wf wfVar = new C2244wf(this);
        $jacocoInit[179] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) wfVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[180] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2154nc ncVar = C2154nc.f5218a;
        C1801Fc fc = new C1801Fc(this);
        $jacocoInit[181] = true;
        a.mo3626a((C0129b<? super T>) ncVar, (C0129b<Throwable>) fc);
        $jacocoInit[182] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m6660s(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1084] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo10725t(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickedReadMore = this.view.clickedReadMore();
        $jacocoInit[1083] = true;
        return clickedReadMore;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10609a(ReadMoreClickEvent readMoreClickEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendReadMoreEvent();
        $jacocoInit[1079] = true;
        AppViewNavigator appViewNavigator2 = this.appViewNavigator;
        String storeName = readMoreClickEvent.getStoreName();
        $jacocoInit[1080] = true;
        String description = readMoreClickEvent.getDescription();
        String storeTheme = readMoreClickEvent.getStoreTheme();
        $jacocoInit[1081] = true;
        appViewNavigator2.navigateToDescriptionReadMore(storeName, description, storeTheme);
        $jacocoInit[1082] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6600b(ReadMoreClickEvent __) {
        $jacocoInit()[1078] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo10690j(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1077] = true;
    }

    private void handleClickOnDeveloperWebsite() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2014bf bfVar = C2014bf.f5052a;
        $jacocoInit[183] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bfVar);
        C1804Ff ff = new C1804Ff(this);
        $jacocoInit[184] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ff);
        C1885Od od = new C1885Od(this);
        $jacocoInit[185] = true;
        C0120S i = f.mo3668i(od);
        C2096he heVar = C2096he.f5153a;
        $jacocoInit[186] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) heVar);
        C2020cb cbVar = new C2020cb(this);
        $jacocoInit[187] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) cbVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[188] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1976Yd yd = C1976Yd.f5008a;
        C1814Gg gg = new C1814Gg(this);
        $jacocoInit[189] = true;
        a.mo3626a((C0129b<? super T>) yd, (C0129b<Throwable>) gg);
        $jacocoInit[190] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m6529A(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1076] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo10534B(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickDeveloperWebsite = this.view.clickDeveloperWebsite();
        $jacocoInit[1075] = true;
        return clickDeveloperWebsite;
    }

    /* renamed from: j */
    public /* synthetic */ Single mo10689j(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1074] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m6650o(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AppDeveloper developer = app.getDeveloper();
        $jacocoInit[1069] = true;
        String website = developer.getWebsite();
        $jacocoInit[1070] = true;
        if (!TextUtils.isEmpty(website)) {
            $jacocoInit[1071] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1072] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1073] = true;
        return valueOf;
    }

    /* renamed from: m */
    public /* synthetic */ void mo10700m(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.navigateToDeveloperWebsite(app);
        $jacocoInit[1068] = true;
    }

    /* renamed from: n */
    static /* synthetic */ void m6648n(AppViewViewModel __) {
        $jacocoInit()[1067] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo10706n(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1066] = true;
    }

    private void handleClickOnAppcInfo() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1781Da da = C1781Da.f4775a;
        $jacocoInit[191] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) da);
        C2126ke keVar = new C2126ke(this);
        $jacocoInit[192] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) keVar);
        C2268zb zbVar = new C2268zb(this);
        $jacocoInit[193] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) zbVar);
        C2065ed edVar = C2065ed.f5114a;
        C1951Vf vf = new C1951Vf(this);
        $jacocoInit[194] = true;
        b.mo3626a((C0129b<? super T>) edVar, (C0129b<Throwable>) vf);
        $jacocoInit[195] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m6656q(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1065] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo10717r(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickGetAppcInfo = this.view.clickGetAppcInfo();
        $jacocoInit[1064] = true;
        return clickGetAppcInfo;
    }

    /* renamed from: e */
    public /* synthetic */ void mo10668e(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendAppcInfoInteractEvent();
        $jacocoInit[1062] = true;
        this.appViewNavigator.navigateToAppCoinsInfo();
        $jacocoInit[1063] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m6631f(Void __) {
        $jacocoInit()[1061] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo10686i(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[1060] = true;
    }

    private void handleClickOnDeveloperEmail() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1844Ka ka = C1844Ka.f4851a;
        $jacocoInit[196] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ka);
        C1948Vc vc = new C1948Vc(this);
        $jacocoInit[197] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vc);
        C2106ie ieVar = new C2106ie(this);
        $jacocoInit[198] = true;
        C0120S i = f.mo3668i(ieVar);
        C2035dg dgVar = C2035dg.f5078a;
        $jacocoInit[199] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) dgVar);
        C1792Ec ec = new C1792Ec(this);
        $jacocoInit[200] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) ec);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[201] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1821He he = C1821He.f4820a;
        C1764Bb bb = new C1764Bb(this);
        $jacocoInit[202] = true;
        a.mo3626a((C0129b<? super T>) he, (C0129b<Throwable>) bb);
        $jacocoInit[203] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m6663u(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1059] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo10735v(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickDeveloperEmail = this.view.clickDeveloperEmail();
        $jacocoInit[1058] = true;
        return clickDeveloperEmail;
    }

    /* renamed from: g */
    public /* synthetic */ Single mo10674g(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1057] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m6622e(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AppDeveloper developer = app.getDeveloper();
        $jacocoInit[1052] = true;
        String email = developer.getEmail();
        $jacocoInit[1053] = true;
        if (!TextUtils.isEmpty(email)) {
            $jacocoInit[1054] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1055] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1056] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ void mo10672f(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.navigateToDeveloperEmail(app);
        $jacocoInit[1051] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m6633g(AppViewViewModel __) {
        $jacocoInit()[1050] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo10694k(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1049] = true;
    }

    private void handleClickOnDeveloperPrivacy() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2068eg egVar = C2068eg.f5117a;
        $jacocoInit[204] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) egVar);
        C1802Fd fd = new C1802Fd(this);
        $jacocoInit[205] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fd);
        C1778Cg cg = new C1778Cg(this);
        $jacocoInit[206] = true;
        C0120S i = f.mo3668i(cg);
        C1850Kg kg = C1850Kg.f4857a;
        $jacocoInit[207] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) kg);
        C2226uf ufVar = new C2226uf(this);
        $jacocoInit[208] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) ufVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[209] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1907Qf qf = C1907Qf.f4921a;
        C1915Rf rf = new C1915Rf(this);
        $jacocoInit[210] = true;
        a.mo3626a((C0129b<? super T>) qf, (C0129b<Throwable>) rf);
        $jacocoInit[211] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m6671y(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1048] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo10747z(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickDeveloperPrivacy = this.view.clickDeveloperPrivacy();
        $jacocoInit[1047] = true;
        return clickDeveloperPrivacy;
    }

    /* renamed from: i */
    public /* synthetic */ Single mo10685i(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1046] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m6639j(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AppDeveloper developer = app.getDeveloper();
        $jacocoInit[1041] = true;
        String privacy = developer.getPrivacy();
        $jacocoInit[1042] = true;
        if (!TextUtils.isEmpty(privacy)) {
            $jacocoInit[1043] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[1044] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[1045] = true;
        return valueOf;
    }

    /* renamed from: k */
    public /* synthetic */ void mo10692k(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.navigateToDeveloperPrivacy(app);
        $jacocoInit[1040] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m6643l(AppViewViewModel __) {
        $jacocoInit()[1039] = true;
    }

    /* renamed from: m */
    public /* synthetic */ void mo10701m(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1038] = true;
    }

    private void handleClickOnDeveloperPermissions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2098hg hgVar = C2098hg.f5155a;
        $jacocoInit[212] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) hgVar);
        C2175pe peVar = new C2175pe(this);
        $jacocoInit[213] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) peVar);
        C1939Uc uc = new C1939Uc(this);
        $jacocoInit[214] = true;
        C0120S i = f.mo3668i(uc);
        C2088gg ggVar = new C2088gg(this);
        $jacocoInit[215] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) ggVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[216] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2190rb rbVar = C2190rb.f5258a;
        C2146me meVar = new C2146me(this);
        $jacocoInit[217] = true;
        a.mo3626a((C0129b<? super T>) rbVar, (C0129b<Throwable>) meVar);
        $jacocoInit[218] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m6667w(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1037] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo10741x(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickDeveloperPermissions = this.view.clickDeveloperPermissions();
        $jacocoInit[1036] = true;
        return clickDeveloperPermissions;
    }

    /* renamed from: h */
    public /* synthetic */ Single mo10678h(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1035] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: h */
    public /* synthetic */ void mo10679h(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.navigateToDeveloperPermissions(app);
        $jacocoInit[1034] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m6638i(AppViewViewModel __) {
        $jacocoInit()[1033] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo10698l(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1032] = true;
    }

    private void handleClickOnStoreLayout() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2012bd bdVar = C2012bd.f5050a;
        $jacocoInit[219] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bdVar);
        C2264yg ygVar = new C2264yg(this);
        $jacocoInit[220] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ygVar);
        C1932Te te = new C1932Te(this);
        $jacocoInit[221] = true;
        C0120S i = f.mo3668i(te);
        C1822Hf hf = new C1822Hf(this);
        $jacocoInit[222] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) hf);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[223] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1869Mg mg = C1869Mg.f4878a;
        C2212ta taVar = new C2212ta(this);
        $jacocoInit[224] = true;
        a.mo3626a((C0129b<? super T>) mg, (C0129b<Throwable>) taVar);
        $jacocoInit[225] = true;
    }

    /* renamed from: O */
    static /* synthetic */ Boolean m6556O(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1031] = true;
        return valueOf;
    }

    /* renamed from: P */
    public /* synthetic */ C0120S mo10568P(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickStoreLayout = this.view.clickStoreLayout();
        $jacocoInit[1030] = true;
        return clickStoreLayout;
    }

    /* renamed from: n */
    public /* synthetic */ Single mo10704n(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1029] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: w */
    public /* synthetic */ void mo10739w(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendStoreOpenEvent(app.getStore());
        $jacocoInit[1026] = true;
        this.appViewAnalytics.sendOpenStoreEvent();
        $jacocoInit[1027] = true;
        this.appViewNavigator.navigateToStore(app.getStore());
        $jacocoInit[1028] = true;
    }

    /* renamed from: x */
    static /* synthetic */ void m6669x(AppViewViewModel __) {
        $jacocoInit()[1025] = true;
    }

    /* renamed from: u */
    public /* synthetic */ void mo10733u(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[1024] = true;
    }

    private void handleClickOnFollowStore() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1978Yf yf = C1978Yf.f5010a;
        $jacocoInit[226] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) yf);
        C2064ec ecVar = new C2064ec(this);
        $jacocoInit[227] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ecVar);
        C2250xb xbVar = new C2250xb(this);
        $jacocoInit[228] = true;
        C0120S i = f.mo3668i(xbVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[229] = true;
        C0120S a = i.mo3616a(v);
        C2253xe xeVar = new C2253xe(this);
        $jacocoInit[230] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) xeVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[231] = true;
        C0120S a2 = g.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1830Ie ie = C1830Ie.f4833a;
        C1894Pb pb = C1894Pb.f4905a;
        $jacocoInit[232] = true;
        a2.mo3626a((C0129b<? super T>) ie, (C0129b<Throwable>) pb);
        $jacocoInit[233] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m6534C(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1023] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo10540D(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickFollowStore = this.view.clickFollowStore();
        $jacocoInit[1022] = true;
        return clickFollowStore;
    }

    /* renamed from: k */
    public /* synthetic */ Single mo10691k(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1021] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: p */
    public /* synthetic */ C0117M mo10709p(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        if (model.isStoreFollowed()) {
            $jacocoInit[1008] = true;
            this.view.setFollowButton(true);
            $jacocoInit[1009] = true;
            this.appViewAnalytics.sendOpenStoreEvent();
            $jacocoInit[1010] = true;
            this.appViewNavigator.navigateToStore(model.getStore());
            $jacocoInit[1011] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[1012] = true;
            return b;
        }
        this.view.setFollowButton(false);
        $jacocoInit[1013] = true;
        this.appViewAnalytics.sendFollowStoreEvent();
        $jacocoInit[1014] = true;
        AppViewView appViewView = this.view;
        Store store = model.getStore();
        $jacocoInit[1015] = true;
        String name = store.getName();
        $jacocoInit[1016] = true;
        appViewView.displayStoreFollowedSnack(name);
        $jacocoInit[1017] = true;
        AppViewManager appViewManager2 = this.appViewManager;
        Store store2 = model.getStore();
        $jacocoInit[1018] = true;
        String name2 = store2.getName();
        $jacocoInit[1019] = true;
        C0117M subscribeStore = appViewManager2.subscribeStore(name2);
        $jacocoInit[1020] = true;
        return subscribeStore;
    }

    /* renamed from: q */
    static /* synthetic */ void m6657q(AppViewViewModel __) {
        $jacocoInit()[1007] = true;
    }

    /* renamed from: o */
    static /* synthetic */ void m6653o(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(err);
        $jacocoInit[1006] = true;
        throw onErrorNotImplementedException;
    }

    private void handleClickOnOtherVersions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1992_c _cVar = C1992_c.f5026a;
        $jacocoInit[234] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) _cVar);
        C1867Me me = new C1867Me(this);
        $jacocoInit[235] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) me);
        C1803Fe fe = new C1803Fe(this);
        $jacocoInit[236] = true;
        C0120S i = f.mo3668i(fe);
        C1916Rg rg = new C1916Rg(this);
        $jacocoInit[237] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) rg);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[238] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2218tg tgVar = C2218tg.f5288a;
        C2249xa xaVar = new C2249xa(this);
        $jacocoInit[239] = true;
        a.mo3626a((C0129b<? super T>) tgVar, (C0129b<Throwable>) xaVar);
        $jacocoInit[240] = true;
    }

    /* renamed from: E */
    static /* synthetic */ Boolean m6538E(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[1005] = true;
        return valueOf;
    }

    /* renamed from: F */
    public /* synthetic */ C0120S mo10545F(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickOtherVersions = this.view.clickOtherVersions();
        $jacocoInit[1004] = true;
        return clickOtherVersions;
    }

    /* renamed from: l */
    public /* synthetic */ Single mo10697l(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[1003] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: r */
    public /* synthetic */ void mo10719r(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendOtherVersionsEvent();
        $jacocoInit[999] = true;
        AppViewNavigator appViewNavigator2 = this.appViewNavigator;
        String appName = model.getAppName();
        String icon = model.getIcon();
        $jacocoInit[1000] = true;
        String packageName = model.getPackageName();
        $jacocoInit[1001] = true;
        appViewNavigator2.navigateToOtherVersions(appName, icon, packageName);
        $jacocoInit[1002] = true;
    }

    /* renamed from: s */
    static /* synthetic */ void m6661s(AppViewViewModel __) {
        $jacocoInit()[998] = true;
    }

    /* renamed from: p */
    public /* synthetic */ void mo10712p(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[997] = true;
    }

    private void handleClickOnTrustedBadge() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1796Eg eg = C1796Eg.f4792a;
        $jacocoInit[241] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) eg);
        C2077ff ffVar = new C2077ff(this);
        $jacocoInit[242] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ffVar);
        C2125kd kdVar = new C2125kd(this);
        $jacocoInit[243] = true;
        C0120S i = f.mo3668i(kdVar);
        C2137lf lfVar = new C2137lf(this);
        $jacocoInit[244] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) lfVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[245] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2086ge geVar = C2086ge.f5140a;
        C1883Ob ob = new C1883Ob(this);
        $jacocoInit[246] = true;
        a.mo3626a((C0129b<? super T>) geVar, (C0129b<Throwable>) ob);
        $jacocoInit[247] = true;
    }

    /* renamed from: U */
    static /* synthetic */ Boolean m6565U(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[996] = true;
        return valueOf;
    }

    /* renamed from: V */
    public /* synthetic */ C0120S mo10575V(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickTrustedBadge = this.view.clickTrustedBadge();
        $jacocoInit[995] = true;
        return clickTrustedBadge;
    }

    /* renamed from: p */
    public /* synthetic */ Single mo10711p(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[994] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: B */
    public /* synthetic */ void mo10536B(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendBadgeClickEvent();
        $jacocoInit[992] = true;
        this.view.showTrustedDialog(model);
        $jacocoInit[993] = true;
    }

    /* renamed from: C */
    static /* synthetic */ void m6535C(AppViewViewModel __) {
        $jacocoInit()[991] = true;
    }

    /* renamed from: x */
    public /* synthetic */ void mo10743x(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[990] = true;
    }

    private void handleClickOnRateApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1876Nd nd = C1876Nd.f4887a;
        $jacocoInit[248] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nd);
        C1776Ce ce = new C1776Ce(this);
        $jacocoInit[249] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ce);
        C2206sf sfVar = new C2206sf(this);
        $jacocoInit[250] = true;
        C0120S i = f.mo3668i(sfVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[251] = true;
        C0120S a = i.mo3616a(v);
        C1898Pf pf = new C1898Pf(this);
        $jacocoInit[252] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) pf);
        C1864Mb mb = new C1864Mb(this);
        $jacocoInit[253] = true;
        C0120S f2 = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mb);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[254] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1987Zf zf = C1987Zf.f5021a;
        C2074fc fcVar = new C2074fc(this);
        $jacocoInit[255] = true;
        a2.mo3626a((C0129b<? super T>) zf, (C0129b<Throwable>) fcVar);
        $jacocoInit[256] = true;
    }

    /* renamed from: G */
    static /* synthetic */ Boolean m6543G(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[989] = true;
        return valueOf;
    }

    /* renamed from: H */
    public /* synthetic */ C0120S mo10549H(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickRateApp = this.view.clickRateApp();
        C0120S clickRateAppLarge = this.view.clickRateAppLarge();
        AppViewView appViewView = this.view;
        $jacocoInit[986] = true;
        C0120S clickRateAppLayout = appViewView.clickRateAppLayout();
        $jacocoInit[987] = true;
        C0120S a = C0120S.m637a(clickRateApp, clickRateAppLarge, clickRateAppLayout);
        $jacocoInit[988] = true;
        return a;
    }

    /* renamed from: m */
    public /* synthetic */ Single mo10699m(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[985] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: t */
    public /* synthetic */ void mo10727t(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendRateThisAppEvent();
        $jacocoInit[984] = true;
    }

    /* renamed from: u */
    public /* synthetic */ C0120S mo10731u(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewView appViewView = this.view;
        String appName = model.getAppName();
        String packageName = model.getPackageName();
        $jacocoInit[980] = true;
        Store store = model.getStore();
        $jacocoInit[981] = true;
        String name = store.getName();
        $jacocoInit[982] = true;
        C0120S showRateDialog = appViewView.showRateDialog(appName, packageName, name);
        $jacocoInit[983] = true;
        return showRateDialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m6589a(EResponse __) {
        $jacocoInit()[979] = true;
    }

    /* renamed from: q */
    public /* synthetic */ void mo10715q(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[978] = true;
    }

    private void handleClickReadReviews() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2031dc dcVar = C2031dc.f5074a;
        $jacocoInit[257] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) dcVar);
        C2204sd sdVar = new C2204sd(this);
        $jacocoInit[258] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sdVar);
        C2025cg cgVar = new C2025cg(this);
        $jacocoInit[259] = true;
        C0120S i = f.mo3668i(cgVar);
        C2163ob obVar = new C2163ob(this);
        $jacocoInit[260] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) obVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[261] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1969Xf xf = C1969Xf.f4998a;
        C1956Wb wb = new C1956Wb(this);
        $jacocoInit[262] = true;
        a.mo3626a((C0129b<? super T>) xf, (C0129b<Throwable>) wb);
        $jacocoInit[263] = true;
    }

    /* renamed from: Y */
    static /* synthetic */ Boolean m6568Y(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[977] = true;
        return valueOf;
    }

    /* renamed from: Z */
    public /* synthetic */ C0120S mo10583Z(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(this.view.clickReviewsLayout(), this.view.clickReadAllReviews());
        $jacocoInit[976] = true;
        return b;
    }

    /* renamed from: q */
    public /* synthetic */ Single mo10714q(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[975] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: D */
    public /* synthetic */ void mo10541D(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendReadAllEvent();
        $jacocoInit[968] = true;
        AppViewNavigator appViewNavigator2 = this.appViewNavigator;
        long appId = model.getAppId();
        String appName = model.getAppName();
        $jacocoInit[969] = true;
        Store store = model.getStore();
        $jacocoInit[970] = true;
        String name = store.getName();
        String packageName = model.getPackageName();
        Store store2 = model.getStore();
        $jacocoInit[971] = true;
        Appearance appearance = store2.getAppearance();
        $jacocoInit[972] = true;
        String theme = appearance.getTheme();
        $jacocoInit[973] = true;
        appViewNavigator2.navigateToRateAndReview(appId, appName, name, packageName, theme);
        $jacocoInit[974] = true;
    }

    /* renamed from: E */
    static /* synthetic */ void m6539E(AppViewViewModel __) {
        $jacocoInit()[967] = true;
    }

    /* renamed from: z */
    public /* synthetic */ void mo10750z(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[966] = true;
    }

    private void handleClickFlags() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2023ce ceVar = C2023ce.f5061a;
        $jacocoInit[264] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ceVar);
        C2015bg bgVar = new C2015bg(this);
        $jacocoInit[265] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bgVar);
        C1810Gc gc = new C1810Gc(this);
        $jacocoInit[266] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) gc);
        C2082ga gaVar = new C2082ga(this);
        $jacocoInit[267] = true;
        C0120S f2 = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gaVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[268] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2085gd gdVar = C2085gd.f5139a;
        C2215td tdVar = new C2215td(this);
        $jacocoInit[269] = true;
        a.mo3626a((C0129b<? super T>) gdVar, (C0129b<Throwable>) tdVar);
        $jacocoInit[270] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m6646m(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[965] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo10703n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickVirusFlag = this.view.clickVirusFlag();
        C0120S clickLicenseFlag = this.view.clickLicenseFlag();
        AppViewView appViewView = this.view;
        $jacocoInit[962] = true;
        C0120S clickWorkingFlag = appViewView.clickWorkingFlag();
        C0120S clickFakeFlag = this.view.clickFakeFlag();
        $jacocoInit[963] = true;
        C0120S a = C0120S.m638a(clickVirusFlag, clickLicenseFlag, clickWorkingFlag, clickFakeFlag);
        $jacocoInit[964] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10614a(VoteType type) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.disableFlags();
        $jacocoInit[961] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10628b(VoteType type) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[938] = true;
        C0120S d = accountStatus.mo3647d();
        C0126V v = this.viewScheduler;
        $jacocoInit[939] = true;
        C0120S a = d.mo3616a(v);
        C2216te teVar = new C2216te(this);
        $jacocoInit[940] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) teVar);
        C2224ud udVar = C2224ud.f5297a;
        $jacocoInit[941] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) udVar);
        C1991_b _bVar = new C1991_b(this);
        $jacocoInit[942] = true;
        C0120S i = d2.mo3668i(_bVar);
        C2162oa oaVar = new C2162oa(this, type);
        $jacocoInit[943] = true;
        C0120S i2 = i.mo3668i(oaVar);
        C2123kb kbVar = C2123kb.f5186a;
        $jacocoInit[944] = true;
        C0120S d3 = i2.mo3653d((C0132p<? super T, Boolean>) kbVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[945] = true;
        C0120S a2 = d3.mo3616a(v2);
        C1793Ed ed = new C1793Ed(this, type);
        $jacocoInit[946] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) ed);
        $jacocoInit[947] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10623b(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!account.isLoggedIn()) {
            $jacocoInit[956] = true;
            this.view.enableFlags();
            $jacocoInit[957] = true;
            this.view.displayNotLoggedInSnack();
            $jacocoInit[958] = true;
            C0120S c = C0120S.m652c(Boolean.valueOf(false));
            $jacocoInit[959] = true;
            return c;
        }
        C0120S c2 = C0120S.m652c(Boolean.valueOf(true));
        $jacocoInit[960] = true;
        return c2;
    }

    /* renamed from: p */
    static /* synthetic */ Boolean m6654p(Boolean isLoggedIn) {
        $jacocoInit()[955] = true;
        return isLoggedIn;
    }

    /* renamed from: q */
    public /* synthetic */ Single mo10713q(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[954] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10602a(VoteType type, AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        Store store = model.getStore();
        $jacocoInit[951] = true;
        String name = store.getName();
        String md5 = model.getMd5();
        $jacocoInit[952] = true;
        Single flagApk = appViewManager2.flagApk(name, md5, type);
        $jacocoInit[953] = true;
        return flagApk;
    }

    /* renamed from: r */
    static /* synthetic */ Boolean m6658r(Boolean result) {
        $jacocoInit()[950] = true;
        return result;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10615a(VoteType type, Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.incrementFlags(type);
        $jacocoInit[948] = true;
        this.view.showFlagVoteSubmittedMessage();
        $jacocoInit[949] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m6618d(Boolean __) {
        $jacocoInit()[937] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo10676g(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.enableFlags();
        $jacocoInit[935] = true;
        this.crashReport.log(err);
        $jacocoInit[936] = true;
    }

    private void handleClickLoginSnack() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1974Yb yb = C1974Yb.f5006a;
        $jacocoInit[271] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) yb);
        C1836Jb jb = new C1836Jb(this);
        $jacocoInit[272] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jb);
        C1813Gf gf = new C1813Gf(this);
        $jacocoInit[273] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) gf);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[274] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2171pa paVar = C2171pa.f5237a;
        C2222ub ubVar = new C2222ub(this);
        $jacocoInit[275] = true;
        a.mo3626a((C0129b<? super T>) paVar, (C0129b<Throwable>) ubVar);
        $jacocoInit[276] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m6651o(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[934] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo10710p(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickLoginSnack = this.view.clickLoginSnack();
        $jacocoInit[933] = true;
        return clickLoginSnack;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10654c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.APP_VIEW_FLAG);
        $jacocoInit[932] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m6620d(Void __) {
        $jacocoInit()[931] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo10680h(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[930] = true;
    }

    private void handleClickOnSimilarApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2193re reVar = C2193re.f5261a;
        $jacocoInit[277] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) reVar);
        C1773Cb cb = new C1773Cb(this);
        $jacocoInit[278] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cb);
        C0126V v = this.viewScheduler;
        $jacocoInit[279] = true;
        C0120S a = f.mo3616a(v);
        C1919Sa sa = new C1919Sa(this);
        $jacocoInit[280] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sa);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[281] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2261yd ydVar = C2261yd.f5335a;
        C1826Ia ia = new C1826Ia(this);
        $jacocoInit[282] = true;
        a2.mo3626a((C0129b<? super T>) ydVar, (C0129b<Throwable>) ia);
        $jacocoInit[283] = true;
    }

    /* renamed from: M */
    static /* synthetic */ Boolean m6552M(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[929] = true;
        return valueOf;
    }

    /* renamed from: N */
    public /* synthetic */ C0120S mo10564N(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickSimilarApp = this.view.clickSimilarApp();
        $jacocoInit[928] = true;
        return clickSimilarApp;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10598a(SimilarAppClickEvent similarAppClickEvent) {
        String packageName;
        boolean[] $jacocoInit = $jacocoInit();
        boolean isAd = false;
        Network network = null;
        $jacocoInit[901] = true;
        AppViewSimilarApp appViewSimilarApp = similarAppClickEvent.getSimilar();
        $jacocoInit[902] = true;
        if (appViewSimilarApp.isAd()) {
            isAd = true;
            $jacocoInit[903] = true;
            ApplicationAd ad = appViewSimilarApp.getAd();
            $jacocoInit[904] = true;
            network = ad.getNetwork();
            $jacocoInit[905] = true;
            ApplicationAd ad2 = appViewSimilarApp.getAd();
            $jacocoInit[906] = true;
            packageName = ad2.getPackageName();
            $jacocoInit[907] = true;
            ApplicationAd ad3 = appViewSimilarApp.getAd();
            $jacocoInit[908] = true;
            if (ad3.getNetwork() != Network.SERVER) {
                $jacocoInit[909] = true;
            } else {
                $jacocoInit[910] = true;
                AppViewNavigator appViewNavigator2 = this.appViewNavigator;
                AptoideNativeAd aptoideNativeAd = (AptoideNativeAd) appViewSimilarApp.getAd();
                $jacocoInit[911] = true;
                SimilarAppType type = similarAppClickEvent.getType();
                $jacocoInit[912] = true;
                String description = type.getDescription();
                $jacocoInit[913] = true;
                appViewNavigator2.navigateToAd(aptoideNativeAd, description);
                $jacocoInit[914] = true;
            }
        } else {
            Application app = appViewSimilarApp.getApp();
            $jacocoInit[915] = true;
            packageName = app.getPackageName();
            $jacocoInit[916] = true;
            AppViewNavigator appViewNavigator3 = this.appViewNavigator;
            Application app2 = appViewSimilarApp.getApp();
            $jacocoInit[917] = true;
            long appId = app2.getAppId();
            SimilarAppType type2 = similarAppClickEvent.getType();
            $jacocoInit[918] = true;
            String description2 = type2.getDescription();
            $jacocoInit[919] = true;
            appViewNavigator3.navigateToAppView(appId, packageName, description2);
            $jacocoInit[920] = true;
        }
        AppViewAnalytics appViewAnalytics2 = this.appViewAnalytics;
        SimilarAppType type3 = similarAppClickEvent.getType();
        $jacocoInit[921] = true;
        String description3 = type3.getDescription();
        $jacocoInit[922] = true;
        appViewAnalytics2.sendSimilarAppsInteractEvent(description3);
        $jacocoInit[923] = true;
        AppViewAnalytics appViewAnalytics3 = this.appViewAnalytics;
        SimilarAppType type4 = similarAppClickEvent.getType();
        $jacocoInit[924] = true;
        int position = similarAppClickEvent.getPosition();
        $jacocoInit[925] = true;
        appViewAnalytics3.similarAppClick(type4, network, packageName, position, isAd);
        $jacocoInit[926] = true;
        C0120S c = C0120S.m652c(Boolean.valueOf(isAd));
        $jacocoInit[927] = true;
        return c;
    }

    /* renamed from: e */
    static /* synthetic */ void m6625e(Boolean __) {
        $jacocoInit()[900] = true;
    }

    /* renamed from: t */
    public /* synthetic */ void mo10729t(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[899] = true;
    }

    private void handleClickOnToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2233vd vdVar = C2233vd.f5306a;
        $jacocoInit[284] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) vdVar);
        C2254xf xfVar = new C2254xf(this);
        $jacocoInit[285] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xfVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[286] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2103ib ibVar = C2103ib.f5162a;
        C1868Mf mf = new C1868Mf(this);
        $jacocoInit[287] = true;
        a.mo3626a((C0129b<? super T>) ibVar, (C0129b<Throwable>) mf);
        $jacocoInit[288] = true;
    }

    /* renamed from: Q */
    static /* synthetic */ Boolean m6560Q(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[898] = true;
        return valueOf;
    }

    /* renamed from: R */
    public /* synthetic */ C0120S mo10570R(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickToolbar = this.view.clickToolbar();
        C1937Ua ua = new C1937Ua(this);
        $jacocoInit[881] = true;
        C0120S f = clickToolbar.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ua);
        $jacocoInit[882] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10592a(MenuItem menuItem) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[883] = true;
        C0120S c = loadAppViewViewModel.mo3696c();
        C1753Ac ac = new C1753Ac(menuItem);
        $jacocoInit[884] = true;
        C0120S d = c.mo3653d((C0132p<? super T, Boolean>) ac);
        C0126V v = this.viewScheduler;
        $jacocoInit[885] = true;
        C0120S a = d.mo3616a(v);
        C2142ma maVar = new C2142ma(this, menuItem);
        $jacocoInit[886] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) maVar);
        $jacocoInit[887] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6576a(MenuItem menuItem, AppViewViewModel appViewViewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (menuItem != null) {
            $jacocoInit[895] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[896] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[897] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10633b(MenuItem menuItem, AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (menuItem.getItemId()) {
            case C1375R.C1376id.menu_item_share /*2131296975*/:
                AppViewView appViewView = this.view;
                String appName = appViewViewModel.getAppName();
                $jacocoInit[889] = true;
                String webUrls = appViewViewModel.getWebUrls();
                $jacocoInit[890] = true;
                appViewView.defaultShare(appName, webUrls);
                $jacocoInit[891] = true;
                break;
            case C1375R.C1376id.menu_remote_install /*2131296976*/:
                this.appViewAnalytics.sendRemoteInstallEvent();
                $jacocoInit[892] = true;
                this.view.showShareOnTvDialog(appViewViewModel.getAppId());
                $jacocoInit[893] = true;
                break;
            default:
                $jacocoInit[888] = true;
                break;
        }
        $jacocoInit[894] = true;
    }

    /* renamed from: y */
    static /* synthetic */ void m6672y(AppViewViewModel __) {
        $jacocoInit()[880] = true;
    }

    /* renamed from: v */
    public /* synthetic */ void mo10736v(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[879] = true;
    }

    private void handleClickOnRetry() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2005ag agVar = C2005ag.f5043a;
        $jacocoInit[289] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) agVar);
        C1914Re re = new C1914Re(this);
        $jacocoInit[290] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) re);
        C2033de deVar = C2033de.f5076a;
        C2156ne neVar = new C2156ne(this);
        $jacocoInit[291] = true;
        f.mo3626a((C0129b<? super T>) deVar, (C0129b<Throwable>) neVar);
        $jacocoInit[292] = true;
    }

    /* renamed from: I */
    static /* synthetic */ Boolean m6547I(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[878] = true;
        return valueOf;
    }

    /* renamed from: J */
    public /* synthetic */ C0120S mo10554J(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(this.view.clickNoNetworkRetry(), this.view.clickGenericRetry());
        C1800Fb fb = new C1800Fb(this);
        $jacocoInit[872] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) fb);
        C1811Gd gd = new C1811Gd(this);
        $jacocoInit[873] = true;
        C0120S f = b2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gd);
        $jacocoInit[874] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[875] = true;
        return g;
    }

    /* renamed from: v */
    public /* synthetic */ void mo10737v(Void __1) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[877] = true;
    }

    /* renamed from: w */
    public /* synthetic */ C0120S mo10738w(Void __2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadApp = loadApp();
        $jacocoInit[876] = true;
        return loadApp;
    }

    /* renamed from: v */
    static /* synthetic */ void m6664v(AppViewViewModel __) {
        $jacocoInit()[871] = true;
    }

    /* renamed from: r */
    public /* synthetic */ void mo10720r(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(e);
        $jacocoInit[870] = true;
    }

    private C0120S<Integer> scheduleAnimations(int topReviewsCount) {
        boolean[] $jacocoInit = $jacocoInit();
        if (topReviewsCount <= 1) {
            $jacocoInit[293] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[294] = true;
            instance.mo2148w(str, "Not enough top reviews to do paging animation.");
            $jacocoInit[295] = true;
            C0120S<Integer> c = C0120S.m651c();
            $jacocoInit[296] = true;
            return c;
        }
        C0120S a = C0120S.m626a(0, topReviewsCount);
        C1905Qd qd = new C1905Qd(this);
        $jacocoInit[297] = true;
        C0120S<Integer> a2 = a.mo3622a((C0132p<? super T, ? extends C0120S<? extends R>>) qd);
        $jacocoInit[298] = true;
        return a2;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo10661d(Integer pos) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(pos);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[865] = true;
        C0120S b = c.mo3630b((long) TIME_BETWEEN_SCROLL, timeUnit);
        $jacocoInit[866] = true;
        C0120S a = b.mo3616a(C14522a.m46170a());
        C2240wb wbVar = new C2240wb(this);
        $jacocoInit[867] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) wbVar);
        $jacocoInit[868] = true;
        return b2;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10652c(Integer pos2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.scrollReviews(pos2);
        $jacocoInit[869] = true;
    }

    private C0120S<AppViewViewModel> loadApp() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        C2107if ifVar = new C2107if(this);
        $jacocoInit[299] = true;
        Single a = loadAppViewViewModel.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) ifVar);
        C2133lb lbVar = new C2133lb(this);
        $jacocoInit[300] = true;
        Single a2 = a.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) lbVar);
        $jacocoInit[301] = true;
        C0120S c = a2.mo3696c();
        C0126V v = this.viewScheduler;
        $jacocoInit[302] = true;
        C0120S a3 = c.mo3616a(v);
        C2022cd cdVar = new C2022cd(this);
        $jacocoInit[303] = true;
        C0120S b = a3.mo3636b((C0129b<? super T>) cdVar);
        C1808Ga ga = new C1808Ga(this);
        $jacocoInit[304] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) ga);
        C1908Qg qg = new C1908Qg(this);
        $jacocoInit[305] = true;
        C0120S f = b2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qg);
        C2172pb pbVar = new C2172pb(this);
        $jacocoInit[306] = true;
        C0120S b3 = f.mo3636b((C0129b<? super T>) pbVar);
        C2011bc bcVar = C2011bc.f5049a;
        $jacocoInit[307] = true;
        C0120S d = b3.mo3653d((C0132p<? super T, Boolean>) bcVar);
        C1772Ca ca = new C1772Ca(this);
        $jacocoInit[308] = true;
        C0120S<AppViewViewModel> f2 = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ca);
        $jacocoInit[309] = true;
        return f2;
    }

    /* renamed from: I */
    public /* synthetic */ Single mo10551I(AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M loadAppCoinsInformation = this.appViewManager.loadAppCoinsInformation();
        $jacocoInit[863] = true;
        Single a = loadAppCoinsInformation.mo3587a(Single.m734a(appViewViewModel));
        $jacocoInit[864] = true;
        return a;
    }

    /* renamed from: J */
    public /* synthetic */ Single mo10555J(AppViewViewModel appViewViewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        String md5 = appViewViewModel.getMd5();
        $jacocoInit[828] = true;
        String packageName = appViewViewModel.getPackageName();
        int versionCode = appViewViewModel.getVersionCode();
        $jacocoInit[829] = true;
        boolean isPaid = appViewViewModel.isPaid();
        Pay pay = appViewViewModel.getPay();
        $jacocoInit[830] = true;
        String signature = appViewViewModel.getSignature();
        Store store = appViewViewModel.getStore();
        $jacocoInit[831] = true;
        long id = store.getId();
        if (appViewViewModel.hasAdvertising()) {
            $jacocoInit[832] = true;
        } else if (appViewViewModel.hasBilling()) {
            $jacocoInit[833] = true;
        } else {
            z = false;
            $jacocoInit[835] = true;
            C0120S loadDownloadAppViewModel = appViewManager2.loadDownloadAppViewModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
            $jacocoInit[836] = true;
            C0120S d = loadDownloadAppViewModel.mo3647d();
            C0126V v = this.viewScheduler;
            $jacocoInit[837] = true;
            C0120S a = d.mo3616a(v);
            C2087gf gfVar = new C2087gf(this, appViewViewModel);
            $jacocoInit[838] = true;
            C0120S b = a.mo3636b((C0129b<? super T>) gfVar);
            C1831If ifR = new C1831If(this);
            $jacocoInit[839] = true;
            C0120S b2 = b.mo3636b((C0129b<? super T>) ifR);
            C2083gb gbVar = new C2083gb(this);
            $jacocoInit[840] = true;
            C0120S b3 = b2.mo3636b((C0129b<? super T>) gbVar);
            $jacocoInit[841] = true;
            Single n = b3.mo3678n();
            C2191rc rcVar = new C2191rc(appViewViewModel);
            $jacocoInit[842] = true;
            Single d2 = n.mo3698d(rcVar);
            $jacocoInit[843] = true;
            return d2;
        }
        $jacocoInit[834] = true;
        z = true;
        C0120S loadDownloadAppViewModel2 = appViewManager2.loadDownloadAppViewModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
        $jacocoInit[836] = true;
        C0120S d3 = loadDownloadAppViewModel2.mo3647d();
        C0126V v2 = this.viewScheduler;
        $jacocoInit[837] = true;
        C0120S a2 = d3.mo3616a(v2);
        C2087gf gfVar2 = new C2087gf(this, appViewViewModel);
        $jacocoInit[838] = true;
        C0120S b4 = a2.mo3636b((C0129b<? super T>) gfVar2);
        C1831If ifR2 = new C1831If(this);
        $jacocoInit[839] = true;
        C0120S b22 = b4.mo3636b((C0129b<? super T>) ifR2);
        C2083gb gbVar2 = new C2083gb(this);
        $jacocoInit[840] = true;
        C0120S b32 = b22.mo3636b((C0129b<? super T>) gbVar2);
        $jacocoInit[841] = true;
        Single n2 = b32.mo3678n();
        C2191rc rcVar2 = new C2191rc(appViewViewModel);
        $jacocoInit[842] = true;
        Single d22 = n2.mo3698d(rcVar2);
        $jacocoInit[843] = true;
        return d22;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10605a(AppViewViewModel appViewViewModel, DownloadAppViewModel downloadAppViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = downloadAppViewModel.getDownloadModel();
        $jacocoInit[854] = true;
        Action action = downloadModel.getAction();
        Action action2 = Action.MIGRATE;
        $jacocoInit[855] = true;
        if (!action.equals(action2)) {
            $jacocoInit[856] = true;
        } else {
            AppViewManager appViewManager2 = this.appViewManager;
            $jacocoInit[857] = true;
            if (appViewManager2.isMigrationImpressionSent()) {
                $jacocoInit[858] = true;
            } else {
                $jacocoInit[859] = true;
                this.appViewManager.setMigrationImpressionSent();
                $jacocoInit[860] = true;
                this.appViewAnalytics.sendAppcMigrationAppOpen();
                $jacocoInit[861] = true;
            }
        }
        this.view.showDownloadAppModel(downloadAppViewModel, appViewViewModel.hasDonations());
        $jacocoInit[862] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10651c(DownloadAppViewModel downloadAppViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.readyToDownload();
        $jacocoInit[853] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo10663d(DownloadAppViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsViewModel appCoinsViewModel = model.getAppCoinsViewModel();
        $jacocoInit[845] = true;
        AppCoinsAdvertisingModel advertisingModel = appCoinsViewModel.getAdvertisingModel();
        $jacocoInit[846] = true;
        if (advertisingModel.getHasAdvertising()) {
            $jacocoInit[847] = true;
        } else {
            AppCoinsViewModel appCoinsViewModel2 = model.getAppCoinsViewModel();
            $jacocoInit[848] = true;
            if (!appCoinsViewModel2.hasBilling()) {
                $jacocoInit[849] = true;
                $jacocoInit[852] = true;
            }
            $jacocoInit[850] = true;
        }
        this.view.setupAppcAppView();
        $jacocoInit[851] = true;
        $jacocoInit[852] = true;
    }

    /* renamed from: b */
    static /* synthetic */ AppViewViewModel m6594b(AppViewViewModel appViewViewModel, DownloadAppViewModel downloadAppViewModel) {
        $jacocoInit()[844] = true;
        return appViewViewModel;
    }

    /* renamed from: K */
    public /* synthetic */ void mo10557K(AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (appViewModel.hasError()) {
            $jacocoInit[824] = true;
            this.view.handleError(appViewModel.getError());
            $jacocoInit[825] = true;
        } else {
            this.view.showAppView(appViewModel);
            $jacocoInit[826] = true;
        }
        $jacocoInit[827] = true;
    }

    /* renamed from: L */
    public /* synthetic */ void mo10560L(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        String editorsChoice = model.getEditorsChoice();
        $jacocoInit[813] = true;
        if (editorsChoice.isEmpty()) {
            $jacocoInit[814] = true;
        } else {
            $jacocoInit[815] = true;
            AppViewManager appViewManager2 = this.appViewManager;
            String packageName = model.getPackageName();
            $jacocoInit[816] = true;
            String editorsChoice2 = model.getEditorsChoice();
            $jacocoInit[817] = true;
            appViewManager2.sendEditorsChoiceClickEvent(packageName, editorsChoice2);
            $jacocoInit[818] = true;
        }
        AppViewManager appViewManager3 = this.appViewManager;
        String packageName2 = model.getPackageName();
        AppDeveloper developer = model.getDeveloper();
        $jacocoInit[819] = true;
        String name = developer.getName();
        Malware malware = model.getMalware();
        $jacocoInit[820] = true;
        Rank rank = malware.getRank();
        $jacocoInit[821] = true;
        String name2 = rank.name();
        boolean hasBilling = model.hasBilling();
        boolean hasAdvertising = model.hasAdvertising();
        $jacocoInit[822] = true;
        appViewManager3.sendAppViewOpenedFromEvent(packageName2, name, name2, hasBilling, hasAdvertising);
        $jacocoInit[823] = true;
    }

    /* renamed from: M */
    public /* synthetic */ C0120S mo10562M(AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (appViewModel.getOpenType() == OpenType.OPEN_AND_INSTALL) {
            $jacocoInit[762] = true;
            C0120S accountStatus = this.accountManager.accountStatus();
            $jacocoInit[763] = true;
            C0120S d = accountStatus.mo3647d();
            C0126V v = this.viewScheduler;
            $jacocoInit[764] = true;
            C0120S a = d.mo3616a(v);
            C1896Pd pd = new C1896Pd(this, appViewModel);
            $jacocoInit[765] = true;
            C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) pd);
            C2173pc pcVar = new C2173pc(appViewModel);
            $jacocoInit[766] = true;
            C0120S j = g.mo3669j(pcVar);
            $jacocoInit[767] = true;
            return j;
        } else if (appViewModel.getOpenType() == OpenType.OPEN_WITH_INSTALL_POPUP) {
            $jacocoInit[768] = true;
            C0120S accountStatus2 = this.accountManager.accountStatus();
            $jacocoInit[769] = true;
            C0120S d2 = accountStatus2.mo3647d();
            C0126V v2 = this.viewScheduler;
            $jacocoInit[770] = true;
            C0120S a2 = d2.mo3616a(v2);
            C1929Tb tb = new C1929Tb(this, appViewModel);
            $jacocoInit[771] = true;
            C0120S f = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tb);
            C1942Uf uf = new C1942Uf(appViewModel);
            $jacocoInit[772] = true;
            C0120S j2 = f.mo3669j(uf);
            $jacocoInit[773] = true;
            return j2;
        } else if (appViewModel.getOpenType() == OpenType.APK_FY_INSTALL_POPUP) {
            $jacocoInit[774] = true;
            C0120S accountStatus3 = this.accountManager.accountStatus();
            $jacocoInit[775] = true;
            C0120S d3 = accountStatus3.mo3647d();
            C0126V v3 = this.viewScheduler;
            $jacocoInit[776] = true;
            C0120S a3 = d3.mo3616a(v3);
            C1854Lb lb = new C1854Lb(this, appViewModel);
            $jacocoInit[777] = true;
            C0120S f2 = a3.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lb);
            C2127kf kfVar = new C2127kf(appViewModel);
            $jacocoInit[778] = true;
            C0120S j3 = f2.mo3669j(kfVar);
            $jacocoInit[779] = true;
            return j3;
        } else {
            C0120S c = C0120S.m652c(appViewModel);
            $jacocoInit[780] = true;
            return c;
        }
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo10586a(AppViewViewModel appViewModel, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = downloadApp(Action.INSTALL, appViewModel);
        C2221ua uaVar = new C2221ua(this, appViewModel);
        $jacocoInit[806] = true;
        C0117M a = downloadApp.mo3582a((C0128a) uaVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[807] = true;
        C0117M a2 = a.mo3581a(v);
        $jacocoInit[808] = true;
        return a2;
    }

    /* renamed from: S */
    public /* synthetic */ void mo10571S(AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewAnalytics appViewAnalytics2 = this.appViewAnalytics;
        String packageName = appViewModel.getPackageName();
        $jacocoInit[809] = true;
        AppDeveloper developer = appViewModel.getDeveloper();
        $jacocoInit[810] = true;
        String name = developer.getName();
        String str = Action.INSTALL.toString();
        $jacocoInit[811] = true;
        appViewAnalytics2.clickOnInstallButton(packageName, name, str);
        $jacocoInit[812] = true;
    }

    /* renamed from: b */
    static /* synthetic */ AppViewViewModel m6593b(AppViewViewModel appViewModel, Account __) {
        $jacocoInit()[805] = true;
        return appViewModel;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo10645c(AppViewViewModel appViewModel, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewView appViewView = this.view;
        String marketName = appViewModel.getMarketName();
        $jacocoInit[795] = true;
        String appName = appViewModel.getAppName();
        $jacocoInit[796] = true;
        C0120S showOpenAndInstallDialog = appViewView.showOpenAndInstallDialog(marketName, appName);
        C2189ra raVar = new C2189ra(this, appViewModel);
        $jacocoInit[797] = true;
        C0120S g = showOpenAndInstallDialog.mo3663g((C0132p<? super T, ? extends C0117M>) raVar);
        $jacocoInit[798] = true;
        return g;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo10620b(AppViewViewModel appViewModel, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = downloadApp(action, appViewModel).mo3582a((C0128a) new C2223uc(this, appViewModel, action));
        C0126V v = this.viewScheduler;
        $jacocoInit[799] = true;
        C0117M a2 = a.mo3581a(v);
        $jacocoInit[800] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10606a(AppViewViewModel appViewModel, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewAnalytics appViewAnalytics2 = this.appViewAnalytics;
        String packageName = appViewModel.getPackageName();
        $jacocoInit[801] = true;
        AppDeveloper developer = appViewModel.getDeveloper();
        $jacocoInit[802] = true;
        String name = developer.getName();
        String str = action.toString();
        $jacocoInit[803] = true;
        appViewAnalytics2.clickOnInstallButton(packageName, name, str);
        $jacocoInit[804] = true;
    }

    /* renamed from: c */
    static /* synthetic */ AppViewViewModel m6607c(AppViewViewModel appViewModel, Action __) {
        $jacocoInit()[794] = true;
        return appViewModel;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo10658d(AppViewViewModel appViewModel, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewView appViewView = this.view;
        String marketName = appViewModel.getMarketName();
        $jacocoInit[782] = true;
        String appName = appViewModel.getAppName();
        double appc = appViewModel.getAppc();
        AppRating rating = appViewModel.getRating();
        $jacocoInit[783] = true;
        float average = rating.getAverage();
        String icon = appViewModel.getIcon();
        int packageDownloads = appViewModel.getPackageDownloads();
        $jacocoInit[784] = true;
        C0120S showOpenAndInstallApkFyDialog = appViewView.showOpenAndInstallApkFyDialog(marketName, appName, appc, average, icon, packageDownloads);
        C2174pd pdVar = new C2174pd(this, appViewModel);
        $jacocoInit[785] = true;
        C0120S g = showOpenAndInstallApkFyDialog.mo3663g((C0132p<? super T, ? extends C0117M>) pdVar);
        $jacocoInit[786] = true;
        return g;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo10665e(AppViewViewModel appViewModel, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = downloadApp(action, appViewModel).mo3581a(this.viewScheduler);
        C2095hd hdVar = new C2095hd(this, appViewModel, action);
        $jacocoInit[787] = true;
        C0117M a2 = a.mo3582a((C0128a) hdVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[788] = true;
        C0117M a3 = a2.mo3581a(v);
        $jacocoInit[789] = true;
        return a3;
    }

    /* renamed from: d */
    public /* synthetic */ void mo10662d(AppViewViewModel appViewModel, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewAnalytics appViewAnalytics2 = this.appViewAnalytics;
        $jacocoInit[790] = true;
        String packageName = appViewModel.getPackageName();
        AppDeveloper developer = appViewModel.getDeveloper();
        $jacocoInit[791] = true;
        String name = developer.getName();
        String str = action.toString();
        $jacocoInit[792] = true;
        appViewAnalytics2.clickOnInstallButton(packageName, name, str);
        $jacocoInit[793] = true;
    }

    /* renamed from: f */
    static /* synthetic */ AppViewViewModel m6628f(AppViewViewModel appViewModel, Action __) {
        $jacocoInit()[781] = true;
        return appViewModel;
    }

    /* renamed from: N */
    public /* synthetic */ void mo10565N(AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.recoverScrollViewState();
        $jacocoInit[761] = true;
    }

    /* renamed from: O */
    static /* synthetic */ Boolean m6555O(AppViewViewModel model) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!model.hasError()) {
            $jacocoInit[758] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[759] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[760] = true;
        return valueOf;
    }

    /* renamed from: P */
    public /* synthetic */ C0120S mo10567P(AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updateSimilarAppsBundles = updateSimilarAppsBundles(appViewModel);
        $jacocoInit[751] = true;
        C0120S updateReviews = updateReviews(appViewModel);
        C1791Eb eb = new C1791Eb(appViewModel);
        $jacocoInit[752] = true;
        C0120S b = C0120S.m650b(updateSimilarAppsBundles, updateReviews, (C14541q<? super T1, ? super T2, ? extends R>) eb);
        $jacocoInit[753] = true;
        C0120S d = b.mo3647d();
        C2092ha haVar = new C2092ha(appViewModel);
        $jacocoInit[754] = true;
        C0120S j = d.mo3669j(haVar);
        $jacocoInit[755] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6584a(AppViewViewModel appViewModel, List similarAppsBundles, ReviewsViewModel reviewsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(appViewModel);
        $jacocoInit[757] = true;
        return c;
    }

    /* renamed from: a */
    static /* synthetic */ AppViewViewModel m6571a(AppViewViewModel appViewModel, C0120S __) {
        $jacocoInit()[756] = true;
        return appViewModel;
    }

    private C0120S<List<SimilarAppsBundle>> updateSimilarAppsBundles(AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(new ArrayList());
        C2078fg fgVar = new C2078fg(this, appViewViewModel);
        $jacocoInit[310] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fgVar);
        C1895Pc pc = new C1895Pc(this, appViewViewModel);
        $jacocoInit[311] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pc);
        C1897Pe pe = new C1897Pe(this, appViewViewModel);
        $jacocoInit[312] = true;
        C0120S f3 = f2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pe);
        C0126V v = this.viewScheduler;
        $jacocoInit[313] = true;
        C0120S a = f3.mo3616a(v);
        C1846Kc kc = new C1846Kc(this);
        $jacocoInit[314] = true;
        C0120S<List<SimilarAppsBundle>> b = a.mo3636b((C0129b<? super T>) kc);
        $jacocoInit[315] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10594a(AppViewViewModel appViewViewModel, ArrayList list) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updateSuggestedAppcApps = updateSuggestedAppcApps(appViewViewModel, list);
        $jacocoInit[750] = true;
        return updateSuggestedAppcApps;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10624b(AppViewViewModel appViewViewModel, List list) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updateSuggestedApps = updateSuggestedApps(appViewViewModel, list);
        $jacocoInit[749] = true;
        return updateSuggestedApps;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo10646c(AppViewViewModel appViewViewModel, List list) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S sortSuggestedApps = sortSuggestedApps(appViewViewModel, list);
        $jacocoInit[748] = true;
        return sortSuggestedApps;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10638b(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.populateSimilar(list);
        $jacocoInit[747] = true;
    }

    private C0120S<List<SimilarAppsBundle>> sortSuggestedApps(AppViewViewModel appViewViewModel, List<SimilarAppsBundle> list) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(list);
        C1941Ue ue = new C1941Ue(list, appViewViewModel);
        $jacocoInit[316] = true;
        C0120S<List<SimilarAppsBundle>> j = c.mo3669j(ue);
        $jacocoInit[317] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ List m6582a(List list, AppViewViewModel appViewViewModel, List __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (list.size() < 2) {
            $jacocoInit[735] = true;
        } else {
            $jacocoInit[736] = true;
            if (appViewViewModel.isAppCoinApp()) {
                $jacocoInit[737] = true;
                SimilarAppsBundle similarAppsBundle = (SimilarAppsBundle) list.get(0);
                $jacocoInit[738] = true;
                if (similarAppsBundle.getType() != BundleType.APPS) {
                    $jacocoInit[739] = true;
                } else {
                    $jacocoInit[740] = true;
                    Collections.swap(list, 0, 1);
                    $jacocoInit[741] = true;
                }
            } else {
                SimilarAppsBundle similarAppsBundle2 = (SimilarAppsBundle) list.get(0);
                $jacocoInit[742] = true;
                if (similarAppsBundle2.getType() != BundleType.APPC_APPS) {
                    $jacocoInit[743] = true;
                } else {
                    $jacocoInit[744] = true;
                    Collections.swap(list, 0, 1);
                    $jacocoInit[745] = true;
                }
            }
        }
        $jacocoInit[746] = true;
        return list;
    }

    private C0120S<List<SimilarAppsBundle>> updateSuggestedAppcApps(AppViewViewModel appViewModel, List<SimilarAppsBundle> list) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        String packageName = appViewModel.getPackageName();
        $jacocoInit[318] = true;
        AppMedia media = appViewModel.getMedia();
        $jacocoInit[319] = true;
        List keywords = media.getKeywords();
        $jacocoInit[320] = true;
        Single loadAppcSimilarAppsViewModel = appViewManager2.loadAppcSimilarAppsViewModel(packageName, keywords);
        C1865Mc mc = new C1865Mc(list);
        $jacocoInit[321] = true;
        Single d = loadAppcSimilarAppsViewModel.mo3698d(mc);
        $jacocoInit[322] = true;
        C0120S<List<SimilarAppsBundle>> c = d.mo3696c();
        $jacocoInit[323] = true;
        return c;
    }

    /* renamed from: a */
    static /* synthetic */ List m6583a(List list, SimilarAppsViewModel appcAppsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!appcAppsViewModel.hasSimilarApps()) {
            $jacocoInit[731] = true;
        } else {
            $jacocoInit[732] = true;
            list.add(new SimilarAppsBundle(appcAppsViewModel, BundleType.APPC_APPS));
            $jacocoInit[733] = true;
        }
        $jacocoInit[734] = true;
        return list;
    }

    private C0120S<List<SimilarAppsBundle>> updateSuggestedApps(AppViewViewModel appViewModel, List<SimilarAppsBundle> list) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        String packageName = appViewModel.getPackageName();
        $jacocoInit[324] = true;
        AppMedia media = appViewModel.getMedia();
        $jacocoInit[325] = true;
        List keywords = media.getKeywords();
        $jacocoInit[326] = true;
        Single loadSimilarAppsViewModel = appViewManager2.loadSimilarAppsViewModel(packageName, keywords);
        C1848Ke ke = new C1848Ke(this);
        $jacocoInit[327] = true;
        Single a = loadSimilarAppsViewModel.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) ke);
        C2073fb fbVar = new C2073fb(list);
        $jacocoInit[328] = true;
        Single d = a.mo3698d(fbVar);
        $jacocoInit[329] = true;
        C0120S<List<SimilarAppsBundle>> c = d.mo3696c();
        $jacocoInit[330] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10601a(SimilarAppsViewModel similarAppsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadNativeAds = this.appViewManager.shouldLoadNativeAds();
        similarAppsViewModel.getClass();
        C2150mi miVar = new C2150mi(similarAppsViewModel);
        $jacocoInit[727] = true;
        Single b = shouldLoadNativeAds.mo3695b((C0129b<? super T>) miVar);
        C2263yf yfVar = new C2263yf(similarAppsViewModel);
        $jacocoInit[728] = true;
        Single d = b.mo3698d(yfVar);
        $jacocoInit[729] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ SimilarAppsViewModel m6574a(SimilarAppsViewModel similarAppsViewModel, Boolean __) {
        $jacocoInit()[730] = true;
        return similarAppsViewModel;
    }

    /* renamed from: b */
    static /* synthetic */ List m6596b(List list, SimilarAppsViewModel similarAppsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!similarAppsViewModel.hasSimilarApps()) {
            $jacocoInit[723] = true;
        } else {
            $jacocoInit[724] = true;
            list.add(new SimilarAppsBundle(similarAppsViewModel, BundleType.APPS));
            $jacocoInit[725] = true;
        }
        $jacocoInit[726] = true;
        return list;
    }

    private C0120S<ReviewsViewModel> updateReviews(AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        Store store = appViewModel.getStore();
        $jacocoInit[331] = true;
        String name = store.getName();
        String packageName = appViewModel.getPackageName();
        String languageFilter = this.view.getLanguageFilter();
        $jacocoInit[332] = true;
        Single loadReviewsViewModel = appViewManager2.loadReviewsViewModel(name, packageName, languageFilter);
        C0126V v = this.viewScheduler;
        $jacocoInit[333] = true;
        Single a = loadReviewsViewModel.mo3686a(v);
        C1847Kd kd = new C1847Kd(this);
        $jacocoInit[334] = true;
        Single a2 = a.mo3687a((C0129b<Throwable>) kd);
        C2157nf nfVar = new C2157nf(this, appViewModel);
        $jacocoInit[335] = true;
        Single b = a2.mo3695b((C0129b<? super T>) nfVar);
        $jacocoInit[336] = true;
        C0120S<ReviewsViewModel> c = b.mo3696c();
        $jacocoInit[337] = true;
        return c;
    }

    /* renamed from: W */
    public /* synthetic */ void mo10579W(Throwable __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideReviews();
        $jacocoInit[722] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10607a(AppViewViewModel appViewModel, ReviewsViewModel reviewsViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (reviewsViewModel.hasError()) {
            $jacocoInit[718] = true;
            this.view.hideReviews();
            $jacocoInit[719] = true;
        } else {
            this.view.populateReviews(reviewsViewModel, appViewModel);
            $jacocoInit[720] = true;
        }
        $jacocoInit[721] = true;
    }

    private void cancelDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1994_e _eVar = C1994_e.f5029a;
        $jacocoInit[338] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) _eVar);
        C1920Sb sb = new C1920Sb(this);
        $jacocoInit[339] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sb);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[340] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1968Xe xe = C1968Xe.f4997a;
        C2155nd ndVar = C2155nd.f5219a;
        $jacocoInit[341] = true;
        a.mo3626a((C0129b<? super T>) xe, (C0129b<Throwable>) ndVar);
        $jacocoInit[342] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6580a(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[715] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[716] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[717] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10626b(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelDownload = this.view.cancelDownload();
        C2124kc kcVar = new C2124kc(this);
        $jacocoInit[705] = true;
        C0120S i = cancelDownload.mo3668i(kcVar);
        C1965Xb xb = new C1965Xb(this);
        $jacocoInit[706] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) xb);
        C1866Md md = new C1866Md(this);
        $jacocoInit[707] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) md);
        $jacocoInit[708] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[709] = true;
        return g2;
    }

    /* renamed from: x */
    public /* synthetic */ Single mo10742x(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[714] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: T */
    public /* synthetic */ void mo10573T(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendDownloadCancelEvent(app.getPackageName());
        $jacocoInit[713] = true;
    }

    /* renamed from: U */
    public /* synthetic */ C0117M mo10574U(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        String md5 = app.getMd5();
        String packageName = app.getPackageName();
        $jacocoInit[710] = true;
        int versionCode = app.getVersionCode();
        $jacocoInit[711] = true;
        C0117M cancelDownload = appViewManager2.cancelDownload(md5, packageName, versionCode);
        $jacocoInit[712] = true;
        return cancelDownload;
    }

    /* renamed from: a */
    static /* synthetic */ void m6587a(AppViewViewModel created) {
        $jacocoInit()[704] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6591a(Throwable error) {
        $jacocoInit()[703] = true;
    }

    private void resumeDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1947Vb vb = C1947Vb.f4971a;
        $jacocoInit[343] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) vb);
        C2152na naVar = new C2152na(this);
        $jacocoInit[344] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) naVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[345] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1783Dc dc = C1783Dc.f4777a;
        C2267za zaVar = C2267za.f5341a;
        $jacocoInit[346] = true;
        a.mo3626a((C0129b<? super T>) dc, (C0129b<Throwable>) zaVar);
        $jacocoInit[347] = true;
    }

    /* renamed from: Ha */
    static /* synthetic */ Boolean m6546Ha(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[700] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[701] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[702] = true;
        return valueOf;
    }

    /* renamed from: Ia */
    public /* synthetic */ C0120S mo10553Ia(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S resumeDownload = this.view.resumeDownload();
        C1832Ig ig = new C1832Ig(this);
        $jacocoInit[690] = true;
        C0120S f = resumeDownload.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ig);
        $jacocoInit[691] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[692] = true;
        return g;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo10659d(Action downloadAction) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        C2198sa saVar = new C2198sa(this);
        $jacocoInit[693] = true;
        C0120S f = requestDownloadAccess.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) saVar);
        C2168og ogVar = new C2168og(this);
        $jacocoInit[694] = true;
        C0120S i = f.mo3668i(ogVar);
        C2003ae aeVar = new C2003ae(this, downloadAction);
        $jacocoInit[695] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) aeVar);
        $jacocoInit[696] = true;
        return g;
    }

    /* renamed from: y */
    public /* synthetic */ C0120S mo10744y(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[699] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: z */
    public /* synthetic */ Single mo10748z(Void __1) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[698] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo10587a(Action downloadAction, AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M resumeDownload = this.appViewManager.resumeDownload(app.getMd5(), app.getAppId(), downloadAction);
        $jacocoInit[697] = true;
        return resumeDownload;
    }

    /* renamed from: ca */
    static /* synthetic */ void m6616ca(AppViewViewModel created) {
        $jacocoInit()[689] = true;
    }

    /* renamed from: T */
    static /* synthetic */ void m6564T(Throwable error) {
        $jacocoInit()[688] = true;
    }

    private void pauseDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1982Za za = C1982Za.f5014a;
        $jacocoInit[348] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) za);
        C1751Aa aa = new C1751Aa(this);
        $jacocoInit[349] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aa);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[350] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1913Rd rd = C1913Rd.f4927a;
        C2115jd jdVar = C2115jd.f5176a;
        $jacocoInit[351] = true;
        a.mo3626a((C0129b<? super T>) rd, (C0129b<Throwable>) jdVar);
        $jacocoInit[352] = true;
    }

    /* renamed from: Da */
    static /* synthetic */ Boolean m6537Da(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[685] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[686] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[687] = true;
        return valueOf;
    }

    /* renamed from: Ea */
    public /* synthetic */ C0120S mo10544Ea(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S pauseDownload = this.view.pauseDownload();
        C1768Bf bf = new C1768Bf(this);
        $jacocoInit[677] = true;
        C0120S i = pauseDownload.mo3668i(bf);
        C1752Ab ab = new C1752Ab(this);
        $jacocoInit[678] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) ab);
        C1794Ee ee = new C1794Ee(this);
        $jacocoInit[679] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) ee);
        $jacocoInit[680] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[681] = true;
        return g2;
    }

    /* renamed from: A */
    public /* synthetic */ Single mo10532A(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[684] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: V */
    public /* synthetic */ void mo10576V(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendDownloadPauseEvent(app.getPackageName());
        $jacocoInit[683] = true;
    }

    /* renamed from: W */
    public /* synthetic */ C0117M mo10578W(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseDownload = this.appViewManager.pauseDownload(app.getMd5());
        $jacocoInit[682] = true;
        return pauseDownload;
    }

    /* renamed from: ba */
    static /* synthetic */ void m6606ba(AppViewViewModel created) {
        $jacocoInit()[676] = true;
    }

    /* renamed from: R */
    static /* synthetic */ void m6561R(Throwable error) {
        $jacocoInit()[675] = true;
    }

    private void handleInstallButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2200sc scVar = C2200sc.f5268a;
        $jacocoInit[353] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) scVar);
        C1957Wc wc = new C1957Wc(this);
        $jacocoInit[354] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wc);
        $jacocoInit[355] = true;
        C0120S d2 = f.mo3647d();
        C0126V v = this.viewScheduler;
        $jacocoInit[356] = true;
        C0120S a = d2.mo3616a(v);
        C1946Va va = new C1946Va(this);
        $jacocoInit[357] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) va);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[358] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1853La la = C1853La.f4860a;
        C1910Ra ra = C1910Ra.f4924a;
        $jacocoInit[359] = true;
        a2.mo3626a((C0129b<? super T>) la, (C0129b<Throwable>) ra);
        $jacocoInit[360] = true;
    }

    /* renamed from: ja */
    static /* synthetic */ Boolean m6641ja(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[672] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[673] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[674] = true;
        return valueOf;
    }

    /* renamed from: ka */
    public /* synthetic */ C0120S mo10695ka(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[671] = true;
        return accountStatus;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10593a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installAppClick = this.view.installAppClick();
        C2241wc wcVar = new C2241wc(this);
        $jacocoInit[620] = true;
        C0120S g = installAppClick.mo3663g((C0132p<? super T, ? extends C0117M>) wcVar);
        C1886Oe oe = C1886Oe.f4897a;
        $jacocoInit[621] = true;
        C0120S a = g.mo3621a((C0129b<? super Throwable>) oe);
        $jacocoInit[622] = true;
        C0120S g2 = a.mo3662g();
        $jacocoInit[623] = true;
        return g2;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo10666e(Action action) {
        C0117M completable;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[625] = true;
        switch (C17611.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[action.ordinal()]) {
            case 1:
            case 2:
                Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
                C1931Td td = new C1931Td(this, action);
                $jacocoInit[626] = true;
                completable = loadAppViewViewModel.mo3693b((C0132p<? super T, ? extends C0117M>) td);
                $jacocoInit[627] = true;
                break;
            case 3:
                Single loadAppViewViewModel2 = this.appViewManager.loadAppViewViewModel();
                C0126V v = this.viewScheduler;
                $jacocoInit[628] = true;
                Single a = loadAppViewViewModel2.mo3686a(v);
                C1928Ta ta = new C1928Ta(this);
                $jacocoInit[629] = true;
                completable = a.mo3693b((C0132p<? super T, ? extends C0117M>) ta);
                $jacocoInit[630] = true;
                break;
            case 4:
                Single loadAppViewViewModel3 = this.appViewManager.loadAppViewViewModel();
                C0126V v2 = this.viewScheduler;
                $jacocoInit[631] = true;
                Single a2 = loadAppViewViewModel3.mo3686a(v2);
                C1960Wf wf = new C1960Wf(this, action);
                $jacocoInit[632] = true;
                completable = a2.mo3693b((C0132p<? super T, ? extends C0117M>) wf);
                $jacocoInit[633] = true;
                break;
            case 5:
                Single loadAppViewViewModel4 = this.appViewManager.loadAppViewViewModel();
                C0126V v3 = this.viewScheduler;
                $jacocoInit[634] = true;
                Single a3 = loadAppViewViewModel4.mo3686a(v3);
                C2118jg jgVar = new C2118jg(this);
                $jacocoInit[635] = true;
                completable = a3.mo3693b((C0132p<? super T, ? extends C0117M>) jgVar);
                $jacocoInit[636] = true;
                break;
            case 6:
                Single loadAppViewViewModel5 = this.appViewManager.loadAppViewViewModel();
                C0126V v4 = this.viewScheduler;
                $jacocoInit[637] = true;
                Single a4 = loadAppViewViewModel5.mo3686a(v4);
                C2269zc zcVar = new C2269zc(this, action);
                $jacocoInit[638] = true;
                completable = a4.mo3693b((C0132p<? super T, ? extends C0117M>) zcVar);
                $jacocoInit[639] = true;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid type of action");
                $jacocoInit[640] = true;
                completable = C0117M.m591b((Throwable) illegalArgumentException);
                $jacocoInit[641] = true;
                break;
        }
        $jacocoInit[642] = true;
        return completable;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo10621b(Action action, AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = downloadApp(action, appViewModel).mo3581a(this.viewScheduler);
        C1829Id id = new C1829Id(this, appViewModel, action);
        $jacocoInit[654] = true;
        C0117M a2 = a.mo3582a((C0128a) id);
        $jacocoInit[655] = true;
        Single b = a2.mo3597b(Boolean.valueOf(true));
        $jacocoInit[656] = true;
        C0117M b2 = b.mo3692b();
        $jacocoInit[657] = true;
        return b2;
    }

    /* renamed from: g */
    public /* synthetic */ void mo10675g(AppViewViewModel appViewModel, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        String conversionUrl = appViewModel.getCampaignUrl();
        $jacocoInit[658] = true;
        if (conversionUrl.isEmpty()) {
            $jacocoInit[659] = true;
        } else {
            CampaignAnalytics campaignAnalytics2 = this.campaignAnalytics;
            $jacocoInit[660] = true;
            String packageName = appViewModel.getPackageName();
            int versionCode = appViewModel.getVersionCode();
            $jacocoInit[661] = true;
            campaignAnalytics2.sendCampaignConversionEvent(conversionUrl, packageName, versionCode);
            $jacocoInit[662] = true;
        }
        AppViewAnalytics appViewAnalytics2 = this.appViewAnalytics;
        String packageName2 = appViewModel.getPackageName();
        $jacocoInit[663] = true;
        AppDeveloper developer = appViewModel.getDeveloper();
        $jacocoInit[664] = true;
        String name = developer.getName();
        String str = action.toString();
        $jacocoInit[665] = true;
        appViewAnalytics2.clickOnInstallButton(packageName2, name, str);
        $jacocoInit[666] = true;
        if (!this.appViewManager.hasClaimablePromotion(ClaimAction.INSTALL)) {
            $jacocoInit[667] = true;
        } else {
            $jacocoInit[668] = true;
            this.appViewAnalytics.sendInstallPromotionApp();
            $jacocoInit[669] = true;
        }
        $jacocoInit[670] = true;
    }

    /* renamed from: X */
    public /* synthetic */ C0117M mo10580X(AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M openInstalledApp = openInstalledApp(appViewViewModel.getPackageName());
        $jacocoInit[653] = true;
        return openInstalledApp;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo10642c(Action action, AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downgradeApp = downgradeApp(action, appViewViewModel);
        $jacocoInit[652] = true;
        return downgradeApp;
    }

    /* renamed from: Y */
    public /* synthetic */ C0117M mo10582Y(AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M payApp = payApp(appViewViewModel.getAppId());
        $jacocoInit[651] = true;
        return payApp;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo10655d(Action action, AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.appViewManager.hasClaimablePromotion(ClaimAction.MIGRATE)) {
            $jacocoInit[643] = true;
        } else {
            $jacocoInit[644] = true;
            this.appViewAnalytics.sendAppcMigrationUpdateClick();
            $jacocoInit[645] = true;
        }
        AppViewAnalytics appViewAnalytics2 = this.appViewAnalytics;
        String packageName = appViewViewModel.getPackageName();
        $jacocoInit[646] = true;
        AppDeveloper developer = appViewViewModel.getDeveloper();
        $jacocoInit[647] = true;
        String name = developer.getName();
        $jacocoInit[648] = true;
        appViewAnalytics2.clickOnInstallButton(packageName, name, "UPDATE TO APPC");
        $jacocoInit[649] = true;
        C0117M migrateApp = migrateApp(action, appViewViewModel);
        $jacocoInit[650] = true;
        return migrateApp;
    }

    /* renamed from: P */
    static /* synthetic */ void m6557P(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[624] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6610c(Action created) {
        $jacocoInit()[619] = true;
    }

    /* renamed from: E */
    static /* synthetic */ void m6540E(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        IllegalStateException illegalStateException = new IllegalStateException(error);
        $jacocoInit[618] = true;
        throw illegalStateException;
    }

    private C0117M payApp(long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1817Ha(this, appId));
        $jacocoInit[361] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10603a(long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendPaymentViewShowEvent();
        $jacocoInit[616] = true;
        this.appViewNavigator.buyApp(appId);
        $jacocoInit[617] = true;
    }

    private C0117M downgradeApp(Action action, AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showDowngradeMessage = this.view.showDowngradeMessage();
        C2034df dfVar = C2034df.f5077a;
        $jacocoInit[362] = true;
        C0120S d = showDowngradeMessage.mo3653d((C0132p<? super T, Boolean>) dfVar);
        C2272zf zfVar = new C2272zf(this);
        $jacocoInit[363] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) zfVar);
        C1777Cf cf = new C1777Cf(this, action, appViewModel);
        $jacocoInit[364] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) cf);
        $jacocoInit[365] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[366] = true;
        return l;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6581a(Boolean downgrade) {
        $jacocoInit()[615] = true;
        return downgrade;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10637b(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showDowngradingMessage();
        $jacocoInit[614] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo10588a(Action action, AppViewViewModel appViewModel, Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = downloadApp(action, appViewModel);
        $jacocoInit[613] = true;
        return downloadApp;
    }

    private C0117M migrateApp(Action action, AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = downloadApp(action, appViewViewModel);
        $jacocoInit[367] = true;
        return downloadApp;
    }

    private C0117M openInstalledApp(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1923Se(this, packageName));
        $jacocoInit[368] = true;
        return c;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10653c(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.openApp(packageName);
        $jacocoInit[612] = true;
    }

    private C0117M downloadApp(Action action, AppViewViewModel appViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m643a((C0131o<C0120S<T>>) new C1986Ze<C0120S<T>>(this, action));
        C0126V v = this.viewScheduler;
        $jacocoInit[369] = true;
        C0120S a2 = a.mo3616a(v);
        C1922Sd sd = new C1922Sd(this, action, appViewModel);
        $jacocoInit[370] = true;
        C0120S f = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sd);
        $jacocoInit[371] = true;
        C0117M l = f.mo3673l();
        $jacocoInit[372] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10595a(Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.appViewManager.shouldShowRootInstallWarningPopup()) {
            $jacocoInit[605] = true;
            C0120S showRootInstallWarningPopup = this.view.showRootInstallWarningPopup();
            C1887Of of = new C1887Of(this);
            $jacocoInit[606] = true;
            C0120S b = showRootInstallWarningPopup.mo3636b((C0129b<? super T>) of);
            C2093hb hbVar = new C2093hb(action);
            $jacocoInit[607] = true;
            C0120S j = b.mo3669j(hbVar);
            $jacocoInit[608] = true;
            return j;
        }
        C0120S c = C0120S.m652c(action);
        $jacocoInit[609] = true;
        return c;
    }

    /* renamed from: s */
    public /* synthetic */ void mo10722s(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewManager.allowRootInstall(answer);
        $jacocoInit[611] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Action m6572a(Action action, Boolean __) {
        $jacocoInit()[610] = true;
        return action;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10596a(Action action, AppViewViewModel appViewModel, Action __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        C1924Sf sf = new C1924Sf(this);
        $jacocoInit[595] = true;
        C0120S f = requestDownloadAccess.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sf);
        $jacocoInit[596] = true;
        C0120S a = f.mo3616a(Schedulers.m776io());
        C1828Ic ic = new C1828Ic(this, action, appViewModel);
        $jacocoInit[597] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) ic);
        $jacocoInit[598] = true;
        return g;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo10535B(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[604] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo10589a(Action action, AppViewViewModel appViewModel, Void __1) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        long appId = appViewModel.getAppId();
        $jacocoInit[599] = true;
        Malware malware = appViewModel.getMalware();
        $jacocoInit[600] = true;
        Rank rank = malware.getRank();
        $jacocoInit[601] = true;
        String name = rank.name();
        String editorsChoice = appViewModel.getEditorsChoice();
        $jacocoInit[602] = true;
        C0117M downloadApp = appViewManager2.downloadApp(action, appId, name, editorsChoice);
        $jacocoInit[603] = true;
        return downloadApp;
    }

    private void loadDownloadApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1799Fa fa = C1799Fa.f4795a;
        $jacocoInit[373] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) fa);
        C2242wd wdVar = new C2242wd(this);
        $jacocoInit[374] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wdVar);
        C2167of ofVar = new C2167of(this);
        $jacocoInit[375] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ofVar);
        C2180qa qaVar = C2180qa.f5247a;
        $jacocoInit[376] = true;
        C0120S d2 = f2.mo3653d((C0132p<? super T, Boolean>) qaVar);
        C1786Df df = new C1786Df(this);
        $jacocoInit[377] = true;
        C0120S f3 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) df);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[378] = true;
        C0120S a = f3.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2122ka kaVar = C2122ka.f5185a;
        C2024cf cfVar = C2024cf.f5062a;
        $jacocoInit[379] = true;
        a.mo3626a((C0129b<? super T>) kaVar, (C0129b<Throwable>) cfVar);
        $jacocoInit[380] = true;
    }

    /* renamed from: za */
    static /* synthetic */ Boolean m6673za(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[592] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[593] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[594] = true;
        return valueOf;
    }

    /* renamed from: Aa */
    public /* synthetic */ C0120S mo10533Aa(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isAppViewReadyToDownload = this.view.isAppViewReadyToDownload();
        $jacocoInit[591] = true;
        return isAppViewReadyToDownload;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo10726t(Void create) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[589] = true;
        C0120S c = loadAppViewViewModel.mo3696c();
        $jacocoInit[590] = true;
        return c;
    }

    /* renamed from: Q */
    static /* synthetic */ Boolean m6559Q(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!app.isLoading()) {
            $jacocoInit[586] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[587] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[588] = true;
        return valueOf;
    }

    /* renamed from: R */
    public /* synthetic */ C0120S mo10569R(AppViewViewModel app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        String md5 = app.getMd5();
        String packageName = app.getPackageName();
        $jacocoInit[576] = true;
        int versionCode = app.getVersionCode();
        boolean isPaid = app.isPaid();
        Pay pay = app.getPay();
        String signature = app.getSignature();
        Store store = app.getStore();
        $jacocoInit[577] = true;
        long id = store.getId();
        if (app.hasAdvertising()) {
            $jacocoInit[578] = true;
        } else if (app.hasBilling()) {
            $jacocoInit[579] = true;
        } else {
            z = false;
            $jacocoInit[581] = true;
            C0120S loadDownloadAppViewModel = appViewManager2.loadDownloadAppViewModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
            C0126V v = this.viewScheduler;
            $jacocoInit[582] = true;
            C0120S a = loadDownloadAppViewModel.mo3616a(v);
            C2251xc xcVar = new C2251xc(this, app);
            $jacocoInit[583] = true;
            C0120S b = a.mo3636b((C0129b<? super T>) xcVar);
            $jacocoInit[584] = true;
            return b;
        }
        $jacocoInit[580] = true;
        z = true;
        C0120S loadDownloadAppViewModel2 = appViewManager2.loadDownloadAppViewModel(md5, packageName, versionCode, isPaid, pay, signature, id, z);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[582] = true;
        C0120S a2 = loadDownloadAppViewModel2.mo3616a(v2);
        C2251xc xcVar2 = new C2251xc(this, app);
        $jacocoInit[583] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) xcVar2);
        $jacocoInit[584] = true;
        return b2;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10650c(AppViewViewModel app, DownloadAppViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showDownloadAppModel(model, app.hasDonations());
        $jacocoInit[585] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6598b(DownloadAppViewModel created) {
        $jacocoInit()[575] = true;
    }

    /* renamed from: M */
    static /* synthetic */ void m6553M(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[574] = true;
        throw onErrorNotImplementedException;
    }

    private void handleAppBought() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1966Xc xc = C1966Xc.f4995a;
        $jacocoInit[381] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) xc);
        C1827Ib ib = new C1827Ib(this);
        $jacocoInit[382] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ib);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[383] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2075fd fdVar = C2075fd.f5126a;
        C1912Rc rc = C1912Rc.f4926a;
        $jacocoInit[384] = true;
        a.mo3626a((C0129b<? super T>) fdVar, (C0129b<Throwable>) rc);
        $jacocoInit[385] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m6637i(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[571] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[572] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[573] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo10688j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appBought = this.view.appBought();
        C1967Xd xd = new C1967Xd(this);
        $jacocoInit[551] = true;
        C0120S f = appBought.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xd);
        $jacocoInit[552] = true;
        C0120S d = f.mo3647d();
        C0126V v = this.viewScheduler;
        $jacocoInit[553] = true;
        C0120S a = d.mo3616a(v);
        C2214tc tcVar = new C2214tc(this);
        $jacocoInit[554] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tcVar);
        $jacocoInit[555] = true;
        C0120S g = f2.mo3662g();
        $jacocoInit[556] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10597a(AppBoughClickEvent appBoughClickEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[562] = true;
        C0120S c = loadAppViewViewModel.mo3696c();
        C2019ca caVar = new C2019ca(appBoughClickEvent);
        $jacocoInit[563] = true;
        C0120S d = c.mo3653d((C0132p<? super T, Boolean>) caVar);
        C1839Je je = new C1839Je(appBoughClickEvent);
        $jacocoInit[564] = true;
        C0120S j = d.mo3669j(je);
        $jacocoInit[565] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6578a(AppBoughClickEvent appBoughClickEvent, AppViewViewModel appViewViewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        long appId = appViewViewModel.getAppId();
        $jacocoInit[567] = true;
        if (appId == appBoughClickEvent.getAppId()) {
            $jacocoInit[568] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[569] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[570] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ AppBoughClickEvent m6595b(AppBoughClickEvent appBoughClickEvent, AppViewViewModel __2) {
        $jacocoInit()[566] = true;
        return appBoughClickEvent;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10625b(AppBoughClickEvent appBoughClickEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        C1993_d _dVar = new C1993_d(this, appBoughClickEvent);
        $jacocoInit[557] = true;
        C0117M b = loadAppViewViewModel.mo3693b((C0132p<? super T, ? extends C0117M>) _dVar);
        $jacocoInit[558] = true;
        C0120S f = b.mo3604f();
        $jacocoInit[559] = true;
        return f;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo10643c(AppBoughClickEvent appBoughClickEvent, AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M appBought = this.appViewManager.appBought(appBoughClickEvent.getPath());
        Action action = Action.INSTALL;
        $jacocoInit[560] = true;
        C0117M a = appBought.mo3580a(downloadApp(action, appViewViewModel));
        $jacocoInit[561] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ void m6590a(Object created) {
        $jacocoInit()[550] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m6626e(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[549] = true;
        throw onErrorNotImplementedException;
    }

    private void handleApkfyDialogPositiveClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2143mb mbVar = C2143mb.f5207a;
        $jacocoInit[386] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mbVar);
        C2000ab abVar = new C2000ab(this);
        $jacocoInit[387] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) abVar);
        C2032dd ddVar = new C2032dd(this);
        $jacocoInit[388] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ddVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[389] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2010bb bbVar = C2010bb.f5048a;
        C1863Ma ma = C1863Ma.f4872a;
        $jacocoInit[390] = true;
        a.mo3626a((C0129b<? super T>) bbVar, (C0129b<Throwable>) ma);
        $jacocoInit[391] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m6632g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[548] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo10677h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S apkfyDialogPositiveClick = this.view.apkfyDialogPositiveClick();
        $jacocoInit[547] = true;
        return apkfyDialogPositiveClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10616a(String appname) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showApkfyElement(appname);
        $jacocoInit[546] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6604b(String created) {
        $jacocoInit()[545] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m6619d(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[544] = true;
        throw onErrorNotImplementedException;
    }

    private void handleClickOnTopDonorsDonate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2273zg zgVar = C2273zg.f5348a;
        $jacocoInit[392] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) zgVar);
        C2145md mdVar = new C2145md(this);
        $jacocoInit[393] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mdVar);
        C2271ze zeVar = new C2271ze(this);
        $jacocoInit[394] = true;
        C0120S i = f.mo3668i(zeVar);
        C2217tf tfVar = new C2217tf(this);
        $jacocoInit[395] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) tfVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[396] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2184qe qeVar = C2184qe.f5251a;
        C1875Nc nc = C1875Nc.f4886a;
        $jacocoInit[397] = true;
        a.mo3626a((C0129b<? super T>) qeVar, (C0129b<Throwable>) nc);
        $jacocoInit[398] = true;
    }

    /* renamed from: S */
    static /* synthetic */ Boolean m6562S(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[543] = true;
        return valueOf;
    }

    /* renamed from: T */
    public /* synthetic */ C0120S mo10572T(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S clickTopDonorsDonateButton = this.view.clickTopDonorsDonateButton();
        $jacocoInit[542] = true;
        return clickTopDonorsDonateButton;
    }

    /* renamed from: o */
    public /* synthetic */ Single mo10707o(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[541] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: z */
    public /* synthetic */ void mo10749z(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendDonateClickTopDonors();
        $jacocoInit[539] = true;
        this.appViewNavigator.navigateToDonationsDialog(app.getPackageName(), TAG);
        $jacocoInit[540] = true;
    }

    /* renamed from: A */
    static /* synthetic */ void m6530A(AppViewViewModel created) {
        $jacocoInit()[538] = true;
    }

    /* renamed from: w */
    static /* synthetic */ void m6668w(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[537] = true;
        throw onErrorNotImplementedException;
    }

    private void handleDonateCardImpressions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2231vb vbVar = C2231vb.f5304a;
        $jacocoInit[399] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) vbVar);
        C2002ad adVar = new C2002ad(this);
        $jacocoInit[400] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) adVar);
        C1940Ud ud = new C1940Ud(this);
        $jacocoInit[401] = true;
        C0120S i = f.mo3668i(ud);
        C1959We we = new C1959We(this);
        $jacocoInit[402] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) we);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[403] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2084gc gcVar = C2084gc.f5138a;
        C2138lg lgVar = C2138lg.f5201a;
        $jacocoInit[404] = true;
        a.mo3626a((C0129b<? super T>) gcVar, (C0129b<Throwable>) lgVar);
        $jacocoInit[405] = true;
    }

    /* renamed from: ca */
    static /* synthetic */ Boolean m6615ca(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[536] = true;
        return valueOf;
    }

    /* renamed from: da */
    public /* synthetic */ C0120S mo10664da(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installAppClick = this.view.installAppClick();
        $jacocoInit[535] = true;
        return installAppClick;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10630b(Action __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[534] = true;
        return loadAppViewViewModel;
    }

    /* renamed from: F */
    public /* synthetic */ void mo10546F(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!model.hasDonations()) {
            $jacocoInit[530] = true;
        } else {
            $jacocoInit[531] = true;
            this.appViewAnalytics.sendDonateImpressionAfterInstall(model.getPackageName());
            $jacocoInit[532] = true;
        }
        $jacocoInit[533] = true;
    }

    /* renamed from: G */
    static /* synthetic */ void m6544G(AppViewViewModel created) {
        $jacocoInit()[529] = true;
    }

    /* renamed from: B */
    static /* synthetic */ void m6532B(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[528] = true;
        throw onErrorNotImplementedException;
    }

    private void handleDismissWalletPromotion() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2260yc ycVar = C2260yc.f5334a;
        $jacocoInit[406] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ycVar);
        C1893Pa pa = new C1893Pa(this);
        $jacocoInit[407] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pa);
        C2227ug ugVar = new C2227ug(this);
        $jacocoInit[408] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ugVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[409] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1812Ge ge = C1812Ge.f4810a;
        C1840Jf jf = C1840Jf.f4845a;
        $jacocoInit[410] = true;
        a.mo3626a((C0129b<? super T>) ge, (C0129b<Throwable>) jf);
        $jacocoInit[411] = true;
    }

    /* renamed from: aa */
    static /* synthetic */ Boolean m6592aa(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[527] = true;
        return valueOf;
    }

    /* renamed from: ba */
    public /* synthetic */ C0120S mo10640ba(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dismissWalletPromotionClick = this.view.dismissWalletPromotionClick();
        $jacocoInit[526] = true;
        return dismissWalletPromotionClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10611a(Promotion promotion) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendClickOnNoThanksWallet(promotion.getPromotionId());
        $jacocoInit[524] = true;
        this.view.dismissWalletPromotionView();
        $jacocoInit[525] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6602b(Promotion created) {
        $jacocoInit()[523] = true;
    }

    /* renamed from: A */
    static /* synthetic */ void m6531A(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[522] = true;
        throw onErrorNotImplementedException;
    }

    private void handleInstallWalletPromotion() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2259yb ybVar = C2259yb.f5333a;
        $jacocoInit[412] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ybVar);
        C1877Ne ne = new C1877Ne(this);
        $jacocoInit[413] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ne);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[414] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1767Be be = C1767Be.f4759a;
        C2144mc mcVar = C2144mc.f5208a;
        $jacocoInit[415] = true;
        a.mo3626a((C0129b<? super T>) be, (C0129b<Throwable>) mcVar);
        $jacocoInit[416] = true;
    }

    /* renamed from: la */
    static /* synthetic */ Boolean m6645la(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[521] = true;
        return valueOf;
    }

    /* renamed from: ma */
    public /* synthetic */ C0120S mo10702ma(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installWalletButtonClick = this.view.installWalletButtonClick();
        C2147mf mfVar = new C2147mf(this);
        $jacocoInit[515] = true;
        C0120S b = installWalletButtonClick.mo3636b((C0129b<? super T>) mfVar);
        C2232vc vcVar = new C2232vc(this);
        $jacocoInit[516] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) vcVar);
        $jacocoInit[517] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[518] = true;
        return g2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10632b(Pair pair) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendInstallAppcWallet(((Promotion) pair.first).getPromotionId());
        $jacocoInit[520] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo10641c(Pair pair) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadWallet = downloadWallet((WalletApp) pair.second);
        $jacocoInit[519] = true;
        return downloadWallet;
    }

    /* renamed from: a */
    static /* synthetic */ void m6586a(Pair created) {
        $jacocoInit()[514] = true;
    }

    /* renamed from: F */
    static /* synthetic */ void m6541F(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[513] = true;
        throw onErrorNotImplementedException;
    }

    private void resumeWalletDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2136le leVar = C2136le.f5199a;
        $jacocoInit[417] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) leVar);
        C1856Ld ld = new C1856Ld(this);
        $jacocoInit[418] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ld);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[419] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C1790Ea ea = C1790Ea.f4784a;
        C2097hf hfVar = C2097hf.f5154a;
        $jacocoInit[420] = true;
        a.mo3626a((C0129b<? super T>) ea, (C0129b<Throwable>) hfVar);
        $jacocoInit[421] = true;
    }

    /* renamed from: Ja */
    static /* synthetic */ Boolean m6548Ja(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[510] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[511] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[512] = true;
        return valueOf;
    }

    /* renamed from: Ka */
    public /* synthetic */ C0120S mo10558Ka(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S resumePromotionDownload = this.view.resumePromotionDownload();
        C2066ee eeVar = new C2066ee(this);
        $jacocoInit[499] = true;
        C0120S f = resumePromotionDownload.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eeVar);
        $jacocoInit[500] = true;
        return f;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10627b(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        C2182qc qcVar = new C2182qc(this);
        $jacocoInit[501] = true;
        C0120S f = requestDownloadAccess.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qcVar);
        C1985Zd zd = new C1985Zd(this, walletApp);
        $jacocoInit[502] = true;
        C0120S g = f.mo3663g((C0132p<? super T, ? extends C0117M>) zd);
        $jacocoInit[503] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[504] = true;
        return g2;
    }

    /* renamed from: C */
    public /* synthetic */ C0120S mo10537C(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[509] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo10622b(WalletApp walletApp, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        String md5sum = walletApp.getMd5sum();
        long id = walletApp.getId();
        $jacocoInit[505] = true;
        DownloadModel downloadModel = walletApp.getDownloadModel();
        $jacocoInit[506] = true;
        Action action = downloadModel.getAction();
        $jacocoInit[507] = true;
        C0117M resumeDownload = appViewManager2.resumeDownload(md5sum, id, action);
        $jacocoInit[508] = true;
        return resumeDownload;
    }

    /* renamed from: D */
    static /* synthetic */ void m6536D(Void created) {
        $jacocoInit()[498] = true;
    }

    /* renamed from: U */
    static /* synthetic */ void m6566U(Throwable error) {
        $jacocoInit()[497] = true;
    }

    private void cancelPromotionDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2255xg xgVar = C2255xg.f5329a;
        $jacocoInit[422] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) xgVar);
        C1955Wa wa = new C1955Wa(this);
        $jacocoInit[423] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wa);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[424] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2067ef efVar = C2067ef.f5116a;
        C2148mg mgVar = C2148mg.f5212a;
        $jacocoInit[425] = true;
        a.mo3626a((C0129b<? super T>) efVar, (C0129b<Throwable>) mgVar);
        $jacocoInit[426] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6609c(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[494] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[495] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[496] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo10660d(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelPromotionDownload = this.view.cancelPromotionDownload();
        C1879Ng ng = new C1879Ng(this);
        $jacocoInit[488] = true;
        C0120S g = cancelPromotionDownload.mo3663g((C0132p<? super T, ? extends C0117M>) ng);
        $jacocoInit[489] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[490] = true;
        return g2;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo10644c(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewManager appViewManager2 = this.appViewManager;
        String md5sum = walletApp.getMd5sum();
        $jacocoInit[491] = true;
        String packageName = walletApp.getPackageName();
        int versionCode = walletApp.getVersionCode();
        $jacocoInit[492] = true;
        C0117M cancelDownload = appViewManager2.cancelDownload(md5sum, packageName, versionCode);
        $jacocoInit[493] = true;
        return cancelDownload;
    }

    /* renamed from: a */
    static /* synthetic */ void m6588a(WalletApp created) {
        $jacocoInit()[487] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6605b(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[486] = true;
        throw onErrorNotImplementedException;
    }

    private void pauseWalletDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1782Db db = C1782Db.f4776a;
        $jacocoInit[427] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) db);
        C1841Jg jg = new C1841Jg(this);
        $jacocoInit[428] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jg);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[429] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2186qg qgVar = C2186qg.f5253a;
        C2076fe feVar = C2076fe.f5127a;
        $jacocoInit[430] = true;
        a.mo3626a((C0129b<? super T>) qgVar, (C0129b<Throwable>) feVar);
        $jacocoInit[431] = true;
    }

    /* renamed from: Fa */
    static /* synthetic */ Boolean m6542Fa(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[485] = true;
        return valueOf;
    }

    /* renamed from: Ga */
    public /* synthetic */ C0120S mo10548Ga(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S pausePromotionDownload = this.view.pausePromotionDownload();
        C1755Ae ae = new C1755Ae(this);
        $jacocoInit[481] = true;
        C0120S g = pausePromotionDownload.mo3663g((C0132p<? super T, ? extends C0117M>) ae);
        $jacocoInit[482] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[483] = true;
        return g2;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo10656d(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseDownload = this.appViewManager.pauseDownload(walletApp.getMd5sum());
        $jacocoInit[484] = true;
        return pauseDownload;
    }

    /* renamed from: e */
    static /* synthetic */ void m6624e(WalletApp created) {
        $jacocoInit()[480] = true;
    }

    /* renamed from: S */
    static /* synthetic */ void m6563S(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        IllegalStateException illegalStateException = new IllegalStateException(error);
        $jacocoInit[479] = true;
        throw illegalStateException;
    }

    private void claimApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1787Dg dg = C1787Dg.f4781a;
        $jacocoInit[432] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) dg);
        C1925Sg sg = new C1925Sg(this);
        $jacocoInit[433] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sg);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[434] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2239wa waVar = C2239wa.f5313a;
        C1785De de = C1785De.f4779a;
        $jacocoInit[435] = true;
        a.mo3626a((C0129b<? super T>) waVar, (C0129b<Throwable>) de);
        $jacocoInit[436] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m6623e(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[476] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[477] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[478] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo10671f(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S claimAppClick = this.view.claimAppClick();
        C1921Sc sc = new C1921Sc(this);
        $jacocoInit[466] = true;
        C0120S f = claimAppClick.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sc);
        $jacocoInit[467] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[468] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo10647c(Promotion promotion) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewAnalytics.sendClickOnClaimAppViewPromotion(promotion.getPromotionId());
        $jacocoInit[469] = true;
        Single loadAppViewViewModel = this.appViewManager.loadAppViewViewModel();
        $jacocoInit[470] = true;
        C0120S c = loadAppViewViewModel.mo3696c();
        C1964Xa xa = new C1964Xa(this, promotion);
        $jacocoInit[471] = true;
        C0120S b = c.mo3636b((C0129b<? super T>) xa);
        $jacocoInit[472] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10612a(Promotion promotion, AppViewViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsNavigator promotionsNavigator2 = this.promotionsNavigator;
        $jacocoInit[473] = true;
        String packageName = appViewViewModel.getPackageName();
        String promotionId = promotion.getPromotionId();
        $jacocoInit[474] = true;
        promotionsNavigator2.navigateToClaimDialog(packageName, promotionId);
        $jacocoInit[475] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6597b(AppViewViewModel created) {
        $jacocoInit()[465] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6614c(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[464] = true;
        throw onErrorNotImplementedException;
    }

    private void handlePromotionClaimResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2153nb nbVar = C2153nb.f5217a;
        $jacocoInit[437] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nbVar);
        C2243we weVar = new C2243we(this);
        $jacocoInit[438] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) weVar);
        C2160ni niVar = C2160ni.f5225a;
        $jacocoInit[439] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) niVar);
        C2072fa faVar = new C2072fa(this);
        $jacocoInit[440] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) faVar);
        AppViewView appViewView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[441] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appViewView.bindUntilEvent(lifecycleEvent2));
        C2164oc ocVar = C2164oc.f5230a;
        C2135ld ldVar = C2135ld.f5198a;
        $jacocoInit[442] = true;
        a.mo3626a((C0129b<? super T>) ocVar, (C0129b<Throwable>) ldVar);
        $jacocoInit[443] = true;
    }

    /* renamed from: va */
    static /* synthetic */ Boolean m6666va(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[463] = true;
        return valueOf;
    }

    /* renamed from: wa */
    public /* synthetic */ C0120S mo10740wa(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S claimDialogResults = this.promotionsNavigator.claimDialogResults();
        $jacocoInit[462] = true;
        return claimDialogResults;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10610a(ClaimDialogResultWrapper result) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewManager.unscheduleNotificationSync();
        $jacocoInit[461] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6601b(ClaimDialogResultWrapper __) {
        $jacocoInit()[460] = true;
    }

    /* renamed from: K */
    static /* synthetic */ void m6550K(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[459] = true;
        throw onErrorNotImplementedException;
    }

    private C0117M downloadWallet(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m643a((C0131o<C0120S<T>>) new C2001ac<C0120S<T>>(this));
        C0126V v = this.viewScheduler;
        $jacocoInit[444] = true;
        C0120S a2 = a.mo3616a(v);
        C2114jc jcVar = new C2114jc(this);
        $jacocoInit[445] = true;
        C0120S f = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jcVar);
        C1784Dd dd = new C1784Dd(this);
        $jacocoInit[446] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dd);
        $jacocoInit[447] = true;
        C0120S a3 = f2.mo3616a(Schedulers.m776io());
        C2235vf vfVar = new C2235vf(this, walletApp);
        $jacocoInit[448] = true;
        C0120S g = a3.mo3663g((C0132p<? super T, ? extends C0117M>) vfVar);
        $jacocoInit[449] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[450] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10591a() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.appViewManager.shouldShowRootInstallWarningPopup()) {
            $jacocoInit[454] = true;
            C0120S showRootInstallWarningPopup = this.view.showRootInstallWarningPopup();
            C2234ve veVar = new C2234ve(this);
            $jacocoInit[455] = true;
            C0120S b = showRootInstallWarningPopup.mo3636b((C0129b<? super T>) veVar);
            $jacocoInit[456] = true;
            return b;
        }
        C0120S c = C0120S.m652c(null);
        $jacocoInit[457] = true;
        return c;
    }

    /* renamed from: t */
    public /* synthetic */ void mo10728t(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appViewManager.allowRootInstall(answer);
        $jacocoInit[458] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo10648c(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        $jacocoInit[453] = true;
        return requestDownloadAccess;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10600a(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[452] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo10590a(WalletApp walletApp, Void __1) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = this.appViewManager.downloadApp(walletApp);
        $jacocoInit[451] = true;
        return downloadApp;
    }
}
