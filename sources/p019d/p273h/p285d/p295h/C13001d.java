package p019d.p273h.p285d.p295h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.ironsource.sdk.data.C10891d;
import com.ironsource.sdk.data.C10892e;
import com.ironsource.sdk.data.C10895h;
import com.ironsource.sdk.data.C10897j;
import com.ironsource.sdk.data.C10898k;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.h.d.h.d */
/* compiled from: IronSourceSharedPrefHelper */
public class C13001d {

    /* renamed from: a */
    private static C13001d f39965a;

    /* renamed from: b */
    private SharedPreferences f39966b;

    private C13001d(Context context) {
        this.f39966b = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    /* renamed from: a */
    public static synchronized C13001d m42394a(Context context) {
        C13001d dVar;
        synchronized (C13001d.class) {
            if (f39965a == null) {
                f39965a = new C13001d(context);
            }
            dVar = f39965a;
        }
        return dVar;
    }

    /* renamed from: g */
    public static synchronized C13001d m42395g() {
        C13001d dVar;
        synchronized (C13001d.class) {
            dVar = f39965a;
        }
        return dVar;
    }

    /* renamed from: c */
    public String mo41902c() {
        return this.f39966b.getString("ssa_rv_parameter_connection_retries", "3");
    }

    /* renamed from: a */
    public void mo41893a(C10891d object) {
        Editor editor = this.f39966b.edit();
        editor.putString("ssa_rv_parameter_connection_retries", object.mo35659b());
        editor.commit();
    }

    /* renamed from: e */
    public void mo41907e(String value) {
        Editor editor = this.f39966b.edit();
        editor.putString("back_button_state", value);
        editor.commit();
    }

    /* renamed from: b */
    public C10892e mo41898b() {
        int state = Integer.parseInt(this.f39966b.getString("back_button_state", "2"));
        if (state == 0) {
            return C10892e.None;
        }
        if (state == 1) {
            return C10892e.Device;
        }
        if (state == 2) {
            return C10892e.Controller;
        }
        return C10892e.Controller;
    }

    /* renamed from: g */
    public void mo41910g(String value) {
        Editor editor = this.f39966b.edit();
        editor.putString("search_keys", value);
        editor.commit();
    }

    /* renamed from: e */
    public List<String> mo41906e() {
        String value = this.f39966b.getString("search_keys", null);
        ArrayList<String> keys = new ArrayList<>();
        if (value != null) {
            C10897j ssaObj = new C10897j(value);
            String str = "searchKeys";
            if (ssaObj.mo35670a(str)) {
                try {
                    keys.addAll(ssaObj.mo35666a((JSONArray) ssaObj.mo35671b(str)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return keys;
    }

    /* renamed from: f */
    public JSONArray mo41908f() {
        JSONArray jsArr;
        String value = this.f39966b.getString("sessions", null);
        if (value == null) {
            return new JSONArray();
        }
        try {
            jsArr = new JSONArray(value);
        } catch (JSONException e) {
            jsArr = new JSONArray();
        }
        return jsArr;
    }

    /* renamed from: a */
    public void mo41892a() {
        Editor editor = this.f39966b.edit();
        editor.putString("sessions", null);
        editor.commit();
    }

    /* renamed from: a */
    public void mo41894a(C10898k session) {
        if (m42396h()) {
            JSONObject jsObj = new JSONObject();
            try {
                jsObj.put("sessionStartTime", session.mo35683d());
                jsObj.put("sessionEndTime", session.mo35682c());
                jsObj.put("sessionType", session.mo35684e());
                jsObj.put("connectivity", session.mo35680b());
            } catch (JSONException e) {
            }
            JSONArray jsArr = mo41908f();
            if (jsArr == null) {
                jsArr = new JSONArray();
            }
            jsArr.put(jsObj);
            Editor editor = this.f39966b.edit();
            editor.putString("sessions", jsArr.toString());
            editor.commit();
        }
    }

    /* renamed from: h */
    private boolean m42396h() {
        return this.f39966b.getBoolean("register_sessions", true);
    }

    /* renamed from: a */
    public void mo41896a(boolean value) {
        Editor editor = this.f39966b.edit();
        editor.putBoolean("register_sessions", value);
        editor.commit();
    }

    /* renamed from: b */
    public boolean mo41901b(String key, String value) {
        Editor editor = this.f39966b.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /* renamed from: c */
    public String mo41903c(String key) {
        String value = this.f39966b.getString(key, null);
        if (value != null) {
            return value;
        }
        return "{}";
    }

    /* renamed from: a */
    public String mo41890a(C10895h type) {
        String applicationKey = null;
        int i = C13000c.f39964a[type.ordinal()];
        if (i == 1) {
            applicationKey = this.f39966b.getString("application_key_rv", null);
        } else if (i == 2) {
            applicationKey = this.f39966b.getString("application_key_ow", null);
        } else if (i == 3) {
            applicationKey = this.f39966b.getString("application_key_is", null);
        }
        if (applicationKey == null) {
            return this.f39966b.getString("application_key", "EMPTY_APPLICATION_KEY");
        }
        return applicationKey;
    }

    /* renamed from: d */
    public void mo41905d(String value) {
        Editor editor = this.f39966b.edit();
        editor.putString("application_key", value);
        editor.commit();
    }

    /* renamed from: h */
    public boolean mo41911h(String value) {
        Editor editor = this.f39966b.edit();
        editor.putString("unique_id", value);
        return editor.commit();
    }

    /* renamed from: d */
    public String mo41904d() {
        return this.f39966b.getString(MediationMetaData.KEY_VERSION, "UN_VERSIONED");
    }

    /* renamed from: f */
    public void mo41909f(String sdkVersion) {
        Editor editor = this.f39966b.edit();
        editor.putString(MediationMetaData.KEY_VERSION, sdkVersion);
        editor.commit();
    }

    /* renamed from: a */
    public String mo41891a(String campaign) {
        return this.f39966b.getString(campaign, null);
    }

    /* renamed from: a */
    public void mo41895a(String campaign, String lastUpdate) {
        Editor editor = this.f39966b.edit();
        editor.putString(campaign, lastUpdate);
        editor.commit();
    }

    /* renamed from: b */
    public String mo41900b(String type) {
        String userUniqueId = null;
        if (type.equalsIgnoreCase(C10895h.RewardedVideo.toString())) {
            userUniqueId = this.f39966b.getString("unique_id_rv", null);
        } else if (type.equalsIgnoreCase(C10895h.OfferWall.toString())) {
            userUniqueId = this.f39966b.getString("unique_id_ow", null);
        } else if (type.equalsIgnoreCase(C10895h.Interstitial.toString())) {
            userUniqueId = this.f39966b.getString("unique_id_is", null);
        }
        if (userUniqueId == null) {
            return this.f39966b.getString("unique_id", "EMPTY_UNIQUE_ID");
        }
        return userUniqueId;
    }

    /* renamed from: b */
    public String mo41899b(C10895h type) {
        return mo41900b(type.toString());
    }

    /* renamed from: a */
    public boolean mo41897a(String timestamp, String applicationKey, String userId) {
        String str = "ssaUserData";
        String value = this.f39966b.getString(str, null);
        if (!TextUtils.isEmpty(value)) {
            try {
                JSONObject ssaUserDataJson = new JSONObject(value);
                if (!ssaUserDataJson.isNull(applicationKey)) {
                    JSONObject applicationKeyJson = ssaUserDataJson.getJSONObject(applicationKey);
                    if (!applicationKeyJson.isNull(userId)) {
                        applicationKeyJson.getJSONObject(userId).put("timestamp", timestamp);
                        Editor editor = this.f39966b.edit();
                        editor.putString(str, ssaUserDataJson.toString());
                        return editor.commit();
                    }
                }
            } catch (JSONException e) {
                C12999b bVar = new C12999b();
                StringBuilder sb = new StringBuilder();
                sb.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                sb.append(e.getStackTrace()[0].getMethodName());
                bVar.execute(new String[]{sb.toString()});
            }
        }
        return false;
    }
}
