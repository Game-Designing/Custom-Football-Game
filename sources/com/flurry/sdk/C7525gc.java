package com.flurry.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.gc */
public final class C7525gc {

    /* renamed from: a */
    private static final String f14857a = C7525gc.class.getSimpleName();

    /* renamed from: b */
    private static final Map<Class<? extends C7530hc>, C7520fc> f14858b = new LinkedHashMap();

    /* renamed from: c */
    private static List<C7530hc> f14859c = new ArrayList();

    /* renamed from: d */
    private static List<String> f14860d;

    /* renamed from: e */
    private final Map<Class<? extends C7530hc>, C7530hc> f14861e = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        f14860d = arrayList;
        arrayList.add("com.flurry.android.marketing.core.FlurryMarketingCoreModule");
        f14860d.add("com.flurry.android.marketing.FlurryMarketingModule");
        f14860d.add("com.flurry.android.config.killswitch.FlurryKillSwitchModule");
        f14860d.add("com.flurry.android.nativecrash.FlurryNativeCrashModule");
        f14860d.add("com.flurry.android.FlurryAdModule");
        f14860d.add("com.flurry.android.ymadlite.YahooAdModule");
    }

    /* renamed from: a */
    public static void m16682a(Class<? extends C7530hc> cls) {
        if (cls != null) {
            synchronized (f14858b) {
                f14858b.put(cls, new C7520fc(cls));
            }
        }
    }

    /* renamed from: a */
    public static void m16681a(C7530hc hcVar) {
        if (hcVar != null) {
            boolean z = false;
            Iterator it = f14859c.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((C7530hc) it.next()).getClass().getSimpleName().equals(hcVar.getClass().getSimpleName())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                f14859c.add(hcVar);
                return;
            }
            String str = f14857a;
            StringBuilder sb = new StringBuilder();
            sb.append(hcVar);
            sb.append(" has been register already as addOn module");
            C7513ec.m16639a(3, str, sb.toString());
            return;
        }
        C7513ec.m16651d(f14857a, "Module is null, cannot register it");
    }

    /* renamed from: a */
    public final synchronized void mo23954a(Context context) {
        ArrayList<C7520fc> arrayList;
        if (context == null) {
            C7513ec.m16639a(5, f14857a, "Null context.");
            return;
        }
        synchronized (f14858b) {
            arrayList = new ArrayList<>(f14858b.values());
        }
        for (C7520fc fcVar : arrayList) {
            try {
                if (fcVar.f14847a != null && VERSION.SDK_INT >= fcVar.f14848b) {
                    C7530hc hcVar = (C7530hc) fcVar.f14847a.newInstance();
                    hcVar.mo23850a(context);
                    this.f14861e.put(fcVar.f14847a, hcVar);
                }
            } catch (Exception e) {
                String str = f14857a;
                StringBuilder sb = new StringBuilder("Flurry Module for class ");
                sb.append(fcVar.f14847a);
                sb.append(" is not available:");
                C7513ec.m16640a(5, str, sb.toString(), e);
            }
        }
        for (C7530hc hcVar2 : f14859c) {
            try {
                hcVar2.mo23850a(context);
                this.f14861e.put(hcVar2.getClass(), hcVar2);
            } catch (C7509dd e2) {
                C7513ec.m16646b(f14857a, e2.getMessage());
            }
        }
        C7585qd.m16785a().mo23999a(context);
        C7412Lb.m16398a();
    }

    /* renamed from: b */
    public final C7530hc mo23955b(Class<? extends C7530hc> cls) {
        C7530hc hcVar;
        if (cls == null) {
            return null;
        }
        synchronized (this.f14861e) {
            hcVar = (C7530hc) this.f14861e.get(cls);
        }
        if (hcVar != null) {
            return hcVar;
        }
        throw new IllegalStateException("Module was not registered/initialized. ".concat(String.valueOf(cls)));
    }
}
