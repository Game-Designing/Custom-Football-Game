package p019d.p143b.p144a.p147c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.r */
public class C7202r {

    /* renamed from: a */
    private static final int[] f13928a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    private static final int[] f13929b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    private static final int[] f13930c = {15, 12, 13};

    /* renamed from: d */
    private static final String f13931d = C7202r.class.getSimpleName();

    /* renamed from: a */
    private static NetworkInfo m15397a(Context context) {
        if (C7206s.m15422a("android.permission.ACCESS_NETWORK_STATE", context)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
        }
        return null;
    }

    /* renamed from: a */
    static String m15398a(C7142c cVar) {
        NetworkInfo a = m15397a(cVar.mo23068m());
        String str = "unknown";
        if (a != null) {
            int type = a.getType();
            int subtype = a.getSubtype();
            if (type == 1) {
                str = "wifi";
            } else if (type == 0) {
                str = m15405a(subtype, f13928a) ? "2g" : m15405a(subtype, f13929b) ? "3g" : m15405a(subtype, f13930c) ? "4g" : "mobile";
            }
            C7262l b = cVar.mo23049b();
            String str2 = f13931d;
            StringBuilder sb = new StringBuilder();
            sb.append("Network ");
            sb.append(type);
            sb.append("/");
            sb.append(subtype);
            sb.append(" resolved to ");
            sb.append(str);
            b.mo22918c(str2, sb.toString());
        }
        return str;
    }

    /* renamed from: a */
    static String m15399a(InputStream inputStream, C7142c cVar) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[((Integer) cVar.mo23039a(C7196pb.f13811ed)).intValue()];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            cVar.mo23049b().mo22917b(f13931d, "Encountered error while reading stream", th);
            return null;
        }
    }

    /* renamed from: a */
    static String m15400a(String str, String str2, Map<String, String> map, C7142c cVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (cVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            StringBuilder sb2 = new StringBuilder(sb.toString());
            if (map != null && map.size() > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("?");
                sb3.append(C7209sc.m15471a(map));
                sb2.append(sb3.toString());
            }
            return sb2.toString();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    static String m15401a(String str, Map<String, String> map, C7142c cVar) {
        String str2 = (String) cVar.mo23039a(C7196pb.f13857o);
        String str3 = (String) cVar.mo23039a(C7196pb.f13832j);
        if (map == null) {
            map = m15408b(cVar);
        } else {
            map.putAll(m15408b(cVar));
        }
        return m15400a(str2, str, map, cVar);
    }

    /* renamed from: a */
    static JSONObject m15402a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    static void m15403a(int i, C7142c cVar) {
        C7204rb rbVar;
        Object valueOf;
        C7208sb A = cVar.mo23026A();
        if (i == 401) {
            valueOf = "";
            A.mo23251a(C7196pb.f13822h, valueOf);
            rbVar = C7196pb.f13832j;
        } else if (i == 418) {
            rbVar = C7196pb.f13797c;
            valueOf = Boolean.valueOf(true);
        } else if ((i >= 400 && i < 500) || i == -1) {
            cVar.mo23030F();
            return;
        } else {
            return;
        }
        A.mo23251a(rbVar, valueOf);
        A.mo23250a();
    }

    /* renamed from: a */
    static void m15404a(JSONObject jSONObject, C7142c cVar) {
        String str = "settings";
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (cVar != null) {
            try {
                if (jSONObject.has(str)) {
                    C7208sb A = cVar.mo23026A();
                    if (!jSONObject.isNull(str)) {
                        A.mo23253a(jSONObject.getJSONObject(str));
                        A.mo23250a();
                        cVar.mo23049b().mo22918c(f13931d, "New settings processed");
                    }
                }
            } catch (JSONException e) {
                cVar.mo23049b().mo22917b(f13931d, "Unable to parse settings out of API response", e);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private static boolean m15405a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m15406a(Context context, C7142c cVar) {
        if (!(C7206s.m15422a("android.permission.ACCESS_NETWORK_STATE", context) && context.getSystemService("connectivity") != null)) {
            return true;
        }
        NetworkInfo a = m15397a(context);
        return a != null ? a.isConnected() : ((Boolean) cVar.mo23039a(C7196pb.f13702Hc)).booleanValue();
    }

    /* renamed from: b */
    static String m15407b(String str, Map<String, String> map, C7142c cVar) {
        return m15400a((String) cVar.mo23039a(C7196pb.f13862p), str, map, cVar);
    }

    /* renamed from: b */
    private static Map<String, String> m15408b(C7142c cVar) {
        HashMap hashMap = new HashMap();
        String str = (String) cVar.mo23039a(C7196pb.f13832j);
        if (C7269s.m15819a(str)) {
            hashMap.put("device_token", str);
        } else {
            hashMap.put("api_key", cVar.mo23079x());
        }
        return hashMap;
    }

    /* renamed from: b */
    static void m15409b(int i, C7142c cVar) {
        if (i == 418) {
            C7208sb A = cVar.mo23026A();
            A.mo23251a(C7196pb.f13797c, (Object) Boolean.valueOf(true));
            A.mo23250a();
        }
    }

    /* renamed from: b */
    static void m15410b(JSONObject jSONObject, C7142c cVar) {
        JSONArray a = C7167ia.m15261a(jSONObject, "zones", (JSONArray) null, (C7267q) cVar);
        if (a != null) {
            Iterator it = cVar.mo23029E().mo22820a(a).iterator();
            while (it.hasNext()) {
                C7059Ec ec = (C7059Ec) it.next();
                if (ec.mo22804e()) {
                    cVar.m15077c().mo22981a(ec);
                } else {
                    cVar.m15057a().mo23011b(ec);
                }
            }
            cVar.mo23063h().mo22958a(cVar.mo23029E().mo22823b());
            cVar.mo23064i().mo22958a(cVar.mo23029E().mo22823b());
        }
    }

    /* renamed from: c */
    static String m15411c(String str, Map<String, String> map, C7142c cVar) {
        String str2 = (String) cVar.mo23039a(C7196pb.f13877s);
        if (map == null) {
            map = m15408b(cVar);
        } else {
            map.putAll(m15408b(cVar));
        }
        return m15400a(str2, str, map, cVar);
    }

    /* renamed from: d */
    static String m15412d(String str, Map<String, String> map, C7142c cVar) {
        return m15400a((String) cVar.mo23039a(C7196pb.f13882t), str, map, cVar);
    }
}
