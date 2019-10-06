package p026rx.p029i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p026rx.C0137ja;
import p026rx.exceptions.C14927a;

/* renamed from: rx.i.c */
/* compiled from: CompositeSubscription */
public final class C0136c implements C0137ja {

    /* renamed from: a */
    private Set<C0137ja> f160a;

    /* renamed from: b */
    private volatile boolean f161b;

    public boolean isUnsubscribed() {
        return this.f161b;
    }

    /* renamed from: a */
    public void mo3713a(C0137ja s) {
        if (!s.isUnsubscribed()) {
            if (!this.f161b) {
                synchronized (this) {
                    if (!this.f161b) {
                        if (this.f160a == null) {
                            this.f160a = new HashSet(4);
                        }
                        this.f160a.add(s);
                        return;
                    }
                }
            }
            s.unsubscribe();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        if (r0 == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r3.unsubscribe();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3714b(p026rx.C0137ja r3) {
        /*
            r2 = this;
            boolean r0 = r2.f161b
            if (r0 != 0) goto L_0x0023
            monitor-enter(r2)
            r0 = 0
            boolean r1 = r2.f161b     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x001c
            java.util.Set<rx.ja> r1 = r2.f160a     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x000f
            goto L_0x001c
        L_0x000f:
            java.util.Set<rx.ja> r1 = r2.f160a     // Catch:{ all -> 0x001e }
            boolean r0 = r1.remove(r3)     // Catch:{ all -> 0x001e }
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0023
            r3.unsubscribe()
            goto L_0x0023
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r1 = move-exception
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r1
        L_0x0021:
            r1 = move-exception
            goto L_0x001f
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p029i.C0136c.mo3714b(rx.ja):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0014, code lost:
        m770a((java.util.Collection<p026rx.C0137ja>) r1);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3712a() {
        /*
            r3 = this;
            boolean r0 = r3.f161b
            if (r0 != 0) goto L_0x0024
            monitor-enter(r3)
            r0 = 0
            boolean r1 = r3.f161b     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x001d
            java.util.Set<rx.ja> r1 = r3.f160a     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000f
            goto L_0x001d
        L_0x000f:
            java.util.Set<rx.ja> r1 = r3.f160a     // Catch:{ all -> 0x001f }
            r3.f160a = r0     // Catch:{ all -> 0x0018 }
            monitor-exit(r3)     // Catch:{ all -> 0x0018 }
            m770a(r1)
            goto L_0x0024
        L_0x0018:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x0020
        L_0x001d:
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
        L_0x0020:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            throw r1
        L_0x0022:
            r1 = move-exception
            goto L_0x0020
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p029i.C0136c.mo3712a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        m770a((java.util.Collection<p026rx.C0137ja>) r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unsubscribe() {
        /*
            r3 = this;
            boolean r0 = r3.f161b
            if (r0 != 0) goto L_0x0022
            monitor-enter(r3)
            r0 = 0
            boolean r1 = r3.f161b     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x001d }
            return
        L_0x000c:
            r1 = 1
            r3.f161b = r1     // Catch:{ all -> 0x001d }
            java.util.Set<rx.ja> r1 = r3.f160a     // Catch:{ all -> 0x001d }
            r3.f160a = r0     // Catch:{ all -> 0x0018 }
            monitor-exit(r3)     // Catch:{ all -> 0x0018 }
            m770a(r1)
            goto L_0x0022
        L_0x0018:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x001e
        L_0x001d:
            r1 = move-exception
        L_0x001e:
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            throw r1
        L_0x0020:
            r1 = move-exception
            goto L_0x001e
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p029i.C0136c.unsubscribe():void");
    }

    /* renamed from: a */
    private static void m770a(Collection<C0137ja> subscriptions) {
        if (subscriptions != null) {
            List<Throwable> es = null;
            for (C0137ja s : subscriptions) {
                try {
                    s.unsubscribe();
                } catch (Throwable e) {
                    if (es == null) {
                        es = new ArrayList<>();
                    }
                    es.add(e);
                }
            }
            C14927a.m46676a(es);
        }
    }

    /* renamed from: b */
    public boolean mo3715b() {
        boolean z = false;
        if (this.f161b) {
            return false;
        }
        synchronized (this) {
            if (!this.f161b && this.f160a != null && !this.f160a.isEmpty()) {
                z = true;
            }
        }
        return z;
    }
}
