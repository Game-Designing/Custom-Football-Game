package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbmy implements zzue {

    /* renamed from: a */
    private zzbgz f25589a;

    /* renamed from: b */
    private final Executor f25590b;

    /* renamed from: c */
    private final zzbml f25591c;

    /* renamed from: d */
    private final Clock f25592d;

    /* renamed from: e */
    private boolean f25593e = false;

    /* renamed from: f */
    private boolean f25594f = false;

    /* renamed from: g */
    private zzbmp f25595g = new zzbmp();

    public zzbmy(Executor executor, zzbml zzbml, Clock clock) {
        this.f25590b = executor;
        this.f25591c = zzbml;
        this.f25592d = clock;
    }

    /* renamed from: E */
    private final void m27273E() {
        try {
            JSONObject a = this.f25591c.mo28177a(this.f25595g);
            if (this.f25589a != null) {
                this.f25590b.execute(new C9122Sf(this, a));
            }
        } catch (JSONException e) {
            zzawz.m26002e("Failed to call video active view js", e);
        }
    }

    /* renamed from: a */
    public final void mo28694a(zzud zzud) {
        this.f25595g.f25558a = this.f25594f ? false : zzud.f29465m;
        this.f25595g.f25561d = this.f25592d.mo27934a();
        this.f25595g.f25563f = zzud;
        if (this.f25593e) {
            m27273E();
        }
    }

    /* renamed from: a */
    public final void mo30746a(zzbgz zzbgz) {
        this.f25589a = zzbgz;
    }

    /* renamed from: C */
    public final void mo30744C() {
        this.f25593e = false;
    }

    /* renamed from: D */
    public final void mo30745D() {
        this.f25593e = true;
        m27273E();
    }

    /* renamed from: f */
    public final void mo30748f(boolean z) {
        this.f25594f = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30747a(JSONObject jSONObject) {
        this.f25589a.mo28740b("AFMA_updateActiveView", jSONObject);
    }
}
