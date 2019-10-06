package p005cm.aptoide.p006pt.account.view.user;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account.Access;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.LoginSignupManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.ProfileAction;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.account.view.user.ProfileStepOnePresenter */
public class ProfileStepOnePresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = ProfileStepOnePresenter.class.getSimpleName();
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private LoginSignupManager loginSignupManager;
    private final ProfileStepOneView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6625480136846652437L, "cm/aptoide/pt/account/view/user/ProfileStepOnePresenter", 47);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[46] = true;
    }

    public ProfileStepOnePresenter(ProfileStepOneView view2, CrashReport crashReport2, AptoideAccountManager accountManager2, AccountNavigator accountNavigator2, AccountAnalytics accountAnalytics2, LoginSignupManager loginSignupManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.crashReport = crashReport2;
        this.accountManager = accountManager2;
        this.accountNavigator = accountNavigator2;
        this.accountAnalytics = accountAnalytics2;
        this.loginSignupManager = loginSignupManager2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1579Y y = C1579Y.f4520a;
        $jacocoInit[1] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) y);
        C1582aa aaVar = new C1582aa(this);
        $jacocoInit[2] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aaVar);
        ProfileStepOneView profileStepOneView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[3] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) profileStepOneView.bindUntilEvent(lifecycleEvent2));
        C1584ba baVar = C1584ba.f4526a;
        C1574T t = new C1574T(this);
        $jacocoInit[4] = true;
        a.mo3626a((C0129b<? super T>) baVar, (C0129b<Throwable>) t);
        $jacocoInit[5] = true;
        C0120S lifecycleEvent3 = this.view.getLifecycleEvent();
        C1572Q q = C1572Q.f4513a;
        $jacocoInit[6] = true;
        C0120S d2 = lifecycleEvent3.mo3653d((C0132p<? super T, Boolean>) q);
        C1578X x = new C1578X(this);
        $jacocoInit[7] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) x);
        ProfileStepOneView profileStepOneView2 = this.view;
        LifecycleEvent lifecycleEvent4 = LifecycleEvent.DESTROY;
        $jacocoInit[8] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) profileStepOneView2.bindUntilEvent(lifecycleEvent4));
        C1576V v = C1576V.f4517a;
        C1573S s = new C1573S(this);
        $jacocoInit[9] = true;
        a2.mo3626a((C0129b<? super T>) v, (C0129b<Throwable>) s);
        $jacocoInit[10] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6357a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[45] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo9958c(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S moreInfoButtonClick = this.view.moreInfoButtonClick();
        C1567M m = new C1567M(this);
        $jacocoInit[40] = true;
        C0120S b = moreInfoButtonClick.mo3636b((C0129b<? super T>) m);
        C1569N n = new C1569N(this);
        $jacocoInit[41] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) n);
        $jacocoInit[42] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9953a(Void __1) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.accountProfileAction(1, ProfileAction.MORE_INFO);
        $jacocoInit[44] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9957b(Void __1) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToProfileStepTwoView();
        $jacocoInit[43] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6360c(Void __) {
        $jacocoInit()[39] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9961d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[38] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m6361d(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[37] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo9954b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S continueButtonClick = this.view.continueButtonClick();
        C1571P p = new C1571P(this);
        $jacocoInit[17] = true;
        C0120S b = continueButtonClick.mo3636b((C0129b<? super T>) p);
        C1566L l = new C1566L(this);
        $jacocoInit[18] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) l);
        C1577W w = C1577W.f4518a;
        $jacocoInit[19] = true;
        C0120S a = f.mo3621a((C0129b<? super Throwable>) w);
        $jacocoInit[20] = true;
        C0120S g = a.mo3662g();
        $jacocoInit[21] = true;
        return g;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9959c(Boolean __11) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showWaitDialog();
        $jacocoInit[36] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo9955b(Boolean isExternalLogin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = makeUserProfilePublic().mo3581a(C14522a.m46170a());
        C1570O o = new C1570O(this);
        $jacocoInit[24] = true;
        C0117M a2 = a.mo3582a((C0128a) o);
        C1575U u = new C1575U(this);
        $jacocoInit[25] = true;
        C0117M a3 = a2.mo3582a((C0128a) u);
        C1565K k = new C1565K(this, isExternalLogin);
        $jacocoInit[26] = true;
        C0117M a4 = a3.mo3582a((C0128a) k);
        $jacocoInit[27] = true;
        C0120S f = a4.mo3604f();
        $jacocoInit[28] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9951a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountAnalytics.accountProfileAction(1, ProfileAction.CONTINUE);
        $jacocoInit[35] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9956b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissWaitDialog();
        $jacocoInit[34] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9952a(Boolean isExternalLogin) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isExternalLogin.booleanValue()) {
            $jacocoInit[29] = true;
        } else if (!this.loginSignupManager.shouldShowCreateStore()) {
            $jacocoInit[30] = true;
        } else {
            this.accountNavigator.navigateToCreateStoreView();
            $jacocoInit[32] = true;
            $jacocoInit[33] = true;
        }
        this.accountNavigator.navigateToHomeView();
        $jacocoInit[31] = true;
        $jacocoInit[33] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6359b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[22] = true;
        instance.mo2142e(str, throwable);
        $jacocoInit[23] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6358a(Object __) {
        $jacocoInit()[16] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9960c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[15] = true;
    }

    private C0117M makeUserProfilePublic() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M updateAccount = this.accountManager.updateAccount(Access.PUBLIC);
        C1580Z z = new C1580Z(this);
        $jacocoInit[11] = true;
        C0117M b = updateAccount.mo3596b((C0132p<? super Throwable, ? extends C0117M>) z);
        $jacocoInit[12] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9950a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[13] = true;
        C0117M showGenericErrorMessage = this.view.showGenericErrorMessage();
        $jacocoInit[14] = true;
        return showGenericErrorMessage;
    }
}
