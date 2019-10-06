package p005cm.aptoide.p006pt.editorialList;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.editorialList.EditorialListViewModel.Error;
import p005cm.aptoide.p006pt.home.EditorialHomeEvent;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListPresenter */
public class EditorialListPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReporter;
    private final EditorialListAnalytics editorialListAnalytics;
    private final EditorialListManager editorialListManager;
    private final EditorialListNavigator editorialListNavigator;
    private final EditorialListView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8849862119358038170L, "cm/aptoide/pt/editorialList/EditorialListPresenter", 249);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListPresenter(EditorialListView editorialListView, EditorialListManager editorialListManager2, AptoideAccountManager accountManager2, EditorialListNavigator editorialListNavigator2, EditorialListAnalytics editorialListAnalytics2, CrashReport crashReporter2, C0126V viewScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = editorialListView;
        this.editorialListManager = editorialListManager2;
        this.accountManager = accountManager2;
        this.editorialListNavigator = editorialListNavigator2;
        this.editorialListAnalytics = editorialListAnalytics2;
        this.crashReporter = crashReporter2;
        this.viewScheduler = viewScheduler2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onCreateLoadViewModel();
        $jacocoInit[1] = true;
        handleImpressions();
        $jacocoInit[2] = true;
        handleEditorialCardClick();
        $jacocoInit[3] = true;
        handlePullToRefresh();
        $jacocoInit[4] = true;
        handleRetryClick();
        $jacocoInit[5] = true;
        handleBottomReached();
        $jacocoInit[6] = true;
        handleUserImageClick();
        $jacocoInit[7] = true;
        loadUserImage();
        $jacocoInit[8] = true;
        handleReactionButtonClick();
        $jacocoInit[9] = true;
        handleLongPressReactionButton();
        $jacocoInit[10] = true;
        handleUserReaction();
        $jacocoInit[11] = true;
        handleSnackLogInClick();
        $jacocoInit[12] = true;
        handleOnDismissPopup();
        $jacocoInit[13] = true;
    }

    private Single<CurationCard> loadReactionModel(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = this.editorialListManager.loadReactionModel(cardId, groupId);
        C0126V v = this.viewScheduler;
        $jacocoInit[14] = true;
        Single a = loadReactionModel.mo3686a(v);
        EditorialListView editorialListView = this.view;
        editorialListView.getClass();
        C3262Na na = new C3262Na(editorialListView);
        $jacocoInit[15] = true;
        Single<CurationCard> b = a.mo3695b((C0129b<? super T>) na);
        $jacocoInit[16] = true;
        return b;
    }

    public void onCreateLoadViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3311ra raVar = C3311ra.f6693a;
        $jacocoInit[17] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) raVar);
        C3310r rVar = new C3310r(this);
        $jacocoInit[18] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) rVar);
        C3318v vVar = new C3318v(this);
        $jacocoInit[19] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vVar);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[20] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3249H h = C3249H.f6625a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[21] = true;
        a.mo3626a((C0129b<? super T>) h, (C0129b<Throwable>) bVar);
        $jacocoInit[22] = true;
    }

    /* renamed from: y */
    static /* synthetic */ Boolean m7879y(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[248] = true;
        return valueOf;
    }

    /* renamed from: z */
    public /* synthetic */ void mo14152z(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[247] = true;
    }

    /* renamed from: A */
    public /* synthetic */ C0120S mo14100A(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadEditorialAndReactions = loadEditorialAndReactions(false, false);
        $jacocoInit[246] = true;
        return loadEditorialAndReactions;
    }

    /* renamed from: g */
    static /* synthetic */ void m7870g(CurationCard __) {
        $jacocoInit()[245] = true;
    }

    private C0120S<CurationCard> loadEditorialAndReactions(boolean loadMore, boolean refresh) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = loadEditorialListViewModel(loadMore, refresh).mo3696c();
        C3266Pa pa = C3266Pa.f6643a;
        $jacocoInit[23] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) pa);
        C3261N n = new C3261N(this);
        $jacocoInit[24] = true;
        C0120S<CurationCard> i = h.mo3668i(n);
        $jacocoInit[25] = true;
        return i;
    }

    /* renamed from: f */
    public /* synthetic */ Single mo14127f(CurationCard curationCard) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = loadReactionModel(curationCard.getId(), curationCard.getType());
        $jacocoInit[244] = true;
        return loadReactionModel;
    }

    public void loadUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3321wa waVar = C3321wa.f6704a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) waVar);
        C3326z zVar = new C3326z(this);
        $jacocoInit[27] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zVar);
        C3239C c = new C3239C(this);
        $jacocoInit[28] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) c);
        C0126V v = this.viewScheduler;
        $jacocoInit[29] = true;
        C0120S a = f2.mo3616a(v);
        C3315ta taVar = new C3315ta(this);
        $jacocoInit[30] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) taVar);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[31] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3265P p = C3265P.f6642a;
        C3271V v2 = new C3271V(this);
        $jacocoInit[32] = true;
        a2.mo3626a((C0129b<? super T>) p, (C0129b<Throwable>) v2);
        $jacocoInit[33] = true;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m7878w(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[243] = true;
        return valueOf;
    }

    /* renamed from: x */
    public /* synthetic */ C0120S mo14151x(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[242] = true;
        return accountStatus;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14102a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S userAvatar = getUserAvatar(account);
        $jacocoInit[241] = true;
        return userAvatar;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14108a(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (userAvatarUrl != null) {
            $jacocoInit[237] = true;
            this.view.setUserImage(userAvatarUrl);
            $jacocoInit[238] = true;
        } else {
            this.view.setDefaultUserImage();
            $jacocoInit[239] = true;
        }
        this.view.showAvatar();
        $jacocoInit[240] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7859b(String __) {
        $jacocoInit()[236] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14123d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[235] = true;
    }

    public void handleEditorialCardClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3314t tVar = C3314t.f6697a;
        $jacocoInit[34] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) tVar);
        C3274Y y = new C3274Y(this);
        $jacocoInit[35] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) y);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[36] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3268S s = C3268S.f6645a;
        C3247G g = new C3247G(this);
        $jacocoInit[37] = true;
        a.mo3626a((C0129b<? super T>) s, (C0129b<Throwable>) g);
        $jacocoInit[38] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7861c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[234] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14120d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S editorialCardClicked = this.view.editorialCardClicked();
        C0126V v = this.viewScheduler;
        $jacocoInit[226] = true;
        C0120S a = editorialCardClicked.mo3616a(v);
        C3322x xVar = new C3322x(this);
        $jacocoInit[227] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) xVar);
        $jacocoInit[228] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[229] = true;
        return g;
    }

    /* renamed from: f */
    public /* synthetic */ void mo14128f(EditorialHomeEvent click) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListAnalytics editorialListAnalytics2 = this.editorialListAnalytics;
        String cardId = click.getCardId();
        $jacocoInit[230] = true;
        int bundlePosition = click.getBundlePosition();
        $jacocoInit[231] = true;
        editorialListAnalytics2.sendEditorialInteractEvent(cardId, bundlePosition);
        $jacocoInit[232] = true;
        this.editorialListNavigator.navigateToEditorial(click.getCardId());
        $jacocoInit[233] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7857a(EditorialHomeEvent homeClick) {
        $jacocoInit()[225] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14117b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[224] = true;
    }

    public void handlePullToRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3255K k = C3255K.f6632a;
        $jacocoInit[39] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) k);
        C3263O o = new C3263O(this);
        $jacocoInit[40] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) o);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[41] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3270U u = C3270U.f6647a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[42] = true;
        a.mo3626a((C0129b<? super T>) u, (C0129b<Throwable>) bVar);
        $jacocoInit[43] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7872k(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[223] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo14143l(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S refreshes = this.view.refreshes();
        C3317ua uaVar = new C3317ua(this);
        $jacocoInit[219] = true;
        C0120S f = refreshes.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) uaVar);
        $jacocoInit[220] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[221] = true;
        return g;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14121d(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadEditorialAndReactions = loadEditorialAndReactions(false, true);
        $jacocoInit[222] = true;
        return loadEditorialAndReactions;
    }

    /* renamed from: b */
    static /* synthetic */ void m7858b(CurationCard bundles) {
        $jacocoInit()[218] = true;
    }

    public void handleRetryClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3259M m = C3259M.f6636a;
        $jacocoInit[44] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) m);
        C3279ba baVar = new C3279ba(this);
        $jacocoInit[45] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) baVar);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[46] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3238Ba ba = C3238Ba.f6612a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[47] = true;
        a.mo3626a((C0129b<? super T>) ba, (C0129b<Throwable>) bVar);
        $jacocoInit[48] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m7874o(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[217] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo14147p(LifecycleEvent viewCreated) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S retryClicked = this.view.retryClicked();
        C0126V v = this.viewScheduler;
        $jacocoInit[211] = true;
        C0120S a = retryClicked.mo3616a(v);
        C3251I i = new C3251I(this);
        $jacocoInit[212] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) i);
        C3269T t = new C3269T(this);
        $jacocoInit[213] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) t);
        $jacocoInit[214] = true;
        return f;
    }

    /* renamed from: e */
    public /* synthetic */ void mo14124e(Void bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[216] = true;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo14126f(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadEditorialAndReactions = loadEditorialAndReactions(false, true);
        $jacocoInit[215] = true;
        return loadEditorialAndReactions;
    }

    /* renamed from: d */
    static /* synthetic */ void m7865d(CurationCard notificationUrl) {
        $jacocoInit()[210] = true;
    }

    public void handleImpressions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3241D d = C3241D.f6616a;
        $jacocoInit[49] = true;
        C0120S d2 = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) d);
        C3257L l = new C3257L(this);
        $jacocoInit[50] = true;
        C0120S f = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) l);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[51] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3237B b = C3237B.f6611a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[52] = true;
        a.mo3626a((C0129b<? super T>) b, (C0129b<Throwable>) bVar);
        $jacocoInit[53] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7866e(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[209] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo14125f(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S visibleCards = this.view.visibleCards();
        C0126V v = this.viewScheduler;
        $jacocoInit[203] = true;
        C0120S a = visibleCards.mo3616a(v);
        C3297ka kaVar = new C3297ka(this);
        $jacocoInit[204] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) kaVar);
        $jacocoInit[205] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14113b(EditorialListEvent editorialListEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListAnalytics editorialListAnalytics2 = this.editorialListAnalytics;
        $jacocoInit[206] = true;
        String cardId = editorialListEvent.getCardId();
        int position = editorialListEvent.getPosition();
        $jacocoInit[207] = true;
        editorialListAnalytics2.sendEditorialImpressionEvent(cardId, position);
        $jacocoInit[208] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7856a(EditorialListEvent __) {
        $jacocoInit()[202] = true;
    }

    public void handleBottomReached() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3308q qVar = C3308q.f6690a;
        $jacocoInit[54] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) qVar);
        C3305oa oaVar = new C3305oa(this);
        $jacocoInit[55] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oaVar);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[56] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3327za zaVar = C3327za.f6710a;
        C3313sa saVar = new C3313sa(this);
        $jacocoInit[57] = true;
        a.mo3626a((C0129b<? super T>) zaVar, (C0129b<Throwable>) saVar);
        $jacocoInit[58] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7853a(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[201] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14112b(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reachesBottom = this.view.reachesBottom();
        C3320w wVar = new C3320w(this);
        $jacocoInit[192] = true;
        C0120S d = reachesBottom.mo3653d((C0132p<? super T, Boolean>) wVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[193] = true;
        C0120S a = d.mo3616a(v);
        C3309qa qaVar = new C3309qa(this);
        $jacocoInit[194] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) qaVar);
        C3236Aa aa = new C3236Aa(this);
        $jacocoInit[195] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aa);
        $jacocoInit[196] = true;
        C0120S g = f.mo3662g();
        $jacocoInit[197] = true;
        return g;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14101a(Object __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.editorialListManager.hasMore());
        $jacocoInit[200] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14116b(Object bottomReached) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoadMore();
        $jacocoInit[199] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo14118c(Object bottomReach) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadEditorialAndReactions = loadEditorialAndReactions(true, false);
        $jacocoInit[198] = true;
        return loadEditorialAndReactions;
    }

    /* renamed from: a */
    static /* synthetic */ void m7855a(CurationCard bundles) {
        $jacocoInit()[191] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14109a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[190] = true;
    }

    private Single<EditorialListViewModel> loadEditorialListViewModel(boolean loadMore, boolean refresh) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialListViewModel = this.editorialListManager.loadEditorialListViewModel(loadMore, refresh);
        C0126V v = this.viewScheduler;
        $jacocoInit[59] = true;
        Single a = loadEditorialListViewModel.mo3686a(v);
        C3312s sVar = new C3312s(this, refresh);
        $jacocoInit[60] = true;
        Single b = a.mo3695b((C0129b<? super T>) sVar);
        C3253J j = C3253J.f6630a;
        $jacocoInit[61] = true;
        Single<EditorialListViewModel> d = b.mo3698d(j);
        $jacocoInit[62] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14111a(boolean refresh, EditorialListViewModel editorialListViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialListViewModel.isLoading()) {
            $jacocoInit[178] = true;
        } else {
            $jacocoInit[179] = true;
            this.view.hideLoading();
            $jacocoInit[180] = true;
        }
        if (editorialListViewModel.hasError()) {
            $jacocoInit[181] = true;
            if (editorialListViewModel.getError() == Error.NETWORK) {
                $jacocoInit[182] = true;
                this.view.showNetworkError();
                $jacocoInit[183] = true;
            } else {
                this.view.showGenericError();
                $jacocoInit[184] = true;
            }
        } else if (refresh) {
            $jacocoInit[185] = true;
            this.view.hideRefresh();
            $jacocoInit[186] = true;
            this.view.update(editorialListViewModel.getCurationCards());
            $jacocoInit[187] = true;
        } else {
            this.view.populateView(editorialListViewModel.getCurationCards());
            $jacocoInit[188] = true;
        }
        this.view.hideLoadMore();
        $jacocoInit[189] = true;
    }

    /* renamed from: a */
    static /* synthetic */ EditorialListViewModel m7852a(EditorialListViewModel editorialViewModel) {
        $jacocoInit()[177] = true;
        return editorialViewModel;
    }

    public void handleUserImageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3316u uVar = C3316u.f6699a;
        $jacocoInit[63] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) uVar);
        C3267Q q = new C3267Q(this);
        $jacocoInit[64] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) q);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[65] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3272W w = C3272W.f6649a;
        C3323xa xaVar = new C3323xa(this);
        $jacocoInit[66] = true;
        a.mo3626a((C0129b<? super T>) w, (C0129b<Throwable>) xaVar);
        $jacocoInit[67] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m7876s(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[176] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo14149t(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S imageClick = this.view.imageClick();
        C0126V v = this.viewScheduler;
        $jacocoInit[171] = true;
        C0120S a = imageClick.mo3616a(v);
        C3301ma maVar = new C3301ma(this);
        $jacocoInit[172] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) maVar);
        $jacocoInit[173] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[174] = true;
        return g;
    }

    /* renamed from: g */
    public /* synthetic */ void mo14129g(Void account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListNavigator.navigateToMyAccount();
        $jacocoInit[175] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7864c(Void __) {
        $jacocoInit()[170] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14119c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReporter.log(throwable);
        $jacocoInit[169] = true;
    }

    private C0120S<String> getUserAvatar(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        String userAvatarUrl = null;
        $jacocoInit[68] = true;
        if (account == null) {
            $jacocoInit[69] = true;
        } else if (!account.isLoggedIn()) {
            $jacocoInit[70] = true;
        } else {
            $jacocoInit[71] = true;
            userAvatarUrl = account.getAvatar();
            $jacocoInit[72] = true;
        }
        C0120S<String> c = C0120S.m652c(userAvatarUrl);
        $jacocoInit[73] = true;
        return c;
    }

    public void handleReactionButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3287fa faVar = C3287fa.f6665a;
        $jacocoInit[74] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) faVar);
        C3243E e = new C3243E(this);
        $jacocoInit[75] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) e);
        C0126V v = this.viewScheduler;
        $jacocoInit[76] = true;
        C0120S a = f.mo3616a(v);
        C3324y yVar = new C3324y(this);
        $jacocoInit[77] = true;
        C0120S f2 = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) yVar);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[78] = true;
        C0120S a2 = f2.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3293ia iaVar = C3293ia.f6671a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[79] = true;
        a2.mo3626a((C0129b<? super T>) iaVar, (C0129b<Throwable>) bVar);
        $jacocoInit[80] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m7873m(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[168] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo14145n(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionsButtonClicked = this.view.reactionsButtonClicked();
        $jacocoInit[167] = true;
        return reactionsButtonClicked;
    }

    /* renamed from: c */
    static /* synthetic */ void m7862c(CurationCard lifecycleEvent) {
        $jacocoInit()[166] = true;
    }

    /* access modifiers changed from: 0000 */
    public void handleLongPressReactionButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3245F f = C3245F.f6620a;
        $jacocoInit[81] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) f);
        C3295ja jaVar = new C3295ja(this);
        $jacocoInit[82] = true;
        C0120S f2 = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jaVar);
        C3248Ga ga = new C3248Ga(this);
        $jacocoInit[83] = true;
        C0120S b = f2.mo3636b((C0129b<? super T>) ga);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[84] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3291ha haVar = C3291ha.f6669a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[85] = true;
        a.mo3626a((C0129b<? super T>) haVar, (C0129b<Throwable>) bVar);
        $jacocoInit[86] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7869g(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[165] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo14130h(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionButtonLongPress = this.view.reactionButtonLongPress();
        $jacocoInit[164] = true;
        return reactionButtonLongPress;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14114b(EditorialHomeEvent editorialHomeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        showReactions(editorialHomeEvent);
        $jacocoInit[163] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7863c(EditorialHomeEvent lifecycleEvent) {
        $jacocoInit()[162] = true;
    }

    /* access modifiers changed from: 0000 */
    public void handleOnDismissPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3277aa aaVar = C3277aa.f6654a;
        $jacocoInit[87] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) aaVar);
        C3275Z z = new C3275Z(this);
        $jacocoInit[88] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) z);
        C3303na naVar = new C3303na(this);
        $jacocoInit[89] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) naVar);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[90] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3273X x = C3273X.f6650a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[91] = true;
        a.mo3626a((C0129b<? super T>) x, (C0129b<Throwable>) bVar);
        $jacocoInit[92] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m7871i(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[161] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo14142j(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S onPopupDismiss = this.view.onPopupDismiss();
        $jacocoInit[160] = true;
        return onPopupDismiss;
    }

    /* renamed from: d */
    public /* synthetic */ void mo14122d(EditorialHomeEvent item) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.setScrollEnabled(Boolean.valueOf(true));
        $jacocoInit[159] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m7868e(EditorialHomeEvent lifecycleEvent) {
        $jacocoInit()[158] = true;
    }

    public void handleUserReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3281ca caVar = C3281ca.f6658a;
        $jacocoInit[93] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) caVar);
        C3242Da da = new C3242Da(this);
        $jacocoInit[94] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) da);
        C3244Ea ea = new C3244Ea(this);
        $jacocoInit[95] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ea);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[96] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3325ya yaVar = C3325ya.f6708a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[97] = true;
        a.mo3626a((C0129b<? super T>) yaVar, (C0129b<Throwable>) bVar);
        $jacocoInit[98] = true;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m7877u(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[157] = true;
        return valueOf;
    }

    /* renamed from: v */
    public /* synthetic */ C0120S mo14150v(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S reactionClicked = this.view.reactionClicked();
        $jacocoInit[156] = true;
        return reactionClicked;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14104a(ReactionsHomeEvent reactionsHomeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListManager editorialListManager2 = this.editorialListManager;
        String cardId = reactionsHomeEvent.getCardId();
        $jacocoInit[143] = true;
        String groupId = reactionsHomeEvent.getGroupId();
        String reaction = reactionsHomeEvent.getReaction();
        $jacocoInit[144] = true;
        Single reaction2 = editorialListManager2.setReaction(cardId, groupId, reaction);
        $jacocoInit[145] = true;
        C0120S c = reaction2.mo3696c();
        C3264Oa oa = C3264Oa.f6641a;
        $jacocoInit[146] = true;
        C0120S d = c.mo3653d((C0132p<? super T, Boolean>) oa);
        C0126V v = this.viewScheduler;
        $jacocoInit[147] = true;
        C0120S a = d.mo3616a(v);
        C3289ga gaVar = new C3289ga(this);
        $jacocoInit[148] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) gaVar);
        C3276a aVar = C3276a.f6653a;
        $jacocoInit[149] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) aVar);
        C3285ea eaVar = new C3285ea(this, reactionsHomeEvent);
        $jacocoInit[150] = true;
        C0120S i = d2.mo3668i(eaVar);
        $jacocoInit[151] = true;
        return i;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14107a(ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        handleReactionsResponse(reactionsResponse, false);
        $jacocoInit[155] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14106a(ReactionsHomeEvent reactionsHomeEvent, ReactionsResponse __) {
        boolean[] $jacocoInit = $jacocoInit();
        String cardId = reactionsHomeEvent.getCardId();
        $jacocoInit[152] = true;
        String groupId = reactionsHomeEvent.getGroupId();
        $jacocoInit[153] = true;
        Single loadReactionModel = loadReactionModel(cardId, groupId);
        $jacocoInit[154] = true;
        return loadReactionModel;
    }

    /* renamed from: e */
    static /* synthetic */ void m7867e(CurationCard lifecycleEvent) {
        $jacocoInit()[142] = true;
    }

    private void handleReactionsResponse(ReactionsResponse reactionsResponse, boolean isDelete) {
        boolean[] $jacocoInit = $jacocoInit();
        if (reactionsResponse.wasSuccess()) {
            if (isDelete) {
                $jacocoInit[99] = true;
                this.editorialListAnalytics.sendDeleteEvent();
                $jacocoInit[100] = true;
            } else {
                this.editorialListAnalytics.sendReactedEvent();
                $jacocoInit[101] = true;
            }
        } else if (reactionsResponse.reactionsExceeded()) {
            $jacocoInit[102] = true;
            this.view.showLogInDialog();
            $jacocoInit[103] = true;
        } else if (reactionsResponse.wasNetworkError()) {
            $jacocoInit[104] = true;
            this.view.showNetworkErrorToast();
            $jacocoInit[105] = true;
        } else if (!reactionsResponse.wasGeneralError()) {
            $jacocoInit[106] = true;
        } else {
            $jacocoInit[107] = true;
            this.view.showGenericErrorToast();
            $jacocoInit[108] = true;
        }
        $jacocoInit[109] = true;
    }

    public void handleSnackLogInClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C3240Ca ca = C3240Ca.f6614a;
        $jacocoInit[110] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) ca);
        C3307pa paVar = new C3307pa(this);
        $jacocoInit[111] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) paVar);
        C3283da daVar = new C3283da(this);
        $jacocoInit[112] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) daVar);
        EditorialListView editorialListView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[113] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) editorialListView.bindUntilEvent(lifecycleEvent2));
        C3319va vaVar = C3319va.f6702a;
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        C3278b bVar = new C3278b(crashReport);
        $jacocoInit[114] = true;
        a.mo3626a((C0129b<? super T>) vaVar, (C0129b<Throwable>) bVar);
        $jacocoInit[115] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m7875q(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[141] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo14148r(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S snackLogInClick = this.view.snackLogInClick();
        $jacocoInit[140] = true;
        return snackLogInClick;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14110a(Void homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListNavigator.navigateToLogIn();
        $jacocoInit[139] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7860b(Void lifecycleEvent) {
        $jacocoInit()[138] = true;
    }

    /* access modifiers changed from: private */
    public C0120S<CurationCard> handleSinglePressReactionButton(EditorialHomeEvent editorialHomeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListManager editorialListManager2 = this.editorialListManager;
        String cardId = editorialHomeEvent.getCardId();
        $jacocoInit[116] = true;
        String groupId = editorialHomeEvent.getGroupId();
        $jacocoInit[117] = true;
        Single isFirstReaction = editorialListManager2.isFirstReaction(cardId, groupId);
        C3299la laVar = new C3299la(this, editorialHomeEvent);
        $jacocoInit[118] = true;
        C0120S<CurationCard> c = isFirstReaction.mo3697c(laVar);
        $jacocoInit[119] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14103a(EditorialHomeEvent editorialHomeEvent, Boolean firstReaction) {
        boolean[] $jacocoInit = $jacocoInit();
        if (firstReaction.booleanValue()) {
            $jacocoInit[124] = true;
            showReactions(editorialHomeEvent);
            $jacocoInit[125] = true;
            C0120S c = C0120S.m652c(new CurationCard());
            $jacocoInit[126] = true;
            return c;
        }
        EditorialListManager editorialListManager2 = this.editorialListManager;
        String cardId = editorialHomeEvent.getCardId();
        $jacocoInit[127] = true;
        String groupId = editorialHomeEvent.getGroupId();
        $jacocoInit[128] = true;
        Single deleteReaction = editorialListManager2.deleteReaction(cardId, groupId);
        $jacocoInit[129] = true;
        C0120S c2 = deleteReaction.mo3696c();
        C3235A a = new C3235A(this);
        $jacocoInit[130] = true;
        C0120S b = c2.mo3636b((C0129b<? super T>) a);
        C3276a aVar = C3276a.f6653a;
        $jacocoInit[131] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) aVar);
        C3246Fa fa = new C3246Fa(this, editorialHomeEvent);
        $jacocoInit[132] = true;
        C0120S i = d.mo3668i(fa);
        $jacocoInit[133] = true;
        return i;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14115b(ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        handleReactionsResponse(reactionsResponse, true);
        $jacocoInit[137] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14105a(EditorialHomeEvent editorialHomeEvent, ReactionsResponse reactionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        String cardId = editorialHomeEvent.getCardId();
        $jacocoInit[134] = true;
        String groupId = editorialHomeEvent.getGroupId();
        $jacocoInit[135] = true;
        Single loadReactionModel = loadReactionModel(cardId, groupId);
        $jacocoInit[136] = true;
        return loadReactionModel;
    }

    private void showReactions(EditorialHomeEvent editorialHomeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListAnalytics.sendReactionButtonClickEvent();
        $jacocoInit[120] = true;
        EditorialListView editorialListView = this.view;
        String cardId = editorialHomeEvent.getCardId();
        String groupId = editorialHomeEvent.getGroupId();
        $jacocoInit[121] = true;
        int bundlePosition = editorialHomeEvent.getBundlePosition();
        $jacocoInit[122] = true;
        editorialListView.showReactionsPopup(cardId, groupId, bundlePosition);
        $jacocoInit[123] = true;
    }
}
