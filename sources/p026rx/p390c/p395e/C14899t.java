package p026rx.p390c.p395e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import p026rx.C0137ja;
import p026rx.exceptions.C14927a;

/* renamed from: rx.c.e.t */
/* compiled from: SubscriptionList */
public final class C14899t implements C0137ja {

    /* renamed from: a */
    private List<C0137ja> f44203a;

    /* renamed from: b */
    private volatile boolean f44204b;

    public C14899t() {
    }

    public C14899t(C0137ja... subscriptions) {
        this.f44203a = new LinkedList(Arrays.asList(subscriptions));
    }

    public C14899t(C0137ja s) {
        this.f44203a = new LinkedList();
        this.f44203a.add(s);
    }

    public boolean isUnsubscribed() {
        return this.f44204b;
    }

    /* renamed from: a */
    public void mo46107a(C0137ja s) {
        if (!s.isUnsubscribed()) {
            if (!this.f44204b) {
                synchronized (this) {
                    if (!this.f44204b) {
                        List<C0137ja> list = this.f44203a;
                        if (list == null) {
                            list = new LinkedList<>();
                            this.f44203a = list;
                        }
                        list.add(s);
                        return;
                    }
                }
            }
            s.unsubscribe();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        if (r0 == false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r4.unsubscribe();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo46108b(p026rx.C0137ja r4) {
        /*
            r3 = this;
            boolean r0 = r3.f44204b
            if (r0 != 0) goto L_0x0021
            monitor-enter(r3)
            r0 = 0
            java.util.List<rx.ja> r1 = r3.f44203a     // Catch:{ all -> 0x001c }
            boolean r2 = r3.f44204b     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x001a
            if (r1 != 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            boolean r0 = r1.remove(r4)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0021
            r4.unsubscribe()
            goto L_0x0021
        L_0x001a:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r1 = move-exception
        L_0x001d:
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
            throw r1
        L_0x001f:
            r1 = move-exception
            goto L_0x001d
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p395e.C14899t.mo46108b(rx.ja):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        m46626a((java.util.Collection<p026rx.C0137ja>) r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unsubscribe() {
        /*
            r3 = this;
            boolean r0 = r3.f44204b
            if (r0 != 0) goto L_0x0022
            monitor-enter(r3)
            r0 = 0
            boolean r1 = r3.f44204b     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x001d }
            return
        L_0x000c:
            r1 = 1
            r3.f44204b = r1     // Catch:{ all -> 0x001d }
            java.util.List<rx.ja> r1 = r3.f44203a     // Catch:{ all -> 0x001d }
            r3.f44203a = r0     // Catch:{ all -> 0x0018 }
            monitor-exit(r3)     // Catch:{ all -> 0x0018 }
            m46626a(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p395e.C14899t.unsubscribe():void");
    }

    /* renamed from: a */
    private static void m46626a(Collection<C0137ja> subscriptions) {
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
}
