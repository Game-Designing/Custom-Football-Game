package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;
import p026rx.p029i.C14977e;
import p026rx.p399e.C14917f;

/* renamed from: rx.c.a.ma */
/* compiled from: OperatorDebounceWithTime */
public final class C14691ma<T> implements C0123b<T, T> {

    /* renamed from: a */
    final long f43715a;

    /* renamed from: b */
    final TimeUnit f43716b;

    /* renamed from: c */
    final C0126V f43717c;

    /* renamed from: rx.c.a.ma$a */
    /* compiled from: OperatorDebounceWithTime */
    static final class C14692a<T> {

        /* renamed from: a */
        int f43718a;

        /* renamed from: b */
        T f43719b;

        /* renamed from: c */
        boolean f43720c;

        /* renamed from: d */
        boolean f43721d;

        /* renamed from: e */
        boolean f43722e;

        C14692a() {
        }

        /* renamed from: a */
        public synchronized int mo45830a(T value) {
            int i;
            this.f43719b = value;
            this.f43720c = true;
            i = this.f43718a + 1;
            this.f43718a = i;
            return i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r6.onNext(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
            if (r4.f43721d != false) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0023, code lost:
            r4.f43722e = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0026, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0027, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0028, code lost:
            r6.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x002f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0030, code lost:
            p026rx.exceptions.C14927a.m46673a(r0, (p026rx.C0125T<?>) r7, (java.lang.Object) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0033, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45832a(int r5, p026rx.C14980ia<T> r6, p026rx.C14980ia<?> r7) {
            /*
                r4 = this;
                monitor-enter(r4)
                r0 = 0
                boolean r1 = r4.f43722e     // Catch:{ all -> 0x003b }
                if (r1 != 0) goto L_0x0039
                boolean r1 = r4.f43720c     // Catch:{ all -> 0x003b }
                if (r1 == 0) goto L_0x0039
                int r1 = r4.f43718a     // Catch:{ all -> 0x003b }
                if (r5 == r1) goto L_0x000f
                goto L_0x0039
            L_0x000f:
                T r1 = r4.f43719b     // Catch:{ all -> 0x003b }
                r4.f43719b = r0     // Catch:{ all -> 0x0034 }
                r0 = 0
                r4.f43720c = r0     // Catch:{ all -> 0x0034 }
                r2 = 1
                r4.f43722e = r2     // Catch:{ all -> 0x0034 }
                monitor-exit(r4)     // Catch:{ all -> 0x0034 }
                r6.onNext(r1)     // Catch:{ Throwable -> 0x002f }
                monitor-enter(r4)
                boolean r2 = r4.f43721d     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x0027
                r4.f43722e = r0     // Catch:{ all -> 0x002c }
                monitor-exit(r4)     // Catch:{ all -> 0x002c }
                return
            L_0x0027:
                monitor-exit(r4)     // Catch:{ all -> 0x002c }
                r6.onCompleted()
                return
            L_0x002c:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x002c }
                throw r0
            L_0x002f:
                r0 = move-exception
                p026rx.exceptions.C14927a.m46673a(r0, r7, r1)
                return
            L_0x0034:
                r0 = move-exception
                r3 = r1
                r1 = r0
                r0 = r3
                goto L_0x003c
            L_0x0039:
                monitor-exit(r4)     // Catch:{ all -> 0x003b }
                return
            L_0x003b:
                r1 = move-exception
            L_0x003c:
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r1
            L_0x003e:
                r1 = move-exception
                goto L_0x003c
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14691ma.C14692a.mo45832a(int, rx.ia, rx.ia):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
            if (r4 == false) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r7.onNext(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x001e, code lost:
            p026rx.exceptions.C14927a.m46673a(r0, (p026rx.C0125T<?>) r8, (java.lang.Object) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0022, code lost:
            r7.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45833a(p026rx.C14980ia<T> r7, p026rx.C14980ia<?> r8) {
            /*
                r6 = this;
                monitor-enter(r6)
                r0 = 0
                r1 = 0
                boolean r2 = r6.f43722e     // Catch:{ all -> 0x002b }
                r3 = 1
                if (r2 == 0) goto L_0x000c
                r6.f43721d = r3     // Catch:{ all -> 0x002b }
                monitor-exit(r6)     // Catch:{ all -> 0x002b }
                return
            L_0x000c:
                T r2 = r6.f43719b     // Catch:{ all -> 0x002b }
                boolean r4 = r6.f43720c     // Catch:{ all -> 0x0029 }
                r6.f43719b = r0     // Catch:{ all -> 0x0026 }
                r6.f43720c = r1     // Catch:{ all -> 0x0026 }
                r6.f43722e = r3     // Catch:{ all -> 0x0026 }
                monitor-exit(r6)     // Catch:{ all -> 0x0026 }
                if (r4 == 0) goto L_0x0022
                r7.onNext(r2)     // Catch:{ Throwable -> 0x001d }
                goto L_0x0022
            L_0x001d:
                r0 = move-exception
                p026rx.exceptions.C14927a.m46673a(r0, r8, r2)
                return
            L_0x0022:
                r7.onCompleted()
                return
            L_0x0026:
                r0 = move-exception
                r1 = r4
                goto L_0x002f
            L_0x0029:
                r0 = move-exception
                goto L_0x002f
            L_0x002b:
                r2 = move-exception
                r5 = r2
                r2 = r0
                r0 = r5
            L_0x002f:
                monitor-exit(r6)     // Catch:{ all -> 0x0031 }
                throw r0
            L_0x0031:
                r0 = move-exception
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14691ma.C14692a.mo45833a(rx.ia, rx.ia):void");
        }

        /* renamed from: a */
        public synchronized void mo45831a() {
            this.f43718a++;
            this.f43719b = null;
            this.f43720c = false;
        }
    }

    public C14691ma(long timeout, TimeUnit unit, C0126V scheduler) {
        this.f43715a = timeout;
        this.f43716b = unit;
        this.f43717c = scheduler;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        C0127a worker = this.f43717c.createWorker();
        C14917f fVar = new C14917f(child);
        C14977e serial = new C14977e();
        fVar.add(worker);
        fVar.add(serial);
        C14687la laVar = new C14687la(this, child, serial, worker, fVar);
        return laVar;
    }
}
