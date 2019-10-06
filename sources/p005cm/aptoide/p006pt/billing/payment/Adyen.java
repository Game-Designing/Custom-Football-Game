package p005cm.aptoide.p006pt.billing.payment;

import android.content.Context;
import android.net.Uri;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p022i.p023b.C0100e;
import p019d.p135a.p136a.C6919k;
import p019d.p135a.p136a.p137a.C6846b;
import p019d.p135a.p136a.p137a.C6847c;
import p019d.p135a.p136a.p137a.C6849e;
import p019d.p135a.p136a.p137a.C6850f;
import p019d.p135a.p136a.p137a.C6851g;
import p019d.p135a.p136a.p137a.C6854i;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.C6896i;
import p019d.p135a.p136a.p139c.p140a.C6881c;
import p019d.p135a.p136a.p139c.p140a.C6884d;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.payment.Adyen */
public class Adyen {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;
    private final Charset dataCharset;
    private DetailsStatus detailsStatus;
    private C6919k paymentRequest;
    private PaymentStatus paymentStatus;
    private final C0126V scheduler;
    private C0100e<AdyenPaymentStatus> status;

    /* renamed from: cm.aptoide.pt.billing.payment.Adyen$DetailsStatus */
    public static class DetailsStatus implements C6850f {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private C6847c detailsCallback;
        private C6919k paymentRequest;
        private List<C6889d> recurringServices;
        private String redirectUrl;
        private C6849e serviceCallback;
        private List<C6889d> services;
        private C0100e<AdyenPaymentStatus> status;
        private C6854i uriCallback;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-6694142361165497413L, "cm/aptoide/pt/billing/payment/Adyen$DetailsStatus", 24);
            $jacocoData = probes;
            return probes;
        }

        public DetailsStatus(C0100e<AdyenPaymentStatus> status2, List<C6889d> services2, List<C6889d> recurringServices2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = status2;
            this.services = services2;
            this.recurringServices = recurringServices2;
            $jacocoInit[0] = true;
        }

        public void onPaymentMethodSelectionRequired(C6919k paymentRequest2, List<C6889d> recurringServices2, List<C6889d> otherServices, C6849e paymentMethodCallback) {
            List<C6889d> list;
            List<C6889d> list2;
            boolean[] $jacocoInit = $jacocoInit();
            this.serviceCallback = paymentMethodCallback;
            if (recurringServices2 != null) {
                $jacocoInit[1] = true;
                list = recurringServices2;
            } else {
                list = Collections.emptyList();
                $jacocoInit[2] = true;
            }
            this.recurringServices = list;
            $jacocoInit[3] = true;
            if (otherServices != null) {
                $jacocoInit[4] = true;
                list2 = otherServices;
            } else {
                list2 = Collections.emptyList();
                $jacocoInit[5] = true;
            }
            this.services = list2;
            $jacocoInit[6] = true;
            notifyStatus();
            $jacocoInit[7] = true;
        }

        public void onRedirectRequired(C6919k paymentRequest2, String redirectUrl2, C6854i uriCallback2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.uriCallback = uriCallback2;
            this.redirectUrl = redirectUrl2;
            $jacocoInit[8] = true;
            notifyStatus();
            $jacocoInit[9] = true;
        }

        public void onPaymentDetailsRequired(C6919k paymentRequest2, Collection<C6881c> collection, C6847c paymentDetailsCallback) {
            boolean[] $jacocoInit = $jacocoInit();
            this.detailsCallback = paymentDetailsCallback;
            this.paymentRequest = paymentRequest2;
            $jacocoInit[10] = true;
            notifyStatus();
            $jacocoInit[11] = true;
        }

        public C6849e getServiceCallback() {
            boolean[] $jacocoInit = $jacocoInit();
            C6849e eVar = this.serviceCallback;
            $jacocoInit[12] = true;
            return eVar;
        }

        public List<C6889d> getServices() {
            boolean[] $jacocoInit = $jacocoInit();
            List<C6889d> list = this.services;
            $jacocoInit[13] = true;
            return list;
        }

        public C6847c getDetailsCallback() {
            boolean[] $jacocoInit = $jacocoInit();
            C6847c cVar = this.detailsCallback;
            $jacocoInit[14] = true;
            return cVar;
        }

        public C6919k getPaymentRequest() {
            boolean[] $jacocoInit = $jacocoInit();
            C6919k kVar = this.paymentRequest;
            $jacocoInit[15] = true;
            return kVar;
        }

        public List<C6889d> getRecurringServices() {
            boolean[] $jacocoInit = $jacocoInit();
            List<C6889d> list = this.recurringServices;
            $jacocoInit[16] = true;
            return list;
        }

        public C6854i getUriCallback() {
            boolean[] $jacocoInit = $jacocoInit();
            C6854i iVar = this.uriCallback;
            $jacocoInit[17] = true;
            return iVar;
        }

        public String getRedirectUrl() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.redirectUrl;
            $jacocoInit[18] = true;
            return str;
        }

        public void clearStatus() {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = null;
            $jacocoInit[19] = true;
        }

        private void notifyStatus() {
            boolean[] $jacocoInit = $jacocoInit();
            C0100e<AdyenPaymentStatus> eVar = this.status;
            if (eVar == null) {
                $jacocoInit[20] = true;
            } else {
                $jacocoInit[21] = true;
                eVar.call(null);
                $jacocoInit[22] = true;
            }
            $jacocoInit[23] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.billing.payment.Adyen$PaymentStatus */
    public static class PaymentStatus implements C6851g {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private C6846b dataCallback;
        private C6896i result;
        private C0100e<AdyenPaymentStatus> status;
        private String token;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6646001524479270922L, "cm/aptoide/pt/billing/payment/Adyen$PaymentStatus", 13);
            $jacocoData = probes;
            return probes;
        }

        public PaymentStatus(C0100e<AdyenPaymentStatus> status2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = status2;
            $jacocoInit[0] = true;
        }

        public void onPaymentDataRequested(C6919k paymentRequest, String token2, C6846b paymentDataCallback) {
            boolean[] $jacocoInit = $jacocoInit();
            this.token = token2;
            this.dataCallback = paymentDataCallback;
            $jacocoInit[1] = true;
            notifyStatus();
            $jacocoInit[2] = true;
        }

        public void onPaymentResult(C6919k paymentRequest, C6896i paymentRequestResult) {
            boolean[] $jacocoInit = $jacocoInit();
            this.result = paymentRequestResult;
            $jacocoInit[3] = true;
            notifyStatus();
            $jacocoInit[4] = true;
        }

        public String getToken() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.token;
            $jacocoInit[5] = true;
            return str;
        }

        public C6846b getDataCallback() {
            boolean[] $jacocoInit = $jacocoInit();
            C6846b bVar = this.dataCallback;
            $jacocoInit[6] = true;
            return bVar;
        }

        public C6896i getResult() {
            boolean[] $jacocoInit = $jacocoInit();
            C6896i iVar = this.result;
            $jacocoInit[7] = true;
            return iVar;
        }

        public void clearStatus() {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = null;
            $jacocoInit[8] = true;
        }

        private void notifyStatus() {
            boolean[] $jacocoInit = $jacocoInit();
            C0100e<AdyenPaymentStatus> eVar = this.status;
            if (eVar == null) {
                $jacocoInit[9] = true;
            } else {
                $jacocoInit[10] = true;
                eVar.call(null);
                $jacocoInit[11] = true;
            }
            $jacocoInit[12] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8846845152216870548L, "cm/aptoide/pt/billing/payment/Adyen", 96);
        $jacocoData = probes;
        return probes;
    }

    public Adyen(Context context2, Charset dataCharset2, C0126V scheduler2, C0100e<AdyenPaymentStatus> paymentRequestStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.dataCharset = dataCharset2;
        this.scheduler = scheduler2;
        this.status = paymentRequestStatus;
        $jacocoInit[0] = true;
    }

    public Single<String> createToken() {
        boolean[] $jacocoInit = $jacocoInit();
        cancelPreviousToken();
        $jacocoInit[1] = true;
        C0120S d = getStatus().mo3653d((C0132p<? super T, Boolean>) C2348n.f5485a);
        C2342h hVar = C2342h.f5479a;
        $jacocoInit[2] = true;
        C0120S j = d.mo3669j(hVar);
        $jacocoInit[3] = true;
        C0120S d2 = j.mo3647d();
        $jacocoInit[4] = true;
        Single<String> n = d2.mo3678n();
        $jacocoInit[5] = true;
        return n;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m171a(AdyenPaymentStatus status2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getToken() != null) {
            $jacocoInit[93] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[94] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[95] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ String m176b(AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        String token = status2.getToken();
        $jacocoInit[92] = true;
        return token;
    }

    public C0117M createPayment(String session) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getStatus().mo3647d();
        $jacocoInit[6] = true;
        Single n = d.mo3678n();
        C2341g gVar = new C2341g(this, session);
        $jacocoInit[7] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) gVar);
        $jacocoInit[8] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo877a(String session, AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getDataCallback() == null) {
            $jacocoInit[87] = true;
            C0117M b = C0117M.m591b((Throwable) new IllegalStateException("Not possible to create payment no callback available."));
            $jacocoInit[88] = true;
            return b;
        }
        C6846b dataCallback = status2.getDataCallback();
        Charset charset = this.dataCharset;
        $jacocoInit[89] = true;
        dataCallback.mo22279a(session.getBytes(charset));
        $jacocoInit[90] = true;
        C0117M b2 = C0117M.m590b();
        $jacocoInit[91] = true;
        return b2;
    }

    public C0117M selectPaymentService(C6889d service) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getStatus().mo3647d();
        $jacocoInit[9] = true;
        Single n = d.mo3678n();
        C2337c cVar = new C2337c(service);
        $jacocoInit[10] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) cVar);
        $jacocoInit[11] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m175a(C6889d service, AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getServiceCallback() == null) {
            $jacocoInit[82] = true;
            C0117M b = C0117M.m591b((Throwable) new IllegalStateException("Not possible to select payment service no callback available."));
            $jacocoInit[83] = true;
            return b;
        }
        C6849e serviceCallback = status2.getServiceCallback();
        $jacocoInit[84] = true;
        serviceCallback.mo22282a(service);
        $jacocoInit[85] = true;
        C0117M b2 = C0117M.m590b();
        $jacocoInit[86] = true;
        return b2;
    }

    public C0117M finishUri(Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getStatus().mo3647d();
        $jacocoInit[12] = true;
        Single n = d.mo3678n();
        C2343i iVar = new C2343i(uri);
        $jacocoInit[13] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) iVar);
        $jacocoInit[14] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m173a(Uri uri, AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getUriCallback() == null) {
            $jacocoInit[77] = true;
            C0117M b = C0117M.m591b((Throwable) new IllegalStateException("Not possible to select payment service no callback available."));
            $jacocoInit[78] = true;
            return b;
        }
        C6854i uriCallback = status2.getUriCallback();
        $jacocoInit[79] = true;
        uriCallback.mo22286a(uri);
        $jacocoInit[80] = true;
        C0117M b2 = C0117M.m590b();
        $jacocoInit[81] = true;
        return b2;
    }

    public C0117M finishPayment(C6884d details) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getStatus().mo3647d();
        $jacocoInit[15] = true;
        Single n = d.mo3678n();
        C2347m mVar = new C2347m(details);
        $jacocoInit[16] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) mVar);
        $jacocoInit[17] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m174a(C6884d details, AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getDetailsCallback() == null) {
            $jacocoInit[72] = true;
            C0117M b = C0117M.m591b((Throwable) new IllegalStateException("Not possible to finish payment with details no callback available."));
            $jacocoInit[73] = true;
            return b;
        }
        C6847c detailsCallback = status2.getDetailsCallback();
        $jacocoInit[74] = true;
        detailsCallback.mo22280a(details);
        $jacocoInit[75] = true;
        C0117M b2 = C0117M.m590b();
        $jacocoInit[76] = true;
        return b2;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m179f(AdyenPaymentStatus status2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getResult() != null) {
            $jacocoInit[69] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[70] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[71] = true;
        return valueOf;
    }

    public Single<C6896i> getPaymentResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getStatus().mo3653d((C0132p<? super T, Boolean>) C2349o.f5486a);
        C2336b bVar = C2336b.f5472a;
        $jacocoInit[18] = true;
        C0120S j = d.mo3669j(bVar);
        $jacocoInit[19] = true;
        C0120S d2 = j.mo3647d();
        $jacocoInit[20] = true;
        Single<C6896i> n = d2.mo3678n();
        $jacocoInit[21] = true;
        return n;
    }

    /* renamed from: g */
    static /* synthetic */ C6896i m180g(AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        C6896i result = status2.getResult();
        $jacocoInit[68] = true;
        return result;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m177d(AdyenPaymentStatus status2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getPaymentRequest() != null) {
            $jacocoInit[65] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[66] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[67] = true;
        return valueOf;
    }

    public Single<C6919k> getPaymentData() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getStatus().mo3653d((C0132p<? super T, Boolean>) C2340f.f5476a);
        C2339e eVar = C2339e.f5475a;
        $jacocoInit[22] = true;
        C0120S j = d.mo3669j(eVar);
        $jacocoInit[23] = true;
        C0120S d2 = j.mo3647d();
        $jacocoInit[24] = true;
        Single<C6919k> n = d2.mo3678n();
        $jacocoInit[25] = true;
        return n;
    }

    /* renamed from: e */
    static /* synthetic */ C6919k m178e(AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        C6919k paymentRequest2 = status2.getPaymentRequest();
        $jacocoInit[64] = true;
        return paymentRequest2;
    }

    /* renamed from: h */
    static /* synthetic */ Boolean m181h(AdyenPaymentStatus status2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (status2.getRedirectUrl() != null) {
            $jacocoInit[61] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[62] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[63] = true;
        return valueOf;
    }

    public Single<String> getRedirectUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getStatus().mo3653d((C0132p<? super T, Boolean>) C2344j.f5481a);
        C2335a aVar = C2335a.f5471a;
        $jacocoInit[26] = true;
        C0120S j = d.mo3669j(aVar);
        $jacocoInit[27] = true;
        C0120S d2 = j.mo3647d();
        $jacocoInit[28] = true;
        Single<String> n = d2.mo3678n();
        $jacocoInit[29] = true;
        return n;
    }

    /* renamed from: i */
    static /* synthetic */ String m182i(AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        String redirectUrl = status2.getRedirectUrl();
        $jacocoInit[60] = true;
        return redirectUrl;
    }

    public Single<C6889d> getCreditCardPaymentService() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = getStatus().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2338d<Object,Object>(this));
        $jacocoInit[30] = true;
        C0120S d = f.mo3647d();
        $jacocoInit[31] = true;
        Single<C6889d> n = d.mo3678n();
        $jacocoInit[32] = true;
        return n;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo878c(AdyenPaymentStatus status2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S recurringPaymentService = getRecurringPaymentService(status2.getRecurringServices());
        $jacocoInit[57] = true;
        C0120S paymentService = getPaymentService(status2.getServices(), "card");
        $jacocoInit[58] = true;
        C0120S f = recurringPaymentService.mo3659f(paymentService);
        $jacocoInit[59] = true;
        return f;
    }

    private C0120S<C6889d> getPaymentService(List<C6889d> services, String paymentType) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) services);
        C2346l lVar = new C2346l(paymentType);
        $jacocoInit[33] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) lVar);
        $jacocoInit[34] = true;
        C0120S<C6889d> b = d.mo3629b(1);
        $jacocoInit[35] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m172a(String paymentType, C6889d service) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(paymentType.equals(service.mo22335h()));
        $jacocoInit[56] = true;
        return valueOf;
    }

    private C0120S<C6889d> getRecurringPaymentService(List<C6889d> services) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) services);
        $jacocoInit[36] = true;
        C0120S<C6889d> b = a.mo3629b(1);
        $jacocoInit[37] = true;
        return b;
    }

    private C0120S<AdyenPaymentStatus> getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S e = this.status.mo3656e(null);
        C2345k kVar = new C2345k(this);
        $jacocoInit[38] = true;
        C0120S j = e.mo3669j(kVar);
        C0126V v = this.scheduler;
        $jacocoInit[39] = true;
        C0120S<AdyenPaymentStatus> b = j.mo3634b(v);
        $jacocoInit[40] = true;
        return b;
    }

    /* renamed from: j */
    public /* synthetic */ AdyenPaymentStatus mo887j(AdyenPaymentStatus event) {
        boolean[] $jacocoInit = $jacocoInit();
        String token = this.paymentStatus.getToken();
        PaymentStatus paymentStatus2 = this.paymentStatus;
        $jacocoInit[50] = true;
        C6846b dataCallback = paymentStatus2.getDataCallback();
        C6896i result = this.paymentStatus.getResult();
        DetailsStatus detailsStatus2 = this.detailsStatus;
        $jacocoInit[51] = true;
        C6849e serviceCallback = detailsStatus2.getServiceCallback();
        List recurringServices = this.detailsStatus.getRecurringServices();
        DetailsStatus detailsStatus3 = this.detailsStatus;
        $jacocoInit[52] = true;
        List services = detailsStatus3.getServices();
        C6847c detailsCallback = this.detailsStatus.getDetailsCallback();
        DetailsStatus detailsStatus4 = this.detailsStatus;
        $jacocoInit[53] = true;
        C6919k paymentRequest2 = detailsStatus4.getPaymentRequest();
        String redirectUrl = this.detailsStatus.getRedirectUrl();
        DetailsStatus detailsStatus5 = this.detailsStatus;
        $jacocoInit[54] = true;
        AdyenPaymentStatus adyenPaymentStatus = new AdyenPaymentStatus(token, dataCallback, result, serviceCallback, recurringServices, services, detailsCallback, paymentRequest2, redirectUrl, detailsStatus5.getUriCallback());
        $jacocoInit[55] = true;
        return adyenPaymentStatus;
    }

    private void cancelPreviousToken() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.paymentRequest == null) {
            $jacocoInit[41] = true;
        } else {
            $jacocoInit[42] = true;
            this.detailsStatus.clearStatus();
            $jacocoInit[43] = true;
            this.paymentStatus.clearStatus();
            $jacocoInit[44] = true;
            this.paymentRequest.mo22374a();
            $jacocoInit[45] = true;
        }
        this.paymentStatus = new PaymentStatus(this.status);
        $jacocoInit[46] = true;
        this.detailsStatus = new DetailsStatus(this.status, Collections.emptyList(), Collections.emptyList());
        $jacocoInit[47] = true;
        this.paymentRequest = new C6919k(this.context, this.paymentStatus, this.detailsStatus);
        $jacocoInit[48] = true;
        this.paymentRequest.mo22380g();
        $jacocoInit[49] = true;
    }
}
