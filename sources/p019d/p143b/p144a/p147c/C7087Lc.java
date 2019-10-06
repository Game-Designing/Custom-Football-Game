package p019d.p143b.p144a.p147c;

import java.util.HashSet;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7259i;

/* renamed from: d.b.a.c.Lc */
class C7087Lc implements C7254d {

    /* renamed from: a */
    private final C7091Mc f13296a;

    /* renamed from: b */
    final /* synthetic */ C7134a f13297b;

    private C7087Lc(C7134a aVar, C7091Mc mc) {
        this.f13297b = aVar;
        this.f13296a = mc;
    }

    /* synthetic */ C7087Lc(C7134a aVar, C7091Mc mc, C7075Ic ic) {
        this(aVar, mc);
    }

    public void adReceived(C7251a aVar) {
        HashSet<C7254d> hashSet;
        HashSet<C7259i> hashSet2;
        C7059Ec n = ((C7071Hc) aVar).mo22762n();
        if (!(aVar instanceof C7048C) && n.mo22813l()) {
            this.f13297b.f13434e.mo23063h().adReceived(aVar);
            aVar = new C7048C(n, this.f13297b.f13434e);
        }
        synchronized (this.f13296a.f13304a) {
            if (n.mo22810i()) {
                long j = n.mo22811j();
                if (j > 0) {
                    this.f13296a.f13306c = System.currentTimeMillis() + (j * 1000);
                } else if (j == 0) {
                    this.f13296a.f13306c = Long.MAX_VALUE;
                }
                this.f13296a.f13305b = aVar;
            } else {
                this.f13296a.f13305b = null;
                this.f13296a.f13306c = 0;
            }
            hashSet = new HashSet<>(this.f13296a.f13309f);
            this.f13296a.f13309f.clear();
            hashSet2 = new HashSet<>(this.f13296a.f13308e);
            this.f13296a.f13307d = false;
        }
        this.f13297b.m15011d(n);
        for (C7254d adReceived : hashSet) {
            try {
                adReceived.adReceived(aVar);
            } catch (Throwable th) {
                this.f13297b.f13435f.mo22917b("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            }
        }
        for (C7259i a : hashSet2) {
            try {
                a.mo22516a(aVar);
            } catch (Throwable th2) {
                this.f13297b.f13435f.mo22917b("AppLovinAdService", "Unable to notify listener about an updated loaded ad", th2);
            }
        }
    }

    public void failedToReceiveAd(int i) {
        HashSet<C7254d> hashSet;
        synchronized (this.f13296a.f13304a) {
            hashSet = new HashSet<>(this.f13296a.f13309f);
            this.f13296a.f13309f.clear();
            this.f13296a.f13307d = false;
        }
        for (C7254d failedToReceiveAd : hashSet) {
            try {
                failedToReceiveAd.failedToReceiveAd(i);
            } catch (Throwable th) {
                this.f13297b.f13435f.mo22917b("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            }
        }
    }
}
