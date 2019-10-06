package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import com.flurry.sdk.C7531hd.C7532a;
import com.flurry.sdk.C7537id.C7538a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.flurry.sdk.qd */
public class C7585qd {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f15036a = C7585qd.class.getSimpleName();

    /* renamed from: b */
    private static C7585qd f15037b;

    /* renamed from: c */
    private final Map<Context, C7531hd> f15038c = new WeakHashMap();

    /* renamed from: d */
    private final C7590rd f15039d = new C7590rd();

    /* renamed from: e */
    private final Object f15040e = new Object();

    /* renamed from: f */
    public long f15041f = 0;

    /* renamed from: g */
    private C7531hd f15042g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f15043h;

    /* renamed from: i */
    private AtomicBoolean f15044i = new AtomicBoolean(false);

    /* renamed from: j */
    private C7452Sb<C7597sd> f15045j = new C7544jd(this);

    /* renamed from: k */
    private C7452Sb<C7395Ib> f15046k = new C7550kd(this);

    /* renamed from: a */
    static /* synthetic */ void m16789a(C7585qd qdVar, C7531hd hdVar) {
        synchronized (qdVar.f15040e) {
            if (qdVar.f15042g == hdVar) {
                C7531hd hdVar2 = qdVar.f15042g;
                C7602td.m16825a().mo24026b("ContinueSessionMillis", hdVar2);
                hdVar2.mo23959a(C7532a.f14871a);
                qdVar.f15042g = null;
            }
        }
    }

    private C7585qd() {
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.ActivityLifecycleEvent", this.f15046k);
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.FlurrySessionTimerEvent", this.f15045j);
    }

    /* renamed from: a */
    public static synchronized C7585qd m16785a() {
        C7585qd qdVar;
        synchronized (C7585qd.class) {
            if (f15037b == null) {
                f15037b = new C7585qd();
            }
            qdVar = f15037b;
        }
        return qdVar;
    }

    /* renamed from: a */
    public final synchronized void mo23999a(Context context) {
        if (context instanceof Activity) {
            if (C7412Lb.m16398a().mo23853b()) {
                C7513ec.m16639a(3, f15036a, "bootstrap for context:".concat(String.valueOf(context)));
                m16793e(context);
            }
        }
    }

    /* renamed from: b */
    public final synchronized void mo24002b(Context context) {
        mo24000a(context, false, false);
    }

    /* renamed from: a */
    public final synchronized void mo24000a(Context context, boolean z, boolean z2) {
        if (!C7412Lb.m16398a().mo23853b() || !(context instanceof Activity)) {
            if (z && z2) {
                this.f15043h = z2;
            }
            C7513ec.m16639a(3, f15036a, "Manual onStartSession for context:".concat(String.valueOf(context)));
            m16786a(context, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m16793e(Context context) {
        m16786a(context, false);
    }

    /* renamed from: a */
    private synchronized void m16786a(Context context, boolean z) {
        if (mo24006d() != null && mo24006d().mo23956a() && z) {
            if (!this.f15039d.mo24016a()) {
                C7513ec.m16639a(3, f15036a, "A background session has already started. Not storing in context map because we use application context only.");
                return;
            }
            C7513ec.m16639a(3, f15036a, "Returning from a paused background session.");
        }
        if (mo24006d() == null || mo24006d().mo23956a() || !z) {
            boolean z2 = true;
            if (mo24006d() != null && mo24006d().mo23956a() && !z) {
                C7513ec.m16641a(f15036a, "New session started while background session is running.  Ending background session, then will create foreground session.");
                this.f15044i.set(true);
                m16790b(C7379Fb.m16300a().f14432d, true);
                C7379Fb.m16300a().mo23817b(new C7556ld(this, context));
            } else if (((C7531hd) this.f15038c.get(context)) == null) {
                this.f15039d.mo24017b();
                C7531hd d = mo24006d();
                if (d == null) {
                    if (z) {
                        d = new C7526gd();
                    } else {
                        d = new C7531hd();
                    }
                    d.mo23959a(C7532a.f14872b);
                    C7513ec.m16651d(f15036a, "Flurry session started for context:".concat(String.valueOf(context)));
                    C7537id idVar = new C7537id();
                    idVar.f14883b = new WeakReference<>(context);
                    idVar.f14884c = d;
                    idVar.f14885d = C7538a.f14887a;
                    idVar.mo23885b();
                } else {
                    z2 = false;
                }
                this.f15038c.put(context, d);
                synchronized (this.f15040e) {
                    this.f15042g = d;
                }
                this.f15044i.set(false);
                C7513ec.m16651d(f15036a, "Flurry session resumed for context:".concat(String.valueOf(context)));
                C7537id idVar2 = new C7537id();
                idVar2.f14883b = new WeakReference<>(context);
                idVar2.f14884c = d;
                idVar2.f14885d = C7538a.f14888b;
                idVar2.mo23885b();
                if (z2) {
                    C7379Fb.m16300a().mo23817b(new C7562md(this, d, context));
                }
                this.f15041f = 0;
            } else if (C7412Lb.m16398a().mo23853b()) {
                C7513ec.m16639a(3, f15036a, "Session already started with context:".concat(String.valueOf(context)));
            } else {
                C7513ec.m16651d(f15036a, "Session already started with context:".concat(String.valueOf(context)));
            }
        } else {
            C7513ec.m16641a(f15036a, "A Flurry background session can't be started while a foreground session is running.");
        }
    }

    /* renamed from: c */
    public final synchronized void mo24005c(Context context) {
        mo24003b(context, false, false);
    }

    /* renamed from: b */
    public final synchronized void mo24003b(Context context, boolean z, boolean z2) {
        if (C7412Lb.m16398a().mo23853b() && (context instanceof Activity)) {
            return;
        }
        if (mo24006d() == null || mo24006d().mo23956a() || !z) {
            if (z) {
                if (this.f15043h && !z2) {
                    return;
                }
            }
            C7513ec.m16639a(3, f15036a, "Manual onEndSession for context:".concat(String.valueOf(context)));
            mo24007d(context);
            return;
        }
        C7513ec.m16641a(f15036a, "No background session running, can't end session.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final synchronized void mo24007d(Context context) {
        m16790b(context, false);
    }

    /* renamed from: b */
    private synchronized void m16790b(Context context, boolean z) {
        C7531hd hdVar = (C7531hd) this.f15038c.remove(context);
        if (z && mo24006d() != null && mo24006d().mo23956a() && this.f15039d.mo24016a()) {
            m16794f();
        } else if (hdVar != null) {
            C7513ec.m16651d(f15036a, "Flurry session paused for context:".concat(String.valueOf(context)));
            C7537id idVar = new C7537id();
            idVar.f14883b = new WeakReference<>(context);
            idVar.f14884c = hdVar;
            C7475Xa.m16549a();
            idVar.f14886e = C7475Xa.m16551c();
            idVar.f14885d = C7538a.f14889c;
            idVar.mo23885b();
            if (m16795g() == 0) {
                if (z) {
                    m16794f();
                } else {
                    this.f15039d.mo24015a(hdVar.mo23957b());
                }
                this.f15041f = System.currentTimeMillis();
                return;
            }
            this.f15041f = 0;
        } else if (C7412Lb.m16398a().mo23853b()) {
            C7513ec.m16639a(3, f15036a, "Session cannot be ended, session not found for context:".concat(String.valueOf(context)));
        } else {
            C7513ec.m16651d(f15036a, "Session cannot be ended, session not found for context:".concat(String.valueOf(context)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m16794f() {
        int g = m16795g();
        if (g > 0) {
            C7513ec.m16639a(5, f15036a, "Session cannot be finalized, sessionContextCount:".concat(String.valueOf(g)));
            return;
        }
        C7531hd d = mo24006d();
        if (d == null) {
            C7513ec.m16639a(5, f15036a, "Session cannot be finalized, current session not found");
            return;
        }
        String str = f15036a;
        StringBuilder sb = new StringBuilder("Flurry ");
        sb.append(d.mo23956a() ? "background" : "");
        sb.append(" session ended");
        C7513ec.m16651d(str, sb.toString());
        C7537id idVar = new C7537id();
        idVar.f14884c = d;
        idVar.f14885d = C7538a.f14890d;
        C7475Xa.m16549a();
        idVar.f14886e = C7475Xa.m16551c();
        idVar.mo23885b();
        C7379Fb.m16300a().mo23817b(new C7567nd(this, d));
    }

    /* renamed from: b */
    public final synchronized void mo24001b() {
        for (Entry entry : this.f15038c.entrySet()) {
            C7537id idVar = new C7537id();
            idVar.f14883b = new WeakReference<>(entry.getKey());
            idVar.f14884c = (C7531hd) entry.getValue();
            idVar.f14885d = C7538a.f14889c;
            C7475Xa.m16549a();
            idVar.f14886e = C7475Xa.m16551c();
            idVar.mo23885b();
        }
        this.f15038c.clear();
        C7379Fb.m16300a().mo23817b(new C7573od(this));
    }

    /* renamed from: g */
    private synchronized int m16795g() {
        return this.f15038c.size();
    }

    /* renamed from: c */
    public final synchronized int mo24004c() {
        if (this.f15044i.get()) {
            return C7532a.f14872b;
        }
        C7531hd d = mo24006d();
        if (d == null) {
            C7513ec.m16639a(2, f15036a, "Session not found. No active session");
            return C7532a.f14871a;
        }
        return d.mo23961c();
    }

    /* renamed from: d */
    public final C7531hd mo24006d() {
        C7531hd hdVar;
        synchronized (this.f15040e) {
            hdVar = this.f15042g;
        }
        return hdVar;
    }
}
