package p005cm.aptoide.p006pt.home.apps;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.apps.App.Type;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.AppsPresenter */
public class AppsPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final AppsManager appsManager;
    private final AppsNavigator appsNavigator;
    private final CrashReport crashReport;
    private final C0126V ioScheduler;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final AppsFragmentView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6385911624218696586L, "cm/aptoide/pt/home/apps/AppsPresenter", 488);
        $jacocoData = probes;
        return probes;
    }

    public AppsPresenter(AppsFragmentView view2, AppsManager appsManager2, C0126V viewScheduler2, C0126V ioScheduler2, CrashReport crashReport2, PermissionManager permissionManager2, PermissionService permissionService2, AptoideAccountManager accountManager2, AppsNavigator appsNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.appsManager = appsManager2;
        this.viewScheduler = viewScheduler2;
        this.ioScheduler = ioScheduler2;
        this.crashReport = crashReport2;
        this.permissionManager = permissionManager2;
        this.permissionService = permissionService2;
        this.accountManager = accountManager2;
        this.appsNavigator = appsNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        getAvailableUpdatesList();
        $jacocoInit[1] = true;
        getAvailableAppcUpgradesList();
        $jacocoInit[2] = true;
        getInstalledApps();
        $jacocoInit[3] = true;
        getDownloads();
        $jacocoInit[4] = true;
        handleAppcUpgradesSeeMoreClick();
        $jacocoInit[5] = true;
        handlePauseDownloadClick();
        $jacocoInit[6] = true;
        handleResumeDownloadClick();
        $jacocoInit[7] = true;
        handleCancelDownloadClick();
        $jacocoInit[8] = true;
        handleInstallAppClick();
        $jacocoInit[9] = true;
        handleUpdateAllClick();
        $jacocoInit[10] = true;
        handleUpdateAppClick();
        $jacocoInit[11] = true;
        handlePauseUpdateClick();
        $jacocoInit[12] = true;
        handleCancelUpdateClick();
        $jacocoInit[13] = true;
        handleResumeUpdateClick();
        $jacocoInit[14] = true;
        handleUpdateCardClick();
        $jacocoInit[15] = true;
        observeUpdatesList();
        $jacocoInit[16] = true;
        observeAppcUpgradesList();
        $jacocoInit[17] = true;
        handleUpdateCardLongClick();
        $jacocoInit[18] = true;
        observeExcludedUpdates();
        $jacocoInit[19] = true;
        observeExcludedAppcUpgrades();
        $jacocoInit[20] = true;
        loadUserImage();
        $jacocoInit[21] = true;
        handleUserAvatarClick();
        $jacocoInit[22] = true;
        observeDownloadInstallations();
        $jacocoInit[23] = true;
        handleBottomNavigationEvents();
        $jacocoInit[24] = true;
        handleRefreshApps();
        $jacocoInit[25] = true;
    }

    private void handleRefreshApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3555Kb kb = C3555Kb.f6937a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kb);
        C3556Kc kc = new C3556Kc(this);
        $jacocoInit[27] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kc);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[28] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3566Ma ma = new C3566Ma(this);
        C3567Mb mb = new C3567Mb(this);
        $jacocoInit[29] = true;
        a.mo3626a((C0129b<? super T>) ma, (C0129b<Throwable>) mb);
        $jacocoInit[30] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m8341y(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[485] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[486] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[487] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo14805z(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S refreshApps = this.view.refreshApps();
        C0126V v = this.ioScheduler;
        $jacocoInit[474] = true;
        C0120S a = refreshApps.mo3616a(v);
        C3704hb hbVar = new C3704hb(this);
        $jacocoInit[475] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) hbVar);
        $jacocoInit[476] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[477] = true;
        return g2;
    }

    /* renamed from: m */
    public /* synthetic */ C0117M mo14777m(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M refreshAllUpdates = this.appsManager.refreshAllUpdates();
        C0126V v = this.viewScheduler;
        $jacocoInit[478] = true;
        C0117M a = refreshAllUpdates.mo3581a(v);
        C3779sb sbVar = new C3779sb(this);
        $jacocoInit[479] = true;
        C0117M a2 = a.mo3582a((C0128a) sbVar);
        C3542Ia ia = new C3542Ia(this);
        $jacocoInit[480] = true;
        C0117M a3 = a2.mo3583a((C0129b<? super Throwable>) ia);
        $jacocoInit[481] = true;
        return a3;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14729a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[484] = true;
    }

    /* renamed from: u */
    public /* synthetic */ void mo14798u(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[482] = true;
        throwable.printStackTrace();
        $jacocoInit[483] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14744b(Void created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[473] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo14774l(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[471] = true;
        this.crashReport.log(error);
        $jacocoInit[472] = true;
    }

    private void observeDownloadInstallations() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3573Nb nb = C3573Nb.f6956a;
        $jacocoInit[31] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nb);
        C0126V v = this.ioScheduler;
        $jacocoInit[32] = true;
        C0120S a = d.mo3616a(v);
        C3798vc vcVar = new C3798vc(this);
        $jacocoInit[33] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vcVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[34] = true;
        C0120S a2 = f.mo3616a(v2);
        C3810xc xcVar = new C3810xc(this);
        $jacocoInit[35] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) xcVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[36] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3525Fb fb = C3525Fb.f6906a;
        C3608Tb tb = new C3608Tb(this);
        $jacocoInit[37] = true;
        a3.mo3626a((C0129b<? super T>) fb, (C0129b<Throwable>) tb);
        $jacocoInit[38] = true;
    }

    /* renamed from: S */
    static /* synthetic */ Boolean m8292S(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[468] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[469] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[470] = true;
        return valueOf;
    }

    /* renamed from: T */
    public /* synthetic */ C0120S mo14723T(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installedDownloads = this.appsManager.getInstalledDownloads();
        $jacocoInit[467] = true;
        return installedDownloads;
    }

    /* renamed from: l */
    public /* synthetic */ void mo14776l(List installedDownloadsList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.removeInstalledDownloads(installedDownloadsList);
        $jacocoInit[466] = true;
    }

    /* renamed from: k */
    static /* synthetic */ void m8327k(List created) {
        $jacocoInit()[465] = true;
    }

    /* renamed from: w */
    public /* synthetic */ void mo14801w(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[464] = true;
    }

    private void handleUpdateCardClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3662bb bbVar = C3662bb.f7061a;
        $jacocoInit[39] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bbVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[40] = true;
        C0120S a = d.mo3616a(v);
        C3592Qc qc = new C3592Qc(this);
        $jacocoInit[41] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qc);
        C3627Wc wc = new C3627Wc(this);
        $jacocoInit[42] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) wc);
        C3513Db db = new C3513Db(this);
        $jacocoInit[43] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) db);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[44] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3761pc pcVar = C3761pc.f7173a;
        C3774rc rcVar = new C3774rc(this);
        $jacocoInit[45] = true;
        a2.mo3626a((C0129b<? super T>) pcVar, (C0129b<Throwable>) rcVar);
        $jacocoInit[46] = true;
    }

    /* renamed from: I */
    static /* synthetic */ Boolean m8287I(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[461] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[462] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[463] = true;
        return valueOf;
    }

    /* renamed from: J */
    public /* synthetic */ C0120S mo14718J(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cardClick = this.view.cardClick();
        $jacocoInit[460] = true;
        return cardClick;
    }

    /* renamed from: i */
    public /* synthetic */ void mo14763i(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        if (app.getType() == Type.DOWNLOAD) {
            $jacocoInit[456] = true;
            this.appsNavigator.navigateToAppView(((DownloadApp) app).getMd5());
            $jacocoInit[457] = true;
        } else {
            this.appsNavigator.navigateToAppView(((UpdateApp) app).getMd5());
            $jacocoInit[458] = true;
        }
        $jacocoInit[459] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo14768j(App __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsManager.setAppViewAnalyticsEvent();
        $jacocoInit[455] = true;
    }

    /* renamed from: k */
    static /* synthetic */ void m8326k(App created) {
        $jacocoInit()[454] = true;
    }

    /* renamed from: q */
    public /* synthetic */ void mo14792q(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[453] = true;
    }

    private void observeExcludedUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3671cd cdVar = C3671cd.f7071a;
        $jacocoInit[47] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) cdVar);
        C0126V v = this.ioScheduler;
        $jacocoInit[48] = true;
        C0120S a = d.mo3616a(v);
        C3768qc qcVar = new C3768qc(this);
        $jacocoInit[49] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qcVar);
        $jacocoInit[50] = true;
        C0120S b = f.mo3628b();
        C3595Ra ra = C3595Ra.f6979a;
        $jacocoInit[51] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) ra);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[52] = true;
        C0120S a2 = d2.mo3616a(v2);
        C3530Ga ga = new C3530Ga(this);
        $jacocoInit[53] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) ga);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[54] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3727kd kdVar = C3727kd.f7135a;
        C3719jc jcVar = new C3719jc(this);
        $jacocoInit[55] = true;
        a3.mo3626a((C0129b<? super T>) kdVar, (C0129b<Throwable>) jcVar);
        $jacocoInit[56] = true;
    }

    /* renamed from: W */
    static /* synthetic */ Boolean m8294W(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[450] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[451] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[452] = true;
        return valueOf;
    }

    /* renamed from: X */
    public /* synthetic */ C0120S mo14725X(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updatesList = this.appsManager.getUpdatesList(true);
        $jacocoInit[449] = true;
        return updatesList;
    }

    /* renamed from: p */
    static /* synthetic */ Boolean m8332p(List excludedUpdatesList) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!excludedUpdatesList.isEmpty()) {
            $jacocoInit[446] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[447] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[448] = true;
        return valueOf;
    }

    /* renamed from: q */
    public /* synthetic */ void mo14793q(List excludedUpdatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.removeExcludedUpdates(excludedUpdatesList);
        $jacocoInit[445] = true;
    }

    /* renamed from: r */
    static /* synthetic */ void m8334r(List created) {
        $jacocoInit()[444] = true;
    }

    /* renamed from: y */
    public /* synthetic */ void mo14804y(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[443] = true;
    }

    private void observeExcludedAppcUpgrades() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3502Bc bc = C3502Bc.f6880a;
        $jacocoInit[57] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bc);
        C0126V v = this.ioScheduler;
        $jacocoInit[58] = true;
        C0120S a = d.mo3616a(v);
        C3793ud udVar = new C3793ud(this);
        $jacocoInit[59] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) udVar);
        $jacocoInit[60] = true;
        C0120S b = f.mo3628b();
        C3792uc ucVar = C3792uc.f7204a;
        $jacocoInit[61] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) ucVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[62] = true;
        C0120S a2 = d2.mo3616a(v2);
        C3586Pc pc = new C3586Pc(this);
        $jacocoInit[63] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) pc);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[64] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3791ub ubVar = C3791ub.f7203a;
        C3718jb jbVar = new C3718jb(this);
        $jacocoInit[65] = true;
        a3.mo3626a((C0129b<? super T>) ubVar, (C0129b<Throwable>) jbVar);
        $jacocoInit[66] = true;
    }

    /* renamed from: U */
    static /* synthetic */ Boolean m8293U(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[440] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[441] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[442] = true;
        return valueOf;
    }

    /* renamed from: V */
    public /* synthetic */ C0120S mo14724V(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appcUpgradesList = this.appsManager.getAppcUpgradesList(true);
        $jacocoInit[439] = true;
        return appcUpgradesList;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m8329m(List excludedUpdatesList) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!excludedUpdatesList.isEmpty()) {
            $jacocoInit[436] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[437] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[438] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ void mo14784n(List excludedUpdatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.removeExcludedAppcUpgrades(excludedUpdatesList);
        $jacocoInit[435] = true;
    }

    /* renamed from: o */
    static /* synthetic */ void m8331o(List created) {
        $jacocoInit()[434] = true;
    }

    /* renamed from: x */
    public /* synthetic */ void mo14803x(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[433] = true;
    }

    private void handleUpdateCardLongClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3786tc tcVar = C3786tc.f7198a;
        $jacocoInit[67] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) tcVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[68] = true;
        C0120S a = d.mo3616a(v);
        C3625Wa wa = new C3625Wa(this);
        $jacocoInit[69] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wa);
        C3720jd jdVar = new C3720jd(this);
        $jacocoInit[70] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) jdVar);
        C3821zb zbVar = new C3821zb(this);
        $jacocoInit[71] = true;
        C0120S f2 = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zbVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[72] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3644Zb zb = C3644Zb.f7040a;
        C3493Ac ac = new C3493Ac(this);
        $jacocoInit[73] = true;
        a2.mo3626a((C0129b<? super T>) zb, (C0129b<Throwable>) ac);
        $jacocoInit[74] = true;
    }

    /* renamed from: K */
    static /* synthetic */ Boolean m8288K(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[430] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[431] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[432] = true;
        return valueOf;
    }

    /* renamed from: L */
    public /* synthetic */ C0120S mo14719L(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updateLongClick = this.view.updateLongClick();
        $jacocoInit[429] = true;
        return updateLongClick;
    }

    /* renamed from: l */
    public /* synthetic */ void mo14773l(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showIgnoreUpdate();
        $jacocoInit[428] = true;
    }

    /* renamed from: m */
    public /* synthetic */ C0120S mo14778m(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S ignoreUpdate = this.view.ignoreUpdate();
        C0126V v = this.ioScheduler;
        $jacocoInit[424] = true;
        C0120S a = ignoreUpdate.mo3616a(v);
        C3706hd hdVar = new C3706hd(this, app);
        $jacocoInit[425] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hdVar);
        $jacocoInit[426] = true;
        return f;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14739b(App app, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S excludeUpdate = this.appsManager.excludeUpdate(app);
        $jacocoInit[427] = true;
        return excludeUpdate;
    }

    /* renamed from: h */
    static /* synthetic */ void m8320h(Void created) {
        $jacocoInit()[423] = true;
    }

    /* renamed from: r */
    public /* synthetic */ void mo14795r(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showUnknownErrorMessage();
        $jacocoInit[421] = true;
        this.crashReport.log(error);
        $jacocoInit[422] = true;
    }

    private void observeUpdatesList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3746nb nbVar = C3746nb.f7155a;
        $jacocoInit[75] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nbVar);
        C3520Ec ec = new C3520Ec(this);
        $jacocoInit[76] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ec);
        C0126V v = this.ioScheduler;
        $jacocoInit[77] = true;
        C0120S a = f.mo3616a(v);
        C3769qd qdVar = new C3769qd(this);
        $jacocoInit[78] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qdVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[79] = true;
        C0120S a2 = f2.mo3616a(v2);
        C3597Rc rc = new C3597Rc(this);
        $jacocoInit[80] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) rc);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[81] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3501Bb bb = C3501Bb.f6879a;
        C3615Uc uc = new C3615Uc(this);
        $jacocoInit[82] = true;
        a3.mo3626a((C0129b<? super T>) bb, (C0129b<Throwable>) uc);
        $jacocoInit[83] = true;
    }

    /* renamed from: Y */
    static /* synthetic */ Boolean m8295Y(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[418] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[419] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[420] = true;
        return valueOf;
    }

    /* renamed from: Z */
    public /* synthetic */ C0120S mo14726Z(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onLoadUpdatesSection = this.view.onLoadUpdatesSection();
        $jacocoInit[417] = true;
        return onLoadUpdatesSection;
    }

    /* renamed from: q */
    public /* synthetic */ C0120S mo14791q(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updateDownloadsList = this.appsManager.getUpdateDownloadsList();
        $jacocoInit[416] = true;
        return updateDownloadsList;
    }

    /* renamed from: s */
    public /* synthetic */ void mo14796s(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showUpdatesDownloadList(list);
        $jacocoInit[415] = true;
    }

    /* renamed from: t */
    static /* synthetic */ void m8338t(List created) {
        $jacocoInit()[414] = true;
    }

    /* renamed from: z */
    public /* synthetic */ void mo14806z(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[413] = true;
    }

    private void observeAppcUpgradesList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3572Na na = C3572Na.f6955a;
        $jacocoInit[84] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) na);
        C3797vb vbVar = new C3797vb(this);
        $jacocoInit[85] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vbVar);
        C0126V v = this.ioScheduler;
        $jacocoInit[86] = true;
        C0120S a = f.mo3616a(v);
        C3603Sc sc = new C3603Sc(this);
        $jacocoInit[87] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sc);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[88] = true;
        C0120S a2 = f2.mo3616a(v2);
        C3614Ub ub = new C3614Ub(this);
        $jacocoInit[89] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) ub);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[90] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3638Yb yb = C3638Yb.f7033a;
        C3621Vc vc = new C3621Vc(this);
        $jacocoInit[91] = true;
        a3.mo3626a((C0129b<? super T>) yb, (C0129b<Throwable>) vc);
        $jacocoInit[92] = true;
    }

    /* renamed from: Q */
    static /* synthetic */ Boolean m8291Q(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[410] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[411] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[412] = true;
        return valueOf;
    }

    /* renamed from: R */
    public /* synthetic */ C0120S mo14722R(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onLoadAppcUpgradesSection = this.view.onLoadAppcUpgradesSection();
        $jacocoInit[409] = true;
        return onLoadAppcUpgradesSection;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo14789p(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appcUpgradeDownloadsList = this.appsManager.getAppcUpgradeDownloadsList();
        $jacocoInit[408] = true;
        return appcUpgradeDownloadsList;
    }

    /* renamed from: i */
    public /* synthetic */ void mo14765i(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAppcUpgradesDownloadList(list);
        $jacocoInit[407] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m8324j(List created) {
        $jacocoInit()[406] = true;
    }

    /* renamed from: v */
    public /* synthetic */ void mo14800v(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[405] = true;
    }

    private void handleResumeUpdateClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3670cc ccVar = C3670cc.f7070a;
        $jacocoInit[93] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ccVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[94] = true;
        C0120S a = d.mo3616a(v);
        C3613Ua ua = new C3613Ua(this);
        $jacocoInit[95] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ua);
        C3645Zc zc = new C3645Zc(this);
        $jacocoInit[96] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) zc);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[97] = true;
        C0120S a2 = b.mo3616a(v2);
        C3677dc dcVar = new C3677dc(this);
        $jacocoInit[98] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) dcVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[99] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3669cb cbVar = C3669cb.f7069a;
        C3531Gb gb = new C3531Gb(this);
        $jacocoInit[100] = true;
        a3.mo3626a((C0129b<? super T>) cbVar, (C0129b<Throwable>) gb);
        $jacocoInit[101] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m8284C(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[402] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[403] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[404] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo14715D(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(this.view.resumeUpdate(), this.view.retryUpdate());
        $jacocoInit[401] = true;
        return b;
    }

    /* renamed from: f */
    public /* synthetic */ C0117M mo14755f(AppClickEventWrapper appClickEventWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M resumeUpdate = this.appsManager.resumeUpdate(appClickEventWrapper.getApp());
        $jacocoInit[400] = true;
        return resumeUpdate;
    }

    /* renamed from: g */
    static /* synthetic */ void m8316g(AppClickEventWrapper created) {
        $jacocoInit()[399] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo14783n(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[398] = true;
    }

    /* access modifiers changed from: private */
    public void setStandbyState(AppClickEventWrapper appClickEventWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClickEventWrapper.getApp();
        $jacocoInit[102] = true;
        if (appClickEventWrapper.isAppcUpgrade()) {
            $jacocoInit[103] = true;
            this.view.setAppcStandbyState(app);
            $jacocoInit[104] = true;
        } else {
            this.view.setStandbyState(app);
            $jacocoInit[105] = true;
        }
        $jacocoInit[106] = true;
    }

    private void handleCancelUpdateClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3561Lb lb = C3561Lb.f6944a;
        $jacocoInit[107] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) lb);
        C0126V v = this.viewScheduler;
        $jacocoInit[108] = true;
        C0120S a = d.mo3616a(v);
        C3580Oc oc = new C3580Oc(this);
        $jacocoInit[109] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oc);
        C3601Sa sa = new C3601Sa(this);
        $jacocoInit[110] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) sa);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[111] = true;
        C0120S a2 = b.mo3616a(v2);
        C3692fd fdVar = new C3692fd(this);
        $jacocoInit[112] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) fdVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[113] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3526Fc fc = C3526Fc.f6907a;
        C3785tb tbVar = new C3785tb(this);
        $jacocoInit[114] = true;
        a3.mo3626a((C0129b<? super T>) fc, (C0129b<Throwable>) tbVar);
        $jacocoInit[115] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m8333q(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[395] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[396] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[397] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo14794r(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelUpdate = this.view.cancelUpdate();
        $jacocoInit[394] = true;
        return cancelUpdate;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14731a(AppClickEventWrapper appClickEventWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsManager.cancelUpdate(appClickEventWrapper.getApp());
        $jacocoInit[393] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8299b(AppClickEventWrapper created) {
        $jacocoInit()[392] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo14762h(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[391] = true;
    }

    /* access modifiers changed from: private */
    public void removeCanceledAppDownload(AppClickEventWrapper appClickEventWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClickEventWrapper.getApp();
        $jacocoInit[116] = true;
        if (appClickEventWrapper.isAppcUpgrade()) {
            $jacocoInit[117] = true;
            this.view.removeAppcCanceledAppDownload(app);
            $jacocoInit[118] = true;
        } else {
            this.view.removeCanceledAppDownload(app);
            $jacocoInit[119] = true;
        }
        $jacocoInit[120] = true;
    }

    private void handlePauseUpdateClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3620Vb vb = C3620Vb.f7011a;
        $jacocoInit[121] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) vb);
        C0126V v = this.viewScheduler;
        $jacocoInit[122] = true;
        C0120S a = d.mo3616a(v);
        C3787td tdVar = new C3787td(this);
        $jacocoInit[123] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tdVar);
        C3732lb lbVar = new C3732lb(this);
        $jacocoInit[124] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) lbVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[125] = true;
        C0120S a2 = b.mo3616a(v2);
        C3705hc hcVar = new C3705hc(this);
        $jacocoInit[126] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) hcVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[127] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3584Pa pa = C3584Pa.f6968a;
        C3733lc lcVar = new C3733lc(this);
        $jacocoInit[128] = true;
        a3.mo3626a((C0129b<? super T>) pa, (C0129b<Throwable>) lcVar);
        $jacocoInit[129] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m8340w(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[388] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[389] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[390] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo14802x(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S pauseUpdate = this.view.pauseUpdate();
        $jacocoInit[387] = true;
        return pauseUpdate;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14745c(AppClickEventWrapper appClickEventWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClickEventWrapper.getApp();
        $jacocoInit[382] = true;
        if (appClickEventWrapper.isAppcUpgrade()) {
            $jacocoInit[383] = true;
            this.view.setAppcPausingDownloadState(app);
            $jacocoInit[384] = true;
        } else {
            this.view.setPausingDownloadState(app);
            $jacocoInit[385] = true;
        }
        $jacocoInit[386] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo14749d(AppClickEventWrapper appClickEventWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseUpdate = this.appsManager.pauseUpdate(appClickEventWrapper.getApp());
        $jacocoInit[381] = true;
        return pauseUpdate;
    }

    /* renamed from: e */
    static /* synthetic */ void m8310e(AppClickEventWrapper created) {
        $jacocoInit()[380] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo14770k(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[379] = true;
    }

    private void handleUpdateAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3748nd ndVar = C3748nd.f7157a;
        $jacocoInit[130] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ndVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[131] = true;
        C0120S a = d.mo3616a(v);
        C3655ab abVar = new C3655ab(this);
        $jacocoInit[132] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) abVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[133] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3537Hb hb = C3537Hb.f6919a;
        C3664bd bdVar = new C3664bd(this);
        $jacocoInit[134] = true;
        a2.mo3626a((C0129b<? super T>) hb, (C0129b<Throwable>) bdVar);
        $jacocoInit[135] = true;
    }

    /* renamed from: G */
    static /* synthetic */ Boolean m8286G(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[376] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[377] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[378] = true;
        return valueOf;
    }

    /* renamed from: H */
    public /* synthetic */ C0120S mo14717H(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updateApp = this.view.updateApp();
        C3554Ka ka = new C3554Ka(this);
        $jacocoInit[357] = true;
        C0120S f = updateApp.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ka);
        $jacocoInit[358] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[359] = true;
        return g;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo14760h(AppClickEventWrapper appClickEventWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        C3697gb gbVar = new C3697gb(this);
        $jacocoInit[360] = true;
        C0120S f = requestExternalStoragePermission.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gbVar);
        C3799vd vdVar = new C3799vd(this);
        $jacocoInit[361] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vdVar);
        C3536Ha ha = new C3536Ha(this, appClickEventWrapper);
        $jacocoInit[362] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) ha);
        C0126V v = this.ioScheduler;
        $jacocoInit[363] = true;
        C0120S a = b.mo3616a(v);
        C3713id idVar = new C3713id(this, appClickEventWrapper);
        $jacocoInit[364] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) idVar);
        $jacocoInit[365] = true;
        return g;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo14782n(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.appsManager.showWarning()) {
            $jacocoInit[371] = true;
            C0120S showRootWarning = this.view.showRootWarning();
            C3602Sb sb = new C3602Sb(this);
            $jacocoInit[372] = true;
            C0120S b = showRootWarning.mo3636b((C0129b<? super T>) sb);
            $jacocoInit[373] = true;
            return b;
        }
        C0120S c = C0120S.m652c(Boolean.valueOf(true));
        $jacocoInit[374] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14733a(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsManager.storeRootAnswer(answer.booleanValue());
        $jacocoInit[375] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14741b(Boolean __2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        $jacocoInit[370] = true;
        return requestDownloadAccess;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14732a(AppClickEventWrapper appClickEventWrapper, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        setStandbyState(appClickEventWrapper);
        $jacocoInit[369] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo14738b(AppClickEventWrapper appClickEventWrapper, Void __3) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsManager appsManager2 = this.appsManager;
        App app = appClickEventWrapper.getApp();
        $jacocoInit[366] = true;
        boolean isAppcUpgrade = appClickEventWrapper.isAppcUpgrade();
        $jacocoInit[367] = true;
        C0117M updateApp = appsManager2.updateApp(app, isAppcUpgrade);
        $jacocoInit[368] = true;
        return updateApp;
    }

    /* renamed from: g */
    static /* synthetic */ void m8318g(Void created) {
        $jacocoInit()[356] = true;
    }

    /* renamed from: p */
    public /* synthetic */ void mo14790p(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[355] = true;
    }

    private void handleBottomNavigationEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3739mb mbVar = C3739mb.f7147a;
        $jacocoInit[136] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mbVar);
        C3514Dc dc = new C3514Dc(this);
        $jacocoInit[137] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dc);
        C0126V v = this.viewScheduler;
        $jacocoInit[138] = true;
        C0120S a = f.mo3616a(v);
        C3656ac acVar = new C3656ac(this);
        $jacocoInit[139] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) acVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[140] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3524Fa fa = C3524Fa.f6905a;
        C3568Mc mc = C3568Mc.f6951a;
        $jacocoInit[141] = true;
        a2.mo3626a((C0129b<? super T>) fa, (C0129b<Throwable>) mc);
        $jacocoInit[142] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m8328m(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[354] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo14781n(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S bottomNavigation = this.appsNavigator.bottomNavigation();
        $jacocoInit[353] = true;
        return bottomNavigation;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14734a(Integer navigated) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.scrollToTop();
        $jacocoInit[352] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8301b(Integer __) {
        $jacocoInit()[351] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m8313f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[350] = true;
        throw onErrorNotImplementedException;
    }

    private void handleUpdateAllClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3578Oa oa = C3578Oa.f6961a;
        $jacocoInit[143] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oa);
        C0126V v = this.viewScheduler;
        $jacocoInit[144] = true;
        C0120S a = d.mo3616a(v);
        C3740mc mcVar = new C3740mc(this);
        $jacocoInit[145] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mcVar);
        C3754oc ocVar = new C3754oc(this);
        $jacocoInit[146] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ocVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[147] = true;
        C0120S a2 = b.mo3616a(v2);
        C3691fc fcVar = new C3691fc(this);
        $jacocoInit[148] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) fcVar);
        C0126V v3 = this.viewScheduler;
        $jacocoInit[149] = true;
        C0120S a3 = g.mo3616a(v3);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[150] = true;
        C0120S a4 = a3.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3698gc gcVar = C3698gc.f7101a;
        C3562Lc lc = new C3562Lc(this);
        $jacocoInit[151] = true;
        a4.mo3626a((C0129b<? super T>) gcVar, (C0129b<Throwable>) lc);
        $jacocoInit[152] = true;
    }

    /* renamed from: E */
    static /* synthetic */ Boolean m8285E(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[347] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[348] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[349] = true;
        return valueOf;
    }

    /* renamed from: F */
    public /* synthetic */ C0120S mo14716F(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updateAll = this.view.updateAll();
        C3585Pb pb = new C3585Pb(this);
        $jacocoInit[343] = true;
        C0120S f = updateAll.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pb);
        $jacocoInit[344] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[345] = true;
        return g;
    }

    /* renamed from: o */
    public /* synthetic */ C0120S mo14785o(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[346] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14751d(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showIndeterminateAllUpdates();
        $jacocoInit[342] = true;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo14752e(Void app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M updateAll = this.appsManager.updateAll();
        $jacocoInit[341] = true;
        return updateAll;
    }

    /* renamed from: f */
    static /* synthetic */ void m8314f(Void created) {
        $jacocoInit()[340] = true;
    }

    /* renamed from: o */
    public /* synthetic */ void mo14787o(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[339] = true;
    }

    private void handleInstallAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3519Eb eb = C3519Eb.f6900a;
        $jacocoInit[153] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) eb);
        C0126V v = this.viewScheduler;
        $jacocoInit[154] = true;
        C0120S a = d.mo3616a(v);
        C3753ob obVar = new C3753ob(this);
        $jacocoInit[155] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) obVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[156] = true;
        C0120S a2 = f.mo3616a(v2);
        C3762pd pdVar = new C3762pd(this);
        $jacocoInit[157] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) pdVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[158] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3816yc ycVar = C3816yc.f7229a;
        C3643Za za = new C3643Za(this);
        $jacocoInit[159] = true;
        a3.mo3626a((C0129b<? super T>) ycVar, (C0129b<Throwable>) za);
        $jacocoInit[160] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m8335s(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[336] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[337] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[338] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo14797t(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installApp = this.view.installApp();
        $jacocoInit[335] = true;
        return installApp;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo14748d(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M installApp = this.appsManager.installApp(app);
        $jacocoInit[334] = true;
        return installApp;
    }

    /* renamed from: e */
    static /* synthetic */ void m8309e(App created) {
        $jacocoInit()[333] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo14764i(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[332] = true;
    }

    private void handleCancelDownloadClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3712ic icVar = C3712ic.f7118a;
        $jacocoInit[161] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) icVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[162] = true;
        C0120S a = d.mo3616a(v);
        C3633Xc xc = new C3633Xc(this);
        $jacocoInit[163] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xc);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[164] = true;
        C0120S a2 = f.mo3616a(v2);
        C3548Ja ja = new C3548Ja(this);
        $jacocoInit[165] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) ja);
        C0126V v3 = this.viewScheduler;
        $jacocoInit[166] = true;
        C0120S a3 = b.mo3616a(v3);
        C3684ec ecVar = new C3684ec(this);
        $jacocoInit[167] = true;
        C0120S b2 = a3.mo3636b((C0129b<? super T>) ecVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[168] = true;
        C0120S a4 = b2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3549Jb jb = C3549Jb.f6931a;
        C3648_a _aVar = new C3648_a(this);
        $jacocoInit[169] = true;
        a4.mo3626a((C0129b<? super T>) jb, (C0129b<Throwable>) _aVar);
        $jacocoInit[170] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m8330o(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[329] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[330] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[331] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo14788p(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelDownload = this.view.cancelDownload();
        $jacocoInit[328] = true;
        return cancelDownload;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14730a(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsManager.cancelDownload(app);
        $jacocoInit[327] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14742b(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.removeCanceledAppDownload(app);
        $jacocoInit[326] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8305c(App created) {
        $jacocoInit()[325] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo14758g(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[324] = true;
    }

    private void handleResumeDownloadClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3676db dbVar = C3676db.f7078a;
        $jacocoInit[171] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) dbVar);
        C3550Jc jc = new C3550Jc(this);
        $jacocoInit[172] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jc);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[173] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3734ld ldVar = C3734ld.f7142a;
        C3822zc zcVar = new C3822zc(this);
        $jacocoInit[174] = true;
        a.mo3626a((C0129b<? super T>) ldVar, (C0129b<Throwable>) zcVar);
        $jacocoInit[175] = true;
    }

    /* renamed from: B */
    static /* synthetic */ Boolean m8283B(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[321] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[322] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[323] = true;
        return valueOf;
    }

    /* renamed from: A */
    public /* synthetic */ C0120S mo14714A(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(this.view.resumeDownload(), this.view.retryDownload());
        C3538Hc hc = new C3538Hc(this);
        $jacocoInit[309] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) hc);
        C0126V v = this.viewScheduler;
        $jacocoInit[310] = true;
        C0120S a = b2.mo3616a(v);
        C3637Ya ya = new C3637Ya(this);
        $jacocoInit[311] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ya);
        $jacocoInit[312] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[313] = true;
        return g;
    }

    /* renamed from: o */
    public /* synthetic */ void mo14786o(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setStandbyState(app);
        $jacocoInit[320] = true;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo14780n(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        C3560La la = new C3560La(this);
        $jacocoInit[314] = true;
        C0120S f = requestExternalStoragePermission.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) la);
        C0126V v = this.ioScheduler;
        $jacocoInit[315] = true;
        C0120S a = f.mo3616a(v);
        C3507Cb cb = new C3507Cb(this, app);
        $jacocoInit[316] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) cb);
        $jacocoInit[317] = true;
        return g;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo14767j(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        $jacocoInit[319] = true;
        return requestDownloadAccess;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo14727a(App app, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M resumeDownload = this.appsManager.resumeDownload(app);
        $jacocoInit[318] = true;
        return resumeDownload;
    }

    /* renamed from: c */
    static /* synthetic */ void m8306c(Void created) {
        $jacocoInit()[308] = true;
    }

    /* renamed from: m */
    public /* synthetic */ void mo14779m(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[307] = true;
    }

    private void handlePauseDownloadClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3781sd sdVar = C3781sd.f7193a;
        $jacocoInit[176] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) sdVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[177] = true;
        C0120S a = d.mo3616a(v);
        C3626Wb wb = new C3626Wb(this);
        $jacocoInit[178] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wb);
        C3492Ab ab = new C3492Ab(this);
        $jacocoInit[179] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ab);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[180] = true;
        C0120S a2 = b.mo3616a(v2);
        C3725kb kbVar = new C3725kb(this);
        $jacocoInit[181] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) kbVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[182] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3803wb wbVar = C3803wb.f7215a;
        C3543Ib ib = new C3543Ib(this);
        $jacocoInit[183] = true;
        a3.mo3626a((C0129b<? super T>) wbVar, (C0129b<Throwable>) ib);
        $jacocoInit[184] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m8339u(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[304] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[305] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[306] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo14799v(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S pauseDownload = this.view.pauseDownload();
        $jacocoInit[303] = true;
        return pauseDownload;
    }

    /* renamed from: f */
    public /* synthetic */ void mo14756f(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setPausingDownloadState(app);
        $jacocoInit[302] = true;
    }

    /* renamed from: g */
    public /* synthetic */ C0117M mo14757g(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseDownload = this.appsManager.pauseDownload(app);
        $jacocoInit[301] = true;
        return pauseDownload;
    }

    /* renamed from: h */
    static /* synthetic */ void m8319h(App created) {
        $jacocoInit()[300] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo14769j(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[299] = true;
    }

    private void getDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3767qb qbVar = C3767qb.f7179a;
        $jacocoInit[185] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) qbVar);
        C0126V v = this.ioScheduler;
        $jacocoInit[186] = true;
        C0120S a = d.mo3616a(v);
        C3726kc kcVar = C3726kc.f7134a;
        $jacocoInit[187] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) kcVar);
        C3663bc bcVar = new C3663bc(this);
        $jacocoInit[188] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bcVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[189] = true;
        C0120S a2 = f.mo3616a(v2);
        C3574Nc nc = new C3574Nc(this);
        $jacocoInit[190] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) nc);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[191] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3544Ic ic = C3544Ic.f6926a;
        C3518Ea ea = new C3518Ea(this);
        $jacocoInit[192] = true;
        a3.mo3626a((C0129b<? super T>) ic, (C0129b<Throwable>) ea);
        $jacocoInit[193] = true;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m8312f(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[296] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[297] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[298] = true;
        return valueOf;
    }

    /* renamed from: g */
    static /* synthetic */ void m8317g(LifecycleEvent installs) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[294] = true;
        instance.mo2136d("Apps", "getting download apps");
        $jacocoInit[295] = true;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo14761h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S downloadApps = this.appsManager.getDownloadApps();
        $jacocoInit[293] = true;
        return downloadApps;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14754e(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showDownloadsList(list);
        $jacocoInit[292] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m8315f(List __) {
        $jacocoInit()[291] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14746c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[290] = true;
    }

    private void getInstalledApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3711ib ibVar = C3711ib.f7117a;
        $jacocoInit[194] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ibVar);
        C0126V v = this.ioScheduler;
        $jacocoInit[195] = true;
        C0120S a = d.mo3616a(v);
        C3631Xa xa = new C3631Xa(this);
        $jacocoInit[196] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xa);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[197] = true;
        C0120S a2 = f.mo3616a(v2);
        C3760pb pbVar = new C3760pb(this);
        $jacocoInit[198] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) pbVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[199] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3649_b _bVar = C3649_b.f7046a;
        C3650_c _cVar = new C3650_c(this);
        $jacocoInit[200] = true;
        a3.mo3626a((C0129b<? super T>) _bVar, (C0129b<Throwable>) _cVar);
        $jacocoInit[201] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m8322i(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[287] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[288] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[289] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo14766j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installedApps = this.appsManager.getInstalledApps();
        $jacocoInit[286] = true;
        return installedApps;
    }

    /* renamed from: g */
    public /* synthetic */ void mo14759g(List installedApps) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showInstalledApps(installedApps);
        $jacocoInit[285] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m8321h(List __) {
        $jacocoInit()[284] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14750d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[283] = true;
    }

    private void getAvailableUpdatesList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3591Qb qb = C3591Qb.f6975a;
        $jacocoInit[202] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) qb);
        C0126V v = this.ioScheduler;
        $jacocoInit[203] = true;
        C0120S a = d.mo3616a(v);
        C3609Tc tc = C3609Tc.f6997a;
        $jacocoInit[204] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) tc);
        C3805wd wdVar = new C3805wd(this);
        $jacocoInit[205] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wdVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[206] = true;
        C0120S a2 = f.mo3616a(v2);
        C3780sc scVar = new C3780sc(this);
        $jacocoInit[207] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) scVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[208] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3607Ta ta = C3607Ta.f6995a;
        C3804wc wcVar = new C3804wc(this);
        $jacocoInit[209] = true;
        a3.mo3626a((C0129b<? super T>) ta, (C0129b<Throwable>) wcVar);
        $jacocoInit[210] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8304c(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[280] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[281] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[282] = true;
        return valueOf;
    }

    /* renamed from: d */
    static /* synthetic */ void m8307d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[278] = true;
        instance.mo2136d("Apps", "going to get available updates list");
        $jacocoInit[279] = true;
    }

    /* renamed from: e */
    public /* synthetic */ C0120S mo14753e(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updatesList = this.appsManager.getUpdatesList(false);
        $jacocoInit[277] = true;
        return updatesList;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14747c(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showUpdatesList(list);
        $jacocoInit[276] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8308d(List __) {
        $jacocoInit()[275] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14743b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[274] = true;
    }

    private void getAvailableAppcUpgradesList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3632Xb xb = C3632Xb.f7025a;
        $jacocoInit[211] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) xb);
        C0126V v = this.ioScheduler;
        $jacocoInit[212] = true;
        C0120S a = d.mo3616a(v);
        C3508Cc cc = new C3508Cc(this);
        $jacocoInit[213] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cc);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[214] = true;
        C0120S a2 = f.mo3616a(v2);
        C3741md mdVar = new C3741md(this);
        $jacocoInit[215] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) mdVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[216] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3699gd gdVar = C3699gd.f7102a;
        C3773rb rbVar = new C3773rb(this);
        $jacocoInit[217] = true;
        a3.mo3626a((C0129b<? super T>) gdVar, (C0129b<Throwable>) rbVar);
        $jacocoInit[218] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8296a(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[271] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[272] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[273] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14740b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appcUpgradesList = this.appsManager.getAppcUpgradesList(false);
        $jacocoInit[270] = true;
        return appcUpgradesList;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14737a(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAppcUpgradesList(list);
        $jacocoInit[269] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8303b(List __) {
        $jacocoInit()[268] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14736a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[267] = true;
    }

    private void handleAppcUpgradesSeeMoreClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3590Qa qa = C3590Qa.f6974a;
        $jacocoInit[219] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) qa);
        C3657ad adVar = new C3657ad(this);
        $jacocoInit[220] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) adVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[221] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3639Yc yc = C3639Yc.f7034a;
        C3683eb ebVar = C3683eb.f7086a;
        $jacocoInit[222] = true;
        a.mo3626a((C0129b<? super T>) yc, (C0129b<Throwable>) ebVar);
        $jacocoInit[223] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m8325k(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[266] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo14772l(LifecycleEvent list) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S moreAppcClick = this.view.moreAppcClick();
        C3809xb xbVar = new C3809xb(this);
        $jacocoInit[262] = true;
        C0120S b = moreAppcClick.mo3636b((C0129b<? super T>) xbVar);
        $jacocoInit[263] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[264] = true;
        return g;
    }

    /* renamed from: k */
    public /* synthetic */ void mo14771k(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsNavigator.navigateToSeeMoreAppc();
        $jacocoInit[265] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8298a(Void __) {
        $jacocoInit()[261] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m8311e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[260] = true;
        throw onErrorNotImplementedException;
    }

    private void loadUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3775rd rdVar = C3775rd.f7187a;
        $jacocoInit[224] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) rdVar);
        C3678dd ddVar = new C3678dd(this);
        $jacocoInit[225] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ddVar);
        C3690fb fbVar = new C3690fb(this);
        $jacocoInit[226] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fbVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[227] = true;
        C0120S a = f2.mo3616a(v);
        C3747nc ncVar = new C3747nc(this);
        $jacocoInit[228] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) ncVar);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[229] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3755od odVar = C3755od.f7165a;
        C3532Gc gc = C3532Gc.f6913a;
        $jacocoInit[230] = true;
        a2.mo3626a((C0129b<? super T>) odVar, (C0129b<Throwable>) gc);
        $jacocoInit[231] = true;
    }

    /* renamed from: O */
    static /* synthetic */ Boolean m8290O(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[259] = true;
        return valueOf;
    }

    /* renamed from: P */
    public /* synthetic */ C0120S mo14721P(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[258] = true;
        return accountStatus;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14728a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S userAvatar = getUserAvatar(account);
        $jacocoInit[257] = true;
        return userAvatar;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14735a(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (userAvatarUrl != null) {
            $jacocoInit[253] = true;
            this.view.setUserImage(userAvatarUrl);
            $jacocoInit[254] = true;
        } else {
            this.view.setDefaultUserImage();
            $jacocoInit[255] = true;
        }
        this.view.showAvatar();
        $jacocoInit[256] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8302b(String __) {
        $jacocoInit()[252] = true;
    }

    /* renamed from: t */
    static /* synthetic */ void m8337t(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[251] = true;
        throw onErrorNotImplementedException;
    }

    private void handleUserAvatarClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3596Rb rb = C3596Rb.f6980a;
        $jacocoInit[232] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) rb);
        C3619Va va = new C3619Va(this);
        $jacocoInit[233] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) va);
        AppsFragmentView appsFragmentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[234] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) appsFragmentView.bindUntilEvent(lifecycleEvent2));
        C3579Ob ob = C3579Ob.f6962a;
        C3685ed edVar = C3685ed.f7088a;
        $jacocoInit[235] = true;
        a.mo3626a((C0129b<? super T>) ob, (C0129b<Throwable>) edVar);
        $jacocoInit[236] = true;
    }

    /* renamed from: M */
    static /* synthetic */ Boolean m8289M(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[250] = true;
        return valueOf;
    }

    /* renamed from: N */
    public /* synthetic */ C0120S mo14720N(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S imageClick = this.view.imageClick();
        C0126V v = this.viewScheduler;
        $jacocoInit[245] = true;
        C0120S a = imageClick.mo3616a(v);
        C3815yb ybVar = new C3815yb(this);
        $jacocoInit[246] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) ybVar);
        $jacocoInit[247] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[248] = true;
        return g;
    }

    /* renamed from: l */
    public /* synthetic */ void mo14775l(Void account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsNavigator.navigateToMyAccount();
        $jacocoInit[249] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m8323i(Void __) {
        $jacocoInit()[244] = true;
    }

    /* renamed from: s */
    static /* synthetic */ void m8336s(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[243] = true;
        throw onErrorNotImplementedException;
    }

    private C0120S<String> getUserAvatar(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        String userAvatarUrl = null;
        $jacocoInit[237] = true;
        if (account == null) {
            $jacocoInit[238] = true;
        } else if (!account.isLoggedIn()) {
            $jacocoInit[239] = true;
        } else {
            $jacocoInit[240] = true;
            userAvatarUrl = account.getAvatar();
            $jacocoInit[241] = true;
        }
        C0120S<String> c = C0120S.m652c(userAvatarUrl);
        $jacocoInit[242] = true;
        return c;
    }
}
