package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzbde {

    /* renamed from: a */
    public final boolean f25147a;

    /* renamed from: b */
    public final int f25148b;

    /* renamed from: c */
    public final int f25149c;

    /* renamed from: d */
    public final int f25150d;

    /* renamed from: e */
    public final String f25151e;

    /* renamed from: f */
    public final int f25152f;

    /* renamed from: g */
    public final int f25153g;

    /* renamed from: h */
    public final int f25154h;

    /* renamed from: i */
    public final int f25155i;

    /* renamed from: j */
    public final boolean f25156j;

    public zzbde(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
            }
        }
        this.f25147a = m26515a(jSONObject, "aggressive_media_codec_release", zzacu.f23986P);
        this.f25148b = m26517b(jSONObject, "byte_buffer_precache_limit", zzacu.f24202y);
        this.f25149c = m26517b(jSONObject, "exo_cache_buffer_size", zzacu.f23914D);
        this.f25150d = m26517b(jSONObject, "exo_connect_timeout_millis", zzacu.f24178u);
        this.f25151e = m26518c(jSONObject, "exo_player_version", zzacu.f24172t);
        this.f25152f = m26517b(jSONObject, "exo_read_timeout_millis", zzacu.f24184v);
        this.f25153g = m26517b(jSONObject, "load_check_interval_bytes", zzacu.f24190w);
        this.f25154h = m26517b(jSONObject, "player_precache_limit", zzacu.f24196x);
        this.f25155i = m26517b(jSONObject, "socket_receive_buffer_size", zzacu.f24208z);
        this.f25156j = m26515a(jSONObject, "use_cache_data_source", zzacu.f24188vd);
    }

    /* renamed from: a */
    private static boolean m26515a(JSONObject jSONObject, String str, zzacj<Boolean> zzacj) {
        return m26516a(jSONObject, str, ((Boolean) zzyt.m31536e().mo29599a(zzacj)).booleanValue());
    }

    /* renamed from: a */
    private static boolean m26516a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException e) {
            }
        }
        return z;
    }

    /* renamed from: b */
    private static int m26517b(JSONObject jSONObject, String str, zzacj<Integer> zzacj) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException e) {
            }
        }
        return ((Integer) zzyt.m31536e().mo29599a(zzacj)).intValue();
    }

    /* renamed from: c */
    private static String m26518c(JSONObject jSONObject, String str, zzacj<String> zzacj) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
            }
        }
        return (String) zzyt.m31536e().mo29599a(zzacj);
    }
}
