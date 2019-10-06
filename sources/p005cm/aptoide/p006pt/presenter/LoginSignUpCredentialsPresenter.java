package p005cm.aptoide.p006pt.presenter;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
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
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;
import p005cm.aptoide.p006pt.view.ThrowableToStringMapper;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.presenter.LoginSignUpCredentialsPresenter */
public abstract class LoginSignUpCredentialsPresenter implements Presenter, ClickHandler {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int RESOLVE_GOOGLE_CREDENTIALS_REQUEST_CODE = 2;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private boolean dismissToNavigateToMainView;
    private final ThrowableToStringMapper errorMapper;
    private final boolean navigateToHome;
    private final Collection<String> permissions;
    private final Collection<String> requiredPermissions;
    private final LoginSignUpCredentialsView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7796184465996756265L, "cm/aptoide/pt/presenter/LoginSignUpCredentialsPresenter", 243);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract C0120S<AptoideCredentials> getAptoideSignUpEvent();

    public LoginSignUpCredentialsPresenter(LoginSignUpCredentialsView view2, AptoideAccountManager accountManager2, CrashReport crashReport2, boolean dismissToNavigateToMainView2, boolean navigateToHome2, AccountNavigator accountNavigator2, Collection<String> permissions2, Collection<String> requiredPermissions2, ThrowableToStringMapper errorMapper2, AccountAnalytics accountAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.accountManager = accountManager2;
        this.crashReport = crashReport2;
        this.dismissToNavigateToMainView = dismissToNavigateToMainView2;
        this.navigateToHome = navigateToHome2;
        this.accountNavigator = accountNavigator2;
        this.permissions = permissions2;
        this.requiredPermissions = requiredPermissions2;
        this.errorMapper = errorMapper2;
        this.accountAnalytics = accountAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleAptoideLoginEvent();
        $jacocoInit[1] = true;
        handleAptoideSignUpEvent();
        $jacocoInit[2] = true;
        handleGoogleSignUpEvent();
        $jacocoInit[3] = true;
        handleGoogleSignUpResult();
        $jacocoInit[4] = true;
        handleFacebookSignUpResult();
        $jacocoInit[5] = true;
        handleFacebookSignUpEvent();
        $jacocoInit[6] = true;
        handleFacebookSignUpWithRequiredPermissionsEvent();
        $jacocoInit[7] = true;
        handleAptoideShowLoginEvent();
        $jacocoInit[8] = true;
        handleAccountStatusChangeWhileShowingView();
        $jacocoInit[9] = true;
        handleForgotPasswordClick();
        $jacocoInit[10] = true;
        handleTogglePasswordVisibility();
        $jacocoInit[11] = true;
    }

    private void handleTogglePasswordVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4345b bVar = C4345b.f7941a;
        $jacocoInit[12] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) bVar);
        C4390q qVar = new C4390q(this);
        $jacocoInit[13] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[14] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4310K k = C4310K.f7906a;
        C4354e eVar = new C4354e(this);
        $jacocoInit[15] = true;
        a.mo3626a((C0129b<? super T>) k, (C0129b<Throwable>) eVar);
        $jacocoInit[16] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m8674w(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[242] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo15433x(LifecycleEvent resumed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = togglePasswordVisibility();
        $jacocoInit[241] = true;
        return s;
    }

    /* renamed from: k */
    static /* synthetic */ void m8668k(Void __) {
        $jacocoInit()[240] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo15413g(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[239] = true;
    }

    private void handleForgotPasswordClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4405v vVar = C4405v.f8001a;
        $jacocoInit[17] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) vVar);
        C4375l lVar = new C4375l(this);
        $jacocoInit[18] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[19] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4417z zVar = C4417z.f8013a;
        C4337Y y = new C4337Y(this);
        $jacocoInit[20] = true;
        a.mo3626a((C0129b<? super T>) zVar, (C0129b<Throwable>) y);
        $jacocoInit[21] = true;
    }

    /* renamed from: p */
    static /* synthetic */ Boolean m8671p(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[238] = true;
        return valueOf;
    }

    /* renamed from: q */
    public /* synthetic */ C0120S mo15428q(LifecycleEvent resumed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S forgotPasswordSelection = forgotPasswordSelection();
        $jacocoInit[237] = true;
        return forgotPasswordSelection;
    }

    /* renamed from: h */
    static /* synthetic */ void m8666h(Void __) {
        $jacocoInit()[236] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15407e(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[235] = true;
    }

    private void handleAptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4329U u = C4329U.f7925a;
        $jacocoInit[22] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) u);
        C4300G g = new C4300G(this);
        $jacocoInit[23] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) g);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[24] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[25] = true;
        a.mo3670j();
        $jacocoInit[26] = true;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m8665h(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[234] = true;
        return valueOf;
    }

    /* renamed from: g */
    public /* synthetic */ C0120S mo15412g(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = getAptoideSignUpEvent().mo3636b((C0129b<? super T>) new C4378m<Object>(this));
        C4349ca caVar = new C4349ca(this);
        $jacocoInit[214] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) caVar);
        $jacocoInit[215] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[216] = true;
        return g2;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15403d(AptoideCredentials click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideKeyboard();
        $jacocoInit[230] = true;
        this.view.showLoading();
        $jacocoInit[231] = true;
        lockScreenRotation();
        $jacocoInit[232] = true;
        this.accountAnalytics.sendAptoideSignUpButtonPressed();
        $jacocoInit[233] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15386a(AptoideCredentials credentials) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M signUp = this.accountManager.signUp(AptoideAccountManager.APTOIDE_SIGN_UP_TYPE, credentials);
        $jacocoInit[217] = true;
        C0117M a = signUp.mo3581a(C14522a.m46170a());
        C4376la laVar = new C4376la(this);
        $jacocoInit[218] = true;
        C0117M a2 = a.mo3582a((C0128a) laVar);
        C4297F f = new C4297F(this);
        $jacocoInit[219] = true;
        C0117M a3 = a2.mo3583a((C0129b<? super Throwable>) f);
        $jacocoInit[220] = true;
        return a3;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15389a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.loginSuccess();
        $jacocoInit[226] = true;
        navigateToCreateProfile();
        $jacocoInit[227] = true;
        unlockScreenRotation();
        $jacocoInit[228] = true;
        this.view.hideLoading();
        $jacocoInit[229] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo15415h(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.sendSignUpErrorEvent(LoginMethod.APTOIDE, throwable);
        $jacocoInit[221] = true;
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[222] = true;
        this.crashReport.log(throwable);
        $jacocoInit[223] = true;
        unlockScreenRotation();
        $jacocoInit[224] = true;
        this.view.hideLoading();
        $jacocoInit[225] = true;
    }

    private void handleAptoideLoginEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4384o oVar = C4384o.f7980a;
        $jacocoInit[27] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oVar);
        C4314M m = new C4314M(this);
        $jacocoInit[28] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) m);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[29] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[30] = true;
        a.mo3670j();
        $jacocoInit[31] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8660c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[213] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo15401d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideLoginEvent = this.view.aptoideLoginEvent();
        C4358fa faVar = new C4358fa(this);
        $jacocoInit[192] = true;
        C0120S b = aptoideLoginEvent.mo3636b((C0129b<? super T>) faVar);
        C4282A a = new C4282A(this);
        $jacocoInit[193] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) a);
        $jacocoInit[194] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[195] = true;
        return g2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15395b(AptoideCredentials click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideKeyboard();
        $jacocoInit[209] = true;
        this.view.showLoading();
        $jacocoInit[210] = true;
        lockScreenRotation();
        $jacocoInit[211] = true;
        this.accountAnalytics.sendAptoideLoginButtonPressed();
        $jacocoInit[212] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo15398c(AptoideCredentials credentials) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M login = this.accountManager.login(credentials);
        $jacocoInit[196] = true;
        C0117M a = login.mo3581a(C14522a.m46170a());
        C4387p pVar = new C4387p(this);
        $jacocoInit[197] = true;
        C0117M a2 = a.mo3582a((C0128a) pVar);
        C4322Q q = new C4322Q(this);
        $jacocoInit[198] = true;
        C0117M a3 = a2.mo3583a((C0129b<? super Throwable>) q);
        $jacocoInit[199] = true;
        return a3;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15394b() {
        boolean[] $jacocoInit = $jacocoInit();
        unlockScreenRotation();
        $jacocoInit[205] = true;
        this.accountAnalytics.loginSuccess();
        $jacocoInit[206] = true;
        navigateToMainView();
        $jacocoInit[207] = true;
        this.view.hideLoading();
        $jacocoInit[208] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo15416i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[200] = true;
        this.view.hideLoading();
        $jacocoInit[201] = true;
        this.crashReport.log(throwable);
        $jacocoInit[202] = true;
        unlockScreenRotation();
        $jacocoInit[203] = true;
        this.accountAnalytics.sendLoginErrorEvent(LoginMethod.APTOIDE, throwable);
        $jacocoInit[204] = true;
    }

    private void handleAptoideShowLoginEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4346ba baVar = C4346ba.f7942a;
        $jacocoInit[32] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) baVar);
        C4370ja jaVar = new C4370ja(this);
        $jacocoInit[33] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jaVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[34] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4373ka kaVar = C4373ka.f7969a;
        C4294E e = new C4294E(this);
        $jacocoInit[35] = true;
        a.mo3626a((C0129b<? super T>) kaVar, (C0129b<Throwable>) e);
        $jacocoInit[36] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8662e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[191] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo15408f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideShowLoginClick = aptoideShowLoginClick();
        $jacocoInit[190] = true;
        return aptoideShowLoginClick;
    }

    /* renamed from: c */
    static /* synthetic */ void m8661c(Void __) {
        $jacocoInit()[189] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15396b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[186] = true;
        this.view.showError(this.errorMapper.map(err));
        $jacocoInit[187] = true;
        this.crashReport.log(err);
        $jacocoInit[188] = true;
    }

    private void handleAccountStatusChangeWhileShowingView() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4363h hVar = C4363h.f7959a;
        $jacocoInit[37] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) hVar);
        C4285B b = new C4285B(this);
        $jacocoInit[38] = true;
        C0120S i = d.mo3668i(b);
        C4408w wVar = new C4408w(this);
        $jacocoInit[39] = true;
        C0120S b2 = i.mo3636b((C0129b<? super T>) wVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.PAUSE;
        $jacocoInit[40] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4306I i2 = C4306I.f7902a;
        C4379ma maVar = C4379ma.f7975a;
        $jacocoInit[41] = true;
        a.mo3626a((C0129b<? super T>) i2, (C0129b<Throwable>) maVar);
        $jacocoInit[42] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8656a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.RESUME));
        $jacocoInit[185] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo15393b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[182] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[183] = true;
        Single n = d.mo3678n();
        $jacocoInit[184] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15390a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!account.isLoggedIn()) {
            $jacocoInit[178] = true;
        } else {
            $jacocoInit[179] = true;
            navigateBack();
            $jacocoInit[180] = true;
        }
        $jacocoInit[181] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8657a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[175] = true;
        instance.log(err);
        $jacocoInit[176] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8658b(Account __) {
        $jacocoInit()[177] = true;
    }

    private void handleGoogleSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4303H h = C4303H.f7899a;
        $jacocoInit[43] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) h);
        C4339Z z = new C4339Z(this);
        $jacocoInit[44] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) z);
        C4318O o = new C4318O(this);
        $jacocoInit[45] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) o);
        C4288C c = new C4288C(this);
        $jacocoInit[46] = true;
        C0120S b2 = f.mo3636b((C0129b<? super T>) c);
        C4343aa aaVar = new C4343aa(this);
        $jacocoInit[47] = true;
        C0120S i = b2.mo3668i(aaVar);
        $jacocoInit[48] = true;
        C0120S a = i.mo3616a(C14522a.m46170a());
        C4402u uVar = new C4402u(this);
        $jacocoInit[49] = true;
        C0120S b3 = a.mo3636b((C0129b<? super T>) uVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[50] = true;
        C0120S a2 = b3.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4396s sVar = C4396s.f7992a;
        C4351d dVar = new C4351d(this);
        $jacocoInit[51] = true;
        a2.mo3626a((C0129b<? super T>) sVar, (C0129b<Throwable>) dVar);
        $jacocoInit[52] = true;
    }

    /* renamed from: r */
    static /* synthetic */ Boolean m8672r(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[174] = true;
        return valueOf;
    }

    /* renamed from: s */
    public /* synthetic */ void mo15429s(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        showOrHideGoogleSignUp();
        $jacocoInit[173] = true;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo15430t(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S googleSignUpEvent = this.view.googleSignUpEvent();
        $jacocoInit[172] = true;
        return googleSignUpEvent;
    }

    /* renamed from: i */
    public /* synthetic */ void mo15417i(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[170] = true;
        this.accountAnalytics.sendGoogleLoginButtonPressed();
        $jacocoInit[171] = true;
    }

    /* renamed from: j */
    public /* synthetic */ Single mo15418j(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        Single navigateToGoogleSignUpForResult = this.accountNavigator.navigateToGoogleSignUpForResult(2);
        $jacocoInit[169] = true;
        return navigateToGoogleSignUpForResult;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15391a(ConnectionResult connectionResult) {
        boolean[] $jacocoInit = $jacocoInit();
        if (connectionResult.mo27281f()) {
            $jacocoInit[164] = true;
        } else {
            $jacocoInit[165] = true;
            this.view.showConnectionError(connectionResult);
            $jacocoInit[166] = true;
            this.view.hideLoading();
            $jacocoInit[167] = true;
        }
        $jacocoInit[168] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8659b(ConnectionResult __) {
        $jacocoInit()[163] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15410f(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[160] = true;
        this.view.showError(this.errorMapper.map(err));
        $jacocoInit[161] = true;
        this.crashReport.log(err);
        $jacocoInit[162] = true;
    }

    private void handleGoogleSignUpResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4369j jVar = C4369j.f7965a;
        $jacocoInit[53] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jVar);
        C4335X x = new C4335X(this);
        $jacocoInit[54] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) x);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[55] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[56] = true;
        a.mo3670j();
        $jacocoInit[57] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m8673u(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[159] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo15432v(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S googleSignUpResults = this.accountNavigator.googleSignUpResults(2);
        C4348c cVar = new C4348c(this);
        $jacocoInit[145] = true;
        C0120S g = googleSignUpResults.mo3663g((C0132p<? super T, ? extends C0117M>) cVar);
        $jacocoInit[146] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[147] = true;
        return g2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15388a(GoogleSignInResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M signUp = this.accountManager.signUp(GoogleSignUpAdapter.TYPE, result);
        $jacocoInit[148] = true;
        C0117M a = signUp.mo3581a(C14522a.m46170a());
        C4372k kVar = new C4372k(this);
        $jacocoInit[149] = true;
        C0117M a2 = a.mo3582a((C0128a) kVar);
        C4357f fVar = new C4357f(this);
        $jacocoInit[150] = true;
        C0117M b = a2.mo3594b((C0128a) fVar);
        C4316N n = new C4316N(this);
        $jacocoInit[151] = true;
        C0117M a3 = b.mo3583a((C0129b<? super Throwable>) n);
        $jacocoInit[152] = true;
        return a3;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15399c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.loginSuccess();
        $jacocoInit[157] = true;
        navigateToMainView();
        $jacocoInit[158] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15402d() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[156] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo15420j(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[153] = true;
        this.crashReport.log(throwable);
        $jacocoInit[154] = true;
        this.accountAnalytics.sendLoginErrorEvent(LoginMethod.GOOGLE, throwable);
        $jacocoInit[155] = true;
    }

    private void handleFacebookSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4333W w = C4333W.f7929a;
        $jacocoInit[58] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) w);
        C4361ga gaVar = new C4361ga(this);
        $jacocoInit[59] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) gaVar);
        C4291D d2 = new C4291D(this);
        $jacocoInit[60] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) d2);
        C4414y yVar = new C4414y(this);
        $jacocoInit[61] = true;
        C0120S b2 = f.mo3636b((C0129b<? super T>) yVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[62] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4331V v = C4331V.f7927a;
        C4320P p = new C4320P(this);
        $jacocoInit[63] = true;
        a.mo3626a((C0129b<? super T>) v, (C0129b<Throwable>) p);
        $jacocoInit[64] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m8667i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[144] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ void mo15419j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        showOrHideFacebookSignUp();
        $jacocoInit[143] = true;
    }

    /* renamed from: k */
    public /* synthetic */ C0120S mo15421k(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S facebookSignUpEvent = this.view.facebookSignUpEvent();
        $jacocoInit[142] = true;
        return facebookSignUpEvent;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15405d(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[139] = true;
        this.accountAnalytics.sendFacebookLoginButtonPressed();
        $jacocoInit[140] = true;
        this.accountNavigator.navigateToFacebookSignUpForResult(this.permissions);
        $jacocoInit[141] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m8663e(Void __) {
        $jacocoInit()[138] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15400c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[135] = true;
        this.view.showError(this.errorMapper.map(err));
        $jacocoInit[136] = true;
        this.crashReport.log(err);
        $jacocoInit[137] = true;
    }

    private void handleFacebookSignUpWithRequiredPermissionsEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4325S s = C4325S.f7921a;
        $jacocoInit[65] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) s);
        C4355ea eaVar = new C4355ea(this);
        $jacocoInit[66] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eaVar);
        C4352da daVar = new C4352da(this);
        $jacocoInit[67] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) daVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[68] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4399t tVar = C4399t.f7995a;
        C4327T t = new C4327T(this);
        $jacocoInit[69] = true;
        a.mo3626a((C0129b<? super T>) tVar, (C0129b<Throwable>) t);
        $jacocoInit[70] = true;
    }

    /* renamed from: n */
    static /* synthetic */ Boolean m8670n(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[134] = true;
        return valueOf;
    }

    /* renamed from: o */
    public /* synthetic */ C0120S mo15427o(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S facebookSignUpWithRequiredPermissionsInEvent = this.view.facebookSignUpWithRequiredPermissionsInEvent();
        $jacocoInit[133] = true;
        return facebookSignUpWithRequiredPermissionsInEvent;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15411f(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[131] = true;
        this.accountNavigator.navigateToFacebookSignUpForResult(this.requiredPermissions);
        $jacocoInit[132] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m8664g(Void __) {
        $jacocoInit()[130] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15404d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[127] = true;
        this.view.showError(this.errorMapper.map(err));
        $jacocoInit[128] = true;
        this.crashReport.log(err);
        $jacocoInit[129] = true;
    }

    private void handleFacebookSignUpResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4312L l = C4312L.f7908a;
        $jacocoInit[71] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) l);
        C4367ia iaVar = new C4367ia(this);
        $jacocoInit[72] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iaVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[73] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[74] = true;
        a.mo3670j();
        $jacocoInit[75] = true;
    }

    /* renamed from: l */
    static /* synthetic */ Boolean m8669l(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[126] = true;
        return valueOf;
    }

    /* renamed from: m */
    public /* synthetic */ C0120S mo15425m(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S facebookSignUpResults = this.accountNavigator.facebookSignUpResults();
        C4411x xVar = new C4411x(this);
        $jacocoInit[107] = true;
        C0120S g = facebookSignUpResults.mo3663g((C0132p<? super T, ? extends C0117M>) xVar);
        $jacocoInit[108] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[109] = true;
        return g2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15387a(FacebookLoginResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M signUp = this.accountManager.signUp(FacebookSignUpAdapter.TYPE, result);
        $jacocoInit[110] = true;
        C0117M a = signUp.mo3581a(C14522a.m46170a());
        C4364ha haVar = new C4364ha(this);
        $jacocoInit[111] = true;
        C0117M a2 = a.mo3582a((C0128a) haVar);
        C4393r rVar = new C4393r(this);
        $jacocoInit[112] = true;
        C0117M b = a2.mo3594b((C0128a) rVar);
        C4366i iVar = new C4366i(this);
        $jacocoInit[113] = true;
        C0117M a3 = b.mo3583a((C0129b<? super Throwable>) iVar);
        $jacocoInit[114] = true;
        return a3;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15406e() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.loginSuccess();
        $jacocoInit[124] = true;
        navigateToMainView();
        $jacocoInit[125] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15409f() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[123] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo15422k(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(throwable instanceof FacebookSignUpException)) {
            $jacocoInit[115] = true;
        } else {
            FacebookSignUpException facebookSignUpException = (FacebookSignUpException) throwable;
            $jacocoInit[116] = true;
            if (facebookSignUpException.getCode() != 1) {
                $jacocoInit[117] = true;
            } else {
                $jacocoInit[118] = true;
                this.view.showFacebookPermissionsRequiredError(throwable);
                $jacocoInit[119] = true;
            }
        }
        this.accountAnalytics.sendLoginErrorEvent(LoginMethod.FACEBOOK, throwable);
        $jacocoInit[120] = true;
        this.crashReport.log(throwable);
        $jacocoInit[121] = true;
        this.view.showError(this.errorMapper.map(throwable));
        $jacocoInit[122] = true;
    }

    private C0120S<Void> aptoideShowLoginClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showAptoideLoginAreaClick = this.view.showAptoideLoginAreaClick();
        C4360g gVar = new C4360g(this);
        $jacocoInit[76] = true;
        C0120S<Void> b = showAptoideLoginAreaClick.mo3636b((C0129b<? super T>) gVar);
        $jacocoInit[77] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15392a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAptoideLoginArea();
        $jacocoInit[106] = true;
    }

    private C0120S<Void> forgotPasswordSelection() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S forgotPasswordClick = this.view.forgotPasswordClick();
        C4381n nVar = new C4381n(this);
        $jacocoInit[78] = true;
        C0120S<Void> b = forgotPasswordClick.mo3636b((C0129b<? super T>) nVar);
        $jacocoInit[79] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15397b(Void selection) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToRecoverPasswordView();
        $jacocoInit[105] = true;
    }

    private C0120S<Void> togglePasswordVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showHidePasswordClick = this.view.showHidePasswordClick();
        C4308J j = new C4308J(this);
        $jacocoInit[80] = true;
        C0120S<Void> b = showHidePasswordClick.mo3636b((C0129b<? super T>) j);
        $jacocoInit[81] = true;
        return b;
    }

    /* renamed from: l */
    public /* synthetic */ void mo15423l(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.view.isPasswordVisible()) {
            $jacocoInit[101] = true;
            this.view.hidePassword();
            $jacocoInit[102] = true;
        } else {
            this.view.showPassword();
            $jacocoInit[103] = true;
        }
        $jacocoInit[104] = true;
    }

    private void showOrHideFacebookSignUp() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.accountManager.isSignUpEnabled(FacebookSignUpAdapter.TYPE)) {
            $jacocoInit[82] = true;
            this.view.showFacebookLogin();
            $jacocoInit[83] = true;
        } else {
            this.view.hideFacebookLogin();
            $jacocoInit[84] = true;
        }
        $jacocoInit[85] = true;
    }

    private void showOrHideGoogleSignUp() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.accountManager.isSignUpEnabled(GoogleSignUpAdapter.TYPE)) {
            $jacocoInit[86] = true;
            this.view.showGoogleLogin();
            $jacocoInit[87] = true;
        } else {
            this.view.hideGoogleLogin();
            $jacocoInit[88] = true;
        }
        $jacocoInit[89] = true;
    }

    private void navigateToMainView() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.dismissToNavigateToMainView) {
            $jacocoInit[90] = true;
            this.view.dismiss();
            $jacocoInit[91] = true;
        } else if (this.navigateToHome) {
            $jacocoInit[92] = true;
            navigateToMainViewCleaningBackStack();
            $jacocoInit[93] = true;
        } else {
            navigateBack();
            $jacocoInit[94] = true;
        }
        $jacocoInit[95] = true;
    }

    /* access modifiers changed from: 0000 */
    public void lockScreenRotation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.lockScreenRotation();
        $jacocoInit[96] = true;
    }

    /* access modifiers changed from: 0000 */
    public void unlockScreenRotation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.unlockScreenRotation();
        $jacocoInit[97] = true;
    }

    /* access modifiers changed from: 0000 */
    public void navigateToCreateProfile() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToCreateProfileView();
        $jacocoInit[98] = true;
    }

    private void navigateToMainViewCleaningBackStack() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToHomeView();
        $jacocoInit[99] = true;
    }

    private void navigateBack() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.popView();
        $jacocoInit[100] = true;
    }
}
