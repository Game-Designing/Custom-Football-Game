package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.zd */
public final class C7635zd {

    /* renamed from: a */
    private static String f15149a = C7635zd.class.getSimpleName();

    @TargetApi(21)
    /* renamed from: a */
    public static File m16871a() {
        File file;
        Context context = C7379Fb.m16300a().f14432d;
        if (C7354Ad.m16262a(21)) {
            file = context.getNoBackupFilesDir();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getPath());
            sb.append(File.separator);
            sb.append("no_backup");
            file = new File(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getPath());
        sb2.append(File.separator);
        sb2.append(".flurryNoBackup");
        return new File(sb2.toString());
    }

    /* renamed from: a */
    public static boolean m16872a(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        C7513ec.m16639a(6, f15149a, "Unable to create persistent dir: ".concat(String.valueOf(parentFile)));
        return false;
    }

    /* renamed from: b */
    public static boolean m16874b(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        for (String file2 : file.list()) {
            if (!m16874b(new File(file, file2))) {
                return false;
            }
        }
        return file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[RETURN] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m16875c(java.io.File r6) {
        /*
            r0 = 4
            r1 = 0
            if (r6 == 0) goto L_0x0066
            boolean r2 = r6.exists()
            if (r2 != 0) goto L_0x000b
            goto L_0x0066
        L_0x000b:
            java.lang.String r2 = f15149a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Loading persistent data: "
            r3.<init>(r4)
            java.lang.String r4 = r6.getAbsolutePath()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r2, r3)
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r0.<init>(r6)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0045 }
            r6.<init>()     // Catch:{ Throwable -> 0x0045 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x0045 }
        L_0x0031:
            int r3 = r0.read(r2)     // Catch:{ Throwable -> 0x0045 }
            if (r3 <= 0) goto L_0x0041
            java.lang.String r4 = new java.lang.String     // Catch:{ Throwable -> 0x0045 }
            r5 = 0
            r4.<init>(r2, r5, r3)     // Catch:{ Throwable -> 0x0045 }
            r6.append(r4)     // Catch:{ Throwable -> 0x0045 }
            goto L_0x0031
        L_0x0041:
            com.flurry.sdk.C7354Ad.m16261a(r0)
            goto L_0x0059
        L_0x0045:
            r6 = move-exception
            goto L_0x004c
        L_0x0047:
            r6 = move-exception
            r0 = r1
            goto L_0x0062
        L_0x004a:
            r6 = move-exception
            r0 = r1
        L_0x004c:
            r2 = 6
            java.lang.String r3 = f15149a     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = "Error when loading persistent file"
            com.flurry.sdk.C7513ec.m16640a(r2, r3, r4, r6)     // Catch:{ all -> 0x0061 }
            com.flurry.sdk.C7354Ad.m16261a(r0)
            r6 = r1
        L_0x0059:
            if (r6 == 0) goto L_0x0060
            java.lang.String r6 = r6.toString()
            return r6
        L_0x0060:
            return r1
        L_0x0061:
            r6 = move-exception
        L_0x0062:
            com.flurry.sdk.C7354Ad.m16261a(r0)
            throw r6
        L_0x0066:
            java.lang.String r6 = f15149a
            java.lang.String r2 = "Persistent file doesn't exist."
            com.flurry.sdk.C7513ec.m16639a(r0, r6, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7635zd.m16875c(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    public static String[] m16873a(File file, Pattern pattern) {
        if (!file.exists()) {
            return new String[0];
        }
        String[] list = file.list(new C7629yd(pattern));
        if (list == null) {
            list = new String[0];
        }
        return list;
    }
}
