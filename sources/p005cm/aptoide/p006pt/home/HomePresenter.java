package p005cm.aptoide.p006pt.home;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd.Network;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;
import p005cm.aptoide.p006pt.home.HomeBundlesModel.Error;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p005cm.aptoide.p006pt.view.app.Application;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.HomePresenter */
public class HomePresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdMapper adMapper;
    private final CrashReport crashReporter;
    private final Home home;
    private final HomeAnalytics homeAnalytics;
    private final HomeNavigator homeNavigator;
    private final HomeView view;
    private final C0126V viewScheduler;

    /* renamed from: cm.aptoide.pt.home.HomePresenter$1 */
    static /* synthetic */ class C33871 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$HomeBundlesModel$Error = new int[Error.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(863984727680459000L, "cm/aptoide/pt/home/HomePresenter$1", 6);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$home$HomeBundlesModel$Error[Error.NETWORK.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$home$HomeBundlesModel$Error[Error.GENERIC.ordinal()] = 2;
            $jacocoInit[3] = true;
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2267555884859656907L, "cm/aptoide/pt/home/HomePresenter", 497);
        $jacocoData = probes;
        return probes;
    }

    public HomePresenter(HomeView view2, Home home2, C0126V viewScheduler2, CrashReport crashReporter2, HomeNavigator homeNavigator2, AdMapper adMapper2, HomeAnalytics homeAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.home = home2;
        this.viewScheduler = viewScheduler2;
        this.crashReporter = crashReporter2;
        this.homeNavigator = homeNavigator2;
        this.adMapper = adMapper2;
        this.homeAnalytics = homeAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onCreateLoadBundles();
        $jacocoInit[1] = true;
        handleAppClick();
        $jacocoInit[2] = true;
        handleAdClick();
        $jacocoInit[3] = true;
        handleMoreClick();
        $jacocoInit[4] = true;
        handleBottomReached();
        $jacocoInit[5] = true;
        handlePullToRefresh();
        $jacocoInit[6] = true;
        handleRetryClick();
        $jacocoInit[7] = true;
        handleBundleScrolledRight();
        $jacocoInit[8] = true;
        handleKnowMoreClick();
        $jacocoInit[9] = true;
        handleDismissClick();
        $jacocoInit[10] = true;
        handleActionBundlesImpression();
        $jacocoInit[11] = true;
        handleEditorialCardClick();
        $jacocoInit[12] = true;
        handleInstallWalletOfferClick();
        $jacocoInit[13] = true;
        handleReactionButtonClick();
        $jacocoInit[14] = true;
        handleLongPressedReactionButton();
        $jacocoInit[15] = true;
        handleUserReaction();
        $jacocoInit[16] = true;
        handleSnackLogInClick();
        $jacocoInit[17] = true;
        handleMoPubConsentDialog();
        $jacocoInit[18] = true;
    }

    private void handleMoPubConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3967yd ydVar = C3967yd.f7448a;
        $jacocoInit[19] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ydVar);
        C3367Ec ec = new C3367Ec(this);
        $jacocoInit[20] = true;
        C0120S i = d.mo3668i(ec);
        C3368Ed ed = C3368Ed.f6749a;
        $jacocoInit[21] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) ed);
        C3955wd wdVar = new C3955wd(this);
        $jacocoInit[22] = true;
        C0120S i2 = d2.mo3668i(wdVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[23] = true;
        C0120S a = i2.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3402Kd kd = C3402Kd.f6781a;
        C3413Mc mc = new C3413Mc(this);
        $jacocoInit[24] = true;
        a.mo3626a((C0129b<? super T>) kd, (C0129b<Throwable>) mc);
        $jacocoInit[25] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m8119u(LifecycleEvent lifecycleEvent) {
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

    /* renamed from: v */
    public /* synthetic */ Single mo14528v(LifecycleEvent model) {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadNativeAd = this.home.shouldLoadNativeAd();
        $jacocoInit[493] = true;
        return shouldLoadNativeAd;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8080b(Boolean loadInterstitial) {
        $jacocoInit()[492] = true;
        return loadInterstitial;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo14481c(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single handleConsentDialog = handleConsentDialog();
        $jacocoInit[491] = true;
        return handleConsentDialog;
    }

    /* renamed from: d */
    static /* synthetic */ void m8093d(Boolean __) {
        $jacocoInit()[490] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo14514i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[489] = true;
    }

    private Single<Boolean> handleConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldShowConsentDialog = this.home.shouldShowConsentDialog();
        C0126V v = this.viewScheduler;
        $jacocoInit[26] = true;
        Single a = shouldShowConsentDialog.mo3686a(v);
        C3467Xb xb = new C3467Xb(this);
        $jacocoInit[27] = true;
        Single<Boolean> d = a.mo3698d(xb);
        $jacocoInit[28] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14461a(Boolean shouldShowConsent) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!shouldShowConsent.booleanValue()) {
            $jacocoInit[485] = true;
        } else {
            $jacocoInit[486] = true;
            this.view.showConsentDialog();
            $jacocoInit[487] = true;
        }
        Boolean valueOf = Boolean.valueOf(true);
        $jacocoInit[488] = true;
        return valueOf;
    }

    private void handleInstallWalletOfferClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3913pd pdVar = C3913pd.f7368a;
        $jacocoInit[29] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) pdVar);
        C3468Xc xc = new C3468Xc(this);
        $jacocoInit[30] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xc);
        C0126V v = this.viewScheduler;
        $jacocoInit[31] = true;
        C0120S a = f.mo3616a(v);
        C3858gc gcVar = new C3858gc(this);
        $jacocoInit[32] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) gcVar);
        C3926re reVar = C3926re.f7391a;
        $jacocoInit[33] = true;
        C0120S j = b.mo3669j(reVar);
        C3406Lc lc = C3406Lc.f6785a;
        $jacocoInit[34] = true;
        $jacocoInit[35] = true;
        C0120S a2 = j.mo3653d((C0132p<? super T, Boolean>) lc).mo3611a(ActionBundle.class);
        C3966yc ycVar = new C3966yc(this);
        $jacocoInit[36] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) ycVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[37] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3961xd xdVar = C3961xd.f7441a;
        C3432Qb qb = C3432Qb.f6809a;
        $jacocoInit[38] = true;
        a3.mo3626a((C0129b<? super T>) xdVar, (C0129b<Throwable>) qb);
        $jacocoInit[39] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m8116o(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[484] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo14525p(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S walletOfferCardInstallWalletClick = this.view.walletOfferCardInstallWalletClick();
        $jacocoInit[483] = true;
        return walletOfferCardInstallWalletClick;
    }

    /* renamed from: j */
    public /* synthetic */ void mo14516j(HomeEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        HomeBundle bundle = event.getBundle();
        $jacocoInit[480] = true;
        String tag = bundle.getTag();
        int bundlePosition = event.getBundlePosition();
        $jacocoInit[481] = true;
        homeAnalytics2.sendActionItemTapOnCardInteractEvent(tag, bundlePosition);
        $jacocoInit[482] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8069a(HomeBundle homeBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(homeBundle instanceof ActionBundle);
        $jacocoInit[479] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14473b(ActionBundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeView homeView = this.view;
        ActionItem actionItem = bundle.getActionItem();
        $jacocoInit[476] = true;
        String url = actionItem.getUrl();
        $jacocoInit[477] = true;
        homeView.sendDeeplinkToWalletAppView(url);
        $jacocoInit[478] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8087c(ActionBundle lifecycleEvent) {
        $jacocoInit()[475] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m8104g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[474] = true;
        throw onErrorNotImplementedException;
    }

    public void handleLongPressedReactionButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3454Ud ud = C3454Ud.f6830a;
        $jacocoInit[40] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ud);
        C3930sc scVar = new C3930sc(this);
        $jacocoInit[41] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) scVar);
        C3463Wc wc = new C3463Wc(this);
        $jacocoInit[42] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) wc);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[43] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3397Jd jd = C3397Jd.f6776a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3831c cVar = new C3831c(crashReport);
        $jacocoInit[44] = true;
        a.mo3626a((C0129b<? super T>) jd, (C0129b<Throwable>) cVar);
        $jacocoInit[45] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m8118s(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[473] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo14527t(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionButtonLongPress = this.view.reactionButtonLongPress();
        $jacocoInit[472] = true;
        return reactionButtonLongPress;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14475b(EditorialHomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendReactionButtonClickEvent();
        $jacocoInit[468] = true;
        HomeView homeView = this.view;
        String cardId = homeEvent.getCardId();
        String groupId = homeEvent.getGroupId();
        $jacocoInit[469] = true;
        int bundlePosition = homeEvent.getBundlePosition();
        $jacocoInit[470] = true;
        homeView.showReactionsPopup(cardId, groupId, bundlePosition);
        $jacocoInit[471] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8088c(EditorialHomeEvent lifecycleEvent) {
        $jacocoInit()[467] = true;
    }

    private Single<List<HomeBundle>> loadReactionModel(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = this.home.loadReactionModel(cardId, groupId);
        C0126V v = this.viewScheduler;
        $jacocoInit[46] = true;
        Single a = loadReactionModel.mo3686a(v);
        C3448Td td = new C3448Td(this);
        $jacocoInit[47] = true;
        Single<List<HomeBundle>> b = a.mo3695b((C0129b<? super T>) td);
        $jacocoInit[48] = true;
        return b;
    }

    /* renamed from: f */
    public /* synthetic */ void mo14496f(List homeBundles) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.updateEditorialCards();
        $jacocoInit[466] = true;
    }

    private C0120S<List<HomeBundle>> loadHomeAndReactions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = loadHome().mo3696c();
        C3968ye yeVar = C3968ye.f7449a;
        $jacocoInit[49] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) yeVar);
        C3380Gd gd = C3380Gd.f6760a;
        $jacocoInit[50] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) gd);
        C3401Kc kc = C3401Kc.f6780a;
        $jacocoInit[51] = true;
        $jacocoInit[52] = true;
        C0120S a = d.mo3653d((C0132p<? super T, Boolean>) kc).mo3611a(ActionBundle.class);
        C3458Vc vc = new C3458Vc(this);
        $jacocoInit[53] = true;
        C0120S<List<HomeBundle>> i = a.mo3668i(vc);
        $jacocoInit[54] = true;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m8091d(HomeBundle actionBundle) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (actionBundle.getType() == BundleType.EDITORIAL) {
            $jacocoInit[463] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[464] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[465] = true;
        return valueOf;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8096e(HomeBundle homeBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(homeBundle instanceof ActionBundle);
        $jacocoInit[462] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ Single mo14489e(ActionBundle actionBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        ActionItem actionItem = actionBundle.getActionItem();
        $jacocoInit[458] = true;
        String cardId = actionItem.getCardId();
        ActionItem actionItem2 = actionBundle.getActionItem();
        $jacocoInit[459] = true;
        String type = actionItem2.getType();
        $jacocoInit[460] = true;
        Single loadReactionModel = loadReactionModel(cardId, type);
        $jacocoInit[461] = true;
        return loadReactionModel;
    }

    private C0120S<List<HomeBundle>> loadFreshBundlesAndReactions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = loadFreshBundles().mo3696c();
        C3968ye yeVar = C3968ye.f7449a;
        $jacocoInit[55] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) yeVar);
        C3852fc fcVar = C3852fc.f7275a;
        $jacocoInit[56] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) fcVar);
        C3865hd hdVar = C3865hd.f7295a;
        $jacocoInit[57] = true;
        $jacocoInit[58] = true;
        C0120S a = d.mo3653d((C0132p<? super T, Boolean>) hdVar).mo3611a(ActionBundle.class);
        C3835cd cdVar = new C3835cd(this);
        $jacocoInit[59] = true;
        C0120S<List<HomeBundle>> i = a.mo3668i(cdVar);
        $jacocoInit[60] = true;
        return i;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8079b(HomeBundle actionBundle) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (actionBundle.getType() == BundleType.EDITORIAL) {
            $jacocoInit[455] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[456] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[457] = true;
        return valueOf;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8084c(HomeBundle homeBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(homeBundle instanceof ActionBundle);
        $jacocoInit[454] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo14487d(ActionBundle actionBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        ActionItem actionItem = actionBundle.getActionItem();
        $jacocoInit[450] = true;
        String cardId = actionItem.getCardId();
        ActionItem actionItem2 = actionBundle.getActionItem();
        $jacocoInit[451] = true;
        String type = actionItem2.getType();
        $jacocoInit[452] = true;
        Single loadReactionModel = loadReactionModel(cardId, type);
        $jacocoInit[453] = true;
        return loadReactionModel;
    }

    private C0120S<List<HomeBundle>> loadNextBundlesAndReactions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = loadNextBundles().mo3696c();
        C3968ye yeVar = C3968ye.f7449a;
        $jacocoInit[61] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) yeVar);
        C3385Hd hd = C3385Hd.f6765a;
        $jacocoInit[62] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) hd);
        C3853fd fdVar = C3853fd.f7276a;
        $jacocoInit[63] = true;
        $jacocoInit[64] = true;
        C0120S a = d.mo3653d((C0132p<? super T, Boolean>) fdVar).mo3611a(ActionBundle.class);
        C3339Ac ac = new C3339Ac(this);
        $jacocoInit[65] = true;
        C0120S<List<HomeBundle>> i = a.mo3668i(ac);
        $jacocoInit[66] = true;
        return i;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m8101f(HomeBundle actionBundle) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (actionBundle.getType() == BundleType.EDITORIAL) {
            $jacocoInit[447] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[448] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[449] = true;
        return valueOf;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m8103g(HomeBundle homeBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(homeBundle instanceof ActionBundle);
        $jacocoInit[446] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ Single mo14494f(ActionBundle actionBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        ActionItem actionItem = actionBundle.getActionItem();
        $jacocoInit[442] = true;
        String cardId = actionItem.getCardId();
        ActionItem actionItem2 = actionBundle.getActionItem();
        $jacocoInit[443] = true;
        String type = actionItem2.getType();
        $jacocoInit[444] = true;
        Single loadReactionModel = loadReactionModel(cardId, type);
        $jacocoInit[445] = true;
        return loadReactionModel;
    }

    public void handleActionBundlesImpression() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3477Zb zb = C3477Zb.f6855a;
        $jacocoInit[67] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) zb);
        C3901nd ndVar = new C3901nd(this);
        $jacocoInit[68] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ndVar);
        C3948vc vcVar = C3948vc.f7428a;
        $jacocoInit[69] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) vcVar);
        C3882kc kcVar = new C3882kc(this);
        $jacocoInit[70] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) kcVar);
        C3481_b _bVar = C3481_b.f6861a;
        $jacocoInit[71] = true;
        C0120S d3 = b.mo3653d((C0132p<? super T, Boolean>) _bVar);
        C3926re reVar = C3926re.f7391a;
        $jacocoInit[72] = true;
        $jacocoInit[73] = true;
        C0120S a = d3.mo3669j(reVar).mo3611a(ActionBundle.class);
        Home home2 = this.home;
        home2.getClass();
        C3956we weVar = new C3956we(home2);
        $jacocoInit[74] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) weVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[75] = true;
        C0120S a2 = g.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3906oc ocVar = C3906oc.f7353a;
        C3438Rd rd = new C3438Rd(this);
        $jacocoInit[76] = true;
        a2.mo3626a((C0129b<? super T>) ocVar, (C0129b<Throwable>) rd);
        $jacocoInit[77] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8071a(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[441] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14472b(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S visibleBundles = this.view.visibleBundles();
        $jacocoInit[440] = true;
        return visibleBundles;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8070a(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(homeEvent.getBundle() instanceof ActionBundle);
        $jacocoInit[439] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14477b(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeBundle bundle = homeEvent.getBundle();
        $jacocoInit[420] = true;
        BundleType type = bundle.getType();
        BundleType bundleType = BundleType.INFO_BUNDLE;
        $jacocoInit[421] = true;
        if (type.equals(bundleType)) {
            $jacocoInit[422] = true;
        } else {
            HomeBundle bundle2 = homeEvent.getBundle();
            $jacocoInit[423] = true;
            BundleType type2 = bundle2.getType();
            BundleType bundleType2 = BundleType.WALLET_ADS_OFFER;
            $jacocoInit[424] = true;
            if (type2.equals(bundleType2)) {
                $jacocoInit[425] = true;
            } else {
                ActionBundle actionBundle = (ActionBundle) homeEvent.getBundle();
                $jacocoInit[429] = true;
                HomeAnalytics homeAnalytics2 = this.homeAnalytics;
                String tag = actionBundle.getTag();
                $jacocoInit[430] = true;
                int bundlePosition = homeEvent.getBundlePosition();
                ActionItem actionItem = actionBundle.getActionItem();
                $jacocoInit[431] = true;
                String cardId = actionItem.getCardId();
                $jacocoInit[432] = true;
                homeAnalytics2.sendEditorialImpressionEvent(tag, bundlePosition, cardId);
                $jacocoInit[433] = true;
                HomeAnalytics homeAnalytics3 = this.homeAnalytics;
                String tag2 = actionBundle.getTag();
                $jacocoInit[434] = true;
                int bundlePosition2 = homeEvent.getBundlePosition();
                ActionItem actionItem2 = actionBundle.getActionItem();
                $jacocoInit[435] = true;
                String cardId2 = actionItem2.getCardId();
                $jacocoInit[436] = true;
                homeAnalytics3.sendActionItemEditorialImpressionEvent(tag2, bundlePosition2, cardId2);
                $jacocoInit[437] = true;
                $jacocoInit[438] = true;
            }
        }
        HomeAnalytics homeAnalytics4 = this.homeAnalytics;
        HomeBundle bundle3 = homeEvent.getBundle();
        $jacocoInit[426] = true;
        String tag3 = bundle3.getTag();
        int bundlePosition3 = homeEvent.getBundlePosition();
        $jacocoInit[427] = true;
        homeAnalytics4.sendActionItemImpressionEvent(tag3, bundlePosition3);
        $jacocoInit[428] = true;
        $jacocoInit[438] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8085c(HomeEvent homeEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        HomeBundle bundle = homeEvent.getBundle();
        $jacocoInit[411] = true;
        BundleType type = bundle.getType();
        BundleType bundleType = BundleType.INFO_BUNDLE;
        $jacocoInit[412] = true;
        if (type.equals(bundleType)) {
            $jacocoInit[413] = true;
        } else {
            HomeBundle bundle2 = homeEvent.getBundle();
            $jacocoInit[414] = true;
            BundleType type2 = bundle2.getType();
            BundleType bundleType2 = BundleType.WALLET_ADS_OFFER;
            $jacocoInit[415] = true;
            if (type2.equals(bundleType2)) {
                $jacocoInit[416] = true;
            } else {
                z = false;
                $jacocoInit[418] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[419] = true;
                return valueOf;
            }
        }
        $jacocoInit[417] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[419] = true;
        return valueOf2;
    }

    /* renamed from: a */
    static /* synthetic */ void m8073a(ActionBundle actionBundle) {
        $jacocoInit()[410] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14470a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[409] = true;
    }

    public void handleKnowMoreClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3464Wd wd = C3464Wd.f6840a;
        $jacocoInit[78] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) wd);
        C3846ec ecVar = new C3846ec(this);
        $jacocoInit[79] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ecVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[80] = true;
        C0120S a = f.mo3616a(v);
        C3414Md md = new C3414Md(this);
        $jacocoInit[81] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) md);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[82] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3437Rc rc = C3437Rc.f6814a;
        C3441Sb sb = C3441Sb.f6818a;
        $jacocoInit[83] = true;
        a2.mo3626a((C0129b<? super T>) rc, (C0129b<Throwable>) sb);
        $jacocoInit[84] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m8117q(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[408] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo14526r(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S infoBundleKnowMoreClicked = this.view.infoBundleKnowMoreClicked();
        $jacocoInit[407] = true;
        return infoBundleKnowMoreClicked;
    }

    /* renamed from: k */
    public /* synthetic */ void mo14517k(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        HomeBundle bundle = homeEvent.getBundle();
        $jacocoInit[403] = true;
        String tag = bundle.getTag();
        int bundlePosition = homeEvent.getBundlePosition();
        $jacocoInit[404] = true;
        homeAnalytics2.sendActionItemTapOnCardInteractEvent(tag, bundlePosition);
        $jacocoInit[405] = true;
        this.homeNavigator.navigateToAppCoinsInformationView();
        $jacocoInit[406] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m8113l(HomeEvent lifecycleEvent) {
        $jacocoInit()[402] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m8107h(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[401] = true;
        throw onErrorNotImplementedException;
    }

    public void handleReactionButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3472Yb yb = C3472Yb.f6849a;
        $jacocoInit[85] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) yb);
        C3442Sc sc = new C3442Sc(this);
        $jacocoInit[86] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sc);
        C0126V v = this.viewScheduler;
        $jacocoInit[87] = true;
        C0120S a = f.mo3616a(v);
        C3422Ob ob = new C3422Ob(this);
        $jacocoInit[88] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ob);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[89] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3828bc bcVar = C3828bc.f7244a;
        C3427Pb pb = new C3427Pb(this);
        $jacocoInit[90] = true;
        a2.mo3626a((C0129b<? super T>) bcVar, (C0129b<Throwable>) pb);
        $jacocoInit[91] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m8063A(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[400] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo14455B(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionsButtonClicked = this.view.reactionsButtonClicked();
        $jacocoInit[399] = true;
        return reactionsButtonClicked;
    }

    /* renamed from: c */
    static /* synthetic */ void m8090c(List lifecycleEvent) {
        $jacocoInit()[398] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo14519l(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[397] = true;
    }

    public void handleUserReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3883kd kdVar = C3883kd.f7318a;
        $jacocoInit[92] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kdVar);
        C3428Pc pc = new C3428Pc(this);
        $jacocoInit[93] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pc);
        C3419Nd nd = new C3419Nd(this);
        $jacocoInit[94] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nd);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[95] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3358Cd cd = C3358Cd.f6737a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3831c cVar = new C3831c(crashReport);
        $jacocoInit[96] = true;
        a.mo3626a((C0129b<? super T>) cd, (C0129b<Throwable>) cVar);
        $jacocoInit[97] = true;
    }

    /* renamed from: G */
    static /* synthetic */ Boolean m8066G(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[396] = true;
        return valueOf;
    }

    /* renamed from: H */
    public /* synthetic */ C0120S mo14458H(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionClicked = this.view.reactionClicked();
        $jacocoInit[395] = true;
        return reactionClicked;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14464a(ReactionsHomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Home home2 = this.home;
        String cardId = homeEvent.getCardId();
        String groupId = homeEvent.getGroupId();
        $jacocoInit[384] = true;
        String reaction = homeEvent.getReaction();
        $jacocoInit[385] = true;
        Single reaction2 = home2.setReaction(cardId, groupId, reaction);
        $jacocoInit[386] = true;
        C0120S c = reaction2.mo3696c();
        C3920qe qeVar = C3920qe.f7380a;
        $jacocoInit[387] = true;
        C0120S d = c.mo3653d((C0132p<? super T, Boolean>) qeVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[388] = true;
        C0120S a = d.mo3616a(v);
        C3870ic icVar = new C3870ic(this);
        $jacocoInit[389] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) icVar);
        C3484a aVar = C3484a.f6864a;
        $jacocoInit[390] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) aVar);
        C3478Zc zc = new C3478Zc(this, homeEvent);
        $jacocoInit[391] = true;
        C0120S i = d2.mo3668i(zc);
        $jacocoInit[392] = true;
        return i;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14478b(ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        handleReactionsResponse(reactionsResponse, false);
        $jacocoInit[394] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14466a(ReactionsHomeEvent homeEvent, ReactionsResponse __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = loadReactionModel(homeEvent.getCardId(), homeEvent.getGroupId());
        $jacocoInit[393] = true;
        return loadReactionModel;
    }

    /* renamed from: e */
    static /* synthetic */ void m8100e(List lifecycleEvent) {
        $jacocoInit()[383] = true;
    }

    private void handleReactionsResponse(ReactionsResponse reactionsResponse, boolean isDelete) {
        boolean[] $jacocoInit = $jacocoInit();
        if (reactionsResponse.wasSuccess()) {
            if (isDelete) {
                $jacocoInit[98] = true;
                this.homeAnalytics.sendDeleteEvent();
                $jacocoInit[99] = true;
            } else {
                this.homeAnalytics.sendReactedEvent();
                $jacocoInit[100] = true;
            }
        } else if (reactionsResponse.reactionsExceeded()) {
            $jacocoInit[101] = true;
            this.view.showLogInDialog();
            $jacocoInit[102] = true;
        } else if (reactionsResponse.wasNetworkError()) {
            $jacocoInit[103] = true;
            this.view.showNetworkErrorToast();
            $jacocoInit[104] = true;
        } else if (!reactionsResponse.wasGeneralError()) {
            $jacocoInit[105] = true;
        } else {
            $jacocoInit[106] = true;
            this.view.showGenericErrorToast();
            $jacocoInit[107] = true;
        }
        $jacocoInit[108] = true;
    }

    public void handleSnackLogInClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3340Ad ad = C3340Ad.f6726a;
        $jacocoInit[109] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ad);
        C3482_c _cVar = new C3482_c(this);
        $jacocoInit[110] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) _cVar);
        C3943ud udVar = new C3943ud(this);
        $jacocoInit[111] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) udVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[112] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3487ac acVar = C3487ac.f6867a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3831c cVar = new C3831c(crashReport);
        $jacocoInit[113] = true;
        a.mo3626a((C0129b<? super T>) acVar, (C0129b<Throwable>) cVar);
        $jacocoInit[114] = true;
    }

    /* renamed from: E */
    static /* synthetic */ Boolean m8065E(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[382] = true;
        return valueOf;
    }

    /* renamed from: F */
    public /* synthetic */ C0120S mo14457F(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S snackLogInClick = this.view.snackLogInClick();
        $jacocoInit[381] = true;
        return snackLogInClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14471a(Void homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeNavigator.navigateToLogIn();
        $jacocoInit[380] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8082b(Void lifecycleEvent) {
        $jacocoInit()[379] = true;
    }

    public void handleDismissClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3954wc wcVar = C3954wc.f7434a;
        $jacocoInit[115] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) wcVar);
        C3876jc jcVar = new C3876jc(this);
        $jacocoInit[116] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jcVar);
        C3424Od od = C3424Od.f6801a;
        $jacocoInit[117] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) od);
        C3447Tc tc = new C3447Tc(this);
        $jacocoInit[118] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) tc);
        C3473Yc yc = new C3473Yc(this);
        $jacocoInit[119] = true;
        C0120S f2 = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) yc);
        C0126V v = this.viewScheduler;
        $jacocoInit[120] = true;
        C0120S a = f2.mo3616a(v);
        C3871id idVar = new C3871id(this);
        $jacocoInit[121] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) idVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[122] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3363Dd dd = C3363Dd.f6743a;
        C3429Pd pd = C3429Pd.f6806a;
        $jacocoInit[123] = true;
        a2.mo3626a((C0129b<? super T>) dd, (C0129b<Throwable>) pd);
        $jacocoInit[124] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m8111k(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[378] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo14518l(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dismissBundleClicked = this.view.dismissBundleClicked();
        $jacocoInit[377] = true;
        return dismissBundleClicked;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8097e(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(homeEvent.getBundle() instanceof ActionBundle);
        $jacocoInit[376] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ void mo14495f(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        $jacocoInit[372] = true;
        HomeBundle bundle = homeEvent.getBundle();
        $jacocoInit[373] = true;
        String tag = bundle.getTag();
        int bundlePosition = homeEvent.getBundlePosition();
        $jacocoInit[374] = true;
        homeAnalytics2.sendActionItemDismissInteractEvent(tag, bundlePosition);
        $jacocoInit[375] = true;
    }

    /* renamed from: g */
    public /* synthetic */ C0120S mo14497g(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M remove = this.home.remove((ActionBundle) homeEvent.getBundle());
        $jacocoInit[370] = true;
        C0120S a = remove.mo3586a(C0120S.m652c(homeEvent));
        $jacocoInit[371] = true;
        return a;
    }

    /* renamed from: h */
    public /* synthetic */ void mo14499h(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideBundle(homeEvent.getBundlePosition());
        $jacocoInit[369] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m8109i(HomeEvent lifecycleEvent) {
        $jacocoInit()[368] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m8102f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[367] = true;
        throw onErrorNotImplementedException;
    }

    public void onCreateLoadBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3942uc ucVar = C3942uc.f7418a;
        $jacocoInit[125] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ucVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[126] = true;
        C0120S a = d.mo3616a(v);
        C3391Ic ic = new C3391Ic(this);
        $jacocoInit[127] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) ic);
        C3859gd gdVar = new C3859gd(this);
        $jacocoInit[128] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gdVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[129] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3436Rb rb = C3436Rb.f6813a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3831c cVar = new C3831c(crashReport);
        $jacocoInit[130] = true;
        a2.mo3626a((C0129b<? super T>) rb, (C0129b<Throwable>) cVar);
        $jacocoInit[131] = true;
    }

    /* renamed from: I */
    static /* synthetic */ Boolean m8067I(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[366] = true;
        return valueOf;
    }

    /* renamed from: J */
    public /* synthetic */ void mo14459J(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[365] = true;
    }

    /* renamed from: K */
    public /* synthetic */ C0120S mo14460K(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadHomeAndReactions = loadHomeAndReactions();
        $jacocoInit[364] = true;
        return loadHomeAndReactions;
    }

    /* renamed from: g */
    static /* synthetic */ void m8105g(List __) {
        $jacocoInit()[363] = true;
    }

    private Single<Boolean> showNativeAds() {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadNativeAd = this.home.shouldLoadNativeAd();
        C0126V v = this.viewScheduler;
        $jacocoInit[132] = true;
        Single a = shouldLoadNativeAd.mo3686a(v);
        C3488ad adVar = new C3488ad(this);
        $jacocoInit[133] = true;
        Single<Boolean> b = a.mo3695b((C0129b<? super T>) adVar);
        $jacocoInit[134] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14490e(Boolean showNatives) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setAdsTest(showNatives.booleanValue());
        $jacocoInit[362] = true;
    }

    /* renamed from: a */
    static /* synthetic */ HomeBundlesModel m8068a(Boolean aBoolean, HomeBundlesModel bundlesModel) {
        $jacocoInit()[361] = true;
        return bundlesModel;
    }

    private Single<HomeBundlesModel> loadHome() {
        boolean[] $jacocoInit = $jacocoInit();
        Single a = Single.m740a(showNativeAds(), loadBundles(), C3462Wb.f6838a);
        C0126V v = this.viewScheduler;
        $jacocoInit[135] = true;
        Single a2 = a.mo3686a(v);
        C3949vd vdVar = new C3949vd(this);
        $jacocoInit[136] = true;
        Single<HomeBundlesModel> b = a2.mo3695b((C0129b<? super T>) vdVar);
        $jacocoInit[137] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14476b(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        handleBundlesResult(bundlesModel);
        $jacocoInit[360] = true;
    }

    private Single<HomeBundlesModel> loadBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> loadHomeBundles = this.home.loadHomeBundles();
        $jacocoInit[138] = true;
        return loadHomeBundles;
    }

    private void handleBundlesResult(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (bundlesModel.hasErrors()) {
            $jacocoInit[139] = true;
            handleError(bundlesModel.getError());
            $jacocoInit[140] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[141] = true;
        } else {
            $jacocoInit[142] = true;
            this.view.hideLoading();
            $jacocoInit[143] = true;
            this.view.showBundles(bundlesModel.getList());
            $jacocoInit[144] = true;
        }
        $jacocoInit[145] = true;
    }

    private void handleError(Error error) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C33871.$SwitchMap$cm$aptoide$pt$home$HomeBundlesModel$Error[error.ordinal()];
        if (i == 1) {
            this.view.showNetworkError();
            $jacocoInit[147] = true;
        } else if (i != 2) {
            $jacocoInit[146] = true;
        } else {
            this.view.showGenericError();
            $jacocoInit[148] = true;
        }
        $jacocoInit[149] = true;
    }

    public void handleAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3423Oc oc = C3423Oc.f6800a;
        $jacocoInit[150] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oc);
        C3443Sd sd = new C3443Sd(this);
        $jacocoInit[151] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sd);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[152] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3405Lb lb = C3405Lb.f6784a;
        C3847ed edVar = C3847ed.f7269a;
        $jacocoInit[153] = true;
        a.mo3626a((C0129b<? super T>) lb, (C0129b<Throwable>) edVar);
        $jacocoInit[154] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8098e(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[359] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo14492f(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appClicked = this.view.appClicked();
        C3350Bc bc = new C3350Bc(this);
        $jacocoInit[327] = true;
        C0120S b = appClicked.mo3636b((C0129b<? super T>) bc);
        C0126V v = this.viewScheduler;
        $jacocoInit[328] = true;
        C0120S a = b.mo3616a(v);
        C3894mc mcVar = new C3894mc(this);
        $jacocoInit[329] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) mcVar);
        $jacocoInit[330] = true;
        C0120S g = b2.mo3662g();
        $jacocoInit[331] = true;
        return g;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14474b(AppHomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        Application app = click.getApp();
        $jacocoInit[351] = true;
        double rating = (double) app.getRating();
        Application app2 = click.getApp();
        $jacocoInit[352] = true;
        String packageName = app2.getPackageName();
        int appPosition = click.getAppPosition();
        int bundlePosition = click.getBundlePosition();
        $jacocoInit[353] = true;
        HomeBundle bundle = click.getBundle();
        $jacocoInit[354] = true;
        String tag = bundle.getTag();
        HomeBundle bundle2 = click.getBundle();
        $jacocoInit[355] = true;
        List content = bundle2.getContent();
        $jacocoInit[356] = true;
        int size = content.size();
        $jacocoInit[357] = true;
        homeAnalytics2.sendTapOnAppInteractEvent(rating, packageName, appPosition, bundlePosition, tag, size);
        $jacocoInit[358] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14482c(AppHomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        Application app = click.getApp();
        $jacocoInit[332] = true;
        HomeBundle bundle = click.getBundle();
        $jacocoInit[333] = true;
        BundleType type = bundle.getType();
        BundleType bundleType = BundleType.EDITORS;
        $jacocoInit[334] = true;
        if (type.equals(bundleType)) {
            $jacocoInit[335] = true;
            HomeNavigator homeNavigator2 = this.homeNavigator;
            Application app2 = click.getApp();
            $jacocoInit[336] = true;
            long appId = app2.getAppId();
            Application app3 = click.getApp();
            $jacocoInit[337] = true;
            String packageName = app3.getPackageName();
            Application app4 = click.getApp();
            $jacocoInit[338] = true;
            String tag = app4.getTag();
            String valueOf = String.valueOf(click.getAppPosition());
            $jacocoInit[339] = true;
            homeNavigator2.navigateWithEditorsPosition(appId, packageName, "", "", tag, valueOf);
            $jacocoInit[340] = true;
        } else {
            HomeBundle bundle2 = click.getBundle();
            $jacocoInit[341] = true;
            BundleType type2 = bundle2.getType();
            BundleType bundleType2 = BundleType.APPCOINS_ADS;
            $jacocoInit[342] = true;
            if (type2.equals(bundleType2)) {
                RewardApp rewardApp = (RewardApp) app;
                $jacocoInit[343] = true;
                this.homeAnalytics.convertAppcAdClick(rewardApp.getClickUrl());
                $jacocoInit[344] = true;
                HomeNavigator homeNavigator3 = this.homeNavigator;
                long appId2 = rewardApp.getAppId();
                $jacocoInit[345] = true;
                String packageName2 = rewardApp.getPackageName();
                String tag2 = rewardApp.getTag();
                String downloadUrl = rewardApp.getDownloadUrl();
                $jacocoInit[346] = true;
                float reward = rewardApp.getReward();
                $jacocoInit[347] = true;
                homeNavigator3.navigateWithDownloadUrlAndReward(appId2, packageName2, tag2, downloadUrl, reward);
                $jacocoInit[348] = true;
            } else {
                this.homeNavigator.navigateToAppView(app.getAppId(), app.getPackageName(), app.getTag());
                $jacocoInit[349] = true;
            }
        }
        $jacocoInit[350] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8074a(AppHomeEvent homeClick) {
        $jacocoInit()[326] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8089c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[325] = true;
        throw onErrorNotImplementedException;
    }

    private void handleEditorialCardClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3452Ub ub = C3452Ub.f6828a;
        $jacocoInit[155] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ub);
        C3417Nb nb = new C3417Nb(this);
        $jacocoInit[156] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nb);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[157] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3912pc pcVar = C3912pc.f7367a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3831c cVar = new C3831c(crashReport);
        $jacocoInit[158] = true;
        a.mo3626a((C0129b<? super T>) pcVar, (C0129b<Throwable>) cVar);
        $jacocoInit[159] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m8114m(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[324] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo14521n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S editorialCardClicked = this.view.editorialCardClicked();
        C0126V v = this.viewScheduler;
        $jacocoInit[313] = true;
        C0120S a = editorialCardClicked.mo3616a(v);
        C3433Qc qc = new C3433Qc(this);
        $jacocoInit[314] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) qc);
        $jacocoInit[315] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[316] = true;
        return g;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14488d(EditorialHomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        HomeBundle bundle = click.getBundle();
        $jacocoInit[317] = true;
        String tag = bundle.getTag();
        int bundlePosition = click.getBundlePosition();
        String cardId = click.getCardId();
        $jacocoInit[318] = true;
        homeAnalytics2.sendEditorialInteractEvent(tag, bundlePosition, cardId);
        $jacocoInit[319] = true;
        HomeAnalytics homeAnalytics3 = this.homeAnalytics;
        HomeBundle bundle2 = click.getBundle();
        $jacocoInit[320] = true;
        String tag2 = bundle2.getTag();
        int bundlePosition2 = click.getBundlePosition();
        String cardId2 = click.getCardId();
        $jacocoInit[321] = true;
        homeAnalytics3.sendActionItemEditorialTapOnCardInteractEvent(tag2, bundlePosition2, cardId2);
        $jacocoInit[322] = true;
        this.homeNavigator.navigateToEditorial(click.getCardId());
        $jacocoInit[323] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8075a(EditorialHomeEvent homeClick) {
        $jacocoInit()[312] = true;
    }

    public void handleAdClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3392Id id = C3392Id.f6771a;
        $jacocoInit[160] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) id);
        C3936tc tcVar = new C3936tc(this);
        $jacocoInit[161] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tcVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[162] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3384Hc hc = C3384Hc.f6764a;
        C3918qc qcVar = C3918qc.f7378a;
        $jacocoInit[163] = true;
        a.mo3626a((C0129b<? super T>) hc, (C0129b<Throwable>) qcVar);
        $jacocoInit[164] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8086c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[311] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14485d(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S adClicked = this.view.adClicked();
        C3888lc lcVar = new C3888lc(this);
        $jacocoInit[289] = true;
        C0120S b = adClicked.mo3636b((C0129b<? super T>) lcVar);
        C3453Uc uc = C3453Uc.f6829a;
        $jacocoInit[290] = true;
        C0120S j = b.mo3669j(uc);
        AdMapper adMapper2 = this.adMapper;
        $jacocoInit[291] = true;
        C0120S j2 = j.mo3669j(adMapper2.mapAdToSearchAd());
        C0126V v = this.viewScheduler;
        $jacocoInit[292] = true;
        C0120S a = j2.mo3616a(v);
        C3459Vd vd = new C3459Vd(this);
        $jacocoInit[293] = true;
        C0120S a2 = a.mo3621a((C0129b<? super Throwable>) vd);
        HomeNavigator homeNavigator2 = this.homeNavigator;
        homeNavigator2.getClass();
        C3825b bVar = new C3825b(homeNavigator2);
        $jacocoInit[294] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) bVar);
        $jacocoInit[295] = true;
        C0120S g = b2.mo3662g();
        $jacocoInit[296] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14467a(AdHomeEvent adHomeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        AdClick adClick = adHomeEvent.getAdClick();
        $jacocoInit[302] = true;
        ApplicationAd ad = adClick.getAd();
        $jacocoInit[303] = true;
        Integer stars = ad.getStars();
        $jacocoInit[304] = true;
        int intValue = stars.intValue();
        $jacocoInit[305] = true;
        AdClick adClick2 = adHomeEvent.getAdClick();
        $jacocoInit[306] = true;
        ApplicationAd ad2 = adClick2.getAd();
        $jacocoInit[307] = true;
        String packageName = ad2.getPackageName();
        int bundlePosition = adHomeEvent.getBundlePosition();
        HomeBundle bundle = adHomeEvent.getBundle();
        $jacocoInit[308] = true;
        String tag = bundle.getTag();
        Type type = adHomeEvent.getType();
        Network network = Network.SERVER;
        $jacocoInit[309] = true;
        homeAnalytics2.sendAdClickEvent(intValue, packageName, bundlePosition, tag, type, network);
        $jacocoInit[310] = true;
    }

    /* renamed from: b */
    static /* synthetic */ AdClick m8078b(AdHomeEvent adHomeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        AdClick adClick = adHomeEvent.getAdClick();
        $jacocoInit[301] = true;
        return adClick;
    }

    /* renamed from: m */
    public /* synthetic */ void mo14520m(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[297] = true;
        Class cls = getClass();
        $jacocoInit[298] = true;
        String canonicalName = cls.getCanonicalName();
        $jacocoInit[299] = true;
        instance.mo2142e(canonicalName, throwable);
        $jacocoInit[300] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8076a(SimpleEntry homeClick) {
        $jacocoInit()[288] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8081b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[287] = true;
        throw onErrorNotImplementedException;
    }

    public void handleMoreClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3907od odVar = C3907od.f7354a;
        $jacocoInit[165] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) odVar);
        C3840dc dcVar = new C3840dc(this);
        $jacocoInit[166] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dcVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[167] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3407Ld ld = C3407Ld.f6786a;
        C3374Fc fc = C3374Fc.f6754a;
        $jacocoInit[168] = true;
        a.mo3626a((C0129b<? super T>) ld, (C0129b<Throwable>) fc);
        $jacocoInit[169] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m8120w(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[286] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo14529x(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S moreClicked = this.view.moreClicked();
        C3889ld ldVar = new C3889ld(this);
        $jacocoInit[275] = true;
        C0120S b = moreClicked.mo3636b((C0129b<? super T>) ldVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[276] = true;
        C0120S a = b.mo3616a(v);
        HomeNavigator homeNavigator2 = this.homeNavigator;
        homeNavigator2.getClass();
        C3830be beVar = new C3830be(homeNavigator2);
        $jacocoInit[277] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) beVar);
        $jacocoInit[278] = true;
        C0120S g = b2.mo3662g();
        $jacocoInit[279] = true;
        return g;
    }

    /* renamed from: n */
    public /* synthetic */ void mo14522n(HomeEvent homeMoreClick) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        $jacocoInit[280] = true;
        int bundlePosition = homeMoreClick.getBundlePosition();
        HomeBundle bundle = homeMoreClick.getBundle();
        $jacocoInit[281] = true;
        String tag = bundle.getTag();
        HomeBundle bundle2 = homeMoreClick.getBundle();
        $jacocoInit[282] = true;
        List content = bundle2.getContent();
        $jacocoInit[283] = true;
        int size = content.size();
        $jacocoInit[284] = true;
        homeAnalytics2.sendTapOnMoreInteractEvent(bundlePosition, tag, size);
        $jacocoInit[285] = true;
    }

    /* renamed from: m */
    static /* synthetic */ void m8115m(HomeEvent homeClick) {
        $jacocoInit()[274] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m8110j(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[273] = true;
        throw onErrorNotImplementedException;
    }

    public void handleBundleScrolledRight() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3931sd sdVar = C3931sd.f7400a;
        $jacocoInit[170] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) sdVar);
        C3412Mb mb = new C3412Mb(this);
        $jacocoInit[171] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mb);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[172] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3834cc ccVar = C3834cc.f7250a;
        C3829bd bdVar = C3829bd.f7245a;
        $jacocoInit[173] = true;
        a.mo3626a((C0129b<? super T>) ccVar, (C0129b<Throwable>) bdVar);
        $jacocoInit[174] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m8108i(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[272] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo14515j(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S bundleScrolled = this.view.bundleScrolled();
        C3877jd jdVar = new C3877jd(this);
        $jacocoInit[262] = true;
        C0120S b = bundleScrolled.mo3636b((C0129b<? super T>) jdVar);
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3831c cVar = new C3831c(crashReport);
        $jacocoInit[263] = true;
        C0120S a = b.mo3621a((C0129b<? super Throwable>) cVar);
        $jacocoInit[264] = true;
        C0120S g = a.mo3662g();
        $jacocoInit[265] = true;
        return g;
    }

    /* renamed from: o */
    public /* synthetic */ void mo14523o(HomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        int bundlePosition = click.getBundlePosition();
        $jacocoInit[266] = true;
        HomeBundle bundle = click.getBundle();
        $jacocoInit[267] = true;
        String tag = bundle.getTag();
        HomeBundle bundle2 = click.getBundle();
        $jacocoInit[268] = true;
        List content = bundle2.getContent();
        $jacocoInit[269] = true;
        int size = content.size();
        $jacocoInit[270] = true;
        homeAnalytics2.sendScrollRightInteractEvent(bundlePosition, tag, size);
        $jacocoInit[271] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8092d(HomeEvent scroll) {
        $jacocoInit()[261] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m8099e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[260] = true;
        throw onErrorNotImplementedException;
    }

    public void handleBottomReached() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3357Cc cc = C3357Cc.f6736a;
        $jacocoInit[175] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) cc);
        C3973zd zdVar = new C3973zd(this);
        $jacocoInit[176] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zdVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[177] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3446Tb tb = C3446Tb.f6823a;
        C3379Gc gc = C3379Gc.f6759a;
        $jacocoInit[178] = true;
        a.mo3626a((C0129b<? super T>) tb, (C0129b<Throwable>) gc);
        $jacocoInit[179] = true;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m8106h(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[259] = true;
        return valueOf;
    }

    /* renamed from: g */
    public /* synthetic */ C0120S mo14498g(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reachesBottom = this.view.reachesBottom();
        C3960xc xcVar = new C3960xc(this);
        $jacocoInit[250] = true;
        C0120S d = reachesBottom.mo3653d((C0132p<? super T, Boolean>) xcVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[251] = true;
        C0120S a = d.mo3616a(v);
        C3351Bd bd = new C3351Bd(this);
        $jacocoInit[252] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) bd);
        C3418Nc nc = new C3418Nc(this);
        $jacocoInit[253] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nc);
        $jacocoInit[254] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[255] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14462a(Object __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.home.hasMore());
        $jacocoInit[258] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14479b(Object bottomReached) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoadMore();
        $jacocoInit[257] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo14480c(Object bottomReached) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadNextBundlesAndReactions = loadNextBundlesAndReactions();
        $jacocoInit[256] = true;
        return loadNextBundlesAndReactions;
    }

    /* renamed from: a */
    static /* synthetic */ void m8077a(List bundles) {
        $jacocoInit()[249] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8094d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[248] = true;
        throw onErrorNotImplementedException;
    }

    private Single<HomeBundlesModel> loadNextBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadNextHomeBundles = this.home.loadNextHomeBundles();
        C0126V v = this.viewScheduler;
        $jacocoInit[180] = true;
        Single a = loadNextHomeBundles.mo3686a(v);
        C3375Fd fd = new C3375Fd(this);
        $jacocoInit[181] = true;
        Single<HomeBundlesModel> b = a.mo3695b((C0129b<? super T>) fd);
        $jacocoInit[182] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14483c(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendLoadMoreInteractEvent();
        $jacocoInit[240] = true;
        if (bundlesModel.hasErrors()) {
            $jacocoInit[241] = true;
            handleError(bundlesModel.getError());
            $jacocoInit[242] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[243] = true;
        } else {
            $jacocoInit[244] = true;
            this.view.showMoreHomeBundles(bundlesModel.getList());
            $jacocoInit[245] = true;
            this.view.hideLoading();
            $jacocoInit[246] = true;
        }
        this.view.hideShowMore();
        $jacocoInit[247] = true;
    }

    public void handlePullToRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3400Kb kb = C3400Kb.f6779a;
        $jacocoInit[183] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kb);
        C3841dd ddVar = new C3841dd(this);
        $jacocoInit[184] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ddVar);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[185] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3457Vb vb = C3457Vb.f6833a;
        C3434Qd qd = C3434Qd.f6811a;
        $jacocoInit[186] = true;
        a.mo3626a((C0129b<? super T>) vb, (C0129b<Throwable>) qd);
        $jacocoInit[187] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m8121y(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[239] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo14530z(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S refreshes = this.view.refreshes();
        C3864hc hcVar = new C3864hc(this);
        $jacocoInit[233] = true;
        C0120S b = refreshes.mo3636b((C0129b<? super T>) hcVar);
        C3925rd rdVar = new C3925rd(this);
        $jacocoInit[234] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rdVar);
        $jacocoInit[235] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[236] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14484c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendPullRefreshInteractEvent();
        $jacocoInit[238] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14486d(Void refreshed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadFreshBundlesAndReactions = loadFreshBundlesAndReactions();
        $jacocoInit[237] = true;
        return loadFreshBundlesAndReactions;
    }

    /* renamed from: b */
    static /* synthetic */ void m8083b(List bundles) {
        $jacocoInit()[232] = true;
    }

    /* renamed from: k */
    static /* synthetic */ void m8112k(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[231] = true;
        throw onErrorNotImplementedException;
    }

    private Single<HomeBundlesModel> loadFreshBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshHomeBundles = this.home.loadFreshHomeBundles();
        C0126V v = this.viewScheduler;
        $jacocoInit[188] = true;
        Single a = loadFreshHomeBundles.mo3686a(v);
        C3937td tdVar = new C3937td(this);
        $jacocoInit[189] = true;
        Single<HomeBundlesModel> b = a.mo3695b((C0129b<? super T>) tdVar);
        $jacocoInit[190] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14468a(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideRefresh();
        $jacocoInit[224] = true;
        if (bundlesModel.hasErrors()) {
            $jacocoInit[225] = true;
            handleError(bundlesModel.getError());
            $jacocoInit[226] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[227] = true;
        } else {
            $jacocoInit[228] = true;
            this.view.showBundles(bundlesModel.getList());
            $jacocoInit[229] = true;
        }
        $jacocoInit[230] = true;
    }

    public void handleRetryClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3396Jc jc = C3396Jc.f6775a;
        $jacocoInit[191] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jc);
        C3362Dc dc = new C3362Dc(this);
        $jacocoInit[192] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dc);
        HomeView homeView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[193] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeView.bindUntilEvent(lifecycleEvent2));
        C3919qd qdVar = C3919qd.f7379a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3831c cVar = new C3831c(crashReport);
        $jacocoInit[194] = true;
        a.mo3626a((C0129b<? super T>) qdVar, (C0129b<Throwable>) cVar);
        $jacocoInit[195] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m8064C(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[223] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo14456D(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S retryClicked = this.view.retryClicked();
        C0126V v = this.viewScheduler;
        $jacocoInit[216] = true;
        C0120S a = retryClicked.mo3616a(v);
        C3900nc ncVar = new C3900nc(this);
        $jacocoInit[217] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) ncVar);
        C3895md mdVar = new C3895md(this);
        $jacocoInit[218] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mdVar);
        $jacocoInit[219] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[220] = true;
        return g;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14491e(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[222] = true;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo14493f(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadNextBundlesAndReactions = loadNextBundlesAndReactions();
        $jacocoInit[221] = true;
        return loadNextBundlesAndReactions;
    }

    /* renamed from: d */
    static /* synthetic */ void m8095d(List notificationUrl) {
        $jacocoInit()[215] = true;
    }

    /* access modifiers changed from: private */
    public C0120S<List<HomeBundle>> singlePressReactionButtonAction(EditorialHomeEvent editorialHomeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Single isFirstReaction = this.home.isFirstReaction(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId());
        C3924rc rcVar = new C3924rc(this, editorialHomeEvent);
        $jacocoInit[196] = true;
        C0120S<List<HomeBundle>> c = isFirstReaction.mo3697c(rcVar);
        $jacocoInit[197] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14463a(EditorialHomeEvent editorialHomeEvent, Boolean firstReaction) {
        boolean[] $jacocoInit = $jacocoInit();
        if (firstReaction.booleanValue()) {
            $jacocoInit[198] = true;
            this.homeAnalytics.sendReactionButtonClickEvent();
            $jacocoInit[199] = true;
            HomeView homeView = this.view;
            String cardId = editorialHomeEvent.getCardId();
            String groupId = editorialHomeEvent.getGroupId();
            $jacocoInit[200] = true;
            int bundlePosition = editorialHomeEvent.getBundlePosition();
            $jacocoInit[201] = true;
            homeView.showReactionsPopup(cardId, groupId, bundlePosition);
            $jacocoInit[202] = true;
            C0120S c = C0120S.m652c(Collections.emptyList());
            $jacocoInit[203] = true;
            return c;
        }
        Home home2 = this.home;
        String cardId2 = editorialHomeEvent.getCardId();
        $jacocoInit[204] = true;
        String groupId2 = editorialHomeEvent.getGroupId();
        $jacocoInit[205] = true;
        Single deleteReaction = home2.deleteReaction(cardId2, groupId2);
        $jacocoInit[206] = true;
        C0120S c2 = deleteReaction.mo3696c();
        C3972zc zcVar = new C3972zc(this);
        $jacocoInit[207] = true;
        C0120S b = c2.mo3636b((C0129b<? super T>) zcVar);
        C3484a aVar = C3484a.f6864a;
        $jacocoInit[208] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) aVar);
        C3469Xd xd = new C3469Xd(this, editorialHomeEvent);
        $jacocoInit[209] = true;
        C0120S i = d.mo3668i(xd);
        $jacocoInit[210] = true;
        return i;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14469a(ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        handleReactionsResponse(reactionsResponse, true);
        $jacocoInit[214] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14465a(EditorialHomeEvent editorialHomeEvent, ReactionsResponse __) {
        boolean[] $jacocoInit = $jacocoInit();
        String cardId = editorialHomeEvent.getCardId();
        $jacocoInit[211] = true;
        String groupId = editorialHomeEvent.getGroupId();
        $jacocoInit[212] = true;
        Single loadReactionModel = loadReactionModel(cardId, groupId);
        $jacocoInit[213] = true;
        return loadReactionModel;
    }
}
