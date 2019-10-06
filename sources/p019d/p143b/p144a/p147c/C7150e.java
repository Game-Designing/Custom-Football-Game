package p019d.p143b.p144a.p147c;

import android.app.Activity;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collection;
import p019d.p143b.p148b.C7241d;
import p019d.p143b.p148b.C7242e;
import p019d.p143b.p148b.C7243f;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7263m;

/* renamed from: d.b.a.c.e */
public class C7150e implements C7263m {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13498a;

    /* renamed from: b */
    private final C7262l f13499b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C7045Ba f13500c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f13501d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f13502e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f13503f = null;

    C7150e(C7142c cVar) {
        if (cVar != null) {
            this.f13498a = cVar;
            this.f13499b = cVar.mo23049b();
            this.f13500c = new C7045Ba(cVar);
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private void m15140a(int i, C7235za zaVar) {
        if (((Boolean) this.f13498a.mo23039a(C7196pb.f13723Ld)).booleanValue()) {
            m15147a("err", i, zaVar);
        }
    }

    /* renamed from: a */
    private void m15144a(C7235za zaVar, int i, C7177kc kcVar) {
        kcVar.mo23193a((C7251a) zaVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15145a(C7235za zaVar, int i, C7254d dVar) {
        m15140a(i, zaVar);
        if (dVar == null) {
            return;
        }
        if (dVar instanceof C7060F) {
            ((C7060F) dVar).mo22816a(zaVar.mo22762n(), i);
        } else {
            dVar.failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15146a(C7251a aVar, C7254d dVar) {
        if (dVar != null) {
            dVar.adReceived(aVar);
        }
    }

    /* renamed from: a */
    private void m15147a(String str, int i, C7235za zaVar) {
        try {
            this.f13498a.mo23078w().mo23136a(Uri.parse((String) this.f13498a.mo23039a(C7196pb.f13867q)).buildUpon().appendQueryParameter("event", str).appendQueryParameter("ec", String.valueOf(i)).appendQueryParameter("clcode", zaVar.mo22761h()).appendQueryParameter("an", zaVar.mo23446s()).appendQueryParameter("ac", zaVar.mo23445r()).build().toString(), null);
        } catch (Throwable th) {
            C7262l lVar = this.f13499b;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to create post-back URL for mediated '");
            sb.append(str);
            sb.append("'");
            lVar.mo22917b("MediationServiceImpl", sb.toString(), th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15150b(C7235za zaVar) {
        if (((Boolean) this.f13498a.mo23039a(C7196pb.f13713Jd)).booleanValue()) {
            m15147a("imp", 0, zaVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15152c(C7235za zaVar) {
        if (((Boolean) this.f13498a.mo23039a(C7196pb.f13718Kd)).booleanValue()) {
            m15147a("clk", 0, zaVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23094a() {
        this.f13500c.mo22748a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23095a(C7235za zaVar) {
        if (zaVar != null) {
            C7262l lVar = this.f13499b;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading ");
            sb.append(zaVar);
            sb.append("...");
            String str = "MediationServiceImpl";
            lVar.mo22918c(str, sb.toString());
            C7053Da a = this.f13500c.mo22747a(zaVar.mo23446s(), zaVar.mo23445r(), zaVar.mo23448u());
            if (a != null) {
                a.mo22782a(zaVar);
                return;
            }
            C7262l lVar2 = this.f13499b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to prepare");
            sb2.append(zaVar);
            sb2.append(": adapter not loaded");
            lVar2.mo22913a(str, sb2.toString());
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23096a(C7235za zaVar, C7254d dVar) {
        if (zaVar != null) {
            C7262l lVar = this.f13499b;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading ");
            sb.append(zaVar);
            sb.append("...");
            String str = "MediationServiceImpl";
            lVar.mo22918c(str, sb.toString());
            C7053Da a = this.f13500c.mo22747a(zaVar.mo23446s(), zaVar.mo23445r(), zaVar.mo23448u());
            if (a != null) {
                C7093Na na = new C7093Na(this, System.currentTimeMillis(), a, zaVar, dVar);
                a.mo22784a(zaVar, (C7254d) na);
                return;
            }
            C7262l lVar2 = this.f13499b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load ");
            sb2.append(zaVar);
            sb2.append(": adapter not loaded");
            lVar2.mo22913a(str, sb2.toString());
            m15145a(zaVar, -5001, dVar);
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    /* renamed from: a */
    public void mo23097a(C7235za zaVar, String str, Activity activity, C7177kc kcVar) {
        if (zaVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (kcVar != null) {
            String str2 = "MediationServiceImpl";
            if (zaVar.mo22764q()) {
                C7053Da a = this.f13500c.mo22747a(zaVar.mo23446s(), zaVar.mo23445r(), zaVar.mo23448u());
                if (a != null) {
                    kcVar.mo23198b((C7253c) new C7097Oa(this, zaVar));
                    kcVar.mo23197b((C7252b) new C7101Pa(this, zaVar));
                    a.mo22783a(zaVar, activity, kcVar);
                    return;
                }
                m15144a(zaVar, -5002, kcVar);
                C7262l lVar = this.f13499b;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to show ");
                sb.append(zaVar);
                sb.append(": adapter not loaded");
                lVar.mo22913a(str2, sb.toString());
                C7262l lVar2 = this.f13499b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("There may be an integration problem with the mediated '");
                sb2.append(zaVar.mo23446s());
                sb2.append("'. Please check if you have a supported version of that SDK integrated into your project.");
                lVar2.mo22921e(str2, sb2.toString());
                return;
            }
            m15144a(zaVar, -5003, kcVar);
            C7262l lVar3 = this.f13499b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Ad ");
            sb3.append(zaVar);
            sb3.append(" was not ready when provided requestsed to show.");
            lVar3.mo22916b(str2, sb3.toString());
        } else {
            throw new IllegalArgumentException("No listeners specified");
        }
    }

    /* renamed from: b */
    public Collection<C7241d> mo23098b() {
        C7241d dVar;
        Collection b = this.f13500c.mo22750b();
        Collection<C7053Da> c = this.f13500c.mo22751c();
        ArrayList arrayList = new ArrayList(c.size());
        for (C7053Da da : c) {
            String a = da.mo22781a();
            String f = da.mo22791f();
            String e = da.mo22790e();
            if (b.contains(f)) {
                dVar = new C7241d(a, f, e, C7243f.ERROR_LOAD);
            } else if (!da.mo22787b()) {
                dVar = new C7241d(a, f, e, C7243f.ERROR_LOAD);
            } else if (da.mo22788c()) {
                C7241d dVar2 = new C7241d(a, f, e, C7243f.READY, da.mo22789d(), da.mo22792g());
                arrayList.add(dVar2);
            } else {
                dVar = new C7241d(a, f, e, C7243f.ERROR_NOT_READY);
            }
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* renamed from: c */
    public C7242e mo23099c() {
        synchronized (this.f13501d) {
            if (this.f13503f == null) {
                return null;
            }
            C7242e eVar = new C7242e(this.f13503f, this.f13502e);
            return eVar;
        }
    }
}
