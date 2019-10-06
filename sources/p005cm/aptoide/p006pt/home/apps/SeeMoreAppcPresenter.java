package p005cm.aptoide.p006pt.home.apps;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.SeeMoreAppcPresenter */
public class SeeMoreAppcPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final CrashReport crashReport;
    private final C0126V ioScheduler;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final SeeMoreAppcManager seeMoreAppcManager;
    private final SeeMoreAppcView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4778547892329176558L, "cm/aptoide/pt/home/apps/SeeMoreAppcPresenter", Opcodes.F2I);
        $jacocoData = probes;
        return probes;
    }

    public SeeMoreAppcPresenter(SeeMoreAppcView view2, C0126V viewScheduler2, C0126V ioScheduler2, CrashReport crashReport2, PermissionManager permissionManager2, PermissionService permissionService2, SeeMoreAppcManager seeMoreAppcManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.viewScheduler = viewScheduler2;
        this.ioScheduler = ioScheduler2;
        this.crashReport = crashReport2;
        this.seeMoreAppcManager = seeMoreAppcManager2;
        this.permissionManager = permissionManager2;
        this.permissionService = permissionService2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleRefreshApps();
        $jacocoInit[1] = true;
        observeAppcUpgradesList();
        $jacocoInit[2] = true;
        getAvailableAppcUpgradesList();
        $jacocoInit[3] = true;
        handleAppcUpgradeAppClick();
        $jacocoInit[4] = true;
        handlePauseAppcUpgradeClick();
        $jacocoInit[5] = true;
        handleCancelAppcUpgradeClick();
        $jacocoInit[6] = true;
        handleResumeAppcUpgradeClick();
        $jacocoInit[7] = true;
    }

    private void handleRefreshApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3800ve veVar = C3800ve.f7212a;
        $jacocoInit[8] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) veVar);
        C3679de deVar = new C3679de(this);
        $jacocoInit[9] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) deVar);
        SeeMoreAppcView seeMoreAppcView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[10] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) seeMoreAppcView.bindUntilEvent(lifecycleEvent2));
        C3522Ee ee = new C3522Ee(this);
        C3721je jeVar = new C3721je(this);
        $jacocoInit[11] = true;
        a.mo3626a((C0129b<? super T>) ee, (C0129b<Throwable>) jeVar);
        $jacocoInit[12] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m8472i(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[136] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[137] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[138] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo14898j(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S refreshApps = this.view.refreshApps();
        C0126V v = this.ioScheduler;
        $jacocoInit[125] = true;
        C0120S a = refreshApps.mo3616a(v);
        C3504Be be = new C3504Be(this);
        $jacocoInit[126] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) be);
        $jacocoInit[127] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[128] = true;
        return g2;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo14884d(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M refreshAllUpdates = this.seeMoreAppcManager.refreshAllUpdates();
        C0126V v = this.viewScheduler;
        $jacocoInit[129] = true;
        C0117M a = refreshAllUpdates.mo3581a(v);
        C3776re reVar = new C3776re(this);
        $jacocoInit[130] = true;
        C0117M a2 = a.mo3582a((C0128a) reVar);
        C3770qe qeVar = new C3770qe(this);
        $jacocoInit[131] = true;
        C0117M a3 = a2.mo3583a((C0129b<? super Throwable>) qeVar);
        $jacocoInit[132] = true;
        return a3;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14869a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[135] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo14893g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[133] = true;
        throwable.printStackTrace();
        $jacocoInit[134] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14879b(Void created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[124] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14889e(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hidePullToRefresh();
        $jacocoInit[122] = true;
        this.crashReport.log(error);
        $jacocoInit[123] = true;
    }

    private void getAvailableAppcUpgradesList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3540He he = C3540He.f6922a;
        $jacocoInit[13] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) he);
        C0126V v = this.ioScheduler;
        $jacocoInit[14] = true;
        C0120S a = d.mo3616a(v);
        C3714ie ieVar = new C3714ie(this);
        $jacocoInit[15] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ieVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[16] = true;
        C0120S a2 = f.mo3616a(v2);
        C3658ae aeVar = new C3658ae(this);
        $jacocoInit[17] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) aeVar);
        SeeMoreAppcView seeMoreAppcView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[18] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) seeMoreAppcView.bindUntilEvent(lifecycleEvent2));
        C3782se seVar = C3782se.f7194a;
        C3552Je je = new C3552Je(this);
        $jacocoInit[19] = true;
        a3.mo3626a((C0129b<? super T>) seVar, (C0129b<Throwable>) je);
        $jacocoInit[20] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8463a(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[119] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[120] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[121] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14875b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appcUpgradesList = this.seeMoreAppcManager.getAppcUpgradesList(false);
        $jacocoInit[118] = true;
        return appcUpgradesList;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14880b(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAppcUpgradesList(list);
        $jacocoInit[117] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8465a(List __) {
        $jacocoInit()[116] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14873a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[115] = true;
    }

    private void observeAppcUpgradesList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3818ye yeVar = C3818ye.f7232a;
        $jacocoInit[21] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) yeVar);
        C0126V v = this.ioScheduler;
        $jacocoInit[22] = true;
        C0120S a = d.mo3616a(v);
        C3546Ie ie = new C3546Ie(this);
        $jacocoInit[23] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ie);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[24] = true;
        C0120S a2 = f.mo3616a(v2);
        C3794ue ueVar = new C3794ue(this);
        $jacocoInit[25] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) ueVar);
        SeeMoreAppcView seeMoreAppcView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[26] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) seeMoreAppcView.bindUntilEvent(lifecycleEvent2));
        C3763pe peVar = C3763pe.f7175a;
        C3693fe feVar = new C3693fe(this);
        $jacocoInit[27] = true;
        a3.mo3626a((C0129b<? super T>) peVar, (C0129b<Throwable>) feVar);
        $jacocoInit[28] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m8475m(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[112] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[113] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[114] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo14900n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appcUpgradeDownloadsList = this.seeMoreAppcManager.getAppcUpgradeDownloadsList();
        $jacocoInit[111] = true;
        return appcUpgradeDownloadsList;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14883c(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAppcUpgradesDownloadList(list);
        $jacocoInit[110] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8468d(List created) {
        $jacocoInit()[109] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo14896h(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[108] = true;
    }

    private void handleAppcUpgradeAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3812xe xeVar = C3812xe.f7225a;
        $jacocoInit[29] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) xeVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[30] = true;
        C0120S a = d.mo3616a(v);
        C3686ee eeVar = new C3686ee(this);
        $jacocoInit[31] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eeVar);
        SeeMoreAppcView seeMoreAppcView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[32] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) seeMoreAppcView.bindUntilEvent(lifecycleEvent2));
        C3646Zd zd = C3646Zd.f7042a;
        C3516De de = new C3516De(this);
        $jacocoInit[33] = true;
        a2.mo3626a((C0129b<? super T>) zd, (C0129b<Throwable>) de);
        $jacocoInit[34] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8466c(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[105] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[106] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[107] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14885d(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S upgradeAppcApp = this.view.upgradeAppcApp();
        C3749ne neVar = new C3749ne(this);
        $jacocoInit[88] = true;
        C0120S f = upgradeAppcApp.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) neVar);
        $jacocoInit[89] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[90] = true;
        return g;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo14897j(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        C3528Fe fe = new C3528Fe(this);
        $jacocoInit[91] = true;
        C0120S f = requestExternalStoragePermission.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fe);
        C3665be beVar = new C3665be(this);
        $jacocoInit[92] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) beVar);
        C3742me meVar = new C3742me(this, app);
        $jacocoInit[93] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) meVar);
        C0126V v = this.ioScheduler;
        $jacocoInit[94] = true;
        C0120S a = b.mo3616a(v);
        C3707he heVar = new C3707he(this, app);
        $jacocoInit[95] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) heVar);
        $jacocoInit[96] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo14881c(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.seeMoreAppcManager.showWarning()) {
            $jacocoInit[100] = true;
            C0120S showRootWarning = this.view.showRootWarning();
            C3558Ke ke = new C3558Ke(this);
            $jacocoInit[101] = true;
            C0120S b = showRootWarning.mo3636b((C0129b<? super T>) ke);
            $jacocoInit[102] = true;
            return b;
        }
        C0120S c = C0120S.m652c(Boolean.valueOf(true));
        $jacocoInit[103] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14872a(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.seeMoreAppcManager.storeRootAnswer(answer.booleanValue());
        $jacocoInit[104] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14876b(Boolean __2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        $jacocoInit[99] = true;
        return requestDownloadAccess;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14871a(App app, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setAppcStandbyState(app);
        $jacocoInit[98] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo14874b(App app, Void __3) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M updateApp = this.seeMoreAppcManager.updateApp(app);
        $jacocoInit[97] = true;
        return updateApp;
    }

    /* renamed from: a */
    static /* synthetic */ void m8464a(Void created) {
        $jacocoInit()[87] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14878b(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[86] = true;
    }

    private void handleResumeAppcUpgradeClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3582Oe oe = C3582Oe.f6965a;
        $jacocoInit[35] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oe);
        C0126V v = this.viewScheduler;
        $jacocoInit[36] = true;
        C0120S a = d.mo3616a(v);
        C3495Ae ae = new C3495Ae(this);
        $jacocoInit[37] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ae);
        C3788te teVar = new C3788te(this);
        $jacocoInit[38] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) teVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[39] = true;
        C0120S a2 = b.mo3616a(v2);
        C3570Me me = new C3570Me(this);
        $jacocoInit[40] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) me);
        SeeMoreAppcView seeMoreAppcView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[41] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) seeMoreAppcView.bindUntilEvent(lifecycleEvent2));
        C3700ge geVar = C3700ge.f7103a;
        C3594Qe qe = new C3594Qe(this);
        $jacocoInit[42] = true;
        a3.mo3626a((C0129b<? super T>) geVar, (C0129b<Throwable>) qe);
        $jacocoInit[43] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m8474k(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[83] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[84] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[85] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo14899l(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(this.view.resumeAppcUpgrade(), this.view.retryAppcUpgrade());
        $jacocoInit[82] = true;
        return b;
    }

    /* renamed from: g */
    public /* synthetic */ void mo14892g(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setAppcStandbyState(app);
        $jacocoInit[81] = true;
    }

    /* renamed from: h */
    public /* synthetic */ C0117M mo14894h(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M resumeUpdate = this.seeMoreAppcManager.resumeUpdate(app);
        $jacocoInit[80] = true;
        return resumeUpdate;
    }

    /* renamed from: i */
    static /* synthetic */ void m8473i(App created) {
        $jacocoInit()[79] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo14891f(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[78] = true;
    }

    private void handleCancelAppcUpgradeClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3576Ne ne = C3576Ne.f6959a;
        $jacocoInit[44] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ne);
        C0126V v = this.viewScheduler;
        $jacocoInit[45] = true;
        C0120S a = d.mo3616a(v);
        C3651_d _dVar = new C3651_d(this);
        $jacocoInit[46] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) _dVar);
        C3564Le le = new C3564Le(this);
        $jacocoInit[47] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) le);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[48] = true;
        C0120S a2 = b.mo3616a(v2);
        C3735le leVar = new C3735le(this);
        $jacocoInit[49] = true;
        C0120S b2 = a2.mo3636b((C0129b<? super T>) leVar);
        SeeMoreAppcView seeMoreAppcView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[50] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) seeMoreAppcView.bindUntilEvent(lifecycleEvent2));
        C3806we weVar = C3806we.f7218a;
        C3588Pe pe = new C3588Pe(this);
        $jacocoInit[51] = true;
        a3.mo3626a((C0129b<? super T>) weVar, (C0129b<Throwable>) pe);
        $jacocoInit[52] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8469e(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[75] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[76] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[77] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo14890f(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelAppcUpgrade = this.view.cancelAppcUpgrade();
        $jacocoInit[74] = true;
        return cancelAppcUpgrade;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14870a(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.removeAppcCanceledAppDownload(app);
        $jacocoInit[73] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14877b(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.seeMoreAppcManager.cancelUpdate(app);
        $jacocoInit[72] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8467c(App created) {
        $jacocoInit()[71] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14882c(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[70] = true;
    }

    private void handlePauseAppcUpgradeClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3534Ge ge = C3534Ge.f6915a;
        $jacocoInit[53] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ge);
        C0126V v = this.viewScheduler;
        $jacocoInit[54] = true;
        C0120S a = d.mo3616a(v);
        C3728ke keVar = new C3728ke(this);
        $jacocoInit[55] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) keVar);
        C3756oe oeVar = new C3756oe(this);
        $jacocoInit[56] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) oeVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[57] = true;
        C0120S a2 = b.mo3616a(v2);
        C3510Ce ce = new C3510Ce(this);
        $jacocoInit[58] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) ce);
        SeeMoreAppcView seeMoreAppcView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[59] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) seeMoreAppcView.bindUntilEvent(lifecycleEvent2));
        C3672ce ceVar = C3672ce.f7072a;
        C3824ze zeVar = new C3824ze(this);
        $jacocoInit[60] = true;
        a3.mo3626a((C0129b<? super T>) ceVar, (C0129b<Throwable>) zeVar);
        $jacocoInit[61] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m8471g(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[67] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[68] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[69] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo14895h(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S pauseAppcUpgrade = this.view.pauseAppcUpgrade();
        $jacocoInit[66] = true;
        return pauseAppcUpgrade;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14886d(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setAppcPausingDownloadState(app);
        $jacocoInit[65] = true;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo14888e(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseUpdate = this.seeMoreAppcManager.pauseUpdate(app);
        $jacocoInit[64] = true;
        return pauseUpdate;
    }

    /* renamed from: f */
    static /* synthetic */ void m8470f(App created) {
        $jacocoInit()[63] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14887d(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[62] = true;
    }
}
