package com.inmobi.rendering.p226a;

import android.content.ContentValues;
import com.inmobi.commons.core.p221d.C10656b;
import com.inmobi.commons.core.p222e.C10659b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.a.b */
/* compiled from: ClickDao */
public class C10737b {

    /* renamed from: a */
    static final String[] f32800a = {"id", "pending_attempts", "url", "ping_in_webview", "follow_redirect", "ts", "created_ts", "track_extras"};

    /* renamed from: b */
    private static final String f32801b = C10737b.class.getSimpleName();

    C10737b() {
        C10656b a = C10656b.m34962a();
        a.mo34472a("click", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL, track_extras TEXT, created_ts TEXT NOT NULL )");
        a.mo34476b();
    }

    /* renamed from: a */
    public static boolean m35277a() {
        return C10656b.m34962a().mo34468a("click") == 0;
    }

    /* renamed from: a */
    public final synchronized boolean mo34652a(C10736a aVar, int i) {
        ContentValues b = m35278b(aVar);
        C10656b a = C10656b.m34962a();
        if (a.mo34468a("click") >= i) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("pingUrl", aVar.f32792b);
                hashMap.put("errorCode", "MaxDbLimitBreach");
                C10659b.m34983a();
                C10659b.m34987a("ads", "PingDiscarded", hashMap);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                sb.append(e.getMessage());
                sb.append(")");
            }
            C10736a a2 = m35274a((ContentValues) a.mo34470a("click", f32800a, "ts= (SELECT MIN(ts) FROM click LIMIT 1)", null, null, null, null, null).get(0));
            StringBuilder sb2 = new StringBuilder("Deleting click (");
            sb2.append(a2.f32791a);
            sb2.append(")");
            m35276a(a2);
        }
        a.mo34473a("click", b);
        a.mo34476b();
        return true;
    }

    /* renamed from: a */
    public static void m35276a(C10736a aVar) {
        C10656b a = C10656b.m34962a();
        a.mo34469a("click", "id = ?", new String[]{String.valueOf(aVar.f32791a)});
        a.mo34476b();
    }

    /* renamed from: a */
    static C10736a m35274a(ContentValues contentValues) {
        String str = ")";
        int intValue = contentValues.getAsInteger("id").intValue();
        int intValue2 = contentValues.getAsInteger("pending_attempts").intValue();
        String asString = contentValues.getAsString("url");
        long longValue = Long.valueOf(contentValues.getAsString("ts")).longValue();
        long longValue2 = Long.valueOf(contentValues.getAsString("created_ts")).longValue();
        boolean booleanValue = Boolean.valueOf(contentValues.getAsString("follow_redirect")).booleanValue();
        boolean booleanValue2 = Boolean.valueOf(contentValues.getAsString("ping_in_webview")).booleanValue();
        String asString2 = contentValues.getAsString("track_extras");
        HashMap hashMap = new HashMap();
        if (asString2 != null) {
            try {
                hashMap.putAll(m35275a(new JSONObject(asString2)));
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder("JSONException in parsing extras (");
                sb.append(e.getMessage());
                sb.append(str);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder("Exception in parsing extras (");
                sb2.append(e2.getMessage());
                sb2.append(str);
            }
        }
        C10736a aVar = new C10736a(intValue, asString, hashMap, booleanValue, booleanValue2, intValue2, longValue, longValue2);
        return aVar;
    }

    /* renamed from: b */
    static ContentValues m35278b(C10736a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(aVar.f32791a));
        contentValues.put("url", aVar.f32792b);
        contentValues.put("pending_attempts", Integer.valueOf(aVar.f32796f));
        contentValues.put("ts", Long.toString(aVar.f32794d));
        contentValues.put("created_ts", Long.toString(aVar.f32795e));
        contentValues.put("follow_redirect", Boolean.toString(aVar.f32799i));
        contentValues.put("ping_in_webview", Boolean.toString(aVar.f32798h));
        Map<String, String> map = aVar.f32793c;
        if (map != null && map.size() > 0) {
            contentValues.put("track_extras", new JSONObject(aVar.f32793c).toString());
        }
        return contentValues;
    }

    /* renamed from: a */
    private static Map<String, String> m35275a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, (String) jSONObject.get(str));
        }
        return hashMap;
    }
}
