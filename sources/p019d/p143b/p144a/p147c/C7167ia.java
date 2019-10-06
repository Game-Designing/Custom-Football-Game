package p019d.p143b.p144a.p147c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.ia */
public class C7167ia {
    /* renamed from: a */
    public static float m15253a(JSONObject jSONObject, String str, float f, C7267q qVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f;
        }
        try {
            double d = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d || d >= 3.4028234663852886E38d) ? f : (float) d;
        } catch (JSONException e) {
            if (qVar == null) {
                return f;
            }
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve float property for key = ");
            sb.append(str);
            b.mo22916b("JsonUtils", sb.toString());
            return f;
        }
    }

    /* renamed from: a */
    public static int m15254a(JSONObject jSONObject, String str, int i, C7267q qVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return i;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            if (qVar == null) {
                return i;
            }
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve int property for key = ");
            sb.append(str);
            b.mo22916b("JsonUtils", sb.toString());
            return i;
        }
    }

    /* renamed from: a */
    public static long m15255a(JSONObject jSONObject, String str, long j, C7267q qVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return j;
        }
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e) {
            if (qVar == null) {
                return j;
            }
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve int property for key = ");
            sb.append(str);
            b.mo22916b("JsonUtils", sb.toString());
            return j;
        }
    }

    /* renamed from: a */
    public static Boolean m15256a(JSONObject jSONObject, String str, Boolean bool, C7267q qVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                bool = Boolean.valueOf(jSONObject.getBoolean(str));
            } catch (JSONException e) {
                if (qVar != null) {
                    C7262l b = qVar.mo23049b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to parse boolean for key = ");
                    sb.append(str);
                    sb.append("... Attempting to parse it as an int");
                    b.mo22913a("JsonUtils", sb.toString());
                }
                return Boolean.valueOf(m15254a(jSONObject, str, bool.booleanValue() ? 1 : 0, qVar) > 0);
            }
        }
        return bool;
    }

    /* renamed from: a */
    private static Object m15257a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return m15260a((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            obj = m15259a((JSONArray) obj);
        }
        return obj;
    }

    /* renamed from: a */
    public static String m15258a(JSONObject jSONObject, String str, String str2, C7267q qVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return str2;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            if (qVar == null) {
                return str2;
            }
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve string property for key = ");
            sb.append(str);
            b.mo22916b("JsonUtils", sb.toString());
            return str2;
        }
    }

    /* renamed from: a */
    public static List m15259a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m15257a(jSONArray.get(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<String, String> m15260a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, m15257a(jSONObject.get(str)).toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONArray m15261a(JSONObject jSONObject, String str, JSONArray jSONArray, C7267q qVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONArray;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            if (qVar == null) {
                return jSONArray;
            }
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve JSON array for key = ");
            sb.append(str);
            b.mo22916b("JsonUtils", sb.toString());
            return jSONArray;
        }
    }

    /* renamed from: a */
    static JSONObject m15262a(Map<String, ?> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m15263a(JSONArray jSONArray, int i, JSONObject jSONObject, C7267q qVar) {
        if (jSONArray == null || i >= jSONArray.length()) {
            return jSONObject;
        }
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            if (qVar == null) {
                return jSONObject;
            }
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve JSON object from array for index = ");
            sb.append(i);
            b.mo22916b("JsonUtils", sb.toString());
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static JSONObject m15264a(JSONObject jSONObject, String str, JSONObject jSONObject2, C7267q qVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONObject2;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            if (qVar == null) {
                return jSONObject2;
            }
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve JSON property for key = ");
            sb.append(str);
            b.mo22916b("JsonUtils", sb.toString());
            return jSONObject2;
        }
    }

    /* renamed from: a */
    public static boolean m15265a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: b */
    public static void m15266b(JSONObject jSONObject, String str, long j, C7267q qVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, j);
            } catch (JSONException e) {
                if (qVar != null) {
                    C7262l b = qVar.mo23049b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to put long property for key = ");
                    sb.append(str);
                    b.mo22916b("JsonUtils", sb.toString());
                }
            }
        }
    }
}
