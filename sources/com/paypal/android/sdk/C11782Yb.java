package com.paypal.android.sdk;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Yb */
final class C11782Yb implements Iterable {

    /* renamed from: a */
    private List f37078a = new ArrayList();

    /* renamed from: b */
    private int f37079b;

    static {
        C11782Yb.class.getSimpleName();
    }

    public C11782Yb(JSONArray jSONArray, JSONObject jSONObject) {
        C11779Xb xb;
        String str;
        int i = 0;
        while (true) {
            xb = null;
            str = "paypal.sdk";
            if (i >= jSONArray.length()) {
                break;
            }
            try {
                xb = C11779Xb.m39007a(jSONArray.getJSONObject(i));
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder("Error extracting funding source: ");
                sb.append(e.getMessage());
                Log.w(str, sb.toString());
            }
            if (xb != null) {
                this.f37078a.add(xb);
            }
            i++;
        }
        if (jSONObject != null) {
            try {
                xb = C11779Xb.m39007a(jSONObject);
            } catch (JSONException e2) {
                StringBuilder sb2 = new StringBuilder("Error parsing backup funding instrument: ");
                sb2.append(e2.getMessage());
                Log.w(str, sb2.toString());
            }
            if (xb != null) {
                this.f37078a.add(xb);
            }
        }
        this.f37079b = m39016f();
    }

    /* renamed from: f */
    private int m39016f() {
        Double valueOf = Double.valueOf(0.0d);
        int i = 0;
        for (int i2 = 0; i2 < this.f37078a.size(); i2++) {
            if (((C11779Xb) this.f37078a.get(i2)).mo38655d().doubleValue() > valueOf.doubleValue()) {
                valueOf = ((C11779Xb) this.f37078a.get(i2)).mo38655d();
                i = i2;
            }
        }
        return i;
    }

    /* renamed from: a */
    public final C11779Xb mo38658a(int i) {
        this.f37078a.size();
        return (C11779Xb) this.f37078a.get(0);
    }

    /* renamed from: a */
    public final String mo38659a() {
        return ((C11779Xb) this.f37078a.get(this.f37079b)).mo38652a();
    }

    /* renamed from: b */
    public final boolean mo38660b() {
        String f = ((C11779Xb) this.f37078a.get(this.f37079b)).mo38657f();
        if (C11723Fa.m38822b((CharSequence) f)) {
            return f.toUpperCase().equals("DELAYED_TRANSFER");
        }
        return false;
    }

    /* renamed from: c */
    public final String mo38661c() {
        return this.f37078a.size() == 1 ? ((C11779Xb) this.f37078a.get(0)).mo38653b() : C11756Pb.m38949a(C11761Rb.AND_OTHER_FUNDING_SOURCES);
    }

    /* renamed from: d */
    public final String mo38662d() {
        return ((C11779Xb) this.f37078a.get(this.f37079b)).mo38656e();
    }

    /* renamed from: e */
    public final int mo38663e() {
        return this.f37078a.size();
    }

    public final Iterator iterator() {
        return this.f37078a.iterator();
    }
}
