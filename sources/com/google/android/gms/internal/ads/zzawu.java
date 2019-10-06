package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@zzard
public final class zzawu implements zzut {

    /* renamed from: a */
    private final Object f24922a = new Object();

    /* renamed from: b */
    private final zzaxb f24923b;

    /* renamed from: c */
    private final zzawt f24924c;
    @VisibleForTesting

    /* renamed from: d */
    private final zzawr f24925d;
    @VisibleForTesting

    /* renamed from: e */
    private final HashSet<zzawj> f24926e = new HashSet<>();
    @VisibleForTesting

    /* renamed from: f */
    private final HashSet<Object> f24927f = new HashSet<>();

    public zzawu(String str, zzaxb zzaxb) {
        this.f24925d = new zzawr(str, zzaxb);
        this.f24923b = zzaxb;
        this.f24924c = new zzawt();
    }

    /* renamed from: a */
    public final void mo30191a(zzawj zzawj) {
        synchronized (this.f24922a) {
            this.f24926e.add(zzawj);
        }
    }

    /* renamed from: a */
    public final void mo30193a(HashSet<zzawj> hashSet) {
        synchronized (this.f24922a) {
            this.f24926e.addAll(hashSet);
        }
    }

    /* renamed from: a */
    public final Bundle mo30188a(Context context, zzaws zzaws) {
        HashSet hashSet = new HashSet();
        synchronized (this.f24922a) {
            hashSet.addAll(this.f24926e);
            this.f24926e.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.f24925d.mo30181a(context, this.f24924c.mo30187b()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.f24927f.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzawj) it2.next()).mo30151a());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzaws.mo30185a(hashSet);
            return bundle;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    public final void mo28176a(boolean z) {
        long b = zzk.zzln().mo27935b();
        if (z) {
            if (b - this.f24923b.mo30217f() > ((Long) zzyt.m31536e().mo29599a(zzacu.f24084eb)).longValue()) {
                this.f24925d.f24913d = -1;
                return;
            }
            this.f24925d.f24913d = this.f24923b.mo30216e();
            return;
        }
        this.f24923b.mo30201a(b);
        this.f24923b.mo30207b(this.f24925d.f24913d);
    }

    /* renamed from: b */
    public final void mo30194b() {
        synchronized (this.f24922a) {
            this.f24925d.mo30184b();
        }
    }

    /* renamed from: a */
    public final void mo30190a() {
        synchronized (this.f24922a) {
            this.f24925d.mo30182a();
        }
    }

    /* renamed from: a */
    public final void mo30192a(zzxz zzxz, long j) {
        synchronized (this.f24922a) {
            this.f24925d.mo30183a(zzxz, j);
        }
    }

    /* renamed from: a */
    public final zzawj mo30189a(Clock clock, String str) {
        return new zzawj(clock, this, this.f24924c.mo30186a(), str);
    }
}
