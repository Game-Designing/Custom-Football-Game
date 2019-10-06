package p005cm.aptoide.p006pt.app.view;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.AdClick;
import p005cm.aptoide.p006pt.home.AdHomeEvent;
import p005cm.aptoide.p006pt.home.AdMapper;
import p005cm.aptoide.p006pt.home.AppHomeEvent;
import p005cm.aptoide.p006pt.home.ChipManager;
import p005cm.aptoide.p006pt.home.ChipManager.Chip;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p005cm.aptoide.p006pt.home.HomeBundle;
import p005cm.aptoide.p006pt.home.HomeBundlesModel;
import p005cm.aptoide.p006pt.home.HomeBundlesModel.Error;
import p005cm.aptoide.p006pt.home.HomeEvent;
import p005cm.aptoide.p006pt.home.HomeNavigator;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.BundleEvent;
import p005cm.aptoide.p006pt.view.app.Application;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.MoreBundlePresenter */
public class MoreBundlePresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdMapper adMapper;
    private final BundleEvent bundleEvent;
    private final ChipManager chipManager;
    private final CrashReport crashReporter;
    private final HomeAnalytics homeAnalytics;
    private final HomeNavigator homeNavigator;
    private final MoreBundleManager moreBundleManager;
    private final MoreBundleView view;
    private final C0126V viewScheduler;

    /* renamed from: cm.aptoide.pt.app.view.MoreBundlePresenter$1 */
    static /* synthetic */ class C18711 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$HomeBundlesModel$Error = new int[Error.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8156968527572457317L, "cm/aptoide/pt/app/view/MoreBundlePresenter$1", 6);
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
        boolean[] probes = Offline.getProbes(-6106605927186544510L, "cm/aptoide/pt/app/view/MoreBundlePresenter", 200);
        $jacocoData = probes;
        return probes;
    }

    public MoreBundlePresenter(MoreBundleView view2, MoreBundleManager moreBundleManager2, C0126V viewScheduler2, CrashReport crashReporter2, HomeNavigator homeNavigator2, AdMapper adMapper2, BundleEvent bundleEvent2, HomeAnalytics homeAnalytics2, ChipManager chipManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.moreBundleManager = moreBundleManager2;
        this.viewScheduler = viewScheduler2;
        this.crashReporter = crashReporter2;
        this.homeNavigator = homeNavigator2;
        this.adMapper = adMapper2;
        this.bundleEvent = bundleEvent2;
        this.homeAnalytics = homeAnalytics2;
        this.chipManager = chipManager2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onCreateSetupToolbar();
        $jacocoInit[1] = true;
        onCreateLoadBundles();
        $jacocoInit[2] = true;
        handleAppClick();
        $jacocoInit[3] = true;
        handleAdClick();
        $jacocoInit[4] = true;
        handleMoreClick();
        $jacocoInit[5] = true;
        handleBottomReached();
        $jacocoInit[6] = true;
        handlePullToRefresh();
        $jacocoInit[7] = true;
        handleRetryClick();
        $jacocoInit[8] = true;
        handleBundleScrolledRight();
        $jacocoInit[9] = true;
    }

    public void onCreateSetupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1860Lh lh = C1860Lh.f4868a;
        $jacocoInit[10] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) lh);
        C0126V v = this.viewScheduler;
        $jacocoInit[11] = true;
        C0120S a = d.mo3616a(v);
        C1815Gh gh = new C1815Gh(this);
        $jacocoInit[12] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) gh);
        C2037di diVar = C2037di.f5080a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C2008b bVar = new C2008b(crashReport);
        $jacocoInit[13] = true;
        b.mo3626a((C0129b<? super T>) diVar, (C0129b<Throwable>) bVar);
        $jacocoInit[14] = true;
    }

    /* renamed from: r */
    static /* synthetic */ Boolean m6931r(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[199] = true;
        return valueOf;
    }

    /* renamed from: s */
    public /* synthetic */ void mo10843s(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setToolbarInfo(this.bundleEvent.getTitle());
        $jacocoInit[198] = true;
    }

    /* renamed from: t */
    static /* synthetic */ void m6932t(LifecycleEvent __) {
        $jacocoInit()[197] = true;
    }

    public void onCreateLoadBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2178ph phVar = C2178ph.f5245a;
        $jacocoInit[15] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) phVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[16] = true;
        C0120S a = d.mo3616a(v);
        C2007ai aiVar = new C2007ai(this);
        $jacocoInit[17] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) aiVar);
        C2149mh mhVar = new C2149mh(this);
        $jacocoInit[18] = true;
        C0120S i = b.mo3668i(mhVar);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[19] = true;
        C0120S a2 = i.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C1779Ch ch = C1779Ch.f4773a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C2008b bVar = new C2008b(crashReport);
        $jacocoInit[20] = true;
        a2.mo3626a((C0129b<? super T>) ch, (C0129b<Throwable>) bVar);
        $jacocoInit[21] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m6930o(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[196] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ void mo10841p(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[195] = true;
    }

    /* renamed from: q */
    public /* synthetic */ Single mo10842q(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadBundles = loadBundles();
        $jacocoInit[194] = true;
        return loadBundles;
    }

    /* renamed from: h */
    static /* synthetic */ void m6926h(HomeBundlesModel __) {
        $jacocoInit()[193] = true;
    }

    private Single<HomeBundlesModel> loadBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadBundle = this.moreBundleManager.loadBundle(this.bundleEvent.getTitle(), this.bundleEvent.getAction());
        C0126V v = this.viewScheduler;
        $jacocoInit[22] = true;
        Single a = loadBundle.mo3686a(v);
        C2187qh qhVar = new C2187qh(this);
        $jacocoInit[23] = true;
        Single<HomeBundlesModel> b = a.mo3695b((C0129b<? super T>) qhVar);
        $jacocoInit[24] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ void mo10822d(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (bundlesModel.hasErrors()) {
            $jacocoInit[186] = true;
            handleError(bundlesModel.getError());
            $jacocoInit[187] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[188] = true;
        } else {
            $jacocoInit[189] = true;
            this.view.hideLoading();
            $jacocoInit[190] = true;
            this.view.showBundles(bundlesModel.getList());
            $jacocoInit[191] = true;
        }
        $jacocoInit[192] = true;
    }

    private void handleError(Error error) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C18711.$SwitchMap$cm$aptoide$pt$home$HomeBundlesModel$Error[error.ordinal()];
        if (i == 1) {
            this.view.showNetworkError();
            $jacocoInit[26] = true;
        } else if (i != 2) {
            $jacocoInit[25] = true;
        } else {
            this.view.showGenericError();
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
    }

    public void handleAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1870Mh mh = C1870Mh.f4879a;
        $jacocoInit[29] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mh);
        C1980Yh yh = new C1980Yh(this);
        $jacocoInit[30] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) yh);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[31] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C1758Ah ah = C1758Ah.f4752a;
        C2169oh ohVar = C2169oh.f5235a;
        $jacocoInit[32] = true;
        a.mo3626a((C0129b<? super T>) ah, (C0129b<Throwable>) ohVar);
        $jacocoInit[33] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m6920d(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[185] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo10816c(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appClicked = this.view.appClicked();
        C2256xh xhVar = new C2256xh(this);
        $jacocoInit[162] = true;
        C0120S b = appClicked.mo3636b((C0129b<? super T>) xhVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[163] = true;
        C0120S a = b.mo3616a(v);
        C1935Th th = new C1935Th(this);
        $jacocoInit[164] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) th);
        $jacocoInit[165] = true;
        C0120S g = b2.mo3662g();
        $jacocoInit[166] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10818c(AppHomeEvent click) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Chip chip = this.chipManager.getCurrentChip();
        $jacocoInit[169] = true;
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        Application app = click.getApp();
        $jacocoInit[170] = true;
        double rating = (double) app.getRating();
        Application app2 = click.getApp();
        $jacocoInit[171] = true;
        String packageName = app2.getPackageName();
        int appPosition = click.getAppPosition();
        int bundlePosition = click.getBundlePosition();
        $jacocoInit[172] = true;
        HomeBundle bundle = click.getBundle();
        $jacocoInit[173] = true;
        String tag = bundle.getTag();
        HomeBundle bundle2 = click.getBundle();
        $jacocoInit[174] = true;
        List content = bundle2.getContent();
        $jacocoInit[175] = true;
        int size = content.size();
        if (chip != null) {
            str = chip.getName();
            $jacocoInit[176] = true;
        } else {
            str = null;
            $jacocoInit[177] = true;
        }
        homeAnalytics2.sendTapOnAppInteractEvent(rating, packageName, appPosition, bundlePosition, tag, size, str);
        if (chip == null) {
            $jacocoInit[178] = true;
        } else {
            $jacocoInit[179] = true;
            HomeAnalytics homeAnalytics3 = this.homeAnalytics;
            HomeBundle bundle3 = click.getBundle();
            $jacocoInit[180] = true;
            String tag2 = bundle3.getTag();
            Application app3 = click.getApp();
            $jacocoInit[181] = true;
            String packageName2 = app3.getPackageName();
            String name = chip.getName();
            $jacocoInit[182] = true;
            homeAnalytics3.sendChipTapOnApp(tag2, packageName2, name);
            $jacocoInit[183] = true;
        }
        $jacocoInit[184] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10814b(AppHomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        Application app = click.getApp();
        $jacocoInit[167] = true;
        this.homeNavigator.navigateToAppView(app.getAppId(), app.getPackageName(), app.getTag());
        $jacocoInit[168] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6910a(AppHomeEvent homeClick) {
        $jacocoInit()[161] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6917b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[160] = true;
        throw onErrorNotImplementedException;
    }

    public void handleAdClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2119jh jhVar = C2119jh.f5180a;
        $jacocoInit[34] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jhVar);
        C2080fi fiVar = new C2080fi(this);
        $jacocoInit[35] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fiVar);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[36] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C2219th thVar = C2219th.f5289a;
        C1797Eh eh = C1797Eh.f4793a;
        $jacocoInit[37] = true;
        a.mo3626a((C0129b<? super T>) thVar, (C0129b<Throwable>) eh);
        $jacocoInit[38] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6909a(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[159] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo10812b(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S adClicked = this.view.adClicked();
        C2159nh nhVar = C2159nh.f5224a;
        $jacocoInit[152] = true;
        C0120S j = adClicked.mo3669j(nhVar);
        AdMapper adMapper2 = this.adMapper;
        $jacocoInit[153] = true;
        C0120S j2 = j.mo3669j(adMapper2.mapAdToSearchAd());
        C0126V v = this.viewScheduler;
        $jacocoInit[154] = true;
        C0120S a = j2.mo3616a(v);
        HomeNavigator homeNavigator2 = this.homeNavigator;
        homeNavigator2.getClass();
        C1998a aVar = new C1998a(homeNavigator2);
        $jacocoInit[155] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) aVar);
        $jacocoInit[156] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[157] = true;
        return g;
    }

    /* renamed from: a */
    static /* synthetic */ AdClick m6908a(AdHomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        AdClick adClick = homeEvent.getAdClick();
        $jacocoInit[158] = true;
        return adClick;
    }

    /* renamed from: a */
    static /* synthetic */ void m6914a(SimpleEntry homeClick) {
        $jacocoInit()[151] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6913a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[150] = true;
        throw onErrorNotImplementedException;
    }

    public void handleMoreClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1842Jh jh = C1842Jh.f4847a;
        $jacocoInit[39] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jh);
        C1770Bh bh = new C1770Bh(this);
        $jacocoInit[40] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bh);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[41] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C1962Wh wh = C1962Wh.f4989a;
        C2070ei eiVar = C2070ei.f5119a;
        $jacocoInit[42] = true;
        a.mo3626a((C0129b<? super T>) wh, (C0129b<Throwable>) eiVar);
        $jacocoInit[43] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m6927i(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[149] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo10836j(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S moreClicked = this.view.moreClicked();
        C1917Rh rh = new C1917Rh(this);
        $jacocoInit[131] = true;
        C0120S b = moreClicked.mo3636b((C0129b<? super T>) rh);
        C0126V v = this.viewScheduler;
        $jacocoInit[132] = true;
        C0120S a = b.mo3616a(v);
        HomeNavigator homeNavigator2 = this.homeNavigator;
        homeNavigator2.getClass();
        C2100hi hiVar = new C2100hi(homeNavigator2);
        $jacocoInit[133] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) hiVar);
        $jacocoInit[134] = true;
        C0120S g = b2.mo3662g();
        $jacocoInit[135] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10819c(HomeEvent homeMoreClick) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Chip chip = this.chipManager.getCurrentChip();
        $jacocoInit[136] = true;
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        int bundlePosition = homeMoreClick.getBundlePosition();
        $jacocoInit[137] = true;
        HomeBundle bundle = homeMoreClick.getBundle();
        $jacocoInit[138] = true;
        String tag = bundle.getTag();
        HomeBundle bundle2 = homeMoreClick.getBundle();
        $jacocoInit[139] = true;
        List content = bundle2.getContent();
        $jacocoInit[140] = true;
        int size = content.size();
        if (chip != null) {
            str = chip.getName();
            $jacocoInit[141] = true;
        } else {
            str = null;
            $jacocoInit[142] = true;
        }
        homeAnalytics2.sendTapOnMoreInteractEvent(bundlePosition, tag, size, str);
        if (chip == null) {
            $jacocoInit[143] = true;
        } else {
            $jacocoInit[144] = true;
            HomeAnalytics homeAnalytics3 = this.homeAnalytics;
            HomeBundle bundle3 = homeMoreClick.getBundle();
            $jacocoInit[145] = true;
            String tag2 = bundle3.getTag();
            String name = chip.getName();
            $jacocoInit[146] = true;
            homeAnalytics3.sendChipTapOnMore(tag2, name);
            $jacocoInit[147] = true;
        }
        $jacocoInit[148] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6916b(HomeEvent homeClick) {
        $jacocoInit()[130] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m6923e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[129] = true;
        throw onErrorNotImplementedException;
    }

    public void handleBundleScrolledRight() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1909Qh qh = C1909Qh.f4923a;
        $jacocoInit[44] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) qh);
        C1880Nh nh = new C1880Nh(this);
        $jacocoInit[45] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nh);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[46] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C1989Zh zh = C1989Zh.f5023a;
        C1900Ph ph = C1900Ph.f4914a;
        $jacocoInit[47] = true;
        a.mo3626a((C0129b<? super T>) zh, (C0129b<Throwable>) ph);
        $jacocoInit[48] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m6925g(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[128] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo10828h(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S bundleScrolled = this.view.bundleScrolled();
        C2246wh whVar = new C2246wh(this);
        $jacocoInit[118] = true;
        C0120S b = bundleScrolled.mo3636b((C0129b<? super T>) whVar);
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C2008b bVar = new C2008b(crashReport);
        $jacocoInit[119] = true;
        C0120S a = b.mo3621a((C0129b<? super Throwable>) bVar);
        $jacocoInit[120] = true;
        C0120S g = a.mo3662g();
        $jacocoInit[121] = true;
        return g;
    }

    /* renamed from: d */
    public /* synthetic */ void mo10823d(HomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeAnalytics homeAnalytics2 = this.homeAnalytics;
        int bundlePosition = click.getBundlePosition();
        $jacocoInit[122] = true;
        HomeBundle bundle = click.getBundle();
        $jacocoInit[123] = true;
        String tag = bundle.getTag();
        HomeBundle bundle2 = click.getBundle();
        $jacocoInit[124] = true;
        List content = bundle2.getContent();
        $jacocoInit[125] = true;
        int size = content.size();
        $jacocoInit[126] = true;
        homeAnalytics2.sendScrollRightInteractEvent(bundlePosition, tag, size);
        $jacocoInit[127] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6912a(HomeEvent scroll) {
        $jacocoInit()[117] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m6921d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[116] = true;
        throw onErrorNotImplementedException;
    }

    public void handleBottomReached() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2208sh shVar = C2208sh.f5279a;
        $jacocoInit[49] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) shVar);
        C1824Hh hh = new C1824Hh(this);
        $jacocoInit[50] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hh);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[51] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C2228uh uhVar = C2228uh.f5301a;
        C1997_h _hVar = C1997_h.f5032a;
        $jacocoInit[52] = true;
        a.mo3626a((C0129b<? super T>) uhVar, (C0129b<Throwable>) _hVar);
        $jacocoInit[53] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m6922e(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[115] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo10825f(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reachesBottom = this.view.reachesBottom();
        C2265yh yhVar = new C2265yh(this);
        $jacocoInit[104] = true;
        C0120S d = reachesBottom.mo3653d((C0132p<? super T, Boolean>) yhVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[105] = true;
        C0120S a = d.mo3616a(v);
        C2237vh vhVar = new C2237vh(this);
        $jacocoInit[106] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) vhVar);
        C1788Dh dh = new C1788Dh(this);
        $jacocoInit[107] = true;
        C0120S i = b.mo3668i(dh);
        C2139lh lhVar = new C2139lh(this);
        $jacocoInit[108] = true;
        C0120S b2 = i.mo3636b((C0129b<? super T>) lhVar);
        $jacocoInit[109] = true;
        C0120S g = b2.mo3662g();
        $jacocoInit[110] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo10810a(Object __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.moreBundleManager.hasMore(this.bundleEvent.getTitle()));
        $jacocoInit[114] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10815b(Object bottomReached) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoadMore();
        $jacocoInit[113] = true;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo10817c(Object bottomReached) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadNextBundles = loadNextBundles();
        $jacocoInit[112] = true;
        return loadNextBundles;
    }

    /* renamed from: g */
    public /* synthetic */ void mo10827g(HomeBundlesModel __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendLoadMoreInteractEvent();
        $jacocoInit[111] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6911a(HomeBundlesModel bundles) {
        $jacocoInit()[103] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6919c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[102] = true;
        throw onErrorNotImplementedException;
    }

    private Single<HomeBundlesModel> loadNextBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadNextBundles = this.moreBundleManager.loadNextBundles(this.bundleEvent.getTitle(), this.bundleEvent.getAction());
        C0126V v = this.viewScheduler;
        $jacocoInit[54] = true;
        Single a = loadNextBundles.mo3686a(v);
        C2017bi biVar = new C2017bi(this);
        $jacocoInit[55] = true;
        Single<HomeBundlesModel> b = a.mo3695b((C0129b<? super T>) biVar);
        $jacocoInit[56] = true;
        return b;
    }

    /* renamed from: f */
    public /* synthetic */ void mo10826f(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (bundlesModel.hasErrors()) {
            $jacocoInit[95] = true;
            handleError(bundlesModel.getError());
            $jacocoInit[96] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[97] = true;
        } else {
            $jacocoInit[98] = true;
            this.view.showMoreHomeBundles(bundlesModel.getList());
            $jacocoInit[99] = true;
            this.view.hideLoading();
            $jacocoInit[100] = true;
        }
        this.view.hideShowMore();
        $jacocoInit[101] = true;
    }

    public void handlePullToRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1851Kh kh = C1851Kh.f4858a;
        $jacocoInit[57] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kh);
        C1806Fh fh = new C1806Fh(this);
        $jacocoInit[58] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fh);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[59] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C2196rh rhVar = C2196rh.f5264a;
        C1833Ih ih = C1833Ih.f4836a;
        $jacocoInit[60] = true;
        a.mo3626a((C0129b<? super T>) rhVar, (C0129b<Throwable>) ih);
        $jacocoInit[61] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m6928k(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[94] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo10837l(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S refreshes = this.view.refreshes();
        C2274zh zhVar = new C2274zh(this);
        $jacocoInit[88] = true;
        C0120S b = refreshes.mo3636b((C0129b<? super T>) zhVar);
        C1926Sh sh = new C1926Sh(this);
        $jacocoInit[89] = true;
        C0120S i = b.mo3668i(sh);
        $jacocoInit[90] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[91] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10811a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.homeAnalytics.sendPullRefreshInteractEvent();
        $jacocoInit[93] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10813b(Void refreshed) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshBundles = loadFreshBundles();
        $jacocoInit[92] = true;
        return loadFreshBundles;
    }

    /* renamed from: b */
    static /* synthetic */ void m6915b(HomeBundlesModel bundles) {
        $jacocoInit()[87] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m6924f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[86] = true;
        throw onErrorNotImplementedException;
    }

    private Single<HomeBundlesModel> loadFreshBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshBundles = this.moreBundleManager.loadFreshBundles(this.bundleEvent.getTitle(), this.bundleEvent.getAction());
        C0126V v = this.viewScheduler;
        $jacocoInit[62] = true;
        Single a = loadFreshBundles.mo3686a(v);
        C1971Xh xh = new C1971Xh(this);
        $jacocoInit[63] = true;
        Single<HomeBundlesModel> b = a.mo3695b((C0129b<? super T>) xh);
        $jacocoInit[64] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ void mo10824e(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideRefresh();
        $jacocoInit[79] = true;
        if (bundlesModel.hasErrors()) {
            $jacocoInit[80] = true;
            handleError(bundlesModel.getError());
            $jacocoInit[81] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[82] = true;
        } else {
            $jacocoInit[83] = true;
            this.view.showBundles(bundlesModel.getList());
            $jacocoInit[84] = true;
        }
        $jacocoInit[85] = true;
    }

    public void handleRetryClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1889Oh oh = C1889Oh.f4900a;
        $jacocoInit[65] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oh);
        C2027ci ciVar = new C2027ci(this);
        $jacocoInit[66] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ciVar);
        MoreBundleView moreBundleView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[67] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) moreBundleView.bindUntilEvent(lifecycleEvent2));
        C1944Uh uh = C1944Uh.f4968a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C2008b bVar = new C2008b(crashReport);
        $jacocoInit[68] = true;
        a.mo3626a((C0129b<? super T>) uh, (C0129b<Throwable>) bVar);
        $jacocoInit[69] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m6929m(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[78] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo10838n(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S retryClicked = this.view.retryClicked();
        C0126V v = this.viewScheduler;
        $jacocoInit[71] = true;
        C0120S a = retryClicked.mo3616a(v);
        C1953Vh vh = new C1953Vh(this);
        $jacocoInit[72] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) vh);
        C2129kh khVar = new C2129kh(this);
        $jacocoInit[73] = true;
        C0120S i = b.mo3668i(khVar);
        $jacocoInit[74] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[75] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10820c(Void bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[77] = true;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo10821d(Void reachesBottom) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadNextBundles = loadNextBundles();
        $jacocoInit[76] = true;
        return loadNextBundles;
    }

    /* renamed from: c */
    static /* synthetic */ void m6918c(HomeBundlesModel notificationUrl) {
        $jacocoInit()[70] = true;
    }
}
