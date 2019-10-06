package p019d.p143b.p144a.p147c;

import android.app.Activity;
import java.util.Timer;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7255e;

/* renamed from: d.b.a.c.U */
class C7114U {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13382a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C7080K f13383b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Activity f13384c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Runnable f13385d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C7255e f13386e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Timer f13387f;

    private C7114U(C7129Z z) {
        this.f13382a = z.f13417a;
        this.f13383b = z.f13418b;
        this.f13384c = z.f13419c;
        this.f13385d = z.f13421e;
        this.f13386e = z.f13420d;
        this.f13387f = new Timer("IncentivizedAdLauncher");
    }

    /* synthetic */ C7114U(C7129Z z, C7117V v) {
        this(z);
    }

    /* renamed from: a */
    static C7129Z m14935a() {
        return new C7129Z(null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22978a(C7251a aVar) {
        this.f13384c.runOnUiThread(new C7117V(this, aVar));
    }
}
