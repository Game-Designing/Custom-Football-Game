package p005cm.aptoide.p006pt.presenter;

import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.accountmanager.AptoideCredentials;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.ThrowableToStringMapper;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.presenter.LoginSignupCredentialsFlavorPresenter */
public class LoginSignupCredentialsFlavorPresenter extends LoginSignUpCredentialsPresenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private final ThrowableToStringMapper errorMapper;
    private final LoginSignUpCredentialsView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8382236935939378631L, "cm/aptoide/pt/presenter/LoginSignupCredentialsFlavorPresenter", 62);
        $jacocoData = probes;
        return probes;
    }

    public LoginSignupCredentialsFlavorPresenter(LoginSignUpCredentialsView view2, AptoideAccountManager accountManager, CrashReport crashReport2, boolean dismissToNavigateToMainView, boolean navigateToHome, AccountNavigator accountNavigator2, Collection<String> permissions, Collection<String> requiredPermissions, ThrowableToStringMapper errorMapper2, AccountAnalytics accountAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view2, accountManager, crashReport2, dismissToNavigateToMainView, navigateToHome, accountNavigator2, permissions, requiredPermissions, errorMapper2, accountAnalytics);
        this.view = view2;
        this.errorMapper = errorMapper2;
        this.crashReport = crashReport2;
        this.accountNavigator = accountNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        super.present();
        $jacocoInit[1] = true;
        showAptoideSignUpEvent();
        $jacocoInit[2] = true;
        handleAptoideShowSignUpEvent();
        $jacocoInit[3] = true;
        handleClickOnTermsAndConditions();
        $jacocoInit[4] = true;
        handleClickOnPrivacyPolicy();
        $jacocoInit[5] = true;
        showTCandPP();
        $jacocoInit[6] = true;
    }

    /* access modifiers changed from: protected */
    public C0120S<AptoideCredentials> getAptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideSignUpEvent = this.view.aptoideSignUpEvent();
        C4286Ba ba = new C4286Ba(this);
        $jacocoInit[7] = true;
        C0120S b = aptoideSignUpEvent.mo3636b((C0129b<? super T>) ba);
        C4305Hb hb = C4305Hb.f7901a;
        $jacocoInit[8] = true;
        C0120S<AptoideCredentials> d = b.mo3653d((C0132p<? super T, Boolean>) hb);
        $jacocoInit[9] = true;
        return d;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15438e(AptoideCredentials credentials) {
        boolean[] $jacocoInit = $jacocoInit();
        showNotCheckedMessage(credentials.isChecked());
        $jacocoInit[61] = true;
    }

    private void handleClickOnTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4409wa waVar = C4409wa.f8005a;
        $jacocoInit[10] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) waVar);
        C4403ua uaVar = new C4403ua(this);
        $jacocoInit[11] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) uaVar);
        C4289Ca ca = new C4289Ca(this);
        $jacocoInit[12] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ca);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[13] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4388pa paVar = C4388pa.f7984a;
        C4397sa saVar = new C4397sa(this);
        $jacocoInit[14] = true;
        a.mo3626a((C0129b<? super T>) paVar, (C0129b<Throwable>) saVar);
        $jacocoInit[15] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m8720C(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[60] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo15435D(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S termsAndConditionsClickEvent = this.view.termsAndConditionsClickEvent();
        $jacocoInit[59] = true;
        return termsAndConditionsClickEvent;
    }

    /* renamed from: o */
    public /* synthetic */ void mo15443o(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToTermsAndConditions();
        $jacocoInit[58] = true;
    }

    /* renamed from: p */
    static /* synthetic */ void m8726p(Void __) {
        $jacocoInit()[57] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo15442n(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[56] = true;
    }

    private void handleClickOnPrivacyPolicy() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4298Fa fa = C4298Fa.f7894a;
        $jacocoInit[16] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) fa);
        C4406va vaVar = new C4406va(this);
        $jacocoInit[17] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vaVar);
        C4385oa oaVar = new C4385oa(this);
        $jacocoInit[18] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) oaVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[19] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4400ta taVar = C4400ta.f7996a;
        C4283Aa aa = new C4283Aa(this);
        $jacocoInit[20] = true;
        a.mo3626a((C0129b<? super T>) taVar, (C0129b<Throwable>) aa);
        $jacocoInit[21] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m8719A(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[55] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo15434B(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S privacyPolicyClickEvent = this.view.privacyPolicyClickEvent();
        $jacocoInit[54] = true;
        return privacyPolicyClickEvent;
    }

    /* renamed from: m */
    public /* synthetic */ void mo15441m(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToPrivacyPolicy();
        $jacocoInit[53] = true;
    }

    /* renamed from: n */
    static /* synthetic */ void m8725n(Void __) {
        $jacocoInit()[52] = true;
    }

    /* renamed from: m */
    public /* synthetic */ void mo15440m(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[51] = true;
    }

    private void showTCandPP() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4394ra raVar = C4394ra.f7990a;
        $jacocoInit[22] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) raVar);
        C4382na naVar = new C4382na(this);
        $jacocoInit[23] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) naVar);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[24] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[25] = true;
        a.mo3670j();
        $jacocoInit[26] = true;
    }

    /* renamed from: E */
    static /* synthetic */ Boolean m8721E(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[50] = true;
        return valueOf;
    }

    /* renamed from: F */
    public /* synthetic */ void mo15436F(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showTCandPP();
        $jacocoInit[49] = true;
    }

    private void handleAptoideShowSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4415ya yaVar = C4415ya.f8011a;
        $jacocoInit[27] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) yaVar);
        C4301Ga ga = new C4301Ga(this);
        $jacocoInit[28] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ga);
        LoginSignUpCredentialsView loginSignUpCredentialsView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[29] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) loginSignUpCredentialsView.bindUntilEvent(lifecycleEvent2));
        C4391qa qaVar = C4391qa.f7987a;
        C4292Da da = new C4292Da(this);
        $jacocoInit[30] = true;
        a.mo3626a((C0129b<? super T>) qaVar, (C0129b<Throwable>) da);
        $jacocoInit[31] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m8727y(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[48] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo15444z(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showAptoideSignUpEvent = showAptoideSignUpEvent();
        $jacocoInit[47] = true;
        return showAptoideSignUpEvent;
    }

    /* renamed from: a */
    static /* synthetic */ void m8723a(Boolean __) {
        $jacocoInit()[46] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo15439l(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[43] = true;
        this.view.showError(this.errorMapper.map(err));
        $jacocoInit[44] = true;
        this.crashReport.log(err);
        $jacocoInit[45] = true;
    }

    private C0120S<Boolean> showAptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S showAptoideSignUpAreaClick = this.view.showAptoideSignUpAreaClick();
        C4295Ea ea = new C4295Ea(this);
        $jacocoInit[32] = true;
        C0120S b = showAptoideSignUpAreaClick.mo3636b((C0129b<? super T>) ea);
        C4418za zaVar = C4418za.f8014a;
        $jacocoInit[33] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) zaVar);
        C4412xa xaVar = new C4412xa(this);
        $jacocoInit[34] = true;
        C0120S<Boolean> b2 = d.mo3636b((C0129b<? super T>) xaVar);
        $jacocoInit[35] = true;
        return b2;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8724b(Boolean event) {
        $jacocoInit()[42] = true;
        return event;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15437c(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAptoideSignUpArea();
        $jacocoInit[41] = true;
    }

    /* access modifiers changed from: private */
    public void showNotCheckedMessage(boolean checked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (checked) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            this.view.showTermsConditionError();
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
    }

    public boolean handle() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean tryCloseLoginBottomSheet = this.view.tryCloseLoginBottomSheet(true);
        $jacocoInit[40] = true;
        return tryCloseLoginBottomSheet;
    }
}
