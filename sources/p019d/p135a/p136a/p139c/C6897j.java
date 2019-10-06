package p019d.p135a.p136a.p139c;

import com.adyen.core.models.PaymentMethod;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

/* renamed from: d.a.a.c.j */
/* compiled from: PaymentResponse */
public class C6897j {

    /* renamed from: a */
    private static final String f12659a = C6897j.class.getSimpleName();

    /* renamed from: b */
    private String f12660b;

    /* renamed from: c */
    private String f12661c;

    /* renamed from: d */
    private String f12662d;

    /* renamed from: e */
    private String f12663e;

    /* renamed from: f */
    private String f12664f;

    /* renamed from: g */
    private String f12665g;

    /* renamed from: h */
    private String f12666h;

    /* renamed from: i */
    private String f12667i;

    /* renamed from: j */
    private String f12668j;

    /* renamed from: k */
    private String f12669k;

    /* renamed from: l */
    private String f12670l;

    /* renamed from: m */
    private C6878a f12671m;

    /* renamed from: n */
    private List<C6889d> f12672n = new ArrayList();

    /* renamed from: o */
    private List<C6889d> f12673o = new ArrayList();

    /* renamed from: p */
    private String f12674p;

    private C6897j() {
    }

    public C6897j(byte[] response) throws JSONException {
        JSONObject responseJSON = m14023a(response);
        this.f12660b = responseJSON.getString("generationtime");
        this.f12661c = responseJSON.getString("initiationUrl");
        this.f12662d = responseJSON.getString("paymentData");
        this.f12663e = responseJSON.getString("logoBaseUrl");
        this.f12664f = responseJSON.getString("origin");
        this.f12665g = responseJSON.getString("publicKeyToken");
        JSONObject paymentJson = responseJSON.getJSONObject("payment");
        this.f12666h = paymentJson.getString("countryCode");
        this.f12667i = paymentJson.getString("reference");
        this.f12668j = paymentJson.getString("sessionValidity");
        JSONObject amountJson = paymentJson.getJSONObject("amount");
        this.f12671m = new C6878a(amountJson.getLong(DonationsAnalytics.VALUE), amountJson.getString("currency"));
        this.f12669k = responseJSON.optString("publicKey");
        this.f12670l = paymentJson.optString("shopperReference");
        this.f12672n = m14022a(responseJSON.getJSONArray("paymentMethods"));
        this.f12673o = m14024b(responseJSON.optJSONArray("recurringDetails"));
        this.f12674p = responseJSON.optString("disableRecurringDetailUrl");
    }

    /* renamed from: f */
    public String mo22351f() {
        return this.f12662d;
    }

    /* renamed from: h */
    public String mo22353h() {
        return this.f12669k;
    }

    /* renamed from: c */
    public String mo22348c() {
        return this.f12660b;
    }

    /* renamed from: d */
    public String mo22349d() {
        return this.f12661c;
    }

    /* renamed from: e */
    public String mo22350e() {
        return this.f12663e;
    }

    /* renamed from: a */
    public C6878a mo22346a() {
        return this.f12671m;
    }

    /* renamed from: i */
    public String mo22354i() {
        return this.f12670l;
    }

    /* renamed from: b */
    public List<C6889d> mo22347b() {
        return this.f12672n;
    }

    /* renamed from: g */
    public List<C6889d> mo22352g() {
        return this.f12673o;
    }

    /* renamed from: a */
    private List<C6889d> m14022a(JSONArray jsonArray) throws JSONException {
        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        if (jsonArray == null) {
            return paymentMethodList;
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject paymentMethodJSON = jsonArray.getJSONObject(i);
            String str = "group";
            if (paymentMethodJSON.has(str)) {
                String groupType = paymentMethodJSON.getJSONObject(str).getString("type");
                boolean groupExists = false;
                Iterator it = paymentMethodList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C6889d paymentMethod = (C6889d) it.next();
                    if (groupType.equals(paymentMethod.mo22335h())) {
                        groupExists = true;
                        paymentMethod.mo22328b(C6889d.m13995b(paymentMethodJSON, mo22350e()));
                        break;
                    }
                }
                if (!groupExists) {
                    C6889d containerPaymentMethod = C6889d.m13992a(paymentMethodJSON, mo22350e());
                    containerPaymentMethod.mo22328b(C6889d.m13995b(paymentMethodJSON, mo22350e()));
                    paymentMethodList.add(containerPaymentMethod);
                }
            } else {
                paymentMethodList.add(C6889d.m13995b(paymentMethodJSON, mo22350e()));
            }
        }
        return paymentMethodList;
    }

    /* renamed from: b */
    private List<C6889d> m14024b(JSONArray jsonArray) throws JSONException {
        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        if (jsonArray == null) {
            return paymentMethodList;
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            paymentMethodList.add(C6889d.m13993a(jsonArray.getJSONObject(i), mo22350e(), true));
        }
        return paymentMethodList;
    }

    /* renamed from: a */
    private JSONObject m14023a(byte[] response) throws JSONException {
        return new JSONObject(new String(response, Charset.forName("UTF-8")));
    }
}
