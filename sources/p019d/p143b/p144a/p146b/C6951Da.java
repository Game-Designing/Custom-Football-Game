package p019d.p143b.p144a.p146b;

import java.lang.ref.WeakReference;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7256f;
import p019d.p143b.p150d.C7259i;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.Da */
class C6951Da implements C7254d, C7259i {

    /* renamed from: a */
    private C6988a f12883a;

    /* renamed from: b */
    private WeakReference<C6988a> f12884b;

    /* renamed from: c */
    private final C7256f f12885c;

    /* renamed from: d */
    private final C7262l f12886d;

    C6951Da(C6988a aVar, C7267q qVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("No view specified");
        } else if (qVar != null) {
            this.f12886d = qVar.mo23049b();
            this.f12885c = qVar.mo23037a();
            if (new C7212tb(qVar).mo23276R()) {
                this.f12883a = aVar;
            } else {
                this.f12884b = new WeakReference<>(aVar);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private C6988a m14344a() {
        C6988a aVar = this.f12883a;
        return aVar != null ? aVar : (C6988a) this.f12884b.get();
    }

    /* renamed from: a */
    public void mo22516a(C7251a aVar) {
        C6988a a = m14344a();
        if (a != null) {
            a.mo22580a(aVar);
            return;
        }
        this.f12885c.mo23009a((C7259i) this, aVar.mo22756a());
        this.f12886d.mo22921e("AppLovinAdView", "Ad view has been garbage collected by the time an ad was updated");
    }

    public void adReceived(C7251a aVar) {
        C6988a a = m14344a();
        if (a != null) {
            a.mo22580a(aVar);
        } else {
            this.f12886d.mo22921e("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
        }
    }

    public void failedToReceiveAd(int i) {
        C6988a a = m14344a();
        if (a != null) {
            a.mo22582b(i);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[AdViewController listener: ");
        sb.append(hashCode());
        sb.append("]");
        return sb.toString();
    }
}
