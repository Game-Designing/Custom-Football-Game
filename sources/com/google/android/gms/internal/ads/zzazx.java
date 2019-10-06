package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

@zzard
public final class zzazx {

    /* renamed from: a */
    private static Object f25050a = new Object();

    /* renamed from: b */
    private static boolean f25051b = false;

    /* renamed from: c */
    private static boolean f25052c = false;

    /* renamed from: d */
    private static Clock f25053d = DefaultClock.m22087d();

    /* renamed from: e */
    private static final Set<String> f25054e = new HashSet(Arrays.asList(new String[0]));

    /* renamed from: f */
    private final List<String> f25055f;

    public zzazx() {
        this(null);
    }

    public zzazx(String str) {
        List<String> list;
        if (!m26334a()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String str2 = "network_request_";
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            list = Arrays.asList(strArr);
        }
        this.f25055f = list;
    }

    /* renamed from: a */
    public final void mo30319a(HttpURLConnection httpURLConnection, byte[] bArr) {
        HashMap hashMap;
        if (m26334a()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            m26338b(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    /* renamed from: a */
    public final void mo30317a(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (m26334a()) {
            m26338b(str, str2, map, bArr);
        }
    }

    /* renamed from: b */
    private final void m26338b(String str, String str2, Map<String, ?> map, byte[] bArr) {
        m26330a("onNetworkRequest", (C8952Kc) new C8868Gc(str, str2, map, bArr));
    }

    /* renamed from: a */
    public final void mo30318a(HttpURLConnection httpURLConnection, int i) {
        if (m26334a()) {
            String str = null;
            m26339b(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String str2 = "Can not get error message from error HttpURLConnection\n";
                    String valueOf = String.valueOf(e.getMessage());
                    zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                m26337b(str);
            }
        }
    }

    /* renamed from: a */
    public final void mo30320a(Map<String, ?> map, int i) {
        if (m26334a()) {
            m26339b(map, i);
            if (i < 200 || i >= 300) {
                m26337b(null);
            }
        }
    }

    /* renamed from: b */
    private final void m26339b(Map<String, ?> map, int i) {
        m26330a("onNetworkResponse", (C8952Kc) new C8889Hc(i, map));
    }

    /* renamed from: a */
    public final void mo30316a(String str) {
        if (m26334a() && str != null) {
            mo30321a(str.getBytes());
        }
    }

    /* renamed from: a */
    public final void mo30321a(byte[] bArr) {
        m26330a("onNetworkResponseBody", (C8952Kc) new C8910Ic(bArr));
    }

    /* renamed from: b */
    private final void m26337b(String str) {
        m26330a("onNetworkRequestError", (C8952Kc) new C8931Jc(str));
    }

    /* renamed from: a */
    private static void m26328a(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                String str = (String) entry.getKey();
                if (!f25054e.contains(str)) {
                    boolean z = entry.getValue() instanceof List;
                    String str2 = DonationsAnalytics.VALUE;
                    String str3 = "name";
                    if (!z) {
                        if (!(entry.getValue() instanceof String)) {
                            zzbad.m26355b("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name(str3).value(str);
                        jsonWriter.name(str2).value((String) entry.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String str4 : (List) entry.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name(str3).value(str);
                            jsonWriter.name(str2).value(str4);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: a */
    private final void m26330a(String str, C8952Kc kc) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(f25053d.mo27935b());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.f25055f) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            kc.mo28250a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzbad.m26356b("unable to log", e);
        }
        m26340c(stringWriter.toString());
    }

    /* renamed from: c */
    private static synchronized void m26340c(String str) {
        synchronized (zzazx.class) {
            zzbad.m26357c("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String str2 = "GMA Debug CONTENT ";
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzbad.m26357c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                i = i2;
            }
            zzbad.m26357c("GMA Debug FINISH");
        }
    }

    /* renamed from: b */
    public static void m26336b() {
        synchronized (f25050a) {
            f25051b = false;
            f25052c = false;
            zzbad.m26359d("Ad debug logging enablement is out of date.");
        }
    }

    /* renamed from: a */
    public static void m26332a(boolean z) {
        synchronized (f25050a) {
            f25051b = true;
            f25052c = z;
        }
    }

    /* renamed from: c */
    public static boolean m26341c() {
        boolean z;
        synchronized (f25050a) {
            z = f25051b;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m26334a() {
        boolean z;
        synchronized (f25050a) {
            z = f25051b && f25052c;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m26335a(Context context) {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23940Hb)).booleanValue()) {
            return false;
        }
        try {
            if (Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzbad.m26358c("Fail to determine debug setting.", e);
            return false;
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m26329a(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    /* renamed from: a */
    static final /* synthetic */ void m26333a(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String a = Base64Utils.m22070a(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(a);
        } else {
            String a2 = zzazt.m26305a(a);
            if (a2 != null) {
                jsonWriter.name("bodydigest").value(a2);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    /* renamed from: a */
    static final /* synthetic */ void m26327a(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        m26328a(jsonWriter, map);
        jsonWriter.endObject();
    }

    /* renamed from: a */
    static final /* synthetic */ void m26331a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(DeepLinksKeys.URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        m26328a(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.m22070a(bArr));
        }
        jsonWriter.endObject();
    }
}
