package p019d.p143b.p144a.p147c;

import java.util.Collection;
import java.util.HashSet;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7259i;

/* renamed from: d.b.a.c.Mc */
class C7091Mc {

    /* renamed from: a */
    final Object f13304a;

    /* renamed from: b */
    C7251a f13305b;

    /* renamed from: c */
    long f13306c;

    /* renamed from: d */
    boolean f13307d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Collection<C7259i> f13308e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Collection<C7254d> f13309f;

    private C7091Mc() {
        this.f13304a = new Object();
        this.f13308e = new HashSet();
        this.f13309f = new HashSet();
    }

    /* synthetic */ C7091Mc(C7075Ic ic) {
        this();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdLoadState{loadedAd=");
        sb.append(this.f13305b);
        sb.append(", loadedAdExpiration=");
        sb.append(this.f13306c);
        sb.append(", isWaitingForAd=");
        sb.append(this.f13307d);
        sb.append(", updateListeners=");
        sb.append(this.f13308e);
        sb.append(", pendingAdListeners=");
        sb.append(this.f13309f);
        sb.append('}');
        return sb.toString();
    }
}
