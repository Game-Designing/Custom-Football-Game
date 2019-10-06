package com.inmobi.p207a;

import android.content.Context;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.p207a.C10301p.C10302a;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.inmobi.a.g */
/* compiled from: CarbWorker */
public class C10287g {

    /* renamed from: a */
    private static final String f31169a = C10287g.class.getSimpleName();

    /* renamed from: b */
    private C10302a f31170b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f31171c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C10276a f31172d = new C10276a();

    /* renamed from: e */
    private C10285e f31173e = new C10285e();

    C10287g() {
    }

    /* renamed from: a */
    public final synchronized void mo33648a(C10302a aVar) {
        boolean z;
        this.f31170b = aVar;
        if (!this.f31171c) {
            long b = this.f31172d.f31138a.mo34481b("carb_last_update_ts", 0);
            if (b == 0) {
                z = true;
            } else if (System.currentTimeMillis() - b >= ((long) (this.f31170b.f31228d * 1000))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.f31171c = true;
                new Thread(new Runnable() {
                    public final void run() {
                        C10283c a = C10287g.m33536a(C10287g.this);
                        if (!a.f31157a) {
                            C10287g.this.f31172d.f31138a.mo34478a("carb_last_update_ts", System.currentTimeMillis());
                            if (!(a.f31160d == 0)) {
                                C10287g.m33538a(C10287g.this, a, C10287g.m33537a((List) a.f31158b));
                            }
                        }
                        C10287g.this.f31171c = false;
                    }
                }).start();
            }
        }
    }

    /* renamed from: a */
    private static boolean m33539a(String str) {
        Context b = C10619a.m34839b();
        boolean z = false;
        if (b == null) {
            return false;
        }
        try {
            b.getPackageManager().getPackageInfo(str, Opcodes.ACC_NATIVE);
            z = true;
        } catch (Exception e) {
        }
        return z;
    }

    /* renamed from: a */
    static /* synthetic */ C10283c m33536a(C10287g gVar) {
        C10302a aVar = gVar.f31170b;
        C10280b bVar = new C10280b(aVar.f31226b, aVar.f31229e, aVar.f31230f, C10300o.m33571a().mo33669d());
        C10302a aVar2 = gVar.f31170b;
        bVar.f32584v = aVar2.f31232h;
        int i = aVar2.f31231g;
        bVar.f32580r = i * 1000;
        bVar.f32581s = i * 1000;
        return C10285e.m33534a(bVar);
    }

    /* renamed from: a */
    static /* synthetic */ List m33537a(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!m33539a(((C10284d) list.get(i)).f31162a)) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m33538a(C10287g gVar, C10283c cVar, List list) {
        C10302a aVar = gVar.f31170b;
        C10286f fVar = new C10286f(aVar.f31227c, aVar.f31229e, aVar.f31230f, C10300o.m33571a().mo33669d(), list, cVar);
        int i = gVar.f31170b.f31231g;
        fVar.f32580r = i * 1000;
        fVar.f32581s = i * 1000;
        C10285e.m33535a(fVar);
    }
}
