package com.inmobi.commons.core.p220c;

import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.C10678e;
import com.inmobi.commons.core.p219b.C10632c;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.uid.C10711d;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.commons.core.c.a */
/* compiled from: EventSubmitter */
public class C10636a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f32418a = C10636a.class.getSimpleName();

    /* renamed from: b */
    private static volatile C10636a f32419b;

    /* renamed from: c */
    private static ScheduledExecutorService f32420c;

    /* renamed from: d */
    private static final Object f32421d = new Object();

    /* renamed from: a */
    public static C10636a m34899a() {
        C10636a aVar = f32419b;
        if (aVar == null) {
            synchronized (f32421d) {
                aVar = f32419b;
                if (aVar == null) {
                    aVar = new C10636a();
                    f32419b = aVar;
                }
            }
        }
        return aVar;
    }

    private C10636a() {
        f32420c = Executors.newSingleThreadScheduledExecutor();
    }

    /* renamed from: a */
    public final void mo34445a(C10632c cVar, String str, int i, int i2, long j, C10711d dVar, C10638b bVar) {
        C10632c cVar2 = cVar;
        int i3 = i;
        int i4 = i2;
        if (!C10700d.m35146a() || !C10619a.m34849g()) {
            bVar.mo34442a(cVar2, false);
            return;
        }
        final C10676c cVar3 = new C10676c("POST", str, false, dVar);
        HashMap hashMap = new HashMap();
        hashMap.put("payload", cVar2.f32405b);
        cVar3.mo34505c(hashMap);
        int i5 = i3 - i4;
        if (i5 > 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("X-im-retry-count", String.valueOf(i5));
            cVar3.mo34502a((Map<String, String>) hashMap2);
        }
        cVar3.f32583u = false;
        cVar3.f32569A = false;
        long j2 = i4 != i3 ? j : 0;
        ScheduledExecutorService scheduledExecutorService = f32420c;
        final int i6 = i2;
        final C10632c cVar4 = cVar;
        final String str2 = str;
        final int i7 = i;
        final long j3 = j;
        final C10711d dVar2 = dVar;
        final C10638b bVar2 = bVar;
        C106371 r0 = new Runnable() {
            public final void run() {
                C10677d a = new C10678e(cVar3).mo34514a();
                if (!a.mo34510a()) {
                    bVar2.mo34441a(cVar4);
                } else if (i6 > 1) {
                    C10636a.f32418a;
                    StringBuilder sb = new StringBuilder("Unable to send trc events to server: ");
                    sb.append(a.mo34511b());
                    sb.append(". Will retry");
                    C10636a.this.mo34445a(cVar4, str2, i7, i6 - 1, j3, dVar2, bVar2);
                } else {
                    bVar2.mo34442a(cVar4, true);
                }
            }
        };
        scheduledExecutorService.schedule(r0, j2, TimeUnit.SECONDS);
    }
}
