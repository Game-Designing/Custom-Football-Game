package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0126V.C0127a;
import p026rx.C14508U;
import p026rx.p027b.C0128a;
import p026rx.p390c.p392b.C14771b;

/* renamed from: rx.c.a.Q */
/* compiled from: OnSubscribeRedo */
class C14614Q implements C14508U {

    /* renamed from: a */
    final /* synthetic */ AtomicLong f43523a;

    /* renamed from: b */
    final /* synthetic */ C14771b f43524b;

    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f43525c;

    /* renamed from: d */
    final /* synthetic */ C0127a f43526d;

    /* renamed from: e */
    final /* synthetic */ C0128a f43527e;

    /* renamed from: f */
    final /* synthetic */ C14622S f43528f;

    C14614Q(C14622S s, AtomicLong atomicLong, C14771b bVar, AtomicBoolean atomicBoolean, C0127a aVar, C0128a aVar2) {
        this.f43528f = s;
        this.f43523a = atomicLong;
        this.f43524b = bVar;
        this.f43525c = atomicBoolean;
        this.f43526d = aVar;
        this.f43527e = aVar2;
    }

    public void request(long n) {
        if (n > 0) {
            C14640a.m46283a(this.f43523a, n);
            this.f43524b.request(n);
            if (this.f43525c.compareAndSet(true, false)) {
                this.f43526d.mo3707a(this.f43527e);
            }
        }
    }
}
