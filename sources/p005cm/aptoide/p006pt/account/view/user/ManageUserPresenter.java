package p005cm.aptoide.p006pt.account.view.user;

import android.net.Uri;
import android.text.TextUtils;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.view.ThrowableToStringMapper;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.account.view.user.ManageUserPresenter */
public class ManageUserPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReport;
    private final ThrowableToStringMapper errorMapper;
    private final boolean isEditProfile;
    private final boolean isFirstTime;
    private final ManageUserNavigator navigator;
    private final boolean showPrivacyConfigs;
    private final UriToPathResolver uriToPathResolver;
    private final ManageUserView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3610110789311921605L, "cm/aptoide/pt/account/view/user/ManageUserPresenter", 128);
        $jacocoData = probes;
        return probes;
    }

    public ManageUserPresenter(ManageUserView view2, CrashReport crashReport2, AptoideAccountManager accountManager2, ThrowableToStringMapper errorMapper2, ManageUserNavigator navigator2, boolean isEditProfile2, UriToPathResolver uriToPathResolver2, boolean showPrivacyConfigs2, boolean isFirstTime2, AccountAnalytics accountAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.crashReport = crashReport2;
        this.accountManager = accountManager2;
        this.errorMapper = errorMapper2;
        this.navigator = navigator2;
        this.isEditProfile = isEditProfile2;
        this.uriToPathResolver = uriToPathResolver2;
        this.showPrivacyConfigs = showPrivacyConfigs2;
        this.isFirstTime = isFirstTime2;
        this.accountAnalytics = accountAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleSaveDataClick();
        $jacocoInit[1] = true;
        handleCancelClick();
        $jacocoInit[2] = true;
        handleCalendarClickLayout();
        $jacocoInit[3] = true;
        onViewCreatedLoadUserData();
        $jacocoInit[4] = true;
    }

    private void handleCalendarClickLayout() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1560F f = C1560F.f4501a;
        $jacocoInit[5] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) f);
        C1561G g = new C1561G(this);
        $jacocoInit[6] = true;
        C0120S f2 = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) g);
        C1623v vVar = new C1623v(this);
        $jacocoInit[7] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) vVar);
        ManageUserView manageUserView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[8] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) manageUserView.bindUntilEvent(lifecycleEvent2));
        C1555A a2 = C1555A.f4496a;
        C1617s sVar = new C1617s(this);
        $jacocoInit[9] = true;
        a.mo3626a((C0129b<? super T>) a2, (C0129b<Throwable>) sVar);
        $jacocoInit[10] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6327a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[125] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[126] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[127] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo9925b(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S calendarLayoutClick = this.view.calendarLayoutClick();
        $jacocoInit[124] = true;
        return calendarLayoutClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9923a(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showCalendar();
        $jacocoInit[123] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6328b(Void __) {
        $jacocoInit()[122] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9922a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[121] = true;
    }

    private void onViewCreatedLoadUserData() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1556B b = C1556B.f4497a;
        $jacocoInit[11] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) b);
        C1621u uVar = new C1621u(this);
        $jacocoInit[12] = true;
        C0120S d2 = d.mo3653d((C0132p<? super T, Boolean>) uVar);
        C1613q qVar = new C1613q(this);
        $jacocoInit[13] = true;
        C0120S i = d2.mo3668i(qVar);
        C1607n nVar = new C1607n(this);
        $jacocoInit[14] = true;
        C0120S j = i.mo3669j(nVar);
        C1601k kVar = C1601k.f4545a;
        $jacocoInit[15] = true;
        C0120S d3 = j.mo3653d((C0132p<? super T, Boolean>) kVar);
        $jacocoInit[16] = true;
        C0120S a = d3.mo3616a(C14522a.m46170a());
        ManageUserView manageUserView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[17] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) manageUserView.bindUntilEvent(lifecycleEvent2));
        C1603l lVar = new C1603l(this);
        C1611p pVar = new C1611p(this);
        $jacocoInit[18] = true;
        a2.mo3626a((C0129b<? super T>) lVar, (C0129b<Throwable>) pVar);
        $jacocoInit[19] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m6333g(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[118] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[119] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[120] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ Boolean mo9939h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.isFirstTime);
        $jacocoInit[117] = true;
        return valueOf;
    }

    /* renamed from: i */
    public /* synthetic */ Single mo9940i(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[114] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[115] = true;
        Single n = d.mo3678n();
        $jacocoInit[116] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ ViewModel mo9919a(Account userAccount) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isEditProfile) {
            $jacocoInit[110] = true;
            String nickname = userAccount.getNickname();
            $jacocoInit[111] = true;
            ViewModel viewModel = new ViewModel(nickname, userAccount.getAvatar());
            $jacocoInit[112] = true;
            return viewModel;
        }
        $jacocoInit[113] = true;
        return null;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m6332f(ViewModel data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (data != null) {
            $jacocoInit[107] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[108] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[109] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ void mo9936e(ViewModel data) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.loadImageStateless(data.getPictureUri());
        $jacocoInit[105] = true;
        this.view.setUserName(data.getName());
        $jacocoInit[106] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9930c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[104] = true;
    }

    private void navigateAway() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isEditProfile) {
            $jacocoInit[20] = true;
            this.navigator.goBack();
            $jacocoInit[21] = true;
        } else if (this.showPrivacyConfigs) {
            $jacocoInit[22] = true;
            this.navigator.toProfileStepOne();
            $jacocoInit[23] = true;
        } else {
            this.navigator.goToHome();
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
    }

    private void handleSaveDataClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1625w wVar = C1625w.f4573a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) wVar);
        C1627x xVar = new C1627x(this);
        $jacocoInit[27] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xVar);
        ManageUserView manageUserView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[28] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) manageUserView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[29] = true;
        a.mo3670j();
        $jacocoInit[30] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m6331e(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[101] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[102] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[103] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo9937f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S saveUserDataButtonClick = this.view.saveUserDataButtonClick();
        C1629y yVar = new C1629y(this);
        $jacocoInit[81] = true;
        C0120S b = saveUserDataButtonClick.mo3636b((C0129b<? super T>) yVar);
        C1595h hVar = new C1595h(this);
        $jacocoInit[82] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) hVar);
        C1615r rVar = new C1615r(this);
        $jacocoInit[83] = true;
        C0120S b2 = d.mo3636b((C0129b<? super T>) rVar);
        C1619t tVar = new C1619t(this);
        $jacocoInit[84] = true;
        C0120S g = b2.mo3663g((C0132p<? super T, ? extends C0117M>) tVar);
        $jacocoInit[85] = true;
        C0120S g2 = g.mo3662g();
        $jacocoInit[86] = true;
        return g2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9921a(ViewModel viewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (viewModel.hasDate()) {
            $jacocoInit[96] = true;
        } else if (this.isEditProfile) {
            $jacocoInit[97] = true;
        } else {
            $jacocoInit[98] = true;
            this.view.showEmptyBirthdayMessage();
            $jacocoInit[99] = true;
        }
        $jacocoInit[100] = true;
    }

    /* renamed from: b */
    public /* synthetic */ Boolean mo9924b(ViewModel viewModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isEditProfile) {
            $jacocoInit[89] = true;
        } else {
            if (!viewModel.hasDate()) {
                $jacocoInit[90] = true;
            } else if (viewModel.hasDateError()) {
                $jacocoInit[91] = true;
            } else {
                $jacocoInit[92] = true;
            }
            z = false;
            $jacocoInit[94] = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[95] = true;
            return valueOf;
        }
        $jacocoInit[93] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[95] = true;
        return valueOf2;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9929c(ViewModel __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showProgressDialog();
        $jacocoInit[88] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo9931d(ViewModel userData) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M saveUserData = saveUserData(userData);
        $jacocoInit[87] = true;
        return saveUserData;
    }

    private C0117M saveUserData(ViewModel userData) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = updateUserAccount(userData).mo3581a(C14522a.m46170a());
        C1593g gVar = new C1593g(this);
        $jacocoInit[31] = true;
        C0117M a2 = a.mo3582a((C0128a) gVar);
        C1605m mVar = new C1605m(this, userData);
        $jacocoInit[32] = true;
        C0117M a3 = a2.mo3582a((C0128a) mVar);
        C1557C c = new C1557C(this);
        $jacocoInit[33] = true;
        C0117M a4 = a3.mo3582a((C0128a) c);
        C1597i iVar = new C1597i(this);
        $jacocoInit[34] = true;
        C0117M b = a4.mo3596b((C0132p<? super Throwable, ? extends C0117M>) iVar);
        $jacocoInit[35] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9928c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideProgressDialog();
        $jacocoInit[80] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo9938g(ViewModel userData) {
        boolean[] $jacocoInit = $jacocoInit();
        sendAnalytics(userData);
        $jacocoInit[79] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9934d() {
        boolean[] $jacocoInit = $jacocoInit();
        navigateAway();
        $jacocoInit[78] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo9932d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M handleSaveUserDataError = handleSaveUserDataError(err);
        $jacocoInit[77] = true;
        return handleSaveUserDataError;
    }

    private void handleCancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1599j jVar = C1599j.f4543a;
        $jacocoInit[36] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jVar);
        C1630z zVar = new C1630z(this);
        $jacocoInit[37] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zVar);
        ManageUserView manageUserView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[38] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) manageUserView.bindUntilEvent(lifecycleEvent2));
        C1558D d2 = C1558D.f4499a;
        C1559E e = new C1559E(this);
        $jacocoInit[39] = true;
        a.mo3626a((C0129b<? super T>) d2, (C0129b<Throwable>) e);
        $jacocoInit[40] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6329c(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[74] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[75] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[76] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo9933d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelButtonClick = this.view.cancelButtonClick();
        C1609o oVar = new C1609o(this);
        $jacocoInit[71] = true;
        C0120S b = cancelButtonClick.mo3636b((C0129b<? super T>) oVar);
        $jacocoInit[72] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9935d(Void __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.goBack();
        $jacocoInit[73] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m6330c(Void __) {
        $jacocoInit()[70] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9927b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[69] = true;
    }

    private C0117M handleSaveUserDataError(Throwable throwable) {
        C0117M errorHandler;
        boolean[] $jacocoInit = $jacocoInit();
        String message = this.errorMapper.map(throwable);
        if (throwable instanceof SocketTimeoutException) {
            $jacocoInit[41] = true;
        } else if (throwable instanceof TimeoutException) {
            $jacocoInit[42] = true;
        } else {
            errorHandler = this.view.showErrorMessage(message);
            $jacocoInit[45] = true;
            C0117M c = C0117M.m597c((C0128a) new C1562H(this));
            $jacocoInit[46] = true;
            C0117M a = c.mo3580a(errorHandler);
            $jacocoInit[47] = true;
            return a;
        }
        C0117M showErrorMessage = this.view.showErrorMessage(message);
        C1563I i = new C1563I(this);
        $jacocoInit[43] = true;
        errorHandler = showErrorMessage.mo3582a((C0128a) i);
        $jacocoInit[44] = true;
        C0117M c2 = C0117M.m597c((C0128a) new C1562H(this));
        $jacocoInit[46] = true;
        C0117M a2 = c2.mo3580a(errorHandler);
        $jacocoInit[47] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9920a() {
        boolean[] $jacocoInit = $jacocoInit();
        navigateAway();
        $jacocoInit[68] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9926b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideProgressDialog();
        $jacocoInit[67] = true;
    }

    private void sendAnalytics(ViewModel userData) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isEditProfile) {
            $jacocoInit[48] = true;
        } else {
            $jacocoInit[49] = true;
            AccountAnalytics accountAnalytics2 = this.accountAnalytics;
            if (!TextUtils.isEmpty(userData.getPictureUri())) {
                $jacocoInit[50] = true;
                z = true;
            } else {
                z = false;
                $jacocoInit[51] = true;
            }
            accountAnalytics2.createdUserProfile(z);
            $jacocoInit[52] = true;
        }
        $jacocoInit[53] = true;
    }

    private C0117M updateUserAccount(ViewModel userData) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isEditProfile) {
            $jacocoInit[54] = true;
            if (userData.hasNewPicture()) {
                UriToPathResolver uriToPathResolver2 = this.uriToPathResolver;
                $jacocoInit[55] = true;
                String mediaStoragePath = uriToPathResolver2.getMediaStoragePath(Uri.parse(userData.getPictureUri()));
                $jacocoInit[56] = true;
                C0117M updateAccount = this.accountManager.updateAccount(userData.getName(), mediaStoragePath);
                $jacocoInit[57] = true;
                return updateAccount;
            }
            C0117M updateAccount2 = this.accountManager.updateAccount(userData.getName());
            $jacocoInit[58] = true;
            return updateAccount2;
        } else if (userData.hasNewPicture()) {
            UriToPathResolver uriToPathResolver3 = this.uriToPathResolver;
            $jacocoInit[59] = true;
            String mediaStoragePath2 = uriToPathResolver3.getMediaStoragePath(Uri.parse(userData.getPictureUri()));
            $jacocoInit[60] = true;
            C0117M updateAccount3 = this.accountManager.updateAccount(userData.getName(), mediaStoragePath2);
            AptoideAccountManager aptoideAccountManager = this.accountManager;
            $jacocoInit[61] = true;
            C0117M c = updateAccount3.mo3600c(aptoideAccountManager.changeBirthdayDate(userData.getRequestDate()));
            AptoideAccountManager aptoideAccountManager2 = this.accountManager;
            $jacocoInit[62] = true;
            C0117M c2 = c.mo3600c(aptoideAccountManager2.changeSubscribeNewsletter(userData.getNewsletterSubscribe()));
            $jacocoInit[63] = true;
            return c2;
        } else {
            C0117M updateAccount4 = this.accountManager.updateAccount(userData.getName());
            AptoideAccountManager aptoideAccountManager3 = this.accountManager;
            $jacocoInit[64] = true;
            C0117M c3 = updateAccount4.mo3600c(aptoideAccountManager3.changeBirthdayDate(userData.getRequestDate()));
            AptoideAccountManager aptoideAccountManager4 = this.accountManager;
            $jacocoInit[65] = true;
            C0117M c4 = c3.mo3600c(aptoideAccountManager4.changeSubscribeNewsletter(userData.getNewsletterSubscribe()));
            $jacocoInit[66] = true;
            return c4;
        }
    }
}
