package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class zzan implements zzb {

    /* renamed from: a */
    private final Map<String, C9205Wa> f24474a;

    /* renamed from: b */
    private long f24475b;

    /* renamed from: c */
    private final File f24476c;

    /* renamed from: d */
    private final int f24477d;

    public zzan(File file, int i) {
        this.f24474a = new LinkedHashMap(16, 0.75f, true);
        this.f24475b = 0;
        this.f24476c = file;
        this.f24477d = i;
    }

    public zzan(File file) {
        this(file, 5242880);
    }

    /* renamed from: c */
    public final synchronized zzc mo29889c(String str) {
        C9268Za za;
        C9205Wa wa = (C9205Wa) this.f24474a.get(str);
        if (wa == null) {
            return null;
        }
        File e = m25326e(str);
        try {
            za = new C9268Za(new BufferedInputStream(m25313a(e)), e.length());
            C9205Wa a = C9205Wa.m23164a(za);
            if (!TextUtils.equals(str, a.f21879b)) {
                zzag.m24966a("%s: key=%s, found=%s", e.getAbsolutePath(), str, a.f21879b);
                m25323b(str);
                za.close();
                return null;
            }
            byte[] a2 = m25320a(za, za.mo28807a());
            zzc zzc = new zzc();
            zzc.f26224a = a2;
            zzc.f26225b = wa.f21880c;
            zzc.f26226c = wa.f21881d;
            zzc.f26227d = wa.f21882e;
            zzc.f26228e = wa.f21883f;
            zzc.f26229f = wa.f21884g;
            List<zzl> list = wa.f21885h;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzl zzl : list) {
                treeMap.put(zzl.mo31933a(), zzl.mo31934b());
            }
            zzc.f26230g = treeMap;
            zzc.f26231h = Collections.unmodifiableList(wa.f21885h);
            za.close();
            return zzc;
        } catch (IOException e2) {
            zzag.m24966a("%s: %s", e.getAbsolutePath(), e2.toString());
            m25318a(str);
            return null;
        } catch (Throwable th) {
            za.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* renamed from: E */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo29887E() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.io.File r0 = r9.f24476c     // Catch:{ all -> 0x0062 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0062 }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r9.f24476c     // Catch:{ all -> 0x0062 }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0062 }
            java.io.File r3 = r9.f24476c     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0062 }
            r2[r1] = r3     // Catch:{ all -> 0x0062 }
            com.google.android.gms.internal.ads.zzag.m24968b(r0, r2)     // Catch:{ all -> 0x0062 }
        L_0x0022:
            monitor-exit(r9)
            return
        L_0x0024:
            java.io.File r0 = r9.f24476c     // Catch:{ all -> 0x0062 }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x0062 }
        L_0x002f:
            if (r1 >= r2) goto L_0x0060
            r3 = r0[r1]     // Catch:{ all -> 0x0062 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0059 }
            com.google.android.gms.internal.ads.Za r6 = new com.google.android.gms.internal.ads.Za     // Catch:{ IOException -> 0x0059 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0059 }
            java.io.InputStream r8 = m25313a(r3)     // Catch:{ IOException -> 0x0059 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0059 }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x0059 }
            com.google.android.gms.internal.ads.Wa r7 = com.google.android.gms.internal.ads.C9205Wa.m23164a(r6)     // Catch:{ all -> 0x0054 }
            r7.f21878a = r4     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r7.f21879b     // Catch:{ all -> 0x0054 }
            r9.m25319a(r4, r7)     // Catch:{ all -> 0x0054 }
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0054:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x0059 }
            throw r4     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r4 = move-exception
            r3.delete()     // Catch:{ all -> 0x0062 }
        L_0x005d:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x0060:
            monitor-exit(r9)
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r9)
            goto L_0x0066
        L_0x0065:
            throw r0
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzan.mo29887E():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fc, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo29888a(java.lang.String r16, com.google.android.gms.internal.ads.zzc r17) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            monitor-enter(r15)
            long r3 = r1.f24475b     // Catch:{ all -> 0x0129 }
            byte[] r5 = r2.f26224a     // Catch:{ all -> 0x0129 }
            int r5 = r5.length     // Catch:{ all -> 0x0129 }
            long r5 = (long) r5     // Catch:{ all -> 0x0129 }
            long r3 = r3 + r5
            int r5 = r1.f24477d     // Catch:{ all -> 0x0129 }
            long r5 = (long) r5     // Catch:{ all -> 0x0129 }
            r7 = 1063675494(0x3f666666, float:0.9)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x0026
            byte[] r3 = r2.f26224a     // Catch:{ all -> 0x0129 }
            int r3 = r3.length     // Catch:{ all -> 0x0129 }
            float r3 = (float) r3     // Catch:{ all -> 0x0129 }
            int r4 = r1.f24477d     // Catch:{ all -> 0x0129 }
            float r4 = (float) r4
            float r4 = r4 * r7
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0026
            monitor-exit(r15)
            return
        L_0x0026:
            java.io.File r3 = r15.m25326e(r16)     // Catch:{ all -> 0x0129 }
            r4 = 1
            r5 = 0
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0113 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0113 }
            r8.<init>(r3)     // Catch:{ IOException -> 0x0113 }
            r6.<init>(r8)     // Catch:{ IOException -> 0x0113 }
            com.google.android.gms.internal.ads.Wa r8 = new com.google.android.gms.internal.ads.Wa     // Catch:{ IOException -> 0x0113 }
            r8.<init>(r0, r2)     // Catch:{ IOException -> 0x0113 }
            boolean r9 = r8.mo28675a(r6)     // Catch:{ IOException -> 0x0113 }
            if (r9 == 0) goto L_0x00fd
            byte[] r2 = r2.f26224a     // Catch:{ IOException -> 0x0113 }
            r6.write(r2)     // Catch:{ IOException -> 0x0113 }
            r6.close()     // Catch:{ IOException -> 0x0113 }
            long r9 = r3.length()     // Catch:{ IOException -> 0x0113 }
            r8.f21878a = r9     // Catch:{ IOException -> 0x0113 }
            r15.m25319a(r0, r8)     // Catch:{ IOException -> 0x0113 }
            long r8 = r1.f24475b     // Catch:{ IOException -> 0x0113 }
            int r0 = r1.f24477d     // Catch:{ IOException -> 0x0113 }
            long r10 = (long) r0     // Catch:{ IOException -> 0x0113 }
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x00fb
            boolean r0 = com.google.android.gms.internal.ads.zzag.f24300b     // Catch:{ IOException -> 0x0113 }
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = "Pruning old cache entries."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0113 }
            com.google.android.gms.internal.ads.zzag.m24969c(r0, r2)     // Catch:{ IOException -> 0x0113 }
        L_0x0067:
            long r8 = r1.f24475b     // Catch:{ IOException -> 0x0113 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0113 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.Wa> r0 = r1.f24474a     // Catch:{ IOException -> 0x0113 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0113 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0113 }
            r2 = 0
        L_0x0079:
            boolean r6 = r0.hasNext()     // Catch:{ IOException -> 0x0113 }
            r12 = 2
            if (r6 == 0) goto L_0x00d2
            java.lang.Object r6 = r0.next()     // Catch:{ IOException -> 0x0113 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x0113 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x0113 }
            com.google.android.gms.internal.ads.Wa r6 = (com.google.android.gms.internal.ads.C9205Wa) r6     // Catch:{ IOException -> 0x0113 }
            java.lang.String r13 = r6.f21879b     // Catch:{ IOException -> 0x0113 }
            java.io.File r13 = r15.m25326e(r13)     // Catch:{ IOException -> 0x0113 }
            boolean r13 = r13.delete()     // Catch:{ IOException -> 0x0113 }
            if (r13 == 0) goto L_0x00a2
            long r13 = r1.f24475b     // Catch:{ IOException -> 0x0113 }
            r16 = r8
            long r7 = r6.f21878a     // Catch:{ IOException -> 0x0113 }
            long r13 = r13 - r7
            r1.f24475b = r13     // Catch:{ IOException -> 0x0113 }
            goto L_0x00b7
        L_0x00a2:
            r16 = r8
            java.lang.String r7 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r8 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x0113 }
            java.lang.String r9 = r6.f21879b     // Catch:{ IOException -> 0x0113 }
            r8[r5] = r9     // Catch:{ IOException -> 0x0113 }
            java.lang.String r6 = r6.f21879b     // Catch:{ IOException -> 0x0113 }
            java.lang.String r6 = m25325d(r6)     // Catch:{ IOException -> 0x0113 }
            r8[r4] = r6     // Catch:{ IOException -> 0x0113 }
            com.google.android.gms.internal.ads.zzag.m24966a(r7, r8)     // Catch:{ IOException -> 0x0113 }
        L_0x00b7:
            r0.remove()     // Catch:{ IOException -> 0x0113 }
            int r2 = r2 + 1
            long r6 = r1.f24475b     // Catch:{ IOException -> 0x0113 }
            float r6 = (float) r6     // Catch:{ IOException -> 0x0113 }
            int r7 = r1.f24477d     // Catch:{ IOException -> 0x0113 }
            float r7 = (float) r7     // Catch:{ IOException -> 0x0113 }
            r8 = 1063675494(0x3f666666, float:0.9)
            float r7 = r7 * r8
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x00cc
            goto L_0x00d4
        L_0x00cc:
            r8 = r16
            r7 = 1063675494(0x3f666666, float:0.9)
            goto L_0x0079
        L_0x00d2:
            r16 = r8
        L_0x00d4:
            boolean r0 = com.google.android.gms.internal.ads.zzag.f24300b     // Catch:{ IOException -> 0x0113 }
            if (r0 == 0) goto L_0x00fb
            java.lang.String r0 = "pruned %d files, %d bytes, %d ms"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x0113 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0113 }
            r6[r5] = r2     // Catch:{ IOException -> 0x0113 }
            long r7 = r1.f24475b     // Catch:{ IOException -> 0x0113 }
            long r7 = r7 - r16
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ IOException -> 0x0113 }
            r6[r4] = r2     // Catch:{ IOException -> 0x0113 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0113 }
            long r7 = r7 - r10
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ IOException -> 0x0113 }
            r6[r12] = r2     // Catch:{ IOException -> 0x0113 }
            com.google.android.gms.internal.ads.zzag.m24969c(r0, r6)     // Catch:{ IOException -> 0x0113 }
        L_0x00fb:
            monitor-exit(r15)
            return
        L_0x00fd:
            r6.close()     // Catch:{ IOException -> 0x0113 }
            java.lang.String r0 = "Failed to write header for %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0113 }
            java.lang.String r6 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0113 }
            r2[r5] = r6     // Catch:{ IOException -> 0x0113 }
            com.google.android.gms.internal.ads.zzag.m24966a(r0, r2)     // Catch:{ IOException -> 0x0113 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0113 }
            r0.<init>()     // Catch:{ IOException -> 0x0113 }
            throw r0     // Catch:{ IOException -> 0x0113 }
        L_0x0113:
            r0 = move-exception
            boolean r0 = r3.delete()     // Catch:{ all -> 0x0129 }
            if (r0 != 0) goto L_0x0127
            java.lang.String r0 = "Could not clean up file %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0129 }
            r2[r5] = r3     // Catch:{ all -> 0x0129 }
            com.google.android.gms.internal.ads.zzag.m24966a(r0, r2)     // Catch:{ all -> 0x0129 }
        L_0x0127:
            monitor-exit(r15)
            return
        L_0x0129:
            r0 = move-exception
            monitor-exit(r15)
            goto L_0x012d
        L_0x012c:
            throw r0
        L_0x012d:
            goto L_0x012c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzan.mo29888a(java.lang.String, com.google.android.gms.internal.ads.zzc):void");
    }

    /* renamed from: a */
    private final synchronized void m25318a(String str) {
        boolean delete = m25326e(str).delete();
        m25323b(str);
        if (!delete) {
            zzag.m24966a("Could not delete cache entry for key=%s, filename=%s", str, m25325d(str));
        }
    }

    /* renamed from: d */
    private static String m25325d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: e */
    private final File m25326e(String str) {
        return new File(this.f24476c, m25325d(str));
    }

    /* renamed from: a */
    private final void m25319a(String str, C9205Wa wa) {
        if (!this.f24474a.containsKey(str)) {
            this.f24475b += wa.f21878a;
        } else {
            this.f24475b += wa.f21878a - ((C9205Wa) this.f24474a.get(str)).f21878a;
        }
        this.f24474a.put(str, wa);
    }

    /* renamed from: b */
    private final void m25323b(String str) {
        C9205Wa wa = (C9205Wa) this.f24474a.remove(str);
        if (wa != null) {
            this.f24475b -= wa.f21878a;
        }
    }

    /* renamed from: a */
    private static byte[] m25320a(C9268Za za, long j) throws IOException {
        long a = za.mo28807a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(za).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(a);
        throw new IOException(sb.toString());
    }

    /* renamed from: a */
    private static InputStream m25313a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /* renamed from: c */
    private static int m25324c(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    static void m25315a(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    /* renamed from: a */
    static int m25312a(InputStream inputStream) throws IOException {
        return (m25324c(inputStream) << 24) | m25324c(inputStream) | 0 | (m25324c(inputStream) << 8) | (m25324c(inputStream) << 16);
    }

    /* renamed from: a */
    static void m25316a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    /* renamed from: b */
    static long m25321b(InputStream inputStream) throws IOException {
        return (((long) m25324c(inputStream)) & 255) | 0 | ((((long) m25324c(inputStream)) & 255) << 8) | ((((long) m25324c(inputStream)) & 255) << 16) | ((((long) m25324c(inputStream)) & 255) << 24) | ((((long) m25324c(inputStream)) & 255) << 32) | ((((long) m25324c(inputStream)) & 255) << 40) | ((((long) m25324c(inputStream)) & 255) << 48) | ((255 & ((long) m25324c(inputStream))) << 56);
    }

    /* renamed from: a */
    static void m25317a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m25316a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    static String m25314a(C9268Za za) throws IOException {
        return new String(m25320a(za, m25321b((InputStream) za)), "UTF-8");
    }

    /* renamed from: b */
    static List<zzl> m25322b(C9268Za za) throws IOException {
        int a = m25312a((InputStream) za);
        if (a >= 0) {
            List<zzl> emptyList = a == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < a; i++) {
                emptyList.add(new zzl(m25314a(za).intern(), m25314a(za).intern()));
            }
            return emptyList;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("readHeaderList size=");
        sb.append(a);
        throw new IOException(sb.toString());
    }
}
