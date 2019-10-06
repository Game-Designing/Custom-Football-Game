package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.Qa */
final class C9076Qa implements zzahw {

    /* renamed from: a */
    private final zzbbr f21603a;

    /* renamed from: b */
    private final /* synthetic */ zzamd f21604b;

    public C9076Qa(zzamd zzamd, zzbbr zzbbr) {
        this.f21604b = zzamd;
        this.f21603a = zzbbr;
    }

    /* renamed from: a */
    public final void mo28373a(JSONObject jSONObject) {
        try {
            this.f21603a.mo30338b(this.f21604b.f24422a.mo28114a(jSONObject));
        } catch (IllegalStateException e) {
        } catch (JSONException e2) {
            this.f21603a.mo30338b(e2);
        }
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.f21603a.mo30337a(new zzali());
            } catch (IllegalStateException e) {
            }
        } else {
            this.f21603a.mo30337a(new zzali(str));
        }
    }
}
