package p019d.p307j.p308a.p313e;

/* renamed from: d.j.a.e.f */
/* compiled from: FileDownloadProperties */
public class C13119f {

    /* renamed from: a */
    public final int f40140a;

    /* renamed from: b */
    public final long f40141b;

    /* renamed from: c */
    public final boolean f40142c;

    /* renamed from: d */
    public final boolean f40143d;

    /* renamed from: e */
    public final int f40144e;

    /* renamed from: f */
    public final boolean f40145f;

    /* renamed from: d.j.a.e.f$a */
    /* compiled from: FileDownloadProperties */
    public static class C13120a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C13119f f40146a = new C13119f();
    }

    /* renamed from: a */
    public static C13119f m42785a() {
        return C13120a.f40146a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0269 A[SYNTHETIC, Splitter:B:103:0x0269] */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d6 A[Catch:{ all -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa A[Catch:{ all -> 0x0258 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0105 A[SYNTHETIC, Splitter:B:53:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0201  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C13119f() {
        /*
            r29 = this;
            r1 = r29
            java.lang.String r2 = "file.non-pre-allocation"
            java.lang.String r3 = "download.max-network-thread-count"
            java.lang.String r4 = "download.min-progress-time"
            java.lang.String r5 = "download.min-progress-step"
            java.lang.String r6 = "process.non-separate"
            java.lang.String r7 = "http.lenient"
            r29.<init>()
            android.content.Context r0 = p019d.p307j.p308a.p313e.C13113c.m42768a()
            if (r0 == 0) goto L_0x0274
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r16 = r0
            r17 = 0
            r18 = r10
            android.content.Context r0 = p019d.p307j.p308a.p313e.C13113c.m42768a()     // Catch:{ IOException -> 0x00c9, all -> 0x00bd }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ IOException -> 0x00c9, all -> 0x00bd }
            java.lang.String r10 = "filedownloader.properties"
            java.io.InputStream r0 = r0.open(r10)     // Catch:{ IOException -> 0x00c9, all -> 0x00bd }
            r10 = r0
            if (r10 == 0) goto L_0x0096
            r20 = r11
            r11 = r16
            r11.load(r10)     // Catch:{ IOException -> 0x0090, all -> 0x0086 }
            java.lang.String r0 = r11.getProperty(r7)     // Catch:{ IOException -> 0x0090, all -> 0x0086 }
            r16 = r0
            java.lang.String r0 = r11.getProperty(r6)     // Catch:{ IOException -> 0x0080, all -> 0x0078 }
            r17 = r0
            java.lang.String r0 = r11.getProperty(r5)     // Catch:{ IOException -> 0x006f, all -> 0x0065 }
            r12 = r0
            java.lang.String r0 = r11.getProperty(r4)     // Catch:{ IOException -> 0x006f, all -> 0x0065 }
            r13 = r0
            java.lang.String r0 = r11.getProperty(r3)     // Catch:{ IOException -> 0x006f, all -> 0x0065 }
            r14 = r0
            java.lang.String r0 = r11.getProperty(r2)     // Catch:{ IOException -> 0x006f, all -> 0x0065 }
            r15 = r0
            goto L_0x009e
        L_0x0065:
            r0 = move-exception
            r2 = r0
            r18 = r11
            r20 = r17
            r17 = r10
            goto L_0x0267
        L_0x006f:
            r0 = move-exception
            r20 = r17
            r17 = r10
            r10 = r16
            goto L_0x00d0
        L_0x0078:
            r0 = move-exception
            r2 = r0
            r17 = r10
            r18 = r11
            goto L_0x0267
        L_0x0080:
            r0 = move-exception
            r17 = r10
            r10 = r16
            goto L_0x00d0
        L_0x0086:
            r0 = move-exception
            r2 = r0
            r17 = r10
            r16 = r18
            r18 = r11
            goto L_0x0267
        L_0x0090:
            r0 = move-exception
            r17 = r10
            r10 = r18
            goto L_0x00d0
        L_0x0096:
            r20 = r11
            r11 = r16
            r16 = r18
            r17 = r20
        L_0x009e:
            if (r10 == 0) goto L_0x00ad
            r10.close()     // Catch:{ IOException -> 0x00a4 }
        L_0x00a3:
            goto L_0x00ad
        L_0x00a4:
            r0 = move-exception
            r18 = r0
            r0 = r18
            r0.printStackTrace()
            goto L_0x00a3
        L_0x00ad:
            r18 = r11
            r21 = r12
            r22 = r13
            r0 = r16
            r28 = r17
            r17 = r10
            r10 = r28
            goto L_0x0114
        L_0x00bd:
            r0 = move-exception
            r20 = r11
            r2 = r0
            r28 = r18
            r18 = r16
            r16 = r28
            goto L_0x0267
        L_0x00c9:
            r0 = move-exception
            r20 = r11
            r11 = r16
            r10 = r18
        L_0x00d0:
            r16 = r10
            boolean r10 = r0 instanceof java.io.FileNotFoundException     // Catch:{ all -> 0x025f }
            if (r10 == 0) goto L_0x00fa
            boolean r10 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x025f }
            if (r10 == 0) goto L_0x00f3
            java.lang.Class<d.j.a.e.f> r10 = p019d.p307j.p308a.p313e.C13119f.class
            r18 = r11
            java.lang.String r11 = "not found filedownloader.properties"
            r21 = r12
            r22 = r13
            r12 = 0
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ all -> 0x0258 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r10, r11, r13)     // Catch:{ all -> 0x0258 }
            goto L_0x0103
        L_0x00eb:
            r0 = move-exception
            r21 = r12
            r22 = r13
            r2 = r0
            goto L_0x0267
        L_0x00f3:
            r18 = r11
            r21 = r12
            r22 = r13
            goto L_0x0103
        L_0x00fa:
            r18 = r11
            r21 = r12
            r22 = r13
            r0.printStackTrace()     // Catch:{ all -> 0x0258 }
        L_0x0103:
            if (r17 == 0) goto L_0x0110
            r17.close()     // Catch:{ IOException -> 0x0109 }
        L_0x0108:
            goto L_0x0110
        L_0x0109:
            r0 = move-exception
            r10 = r0
            r0 = r10
            r0.printStackTrace()
            goto L_0x0108
        L_0x0110:
            r0 = r16
            r10 = r20
        L_0x0114:
            java.lang.String r11 = "the value of '%s' must be '%s' or '%s'"
            java.lang.String r13 = "false"
            java.lang.String r12 = "true"
            if (r0 == 0) goto L_0x0148
            boolean r23 = r0.equals(r12)
            if (r23 != 0) goto L_0x013f
            boolean r23 = r0.equals(r13)
            if (r23 == 0) goto L_0x0129
            goto L_0x013f
        L_0x0129:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r7
            r4 = 1
            r3[r4] = r12
            r4 = 2
            r3[r4] = r13
            java.lang.String r3 = p019d.p307j.p308a.p313e.C13121g.m42792a(r11, r3)
            r2.<init>(r3)
            throw r2
        L_0x013f:
            r23 = r3
            boolean r3 = r0.equals(r12)
            r1.f40142c = r3
            goto L_0x014d
        L_0x0148:
            r23 = r3
            r3 = 0
            r1.f40142c = r3
        L_0x014d:
            if (r10 == 0) goto L_0x017a
            boolean r3 = r10.equals(r12)
            if (r3 != 0) goto L_0x0172
            boolean r3 = r10.equals(r13)
            if (r3 == 0) goto L_0x015c
            goto L_0x0172
        L_0x015c:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r6
            r4 = 1
            r3[r4] = r12
            r4 = 2
            r3[r4] = r13
            java.lang.String r3 = p019d.p307j.p308a.p313e.C13121g.m42792a(r11, r3)
            r2.<init>(r3)
            throw r2
        L_0x0172:
            boolean r3 = r10.equals(r12)
            r1.f40143d = r3
            r3 = 0
            goto L_0x017d
        L_0x017a:
            r3 = 0
            r1.f40143d = r3
        L_0x017d:
            if (r21 == 0) goto L_0x0190
            java.lang.Integer r19 = java.lang.Integer.valueOf(r21)
            r24 = r0
            int r0 = r19.intValue()
            int r0 = java.lang.Math.max(r3, r0)
            r1.f40140a = r0
            goto L_0x0196
        L_0x0190:
            r24 = r0
            r0 = 65536(0x10000, float:9.18355E-41)
            r1.f40140a = r0
        L_0x0196:
            if (r22 == 0) goto L_0x01af
            java.lang.Long r0 = java.lang.Long.valueOf(r22)
            r25 = r4
            long r3 = r0.longValue()
            r26 = r5
            r27 = r6
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
            r1.f40141b = r3
            goto L_0x01b9
        L_0x01af:
            r25 = r4
            r26 = r5
            r27 = r6
            r3 = 2000(0x7d0, double:9.88E-321)
            r1.f40141b = r3
        L_0x01b9:
            if (r14 == 0) goto L_0x01cb
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            int r0 = r0.intValue()
            int r0 = m42784a(r0)
            r1.f40144e = r0
            goto L_0x01ce
        L_0x01cb:
            r0 = 3
            r1.f40144e = r0
        L_0x01ce:
            if (r15 == 0) goto L_0x01fa
            boolean r0 = r15.equals(r12)
            if (r0 != 0) goto L_0x01f3
            boolean r0 = r15.equals(r13)
            if (r0 == 0) goto L_0x01dd
            goto L_0x01f3
        L_0x01dd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r2
            r2 = 1
            r3[r2] = r12
            r2 = 2
            r3[r2] = r13
            java.lang.String r2 = p019d.p307j.p308a.p313e.C13121g.m42792a(r11, r3)
            r0.<init>(r2)
            throw r0
        L_0x01f3:
            boolean r0 = r15.equals(r12)
            r1.f40145f = r0
            goto L_0x01fd
        L_0x01fa:
            r2 = 0
            r1.f40145f = r2
        L_0x01fd:
            boolean r0 = p019d.p307j.p308a.p313e.C13117d.f40139a
            if (r0 == 0) goto L_0x0257
            java.lang.Class<d.j.a.e.f> r0 = p019d.p307j.p308a.p313e.C13119f.class
            r2 = 11
            java.lang.Object[] r2 = new java.lang.Object[r2]
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r8
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r7
            boolean r3 = r1.f40142c
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r4 = 2
            r2[r4] = r3
            r3 = 3
            r2[r3] = r27
            r3 = 4
            boolean r4 = r1.f40143d
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r2[r3] = r4
            r3 = 5
            r2[r3] = r26
            r3 = 6
            int r4 = r1.f40140a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            r3 = 7
            r2[r3] = r25
            r3 = 8
            long r4 = r1.f40141b
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2[r3] = r4
            r3 = 9
            r2[r3] = r23
            r3 = 10
            int r4 = r1.f40144e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            java.lang.String r3 = "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d"
            p019d.p307j.p308a.p313e.C13117d.m42781c(r0, r3, r2)
        L_0x0257:
            return
        L_0x0258:
            r0 = move-exception
            r2 = r0
            r12 = r21
            r13 = r22
            goto L_0x0267
        L_0x025f:
            r0 = move-exception
            r18 = r11
            r21 = r12
            r22 = r13
            r2 = r0
        L_0x0267:
            if (r17 == 0) goto L_0x0273
            r17.close()     // Catch:{ IOException -> 0x026d }
            goto L_0x0273
        L_0x026d:
            r0 = move-exception
            r3 = r0
            r0 = r3
            r0.printStackTrace()
        L_0x0273:
            throw r2
        L_0x0274:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Please invoke the FileDownloader#init in Application#onCreate first."
            r0.<init>(r2)
            goto L_0x027d
        L_0x027c:
            throw r0
        L_0x027d:
            goto L_0x027c
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p307j.p308a.p313e.C13119f.<init>():void");
    }

    /* renamed from: a */
    public static int m42784a(int requireCount) {
        Integer valueOf = Integer.valueOf(12);
        Integer valueOf2 = Integer.valueOf(1);
        if (requireCount > 12) {
            C13117d.m42783e(C13119f.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(requireCount), valueOf, valueOf);
            return 12;
        } else if (requireCount >= 1) {
            return requireCount;
        } else {
            C13117d.m42783e(C13119f.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(requireCount), valueOf2, valueOf2);
            return 1;
        }
    }
}
