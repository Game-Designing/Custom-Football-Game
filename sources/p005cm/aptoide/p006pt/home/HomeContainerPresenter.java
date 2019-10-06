package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.ChipManager.Chip;
import p005cm.aptoide.p006pt.home.HomeContainerFragment.ChipsEvents;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.HomeContainerPresenter */
public class HomeContainerPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final ChipManager chipManager;
    private final CrashReport crashReport;
    private final Home home;
    private final HomeAnalytics homeAnalytics;
    private final HomeContainerNavigator homeContainerNavigator;
    private final HomeNavigator homeNavigator;
    private final HomeContainerView view;
    private final C0126V viewScheduler;

    /* renamed from: cm.aptoide.pt.home.HomeContainerPresenter$1 */
    static /* synthetic */ class C33861 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents = new int[ChipsEvents.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-5595702521073419837L, "cm/aptoide/pt/home/HomeContainerPresenter$1", 6);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents[ChipsEvents.GAMES.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents[ChipsEvents.APPS.ordinal()] = 2;
            $jacocoInit[3] = true;
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3752074232545620381L, "cm/aptoide/pt/home/HomeContainerPresenter", 255);
        $jacocoData = probes;
        return probes;
    }

    public HomeContainerPresenter(HomeContainerView view2, C0126V viewScheduler2, CrashReport crashReport2, AptoideAccountManager accountManager2, HomeContainerNavigator homeContainerNavigator2, HomeNavigator homeNavigator2, HomeAnalytics homeAnalytics2, Home home2, ChipManager chipManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.viewScheduler = viewScheduler2;
        this.crashReport = crashReport2;
        this.accountManager = accountManager2;
        this.homeContainerNavigator = homeContainerNavigator2;
        this.homeNavigator = homeNavigator2;
        this.homeAnalytics = homeAnalytics2;
        this.home = home2;
        this.chipManager = chipManager2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        loadMainHomeContent();
        $jacocoInit[1] = true;
        loadUserImage();
        $jacocoInit[2] = true;
        handleUserImageClick();
        $jacocoInit[3] = true;
        handlePromotionsClick();
        $jacocoInit[4] = true;
        checkForPromotionApps();
        $jacocoInit[5] = true;
        handleClickOnPromotionsDialogContinue();
        $jacocoInit[6] = true;
        handleClickOnPromotionsDialogCancel();
        $jacocoInit[7] = true;
        handleLoggedInAcceptTermsAndConditions();
        $jacocoInit[8] = true;
        handleTermsAndConditionsContinueClicked();
        $jacocoInit[9] = true;
        handleTermsAndConditionsLogOutClicked();
        $jacocoInit[10] = true;
        handleClickOnTermsAndConditions();
        $jacocoInit[11] = true;
        handleClickOnPrivacyPolicy();
        $jacocoInit[12] = true;
        handleClickOnGamesChip();
        $jacocoInit[13] = true;
        handleClickOnAppsChip();
        $jacocoInit[14] = true;
        handleBottomNavigationEvents();
        $jacocoInit[15] = true;
    }

    public void loadMainHomeContent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3881kb kbVar = C3881kb.f7316a;
        $jacocoInit[16] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kbVar);
        C3410M m = new C3410M(this);
        $jacocoInit[17] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) m);
        C3470Y y = new C3470Y(this);
        $jacocoInit[18] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) y);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[19] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3435Ra ra = C3435Ra.f6812a;
        C3475Z z = C3475Z.f6853a;
        $jacocoInit[20] = true;
        a.mo3626a((C0129b<? super T>) ra, (C0129b<Throwable>) z);
        $jacocoInit[21] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m7961A(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[254] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo14366B(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isChipChecked = this.view.isChipChecked();
        $jacocoInit[253] = true;
        return isChipChecked;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14369a(ChipsEvents checked) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C33861.$SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents[checked.ordinal()];
        if (i == 1) {
            this.homeContainerNavigator.loadGamesHomeContent();
            $jacocoInit[249] = true;
        } else if (i != 2) {
            this.homeContainerNavigator.loadMainHomeContent();
            $jacocoInit[251] = true;
        } else {
            this.homeContainerNavigator.loadAppsHomeContent();
            $jacocoInit[250] = true;
        }
        $jacocoInit[252] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7967b(ChipsEvents __) {
        $jacocoInit()[248] = true;
    }

    /* renamed from: n */
    static /* synthetic */ void m8000n(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(err);
        $jacocoInit[247] = true;
        throw onErrorNotImplementedException;
    }

    private void handleBottomNavigationEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3892ma maVar = C3892ma.f7334a;
        $jacocoInit[22] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) maVar);
        C3839db dbVar = new C3839db(this);
        $jacocoInit[23] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dbVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[24] = true;
        C0120S a = f.mo3616a(v);
        C3845eb ebVar = new C3845eb(this);
        $jacocoInit[25] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ebVar);
        C3905ob obVar = new C3905ob(this);
        $jacocoInit[26] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) obVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[27] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3869ib ibVar = C3869ib.f7301a;
        C3934ta taVar = C3934ta.f7408a;
        $jacocoInit[28] = true;
        a2.mo3626a((C0129b<? super T>) ibVar, (C0129b<Throwable>) taVar);
        $jacocoInit[29] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7971c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[246] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14381d(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S bottomNavigation = this.homeNavigator.bottomNavigation();
        $jacocoInit[245] = true;
        return bottomNavigation;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14368a(Integer __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigateHome = this.homeContainerNavigator.navigateHome();
        $jacocoInit[244] = true;
        return navigateHome;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14371a(Boolean shouldGoHome) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.expandChips();
        $jacocoInit[237] = true;
        if (!shouldGoHome.booleanValue()) {
            $jacocoInit[238] = true;
        } else {
            $jacocoInit[239] = true;
            this.homeContainerNavigator.loadMainHomeContent();
            $jacocoInit[240] = true;
            this.chipManager.setCurrentChip(null);
            $jacocoInit[241] = true;
            this.view.uncheckChips();
            $jacocoInit[242] = true;
        }
        $jacocoInit[243] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7968b(Boolean __) {
        $jacocoInit()[236] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7969b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(err);
        $jacocoInit[235] = true;
        throw onErrorNotImplementedException;
    }

    public void loadUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3389Ia ia = C3389Ia.f6768a;
        $jacocoInit[30] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ia);
        C3420O o = new C3420O(this);
        $jacocoInit[31] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) o);
        C3440Sa sa = new C3440Sa(this);
        $jacocoInit[32] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sa);
        C0126V v = this.viewScheduler;
        $jacocoInit[33] = true;
        C0120S a = f2.mo3616a(v);
        C3486ab abVar = new C3486ab(this);
        $jacocoInit[34] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) abVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[35] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3450U u = C3450U.f6826a;
        C3970za zaVar = C3970za.f7452a;
        $jacocoInit[36] = true;
        a2.mo3626a((C0129b<? super T>) u, (C0129b<Throwable>) zaVar);
        $jacocoInit[37] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m7962C(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[234] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo14367D(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[233] = true;
        return accountStatus;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14380d(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S userAvatar = getUserAvatar(account);
        $jacocoInit[232] = true;
        return userAvatar;
    }

    /* renamed from: s */
    public /* synthetic */ void mo14409s(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (userAvatarUrl != null) {
            $jacocoInit[228] = true;
            this.view.setUserImage(userAvatarUrl);
            $jacocoInit[229] = true;
        } else {
            this.view.setDefaultUserImage();
            $jacocoInit[230] = true;
        }
        this.view.showAvatar();
        $jacocoInit[231] = true;
    }

    /* renamed from: t */
    static /* synthetic */ void m8008t(String __) {
        $jacocoInit()[227] = true;
    }

    /* renamed from: o */
    static /* synthetic */ void m8003o(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[226] = true;
        throw onErrorNotImplementedException;
    }

    public void handleUserImageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3476Za za = C3476Za.f6854a;
        $jacocoInit[38] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) za);
        C3355Ca ca = new C3355Ca(this);
        $jacocoInit[39] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ca);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[40] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3928sa saVar = C3928sa.f7397a;
        C3430Q q = C3430Q.f6807a;
        $jacocoInit[41] = true;
        a.mo3626a((C0129b<? super T>) saVar, (C0129b<Throwable>) q);
        $jacocoInit[42] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m8011y(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[225] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo14413z(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.view.toolbarUserClick();
        C0126V v = this.viewScheduler;
        $jacocoInit[220] = true;
        C0120S a = s.mo3616a(v);
        C3833cb cbVar = new C3833cb(this);
        $jacocoInit[221] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) cbVar);
        $jacocoInit[222] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[223] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14378c(Void account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeNavigator.navigateToMyAccount();
        $jacocoInit[224] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7970b(Void __) {
        $jacocoInit()[219] = true;
    }

    /* renamed from: m */
    static /* synthetic */ void m7999m(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[218] = true;
        throw onErrorNotImplementedException;
    }

    public void handlePromotionsClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3832ca caVar = C3832ca.f7248a;
        $jacocoInit[43] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) caVar);
        C3886la laVar = new C3886la(this);
        $jacocoInit[44] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) laVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[45] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3394Ja ja = C3394Ja.f6773a;
        C3480_a _aVar = C3480_a.f6860a;
        $jacocoInit[46] = true;
        a.mo3626a((C0129b<? super T>) ja, (C0129b<Throwable>) _aVar);
        $jacocoInit[47] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m8007s(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[217] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo14410t(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.view.toolbarPromotionsClick();
        C0126V v = this.viewScheduler;
        $jacocoInit[211] = true;
        C0120S a = s.mo3616a(v);
        C3862ha haVar = new C3862ha(this);
        $jacocoInit[212] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) haVar);
        $jacocoInit[213] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[214] = true;
        return g;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14382d(Void account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendPromotionsIconClickEvent();
        $jacocoInit[215] = true;
        this.homeNavigator.navigateToPromotions();
        $jacocoInit[216] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7966a(Void __) {
        $jacocoInit()[210] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m7992j(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[209] = true;
        throw onErrorNotImplementedException;
    }

    public void checkForPromotionApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3372Fa fa = C3372Fa.f6752a;
        $jacocoInit[48] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) fa);
        C3426Pa pa = new C3426Pa(this);
        $jacocoInit[49] = true;
        C0120S i = d.mo3668i(pa);
        C3902ne neVar = C3902ne.f7349a;
        $jacocoInit[50] = true;
        C0120S d2 = i.mo3653d((C0132p<? super T, Boolean>) neVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[51] = true;
        C0120S a = d2.mo3616a(v);
        C3940ua uaVar = new C3940ua(this);
        $jacocoInit[52] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) uaVar);
        C3950ve veVar = C3950ve.f7430a;
        $jacocoInit[53] = true;
        C0120S d3 = b.mo3653d((C0132p<? super T, Boolean>) veVar);
        C3439S s = new C3439S(this);
        $jacocoInit[54] = true;
        C0120S b2 = d3.mo3636b((C0129b<? super T>) s);
        C3944ue ueVar = C3944ue.f7420a;
        $jacocoInit[55] = true;
        C0120S a2 = b2.mo3621a((C0129b<? super Throwable>) ueVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[56] = true;
        C0120S a3 = a2.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3826ba baVar = C3826ba.f7242a;
        C3844ea eaVar = new C3844ea(this);
        $jacocoInit[57] = true;
        a3.mo3626a((C0129b<? super T>) baVar, (C0129b<Throwable>) eaVar);
        $jacocoInit[58] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7964a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[208] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo14373b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single hasPromotionApps = this.home.hasPromotionApps();
        $jacocoInit[207] = true;
        return hasPromotionApps;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14370a(HomePromotionsWrapper apps) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showPromotionsHomeIcon(apps);
        $jacocoInit[205] = true;
        this.homeAnalytics.sendPromotionsImpressionEvent();
        $jacocoInit[206] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14375b(HomePromotionsWrapper apps) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendPromotionsDialogImpressionEvent();
        $jacocoInit[202] = true;
        this.home.setPromotionsDialogShown();
        $jacocoInit[203] = true;
        this.view.showPromotionsHomeDialog(apps);
        $jacocoInit[204] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7973c(HomePromotionsWrapper __) {
        $jacocoInit()[201] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14372a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePromotionsIcon();
        $jacocoInit[200] = true;
    }

    public void handleClickOnPromotionsDialogContinue() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3880ka kaVar = C3880ka.f7315a;
        $jacocoInit[59] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kaVar);
        C3893mb mbVar = new C3893mb(this);
        $jacocoInit[60] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mbVar);
        C3929sb sbVar = C3929sb.f7398a;
        $jacocoInit[61] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) sbVar);
        C3946va vaVar = new C3946va(this);
        $jacocoInit[62] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) vaVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[63] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3485aa aaVar = C3485aa.f6865a;
        C3916qa qaVar = C3916qa.f7376a;
        $jacocoInit[64] = true;
        a.mo3626a((C0129b<? super T>) aaVar, (C0129b<Throwable>) qaVar);
        $jacocoInit[65] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m7997m(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[199] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo14405n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S promotionsHomeDialogClicked = this.view.promotionsHomeDialogClicked();
        $jacocoInit[198] = true;
        return promotionsHomeDialogClicked;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7985g(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(action.equals("navigate"));
        $jacocoInit[197] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ void mo14387h(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendPromotionsDialogNavigateEvent();
        $jacocoInit[194] = true;
        this.view.dismissPromotionsDialog();
        $jacocoInit[195] = true;
        this.homeNavigator.navigateToPromotions();
        $jacocoInit[196] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m7989i(String __) {
        $jacocoInit()[193] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m7986g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[192] = true;
        throw onErrorNotImplementedException;
    }

    public void handleClickOnPromotionsDialogCancel() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3923rb rbVar = C3923rb.f7387a;
        $jacocoInit[66] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) rbVar);
        C3917qb qbVar = new C3917qb(this);
        $jacocoInit[67] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qbVar);
        C3377Ga ga = C3377Ga.f6757a;
        $jacocoInit[68] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) ga);
        C3868ia iaVar = new C3868ia(this);
        $jacocoInit[69] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) iaVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[70] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3851fb fbVar = C3851fb.f7274a;
        C3863hb hbVar = C3863hb.f7293a;
        $jacocoInit[71] = true;
        a.mo3626a((C0129b<? super T>) fbVar, (C0129b<Throwable>) hbVar);
        $jacocoInit[72] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7993k(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[191] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo14401l(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S promotionsHomeDialogClicked = this.view.promotionsHomeDialogClicked();
        $jacocoInit[190] = true;
        return promotionsHomeDialogClicked;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m7976d(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(action.equals("cancel"));
        $jacocoInit[189] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14384e(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendPromotionsDialogDismissEvent();
        $jacocoInit[187] = true;
        this.view.dismissPromotionsDialog();
        $jacocoInit[188] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m7982f(String __) {
        $jacocoInit()[186] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m7983f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[185] = true;
        throw onErrorNotImplementedException;
    }

    public void handleLoggedInAcceptTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3874ja jaVar = C3874ja.f7307a;
        $jacocoInit[73] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jaVar);
        C3455V v = new C3455V(this);
        $jacocoInit[74] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) v);
        C3962xe xeVar = C3962xe.f7442a;
        $jacocoInit[75] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) xeVar);
        C3460W w = C3460W.f6836a;
        $jacocoInit[76] = true;
        C0120S d3 = d2.mo3653d((C0132p<? super T, Boolean>) w);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[77] = true;
        C0120S a = d3.mo3616a(v2);
        C3456Va va = new C3456Va(this);
        $jacocoInit[78] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) va);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[79] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3910pa paVar = C3910pa.f7365a;
        C3444T t = C3444T.f6821a;
        $jacocoInit[80] = true;
        a2.mo3626a((C0129b<? super T>) paVar, (C0129b<Throwable>) t);
        $jacocoInit[81] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m8005q(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[184] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo14408r(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[182] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[183] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7963a(Account account) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!account.acceptedPrivacyPolicy()) {
            $jacocoInit[177] = true;
        } else if (!account.acceptedTermsAndConditions()) {
            $jacocoInit[178] = true;
        } else {
            z = false;
            $jacocoInit[180] = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[181] = true;
            return valueOf;
        }
        $jacocoInit[179] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[181] = true;
        return valueOf2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14374b(Account __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showTermsAndConditionsDialog();
        $jacocoInit[176] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7972c(Account __) {
        $jacocoInit()[175] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m7990i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[174] = true;
        throw onErrorNotImplementedException;
    }

    public void handleTermsAndConditionsContinueClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3838da daVar = C3838da.f7259a;
        $jacocoInit[82] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) daVar);
        C3952wa waVar = new C3952wa(this);
        $jacocoInit[83] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) waVar);
        C3850fa faVar = C3850fa.f7273a;
        $jacocoInit[84] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) faVar);
        C3899nb nbVar = new C3899nb(this);
        $jacocoInit[85] = true;
        C0120S g = d2.mo3663g((C0132p<? super T, ? extends C0117M>) nbVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[86] = true;
        C0120S a = g.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3348Ba ba = C3348Ba.f6729a;
        C3958xa xaVar = C3958xa.f7438a;
        $jacocoInit[87] = true;
        a.mo3626a((C0129b<? super T>) ba, (C0129b<Throwable>) xaVar);
        $jacocoInit[88] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m8009u(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[173] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo14411v(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S gdprDialogClicked = this.view.gdprDialogClicked();
        $jacocoInit[172] = true;
        return gdprDialogClicked;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m7998m(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(action.equals("continue"));
        $jacocoInit[171] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0117M mo14404n(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M updateTermsAndConditions = this.accountManager.updateTermsAndConditions();
        $jacocoInit[170] = true;
        return updateTermsAndConditions;
    }

    /* renamed from: o */
    static /* synthetic */ void m8002o(String __) {
        $jacocoInit()[169] = true;
    }

    /* renamed from: k */
    static /* synthetic */ void m7994k(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[168] = true;
        throw onErrorNotImplementedException;
    }

    public void handleTermsAndConditionsLogOutClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3898na naVar = C3898na.f7345a;
        $jacocoInit[89] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) naVar);
        C3466Xa xa = new C3466Xa(this);
        $jacocoInit[90] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xa);
        C3911pb pbVar = C3911pb.f7366a;
        $jacocoInit[91] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) pbVar);
        C3904oa oaVar = new C3904oa(this);
        $jacocoInit[92] = true;
        C0120S g = d2.mo3663g((C0132p<? super T, ? extends C0117M>) oaVar);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[93] = true;
        C0120S a = g.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3922ra raVar = C3922ra.f7386a;
        C3465X x = C3465X.f6841a;
        $jacocoInit[94] = true;
        a.mo3626a((C0129b<? super T>) raVar, (C0129b<Throwable>) x);
        $jacocoInit[95] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m8010w(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[167] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo14412x(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S gdprDialogClicked = this.view.gdprDialogClicked();
        $jacocoInit[166] = true;
        return gdprDialogClicked;
    }

    /* renamed from: p */
    static /* synthetic */ Boolean m8004p(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(action.equals("logout"));
        $jacocoInit[165] = true;
        return valueOf;
    }

    /* renamed from: q */
    public /* synthetic */ C0117M mo14407q(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M logout = this.accountManager.logout();
        $jacocoInit[164] = true;
        return logout;
    }

    /* renamed from: r */
    static /* synthetic */ void m8006r(String __) {
        $jacocoInit()[163] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m7996l(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[162] = true;
        throw onErrorNotImplementedException;
    }

    public void handleClickOnTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3856ga gaVar = C3856ga.f7281a;
        $jacocoInit[96] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) gaVar);
        C3461Wa wa = new C3461Wa(this);
        $jacocoInit[97] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wa);
        C3425P p = C3425P.f6802a;
        $jacocoInit[98] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) p);
        C3471Ya ya = new C3471Ya(this);
        $jacocoInit[99] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) ya);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[100] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3887lb lbVar = C3887lb.f7327a;
        C3416Na na = C3416Na.f6793a;
        $jacocoInit[101] = true;
        a.mo3626a((C0129b<? super T>) lbVar, (C0129b<Throwable>) na);
        $jacocoInit[102] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m8001o(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[161] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo14406p(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S gdprDialogClicked = this.view.gdprDialogClicked();
        $jacocoInit[160] = true;
        return gdprDialogClicked;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m7991j(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(action.equals("terms"));
        $jacocoInit[159] = true;
        return valueOf;
    }

    /* renamed from: k */
    public /* synthetic */ void mo14400k(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeNavigator.navigateToTermsAndConditions();
        $jacocoInit[158] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m7995l(String __) {
        $jacocoInit()[157] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m7987h(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(err);
        $jacocoInit[156] = true;
        throw onErrorNotImplementedException;
    }

    public void handleClickOnPrivacyPolicy() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3411Ma ma = C3411Ma.f6788a;
        $jacocoInit[103] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ma);
        C3399Ka ka = new C3399Ka(this);
        $jacocoInit[104] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ka);
        C3421Oa oa = C3421Oa.f6798a;
        $jacocoInit[105] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) oa);
        C3382Ha ha = new C3382Ha(this);
        $jacocoInit[106] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) ha);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[107] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3337Aa aa = C3337Aa.f6723a;
        C3451Ua ua = C3451Ua.f6827a;
        $jacocoInit[108] = true;
        a.mo3626a((C0129b<? super T>) aa, (C0129b<Throwable>) ua);
        $jacocoInit[109] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m7988i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[155] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo14399j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S gdprDialogClicked = this.view.gdprDialogClicked();
        $jacocoInit[154] = true;
        return gdprDialogClicked;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7965a(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(action.equals("privacy"));
        $jacocoInit[153] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14376b(String __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeNavigator.navigateToPrivacyPolicy();
        $jacocoInit[152] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7974c(String __) {
        $jacocoInit()[151] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m7980e(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(err);
        $jacocoInit[150] = true;
        throw onErrorNotImplementedException;
    }

    public void handleClickOnGamesChip() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3415N n = C3415N.f6792a;
        $jacocoInit[110] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) n);
        C3857gb gbVar = new C3857gb(this);
        $jacocoInit[111] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gbVar);
        C3404La la = new C3404La(this);
        $jacocoInit[112] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) la);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[113] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3365Ea ea = C3365Ea.f6746a;
        C3964ya yaVar = C3964ya.f7445a;
        $jacocoInit[114] = true;
        a.mo3626a((C0129b<? super T>) ea, (C0129b<Throwable>) yaVar);
        $jacocoInit[115] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7984g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[149] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo14386h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S gamesChipClicked = this.view.gamesChipClicked();
        $jacocoInit[148] = true;
        return gamesChipClicked;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14383e(Boolean isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isChecked.booleanValue()) {
            $jacocoInit[141] = true;
            this.homeContainerNavigator.loadGamesHomeContent();
            $jacocoInit[142] = true;
            this.chipManager.setCurrentChip(Chip.GAMES);
            $jacocoInit[143] = true;
        } else {
            this.homeContainerNavigator.loadMainHomeContent();
            $jacocoInit[144] = true;
            this.chipManager.setCurrentChip(null);
            $jacocoInit[145] = true;
        }
        this.homeAnalytics.sendChipInteractEvent(Chip.GAMES.getName());
        $jacocoInit[146] = true;
        this.homeAnalytics.sendChipHomeInteractEvent(Chip.GAMES.getName());
        $jacocoInit[147] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m7981f(Boolean __) {
        $jacocoInit()[140] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7978d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(err);
        $jacocoInit[139] = true;
        throw onErrorNotImplementedException;
    }

    public void handleClickOnAppsChip() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3445Ta ta = C3445Ta.f6822a;
        $jacocoInit[116] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ta);
        C3827bb bbVar = new C3827bb(this);
        $jacocoInit[117] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bbVar);
        C3431Qa qa = new C3431Qa(this);
        $jacocoInit[118] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) qa);
        HomeContainerView homeContainerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[119] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) homeContainerView.bindUntilEvent(lifecycleEvent2));
        C3360Da da = C3360Da.f6740a;
        C3875jb jbVar = C3875jb.f7308a;
        $jacocoInit[120] = true;
        a.mo3626a((C0129b<? super T>) da, (C0129b<Throwable>) jbVar);
        $jacocoInit[121] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7979e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[138] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo14385f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appsChipClicked = this.view.appsChipClicked();
        $jacocoInit[137] = true;
        return appsChipClicked;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14377c(Boolean isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isChecked.booleanValue()) {
            $jacocoInit[130] = true;
            this.homeContainerNavigator.loadAppsHomeContent();
            $jacocoInit[131] = true;
            this.chipManager.setCurrentChip(Chip.APPS);
            $jacocoInit[132] = true;
        } else {
            this.homeContainerNavigator.loadMainHomeContent();
            $jacocoInit[133] = true;
            this.chipManager.setCurrentChip(null);
            $jacocoInit[134] = true;
        }
        this.homeAnalytics.sendChipInteractEvent(Chip.APPS.getName());
        $jacocoInit[135] = true;
        this.homeAnalytics.sendChipHomeInteractEvent(Chip.APPS.getName());
        $jacocoInit[136] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7977d(Boolean __) {
        $jacocoInit()[129] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7975c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(err);
        $jacocoInit[128] = true;
        throw onErrorNotImplementedException;
    }

    private C0120S<String> getUserAvatar(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        String userAvatarUrl = null;
        $jacocoInit[122] = true;
        if (account == null) {
            $jacocoInit[123] = true;
        } else if (!account.isLoggedIn()) {
            $jacocoInit[124] = true;
        } else {
            $jacocoInit[125] = true;
            userAvatarUrl = account.getAvatar();
            $jacocoInit[126] = true;
        }
        C0120S<String> c = C0120S.m652c(userAvatarUrl);
        $jacocoInit[127] = true;
        return c;
    }
}
