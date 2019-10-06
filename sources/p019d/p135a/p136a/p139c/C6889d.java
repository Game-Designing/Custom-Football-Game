package p019d.p135a.p136a.p139c;

import com.adyen.core.models.paymentdetails.InputDetail;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p135a.p136a.p139c.p140a.C6881c;

/* renamed from: d.a.a.c.d */
/* compiled from: PaymentMethod */
public final class C6889d implements Serializable {

    /* renamed from: a */
    private String f12635a;

    /* renamed from: b */
    private String f12636b;

    /* renamed from: c */
    private String f12637c;

    /* renamed from: d */
    private boolean f12638d;

    /* renamed from: e */
    private C6891b f12639e;

    /* renamed from: f */
    private C6890a f12640f;

    /* renamed from: g */
    private List<C6889d> f12641g;

    /* renamed from: h */
    private String f12642h;

    /* renamed from: i */
    private Collection<C6881c> f12643i;

    /* renamed from: d.a.a.c.d$a */
    /* compiled from: PaymentMethod */
    public static final class C6890a implements Serializable {

        /* renamed from: a */
        private String f12644a;

        /* renamed from: b */
        private String f12645b;

        /* renamed from: c */
        private String f12646c;

        /* renamed from: d */
        private String f12647d;

        private C6890a(JSONObject jsonObject) throws JSONException {
            this.f12644a = jsonObject.getString("expiryMonth");
            this.f12645b = jsonObject.getString("expiryYear");
            this.f12647d = jsonObject.getString("number");
            this.f12646c = jsonObject.optString("holderName");
        }
    }

    /* renamed from: d.a.a.c.d$b */
    /* compiled from: PaymentMethod */
    public static final class C6891b implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f12648a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f12649b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f12650c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f12651d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f12652e;

        private C6891b() {
        }

        /* renamed from: a */
        public String mo22340a() {
            return this.f12651d;
        }

        /* renamed from: b */
        public String mo22341b() {
            return this.f12652e;
        }
    }

    private C6889d() {
    }

    /* renamed from: b */
    public Collection<C6881c> mo22327b() {
        return this.f12643i;
    }

    /* renamed from: b */
    static C6889d m13995b(JSONObject paymentMethodJSON, String logoBaseUrl) throws JSONException {
        return m13993a(paymentMethodJSON, logoBaseUrl, false);
    }

    /* renamed from: a */
    static C6889d m13993a(JSONObject paymentMethodJSON, String logoBaseUrl, boolean isOneClick) throws JSONException {
        C6889d paymentMethod = new C6889d();
        paymentMethod.f12638d = isOneClick;
        paymentMethod.f12636b = paymentMethodJSON.getString("type");
        paymentMethod.f12635a = paymentMethodJSON.getString("name");
        paymentMethod.f12637c = paymentMethodJSON.getString("paymentMethodData");
        StringBuilder sb = new StringBuilder();
        sb.append(logoBaseUrl);
        sb.append(paymentMethod.mo22335h());
        sb.append(".png");
        paymentMethod.f12642h = sb.toString();
        JSONArray inputDetails = paymentMethodJSON.optJSONArray("inputDetails");
        if (inputDetails != null) {
            paymentMethod.f12643i = m13994a(inputDetails);
        }
        String str = "card";
        if (!paymentMethodJSON.isNull(str)) {
            JSONObject card = paymentMethodJSON.getJSONObject(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("•••• ");
            sb2.append(card.getString("number"));
            paymentMethod.f12635a = sb2.toString();
            paymentMethod.f12640f = new C6890a(card);
        }
        C6891b configuration = new C6891b();
        String str2 = "configuration";
        if (!paymentMethodJSON.isNull(str2)) {
            JSONObject configurationJson = paymentMethodJSON.getJSONObject(str2);
            configuration.f12648a = configurationJson.optString("merchantIdentifier");
            configuration.f12649b = configurationJson.optString("merchantName");
            configuration.f12650c = configurationJson.optString("publicKey").replaceAll("\\r\\n", "");
        }
        Collection<C6881c> collection = paymentMethod.f12643i;
        if (collection != null) {
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map<String, String> inputDetailConfiguration = ((C6881c) it.next()).mo22306a();
                if (inputDetailConfiguration != null && inputDetailConfiguration.size() > 0) {
                    configuration.f12651d = (String) inputDetailConfiguration.get("cvcOptional");
                    configuration.f12652e = (String) inputDetailConfiguration.get("noCVC");
                    break;
                }
            }
        }
        paymentMethod.f12639e = configuration;
        return paymentMethod;
    }

    /* renamed from: a */
    static C6889d m13992a(JSONObject paymentMethodJSON, String logoUrl) throws JSONException {
        C6889d paymentMethod = new C6889d();
        JSONObject group = paymentMethodJSON.getJSONObject("group");
        String str = "type";
        paymentMethod.f12636b = group.getString(str);
        paymentMethod.f12635a = group.getString("name");
        StringBuilder sb = new StringBuilder();
        sb.append(logoUrl);
        sb.append(group.getString(str));
        sb.append(".png");
        paymentMethod.f12642h = sb.toString();
        paymentMethod.f12637c = group.getString("paymentMethodData");
        JSONArray inputDetails = paymentMethodJSON.optJSONArray("inputDetails");
        if (inputDetails != null) {
            paymentMethod.f12643i = m13994a(inputDetails);
        }
        return paymentMethod;
    }

    /* renamed from: a */
    private static Collection<C6881c> m13994a(JSONArray inputDetailsJson) throws JSONException {
        Collection<InputDetail> inputDetails = new ArrayList<>();
        for (int r = 0; r < inputDetailsJson.length(); r++) {
            JSONObject field = inputDetailsJson.optJSONObject(r);
            if (field != null) {
                C6881c a = C6881c.m13968a(field);
                inputDetails.add(C6881c.m13968a(field));
            }
        }
        return inputDetails;
    }

    /* renamed from: g */
    public C6895h mo22334g() {
        C6895h[] values;
        for (C6895h module : C6895h.values()) {
            if (module.toString().equals(this.f12636b)) {
                return module;
            }
        }
        return null;
    }

    /* renamed from: h */
    public String mo22335h() {
        return this.f12636b;
    }

    /* renamed from: e */
    public String mo22331e() {
        return this.f12635a;
    }

    /* renamed from: f */
    public String mo22333f() {
        return this.f12637c;
    }

    /* renamed from: c */
    public String mo22329c() {
        return this.f12642h;
    }

    /* renamed from: d */
    public List<C6889d> mo22330d() {
        return this.f12641g;
    }

    /* renamed from: j */
    public boolean mo22338j() {
        boolean z = true;
        if ("paypal".equals(this.f12636b)) {
            return true;
        }
        Collection<C6881c> collection = this.f12643i;
        if ((collection != null && !collection.isEmpty()) || this.f12638d) {
            z = false;
        }
        return z;
    }

    /* renamed from: k */
    public boolean mo22339k() {
        Collection<C6881c> collection = this.f12643i;
        if (collection != null) {
            for (C6881c inputDetail : collection) {
                if (!inputDetail.mo22314g()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: i */
    public boolean mo22337i() {
        return this.f12638d;
    }

    /* renamed from: a */
    public C6891b mo22326a() {
        return this.f12639e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22328b(C6889d paymentMethod) {
        if (this.f12641g == null) {
            this.f12641g = new CopyOnWriteArrayList();
        }
        this.f12641g.add(paymentMethod);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C6889d) && ((C6889d) obj).mo22333f().equals(this.f12637c);
    }

    public int hashCode() {
        return this.f12637c.hashCode();
    }
}
