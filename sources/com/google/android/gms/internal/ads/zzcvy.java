package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final class zzcvy implements zzcva<zzcvx> {

    /* renamed from: a */
    private final zzasc f27478a;

    /* renamed from: b */
    private final Context f27479b;

    /* renamed from: c */
    private final String f27480c;

    /* renamed from: d */
    private final zzbbl f27481d;

    public zzcvy(zzasc zzasc, Context context, String str, zzbbl zzbbl) {
        this.f27478a = zzasc;
        this.f27479b = context;
        this.f27480c = str;
        this.f27481d = zzbbl;
    }

    /* renamed from: a */
    public final zzbbh<zzcvx> mo28586a() {
        return this.f27481d.mo30326a((Callable<T>) new C9279Zl<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcvx mo31273b() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzasc zzasc = this.f27478a;
        if (zzasc != null) {
            zzasc.mo30038a(this.f27479b, this.f27480c, jSONObject);
        }
        return new zzcvx(jSONObject);
    }
}
