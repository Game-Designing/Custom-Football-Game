package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzahu implements zzaho<Object> {

    /* renamed from: a */
    private final Object f24349a = new Object();

    /* renamed from: b */
    private final Map<String, zzahw> f24350b = new HashMap();

    /* renamed from: a */
    public final void mo29741a(String str, zzahw zzahw) {
        synchronized (this.f24349a) {
            this.f24350b.put(str, zzahw);
        }
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        String str;
        String str2 = (String) map.get("id");
        String str3 = (String) map.get("fail");
        String str4 = (String) map.get("fail_reason");
        String str5 = (String) map.get("fail_stack");
        String str6 = (String) map.get("result");
        if (TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            String str7 = "\n";
            String valueOf = String.valueOf(str5);
            str = valueOf.length() != 0 ? str7.concat(valueOf) : new String(str7);
        }
        synchronized (this.f24349a) {
            zzahw zzahw = (zzahw) this.f24350b.remove(str2);
            if (zzahw == null) {
                String str8 = "Received result for unexpected method invocation: ";
                String valueOf2 = String.valueOf(str2);
                zzbad.m26359d(valueOf2.length() != 0 ? str8.concat(valueOf2) : new String(str8));
            } else if (!TextUtils.isEmpty(str3)) {
                String valueOf3 = String.valueOf(str4);
                String valueOf4 = String.valueOf(str);
                zzahw.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str6 == null) {
                zzahw.mo28373a(null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zzawz.m26001a()) {
                        String str9 = "Result GMSG: ";
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzawz.m26003f(valueOf5.length() != 0 ? str9.concat(valueOf5) : new String(str9));
                    }
                    zzahw.mo28373a(jSONObject);
                } catch (JSONException e) {
                    zzahw.onFailure(e.getMessage());
                }
            }
        }
    }

    /* renamed from: a */
    public final <EngineT extends zzakg> zzbbh<JSONObject> mo29740a(EngineT enginet, String str, JSONObject jSONObject) {
        zzbbr zzbbr = new zzbbr();
        zzk.zzlg();
        String a = zzaxi.m26104a();
        mo29741a(a, (zzahw) new C9012N(this, zzbbr));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", a);
            jSONObject2.put("args", jSONObject);
            enginet.mo28740b(str, jSONObject2);
        } catch (Exception e) {
            zzbbr.mo30337a(e);
        }
        return zzbbr;
    }
}
