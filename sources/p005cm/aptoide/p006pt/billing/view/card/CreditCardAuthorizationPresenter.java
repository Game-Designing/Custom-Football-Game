package p005cm.aptoide.p006pt.billing.view.card;

import android.net.Uri;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.authorization.AdyenAuthorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.payment.Adyen;
import p005cm.aptoide.p006pt.billing.payment.Payment;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p019d.p135a.p136a.C6919k;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6886b;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.C6896i;
import p019d.p135a.p136a.p139c.p140a.C6884d;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.view.card.CreditCardAuthorizationPresenter */
public class CreditCardAuthorizationPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: adyen reason: collision with root package name */
    private final Adyen f44402adyen;
    private final BillingAnalytics analytics;
    private final Billing billing;
    private final BillingNavigator navigator;
    private final String serviceName;
    private final String sku;
    private final CreditCardAuthorizationView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3625878763219585686L, "cm/aptoide/pt/billing/view/card/CreditCardAuthorizationPresenter", 200);
        $jacocoData = probes;
        return probes;
    }

    public CreditCardAuthorizationPresenter(CreditCardAuthorizationView view2, String sku2, Billing billing2, BillingNavigator navigator2, BillingAnalytics analytics2, String serviceName2, Adyen adyen2, C0126V viewScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.sku = sku2;
        this.billing = billing2;
        this.navigator = navigator2;
        this.analytics = analytics2;
        this.serviceName = serviceName2;
        this.f44402adyen = adyen2;
        this.viewScheduler = viewScheduler2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        onViewCreatedCreatePayment();
        $jacocoInit[1] = true;
        onViewCreatedSelectCreditCardPayment();
        $jacocoInit[2] = true;
        onViewCreatedShowCreditCardInputView();
        $jacocoInit[3] = true;
        onViewCreatedCheckAuthorizationActive();
        $jacocoInit[4] = true;
        onViewCreatedCheckAuthorizationFailed();
        $jacocoInit[5] = true;
        onViewCreatedCheckAuthorizationProcessing();
        $jacocoInit[6] = true;
        handleAdyenCreditCardResults();
        $jacocoInit[7] = true;
        handleAdyenUriRedirect();
        $jacocoInit[8] = true;
        handleAdyenUriResult();
        $jacocoInit[9] = true;
        handleErrorDismissEvent();
        $jacocoInit[10] = true;
        handleAdyenPaymentResult();
        $jacocoInit[11] = true;
        handleCancel();
        $jacocoInit[12] = true;
    }

    private void handleCancel() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2401Q q = C2401Q.f5564a;
        $jacocoInit[13] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) q);
        C2437na naVar = new C2437na(this);
        $jacocoInit[14] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) naVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[15] = true;
        C0120S a = f.mo3616a(v);
        C2454w wVar = new C2454w(this);
        $jacocoInit[16] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) wVar);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[17] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2415ca caVar = C2415ca.f5578a;
        C2453va vaVar = new C2453va(this);
        $jacocoInit[18] = true;
        a2.mo3626a((C0129b<? super T>) caVar, (C0129b<Throwable>) vaVar);
        $jacocoInit[19] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m7075i(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[199] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo11321j(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelEvent = this.view.cancelEvent();
        $jacocoInit[198] = true;
        return cancelEvent;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11303a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendAuthorizationCancelEvent(this.serviceName);
        $jacocoInit[196] = true;
        this.navigator.popView();
        $jacocoInit[197] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7065b(Void __) {
        $jacocoInit()[195] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11313e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[194] = true;
    }

    private void onViewCreatedCheckAuthorizationActive() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2391G g = C2391G.f5554a;
        $jacocoInit[20] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) g);
        C2418e eVar = new C2418e(this);
        $jacocoInit[21] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eVar);
        C2446s sVar = C2446s.f5609a;
        $jacocoInit[22] = true;
        C0120S e = f.mo3658e((C0132p<? super T, Boolean>) sVar);
        C2398N n = new C2398N(this);
        $jacocoInit[23] = true;
        C0120S b = e.mo3636b((C0129b<? super T>) n);
        C0126V v = this.viewScheduler;
        $jacocoInit[24] = true;
        C0120S a = b.mo3616a(v);
        C2399O o = new C2399O(this);
        $jacocoInit[25] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) o);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[26] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2432l lVar = C2432l.f5595a;
        C2451ua uaVar = new C2451ua(this);
        $jacocoInit[27] = true;
        a2.mo3626a((C0129b<? super T>) lVar, (C0129b<Throwable>) uaVar);
        $jacocoInit[28] = true;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m7080m(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[193] = true;
        return valueOf;
    }

    /* renamed from: n */
    public /* synthetic */ C0120S mo11327n(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[192] = true;
        return payment;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7058b(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(payment.isCompleted());
        $jacocoInit[191] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11307c(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendAuthorizationSuccessEvent(payment);
        $jacocoInit[190] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo11311d(Payment __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popView();
        $jacocoInit[189] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7057a(Payment __) {
        $jacocoInit()[188] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo11316g(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[187] = true;
    }

    private void onViewCreatedCheckAuthorizationFailed() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2385B b = C2385B.f5549a;
        $jacocoInit[29] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) b);
        C2413ba baVar = new C2413ba(this);
        $jacocoInit[30] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) baVar);
        C2424h hVar = C2424h.f5587a;
        $jacocoInit[31] = true;
        C0120S e = f.mo3658e((C0132p<? super T, Boolean>) hVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[32] = true;
        C0120S a = e.mo3616a(v);
        C2420f fVar = new C2420f(this);
        $jacocoInit[33] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) fVar);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[34] = true;
        C0120S a2 = b2.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2427ia iaVar = C2427ia.f5590a;
        C2386C c = new C2386C(this);
        $jacocoInit[35] = true;
        a2.mo3626a((C0129b<? super T>) iaVar, (C0129b<Throwable>) c);
        $jacocoInit[36] = true;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m7081o(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[186] = true;
        return valueOf;
    }

    /* renamed from: p */
    public /* synthetic */ C0120S mo11328p(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[185] = true;
        return payment;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7069e(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(payment.isFailed());
        $jacocoInit[184] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ void mo11315f(Payment __) {
        boolean[] $jacocoInit = $jacocoInit();
        popViewWithError();
        $jacocoInit[183] = true;
    }

    /* renamed from: g */
    static /* synthetic */ void m7073g(Payment __) {
        $jacocoInit()[182] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo11318h(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[181] = true;
    }

    private void onViewCreatedCheckAuthorizationProcessing() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2430k kVar = C2430k.f5593a;
        $jacocoInit[37] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kVar);
        C2395K k = new C2395K(this);
        $jacocoInit[38] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) k);
        C2422g gVar = C2422g.f5585a;
        $jacocoInit[39] = true;
        C0120S d2 = f.mo3653d((C0132p<? super T, Boolean>) gVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[40] = true;
        C0120S a = d2.mo3616a(v);
        C2426i iVar = new C2426i(this);
        $jacocoInit[41] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) iVar);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[42] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2456y yVar = C2456y.f5619a;
        C2392H h = new C2392H(this);
        $jacocoInit[43] = true;
        a2.mo3626a((C0129b<? super T>) yVar, (C0129b<Throwable>) h);
        $jacocoInit[44] = true;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m7082q(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[180] = true;
        return valueOf;
    }

    /* renamed from: r */
    public /* synthetic */ C0120S mo11329r(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[179] = true;
        return payment;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m7074h(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(payment.isProcessing());
        $jacocoInit[178] = true;
        return valueOf;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11319i(Payment __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[177] = true;
    }

    /* renamed from: j */
    static /* synthetic */ void m7076j(Payment __) {
        $jacocoInit()[176] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11320i(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[175] = true;
    }

    private void handleAdyenCreditCardResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2404U u = C2404U.f5567a;
        $jacocoInit[45] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) u);
        C2444r rVar = new C2444r(this);
        $jacocoInit[46] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        C2443qa qaVar = new C2443qa(this);
        $jacocoInit[47] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) qaVar);
        C2397M m = new C2397M(this);
        $jacocoInit[48] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) m);
        C0126V v = this.viewScheduler;
        $jacocoInit[49] = true;
        C0120S a = g.mo3616a(v);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[50] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2435ma maVar = C2435ma.f5598a;
        C2406W w = new C2406W(this);
        $jacocoInit[51] = true;
        a2.mo3626a((C0129b<? super T>) maVar, (C0129b<Throwable>) w);
        $jacocoInit[52] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7056a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[174] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11305b(LifecycleEvent authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S creditCardDetailsEvent = this.view.creditCardDetailsEvent();
        $jacocoInit[173] = true;
        return creditCardDetailsEvent;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11299a(C6884d __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[172] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo11304b(C6884d details) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M finishPayment = this.f44402adyen.finishPayment(details);
        $jacocoInit[171] = true;
        return finishPayment;
    }

    /* renamed from: c */
    static /* synthetic */ void m7067c(C6884d __) {
        $jacocoInit()[170] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11302a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[169] = true;
    }

    private void handleAdyenUriRedirect() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2447sa saVar = C2447sa.f5610a;
        $jacocoInit[53] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) saVar);
        C2409Z z = new C2409Z(this);
        $jacocoInit[54] = true;
        C0120S i = d.mo3668i(z);
        C0126V v = this.viewScheduler;
        $jacocoInit[55] = true;
        C0120S a = i.mo3616a(v);
        C2405V v2 = new C2405V(this);
        $jacocoInit[56] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) v2);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[57] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2423ga gaVar = C2423ga.f5586a;
        C2400P p = new C2400P(this);
        $jacocoInit[58] = true;
        a2.mo3626a((C0129b<? super T>) gaVar, (C0129b<Throwable>) p);
        $jacocoInit[59] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7070e(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[168] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ Single mo11314f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single redirectUrl = this.f44402adyen.getRedirectUrl();
        $jacocoInit[167] = true;
        return redirectUrl;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11301a(String redirectUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[165] = true;
        this.navigator.navigateToUriForResult(redirectUrl);
        $jacocoInit[166] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7064b(String __) {
        $jacocoInit()[164] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11308c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[163] = true;
    }

    private void handleAdyenUriResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2396L l = C2396L.f5559a;
        $jacocoInit[60] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) l);
        C2388D d2 = new C2388D(this);
        $jacocoInit[61] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) d2);
        C2393I i = new C2393I(this);
        $jacocoInit[62] = true;
        C0120S g = f.mo3663g((C0132p<? super T, ? extends C0117M>) i);
        C0126V v = this.viewScheduler;
        $jacocoInit[63] = true;
        C0120S a = g.mo3616a(v);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[64] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2403T t = C2403T.f5566a;
        C2417da daVar = new C2417da(this);
        $jacocoInit[65] = true;
        a2.mo3626a((C0129b<? super T>) t, (C0129b<Throwable>) daVar);
        $jacocoInit[66] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m7072g(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[162] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo11317h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S uriResults = this.navigator.uriResults();
        $jacocoInit[161] = true;
        return uriResults;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11295a(Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M finishUri = this.f44402adyen.finishUri(uri);
        $jacocoInit[160] = true;
        return finishUri;
    }

    /* renamed from: b */
    static /* synthetic */ void m7059b(Uri __) {
        $jacocoInit()[159] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo11312d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[158] = true;
    }

    private void handleAdyenPaymentResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2389E e = C2389E.f5552a;
        $jacocoInit[67] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) e);
        C2452v vVar = new C2452v(this);
        $jacocoInit[68] = true;
        C0120S i = d.mo3668i(vVar);
        C2440p pVar = new C2440p(this);
        $jacocoInit[69] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) pVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[70] = true;
        C0120S a = g.mo3616a(v);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[71] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2407X x = C2407X.f5570a;
        C2428j jVar = new C2428j(this);
        $jacocoInit[72] = true;
        a2.mo3626a((C0129b<? super T>) x, (C0129b<Throwable>) jVar);
        $jacocoInit[73] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7066c(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[157] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo11310d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single paymentResult = this.f44402adyen.getPaymentResult();
        $jacocoInit[156] = true;
        return paymentResult;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11298a(C6896i result) {
        boolean[] $jacocoInit = $jacocoInit();
        if (result.mo22345c()) {
            $jacocoInit[151] = true;
            Billing billing2 = this.billing;
            String str = this.sku;
            C6886b b = result.mo22344b();
            $jacocoInit[152] = true;
            String a = b.mo22324a();
            $jacocoInit[153] = true;
            C0117M authorize = billing2.authorize(str, a);
            $jacocoInit[154] = true;
            return authorize;
        }
        C0117M b2 = C0117M.m591b(result.mo22343a());
        $jacocoInit[155] = true;
        return b2;
    }

    /* renamed from: b */
    static /* synthetic */ void m7062b(C6896i __) {
        $jacocoInit()[150] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11306b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[149] = true;
    }

    private void onViewCreatedShowCreditCardInputView() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2434m mVar = C2434m.f5597a;
        $jacocoInit[74] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) mVar);
        C2411aa aaVar = new C2411aa(this);
        $jacocoInit[75] = true;
        C0120S i = d.mo3668i(aaVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[76] = true;
        C0120S a = i.mo3616a(v);
        C2442q qVar = new C2442q(this);
        $jacocoInit[77] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) qVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[78] = true;
        C0120S a2 = b.mo3616a(v2);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[79] = true;
        C0120S a3 = a2.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2419ea eaVar = C2419ea.f5582a;
        C2439oa oaVar = new C2439oa(this);
        $jacocoInit[80] = true;
        a3.mo3626a((C0129b<? super T>) eaVar, (C0129b<Throwable>) oaVar);
        $jacocoInit[81] = true;
    }

    /* renamed from: x */
    static /* synthetic */ Boolean m7085x(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[148] = true;
        return valueOf;
    }

    /* renamed from: y */
    public /* synthetic */ Single mo11333y(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single paymentData = this.f44402adyen.getPaymentData();
        $jacocoInit[147] = true;
        return paymentData;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11300a(C6919k data) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        this.view.hideLoading();
        $jacocoInit[136] = true;
        C6889d d = data.mo22377d();
        $jacocoInit[137] = true;
        String h = d.mo22335h();
        $jacocoInit[138] = true;
        if (h.equals("card")) {
            $jacocoInit[139] = true;
            CreditCardAuthorizationView creditCardAuthorizationView = this.view;
            C6889d d2 = data.mo22377d();
            C6878a b = data.mo22375b();
            $jacocoInit[140] = true;
            if (data.mo22379f() != null) {
                $jacocoInit[141] = true;
                z = true;
            } else {
                $jacocoInit[142] = true;
                z = false;
            }
            String e = data.mo22378e();
            String c = data.mo22376c();
            $jacocoInit[143] = true;
            creditCardAuthorizationView.showCreditCardView(d2, b, true, z, e, c);
            $jacocoInit[144] = true;
        } else {
            this.view.showCvcView(data.mo22375b(), data.mo22377d());
            $jacocoInit[145] = true;
        }
        $jacocoInit[146] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7063b(C6919k __) {
        $jacocoInit()[135] = true;
    }

    /* renamed from: l */
    public /* synthetic */ void mo11326l(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[134] = true;
    }

    private void onViewCreatedSelectCreditCardPayment() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2445ra raVar = C2445ra.f5608a;
        $jacocoInit[82] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) raVar);
        C2457z zVar = new C2457z(this);
        $jacocoInit[83] = true;
        C0120S i = d.mo3668i(zVar);
        C2455x xVar = new C2455x(this);
        $jacocoInit[84] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) xVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[85] = true;
        C0120S a = g.mo3616a(v);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[86] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2438o oVar = C2438o.f5601a;
        C2441pa paVar = new C2441pa(this);
        $jacocoInit[87] = true;
        a2.mo3626a((C0129b<? super T>) oVar, (C0129b<Throwable>) paVar);
        $jacocoInit[88] = true;
    }

    /* renamed from: v */
    static /* synthetic */ Boolean m7084v(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[133] = true;
        return valueOf;
    }

    /* renamed from: w */
    public /* synthetic */ Single mo11332w(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single creditCardPaymentService = this.f44402adyen.getCreditCardPaymentService();
        $jacocoInit[132] = true;
        return creditCardPaymentService;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11297a(C6889d creditCard) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M selectPaymentService = this.f44402adyen.selectPaymentService(creditCard);
        $jacocoInit[131] = true;
        return selectPaymentService;
    }

    /* renamed from: b */
    static /* synthetic */ void m7061b(C6889d __) {
        $jacocoInit()[130] = true;
    }

    /* renamed from: k */
    public /* synthetic */ void mo11324k(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[129] = true;
    }

    private void onViewCreatedCreatePayment() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2436n nVar = C2436n.f5599a;
        $jacocoInit[89] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nVar);
        C2390F f = new C2390F(this);
        $jacocoInit[90] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) f);
        C2425ha haVar = new C2425ha(this);
        $jacocoInit[91] = true;
        C0120S f2 = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) haVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[92] = true;
        C0120S a = f2.mo3616a(v);
        C2448t tVar = new C2448t(this);
        $jacocoInit[93] = true;
        C0120S b2 = a.mo3636b((C0129b<? super T>) tVar);
        C2421fa faVar = C2421fa.f5584a;
        $jacocoInit[94] = true;
        C0120S e = b2.mo3658e((C0132p<? super T, Boolean>) faVar);
        C2394J j = C2394J.f5557a;
        $jacocoInit[95] = true;
        $jacocoInit[96] = true;
        C0120S a2 = e.mo3669j(j).mo3611a(AdyenAuthorization.class);
        C2449ta taVar = new C2449ta(this);
        $jacocoInit[97] = true;
        C0120S g = a2.mo3663g((C0132p<? super T, ? extends C0117M>) taVar);
        C0126V v2 = this.viewScheduler;
        $jacocoInit[98] = true;
        C0120S a3 = g.mo3616a(v2);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[99] = true;
        C0120S a4 = a3.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2433la laVar = C2433la.f5596a;
        C2408Y y = new C2408Y(this);
        $jacocoInit[100] = true;
        a4.mo3626a((C0129b<? super T>) laVar, (C0129b<Throwable>) y);
        $jacocoInit[101] = true;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m7083s(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[128] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ void mo11330t(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showLoading();
        $jacocoInit[127] = true;
    }

    /* renamed from: u */
    public /* synthetic */ C0120S mo11331u(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S payment = this.billing.getPayment(this.sku);
        $jacocoInit[126] = true;
        return payment;
    }

    /* renamed from: k */
    public /* synthetic */ void mo11323k(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showProduct(payment.getProduct());
        $jacocoInit[125] = true;
    }

    /* renamed from: l */
    static /* synthetic */ Boolean m7078l(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(payment.isPendingAuthorization());
        $jacocoInit[124] = true;
        return valueOf;
    }

    /* renamed from: m */
    static /* synthetic */ Authorization m7079m(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Authorization authorization = payment.getAuthorization();
        $jacocoInit[123] = true;
        return authorization;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11296a(AdyenAuthorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M createPayment = this.f44402adyen.createPayment(authorization.getSession());
        $jacocoInit[122] = true;
        return createPayment;
    }

    /* renamed from: b */
    static /* synthetic */ void m7060b(AdyenAuthorization __) {
        $jacocoInit()[121] = true;
    }

    /* renamed from: j */
    public /* synthetic */ void mo11322j(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showError(throwable);
        $jacocoInit[120] = true;
    }

    private void handleErrorDismissEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C2450u uVar = C2450u.f5613a;
        $jacocoInit[102] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) uVar);
        C2402S s = new C2402S(this);
        $jacocoInit[103] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) s);
        C2429ja jaVar = new C2429ja(this);
        $jacocoInit[104] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) jaVar);
        CreditCardAuthorizationView creditCardAuthorizationView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[105] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) creditCardAuthorizationView.bindUntilEvent(lifecycleEvent2));
        C2431ka kaVar = C2431ka.f5594a;
        C2384A a2 = C2384A.f5548a;
        $jacocoInit[106] = true;
        a.mo3626a((C0129b<? super T>) kaVar, (C0129b<Throwable>) a2);
        $jacocoInit[107] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m7077k(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[119] = true;
        return valueOf;
    }

    /* renamed from: l */
    public /* synthetic */ C0120S mo11325l(LifecycleEvent created) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S errorDismisses = this.view.errorDismisses();
        $jacocoInit[118] = true;
        return errorDismisses;
    }

    /* renamed from: c */
    public /* synthetic */ void mo11309c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        popViewWithError();
        $jacocoInit[117] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m7068d(Void __) {
        $jacocoInit()[116] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m7071f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        $jacocoInit[115] = true;
        throw onErrorNotImplementedException;
    }

    private void showError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof IOException) {
            $jacocoInit[108] = true;
            this.view.hideLoading();
            $jacocoInit[109] = true;
            this.view.showNetworkError();
            $jacocoInit[110] = true;
        } else {
            popViewWithError();
            $jacocoInit[111] = true;
        }
        $jacocoInit[112] = true;
    }

    private void popViewWithError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendAuthorizationErrorEvent(this.serviceName);
        $jacocoInit[113] = true;
        this.navigator.popView();
        $jacocoInit[114] = true;
    }
}
