package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Nc */
class C7095Nc extends C7184mb {

    /* renamed from: f */
    private final C7059Ec f13318f;

    /* renamed from: g */
    final /* synthetic */ C7134a f13319g;

    private C7095Nc(C7134a aVar, C7059Ec ec) {
        this.f13319g = aVar;
        super("UpdateAdTask", aVar.f13434e);
        this.f13318f = ec;
    }

    /* synthetic */ C7095Nc(C7134a aVar, C7059Ec ec, C7075Ic ic) {
        this(aVar, ec);
    }

    public void run() {
        C7262l lVar = this.f13626c;
        StringBuilder sb = new StringBuilder();
        sb.append("Attempt update for spec: ");
        sb.append(this.f13318f);
        lVar.mo22918c("AppLovinAdService", sb.toString());
        C7091Mc b = this.f13319g.m15009c(this.f13318f);
        synchronized (b.f13304a) {
            boolean i = this.f13318f.mo22810i();
            boolean d = this.f13319g.m15008b();
            boolean z = false;
            boolean z2 = !b.f13308e.isEmpty();
            if (System.currentTimeMillis() > b.f13306c) {
                z = true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Update ad states - isRefreshEnabled=");
            sb2.append(i);
            sb2.append(" hasUpdateListeners=");
            sb2.append(z2);
            sb2.append(" isCurrentAdExpired=");
            sb2.append(z);
            sb2.append(" isDeviceOn=");
            sb2.append(d);
            sb2.append(" isWaitingForAd=");
            sb2.append(b.f13307d);
            this.f13626c.mo22918c("AppLovinAdService", sb2.toString());
            if (!i || !z2 || !z || !d || b.f13307d) {
                this.f13626c.mo22918c("AppLovinAdService", "Ad update skipped");
            } else {
                this.f13626c.mo22918c("AppLovinAdService", "Performing ad update...");
                b.f13307d = true;
                this.f13319g.m14999a(this.f13318f, new C7087Lc(this.f13319g, b, null));
            }
        }
    }
}
