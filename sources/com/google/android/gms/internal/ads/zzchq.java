package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzchq {

    /* renamed from: a */
    private final Context f26641a;

    /* renamed from: b */
    private final zzbai f26642b;

    /* renamed from: c */
    private final zzcxv f26643c;

    /* renamed from: d */
    private final Executor f26644d;

    public zzchq(Context context, zzbai zzbai, zzcxv zzcxv, Executor executor) {
        this.f26641a = context;
        this.f26642b = zzbai;
        this.f26643c = zzcxv;
        this.f26644d = executor;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final zzbbh<zzcxu> mo31164a() {
        zzalr b = zzk.zzlt().mo29807b(this.f26641a, this.f26642b);
        zzaln<JSONObject> zzaln = zzalo.f24411b;
        zzalj a = b.mo29808a("google.afma.response.normalize", zzaln, zzaln);
        return zzbar.m26379a(zzbar.m26379a(zzbar.m26379a((zzbbh<A>) zzbar.m26376a(""), (zzbal<? super A, ? extends B>) new C9234Xi<Object,Object>(this, this.f26643c.f27600d.f29741s), this.f26644d), (zzbal<? super A, ? extends B>) new C9255Yi<Object,Object>(a), this.f26644d), (zzbal<? super A, ? extends B>) new C9276Zi<Object,Object>(this), this.f26644d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31165a(JSONObject jSONObject) throws Exception {
        return zzbar.m26376a(new zzcxu(new zzcxr(this.f26643c), zzcxs.m28953a(new StringReader(jSONObject.toString()))));
    }
}
