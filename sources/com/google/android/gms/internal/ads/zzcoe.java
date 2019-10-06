package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbsm;
import java.util.Iterator;

public final class zzcoe<AdT, AdapterT, ListenerT extends zzbsm> implements zzcjv<AdT> {

    /* renamed from: a */
    private final zzcjz<AdapterT, ListenerT> f27108a;

    /* renamed from: b */
    private final zzcka<AdT, AdapterT, ListenerT> f27109b;

    /* renamed from: c */
    private final zzczt f27110c;

    /* renamed from: d */
    private final zzbbl f27111d;

    public zzcoe(zzczt zzczt, zzbbl zzbbl, zzcjz<AdapterT, ListenerT> zzcjz, zzcka<AdT, AdapterT, ListenerT> zzcka) {
        this.f27110c = zzczt;
        this.f27111d = zzbbl;
        this.f27109b = zzcka;
        this.f27108a = zzcjz;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        return !zzcxm.f27566q.isEmpty();
    }

    /* renamed from: a */
    public final zzbbh<AdT> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        zzcjy zzcjy;
        Iterator it = zzcxm.f27566q.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcjy = null;
                break;
            }
            try {
                zzcjy = this.f27108a.mo31189a((String) it.next(), zzcxm.f27568s);
                break;
            } catch (Throwable th) {
            }
        }
        if (zzcjy == null) {
            return zzbar.m26375a((Throwable) new zzcmk("unable to instantiate mediation adapter class"));
        }
        zzbbr zzbbr = new zzbbr();
        zzcjy.f26730c.mo30888a(new C8771Bk(this, zzbbr, zzcjy));
        if (zzcxm.f27539E) {
            Bundle bundle = zzcxu.f27595a.f27589a.f27600d.f29735m;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.f27110c.mo31318a(zzczs.ADAPTER_LOAD_AD_SYN).mo31323a((zzczd) new C9859zk(this, zzcxu, zzcxm, zzcjy), this.f27111d).mo31332a(zzczs.ADAPTER_LOAD_AD_ACK).mo31328a((zzbbh<O2>) zzbbr).mo31332a(zzczs.ADAPTER_WRAP_ADAPTER).mo31329a((zzczc<O, O2>) new C8750Ak<O,O2>(this, zzcxu, zzcxm, zzcjy)).mo31325a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ Object mo31215a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy, Void voidR) throws Exception {
        return this.f27109b.mo31190a(zzcxu, zzcxm, zzcjy);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31216a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws Exception {
        this.f27109b.mo31191b(zzcxu, zzcxm, zzcjy);
    }
}
