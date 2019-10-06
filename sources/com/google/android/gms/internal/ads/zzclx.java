package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzclx implements zzclw<zzbyn> {

    /* renamed from: a */
    private final zzbxo f26998a;

    /* renamed from: b */
    private final zzbbl f26999b;

    /* renamed from: c */
    private final zzcaq f27000c;

    public zzclx(zzbxo zzbxo, zzbbl zzbbl, zzcaq zzcaq) {
        this.f26998a = zzbxo;
        this.f26999b = zzbbl;
        this.f27000c = zzcaq;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        zzcxq zzcxq = zzcxm.f27565p;
        return (zzcxq == null || zzcxq.f27587c == null) ? false : true;
    }

    /* renamed from: a */
    public final zzbbh<List<zzbbh<zzbyn>>> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        zzbbh a = this.f26998a.mo29204d().mo31304a();
        this.f26998a.mo29204d().mo31306a(a);
        return zzbar.m26379a(zzbar.m26379a(a, (zzbal<? super A, ? extends B>) new C9235Xj<Object,Object>(this, zzcxm), (Executor) this.f26999b), (zzbal<? super A, ? extends B>) new C9256Yj<Object,Object>(this, zzcxu, zzcxm), (Executor) this.f26999b);
    }

    /* renamed from: a */
    private final zzbbh<zzbyn> m28574a(zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) {
        zzbbh a = this.f26998a.mo29204d().mo31304a();
        zzbbh a2 = this.f27000c.mo31088a(zzcxu, zzcxm, jSONObject);
        zzbbc a3 = zzbar.m26377a((zzbbh<? extends V>[]) new zzbbh[]{a, a2});
        C9341bk bkVar = new C9341bk(this, a2, a, zzcxu, zzcxm, jSONObject);
        return a3.mo30334a(bkVar, this.f26999b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbyn mo31208a(zzbbh zzbbh, zzbbh zzbbh2, zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) throws Exception {
        zzbyt zzbyt = (zzbyt) zzbbh.get();
        zzccj zzccj = (zzccj) zzbbh2.get();
        zzbyv a = this.f26998a.mo29200a(new zzbpr(zzcxu, zzcxm, null), new zzbzf(zzbyt), new zzbyc(jSONObject, zzccj));
        a.mo29233h().mo31109a();
        a.mo29234i().mo31119a(zzccj);
        a.mo29235j().mo31103a(zzbyt.mo31020r());
        return a.mo29232g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31207a(zzcxu zzcxu, zzcxm zzcxm, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzbar.m26375a((Throwable) new zzcgm(3));
        }
        if (zzcxu.f27595a.f27589a.f27608l <= 1) {
            return zzbar.m26380a(m28574a(zzcxu, zzcxm, jSONArray.getJSONObject(0)), C9319ak.f22093a, (Executor) this.f26999b);
        }
        int length = jSONArray.length();
        this.f26998a.mo29204d().mo31305a(Math.min(length, zzcxu.f27595a.f27589a.f27608l));
        ArrayList arrayList = new ArrayList(zzcxu.f27595a.f27589a.f27608l);
        for (int i = 0; i < zzcxu.f27595a.f27589a.f27608l; i++) {
            if (i < length) {
                arrayList.add(m28574a(zzcxu, zzcxm, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzbar.m26375a((Throwable) new zzcgm(3)));
            }
        }
        return zzbar.m26376a(arrayList);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31206a(zzcxm zzcxm, zzccj zzccj) throws Exception {
        JSONObject a = zzazc.m26264a("isNonagon", (Object) Boolean.valueOf(true));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzcxm.f27565p.f27587c);
        jSONObject.put("sdk_params", a);
        return zzbar.m26379a(zzccj.mo31110a("google.afma.nativeAds.preProcessJson", jSONObject), C9297_j.f22049a, (Executor) this.f26999b);
    }
}
