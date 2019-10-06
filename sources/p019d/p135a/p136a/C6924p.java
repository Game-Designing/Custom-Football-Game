package p019d.p135a.p136a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p000v4.content.C0515e;
import android.util.Log;
import com.adyen.core.exceptions.UIModuleNotAvailableException;
import com.adyen.core.models.PaymentMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p135a.p136a.p137a.C6845a;
import p019d.p135a.p136a.p137a.C6850f;
import p019d.p135a.p136a.p137a.C6851g;
import p019d.p135a.p136a.p137a.C6852h;
import p019d.p135a.p136a.p137a.C6852h.C6853a;
import p019d.p135a.p136a.p137a.C6854i;
import p019d.p135a.p136a.p138b.C6860e;
import p019d.p135a.p136a.p138b.C6862g;
import p019d.p135a.p136a.p138b.C6874s;
import p019d.p135a.p136a.p138b.C6875t;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.C6896i;
import p019d.p135a.p136a.p139c.C6897j;
import p019d.p135a.p136a.p139c.p140a.C6881c;
import p019d.p135a.p136a.p139c.p140a.C6884d;
import p019d.p135a.p136a.p142e.C6904d;
import p019d.p135a.p136a.p142e.C6913k;
import p320f.p321a.p326c.C13204f;

/* renamed from: d.a.a.p */
/* compiled from: PaymentStateHandler */
class C6924p implements C6853a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12713a = C6924p.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Throwable f12714b;

    /* renamed from: c */
    private C6851g f12715c;

    /* renamed from: d */
    private C6850f f12716d;

    /* renamed from: e */
    private ArrayList<C6850f> f12717e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<C6851g> f12718f = new ArrayList<>();

    /* renamed from: g */
    private C6897j f12719g;

    /* renamed from: h */
    private Context f12720h;

    /* renamed from: i */
    private C6889d f12721i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public JSONObject f12722j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C6896i f12723k;

    /* renamed from: l */
    private C6919k f12724l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public List<C6889d> f12725m;

    /* renamed from: n */
    private List<C6889d> f12726n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C6862g f12727o;

    /* renamed from: p */
    private C6918j f12728p;

    /* renamed from: q */
    private C6884d f12729q;
    @Deprecated

    /* renamed from: r */
    private Map<String, Object> f12730r;

    /* renamed from: s */
    private C6854i f12731s = new C6922n(this);

    C6924p(Context context, C6919k paymentRequest, C6851g paymentRequestListener, C6850f paymentRequestDetailsListener) {
        this.f12720h = context;
        this.f12724l = paymentRequest;
        this.f12715c = paymentRequestListener;
        this.f12716d = paymentRequestDetailsListener;
        this.f12728p = new C6918j(this, paymentRequest);
        this.f12725m = new ArrayList();
        this.f12727o = new C6862g(this);
        this.f12718f.add(paymentRequestListener);
        if (paymentRequestDetailsListener != null) {
            this.f12717e.add(paymentRequestDetailsListener);
            return;
        }
        try {
            this.f12717e.add(C6855b.m13930a(context));
            this.f12718f.add(C6855b.m13932b(context));
        } catch (UIModuleNotAvailableException e) {
            mo22385a((Throwable) e);
        }
    }

    /* renamed from: b */
    public void mo22285b(C6852h state) {
        String str = f12713a;
        StringBuilder sb = new StringBuilder();
        sb.append("onStateChanged: ");
        sb.append(state.toString());
        Log.d(str, sb.toString());
        switch (C6923o.f12712a[((C6874s) state).ordinal()]) {
            case 1:
                Log.d(f12713a, "Waiting for client to provide payment data.");
                m14102q();
                return;
            case 2:
                Log.d(f12713a, "Fetching and filtering the available payment methods");
                m14097l();
                return;
            case 3:
                Log.d(f12713a, "Waiting for user to select payment method.");
                m14104s();
                return;
            case 4:
                Log.d(f12713a, "Waiting for payment details (The selected payment method requires additional information)");
                m14103r();
                return;
            case 5:
                Log.d(f12713a, "Processing payment.");
                m14101p();
                return;
            case 6:
                Log.d(f12713a, "Waiting for redirection.");
                m14098m();
                return;
            case 7:
                Log.d(f12713a, "Payment processed.");
                m14105t();
                m14100o();
                return;
            case 8:
                Log.d(f12713a, "Payment aborted.");
                m14105t();
                m14099n();
                return;
            case 9:
                Log.d(f12713a, "Payment cancelled.");
                this.f12723k = new C6896i(new Throwable("Cancelled"));
                m14100o();
                C0515e.m2597a(this.f12720h).mo5314a(new Intent("com.adyen.core.ui.finish"));
                m14105t();
                return;
            default:
                String str2 = f12713a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected state: ");
                sb2.append(state.toString());
                Log.e(str2, sb2.toString());
                this.f12714b = new IllegalStateException("Internal error - payment request state machine failure.");
                m14105t();
                m14099n();
                return;
        }
    }

    /* renamed from: a */
    public void mo22284a(C6852h state) {
        String str = f12713a;
        StringBuilder sb = new StringBuilder();
        sb.append("onStateNotChanged: ");
        sb.append(state.toString());
        Log.d(str, sb.toString());
        if (C6923o.f12712a[((C6874s) state).ordinal()] != 4) {
            Log.d(f12713a, "No action will be taken for this state.");
            return;
        }
        Log.d(f12713a, "Waiting for payment details (The selected payment method requires additional information)");
        m14103r();
    }

    /* renamed from: q */
    private void m14102q() {
        Log.d(f12713a, "requestPaymentData()");
        String token = C6844a.m13919a(this.f12720h, this);
        Iterator it = this.f12718f.iterator();
        while (it.hasNext()) {
            ((C6851g) it.next()).onPaymentDataRequested(this.f12724l, token, this.f12728p.mo22368c());
        }
    }

    /* renamed from: r */
    private void m14103r() {
        Log.d(f12713a, "requestPaymentMethodDetails()");
        C0515e.m2597a(this.f12720h).mo5313a(this.f12728p.mo22367b(), new IntentFilter("com.adyen.androidpay.ui.AndroidTokenProvided"));
        Iterator it = this.f12717e.iterator();
        while (it.hasNext()) {
            ((C6850f) it.next()).onPaymentDetailsRequired(this.f12724l, this.f12721i.mo22327b(), this.f12728p.mo22369d());
        }
    }

    /* renamed from: s */
    private void m14104s() {
        Log.d(f12713a, "requestPaymentMethodSelection()");
        Iterator it = this.f12717e.iterator();
        while (it.hasNext()) {
            ((C6850f) it.next()).onPaymentMethodSelectionRequired(this.f12724l, this.f12726n, this.f12725m, this.f12728p.mo22371f());
        }
        C0515e.m2597a(this.f12720h).mo5313a(this.f12728p.mo22372g(), new IntentFilter("com.adyen.core.ui.PaymentMethodSelected"));
        C0515e.m2597a(this.f12720h).mo5313a(this.f12728p.mo22370e(), new IntentFilter("com.adyen.core.ui.PaymentDetailsProvided"));
    }

    /* renamed from: o */
    private void m14100o() {
        Log.d(f12713a, "Notifying the payment result to the merchant application");
        Iterator it = this.f12718f.iterator();
        while (it.hasNext()) {
            ((C6851g) it.next()).onPaymentResult(this.f12724l, this.f12723k);
        }
    }

    /* renamed from: n */
    private void m14099n() {
        Log.d(f12713a, "Notifying the payment error to the client app");
        Iterator it = this.f12718f.iterator();
        while (it.hasNext()) {
            ((C6851g) it.next()).onPaymentResult(this.f12724l, new C6896i(this.f12714b));
        }
    }

    /* renamed from: t */
    private void m14105t() {
        try {
            C0515e.m2597a(this.f12720h).mo5312a(this.f12728p.mo22372g());
            C0515e.m2597a(this.f12720h).mo5312a(this.f12728p.mo22367b());
            C0515e.m2597a(this.f12720h).mo5312a(this.f12728p.mo22373h());
            C0515e.m2597a(this.f12720h).mo5312a(this.f12728p.mo22370e());
        } catch (IllegalArgumentException possibleException) {
            Log.w(f12713a, "Accepted exception", possibleException);
        }
    }

    /* renamed from: l */
    private void m14097l() {
        C6897j jVar = this.f12719g;
        if (jVar != null) {
            List<PaymentMethod> unfilteredPaymentMethods = jVar.mo22347b();
            this.f12726n = this.f12719g.mo22352g();
            C6860e.m13943a(this.f12720h, unfilteredPaymentMethods).subscribe((C13204f<? super T>) new C6920l<Object>(this));
        }
    }

    /* renamed from: p */
    private void m14101p() {
        Log.d(f12713a, "processPayment()");
        if (mo22395j()) {
            Log.d(f12713a, "Checkout SDK will display an animation while processing.");
        } else {
            Log.d(f12713a, "The merchant application will handle UI while Checkout SDK is processing payment.");
        }
        m14092a((C6845a) new C6921m(this));
    }

    /* renamed from: a */
    private void m14092a(C6845a httpResponseCallback) {
        Log.d(f12713a, "initiatePayment()");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=UTF-8");
        JSONObject paymentRequestPostData = new JSONObject();
        try {
            paymentRequestPostData.put("paymentData", this.f12719g.mo22351f());
            paymentRequestPostData.put("paymentMethodData", this.f12721i.mo22333f());
            JSONObject jsonDetails = new JSONObject();
            if (this.f12729q != null) {
                jsonDetails = m14094b(this.f12729q);
            } else if (this.f12730r != null) {
                jsonDetails = C6913k.m14062a(this.f12730r);
            }
            if (mo22395j()) {
                if (this.f12729q == null && this.f12730r == null) {
                    jsonDetails = new JSONObject();
                }
                Log.d(f12713a, "Return url is going to be overridden by SDK");
                jsonDetails.put("overrideReturnUrl", "adyencheckout://");
            }
            if (jsonDetails != null) {
                paymentRequestPostData.put("paymentDetails", jsonDetails);
            }
            C6904d.m14044a(this.f12719g.mo22349d(), headers, paymentRequestPostData.toString(), httpResponseCallback);
        } catch (JSONException jsonException) {
            Log.e(f12713a, "initiatePayment() error", jsonException);
            mo22387b((Throwable) jsonException);
        }
    }

    /* renamed from: m */
    private void m14098m() {
        Log.d(f12713a, "handleRedirect()");
        try {
            m14096k();
            String url = this.f12722j.getString("url");
            Iterator it = this.f12717e.iterator();
            while (it.hasNext()) {
                ((C6850f) it.next()).onRedirectRequired(this.f12724l, url, this.f12731s);
            }
        } catch (JSONException jsonException) {
            Log.e(f12713a, "handleRedirect() exception occurred", jsonException);
            mo22387b((Throwable) jsonException);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo22395j() {
        return this.f12716d == null;
    }

    /* renamed from: k */
    private void m14096k() {
        Intent intent = new Intent();
        intent.setAction("adyen.core.utils.DISABLE_REDIRECTION_HANDLER");
        intent.addFlags(32);
        intent.putExtra("PackageName", this.f12720h.getPackageName());
        this.f12720h.sendBroadcast(intent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C6862g mo22391f() {
        return this.f12727o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C6918j mo22389d() {
        return this.f12728p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo22392g() {
        return this.f12719g.mo22353h();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo22388c() {
        return this.f12719g.mo22348c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C6878a mo22386b() {
        return this.f12719g.mo22346a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public String mo22393h() {
        return this.f12719g.mo22354i();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C6889d mo22390e() {
        return this.f12721i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo22394i() {
        ArrayList<C6850f> arrayList = this.f12717e;
        return arrayList != null && !arrayList.isEmpty();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22383a(C6889d paymentMethod) {
        this.f12721i = paymentMethod;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22384a(C6897j paymentResponse) {
        this.f12719g = paymentResponse;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22385a(Throwable errorThrowable) {
        this.f12714b = errorThrowable;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22387b(Throwable errorThrowable) {
        this.f12714b = errorThrowable;
        this.f12727o.mo22283a(C6875t.ERROR_OCCURRED);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22382a(C6884d paymentDetails) {
        this.f12729q = paymentDetails;
    }

    /* renamed from: b */
    private static JSONObject m14094b(C6884d paymentDetails) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        for (C6881c inputDetail : paymentDetails.mo22319a()) {
            if (inputDetail.mo22309b() == null || inputDetail.mo22309b().isEmpty()) {
                jsonObject.put(inputDetail.mo22311d(), inputDetail.mo22313f());
            } else {
                JSONObject recursiveDetailJson = new JSONObject();
                Iterator it = inputDetail.mo22309b().iterator();
                while (it.hasNext()) {
                    C6881c recursiveDetail = (C6881c) it.next();
                    recursiveDetailJson.put(recursiveDetail.mo22311d(), recursiveDetail.mo22313f());
                }
                jsonObject.put(inputDetail.mo22311d(), recursiveDetailJson);
            }
        }
        return jsonObject;
    }
}
