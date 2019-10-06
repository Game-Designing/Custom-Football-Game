package p019d.p273h.p276c;

import java.util.Timer;
import p019d.p273h.p276c.p284h.C12906a;

/* renamed from: d.h.c.sa */
/* compiled from: RvAuctionTigger */
public class C12944sa {

    /* renamed from: a */
    private C12906a f39847a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12946ta f39848b;

    /* renamed from: c */
    private Timer f39849c = new Timer();

    public C12944sa(C12906a auctionSettings, C12946ta listener) {
        this.f39847a = auctionSettings;
        this.f39848b = listener;
    }

    /* renamed from: b */
    public synchronized void mo41766b() {
        if (!this.f39847a.mo41679c()) {
            this.f39849c.cancel();
            this.f39849c.schedule(new C12940qa(this), this.f39847a.mo41681e());
        }
    }

    /* renamed from: c */
    public synchronized void mo41767c() {
        this.f39849c.cancel();
        this.f39848b.mo41285a();
    }

    /* renamed from: a */
    public synchronized void mo41765a() {
        this.f39849c.cancel();
        this.f39849c.schedule(new C12942ra(this), this.f39847a.mo41677a());
    }
}
