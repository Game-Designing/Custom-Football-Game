package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzccj {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C9493ii f26370a = new C9493ii(null);

    /* renamed from: b */
    private final zza f26371b;

    /* renamed from: c */
    private final zzbhf f26372c;

    /* renamed from: d */
    private final Context f26373d;

    /* renamed from: e */
    private final Executor f26374e;

    /* renamed from: f */
    private final zzdh f26375f;

    /* renamed from: g */
    private final zzbai f26376g;

    /* renamed from: h */
    private final zzahu f26377h;

    /* renamed from: i */
    private zzbbh<zzbgz> f26378i;

    public zzccj(Context context, Executor executor, zzdh zzdh, zzbai zzbai, zza zza, zzbhf zzbhf) {
        this.f26373d = context;
        this.f26374e = executor;
        this.f26375f = zzdh;
        this.f26376g = zzbai;
        this.f26371b = zza;
        this.f26372c = zzbhf;
        this.f26377h = new zzahu();
    }

    /* renamed from: b */
    public final synchronized void mo31117b() {
        this.f26378i = zzbar.m26380a(zzbhf.m26876a(this.f26373d, this.f26376g, (String) zzyt.m31536e().mo29599a(zzacu.f23929Fc), this.f26375f, this.f26371b), (zzbam<A, B>) new C9361ci<A,B>(this), this.f26374e);
        zzbao.m26373a(this.f26378i, "NativeJavascriptExecutor.initializeEngine");
    }

    /* renamed from: a */
    public final synchronized void mo31113a() {
        if (this.f26378i != null) {
            zzbar.m26383a(this.f26378i, (zzban<? super V>) new C9405ei<Object>(this), this.f26374e);
            this.f26378i = null;
        }
    }

    /* renamed from: a */
    public final synchronized zzbbh<JSONObject> mo31110a(String str, JSONObject jSONObject) {
        if (this.f26378i == null) {
            return zzbar.m26376a(null);
        }
        return zzbar.m26379a(this.f26378i, (zzbal<? super A, ? extends B>) new C9383di<Object,Object>(this, str, jSONObject), this.f26374e);
    }

    /* renamed from: a */
    public final synchronized void mo31114a(String str, zzaho<Object> zzaho) {
        if (this.f26378i != null) {
            zzbar.m26383a(this.f26378i, (zzban<? super V>) new C9427fi<Object>(this, str, zzaho), this.f26374e);
        }
    }

    /* renamed from: b */
    public final synchronized void mo31118b(String str, zzaho<Object> zzaho) {
        if (this.f26378i != null) {
            zzbar.m26383a(this.f26378i, (zzban<? super V>) new C9449gi<Object>(this, str, zzaho), this.f26374e);
        }
    }

    /* renamed from: a */
    public final synchronized void mo31115a(String str, Map<String, ?> map) {
        if (this.f26378i != null) {
            zzbar.m26383a(this.f26378i, (zzban<? super V>) new C9471hi<Object>(this, str, map), this.f26374e);
        }
    }

    /* renamed from: a */
    public final <T> void mo31116a(WeakReference<T> weakReference, String str, zzaho<T> zzaho) {
        C9537ki kiVar = new C9537ki(this, weakReference, str, zzaho, null);
        mo31114a(str, (zzaho<Object>) kiVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31111a(String str, JSONObject jSONObject, zzbgz zzbgz) throws Exception {
        return this.f26377h.mo29740a(zzbgz, str, jSONObject);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbgz mo31112a(zzbgz zzbgz) {
        zzbgz.mo28726a("/result", (zzaho<? super zzbgz>) this.f26377h);
        zzbii a = zzbgz.mo28714a();
        C9493ii iiVar = this.f26370a;
        a.mo30599a(null, iiVar, iiVar, iiVar, iiVar, false, null, new zzb(this.f26373d, null, null), null, null);
        return zzbgz;
    }
}
