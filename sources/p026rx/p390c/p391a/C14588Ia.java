package p026rx.p390c.p391a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p029i.C14978f;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.p396a.C14828e;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14859t;
import p026rx.p398d.C14908d;
import rx.internal.operators.OperatorPublish.InnerProducer;
import rx.internal.operators.OperatorPublish.PublishSubscriber;

/* renamed from: rx.c.a.Ia */
/* compiled from: OperatorPublish */
public final class C14588Ia<T> extends C14908d<T> {

    /* renamed from: b */
    final C0120S<? extends T> f43456b;

    /* renamed from: c */
    final AtomicReference<C14590b<T>> f43457c;

    /* renamed from: rx.c.a.Ia$a */
    /* compiled from: OperatorPublish */
    static final class C14589a<T> extends AtomicLong implements C14508U, C0137ja {

        /* renamed from: a */
        final C14590b<T> f43458a;

        /* renamed from: b */
        final C14980ia<? super T> f43459b;

        public C14589a(C14590b<T> parent, C14980ia<? super T> child) {
            this.f43458a = parent;
            this.f43459b = child;
            lazySet(-4611686018427387904L);
        }

        public void request(long n) {
            long r;
            long u;
            if (n >= 0) {
                do {
                    r = get();
                    if (r != Long.MIN_VALUE) {
                        if (r >= 0 && n == 0) {
                            return;
                        }
                        if (r == -4611686018427387904L) {
                            u = n;
                        } else {
                            u = r + n;
                            if (u < 0) {
                                u = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(r, u));
                this.f43458a.mo45765a();
            }
        }

        /* renamed from: a */
        public long mo45764a(long n) {
            long r;
            long u;
            if (n > 0) {
                do {
                    r = get();
                    if (r == -4611686018427387904L) {
                        throw new IllegalStateException("Produced without request");
                    } else if (r == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    } else {
                        u = r - n;
                        if (u < 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("More produced (");
                            sb.append(n);
                            sb.append(") than requested (");
                            sb.append(r);
                            sb.append(")");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                } while (!compareAndSet(r, u));
                return u;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f43458a.mo45769b(this);
                this.f43458a.mo45765a();
            }
        }
    }

    /* renamed from: rx.c.a.Ia$b */
    /* compiled from: OperatorPublish */
    static final class C14590b<T> extends C14980ia<T> implements C0137ja {

        /* renamed from: a */
        static final C14589a[] f43460a = new C14589a[0];

        /* renamed from: b */
        static final C14589a[] f43461b = new C14589a[0];

        /* renamed from: c */
        final Queue<Object> f43462c;

        /* renamed from: d */
        final AtomicReference<C14590b<T>> f43463d;

        /* renamed from: e */
        volatile Object f43464e;

        /* renamed from: f */
        final AtomicReference<C14589a[]> f43465f;

        /* renamed from: g */
        final AtomicBoolean f43466g;

        /* renamed from: h */
        boolean f43467h;

        /* renamed from: i */
        boolean f43468i;

        public C14590b(AtomicReference<C14590b<T>> current) {
            this.f43462c = C14839G.m46555a() ? new C14859t<>(C14880h.f44165a) : new C14828e<>(C14880h.f44165a);
            this.f43465f = new AtomicReference<>(f43460a);
            this.f43463d = current;
            this.f43466g = new AtomicBoolean();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45768b() {
            add(C14978f.m46781a(new C14593Ja(this)));
        }

        public void onStart() {
            request((long) C14880h.f44165a);
        }

        public void onNext(T t) {
            if (!this.f43462c.offer(C14689m.m46326d(t))) {
                onError(new MissingBackpressureException());
            } else {
                mo45765a();
            }
        }

        public void onError(Throwable e) {
            if (this.f43464e == null) {
                this.f43464e = C14689m.m46321a(e);
                mo45765a();
            }
        }

        public void onCompleted() {
            if (this.f43464e == null) {
                this.f43464e = C14689m.m46320a();
                mo45765a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45767a(C14589a<T> producer) {
            C14589a[] c;
            C14589a[] u;
            if (producer != null) {
                do {
                    c = (C14589a[]) this.f43465f.get();
                    if (c == f43461b) {
                        return false;
                    }
                    int len = c.length;
                    u = new C14589a[(len + 1)];
                    System.arraycopy(c, 0, u, 0, len);
                    u[len] = producer;
                } while (!this.f43465f.compareAndSet(c, u));
                return true;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45769b(C14589a<T> producer) {
            C14589a[] c;
            C14589a[] u;
            do {
                c = (C14589a[]) this.f43465f.get();
                if (c != f43460a && c != f43461b) {
                    int j = -1;
                    int len = c.length;
                    int i = 0;
                    while (true) {
                        if (i >= len) {
                            break;
                        } else if (c[i].equals(producer)) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (len == 1) {
                            u = f43460a;
                        } else {
                            C14589a[] u2 = new C14589a[(len - 1)];
                            System.arraycopy(c, 0, u2, 0, j);
                            System.arraycopy(c, j + 1, u2, j, (len - j) - 1);
                            u = u2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f43465f.compareAndSet(c, u));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45766a(Object term, boolean empty) {
            if (term != null) {
                if (!C14689m.m46325c(term)) {
                    Throwable t = C14689m.m46322a(term);
                    this.f43463d.compareAndSet(this, null);
                    try {
                        for (InnerProducer<?> ip : (C14589a[]) this.f43465f.getAndSet(f43461b)) {
                            ip.f43459b.onError(t);
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                } else if (empty) {
                    this.f43463d.compareAndSet(this, null);
                    try {
                        for (InnerProducer<?> ip2 : (C14589a[]) this.f43465f.getAndSet(f43461b)) {
                            ip2.f43459b.onCompleted();
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x012f, code lost:
            r19 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0131, code lost:
            if (r5 <= 0) goto L_0x0137;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0133, code lost:
            request((long) r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0139, code lost:
            if (r14 == 0) goto L_0x0141;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x013b, code lost:
            if (r6 != false) goto L_0x0141;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x013d, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0141, code lost:
            r5 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0142, code lost:
            monitor-enter(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0145, code lost:
            if (r1.f43468i != false) goto L_0x015b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0147, code lost:
            r1.f43467h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
            monitor-exit(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x014c, code lost:
            if (1 != 0) goto L_0x0157;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x014e, code lost:
            monitor-enter(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
            r1.f43467h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0152, code lost:
            monitor-exit(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0157, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0158, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x0159, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r5 = r1.f43464e;
            r6 = r1.f43462c.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
            r1.f43468i = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x015e, code lost:
            monitor-exit(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x015f, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x0163, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x0164, code lost:
            monitor-exit(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0166, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x0167, code lost:
            if (r4 == false) goto L_0x0169;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (mo45766a(r5, r6) == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0169, code lost:
            monitor-enter(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
            r1.f43467h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0172, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (1 != 0) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            monitor-enter(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r1.f43467h = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
            monitor-exit(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x002e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x002f, code lost:
            if (r6 != false) goto L_0x0142;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r7 = (p026rx.p390c.p391a.C14588Ia.C14589a[]) r1.f43465f.get();
            r8 = r7.length;
            r11 = r7;
            r12 = r11.length;
            r13 = 0;
            r14 = Long.MAX_VALUE;
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0049, code lost:
            if (r13 >= r12) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004b, code lost:
            r2 = r11[r13].get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
            if (r2 < 0) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            r14 = java.lang.Math.min(r14, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
            if (r2 != Long.MIN_VALUE) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0066, code lost:
            r9 = r9 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
            r13 = r13 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006f, code lost:
            if (r8 != r9) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0071, code lost:
            r5 = r1.f43464e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007b, code lost:
            if (r1.f43462c.poll() != null) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x007f, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0084, code lost:
            if (mo45766a(r5, r0) == false) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0087, code lost:
            if (1 != 0) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0089, code lost:
            monitor-enter(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            r1.f43467h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008d, code lost:
            monitor-exit(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0092, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            request(1);
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x009a, code lost:
            r24 = r5;
            r5 = 0;
            r0 = r24;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a3, code lost:
            if (((long) r5) >= r14) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a5, code lost:
            r11 = r1.f43464e;
            r12 = r1.f43462c.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ae, code lost:
            if (r12 != null) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b0, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b2, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b3, code lost:
            r6 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b8, code lost:
            if (mo45766a(r11, r6) == false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00bb, code lost:
            if (1 != 0) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00bd, code lost:
            monitor-enter(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            r1.f43467h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00c1, code lost:
            monitor-exit(r25);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x00c6, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x00c7, code lost:
            if (r6 == false) goto L_0x00ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x00c9, code lost:
            r19 = r7;
            r0 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            r13 = p026rx.p390c.p391a.C14689m.m46324b(r12);
            r10 = r7;
            r19 = r10.length;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x00dc, code lost:
            r3 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00de, code lost:
            if (r2 >= r3) goto L_0x0121;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x00e0, code lost:
            r19 = r10[r2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x00ea, code lost:
            if (r19.get() <= 0) goto L_0x0110;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x00ec, code lost:
            r22 = r3;
            r3 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            r3.f43459b.onNext(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x00f5, code lost:
            r23 = r6;
            r19 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
            r3.mo45764a(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0100, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0101, code lost:
            r23 = r6;
            r19 = r7;
            r3.unsubscribe();
            p026rx.exceptions.C14927a.m46673a(r0, (p026rx.C0125T<?>) r3.f43459b, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0110, code lost:
            r22 = r3;
            r23 = r6;
            r3 = r19;
            r19 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0121, code lost:
            r22 = r3;
            r23 = r6;
            r19 = r7;
            r5 = r5 + 1;
            r0 = r11;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45765a() {
            /*
                r25 = this;
                r1 = r25
                monitor-enter(r25)
                boolean r0 = r1.f43467h     // Catch:{ all -> 0x0173 }
                r2 = 1
                if (r0 == 0) goto L_0x000c
                r1.f43468i = r2     // Catch:{ all -> 0x0173 }
                monitor-exit(r25)     // Catch:{ all -> 0x0173 }
                return
            L_0x000c:
                r1.f43467h = r2     // Catch:{ all -> 0x0173 }
                r3 = 0
                r1.f43468i = r3     // Catch:{ all -> 0x0173 }
                monitor-exit(r25)     // Catch:{ all -> 0x0173 }
                r4 = 0
            L_0x0013:
                java.lang.Object r0 = r1.f43464e     // Catch:{ all -> 0x0166 }
                r5 = r0
                java.util.Queue<java.lang.Object> r0 = r1.f43462c     // Catch:{ all -> 0x0166 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0166 }
                r6 = r0
                boolean r0 = r1.mo45766a(r5, r6)     // Catch:{ all -> 0x0166 }
                if (r0 == 0) goto L_0x002f
                r2 = 1
                if (r2 != 0) goto L_0x002e
                monitor-enter(r25)
                r1.f43467h = r3     // Catch:{ all -> 0x002b }
                monitor-exit(r25)     // Catch:{ all -> 0x002b }
                goto L_0x002e
            L_0x002b:
                r0 = move-exception
                monitor-exit(r25)     // Catch:{ all -> 0x002b }
                throw r0
            L_0x002e:
                return
            L_0x002f:
                if (r6 != 0) goto L_0x0142
                java.util.concurrent.atomic.AtomicReference<rx.c.a.Ia$a[]> r0 = r1.f43465f     // Catch:{ all -> 0x0166 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0166 }
                rx.c.a.Ia$a[] r0 = (p026rx.p390c.p391a.C14588Ia.C14589a[]) r0     // Catch:{ all -> 0x0166 }
                r7 = r0
                int r0 = r7.length     // Catch:{ all -> 0x0166 }
                r8 = r0
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r0 = 0
                r11 = r7
                int r12 = r11.length     // Catch:{ all -> 0x0166 }
                r13 = 0
                r14 = r9
                r9 = r0
            L_0x0047:
                r16 = 0
                if (r13 >= r12) goto L_0x006d
                r0 = r11[r13]     // Catch:{ all -> 0x0166 }
                long r18 = r0.get()     // Catch:{ all -> 0x0166 }
                r20 = r18
                r2 = r20
                int r19 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
                if (r19 < 0) goto L_0x0060
                long r16 = java.lang.Math.min(r14, r2)     // Catch:{ all -> 0x0166 }
                r14 = r16
                goto L_0x0068
            L_0x0060:
                r16 = -9223372036854775808
                int r19 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
                if (r19 != 0) goto L_0x0068
                int r9 = r9 + 1
            L_0x0068:
                int r13 = r13 + 1
                r2 = 1
                r3 = 0
                goto L_0x0047
            L_0x006d:
                r2 = 1
                if (r8 != r9) goto L_0x009a
                java.lang.Object r0 = r1.f43464e     // Catch:{ all -> 0x0166 }
                r5 = r0
                java.util.Queue<java.lang.Object> r0 = r1.f43462c     // Catch:{ all -> 0x0166 }
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0166 }
                r11 = r0
                if (r11 != 0) goto L_0x007f
                r0 = 1
                goto L_0x0080
            L_0x007f:
                r0 = 0
            L_0x0080:
                boolean r0 = r1.mo45766a(r5, r0)     // Catch:{ all -> 0x0166 }
                if (r0 == 0) goto L_0x0093
                r2 = 1
                if (r2 != 0) goto L_0x0092
                monitor-enter(r25)
                r3 = 0
                r1.f43467h = r3     // Catch:{ all -> 0x008f }
                monitor-exit(r25)     // Catch:{ all -> 0x008f }
                goto L_0x0092
            L_0x008f:
                r0 = move-exception
                monitor-exit(r25)     // Catch:{ all -> 0x008f }
                throw r0
            L_0x0092:
                return
            L_0x0093:
                r1.request(r2)     // Catch:{ all -> 0x0166 }
                r2 = 1
                r3 = 0
                goto L_0x0013
            L_0x009a:
                r0 = 0
                r24 = r5
                r5 = r0
                r0 = r24
            L_0x00a0:
                long r11 = (long) r5     // Catch:{ all -> 0x0166 }
                int r13 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
                if (r13 >= 0) goto L_0x012f
                java.lang.Object r11 = r1.f43464e     // Catch:{ all -> 0x0166 }
                java.util.Queue<java.lang.Object> r0 = r1.f43462c     // Catch:{ all -> 0x0166 }
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0166 }
                r12 = r0
                if (r12 != 0) goto L_0x00b2
                r0 = 1
                goto L_0x00b3
            L_0x00b2:
                r0 = 0
            L_0x00b3:
                r6 = r0
                boolean r0 = r1.mo45766a(r11, r6)     // Catch:{ all -> 0x0166 }
                if (r0 == 0) goto L_0x00c7
                r2 = 1
                if (r2 != 0) goto L_0x00c6
                monitor-enter(r25)
                r3 = 0
                r1.f43467h = r3     // Catch:{ all -> 0x00c3 }
                monitor-exit(r25)     // Catch:{ all -> 0x00c3 }
                goto L_0x00c6
            L_0x00c3:
                r0 = move-exception
                monitor-exit(r25)     // Catch:{ all -> 0x00c3 }
                throw r0
            L_0x00c6:
                return
            L_0x00c7:
                if (r6 == 0) goto L_0x00ce
                r19 = r7
                r0 = r11
                goto L_0x0131
            L_0x00ce:
                java.lang.Object r0 = p026rx.p390c.p391a.C14689m.m46324b(r12)     // Catch:{ all -> 0x0166 }
                r13 = r0
                r19 = r7
                r10 = r19
                int r0 = r10.length     // Catch:{ all -> 0x0166 }
                r19 = r0
                r0 = 0
                r2 = r0
            L_0x00dc:
                r3 = r19
                if (r2 >= r3) goto L_0x0121
                r0 = r10[r2]     // Catch:{ all -> 0x0166 }
                r19 = r0
                long r22 = r19.get()     // Catch:{ all -> 0x0166 }
                int r0 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
                if (r0 <= 0) goto L_0x0110
                r22 = r3
                r3 = r19
                rx.ia<? super T> r0 = r3.f43459b     // Catch:{ Throwable -> 0x0100 }
                r0.onNext(r13)     // Catch:{ Throwable -> 0x0100 }
                r23 = r6
                r19 = r7
                r6 = 1
                r3.mo45764a(r6)     // Catch:{ all -> 0x0166 }
                goto L_0x0118
            L_0x0100:
                r0 = move-exception
                r23 = r6
                r19 = r7
                r6 = 1
                r3.unsubscribe()     // Catch:{ all -> 0x0166 }
                rx.ia<? super T> r6 = r3.f43459b     // Catch:{ all -> 0x0166 }
                p026rx.exceptions.C14927a.m46673a(r0, r6, r13)     // Catch:{ all -> 0x0166 }
                goto L_0x0118
            L_0x0110:
                r22 = r3
                r23 = r6
                r3 = r19
                r19 = r7
            L_0x0118:
                int r2 = r2 + 1
                r7 = r19
                r19 = r22
                r6 = r23
                goto L_0x00dc
            L_0x0121:
                r22 = r3
                r23 = r6
                r19 = r7
                int r5 = r5 + 1
                r0 = r11
                r2 = 1
                goto L_0x00a0
            L_0x012f:
                r19 = r7
            L_0x0131:
                if (r5 <= 0) goto L_0x0137
                long r2 = (long) r5     // Catch:{ all -> 0x0166 }
                r1.request(r2)     // Catch:{ all -> 0x0166 }
            L_0x0137:
                int r2 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r2 == 0) goto L_0x0141
                if (r6 != 0) goto L_0x0141
                r2 = 1
                r3 = 0
                goto L_0x0013
            L_0x0141:
                r5 = r0
            L_0x0142:
                monitor-enter(r25)     // Catch:{ all -> 0x0166 }
                boolean r0 = r1.f43468i     // Catch:{ all -> 0x0163 }
                if (r0 != 0) goto L_0x015b
                r2 = 0
                r1.f43467h = r2     // Catch:{ all -> 0x0163 }
                r2 = 1
                monitor-exit(r25)     // Catch:{ all -> 0x0158 }
                if (r2 != 0) goto L_0x0157
                monitor-enter(r25)
                r3 = 0
                r1.f43467h = r3     // Catch:{ all -> 0x0154 }
                monitor-exit(r25)     // Catch:{ all -> 0x0154 }
                goto L_0x0157
            L_0x0154:
                r0 = move-exception
                monitor-exit(r25)     // Catch:{ all -> 0x0154 }
                throw r0
            L_0x0157:
                return
            L_0x0158:
                r0 = move-exception
                r4 = r2
                goto L_0x0164
            L_0x015b:
                r2 = 0
                r1.f43468i = r2     // Catch:{ all -> 0x0163 }
                monitor-exit(r25)     // Catch:{ all -> 0x0163 }
                r2 = 1
                r3 = 0
                goto L_0x0013
            L_0x0163:
                r0 = move-exception
            L_0x0164:
                monitor-exit(r25)     // Catch:{ all -> 0x0163 }
                throw r0     // Catch:{ all -> 0x0166 }
            L_0x0166:
                r0 = move-exception
                if (r4 != 0) goto L_0x0172
                monitor-enter(r25)
                r2 = 0
                r1.f43467h = r2     // Catch:{ all -> 0x016f }
                monitor-exit(r25)     // Catch:{ all -> 0x016f }
                goto L_0x0172
            L_0x016f:
                r0 = move-exception
                monitor-exit(r25)     // Catch:{ all -> 0x016f }
                throw r0
            L_0x0172:
                throw r0
            L_0x0173:
                r0 = move-exception
                monitor-exit(r25)     // Catch:{ all -> 0x0173 }
                goto L_0x0177
            L_0x0176:
                throw r0
            L_0x0177:
                goto L_0x0176
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14588Ia.C14590b.mo45765a():void");
        }
    }

    /* renamed from: i */
    public static <T> C14908d<T> m46229i(C0120S<? extends T> source) {
        AtomicReference<PublishSubscriber<T>> curr = new AtomicReference<>();
        return new C14588Ia(new C14585Ha<>(curr), source, curr);
    }

    private C14588Ia(C0122a<T> onSubscribe, C0120S<? extends T> source, AtomicReference<C14590b<T>> current) {
        super(onSubscribe);
        this.f43456b = source;
        this.f43457c = current;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo45763d(p026rx.p027b.C0129b<? super p026rx.C0137ja> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<rx.c.a.Ia$b<T>> r0 = r4.f43457c
            java.lang.Object r0 = r0.get()
            rx.c.a.Ia$b r0 = (p026rx.p390c.p391a.C14588Ia.C14590b) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isUnsubscribed()
            if (r1 == 0) goto L_0x0024
        L_0x0010:
            rx.c.a.Ia$b r1 = new rx.c.a.Ia$b
            java.util.concurrent.atomic.AtomicReference<rx.c.a.Ia$b<T>> r2 = r4.f43457c
            r1.<init>(r2)
            r1.mo45768b()
            java.util.concurrent.atomic.AtomicReference<rx.c.a.Ia$b<T>> r2 = r4.f43457c
            boolean r2 = r2.compareAndSet(r0, r1)
            if (r2 != 0) goto L_0x0023
            goto L_0x0000
        L_0x0023:
            r0 = r1
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f43466g
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0037
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f43466g
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            r1 = r2
            r5.call(r0)
            if (r1 == 0) goto L_0x0044
            rx.S<? extends T> r2 = r4.f43456b
            r2.mo3640b(r0)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14588Ia.mo45763d(rx.b.b):void");
    }
}
