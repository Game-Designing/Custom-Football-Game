package com.inmobi.p207a;

import android.os.SystemClock;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.C10678e;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.p222e.C10669f;

/* renamed from: com.inmobi.a.e */
/* compiled from: CarbNetworkClient */
public class C10285e {

    /* renamed from: a */
    private static final String f31164a = C10285e.class.getSimpleName();

    /* renamed from: a */
    static C10283c m33534a(C10280b bVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C10677d a = new C10678e(bVar).mo34514a();
        C10283c cVar = new C10283c(a);
        try {
            C10299n.m33566a().mo33663a(bVar.mo34509g());
            C10299n.m33566a().mo33664b(a.mo34513c());
            C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - elapsedRealtime);
        } catch (Exception e) {
            new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
        }
        boolean z = cVar.f31157a;
        return cVar;
    }

    /* renamed from: a */
    static boolean m33535a(C10286f fVar) {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i > fVar.f31165a) {
                break;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C10677d a = new C10678e(fVar).mo34514a();
            try {
                C10299n.m33566a().mo33663a(fVar.mo34509g());
                C10299n.m33566a().mo33664b(a.mo34513c());
                C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - elapsedRealtime);
            } catch (Exception e) {
                new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
            }
            if (!a.mo34510a()) {
                z = true;
                break;
            }
            i++;
            if (i > fVar.f31165a) {
                break;
            }
            try {
                Thread.sleep((long) (fVar.f31166b * 1000));
            } catch (InterruptedException e2) {
            }
        }
        if (!z) {
            try {
                C10659b.m34983a().mo34485a(new C10669f("signals", "CarbUploadDiscarded"));
            } catch (Exception e3) {
                StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                sb.append(e3.getMessage());
                sb.append(")");
            }
        }
        return z;
    }
}
