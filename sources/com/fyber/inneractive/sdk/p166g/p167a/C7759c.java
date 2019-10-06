package com.fyber.inneractive.sdk.p166g.p167a;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.fyber.inneractive.sdk.g.a.c */
final class C7759c implements Closeable {

    /* renamed from: a */
    static final Pattern f15565a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static final OutputStream f15566q = new OutputStream() {
        public final void write(int i) throws IOException {
        }
    };

    /* renamed from: b */
    final LinkedHashMap<String, C7764b> f15567b = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: c */
    C7765c f15568c;

    /* renamed from: d */
    final ThreadPoolExecutor f15569d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final File f15570e;

    /* renamed from: f */
    private final File f15571f;

    /* renamed from: g */
    private final File f15572g;

    /* renamed from: h */
    private final File f15573h;

    /* renamed from: i */
    private final int f15574i;

    /* renamed from: j */
    private long f15575j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final int f15576k;

    /* renamed from: l */
    private long f15577l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Writer f15578m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f15579n;

    /* renamed from: o */
    private long f15580o = 0;

    /* renamed from: p */
    private final Callable<Void> f15581p;

    /* renamed from: com.fyber.inneractive.sdk.g.a.c$a */
    public final class C7762a {

        /* renamed from: a */
        final C7764b f15583a;

        /* renamed from: b */
        final boolean[] f15584b;

        /* renamed from: c */
        boolean f15585c;

        /* renamed from: d */
        boolean f15586d;

        /* renamed from: com.fyber.inneractive.sdk.g.a.c$a$a */
        private class C7763a extends FilterOutputStream {
            /* synthetic */ C7763a(C7762a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            private C7763a(OutputStream outputStream) {
                super(outputStream);
            }

            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C7762a.this.f15585c = true;
                }
            }

            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C7762a.this.f15585c = true;
                }
            }

            public final void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C7762a.this.f15585c = true;
                }
            }

            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C7762a.this.f15585c = true;
                }
            }
        }

        /* synthetic */ C7762a(C7759c cVar, C7764b bVar, byte b) {
            this(bVar);
        }

        private C7762a(C7764b bVar) {
            this.f15583a = bVar;
            this.f15584b = bVar.f15591c ? null : new boolean[C7759c.this.f15576k];
        }

        /* renamed from: a */
        public final OutputStream mo24375a() throws IOException {
            FileOutputStream fileOutputStream;
            C7763a aVar;
            if (C7759c.this.f15576k > 0) {
                synchronized (C7759c.this) {
                    if (this.f15583a.f15592d == this) {
                        if (!this.f15583a.f15591c) {
                            this.f15584b[0] = true;
                        }
                        File b = this.f15583a.mo24384b(0);
                        try {
                            fileOutputStream = new FileOutputStream(b);
                        } catch (FileNotFoundException e) {
                            C7759c.this.f15570e.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(b);
                            } catch (FileNotFoundException e2) {
                                return C7759c.f15566q;
                            }
                        }
                        aVar = new C7763a(this, fileOutputStream, 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            StringBuilder sb = new StringBuilder("Expected index 0 to be greater than 0 and less than the maximum value count of ");
            sb.append(C7759c.this.f15576k);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: b */
        public final void mo24376b() throws IOException {
            C7759c.this.m17226a(this, false);
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a.c$b */
    private final class C7764b {

        /* renamed from: a */
        final String f15589a;

        /* renamed from: b */
        final long[] f15590b;

        /* renamed from: c */
        boolean f15591c;

        /* renamed from: d */
        C7762a f15592d;

        /* renamed from: e */
        long f15593e;

        /* synthetic */ C7764b(C7759c cVar, String str, byte b) {
            this(str);
        }

        private C7764b(String str) {
            this.f15589a = str;
            this.f15590b = new long[C7759c.this.f15576k];
        }

        /* renamed from: a */
        public final String mo24382a() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f15590b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo24383a(String[] strArr) throws IOException {
            if (strArr.length == C7759c.this.f15576k) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f15590b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException e) {
                        m17254b(strArr);
                        throw null;
                    }
                }
                return;
            }
            m17254b(strArr);
            throw null;
        }

        /* renamed from: b */
        private static IOException m17254b(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        /* renamed from: a */
        public final File mo24381a(int i) {
            File g = C7759c.this.f15570e;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15589a);
            sb.append(".");
            sb.append(i);
            return new File(g, sb.toString());
        }

        /* renamed from: b */
        public final File mo24384b(int i) {
            File g = C7759c.this.f15570e;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15589a);
            sb.append(".");
            sb.append(i);
            sb.append(".tmp");
            return new File(g, sb.toString());
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a.c$c */
    public interface C7765c {
        /* renamed from: a */
        boolean mo24385a(String str);
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a.c$d */
    public final class C7766d implements Closeable {

        /* renamed from: b */
        private final String f15596b;

        /* renamed from: c */
        private final long f15597c;

        /* renamed from: d */
        private final InputStream[] f15598d;

        /* renamed from: e */
        private final long[] f15599e;

        /* synthetic */ C7766d(C7759c cVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        private C7766d(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f15596b = str;
            this.f15597c = j;
            this.f15598d = inputStreamArr;
            this.f15599e = jArr;
        }

        public final void close() {
            for (InputStream a : this.f15598d) {
                C7789k.m17288a((Closeable) a);
            }
        }
    }

    private C7759c(File file) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f15569d = threadPoolExecutor;
        this.f15581p = new Callable<Void>() {
            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
                return null;
             */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Void call() throws java.lang.Exception {
                /*
                    r3 = this;
                    com.fyber.inneractive.sdk.g.a.c r0 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this
                    monitor-enter(r0)
                    com.fyber.inneractive.sdk.g.a.c r1 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x0027 }
                    java.io.Writer r1 = r1.f15578m     // Catch:{ all -> 0x0027 }
                    r2 = 0
                    if (r1 != 0) goto L_0x000e
                    monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                    return r2
                L_0x000e:
                    com.fyber.inneractive.sdk.g.a.c r1 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x0027 }
                    r1.m17242j()     // Catch:{ all -> 0x0027 }
                    com.fyber.inneractive.sdk.g.a.c r1 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x0027 }
                    boolean r1 = r1.m17241i()     // Catch:{ all -> 0x0027 }
                    if (r1 == 0) goto L_0x0025
                    com.fyber.inneractive.sdk.g.a.c r1 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x0027 }
                    r1.m17240h()     // Catch:{ all -> 0x0027 }
                    com.fyber.inneractive.sdk.g.a.c r1 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x0027 }
                    r1.f15579n = 0     // Catch:{ all -> 0x0027 }
                L_0x0025:
                    monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                    return r2
                L_0x0027:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7759c.C77601.call():java.lang.Void");
            }
        };
        this.f15570e = file;
        this.f15574i = 0;
        this.f15571f = new File(file, "journal");
        this.f15572g = new File(file, "journal.tmp");
        this.f15573h = new File(file, "journal.bkp");
        this.f15576k = 1;
        this.f15575j = 31457280;
    }

    /* renamed from: a */
    public static C7759c m17224a(File file) throws IOException {
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m17228a(file2, file3, false);
            }
        }
        C7759c cVar = new C7759c(file);
        if (cVar.f15571f.exists()) {
            try {
                cVar.m17237f();
                cVar.m17239g();
                return cVar;
            } catch (IOException e) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder("DiskLruCache ");
                sb.append(file);
                sb.append(" is corrupt: ");
                sb.append(e.getMessage());
                sb.append(", removing");
                printStream.println(sb.toString());
                cVar.mo24371d();
            }
        }
        file.mkdirs();
        C7759c cVar2 = new C7759c(file);
        cVar2.m17240h();
        return cVar2;
    }

    /* renamed from: f */
    private void m17237f() throws IOException {
        boolean z;
        int i;
        String a;
        String str;
        String str2;
        String str3 = ", ";
        C7787j jVar = new C7787j(new FileInputStream(this.f15571f), C7789k.f15667a);
        try {
            String a2 = jVar.mo24409a();
            String a3 = jVar.mo24409a();
            String a4 = jVar.mo24409a();
            String a5 = jVar.mo24409a();
            String a6 = jVar.mo24409a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f15574i).equals(a4) || !Integer.toString(this.f15576k).equals(a5) || !"".equals(a6)) {
                StringBuilder sb = new StringBuilder("unexpected journal header: [");
                sb.append(a2);
                sb.append(str3);
                sb.append(a3);
                sb.append(str3);
                sb.append(a5);
                sb.append(str3);
                sb.append(a6);
                sb.append("]");
                throw new IOException(sb.toString());
            }
            z = false;
            i = 0;
            while (true) {
                a = jVar.mo24409a();
                int indexOf = a.indexOf(32);
                str = "unexpected journal line: ";
                if (indexOf != -1) {
                    int i2 = indexOf + 1;
                    int indexOf2 = a.indexOf(32, i2);
                    if (indexOf2 == -1) {
                        str2 = a.substring(i2);
                        if (indexOf == 6 && a.startsWith("REMOVE")) {
                            this.f15567b.remove(str2);
                            i++;
                        }
                    } else {
                        str2 = a.substring(i2, indexOf2);
                    }
                    C7764b bVar = (C7764b) this.f15567b.get(str2);
                    if (bVar == null) {
                        bVar = new C7764b(this, str2, 0);
                        this.f15567b.put(str2, bVar);
                    }
                    if (indexOf2 != -1 && indexOf == 5 && a.startsWith("CLEAN")) {
                        String[] split = a.substring(indexOf2 + 1).split(" ");
                        bVar.f15591c = true;
                        bVar.f15592d = null;
                        bVar.mo24383a(split);
                        i++;
                    } else if (indexOf2 == -1 && indexOf == 5 && a.startsWith("DIRTY")) {
                        bVar.f15592d = new C7762a(this, bVar, 0);
                        i++;
                    } else if (indexOf2 == -1 && indexOf == 4 && a.startsWith("READ")) {
                        i++;
                    } else {
                        StringBuilder sb2 = new StringBuilder(str);
                        sb2.append(a);
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder(str);
                    sb3.append(a);
                    throw new IOException(sb3.toString());
                }
            }
            StringBuilder sb22 = new StringBuilder(str);
            sb22.append(a);
            throw new IOException(sb22.toString());
        } catch (EOFException e) {
            this.f15579n = i - this.f15567b.size();
            if (jVar.f15662b == -1) {
                z = true;
            }
            if (z) {
                m17240h();
            } else {
                this.f15578m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f15571f, true), C7789k.f15667a));
            }
            C7789k.m17288a((Closeable) jVar);
        } catch (Throwable th) {
            C7789k.m17288a((Closeable) jVar);
            throw th;
        }
    }

    /* renamed from: g */
    private void m17239g() throws IOException {
        m17230b(this.f15572g);
        Iterator it = this.f15567b.values().iterator();
        while (it.hasNext()) {
            C7764b bVar = (C7764b) it.next();
            int i = 0;
            if (bVar.f15592d == null) {
                while (i < this.f15576k) {
                    this.f15577l += bVar.f15590b[i];
                    i++;
                }
            } else {
                bVar.f15592d = null;
                while (i < this.f15576k) {
                    m17230b(bVar.mo24381a(i));
                    m17230b(bVar.mo24384b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: h */
    public synchronized void m17240h() throws IOException {
        if (this.f15578m != null) {
            this.f15578m.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f15572g), C7789k.f15667a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f15574i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f15576k));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C7764b bVar : this.f15567b.values()) {
                if (bVar.f15592d != null) {
                    StringBuilder sb = new StringBuilder("DIRTY ");
                    sb.append(bVar.f15589a);
                    sb.append(10);
                    bufferedWriter.write(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder("CLEAN ");
                    sb2.append(bVar.f15589a);
                    sb2.append(bVar.mo24382a());
                    sb2.append(10);
                    bufferedWriter.write(sb2.toString());
                }
            }
            bufferedWriter.close();
            if (this.f15571f.exists()) {
                m17228a(this.f15571f, this.f15573h, true);
            }
            m17228a(this.f15572g, this.f15571f, false);
            this.f15573h.delete();
            this.f15578m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f15571f, true), C7789k.f15667a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: b */
    private static void m17230b(File file) throws IOException {
        StringBuilder sb = new StringBuilder("DiskLruCache deleteIfExists - ");
        sb.append(file);
        IAlog.m18019a(sb.toString());
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m17228a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m17230b(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public final synchronized C7766d mo24365a(String str) throws IOException {
        mo24367b();
        m17235e(str);
        C7764b bVar = (C7764b) this.f15567b.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f15591c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f15576k];
        int i = 0;
        int i2 = 0;
        while (i2 < this.f15576k) {
            try {
                inputStreamArr[i2] = new FileInputStream(bVar.mo24381a(i2));
                i2++;
            } catch (FileNotFoundException e) {
                while (i < this.f15576k && inputStreamArr[i] != null) {
                    C7789k.m17288a((Closeable) inputStreamArr[i]);
                    i++;
                }
                return null;
            }
        }
        this.f15579n++;
        Writer writer = this.f15578m;
        StringBuilder sb = new StringBuilder("READ ");
        sb.append(str);
        sb.append(10);
        writer.append(sb.toString());
        if (m17241i()) {
            this.f15569d.submit(this.f15581p);
        }
        C7766d dVar = new C7766d(this, str, bVar.f15593e, inputStreamArr, bVar.f15590b, 0);
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final File mo24366b(String str) {
        mo24367b();
        m17235e(str);
        C7764b bVar = (C7764b) this.f15567b.get(str);
        if (bVar == null) {
            return null;
        }
        return bVar.mo24381a(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final synchronized C7762a mo24368c(String str) throws IOException {
        mo24367b();
        m17235e(str);
        C7764b bVar = (C7764b) this.f15567b.get(str);
        if (bVar == null) {
            bVar = new C7764b(this, str, 0);
            this.f15567b.put(str, bVar);
        } else if (bVar.f15592d != null) {
            return null;
        }
        C7762a aVar = new C7762a(this, bVar, 0);
        bVar.f15592d = aVar;
        Writer writer = this.f15578m;
        StringBuilder sb = new StringBuilder("DIRTY ");
        sb.append(str);
        sb.append(10);
        writer.write(sb.toString());
        this.f15578m.flush();
        return aVar;
    }

    /* renamed from: a */
    public final synchronized long mo24364a() {
        return this.f15577l;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f3, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m17226a(com.fyber.inneractive.sdk.p166g.p167a.C7759c.C7762a r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.fyber.inneractive.sdk.g.a.c$b r0 = r10.f15583a     // Catch:{ all -> 0x00fa }
            com.fyber.inneractive.sdk.g.a.c$a r1 = r0.f15592d     // Catch:{ all -> 0x00fa }
            if (r1 != r10) goto L_0x00f4
            r1 = 0
            if (r11 == 0) goto L_0x0046
            boolean r2 = r0.f15591c     // Catch:{ all -> 0x00fa }
            if (r2 != 0) goto L_0x0046
            r2 = 0
        L_0x0012:
            int r3 = r9.f15576k     // Catch:{ all -> 0x00fa }
            if (r2 >= r3) goto L_0x0046
            boolean[] r3 = r10.f15584b     // Catch:{ all -> 0x00fa }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fa }
            if (r3 == 0) goto L_0x002f
            java.io.File r3 = r0.mo24384b(r2)     // Catch:{ all -> 0x00fa }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x00fa }
            if (r3 != 0) goto L_0x002c
            r10.mo24376b()     // Catch:{ all -> 0x00fa }
            monitor-exit(r9)
            return
        L_0x002c:
            int r2 = r2 + 1
            goto L_0x0012
        L_0x002f:
            r10.mo24376b()     // Catch:{ all -> 0x00fa }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.<init>(r0)     // Catch:{ all -> 0x00fa }
            r11.append(r2)     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fa }
            r10.<init>(r11)     // Catch:{ all -> 0x00fa }
            throw r10     // Catch:{ all -> 0x00fa }
        L_0x0046:
        L_0x0047:
            int r10 = r9.f15576k     // Catch:{ all -> 0x00fa }
            if (r1 >= r10) goto L_0x0079
            java.io.File r10 = r0.mo24384b(r1)     // Catch:{ all -> 0x00fa }
            if (r11 == 0) goto L_0x0073
            boolean r2 = r10.exists()     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x0076
            java.io.File r2 = r0.mo24381a(r1)     // Catch:{ all -> 0x00fa }
            r10.renameTo(r2)     // Catch:{ all -> 0x00fa }
            long[] r10 = r0.f15590b     // Catch:{ all -> 0x00fa }
            r3 = r10[r1]     // Catch:{ all -> 0x00fa }
            long r5 = r2.length()     // Catch:{ all -> 0x00fa }
            long[] r10 = r0.f15590b     // Catch:{ all -> 0x00fa }
            r10[r1] = r5     // Catch:{ all -> 0x00fa }
            long r7 = r9.f15577l     // Catch:{ all -> 0x00fa }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f15577l = r7     // Catch:{ all -> 0x00fa }
            goto L_0x0076
        L_0x0073:
            m17230b(r10)     // Catch:{ all -> 0x00fa }
        L_0x0076:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x0079:
            int r10 = r9.f15579n     // Catch:{ all -> 0x00fa }
            r1 = 1
            int r10 = r10 + r1
            r9.f15579n = r10     // Catch:{ all -> 0x00fa }
            r10 = 0
            r0.f15592d = r10     // Catch:{ all -> 0x00fa }
            boolean r10 = r0.f15591c     // Catch:{ all -> 0x00fa }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00b9
            r0.f15591c = r1     // Catch:{ all -> 0x00fa }
            java.io.Writer r10 = r9.f15578m     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            java.lang.String r3 = "CLEAN "
            r1.<init>(r3)     // Catch:{ all -> 0x00fa }
            java.lang.String r3 = r0.f15589a     // Catch:{ all -> 0x00fa }
            r1.append(r3)     // Catch:{ all -> 0x00fa }
            java.lang.String r3 = r0.mo24382a()     // Catch:{ all -> 0x00fa }
            r1.append(r3)     // Catch:{ all -> 0x00fa }
            r1.append(r2)     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fa }
            r10.write(r1)     // Catch:{ all -> 0x00fa }
            if (r11 == 0) goto L_0x00d8
            long r10 = r9.f15580o     // Catch:{ all -> 0x00fa }
            r1 = 1
            long r1 = r1 + r10
            r9.f15580o = r1     // Catch:{ all -> 0x00fa }
            r0.f15593e = r10     // Catch:{ all -> 0x00fa }
            goto L_0x00d8
        L_0x00b9:
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.g.a.c$b> r10 = r9.f15567b     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = r0.f15589a     // Catch:{ all -> 0x00fa }
            r10.remove(r11)     // Catch:{ all -> 0x00fa }
            java.io.Writer r10 = r9.f15578m     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "REMOVE "
            r11.<init>(r1)     // Catch:{ all -> 0x00fa }
            java.lang.String r0 = r0.f15589a     // Catch:{ all -> 0x00fa }
            r11.append(r0)     // Catch:{ all -> 0x00fa }
            r11.append(r2)     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fa }
            r10.write(r11)     // Catch:{ all -> 0x00fa }
        L_0x00d8:
            java.io.Writer r10 = r9.f15578m     // Catch:{ all -> 0x00fa }
            r10.flush()     // Catch:{ all -> 0x00fa }
            long r10 = r9.f15577l     // Catch:{ all -> 0x00fa }
            long r0 = r9.f15575j     // Catch:{ all -> 0x00fa }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00eb
            boolean r10 = r9.m17241i()     // Catch:{ all -> 0x00fa }
            if (r10 == 0) goto L_0x00f2
        L_0x00eb:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f15569d     // Catch:{ all -> 0x00fa }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f15581p     // Catch:{ all -> 0x00fa }
            r10.submit(r11)     // Catch:{ all -> 0x00fa }
        L_0x00f2:
            monitor-exit(r9)
            return
        L_0x00f4:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fa }
            r10.<init>()     // Catch:{ all -> 0x00fa }
            throw r10     // Catch:{ all -> 0x00fa }
        L_0x00fa:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00fe
        L_0x00fd:
            throw r10
        L_0x00fe:
            goto L_0x00fd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7759c.m17226a(com.fyber.inneractive.sdk.g.a.c$a, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m17241i() {
        int i = this.f15579n;
        return i >= 2000 && i >= this.f15567b.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0098, code lost:
        return false;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo24372d(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            java.lang.String r1 = "DiskLruCache remove "
            r0.<init>(r1)     // Catch:{ all -> 0x0099 }
            r0.append(r8)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0099 }
            com.fyber.inneractive.sdk.util.IAlog.m18019a(r0)     // Catch:{ all -> 0x0099 }
            r7.mo24367b()     // Catch:{ all -> 0x0099 }
            m17235e(r8)     // Catch:{ all -> 0x0099 }
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.g.a.c$b> r0 = r7.f15567b     // Catch:{ all -> 0x0099 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0099 }
            com.fyber.inneractive.sdk.g.a.c$b r0 = (com.fyber.inneractive.sdk.p166g.p167a.C7759c.C7764b) r0     // Catch:{ all -> 0x0099 }
            r1 = 0
            if (r0 == 0) goto L_0x0097
            com.fyber.inneractive.sdk.g.a.c$a r2 = r0.f15592d     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0028
            goto L_0x0097
        L_0x0028:
        L_0x0029:
            int r2 = r7.f15576k     // Catch:{ all -> 0x0099 }
            if (r1 >= r2) goto L_0x0065
            java.io.File r2 = r0.mo24381a(r1)     // Catch:{ all -> 0x0099 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0099 }
            if (r3 == 0) goto L_0x0052
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0099 }
            if (r3 == 0) goto L_0x003e
            goto L_0x0052
        L_0x003e:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            java.lang.String r1 = "failed to delete "
            r0.<init>(r1)     // Catch:{ all -> 0x0099 }
            r0.append(r2)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0099 }
            r8.<init>(r0)     // Catch:{ all -> 0x0099 }
            throw r8     // Catch:{ all -> 0x0099 }
        L_0x0052:
            long r2 = r7.f15577l     // Catch:{ all -> 0x0099 }
            long[] r4 = r0.f15590b     // Catch:{ all -> 0x0099 }
            r5 = r4[r1]     // Catch:{ all -> 0x0099 }
            long r2 = r2 - r5
            r7.f15577l = r2     // Catch:{ all -> 0x0099 }
            long[] r2 = r0.f15590b     // Catch:{ all -> 0x0099 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0099 }
            int r1 = r1 + 1
            goto L_0x0029
        L_0x0065:
            int r0 = r7.f15579n     // Catch:{ all -> 0x0099 }
            r1 = 1
            int r0 = r0 + r1
            r7.f15579n = r0     // Catch:{ all -> 0x0099 }
            java.io.Writer r0 = r7.f15578m     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = "REMOVE "
            r2.<init>(r3)     // Catch:{ all -> 0x0099 }
            r2.append(r8)     // Catch:{ all -> 0x0099 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0099 }
            r0.append(r2)     // Catch:{ all -> 0x0099 }
            java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.g.a.c$b> r0 = r7.f15567b     // Catch:{ all -> 0x0099 }
            r0.remove(r8)     // Catch:{ all -> 0x0099 }
            boolean r8 = r7.m17241i()     // Catch:{ all -> 0x0099 }
            if (r8 == 0) goto L_0x0095
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f15569d     // Catch:{ all -> 0x0099 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f15581p     // Catch:{ all -> 0x0099 }
            r8.submit(r0)     // Catch:{ all -> 0x0099 }
        L_0x0095:
            monitor-exit(r7)
            return r1
        L_0x0097:
            monitor-exit(r7)
            return r1
        L_0x0099:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7759c.mo24372d(java.lang.String):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo24367b() {
        if (this.f15578m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: c */
    public final synchronized void mo24369c() throws IOException {
        mo24367b();
        m17242j();
        this.f15578m.flush();
    }

    public final synchronized void close() throws IOException {
        if (this.f15578m != null) {
            Iterator it = new ArrayList(this.f15567b.values()).iterator();
            while (it.hasNext()) {
                C7764b bVar = (C7764b) it.next();
                if (bVar.f15592d != null) {
                    bVar.f15592d.mo24376b();
                }
            }
            m17242j();
            this.f15578m.close();
            this.f15578m = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m17242j() throws IOException {
        while (this.f15577l > this.f15575j) {
            String str = (String) ((Entry) this.f15567b.entrySet().iterator().next()).getKey();
            C7765c cVar = this.f15568c;
            if (cVar == null) {
                mo24372d(str);
            } else if (cVar.mo24385a(str)) {
                mo24372d(str);
            } else {
                boolean z = false;
                for (String str2 : this.f15567b.keySet()) {
                    if (this.f15568c.mo24385a(str2)) {
                        z |= mo24372d(str2);
                    }
                }
                if (!z) {
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public final void mo24371d() throws IOException {
        IAlog.m18019a("DiskLruCache delete cache");
        close();
        C7789k.m17289a(this.f15570e);
    }

    /* renamed from: e */
    static void m17235e(String str) {
        if (!f15565a.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"");
            sb.append(str);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
