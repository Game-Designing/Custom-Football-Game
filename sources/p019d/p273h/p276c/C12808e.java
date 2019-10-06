package p019d.p273h.p276c;

import com.mopub.mobileads.vungle.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: d.h.c.e */
/* compiled from: AdaptersCompatibilityHandler */
public class C12808e {

    /* renamed from: a */
    private static final C12808e f39426a = new C12808e();

    /* renamed from: b */
    private Map<String, String> f39427b = new HashMap();

    /* renamed from: a */
    public static synchronized C12808e m41634a() {
        C12808e eVar;
        synchronized (C12808e.class) {
            eVar = f39426a;
        }
        return eVar;
    }

    private C12808e() {
        this.f39427b.put("adcolony", "4.1.6");
        this.f39427b.put(BuildConfig.NETWORK_NAME, "4.1.5");
        this.f39427b.put("applovin", "4.3.3");
        this.f39427b.put("admob", "4.3.2");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        return r3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo41450a(p019d.p273h.p276c.C12775b r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r9 != 0) goto L_0x0006
            r0 = 0
            monitor-exit(r8)
            return r0
        L_0x0006:
            java.lang.String r0 = r9.getProviderName()     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, java.lang.String> r1 = r8.f39427b     // Catch:{ all -> 0x0060 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0019
            r1 = 1
            monitor-exit(r8)
            return r1
        L_0x0019:
            java.util.Map<java.lang.String, java.lang.String> r1 = r8.f39427b     // Catch:{ all -> 0x0060 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = r9.getVersion()     // Catch:{ all -> 0x0060 }
            boolean r3 = r8.m41635a(r1, r2)     // Catch:{ all -> 0x0060 }
            if (r3 != 0) goto L_0x005e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r4.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = r9.getProviderName()     // Catch:{ all -> 0x0060 }
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = " adapter "
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            r4.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = " is incompatible with SDK version "
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = p019d.p273h.p276c.p284h.C12916j.m41971b()     // Catch:{ all -> 0x0060 }
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = ", please update your adapter to the latest version"
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0060 }
            d.h.c.d.d r5 = p019d.p273h.p276c.p280d.C12802d.m41613c()     // Catch:{ all -> 0x0060 }
            d.h.c.d.c$a r6 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0060 }
            r7 = 3
            r5.mo41427b(r6, r4, r7)     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r8)
            return r3
        L_0x0060:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12808e.mo41450a(d.h.c.b):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        return r1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo41451b(p019d.p273h.p276c.C12775b r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 != 0) goto L_0x0006
            r0 = 0
            monitor-exit(r6)
            return r0
        L_0x0006:
            java.lang.String r0 = r7.getVersion()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "4.3.0"
            boolean r1 = r6.m41635a(r1, r0)     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0045
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r2.<init>()     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = r7.getProviderName()     // Catch:{ all -> 0x0047 }
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = " adapter "
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            r2.append(r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = " is incompatible with SDK version "
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = p019d.p273h.p276c.p284h.C12916j.m41971b()     // Catch:{ all -> 0x0047 }
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = ", please update your adapter to the latest version"
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0047 }
            d.h.c.d.d r3 = p019d.p273h.p276c.p280d.C12802d.m41613c()     // Catch:{ all -> 0x0047 }
            d.h.c.d.c$a r4 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0047 }
            r5 = 3
            r3.mo41427b(r4, r2, r5)     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r6)
            return r1
        L_0x0047:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12808e.mo41451b(d.h.c.b):boolean");
    }

    /* renamed from: a */
    private boolean m41635a(String minAcceptedVersion, String adapterVersion) {
        if (minAcceptedVersion.equalsIgnoreCase(adapterVersion)) {
            return true;
        }
        String str = "\\.";
        String[] minAcceptedVersionArr = minAcceptedVersion.split(str);
        String[] adapterVersionArr = adapterVersion.split(str);
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(adapterVersionArr[i]) < Integer.parseInt(minAcceptedVersionArr[i])) {
                return false;
            }
        }
        return true;
    }
}
