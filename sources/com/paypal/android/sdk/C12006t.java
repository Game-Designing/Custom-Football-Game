package com.paypal.android.sdk;

import android.location.Location;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;

/* renamed from: com.paypal.android.sdk.t */
public final class C12006t {

    /* renamed from: A */
    private String f37692A = "full";

    /* renamed from: B */
    public String f37693B;

    /* renamed from: C */
    public String f37694C;

    /* renamed from: D */
    public Boolean f37695D;

    /* renamed from: E */
    public String f37696E;

    /* renamed from: F */
    public String f37697F;

    /* renamed from: G */
    public Boolean f37698G;

    /* renamed from: H */
    public String f37699H;

    /* renamed from: I */
    public String f37700I;

    /* renamed from: J */
    public long f37701J;

    /* renamed from: K */
    public long f37702K;

    /* renamed from: L */
    public String f37703L;

    /* renamed from: M */
    public Boolean f37704M;

    /* renamed from: N */
    public Integer f37705N;

    /* renamed from: O */
    public int f37706O = -1;

    /* renamed from: P */
    public int f37707P = -1;

    /* renamed from: Q */
    public String f37708Q;

    /* renamed from: R */
    public int f37709R = -1;

    /* renamed from: S */
    public String f37710S;

    /* renamed from: T */
    public Boolean f37711T;

    /* renamed from: U */
    public Boolean f37712U;

    /* renamed from: V */
    public String f37713V;

    /* renamed from: W */
    public long f37714W;

    /* renamed from: X */
    public long f37715X;

    /* renamed from: Y */
    public String f37716Y;

    /* renamed from: Z */
    public String f37717Z;

    /* renamed from: a */
    public String f37718a;

    /* renamed from: aa */
    public String f37719aa;

    /* renamed from: b */
    public String f37720b;

    /* renamed from: ba */
    public String f37721ba;

    /* renamed from: c */
    public String f37722c;

    /* renamed from: ca */
    public String f37723ca;

    /* renamed from: d */
    public int f37724d = -1;

    /* renamed from: da */
    public String f37725da;

    /* renamed from: e */
    public String f37726e;

    /* renamed from: ea */
    public String f37727ea;

    /* renamed from: f */
    public int f37728f = -1;

    /* renamed from: fa */
    public String f37729fa;

    /* renamed from: g */
    public String f37730g;

    /* renamed from: ga */
    public String f37731ga;

    /* renamed from: h */
    public String f37732h;

    /* renamed from: ha */
    public List f37733ha;

    /* renamed from: i */
    public String f37734i;

    /* renamed from: ia */
    public Map f37735ia;

    /* renamed from: j */
    public String f37736j;

    /* renamed from: k */
    public String f37737k;

    /* renamed from: l */
    public String f37738l;

    /* renamed from: m */
    public String f37739m;

    /* renamed from: n */
    public long f37740n = -1;

    /* renamed from: o */
    public String f37741o;

    /* renamed from: p */
    public List f37742p;

    /* renamed from: q */
    public List f37743q;

    /* renamed from: r */
    public String f37744r;

    /* renamed from: s */
    public String f37745s;

    /* renamed from: t */
    public String f37746t;

    /* renamed from: u */
    public String f37747u;

    /* renamed from: v */
    public Location f37748v;

    /* renamed from: w */
    public int f37749w = -1;

    /* renamed from: x */
    public String f37750x;

    /* renamed from: y */
    public String f37751y = "Android";

    /* renamed from: z */
    public String f37752z;

    /* renamed from: a */
    private static JSONObject m39709a(Location location) {
        if (location != null) {
            try {
                StringBuilder sb = new StringBuilder("{\"lat\":");
                sb.append(location.getLatitude());
                sb.append(",\"lng\":");
                sb.append(location.getLongitude());
                sb.append(",\"acc\":");
                sb.append(location.getAccuracy());
                sb.append(",\"timestamp\":");
                sb.append(location.getTime());
                sb.append("}");
                return new JSONObject(sb.toString());
            } catch (JSONException e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m39710a(JSONObject jSONObject) {
        Map map = this.f37735ia;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    C11754P.m38932a((String) null, (String) null, (Throwable) e);
                }
            }
        }
    }

    /* renamed from: a */
    public final JSONObject mo39188a() {
        String str = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_guid", this.f37718a);
            jSONObject.put(BundleCons.APP_ID, this.f37720b);
            jSONObject.put("app_version", this.f37722c);
            jSONObject.put("base_station_id", this.f37724d == -1 ? null : Integer.valueOf(this.f37724d));
            jSONObject.put("bssid", this.f37726e);
            jSONObject.put("bssid_array", this.f37733ha == null ? null : new JSONArray(this.f37733ha));
            jSONObject.put("cell_id", this.f37728f == -1 ? null : Integer.valueOf(this.f37728f));
            jSONObject.put("comp_version", this.f37730g);
            jSONObject.put("conf_url", this.f37732h);
            jSONObject.put("conf_version", this.f37734i);
            jSONObject.put("conn_type", this.f37736j);
            jSONObject.put("device_id", this.f37737k);
            jSONObject.put("dc_id", this.f37729fa);
            jSONObject.put("device_model", this.f37738l);
            jSONObject.put("device_name", this.f37739m);
            jSONObject.put("device_uptime", this.f37740n == -1 ? null : Long.valueOf(this.f37740n));
            jSONObject.put("ip_addrs", this.f37741o);
            jSONObject.put("ip_addresses", this.f37742p == null ? null : new JSONArray(this.f37742p));
            jSONObject.put("known_apps", this.f37743q == null ? null : new JSONArray(this.f37743q));
            jSONObject.put("line_1_number", str.equals(this.f37744r) ? null : this.f37744r);
            jSONObject.put("linker_id", this.f37745s);
            jSONObject.put("locale_country", this.f37746t);
            jSONObject.put("locale_lang", this.f37747u);
            jSONObject.put("location", m39709a(this.f37748v));
            jSONObject.put("location_area_code", this.f37749w == -1 ? null : Integer.valueOf(this.f37749w));
            jSONObject.put("mac_addrs", this.f37750x);
            jSONObject.put("os_type", this.f37751y);
            jSONObject.put("os_version", this.f37752z);
            jSONObject.put("payload_type", this.f37692A);
            jSONObject.put("phone_type", this.f37693B);
            jSONObject.put("risk_comp_session_id", this.f37694C);
            jSONObject.put("roaming", this.f37695D);
            jSONObject.put("sim_operator_name", str.equals(this.f37696E) ? null : this.f37696E);
            jSONObject.put("sim_serial_number", this.f37697F);
            jSONObject.put("sms_enabled", this.f37698G);
            jSONObject.put("ssid", this.f37699H);
            jSONObject.put("cdma_network_id", this.f37707P == -1 ? null : Integer.valueOf(this.f37707P));
            jSONObject.put("cdma_system_id", this.f37706O == -1 ? null : Integer.valueOf(this.f37706O));
            jSONObject.put("subscriber_id", this.f37700I);
            jSONObject.put("timestamp", this.f37701J);
            jSONObject.put("total_storage_space", this.f37702K);
            jSONObject.put("tz_name", this.f37703L);
            jSONObject.put("ds", this.f37704M);
            jSONObject.put("tz", this.f37705N);
            jSONObject.put("network_operator", this.f37708Q);
            jSONObject.put("source_app", this.f37709R == -1 ? null : Integer.valueOf(this.f37709R));
            jSONObject.put("source_app_version", this.f37710S);
            jSONObject.put("is_emulator", this.f37711T);
            jSONObject.put("is_rooted", this.f37712U);
            jSONObject.put("pairing_id", this.f37713V);
            jSONObject.put("app_first_install_time", this.f37714W);
            jSONObject.put("app_last_update_time", this.f37715X);
            jSONObject.put("android_id", this.f37716Y);
            jSONObject.put("serial_number", this.f37719aa);
            jSONObject.put("notif_token", this.f37717Z);
            jSONObject.put("bluetooth_mac_addrs", null);
            jSONObject.put("gsf_id", this.f37721ba);
            jSONObject.put("VPN_setting", this.f37725da);
            jSONObject.put("proxy_setting", this.f37723ca);
            jSONObject.put("c", this.f37727ea);
            jSONObject.put("pm", this.f37731ga);
            m39710a(jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    /* renamed from: a */
    public final JSONObject mo39189a(C12006t tVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_emulator", tVar.f37711T);
            jSONObject.put("is_rooted", tVar.f37712U);
            jSONObject.put("app_guid", tVar.f37718a);
            jSONObject.put("risk_comp_session_id", tVar.f37694C);
            jSONObject.put("timestamp", tVar.f37701J);
            jSONObject.put("payload_type", "incremental");
            jSONObject.put("source_app", tVar.f37709R);
            jSONObject.put("pairing_id", tVar.f37713V);
            m39710a(jSONObject);
            if (this.f37720b != null && !this.f37720b.equals(tVar.f37720b)) {
                jSONObject.put(BundleCons.APP_ID, tVar.f37720b);
            }
            if (this.f37722c != null && !this.f37722c.equals(tVar.f37722c)) {
                jSONObject.put("app_version", tVar.f37722c);
            }
            if (this.f37724d != tVar.f37724d) {
                jSONObject.put("base_station_id", tVar.f37724d);
            }
            if (this.f37726e != null && !this.f37726e.equals(tVar.f37726e)) {
                jSONObject.put("bssid", tVar.f37726e);
            }
            if (this.f37728f != tVar.f37728f) {
                jSONObject.put("cell_id", tVar.f37728f);
            }
            if (this.f37730g != null && !this.f37730g.equals(tVar.f37730g)) {
                jSONObject.put("comp_version", tVar.f37730g);
            }
            if (this.f37734i != null && !this.f37734i.equals(tVar.f37734i)) {
                jSONObject.put("conf_version", tVar.f37734i);
            }
            if (this.f37732h != null && !this.f37732h.equals(tVar.f37732h)) {
                jSONObject.put("conf_url", tVar.f37732h);
            }
            if (this.f37736j != null && !this.f37736j.equals(tVar.f37736j)) {
                jSONObject.put("conn_type", tVar.f37736j);
            }
            if (this.f37737k != null && !this.f37737k.equals(tVar.f37737k)) {
                jSONObject.put("device_id", tVar.f37737k);
            }
            if (this.f37738l != null && !this.f37738l.equals(tVar.f37738l)) {
                jSONObject.put("device_model", tVar.f37738l);
            }
            if (this.f37739m != null && !this.f37739m.equals(tVar.f37739m)) {
                jSONObject.put("device_name", tVar.f37739m);
            }
            if (this.f37740n != tVar.f37740n) {
                jSONObject.put("device_uptime", tVar.f37740n);
            }
            if (this.f37741o != null && !this.f37741o.equals(tVar.f37741o)) {
                jSONObject.put("ip_addrs", tVar.f37741o);
            }
            if (!(this.f37742p == null || tVar.f37742p == null || this.f37742p.toString().equals(tVar.f37742p.toString()))) {
                jSONObject.put("ip_addresses", new JSONArray(tVar.f37742p));
            }
            if (!(this.f37743q == null || tVar.f37743q == null || this.f37743q.toString().equals(tVar.f37743q.toString()))) {
                jSONObject.put("known_apps", new JSONArray(tVar.f37743q));
            }
            if (this.f37744r != null && !this.f37744r.equals(tVar.f37744r)) {
                jSONObject.put("line_1_number", tVar.f37744r);
            }
            if (this.f37745s != null && !this.f37745s.equals(tVar.f37745s)) {
                jSONObject.put("linker_id", tVar.f37745s);
            }
            if (this.f37746t != null && !this.f37746t.equals(tVar.f37746t)) {
                jSONObject.put("locale_country", tVar.f37746t);
            }
            if (this.f37747u != null && !this.f37747u.equals(tVar.f37747u)) {
                jSONObject.put("locale_lang", tVar.f37747u);
            }
            if (!(this.f37748v == null || tVar.f37748v == null || this.f37748v.toString().equals(tVar.f37748v.toString()))) {
                jSONObject.put("location", m39709a(tVar.f37748v));
            }
            if (this.f37749w != tVar.f37749w) {
                jSONObject.put("location_area_code", tVar.f37749w);
            }
            if (this.f37750x != null && !this.f37750x.equals(tVar.f37750x)) {
                jSONObject.put("mac_addrs", tVar.f37750x);
            }
            if (this.f37751y != null && !this.f37751y.equals(tVar.f37751y)) {
                jSONObject.put("os_type", tVar.f37751y);
            }
            if (this.f37752z != null && !this.f37752z.equals(tVar.f37752z)) {
                jSONObject.put("os_version", tVar.f37752z);
            }
            if (this.f37693B != null && !this.f37693B.equals(tVar.f37693B)) {
                jSONObject.put("phone_type", tVar.f37693B);
            }
            if (this.f37695D != null && this.f37695D.equals(tVar.f37695D)) {
                jSONObject.put("roaming", tVar.f37695D);
            }
            if (this.f37696E != null && !this.f37696E.equals(tVar.f37696E)) {
                jSONObject.put("sim_operator_name", tVar.f37696E);
            }
            if (this.f37697F != null && !this.f37697F.equals(tVar.f37697F)) {
                jSONObject.put("sim_serial_number", tVar.f37697F);
            }
            if (this.f37698G != null && this.f37698G.equals(tVar.f37698G)) {
                jSONObject.put("sms_enabled", tVar.f37698G);
            }
            if (this.f37699H != null && !this.f37699H.equals(tVar.f37699H)) {
                jSONObject.put("ssid", tVar.f37699H);
            }
            if (this.f37707P != tVar.f37707P) {
                jSONObject.put("cdma_network_id", tVar.f37707P);
            }
            if (this.f37706O != tVar.f37706O) {
                jSONObject.put("cdma_system_id", tVar.f37706O);
            }
            if (this.f37700I != null && !this.f37700I.equals(tVar.f37700I)) {
                jSONObject.put("subscriber_id", tVar.f37700I);
            }
            if (this.f37702K != tVar.f37702K) {
                jSONObject.put("total_storage_space", tVar.f37702K);
            }
            if (this.f37703L != null && !this.f37703L.equals(tVar.f37703L)) {
                jSONObject.put("tz_name", tVar.f37703L);
            }
            if (this.f37704M != null && !this.f37704M.equals(tVar.f37704M)) {
                jSONObject.put("ds", tVar.f37704M);
            }
            if (this.f37705N != null && !this.f37705N.equals(tVar.f37705N)) {
                jSONObject.put("tz", tVar.f37705N);
            }
            if (this.f37708Q != null && !this.f37708Q.equals(tVar.f37708Q)) {
                jSONObject.put("network_operator", tVar.f37708Q);
            }
            if (this.f37710S != null && !this.f37710S.equals(tVar.f37710S)) {
                jSONObject.put("source_app_version", tVar.f37710S);
            }
            if (this.f37714W != tVar.f37714W) {
                jSONObject.put("app_first_install_time", tVar.f37714W);
            }
            if (this.f37715X != tVar.f37715X) {
                jSONObject.put("app_last_update_time", tVar.f37715X);
            }
            if (this.f37716Y != null && !this.f37716Y.equals(tVar.f37716Y)) {
                jSONObject.put("android_id", tVar.f37716Y);
            }
            if (this.f37719aa != null && !this.f37719aa.equals(tVar.f37719aa)) {
                jSONObject.put("serial_number", tVar.f37719aa);
            }
            if (this.f37717Z != null && !this.f37717Z.equals(tVar.f37717Z)) {
                jSONObject.put("notif_token", tVar.f37717Z);
            }
            if (this.f37721ba != null && !this.f37721ba.equals(tVar.f37721ba)) {
                jSONObject.put("gsf_id", tVar.f37721ba);
            }
            if (this.f37725da != null && !this.f37725da.equals(tVar.f37725da)) {
                jSONObject.put("VPN_setting", tVar.f37725da);
            }
            if (this.f37723ca != null && !this.f37723ca.equals(tVar.f37723ca)) {
                jSONObject.put("proxy_setting", tVar.f37723ca);
            }
            if (this.f37727ea != null && !this.f37727ea.equals(tVar.f37727ea)) {
                jSONObject.put("c", tVar.f37727ea);
            }
            if (this.f37731ga != null && !this.f37731ga.equals(tVar.f37731ga)) {
                jSONObject.put("pm", tVar.f37731ga);
            }
            if (this.f37733ha != null && !this.f37733ha.equals(tVar.f37733ha)) {
                jSONObject.put("bssid_arr", tVar.f37733ha);
            }
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }
}
