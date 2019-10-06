package p005cm.aptoide.p006pt.billing.view.paypal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.Price;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.PayPalAuthorization;
import p005cm.aptoide.p006pt.billing.payment.Payment;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator.PayPalResult;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.view.paypal.PayPalAuthorizationPresenter */
public class PayPalAuthorizationPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int PAY_APP_REQUEST_CODE = 12;
    private final BillingAnalytics analytics;
    private final Billing billing;
    private final BillingNavigator billingNavigator;
    private final String serviceName;
    private final String sku;
    private final PayPalView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6632998841013851040L, "cm/aptoide/pt/billing/view/paypal/PayPalAuthorizationPresenter", 118);
        $jacocoData = probes;
        return probes;
    }

    public PayPalAuthorizationPresenter(PayPalView view2, Billing billing2, BillingAnalytics analytics2, BillingNavigator billingNavigator2, C0126V viewScheduler2, String sku2, String serviceName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.billing = billing2;
        this.analytics = analytics2;
        this.billingNavigator = billingNavigator2;
        this.serviceName = serviceName2;
        this.viewScheduler = viewScheduler2;
        this.sku = sku2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onViewCreatedShowAuthorization();
        $jacocoInit[1] = true;
        onViewCreatedCheckAuthorizationActive();
        $jacocoInit[2] = true;
        onViewCreatedCheckAuthorizationFailed();
        $jacocoInit[3] = true;
        onViewCreatedCheckAuthorizationProcessing();
        $jacocoInit[4] = true;
        handlePayPalResultEvent();
        $jacocoInit[5] = true;
        handleErrorDismissEvent();
        $jacocoInit[6] = true;
    }

    private void onViewCreatedShowAuthorization() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2643w wVar = C2643w.f5805a;
        $jacocoInit[7] = true;
        C0120S e = lifecycleEvent.mo3658e((C0132p<? super T, Boolean>) wVar);
        C2626f fVar = new C2626f(this);
        $jacocoInit[8] = true;
        C0120S b = e.mo3636b((C0129b<? super T>) fVar);
        C2646z zVar = new C2646z(this);
        $jacocoInit[9] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zVar);
        C2627g gVar = C2627g.f5789a;
        $jacocoInit[10] = true;
        C0120S e2 = f.mo3658e((C0132p<? super T, Boolean>) gVar);
        C2622b bVar = C2622b.f5784a;
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
        C0120S a = e2.mo3669j(bVar).mo3611a(PayPalAuthorization.class);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[13] = true;
        C0120S b2 = a.mo3630b(100, timeUnit);
        C0126V v = this.viewScheduler;
        $jacocoInit[14] = true;
        C0120S a2 = b2.mo3616a(v);
        C2640t tVar = new C2640t(this);
        $jacocoInit[15] = true;
        C0120S b3 = a2.mo3636b((C0129b<? super T>) tVar);
        C2639s sVar = new C2639s(this);
        $jacocoInit[16] = true;
        C0120S b4 = b3.mo3636b((C0129b<? super T>) sVar);
        PayPalView payPalView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[17] = true;
        C0120S a3 = b4.mo3614a((C0121c<? super T, ? extends R>) payPalView.bindUntilEvent(lifecycleEvent2));
        C2611E e3 = C2611E.f5773a;
        C2625e eVar = new C2625e(this);
        $jacocoInit[18] = true;
        a3.mo3626a((C0129b<? super T>) e3, (C0129b<Throwable>) eVar);
        $jacocoInit[19] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7288k(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.RESUME));
        $jacocoInit[117] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ void mo11508l(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[116] = true;
    }

    /* renamed from: m */
    public /* synthetic */ C0120S mo11509m(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[115] = true;
        return payment;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7287k(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(payment.isPendingAuthorization());
        $jacocoInit[114] = true;
        return valueOf;
    }

    /* renamed from: l */
    static /* synthetic */ Authorization m7289l(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Authorization authorization = payment.getAuthorization();
        $jacocoInit[113] = true;
        return authorization;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11488a(PayPalAuthorization __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[112] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11494b(PayPalAuthorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        BillingNavigator billingNavigator2 = this.billingNavigator;
        $jacocoInit[107] = true;
        Price price = authorization.getPrice();
        $jacocoInit[108] = true;
        String currency = price.getCurrency();
        String description = authorization.getDescription();
        Price price2 = authorization.getPrice();
        $jacocoInit[109] = true;
        double amount = price2.getAmount();
        $jacocoInit[110] = true;
        billingNavigator2.navigateToPayPalForResult(12, currency, description, amount);
        $jacocoInit[111] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7277c(PayPalAuthorization __) {
        $jacocoInit()[106] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo11504f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[105] = true;
    }

    private void onViewCreatedCheckAuthorizationActive() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2628h hVar = C2628h.f5790a;
        $jacocoInit[20] = true;
        C0120S e = lifecycleEvent.mo3658e((C0132p<? super T, Boolean>) hVar);
        C2614H h = new C2614H(this);
        $jacocoInit[21] = true;
        C0120S f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) h);
        C2645y yVar = C2645y.f5807a;
        $jacocoInit[22] = true;
        C0120S e2 = f.mo3658e((C0132p<? super T, Boolean>) yVar);
        C2635o oVar = new C2635o(this);
        $jacocoInit[23] = true;
        C0120S b = e2.mo3636b((C0129b<? super T>) oVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[24] = true;
        C0120S a = b.mo3616a(v);
        C2644x xVar = new C2644x(this);
        $jacocoInit[25] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) xVar);
        PayPalView payPalView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[26] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) payPalView.bindUntilEvent(lifecycleEvent2));
        C2642v vVar = C2642v.f5804a;
        C2607A a3 = new C2607A(this);
        $jacocoInit[27] = true;
        a2.mo3626a((C0129b<? super T>) vVar, (C0129b<Throwable>) a3);
        $jacocoInit[28] = true;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m7281f(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[104] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ C0120S mo11501e(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[103] = true;
        return payment;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7273a(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(payment.isCompleted());
        $jacocoInit[102] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11495b(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendAuthorizationSuccessEvent(payment);
        $jacocoInit[101] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11497c(Payment __) {
        boolean[] $jacocoInit = $jacocoInit();
        popView();
        $jacocoInit[100] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7279d(Payment __) {
        $jacocoInit()[99] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11498c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[98] = true;
    }

    private void onViewCreatedCheckAuthorizationFailed() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2617K k = C2617K.f5779a;
        $jacocoInit[29] = true;
        C0120S e = lifecycleEvent.mo3658e((C0132p<? super T, Boolean>) k);
        C2641u uVar = new C2641u(this);
        $jacocoInit[30] = true;
        C0120S f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) uVar);
        C2612F f2 = C2612F.f5774a;
        $jacocoInit[31] = true;
        C0120S e2 = f.mo3658e((C0132p<? super T, Boolean>) f2);
        C0126V v = this.viewScheduler;
        $jacocoInit[32] = true;
        C0120S a = e2.mo3616a(v);
        C2634n nVar = new C2634n(this);
        $jacocoInit[33] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) nVar);
        PayPalView payPalView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[34] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) payPalView.bindUntilEvent(lifecycleEvent2));
        C2620N n = C2620N.f5782a;
        C2631k kVar = new C2631k(this);
        $jacocoInit[35] = true;
        a2.mo3626a((C0129b<? super T>) n, (C0129b<Throwable>) kVar);
        $jacocoInit[36] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7282g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[97] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo11505h(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[96] = true;
        return payment;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7280e(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(payment.isFailed());
        $jacocoInit[95] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ void mo11503f(Payment __) {
        boolean[] $jacocoInit = $jacocoInit();
        popViewWithError();
        $jacocoInit[94] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m7283g(Payment __) {
        $jacocoInit()[93] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo11500d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[92] = true;
    }

    private void onViewCreatedCheckAuthorizationProcessing() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2638r rVar = C2638r.f5800a;
        $jacocoInit[37] = true;
        C0120S e = lifecycleEvent.mo3658e((C0132p<? super T, Boolean>) rVar);
        C2637q qVar = new C2637q(this);
        $jacocoInit[38] = true;
        C0120S f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) qVar);
        C2609C c = C2609C.f5771a;
        $jacocoInit[39] = true;
        C0120S e2 = f.mo3658e((C0132p<? super T, Boolean>) c);
        C0126V v = this.viewScheduler;
        $jacocoInit[40] = true;
        C0120S a = e2.mo3616a(v);
        C2618L l = new C2618L(this);
        $jacocoInit[41] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) l);
        PayPalView payPalView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[42] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) payPalView.bindUntilEvent(lifecycleEvent2));
        C2632l lVar = C2632l.f5794a;
        C2636p pVar = new C2636p(this);
        $jacocoInit[43] = true;
        a2.mo3626a((C0129b<? super T>) lVar, (C0129b<Throwable>) pVar);
        $jacocoInit[44] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m7285i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[91] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo11507j(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[90] = true;
        return payment;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m7284h(Payment authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(authorization.isProcessing());
        $jacocoInit[89] = true;
        return valueOf;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11506i(Payment __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[88] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m7286j(Payment __) {
        $jacocoInit()[87] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11502e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[86] = true;
    }

    private void handlePayPalResultEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2615I i = C2615I.f5777a;
        $jacocoInit[45] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) i);
        C2610D d2 = new C2610D(this);
        $jacocoInit[46] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) d2);
        C2623c cVar = new C2623c(this);
        $jacocoInit[47] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) cVar);
        C2613G g = new C2613G(this);
        $jacocoInit[48] = true;
        C0120S g2 = b.mo3663g((C0132p<? super T, ? extends C0117M>) g);
        PayPalView payPalView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[49] = true;
        C0120S a = g2.mo3614a((C0121c<? super T, ? extends R>) payPalView.bindUntilEvent(lifecycleEvent2));
        C2624d dVar = C2624d.f5786a;
        C2608B b2 = new C2608B(this);
        $jacocoInit[50] = true;
        a.mo3626a((C0129b<? super T>) dVar, (C0129b<Throwable>) b2);
        $jacocoInit[51] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7276c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[85] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo11499d(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payPalResults = this.billingNavigator.payPalResults(12);
        $jacocoInit[84] = true;
        return payPalResults;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11489a(PayPalResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[83] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo11492b(PayPalResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        int status = result.getStatus();
        if (status == 0) {
            C0117M authorize = this.billing.authorize(this.sku, result.getPaymentConfirmationId());
            $jacocoInit[76] = true;
            return authorize;
        } else if (status == 1) {
            showUnknownError();
            $jacocoInit[80] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[81] = true;
            return b;
        } else if (status != 2) {
            C0117M b2 = C0117M.m590b();
            $jacocoInit[82] = true;
            return b2;
        } else {
            this.analytics.sendAuthorizationCancelEvent(this.serviceName);
            $jacocoInit[77] = true;
            popView();
            $jacocoInit[78] = true;
            C0117M b3 = C0117M.m590b();
            $jacocoInit[79] = true;
            return b3;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m7278c(PayPalResult __) {
        $jacocoInit()[75] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11496b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[74] = true;
    }

    private void handleErrorDismissEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2629i iVar = C2629i.f5791a;
        $jacocoInit[52] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) iVar);
        C2633m mVar = new C2633m(this);
        $jacocoInit[53] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) mVar);
        C2616J j = new C2616J(this);
        $jacocoInit[54] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) j);
        PayPalView payPalView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[55] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) payPalView.bindUntilEvent(lifecycleEvent2));
        C2619M m = C2619M.f5781a;
        C2630j jVar = new C2630j(this);
        $jacocoInit[56] = true;
        a.mo3626a((C0129b<? super T>) m, (C0129b<Throwable>) jVar);
        $jacocoInit[57] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7274a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[73] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11493b(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S errorDismisses = this.view.errorDismisses();
        $jacocoInit[72] = true;
        return errorDismisses;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11491a(Void product) {
        boolean[] $jacocoInit = $jacocoInit();
        popViewWithError();
        $jacocoInit[71] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7275b(Void __) {
        $jacocoInit()[70] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11490a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[69] = true;
    }

    private void popView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[58] = true;
        this.billingNavigator.popView();
        $jacocoInit[59] = true;
    }

    private void showUnknownError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[60] = true;
    }

    private void showError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof IOException) {
            $jacocoInit[61] = true;
            this.view.hideLoading();
            $jacocoInit[62] = true;
            this.view.showNetworkError();
            $jacocoInit[63] = true;
        } else {
            popViewWithError();
            $jacocoInit[64] = true;
        }
        $jacocoInit[65] = true;
    }

    private void popViewWithError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendAuthorizationErrorEvent(this.serviceName);
        $jacocoInit[66] = true;
        this.view.hideLoading();
        $jacocoInit[67] = true;
        this.billingNavigator.popView();
        $jacocoInit[68] = true;
    }
}
