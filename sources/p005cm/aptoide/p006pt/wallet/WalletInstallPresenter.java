package p005cm.aptoide.p006pt.wallet;

import android.os.Build.VERSION;
import kotlin.C14268b;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter */
/* compiled from: WalletInstallPresenter.kt */
public final class WalletInstallPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: io */
    private final C0126V f9379io;
    private final WalletInstallNavigator navigator;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final WalletInstallView view;
    private final C0126V viewScheduler;
    private final WalletInstallManager walletInstallManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4353504006673122899L, "cm/aptoide/pt/wallet/WalletInstallPresenter", 69);
        $jacocoData = probes;
        return probes;
    }

    public WalletInstallPresenter(WalletInstallView view2, WalletInstallManager walletInstallManager2, WalletInstallNavigator navigator2, PermissionManager permissionManager2, PermissionService permissionService2, C0126V viewScheduler2, C0126V io) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(view2, "view");
        C14281f.m45916b(walletInstallManager2, "walletInstallManager");
        C14281f.m45916b(navigator2, "navigator");
        C14281f.m45916b(permissionManager2, "permissionManager");
        C14281f.m45916b(permissionService2, "permissionService");
        C14281f.m45916b(viewScheduler2, "viewScheduler");
        C14281f.m45916b(io, "io");
        $jacocoInit[61] = true;
        this.view = view2;
        this.walletInstallManager = walletInstallManager2;
        this.navigator = navigator2;
        this.permissionManager = permissionManager2;
        this.permissionService = permissionService2;
        this.viewScheduler = viewScheduler2;
        this.f9379io = io;
        $jacocoInit[62] = true;
    }

    public static final /* synthetic */ C0120S access$handleInstallDialogCancelButtonPress(WalletInstallPresenter $this) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S handleInstallDialogCancelButtonPress = $this.handleInstallDialogCancelButtonPress();
        $jacocoInit[68] = true;
        return handleInstallDialogCancelButtonPress;
    }

    public static final /* synthetic */ C0120S access$handleWalletInstallation(WalletInstallPresenter $this) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S handleWalletInstallation = $this.handleWalletInstallation();
        $jacocoInit[66] = true;
        return handleWalletInstallation;
    }

    public static final /* synthetic */ boolean access$hasMinimumSdk(WalletInstallPresenter $this) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasMinimumSdk = $this.hasMinimumSdk();
        $jacocoInit[63] = true;
        return hasMinimumSdk;
    }

    public static final /* synthetic */ C0120S access$observeDownloadProgress(WalletInstallPresenter $this, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S observeDownloadProgress = $this.observeDownloadProgress(walletApp);
        $jacocoInit[67] = true;
        return observeDownloadProgress;
    }

    public static final /* synthetic */ C0120S access$showWalletInitialState(WalletInstallPresenter $this) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showWalletInitialState = $this.showWalletInitialState();
        $jacocoInit[64] = true;
        return showWalletInitialState;
    }

    public static final /* synthetic */ C0117M access$startWalletDownload(WalletInstallPresenter $this, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M startWalletDownload = $this.startWalletDownload(walletApp);
        $jacocoInit[65] = true;
        return startWalletDownload;
    }

    public final WalletInstallView getView() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallView walletInstallView = this.view;
        $jacocoInit[54] = true;
        return walletInstallView;
    }

    public final WalletInstallManager getWalletInstallManager() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallManager walletInstallManager2 = this.walletInstallManager;
        $jacocoInit[55] = true;
        return walletInstallManager2;
    }

    public final WalletInstallNavigator getNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallNavigator walletInstallNavigator = this.navigator;
        $jacocoInit[56] = true;
        return walletInstallNavigator;
    }

    public final PermissionManager getPermissionManager() {
        boolean[] $jacocoInit = $jacocoInit();
        PermissionManager permissionManager2 = this.permissionManager;
        $jacocoInit[57] = true;
        return permissionManager2;
    }

    public final PermissionService getPermissionService() {
        boolean[] $jacocoInit = $jacocoInit();
        PermissionService permissionService2 = this.permissionService;
        $jacocoInit[58] = true;
        return permissionService2;
    }

    public final C0126V getIo() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V v = this.f9379io;
        $jacocoInit[60] = true;
        return v;
    }

    public final C0126V getViewScheduler() {
        boolean[] $jacocoInit = $jacocoInit();
        C0126V v = this.viewScheduler;
        $jacocoInit[59] = true;
        return v;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        loadWalletInstall();
        $jacocoInit[0] = true;
        handleCloseButtonClick();
        $jacocoInit[1] = true;
        handleCancelDownloadButton();
        $jacocoInit[2] = true;
        handleAnalyticsContextSetup();
        $jacocoInit[3] = true;
    }

    private final void handleAnalyticsContextSetup() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        $jacocoInit[4] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) WalletInstallPresenter$handleAnalyticsContextSetup$1.INSTANCE);
        $jacocoInit[5] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) new WalletInstallPresenter$handleAnalyticsContextSetup$2<Object>(this));
        $jacocoInit[6] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) this.view.bindUntilEvent(LifecycleEvent.DESTROY));
        $jacocoInit[7] = true;
        a.mo3626a((C0129b<? super T>) WalletInstallPresenter$handleAnalyticsContextSetup$3.INSTANCE, (C0129b<Throwable>) new WalletInstallPresenter$handleAnalyticsContextSetup$4<Throwable>(this));
        $jacocoInit[8] = true;
    }

    private final void handleCancelDownloadButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        $jacocoInit[9] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) WalletInstallPresenter$handleCancelDownloadButton$1.INSTANCE);
        $jacocoInit[10] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new WalletInstallPresenter$handleCancelDownloadButton$2<Object,Object>(this));
        $jacocoInit[11] = true;
        C0120S d2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new WalletInstallPresenter$handleCancelDownloadButton$3<Object,Object>(this)).mo3647d();
        $jacocoInit[12] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) new WalletInstallPresenter$handleCancelDownloadButton$4<Object>(this));
        $jacocoInit[13] = true;
        C0120S a = b.mo3616a(this.viewScheduler);
        $jacocoInit[14] = true;
        C0120S a2 = a.mo3620a((C0128a) new WalletInstallPresenter$handleCancelDownloadButton$5(this));
        $jacocoInit[15] = true;
        C0120S a3 = a2.mo3614a((C0121c<? super T, ? extends R>) this.view.bindUntilEvent(LifecycleEvent.DESTROY));
        $jacocoInit[16] = true;
        a3.mo3626a((C0129b<? super T>) WalletInstallPresenter$handleCancelDownloadButton$6.INSTANCE, (C0129b<Throwable>) new WalletInstallPresenter$handleCancelDownloadButton$7<Throwable>(this));
        $jacocoInit[17] = true;
    }

    private final C0120S<Boolean> handleWalletInstallation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.walletInstallManager.onWalletInstalled().mo3647d();
        $jacocoInit[18] = true;
        C0120S a = d.mo3616a(this.viewScheduler);
        $jacocoInit[19] = true;
        C0120S<Boolean> b = a.mo3636b((C0129b<? super T>) new WalletInstallPresenter$handleWalletInstallation$1<Object>(this));
        C14281f.m45913a((Object) b, "walletInstallManager.onW…stallationSuccessView() }");
        $jacocoInit[20] = true;
        return b;
    }

    private final void loadWalletInstall() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        $jacocoInit[21] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) WalletInstallPresenter$loadWalletInstall$1.INSTANCE);
        $jacocoInit[22] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) new WalletInstallPresenter$loadWalletInstall$2<Object>(this));
        $jacocoInit[23] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) new WalletInstallPresenter$loadWalletInstall$3<Object,Boolean>(this));
        $jacocoInit[24] = true;
        C0120S f = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new WalletInstallPresenter$loadWalletInstall$4<Object,Object>(this));
        $jacocoInit[25] = true;
        C0120S d3 = f.mo3653d((C0132p<? super T, Boolean>) WalletInstallPresenter$loadWalletInstall$5.INSTANCE);
        $jacocoInit[26] = true;
        C0120S a = d3.mo3616a(this.viewScheduler);
        $jacocoInit[27] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) new WalletInstallPresenter$loadWalletInstall$6<Object>(this));
        $jacocoInit[28] = true;
        C0120S f2 = b2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new WalletInstallPresenter$loadWalletInstall$7<Object,Object>(this));
        $jacocoInit[29] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) this.view.bindUntilEvent(LifecycleEvent.DESTROY));
        $jacocoInit[30] = true;
        a2.mo3626a((C0129b<? super T>) WalletInstallPresenter$loadWalletInstall$8.INSTANCE, (C0129b<Throwable>) new WalletInstallPresenter$loadWalletInstall$9<Throwable>(this));
        $jacocoInit[31] = true;
    }

    private final C0120S<WalletApp> observeDownloadProgress(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = this.walletInstallManager.loadDownloadModel(walletApp).mo3616a(this.viewScheduler);
        $jacocoInit[32] = true;
        C0120S<WalletApp> j = a.mo3636b((C0129b<? super T>) new WalletInstallPresenter$observeDownloadProgress$1<Object>(this)).mo3669j(new WalletInstallPresenter$observeDownloadProgress$2(walletApp));
        C14281f.m45913a((Object) j, "walletInstallManager.loa…e(it) }.map { walletApp }");
        $jacocoInit[33] = true;
        return j;
    }

    private final C0117M startWalletDownload(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m643a((C0131o<C0120S<T>>) new WalletInstallPresenter$startWalletDownload$1<C0120S<T>>(this, walletApp));
        $jacocoInit[34] = true;
        C0120S a2 = a.mo3616a(this.viewScheduler);
        $jacocoInit[35] = true;
        C0120S f = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new WalletInstallPresenter$startWalletDownload$2<Object,Object>(this, walletApp));
        $jacocoInit[36] = true;
        C0117M l = f.mo3673l();
        C14281f.m45913a((Object) l, "Observable.defer {\n     …        }.toCompletable()");
        $jacocoInit[37] = true;
        return l;
    }

    private final C0120S<C14268b<String, WalletApp>> showWalletInitialState() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appIcon = this.walletInstallManager.getAppIcon();
        $jacocoInit[38] = true;
        C0120S wallet = this.walletInstallManager.getWallet();
        WalletInstallPresenter$showWalletInitialState$1 walletInstallPresenter$showWalletInitialState$1 = WalletInstallPresenter$showWalletInitialState$1.INSTANCE;
        $jacocoInit[39] = true;
        C0120S b = C0120S.m650b(appIcon, wallet, (C14541q<? super T1, ? super T2, ? extends R>) walletInstallPresenter$showWalletInitialState$1);
        $jacocoInit[40] = true;
        C0120S a = b.mo3647d().mo3616a(this.viewScheduler);
        $jacocoInit[41] = true;
        C0120S<C14268b<String, WalletApp>> b2 = a.mo3636b((C0129b<? super T>) new WalletInstallPresenter$showWalletInitialState$2<Object>(this));
        $jacocoInit[42] = true;
        return b2;
    }

    private final boolean hasMinimumSdk() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 21) {
            $jacocoInit[43] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[44] = true;
        }
        $jacocoInit[45] = true;
        return z;
    }

    private final void handleCloseButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        $jacocoInit[46] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) WalletInstallPresenter$handleCloseButtonClick$1.INSTANCE);
        $jacocoInit[47] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new WalletInstallPresenter$handleCloseButtonClick$2<Object,Object>(this));
        $jacocoInit[48] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) new WalletInstallPresenter$handleCloseButtonClick$3<Object>(this));
        $jacocoInit[49] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) this.view.bindUntilEvent(LifecycleEvent.DESTROY));
        $jacocoInit[50] = true;
        a.mo3626a((C0129b<? super T>) WalletInstallPresenter$handleCloseButtonClick$4.INSTANCE, (C0129b<Throwable>) new WalletInstallPresenter$handleCloseButtonClick$5<Throwable>(this));
        $jacocoInit[51] = true;
    }

    private final C0120S<Boolean> handleInstallDialogCancelButtonPress() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.walletInstallManager.onWalletInstallationCanceled().mo3647d();
        $jacocoInit[52] = true;
        C0120S<Boolean> b = d.mo3636b((C0129b<? super T>) new WalletInstallPresenter$handleInstallDialogCancelButtonPress$1<Object>(this));
        C14281f.m45913a((Object) b, "walletInstallManager.onW… { view.dismissDialog() }");
        $jacocoInit[53] = true;
        return b;
    }
}
