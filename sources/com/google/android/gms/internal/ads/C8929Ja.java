package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.Ja */
final class C8929Ja implements zzahw {

    /* renamed from: a */
    private final zzakw f21276a;

    /* renamed from: b */
    private final zzbbr f21277b;

    /* renamed from: c */
    private final /* synthetic */ zzalu f21278c;

    public C8929Ja(zzalu zzalu, zzakw zzakw, zzbbr zzbbr) {
        this.f21278c = zzalu;
        this.f21276a = zzakw;
        this.f21277b = zzbbr;
    }

    /* renamed from: a */
    public final void mo28373a(JSONObject jSONObject) {
        try {
            this.f21277b.mo30338b(this.f21278c.f24416a.mo28114a(jSONObject));
        } catch (IllegalStateException e) {
        } catch (JSONException e2) {
            this.f21277b.mo30338b(e2);
        } finally {
            this.f21276a.mo29798c();
        }
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.f21277b.mo30337a(new zzali());
            } catch (IllegalStateException e) {
                this.f21276a.mo29798c();
                return;
            } catch (Throwable th) {
                this.f21276a.mo29798c();
                throw th;
            }
        } else {
            this.f21277b.mo30337a(new zzali(str));
        }
        this.f21276a.mo29798c();
    }
}
