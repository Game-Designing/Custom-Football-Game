package com.facebook.p127a;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.C6787r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.C */
/* compiled from: UserDataStore */
public class C6563C {

    /* renamed from: a */
    private static final String f11880a = C6563C.class.getSimpleName();

    /* renamed from: b */
    private static ConcurrentHashMap<String, String> f11881b;

    /* renamed from: c */
    private static SharedPreferences f11882c;

    /* renamed from: d */
    private static AtomicBoolean f11883d = new AtomicBoolean(false);

    /* renamed from: b */
    static void m13000b() {
        if (!f11883d.get()) {
            m13001c();
        }
    }

    /* renamed from: a */
    static String m12997a() {
        if (!f11883d.get()) {
            Log.w(f11880a, "initStore should have been called before calling setUserID");
            m13001c();
        }
        return m12998a((Map<String, String>) f11881b);
    }

    /* renamed from: c */
    private static synchronized void m13001c() {
        synchronized (C6563C.class) {
            if (!f11883d.get()) {
                f11882c = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e());
                f11881b = new ConcurrentHashMap<>(m12999a(f11882c.getString("com.facebook.appevents.UserDataStore.userData", "")));
                f11883d.set(true);
            }
        }
    }

    /* renamed from: a */
    private static String m12998a(Map<String, String> map) {
        String str = "";
        if (map.isEmpty()) {
            return str;
        }
        try {
            JSONObject jsonObject = new JSONObject();
            for (String key : map.keySet()) {
                jsonObject.put(key, map.get(key));
            }
            return jsonObject.toString();
        } catch (JSONException e) {
            return str;
        }
    }

    /* renamed from: a */
    private static Map<String, String> m12999a(String str) {
        if (str.isEmpty()) {
            return new HashMap();
        }
        try {
            Map<String, String> map = new HashMap<>();
            JSONObject jsonObject = new JSONObject(str);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                map.put(key, jsonObject.getString(key));
            }
            return map;
        } catch (JSONException e) {
            return new HashMap();
        }
    }
}
