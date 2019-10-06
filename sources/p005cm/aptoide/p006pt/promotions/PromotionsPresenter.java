package p005cm.aptoide.p006pt.promotions;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.promotions.PromotionsPresenter */
public class PromotionsPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private String promotionId;
    private final String promotionType;
    private final PromotionsAnalytics promotionsAnalytics;
    private final PromotionsManager promotionsManager;
    private final PromotionsNavigator promotionsNavigator;
    private final PromotionsView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3155941853757803070L, "cm/aptoide/pt/promotions/PromotionsPresenter", 246);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsPresenter(PromotionsView view2, PromotionsManager promotionsManager2, PermissionManager permissionManager2, PermissionService permissionService2, C0126V viewScheduler2, PromotionsAnalytics promotionsAnalytics2, PromotionsNavigator promotionsNavigator2, String promotionType2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.promotionsManager = promotionsManager2;
        this.permissionManager = permissionManager2;
        this.permissionService = permissionService2;
        this.viewScheduler = viewScheduler2;
        this.promotionsAnalytics = promotionsAnalytics2;
        this.promotionsNavigator = promotionsNavigator2;
        this.promotionType = promotionType2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        getPromotionApps();
        $jacocoInit[1] = true;
        installButtonClick();
        $jacocoInit[2] = true;
        pauseDownload();
        $jacocoInit[3] = true;
        cancelDownload();
        $jacocoInit[4] = true;
        resumeDownload();
        $jacocoInit[5] = true;
        claimApp();
        $jacocoInit[6] = true;
        handlePromotionClaimResult();
        $jacocoInit[7] = true;
        handleRetryClick();
        $jacocoInit[8] = true;
        handlePromotionOverDialogClick();
        $jacocoInit[9] = true;
    }

    private void claimApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4577rb rbVar = C4577rb.f8206a;
        $jacocoInit[10] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) rbVar);
        C4597wb wbVar = new C4597wb(this);
        $jacocoInit[11] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wbVar);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[12] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4521db dbVar = C4521db.f8138a;
        C4565ob obVar = C4565ob.f8191a;
        $jacocoInit[13] = true;
        a.mo3626a((C0129b<? super T>) dbVar, (C0129b<Throwable>) obVar);
        $jacocoInit[14] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8908c(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[243] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[244] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[245] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo15768d(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S claimAppClick = this.view.claimAppClick();
        C4557mb mbVar = new C4557mb(this);
        $jacocoInit[236] = true;
        C0120S b = claimAppClick.mo3636b((C0129b<? super T>) mbVar);
        C4498Xb xb = new C4498Xb(this);
        $jacocoInit[237] = true;
        C0120S i = b.mo3668i(xb);
        $jacocoInit[238] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[239] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15765c(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsAnalytics promotionsAnalytics2 = this.promotionsAnalytics;
        $jacocoInit[240] = true;
        String packageName = promotionViewApp.getPackageName();
        float appcValue = promotionViewApp.getAppcValue();
        $jacocoInit[241] = true;
        promotionsAnalytics2.sendPromotionsAppInteractClaimEvent(packageName, appcValue);
        $jacocoInit[242] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8902a(String created) {
        $jacocoInit()[235] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8907b(Throwable error) {
        $jacocoInit()[234] = true;
    }

    /* access modifiers changed from: private */
    public Single<? extends String> showClaimView(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.promotionId;
        if (str != null) {
            $jacocoInit[15] = true;
            Single a = Single.m734a(str);
            C4465Nb nb = new C4465Nb(this, promotionViewApp);
            $jacocoInit[16] = true;
            Single<? extends String> b = a.mo3695b((C0129b<? super T>) nb);
            $jacocoInit[17] = true;
            return b;
        }
        Single promotionsModel = this.promotionsManager.getPromotionsModel(this.promotionType);
        C4507a aVar = C4507a.f8123a;
        $jacocoInit[18] = true;
        Single d = promotionsModel.mo3698d(aVar);
        C4434Db db = new C4434Db(this, promotionViewApp);
        $jacocoInit[19] = true;
        Single<? extends String> b2 = d.mo3695b((C0129b<? super T>) db);
        $jacocoInit[20] = true;
        return b2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15761b(PromotionViewApp promotionViewApp, String promotionsModel) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsNavigator promotionsNavigator2 = this.promotionsNavigator;
        $jacocoInit[231] = true;
        String packageName = promotionViewApp.getPackageName();
        String str = this.promotionId;
        $jacocoInit[232] = true;
        promotionsNavigator2.navigateToClaimDialog(packageName, str);
        $jacocoInit[233] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15766c(PromotionViewApp promotionViewApp, String promotionsModel) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsNavigator promotionsNavigator2 = this.promotionsNavigator;
        $jacocoInit[228] = true;
        String packageName = promotionViewApp.getPackageName();
        String str = this.promotionId;
        $jacocoInit[229] = true;
        promotionsNavigator2.navigateToClaimDialog(packageName, str);
        $jacocoInit[230] = true;
    }

    private void resumeDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4513bb bbVar = C4513bb.f8130a;
        $jacocoInit[21] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bbVar);
        C4426Bb bb = new C4426Bb(this);
        $jacocoInit[22] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bb);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[23] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4530fc fcVar = C4530fc.f8149a;
        C4586tc tcVar = C4586tc.f8215a;
        $jacocoInit[24] = true;
        a.mo3626a((C0129b<? super T>) fcVar, (C0129b<Throwable>) tcVar);
        $jacocoInit[25] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m8930s(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[225] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[226] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[227] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo15786r(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S resumeDownload = this.view.resumeDownload();
        C4538hc hcVar = new C4538hc(this);
        $jacocoInit[215] = true;
        C0120S f = resumeDownload.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hcVar);
        $jacocoInit[216] = true;
        return f;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo15769d(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        C4558mc mcVar = new C4558mc(this);
        $jacocoInit[217] = true;
        C0120S f = requestDownloadAccess.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mcVar);
        C4537hb hbVar = new C4537hb(this, promotionViewApp);
        $jacocoInit[218] = true;
        C0120S g = f.mo3663g((C0132p<? super T, ? extends C0117M>) hbVar);
        $jacocoInit[219] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[220] = true;
        return g2;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo15775f(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[224] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo15756b(PromotionViewApp promotionViewApp, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsManager promotionsManager2 = this.promotionsManager;
        String md5 = promotionViewApp.getMd5();
        $jacocoInit[221] = true;
        String packageName = promotionViewApp.getPackageName();
        long appId = promotionViewApp.getAppId();
        $jacocoInit[222] = true;
        C0117M resumeDownload = promotionsManager2.resumeDownload(md5, packageName, appId);
        $jacocoInit[223] = true;
        return resumeDownload;
    }

    /* renamed from: g */
    static /* synthetic */ void m8919g(Void created) {
        $jacocoInit()[214] = true;
    }

    /* renamed from: k */
    static /* synthetic */ void m8926k(Throwable error) {
        $jacocoInit()[213] = true;
    }

    private void cancelDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4526ec ecVar = C4526ec.f8144a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ecVar);
        C4553lb lbVar = new C4553lb(this);
        $jacocoInit[27] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lbVar);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[28] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4468Ob ob = C4468Ob.f8078a;
        C4594vc vcVar = C4594vc.f8224a;
        $jacocoInit[29] = true;
        a.mo3626a((C0129b<? super T>) ob, (C0129b<Throwable>) vcVar);
        $jacocoInit[30] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8895a(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[210] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[211] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[212] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15757b(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelDownload = this.view.cancelDownload();
        C4504Zb zb = new C4504Zb(this);
        $jacocoInit[204] = true;
        C0120S g = cancelDownload.mo3663g((C0132p<? super T, ? extends C0117M>) zb);
        $jacocoInit[205] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[206] = true;
        return g2;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo15771e(PromotionViewApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsManager promotionsManager2 = this.promotionsManager;
        String md5 = app.getMd5();
        String packageName = app.getPackageName();
        $jacocoInit[207] = true;
        int versionCode = app.getVersionCode();
        $jacocoInit[208] = true;
        C0117M cancelDownload = promotionsManager2.cancelDownload(md5, packageName, versionCode);
        $jacocoInit[209] = true;
        return cancelDownload;
    }

    /* renamed from: a */
    static /* synthetic */ void m8901a(PromotionViewApp created) {
        $jacocoInit()[203] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8903a(Throwable error) {
        $jacocoInit()[202] = true;
    }

    private void pauseDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4441Fb fb = C4441Fb.f8043a;
        $jacocoInit[31] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) fb);
        C4541ib ibVar = new C4541ib(this);
        $jacocoInit[32] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ibVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[33] = true;
        C0120S a = f.mo3616a(v);
        C4514bc bcVar = C4514bc.f8131a;
        $jacocoInit[34] = true;
        C0120S a2 = a.mo3621a((C0129b<? super Throwable>) bcVar);
        $jacocoInit[35] = true;
        C0120S g = a2.mo3662g();
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[36] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4593vb vbVar = C4593vb.f8223a;
        C4570pc pcVar = C4570pc.f8198a;
        $jacocoInit[37] = true;
        a3.mo3626a((C0129b<? super T>) vbVar, (C0129b<Throwable>) pcVar);
        $jacocoInit[38] = true;
    }

    /* renamed from: p */
    static /* synthetic */ Boolean m8929p(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[201] = true;
        return valueOf;
    }

    /* renamed from: q */
    public /* synthetic */ C0120S mo15785q(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S pauseDownload = this.view.pauseDownload();
        C4598wc wcVar = new C4598wc(this);
        $jacocoInit[197] = true;
        C0120S g = pauseDownload.mo3663g((C0132p<? super T, ? extends C0117M>) wcVar);
        $jacocoInit[198] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[199] = true;
        return g2;
    }

    /* renamed from: f */
    public /* synthetic */ C0117M mo15774f(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseDownload = this.promotionsManager.pauseDownload(promotionViewApp.getMd5());
        $jacocoInit[200] = true;
        return pauseDownload;
    }

    /* renamed from: i */
    static /* synthetic */ void m8921i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[196] = true;
    }

    /* renamed from: k */
    static /* synthetic */ void m8925k(PromotionViewApp created) {
        $jacocoInit()[195] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m8924j(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        IllegalStateException illegalStateException = new IllegalStateException(error);
        $jacocoInit[194] = true;
        throw illegalStateException;
    }

    private void installButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4605yb ybVar = C4605yb.f8237a;
        $jacocoInit[39] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ybVar);
        C4585tb tbVar = new C4585tb(this);
        $jacocoInit[40] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tbVar);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[41] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4574qc qcVar = C4574qc.f8203a;
        C4450Ib ib = C4450Ib.f8054a;
        $jacocoInit[42] = true;
        a.mo3626a((C0129b<? super T>) qcVar, (C0129b<Throwable>) ib);
        $jacocoInit[43] = true;
    }

    /* renamed from: n */
    static /* synthetic */ Boolean m8928n(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[193] = true;
        return valueOf;
    }

    /* renamed from: o */
    public /* synthetic */ C0120S mo15784o(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installButtonClick = this.view.installButtonClick();
        C4578rc rcVar = C4578rc.f8207a;
        $jacocoInit[176] = true;
        C0120S d = installButtonClick.mo3653d((C0132p<? super T, Boolean>) rcVar);
        C4462Mb mb = new C4462Mb(this);
        $jacocoInit[177] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) mb);
        C4489Ub ub = new C4489Ub(this);
        $jacocoInit[178] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) ub);
        C0126V v = this.viewScheduler;
        $jacocoInit[179] = true;
        C0120S a = g.mo3616a(v);
        C4529fb fbVar = C4529fb.f8148a;
        $jacocoInit[180] = true;
        C0120S a2 = a.mo3621a((C0129b<? super Throwable>) fbVar);
        $jacocoInit[181] = true;
        C0120S g2 = a2.mo3662g();
        $jacocoInit[182] = true;
        return g2;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m8917g(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = promotionViewApp.getDownloadModel();
        $jacocoInit[190] = true;
        boolean isDownloadable = downloadModel.isDownloadable();
        $jacocoInit[191] = true;
        Boolean valueOf = Boolean.valueOf(isDownloadable);
        $jacocoInit[192] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ void mo15778h(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsAnalytics promotionsAnalytics2 = this.promotionsAnalytics;
        $jacocoInit[185] = true;
        String packageName = promotionViewApp.getPackageName();
        float appcValue = promotionViewApp.getAppcValue();
        $jacocoInit[186] = true;
        DownloadModel downloadModel = promotionViewApp.getDownloadModel();
        $jacocoInit[187] = true;
        Action action = downloadModel.getAction();
        $jacocoInit[188] = true;
        promotionsAnalytics2.sendPromotionsAppInteractInstallEvent(packageName, appcValue, action);
        $jacocoInit[189] = true;
    }

    /* renamed from: i */
    public /* synthetic */ C0117M mo15780i(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = downloadApp(promotionViewApp);
        $jacocoInit[184] = true;
        return downloadApp;
    }

    /* renamed from: g */
    static /* synthetic */ void m8918g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[183] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8906b(PromotionViewApp created) {
        $jacocoInit()[175] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m8916f(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        IllegalStateException illegalStateException = new IllegalStateException(error);
        $jacocoInit[174] = true;
        throw illegalStateException;
    }

    private void handlePromotionOverDialogClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4478Qb qb = C4478Qb.f8086a;
        $jacocoInit[44] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) qb);
        C4533gb gbVar = new C4533gb(this);
        $jacocoInit[45] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gbVar);
        C4456Kb kb = new C4456Kb(this);
        $jacocoInit[46] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) kb);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[47] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4569pb pbVar = C4569pb.f8197a;
        C4550kc kcVar = C4550kc.f8175a;
        $jacocoInit[48] = true;
        a.mo3626a((C0129b<? super T>) pbVar, (C0129b<Throwable>) kcVar);
        $jacocoInit[49] = true;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m8922j(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[173] = true;
        return valueOf;
    }

    /* renamed from: k */
    public /* synthetic */ C0120S mo15782k(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S promotionOverDialogClick = this.view.promotionOverDialogClick();
        $jacocoInit[172] = true;
        return promotionOverDialogClick;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15764b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsNavigator.navigateToHome();
        $jacocoInit[171] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8911c(Void __) {
        $jacocoInit()[170] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m8915e(Throwable throwable) {
        $jacocoInit()[169] = true;
    }

    private C0117M downloadApp(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m643a((C0131o<C0120S<T>>) new C4562nc<C0120S<T>>(this));
        C0126V v = this.viewScheduler;
        $jacocoInit[50] = true;
        C0120S a2 = a.mo3616a(v);
        C4492Vb vb = new C4492Vb(this);
        $jacocoInit[51] = true;
        C0120S f = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vb);
        C4525eb ebVar = new C4525eb(this);
        $jacocoInit[52] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ebVar);
        $jacocoInit[53] = true;
        C0120S a3 = f2.mo3616a(Schedulers.m776io());
        C4601xb xbVar = new C4601xb(this, promotionViewApp);
        $jacocoInit[54] = true;
        C0120S g = a3.mo3663g((C0132p<? super T, ? extends C0117M>) xbVar);
        $jacocoInit[55] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[56] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15748a() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.promotionsManager.shouldShowRootInstallWarningPopup()) {
            $jacocoInit[164] = true;
            C0120S showRootInstallWarningPopup = this.view.showRootInstallWarningPopup();
            C4509ab abVar = new C4509ab(this);
            $jacocoInit[165] = true;
            C0120S b = showRootInstallWarningPopup.mo3636b((C0129b<? super T>) abVar);
            $jacocoInit[166] = true;
            return b;
        }
        C0120S c = C0120S.m652c(null);
        $jacocoInit[167] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15763b(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsManager.allowRootInstall(answer);
        $jacocoInit[168] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15749a(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        $jacocoInit[163] = true;
        return requestDownloadAccess;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15750a(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[162] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15747a(PromotionViewApp promotionViewApp, Void __1) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = this.promotionsManager.downloadApp(promotionViewApp);
        $jacocoInit[161] = true;
        return downloadApp;
    }

    private void getPromotionApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4447Hb hb = C4447Hb.f8051a;
        $jacocoInit[57] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) hb);
        C4483Sb sb = new C4483Sb(this);
        $jacocoInit[58] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) sb);
        C4471Pb pb = new C4471Pb(this);
        $jacocoInit[59] = true;
        C0120S i = b.mo3668i(pb);
        C4506_b _bVar = new C4506_b(this);
        $jacocoInit[60] = true;
        C0120S b2 = i.mo3636b((C0129b<? super T>) _bVar);
        C4590uc ucVar = new C4590uc(this);
        $jacocoInit[61] = true;
        C0120S b3 = b2.mo3636b((C0129b<? super T>) ucVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[62] = true;
        C0120S a = b3.mo3616a(v);
        C4501Yb yb = new C4501Yb(this);
        $jacocoInit[63] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) yb);
        C4459Lb lb = new C4459Lb(this);
        $jacocoInit[64] = true;
        C0120S a2 = f.mo3621a((C0129b<? super Throwable>) lb);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[65] = true;
        C0120S a3 = a2.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4495Wb wb = C4495Wb.f8106a;
        C4431Cc cc = C4431Cc.f8030a;
        $jacocoInit[66] = true;
        a3.mo3626a((C0129b<? super T>) wb, (C0129b<Throwable>) cc);
        $jacocoInit[67] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8914e(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[160] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15776f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[159] = true;
    }

    /* renamed from: g */
    public /* synthetic */ Single mo15777g(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single promotionsModel = this.promotionsManager.getPromotionsModel(this.promotionType);
        $jacocoInit[158] = true;
        return promotionsModel;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15753a(PromotionsModel promotionsModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionId = promotionsModel.getPromotionId();
        $jacocoInit[157] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15762b(PromotionsModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAnalytics.sendOpenPromotionsFragmentEvent();
        $jacocoInit[156] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15767c(Throwable __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showErrorView();
        $jacocoInit[155] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8910c(PromotionsModel __) {
        $jacocoInit()[154] = true;
    }

    /* access modifiers changed from: private */
    public C0120S<? extends PromotionsModel> showPromotions(PromotionsModel appsModel) {
        boolean[] $jacocoInit = $jacocoInit();
        List appsList = appsModel.getAppsList();
        $jacocoInit[68] = true;
        if (appsList.isEmpty()) {
            $jacocoInit[69] = true;
            this.view.showPromotionOverDialog();
            $jacocoInit[70] = true;
            C0120S<? extends PromotionsModel> c = C0120S.m651c();
            $jacocoInit[71] = true;
            return c;
        }
        this.view.showAppCoinsAmount(appsModel.getTotalAppcValue());
        $jacocoInit[72] = true;
        this.view.showPromotionTitle(appsModel.getTitle());
        $jacocoInit[73] = true;
        this.view.showPromotionFeatureGraphic(appsModel.getFeatureGraphic());
        $jacocoInit[74] = true;
        C0120S<? extends PromotionsModel> handlePromotionApps = handlePromotionApps(appsModel);
        $jacocoInit[75] = true;
        return handlePromotionApps;
    }

    private void handlePromotionClaimResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4453Jb jb = C4453Jb.f8057a;
        $jacocoInit[76] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jb);
        C4581sb sbVar = new C4581sb(this);
        $jacocoInit[77] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sbVar);
        C4435Dc dc = C4435Dc.f8037a;
        $jacocoInit[78] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) dc);
        C4546jc jcVar = new C4546jc(this);
        $jacocoInit[79] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) jcVar);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[80] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4534gc gcVar = C4534gc.f8154a;
        C4518cc ccVar = C4518cc.f8135a;
        $jacocoInit[81] = true;
        a.mo3626a((C0129b<? super T>) gcVar, (C0129b<Throwable>) ccVar);
        $jacocoInit[82] = true;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m8920h(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[153] = true;
        return valueOf;
    }

    /* renamed from: i */
    public /* synthetic */ C0120S mo15781i(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S claimDialogResults = this.promotionsNavigator.claimDialogResults();
        $jacocoInit[152] = true;
        return claimDialogResults;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15751a(ClaimDialogResultWrapper result) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.updateClaimStatus(result.getPackageName());
        $jacocoInit[151] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8905b(ClaimDialogResultWrapper __) {
        $jacocoInit()[150] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8913d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[149] = true;
        throw onErrorNotImplementedException;
    }

    private void handleRetryClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4517cb cbVar = C4517cb.f8134a;
        $jacocoInit[83] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) cbVar);
        C4582sc scVar = new C4582sc(this);
        $jacocoInit[84] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) scVar);
        PromotionsView promotionsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[85] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) promotionsView.bindUntilEvent(lifecycleEvent2));
        C4486Tb tb = C4486Tb.f8094a;
        C4431Cc cc = C4431Cc.f8030a;
        $jacocoInit[86] = true;
        a.mo3626a((C0129b<? super T>) tb, (C0129b<Throwable>) cc);
        $jacocoInit[87] = true;
    }

    /* renamed from: l */
    static /* synthetic */ Boolean m8927l(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[148] = true;
        return valueOf;
    }

    /* renamed from: m */
    public /* synthetic */ C0120S mo15783m(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S retryClicked = this.view.retryClicked();
        C4522dc dcVar = new C4522dc(this);
        $jacocoInit[136] = true;
        C0120S b = retryClicked.mo3636b((C0129b<? super T>) dcVar);
        C4561nb nbVar = new C4561nb(this);
        $jacocoInit[137] = true;
        C0120S i = b.mo3668i(nbVar);
        C4422Ab ab = new C4422Ab(this);
        $jacocoInit[138] = true;
        C0120S b2 = i.mo3636b((C0129b<? super T>) ab);
        C0126V v = this.viewScheduler;
        $jacocoInit[139] = true;
        C0120S a = b2.mo3616a(v);
        C4501Yb yb = new C4501Yb(this);
        $jacocoInit[140] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) yb);
        C4589ub ubVar = new C4589ub(this);
        $jacocoInit[141] = true;
        C0120S a2 = f.mo3621a((C0129b<? super Throwable>) ubVar);
        $jacocoInit[142] = true;
        C0120S g = a2.mo3662g();
        $jacocoInit[143] = true;
        return g;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15770d(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[147] = true;
    }

    /* renamed from: e */
    public /* synthetic */ Single mo15772e(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single promotionsModel = this.promotionsManager.getPromotionsModel(this.promotionType);
        $jacocoInit[146] = true;
        return promotionsModel;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15773e(PromotionsModel promotionsModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionId = promotionsModel.getPromotionId();
        $jacocoInit[145] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo15779h(Throwable __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showErrorView();
        $jacocoInit[144] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8912d(PromotionsModel __) {
        $jacocoInit()[135] = true;
    }

    private C0120S<PromotionsModel> handlePromotionApps(PromotionsModel promotionsModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(promotionsModel);
        C4480Rb rb = new C4480Rb(promotionsModel);
        $jacocoInit[88] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) rb);
        C4542ic icVar = C4542ic.f8165a;
        $jacocoInit[89] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) icVar);
        C4430Cb cb = new C4430Cb(this, promotionsModel);
        $jacocoInit[90] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) cb);
        C4609zb zbVar = new C4609zb(promotionsModel);
        $jacocoInit[91] = true;
        C0120S j = b.mo3669j(zbVar);
        C4554lc lcVar = new C4554lc(this, promotionsModel);
        $jacocoInit[92] = true;
        C0120S<PromotionsModel> f = j.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lcVar);
        $jacocoInit[93] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m8898a(PromotionsModel promotionsModel, PromotionsModel promotionsModel1) {
        boolean[] $jacocoInit = $jacocoInit();
        List appsList = promotionsModel.getAppsList();
        $jacocoInit[134] = true;
        return appsList;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8896a(PromotionApp promotionApp) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = promotionApp.getPackageName();
        $jacocoInit[131] = true;
        boolean equals = packageName.equals("com.appcoins.wallet");
        $jacocoInit[132] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[133] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15754a(PromotionsModel promotionsModel, PromotionApp wallet) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsView promotionsView = this.view;
        $jacocoInit[125] = true;
        if (!promotionsModel.isWalletInstalled()) {
            $jacocoInit[126] = true;
        } else if (!wallet.isClaimed()) {
            $jacocoInit[127] = true;
        } else {
            $jacocoInit[128] = true;
            z = true;
            promotionsView.lockPromotionApps(z);
            $jacocoInit[130] = true;
        }
        z = false;
        $jacocoInit[129] = true;
        promotionsView.lockPromotionApps(z);
        $jacocoInit[130] = true;
    }

    /* renamed from: b */
    static /* synthetic */ PromotionsModel m8904b(PromotionsModel promotionsModel, PromotionApp promotionApp) {
        $jacocoInit()[124] = true;
        return promotionsModel;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15760b(PromotionsModel promotionsModel, PromotionsModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(promotionsModel);
        C4549kb kbVar = new C4549kb(promotionsModel);
        $jacocoInit[94] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) kbVar);
        C4438Eb eb = new C4438Eb(this);
        $jacocoInit[95] = true;
        C0120S f = h.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eb);
        C0126V v = this.viewScheduler;
        $jacocoInit[96] = true;
        C0120S a = f.mo3616a(v);
        C4444Gb gb = new C4444Gb(this, promotionsModel);
        $jacocoInit[97] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) gb);
        C4573qb qbVar = C4573qb.f8202a;
        $jacocoInit[98] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) qbVar);
        C4510ac acVar = new C4510ac(this, promotionsModel);
        $jacocoInit[99] = true;
        C0120S f2 = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) acVar);
        $jacocoInit[100] = true;
        return f2;
    }

    /* renamed from: c */
    static /* synthetic */ Iterable m8909c(PromotionsModel promotionsModel, PromotionsModel promotionsModel1) {
        boolean[] $jacocoInit = $jacocoInit();
        List appsList = promotionsModel.getAppsList();
        $jacocoInit[123] = true;
        return appsList;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15758b(PromotionApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S download = this.promotionsManager.getDownload(promotionViewApp);
        $jacocoInit[122] = true;
        return download;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15755a(PromotionsModel promotionsModel, PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsView promotionsView = this.view;
        $jacocoInit[119] = true;
        boolean isWalletInstalled = promotionsModel.isWalletInstalled();
        $jacocoInit[120] = true;
        promotionsView.showPromotionApp(promotionViewApp, isWalletInstalled);
        $jacocoInit[121] = true;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m8923j(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = promotionViewApp.getDownloadModel();
        $jacocoInit[115] = true;
        Action action = downloadModel.getAction();
        Action action2 = Action.UPDATE;
        $jacocoInit[116] = true;
        boolean equals = action.equals(action2);
        $jacocoInit[117] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[118] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15759b(PromotionsModel promotionsModel, PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsManager promotionsManager2 = this.promotionsManager;
        $jacocoInit[101] = true;
        String packageName = promotionViewApp.getPackageName();
        $jacocoInit[102] = true;
        C0120S packageSignature = promotionsManager2.getPackageSignature(packageName);
        C0126V v = this.viewScheduler;
        $jacocoInit[103] = true;
        C0120S a = packageSignature.mo3616a(v);
        C4505_a _aVar = new C4505_a(promotionViewApp);
        $jacocoInit[104] = true;
        C0120S j = a.mo3669j(_aVar);
        C4566oc ocVar = new C4566oc(this, promotionViewApp);
        $jacocoInit[105] = true;
        C0120S b = j.mo3636b((C0129b<? super T>) ocVar);
        C4545jb jbVar = new C4545jb(promotionsModel);
        $jacocoInit[106] = true;
        C0120S j2 = b.mo3669j(jbVar);
        $jacocoInit[107] = true;
        return j2;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8897a(PromotionViewApp promotionViewApp, String signature) {
        boolean[] $jacocoInit = $jacocoInit();
        String signature2 = promotionViewApp.getSignature();
        $jacocoInit[112] = true;
        boolean equals = signature2.equals(signature);
        $jacocoInit[113] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[114] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15752a(PromotionViewApp promotionViewApp, Boolean signatureMatch) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsAnalytics promotionsAnalytics2 = this.promotionsAnalytics;
        $jacocoInit[109] = true;
        String packageName = promotionViewApp.getPackageName();
        $jacocoInit[110] = true;
        promotionsAnalytics2.sendValentineMigratorEvent(packageName, signatureMatch);
        $jacocoInit[111] = true;
    }

    /* renamed from: a */
    static /* synthetic */ PromotionsModel m8894a(PromotionsModel promotionsModel, Boolean __2) {
        $jacocoInit()[108] = true;
        return promotionsModel;
    }
}
