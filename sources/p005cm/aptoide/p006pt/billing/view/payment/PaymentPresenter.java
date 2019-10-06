package p005cm.aptoide.p006pt.billing.view.payment;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.Customer;
import p005cm.aptoide.p006pt.billing.exception.ServiceNotAuthorizedException;
import p005cm.aptoide.p006pt.billing.payment.Payment;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.billing.view.payment.PaymentPresenter */
public class PaymentPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int CUSTOMER_AUTHORIZATION_REQUEST_CODE = 2001;
    private final BillingAnalytics analytics;
    private final Billing billing;
    private final String merchantName;
    private final BillingNavigator navigator;
    private final String payload;
    private final Set<String> purchaseErrorShown;
    private final String sku;
    private final PaymentView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2962518774603224276L, "cm/aptoide/pt/billing/view/payment/PaymentPresenter", Opcodes.PUTFIELD);
        $jacocoData = probes;
        return probes;
    }

    public PaymentPresenter(PaymentView view2, Billing billing2, BillingNavigator navigator2, BillingAnalytics analytics2, String merchantName2, String sku2, String payload2, Set<String> purchaseErrorShown2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.billing = billing2;
        this.navigator = navigator2;
        this.analytics = analytics2;
        this.merchantName = merchantName2;
        this.sku = sku2;
        this.payload = payload2;
        this.purchaseErrorShown = purchaseErrorShown2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onViewCreatedNavigateToCustomerAuthentication();
        $jacocoInit[1] = true;
        onViewCreatedHandleCustomerAuthenticationResult();
        $jacocoInit[2] = true;
        onViewCreatedShowPayment();
        $jacocoInit[3] = true;
        onViewCreatedCheckPaymentResult();
        $jacocoInit[4] = true;
        handleSelectServiceEvent();
        $jacocoInit[5] = true;
        handleCancelEvent();
        $jacocoInit[6] = true;
        handleBuyEvent();
        $jacocoInit[7] = true;
    }

    private void onViewCreatedNavigateToCustomerAuthentication() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2581ba baVar = C2581ba.f5742a;
        $jacocoInit[8] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) baVar);
        C2603w wVar = new C2603w(this);
        $jacocoInit[9] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) wVar);
        C2602v vVar = new C2602v(this);
        $jacocoInit[10] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vVar);
        C2564M m = new C2564M(this);
        $jacocoInit[11] = true;
        C0120S b2 = f.mo3636b((C0129b<? super T>) m);
        C2561J j = C2561J.f5722a;
        $jacocoInit[12] = true;
        C0120S d2 = b2.mo3653d((C0132p<? super T, Boolean>) j);
        $jacocoInit[13] = true;
        C0120S a = d2.mo3616a(C14522a.m46170a());
        C2605y yVar = new C2605y(this);
        $jacocoInit[14] = true;
        C0120S b3 = a.mo3636b((C0129b<? super T>) yVar);
        PaymentView paymentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[15] = true;
        C0120S a2 = b3.mo3614a((C0121c<? super T, ? extends R>) paymentView.bindUntilEvent(lifecycleEvent2));
        C2566O o = C2566O.f5727a;
        C2557F f2 = new C2557F(this);
        $jacocoInit[16] = true;
        a2.mo3626a((C0129b<? super T>) o, (C0129b<Throwable>) f2);
        $jacocoInit[17] = true;
    }

    /* renamed from: l */
    static /* synthetic */ Boolean m7236l(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[180] = true;
        return valueOf;
    }

    /* renamed from: m */
    public /* synthetic */ void mo11481m(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showPaymentLoading();
        $jacocoInit[179] = true;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo11482n(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Customer customer = this.billing.getCustomer();
        $jacocoInit[176] = true;
        C0120S isAuthenticated = customer.isAuthenticated();
        $jacocoInit[177] = true;
        C0120S d = isAuthenticated.mo3647d();
        $jacocoInit[178] = true;
        return d;
    }

    /* renamed from: g */
    public /* synthetic */ void mo11472g(Boolean authenticated) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendCustomerAuthenticatedEvent(authenticated.booleanValue());
        $jacocoInit[175] = true;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m7230h(Boolean authenticated) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!authenticated.booleanValue()) {
            $jacocoInit[172] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[173] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[174] = true;
        return valueOf;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11478i(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.navigateToCustomerAuthenticationForResult(CUSTOMER_AUTHORIZATION_REQUEST_CODE);
        $jacocoInit[171] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m7234j(Boolean __) {
        $jacocoInit()[170] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo11473g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult(throwable);
        $jacocoInit[169] = true;
    }

    private void onViewCreatedHandleCustomerAuthenticationResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2586f fVar = C2586f.f5747a;
        $jacocoInit[18] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) fVar);
        C2598r rVar = new C2598r(this);
        $jacocoInit[19] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        C2597q qVar = new C2597q(this);
        $jacocoInit[20] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) qVar);
        C2555D d2 = C2555D.f5716a;
        $jacocoInit[21] = true;
        C0120S d3 = b.mo3653d((C0132p<? super T, Boolean>) d2);
        $jacocoInit[22] = true;
        C0120S a = d3.mo3616a(C14522a.m46170a());
        C2563L l = new C2563L(this);
        $jacocoInit[23] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) l);
        PaymentView paymentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[24] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) paymentView.bindUntilEvent(lifecycleEvent2));
        C2565N n = C2565N.f5726a;
        C2585e eVar = new C2585e(this);
        $jacocoInit[25] = true;
        a2.mo3626a((C0129b<? super T>) n, (C0129b<Throwable>) eVar);
        $jacocoInit[26] = true;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m7232j(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[168] = true;
        return valueOf;
    }

    /* renamed from: k */
    public /* synthetic */ C0120S mo11479k(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S customerAuthenticationResults = this.navigator.customerAuthenticationResults(CUSTOMER_AUTHORIZATION_REQUEST_CODE);
        $jacocoInit[167] = true;
        return customerAuthenticationResults;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11460c(Boolean authenticated) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendCustomerAuthenticationResultEvent(authenticated.booleanValue());
        $jacocoInit[166] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m7226d(Boolean authenticated) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!authenticated.booleanValue()) {
            $jacocoInit[163] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[164] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[165] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11466e(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult();
        $jacocoInit[162] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m7228f(Boolean __) {
        $jacocoInit()[161] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo11470f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult(throwable);
        $jacocoInit[160] = true;
    }

    private void onViewCreatedShowPayment() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2579aa aaVar = C2579aa.f5740a;
        $jacocoInit[27] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) aaVar);
        C2571T t = new C2571T(this);
        $jacocoInit[28] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) t);
        C2573V v = C2573V.f5734a;
        $jacocoInit[29] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) v);
        C2553B b = new C2553B(this);
        $jacocoInit[30] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) b);
        $jacocoInit[31] = true;
        C0120S a = f2.mo3616a(C14522a.m46170a());
        C2567P p = new C2567P(this);
        $jacocoInit[32] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) p);
        PaymentView paymentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[33] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) paymentView.bindUntilEvent(lifecycleEvent2));
        C2558G g = C2558G.f5719a;
        C2595o oVar = new C2595o(this);
        $jacocoInit[34] = true;
        a2.mo3626a((C0129b<? super T>) g, (C0129b<Throwable>) oVar);
        $jacocoInit[35] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m7237o(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[159] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo11483p(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Customer customer = this.billing.getCustomer();
        $jacocoInit[157] = true;
        C0120S isAuthenticated = customer.isAuthenticated();
        $jacocoInit[158] = true;
        return isAuthenticated;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7235k(Boolean authenticated) {
        $jacocoInit()[156] = true;
        return authenticated;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo11480l(Boolean loading) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[155] = true;
        return payment;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11477i(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        showPayment(payment);
        $jacocoInit[153] = true;
        this.view.hidePaymentLoading();
        $jacocoInit[154] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m7233j(Payment __) {
        $jacocoInit()[152] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo11475h(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult(throwable);
        $jacocoInit[151] = true;
    }

    private void onViewCreatedCheckPaymentResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2591k kVar = C2591k.f5753a;
        $jacocoInit[36] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kVar);
        C2582c cVar = new C2582c(this);
        $jacocoInit[37] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) cVar);
        C2589i iVar = new C2589i(this);
        $jacocoInit[38] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iVar);
        C2599s sVar = C2599s.f5761a;
        $jacocoInit[39] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) sVar);
        C2584d dVar = new C2584d(this);
        $jacocoInit[40] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dVar);
        PaymentView paymentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[41] = true;
        C0120S a = f2.mo3614a((C0121c<? super T, ? extends R>) paymentView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[42] = true;
        C0120S a2 = a.mo3616a(C14522a.m46170a());
        C2600t tVar = C2600t.f5762a;
        C2560I i = new C2560I(this);
        $jacocoInit[43] = true;
        a2.mo3626a((C0129b<? super T>) tVar, (C0129b<Throwable>) i);
        $jacocoInit[44] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7229g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[150] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ void mo11474h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showPurchaseLoading();
        $jacocoInit[149] = true;
    }

    /* renamed from: i */
    public /* synthetic */ C0120S mo11476i(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Customer customer = this.billing.getCustomer();
        $jacocoInit[147] = true;
        C0120S isAuthenticated = customer.isAuthenticated();
        $jacocoInit[148] = true;
        return isAuthenticated;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7221a(Boolean authenticated) {
        $jacocoInit()[146] = true;
        return authenticated;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11455b(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[120] = true;
        C0120S a = payment.mo3616a(C14522a.m46170a());
        C2606z zVar = new C2606z(this);
        $jacocoInit[121] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) zVar);
        $jacocoInit[122] = true;
        return b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void mo11463d(p005cm.aptoide.p006pt.billing.payment.Payment r6) {
        /*
            r5 = this;
            boolean[] r0 = $jacocoInit()
            boolean r1 = r6.isNew()
            r2 = 1
            if (r1 == 0) goto L_0x0010
            r1 = 123(0x7b, float:1.72E-43)
            r0[r1] = r2
            goto L_0x001f
        L_0x0010:
            boolean r1 = r6.isPendingAuthorization()
            if (r1 != 0) goto L_0x001b
            r1 = 124(0x7c, float:1.74E-43)
            r0[r1] = r2
            goto L_0x0028
        L_0x001b:
            r1 = 125(0x7d, float:1.75E-43)
            r0[r1] = r2
        L_0x001f:
            cm.aptoide.pt.billing.view.payment.PaymentView r1 = r5.view
            r1.hidePurchaseLoading()
            r1 = 126(0x7e, float:1.77E-43)
            r0[r1] = r2
        L_0x0028:
            boolean r1 = r6.isProcessing()
            if (r1 != 0) goto L_0x0033
            r1 = 127(0x7f, float:1.78E-43)
            r0[r1] = r2
            goto L_0x0040
        L_0x0033:
            r1 = 128(0x80, float:1.794E-43)
            r0[r1] = r2
            cm.aptoide.pt.billing.view.payment.PaymentView r1 = r5.view
            r1.showPurchaseLoading()
            r1 = 129(0x81, float:1.81E-43)
            r0[r1] = r2
        L_0x0040:
            boolean r1 = r6.isCompleted()
            if (r1 != 0) goto L_0x004b
            r1 = 130(0x82, float:1.82E-43)
            r0[r1] = r2
            goto L_0x0065
        L_0x004b:
            r1 = 131(0x83, float:1.84E-43)
            r0[r1] = r2
            cm.aptoide.pt.billing.BillingAnalytics r1 = r5.analytics
            r1.sendPaymentSuccessEvent()
            r1 = 132(0x84, float:1.85E-43)
            r0[r1] = r2
            cm.aptoide.pt.billing.view.BillingNavigator r1 = r5.navigator
            cm.aptoide.pt.billing.purchase.Purchase r3 = r6.getPurchase()
            r1.popViewWithResult(r3)
            r1 = 133(0x85, float:1.86E-43)
            r0[r1] = r2
        L_0x0065:
            boolean r1 = r6.isFailed()
            if (r1 != 0) goto L_0x0070
            r1 = 134(0x86, float:1.88E-43)
            r0[r1] = r2
            goto L_0x00c5
        L_0x0070:
            java.util.Set<java.lang.String> r1 = r5.purchaseErrorShown
            cm.aptoide.pt.billing.transaction.Transaction r3 = r6.getTransaction()
            r4 = 135(0x87, float:1.89E-43)
            r0[r4] = r2
            java.lang.String r3 = r3.getId()
            r4 = 136(0x88, float:1.9E-43)
            r0[r4] = r2
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L_0x008d
            r1 = 137(0x89, float:1.92E-43)
            r0[r1] = r2
            goto L_0x00c5
        L_0x008d:
            r1 = 138(0x8a, float:1.93E-43)
            r0[r1] = r2
            java.util.Set<java.lang.String> r1 = r5.purchaseErrorShown
            cm.aptoide.pt.billing.transaction.Transaction r3 = r6.getTransaction()
            r4 = 139(0x8b, float:1.95E-43)
            r0[r4] = r2
            java.lang.String r3 = r3.getId()
            r4 = 140(0x8c, float:1.96E-43)
            r0[r4] = r2
            r1.add(r3)
            r1 = 141(0x8d, float:1.98E-43)
            r0[r1] = r2
            cm.aptoide.pt.billing.view.payment.PaymentView r1 = r5.view
            r1.hidePurchaseLoading()
            r1 = 142(0x8e, float:1.99E-43)
            r0[r1] = r2
            cm.aptoide.pt.billing.view.payment.PaymentView r1 = r5.view
            r1.showUnknownError()
            r1 = 143(0x8f, float:2.0E-43)
            r0[r1] = r2
            cm.aptoide.pt.billing.BillingAnalytics r1 = r5.analytics
            r1.sendPaymentErrorEvent()
            r1 = 144(0x90, float:2.02E-43)
            r0[r1] = r2
        L_0x00c5:
            r1 = 145(0x91, float:2.03E-43)
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.view.payment.PaymentPresenter.mo11463d(cm.aptoide.pt.billing.payment.Payment):void");
    }

    /* renamed from: h */
    static /* synthetic */ void m7231h(Payment __) {
        $jacocoInit()[119] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11467e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult(throwable);
        $jacocoInit[118] = true;
    }

    private void handleCancelEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2574W w = C2574W.f5735a;
        $jacocoInit[45] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) w);
        $jacocoInit[46] = true;
        C0120S a = d.mo3616a(C14522a.m46170a());
        C2576Y y = new C2576Y(this);
        $jacocoInit[47] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) y);
        C2562K k = new C2562K(this);
        $jacocoInit[48] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) k);
        $jacocoInit[49] = true;
        C0120S a2 = f2.mo3616a(C14522a.m46170a());
        C2559H h = new C2559H(this);
        $jacocoInit[50] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) h);
        PaymentView paymentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[51] = true;
        C0120S a3 = b.mo3614a((C0121c<? super T, ? extends R>) paymentView.bindUntilEvent(lifecycleEvent2));
        C2604x xVar = C2604x.f5766a;
        C2569Q q = new C2569Q(this);
        $jacocoInit[52] = true;
        a3.mo3626a((C0129b<? super T>) xVar, (C0129b<Throwable>) q);
        $jacocoInit[53] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7224c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.CREATE.equals(event));
        $jacocoInit[117] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo11462d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelEvent = this.view.cancelEvent();
        $jacocoInit[116] = true;
        return cancelEvent;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11452a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[114] = true;
        C0120S d = payment.mo3647d();
        $jacocoInit[115] = true;
        return d;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11456b(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendPaymentViewCancelEvent(payment);
        $jacocoInit[112] = true;
        this.navigator.popViewWithResult();
        $jacocoInit[113] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m7225c(Payment __) {
        $jacocoInit()[111] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11457b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult();
        $jacocoInit[110] = true;
    }

    private void handleSelectServiceEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2590j jVar = C2590j.f5752a;
        $jacocoInit[54] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) jVar);
        $jacocoInit[55] = true;
        C0120S a = d.mo3616a(C14522a.m46170a());
        C2552A a2 = new C2552A(this);
        $jacocoInit[56] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) a2);
        C2594n nVar = new C2594n(this);
        $jacocoInit[57] = true;
        C0120S g = f.mo3663g((C0132p<? super T, ? extends C0117M>) nVar);
        PaymentView paymentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[58] = true;
        C0120S a3 = g.mo3614a((C0121c<? super T, ? extends R>) paymentView.bindUntilEvent(lifecycleEvent2));
        C2583ca caVar = C2583ca.f5744a;
        C2575X x = new C2575X(this);
        $jacocoInit[59] = true;
        a3.mo3626a((C0129b<? super T>) caVar, (C0129b<Throwable>) x);
        $jacocoInit[60] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7227e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.CREATE.equals(event));
        $jacocoInit[109] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo11468f(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S selectServiceEvent = this.view.selectServiceEvent();
        $jacocoInit[108] = true;
        return selectServiceEvent;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11451a(String serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M selectService = this.billing.selectService(serviceId);
        $jacocoInit[107] = true;
        return selectService;
    }

    /* renamed from: b */
    static /* synthetic */ void m7223b(String __) {
        $jacocoInit()[106] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11461c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult(throwable);
        $jacocoInit[105] = true;
    }

    private void handleBuyEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2592l lVar = C2592l.f5754a;
        $jacocoInit[61] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) lVar);
        C2554C c = new C2554C(this);
        $jacocoInit[62] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) c);
        PaymentView paymentView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[63] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) paymentView.bindUntilEvent(lifecycleEvent2));
        C2601u uVar = C2601u.f5763a;
        C2572U u = new C2572U(this);
        $jacocoInit[64] = true;
        a.mo3626a((C0129b<? super T>) uVar, (C0129b<Throwable>) u);
        $jacocoInit[65] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7220a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(LifecycleEvent.CREATE.equals(event));
        $jacocoInit[104] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11454b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S buyEvent = this.view.buyEvent();
        C2556E e = new C2556E(this);
        $jacocoInit[83] = true;
        C0120S b = buyEvent.mo3636b((C0129b<? super T>) e);
        C2596p pVar = new C2596p(this);
        $jacocoInit[84] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pVar);
        C2577Z z = new C2577Z(this);
        $jacocoInit[85] = true;
        C0120S b2 = f.mo3636b((C0129b<? super T>) z);
        C2588h hVar = new C2588h(this);
        $jacocoInit[86] = true;
        C0120S g = b2.mo3663g((C0132p<? super T, ? extends C0117M>) hVar);
        $jacocoInit[87] = true;
        C0120S a = g.mo3616a(C14522a.m46170a());
        C2593m mVar = new C2593m(this);
        $jacocoInit[88] = true;
        C0120S a2 = a.mo3621a((C0129b<? super Throwable>) mVar);
        $jacocoInit[89] = true;
        C0120S g2 = a2.mo3662g();
        $jacocoInit[90] = true;
        return g2;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11458b(Void ___) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showBuyLoading();
        $jacocoInit[103] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo11459c(Void ___) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[101] = true;
        C0120S d = payment.mo3647d();
        $jacocoInit[102] = true;
        return d;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11465e(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendPaymentViewBuyEvent(payment);
        $jacocoInit[100] = true;
    }

    /* renamed from: g */
    public /* synthetic */ C0117M mo11471g(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M processPayment = this.billing.processPayment(this.sku, this.payload);
        $jacocoInit[93] = true;
        C0117M a = processPayment.mo3581a(C14522a.m46170a());
        C2570S s = new C2570S(this, payment);
        $jacocoInit[94] = true;
        C0117M a2 = a.mo3582a((C0128a) s);
        C2587g gVar = new C2587g(this, payment);
        $jacocoInit[95] = true;
        C0117M b = a2.mo3596b((C0132p<? super Throwable, ? extends C0117M>) gVar);
        $jacocoInit[96] = true;
        return b;
    }

    /* renamed from: f */
    public /* synthetic */ void mo11469f(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendAuthorizationSuccessEvent(payment);
        $jacocoInit[98] = true;
        this.view.hideBuyLoading();
        $jacocoInit[99] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11450a(Payment payment, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M navigateToAuthorizationView = navigateToAuthorizationView(payment, throwable);
        $jacocoInit[97] = true;
        return navigateToAuthorizationView;
    }

    /* renamed from: d */
    public /* synthetic */ void mo11464d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideBuyLoading();
        $jacocoInit[91] = true;
        showError(throwable);
        $jacocoInit[92] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7222a(Payment __) {
        $jacocoInit()[82] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11453a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popViewWithResult(throwable);
        $jacocoInit[81] = true;
    }

    private C0117M navigateToAuthorizationView(Payment payment, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof ServiceNotAuthorizedException) {
            BillingNavigator billingNavigator = this.navigator;
            String str = this.merchantName;
            $jacocoInit[66] = true;
            PaymentService selectedPaymentService = payment.getSelectedPaymentService();
            String str2 = this.sku;
            $jacocoInit[67] = true;
            billingNavigator.navigateToTransactionAuthorizationView(str, selectedPaymentService, str2);
            $jacocoInit[68] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[69] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b(throwable);
        $jacocoInit[70] = true;
        return b2;
    }

    private void showError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof IOException) {
            $jacocoInit[71] = true;
            this.view.showNetworkError();
            $jacocoInit[72] = true;
        } else {
            this.view.showUnknownError();
            $jacocoInit[73] = true;
        }
        $jacocoInit[74] = true;
    }

    private void showPayment(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showProduct(payment.getProduct());
        $jacocoInit[75] = true;
        List paymentServices = payment.getPaymentServices();
        $jacocoInit[76] = true;
        if (paymentServices.isEmpty()) {
            $jacocoInit[77] = true;
            this.view.showPaymentsNotFoundMessage();
            $jacocoInit[78] = true;
        } else {
            this.view.showPayments(payment.getPaymentServices(), payment.getSelectedPaymentService());
            $jacocoInit[79] = true;
        }
        $jacocoInit[80] = true;
    }
}
