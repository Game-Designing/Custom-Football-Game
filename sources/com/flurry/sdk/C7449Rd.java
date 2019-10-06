package com.flurry.sdk;

import android.content.Context;
import com.google.android.instantapps.InstantApps;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import p019d.p020e.p021a.C7296g;

/* renamed from: com.flurry.sdk.Rd */
public class C7449Rd implements C7530hc {

    /* renamed from: a */
    private static final String f14636a = C7449Rd.class.getSimpleName();

    /* renamed from: b */
    public C7382G f14637b;

    /* renamed from: c */
    public C7616wa f14638c;

    /* renamed from: d */
    public C7404K f14639d;

    /* renamed from: e */
    public C7392Hd f14640e;

    /* renamed from: f */
    public boolean f14641f = false;

    /* renamed from: g */
    private final Object f14642g = new Object();

    /* renamed from: h */
    private Queue<C7433Od> f14643h = new LinkedList();

    /* renamed from: i */
    private Queue<C7433Od> f14644i = new LinkedList();

    /* renamed from: j */
    private Queue<C7428Nd> f14645j = new LinkedList();

    /* renamed from: k */
    private final C7452Sb<C7537id> f14646k = new C7439Pd(this);

    /* renamed from: a */
    public static synchronized C7449Rd m16479a() {
        C7449Rd rd;
        synchronized (C7449Rd.class) {
            rd = (C7449Rd) C7379Fb.m16300a().mo23814a(C7449Rd.class);
        }
        return rd;
    }

    /* renamed from: a */
    public void mo23850a(Context context) {
        C7531hd.m16688a(C7461Ua.class);
        this.f14638c = new C7616wa();
        this.f14637b = new C7382G();
        this.f14639d = new C7404K();
        this.f14640e = new C7392Hd();
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.FlurrySessionEvent", this.f14646k);
        if (!C7354Ad.m16263a(context, "android.permission.INTERNET")) {
            C7513ec.m16646b(f14636a, "Application must declare permission: android.permission.INTERNET");
        }
        if (!C7354Ad.m16263a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            C7513ec.m16651d(f14636a, "It is highly recommended that the application declare permission: android.permission.ACCESS_NETWORK_STATE");
        }
        int identifier = context.getResources().getIdentifier("FLURRY_IS_YAHOO_APP", "bool", context.getPackageName());
        if (identifier != 0) {
            this.f14641f = context.getResources().getBoolean(identifier);
            String str = f14636a;
            StringBuilder sb = new StringBuilder("Found FLURRY_IS_YAHOO_APP resource id. Value: ");
            sb.append(this.f14641f);
            C7513ec.m16649c(str, sb.toString());
        }
        C7508dc a = C7508dc.m16634a();
        try {
            Class.forName("com.google.android.instantapps.InstantApps");
            a.f14800c = InstantApps.isInstantApp(context);
            String str2 = C7508dc.f14798a;
            StringBuilder sb2 = new StringBuilder("isInstantApp: ");
            sb2.append(String.valueOf(a.f14800c));
            C7513ec.m16641a(str2, sb2.toString());
        } catch (ClassNotFoundException e) {
            C7513ec.m16641a(C7508dc.f14798a, "isInstantApps dependency is not added");
        }
    }

    /* renamed from: b */
    public static C7461Ua m16482b() {
        C7531hd d = C7585qd.m16785a().mo24006d();
        if (d == null) {
            return null;
        }
        return (C7461Ua) d.mo23960b(C7461Ua.class);
    }

    /* renamed from: a */
    public final C7296g mo23889a(String str, Map<String, String> map, int i) {
        return mo23891a(str, map, false, i);
    }

    /* renamed from: a */
    public final C7296g mo23890a(String str, Map<String, String> map, boolean z) {
        return mo23891a(str, map, z, 0);
    }

    /* renamed from: a */
    public final C7296g mo23891a(String str, Map<String, String> map, boolean z, int i) {
        C7433Od od = new C7433Od(str, map, z, i);
        synchronized (this.f14642g) {
            int i2 = C7445Qd.f14622b[m16485c() - 1];
            if (i2 == 1) {
                String str2 = f14636a;
                StringBuilder sb = new StringBuilder("There is no active Flurry session. Adding this event to deferred queue and flush them when the session initializes. Event: ");
                sb.append(od.f14588a);
                C7513ec.m16641a(str2, sb.toString());
                this.f14643h.add(od);
                C7296g gVar = C7296g.kFlurryEventLoggingDelayed;
                return gVar;
            } else if (i2 == 2) {
                String str3 = f14636a;
                StringBuilder sb2 = new StringBuilder("Waiting for Flurry session to initialize before logging event: ");
                sb2.append(od.f14588a);
                C7513ec.m16641a(str3, sb2.toString());
                this.f14643h.add(od);
                C7296g gVar2 = C7296g.kFlurryEventLoggingDelayed;
                return gVar2;
            } else if (i2 != 3) {
                C7296g gVar3 = C7296g.kFlurryEventFailed;
                return gVar3;
            } else {
                C7296g a = m16480a(od);
                return a;
            }
        }
    }

    /* renamed from: a */
    private static C7296g m16480a(C7433Od od) {
        C7461Ua b = m16482b();
        C7296g gVar = C7296g.kFlurryEventFailed;
        if (b != null) {
            return b.mo23900a(od.f14588a, od.f14589b, od.f14590c, od.f14591d);
        }
        return gVar;
    }

    /* renamed from: c */
    private synchronized int m16485c() {
        return C7585qd.m16785a().mo24004c();
    }

    /* renamed from: b */
    private static void m16484b(C7433Od od) {
        C7461Ua b = m16482b();
        if (b != null) {
            b.mo23905a(od.f14588a, od.f14589b);
        }
    }

    /* renamed from: a */
    public final void mo23893a(String str, String str2, Throwable th, Map<String, String> map) {
        boolean z = str != null && "uncaught".equals(str);
        C7428Nd nd = new C7428Nd(str, str2, th.getClass().getName(), th, C7403Jd.m16377a(z), map);
        if (z) {
            C7392Hd hd = this.f14640e;
            if (hd != null) {
                List<C7386Gd> a = hd.mo23834a();
                nd.f14576g = a;
                String str3 = f14636a;
                StringBuilder sb = new StringBuilder("Total breadcrumbs - ");
                sb.append(a.size());
                C7513ec.m16639a(4, str3, sb.toString());
            }
        }
        mo23892a(nd);
    }

    /* renamed from: a */
    public final void mo23892a(C7428Nd nd) {
        synchronized (this.f14642g) {
            int i = C7445Qd.f14622b[m16485c() - 1];
            if (i == 1) {
                String str = f14636a;
                StringBuilder sb = new StringBuilder("There is no active Flurry session. Adding this logging error to deferred queue and flush them when the session initializes. Error: ");
                sb.append(nd.f14570a);
                C7513ec.m16641a(str, sb.toString());
                this.f14645j.add(nd);
            } else if (i == 2) {
                String str2 = f14636a;
                StringBuilder sb2 = new StringBuilder("Waiting for Flurry session to initialize before logging error: ");
                sb2.append(nd.f14570a);
                C7513ec.m16641a(str2, sb2.toString());
                this.f14645j.add(nd);
            } else if (i == 3) {
                m16483b(nd);
            }
        }
    }

    /* renamed from: b */
    private static void m16483b(C7428Nd nd) {
        C7461Ua b = m16482b();
        if (b != null) {
            b.mo23904a(nd);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m16481a(C7449Rd rd) {
        C7513ec.m16641a(f14636a, "Flushing deferred events queues.");
        synchronized (rd.f14642g) {
            while (rd.f14643h.peek() != null) {
                m16480a((C7433Od) rd.f14643h.poll());
            }
            while (rd.f14645j.peek() != null) {
                m16483b((C7428Nd) rd.f14645j.poll());
            }
            while (rd.f14644i.peek() != null) {
                m16484b((C7433Od) rd.f14644i.poll());
            }
        }
    }
}
