package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
public final class zzamd<I, O> implements zzbal<I, O> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzall<O> f24422a;

    /* renamed from: b */
    private final zzalm<I> f24423b;

    /* renamed from: c */
    private final String f24424c;

    /* renamed from: d */
    private final zzbbh<zzalf> f24425d;

    zzamd(zzbbh<zzalf> zzbbh, String str, zzalm<I> zzalm, zzall<O> zzall) {
        this.f24425d = zzbbh;
        this.f24424c = str;
        this.f24423b = zzalm;
        this.f24422a = zzall;
    }

    /* renamed from: a */
    public final zzbbh<O> mo26658a(I i) throws Exception {
        return zzbar.m26379a(this.f24425d, (zzbal<? super A, ? extends B>) new C9055Pa<Object,Object>(this, i), zzbbm.f25065b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo29813a(Object obj, zzalf zzalf) throws Exception {
        zzbbr zzbbr = new zzbbr();
        zzk.zzlg();
        String a = zzaxi.m26104a();
        zzagz.f24335o.mo29741a(a, (zzahw) new C9076Qa(this, zzbbr));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", a);
        jSONObject.put("args", this.f24423b.mo28177a(obj));
        zzalf.mo28740b(this.f24424c, jSONObject);
        return zzbbr;
    }
}
