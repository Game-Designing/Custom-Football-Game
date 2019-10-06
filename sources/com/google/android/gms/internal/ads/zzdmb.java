package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

public final class zzdmb {

    /* renamed from: a */
    private static final C9455go f27966a;

    /* renamed from: b */
    private static final int f27967b;

    /* renamed from: com.google.android.gms.internal.ads.zzdmb$a */
    static final class C9873a extends C9455go {
        C9873a() {
        }

        /* renamed from: a */
        public final void mo28965a(Throwable th, Throwable th2) {
        }

        /* renamed from: a */
        public final void mo28963a(Throwable th) {
            th.printStackTrace();
        }

        /* renamed from: a */
        public final void mo28964a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* renamed from: a */
    public static void m29637a(Throwable th, Throwable th2) {
        f27966a.mo28965a(th, th2);
    }

    /* renamed from: a */
    public static void m29635a(Throwable th) {
        f27966a.mo28963a(th);
    }

    /* renamed from: a */
    public static void m29636a(Throwable th, PrintWriter printWriter) {
        f27966a.mo28964a(th, printWriter);
    }

    /* renamed from: a */
    private static Integer m29634a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = m29634a()     // Catch:{ Throwable -> 0x002d }
            if (r1 == 0) goto L_0x0016
            int r2 = r1.intValue()     // Catch:{ Throwable -> 0x002b }
            r3 = 19
            if (r2 < r3) goto L_0x0016
            com.google.android.gms.internal.ads.ko r2 = new com.google.android.gms.internal.ads.ko     // Catch:{ Throwable -> 0x002b }
            r2.<init>()     // Catch:{ Throwable -> 0x002b }
            goto L_0x0064
        L_0x0016:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch:{ Throwable -> 0x002b }
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.jo r2 = new com.google.android.gms.internal.ads.jo     // Catch:{ Throwable -> 0x002b }
            r2.<init>()     // Catch:{ Throwable -> 0x002b }
            goto L_0x0064
        L_0x0025:
            com.google.android.gms.internal.ads.zzdmb$a r2 = new com.google.android.gms.internal.ads.zzdmb$a     // Catch:{ Throwable -> 0x002b }
            r2.<init>()     // Catch:{ Throwable -> 0x002b }
            goto L_0x0064
        L_0x002b:
            r2 = move-exception
            goto L_0x002f
        L_0x002d:
            r2 = move-exception
            r1 = 0
        L_0x002f:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.ads.zzdmb$a> r4 = com.google.android.gms.internal.ads.zzdmb.C9873a.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.ads.zzdmb$a r2 = new com.google.android.gms.internal.ads.zzdmb$a
            r2.<init>()
        L_0x0064:
            f27966a = r2
            if (r1 != 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            int r0 = r1.intValue()
        L_0x006d:
            f27967b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmb.<clinit>():void");
    }
}
