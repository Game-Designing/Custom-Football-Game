package com.flurry.sdk;

import android.content.Context;
import java.util.Map;

/* renamed from: com.flurry.sdk.Xa */
public class C7475Xa implements C7530hc {
    /* renamed from: a */
    public static synchronized C7475Xa m16549a() {
        C7475Xa xa;
        synchronized (C7475Xa.class) {
            xa = (C7475Xa) C7379Fb.m16300a().mo23814a(C7475Xa.class);
        }
        return xa;
    }

    /* renamed from: a */
    public void mo23850a(Context context) {
        C7531hd.m16688a(C7374Eb.class);
        C7462Ub.m16528a();
        C7602td.m16825a();
        C7389Hb.m16355a();
        C7570ob.m16755a();
        C7517fb.m16656a();
        C7576pb.m16765a();
        C7547kb.m16712a();
        C7588rb.m16810a();
        C7535ib.m16696a();
        C7633zb.m16869a();
    }

    /* renamed from: b */
    public static C7374Eb m16550b() {
        return m16548a(C7585qd.m16785a().mo24006d());
    }

    /* renamed from: a */
    private static C7374Eb m16548a(C7531hd hdVar) {
        if (hdVar == null) {
            return null;
        }
        return (C7374Eb) hdVar.mo23960b(C7374Eb.class);
    }

    /* renamed from: c */
    public static long m16551c() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.f14415c;
        }
        return 0;
    }

    /* renamed from: d */
    public static long m16552d() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.f14416d;
        }
        return 0;
    }

    /* renamed from: e */
    public static long m16553e() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.f14417e;
        }
        return -1;
    }

    /* renamed from: f */
    public static long m16554f() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.mo23809b();
        }
        return 0;
    }

    /* renamed from: g */
    public static long m16555g() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.f14418f;
        }
        return 0;
    }

    /* renamed from: h */
    public static String m16556h() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.mo23810c();
        }
        return null;
    }

    /* renamed from: i */
    public static String m16557i() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.mo23811d();
        }
        return null;
    }

    /* renamed from: j */
    public static Map<String, String> m16558j() {
        C7374Eb b = m16550b();
        if (b != null) {
            return b.mo23812e();
        }
        return null;
    }

    /* renamed from: k */
    public static int m16559k() {
        return C7570ob.m16755a().mo23982b();
    }
}
