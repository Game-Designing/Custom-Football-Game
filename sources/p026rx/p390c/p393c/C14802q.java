package p026rx.p390c.p393c;

import java.util.concurrent.TimeUnit;
import p026rx.C0126V.C0127a;
import p026rx.p027b.C0128a;
import p026rx.p390c.p393c.C14803r.C14804a;
import p026rx.p390c.p394d.C14821b;

/* renamed from: rx.c.c.q */
/* compiled from: SchedulePeriodicHelper */
class C14802q implements C0128a {

    /* renamed from: a */
    long f44036a;

    /* renamed from: b */
    long f44037b = this.f44039d;

    /* renamed from: c */
    long f44038c = this.f44040e;

    /* renamed from: d */
    final /* synthetic */ long f44039d;

    /* renamed from: e */
    final /* synthetic */ long f44040e;

    /* renamed from: f */
    final /* synthetic */ C0128a f44041f;

    /* renamed from: g */
    final /* synthetic */ C14821b f44042g;

    /* renamed from: h */
    final /* synthetic */ C14804a f44043h;

    /* renamed from: i */
    final /* synthetic */ C0127a f44044i;

    /* renamed from: j */
    final /* synthetic */ long f44045j;

    C14802q(long j, long j2, C0128a aVar, C14821b bVar, C14804a aVar2, C0127a aVar3, long j3) {
        this.f44039d = j;
        this.f44040e = j2;
        this.f44041f = aVar;
        this.f44042g = bVar;
        this.f44043h = aVar2;
        this.f44044i = aVar3;
        this.f44045j = j3;
    }

    public void call() {
        long nextTick;
        this.f44041f.call();
        if (!this.f44042g.isUnsubscribed()) {
            C14804a aVar = this.f44043h;
            long nowNanos = aVar != null ? aVar.mo45938a() : TimeUnit.MILLISECONDS.toNanos(this.f44044i.mo3710b());
            long j = C14803r.f44046a;
            long j2 = nowNanos + j;
            long j3 = this.f44037b;
            if (j2 >= j3) {
                long j4 = this.f44045j;
                if (nowNanos < j3 + j4 + j) {
                    long j5 = this.f44038c;
                    long j6 = this.f44036a + 1;
                    this.f44036a = j6;
                    nextTick = j5 + (j6 * j4);
                    this.f44037b = nowNanos;
                    this.f44042g.mo45948a(this.f44044i.mo3709a(this, nextTick - nowNanos, TimeUnit.NANOSECONDS));
                }
            }
            long nextTick2 = this.f44045j;
            long nextTick3 = nowNanos + nextTick2;
            long j7 = this.f44036a + 1;
            this.f44036a = j7;
            this.f44038c = nextTick3 - (nextTick2 * j7);
            nextTick = nextTick3;
            this.f44037b = nowNanos;
            this.f44042g.mo45948a(this.f44044i.mo3709a(this, nextTick - nowNanos, TimeUnit.NANOSECONDS));
        }
    }
}
