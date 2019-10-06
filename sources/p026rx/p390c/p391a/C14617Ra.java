package p026rx.p390c.p391a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.CompositeException;
import p026rx.p029i.C14977e;
import p026rx.p029i.C14978f;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.p396a.C14830g;
import p026rx.p400f.C14948s;
import rx.internal.operators.OperatorSwitch.InnerSubscriber;
import rx.internal.operators.OperatorSwitch.SwitchSubscriber;

/* renamed from: rx.c.a.Ra */
/* compiled from: OperatorSwitch */
public final class C14617Ra<T> implements C0123b<T, C0120S<? extends T>> {

    /* renamed from: a */
    final boolean f43537a;

    /* renamed from: rx.c.a.Ra$a */
    /* compiled from: OperatorSwitch */
    static final class C14618a {

        /* renamed from: a */
        static final C14617Ra<Object> f43538a = new C14617Ra<>(false);
    }

    /* renamed from: rx.c.a.Ra$b */
    /* compiled from: OperatorSwitch */
    static final class C14619b {

        /* renamed from: a */
        static final C14617Ra<Object> f43539a = new C14617Ra<>(true);
    }

    /* renamed from: rx.c.a.Ra$c */
    /* compiled from: OperatorSwitch */
    static final class C14620c<T> extends C14980ia<T> {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final long f43540a;

        /* renamed from: b */
        private final C14621d<T> f43541b;

        C14620c(long id, C14621d<T> parent) {
            this.f43540a = id;
            this.f43541b = parent;
        }

        public void setProducer(C14508U p) {
            this.f43541b.mo45786a(p, this.f43540a);
        }

        public void onNext(T t) {
            this.f43541b.mo45783a(t, this);
        }

        public void onError(Throwable e) {
            this.f43541b.mo45784a(e, this.f43540a);
        }

        public void onCompleted() {
            this.f43541b.mo45789b(this.f43540a);
        }
    }

    /* renamed from: rx.c.a.Ra$d */
    /* compiled from: OperatorSwitch */
    static final class C14621d<T> extends C14980ia<C0120S<? extends T>> {

        /* renamed from: a */
        static final Throwable f43542a = new Throwable("Terminal error");

        /* renamed from: b */
        final C14980ia<? super T> f43543b;

        /* renamed from: c */
        final C14977e f43544c = new C14977e();

        /* renamed from: d */
        final boolean f43545d;

        /* renamed from: e */
        final AtomicLong f43546e;

        /* renamed from: f */
        final C14830g<Object> f43547f;

        /* renamed from: g */
        boolean f43548g;

        /* renamed from: h */
        boolean f43549h;

        /* renamed from: i */
        volatile boolean f43550i;

        /* renamed from: j */
        Throwable f43551j;

        /* renamed from: k */
        boolean f43552k;
        C14508U producer;
        long requested;

        C14621d(C14980ia<? super T> child, boolean delayError) {
            this.f43543b = child;
            this.f43545d = delayError;
            this.f43546e = new AtomicLong();
            this.f43547f = new C14830g<>(C14880h.f44165a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45791c() {
            this.f43543b.add(this.f43544c);
            this.f43543b.add(C14978f.m46781a(new C14623Sa(this)));
            this.f43543b.setProducer(new C14625Ta(this));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45781a() {
            synchronized (this) {
                this.producer = null;
            }
        }

        /* renamed from: a */
        public void onNext(C0120S<? extends T> t) {
            long id = this.f43546e.incrementAndGet();
            C0137ja s = this.f43544c.mo46197a();
            if (s != null) {
                s.unsubscribe();
            }
            synchronized (this) {
                try {
                    InnerSubscriber<T> inner = new C14620c<>(id, this);
                    try {
                        this.f43552k = true;
                        this.producer = null;
                        this.f43544c.mo46198a(inner);
                        t.mo3640b((C14980ia<? super T>) inner);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0006, code lost:
            if (r0 == false) goto L_0x000f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0008, code lost:
            r2.f43550i = true;
            mo45788b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            mo45790b(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.mo45792c(r3)     // Catch:{ all -> 0x0015 }
                monitor-exit(r2)     // Catch:{ all -> 0x0013 }
                if (r0 == 0) goto L_0x000f
                r1 = 1
                r2.f43550i = r1
                r2.mo45788b()
                goto L_0x0012
            L_0x000f:
                r2.mo45790b(r3)
            L_0x0012:
                return
            L_0x0013:
                r1 = move-exception
                goto L_0x0017
            L_0x0015:
                r1 = move-exception
                r0 = 0
            L_0x0017:
                monitor-exit(r2)     // Catch:{ all -> 0x0013 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14617Ra.C14621d.onError(java.lang.Throwable):void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo45792c(Throwable next) {
            Throwable e = this.f43551j;
            if (e == f43542a) {
                return false;
            }
            if (e == null) {
                this.f43551j = next;
            } else if (e instanceof CompositeException) {
                List<Throwable> list = new ArrayList<>(((CompositeException) e).mo46124a());
                list.add(next);
                this.f43551j = new CompositeException((Collection<? extends Throwable>) list);
            } else {
                this.f43551j = new CompositeException(e, next);
            }
            return true;
        }

        public void onCompleted() {
            this.f43550i = true;
            mo45788b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45783a(T value, C14620c<T> inner) {
            synchronized (this) {
                if (this.f43546e.get() == inner.f43540a) {
                    this.f43547f.mo45996a(inner, C14689m.m46326d(value));
                    mo45788b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            if (r1 == false) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            mo45788b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            mo45790b(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45784a(java.lang.Throwable r6, long r7) {
            /*
                r5 = this;
                monitor-enter(r5)
                r0 = 0
                java.util.concurrent.atomic.AtomicLong r1 = r5.f43546e     // Catch:{ all -> 0x0023 }
                long r1 = r1.get()     // Catch:{ all -> 0x0023 }
                int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
                if (r3 != 0) goto L_0x0016
                boolean r1 = r5.mo45792c(r6)     // Catch:{ all -> 0x0023 }
                r5.f43552k = r0     // Catch:{ all -> 0x0029 }
                r0 = 0
                r5.producer = r0     // Catch:{ all -> 0x0029 }
                goto L_0x0018
            L_0x0016:
                r0 = 1
                r1 = r0
            L_0x0018:
                monitor-exit(r5)     // Catch:{ all -> 0x0029 }
                if (r1 == 0) goto L_0x001f
                r5.mo45788b()
                goto L_0x0022
            L_0x001f:
                r5.mo45790b(r6)
            L_0x0022:
                return
            L_0x0023:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
            L_0x0027:
                monitor-exit(r5)     // Catch:{ all -> 0x0029 }
                throw r0
            L_0x0029:
                r0 = move-exception
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14617Ra.C14621d.mo45784a(java.lang.Throwable, long):void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45789b(long id) {
            synchronized (this) {
                if (this.f43546e.get() == id) {
                    this.f43552k = false;
                    this.producer = null;
                    mo45788b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45790b(Throwable e) {
            C14948s.m46719b(e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45786a(C14508U p, long id) {
            synchronized (this) {
                try {
                    if (this.f43546e.get() == id) {
                        long n = this.requested;
                        try {
                            this.producer = p;
                            p.request(n);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if (r0 == null) goto L_0x0011;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
            r0.request(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
            mo45788b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45782a(long r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                rx.U r0 = r3.producer     // Catch:{ all -> 0x0017 }
                long r1 = r3.requested     // Catch:{ all -> 0x0015 }
                long r1 = p026rx.p390c.p391a.C14640a.m46282a(r1, r4)     // Catch:{ all -> 0x0015 }
                r3.requested = r1     // Catch:{ all -> 0x0015 }
                monitor-exit(r3)     // Catch:{ all -> 0x0015 }
                if (r0 == 0) goto L_0x0011
                r0.request(r4)
            L_0x0011:
                r3.mo45788b()
                return
            L_0x0015:
                r1 = move-exception
                goto L_0x0019
            L_0x0017:
                r1 = move-exception
                r0 = 0
            L_0x0019:
                monitor-exit(r3)     // Catch:{ all -> 0x0015 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14617Ra.C14621d.mo45782a(long):void");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0029, code lost:
            r10 = r8.f43547f;
            r11 = r8.f43546e;
            r12 = r8.f43543b;
            r17 = r8.f43550i;
            r16 = r1;
            r13 = r2;
            r15 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0037, code lost:
            r18 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003d, code lost:
            if (r18 == r13) goto L_0x0080;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0043, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0046, code lost:
            r0 = r10.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0058, code lost:
            if (mo45787a(r17, r15, r16, r10, r12, r0) == false) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005b, code lost:
            if (r0 == false) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005e, code lost:
            r1 = (p026rx.p390c.p391a.C14617Ra.C14620c) r10.poll();
            r2 = p026rx.p390c.p391a.C14689m.m46324b(r10.poll());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0076, code lost:
            if (r11.get() != p026rx.p390c.p391a.C14617Ra.C14620c.m46255a(r1)) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0078, code lost:
            r12.onNext(r2);
            r18 = r18 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0082, code lost:
            if (r18 != r13) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0088, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x008a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x009c, code lost:
            if (mo45787a(r8.f43550i, r15, r16, r10, r12, r10.isEmpty()) == false) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x009e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x009f, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r0 = r8.requested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a9, code lost:
            if (r0 == Long.MAX_VALUE) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ab, code lost:
            r13 = r0 - r18;
            r8.requested = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b0, code lost:
            r13 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b3, code lost:
            if (r8.f43549h != false) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b5, code lost:
            r8.f43548g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b7, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b8, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b9, code lost:
            r8.f43549h = false;
            r17 = r8.f43550i;
            r15 = r8.f43552k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c4, code lost:
            r1 = r8.f43551j;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c5, code lost:
            if (r1 == null) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c9, code lost:
            if (r1 == f43542a) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00cd, code lost:
            if (r8.f43545d != false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cf, code lost:
            r8.f43551j = f43542a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d3, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00d4, code lost:
            r16 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d8, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d9, code lost:
            r16 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00dc, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00de, code lost:
            throw r0;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45788b() {
            /*
                r20 = this;
                r8 = r20
                monitor-enter(r20)
                r9 = 0
                r1 = 0
                r2 = 0
                boolean r0 = r8.f43548g     // Catch:{ all -> 0x00e3 }
                r4 = 1
                if (r0 == 0) goto L_0x0010
                r8.f43549h = r4     // Catch:{ all -> 0x00e3 }
                monitor-exit(r20)     // Catch:{ all -> 0x00e3 }
                return
            L_0x0010:
                r8.f43548g = r4     // Catch:{ all -> 0x00e3 }
                boolean r0 = r8.f43552k     // Catch:{ all -> 0x00e3 }
                r4 = r0
                long r2 = r8.requested     // Catch:{ all -> 0x00e1 }
                java.lang.Throwable r0 = r8.f43551j     // Catch:{ all -> 0x00df }
                r1 = r0
                if (r1 == 0) goto L_0x0028
                java.lang.Throwable r0 = f43542a     // Catch:{ all -> 0x00e7 }
                if (r1 == r0) goto L_0x0028
                boolean r0 = r8.f43545d     // Catch:{ all -> 0x00e7 }
                if (r0 != 0) goto L_0x0028
                java.lang.Throwable r0 = f43542a     // Catch:{ all -> 0x00e7 }
                r8.f43551j = r0     // Catch:{ all -> 0x00e7 }
            L_0x0028:
                monitor-exit(r20)     // Catch:{ all -> 0x00e7 }
                rx.c.e.a.g<java.lang.Object> r10 = r8.f43547f
                java.util.concurrent.atomic.AtomicLong r11 = r8.f43546e
                rx.ia<? super T> r12 = r8.f43543b
                boolean r0 = r8.f43550i
                r17 = r0
                r16 = r1
                r13 = r2
                r15 = r4
            L_0x0037:
                r0 = 0
                r18 = r0
            L_0x003b:
                int r0 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1))
                if (r0 == 0) goto L_0x0080
                boolean r0 = r12.isUnsubscribed()
                if (r0 == 0) goto L_0x0046
                return
            L_0x0046:
                boolean r0 = r10.isEmpty()
                r1 = r20
                r2 = r17
                r3 = r15
                r4 = r16
                r5 = r10
                r6 = r12
                r7 = r0
                boolean r1 = r1.mo45787a(r2, r3, r4, r5, r6, r7)
                if (r1 == 0) goto L_0x005b
                return
            L_0x005b:
                if (r0 == 0) goto L_0x005e
                goto L_0x0080
            L_0x005e:
                java.lang.Object r1 = r10.poll()
                rx.c.a.Ra$c r1 = (p026rx.p390c.p391a.C14617Ra.C14620c) r1
                java.lang.Object r2 = r10.poll()
                java.lang.Object r2 = p026rx.p390c.p391a.C14689m.m46324b(r2)
                long r3 = r11.get()
                long r5 = r1.f43540a
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 != 0) goto L_0x007f
                r12.onNext(r2)
                r3 = 1
                long r18 = r18 + r3
            L_0x007f:
                goto L_0x003b
            L_0x0080:
                int r0 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1))
                if (r0 != 0) goto L_0x009f
                boolean r0 = r12.isUnsubscribed()
                if (r0 == 0) goto L_0x008b
                return
            L_0x008b:
                boolean r2 = r8.f43550i
                boolean r7 = r10.isEmpty()
                r1 = r20
                r3 = r15
                r4 = r16
                r5 = r10
                r6 = r12
                boolean r0 = r1.mo45787a(r2, r3, r4, r5, r6, r7)
                if (r0 == 0) goto L_0x009f
                return
            L_0x009f:
                monitor-enter(r20)
                long r0 = r8.requested     // Catch:{ all -> 0x00dc }
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L_0x00b0
                long r13 = r0 - r18
                r8.requested = r13     // Catch:{ all -> 0x00dc }
                goto L_0x00b1
            L_0x00b0:
                r13 = r0
            L_0x00b1:
                boolean r0 = r8.f43549h     // Catch:{ all -> 0x00dc }
                if (r0 != 0) goto L_0x00b9
                r8.f43548g = r9     // Catch:{ all -> 0x00dc }
                monitor-exit(r20)     // Catch:{ all -> 0x00dc }
                return
            L_0x00b9:
                r8.f43549h = r9     // Catch:{ all -> 0x00dc }
                boolean r0 = r8.f43550i     // Catch:{ all -> 0x00dc }
                r17 = r0
                boolean r0 = r8.f43552k     // Catch:{ all -> 0x00dc }
                r15 = r0
                java.lang.Throwable r0 = r8.f43551j     // Catch:{ all -> 0x00dc }
                r1 = r0
                if (r1 == 0) goto L_0x00d3
                java.lang.Throwable r0 = f43542a     // Catch:{ all -> 0x00d8 }
                if (r1 == r0) goto L_0x00d3
                boolean r0 = r8.f43545d     // Catch:{ all -> 0x00d8 }
                if (r0 != 0) goto L_0x00d3
                java.lang.Throwable r0 = f43542a     // Catch:{ all -> 0x00d8 }
                r8.f43551j = r0     // Catch:{ all -> 0x00d8 }
            L_0x00d3:
                monitor-exit(r20)     // Catch:{ all -> 0x00d8 }
                r16 = r1
                goto L_0x0037
            L_0x00d8:
                r0 = move-exception
                r16 = r1
                goto L_0x00dd
            L_0x00dc:
                r0 = move-exception
            L_0x00dd:
                monitor-exit(r20)     // Catch:{ all -> 0x00dc }
                throw r0
            L_0x00df:
                r0 = move-exception
                goto L_0x00e5
            L_0x00e1:
                r0 = move-exception
                goto L_0x00e5
            L_0x00e3:
                r0 = move-exception
                r4 = r9
            L_0x00e5:
                monitor-exit(r20)     // Catch:{ all -> 0x00e7 }
                throw r0
            L_0x00e7:
                r0 = move-exception
                goto L_0x00e5
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14617Ra.C14621d.mo45788b():void");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo45787a(boolean localMainDone, boolean localInnerActive, Throwable localError, C14830g<Object> localQueue, C14980ia<? super T> localChild, boolean empty) {
            if (this.f43545d) {
                if (localMainDone && !localInnerActive && empty) {
                    if (localError != null) {
                        localChild.onError(localError);
                    } else {
                        localChild.onCompleted();
                    }
                    return true;
                }
            } else if (localError != null) {
                localQueue.clear();
                localChild.onError(localError);
                return true;
            } else if (localMainDone && !localInnerActive && empty) {
                localChild.onCompleted();
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    public static <T> C14617Ra<T> m46253a(boolean delayError) {
        if (delayError) {
            return C14619b.f43539a;
        }
        return C14618a.f43538a;
    }

    C14617Ra(boolean delayError) {
        this.f43537a = delayError;
    }

    /* renamed from: a */
    public C14980ia<? super C0120S<? extends T>> call(C14980ia<? super T> child) {
        SwitchSubscriber<T> sws = new C14621d<>(child, this.f43537a);
        child.add(sws);
        sws.mo45791c();
        return sws;
    }
}
