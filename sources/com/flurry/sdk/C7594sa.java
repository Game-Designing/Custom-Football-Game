package com.flurry.sdk;

/* renamed from: com.flurry.sdk.sa */
public class C7594sa {

    /* renamed from: a */
    private static final String f15071a = C7594sa.class.getSimpleName();

    /* renamed from: b */
    public byte[] f15072b = null;

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0450 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x04b0 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }, LOOP:8: B:105:0x04aa->B:107:0x04b0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01a5 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01ae A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01b4 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0260 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0268 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x027d A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0286 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x029c A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0315 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x031e A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0334 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x042b A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x042d A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0433 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0435 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0443 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0447 A[Catch:{ Throwable -> 0x04db, all -> 0x04d8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C7594sa(java.lang.String r17, java.lang.String r18, boolean r19, boolean r20, long r21, long r23, java.util.List<com.flurry.sdk.C7631za> r25, java.util.Map<com.flurry.sdk.C7583qb, byte[]> r26, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r27, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r28, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r29, long r30, com.flurry.sdk.C7602td r32, boolean r33) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            r2 = r32
            java.lang.String r3 = ":  "
            r16.<init>()
            r4 = 0
            r1.f15072b = r4
            com.flurry.sdk.Ob r5 = new com.flurry.sdk.Ob     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            r5.<init>()     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            r6.<init>()     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            java.security.DigestOutputStream r7 = new java.security.DigestOutputStream     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            r7.<init>(r6, r5)     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            r8.<init>(r7)     // Catch:{ Throwable -> 0x04e3, all -> 0x04df }
            r9 = 35
            r8.writeShort(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r9 = 0
            r8.writeShort(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r10 = 0
            r8.writeLong(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r10 = 3
            r8.writeShort(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r11 = com.flurry.sdk.C7384Gb.m16351a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r11 = r30
            r8.writeLong(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r11 = r17
            r8.writeUTF(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r11 = r18
            r8.writeUTF(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = "VersionName"
            java.lang.Object r11 = r2.mo24023a(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r13 = ""
            if (r12 == 0) goto L_0x0061
            r8.writeUTF(r13)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x0064
        L_0x0061:
            r8.writeUTF(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x0064:
            com.flurry.sdk.Fb r11 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            android.content.Context r11 = r11.f14432d     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            android.content.pm.PackageManager r12 = r11.getPackageManager()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            android.content.pm.PackageInfo r11 = r12.getPackageInfo(r11, r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r11 = r11.versionCode     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            com.flurry.sdk.dc r11 = com.flurry.sdk.C7508dc.m16634a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            boolean r11 = r11.f14800c     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12 = 1
            if (r11 == 0) goto L_0x0097
            r8.writeByte(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "Agent report type: instant app"
            com.flurry.sdk.C7513ec.m16649c(r11, r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x00a1
        L_0x0097:
            r8.writeByte(r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "Agent report type: main device"
            com.flurry.sdk.C7513ec.m16649c(r11, r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x00a1:
            int r11 = r26.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Set r11 = r26.entrySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x00b0:
            boolean r14 = r11.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r14 == 0) goto L_0x00d5
            java.lang.Object r14 = r11.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r15 = r14.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            com.flurry.sdk.qb r15 = (com.flurry.sdk.C7583qb) r15     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r15 = r15.f15034e     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r14 = r14.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            byte[] r14 = (byte[]) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r15 = r14.length     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.write(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x00b0
        L_0x00d5:
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r11 = r19
            r8.writeBoolean(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r11 = r20
            r8.writeBoolean(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14 = r21
            r8.writeLong(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14 = r23
            r8.writeLong(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r11 = 2
            if (r33 == 0) goto L_0x00f3
            r8.writeByte(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x00f6
        L_0x00f3:
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x00f6:
            java.lang.String r14 = "IncludeBackgroundSessionsInMetrics"
            java.lang.Object r14 = r2.mo24023a(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            boolean r14 = r14.booleanValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeBoolean(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "os.arch"
            java.lang.String r14 = java.lang.System.getProperty(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r15 == 0) goto L_0x0112
            r14 = r13
        L_0x0112:
            r15 = 8
            r8.writeShort(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "device.model"
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = android.os.Build.MODEL     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "build.brand"
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = android.os.Build.BRAND     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "build.id"
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = android.os.Build.ID     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "version.release"
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = android.os.Build.VERSION.RELEASE     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "build.device"
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = android.os.Build.DEVICE     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "build.product"
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = android.os.Build.PRODUCT     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "proguard.build.uuid"
            r8.writeUTF(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            com.flurry.sdk.C7479Ya.m16564a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            com.flurry.sdk.Fb r15 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            android.content.Context r15 = r15.f14432d     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r15 == 0) goto L_0x0191
            android.content.res.Resources r4 = r15.getResources()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = "com.flurry.crash.map_id"
            java.lang.String r12 = "string"
            java.lang.String r10 = r15.getPackageName()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r4 = r4.getIdentifier(r11, r12, r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r4 == 0) goto L_0x0191
            android.content.res.Resources r10 = r15.getResources()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r4 = r10.getString(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x0192
        L_0x0191:
            r4 = r13
        L_0x0192:
            r8.writeUTF(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r4 = "device.arch"
            r8.writeUTF(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeByte(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r27 == 0) goto L_0x01ae
            java.util.Set r4 = r27.keySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r4 = r4.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x01af
        L_0x01ae:
            r4 = 0
        L_0x01af:
            r8.writeShort(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r27 == 0) goto L_0x0252
            java.lang.String r4 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = "sending referrer values because it exists"
            r11 = 3
            com.flurry.sdk.C7513ec.m16639a(r11, r4, r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Set r4 = r27.entrySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x01c4:
            boolean r10 = r4.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r10 == 0) goto L_0x0252
            java.lang.Object r10 = r4.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "Referrer Entry:  "
            r12.<init>(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r14 = r10.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12.append(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "="
            r12.append(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r14 = r10.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12.append(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14 = 3
            com.flurry.sdk.C7513ec.m16639a(r14, r11, r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "referrer key is :"
            r12.<init>(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r14 = r10.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12.append(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14 = 3
            com.flurry.sdk.C7513ec.m16639a(r14, r11, r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r10.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r11 = r11.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x0230:
            boolean r11 = r10.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r11 == 0) goto L_0x0250
            java.lang.Object r11 = r10.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "referrer value is :"
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = r14.concat(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14 = 3
            com.flurry.sdk.C7513ec.m16639a(r14, r12, r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x0230
        L_0x0250:
            goto L_0x01c4
        L_0x0252:
            java.lang.String r4 = "notificationToken"
            java.lang.Object r4 = r2.mo24023a(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r10 != 0) goto L_0x0268
            r10 = 1
            r8.writeBoolean(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x026c
        L_0x0268:
            r10 = 1
            r8.writeBoolean(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x026c:
            java.lang.String r4 = "notificationsEnabled"
            java.lang.Object r2 = r2.mo24023a(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            boolean r2 = r2.booleanValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeBoolean(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r28 == 0) goto L_0x0286
            java.util.Set r2 = r28.keySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r2 = r2.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x0287
        L_0x0286:
            r2 = 0
        L_0x0287:
            java.lang.String r4 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = "optionsMapSize is:  "
            java.lang.String r12 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = r11.concat(r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12 = 3
            com.flurry.sdk.C7513ec.m16639a(r12, r4, r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r28 == 0) goto L_0x0313
            java.lang.String r4 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = "sending launch options"
            r12 = 3
            com.flurry.sdk.C7513ec.m16639a(r12, r4, r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Set r4 = r28.entrySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x02ac:
            boolean r11 = r4.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r11 == 0) goto L_0x0313
            java.lang.Object r11 = r4.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "Launch Options Key:  "
            r14.<init>(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r15 = r11.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14.append(r15)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = r14.toString()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r15 = 3
            com.flurry.sdk.C7513ec.m16639a(r15, r12, r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r12 = r11.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.List r12 = (java.util.List) r12     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r12 = r12.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x02f2:
            boolean r12 = r11.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r12 == 0) goto L_0x0312
            java.lang.Object r12 = r11.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r15 = "Launch Options value is :"
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = r15.concat(r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r15 = 3
            com.flurry.sdk.C7513ec.m16639a(r15, r14, r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x02f2
        L_0x0312:
            goto L_0x02ac
        L_0x0313:
            if (r29 == 0) goto L_0x031e
            java.util.Set r4 = r29.keySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r4 = r4.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x031f
        L_0x031e:
            r4 = 0
        L_0x031f:
            java.lang.String r11 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = "numOriginAttributions is:  "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r2 = r12.concat(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12 = 3
            com.flurry.sdk.C7513ec.m16639a(r12, r11, r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r29 == 0) goto L_0x0417
            java.util.Set r2 = r29.entrySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x033c:
            boolean r4 = r2.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r4 == 0) goto L_0x0417
            java.lang.Object r4 = r2.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "Origin Atttribute Key:  "
            r12.<init>(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r14 = r4.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12.append(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14 = 3
            com.flurry.sdk.C7513ec.m16639a(r14, r11, r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r4.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r4.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r11 = r11.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = "Origin Attribute Map Size for "
            r12.<init>(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r14 = r4.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12.append(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12.append(r3)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r14 = r4.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            int r14 = r14.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r12.append(r14)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r14 = 3
            com.flurry.sdk.C7513ec.m16639a(r14, r11, r12)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r4.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Set r11 = r11.entrySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x03b0:
            boolean r12 = r11.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r12 == 0) goto L_0x0414
            java.lang.Object r12 = r11.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r14 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = "Origin Atttribute for "
            r15.<init>(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r10 = r4.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r15.append(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r15.append(r3)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r10 = r12.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r15.append(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = ":"
            r15.append(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r10 = r12.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r15.append(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = r15.toString()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r15 = 3
            com.flurry.sdk.C7513ec.m16639a(r15, r14, r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r10 = r12.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r10 == 0) goto L_0x03fd
            java.lang.Object r10 = r12.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x03fe
        L_0x03fd:
            r10 = r13
        L_0x03fe:
            r8.writeUTF(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r10 = r12.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r10 == 0) goto L_0x040e
            java.lang.Object r10 = r12.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x040f
        L_0x040e:
            r10 = r13
        L_0x040f:
            r8.writeUTF(r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r10 = 1
            goto L_0x03b0
        L_0x0414:
            r10 = 1
            goto L_0x033c
        L_0x0417:
            com.flurry.sdk.Fb r2 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            android.content.Context r2 = r2.f14432d     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r2 = com.flurry.sdk.C7619wd.m16849a(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            d.e.a.a r2 = p019d.p020e.p021a.C7294e.m15871c()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r2 != 0) goto L_0x042d
            r4 = 0
            goto L_0x0431
        L_0x042d:
            java.util.Map r4 = r2.mo23506a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x0431:
            if (r2 != 0) goto L_0x0435
            r2 = 0
            goto L_0x043e
        L_0x0435:
            boolean r2 = r2.mo23507b()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r2 == 0) goto L_0x043d
            r2 = 1
            goto L_0x043e
        L_0x043d:
            r2 = 2
        L_0x043e:
            r8.writeByte(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r4 != 0) goto L_0x0447
            r8.writeShort(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x044e
        L_0x0447:
            int r2 = r4.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x044e:
            if (r4 == 0) goto L_0x049f
            java.util.Set r2 = r4.entrySet()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x0458:
            boolean r3 = r2.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r3 == 0) goto L_0x049f
            java.lang.Object r3 = r2.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r4 = f15071a     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = "Consent string for "
            r10.<init>(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r3.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r10.append(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = ": "
            r10.append(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r11 = r3.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r10.append(r11)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r11 = 3
            com.flurry.sdk.C7513ec.m16639a(r11, r4, r10)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r4)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeUTF(r3)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x0458
        L_0x049f:
            int r2 = r25.size()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            java.util.Iterator r2 = r25.iterator()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
        L_0x04aa:
            boolean r3 = r2.hasNext()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            if (r3 == 0) goto L_0x04bd
            java.lang.Object r3 = r2.next()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            com.flurry.sdk.za r3 = (com.flurry.sdk.C7631za) r3     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            byte[] r3 = r3.f15146b     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.write(r3)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            goto L_0x04aa
        L_0x04bd:
            r8.writeShort(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.writeShort(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r7.on(r9)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            byte[] r2 = r5.mo23871a()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.write(r2)     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            r8.close()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            byte[] r4 = r6.toByteArray()     // Catch:{ Throwable -> 0x04db, all -> 0x04d8 }
            com.flurry.sdk.C7354Ad.m16261a(r8)
            goto L_0x04f2
        L_0x04d8:
            r0 = move-exception
            r2 = r0
            goto L_0x04f8
        L_0x04db:
            r0 = move-exception
            r2 = r0
            r4 = r8
            goto L_0x04e6
        L_0x04df:
            r0 = move-exception
            r2 = r0
            r8 = 0
            goto L_0x04f8
        L_0x04e3:
            r0 = move-exception
            r2 = r0
            r4 = 0
        L_0x04e6:
            r3 = 6
            java.lang.String r5 = f15071a     // Catch:{ all -> 0x04f5 }
            java.lang.String r6 = "Error when generating report"
            com.flurry.sdk.C7513ec.m16640a(r3, r5, r6, r2)     // Catch:{ all -> 0x04f5 }
            com.flurry.sdk.C7354Ad.m16261a(r4)
            r4 = 0
        L_0x04f2:
            r1.f15072b = r4
            return
        L_0x04f5:
            r0 = move-exception
            r2 = r0
            r8 = r4
        L_0x04f8:
            com.flurry.sdk.C7354Ad.m16261a(r8)
            goto L_0x04fd
        L_0x04fc:
            throw r2
        L_0x04fd:
            goto L_0x04fc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7594sa.<init>(java.lang.String, java.lang.String, boolean, boolean, long, long, java.util.List, java.util.Map, java.util.Map, java.util.Map, java.util.Map, long, com.flurry.sdk.td, boolean):void");
    }
}
