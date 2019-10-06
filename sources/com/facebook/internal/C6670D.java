package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6738z.C6739a;
import com.facebook.internal.FetchedAppSettings.DialogFeatureConfig;
import com.facebook.p127a.p128a.p129a.C6573e;
import com.facebook.p127a.p130b.C6610n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.D */
/* compiled from: FetchedAppSettingsManager */
public final class C6670D {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12167a = C6670D.class.getSimpleName();

    /* renamed from: b */
    private static final String[] f12168b = {"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url"};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Map<String, C6738z> f12169c = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final AtomicReference<C6671a> f12170d = new AtomicReference<>(C6671a.NOT_LOADED);

    /* renamed from: e */
    private static final ConcurrentLinkedQueue<C6672b> f12171e = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static boolean f12172f = false;

    /* renamed from: g */
    private static boolean f12173g = false;

    /* renamed from: h */
    private static JSONArray f12174h = null;

    /* renamed from: com.facebook.internal.D$a */
    /* compiled from: FetchedAppSettingsManager */
    enum C6671a {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    /* renamed from: com.facebook.internal.D$b */
    /* compiled from: FetchedAppSettingsManager */
    public interface C6672b {
        /* renamed from: a */
        void mo19878a(C6738z zVar);

        void onError();
    }

    /* renamed from: f */
    public static void m13313f() {
        Context context = C6787r.m13815e();
        String applicationId = C6787r.m13816f();
        if (C6694S.m13436b(applicationId)) {
            f12170d.set(C6671a.ERROR);
            m13314g();
        } else if (f12169c.containsKey(applicationId)) {
            f12170d.set(C6671a.SUCCESS);
            m13314g();
        } else {
            if (!(f12170d.compareAndSet(C6671a.NOT_LOADED, C6671a.LOADING) || f12170d.compareAndSet(C6671a.ERROR, C6671a.LOADING))) {
                m13314g();
            } else {
                C6787r.m13822l().execute(new C6667A(context, String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[]{applicationId}), applicationId));
            }
        }
    }

    /* renamed from: b */
    public static C6738z m13306b(String applicationId) {
        if (applicationId != null) {
            return (C6738z) f12169c.get(applicationId);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        return;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m13314g() {
        /*
            java.lang.Class<com.facebook.internal.D> r0 = com.facebook.internal.C6670D.class
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<com.facebook.internal.D$a> r1 = f12170d     // Catch:{ all -> 0x0073 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0073 }
            com.facebook.internal.D$a r1 = (com.facebook.internal.C6670D.C6671a) r1     // Catch:{ all -> 0x0073 }
            com.facebook.internal.D$a r2 = com.facebook.internal.C6670D.C6671a.NOT_LOADED     // Catch:{ all -> 0x0073 }
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x0073 }
            if (r2 != 0) goto L_0x0071
            com.facebook.internal.D$a r2 = com.facebook.internal.C6670D.C6671a.LOADING     // Catch:{ all -> 0x0073 }
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x001c
            goto L_0x0071
        L_0x001c:
            java.lang.String r2 = com.facebook.C6787r.m13816f()     // Catch:{ all -> 0x0073 }
            java.util.Map<java.lang.String, com.facebook.internal.z> r3 = f12169c     // Catch:{ all -> 0x0073 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0073 }
            com.facebook.internal.z r3 = (com.facebook.internal.C6738z) r3     // Catch:{ all -> 0x0073 }
            android.os.Handler r4 = new android.os.Handler     // Catch:{ all -> 0x0073 }
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0073 }
            r4.<init>(r5)     // Catch:{ all -> 0x0073 }
            com.facebook.internal.D$a r5 = com.facebook.internal.C6670D.C6671a.ERROR     // Catch:{ all -> 0x0073 }
            boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x0073 }
            if (r5 == 0) goto L_0x0055
        L_0x0039:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.D$b> r5 = f12171e     // Catch:{ all -> 0x0073 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0073 }
            if (r5 != 0) goto L_0x0053
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.D$b> r5 = f12171e     // Catch:{ all -> 0x0073 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x0073 }
            com.facebook.internal.D$b r5 = (com.facebook.internal.C6670D.C6672b) r5     // Catch:{ all -> 0x0073 }
            com.facebook.internal.B r6 = new com.facebook.internal.B     // Catch:{ all -> 0x0073 }
            r6.<init>(r5)     // Catch:{ all -> 0x0073 }
            r4.post(r6)     // Catch:{ all -> 0x0073 }
            goto L_0x0039
        L_0x0053:
            monitor-exit(r0)
            return
        L_0x0055:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.D$b> r5 = f12171e     // Catch:{ all -> 0x0073 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0073 }
            if (r5 != 0) goto L_0x006f
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.D$b> r5 = f12171e     // Catch:{ all -> 0x0073 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x0073 }
            com.facebook.internal.D$b r5 = (com.facebook.internal.C6670D.C6672b) r5     // Catch:{ all -> 0x0073 }
            com.facebook.internal.C r6 = new com.facebook.internal.C     // Catch:{ all -> 0x0073 }
            r6.<init>(r5, r3)     // Catch:{ all -> 0x0073 }
            r4.post(r6)     // Catch:{ all -> 0x0073 }
            goto L_0x0055
        L_0x006f:
            monitor-exit(r0)
            return
        L_0x0071:
            monitor-exit(r0)
            return
        L_0x0073:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x0077
        L_0x0076:
            throw r1
        L_0x0077:
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.C6670D.m13314g():void");
    }

    /* renamed from: a */
    public static C6738z m13301a(String applicationId, boolean forceRequery) {
        if (!forceRequery && f12169c.containsKey(applicationId)) {
            return (C6738z) f12169c.get(applicationId);
        }
        JSONObject response = m13310c(applicationId);
        if (response == null) {
            return null;
        }
        C6738z fetchedAppSettings = m13307b(applicationId, response);
        if (applicationId.equals(C6787r.m13816f())) {
            f12170d.set(C6671a.SUCCESS);
            m13314g();
        }
        return fetchedAppSettings;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static C6738z m13307b(String applicationId, JSONObject settingsJSON) {
        C6732t errorClassification;
        JSONObject jSONObject = settingsJSON;
        JSONArray errorClassificationJSON = jSONObject.optJSONArray("android_sdk_error_categories");
        if (errorClassificationJSON == null) {
            errorClassification = C6732t.m13557a();
        } else {
            errorClassification = C6732t.m13558a(errorClassificationJSON);
        }
        int featureBitmask = jSONObject.optInt("app_events_feature_bitmask", 0);
        boolean automaticLoggingEnabled = (featureBitmask & 8) != 0;
        boolean inAppPurchaseAutomaticLoggingEnabled = (featureBitmask & 16) != 0;
        boolean codelessEventsEnabled = (featureBitmask & 32) != 0;
        boolean trackUninstallEnabled = (featureBitmask & Opcodes.ACC_NATIVE) != 0;
        JSONArray eventBindings = jSONObject.optJSONArray("auto_event_mapping_android");
        f12174h = eventBindings;
        if (f12174h != null && C6673E.m13317b()) {
            C6573e.m13018a(eventBindings.toString());
        }
        int i = featureBitmask;
        C6738z zVar = new C6738z(jSONObject.optBoolean("supports_implicit_sdk_logging", false), jSONObject.optString("gdpv4_nux_content", ""), jSONObject.optBoolean("gdpv4_nux_enabled", false), jSONObject.optBoolean("gdpv4_chrome_custom_tabs_enabled", false), jSONObject.optInt("app_events_session_timeout", C6610n.m13121a()), C6691O.m13391a(jSONObject.optLong("seamless_login")), m13302a(jSONObject.optJSONObject("android_dialog_configs")), automaticLoggingEnabled, errorClassification, jSONObject.optString("smart_login_bookmark_icon_url"), jSONObject.optString("smart_login_menu_icon_url"), inAppPurchaseAutomaticLoggingEnabled, codelessEventsEnabled, eventBindings, jSONObject.optString("sdk_update_message"), trackUninstallEnabled);
        C6738z result = zVar;
        f12169c.put(applicationId, result);
        return result;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static JSONObject m13310c(String applicationId) {
        Bundle appSettingsParams = new Bundle();
        String str = "fields";
        appSettingsParams.putString(str, TextUtils.join(",", new ArrayList<>(Arrays.asList(f12168b))));
        GraphRequest request = GraphRequest.m12874a((AccessToken) null, applicationId, (C6545b) null);
        request.mo19679a(true);
        request.mo19675a(appSettingsParams);
        return request.mo19680b().mo20228b();
    }

    /* renamed from: a */
    private static Map<String, Map<String, C6739a>> m13302a(JSONObject dialogConfigResponse) {
        HashMap<String, Map<String, DialogFeatureConfig>> dialogConfigMap = new HashMap<>();
        if (dialogConfigResponse != null) {
            JSONArray dialogConfigData = dialogConfigResponse.optJSONArray("data");
            if (dialogConfigData != null) {
                for (int i = 0; i < dialogConfigData.length(); i++) {
                    C6739a dialogConfig = C6739a.m13587a(dialogConfigData.optJSONObject(i));
                    if (dialogConfig != null) {
                        String dialogName = dialogConfig.mo19983a();
                        Map map = (Map) dialogConfigMap.get(dialogName);
                        if (map == null) {
                            map = new HashMap();
                            dialogConfigMap.put(dialogName, map);
                        }
                        map.put(dialogConfig.mo19984b(), dialogConfig);
                    }
                }
            }
        }
        return dialogConfigMap;
    }
}
