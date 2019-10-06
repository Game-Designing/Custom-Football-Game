package p005cm.aptoide.p006pt.presenter;

import android.content.SharedPreferences;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateManager;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.InstallCompletedNotifier;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.notification.ContentPuller;
import p005cm.aptoide.p006pt.notification.NotificationSyncScheduler;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferences;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenManager;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p005cm.aptoide.p006pt.util.ApkFy;
import p005cm.aptoide.p006pt.view.DeepLinkManager;
import p005cm.aptoide.p006pt.view.wizard.WizardFragment;
import p019d.p022i.p023b.C0100e;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.presenter.MainPresenter */
public class MainPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApkFy apkFy;
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final AutoUpdateManager autoUpdateManager;
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final ContentPuller contentPuller;
    private final CrashReport crashReport;
    private final DeepLinkManager deepLinkManager;
    private final boolean firstCreated;
    private final FragmentNavigator fragmentNavigator;
    private final InstallCompletedNotifier installCompletedNotifier;
    private final InstallManager installManager;
    private final C0126V ioScheduler;
    private final NotificationSyncScheduler notificationSyncScheduler;
    private final RootInstallationRetryHandler rootInstallationRetryHandler;
    private final SharedPreferences securePreferences;
    private final SharedPreferences sharedPreferences;
    private final SplashScreenManager splashScreenManager;
    private final SplashScreenNavigator splashScreenNavigator;
    private final UpdatesManager updatesManager;
    private final MainView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7816290514694018154L, "cm/aptoide/pt/presenter/MainPresenter", Opcodes.ARETURN);
        $jacocoData = probes;
        return probes;
    }

    public MainPresenter(MainView view2, InstallManager installManager2, RootInstallationRetryHandler rootInstallationRetryHandler2, CrashReport crashReport2, ApkFy apkFy2, ContentPuller contentPuller2, NotificationSyncScheduler notificationSyncScheduler2, InstallCompletedNotifier installCompletedNotifier2, SharedPreferences sharedPreferences2, SharedPreferences securePreferences2, FragmentNavigator fragmentNavigator2, DeepLinkManager deepLinkManager2, boolean firstCreated2, AptoideBottomNavigator aptoideBottomNavigator2, C0126V viewScheduler2, C0126V ioScheduler2, BottomNavigationNavigator bottomNavigationNavigator2, UpdatesManager updatesManager2, AutoUpdateManager autoUpdateManager2, SplashScreenManager splashScreenManager2, SplashScreenNavigator splashScreenNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.installManager = installManager2;
        this.rootInstallationRetryHandler = rootInstallationRetryHandler2;
        this.crashReport = crashReport2;
        this.apkFy = apkFy2;
        this.contentPuller = contentPuller2;
        this.notificationSyncScheduler = notificationSyncScheduler2;
        this.installCompletedNotifier = installCompletedNotifier2;
        this.fragmentNavigator = fragmentNavigator2;
        this.deepLinkManager = deepLinkManager2;
        this.firstCreated = firstCreated2;
        this.sharedPreferences = sharedPreferences2;
        this.securePreferences = securePreferences2;
        this.aptoideBottomNavigator = aptoideBottomNavigator2;
        this.viewScheduler = viewScheduler2;
        this.ioScheduler = ioScheduler2;
        this.bottomNavigationNavigator = bottomNavigationNavigator2;
        this.updatesManager = updatesManager2;
        this.autoUpdateManager = autoUpdateManager2;
        this.splashScreenManager = splashScreenManager2;
        this.splashScreenNavigator = splashScreenNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4307Ia ia = C4307Ia.f7903a;
        $jacocoInit[1] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ia);
        C4398sb sbVar = new C4398sb(this);
        $jacocoInit[2] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) sbVar);
        C4315Ma ma = new C4315Ma(this);
        $jacocoInit[3] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) ma);
        C4413xb xbVar = new C4413xb(this);
        $jacocoInit[4] = true;
        C0120S b2 = d2.mo3636b((C0129b<? super T>) xbVar);
        MainView mainView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[5] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) mainView.bindUntilEvent(lifecycleEvent2));
        C4299Fb fb = new C4299Fb(this);
        $jacocoInit[6] = true;
        C0120S b3 = a.mo3636b((C0129b<? super T>) fb);
        C4389pb pbVar = new C4389pb(this);
        $jacocoInit[7] = true;
        C0120S b4 = b3.mo3636b((C0129b<? super T>) pbVar);
        C4328Ta ta = C4328Ta.f7924a;
        C4290Cb cb = new C4290Cb(this);
        $jacocoInit[8] = true;
        b4.mo3626a((C0129b<? super T>) ta, (C0129b<Throwable>) cb);
        $jacocoInit[9] = true;
        C0120S lifecycleEvent3 = this.view.getLifecycleEvent();
        C4350cb cbVar = C4350cb.f7946a;
        $jacocoInit[10] = true;
        C0120S d3 = lifecycleEvent3.mo3653d((C0132p<? super T, Boolean>) cbVar);
        C4334Wa wa = new C4334Wa(this);
        $jacocoInit[11] = true;
        C0120S f = d3.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wa);
        MainView mainView2 = this.view;
        LifecycleEvent lifecycleEvent4 = LifecycleEvent.DESTROY;
        $jacocoInit[12] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) mainView2.bindUntilEvent(lifecycleEvent4));
        C4377lb lbVar = C4377lb.f7973a;
        C4401tb tbVar = C4401tb.f7997a;
        $jacocoInit[13] = true;
        a2.mo3626a((C0129b<? super T>) lbVar, (C0129b<Throwable>) tbVar);
        $jacocoInit[14] = true;
        handleAutoUpdateDialogAccepted();
        $jacocoInit[15] = true;
        setupInstallErrorsDisplay();
        $jacocoInit[16] = true;
        shortcutManagement();
        $jacocoInit[17] = true;
        setupUpdatesNumber();
        $jacocoInit[18] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8752e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.CREATE.equals(event));
        $jacocoInit[175] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15460f(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apkFy.run();
        $jacocoInit[174] = true;
    }

    /* renamed from: h */
    public /* synthetic */ Boolean mo15464h(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.firstCreated);
        $jacocoInit[173] = true;
        return valueOf;
    }

    /* renamed from: i */
    public /* synthetic */ void mo15465i(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationSyncScheduler.forceSync();
        $jacocoInit[172] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo15467j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.contentPuller.start();
        $jacocoInit[171] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo15468k(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        navigate();
        $jacocoInit[170] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m8754l(LifecycleEvent __) {
        $jacocoInit()[169] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15457d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[168] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m8755m(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.CREATE.equals(lifecycleEvent));
        $jacocoInit[167] = true;
        return valueOf;
    }

    /* renamed from: g */
    public /* synthetic */ C0120S mo15462g(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigationEvent = this.aptoideBottomNavigator.navigationEvent();
        C0126V v = this.viewScheduler;
        $jacocoInit[162] = true;
        C0120S a = navigationEvent.mo3616a(v);
        C4332Va va = new C4332Va(this);
        $jacocoInit[163] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) va);
        $jacocoInit[164] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[165] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15447a(Integer fragmentid) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideBottomNavigator.showFragment(fragmentid);
        $jacocoInit[166] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8745b(Integer __) {
        $jacocoInit()[161] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8747c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[160] = true;
        throw onErrorNotImplementedException;
    }

    private void setupUpdatesNumber() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4340Za za = C4340Za.f7936a;
        $jacocoInit[19] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) za);
        C4338Ya ya = new C4338Ya(this);
        $jacocoInit[20] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ya);
        C0126V v = this.viewScheduler;
        $jacocoInit[21] = true;
        C0120S a = f.mo3616a(v);
        C4341_a _aVar = new C4341_a(this);
        $jacocoInit[22] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) _aVar);
        MainView mainView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[23] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) mainView.bindUntilEvent(lifecycleEvent2));
        C4365hb hbVar = C4365hb.f7961a;
        C4319Oa oa = C4319Oa.f7915a;
        $jacocoInit[24] = true;
        a2.mo3626a((C0129b<? super T>) hbVar, (C0129b<Throwable>) oa);
        $jacocoInit[25] = true;
    }

    /* renamed from: v */
    static /* synthetic */ Boolean m8760v(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (lifecycleEvent == LifecycleEvent.CREATE) {
            $jacocoInit[157] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[158] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[159] = true;
        return valueOf;
    }

    /* renamed from: w */
    public /* synthetic */ C0120S mo15473w(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updatesNumber = this.updatesManager.getUpdatesNumber();
        $jacocoInit[156] = true;
        return updatesNumber;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15454c(Integer updates) {
        boolean[] $jacocoInit = $jacocoInit();
        if (updates.intValue() > 0) {
            $jacocoInit[152] = true;
            this.view.showUpdatesNumber(updates);
            $jacocoInit[153] = true;
        } else {
            this.view.hideUpdatesBadge();
            $jacocoInit[154] = true;
        }
        $jacocoInit[155] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8750d(Integer __) {
        $jacocoInit()[151] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m8753h(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[150] = true;
        throw onErrorNotImplementedException;
    }

    private void setupInstallErrorsDisplay() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4284Ab ab = C4284Ab.f7880a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ab);
        C4311Ka ka = new C4311Ka(this);
        $jacocoInit[27] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ka);
        C4302Gb gb = C4302Gb.f7898a;
        $jacocoInit[28] = true;
        C0120S c = f.mo3645c((C0132p<? super T, ? extends U>) gb);
        C4374kb kbVar = C4374kb.f7970a;
        $jacocoInit[29] = true;
        C0120S d2 = c.mo3653d((C0132p<? super T, Boolean>) kbVar);
        $jacocoInit[30] = true;
        C0120S a = d2.mo3616a(C14522a.m46170a());
        MainView mainView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[31] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) mainView.bindUntilEvent(lifecycleEvent2));
        C4410wb wbVar = new C4410wb(this);
        C4304Ha ha = new C4304Ha(this);
        $jacocoInit[32] = true;
        a2.mo3626a((C0129b<? super T>) wbVar, (C0129b<Throwable>) ha);
        $jacocoInit[33] = true;
        C0120S lifecycleEvent3 = this.view.getLifecycleEvent();
        C4416yb ybVar = C4416yb.f8012a;
        $jacocoInit[34] = true;
        C0120S d3 = lifecycleEvent3.mo3653d((C0132p<? super T, Boolean>) ybVar);
        C4324Ra ra = new C4324Ra(this);
        $jacocoInit[35] = true;
        C0120S f2 = d3.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ra);
        C4380mb mbVar = C4380mb.f7976a;
        $jacocoInit[36] = true;
        C0120S d4 = f2.mo3653d((C0132p<? super T, Boolean>) mbVar);
        $jacocoInit[37] = true;
        C0120S a3 = d4.mo3616a(C14522a.m46170a());
        MainView mainView2 = this.view;
        LifecycleEvent lifecycleEvent4 = LifecycleEvent.DESTROY;
        $jacocoInit[38] = true;
        C0120S a4 = a3.mo3614a((C0121c<? super T, ? extends R>) mainView2.bindUntilEvent(lifecycleEvent4));
        C4353db dbVar = new C4353db(this);
        C4309Ja ja = new C4309Ja(this);
        $jacocoInit[39] = true;
        a4.mo3626a((C0129b<? super T>) dbVar, (C0129b<Throwable>) ja);
        $jacocoInit[40] = true;
        C0120S lifecycleEvent5 = this.view.getLifecycleEvent();
        C4359fb fbVar = C4359fb.f7955a;
        $jacocoInit[41] = true;
        C0120S d5 = lifecycleEvent5.mo3653d((C0132p<? super T, Boolean>) fbVar);
        C4356eb ebVar = new C4356eb(this);
        $jacocoInit[42] = true;
        C0120S f3 = d5.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ebVar);
        MainView mainView3 = this.view;
        LifecycleEvent lifecycleEvent6 = LifecycleEvent.DESTROY;
        $jacocoInit[43] = true;
        C0120S a5 = f3.mo3614a((C0121c<? super T, ? extends R>) mainView3.bindUntilEvent(lifecycleEvent6));
        C4362gb gbVar = new C4362gb(this);
        $jacocoInit[44] = true;
        a5.mo3646c((C0129b<? super T>) gbVar);
        $jacocoInit[45] = true;
        C0120S lifecycleEvent7 = this.view.getLifecycleEvent();
        C4287Bb bb = C4287Bb.f7883a;
        $jacocoInit[46] = true;
        C0120S d6 = lifecycleEvent7.mo3653d((C0132p<? super T, Boolean>) bb);
        C4419zb zbVar = new C4419zb(this);
        $jacocoInit[47] = true;
        C0120S f4 = d6.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zbVar);
        C4323Qa qa = new C4323Qa(this);
        $jacocoInit[48] = true;
        C0120S g = f4.mo3663g((C0132p<? super T, ? extends C0117M>) qa);
        MainView mainView4 = this.view;
        LifecycleEvent lifecycleEvent8 = LifecycleEvent.DESTROY;
        $jacocoInit[49] = true;
        C0120S a6 = g.mo3614a((C0121c<? super T, ? extends R>) mainView4.bindUntilEvent(lifecycleEvent8));
        C4330Ua ua = C4330Ua.f7926a;
        C4392qb qbVar = new C4392qb(this);
        $jacocoInit[50] = true;
        a6.mo3626a((C0129b<? super T>) ua, (C0129b<Throwable>) qbVar);
        $jacocoInit[51] = true;
    }

    /* renamed from: n */
    static /* synthetic */ Boolean m8756n(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.RESUME.equals(event));
        $jacocoInit[149] = true;
        return valueOf;
    }

    /* renamed from: o */
    public /* synthetic */ C0120S mo15469o(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S retries = this.rootInstallationRetryHandler.retries();
        MainView mainView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.PAUSE;
        $jacocoInit[147] = true;
        C0120S a = retries.mo3614a((C0121c<? super T, ? extends R>) mainView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[148] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Integer m8741a(List installationProgresses) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(installationProgresses.size());
        $jacocoInit[146] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8742b(List installationProgresses) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!installationProgresses.isEmpty()) {
            $jacocoInit[143] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[144] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[145] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15455c(List installationProgresses) {
        boolean[] $jacocoInit = $jacocoInit();
        watchInstalls(installationProgresses);
        $jacocoInit[141] = true;
        this.view.showInstallationError(installationProgresses.size());
        $jacocoInit[142] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15458e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[140] = true;
    }

    /* renamed from: p */
    static /* synthetic */ Boolean m8757p(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.RESUME.equals(lifecycleEvent));
        $jacocoInit[139] = true;
        return valueOf;
    }

    /* renamed from: q */
    public /* synthetic */ C0120S mo15470q(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S timedOutInstallations = this.installManager.getTimedOutInstallations();
        $jacocoInit[138] = true;
        return timedOutInstallations;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m8748d(List installationProgresses) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!installationProgresses.isEmpty()) {
            $jacocoInit[135] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[136] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[137] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15459e(List noInstallErrors) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissInstallationError();
        $jacocoInit[134] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15461f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[133] = true;
    }

    /* renamed from: r */
    static /* synthetic */ Boolean m8758r(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.RESUME.equals(lifecycleEvent));
        $jacocoInit[132] = true;
        return valueOf;
    }

    /* renamed from: s */
    public /* synthetic */ C0120S mo15471s(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e watcher = this.installCompletedNotifier.getWatcher();
        $jacocoInit[131] = true;
        return watcher;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15451b(Void allInstallsCompleted) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showInstallationSuccessMessage();
        $jacocoInit[130] = true;
    }

    /* renamed from: t */
    static /* synthetic */ Boolean m8759t(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.RESUME.equals(lifecycleEvent));
        $jacocoInit[129] = true;
        return valueOf;
    }

    /* renamed from: u */
    public /* synthetic */ C0120S mo15472u(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installErrorsDismiss = this.view.getInstallErrorsDismiss();
        $jacocoInit[128] = true;
        return installErrorsDismiss;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo15452c(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M cleanTimedOutInstalls = this.installManager.cleanTimedOutInstalls();
        $jacocoInit[127] = true;
        return cleanTimedOutInstalls;
    }

    /* renamed from: d */
    static /* synthetic */ void m8751d(Void timeoutErrorsCleaned) {
        $jacocoInit()[126] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo15463g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[125] = true;
    }

    private void shortcutManagement() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4368ib ibVar = C4368ib.f7964a;
        $jacocoInit[52] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ibVar);
        $jacocoInit[53] = true;
        C0120S d2 = d.mo3647d();
        C4407vb vbVar = new C4407vb(this);
        C4386ob obVar = new C4386ob(this);
        $jacocoInit[54] = true;
        d2.mo3626a((C0129b<? super T>) vbVar, (C0129b<Throwable>) obVar);
        $jacocoInit[55] = true;
    }

    /* renamed from: x */
    static /* synthetic */ Boolean m8761x(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.DESTROY));
        $jacocoInit[124] = true;
        return valueOf;
    }

    /* renamed from: y */
    public /* synthetic */ void mo15474y(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.deepLinkManager.freeSubscriptions();
        $jacocoInit[123] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo15466i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[122] = true;
    }

    private void navigate() {
        boolean[] $jacocoInit = $jacocoInit();
        showHome();
        $jacocoInit[56] = true;
        if (!ManagerPreferences.isCheckAutoUpdateEnable(this.sharedPreferences)) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            if (AptoideApplication.isAutoUpdateWasCalled()) {
                $jacocoInit[59] = true;
            } else {
                $jacocoInit[60] = true;
                handleAutoUpdate();
                $jacocoInit[61] = true;
            }
        }
        if (this.deepLinkManager.showDeepLink(this.view.getIntentAfterCreate())) {
            $jacocoInit[62] = true;
            SecurePreferences.setWizardAvailable(false, this.securePreferences);
            $jacocoInit[63] = true;
        } else if (SecurePreferences.isWizardAvailable(this.securePreferences)) {
            $jacocoInit[64] = true;
            showWizard();
            $jacocoInit[65] = true;
            SecurePreferences.setWizardAvailable(false, this.securePreferences);
            $jacocoInit[66] = true;
        } else if (!this.splashScreenManager.shouldShowSplashScreen()) {
            $jacocoInit[67] = true;
        } else {
            $jacocoInit[68] = true;
            this.splashScreenNavigator.navigateToSplashScreen();
            $jacocoInit[69] = true;
        }
        $jacocoInit[70] = true;
    }

    private void handleAutoUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4371jb jbVar = C4371jb.f7967a;
        $jacocoInit[71] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jbVar);
        C0126V v = this.ioScheduler;
        $jacocoInit[72] = true;
        C0120S a = d.mo3616a(v);
        C4404ub ubVar = new C4404ub(this);
        $jacocoInit[73] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ubVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[74] = true;
        C0120S a2 = f.mo3616a(v2);
        C4326Sa sa = C4326Sa.f7922a;
        $jacocoInit[75] = true;
        C0120S d2 = a2.mo3653d((C0132p<? super T, Boolean>) sa);
        C4293Db db = C4293Db.f7889a;
        $jacocoInit[76] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) db);
        C4296Eb eb = new C4296Eb(this);
        $jacocoInit[77] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) eb);
        MainView mainView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[78] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) mainView.bindUntilEvent(lifecycleEvent2));
        C4321Pa pa = C4321Pa.f7917a;
        C4336Xa xa = new C4336Xa(this);
        $jacocoInit[79] = true;
        a3.mo3626a((C0129b<? super T>) pa, (C0129b<Throwable>) xa);
        $jacocoInit[80] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8739a(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.CREATE.equals(lifecycleEvent));
        $jacocoInit[121] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15449b(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S shouldUpdate = this.autoUpdateManager.shouldUpdate();
        $jacocoInit[120] = true;
        return shouldUpdate;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8740a(Boolean shouldUpdate) {
        $jacocoInit()[119] = true;
        return shouldUpdate;
    }

    /* renamed from: b */
    static /* synthetic */ void m8744b(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplication.setAutoUpdateWasCalled(true);
        $jacocoInit[118] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15453c(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.requestAutoUpdate();
        $jacocoInit[117] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8749d(Boolean __) {
        $jacocoInit()[116] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15448a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[115] = true;
    }

    private void showWizard() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(WizardFragment.newInstance(), true);
        $jacocoInit[81] = true;
    }

    private void showHome() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator.navigateToHome();
        $jacocoInit[82] = true;
    }

    private void handleAutoUpdateDialogAccepted() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4395rb rbVar = C4395rb.f7991a;
        $jacocoInit[83] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) rbVar);
        C4313La la = new C4313La(this);
        $jacocoInit[84] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) la);
        C0126V v = this.viewScheduler;
        $jacocoInit[85] = true;
        C0120S a = f.mo3616a(v);
        AutoUpdateManager autoUpdateManager2 = this.autoUpdateManager;
        autoUpdateManager2.getClass();
        C4342a aVar = new C4342a(autoUpdateManager2);
        $jacocoInit[86] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        C0126V v2 = this.ioScheduler;
        $jacocoInit[87] = true;
        C0120S a2 = f2.mo3616a(v2);
        C4317Na na = new C4317Na(this);
        $jacocoInit[88] = true;
        C0120S f3 = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) na);
        C0126V v3 = this.viewScheduler;
        $jacocoInit[89] = true;
        C0120S a3 = f3.mo3616a(v3);
        C4344ab abVar = new C4344ab(this);
        $jacocoInit[90] = true;
        C0120S b = a3.mo3636b((C0129b<? super T>) abVar);
        MainView mainView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[91] = true;
        C0120S a4 = b.mo3614a((C0121c<? super T, ? extends R>) mainView.bindUntilEvent(lifecycleEvent2));
        C4347bb bbVar = C4347bb.f7943a;
        C4383nb nbVar = new C4383nb(this);
        $jacocoInit[92] = true;
        a4.mo3626a((C0129b<? super T>) bbVar, (C0129b<Throwable>) nbVar);
        $jacocoInit[93] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8746c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.CREATE.equals(lifecycleEvent));
        $jacocoInit[114] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo15456d(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S autoUpdateDialogCreated = this.view.autoUpdateDialogCreated();
        $jacocoInit[113] = true;
        return autoUpdateDialogCreated;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15445a(Void success) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S startUpdate = this.autoUpdateManager.startUpdate();
        $jacocoInit[112] = true;
        return startUpdate;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15446a(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        handleAutoUpdateResult(install.isFailed());
        $jacocoInit[111] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8743b(Install timeoutErrorsCleaned) {
        $jacocoInit()[110] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15450b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        handleErrorResult(throwable);
        $jacocoInit[108] = true;
        this.crashReport.log(throwable);
        $jacocoInit[109] = true;
    }

    private void watchInstalls(List<Install> installs) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[94] = true;
        for (Install install : installs) {
            $jacocoInit[95] = true;
            InstallCompletedNotifier installCompletedNotifier2 = this.installCompletedNotifier;
            String packageName = install.getPackageName();
            int versionCode = install.getVersionCode();
            $jacocoInit[96] = true;
            String md5 = install.getMd5();
            $jacocoInit[97] = true;
            installCompletedNotifier2.add(packageName, versionCode, md5);
            $jacocoInit[98] = true;
        }
        $jacocoInit[99] = true;
    }

    private void handleAutoUpdateResult(boolean installFailed) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissAutoUpdateDialog();
        if (!installFailed) {
            $jacocoInit[100] = true;
        } else {
            $jacocoInit[101] = true;
            this.view.showUnknownErrorMessage();
            $jacocoInit[102] = true;
        }
        $jacocoInit[103] = true;
    }

    private void handleErrorResult(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissAutoUpdateDialog();
        if (throwable instanceof SecurityException) {
            $jacocoInit[104] = true;
        } else {
            $jacocoInit[105] = true;
            this.view.showUnknownErrorMessage();
            $jacocoInit[106] = true;
        }
        $jacocoInit[107] = true;
    }
}
