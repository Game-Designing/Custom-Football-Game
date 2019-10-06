package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzasj extends zzasl {

    /* renamed from: a */
    private final Object f24797a = new Object();

    /* renamed from: b */
    private final Context f24798b;

    /* renamed from: c */
    private SharedPreferences f24799c;

    /* renamed from: d */
    private final zzalj<JSONObject, JSONObject> f24800d;

    public zzasj(Context context, zzalj<JSONObject, JSONObject> zzalj) {
        this.f24798b = context.getApplicationContext();
        this.f24800d = zzalj;
    }

    /* renamed from: a */
    public final zzbbh<Void> mo30046a() {
        synchronized (this.f24797a) {
            if (this.f24799c == null) {
                this.f24799c = this.f24798b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzk.zzln().mo27935b() - this.f24799c.getLong("js_last_update", 0) < ((Long) zzyt.m31536e().mo29599a(zzacu.f23905Bc)).longValue()) {
            return zzbar.m26376a(null);
        }
        return zzbar.m26380a(this.f24800d.mo29805b(m25733a(this.f24798b)), (zzbam<A, B>) new C9745ub<A,B>(this), zzbbm.f25065b);
    }

    /* renamed from: a */
    public static JSONObject m25733a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbai.m26367a().f25057a);
            jSONObject.put("mf", zzyt.m31536e().mo29599a(zzacu.f23911Cc));
            jSONObject.put("cl", "248613007");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 11140);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.m22219b(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ Void mo30047a(JSONObject jSONObject) {
        zzacu.m24783a(this.f24798b, 1, jSONObject);
        this.f24799c.edit().putLong("js_last_update", zzk.zzln().mo27935b()).apply();
        return null;
    }
}
