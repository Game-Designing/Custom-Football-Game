package p019d.p143b.p144a.p147c;

import android.app.Activity;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Ia */
class C7073Ia implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7177kc f13245a;

    /* renamed from: b */
    final /* synthetic */ C7235za f13246b;

    /* renamed from: c */
    final /* synthetic */ Activity f13247c;

    /* renamed from: d */
    final /* synthetic */ C7053Da f13248d;

    C7073Ia(C7053Da da, C7177kc kcVar, C7235za zaVar, Activity activity) {
        this.f13248d = da;
        this.f13245a = kcVar;
        this.f13246b = zaVar;
        this.f13247c = activity;
    }

    public void run() {
        C7077Ja ja = new C7077Ja(this);
        String str = ": ";
        String str2 = "Failed to display ";
        String str3 = "MediationAdapterWrapper";
        if (this.f13246b.mo22759d() == C7258h.f14102a) {
            if (this.f13246b.mo22756a() == C7257g.f14096c) {
                this.f13248d.f13179b.mo23459b(this.f13246b.mo23447t(), this.f13248d.f13182e, this.f13247c, ja);
                return;
            }
            C7262l d = this.f13248d.f13181d;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(this.f13246b);
            sb.append(str);
            sb.append(this.f13246b.mo22756a());
            sb.append(" is not a supported ad size");
            d.mo22916b(str3, sb.toString());
            throw new IllegalArgumentException("Unsupported ad size");
        } else if (this.f13246b.mo22759d() == C7258h.f14103b) {
            this.f13248d.f13179b.mo23454a(this.f13246b.mo23447t(), this.f13248d.f13182e, this.f13247c, ja);
        } else {
            C7262l d2 = this.f13248d.f13181d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f13246b);
            sb2.append(str);
            sb2.append(this.f13246b.mo22759d());
            sb2.append(" is not a supported ad type");
            d2.mo22916b(str3, sb2.toString());
            throw new IllegalArgumentException("Unsupported ad type");
        }
    }
}
