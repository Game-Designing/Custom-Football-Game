package p026rx;

import java.util.concurrent.TimeUnit;
import p026rx.C0117M.C0118a;
import p026rx.C0126V.C0127a;
import p026rx.p029i.C0136c;

/* renamed from: rx.j */
/* compiled from: Completable */
class C14981j implements C0118a {

    /* renamed from: a */
    final /* synthetic */ C0126V f44330a;

    /* renamed from: b */
    final /* synthetic */ long f44331b;

    /* renamed from: c */
    final /* synthetic */ TimeUnit f44332c;

    /* renamed from: d */
    final /* synthetic */ boolean f44333d;

    /* renamed from: e */
    final /* synthetic */ C0117M f44334e;

    C14981j(C0117M m, C0126V v, long j, TimeUnit timeUnit, boolean z) {
        this.f44334e = m;
        this.f44330a = v;
        this.f44331b = j;
        this.f44332c = timeUnit;
        this.f44333d = z;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        C0136c set = new C0136c();
        C0127a w = this.f44330a.createWorker();
        set.mo3713a((C0137ja) w);
        this.f44334e.mo3599b((C14503O) new C14973i(this, set, w, s));
    }
}
