package p019d.p135a.p136a.p139c.p140a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: d.a.a.c.a.c */
/* compiled from: InputDetail */
public final class C6881c implements Serializable {

    /* renamed from: a */
    private String f12601a;

    /* renamed from: b */
    private String f12602b;

    /* renamed from: c */
    private C6883b f12603c;

    /* renamed from: d */
    private boolean f12604d = true;

    /* renamed from: e */
    private ArrayList<C6882a> f12605e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<C6881c> f12606f;

    /* renamed from: g */
    private Map<String, String> f12607g = new HashMap();

    /* renamed from: d.a.a.c.a.c$a */
    /* compiled from: InputDetail */
    public static final class C6882a implements Serializable {

        /* renamed from: a */
        private String f12608a;

        /* renamed from: b */
        private String f12609b;

        /* renamed from: c */
        private String f12610c;

        private C6882a() {
        }

        /* renamed from: a */
        static C6882a m13979a(JSONObject jsonObject) throws JSONException {
            C6882a item = new C6882a();
            item.f12608a = jsonObject.getString("id");
            item.f12609b = jsonObject.optString("imageUrl");
            item.f12610c = jsonObject.getString("name");
            return item;
        }

        /* renamed from: c */
        public String mo22317c() {
            return this.f12610c;
        }

        /* renamed from: b */
        public String mo22316b() {
            return this.f12609b;
        }

        /* renamed from: a */
        public String mo22315a() {
            return this.f12608a;
        }
    }

    /* renamed from: d.a.a.c.a.c$b */
    /* compiled from: InputDetail */
    public enum C6883b implements Serializable {
        Text(CommandHandler.TEXT),
        CardToken("cardToken"),
        Iban("iban"),
        Select("select"),
        Boolean("boolean"),
        ApplePayToken("applePayToken"),
        AndroidPayToken("androidPayToken"),
        SamsungPayToken("samsungPayToken"),
        Cvc("cvc"),
        Address(AgentOptions.ADDRESS),
        f12621k(r12);
        

        /* renamed from: m */
        private String f12623m;

        private C6883b(String apiField) {
            this.f12623m = apiField;
        }

        /* renamed from: e */
        public String mo22318e() {
            return this.f12623m;
        }

        /* renamed from: a */
        static C6883b m13983a(String type) {
            C6883b[] values;
            for (C6883b fieldType : values()) {
                if (fieldType.mo22318e().equals(type)) {
                    return fieldType;
                }
            }
            return f12621k;
        }
    }

    private C6881c() {
    }

    /* renamed from: a */
    public boolean mo22307a(String value) {
        this.f12602b = value;
        return true;
    }

    /* renamed from: a */
    public boolean mo22308a(boolean value) {
        if (this.f12603c != C6883b.Boolean) {
            return false;
        }
        this.f12602b = String.valueOf(value);
        return true;
    }

    /* renamed from: a */
    public static C6881c m13968a(JSONObject jsonObject) throws JSONException {
        C6881c inputDetail = new C6881c();
        inputDetail.f12601a = jsonObject.getString(Notification.KEY);
        inputDetail.f12604d = jsonObject.optBoolean("optional", false);
        inputDetail.f12603c = C6883b.m13983a(jsonObject.getString("type"));
        inputDetail.f12602b = jsonObject.optString(DonationsAnalytics.VALUE);
        JSONObject configurationJSON = jsonObject.optJSONObject("configuration");
        if (configurationJSON != null) {
            Iterator<String> keys = configurationJSON.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                inputDetail.f12607g.put(key, configurationJSON.getString(key));
            }
        }
        if (inputDetail.f12603c == C6883b.Select) {
            JSONArray jsonItems = jsonObject.getJSONArray(Repo.COLUMN_ITEMS);
            for (int i = 0; i < jsonItems.length(); i++) {
                inputDetail.f12605e.add(C6882a.m13979a(jsonItems.getJSONObject(i)));
            }
        }
        String str = "inputDetails";
        if (jsonObject.has(str)) {
            JSONArray jsonObjectInputDetails = jsonObject.getJSONArray(str);
            for (int i2 = 0; i2 < jsonObjectInputDetails.length(); i2++) {
                inputDetail.m13969a(m13968a(jsonObjectInputDetails.getJSONObject(i2)));
            }
        }
        return inputDetail;
    }

    /* renamed from: a */
    private void m13969a(C6881c inputDetail) {
        if (this.f12606f == null) {
            this.f12606f = new ArrayList<>();
        }
        this.f12606f.add(inputDetail);
    }

    /* renamed from: b */
    public ArrayList<C6881c> mo22309b() {
        return this.f12606f;
    }

    /* renamed from: d */
    public String mo22311d() {
        return this.f12601a;
    }

    /* renamed from: e */
    public C6883b mo22312e() {
        return this.f12603c;
    }

    /* renamed from: g */
    public boolean mo22314g() {
        return this.f12604d;
    }

    /* renamed from: c */
    public ArrayList<C6882a> mo22310c() {
        return this.f12605e;
    }

    /* renamed from: f */
    public String mo22313f() {
        return this.f12602b;
    }

    /* renamed from: a */
    public Map<String, String> mo22306a() {
        return this.f12607g;
    }
}
