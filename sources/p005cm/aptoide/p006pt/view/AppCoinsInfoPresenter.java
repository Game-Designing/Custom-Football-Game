package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.AppCoinsInfoView;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.AppCoinsInfoPresenter */
public class AppCoinsInfoPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppCoinsInfoNavigator appCoinsInfoNavigator;
    private final String appcWalletPackageName;
    private final CrashReport crashReport;
    private final InstallManager installManager;
    private final AppCoinsInfoView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8975158217892413581L, "cm/aptoide/pt/view/AppCoinsInfoPresenter", 39);
        $jacocoData = probes;
        return probes;
    }

    public AppCoinsInfoPresenter(AppCoinsInfoView view2, AppCoinsInfoNavigator appCoinsInfoNavigator2, InstallManager installManager2, CrashReport crashReport2, String appcWalletPackageName2, C0126V viewScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.appCoinsInfoNavigator = appCoinsInfoNavigator2;
        this.installManager = installManager2;
        this.crashReport = crashReport2;
        this.appcWalletPackageName = appcWalletPackageName2;
        this.viewScheduler = viewScheduler2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleClickOnAppcWalletLink();
        $jacocoInit[1] = true;
        handleClickOnInstallButton();
        $jacocoInit[2] = true;
        handleButtonText();
        $jacocoInit[3] = true;
    }

    public void handleClickOnInstallButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5316d dVar = C5316d.f9091a;
        $jacocoInit[4] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) dVar);
        C5351j jVar = new C5351j(this);
        $jacocoInit[5] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jVar);
        C5350i iVar = new C5350i(this);
        $jacocoInit[6] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[7] = true;
        C0120S a = f2.mo3616a(v);
        C5336e eVar = new C5336e(this);
        $jacocoInit[8] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) eVar);
        AppCoinsInfoView appCoinsInfoView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[9] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) appCoinsInfoView.bindUntilEvent(lifecycleEvent2));
        C5349h hVar = C5349h.f9147a;
        CrashReport crashReport2 = this.crashReport;
        crashReport2.getClass();
        C5224a aVar = new C5224a(crashReport2);
        $jacocoInit[10] = true;
        a2.mo3626a((C0129b<? super T>) hVar, (C0129b<Throwable>) aVar);
        $jacocoInit[11] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9490e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[38] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo16862f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(this.view.installButtonClick(), this.view.cardViewClick());
        $jacocoInit[37] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo16860c(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isInstalled = this.installManager.isInstalled(this.appcWalletPackageName);
        $jacocoInit[36] = true;
        return isInstalled;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16859b(Boolean isInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isInstalled.booleanValue()) {
            $jacocoInit[32] = true;
            this.view.openApp(this.appcWalletPackageName);
            $jacocoInit[33] = true;
        } else {
            this.appCoinsInfoNavigator.navigateToAppCoinsWallet();
            $jacocoInit[34] = true;
        }
        $jacocoInit[35] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9489c(Boolean __) {
        $jacocoInit()[31] = true;
    }

    public void handleClickOnAppcWalletLink() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5348g gVar = C5348g.f9146a;
        $jacocoInit[12] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) gVar);
        C5355n nVar = new C5355n(this);
        $jacocoInit[13] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nVar);
        C5352k kVar = new C5352k(this);
        $jacocoInit[14] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) kVar);
        AppCoinsInfoView appCoinsInfoView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[15] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appCoinsInfoView.bindUntilEvent(lifecycleEvent2));
        C5337f fVar = C5337f.f9136a;
        CrashReport crashReport2 = this.crashReport;
        crashReport2.getClass();
        C5224a aVar = new C5224a(crashReport2);
        $jacocoInit[16] = true;
        a.mo3626a((C0129b<? super T>) fVar, (C0129b<Throwable>) aVar);
        $jacocoInit[17] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9488c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[30] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo16861d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appCoinsWalletLinkClick = this.view.appCoinsWalletLinkClick();
        $jacocoInit[29] = true;
        return appCoinsWalletLinkClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16858a(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appCoinsInfoNavigator.navigateToAppCoinsWallet();
        $jacocoInit[28] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9487b(Void __) {
        $jacocoInit()[27] = true;
    }

    public void handleButtonText() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5354m mVar = C5354m.f9152a;
        $jacocoInit[18] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mVar);
        C5353l lVar = new C5353l(this);
        $jacocoInit[19] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lVar);
        AppCoinsInfoView appCoinsInfoView = this.view;
        appCoinsInfoView.getClass();
        C5222J j = new C5222J(appCoinsInfoView);
        $jacocoInit[20] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) j);
        AppCoinsInfoView appCoinsInfoView2 = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[21] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) appCoinsInfoView2.bindUntilEvent(lifecycleEvent2));
        C5311c cVar = C5311c.f9090a;
        CrashReport crashReport2 = this.crashReport;
        crashReport2.getClass();
        C5224a aVar = new C5224a(crashReport2);
        $jacocoInit[22] = true;
        a.mo3626a((C0129b<? super T>) cVar, (C0129b<Throwable>) aVar);
        $jacocoInit[23] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m9486b(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[26] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16857a(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isInstalled = this.installManager.isInstalled(this.appcWalletPackageName);
        $jacocoInit[25] = true;
        return isInstalled;
    }

    /* renamed from: a */
    static /* synthetic */ void m9485a(Boolean __) {
        $jacocoInit()[24] = true;
    }
}
