package p019d.p307j.p308a.p310b;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import junit.framework.Assert;
import p019d.p307j.p308a.p313e.C13111b;
import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: d.j.a.b.b */
/* compiled from: DownloadEventPoolImpl */
public class C13090b implements C13094e {

    /* renamed from: a */
    private final Executor f40083a = C13111b.m42766a(10, "EventPool");

    /* renamed from: b */
    private final HashMap<String, LinkedList<C13095f>> f40084b = new HashMap<>();

    /* renamed from: a */
    public boolean mo42065a(String eventId, C13095f listener) {
        boolean add;
        if (C13117d.f40139a) {
            C13117d.m42782d(this, "setListener %s", eventId);
        }
        Assert.assertNotNull("EventPoolImpl.add", listener);
        LinkedList linkedList = (LinkedList) this.f40084b.get(eventId);
        if (linkedList == null) {
            synchronized (eventId.intern()) {
                linkedList = (LinkedList) this.f40084b.get(eventId);
                if (linkedList == null) {
                    HashMap<String, LinkedList<C13095f>> hashMap = this.f40084b;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList = linkedList2;
                    hashMap.put(eventId, linkedList2);
                }
            }
        }
        synchronized (eventId.intern()) {
            add = linkedList.add(listener);
        }
        return add;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        return false;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo42066b(p019d.p307j.p308a.p310b.C13093d r7) {
        /*
            r6 = this;
            boolean r0 = p019d.p307j.p308a.p313e.C13117d.f40139a
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0013
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = r7.mo42068a()
            r0[r1] = r3
            java.lang.String r3 = "publish %s"
            p019d.p307j.p308a.p313e.C13117d.m42782d(r6, r3, r0)
        L_0x0013:
            java.lang.String r0 = "EventPoolImpl.publish"
            junit.framework.Assert.assertNotNull(r0, r7)
            java.lang.String r0 = r7.mo42068a()
            java.util.HashMap<java.lang.String, java.util.LinkedList<d.j.a.b.f>> r3 = r6.f40084b
            java.lang.Object r3 = r3.get(r0)
            java.util.LinkedList r3 = (java.util.LinkedList) r3
            if (r3 != 0) goto L_0x004a
            java.lang.String r4 = r0.intern()
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, java.util.LinkedList<d.j.a.b.f>> r5 = r6.f40084b     // Catch:{ all -> 0x0047 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0047 }
            java.util.LinkedList r5 = (java.util.LinkedList) r5     // Catch:{ all -> 0x0047 }
            r3 = r5
            if (r3 != 0) goto L_0x0045
            boolean r5 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0047 }
            if (r5 == 0) goto L_0x0043
            java.lang.String r5 = "No listener for this event %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0047 }
            r2[r1] = r0     // Catch:{ all -> 0x0047 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r6, r5, r2)     // Catch:{ all -> 0x0047 }
        L_0x0043:
            monitor-exit(r4)     // Catch:{ all -> 0x0047 }
            return r1
        L_0x0045:
            monitor-exit(r4)     // Catch:{ all -> 0x0047 }
            goto L_0x004a
        L_0x0047:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0047 }
            throw r1
        L_0x004a:
            r6.m42646a(r3, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p307j.p308a.p310b.C13090b.mo42066b(d.j.a.b.d):boolean");
    }

    /* renamed from: a */
    public void mo42064a(C13093d event) {
        if (C13117d.f40139a) {
            C13117d.m42782d(this, "asyncPublishInNewThread %s", event.mo42068a());
        }
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", event);
        this.f40083a.execute(new C13089a(this, event));
    }

    /* renamed from: a */
    private void m42646a(LinkedList<C13095f> listeners, C13093d event) {
        Object[] lists = listeners.toArray();
        int length = lists.length;
        int i = 0;
        while (i < length && !((C13095f) lists[i]).mo42069a(event)) {
            i++;
        }
        Runnable runnable = event.f40091a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
