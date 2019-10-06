package p024io.fabric.sdk.android.p348a.p353e;

import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p024io.fabric.sdk.android.p348a.p350b.C13857n;

/* renamed from: io.fabric.sdk.android.a.e.l */
/* compiled from: DefaultSettingsJsonTransform */
class C13898l implements C13911x {
    C13898l() {
    }

    /* renamed from: a */
    public C13909v mo43308a(C13857n currentTimeProvider, JSONObject json) throws JSONException {
        JSONObject jSONObject = json;
        int settingsVersion = jSONObject.optInt("settings_version", 0);
        int cacheDuration = jSONObject.optInt("cache_duration", 3600);
        C13909v vVar = new C13909v(m44175a(currentTimeProvider, (long) cacheDuration, jSONObject), m44177b(jSONObject.getJSONObject("app")), m44182g(jSONObject.getJSONObject("session")), m44181f(jSONObject.getJSONObject("prompt")), m44179d(jSONObject.getJSONObject("features")), m44176a(jSONObject.getJSONObject("analytics")), m44178c(jSONObject.getJSONObject("beta")), settingsVersion, cacheDuration);
        return vVar;
    }

    /* renamed from: b */
    private C13891e m44177b(JSONObject json) throws JSONException {
        C13889c icon;
        JSONObject jSONObject = json;
        String identifier = jSONObject.getString("identifier");
        String status = jSONObject.getString("status");
        String url = jSONObject.getString("url");
        String reportsUrl = jSONObject.getString("reports_url");
        String ndkReportsUrl = jSONObject.getString("ndk_reports_url");
        boolean updateRequired = jSONObject.optBoolean("update_required", false);
        String str = "icon";
        if (jSONObject.has(str)) {
            if (jSONObject.getJSONObject(str).has(Repo.COLUMN_HASH)) {
                icon = m44180e(jSONObject.getJSONObject(str));
                C13891e eVar = new C13891e(identifier, status, url, reportsUrl, ndkReportsUrl, updateRequired, icon);
                return eVar;
            }
        }
        icon = null;
        C13891e eVar2 = new C13891e(identifier, status, url, reportsUrl, ndkReportsUrl, updateRequired, icon);
        return eVar2;
    }

    /* renamed from: e */
    private C13889c m44180e(JSONObject iconJson) throws JSONException {
        return new C13889c(iconJson.getString(Repo.COLUMN_HASH), iconJson.getInt("width"), iconJson.getInt("height"));
    }

    /* renamed from: d */
    private C13900n m44179d(JSONObject json) {
        C13900n nVar = new C13900n(json.optBoolean("prompt_enabled", false), json.optBoolean("collect_logged_exceptions", true), json.optBoolean("collect_reports", true), json.optBoolean("collect_analytics", false), json.optBoolean("firebase_crashlytics_enabled", false));
        return nVar;
    }

    /* renamed from: a */
    private C13888b m44176a(JSONObject json) {
        JSONObject jSONObject = json;
        C13888b bVar = new C13888b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("forward_to_google_analytics", false), jSONObject.optBoolean("include_purchase_events_in_forwarded_events", false), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
        return bVar;
    }

    /* renamed from: g */
    private C13903q m44182g(JSONObject json) throws JSONException {
        JSONObject jSONObject = json;
        C13903q qVar = new C13903q(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
        return qVar;
    }

    /* renamed from: f */
    private C13902p m44181f(JSONObject json) throws JSONException {
        JSONObject jSONObject = json;
        C13902p pVar = new C13902p(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
        return pVar;
    }

    /* renamed from: c */
    private C13893g m44178c(JSONObject json) throws JSONException {
        return new C13893g(json.optString("update_endpoint", C13910w.f42200a), json.optInt("update_suspend_duration", 3600));
    }

    /* renamed from: a */
    private long m44175a(C13857n currentTimeProvider, long cacheDurationSeconds, JSONObject json) throws JSONException {
        String str = "expires_at";
        if (json.has(str)) {
            return json.getLong(str);
        }
        return currentTimeProvider.mo43216a() + (1000 * cacheDurationSeconds);
    }
}
