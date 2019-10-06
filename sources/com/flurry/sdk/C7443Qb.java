package com.flurry.sdk;

import java.io.File;

/* renamed from: com.flurry.sdk.Qb */
public class C7443Qb<T> {

    /* renamed from: a */
    private static final String f14617a = C7443Qb.class.getSimpleName();

    /* renamed from: b */
    private final File f14618b;

    /* renamed from: c */
    private final C7493ad<T> f14619c;

    public C7443Qb(File file, String str, int i, C7521fd<T> fdVar) {
        this.f14618b = file;
        this.f14619c = new C7477Xc(new C7514ed(str, i, fdVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T mo23881a() {
        /*
            r7 = this;
            java.io.File r0 = r7.f14618b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0027
            r0 = 5
            java.lang.String r2 = f14617a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "No data to read for file:"
            r3.<init>(r4)
            java.io.File r4 = r7.f14618b
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r2, r3)
            return r1
        L_0x0027:
            r0 = 0
            r2 = 3
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.io.File r4 = r7.f14618b     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            com.flurry.sdk.ad<T> r4 = r7.f14619c     // Catch:{ Exception -> 0x003c }
            java.lang.Object r1 = r4.mo23855a(r3)     // Catch:{ Exception -> 0x003c }
        L_0x0038:
            com.flurry.sdk.C7354Ad.m16261a(r3)
            goto L_0x005e
        L_0x003c:
            r0 = move-exception
            goto L_0x0043
        L_0x003e:
            r0 = move-exception
            r3 = r1
            goto L_0x0080
        L_0x0041:
            r0 = move-exception
            r3 = r1
        L_0x0043:
            java.lang.String r4 = f14617a     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            java.lang.String r6 = "Error reading data file:"
            r5.<init>(r6)     // Catch:{ all -> 0x007f }
            java.io.File r6 = r7.f14618b     // Catch:{ all -> 0x007f }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x007f }
            r5.append(r6)     // Catch:{ all -> 0x007f }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x007f }
            com.flurry.sdk.C7513ec.m16640a(r2, r4, r5, r0)     // Catch:{ all -> 0x007f }
            r0 = 1
            goto L_0x0038
        L_0x005e:
            if (r0 == 0) goto L_0x007e
            java.lang.String r0 = f14617a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Deleting data file:"
            r3.<init>(r4)
            java.io.File r4 = r7.f14618b
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.flurry.sdk.C7513ec.m16639a(r2, r0, r3)
            java.io.File r0 = r7.f14618b
            r0.delete()
        L_0x007e:
            return r1
        L_0x007f:
            r0 = move-exception
        L_0x0080:
            com.flurry.sdk.C7354Ad.m16261a(r3)
            goto L_0x0085
        L_0x0084:
            throw r0
        L_0x0085:
            goto L_0x0084
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7443Qb.mo23881a():java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo23882a(T r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 3
            if (r7 != 0) goto L_0x0020
            java.lang.String r7 = f14617a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "No data to write for file:"
            r2.<init>(r3)
            java.io.File r3 = r6.f14618b
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.flurry.sdk.C7513ec.m16639a(r1, r7, r2)
            goto L_0x0069
        L_0x0020:
            r2 = 0
            java.io.File r3 = r6.f14618b     // Catch:{ Exception -> 0x004a }
            boolean r3 = com.flurry.sdk.C7635zd.m16872a(r3)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0040
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004a }
            java.io.File r4 = r6.f14618b     // Catch:{ Exception -> 0x004a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x004a }
            com.flurry.sdk.ad<T> r2 = r6.f14619c     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            r2.mo23856a(r3, r7)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            com.flurry.sdk.C7354Ad.m16261a(r3)
            r0 = 0
            goto L_0x0069
        L_0x003a:
            r7 = move-exception
            r2 = r3
            goto L_0x008a
        L_0x003d:
            r7 = move-exception
            r2 = r3
            goto L_0x004b
        L_0x0040:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = "Cannot create parent directory!"
            r7.<init>(r3)     // Catch:{ Exception -> 0x004a }
            throw r7     // Catch:{ Exception -> 0x004a }
        L_0x0048:
            r7 = move-exception
            goto L_0x008a
        L_0x004a:
            r7 = move-exception
        L_0x004b:
            java.lang.String r3 = f14617a     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = "Error writing data file:"
            r4.<init>(r5)     // Catch:{ all -> 0x0048 }
            java.io.File r5 = r6.f14618b     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0048 }
            r4.append(r5)     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0048 }
            com.flurry.sdk.C7513ec.m16640a(r1, r3, r4, r7)     // Catch:{ all -> 0x0048 }
            com.flurry.sdk.C7354Ad.m16261a(r2)
        L_0x0069:
            if (r0 == 0) goto L_0x0089
            java.lang.String r7 = f14617a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Deleting data file:"
            r0.<init>(r2)
            java.io.File r2 = r6.f14618b
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.flurry.sdk.C7513ec.m16639a(r1, r7, r0)
            java.io.File r7 = r6.f14618b
            r7.delete()
        L_0x0089:
            return
        L_0x008a:
            com.flurry.sdk.C7354Ad.m16261a(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7443Qb.mo23882a(java.lang.Object):void");
    }

    /* renamed from: b */
    public final boolean mo23883b() {
        File file = this.f14618b;
        if (file == null) {
            return false;
        }
        return file.delete();
    }
}
