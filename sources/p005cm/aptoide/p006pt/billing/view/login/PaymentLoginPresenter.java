package p005cm.aptoide.p006pt.billing.view.login;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.accountmanager.AptoideCredentials;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.LoginMethod;
import p005cm.aptoide.p006pt.account.FacebookLoginResult;
import p005cm.aptoide.p006pt.account.FacebookSignUpAdapter;
import p005cm.aptoide.p006pt.account.FacebookSignUpException;
import p005cm.aptoide.p006pt.account.GoogleSignUpAdapter;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.ThrowableToStringMapper;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.view.login.PaymentLoginPresenter */
public abstract class PaymentLoginPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int RESOLVE_GOOGLE_CREDENTIALS_REQUEST_CODE = 2;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private final ThrowableToStringMapper errorMapper;
    private final ScreenOrientationManager orientationManager;
    private final Collection<String> permissions;
    private final int requestCode;
    private final Collection<String> requiredPermissions;
    private final PaymentLoginView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5482853477565328225L, "cm/aptoide/pt/billing/view/login/PaymentLoginPresenter", Opcodes.IF_ICMPGT);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract C0120S<AptoideCredentials> getAptoideSignUpEvent();

    public PaymentLoginPresenter(PaymentLoginView view2, int requestCode2, Collection<String> permissions2, AccountNavigator accountNavigator2, Collection<String> requiredPermissions2, AptoideAccountManager accountManager2, CrashReport crashReport2, ThrowableToStringMapper errorMapper2, C0126V viewScheduler2, ScreenOrientationManager orientationManager2, AccountAnalytics accountAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.accountNavigator = accountNavigator2;
        this.requestCode = requestCode2;
        this.permissions = permissions2;
        this.requiredPermissions = requiredPermissions2;
        this.accountManager = accountManager2;
        this.crashReport = crashReport2;
        this.errorMapper = errorMapper2;
        this.viewScheduler = viewScheduler2;
        this.orientationManager = orientationManager2;
        this.accountAnalytics = accountAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onViewCreatedCheckLoginStatus();
        $jacocoInit[1] = true;
        handleFacebookSignUpResult();
        $jacocoInit[2] = true;
        handleFacebookSignUpEvent();
        $jacocoInit[3] = true;
        handleGrantFacebookRequiredPermissionsEvent();
        $jacocoInit[4] = true;
        handleGoogleSignUpResult();
        $jacocoInit[5] = true;
        handleGoogleSignUpEvent();
        $jacocoInit[6] = true;
        handleRecoverPasswordEvent();
        $jacocoInit[7] = true;
        handleAptoideSignUpEvent();
        $jacocoInit[8] = true;
        handleAptoideLoginEvent();
        $jacocoInit[9] = true;
    }

    private void handleGrantFacebookRequiredPermissionsEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2498Y y = C2498Y.f5659a;
        $jacocoInit[10] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) y);
        C2503ba baVar = new C2503ba(this);
        $jacocoInit[11] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) baVar);
        C2469Fa fa = new C2469Fa(this);
        $jacocoInit[12] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) fa);
        C2485Na na = new C2485Na(this);
        $jacocoInit[13] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) na);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[14] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[15] = true;
        a.mo3670j();
        $jacocoInit[16] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m7179m(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[162] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo11428n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S grantFacebookRequiredPermissionsEvent = this.view.grantFacebookRequiredPermissionsEvent();
        $jacocoInit[161] = true;
        return grantFacebookRequiredPermissionsEvent;
    }

    /* renamed from: g */
    public /* synthetic */ void mo11420g(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[160] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo11422h(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToFacebookSignUpForResult(this.requiredPermissions);
        $jacocoInit[159] = true;
    }

    private void onViewCreatedCheckLoginStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2493T t = C2493T.f5654a;
        $jacocoInit[17] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) t);
        C2507da daVar = new C2507da(this);
        $jacocoInit[18] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) daVar);
        C2527na naVar = C2527na.f5688a;
        $jacocoInit[19] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) naVar);
        C2465Da da = new C2465Da(this);
        $jacocoInit[20] = true;
        C0120S b = d2.mo3636b((C0129b<? super T>) da);
        C0126V v = this.viewScheduler;
        $jacocoInit[21] = true;
        C0120S a = b.mo3616a(v);
        C2535ra raVar = new C2535ra(this);
        $jacocoInit[22] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) raVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[23] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[24] = true;
        a2.mo3670j();
        $jacocoInit[25] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m7181q(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[158] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo11430r(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[157] = true;
        return accountStatus;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7171a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(account.isLoggedIn());
        $jacocoInit[156] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11403b(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.loginSuccess();
        $jacocoInit[155] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11408c(Account __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.popViewWithResult(this.requestCode, true);
        $jacocoInit[154] = true;
    }

    /* access modifiers changed from: 0000 */
    public void handleAptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2521ka kaVar = C2521ka.f5682a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kaVar);
        C2523la laVar = new C2523la(this);
        $jacocoInit[27] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) laVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[28] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[29] = true;
        a.mo3670j();
        $jacocoInit[30] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m7174d(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[153] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo11406c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = getAptoideSignUpEvent().mo3636b((C0129b<? super T>) new C2479Ka<Object>(this));
        C2547xa xaVar = new C2547xa(this);
        $jacocoInit[138] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) xaVar);
        $jacocoInit[139] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[140] = true;
        return g2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11396a(AptoideCredentials __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[150] = true;
        this.orientationManager.lock();
        $jacocoInit[151] = true;
        this.accountAnalytics.sendAptoideSignUpButtonPressed();
        $jacocoInit[152] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo11400b(AptoideCredentials result) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M signUp = this.accountManager.signUp(AptoideAccountManager.APTOIDE_SIGN_UP_TYPE, result);
        C0126V v = this.viewScheduler;
        $jacocoInit[141] = true;
        C0117M a = signUp.mo3581a(v);
        C2496W w = new C2496W(this);
        $jacocoInit[142] = true;
        C0117M b = a.mo3594b((C0128a) w);
        C2475Ia ia = new C2475Ia(this);
        $jacocoInit[143] = true;
        C0117M a2 = b.mo3583a((C0129b<? super Throwable>) ia);
        $jacocoInit[144] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11395a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[148] = true;
        this.orientationManager.unlock();
        $jacocoInit[149] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11404b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.sendSignUpErrorEvent(LoginMethod.APTOIDE, throwable);
        $jacocoInit[145] = true;
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[146] = true;
        this.crashReport.log(throwable);
        $jacocoInit[147] = true;
    }

    private void handleAptoideLoginEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2509ea eaVar = C2509ea.f5670a;
        $jacocoInit[31] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) eaVar);
        C2459Aa aa = new C2459Aa(this);
        $jacocoInit[32] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aa);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[33] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[34] = true;
        a.mo3670j();
        $jacocoInit[35] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7172a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[137] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11401b(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideLoginEvent = this.view.aptoideLoginEvent();
        C2539ta taVar = new C2539ta(this);
        $jacocoInit[121] = true;
        C0120S b = aptoideLoginEvent.mo3636b((C0129b<? super T>) taVar);
        C2471Ga ga = new C2471Ga(this);
        $jacocoInit[122] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) ga);
        $jacocoInit[123] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[124] = true;
        return g2;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11409c(AptoideCredentials __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[134] = true;
        this.orientationManager.lock();
        $jacocoInit[135] = true;
        this.accountAnalytics.sendAptoideLoginButtonPressed();
        $jacocoInit[136] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo11412d(AptoideCredentials result) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M login = this.accountManager.login(result);
        C0126V v = this.viewScheduler;
        $jacocoInit[125] = true;
        C0117M a = login.mo3581a(v);
        C2505ca caVar = new C2505ca(this);
        $jacocoInit[126] = true;
        C0117M b = a.mo3594b((C0128a) caVar);
        C2463Ca ca = new C2463Ca(this);
        $jacocoInit[127] = true;
        C0117M a2 = b.mo3583a((C0129b<? super Throwable>) ca);
        $jacocoInit[128] = true;
        return a2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11402b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[132] = true;
        this.orientationManager.unlock();
        $jacocoInit[133] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11410c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.sendLoginErrorEvent(LoginMethod.APTOIDE, throwable);
        $jacocoInit[129] = true;
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[130] = true;
        this.crashReport.log(throwable);
        $jacocoInit[131] = true;
    }

    private void handleFacebookSignUpResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2551za zaVar = C2551za.f5712a;
        $jacocoInit[36] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) zaVar);
        C2545wa waVar = new C2545wa(this);
        $jacocoInit[37] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) waVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[38] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[39] = true;
        a.mo3670j();
        $jacocoInit[40] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7176g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[120] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo11421h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S facebookSignUpResults = this.accountNavigator.facebookSignUpResults();
        C2549ya yaVar = new C2549ya(this);
        $jacocoInit[104] = true;
        C0120S g = facebookSignUpResults.mo3663g((C0132p<? super T, ? extends C0117M>) yaVar);
        $jacocoInit[105] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[106] = true;
        return g2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11393a(FacebookLoginResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M signUp = this.accountManager.signUp(FacebookSignUpAdapter.TYPE, result);
        C0126V v = this.viewScheduler;
        $jacocoInit[107] = true;
        C0117M a = signUp.mo3581a(v);
        C2537sa saVar = new C2537sa(this);
        $jacocoInit[108] = true;
        C0117M b = a.mo3594b((C0128a) saVar);
        C2543va vaVar = new C2543va(this);
        $jacocoInit[109] = true;
        C0117M a2 = b.mo3583a((C0129b<? super Throwable>) vaVar);
        $jacocoInit[110] = true;
        return a2;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11407c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[119] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo11414d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(throwable instanceof FacebookSignUpException)) {
            $jacocoInit[111] = true;
        } else {
            FacebookSignUpException facebookSignUpException = (FacebookSignUpException) throwable;
            $jacocoInit[112] = true;
            if (facebookSignUpException.getCode() != 1) {
                $jacocoInit[113] = true;
            } else {
                $jacocoInit[114] = true;
                this.view.showFacebookPermissionsRequiredError();
                $jacocoInit[115] = true;
                this.accountAnalytics.sendLoginErrorEvent(LoginMethod.FACEBOOK, throwable);
                $jacocoInit[118] = true;
            }
        }
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[116] = true;
        this.crashReport.log(throwable);
        $jacocoInit[117] = true;
        this.accountAnalytics.sendLoginErrorEvent(LoginMethod.FACEBOOK, throwable);
        $jacocoInit[118] = true;
    }

    public void handleFacebookSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2473Ha ha = C2473Ha.f5636a;
        $jacocoInit[41] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ha);
        C2477Ja ja = new C2477Ja(this);
        $jacocoInit[42] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ja);
        C2483Ma ma = new C2483Ma(this);
        $jacocoInit[43] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ma);
        C2517ia iaVar = new C2517ia(this);
        $jacocoInit[44] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) iaVar);
        C2494U u = new C2494U(this);
        $jacocoInit[45] = true;
        C0120S b3 = b2.mo3636b((C0129b<? super T>) u);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[46] = true;
        C0120S a = b3.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[47] = true;
        a.mo3670j();
        $jacocoInit[48] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7175e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[103] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo11418f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S facebookSignUpEvent = this.view.facebookSignUpEvent();
        $jacocoInit[102] = true;
        return facebookSignUpEvent;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11399a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[101] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11405b(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.sendFacebookLoginButtonPressed();
        $jacocoInit[100] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11411c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToFacebookSignUpForResult(this.permissions);
        $jacocoInit[99] = true;
    }

    private void handleGoogleSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2519ja jaVar = C2519ja.f5680a;
        $jacocoInit[49] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jaVar);
        C2499Z z = new C2499Z(this);
        $jacocoInit[50] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) z);
        C2467Ea ea = new C2467Ea(this);
        $jacocoInit[51] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ea);
        C2461Ba ba = new C2461Ba(this);
        $jacocoInit[52] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) ba);
        C2515ha haVar = new C2515ha(this);
        $jacocoInit[53] = true;
        C0120S i = b2.mo3668i(haVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[54] = true;
        C0120S a = i.mo3616a(v);
        C2513ga gaVar = new C2513ga(this);
        $jacocoInit[55] = true;
        C0120S b3 = a.mo3636b((C0129b<? super T>) gaVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[56] = true;
        C0120S a2 = b3.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        C2511fa faVar = C2511fa.f5672a;
        C2497X x = new C2497X(this);
        $jacocoInit[57] = true;
        a2.mo3626a((C0129b<? super T>) faVar, (C0129b<Throwable>) x);
        $jacocoInit[58] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m7177i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[98] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo11426j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S googleSignUpEvent = this.view.googleSignUpEvent();
        $jacocoInit[97] = true;
        return googleSignUpEvent;
    }

    /* renamed from: d */
    public /* synthetic */ void mo11415d(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[96] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11417e(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.sendGoogleLoginButtonPressed();
        $jacocoInit[95] = true;
    }

    /* renamed from: f */
    public /* synthetic */ Single mo11419f(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        Single navigateToGoogleSignUpForResult = this.accountNavigator.navigateToGoogleSignUpForResult(2);
        $jacocoInit[94] = true;
        return navigateToGoogleSignUpForResult;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11397a(ConnectionResult connectionResult) {
        boolean[] $jacocoInit = $jacocoInit();
        if (connectionResult.mo27281f()) {
            $jacocoInit[89] = true;
        } else {
            $jacocoInit[90] = true;
            this.view.showConnectionError(connectionResult);
            $jacocoInit[91] = true;
            this.view.hideLoading();
            $jacocoInit[92] = true;
        }
        $jacocoInit[93] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7173b(ConnectionResult __) {
        $jacocoInit()[88] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11398a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[85] = true;
        this.view.showError(this.errorMapper.map(err));
        $jacocoInit[86] = true;
        this.crashReport.log(err);
        $jacocoInit[87] = true;
    }

    private void handleGoogleSignUpResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2495V v = C2495V.f5656a;
        $jacocoInit[59] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) v);
        C2531pa paVar = new C2531pa(this);
        $jacocoInit[60] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) paVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[61] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[62] = true;
        a.mo3670j();
        $jacocoInit[63] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7178k(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[84] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo11427l(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S googleSignUpResults = this.accountNavigator.googleSignUpResults(2);
        C2501aa aaVar = new C2501aa(this);
        $jacocoInit[73] = true;
        C0120S g = googleSignUpResults.mo3663g((C0132p<? super T, ? extends C0117M>) aaVar);
        $jacocoInit[74] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[75] = true;
        return g2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11394a(GoogleSignInResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M signUp = this.accountManager.signUp(GoogleSignUpAdapter.TYPE, result);
        C0126V v = this.viewScheduler;
        $jacocoInit[76] = true;
        C0117M a = signUp.mo3581a(v);
        C2541ua uaVar = new C2541ua(this);
        $jacocoInit[77] = true;
        C0117M b = a.mo3594b((C0128a) uaVar);
        C2481La la = new C2481La(this);
        $jacocoInit[78] = true;
        C0117M a2 = b.mo3583a((C0129b<? super Throwable>) la);
        $jacocoInit[79] = true;
        return a2;
    }

    /* renamed from: d */
    public /* synthetic */ void mo11413d() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[83] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11416e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[80] = true;
        this.crashReport.log(throwable);
        $jacocoInit[81] = true;
        this.accountAnalytics.sendLoginErrorEvent(LoginMethod.GOOGLE, throwable);
        $jacocoInit[82] = true;
    }

    private void handleRecoverPasswordEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2529oa oaVar = C2529oa.f5690a;
        $jacocoInit[64] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oaVar);
        C2525ma maVar = new C2525ma(this);
        $jacocoInit[65] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) maVar);
        C2533qa qaVar = new C2533qa(this);
        $jacocoInit[66] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) qaVar);
        PaymentLoginView paymentLoginView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[67] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) paymentLoginView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[68] = true;
        a.mo3670j();
        $jacocoInit[69] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m7180o(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[72] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo11429p(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S recoverPasswordEvent = this.view.recoverPasswordEvent();
        $jacocoInit[71] = true;
        return recoverPasswordEvent;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11425i(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToRecoverPasswordView();
        $jacocoInit[70] = true;
    }
}
