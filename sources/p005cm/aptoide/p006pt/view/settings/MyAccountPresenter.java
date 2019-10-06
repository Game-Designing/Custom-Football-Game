package p005cm.aptoide.p006pt.view.settings;

import android.content.SharedPreferences;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.accountmanager.Store;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.StoreUserAbstraction.Nodes;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.settings.MyAccountPresenter */
public class MyAccountPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int EDIT_STORE_REQUEST_CODE = 1230;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReport;
    private final MyAccountNavigator myAccountNavigator;
    private final C0126V scheduler;
    private final SharedPreferences sharedPreferences;
    private final MyAccountView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(558550923517403647L, "cm/aptoide/pt/view/settings/MyAccountPresenter", 241);
        $jacocoData = probes;
        return probes;
    }

    public MyAccountPresenter(MyAccountView view2, AptoideAccountManager accountManager2, CrashReport crashReport2, SharedPreferences sharedPreferences2, C0126V scheduler2, MyAccountNavigator myAccountNavigator2, AccountAnalytics accountAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.accountManager = accountManager2;
        this.crashReport = crashReport2;
        this.sharedPreferences = sharedPreferences2;
        this.scheduler = scheduler2;
        this.myAccountNavigator = myAccountNavigator2;
        this.accountAnalytics = accountAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        populateAccountViews();
        $jacocoInit[1] = true;
        checkIfStoreIsInvalidAndRefresh();
        $jacocoInit[2] = true;
        handleLoginClick();
        $jacocoInit[3] = true;
        handleLogOutClick();
        $jacocoInit[4] = true;
        handleCreateStoreClick();
        $jacocoInit[5] = true;
        handleStoreEditClick();
        $jacocoInit[6] = true;
        handleStoreEditResult();
        $jacocoInit[7] = true;
        handleStoreDisplayableClick();
        $jacocoInit[8] = true;
        handleProfileEditClick();
        $jacocoInit[9] = true;
        handleProfileDisplayableClick();
        $jacocoInit[10] = true;
        handleSettingsClicked();
        $jacocoInit[11] = true;
        handleNotificationHistoryClicked();
        $jacocoInit[12] = true;
        handleAptoideTvCardViewClick();
        $jacocoInit[13] = true;
        handleAptoideUploaderCardViewClick();
        $jacocoInit[14] = true;
        handleAptoideBackupCardViewClick();
        $jacocoInit[15] = true;
    }

    public void handleLoginClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5501oa oaVar = C5501oa.f9312a;
        $jacocoInit[16] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) oaVar);
        C5459aa aaVar = new C5459aa(this);
        $jacocoInit[17] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aaVar);
        C5497n nVar = new C5497n(this);
        $jacocoInit[18] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) nVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[19] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5403Ca ca = C5403Ca.f9216a;
        C5432O o = new C5432O(this);
        $jacocoInit[20] = true;
        a.mo3626a((C0129b<? super T>) ca, (C0129b<Throwable>) o);
        $jacocoInit[21] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m9673m(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[240] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo17472n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loginClick = this.view.loginClick();
        $jacocoInit[239] = true;
        return loginClick;
    }

    /* renamed from: j */
    public /* synthetic */ void mo17465j(Void loginClicked) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToLoginView(AccountOrigins.MY_ACCOUNT);
        $jacocoInit[238] = true;
    }

    /* renamed from: k */
    static /* synthetic */ void m9671k(Void __) {
        $jacocoInit()[237] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo17446g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[236] = true;
    }

    public void populateAccountViews() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5489ka kaVar = C5489ka.f9300a;
        $jacocoInit[22] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kaVar);
        C5409Ea ea = new C5409Ea(this);
        $jacocoInit[23] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ea);
        C0126V v = this.scheduler;
        $jacocoInit[24] = true;
        C0120S a = f.mo3616a(v);
        C5467d dVar = new C5467d(this);
        $jacocoInit[25] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) dVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[26] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5530y yVar = C5530y.f9341a;
        C5427La la = new C5427La(this);
        $jacocoInit[27] = true;
        a2.mo3626a((C0129b<? super T>) yVar, (C0129b<Throwable>) la);
        $jacocoInit[28] = true;
    }

    /* renamed from: C */
    static /* synthetic */ Boolean m9651C(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[235] = true;
        return valueOf;
    }

    /* renamed from: D */
    public /* synthetic */ C0120S mo17424D(LifecycleEvent resumed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[233] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[234] = true;
        return d;
    }

    /* renamed from: k */
    public /* synthetic */ void mo17466k(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAccount(account);
        $jacocoInit[232] = true;
    }

    /* renamed from: l */
    static /* synthetic */ void m9672l(Account __) {
        $jacocoInit()[231] = true;
    }

    /* renamed from: p */
    public /* synthetic */ void mo17478p(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[230] = true;
    }

    public void handleProfileDisplayableClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5445U u = C5445U.f9256a;
        $jacocoInit[29] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) u);
        C5423Ja ja = new C5423Ja(this);
        $jacocoInit[30] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ja);
        C5483ia iaVar = new C5483ia(this);
        $jacocoInit[31] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iaVar);
        C5494m mVar = new C5494m(this);
        $jacocoInit[32] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) mVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[33] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5411F f3 = C5411F.f9224a;
        C5534za zaVar = new C5534za(this);
        $jacocoInit[34] = true;
        a.mo3626a((C0129b<? super T>) f3, (C0129b<Throwable>) zaVar);
        $jacocoInit[35] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m9677q(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[229] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo17481r(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S userClick = this.view.userClick();
        $jacocoInit[228] = true;
        return userClick;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo17473n(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[226] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[227] = true;
        return d;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17434c(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountNavigator myAccountNavigator2 = this.myAccountNavigator;
        String id = account.getId();
        $jacocoInit[222] = true;
        Store store = account.getStore();
        $jacocoInit[223] = true;
        String theme = store.getTheme();
        $jacocoInit[224] = true;
        myAccountNavigator2.navigateToUserView(id, theme);
        $jacocoInit[225] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m9659d(Account account) {
        $jacocoInit()[221] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo17461i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[220] = true;
    }

    public void handleProfileEditClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5430N n = C5430N.f9243a;
        $jacocoInit[36] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) n);
        C5482i iVar = new C5482i(this);
        $jacocoInit[37] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[38] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5533z zVar = C5533z.f9344a;
        C5518u uVar = new C5518u(this);
        $jacocoInit[39] = true;
        a.mo3626a((C0129b<? super T>) zVar, (C0129b<Throwable>) uVar);
        $jacocoInit[40] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m9678s(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[219] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo17484t(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S editUserProfileClick = this.view.editUserProfileClick();
        C5451X x = new C5451X(this);
        $jacocoInit[213] = true;
        C0120S f = editUserProfileClick.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) x);
        C5507qa qaVar = new C5507qa(this);
        $jacocoInit[214] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) qaVar);
        $jacocoInit[215] = true;
        return b;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo17482r(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[217] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[218] = true;
        return d;
    }

    /* renamed from: j */
    public /* synthetic */ void mo17463j(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToEditProfileView();
        $jacocoInit[216] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m9662e(Account account) {
        $jacocoInit()[212] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo17464j(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[211] = true;
    }

    public void handleStoreDisplayableClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5516ta taVar = C5516ta.f9327a;
        $jacocoInit[41] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) taVar);
        C5509r rVar = new C5509r(this);
        $jacocoInit[42] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        C5473f fVar = new C5473f(this);
        $jacocoInit[43] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
        C5527x xVar = new C5527x(this);
        $jacocoInit[44] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) xVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[45] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5485j jVar = C5485j.f9296a;
        C5397Aa aa = new C5397Aa(this);
        $jacocoInit[46] = true;
        a.mo3626a((C0129b<? super T>) jVar, (C0129b<Throwable>) aa);
        $jacocoInit[47] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m9680w(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[210] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo17487x(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S storeClick = this.view.storeClick();
        $jacocoInit[209] = true;
        return storeClick;
    }

    /* renamed from: q */
    public /* synthetic */ C0120S mo17480q(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[207] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[208] = true;
        return d;
    }

    /* renamed from: f */
    public /* synthetic */ void mo17444f(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountNavigator myAccountNavigator2 = this.myAccountNavigator;
        Store store = account.getStore();
        $jacocoInit[203] = true;
        String name = store.getName();
        Store store2 = account.getStore();
        $jacocoInit[204] = true;
        String theme = store2.getTheme();
        $jacocoInit[205] = true;
        myAccountNavigator2.navigateToStoreView(name, theme);
        $jacocoInit[206] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m9665g(Account account) {
        $jacocoInit()[202] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo17469l(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[201] = true;
    }

    public void handleStoreEditClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5515t tVar = C5515t.f9326a;
        $jacocoInit[48] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) tVar);
        C5519ua uaVar = new C5519ua(this);
        $jacocoInit[49] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) uaVar);
        C0126V v = this.scheduler;
        $jacocoInit[50] = true;
        C0120S a = f.mo3616a(v);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[51] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5531ya yaVar = new C5531ya(this);
        C5465ca caVar = new C5465ca(this);
        $jacocoInit[52] = true;
        a2.mo3626a((C0129b<? super T>) yaVar, (C0129b<Throwable>) caVar);
        $jacocoInit[53] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m9681y(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[200] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ C0120S mo17488z(LifecycleEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S editStoreClick = this.view.editStoreClick();
        C5420I i = new C5420I(this);
        $jacocoInit[192] = true;
        C0120S f = editStoreClick.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) i);
        C5470e eVar = C5470e.f9281a;
        $jacocoInit[193] = true;
        C0120S j = f.mo3669j(eVar);
        $jacocoInit[194] = true;
        return j;
    }

    /* renamed from: s */
    public /* synthetic */ C0120S mo17483s(Void response) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S store = this.view.getStore();
        $jacocoInit[199] = true;
        return store;
    }

    /* renamed from: a */
    static /* synthetic */ p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store m9652a(GetStore getStore) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[195] = true;
        Nodes nodes = getStore.getNodes();
        $jacocoInit[196] = true;
        GetStoreMeta getStoreMeta = (GetStoreMeta) nodes.getMeta();
        $jacocoInit[197] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store data = getStoreMeta.getData();
        $jacocoInit[198] = true;
        return data;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17432b(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToEditStoreView(store, EDIT_STORE_REQUEST_CODE);
        $jacocoInit[191] = true;
    }

    /* renamed from: m */
    public /* synthetic */ void mo17471m(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[190] = true;
    }

    public void handleStoreEditResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5402C c = C5402C.f9215a;
        $jacocoInit[54] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) c);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[55] = true;
        C0120S a = d.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5396A a2 = new C5396A(this);
        $jacocoInit[56] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) a2);
        C5426L l = new C5426L(this);
        $jacocoInit[57] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) l);
        C0126V v = this.scheduler;
        $jacocoInit[58] = true;
        C0120S a3 = f2.mo3616a(v);
        C5447V v2 = new C5447V(this);
        $jacocoInit[59] = true;
        C0120S b = a3.mo3636b((C0129b<? super T>) v2);
        MyAccountView myAccountView2 = this.view;
        LifecycleEvent lifecycleEvent3 = LifecycleEvent.DESTROY;
        $jacocoInit[60] = true;
        C0120S a4 = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView2.bindUntilEvent(lifecycleEvent3));
        C5422J j = C5422J.f9235a;
        C5504pa paVar = new C5504pa(this);
        $jacocoInit[61] = true;
        a4.mo3626a((C0129b<? super T>) j, (C0129b<Throwable>) paVar);
        $jacocoInit[62] = true;
    }

    /* renamed from: A */
    static /* synthetic */ Boolean m9650A(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[189] = true;
        return valueOf;
    }

    /* renamed from: B */
    public /* synthetic */ C0120S mo17423B(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S editStoreResult = this.myAccountNavigator.editStoreResult(EDIT_STORE_REQUEST_CODE);
        $jacocoInit[188] = true;
        return editStoreResult;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo17427a(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[186] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[187] = true;
        return d;
    }

    /* renamed from: h */
    public /* synthetic */ void mo17449h(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showAccount(account);
        $jacocoInit[185] = true;
    }

    /* renamed from: i */
    static /* synthetic */ void m9668i(Account notification) {
        $jacocoInit()[184] = true;
    }

    /* renamed from: n */
    public /* synthetic */ void mo17474n(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[183] = true;
    }

    public void handleCreateStoreClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5513sa saVar = C5513sa.f9324a;
        $jacocoInit[63] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) saVar);
        C5476g gVar = new C5476g(this);
        $jacocoInit[64] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gVar);
        C5471ea eaVar = new C5471ea(this);
        $jacocoInit[65] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) eaVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[66] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5428M m = C5428M.f9241a;
        C5453Y y = new C5453Y(this);
        $jacocoInit[67] = true;
        a.mo3626a((C0129b<? super T>) m, (C0129b<Throwable>) y);
        $jacocoInit[68] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m9667i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[182] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo17462j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S createStoreClick = this.view.createStoreClick();
        $jacocoInit[181] = true;
        return createStoreClick;
    }

    /* renamed from: g */
    public /* synthetic */ void mo17447g(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToCreateStore();
        $jacocoInit[180] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m9666h(Void notification) {
        $jacocoInit()[179] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo17441e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[178] = true;
    }

    public void checkIfStoreIsInvalidAndRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5436Q q = C5436Q.f9249a;
        $jacocoInit[69] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) q);
        C5443T t = new C5443T(this);
        $jacocoInit[70] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) t);
        C5500o oVar = new C5500o(this);
        $jacocoInit[71] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) oVar);
        C5510ra raVar = new C5510ra(this);
        $jacocoInit[72] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) raVar);
        C5434P p = new C5434P(this);
        $jacocoInit[73] = true;
        C0120S f3 = f2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) p);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[74] = true;
        C0120S a = f3.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5468da daVar = C5468da.f9279a;
        C5406Da da = C5406Da.f9219a;
        $jacocoInit[75] = true;
        a.mo3626a((C0129b<? super T>) daVar, (C0129b<Throwable>) da);
        $jacocoInit[76] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9653a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[177] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo17431b(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[176] = true;
        return accountStatus;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo17425a(Account account) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (storeExistsInAccount(account)) {
            $jacocoInit[171] = true;
        } else if (!account.hasStore()) {
            $jacocoInit[172] = true;
        } else {
            $jacocoInit[173] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[175] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[174] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[175] = true;
        return valueOf2;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo17430b(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S store = this.view.getStore();
        C5408E e = C5408E.f9221a;
        $jacocoInit[162] = true;
        C0120S j = store.mo3669j(e);
        C0126V v = this.scheduler;
        $jacocoInit[163] = true;
        C0120S a = j.mo3616a(v);
        C5521v vVar = new C5521v(this);
        $jacocoInit[164] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) vVar);
        $jacocoInit[165] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store m9656b(GetStore store) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[167] = true;
        Nodes nodes = store.getNodes();
        $jacocoInit[168] = true;
        GetStoreMeta getStoreMeta = (GetStoreMeta) nodes.getMeta();
        $jacocoInit[169] = true;
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store data = getStoreMeta.getData();
        $jacocoInit[170] = true;
        return data;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17435c(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.refreshUI(store);
        $jacocoInit[166] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo17426a(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M updateAccount = this.accountManager.updateAccount();
        $jacocoInit[160] = true;
        C0120S f = updateAccount.mo3604f();
        $jacocoInit[161] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ void m9654a(Object account) {
        $jacocoInit()[159] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9655a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[157] = true;
        instance.log(throwable);
        $jacocoInit[158] = true;
    }

    public void handleLogOutClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5528xa xaVar = C5528xa.f9339a;
        $jacocoInit[77] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) xaVar);
        C5418Ha ha = new C5418Ha(this);
        $jacocoInit[78] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ha);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[79] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5506q qVar = C5506q.f9317a;
        C5405D d2 = new C5405D(this);
        $jacocoInit[80] = true;
        a.mo3626a((C0129b<? super T>) qVar, (C0129b<Throwable>) d2);
        $jacocoInit[81] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m9670k(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[156] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo17468l(LifecycleEvent resumed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S signOutClick = signOutClick();
        $jacocoInit[155] = true;
        return signOutClick;
    }

    /* renamed from: i */
    static /* synthetic */ void m9669i(Void signOutClick) {
        $jacocoInit()[154] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo17445f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[153] = true;
    }

    public void handleSettingsClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5449W w = C5449W.f9260a;
        $jacocoInit[82] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) w);
        C5462ba baVar = new C5462ba(this);
        $jacocoInit[83] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) baVar);
        C5415Ga ga = new C5415Ga(this);
        $jacocoInit[84] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) ga);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[85] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5480ha haVar = C5480ha.f9291a;
        C5492la laVar = new C5492la(this);
        $jacocoInit[86] = true;
        a.mo3626a((C0129b<? super T>) haVar, (C0129b<Throwable>) laVar);
        $jacocoInit[87] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m9679u(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[152] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo17486v(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.view.settingsClicked();
        $jacocoInit[151] = true;
        return s;
    }

    /* renamed from: o */
    public /* synthetic */ void mo17476o(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToSettings();
        $jacocoInit[150] = true;
    }

    /* renamed from: p */
    static /* synthetic */ void m9676p(Void __) {
        $jacocoInit()[149] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo17467k(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[148] = true;
    }

    public void handleNotificationHistoryClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5498na naVar = C5498na.f9309a;
        $jacocoInit[88] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) naVar);
        C5491l lVar = new C5491l(this);
        $jacocoInit[89] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) lVar);
        C5524w wVar = new C5524w(this);
        $jacocoInit[90] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) wVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[91] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5414G g = C5414G.f9227a;
        C5425Ka ka = new C5425Ka(this);
        $jacocoInit[92] = true;
        a.mo3626a((C0129b<? super T>) g, (C0129b<Throwable>) ka);
        $jacocoInit[93] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m9675o(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[147] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo17477p(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S notificationsClicked = this.view.notificationsClicked();
        $jacocoInit[146] = true;
        return notificationsClicked;
    }

    /* renamed from: l */
    public /* synthetic */ void mo17470l(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToNotificationHistory();
        $jacocoInit[145] = true;
    }

    /* renamed from: m */
    static /* synthetic */ void m9674m(Void __) {
        $jacocoInit()[144] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo17450h(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[143] = true;
    }

    private C0120S<Void> signOutClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S signOutClick = this.view.signOutClick();
        C5421Ia ia = new C5421Ia(this);
        $jacocoInit[94] = true;
        C0120S f = signOutClick.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ia);
        $jacocoInit[95] = true;
        C0120S<Void> g = f.mo3662g();
        $jacocoInit[96] = true;
        return g;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo17485t(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M logout = this.accountManager.logout();
        C0126V v = this.scheduler;
        $jacocoInit[137] = true;
        C0117M a = logout.mo3581a(v);
        C5486ja jaVar = new C5486ja(this);
        $jacocoInit[138] = true;
        C0117M a2 = a.mo3582a((C0128a) jaVar);
        C5477ga gaVar = new C5477ga(this);
        $jacocoInit[139] = true;
        C0120S f = a2.mo3583a((C0129b<? super Throwable>) gaVar).mo3604f();
        $jacocoInit[140] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17428a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoginAccountDisplayable();
        $jacocoInit[142] = true;
    }

    /* renamed from: o */
    public /* synthetic */ void mo17475o(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[141] = true;
    }

    private void handleAptoideTvCardViewClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5474fa faVar = C5474fa.f9285a;
        $jacocoInit[97] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) faVar);
        C5495ma maVar = new C5495ma(this);
        $jacocoInit[98] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) maVar);
        C5488k kVar = new C5488k(this);
        $jacocoInit[99] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) kVar);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[100] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5525wa waVar = C5525wa.f9336a;
        C5455Z z = new C5455Z(this);
        $jacocoInit[101] = true;
        a.mo3626a((C0129b<? super T>) waVar, (C0129b<Throwable>) z);
        $jacocoInit[102] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9661e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[136] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo17443f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideTvCardViewClick = this.view.aptoideTvCardViewClick();
        $jacocoInit[135] = true;
        return aptoideTvCardViewClick;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17437c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.startAptoideTvWebView();
        $jacocoInit[133] = true;
        this.accountAnalytics.sendPromoteAptoideTVEvent();
        $jacocoInit[134] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m9660d(Void __) {
        $jacocoInit()[132] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo17436c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[131] = true;
    }

    private void handleAptoideUploaderCardViewClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5479h hVar = C5479h.f9290a;
        $jacocoInit[103] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) hVar);
        C5522va vaVar = new C5522va(this);
        $jacocoInit[104] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vaVar);
        C5399B b = new C5399B(this);
        $jacocoInit[105] = true;
        C0120S b2 = f.mo3636b((C0129b<? super T>) b);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[106] = true;
        C0120S a = b2.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5503p pVar = C5503p.f9314a;
        C5412Fa fa = new C5412Fa(this);
        $jacocoInit[107] = true;
        a.mo3626a((C0129b<? super T>) pVar, (C0129b<Throwable>) fa);
        $jacocoInit[108] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m9664g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[130] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo17448h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideUploaderCardViewClick = this.view.aptoideUploaderCardViewClick();
        $jacocoInit[129] = true;
        return aptoideUploaderCardViewClick;
    }

    /* renamed from: e */
    public /* synthetic */ void mo17442e(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToUploader();
        $jacocoInit[127] = true;
        this.accountAnalytics.sendPromoteAptoideUploaderEvent();
        $jacocoInit[128] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m9663f(Void __) {
        $jacocoInit()[126] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo17440d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[125] = true;
    }

    private void handleAptoideBackupCardViewClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5400Ba ba = C5400Ba.f9213a;
        $jacocoInit[109] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ba);
        C5512s sVar = new C5512s(this);
        $jacocoInit[110] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sVar);
        C5439S s = new C5439S(this);
        $jacocoInit[111] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) s);
        MyAccountView myAccountView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[112] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) myAccountView.bindUntilEvent(lifecycleEvent2));
        C5424K k = C5424K.f9237a;
        C5417H h = new C5417H(this);
        $jacocoInit[113] = true;
        a.mo3626a((C0129b<? super T>) k, (C0129b<Throwable>) h);
        $jacocoInit[114] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9658c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[124] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo17439d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S aptoideBackupCardViewClick = this.view.aptoideBackupCardViewClick();
        $jacocoInit[123] = true;
        return aptoideBackupCardViewClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17429a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myAccountNavigator.navigateToBackupApps();
        $jacocoInit[121] = true;
        this.accountAnalytics.sendPromoteAptoideBackupAppsEvent();
        $jacocoInit[122] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9657b(Void __) {
        $jacocoInit()[120] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17433b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[119] = true;
    }

    private boolean storeExistsInAccount(Account account) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Store store = account.getStore();
        $jacocoInit[115] = true;
        if (store.getId() != 0) {
            $jacocoInit[116] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[117] = true;
        }
        $jacocoInit[118] = true;
        return z;
    }
}
