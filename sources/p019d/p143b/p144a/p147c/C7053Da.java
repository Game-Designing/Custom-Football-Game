package p019d.p143b.p144a.p147c;

import android.app.Activity;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p019d.p143b.p148b.C7239b;
import p019d.p143b.p148b.C7240c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Da */
class C7053Da {

    /* renamed from: a */
    private final String f13178a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C7239b f13179b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C7142c f13180c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C7262l f13181d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C7041Aa f13182e;

    /* renamed from: f */
    private final AtomicBoolean f13183f;

    C7053Da(String str, C7239b bVar, C7142c cVar) {
        if (str == null) {
            throw new IllegalArgumentException("No implementation name specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No implementation specified");
        } else if (cVar != null) {
            this.f13178a = str;
            this.f13179b = bVar;
            this.f13180c = cVar;
            this.f13181d = cVar.mo23049b();
            this.f13182e = new C7041Aa(str, cVar);
            this.f13183f = new AtomicBoolean(true);
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14642a(int i, C7085La la) {
        if (la.f13286c.compareAndSet(false, true) && la.f13285b != null) {
            la.f13285b.failedToReceiveAd(i);
        }
    }

    /* renamed from: a */
    private void m14645a(String str, Runnable runnable) {
        String str2 = "MediationAdapterWrapper";
        if (runnable != null) {
            try {
                C7262l lVar = this.f13181d;
                StringBuilder sb = new StringBuilder();
                sb.append("Running implementation operation '");
                sb.append(str);
                sb.append("'...");
                lVar.mo22918c(str2, sb.toString());
                runnable.run();
            } catch (Throwable th) {
                C7262l lVar2 = this.f13181d;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to implementation operation run ");
                sb2.append(str);
                sb2.append(", marking ");
                sb2.append(this);
                sb2.append(" as disabled");
                lVar2.mo22917b(str2, sb2.toString(), th);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("fail_");
                sb3.append(str);
                mo22785a(sb3.toString());
            }
        } else {
            throw new IllegalArgumentException("No operation specified");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14647b(C7235za zaVar) {
        Map u = zaVar.mo23448u();
        if (u != null) {
            this.f13182e.mo22735b(u);
        }
    }

    /* renamed from: a */
    public String mo22781a() {
        return this.f13178a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22782a(C7235za zaVar) {
        if (zaVar != null) {
            String str = "Mediation implementation '";
            String str2 = "MediationAdapterWrapper";
            if (!this.f13183f.get()) {
                C7262l lVar = this.f13181d;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(mo22791f());
                sb.append("' was disabled due to earlier failures. Preparing ads with this implementation is disabled.");
                lVar.mo22913a(str2, sb.toString());
            } else if (!this.f13179b.isReady()) {
                C7262l lVar2 = this.f13181d;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(mo22791f());
                sb2.append("' is not ready.");
                lVar2.mo22921e(str2, sb2.toString());
            } else {
                m14645a("ad_prepare", (Runnable) new C7069Ha(this, zaVar));
            }
        } else {
            throw new IllegalArgumentException("No mediated ad specified");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22783a(C7235za zaVar, Activity activity, C7177kc kcVar) {
        if (zaVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!zaVar.mo22764q()) {
            throw new IllegalArgumentException("Mediated ad is not ready");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (kcVar != null) {
            m14645a("ad_render", (Runnable) new C7073Ia(this, kcVar, zaVar, activity));
        } else {
            throw new IllegalArgumentException("No listeners specified");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22784a(C7235za zaVar, C7254d dVar) {
        if (zaVar != null) {
            String str = "Mediation implementation '";
            String str2 = "MediationAdapterWrapper";
            if (!this.f13183f.get()) {
                C7262l lVar = this.f13181d;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(mo22791f());
                sb.append("' was disabled due to earlier failures. Loading ads with this implementation is disabled.");
                lVar.mo22921e(str2, sb.toString());
                if (dVar != null) {
                    dVar.failedToReceiveAd(-5103);
                }
            } else if (!this.f13179b.isReady()) {
                C7262l lVar2 = this.f13181d;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(mo22791f());
                sb2.append("' is not ready.");
                lVar2.mo22921e(str2, sb2.toString());
                if (dVar != null) {
                    dVar.failedToReceiveAd(-5104);
                }
            } else {
                m14645a("ad_load", (Runnable) new C7061Fa(this, zaVar, new C7085La(zaVar, dVar)));
            }
        } else {
            throw new IllegalArgumentException("No mediated ad specified");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22785a(String str) {
        C7262l lVar = this.f13181d;
        StringBuilder sb = new StringBuilder();
        sb.append("Marking ");
        sb.append(mo22791f());
        sb.append(" as disabled due to: ");
        sb.append(str);
        lVar.mo22920d("MediationAdapterWrapper", sb.toString());
        this.f13183f.set(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22786a(Map<String, String> map) {
        m14645a("init", (Runnable) new C7057Ea(this, map));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo22787b() {
        return this.f13183f.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo22788c() {
        return mo22787b() && this.f13179b.isReady();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C7239b mo22789d() {
        return this.f13179b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo22790e() {
        C7239b bVar = this.f13179b;
        if (bVar != null) {
            try {
                return bVar.getVersion();
            } catch (Throwable th) {
                C7262l lVar = this.f13181d;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to get implementation version, marking ");
                sb.append(this);
                sb.append(" as disabled");
                lVar.mo22917b("MediationAdapterWrapper", sb.toString(), th);
                mo22785a("fail_version");
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo22791f() {
        return this.f13179b.getClass().getName();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public C7240c mo22792g() {
        return this.f13182e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[MediationAdapterWrapper implementation: ");
        sb.append(mo22791f());
        sb.append("]");
        return sb.toString();
    }
}
