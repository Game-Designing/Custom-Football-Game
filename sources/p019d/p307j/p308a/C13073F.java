package p019d.p307j.p308a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.p310b.C13091c.C13092a;
import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: d.j.a.F */
/* compiled from: LostServiceConnectedHandler */
public class C13073F extends C13122f implements C13067B {

    /* renamed from: b */
    private final ArrayList<C13081b> f40060b = new ArrayList<>();

    /* renamed from: a */
    public void mo41997a() {
        C13068C queueHandler = C13149w.m42916b().mo42165d();
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.f40060b) {
            try {
                List<C13081b> list = (List) this.f40060b.clone();
                this.f40060b.clear();
                List<Integer> wakeupSerialQueueKeyList = new ArrayList<>(queueHandler.mo41974a());
                for (C13081b task : list) {
                    int attachKey = task.mo42045b();
                    if (queueHandler.mo41976a(attachKey)) {
                        task.mo42043F().mo42027j().mo42054a();
                        if (!wakeupSerialQueueKeyList.contains(Integer.valueOf(attachKey))) {
                            wakeupSerialQueueKeyList.add(Integer.valueOf(attachKey));
                        }
                    } else {
                        task.mo42051t();
                    }
                }
                queueHandler.mo41975a(wakeupSerialQueueKeyList);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* renamed from: b */
    public void mo41998b() {
        if (mo42094c() == C13092a.lost) {
            C13068C queueHandler = C13149w.m42916b().mo42165d();
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(C13128k.m42819b().mo42108c()));
            }
            if (C13128k.m42819b().mo42108c() > 0) {
                synchronized (this.f40060b) {
                    C13128k.m42819b().mo42103a((List<C13081b>) this.f40060b);
                    Iterator it = this.f40060b.iterator();
                    while (it.hasNext()) {
                        ((C13081b) it.next()).free();
                    }
                    queueHandler.mo41978b();
                }
                C13149w.m42916b().mo42158a();
            }
        } else if (C13128k.m42819b().mo42108c() > 0) {
            C13117d.m42783e(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(C13128k.m42819b().mo42108c()));
        }
    }

    /* renamed from: b */
    public boolean mo41972b(C13081b task) {
        return !this.f40060b.isEmpty() && this.f40060b.contains(task);
    }

    /* renamed from: c */
    public void mo41973c(C13081b task) {
        if (!this.f40060b.isEmpty()) {
            synchronized (this.f40060b) {
                this.f40060b.remove(task);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo41971a(p019d.p307j.p308a.C13079a.C13081b r7) {
        /*
            r6 = this;
            d.j.a.w r0 = p019d.p307j.p308a.C13149w.m42916b()
            boolean r0 = r0.mo42166e()
            r1 = 0
            if (r0 != 0) goto L_0x0054
            java.util.ArrayList<d.j.a.a$b> r0 = r6.f40060b
            monitor-enter(r0)
            d.j.a.w r2 = p019d.p307j.p308a.C13149w.m42916b()     // Catch:{ all -> 0x0051 }
            boolean r2 = r2.mo42166e()     // Catch:{ all -> 0x0051 }
            if (r2 != 0) goto L_0x004f
            boolean r2 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0051 }
            r3 = 1
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = "Waiting for connecting with the downloader service... %d"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0051 }
            d.j.a.a r5 = r7.mo42043F()     // Catch:{ all -> 0x0051 }
            int r5 = r5.getId()     // Catch:{ all -> 0x0051 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0051 }
            r4[r1] = r5     // Catch:{ all -> 0x0051 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r6, r2, r4)     // Catch:{ all -> 0x0051 }
        L_0x0032:
            d.j.a.r r1 = p019d.p307j.p308a.C13139r.m42869c()     // Catch:{ all -> 0x0051 }
            android.content.Context r2 = p019d.p307j.p308a.p313e.C13113c.m42768a()     // Catch:{ all -> 0x0051 }
            r1.mo35749a(r2)     // Catch:{ all -> 0x0051 }
            java.util.ArrayList<d.j.a.a$b> r1 = r6.f40060b     // Catch:{ all -> 0x0051 }
            boolean r1 = r1.contains(r7)     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x004d
            r7.free()     // Catch:{ all -> 0x0051 }
            java.util.ArrayList<d.j.a.a$b> r1 = r6.f40060b     // Catch:{ all -> 0x0051 }
            r1.add(r7)     // Catch:{ all -> 0x0051 }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return r3
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0054
        L_0x0051:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r1
        L_0x0054:
            r6.mo41973c(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p307j.p308a.C13073F.mo41971a(d.j.a.a$b):boolean");
    }
}
