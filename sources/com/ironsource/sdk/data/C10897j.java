package com.ironsource.sdk.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.sdk.data.j */
/* compiled from: SSAObj */
public class C10897j {

    /* renamed from: a */
    private JSONObject f33281a;

    public C10897j() {
        this.f33281a = new JSONObject();
    }

    public C10897j(String value) {
        mo35640f(value);
    }

    /* renamed from: f */
    private void mo35640f(String value) {
        try {
            this.f33281a = new JSONObject(value);
        } catch (Exception e) {
            this.f33281a = new JSONObject();
        }
    }

    /* renamed from: a */
    public JSONObject mo35667a() {
        return this.f33281a;
    }

    /* renamed from: a */
    public boolean mo35670a(String key) {
        return mo35667a().has(key);
    }

    /* renamed from: e */
    public boolean mo35674e(String key) {
        return mo35667a().isNull(key);
    }

    /* renamed from: b */
    public Object mo35671b(String key) {
        try {
            return mo35667a().get(key);
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: d */
    public String mo35673d(String key) {
        try {
            return this.f33281a.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: c */
    public boolean mo35672c(String key) {
        try {
            return this.f33281a.getBoolean(key);
        } catch (JSONException e) {
            return false;
        }
    }

    /* renamed from: a */
    public List mo35666a(JSONArray array) throws JSONException {
        List list = new ArrayList();
        for (int i = 0; i < array.length(); i++) {
            list.add(m35668a(array.get(i)));
        }
        return list;
    }

    /* renamed from: a */
    public void mo35668a(String name, String value) {
        try {
            this.f33281a.put(name, value);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void mo35669a(String name, JSONObject value) {
        try {
            this.f33281a.put(name, value);
        } catch (Exception e) {
        }
    }

    public String toString() {
        JSONObject jSONObject = this.f33281a;
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private Map<String, Object> m35669a(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<>();
        Iterator keys = object.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            map.put(key, m35668a(object.get(key)));
        }
        return map;
    }

    /* renamed from: a */
    private Object m35668a(Object json) throws JSONException {
        if (json == JSONObject.NULL) {
            return null;
        }
        if (json instanceof JSONObject) {
            return m35669a((JSONObject) json);
        }
        if (json instanceof JSONArray) {
            return mo35666a((JSONArray) json);
        }
        return json;
    }
}
