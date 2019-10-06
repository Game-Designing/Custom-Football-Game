package p019d.p273h.p276c;

import android.app.Activity;
import com.mopub.common.AdType;
import java.util.Date;
import java.util.Timer;
import org.json.JSONObject;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12869ea;
import p019d.p273h.p276c.p282f.C12871fa;
import p019d.p273h.p276c.p282f.C12873ga;
import p019d.p273h.p276c.p282f.C12886n;
import p019d.p273h.p276c.p282f.C12888o;
import p019d.p273h.p276c.p282f.C12889p;

/* renamed from: d.h.c.C */
/* compiled from: InterstitialSmash */
public class C12740C extends C12791c implements C12889p, C12869ea, C12888o, C12873ga {

    /* renamed from: v */
    private JSONObject f39070v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C12886n f39071w;

    /* renamed from: x */
    private C12871fa f39072x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public long f39073y;

    /* renamed from: z */
    private int f39074z;

    C12740C(C12826q adapterConfigs, int timeout) {
        super(adapterConfigs);
        this.f39070v = adapterConfigs.mo41549f();
        this.f39355f = adapterConfigs.mo41556m();
        this.f39357h = adapterConfigs.mo41555l();
        this.f39074z = timeout;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo41184k() {
        this.f39360k = 0;
        mo41388a(C12792a.INITIATED);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: H */
    public void mo41169H() {
        try {
            mo41383C();
            this.f39361l = new Timer();
            this.f39361l.schedule(new C12738A(this), (long) (this.f39074z * 1000));
        } catch (Exception e) {
            mo41390a("startInitTimer", e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: I */
    public void mo41170I() {
        try {
            mo41384D();
            this.f39362m = new Timer();
            this.f39362m.schedule(new C12739B(this), (long) (this.f39074z * 1000));
        } catch (Exception e) {
            mo41390a("startLoadTimer", e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public String mo41185m() {
        return AdType.INTERSTITIAL;
    }

    /* renamed from: a */
    public void mo41172a(Activity activity, String appKey, String userId) {
        mo41169H();
        C12775b bVar = this.f39351b;
        if (bVar != null) {
            bVar.addInterstitialListener(this);
            if (this.f39072x != null) {
                this.f39351b.setRewardedInterstitialListener(this);
            }
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41398o());
            sb.append(":initInterstitial()");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39351b.initInterstitial(activity, appKey, userId, this.f39070v, this);
        }
    }

    /* renamed from: F */
    public void mo41167F() {
        mo41170I();
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41398o());
            sb.append(":loadInterstitial()");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39073y = new Date().getTime();
            this.f39351b.loadInterstitial(this.f39070v, this);
        }
    }

    /* renamed from: G */
    public void mo41168G() {
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41398o());
            sb.append(":showInterstitial()");
            dVar.mo41427b(aVar, sb.toString(), 1);
            mo41382B();
            this.f39351b.showInterstitial(this.f39070v, this);
        }
    }

    /* renamed from: E */
    public boolean mo41166E() {
        if (this.f39351b == null) {
            return false;
        }
        C12802d dVar = this.f39367r;
        C12801a aVar = C12801a.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append(mo41398o());
        sb.append(":isInterstitialReady()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        return this.f39351b.isInterstitialReady(this.f39070v);
    }

    /* renamed from: a */
    public void mo41175a(C12886n listener) {
        this.f39071w = listener;
    }

    /* renamed from: a */
    public void mo41174a(C12871fa listener) {
        this.f39072x = listener;
    }

    public void onInterstitialInitSuccess() {
        mo41383C();
        if (this.f39350a == C12792a.INIT_PENDING) {
            mo41388a(C12792a.INITIATED);
            C12886n nVar = this.f39071w;
            if (nVar != null) {
                nVar.mo41652a(this);
            }
        }
    }

    /* renamed from: d */
    public void mo41180d(C12799b error) {
        mo41383C();
        if (this.f39350a == C12792a.INIT_PENDING) {
            mo41388a(C12792a.INIT_FAILED);
            C12886n nVar = this.f39071w;
            if (nVar != null) {
                nVar.mo41657b(error, this);
            }
        }
    }

    /* renamed from: a */
    public void mo41171a() {
        mo41384D();
        if (this.f39350a == C12792a.LOAD_PENDING && this.f39071w != null) {
            this.f39071w.mo41653a(this, new Date().getTime() - this.f39073y);
        }
    }

    /* renamed from: a */
    public void mo41173a(C12799b error) {
        mo41384D();
        if (this.f39350a == C12792a.LOAD_PENDING && this.f39071w != null) {
            this.f39071w.mo41655a(error, this, new Date().getTime() - this.f39073y);
        }
    }

    /* renamed from: d */
    public void mo41179d() {
        C12886n nVar = this.f39071w;
        if (nVar != null) {
            nVar.mo41661g(this);
        }
    }

    /* renamed from: b */
    public void mo41176b() {
        C12886n nVar = this.f39071w;
        if (nVar != null) {
            nVar.mo41660f(this);
        }
    }

    /* renamed from: e */
    public void mo41181e() {
        C12886n nVar = this.f39071w;
        if (nVar != null) {
            nVar.mo41656b(this);
        }
    }

    /* renamed from: b */
    public void mo41177b(C12799b error) {
        C12886n nVar = this.f39071w;
        if (nVar != null) {
            nVar.mo41654a(error, this);
        }
    }

    /* renamed from: c */
    public void mo41178c() {
        C12886n nVar = this.f39071w;
        if (nVar != null) {
            nVar.mo41658c(this);
        }
    }

    /* renamed from: f */
    public void mo41182f() {
        C12886n nVar = this.f39071w;
        if (nVar != null) {
            nVar.mo41659e(this);
        }
    }

    /* renamed from: j */
    public void mo41183j() {
        C12871fa faVar = this.f39072x;
        if (faVar != null) {
            faVar.mo41644d(this);
        }
    }
}
