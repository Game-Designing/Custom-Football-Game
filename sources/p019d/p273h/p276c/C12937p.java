package p019d.p273h.p276c;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12872g;
import p019d.p273h.p276c.p282f.C12884m;

/* renamed from: d.h.c.p */
/* compiled from: CallbackThrottler */
public class C12937p {

    /* renamed from: a */
    private static final C12937p f39826a = new C12937p();

    /* renamed from: b */
    private Map<String, Long> f39827b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<String, Boolean> f39828c = new HashMap();

    /* renamed from: d */
    private C12884m f39829d = null;

    /* renamed from: e */
    private C12872g f39830e = null;

    /* renamed from: a */
    public static synchronized C12937p m42122a() {
        C12937p pVar;
        synchronized (C12937p.class) {
            pVar = f39826a;
        }
        return pVar;
    }

    private C12937p() {
    }

    /* renamed from: a */
    public void mo41748a(C12884m listener) {
        this.f39829d = listener;
    }

    /* renamed from: a */
    public void mo41747a(C12872g listener) {
        this.f39830e = listener;
    }

    /* renamed from: a */
    public void mo41746a(C12799b error) {
        synchronized (this) {
            m42127c("mediation", error);
        }
    }

    /* renamed from: a */
    public void mo41749a(String instanceId, C12799b error) {
        synchronized (this) {
            m42127c(instanceId, error);
        }
    }

    /* renamed from: a */
    public boolean mo41750a(String instanceId) {
        boolean b;
        synchronized (this) {
            b = m42126b(instanceId);
        }
        return b;
    }

    /* renamed from: b */
    public boolean mo41751b() {
        boolean b;
        synchronized (this) {
            b = m42126b("mediation");
        }
        return b;
    }

    /* renamed from: b */
    private boolean m42126b(String instanceId) {
        if (!TextUtils.isEmpty(instanceId) && this.f39828c.containsKey(instanceId)) {
            return ((Boolean) this.f39828c.get(instanceId)).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m42125b(String instanceId, C12799b error) {
        this.f39827b.put(instanceId, Long.valueOf(System.currentTimeMillis()));
        if (instanceId.equalsIgnoreCase("mediation")) {
            C12884m mVar = this.f39829d;
            if (mVar != null) {
                mVar.mo41610a(error);
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.CALLBACK;
                StringBuilder sb = new StringBuilder();
                sb.append("onInterstitialAdLoadFailed(");
                sb.append(error.toString());
                sb.append(")");
                c.mo41427b(aVar, sb.toString(), 1);
                return;
            }
            return;
        }
        C12872g gVar = this.f39830e;
        if (gVar != null) {
            gVar.onInterstitialAdLoadFailed(instanceId, error);
        }
    }

    /* renamed from: c */
    private void m42127c(String instanceId, C12799b error) {
        if (!m42126b(instanceId)) {
            if (!this.f39827b.containsKey(instanceId)) {
                m42125b(instanceId, error);
                return;
            }
            long timeSinceLastCallMs = System.currentTimeMillis() - ((Long) this.f39827b.get(instanceId)).longValue();
            if (timeSinceLastCallMs > 15000) {
                m42125b(instanceId, error);
                return;
            }
            this.f39828c.put(instanceId, Boolean.valueOf(true));
            new Handler(Looper.getMainLooper()).postDelayed(new C12935o(this, instanceId, error), 15000 - timeSinceLastCallMs);
        }
    }
}
