package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.app.AppsList.Error;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.view.app.ListStoreAppsPresenter */
public class ListStoreAppsPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppCenter appCenter;
    private final CrashReport crashReport;
    private final int limit;
    private final ListStoreAppsNavigator navigator;
    private final long storeId;
    private final ListStoreAppsView view;
    private final C0126V viewScheduler;

    /* renamed from: cm.aptoide.pt.view.app.ListStoreAppsPresenter$1 */
    static /* synthetic */ class C52441 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$view$app$AppsList$Error = new int[Error.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6756694613371167560L, "cm/aptoide/pt/view/app/ListStoreAppsPresenter$1", 6);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$view$app$AppsList$Error[Error.NETWORK.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$view$app$AppsList$Error[Error.GENERIC.ordinal()] = 2;
            $jacocoInit[3] = true;
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3450456948118796960L, "cm/aptoide/pt/view/app/ListStoreAppsPresenter", 102);
        $jacocoData = probes;
        return probes;
    }

    public ListStoreAppsPresenter(ListStoreAppsView view2, long storeId2, C0126V viewScheduler2, AppCenter appCenter2, CrashReport crashReport2, ListStoreAppsNavigator navigator2, int limit2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.storeId = storeId2;
        this.viewScheduler = viewScheduler2;
        this.appCenter = appCenter2;
        this.crashReport = crashReport2;
        this.navigator = navigator2;
        this.limit = limit2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onCreateLoadApps();
        $jacocoInit[1] = true;
        onCreateHandleAppClicks();
        $jacocoInit[2] = true;
        onCreateHandleBottomReached();
        $jacocoInit[3] = true;
        onCreateHandleRefresh();
        $jacocoInit[4] = true;
        onCreateHandleRetry();
        $jacocoInit[5] = true;
    }

    private void onCreateHandleRetry() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5297ta taVar = C5297ta.f9076a;
        $jacocoInit[6] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) taVar);
        C5289pa paVar = new C5289pa(this);
        $jacocoInit[7] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) paVar);
        ListStoreAppsView listStoreAppsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[8] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) listStoreAppsView.bindUntilEvent(lifecycleEvent2));
        C5231Ca ca = C5231Ca.f9000a;
        C5285na naVar = new C5285na(this);
        $jacocoInit[9] = true;
        a.mo3626a((C0129b<? super T>) ca, (C0129b<Throwable>) naVar);
        $jacocoInit[10] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m9575g(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[101] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo17118h(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S retryEvent = this.view.getRetryEvent();
        C0126V v = this.viewScheduler;
        $jacocoInit[94] = true;
        C0120S a = retryEvent.mo3616a(v);
        C5279ka kaVar = new C5279ka(this);
        $jacocoInit[95] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) kaVar);
        C5277ja jaVar = new C5277ja(this);
        $jacocoInit[96] = true;
        C0120S i = b.mo3668i(jaVar);
        $jacocoInit[97] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[98] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17105a(Void bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showStartingLoading();
        $jacocoInit[100] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo17108b(Void reachesBottom) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadShowNextApps = loadShowNextApps();
        $jacocoInit[99] = true;
        return loadShowNextApps;
    }

    /* renamed from: f */
    static /* synthetic */ void m9574f(AppsList notificationUrl) {
        $jacocoInit()[93] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo17115d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[92] = true;
    }

    private Single<AppsList> loadShowNextApps() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadNextApps = this.appCenter.loadNextApps(this.storeId, this.limit);
        C0126V v = this.viewScheduler;
        $jacocoInit[11] = true;
        Single a = loadNextApps.mo3686a(v);
        C5263ca caVar = new C5263ca(this);
        $jacocoInit[12] = true;
        Single<AppsList> b = a.mo3695b((C0129b<? super T>) caVar);
        $jacocoInit[13] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17112c(AppsList applications) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[85] = true;
        if (applications.hasErrors()) {
            $jacocoInit[86] = true;
            handleError(applications.getError());
            $jacocoInit[87] = true;
        } else if (applications.isLoading()) {
            $jacocoInit[88] = true;
        } else {
            $jacocoInit[89] = true;
            this.view.addApps(applications.getList());
            $jacocoInit[90] = true;
        }
        $jacocoInit[91] = true;
    }

    private void onCreateHandleRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5305xa xaVar = C5305xa.f9084a;
        $jacocoInit[14] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) xaVar);
        C5283ma maVar = new C5283ma(this);
        $jacocoInit[15] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) maVar);
        ListStoreAppsView listStoreAppsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[16] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) listStoreAppsView.bindUntilEvent(lifecycleEvent2));
        C5309za zaVar = C5309za.f9088a;
        C5269fa faVar = new C5269fa(this);
        $jacocoInit[17] = true;
        a.mo3626a((C0129b<? super T>) zaVar, (C0129b<Throwable>) faVar);
        $jacocoInit[18] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9572e(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[84] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo17117f(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c refreshEvent = this.view.getRefreshEvent();
        C0126V v = this.viewScheduler;
        $jacocoInit[79] = true;
        C0120S a = refreshEvent.mo3616a(v);
        C5267ea eaVar = new C5267ea(this);
        $jacocoInit[80] = true;
        C0120S i = a.mo3668i(eaVar);
        $jacocoInit[81] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[82] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo17111c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshApps = loadFreshApps();
        $jacocoInit[83] = true;
        return loadFreshApps;
    }

    /* renamed from: e */
    static /* synthetic */ void m9573e(AppsList notificationUrl) {
        $jacocoInit()[78] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17113c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[77] = true;
    }

    private Single<AppsList> loadFreshApps() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshApps = this.appCenter.loadFreshApps(this.storeId, this.limit);
        C0126V v = this.viewScheduler;
        $jacocoInit[19] = true;
        Single a = loadFreshApps.mo3686a(v);
        C5261ba baVar = new C5261ba(this);
        $jacocoInit[20] = true;
        Single<AppsList> b = a.mo3695b((C0129b<? super T>) baVar);
        $jacocoInit[21] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17109b(AppsList applications) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideRefreshLoading();
        $jacocoInit[70] = true;
        if (applications.hasErrors()) {
            $jacocoInit[71] = true;
            handleError(applications.getError());
            $jacocoInit[72] = true;
        } else if (applications.isLoading()) {
            $jacocoInit[73] = true;
        } else {
            $jacocoInit[74] = true;
            this.view.setApps(applications.getList());
            $jacocoInit[75] = true;
        }
        $jacocoInit[76] = true;
    }

    private void onCreateLoadApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5303wa waVar = C5303wa.f9082a;
        $jacocoInit[22] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) waVar);
        C5281la laVar = new C5281la(this);
        $jacocoInit[23] = true;
        C0120S i = d.mo3668i(laVar);
        ListStoreAppsView listStoreAppsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[24] = true;
        C0120S a = i.mo3614a((C0121c<? super T, ? extends R>) listStoreAppsView.bindUntilEvent(lifecycleEvent2));
        C5265da daVar = C5265da.f9042a;
        C5226Aa aa = new C5226Aa(this);
        $jacocoInit[25] = true;
        a.mo3626a((C0129b<? super T>) daVar, (C0129b<Throwable>) aa);
        $jacocoInit[26] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m9577i(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[69] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ Single mo17119j(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Single apps = getApps();
        $jacocoInit[68] = true;
        return apps;
    }

    /* renamed from: g */
    static /* synthetic */ void m9576g(AppsList notificationUrl) {
        $jacocoInit()[67] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo17116e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[66] = true;
    }

    private Single<AppsList> getApps() {
        boolean[] $jacocoInit = $jacocoInit();
        Single apps = this.appCenter.getApps(this.storeId, this.limit);
        C0126V v = this.viewScheduler;
        $jacocoInit[27] = true;
        Single a = apps.mo3686a(v);
        C5271ga gaVar = new C5271ga(this);
        $jacocoInit[28] = true;
        Single<AppsList> b = a.mo3695b((C0129b<? super T>) gaVar);
        $jacocoInit[29] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17102a(AppsList applications) {
        boolean[] $jacocoInit = $jacocoInit();
        if (applications.hasErrors()) {
            $jacocoInit[60] = true;
            handleError(applications.getError());
            $jacocoInit[61] = true;
        } else if (applications.isLoading()) {
            $jacocoInit[62] = true;
        } else {
            $jacocoInit[63] = true;
            this.view.setApps(applications.getList());
            $jacocoInit[64] = true;
        }
        $jacocoInit[65] = true;
    }

    private void onCreateHandleBottomReached() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5287oa oaVar = C5287oa.f9066a;
        $jacocoInit[30] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oaVar);
        C5291qa qaVar = new C5291qa(this);
        $jacocoInit[31] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qaVar);
        ListStoreAppsView listStoreAppsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[32] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) listStoreAppsView.bindUntilEvent(lifecycleEvent2));
        C5293ra raVar = C5293ra.f9072a;
        C5229Ba ba = new C5229Ba(this);
        $jacocoInit[33] = true;
        a.mo3626a((C0129b<? super T>) raVar, (C0129b<Throwable>) ba);
        $jacocoInit[34] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9570c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[59] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo17114d(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reachesBottom = this.view.reachesBottom();
        C0126V v = this.viewScheduler;
        $jacocoInit[52] = true;
        C0120S a = reachesBottom.mo3616a(v);
        C5299ua uaVar = new C5299ua(this);
        $jacocoInit[53] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) uaVar);
        C5233Da da = new C5233Da(this);
        $jacocoInit[54] = true;
        C0120S i = b.mo3668i(da);
        $jacocoInit[55] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[56] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17103a(Object bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[58] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo17107b(Object reachesBottom) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadShowNextApps = loadShowNextApps();
        $jacocoInit[57] = true;
        return loadShowNextApps;
    }

    /* renamed from: d */
    static /* synthetic */ void m9571d(AppsList notificationUrl) {
        $jacocoInit()[51] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17110b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[50] = true;
    }

    private void handleError(Error error) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C52441.$SwitchMap$cm$aptoide$pt$view$app$AppsList$Error[error.ordinal()];
        if (i == 1) {
            this.view.showNetworkError();
            $jacocoInit[36] = true;
        } else if (i != 2) {
            $jacocoInit[35] = true;
        } else {
            this.view.showGenericError();
            $jacocoInit[37] = true;
        }
        $jacocoInit[38] = true;
    }

    private void onCreateHandleAppClicks() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5295sa saVar = C5295sa.f9074a;
        $jacocoInit[39] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) saVar);
        C5273ha haVar = new C5273ha(this);
        $jacocoInit[40] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) haVar);
        ListStoreAppsView listStoreAppsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[41] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) listStoreAppsView.bindUntilEvent(lifecycleEvent2));
        C5301va vaVar = C5301va.f9080a;
        C5307ya yaVar = new C5307ya(this);
        $jacocoInit[42] = true;
        a.mo3626a((C0129b<? super T>) vaVar, (C0129b<Throwable>) yaVar);
        $jacocoInit[43] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9568a(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[49] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo17106b(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appClick = this.view.getAppClick();
        C5275ia iaVar = new C5275ia(this);
        $jacocoInit[46] = true;
        C0120S b = appClick.mo3636b((C0129b<? super T>) iaVar);
        $jacocoInit[47] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17101a(Application app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.navigateToAppView(app.getAppId(), app.getPackageName());
        $jacocoInit[48] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9569b(Application notificationUrl) {
        $jacocoInit()[45] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17104a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[44] = true;
    }
}
