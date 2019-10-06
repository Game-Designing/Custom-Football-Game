package p019d.p143b.p144a.p146b;

import java.util.concurrent.TimeUnit;

/* renamed from: d.b.a.b.M */
class C6968M implements C7024s {

    /* renamed from: a */
    final /* synthetic */ long f12916a;

    /* renamed from: b */
    final /* synthetic */ C6950D f12917b;

    C6968M(C6950D d, long j) {
        this.f12917b = d;
        this.f12916a = j;
    }

    /* renamed from: a */
    public void mo22553a() {
        if (this.f12917b.f12849M != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f12916a - ((long) this.f12917b.f12844H.getCurrentPosition()));
            if (seconds <= 0) {
                this.f12917b.f12849M.setVisibility(8);
                this.f12917b.f12880x = true;
            } else if (this.f12917b.m14260T()) {
                this.f12917b.f12849M.mo22639a((int) seconds);
            }
        }
    }

    /* renamed from: b */
    public boolean mo22554b() {
        return this.f12917b.m14260T();
    }
}
