package p019d.p273h.p276c.p284h;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p019d.p273h.p276c.C12807da;

/* renamed from: d.h.c.h.l */
/* compiled from: SessionCappingManager */
public class C12918l {

    /* renamed from: a */
    private Map<String, Integer> f39750a = new HashMap();

    public C12918l(List<C12807da> smashes) {
        for (C12807da smash : smashes) {
            this.f39750a.put(smash.mo41444j(), Integer.valueOf(0));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        return r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo41700a(p019d.p273h.p276c.C12807da r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r5.mo41444j()     // Catch:{ all -> 0x0025 }
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r4.f39750a     // Catch:{ all -> 0x0025 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 == 0) goto L_0x0023
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r4.f39750a     // Catch:{ all -> 0x0025 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0025 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0025 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0025 }
            int r3 = r5.mo41446l()     // Catch:{ all -> 0x0025 }
            if (r1 < r3) goto L_0x0021
            r2 = 1
        L_0x0021:
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            return r2
        L_0x0023:
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            return r2
        L_0x0025:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.p284h.C12918l.mo41700a(d.h.c.da):boolean");
    }
}
