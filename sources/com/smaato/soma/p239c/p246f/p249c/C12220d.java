package com.smaato.soma.p239c.p246f.p249c;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p246f.C12253x;
import com.smaato.soma.p239c.p252i.C12280f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.c.f.c.d */
/* compiled from: DeviceDataCollector */
public class C12220d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C12220d f38289a;

    /* renamed from: b */
    private HashMap<String, String> f38290b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f38291c;

    /* renamed from: com.smaato.soma.c.f.c.d$a */
    /* compiled from: DeviceDataCollector */
    private class C12221a extends Thread {
        private C12221a() {
        }

        /* synthetic */ C12221a(C12220d x0, C12217a x1) {
            this();
        }

        public void run() {
            new C12219c(this).execute();
            super.run();
        }
    }

    /* renamed from: i */
    public static C12220d m40201i() {
        if (f38289a == null) {
            f38289a = new C12220d();
            new C12217a().execute();
        }
        return f38289a;
    }

    /* renamed from: o */
    public final void mo39566o() {
        mo39553b();
    }

    /* renamed from: f */
    public final String mo39558f() {
        return Build.MODEL;
    }

    /* renamed from: c */
    public final String mo39555c() {
        if (this.f38291c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != -1) {
            return m40196a(((ConnectivityManager) this.f38291c.getSystemService("connectivity")).getActiveNetworkInfo());
        }
        C12146d.m39965a(new C12147e("Data_Collector", "You should add the permission ACCESS_NETWORK_STATE in the manifest file.", 1, C12143a.VERVOSE));
        return null;
    }

    /* renamed from: a */
    private static String m40196a(NetworkInfo info) {
        if (info != null) {
            int type = info.getType();
            if (type == 0) {
                switch (info.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2g";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3g";
                    case 13:
                        return "4g";
                    default:
                        return "carrier";
                }
            } else if (type == 1) {
                return "wifi";
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo39551a(Context context) {
        this.f38291c = context;
    }

    /* renamed from: k */
    public final Map<String, String> mo39562k() {
        C12146d.m39966a((Object) new C12218b(this));
        Map<String, String> params = new HashMap<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f38291c.getSystemService("phone");
            if (telephonyManager != null) {
                m40199a(params, "carrier", telephonyManager.getNetworkOperatorName());
                m40199a(params, "carriercode", telephonyManager.getNetworkOperator());
            }
            m40199a(params, "connection", mo39555c());
            m40199a(params, "bundle", mo39561j());
            m40199a(params, "devicemodel", mo39558f());
            m40199a(params, "lang", mo39557e());
            if (C12253x.m40318a(this.f38291c)) {
                m40199a(params, "googleadid", mo39559g());
            }
            m40198a(params);
        } catch (Exception e) {
            String str = "Data_Collector";
            String str2 = "Cannot retreive device info";
            C12147e eVar = new C12147e(str, str2, 1, C12143a.EXCEPTION, e);
            C12146d.m39965a(eVar);
        }
        return params;
    }

    /* renamed from: a */
    private void m40199a(Map<String, String> map, String key, String value) {
        if (!C12280f.m40428a((CharSequence) value)) {
            map.put(key, value);
        }
    }

    /* renamed from: a */
    private void m40198a(Map<String, String> params) {
        String googleDoNotTrackValue = mo39560h();
        if (C12280f.m40428a((CharSequence) googleDoNotTrackValue)) {
            googleDoNotTrackValue = "1";
        }
        params.put("googlednt", googleDoNotTrackValue);
    }

    /* renamed from: j */
    public String mo39561j() {
        if (mo39556d() == null || mo39556d().getApplicationContext() == null) {
            return null;
        }
        return mo39556d().getApplicationContext().getPackageName();
    }

    /* renamed from: n */
    public int mo39565n() {
        return mo39564m().x;
    }

    /* renamed from: l */
    public int mo39563l() {
        return mo39564m().y;
    }

    /* renamed from: m */
    public Point mo39564m() {
        Display display = ((WindowManager) this.f38291c.getSystemService("window")).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    /* renamed from: p */
    public boolean mo39567p() {
        return this.f38291c.getResources().getConfiguration().orientation == 1;
    }

    /* renamed from: e */
    public String mo39557e() {
        String str = "";
        if (this.f38291c == null) {
            return str;
        }
        StringBuffer res = new StringBuffer(str);
        String lang = this.f38291c.getResources().getConfiguration().locale.getLanguage();
        String country = this.f38291c.getResources().getConfiguration().locale.getCountry();
        if (!TextUtils.isEmpty(lang) && !TextUtils.isEmpty(country)) {
            res.append(lang);
            res.append("-");
            res.append(country);
        }
        return res.toString();
    }

    /* renamed from: q */
    public boolean mo39568q() {
        return (mo39556d().getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* renamed from: b */
    public final void mo39553b() {
        Context context = this.f38291c;
        if (context == null) {
            return;
        }
        if (C12253x.m40318a(context)) {
            new C12221a(this, null).start();
        } else if (m40202r().contains("SOMA_DNT") || m40202r().contains("SOMA_GAID")) {
            m40202r().edit().clear().apply();
        }
    }

    /* renamed from: g */
    public final String mo39559g() {
        return m40200c("SOMA_GAID");
    }

    /* renamed from: a */
    public void mo39552a(String googleAdvertisingId) {
        m40197a("SOMA_GAID", googleAdvertisingId);
    }

    /* renamed from: h */
    public final String mo39560h() {
        return m40200c("SOMA_DNT");
    }

    /* renamed from: b */
    public void mo39554b(String googleDoNotTrackValue) {
        m40197a("SOMA_DNT", googleDoNotTrackValue);
    }

    /* renamed from: a */
    private synchronized void m40197a(String key, String value) {
        this.f38290b.put(key, value);
        m40202r().edit().putString(key, value).apply();
    }

    /* renamed from: c */
    private synchronized String m40200c(String key) {
        String result;
        result = (String) this.f38290b.get(key);
        if (result == null) {
            result = m40202r().getString(key, "");
        }
        return result;
    }

    /* renamed from: r */
    private SharedPreferences m40202r() {
        return mo39556d().getSharedPreferences("SOMA_DATA", 0);
    }

    /* renamed from: d */
    public final Context mo39556d() {
        return this.f38291c;
    }
}
