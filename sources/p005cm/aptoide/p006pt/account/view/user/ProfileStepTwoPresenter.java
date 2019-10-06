package p005cm.aptoide.p006pt.account.view.user;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account.Access;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.LoginSignupManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.ProfileAction;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import rx.Observable;

/* renamed from: cm.aptoide.pt.account.view.user.ProfileStepTwoPresenter */
public class ProfileStepTwoPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private LoginSignupManager loginSignupManager;
    private final ProfileStepTwoView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8198526663200734579L, "cm/aptoide/pt/account/view/user/ProfileStepTwoPresenter", 55);
        $jacocoData = probes;
        return probes;
    }

    public ProfileStepTwoPresenter(ProfileStepTwoView view2, AptoideAccountManager accountManager2, CrashReport crashReport2, AccountNavigator accountNavigator2, AccountAnalytics accountAnalytics2, LoginSignupManager loginSignupManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.accountManager = accountManager2;
        this.crashReport = crashReport2;
        this.accountNavigator = accountNavigator2;
        this.accountAnalytics = accountAnalytics2;
        this.loginSignupManager = loginSignupManager2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S continueButtonClick = this.view.continueButtonClick();
        C1622ua uaVar = new C1622ua(this);
        $jacocoInit[1] = true;
        C0120S b = continueButtonClick.mo3636b((C0129b<? super T>) uaVar);
        C1624va vaVar = new C1624va(this);
        $jacocoInit[2] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) vaVar);
        $jacocoInit[3] = true;
        C0120S g2 = g.mo3662g();
        C1596ha haVar = C1596ha.f4539a;
        $jacocoInit[4] = true;
        Observable<Void> handleContinueClick = g2.mo3669j(haVar);
        $jacocoInit[5] = true;
        C0120S makePrivateProfileButtonClick = this.view.makePrivateProfileButtonClick();
        C1594ga gaVar = new C1594ga(this);
        $jacocoInit[6] = true;
        C0120S b2 = makePrivateProfileButtonClick.mo3636b((C0129b<? super T>) gaVar);
        C1608na naVar = new C1608na(this);
        $jacocoInit[7] = true;
        C0120S g3 = b2.mo3663g((C0132p<? super T, ? extends C0117M>) naVar);
        $jacocoInit[8] = true;
        C0120S g4 = g3.mo3662g();
        C1616ra raVar = C1616ra.f4563a;
        $jacocoInit[9] = true;
        Observable<Void> handlePrivateProfileClick = g4.mo3669j(raVar);
        $jacocoInit[10] = true;
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1600ja jaVar = C1600ja.f4544a;
        $jacocoInit[11] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jaVar);
        C1612pa paVar = new C1612pa(handleContinueClick, handlePrivateProfileClick);
        $jacocoInit[12] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) paVar);
        ProfileStepTwoView profileStepTwoView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[13] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) profileStepTwoView.bindUntilEvent(lifecycleEvent2));
        C1614qa qaVar = C1614qa.f4561a;
        C1604la laVar = new C1604la(this);
        $jacocoInit[14] = true;
        a.mo3626a((C0129b<? super T>) qaVar, (C0129b<Throwable>) laVar);
        $jacocoInit[15] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9980c(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showWaitDialog();
        $jacocoInit[54] = true;
    }

    /* renamed from: f */
    public /* synthetic */ C0117M mo9984f(Boolean externalLogin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = makeAccountPublic().mo3581a(C14522a.m46170a());
        C1626wa waVar = new C1626wa(this);
        $jacocoInit[47] = true;
        C0117M a2 = a.mo3582a((C0128a) waVar);
        C1602ka kaVar = new C1602ka(this);
        $jacocoInit[48] = true;
        C0117M a3 = a2.mo3582a((C0128a) kaVar);
        C1618sa saVar = new C1618sa(this, externalLogin);
        $jacocoInit[49] = true;
        C0117M a4 = a3.mo3582a((C0128a) saVar);
        $jacocoInit[50] = true;
        return a4;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9973a() {
        boolean[] $jacocoInit = $jacocoInit();
        sendAnalytics(ProfileAction.CONTINUE);
        $jacocoInit[53] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9977b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissWaitDialog();
        $jacocoInit[52] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9975a(Boolean externalLogin) {
        boolean[] $jacocoInit = $jacocoInit();
        navigate(externalLogin.booleanValue());
        $jacocoInit[51] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Void m6381g(Boolean __) {
        $jacocoInit()[46] = true;
        return null;
    }

    /* renamed from: h */
    public /* synthetic */ void mo9985h(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showWaitDialog();
        $jacocoInit[45] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo9982d(Boolean externalLogin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = makeAccountPrivate().mo3581a(C14522a.m46170a());
        C1628xa xaVar = new C1628xa(this);
        $jacocoInit[38] = true;
        C0117M a2 = a.mo3582a((C0128a) xaVar);
        C1620ta taVar = new C1620ta(this);
        $jacocoInit[39] = true;
        C0117M a3 = a2.mo3582a((C0128a) taVar);
        C1598ia iaVar = new C1598ia(this, externalLogin);
        $jacocoInit[40] = true;
        C0117M a4 = a3.mo3582a((C0128a) iaVar);
        $jacocoInit[41] = true;
        return a4;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9979c() {
        boolean[] $jacocoInit = $jacocoInit();
        sendAnalytics(ProfileAction.PRIVATE_PROFILE);
        $jacocoInit[44] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9983d() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissWaitDialog();
        $jacocoInit[43] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9978b(Boolean externalLogin) {
        boolean[] $jacocoInit = $jacocoInit();
        navigate(externalLogin.booleanValue());
        $jacocoInit[42] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Void m6380e(Boolean __) {
        $jacocoInit()[37] = true;
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6377a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[34] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[35] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[36] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6378a(C0120S handleContinueClick, C0120S handlePrivateProfileClick, LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(handleContinueClick, handlePrivateProfileClick);
        $jacocoInit[33] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ void m6379a(Void __) {
        $jacocoInit()[32] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9981c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[31] = true;
    }

    private C0117M makeAccountPublic() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M updateAccount = this.accountManager.updateAccount(Access.PUBLIC);
        C1606ma maVar = new C1606ma(this);
        $jacocoInit[16] = true;
        C0117M b = updateAccount.mo3596b((C0132p<? super Throwable, ? extends C0117M>) maVar);
        $jacocoInit[17] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo9976b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[29] = true;
        C0117M showGenericErrorMessage = this.view.showGenericErrorMessage();
        $jacocoInit[30] = true;
        return showGenericErrorMessage;
    }

    private C0117M makeAccountPrivate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M updateAccount = this.accountManager.updateAccount(Access.UNLISTED);
        C1592fa faVar = new C1592fa(this);
        $jacocoInit[18] = true;
        C0117M b = updateAccount.mo3596b((C0132p<? super Throwable, ? extends C0117M>) faVar);
        $jacocoInit[19] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9972a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[27] = true;
        C0117M showGenericErrorMessage = this.view.showGenericErrorMessage();
        $jacocoInit[28] = true;
        return showGenericErrorMessage;
    }

    private C0117M sendAnalytics(ProfileAction action) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1610oa(this, action));
        $jacocoInit[20] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9974a(ProfileAction action) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.accountProfileAction(2, action);
        $jacocoInit[26] = true;
    }

    private void navigate(boolean externalLogin) {
        boolean[] $jacocoInit = $jacocoInit();
        if (externalLogin) {
            $jacocoInit[21] = true;
        } else if (!this.loginSignupManager.shouldShowCreateStore()) {
            $jacocoInit[22] = true;
        } else {
            this.accountNavigator.navigateToCreateStoreView();
            $jacocoInit[24] = true;
            $jacocoInit[25] = true;
        }
        this.accountNavigator.navigateToHomeView();
        $jacocoInit[23] = true;
        $jacocoInit[25] = true;
    }
}
