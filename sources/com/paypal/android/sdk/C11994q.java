package com.paypal.android.sdk;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.q */
public class C11994q {

    /* renamed from: a */
    private static final String f37660a = C11994q.class.getSimpleName();

    /* renamed from: b */
    private Context f37661b;

    /* renamed from: c */
    private String f37662c;

    /* renamed from: d */
    private JSONObject f37663d;

    /* renamed from: e */
    private boolean f37664e;

    public C11994q(Context context, String str) {
        this(context, str, 0);
    }

    private C11994q(Context context, String str, byte b) {
        C11754P.m38931a(f37660a, "entering Configuration url loading");
        this.f37661b = context;
        this.f37662c = str;
        String o = m39665o();
        if (!"".equals(o)) {
            C11754P.m38931a(f37660a, "entering saveConfigDataToDisk");
            try {
                File file = new File(this.f37661b.getFilesDir(), "CONFIG_DATA");
                File file2 = new File(this.f37661b.getFilesDir(), "CONFIG_TIME");
                C11723Fa.m38816a(file, o);
                C11723Fa.m38816a(file2, String.valueOf(System.currentTimeMillis()));
                C11754P.m38931a(f37660a, "leaving saveConfigDataToDisk successfully");
            } catch (IOException e) {
                new StringBuilder("Failed to write config data: ").append(e.toString());
            }
            this.f37663d = new JSONObject(o);
            C11754P.m38931a(f37660a, "leaving Configuration url loading");
            return;
        }
        StringBuilder sb = new StringBuilder("No valid config found for ");
        sb.append(str);
        throw new IOException(sb.toString());
    }

    public C11994q(Context context, boolean z) {
        this.f37661b = context;
        this.f37662c = null;
        this.f37664e = z;
        StringBuilder sb = new StringBuilder("confIsUpdatable=");
        sb.append(Boolean.toString(this.f37664e));
        C11754P.m38929a(3, "PRD", sb.toString());
        this.f37663d = m39660j();
        C11754P.m38931a(f37660a, "Configuation initialize, dumping config");
        C11754P.m38933a(f37660a, this.f37663d);
    }

    /* renamed from: a */
    private JSONObject m39658a(String str) {
        try {
            C11754P.m38931a(f37660a, "entering getIncrementalConfig");
            JSONObject jSONObject = new JSONObject(C11754P.m38939b(this.f37661b, str));
            C11754P.m38931a(f37660a, "leaving getIncrementalConfig");
            return jSONObject;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error while loading prdc Config ");
            sb.append(str);
            C11754P.m38930a(6, "PRD", sb.toString(), (Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    private static JSONObject m39659a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            C11754P.m38931a(f37660a, "entering mergeConfig");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String str2 = f37660a;
                StringBuilder sb = new StringBuilder("overridding ");
                sb.append(str);
                C11754P.m38931a(str2, sb.toString());
                jSONObject.put(str, jSONObject2.get(str));
            }
            C11754P.m38931a(f37660a, "leaving mergeConfig");
            return jSONObject;
        } catch (Exception e) {
            C11754P.m38930a(6, "PRD", "Error encountered while applying prdc Config", (Throwable) e);
            return null;
        }
    }

    /* renamed from: j */
    private JSONObject m39660j() {
        String str = "PRD";
        try {
            JSONObject l = m39662l();
            if (l != null) {
                if (C11754P.m38942b(l.optString("conf_version", ""), "3.0")) {
                    if (this.f37664e) {
                        if (System.currentTimeMillis() > Long.parseLong(m39668r()) + (l.optLong("conf_refresh_time_interval", 0) * 1000)) {
                            m39664n();
                        }
                    }
                    C11754P.m38931a(f37660a, "Using cached config");
                    return l;
                }
                m39667q();
            }
            JSONObject k = m39661k();
            if (k == null) {
                Log.e(f37660a, "default Configuration loading failed,Using hardcoded config");
                return m39663m();
            }
            String a = C11754P.m38925a(this.f37661b, "prdc", (String) null);
            if (a == null) {
                if (this.f37664e) {
                    m39664n();
                }
                C11754P.m38929a(3, str, "prdc field not configured, using default config");
                return k;
            }
            StringBuilder sb = new StringBuilder("prdc field is configured, loading path:");
            sb.append(a);
            C11754P.m38929a(3, str, sb.toString());
            JSONObject a2 = m39658a(a);
            if (a2 == null) {
                C11754P.m38929a(6, str, "prdc Configuration loading failed, using default config");
                return k;
            }
            JSONObject a3 = m39659a(k, a2);
            if (a3 == null) {
                C11754P.m38929a(6, str, "applying prdc Configuration failed, using default config");
                return k;
            }
            C11754P.m38929a(3, str, "prdc configuration loaded successfully");
            return a3;
        } catch (Exception e) {
            C11754P.m38930a(6, str, "Severe Error while loading config, using hard code version", (Throwable) e);
            return m39663m();
        }
    }

    /* renamed from: k */
    private static JSONObject m39661k() {
        C11754P.m38931a(f37660a, "entering getDefaultConfigurations");
        try {
            String str = new String(Base64.decode("eyAiY29uZl92ZXJzaW9uIjogIjMuMCIsImFzeW5jX3VwZGF0ZV90aW1lX2ludGVydmFsIjogMzYwMCwgImZvcmNlZF9mdWxsX3VwZGF0ZV90aW1lX2ludGVydmFsIjogMTgwMCwgImNvbmZfcmVmcmVzaF90aW1lX2ludGVydmFsIjogODY0MDAsICJhbmRyb2lkX2FwcHNfdG9fY2hlY2siOiBbICJjb20uZWJheS5jbGFzc2lmaWVkcy9jb20uZWJheS5hcHAuTWFpblRhYkFjdGl2aXR5IiwgImNvbS5lYmF5Lm1vYmlsZS9jb20uZWJheS5tb2JpbGUuYWN0aXZpdGllcy5lQmF5IiwgImNvbS5lYmF5LnJlZGxhc2VyL2NvbS5lYmF5LnJlZGxhc2VyLlNjYW5uZWRJdGVtc0FjdGl2aXR5IiwgImNvbS5taWxvLmFuZHJvaWQvY29tLm1pbG8uYW5kcm9pZC5hY3Rpdml0eS5Ib21lQWN0aXZpdHkiLCAiY29tLnBheXBhbC5hbmRyb2lkLnAycG1vYmlsZS9jb20ucGF5cGFsLmFuZHJvaWQucDJwbW9iaWxlLmFjdGl2aXR5LlNlbmRNb25leUFjdGl2aXR5IiwgImNvbS5yZW50L2NvbS5yZW50LmFjdGl2aXRpZXMuc2Vzc2lvbi5BY3Rpdml0eUhvbWUiLCAiY29tLnN0dWJodWIvY29tLnN0dWJodWIuQWJvdXQiLCAiY29tLnVsb2NhdGUvY29tLnVsb2NhdGUuYWN0aXZpdGllcy5TZXR0aW5ncyIsICJjb20ubm9zaHVmb3UuYW5kcm9pZC5zdS9jb20ubm9zaHVmb3UuYW5kcm9pZC5zdS5TdSIsICJzdGVyaWNzb24uYnVzeWJveC9zdGVyaWNzb24uYnVzeWJveC5BY3Rpdml0eS5NYWluQWN0aXZpdHkiLCAib3JnLnByb3h5ZHJvaWQvb3JnLnByb3h5ZHJvaWQuUHJveHlEcm9pZCIsICJjb20uYWVkLmRyb2lkdnBuL2NvbS5hZWQuZHJvaWR2cG4uTWFpbkdVSSIsICJuZXQub3BlbnZwbi5vcGVudnBuL25ldC5vcGVudnBuLm9wZW52cG4uT3BlblZQTkNsaWVudCIsICJjb20ucGhvbmVhcHBzOTkuYWFiaXByb3h5L2NvbS5waG9uZWFwcHM5OS5hYWJpcHJveHkuT3Jib3QiLCAiY29tLmV2YW5oZS5wcm94eW1hbmFnZXIucHJvL2NvbS5ldmFuaGUucHJveHltYW5hZ2VyLk1haW5BY3Rpdml0eSIsICJjb20uZXZhbmhlLnByb3h5bWFuYWdlci9jb20uZXZhbmhlLnByb3h5bWFuYWdlci5NYWluQWN0aXZpdHkiLCAiY29tLmFuZHJvbW8uZGV2MzA5MzYuYXBwNzYxOTgvY29tLmFuZHJvbW8uZGV2MzA5MzYuYXBwNzYxOTguQW5kcm9tb0Rhc2hib2FyZEFjdGl2aXR5IiwgImNvbS5tZ3JhbmphLmF1dG9wcm94eV9saXRlL2NvbS5tZ3JhbmphLmF1dG9wcm94eV9saXRlLlByb3h5TGlzdEFjdGl2aXR5IiwgImNvbS52cG5vbmVjbGljay5hbmRyb2lkL2NvbS52cG5vbmVjbGljay5hbmRyb2lkLk1haW5BY3Rpdml0eSIsICJuZXQuaGlkZW1hbi9uZXQuaGlkZW1hbi5TdGFydGVyQWN0aXZpdHkiLCAiY29tLmRvZW50ZXIuYW5kcm9pZC52cG4uZml2ZXZwbi9jb20uZG9lbnRlci5hbmRyb2lkLnZwbi5maXZldnBuLkZpdmVWcG4iLCAiY29tLnRpZ2VydnBucy5hbmRyb2lkL2NvbS50aWdlcnZwbnMuYW5kcm9pZC5NYWluQWN0aXZpdHkiLCAiY29tLnBhbmRhcG93LnZwbi9jb20ucGFuZGFwb3cudnBuLlBhbmRhUG93IiwgImNvbS5leHByZXNzdnBuLnZwbi9jb20uZXhwcmVzc3Zwbi52cG4uTWFpbkFjdGl2aXR5IiwgImNvbS5sb25kb250cnVzdG1lZGlhLnZwbi9jb20ubG9uZG9udHJ1c3RtZWRpYS52cG4uVnBuU2VydmljZUFjdGl2aXR5IiwgImZyLm1lbGVjb20uVlBOUFBUUC52MTAxL2ZyLm1lbGVjb20uVlBOUFBUUC52MTAxLlNwbGFzaFNjcmVlbiIsICJjb20uY2hlY2twb2ludC5WUE4vY29tLmNoZWNrcG9pbnQuVlBOLk1haW5IYW5kbGVyIiwgImNvbS50dW5uZWxiZWFyLmFuZHJvaWQvY29tLnR1bm5lbGJlYXIuYW5kcm9pZC5UYmVhck1haW5BY3Rpdml0eSIsICJkZS5ibGlua3Qub3BlbnZwbi9kZS5ibGlua3Qub3BlbnZwbi5NYWluQWN0aXZpdHkiLCAib3JnLmFqZWplLmZha2Vsb2NhdGlvbi9vcmcuYWplamUuZmFrZWxvY2F0aW9uLkZha2UiLCAiY29tLmxleGEuZmFrZWdwcy9jb20ubGV4YS5mYWtlZ3BzLlBpY2tQb2ludCIsICJjb20uZm9yZ290dGVucHJvamVjdHMubW9ja2xvY2F0aW9ucy9jb20uZm9yZ290dGVucHJvamVjdHMubW9ja2xvY2F0aW9ucy5NYWluIiwgImtyLndvb3QwcGlhLmdwcy9rci53b290MHBpYS5ncHMuQ2F0Y2hNZUlmVUNhbiIsICJjb20ubXkuZmFrZS5sb2NhdGlvbi9jb20ubXkuZmFrZS5sb2NhdGlvbi5jb20ubXkuZmFrZS5sb2NhdGlvbiIsICJqcC5uZXRhcnQuYXJzdGFsa2luZy9qcC5uZXRhcnQuYXJzdGFsa2luZy5NeVByZWZlcmVuY2VBY3Rpdml0eSIsICJsb2NhdGlvblBsYXkuR1BTQ2hlYXRGcmVlL2xvY2F0aW9uUGxheS5HUFNDaGVhdEZyZWUuQWN0aXZpdHlTbWFydExvY2F0aW9uIiwgIm9yZy5nb29kZXYubGF0aXR1ZGUvb3JnLmdvb2Rldi5sYXRpdHVkZS5MYXRpdHVkZUFjdGl2aXR5IiwgImNvbS5zY2hlZmZzYmxlbmQuZGV2aWNlc3Bvb2YvY29tLnNjaGVmZnNibGVuZC5kZXZpY2VzcG9vZi5EZXZpY2VTcG9vZkFjdGl2aXR5IiwgImNvbS5wcm94eUJyb3dzZXIvY29tLnByb3h5QnJvd3Nlci5OZXdQcm94eUJyb3dzZXJBY3Rpdml0eSIsICJjb20uaWNlY29sZGFwcHMucHJveHlzZXJ2ZXJwcm8vY29tLmljZWNvbGRhcHBzLnByb3h5c2VydmVycHJvLnZpZXdTdGFydCIsICJob3RzcG90c2hpZWxkLmFuZHJvaWQudnBuL2NvbS5hbmNob3JmcmVlLnVpLkhvdFNwb3RTaGllbGQiLCAiY29tLmRvZW50ZXIub25ldnBuL2NvbS5kb2VudGVyLm9uZXZwbi5WcG5TZXR0aW5ncyIsICJjb20ueWVzdnBuLmVuL2NvbS55ZXN2cG4uTWFpblRhYiIsICJjb20ub2ZmaWNld3l6ZS5wbHV0b3Zwbi9jb20ub2ZmaWNld3l6ZS5wbHV0b3Zwbi5Ib21lQWN0aXZpdHkiLCAib3JnLmFqZWplLmxvY2F0aW9uc3Bvb2ZlcnByby9vcmcuYWplamUubG9jYXRpb25zcG9vZmVycHJvLkZha2UiLCAibG9jYXRpb25QbGF5LkdQU0NoZWF0L2xvY2F0aW9uUGxheS5HUFNDaGVhdC5BY3Rpdml0eVNtYXJ0TG9jYXRpb24iIF0sICJsb2NhdGlvbl9taW5fYWNjdXJhY3kiOiA1MDAsICJsb2NhdGlvbl9tYXhfY2FjaGVfYWdlIjogMTgwMCwgInNlbmRfb25fYXBwX3N0YXJ0IjogMSwgImVuZHBvaW50X3VybCI6ICJodHRwczovL3N2Y3MucGF5cGFsLmNvbS9BY2Nlc3NDb250cm9sL0xvZ1Jpc2tNZXRhZGF0YSIsICJpbnRlcm5hbF9jYWNoZV9tYXhfYWdlIjogMzAsICJjb21wX3RpbWVvdXQiOiA2MDAgfQ==", 0), "UTF-8");
            C11754P.m38931a(f37660a, "leaving getDefaultConfigurations, Default Conf load succeed");
            return new JSONObject(str);
        } catch (Exception e) {
            C11754P.m38930a(6, "PRD", "Read default config file exception.", (Throwable) e);
            C11754P.m38931a(f37660a, "leaving getDefaultConfigurations,returning null");
            return null;
        }
    }

    /* renamed from: l */
    private JSONObject m39662l() {
        C11754P.m38931a(f37660a, "entering getCachedConfiguration");
        try {
            String p = m39666p();
            if (!"".equals(p)) {
                C11754P.m38931a(f37660a, "leaving getCachedConfiguration,cached config load succeed");
                return new JSONObject(p);
            }
        } catch (Exception e) {
            C11754P.m38932a(f37660a, "JSON Exception in creating config file", (Throwable) e);
        }
        C11754P.m38931a(f37660a, "leaving getCachedConfiguration,cached config load failed");
        return null;
    }

    /* renamed from: m */
    private static JSONObject m39663m() {
        C11754P.m38931a(f37660a, "entering getHardcodedConfig");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conf_version", "3.0");
            jSONObject.put("async_update_time_interval", 3600);
            jSONObject.put("forced_full_update_time_interval", 1800);
            jSONObject.put("conf_refresh_time_interval", 86400);
            jSONObject.put("location_min_accuracy", 500);
            jSONObject.put("location_max_cache_age", 1800);
            jSONObject.put("endpoint_url", "https://svcs.paypal.com/AccessControl/LogRiskMetadata");
        } catch (JSONException e) {
        }
        C11754P.m38931a(f37660a, "leaving getHardcodedConfig");
        return jSONObject;
    }

    /* renamed from: n */
    private static void m39664n() {
        C11754P.m38931a(f37660a, "Loading web config");
        C12010u.m39718a().mo39194b();
    }

    /* renamed from: o */
    private String m39665o() {
        InputStream inputStream;
        C11754P.m38931a(f37660a, "entering getRemoteConfig");
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = new URL(this.f37662c).openStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            C11723Fa.m38815a((Closeable) inputStream);
                            C11723Fa.m38815a((Closeable) bufferedReader2);
                            C11754P.m38931a(f37660a, "leaving getRemoteConfig successfully");
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C11723Fa.m38815a((Closeable) inputStream);
                        C11723Fa.m38815a((Closeable) bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                C11723Fa.m38815a((Closeable) inputStream);
                C11723Fa.m38815a((Closeable) bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            C11723Fa.m38815a((Closeable) inputStream);
            C11723Fa.m38815a((Closeable) bufferedReader);
            throw th;
        }
    }

    /* renamed from: p */
    private String m39666p() {
        try {
            return C11723Fa.m38811a(new File(this.f37661b.getFilesDir(), "CONFIG_DATA"));
        } catch (IOException e) {
            C11754P.m38932a(f37660a, "Load cached config failed", (Throwable) e);
            return "";
        }
    }

    /* renamed from: q */
    private boolean m39667q() {
        try {
            C11754P.m38931a(f37660a, "entering deleteCachedConfigDataFromDisk");
            File file = new File(this.f37661b.getFilesDir(), "CONFIG_DATA");
            File file2 = new File(this.f37661b.getFilesDir(), "CONFIG_TIME");
            if (file.exists()) {
                C11754P.m38931a(f37660a, "cached Config Data found, deleting");
                file.delete();
            }
            if (file2.exists()) {
                C11754P.m38931a(f37660a, "cached Config Time found, deleting");
                file.delete();
            }
            C11754P.m38931a(f37660a, "leaving deleteCachedConfigDataFromDisk");
            return true;
        } catch (Exception e) {
            C11754P.m38932a(f37660a, "error encountered while deleteCachedConfigData", (Throwable) e);
            return false;
        }
    }

    /* renamed from: r */
    private String m39668r() {
        try {
            return C11723Fa.m38811a(new File(this.f37661b.getFilesDir(), "CONFIG_TIME"));
        } catch (IOException e) {
            return "";
        }
    }

    /* renamed from: a */
    public final String mo39172a() {
        return this.f37662c;
    }

    /* renamed from: b */
    public final String mo39173b() {
        return this.f37663d.optString("conf_version", "");
    }

    /* renamed from: c */
    public final long mo39174c() {
        return this.f37663d.optLong("async_update_time_interval", 0);
    }

    /* renamed from: d */
    public final long mo39175d() {
        return this.f37663d.optLong("forced_full_update_time_interval", 0);
    }

    /* renamed from: e */
    public final long mo39176e() {
        return this.f37663d.optLong("comp_timeout", 0);
    }

    /* renamed from: f */
    public final List mo39177f() {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = this.f37663d.optJSONArray("android_apps_to_check");
        int i = 0;
        while (optJSONArray != null && i < optJSONArray.length()) {
            arrayList.add(optJSONArray.getString(i));
            i++;
        }
        return arrayList;
    }

    /* renamed from: g */
    public final String mo39178g() {
        return this.f37663d.optString("endpoint_url", null);
    }

    /* renamed from: h */
    public final boolean mo39179h() {
        return this.f37663d.optBoolean("endpoint_is_stage", false);
    }

    /* renamed from: i */
    public final C11748N mo39180i() {
        String str = "";
        String str2 = "PRD";
        try {
            String optString = this.f37663d.optString("CDS", str);
            if (optString != null) {
                if (!str.equals(optString)) {
                    C11754P.m38929a(3, str2, "CDS field was found");
                    return new C11748N(optString.trim());
                }
            }
            C11754P.m38929a(3, str2, "No CDS is configured, enabling all variables");
            return C11748N.f36759b;
        } catch (Exception e) {
            C11754P.m38930a(6, str2, "Failed to decode CDS", (Throwable) e);
            return C11748N.f36759b;
        }
    }
}
