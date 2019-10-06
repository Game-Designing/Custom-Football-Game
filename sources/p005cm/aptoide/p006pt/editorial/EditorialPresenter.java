package p005cm.aptoide.p006pt.editorial;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.reactions.ReactionEvent;
import p005cm.aptoide.p006pt.reactions.network.LoadReactionModel;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.editorial.EditorialPresenter */
public class EditorialPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final CrashReport crashReporter;
    private final EditorialAnalytics editorialAnalytics;
    private final EditorialManager editorialManager;
    private final EditorialNavigator editorialNavigator;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final EditorialView view;
    private final C0126V viewScheduler;

    /* renamed from: cm.aptoide.pt.editorial.EditorialPresenter$1 */
    static /* synthetic */ class C30741 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(5500422650314109591L, "cm/aptoide/pt/editorial/EditorialPresenter$1", 10);
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
                            $jacocoInit[8] = true;
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
            $jacocoInit[9] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1606971583098847740L, "cm/aptoide/pt/editorial/EditorialPresenter", 416);
        $jacocoData = probes;
        return probes;
    }

    public EditorialPresenter(EditorialView view2, EditorialManager editorialManager2, C0126V viewScheduler2, CrashReport crashReporter2, PermissionManager permissionManager2, PermissionService permissionService2, EditorialAnalytics editorialAnalytics2, EditorialNavigator editorialNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.editorialManager = editorialManager2;
        this.viewScheduler = viewScheduler2;
        this.crashReporter = crashReporter2;
        this.permissionManager = permissionManager2;
        this.permissionService = permissionService2;
        this.editorialAnalytics = editorialAnalytics2;
        this.editorialNavigator = editorialNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onCreateLoadAppOfTheWeek();
        $jacocoInit[1] = true;
        handleRetryClick();
        $jacocoInit[2] = true;
        handleClickOnMedia();
        $jacocoInit[3] = true;
        handleClickOnAppCard();
        $jacocoInit[4] = true;
        handleInstallClick();
        $jacocoInit[5] = true;
        pauseDownload();
        $jacocoInit[6] = true;
        resumeDownload();
        $jacocoInit[7] = true;
        cancelDownload();
        $jacocoInit[8] = true;
        loadDownloadApp();
        $jacocoInit[9] = true;
        handlePlaceHolderVisibilityChange();
        $jacocoInit[10] = true;
        handlePlaceHolderVisibility();
        $jacocoInit[11] = true;
        handleMediaListDescriptionVisibility();
        $jacocoInit[12] = true;
        handleClickActionButtonCard();
        $jacocoInit[13] = true;
        handleMovingCollapse();
        $jacocoInit[14] = true;
        handleReactionButtonClick();
        $jacocoInit[15] = true;
        handleUserReaction();
        $jacocoInit[16] = true;
        handleLongPressReactionButton();
        $jacocoInit[17] = true;
        handleSnackLogInClick();
        $jacocoInit[18] = true;
        onCreateLoadReactionModel();
        $jacocoInit[19] = true;
    }

    public void onCreateLoadAppOfTheWeek() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3085Ia ia = C3085Ia.f6427a;
        $jacocoInit[20] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ia);
        C3057Bb bb = new C3057Bb(this);
        $jacocoInit[21] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) bb);
        C3130Xb xb = new C3130Xb(this);
        $jacocoInit[22] = true;
        C0120S i = b.mo3668i(xb);
        C3192na naVar = C3192na.f6558a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[23] = true;
        i.mo3626a((C0129b<? super T>) naVar, (C0129b<Throwable>) cVar);
        $jacocoInit[24] = true;
    }

    /* renamed from: E */
    static /* synthetic */ Boolean m7712E(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[415] = true;
        return valueOf;
    }

    /* renamed from: F */
    public /* synthetic */ void mo13891F(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[414] = true;
    }

    /* renamed from: G */
    public /* synthetic */ Single mo13892G(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialViewModel = loadEditorialViewModel();
        $jacocoInit[413] = true;
        return loadEditorialViewModel;
    }

    /* renamed from: j */
    static /* synthetic */ void m7747j(EditorialViewModel __) {
        $jacocoInit()[412] = true;
    }

    private Single<EditorialViewModel> loadEditorialViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialViewModel = this.editorialManager.loadEditorialViewModel();
        C0126V v = this.viewScheduler;
        $jacocoInit[25] = true;
        Single a = loadEditorialViewModel.mo3686a(v);
        C3145bb bbVar = new C3145bb(this);
        $jacocoInit[26] = true;
        Single b = a.mo3695b((C0129b<? super T>) bbVar);
        C3133Yb yb = C3133Yb.f6491a;
        $jacocoInit[27] = true;
        Single<EditorialViewModel> d = b.mo3698d(yb);
        $jacocoInit[28] = true;
        return d;
    }

    /* renamed from: h */
    public /* synthetic */ void mo13942h(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialViewModel.isLoading()) {
            $jacocoInit[405] = true;
        } else {
            $jacocoInit[406] = true;
            this.view.hideLoading();
            $jacocoInit[407] = true;
        }
        if (editorialViewModel.hasError()) {
            $jacocoInit[408] = true;
            this.view.showError(editorialViewModel.getError());
            $jacocoInit[409] = true;
        } else {
            this.view.populateView(editorialViewModel);
            $jacocoInit[410] = true;
        }
        $jacocoInit[411] = true;
    }

    /* renamed from: i */
    static /* synthetic */ EditorialViewModel m7743i(EditorialViewModel editorialViewModel) {
        $jacocoInit()[404] = true;
        return editorialViewModel;
    }

    public void handleRetryClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3233za zaVar = C3233za.f6607a;
        $jacocoInit[29] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) zaVar);
        C3180ka kaVar = new C3180ka(this);
        $jacocoInit[30] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kaVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[31] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3066Eb eb = C3066Eb.f6409a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[32] = true;
        a.mo3626a((C0129b<? super T>) eb, (C0129b<Throwable>) cVar);
        $jacocoInit[33] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m7756w(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[403] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo13974x(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S retryClicked = this.view.retryClicked();
        C0126V v = this.viewScheduler;
        $jacocoInit[397] = true;
        C0120S a = retryClicked.mo3616a(v);
        C3126Wa wa = new C3126Wa(this);
        $jacocoInit[398] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) wa);
        C3080Gb gb = new C3080Gb(this);
        $jacocoInit[399] = true;
        C0120S i = b.mo3668i(gb);
        $jacocoInit[400] = true;
        return i;
    }

    /* renamed from: j */
    public /* synthetic */ void mo13959j(Void bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[402] = true;
    }

    /* renamed from: k */
    public /* synthetic */ Single mo13961k(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialViewModel = loadEditorialViewModel();
        $jacocoInit[401] = true;
        return loadEditorialViewModel;
    }

    /* renamed from: f */
    static /* synthetic */ void m7736f(EditorialViewModel notificationUrl) {
        $jacocoInit()[396] = true;
    }

    public void handleClickOnMedia() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3119U u = C3119U.f6476a;
        $jacocoInit[34] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) u);
        C3097Ma ma = new C3097Ma(this);
        $jacocoInit[35] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ma);
        C3148ca caVar = new C3148ca(this);
        $jacocoInit[36] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) caVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[37] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3184la laVar = C3184la.f6550a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[38] = true;
        a.mo3626a((C0129b<? super T>) laVar, (C0129b<Throwable>) cVar);
        $jacocoInit[39] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7738g(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[395] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo13939h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mediaContentClicked = this.view.mediaContentClicked();
        $jacocoInit[394] = true;
        return mediaContentClicked;
    }

    /* renamed from: e */
    public /* synthetic */ void mo13931e(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialNavigator.navigateToUri(editorialEvent.getUrl());
        $jacocoInit[393] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m7735f(EditorialEvent notificationUrl) {
        $jacocoInit()[392] = true;
    }

    public void handleClickOnAppCard() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3104Ob ob = C3104Ob.f6457a;
        $jacocoInit[40] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ob);
        C3209rb rbVar = new C3209rb(this);
        $jacocoInit[41] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rbVar);
        EditorialView editorialView = this.view;
        editorialView.getClass();
        C3143b bVar = new C3143b(editorialView);
        $jacocoInit[42] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bVar);
        C3131Y y = new C3131Y(this);
        $jacocoInit[43] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) y);
        EditorialView editorialView2 = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[44] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialView2.bindUntilEvent(lifecycleEvent2));
        C3201pb pbVar = C3201pb.f6568a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[45] = true;
        a.mo3626a((C0129b<? super T>) pbVar, (C0129b<Throwable>) cVar);
        $jacocoInit[46] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7734e(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[391] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo13933f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S upViewModelOnViewReady = setUpViewModelOnViewReady();
        $jacocoInit[390] = true;
        return upViewModelOnViewReady;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13921c(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialNavigator editorialNavigator2 = this.editorialNavigator;
        long id = editorialEvent.getId();
        $jacocoInit[387] = true;
        String packageName = editorialEvent.getPackageName();
        $jacocoInit[388] = true;
        editorialNavigator2.navigateToAppView(id, packageName);
        $jacocoInit[389] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7730d(EditorialEvent __) {
        $jacocoInit()[386] = true;
    }

    public void handleClickActionButtonCard() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3149cb cbVar = C3149cb.f6510a;
        $jacocoInit[47] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) cbVar);
        C3144ba baVar = new C3144ba(this);
        $jacocoInit[48] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) baVar);
        C3161fb fbVar = new C3161fb(this);
        $jacocoInit[49] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) fbVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[50] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3082Ha ha = C3082Ha.f6421a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[51] = true;
        a.mo3626a((C0129b<? super T>) ha, (C0129b<Throwable>) cVar);
        $jacocoInit[52] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7727c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[385] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo13926d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S actionButtonClicked = this.view.actionButtonClicked();
        $jacocoInit[384] = true;
        return actionButtonClicked;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13908a(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialNavigator.navigateToUri(editorialEvent.getUrl());
        $jacocoInit[383] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7723b(EditorialEvent __) {
        $jacocoInit()[382] = true;
    }

    private void handleInstallClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3188ma maVar = C3188ma.f6554a;
        $jacocoInit[53] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) maVar);
        C3124Vb vb = new C3124Vb(this);
        $jacocoInit[54] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vb);
        C3160fa faVar = new C3160fa(this);
        $jacocoInit[55] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) faVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[56] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3083Hb hb = C3083Hb.f6422a;
        C3197ob obVar = C3197ob.f6563a;
        $jacocoInit[57] = true;
        a.mo3626a((C0129b<? super T>) hb, (C0129b<Throwable>) obVar);
        $jacocoInit[58] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m7744i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[381] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo13958j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S upViewModelOnViewReady = setUpViewModelOnViewReady();
        $jacocoInit[380] = true;
        return upViewModelOnViewReady;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13915b(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installButtonClick = this.view.installButtonClick(editorialViewModel);
        C3091Ka ka = new C3091Ka(this);
        $jacocoInit[354] = true;
        C0120S g = installButtonClick.mo3663g((C0132p<? super T, ? extends C0117M>) ka);
        C3164ga gaVar = C3164ga.f6528a;
        $jacocoInit[355] = true;
        C0120S a = g.mo3621a((C0129b<? super Throwable>) gaVar);
        $jacocoInit[356] = true;
        C0120S g2 = a.mo3662g();
        $jacocoInit[357] = true;
        return g2;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo13928e(EditorialDownloadEvent editorialDownloadEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M completable = null;
        $jacocoInit[359] = true;
        Action action = editorialDownloadEvent.getAction();
        $jacocoInit[360] = true;
        int i = C30741.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[action.ordinal()];
        if (i == 1 || i == 2) {
            Single loadEditorialViewModel = this.editorialManager.loadEditorialViewModel();
            C3134Z z = new C3134Z(this, editorialDownloadEvent, action);
            $jacocoInit[362] = true;
            completable = loadEditorialViewModel.mo3693b((C0132p<? super T, ? extends C0117M>) z);
            $jacocoInit[363] = true;
        } else if (i == 3) {
            Single loadEditorialViewModel2 = this.editorialManager.loadEditorialViewModel();
            C0126V v = this.viewScheduler;
            $jacocoInit[364] = true;
            Single a = loadEditorialViewModel2.mo3686a(v);
            C3063Db db = new C3063Db(this, editorialDownloadEvent);
            $jacocoInit[365] = true;
            completable = a.mo3693b((C0132p<? super T, ? extends C0117M>) db);
            $jacocoInit[366] = true;
        } else if (i != 4) {
            $jacocoInit[361] = true;
        } else {
            Single loadEditorialViewModel3 = this.editorialManager.loadEditorialViewModel();
            C0126V v2 = this.viewScheduler;
            $jacocoInit[367] = true;
            Single a2 = loadEditorialViewModel3.mo3686a(v2);
            C3152da daVar = new C3152da(this, editorialDownloadEvent);
            $jacocoInit[368] = true;
            completable = a2.mo3693b((C0132p<? super T, ? extends C0117M>) daVar);
            $jacocoInit[369] = true;
        }
        $jacocoInit[370] = true;
        return completable;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo13896a(EditorialDownloadEvent editorialDownloadEvent, Action action, EditorialViewModel viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = downloadApp(editorialDownloadEvent).mo3581a(this.viewScheduler);
        C3221va vaVar = new C3221va(this, editorialDownloadEvent, action);
        $jacocoInit[375] = true;
        C0117M a2 = a.mo3582a((C0128a) vaVar);
        $jacocoInit[376] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13907a(EditorialDownloadEvent editorialDownloadEvent, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialAnalytics editorialAnalytics2 = this.editorialAnalytics;
        $jacocoInit[377] = true;
        String packageName = editorialDownloadEvent.getPackageName();
        String str = action.toString();
        $jacocoInit[378] = true;
        editorialAnalytics2.clickOnInstallButton(packageName, str);
        $jacocoInit[379] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo13897a(EditorialDownloadEvent editorialDownloadEvent, EditorialViewModel appViewViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[372] = true;
        String packageName = editorialDownloadEvent.getPackageName();
        $jacocoInit[373] = true;
        C0117M openInstalledApp = openInstalledApp(packageName);
        $jacocoInit[374] = true;
        return openInstalledApp;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo13912b(EditorialDownloadEvent editorialDownloadEvent, EditorialViewModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downgradeApp = downgradeApp(editorialDownloadEvent);
        $jacocoInit[371] = true;
        return downgradeApp;
    }

    /* renamed from: g */
    static /* synthetic */ void m7740g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[358] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7729d(EditorialDownloadEvent created) {
        $jacocoInit()[353] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7726b(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        IllegalStateException illegalStateException = new IllegalStateException(error);
        $jacocoInit[352] = true;
        throw illegalStateException;
    }

    private void cancelDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3205qb qbVar = C3205qb.f6575a;
        $jacocoInit[59] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) qbVar);
        C3150cc ccVar = new C3150cc(this);
        $jacocoInit[60] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ccVar);
        C3142ac acVar = new C3142ac(this);
        $jacocoInit[61] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) acVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[62] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3086Ib ib = C3086Ib.f6428a;
        C3121Ub ub = C3121Ub.f6478a;
        $jacocoInit[63] = true;
        a.mo3626a((C0129b<? super T>) ib, (C0129b<Throwable>) ub);
        $jacocoInit[64] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7716a(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[349] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[350] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[351] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13916b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S upViewModelOnViewReady = setUpViewModelOnViewReady();
        $jacocoInit[348] = true;
        return upViewModelOnViewReady;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13901a(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelDownload = this.view.cancelDownload(editorialViewModel);
        C3116T t = new C3116T(this);
        $jacocoInit[338] = true;
        C0120S b = cancelDownload.mo3636b((C0129b<? super T>) t);
        C3110Qb qb = new C3110Qb(this);
        $jacocoInit[339] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) qb);
        $jacocoInit[340] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[341] = true;
        return g2;
    }

    /* renamed from: f */
    public /* synthetic */ void mo13934f(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialAnalytics editorialAnalytics2 = this.editorialAnalytics;
        $jacocoInit[345] = true;
        String packageName = editorialEvent.getPackageName();
        $jacocoInit[346] = true;
        editorialAnalytics2.sendDownloadCancelEvent(packageName);
        $jacocoInit[347] = true;
    }

    /* renamed from: g */
    public /* synthetic */ C0117M mo13937g(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialManager editorialManager2 = this.editorialManager;
        String md5 = editorialEvent.getMd5();
        $jacocoInit[342] = true;
        String packageName = editorialEvent.getPackageName();
        int verCode = editorialEvent.getVerCode();
        $jacocoInit[343] = true;
        C0117M cancelDownload = editorialManager2.cancelDownload(md5, packageName, verCode);
        $jacocoInit[344] = true;
        return cancelDownload;
    }

    /* renamed from: a */
    static /* synthetic */ void m7718a(EditorialDownloadEvent created) {
        $jacocoInit()[337] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7721a(Throwable error) {
        $jacocoInit()[336] = true;
    }

    private void resumeDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3120Ua ua = C3120Ua.f6477a;
        $jacocoInit[65] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ua);
        C3118Tb tb = new C3118Tb(this);
        $jacocoInit[66] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tb);
        C3059Ca ca = new C3059Ca(this);
        $jacocoInit[67] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ca);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[68] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3222vb vbVar = C3222vb.f6594a;
        C3204qa qaVar = C3204qa.f6574a;
        $jacocoInit[69] = true;
        a.mo3626a((C0129b<? super T>) vbVar, (C0129b<Throwable>) qaVar);
        $jacocoInit[70] = true;
    }

    /* renamed from: L */
    static /* synthetic */ Boolean m7715L(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[333] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[334] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[335] = true;
        return valueOf;
    }

    /* renamed from: M */
    public /* synthetic */ C0120S mo13895M(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S upViewModelOnViewReady = setUpViewModelOnViewReady();
        $jacocoInit[332] = true;
        return upViewModelOnViewReady;
    }

    /* renamed from: m */
    public /* synthetic */ C0120S mo13965m(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S resumeDownload = this.view.resumeDownload(editorialViewModel);
        C3146bc bcVar = new C3146bc(this);
        $jacocoInit[322] = true;
        C0120S f = resumeDownload.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bcVar);
        $jacocoInit[323] = true;
        return f;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo13938h(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        C3129Xa xa = new C3129Xa(this);
        $jacocoInit[324] = true;
        C0120S f = requestDownloadAccess.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xa);
        C3140aa aaVar = new C3140aa(this, editorialEvent);
        $jacocoInit[325] = true;
        C0120S g = f.mo3663g((C0132p<? super T, ? extends C0117M>) aaVar);
        $jacocoInit[326] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[327] = true;
        return g2;
    }

    /* renamed from: i */
    public /* synthetic */ C0120S mo13955i(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[331] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo13913b(EditorialDownloadEvent editorialEvent, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialManager editorialManager2 = this.editorialManager;
        String md5 = editorialEvent.getMd5();
        $jacocoInit[328] = true;
        String packageName = editorialEvent.getPackageName();
        long appId = editorialEvent.getAppId();
        $jacocoInit[329] = true;
        C0117M resumeDownload = editorialManager2.resumeDownload(md5, packageName, appId);
        $jacocoInit[330] = true;
        return resumeDownload;
    }

    /* renamed from: l */
    static /* synthetic */ void m7750l(Void created) {
        $jacocoInit()[321] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m7746i(Throwable error) {
        $jacocoInit()[320] = true;
    }

    private void pauseDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3231yb ybVar = C3231yb.f6604a;
        $jacocoInit[71] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ybVar);
        C3100Na na = new C3100Na(this);
        $jacocoInit[72] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) na);
        C3103Oa oa = new C3103Oa(this);
        $jacocoInit[73] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oa);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[74] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3135Za za = C3135Za.f6495a;
        C3216tb tbVar = C3216tb.f6586a;
        $jacocoInit[75] = true;
        a.mo3626a((C0129b<? super T>) za, (C0129b<Throwable>) tbVar);
        $jacocoInit[76] = true;
    }

    /* renamed from: J */
    static /* synthetic */ Boolean m7714J(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[317] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[318] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[319] = true;
        return valueOf;
    }

    /* renamed from: K */
    public /* synthetic */ C0120S mo13894K(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S upViewModelOnViewReady = setUpViewModelOnViewReady();
        $jacocoInit[316] = true;
        return upViewModelOnViewReady;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo13962l(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S pauseDownload = this.view.pauseDownload(editorialViewModel);
        C3213sb sbVar = new C3213sb(this);
        $jacocoInit[308] = true;
        C0120S b = pauseDownload.mo3636b((C0129b<? super T>) sbVar);
        C3109Qa qa = new C3109Qa(this);
        $jacocoInit[309] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) qa);
        $jacocoInit[310] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[311] = true;
        return g2;
    }

    /* renamed from: i */
    public /* synthetic */ void mo13956i(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialAnalytics editorialAnalytics2 = this.editorialAnalytics;
        $jacocoInit[313] = true;
        String packageName = editorialEvent.getPackageName();
        $jacocoInit[314] = true;
        editorialAnalytics2.sendDownloadPauseEvent(packageName);
        $jacocoInit[315] = true;
    }

    /* renamed from: j */
    public /* synthetic */ C0117M mo13957j(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseDownload = this.editorialManager.pauseDownload(editorialEvent.getMd5());
        $jacocoInit[312] = true;
        return pauseDownload;
    }

    /* renamed from: k */
    static /* synthetic */ void m7749k(EditorialDownloadEvent created) {
        $jacocoInit()[307] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m7742h(Throwable error) {
        $jacocoInit()[306] = true;
    }

    private C0117M downloadApp(EditorialDownloadEvent editorialDownloadEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m643a((C0131o<C0120S<T>>) new C3060Cb<C0120S<T>>(this, editorialDownloadEvent));
        C0126V v = this.viewScheduler;
        $jacocoInit[77] = true;
        C0120S a2 = a.mo3616a(v);
        C3123Va va = new C3123Va(this);
        $jacocoInit[78] = true;
        C0120S f = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) va);
        C3056Ba ba = new C3056Ba(this);
        $jacocoInit[79] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ba);
        $jacocoInit[80] = true;
        C0120S a3 = f2.mo3616a(Schedulers.m776io());
        C3162fc fcVar = new C3162fc(this, editorialDownloadEvent);
        $jacocoInit[81] = true;
        C0120S g = a3.mo3663g((C0132p<? super T, ? extends C0117M>) fcVar);
        $jacocoInit[82] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[83] = true;
        return l;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13914b(EditorialDownloadEvent editorialDownloadEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.editorialManager.shouldShowRootInstallWarningPopup()) {
            $jacocoInit[300] = true;
            C0120S showRootInstallWarningPopup = this.view.showRootInstallWarningPopup();
            EditorialManager editorialManager2 = this.editorialManager;
            editorialManager2.getClass();
            C3194nc ncVar = new C3194nc(editorialManager2);
            $jacocoInit[301] = true;
            C0120S b = showRootInstallWarningPopup.mo3636b((C0129b<? super T>) ncVar);
            C3176ja jaVar = new C3176ja(editorialDownloadEvent);
            $jacocoInit[302] = true;
            C0120S j = b.mo3669j(jaVar);
            $jacocoInit[303] = true;
            return j;
        }
        C0120S c = C0120S.m652c(editorialDownloadEvent);
        $jacocoInit[304] = true;
        return c;
    }

    /* renamed from: b */
    static /* synthetic */ EditorialDownloadEvent m7722b(EditorialDownloadEvent editorialDownloadEvent, Boolean __) {
        $jacocoInit()[305] = true;
        return editorialDownloadEvent;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo13920c(EditorialDownloadEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(this.permissionService);
        $jacocoInit[299] = true;
        return requestDownloadAccess;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13904a(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S requestExternalStoragePermission = this.permissionManager.requestExternalStoragePermission(this.permissionService);
        $jacocoInit[298] = true;
        return requestExternalStoragePermission;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo13899a(EditorialDownloadEvent editorialDownloadEvent, Void viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = this.editorialManager.downloadApp(editorialDownloadEvent);
        $jacocoInit[297] = true;
        return downloadApp;
    }

    public void loadDownloadApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3065Ea ea = C3065Ea.f6408a;
        $jacocoInit[84] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ea);
        C3088Ja ja = new C3088Ja(this);
        $jacocoInit[85] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ja);
        C3158ec ecVar = new C3158ec(this);
        $jacocoInit[86] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ecVar);
        C3227xa xaVar = C3227xa.f6600a;
        $jacocoInit[87] = true;
        C0120S h = f2.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) xaVar);
        C3185lb lbVar = new C3185lb(this);
        $jacocoInit[88] = true;
        C0120S f3 = h.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lbVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[89] = true;
        C0120S a = f3.mo3616a(v);
        EditorialView editorialView = this.view;
        editorialView.getClass();
        C3210rc rcVar = new C3210rc(editorialView);
        $jacocoInit[90] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) rcVar);
        EditorialView editorialView2 = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[91] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) editorialView2.bindUntilEvent(lifecycleEvent2));
        C3137_a _aVar = C3137_a.f6497a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[92] = true;
        a2.mo3626a((C0129b<? super T>) _aVar, (C0129b<Throwable>) cVar);
        $jacocoInit[93] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m7711C(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[294] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[295] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[296] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo13890D(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isViewReady = this.view.isViewReady();
        $jacocoInit[293] = true;
        return isViewReady;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo13940h(Void create) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialViewModel = this.editorialManager.loadEditorialViewModel();
        $jacocoInit[291] = true;
        C0120S c = loadEditorialViewModel.mo3696c();
        $jacocoInit[292] = true;
        return c;
    }

    /* renamed from: g */
    static /* synthetic */ Iterable m7739g(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        List placeHolderContent = editorialViewModel.getPlaceHolderContent();
        $jacocoInit[290] = true;
        return placeHolderContent;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13900a(EditorialContent editorialContent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialManager editorialManager2 = this.editorialManager;
        String md5sum = editorialContent.getMd5sum();
        $jacocoInit[286] = true;
        String packageName = editorialContent.getPackageName();
        int verCode = editorialContent.getVerCode();
        $jacocoInit[287] = true;
        int position = editorialContent.getPosition();
        $jacocoInit[288] = true;
        C0120S loadDownloadModel = editorialManager2.loadDownloadModel(md5sum, packageName, verCode, false, null, position);
        $jacocoInit[289] = true;
        return loadDownloadModel;
    }

    /* renamed from: a */
    static /* synthetic */ void m7719a(EditorialDownloadModel created) {
        $jacocoInit()[285] = true;
    }

    public void handlePlaceHolderVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3219ub ubVar = C3219ub.f6589a;
        $jacocoInit[94] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ubVar);
        C3095Lb lb = new C3095Lb(this);
        $jacocoInit[95] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lb);
        C0126V v = this.viewScheduler;
        $jacocoInit[96] = true;
        C0120S a = f.mo3616a(v);
        C3225wb wbVar = new C3225wb(this);
        $jacocoInit[97] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) wbVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[98] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3141ab abVar = C3141ab.f6502a;
        C3062Da da = new C3062Da(this);
        $jacocoInit[99] = true;
        a2.mo3626a((C0129b<? super T>) abVar, (C0129b<Throwable>) da);
        $jacocoInit[100] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m7753q(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[282] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[283] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[284] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo13971r(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isViewReady = this.view.isViewReady();
        $jacocoInit[281] = true;
        return isViewReady;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13925c(Void model) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.managePlaceHolderVisibity();
        $jacocoInit[280] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7733d(Void created) {
        $jacocoInit()[279] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo13927d(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(error);
        $jacocoInit[278] = true;
    }

    private C0117M openInstalledApp(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3106Pa(this, packageName));
        $jacocoInit[101] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13911a(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.openApp(packageName);
        $jacocoInit[277] = true;
    }

    public void handlePlaceHolderVisibilityChange() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3157eb ebVar = C3157eb.f6519a;
        $jacocoInit[102] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ebVar);
        C3076Fa fa = new C3076Fa(this);
        $jacocoInit[103] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fa);
        C3089Jb jb = new C3089Jb(this);
        $jacocoInit[104] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) jb);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[105] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3212sa saVar = C3212sa.f6582a;
        C3230ya yaVar = new C3230ya(this);
        $jacocoInit[106] = true;
        a.mo3626a((C0129b<? super T>) saVar, (C0129b<Throwable>) yaVar);
        $jacocoInit[107] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m7754s(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[276] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo13972t(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S placeHolderVisibilityChange = this.view.placeHolderVisibilityChange();
        $jacocoInit[275] = true;
        return placeHolderVisibilityChange;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13909a(ScrollEvent scrollEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!scrollEvent.getItemShown().booleanValue()) {
            $jacocoInit[266] = true;
        } else if (!scrollEvent.isScrollDown()) {
            $jacocoInit[267] = true;
        } else {
            $jacocoInit[268] = true;
            this.view.removeBottomCardAnimation();
            $jacocoInit[269] = true;
            $jacocoInit[274] = true;
        }
        if (scrollEvent.getItemShown().booleanValue()) {
            $jacocoInit[270] = true;
        } else if (scrollEvent.isScrollDown()) {
            $jacocoInit[271] = true;
        } else {
            $jacocoInit[272] = true;
            this.view.addBottomCardAnimation();
            $jacocoInit[273] = true;
        }
        $jacocoInit[274] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7724b(ScrollEvent __) {
        $jacocoInit()[265] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo13932e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[264] = true;
    }

    public void handleMediaListDescriptionVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3132Ya ya = C3132Ya.f6490a;
        $jacocoInit[108] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ya);
        C3112Rb rb = new C3112Rb(this);
        $jacocoInit[109] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rb);
        C0126V v = this.viewScheduler;
        $jacocoInit[110] = true;
        C0120S a = f.mo3616a(v);
        C3113S s = C3113S.f6469a;
        $jacocoInit[111] = true;
        C0120S d2 = a.mo3653d((C0132p<? super T, Boolean>) s);
        C3181kb kbVar = new C3181kb(this);
        $jacocoInit[112] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) kbVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[113] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3153db dbVar = C3153db.f6515a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[114] = true;
        a2.mo3626a((C0129b<? super T>) dbVar, (C0129b<Throwable>) cVar);
        $jacocoInit[115] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m7751m(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[263] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo13967n(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mediaListDescriptionChanged = this.view.mediaListDescriptionChanged();
        $jacocoInit[262] = true;
        return mediaListDescriptionChanged;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7737g(EditorialEvent editorialEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialEvent.getFirstVisiblePosition() >= 0) {
            $jacocoInit[259] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[260] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[261] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ void mo13941h(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        int firstVisiblePosition = editorialEvent.getFirstVisiblePosition();
        $jacocoInit[253] = true;
        int lastVisibleItemPosition = editorialEvent.getLastVisibleItemPosition();
        $jacocoInit[254] = true;
        if (isOnlyOneMediaVisible(firstVisiblePosition, lastVisibleItemPosition)) {
            $jacocoInit[255] = true;
            this.view.manageMediaListDescriptionAnimationVisibility(editorialEvent);
            $jacocoInit[256] = true;
        } else {
            this.view.setMediaListDescriptionsVisible(editorialEvent);
            $jacocoInit[257] = true;
        }
        $jacocoInit[258] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m7745i(EditorialEvent __) {
        $jacocoInit()[252] = true;
    }

    public void handleMovingCollapse() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3079Ga ga = C3079Ga.f6418a;
        $jacocoInit[116] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ga);
        C3125W w = new C3125W(this);
        $jacocoInit[117] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) w);
        C0126V v = this.viewScheduler;
        $jacocoInit[118] = true;
        C0120S a = f.mo3616a(v);
        C3200pa paVar = new C3200pa(this);
        $jacocoInit[119] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) paVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[120] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3077Fb fb = C3077Fb.f6416a;
        C3053Aa aa = new C3053Aa(this);
        $jacocoInit[121] = true;
        a2.mo3626a((C0129b<? super T>) fb, (C0129b<Throwable>) aa);
        $jacocoInit[122] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m7752o(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[251] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo13970p(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S handleMovingCollapse = this.view.handleMovingCollapse();
        $jacocoInit[250] = true;
        return handleMovingCollapse;
    }

    /* renamed from: b */
    public /* synthetic */ void mo13919b(Boolean isItemShown) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isItemShown.booleanValue()) {
            $jacocoInit[246] = true;
            this.view.removeBottomCardAnimation();
            $jacocoInit[247] = true;
        } else {
            this.view.addBottomCardAnimation();
            $jacocoInit[248] = true;
        }
        $jacocoInit[249] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7728c(Boolean __) {
        $jacocoInit()[245] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13924c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[244] = true;
    }

    private C0120S<LoadReactionModel> handleSinglePressReactionButton(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialManager editorialManager2 = this.editorialManager;
        String cardId = editorialViewModel.getCardId();
        $jacocoInit[123] = true;
        String groupId = editorialViewModel.getGroupId();
        $jacocoInit[124] = true;
        Single isFirstReaction = editorialManager2.isFirstReaction(cardId, groupId);
        C3127Wb wb = new C3127Wb(this, editorialViewModel);
        $jacocoInit[125] = true;
        C0120S<LoadReactionModel> c = isFirstReaction.mo3697c(wb);
        $jacocoInit[126] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13902a(EditorialViewModel editorialViewModel, Boolean firstReaction) {
        boolean[] $jacocoInit = $jacocoInit();
        if (firstReaction.booleanValue()) {
            $jacocoInit[227] = true;
            this.editorialAnalytics.sendReactionButtonClickEvent();
            $jacocoInit[228] = true;
            EditorialView editorialView = this.view;
            String cardId = editorialViewModel.getCardId();
            $jacocoInit[229] = true;
            String groupId = editorialViewModel.getGroupId();
            $jacocoInit[230] = true;
            editorialView.showReactionsPopup(cardId, groupId);
            $jacocoInit[231] = true;
            C0120S c = C0120S.m652c(new LoadReactionModel());
            $jacocoInit[232] = true;
            return c;
        }
        EditorialManager editorialManager2 = this.editorialManager;
        String cardId2 = editorialViewModel.getCardId();
        $jacocoInit[233] = true;
        String groupId2 = editorialViewModel.getGroupId();
        $jacocoInit[234] = true;
        Single deleteReaction = editorialManager2.deleteReaction(cardId2, groupId2);
        $jacocoInit[235] = true;
        C0120S c2 = deleteReaction.mo3696c();
        C3136Zb zb = new C3136Zb(this);
        $jacocoInit[236] = true;
        C0120S b = c2.mo3636b((C0129b<? super T>) zb);
        C3139a aVar = C3139a.f6499a;
        $jacocoInit[237] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) aVar);
        C3115Sb sb = new C3115Sb(this, editorialViewModel);
        $jacocoInit[238] = true;
        C0120S i = d.mo3668i(sb);
        $jacocoInit[239] = true;
        return i;
    }

    /* renamed from: b */
    public /* synthetic */ void mo13918b(ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        handleReactionsResponse(reactionsResponse, true);
        $jacocoInit[243] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo13905a(EditorialViewModel editorialViewModel, ReactionsResponse __) {
        boolean[] $jacocoInit = $jacocoInit();
        String cardId = editorialViewModel.getCardId();
        $jacocoInit[240] = true;
        String groupId = editorialViewModel.getGroupId();
        $jacocoInit[241] = true;
        Single loadReactionModel = loadReactionModel(cardId, groupId);
        $jacocoInit[242] = true;
        return loadReactionModel;
    }

    private Single<LoadReactionModel> loadReactionModel(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = this.editorialManager.loadReactionModel(cardId, groupId);
        C0126V v = this.viewScheduler;
        $jacocoInit[127] = true;
        Single a = loadReactionModel.mo3686a(v);
        C3189mb mbVar = new C3189mb(this);
        $jacocoInit[128] = true;
        Single<LoadReactionModel> b = a.mo3695b((C0129b<? super T>) mbVar);
        $jacocoInit[129] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13923c(LoadReactionModel reactionModel) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialView editorialView = this.view;
        String myReaction = reactionModel.getMyReaction();
        $jacocoInit[224] = true;
        List topReactionList = reactionModel.getTopReactionList();
        int total = reactionModel.getTotal();
        $jacocoInit[225] = true;
        editorialView.showTopReactions(myReaction, topReactionList, total);
        $jacocoInit[226] = true;
    }

    private void handleReactionsResponse(ReactionsResponse reactionsResponse, boolean isDelete) {
        boolean[] $jacocoInit = $jacocoInit();
        if (reactionsResponse.wasSuccess()) {
            if (isDelete) {
                $jacocoInit[130] = true;
                this.editorialAnalytics.sendDeletedEvent();
                $jacocoInit[131] = true;
            } else {
                this.editorialAnalytics.sendReactedEvent();
                $jacocoInit[132] = true;
            }
        } else if (reactionsResponse.reactionsExceeded()) {
            $jacocoInit[133] = true;
            this.view.showLoginDialog();
            $jacocoInit[134] = true;
        } else if (reactionsResponse.wasNetworkError()) {
            $jacocoInit[135] = true;
            this.view.showNetworkErrorToast();
            $jacocoInit[136] = true;
        } else if (!reactionsResponse.wasGeneralError()) {
            $jacocoInit[137] = true;
        } else {
            $jacocoInit[138] = true;
            this.view.showGenericErrorToast();
            $jacocoInit[139] = true;
        }
        $jacocoInit[140] = true;
    }

    private boolean isOnlyOneMediaVisible(int firstVisiblePosition, int lastVisiblePosition) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (firstVisiblePosition == lastVisiblePosition) {
            $jacocoInit[141] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[142] = true;
        }
        $jacocoInit[143] = true;
        return z;
    }

    private C0117M downgradeApp(EditorialDownloadEvent downloadEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showDowngradeMessage = this.view.showDowngradeMessage();
        C3208ra raVar = C3208ra.f6578a;
        $jacocoInit[144] = true;
        C0120S d = showDowngradeMessage.mo3653d((C0132p<? super T, Boolean>) raVar);
        C3111Ra ra = new C3111Ra(this, downloadEvent);
        $jacocoInit[145] = true;
        C0120S g = d.mo3663g((C0132p<? super T, ? extends C0117M>) ra);
        $jacocoInit[146] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[147] = true;
        return l;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7717a(Boolean downgrade) {
        $jacocoInit()[223] = true;
        return downgrade;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo13898a(EditorialDownloadEvent downloadEvent, Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M downloadApp = downloadApp(downloadEvent);
        $jacocoInit[222] = true;
        return downloadApp;
    }

    private C0120S<EditorialViewModel> setUpViewModelOnViewReady() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isViewReady = this.view.isViewReady();
        C3114Sa sa = new C3114Sa(this);
        $jacocoInit[148] = true;
        C0120S<EditorialViewModel> f = isViewReady.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sa);
        $jacocoInit[149] = true;
        return f;
    }

    /* renamed from: m */
    public /* synthetic */ C0120S mo13966m(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialViewModel = this.editorialManager.loadEditorialViewModel();
        $jacocoInit[220] = true;
        C0120S c = loadEditorialViewModel.mo3696c();
        $jacocoInit[221] = true;
        return c;
    }

    public void handleReactionButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3098Mb mb = C3098Mb.f6447a;
        $jacocoInit[150] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mb);
        C3138_b _bVar = new C3138_b(this);
        $jacocoInit[151] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) _bVar);
        C3218ua uaVar = new C3218ua(this);
        $jacocoInit[152] = true;
        C0120S i = f.mo3668i(uaVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[153] = true;
        C0120S a = i.mo3616a(v);
        C3228xb xbVar = new C3228xb(this);
        $jacocoInit[154] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xbVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[155] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3092Kb kb = C3092Kb.f6437a;
        C3215ta taVar = new C3215ta(this);
        $jacocoInit[156] = true;
        a2.mo3626a((C0129b<? super T>) kb, (C0129b<Throwable>) taVar);
        $jacocoInit[157] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m7755u(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[219] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo13973v(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionsButtonClicked = this.view.reactionsButtonClicked();
        $jacocoInit[218] = true;
        return reactionsButtonClicked;
    }

    /* renamed from: e */
    public /* synthetic */ Single mo13930e(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialViewModel = this.editorialManager.loadEditorialViewModel();
        $jacocoInit[217] = true;
        return loadEditorialViewModel;
    }

    /* renamed from: e */
    public /* synthetic */ C0120S mo13929e(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S handleSinglePressReactionButton = handleSinglePressReactionButton(editorialViewModel);
        $jacocoInit[216] = true;
        return handleSinglePressReactionButton;
    }

    /* renamed from: a */
    static /* synthetic */ void m7720a(LoadReactionModel lifecycleEvent) {
        $jacocoInit()[215] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo13935f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[214] = true;
    }

    public void handleUserReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3101Nb nb = C3101Nb.f6452a;
        $jacocoInit[158] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nb);
        C3165gb gbVar = new C3165gb(this);
        $jacocoInit[159] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gbVar);
        C3172ia iaVar = new C3172ia(this);
        $jacocoInit[160] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iaVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[161] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3224wa waVar = C3224wa.f6596a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[162] = true;
        a.mo3626a((C0129b<? super T>) waVar, (C0129b<Throwable>) cVar);
        $jacocoInit[163] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m7710A(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[213] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo13889B(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionClicked = this.view.reactionClicked();
        $jacocoInit[212] = true;
        return reactionClicked;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13903a(ReactionEvent reactionEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialManager editorialManager2 = this.editorialManager;
        String cardId = reactionEvent.getCardId();
        $jacocoInit[201] = true;
        String groupId = reactionEvent.getGroupId();
        String reactionType = reactionEvent.getReactionType();
        $jacocoInit[202] = true;
        Single reaction = editorialManager2.setReaction(cardId, groupId, reactionType);
        $jacocoInit[203] = true;
        C0120S c = reaction.mo3696c();
        C3202pc pcVar = C3202pc.f6569a;
        $jacocoInit[204] = true;
        C0120S d = c.mo3653d((C0132p<? super T, Boolean>) pcVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[205] = true;
        C0120S a = d.mo3616a(v);
        C3154dc dcVar = new C3154dc(this);
        $jacocoInit[206] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) dcVar);
        C3139a aVar = C3139a.f6499a;
        $jacocoInit[207] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) aVar);
        C3173ib ibVar = new C3173ib(this, reactionEvent);
        $jacocoInit[208] = true;
        C0120S i = d2.mo3668i(ibVar);
        $jacocoInit[209] = true;
        return i;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13910a(ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        handleReactionsResponse(reactionsResponse, false);
        $jacocoInit[211] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo13906a(ReactionEvent reactionEvent, ReactionsResponse __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = loadReactionModel(reactionEvent.getCardId(), reactionEvent.getGroupId());
        $jacocoInit[210] = true;
        return loadReactionModel;
    }

    /* renamed from: b */
    static /* synthetic */ void m7725b(LoadReactionModel lifecycleEvent) {
        $jacocoInit()[200] = true;
    }

    public void handleLongPressReactionButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3156ea eaVar = C3156ea.f6518a;
        $jacocoInit[164] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) eaVar);
        C3094La la = new C3094La(this);
        $jacocoInit[165] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) la);
        C3128X x = new C3128X(this);
        $jacocoInit[166] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) x);
        C3054Ab ab = new C3054Ab(this);
        $jacocoInit[167] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) ab);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[168] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3234zb zbVar = C3234zb.f6608a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[169] = true;
        a.mo3626a((C0129b<? super T>) zbVar, (C0129b<Throwable>) cVar);
        $jacocoInit[170] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7748k(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[199] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo13963l(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionsButtonLongPressed = this.view.reactionsButtonLongPressed();
        $jacocoInit[198] = true;
        return reactionsButtonLongPressed;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13917b(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialViewModel = this.editorialManager.loadEditorialViewModel();
        $jacocoInit[196] = true;
        C0120S c = loadEditorialViewModel.mo3696c();
        $jacocoInit[197] = true;
        return c;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13922c(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialAnalytics.sendReactionButtonClickEvent();
        $jacocoInit[194] = true;
        this.view.showReactionsPopup(editorialViewModel.getCardId(), editorialViewModel.getGroupId());
        $jacocoInit[195] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7731d(EditorialViewModel lifecycleEvent) {
        $jacocoInit()[193] = true;
    }

    public void handleSnackLogInClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3193nb nbVar = C3193nb.f6559a;
        $jacocoInit[171] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nbVar);
        C3107Pb pb = new C3107Pb(this);
        $jacocoInit[172] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pb);
        C3122V v = new C3122V(this);
        $jacocoInit[173] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) v);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[174] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3117Ta ta = C3117Ta.f6474a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[175] = true;
        a.mo3626a((C0129b<? super T>) ta, (C0129b<Throwable>) cVar);
        $jacocoInit[176] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m7757y(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[192] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo13975z(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S snackLoginClick = this.view.snackLoginClick();
        $jacocoInit[191] = true;
        return snackLoginClick;
    }

    /* renamed from: f */
    public /* synthetic */ void mo13936f(Void homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialNavigator.navigateToLogIn();
        $jacocoInit[190] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m7741g(Void lifecycleEvent) {
        $jacocoInit()[189] = true;
    }

    public void onCreateLoadReactionModel() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3168ha haVar = C3168ha.f6532a;
        $jacocoInit[177] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) haVar);
        C3196oa oaVar = new C3196oa(this);
        $jacocoInit[178] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oaVar);
        C3177jb jbVar = new C3177jb(this);
        $jacocoInit[179] = true;
        C0120S i = f.mo3668i(jbVar);
        EditorialView editorialView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[180] = true;
        C0120S a = i.mo3614a((C0121c<? super T, ? extends R>) editorialView.bindUntilEvent(lifecycleEvent2));
        C3169hb hbVar = C3169hb.f6533a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3147c cVar = new C3147c(crashReport);
        $jacocoInit[181] = true;
        a.mo3626a((C0129b<? super T>) hbVar, (C0129b<Throwable>) cVar);
        $jacocoInit[182] = true;
    }

    /* renamed from: H */
    static /* synthetic */ Boolean m7713H(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[188] = true;
        return valueOf;
    }

    /* renamed from: I */
    public /* synthetic */ C0120S mo13893I(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S upViewModelOnViewReady = setUpViewModelOnViewReady();
        $jacocoInit[187] = true;
        return upViewModelOnViewReady;
    }

    /* renamed from: k */
    public /* synthetic */ Single mo13960k(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        String cardId = editorialViewModel.getCardId();
        $jacocoInit[184] = true;
        String groupId = editorialViewModel.getGroupId();
        $jacocoInit[185] = true;
        Single loadReactionModel = loadReactionModel(cardId, groupId);
        $jacocoInit[186] = true;
        return loadReactionModel;
    }

    /* renamed from: d */
    static /* synthetic */ void m7732d(LoadReactionModel lifecycleEvent) {
        $jacocoInit()[183] = true;
    }
}
