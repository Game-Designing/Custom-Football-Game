package p005cm.aptoide.p006pt.store.view.p079my;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.store.view.my.MyStoresPresenter */
public class MyStoresPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final MyStoresNavigator myStoresNavigator;
    private final MyStoresView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5615948160653343545L, "cm/aptoide/pt/store/view/my/MyStoresPresenter", 53);
        $jacocoData = probes;
        return probes;
    }

    public MyStoresPresenter(MyStoresView view2, C0126V viewScheduler2, AptoideAccountManager accountManager2, MyStoresNavigator myStoresNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.viewScheduler = viewScheduler2;
        this.accountManager = accountManager2;
        this.myStoresNavigator = myStoresNavigator2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        loadUserImage();
        $jacocoInit[1] = true;
        handleBottomNavigationEvent();
        $jacocoInit[2] = true;
        handleUserImageClick();
        $jacocoInit[3] = true;
    }

    private void handleUserImageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5046k kVar = C5046k.f8734a;
        $jacocoInit[4] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kVar);
        C5056u uVar = new C5056u(this);
        $jacocoInit[5] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) uVar);
        MyStoresView myStoresView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[6] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) myStoresView.bindUntilEvent(lifecycleEvent2));
        C5044i iVar = C5044i.f8732a;
        C5048m mVar = C5048m.f8736a;
        $jacocoInit[7] = true;
        a.mo3626a((C0129b<? super T>) iVar, (C0129b<Throwable>) mVar);
        $jacocoInit[8] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m9387c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[52] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo16681d(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S imageClick = this.view.imageClick();
        C0126V v = this.viewScheduler;
        $jacocoInit[47] = true;
        C0120S a = imageClick.mo3616a(v);
        C5050o oVar = new C5050o(this);
        $jacocoInit[48] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) oVar);
        $jacocoInit[49] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[50] = true;
        return g;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16680b(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.myStoresNavigator.navigateToMyAccount();
        $jacocoInit[51] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9384a(Void __) {
        $jacocoInit()[46] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9386b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[45] = true;
        throw onErrorNotImplementedException;
    }

    private void loadUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5047l lVar = C5047l.f8735a;
        $jacocoInit[9] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) lVar);
        C5052q qVar = new C5052q(this);
        $jacocoInit[10] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qVar);
        C5049n nVar = new C5049n(this);
        $jacocoInit[11] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[12] = true;
        C0120S a = f2.mo3616a(v);
        C5057v vVar = new C5057v(this);
        $jacocoInit[13] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) vVar);
        MyStoresView myStoresView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[14] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) myStoresView.bindUntilEvent(lifecycleEvent2));
        C5045j jVar = C5045j.f8733a;
        C5042g gVar = C5042g.f8730a;
        $jacocoInit[15] = true;
        a2.mo3626a((C0129b<? super T>) jVar, (C0129b<Throwable>) gVar);
        $jacocoInit[16] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m9389e(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[44] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo16682f(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[43] = true;
        return accountStatus;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16676a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S userAvatar = getUserAvatar(account);
        $jacocoInit[42] = true;
        return userAvatar;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16677a(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (userAvatarUrl != null) {
            $jacocoInit[38] = true;
            this.view.setUserImage(userAvatarUrl);
            $jacocoInit[39] = true;
        } else {
            this.view.setDefaultUserImage();
            $jacocoInit[40] = true;
        }
        this.view.showAvatar();
        $jacocoInit[41] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9385b(String __) {
        $jacocoInit()[37] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9388c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[36] = true;
        throw onErrorNotImplementedException;
    }

    private void handleBottomNavigationEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C5043h hVar = C5043h.f8731a;
        $jacocoInit[17] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) hVar);
        C5054s sVar = new C5054s(this);
        $jacocoInit[18] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sVar);
        MyStoresView myStoresView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[19] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) myStoresView.bindUntilEvent(lifecycleEvent2));
        C5055t tVar = C5055t.f8743a;
        C5053r rVar = C5053r.f8741a;
        $jacocoInit[20] = true;
        a.mo3626a((C0129b<? super T>) tVar, (C0129b<Throwable>) rVar);
        $jacocoInit[21] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9381a(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[35] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo16678b(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S bottomNavigationEvent = this.myStoresNavigator.bottomNavigationEvent();
        C0126V v = this.viewScheduler;
        $jacocoInit[30] = true;
        C0120S a = bottomNavigationEvent.mo3616a(v);
        C5051p pVar = new C5051p(this);
        $jacocoInit[31] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) pVar);
        $jacocoInit[32] = true;
        C0120S g = b.mo3662g();
        $jacocoInit[33] = true;
        return g;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16679b(Integer navigated) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.scrollToTop();
        $jacocoInit[34] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9382a(Integer __) {
        $jacocoInit()[29] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9383a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[28] = true;
        throw onErrorNotImplementedException;
    }

    private C0120S<String> getUserAvatar(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        String userAvatarUrl = null;
        $jacocoInit[22] = true;
        if (account == null) {
            $jacocoInit[23] = true;
        } else if (!account.isLoggedIn()) {
            $jacocoInit[24] = true;
        } else {
            $jacocoInit[25] = true;
            userAvatarUrl = account.getAvatar();
            $jacocoInit[26] = true;
        }
        C0120S<String> c = C0120S.m652c(userAvatarUrl);
        $jacocoInit[27] = true;
        return c;
    }
}
