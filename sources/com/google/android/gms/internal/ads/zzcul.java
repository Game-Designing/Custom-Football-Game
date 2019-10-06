package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcul implements zzcva<zzcuk> {

    /* renamed from: a */
    private final zzbbl f27398a;

    /* renamed from: b */
    private final ScheduledExecutorService f27399b;

    /* renamed from: c */
    private final List<zzcpk> f27400c;

    /* renamed from: d */
    private final Context f27401d;

    /* renamed from: e */
    private final zzcxv f27402e;

    /* renamed from: f */
    private String f27403f;

    public zzcul(zzbbl zzbbl, ScheduledExecutorService scheduledExecutorService, String str, zzcpf zzcpf, Context context, zzcxv zzcxv) {
        this.f27398a = zzbbl;
        this.f27399b = scheduledExecutorService;
        this.f27403f = str;
        this.f27401d = context;
        this.f27402e = zzcxv;
        if (zzcpf.mo31224b().containsKey(zzcxv.f27602f)) {
            this.f27400c = (List) zzcpf.mo31224b().get(zzcxv.f27602f);
        } else {
            this.f27400c = Collections.emptyList();
        }
    }

    /* renamed from: a */
    public final zzbbh<zzcuk> mo28586a() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24048Zb)).booleanValue()) {
            return zzbar.m26379a(this.f27398a.mo30326a((Callable<T>) new C8940Jl<T>(this)), (zzbal<? super A, ? extends B>) new C8961Kl<Object,Object>(this), (Executor) this.f27398a);
        }
        return zzbar.m26376a(null);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.google.android.gms.internal.ads.zzbbh>, for r2v0, types: [java.util.List<com.google.android.gms.internal.ads.zzbbh>, java.util.List] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ com.google.android.gms.internal.ads.zzcuk m28886a(java.util.List<com.google.android.gms.internal.ads.zzbbh> r2) throws java.lang.Exception {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0009:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r2.next()
            com.google.android.gms.internal.ads.zzbbh r1 = (com.google.android.gms.internal.ads.zzbbh) r1
            java.lang.Object r1 = r1.get()     // Catch:{ InterruptedException -> 0x001f, ExecutionException -> 0x001d }
            r0.put(r1)     // Catch:{ InterruptedException -> 0x001f, ExecutionException -> 0x001d }
            goto L_0x0009
        L_0x001d:
            r1 = move-exception
            goto L_0x0020
        L_0x001f:
            r1 = move-exception
        L_0x0020:
            goto L_0x0009
        L_0x0021:
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0029
            r2 = 0
            return r2
        L_0x0029:
            com.google.android.gms.internal.ads.zzcuk r2 = new com.google.android.gms.internal.ads.zzcuk
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcul.m28886a(java.util.List):com.google.android.gms.internal.ads.zzcuk");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31264a(zzcpk zzcpk, Bundle bundle, zzcpl zzcpl, zzbbr zzbbr) {
        try {
            zzcpk.f27166d.mo29957a(ObjectWrapper.m22188a(this.f27401d), this.f27403f, bundle, zzcpk.f27165c, this.f27402e.f27601e, (zzaoy) zzcpl);
        } catch (Exception e) {
            zzbbr.mo30337a(new Exception("Error calling adapter"));
            zzbad.m26356b("", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzbbh mo31265b(List list) throws Exception {
        return zzbar.m26388b(list).mo30334a(new C9003Ml(list), this.f27398a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ List mo31266b() throws Exception {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        for (zzcpk zzcpk : this.f27400c) {
            zzbbr zzbbr = new zzbbr();
            zzcpl zzcpl = new zzcpl(zzcpk, zzbbr);
            Bundle bundle2 = this.f27402e.f27600d.f29735m;
            if (bundle2 != null) {
                bundle = bundle2.getBundle(zzcpk.f27163a);
            } else {
                bundle = null;
            }
            Bundle bundle3 = bundle;
            arrayList.add(zzbar.m26378a((zzbbh<V>) zzbbr, ((Long) zzyt.m31536e().mo29599a(zzacu.f24042Yb)).longValue(), TimeUnit.MILLISECONDS, this.f27399b));
            zzbbl zzbbl = this.f27398a;
            C8982Ll ll = new C8982Ll(this, zzcpk, bundle3, zzcpl, zzbbr);
            zzbbl.execute(ll);
        }
        return arrayList;
    }
}
