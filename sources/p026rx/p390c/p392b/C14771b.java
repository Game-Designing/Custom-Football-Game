package p026rx.p390c.p392b;

import p026rx.C14508U;

/* renamed from: rx.c.b.b */
/* compiled from: ProducerArbiter */
public final class C14771b implements C14508U {

    /* renamed from: a */
    static final C14508U f43946a = new C14770a();

    /* renamed from: b */
    long f43947b;

    /* renamed from: c */
    C14508U f43948c;

    /* renamed from: d */
    boolean f43949d;

    /* renamed from: e */
    long f43950e;

    /* renamed from: f */
    long f43951f;

    /* renamed from: g */
    C14508U f43952g;

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r6 = r9.f43947b + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        if (r6 >= 0) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        r6 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        r9.f43947b = r6;
        r0 = r9.f43948c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r0 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        r0.request(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        mo45913a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        if (1 != 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r9.f43949d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0043, code lost:
        if (0 == 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0045, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r9.f43949d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x004d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(long r10) {
        /*
            r9 = this;
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0051
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            monitor-enter(r9)
            boolean r2 = r9.f43949d     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0017
            long r0 = r9.f43950e     // Catch:{ all -> 0x004e }
            long r0 = r0 + r10
            r9.f43950e = r0     // Catch:{ all -> 0x004e }
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            return
        L_0x0017:
            r2 = 1
            r9.f43949d = r2     // Catch:{ all -> 0x004e }
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            r2 = 0
            r3 = 0
            long r4 = r9.f43947b     // Catch:{ all -> 0x0042 }
            long r6 = r4 + r10
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x002a
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x002a:
            r9.f43947b = r6     // Catch:{ all -> 0x0042 }
            rx.U r0 = r9.f43948c     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0033
            r0.request(r10)     // Catch:{ all -> 0x0042 }
        L_0x0033:
            r9.mo45913a()     // Catch:{ all -> 0x0042 }
            r0 = 1
            if (r0 != 0) goto L_0x0041
            monitor-enter(r9)
            r9.f43949d = r3     // Catch:{ all -> 0x003e }
            monitor-exit(r9)     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003e:
            r1 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x003e }
            throw r1
        L_0x0041:
            return
        L_0x0042:
            r0 = move-exception
            if (r2 != 0) goto L_0x004d
            monitor-enter(r9)
            r9.f43949d = r3     // Catch:{ all -> 0x004a }
            monitor-exit(r9)     // Catch:{ all -> 0x004a }
            goto L_0x004d
        L_0x004a:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004a }
            throw r0
        L_0x004d:
            throw r0
        L_0x004e:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            throw r0
        L_0x0051:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "n >= 0 required"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p392b.C14771b.request(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4 = r9.f43947b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r4 == Long.MAX_VALUE) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        r6 = r4 - r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        if (r6 < 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        r9.f43947b = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        throw new java.lang.IllegalStateException("more items arrived than were requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        mo45913a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (1 != 0) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r9.f43949d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0042, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0043, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0044, code lost:
        if (0 == 0) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0046, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r9.f43949d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x004e, code lost:
        throw r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo45914a(long r10) {
        /*
            r9 = this;
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0052
            monitor-enter(r9)
            boolean r2 = r9.f43949d     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0012
            long r0 = r9.f43951f     // Catch:{ all -> 0x004f }
            long r0 = r0 + r10
            r9.f43951f = r0     // Catch:{ all -> 0x004f }
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            return
        L_0x0012:
            r2 = 1
            r9.f43949d = r2     // Catch:{ all -> 0x004f }
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            r2 = 0
            r3 = 0
            long r4 = r9.f43947b     // Catch:{ all -> 0x0043 }
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0034
            long r6 = r4 - r10
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 < 0) goto L_0x002c
            r9.f43947b = r6     // Catch:{ all -> 0x0043 }
            goto L_0x0034
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "more items arrived than were requested"
            r0.<init>(r1)     // Catch:{ all -> 0x0043 }
            throw r0     // Catch:{ all -> 0x0043 }
        L_0x0034:
            r9.mo45913a()     // Catch:{ all -> 0x0043 }
            r0 = 1
            if (r0 != 0) goto L_0x0042
            monitor-enter(r9)
            r9.f43949d = r3     // Catch:{ all -> 0x003f }
            monitor-exit(r9)     // Catch:{ all -> 0x003f }
            goto L_0x0042
        L_0x003f:
            r1 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        L_0x0043:
            r0 = move-exception
            if (r2 != 0) goto L_0x004e
            monitor-enter(r9)
            r9.f43949d = r3     // Catch:{ all -> 0x004b }
            monitor-exit(r9)     // Catch:{ all -> 0x004b }
            goto L_0x004e
        L_0x004b:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004b }
            throw r0
        L_0x004e:
            throw r0
        L_0x004f:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            throw r0
        L_0x0052:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "n > 0 required"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p392b.C14771b.mo45914a(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4.f43948c = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0017, code lost:
        if (r5 == null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        r5.request(r4.f43947b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        mo45913a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        if (1 != 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.f43949d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0027, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x002c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x002d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x002e, code lost:
        if (0 == 0) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0030, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r4.f43949d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0038, code lost:
        throw r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo45915a(p026rx.C14508U r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f43949d     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x000f
            if (r5 != 0) goto L_0x000a
            rx.U r0 = f43946a     // Catch:{ all -> 0x0039 }
            goto L_0x000b
        L_0x000a:
            r0 = r5
        L_0x000b:
            r4.f43952g = r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            return
        L_0x000f:
            r0 = 1
            r4.f43949d = r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            r0 = 0
            r1 = 0
            r4.f43948c = r5     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x001e
            long r2 = r4.f43947b     // Catch:{ all -> 0x002d }
            r5.request(r2)     // Catch:{ all -> 0x002d }
        L_0x001e:
            r4.mo45913a()     // Catch:{ all -> 0x002d }
            r0 = 1
            if (r0 != 0) goto L_0x002c
            monitor-enter(r4)
            r4.f43949d = r1     // Catch:{ all -> 0x0029 }
            monitor-exit(r4)     // Catch:{ all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0029 }
            throw r1
        L_0x002c:
            return
        L_0x002d:
            r2 = move-exception
            if (r0 != 0) goto L_0x0038
            monitor-enter(r4)
            r4.f43949d = r1     // Catch:{ all -> 0x0035 }
            monitor-exit(r4)     // Catch:{ all -> 0x0035 }
            goto L_0x0038
        L_0x0035:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0035 }
            throw r1
        L_0x0038:
            throw r2
        L_0x0039:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p392b.C14771b.mo45915a(rx.U):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0023, code lost:
        r8 = r15.f43947b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        if (r8 == Long.MAX_VALUE) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r12 = r8 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        if (r12 < 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
        if (r12 != Long.MAX_VALUE) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
        r10 = r12 - r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
        if (r10 < 0) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003f, code lost:
        r8 = r10;
        r15.f43947b = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004a, code lost:
        throw new java.lang.IllegalStateException("more produced than requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        r8 = Long.MAX_VALUE;
        r15.f43947b = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
        if (r7 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0056, code lost:
        if (r7 != f43946a) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
        r15.f43948c = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
        r15.f43948c = r7;
        r7.request(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0061, code lost:
        r10 = r15.f43948c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0063, code lost:
        if (r10 == null) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0067, code lost:
        if (r3 == 0) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0069, code lost:
        r10.request(r3);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo45913a() {
        /*
            r15 = this;
            r0 = 0
            r1 = 0
            r7 = r0
            r3 = r1
            r5 = r3
        L_0x0006:
            monitor-enter(r15)
            long r3 = r15.f43950e     // Catch:{ all -> 0x0073 }
            long r5 = r15.f43951f     // Catch:{ all -> 0x0071 }
            rx.U r7 = r15.f43952g     // Catch:{ all -> 0x006f }
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x001c
            int r8 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x001c
            if (r7 != 0) goto L_0x001c
            r0 = 0
            r15.f43949d = r0     // Catch:{ all -> 0x0076 }
            monitor-exit(r15)     // Catch:{ all -> 0x0076 }
            return
        L_0x001c:
            r15.f43950e = r1     // Catch:{ all -> 0x006d }
            r15.f43951f = r1     // Catch:{ all -> 0x006d }
            r15.f43952g = r0     // Catch:{ all -> 0x006d }
            monitor-exit(r15)     // Catch:{ all -> 0x006d }
            long r8 = r15.f43947b
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0052
            long r12 = r8 + r3
            int r14 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r14 < 0) goto L_0x004b
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 != 0) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            long r10 = r12 - r5
            int r14 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r14 < 0) goto L_0x0043
            r8 = r10
            r15.f43947b = r10
            goto L_0x0052
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "more produced than requested"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r15.f43947b = r8
        L_0x0052:
            if (r7 == 0) goto L_0x0061
            rx.U r10 = f43946a
            if (r7 != r10) goto L_0x005b
            r15.f43948c = r0
            goto L_0x006c
        L_0x005b:
            r15.f43948c = r7
            r7.request(r8)
            goto L_0x006c
        L_0x0061:
            rx.U r10 = r15.f43948c
            if (r10 == 0) goto L_0x006c
            int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r11 == 0) goto L_0x006c
            r10.request(r3)
        L_0x006c:
            goto L_0x0006
        L_0x006d:
            r0 = move-exception
            goto L_0x0074
        L_0x006f:
            r0 = move-exception
            goto L_0x0074
        L_0x0071:
            r0 = move-exception
            goto L_0x0074
        L_0x0073:
            r0 = move-exception
        L_0x0074:
            monitor-exit(r15)     // Catch:{ all -> 0x0076 }
            throw r0
        L_0x0076:
            r0 = move-exception
            goto L_0x0074
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p392b.C14771b.mo45913a():void");
    }
}
