package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
public final class zzalu<I, O> implements zzalj<I, O> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzall<O> f24416a;

    /* renamed from: b */
    private final zzalm<I> f24417b;

    /* renamed from: c */
    private final zzakh f24418c;

    /* renamed from: d */
    private final String f24419d;

    zzalu(zzakh zzakh, String str, zzalm<I> zzalm, zzall<O> zzall) {
        this.f24418c = zzakh;
        this.f24419d = str;
        this.f24417b = zzalm;
        this.f24416a = zzall;
    }

    /* renamed from: b */
    public final zzbbh<O> mo29805b(I i) {
        zzbbr zzbbr = new zzbbr();
        zzakw b = this.f24418c.mo29797b((zzdh) null);
        b.mo30344a(new C8887Ha(this, b, i, zzbbr), new C8908Ia(this, zzbbr, b));
        return zzbbr;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25206a(zzakw zzakw, zzalf zzalf, I i, zzbbr<O> zzbbr) {
        try {
            zzk.zzlg();
            String a = zzaxi.m26104a();
            zzagz.f24335o.mo29741a(a, (zzahw) new C8929Ja(this, zzakw, zzbbr));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", a);
            jSONObject.put("args", this.f24417b.mo28177a(i));
            zzalf.mo28740b(this.f24419d, jSONObject);
        } catch (Exception e) {
            zzbbr.mo30337a(e);
            zzbad.m26356b("Unable to invokeJavascript", e);
            zzakw.mo29798c();
        } catch (Throwable th) {
            zzakw.mo29798c();
            throw th;
        }
    }

    /* renamed from: a */
    public final zzbbh<O> mo26658a(I i) throws Exception {
        return mo29805b(i);
    }
}
