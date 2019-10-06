package p005cm.aptoide.p006pt.billing.view.login;

import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.accountmanager.AptoideCredentials;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.ThrowableToStringMapper;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.view.login.PaymentLoginFlavorPresenter */
public class PaymentLoginFlavorPresenter extends PaymentLoginPresenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private final ThrowableToStringMapper errorMapper;
    private final int requestCode;
    private final PaymentLoginView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-507782186272272221L, "cm/aptoide/pt/billing/view/login/PaymentLoginFlavorPresenter", 85);
        $jacocoData = probes;
        return probes;
    }

    public PaymentLoginFlavorPresenter(PaymentLoginView view2, int requestCode2, Collection<String> permissions, AccountNavigator accountNavigator2, Collection<String> requiredPermissions, AptoideAccountManager accountManager, CrashReport crashReport2, ThrowableToStringMapper errorMapper2, C0126V viewScheduler, ScreenOrientationManager orientationManager, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view2, requestCode2, permissions, accountNavigator2, requiredPermissions, accountManager, crashReport2, errorMapper2, viewScheduler, orientationManager, accountAnalytics);
        this.view = view2;
        this.requestCode = requestCode2;
        this.crashReport = crashReport2;
        this.errorMapper = errorMapper2;
        this.accountNavigator = accountNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        super.present();
        $jacocoInit[1] = true;
        handleClickOnPrivacyPolicy();
        $jacocoInit[2] = true;
        handleClickOnTermsAndConditions();
        $jacocoInit[3] = true;
        showAptoideSignUpEvent();
        $jacocoInit[4] = true;
        handleAptoideShowSignUpEvent();
        $jacocoInit[5] = true;
        showTCandPP();
        $jacocoInit[6] = true;
        handleBackButtonAndUpNavigationEvent();
        $jacocoInit[7] = true;
        hidePasswordContainerEvent();
        $jacocoInit[8] = true;
    }

    /* access modifiers changed from: protected */
    public C0120S<AptoideCredentials> getAptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideSignUpEvent = this.view.aptoideSignUpEvent();
        C2536s sVar = new C2536s(this);
        $jacocoInit[9] = true;
        C0120S b = aptoideSignUpEvent.mo3636b((C0129b<? super T>) sVar);
        C2487Oa oa = C2487Oa.f5650a;
        $jacocoInit[10] = true;
        C0120S<AptoideCredentials> d = b.mo3653d((C0132p<? super T, Boolean>) oa);
        $jacocoInit[11] = true;
        return d;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11339e(AptoideCredentials credentials) {
        boolean[] $jacocoInit = $jacocoInit();
        showNotCheckedMessage(credentials.isChecked());
        $jacocoInit[84] = true;
    }

    private void handleClickOnTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2524m mVar = C2524m.f5685a;
        $jacocoInit[12] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mVar);
        C2462C c = new C2462C(this);
        $jacocoInit[13] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) c);
        C2504c cVar = new C2504c(this);
        $jacocoInit[14] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) cVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[15] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        C2514h hVar = C2514h.f5675a;
        C2460B b2 = new C2460B(this);
        $jacocoInit[16] = true;
        a.mo3626a((C0129b<? super T>) hVar, (C0129b<Throwable>) b2);
        $jacocoInit[17] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m7138y(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[83] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo11353z(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S termsAndConditionsClickEvent = this.view.termsAndConditionsClickEvent();
        $jacocoInit[82] = true;
        return termsAndConditionsClickEvent;
    }

    /* renamed from: n */
    public /* synthetic */ void mo11348n(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToTermsAndConditions();
        $jacocoInit[81] = true;
    }

    /* renamed from: o */
    static /* synthetic */ void m7133o(Void __) {
        $jacocoInit()[80] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo11343h(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[79] = true;
    }

    private void handleClickOnPrivacyPolicy() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2506d dVar = C2506d.f5667a;
        $jacocoInit[18] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) dVar);
        C2518j jVar = new C2518j(this);
        $jacocoInit[19] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jVar);
        C2458A a = new C2458A(this);
        $jacocoInit[20] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) a);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[21] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        C2512g gVar = C2512g.f5673a;
        C2520k kVar = new C2520k(this);
        $jacocoInit[22] = true;
        a2.mo3626a((C0129b<? super T>) gVar, (C0129b<Throwable>) kVar);
        $jacocoInit[23] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m7137w(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[78] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo11352x(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S privacyPolicyClickEvent = this.view.privacyPolicyClickEvent();
        $jacocoInit[77] = true;
        return privacyPolicyClickEvent;
    }

    /* renamed from: l */
    public /* synthetic */ void mo11347l(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToPrivacyPolicy();
        $jacocoInit[76] = true;
    }

    /* renamed from: m */
    static /* synthetic */ void m7132m(Void __) {
        $jacocoInit()[75] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo11341g(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[74] = true;
    }

    private void showTCandPP() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2508e eVar = C2508e.f5669a;
        $jacocoInit[24] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) eVar);
        C2522l lVar = new C2522l(this);
        $jacocoInit[25] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) lVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[26] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[27] = true;
        a.mo3670j();
        $jacocoInit[28] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m7128C(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[73] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ void mo11337D(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showTCandPP();
        $jacocoInit[72] = true;
    }

    private void handleAptoideShowSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2502b bVar = C2502b.f5663a;
        $jacocoInit[29] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bVar);
        C2510f fVar = new C2510f(this);
        $jacocoInit[30] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[31] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        C2528o oVar = C2528o.f5689a;
        C2500a aVar = new C2500a(this);
        $jacocoInit[32] = true;
        a.mo3626a((C0129b<? super T>) oVar, (C0129b<Throwable>) aVar);
        $jacocoInit[33] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m7135s(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[71] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo11350t(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showAptoideSignUpEvent = showAptoideSignUpEvent();
        $jacocoInit[70] = true;
        return showAptoideSignUpEvent;
    }

    /* renamed from: a */
    static /* synthetic */ void m7130a(Boolean __) {
        $jacocoInit()[69] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo11340f(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[66] = true;
        this.view.showError(this.errorMapper.map(err));
        $jacocoInit[67] = true;
        this.crashReport.log(err);
        $jacocoInit[68] = true;
    }

    private C0120S<Boolean> showAptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showAptoideSignUpAreaClick = this.view.showAptoideSignUpAreaClick();
        C2516i iVar = new C2516i(this);
        $jacocoInit[34] = true;
        C0120S b = showAptoideSignUpAreaClick.mo3636b((C0129b<? super T>) iVar);
        C2548y yVar = C2548y.f5709a;
        $jacocoInit[35] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) yVar);
        C2538t tVar = new C2538t(this);
        $jacocoInit[36] = true;
        C0120S<Boolean> b2 = d.mo3636b((C0129b<? super T>) tVar);
        $jacocoInit[37] = true;
        return b2;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7131b(Boolean event) {
        $jacocoInit()[65] = true;
        return event;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11338c(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showUsernamePasswordContainer(false, true);
        $jacocoInit[64] = true;
    }

    /* access modifiers changed from: private */
    public void showNotCheckedMessage(boolean checked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (checked) {
            $jacocoInit[38] = true;
        } else {
            $jacocoInit[39] = true;
            this.view.showTermsConditionError();
            $jacocoInit[40] = true;
        }
        $jacocoInit[41] = true;
    }

    private void hidePasswordContainerEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2544w wVar = C2544w.f5705a;
        $jacocoInit[42] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) wVar);
        C2546x xVar = new C2546x(this);
        $jacocoInit[43] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xVar);
        C2550z zVar = new C2550z(this);
        $jacocoInit[44] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) zVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[45] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        C2532q qVar = C2532q.f5693a;
        C2540u uVar = new C2540u(this);
        $jacocoInit[46] = true;
        a.mo3626a((C0129b<? super T>) qVar, (C0129b<Throwable>) uVar);
        $jacocoInit[47] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m7127A(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[63] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo11336B(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S hidePasswordContainerEvent = this.view.hidePasswordContainerEvent();
        $jacocoInit[62] = true;
        return hidePasswordContainerEvent;
    }

    /* renamed from: p */
    public /* synthetic */ void mo11349p(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideUsernamePasswordContainer(true);
        $jacocoInit[61] = true;
    }

    /* renamed from: q */
    static /* synthetic */ void m7134q(Void __) {
        $jacocoInit()[60] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11344i(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[59] = true;
    }

    private void handleBackButtonAndUpNavigationEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2542v vVar = C2542v.f5703a;
        $jacocoInit[48] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) vVar);
        C2530p pVar = new C2530p(this);
        $jacocoInit[49] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pVar);
        C2526n nVar = new C2526n(this);
        $jacocoInit[50] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) nVar);
        C2534r rVar = new C2534r(this);
        $jacocoInit[51] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) rVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[52] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[53] = true;
        a.mo3670j();
        $jacocoInit[54] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m7136u(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[58] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo11351v(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(this.view.backButtonEvent(), this.view.upNavigationEvent());
        $jacocoInit[57] = true;
        return b;
    }

    /* renamed from: j */
    public /* synthetic */ void mo11345j(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.popViewWithResult(this.requestCode, false);
        $jacocoInit[56] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo11346k(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideUsernamePasswordContainer(true);
        $jacocoInit[55] = true;
    }
}
