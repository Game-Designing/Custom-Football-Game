package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzv {

    /* renamed from: a */
    private final AtomicInteger f29512a;

    /* renamed from: b */
    private final Set<zzr<?>> f29513b;

    /* renamed from: c */
    private final PriorityBlockingQueue<zzr<?>> f29514c;

    /* renamed from: d */
    private final PriorityBlockingQueue<zzr<?>> f29515d;

    /* renamed from: e */
    private final zzb f29516e;

    /* renamed from: f */
    private final zzm f29517f;

    /* renamed from: g */
    private final zzab f29518g;

    /* renamed from: h */
    private final zzn[] f29519h;

    /* renamed from: i */
    private zzd f29520i;

    /* renamed from: j */
    private final List<zzx> f29521j;

    /* renamed from: k */
    private final List<zzw> f29522k;

    private zzv(zzb zzb, zzm zzm, int i, zzab zzab) {
        this.f29512a = new AtomicInteger();
        this.f29513b = new HashSet();
        this.f29514c = new PriorityBlockingQueue<>();
        this.f29515d = new PriorityBlockingQueue<>();
        this.f29521j = new ArrayList();
        this.f29522k = new ArrayList();
        this.f29516e = zzb;
        this.f29517f = zzm;
        this.f29519h = new zzn[4];
        this.f29518g = zzab;
    }

    private zzv(zzb zzb, zzm zzm, int i) {
        this(zzb, zzm, 4, new zzi(new Handler(Looper.getMainLooper())));
    }

    public zzv(zzb zzb, zzm zzm) {
        this(zzb, zzm, 4);
    }

    /* renamed from: a */
    public final void mo32301a() {
        zzn[] zznArr;
        zzd zzd = this.f29520i;
        if (zzd != null) {
            zzd.mo31335a();
        }
        for (zzn zzn : this.f29519h) {
            if (zzn != null) {
                zzn.mo32021a();
            }
        }
        this.f29520i = new zzd(this.f29514c, this.f29515d, this.f29516e, this.f29518g);
        this.f29520i.start();
        for (int i = 0; i < this.f29519h.length; i++) {
            zzn zzn2 = new zzn(this.f29515d, this.f29517f, this.f29516e, this.f29518g);
            this.f29519h[i] = zzn2;
            zzn2.start();
        }
    }

    /* renamed from: a */
    public final <T> zzr<T> mo32300a(zzr<T> zzr) {
        zzr.mo32121a(this);
        synchronized (this.f29513b) {
            this.f29513b.add(zzr);
        }
        zzr.mo32127b(this.f29512a.incrementAndGet());
        zzr.mo32126a("add-to-queue");
        mo32302a(zzr, 0);
        if (!zzr.mo32137v()) {
            this.f29515d.add(zzr);
            return zzr;
        }
        this.f29514c.add(zzr);
        return zzr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final <T> void mo32303b(zzr<T> zzr) {
        synchronized (this.f29513b) {
            this.f29513b.remove(zzr);
        }
        synchronized (this.f29521j) {
            for (zzx a : this.f29521j) {
                a.mo32359a(zzr);
            }
        }
        mo32302a(zzr, 5);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32302a(zzr<?> zzr, int i) {
        synchronized (this.f29522k) {
            for (zzw a : this.f29522k) {
                a.mo32327a(zzr, i);
            }
        }
    }
}
