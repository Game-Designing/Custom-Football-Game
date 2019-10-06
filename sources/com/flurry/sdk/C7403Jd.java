package com.flurry.sdk;

import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.StatFs;
import com.flurry.sdk.C7369Dd.C7370a;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.flurry.sdk.Jd */
public class C7403Jd {

    /* renamed from: a */
    public static final String f14516a = C7403Jd.class.getSimpleName();

    /* renamed from: a */
    public static Map<String, String> m16377a(boolean z) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("mem.java.max", Long.toString(Runtime.getRuntime().maxMemory()));
        } catch (RuntimeException e) {
            C7513ec.m16642a(f14516a, "Error retrieving max memory", (Throwable) e);
        }
        try {
            MemoryInfo memoryInfo = new MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            hashMap.put("mem.pss", Long.toString((long) (memoryInfo.getTotalPss() * Opcodes.ACC_ABSTRACT)));
        } catch (RuntimeException e2) {
            C7513ec.m16642a(f14516a, "Error retrieving pss memory", (Throwable) e2);
        }
        String str = "application.state";
        if (C7379Fb.m16303b()) {
            hashMap.put(str, Integer.toString(C7370a.ACTIVE.f14400f));
        } else {
            hashMap.put(str, Integer.toString(C7370a.BACKGROUND.f14400f));
        }
        int i = -1;
        try {
            C7475Xa.m16549a();
            i = C7475Xa.m16559k() - 1;
        } catch (Exception e3) {
        }
        hashMap.put("net.status", Integer.toString(i));
        int i2 = 0;
        try {
            i2 = C7624xd.m16861a();
        } catch (RuntimeException e4) {
        }
        hashMap.put(AdUnitActivity.EXTRA_ORIENTATION, Integer.toString(i2));
        if (!z) {
            C7379Fb.m16300a().mo23817b(new C7398Id(hashMap));
        } else {
            m16381d(hashMap);
            m16378a((Map<String, String>) hashMap);
            m16379b(hashMap);
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad A[Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:60:0x00d6=Splitter:B:60:0x00d6, B:65:0x00df=Splitter:B:65:0x00df} */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m16381d(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "^Vm(RSS|Size|Peak):\\s+(\\d+)\\s+kB$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "/proc/"
            r2.<init>(r3)
            int r3 = android.os.Process.myPid()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "status"
            r2.<init>(r1, r3)
            r1 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d4, all -> 0x00d0 }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d4, all -> 0x00d0 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c8, all -> 0x00c5 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c8, all -> 0x00c5 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c8, all -> 0x00c5 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c8, all -> 0x00c5 }
            java.lang.String r1 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
        L_0x0042:
            if (r1 == 0) goto L_0x00b8
            java.util.regex.Matcher r1 = r0.matcher(r1)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            boolean r4 = r1.find()     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            if (r4 == 0) goto L_0x00b3
            r4 = 1
            java.lang.String r5 = r1.group(r4)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            r6 = 2
            java.lang.String r1 = r1.group(r6)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            if (r7 != 0) goto L_0x00b3
            boolean r7 = android.text.TextUtils.isEmpty(r1)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            if (r7 == 0) goto L_0x0066
            goto L_0x00b3
        L_0x0066:
            r7 = -1
            int r8 = r5.hashCode()     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            r9 = 81458(0x13e32, float:1.14147E-40)
            if (r8 == r9) goto L_0x008f
            r9 = 2483455(0x25e4ff, float:3.480062E-39)
            if (r8 == r9) goto L_0x0085
            r9 = 2577441(0x275421, float:3.611764E-39)
            if (r8 == r9) goto L_0x007b
        L_0x007a:
            goto L_0x0099
        L_0x007b:
            java.lang.String r8 = "Size"
            boolean r5 = r5.equals(r8)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            if (r5 == 0) goto L_0x007a
            r5 = 1
            goto L_0x009a
        L_0x0085:
            java.lang.String r8 = "Peak"
            boolean r5 = r5.equals(r8)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            if (r5 == 0) goto L_0x007a
            r5 = 2
            goto L_0x009a
        L_0x008f:
            java.lang.String r8 = "RSS"
            boolean r5 = r5.equals(r8)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            if (r5 == 0) goto L_0x007a
            r5 = 0
            goto L_0x009a
        L_0x0099:
            r5 = -1
        L_0x009a:
            if (r5 == 0) goto L_0x00ad
            if (r5 == r4) goto L_0x00a7
            if (r5 == r6) goto L_0x00a1
            goto L_0x00b3
        L_0x00a1:
            java.lang.String r4 = "mem.virt.max"
            r10.put(r4, r1)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            goto L_0x00b3
        L_0x00a7:
            java.lang.String r4 = "mem.virt"
            r10.put(r4, r1)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            goto L_0x00b3
        L_0x00ad:
            java.lang.String r4 = "mem.rss"
            r10.put(r4, r1)     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
        L_0x00b3:
            java.lang.String r1 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x00c3, IOException -> 0x00c1, all -> 0x00bf }
            goto L_0x0042
        L_0x00b8:
            com.flurry.sdk.C7354Ad.m16261a(r3)
        L_0x00bb:
            com.flurry.sdk.C7354Ad.m16261a(r2)
            return
        L_0x00bf:
            r10 = move-exception
            goto L_0x00e5
        L_0x00c1:
            r10 = move-exception
            goto L_0x00ca
        L_0x00c3:
            r10 = move-exception
            goto L_0x00ce
        L_0x00c5:
            r10 = move-exception
            r2 = r1
            goto L_0x00e5
        L_0x00c8:
            r10 = move-exception
            r2 = r1
        L_0x00ca:
            r1 = r3
            goto L_0x00d6
        L_0x00cc:
            r10 = move-exception
            r2 = r1
        L_0x00ce:
            r1 = r3
            goto L_0x00df
        L_0x00d0:
            r10 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x00e5
        L_0x00d4:
            r10 = move-exception
            r2 = r1
        L_0x00d6:
            r10.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00d9:
            com.flurry.sdk.C7354Ad.m16261a(r1)
            goto L_0x00bb
        L_0x00dd:
            r10 = move-exception
            r2 = r1
        L_0x00df:
            r10.printStackTrace()     // Catch:{ all -> 0x00e3 }
            goto L_0x00d9
        L_0x00e3:
            r10 = move-exception
            r3 = r1
        L_0x00e5:
            com.flurry.sdk.C7354Ad.m16261a(r3)
            com.flurry.sdk.C7354Ad.m16261a(r2)
            goto L_0x00ed
        L_0x00ec:
            throw r10
        L_0x00ed:
            goto L_0x00ec
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7403Jd.m16381d(java.util.Map):void");
    }

    /* renamed from: a */
    static void m16378a(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (VERSION.SDK_INT >= 18) {
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getAvailableBlocks();
        }
        map.put("disk.size.free", Long.toString(j2 * j));
    }

    /* renamed from: b */
    static void m16379b(Map<String, String> map) {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
        } else {
            j = (long) statFs.getBlockSize();
        }
        if (VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockCountLong();
        } else {
            j2 = (long) statFs.getBlockCount();
        }
        map.put("disk.size.total", Long.toString(j2 * j));
    }
}
