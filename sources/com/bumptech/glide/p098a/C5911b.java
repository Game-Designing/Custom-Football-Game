package com.bumptech.glide.p098a;

import com.bumptech.glide.disklrucache.DiskLruCache.Entry;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bumptech.glide.a.b */
/* compiled from: DiskLruCache */
public final class C5911b implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final File f10342a;

    /* renamed from: b */
    private final File f10343b;

    /* renamed from: c */
    private final File f10344c;

    /* renamed from: d */
    private final File f10345d;

    /* renamed from: e */
    private final int f10346e;

    /* renamed from: f */
    private long f10347f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f10348g;

    /* renamed from: h */
    private long f10349h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Writer f10350i;

    /* renamed from: j */
    private final LinkedHashMap<String, C5914c> f10351j = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f10352k;

    /* renamed from: l */
    private long f10353l = 0;

    /* renamed from: m */
    final ThreadPoolExecutor f10354m;

    /* renamed from: n */
    private final Callable<Void> f10355n;

    /* renamed from: com.bumptech.glide.a.b$a */
    /* compiled from: DiskLruCache */
    private static final class C5912a implements ThreadFactory {
        private C5912a() {
        }

        /* synthetic */ C5912a(C5910a x0) {
            this();
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread result;
            result = new Thread(runnable, "glide-disk-lru-cache-thread");
            result.setPriority(1);
            return result;
        }
    }

    /* renamed from: com.bumptech.glide.a.b$b */
    /* compiled from: DiskLruCache */
    public final class C5913b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C5914c f10356a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final boolean[] f10357b;

        /* renamed from: c */
        private boolean f10358c;

        /* synthetic */ C5913b(C5911b x0, C5914c x1, C5910a x2) {
            this(x1);
        }

        private C5913b(C5914c entry) {
            this.f10356a = entry;
            this.f10357b = entry.f10364e ? null : new boolean[C5911b.this.f10348g];
        }

        /* renamed from: a */
        public File mo18538a(int index) throws IOException {
            File dirtyFile;
            synchronized (C5911b.this) {
                if (this.f10356a.f10365f == this) {
                    if (!this.f10356a.f10364e) {
                        this.f10357b[index] = true;
                    }
                    dirtyFile = this.f10356a.mo18544b(index);
                    if (!C5911b.this.f10342a.exists()) {
                        C5911b.this.f10342a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return dirtyFile;
        }

        /* renamed from: c */
        public void mo18541c() throws IOException {
            C5911b.this.m10817a(this, true);
            this.f10358c = true;
        }

        /* renamed from: a */
        public void mo18539a() throws IOException {
            C5911b.this.m10817a(this, false);
        }

        /* renamed from: b */
        public void mo18540b() {
            if (!this.f10358c) {
                try {
                    mo18539a();
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.bumptech.glide.a.b$c */
    /* compiled from: DiskLruCache */
    private final class C5914c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f10360a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long[] f10361b;

        /* renamed from: c */
        File[] f10362c;

        /* renamed from: d */
        File[] f10363d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f10364e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public C5913b f10365f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public long f10366g;

        /* synthetic */ C5914c(C5911b x0, String x1, C5910a x2) {
            this(x1);
        }

        private C5914c(String key) {
            this.f10360a = key;
            this.f10361b = new long[C5911b.this.f10348g];
            this.f10362c = new File[C5911b.this.f10348g];
            this.f10363d = new File[C5911b.this.f10348g];
            StringBuilder fileBuilder = new StringBuilder(key).append('.');
            int truncateTo = fileBuilder.length();
            for (int i = 0; i < C5911b.this.f10348g; i++) {
                fileBuilder.append(i);
                this.f10362c[i] = new File(C5911b.this.f10342a, fileBuilder.toString());
                fileBuilder.append(".tmp");
                this.f10363d[i] = new File(C5911b.this.f10342a, fileBuilder.toString());
                fileBuilder.setLength(truncateTo);
            }
        }

        /* renamed from: a */
        public String mo18543a() throws IOException {
            long[] jArr;
            StringBuilder result = new StringBuilder();
            for (long size : this.f10361b) {
                result.append(' ');
                result.append(size);
            }
            return result.toString();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m10850b(String[] strings) throws IOException {
            if (strings.length == C5911b.this.f10348g) {
                int i = 0;
                while (i < strings.length) {
                    try {
                        this.f10361b[i] = Long.parseLong(strings[i]);
                        i++;
                    } catch (NumberFormatException e) {
                        m10845a(strings);
                        throw null;
                    }
                }
                return;
            }
            m10845a(strings);
            throw null;
        }

        /* renamed from: a */
        private IOException m10845a(String[] strings) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strings));
            throw new IOException(sb.toString());
        }

        /* renamed from: a */
        public File mo18542a(int i) {
            return this.f10362c[i];
        }

        /* renamed from: b */
        public File mo18544b(int i) {
            return this.f10363d[i];
        }
    }

    /* renamed from: com.bumptech.glide.a.b$d */
    /* compiled from: DiskLruCache */
    public final class C5915d {

        /* renamed from: a */
        private final String f10368a;

        /* renamed from: b */
        private final long f10369b;

        /* renamed from: c */
        private final long[] f10370c;

        /* renamed from: d */
        private final File[] f10371d;

        /* synthetic */ C5915d(C5911b x0, String x1, long x2, File[] x3, long[] x4, C5910a x5) {
            this(x1, x2, x3, x4);
        }

        private C5915d(String key, long sequenceNumber, File[] files, long[] lengths) {
            this.f10368a = key;
            this.f10369b = sequenceNumber;
            this.f10371d = files;
            this.f10370c = lengths;
        }

        /* renamed from: a */
        public File mo18545a(int index) {
            return this.f10371d[index];
        }
    }

    private C5911b(File directory, int appVersion, int valueCount, long maxSize) {
        File file = directory;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C5912a(null));
        this.f10354m = threadPoolExecutor;
        this.f10355n = new C5910a(this);
        this.f10342a = file;
        this.f10346e = appVersion;
        this.f10343b = new File(file, "journal");
        this.f10344c = new File(file, "journal.tmp");
        this.f10345d = new File(file, "journal.bkp");
        this.f10348g = valueCount;
        this.f10347f = maxSize;
    }

    /* renamed from: a */
    public static C5911b m10815a(File directory, int appVersion, int valueCount, long maxSize) throws IOException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (valueCount > 0) {
            File backupFile = new File(directory, "journal.bkp");
            if (backupFile.exists()) {
                File journalFile = new File(directory, "journal");
                if (journalFile.exists()) {
                    backupFile.delete();
                } else {
                    m10820a(backupFile, journalFile, false);
                }
            }
            C5911b bVar = new C5911b(directory, appVersion, valueCount, maxSize);
            if (bVar.f10343b.exists()) {
                try {
                    bVar.m10828e();
                    bVar.m10826d();
                    return bVar;
                } catch (IOException journalIsCorrupt) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(directory);
                    sb.append(" is corrupt: ");
                    sb.append(journalIsCorrupt.getMessage());
                    sb.append(", removing");
                    printStream.println(sb.toString());
                    bVar.mo18533a();
                }
            }
            directory.mkdirs();
            C5911b bVar2 = new C5911b(directory, appVersion, valueCount, maxSize);
            C5911b cache = bVar2;
            cache.m10830f();
            return cache;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* renamed from: e */
    private void m10828e() throws IOException {
        int lineCount;
        String str = ", ";
        C5917d reader = new C5917d(new FileInputStream(this.f10343b), C5918e.f10379a);
        try {
            String magic = reader.mo18548b();
            String version = reader.mo18548b();
            String appVersionString = reader.mo18548b();
            String valueCountString = reader.mo18548b();
            String blank = reader.mo18548b();
            if (!"libcore.io.DiskLruCache".equals(magic) || !"1".equals(version) || !Integer.toString(this.f10346e).equals(appVersionString) || !Integer.toString(this.f10348g).equals(valueCountString) || !"".equals(blank)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(magic);
                sb.append(str);
                sb.append(version);
                sb.append(str);
                sb.append(valueCountString);
                sb.append(str);
                sb.append(blank);
                sb.append("]");
                throw new IOException(sb.toString());
            }
            lineCount = 0;
            while (true) {
                m10827d(reader.mo18548b());
                lineCount++;
            }
        } catch (EOFException e) {
            this.f10352k = lineCount - this.f10351j.size();
            if (reader.mo18547a()) {
                m10830f();
            } else {
                this.f10350i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10343b, true), C5918e.f10379a));
            }
            C5918e.m10862a((Closeable) reader);
        } catch (Throwable th) {
            C5918e.m10862a((Closeable) reader);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
        if (r11.startsWith(r3) != false) goto L_0x0095;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10827d(java.lang.String r11) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 32
            int r1 = r11.indexOf(r0)
            java.lang.String r2 = "unexpected journal line: "
            r3 = -1
            if (r1 == r3) goto L_0x00ab
            int r4 = r1 + 1
            int r0 = r11.indexOf(r0, r4)
            if (r0 != r3) goto L_0x002b
            java.lang.String r5 = r11.substring(r4)
            java.lang.String r6 = "REMOVE"
            int r7 = r6.length()
            if (r1 != r7) goto L_0x002f
            boolean r6 = r11.startsWith(r6)
            if (r6 == 0) goto L_0x002f
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r2 = r10.f10351j
            r2.remove(r5)
            return
        L_0x002b:
            java.lang.String r5 = r11.substring(r4, r0)
        L_0x002f:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r6 = r10.f10351j
            java.lang.Object r6 = r6.get(r5)
            com.bumptech.glide.a.b$c r6 = (com.bumptech.glide.p098a.C5911b.C5914c) r6
            r7 = 0
            if (r6 != 0) goto L_0x0045
            com.bumptech.glide.a.b$c r8 = new com.bumptech.glide.a.b$c
            r8.<init>(r10, r5, r7)
            r6 = r8
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r8 = r10.f10351j
            r8.put(r5, r6)
        L_0x0045:
            if (r0 == r3) goto L_0x006c
            java.lang.String r8 = "CLEAN"
            int r9 = r8.length()
            if (r1 != r9) goto L_0x006c
            boolean r8 = r11.startsWith(r8)
            if (r8 == 0) goto L_0x006c
            int r2 = r0 + 1
            java.lang.String r2 = r11.substring(r2)
            java.lang.String r3 = " "
            java.lang.String[] r2 = r2.split(r3)
            r3 = 1
            r6.f10364e = r3
            r6.f10365f = r7
            r6.m10850b(r2)
            goto L_0x0095
        L_0x006c:
            if (r0 != r3) goto L_0x0085
            java.lang.String r8 = "DIRTY"
            int r9 = r8.length()
            if (r1 != r9) goto L_0x0085
            boolean r8 = r11.startsWith(r8)
            if (r8 == 0) goto L_0x0085
            com.bumptech.glide.a.b$b r2 = new com.bumptech.glide.a.b$b
            r2.<init>(r10, r6, r7)
            r6.f10365f = r2
            goto L_0x0095
        L_0x0085:
            if (r0 != r3) goto L_0x0096
            java.lang.String r3 = "READ"
            int r7 = r3.length()
            if (r1 != r7) goto L_0x0096
            boolean r3 = r11.startsWith(r3)
            if (r3 == 0) goto L_0x0096
        L_0x0095:
            return
        L_0x0096:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r2)
            r7.append(r11)
            java.lang.String r2 = r7.toString()
            r3.<init>(r2)
            throw r3
        L_0x00ab:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r11)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p098a.C5911b.m10827d(java.lang.String):void");
    }

    /* renamed from: d */
    private void m10826d() throws IOException {
        m10819a(this.f10344c);
        Iterator<Entry> i = this.f10351j.values().iterator();
        while (i.hasNext()) {
            C5914c entry = (C5914c) i.next();
            if (entry.f10365f == null) {
                for (int t = 0; t < this.f10348g; t++) {
                    this.f10349h += entry.f10361b[t];
                }
            } else {
                entry.f10365f = null;
                for (int t2 = 0; t2 < this.f10348g; t2++) {
                    m10819a(entry.mo18542a(t2));
                    m10819a(entry.mo18544b(t2));
                }
                i.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m10830f() throws IOException {
        if (this.f10350i != null) {
            this.f10350i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10344c), C5918e.f10379a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f10346e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f10348g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C5914c entry : this.f10351j.values()) {
                if (entry.f10365f != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(entry.f10360a);
                    sb.append(10);
                    bufferedWriter.write(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(entry.f10360a);
                    sb2.append(entry.mo18543a());
                    sb2.append(10);
                    bufferedWriter.write(sb2.toString());
                }
            }
            bufferedWriter.close();
            if (this.f10343b.exists()) {
                m10820a(this.f10343b, this.f10345d, true);
            }
            m10820a(this.f10344c, this.f10343b, false);
            this.f10345d.delete();
            this.f10350i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10343b, true), C5918e.f10379a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m10819a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m10820a(File from, File to, boolean deleteDestination) throws IOException {
        if (deleteDestination) {
            m10819a(to);
        }
        if (!from.renameTo(to)) {
            throw new IOException();
        }
    }

    /* renamed from: b */
    public synchronized C5915d mo18534b(String key) throws IOException {
        m10822b();
        C5914c entry = (C5914c) this.f10351j.get(key);
        if (entry == null) {
            return null;
        }
        if (!entry.f10364e) {
            return null;
        }
        for (File file : entry.f10362c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f10352k++;
        this.f10350i.append("READ");
        this.f10350i.append(' ');
        this.f10350i.append(key);
        this.f10350i.append(10);
        if (m10824c()) {
            this.f10354m.submit(this.f10355n);
        }
        C5915d dVar = new C5915d(this, key, entry.f10366g, entry.f10362c, entry.f10361b, null);
        return dVar;
    }

    /* renamed from: a */
    public C5913b mo18532a(String key) throws IOException {
        return m10814a(key, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.bumptech.glide.p098a.C5911b.C5913b m10814a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m10822b()     // Catch:{ all -> 0x005e }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r0 = r5.f10351j     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005e }
            com.bumptech.glide.a.b$c r0 = (com.bumptech.glide.p098a.C5911b.C5914c) r0     // Catch:{ all -> 0x005e }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r1 = r0.f10366g     // Catch:{ all -> 0x005e }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r3
        L_0x001f:
            if (r0 != 0) goto L_0x002d
            com.bumptech.glide.a.b$c r1 = new com.bumptech.glide.a.b$c     // Catch:{ all -> 0x005e }
            r1.<init>(r5, r6, r3)     // Catch:{ all -> 0x005e }
            r0 = r1
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r1 = r5.f10351j     // Catch:{ all -> 0x005e }
            r1.put(r6, r0)     // Catch:{ all -> 0x005e }
            goto L_0x0035
        L_0x002d:
            com.bumptech.glide.a.b$b r1 = r0.f10365f     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0035
            monitor-exit(r5)
            return r3
        L_0x0035:
            com.bumptech.glide.a.b$b r1 = new com.bumptech.glide.a.b$b     // Catch:{ all -> 0x005e }
            r1.<init>(r5, r0, r3)     // Catch:{ all -> 0x005e }
            r0.f10365f = r1     // Catch:{ all -> 0x005e }
            java.io.Writer r2 = r5.f10350i     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "DIRTY"
            r2.append(r3)     // Catch:{ all -> 0x005e }
            java.io.Writer r2 = r5.f10350i     // Catch:{ all -> 0x005e }
            r3 = 32
            r2.append(r3)     // Catch:{ all -> 0x005e }
            java.io.Writer r2 = r5.f10350i     // Catch:{ all -> 0x005e }
            r2.append(r6)     // Catch:{ all -> 0x005e }
            java.io.Writer r2 = r5.f10350i     // Catch:{ all -> 0x005e }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x005e }
            java.io.Writer r2 = r5.f10350i     // Catch:{ all -> 0x005e }
            r2.flush()     // Catch:{ all -> 0x005e }
            monitor-exit(r5)
            return r1
        L_0x005e:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p098a.C5911b.m10814a(java.lang.String, long):com.bumptech.glide.a.b$b");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m10817a(com.bumptech.glide.p098a.C5911b.C5913b r11, boolean r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            com.bumptech.glide.a.b$c r0 = r11.f10356a     // Catch:{ all -> 0x0110 }
            com.bumptech.glide.a.b$b r1 = r0.f10365f     // Catch:{ all -> 0x0110 }
            if (r1 != r11) goto L_0x010a
            r1 = 0
            if (r12 == 0) goto L_0x004d
            boolean r2 = r0.f10364e     // Catch:{ all -> 0x0110 }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r10.f10348g     // Catch:{ all -> 0x0110 }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r11.f10357b     // Catch:{ all -> 0x0110 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.mo18544b(r2)     // Catch:{ all -> 0x0110 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0110 }
            if (r3 != 0) goto L_0x0030
            r11.mo18539a()     // Catch:{ all -> 0x0110 }
            monitor-exit(r10)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r11.mo18539a()     // Catch:{ all -> 0x0110 }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r3.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r4 = "Newly created entry didn't create value for index "
            r3.append(r4)     // Catch:{ all -> 0x0110 }
            r3.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0110 }
            r1.<init>(r3)     // Catch:{ all -> 0x0110 }
            throw r1     // Catch:{ all -> 0x0110 }
        L_0x004d:
        L_0x004e:
            int r2 = r10.f10348g     // Catch:{ all -> 0x0110 }
            if (r1 >= r2) goto L_0x0083
            java.io.File r2 = r0.mo18544b(r1)     // Catch:{ all -> 0x0110 }
            if (r12 == 0) goto L_0x007d
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0080
            java.io.File r3 = r0.mo18542a(r1)     // Catch:{ all -> 0x0110 }
            r2.renameTo(r3)     // Catch:{ all -> 0x0110 }
            long[] r4 = r0.f10361b     // Catch:{ all -> 0x0110 }
            r5 = r4[r1]     // Catch:{ all -> 0x0110 }
            r4 = r5
            long r6 = r3.length()     // Catch:{ all -> 0x0110 }
            long[] r8 = r0.f10361b     // Catch:{ all -> 0x0110 }
            r8[r1] = r6     // Catch:{ all -> 0x0110 }
            long r8 = r10.f10349h     // Catch:{ all -> 0x0110 }
            long r8 = r8 - r4
            long r8 = r8 + r6
            r10.f10349h = r8     // Catch:{ all -> 0x0110 }
            goto L_0x0080
        L_0x007d:
            m10819a(r2)     // Catch:{ all -> 0x0110 }
        L_0x0080:
            int r1 = r1 + 1
            goto L_0x004e
        L_0x0083:
            int r1 = r10.f10352k     // Catch:{ all -> 0x0110 }
            r2 = 1
            int r1 = r1 + r2
            r10.f10352k = r1     // Catch:{ all -> 0x0110 }
            r1 = 0
            r0.f10365f = r1     // Catch:{ all -> 0x0110 }
            boolean r1 = r0.f10364e     // Catch:{ all -> 0x0110 }
            r1 = r1 | r12
            r3 = 10
            r4 = 32
            if (r1 == 0) goto L_0x00cb
            r0.f10364e = r2     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = "CLEAN"
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            r1.append(r4)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = r0.f10360a     // Catch:{ all -> 0x0110 }
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = r0.mo18543a()     // Catch:{ all -> 0x0110 }
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            if (r12 == 0) goto L_0x00ee
            long r1 = r10.f10353l     // Catch:{ all -> 0x0110 }
            r3 = 1
            long r3 = r3 + r1
            r10.f10353l = r3     // Catch:{ all -> 0x0110 }
            r0.f10366g = r1     // Catch:{ all -> 0x0110 }
            goto L_0x00ee
        L_0x00cb:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r1 = r10.f10351j     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = r0.f10360a     // Catch:{ all -> 0x0110 }
            r1.remove(r2)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = "REMOVE"
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            r1.append(r4)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = r0.f10360a     // Catch:{ all -> 0x0110 }
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
        L_0x00ee:
            java.io.Writer r1 = r10.f10350i     // Catch:{ all -> 0x0110 }
            r1.flush()     // Catch:{ all -> 0x0110 }
            long r1 = r10.f10349h     // Catch:{ all -> 0x0110 }
            long r3 = r10.f10347f     // Catch:{ all -> 0x0110 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0101
            boolean r1 = r10.m10824c()     // Catch:{ all -> 0x0110 }
            if (r1 == 0) goto L_0x0108
        L_0x0101:
            java.util.concurrent.ThreadPoolExecutor r1 = r10.f10354m     // Catch:{ all -> 0x0110 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r10.f10355n     // Catch:{ all -> 0x0110 }
            r1.submit(r2)     // Catch:{ all -> 0x0110 }
        L_0x0108:
            monitor-exit(r10)
            return
        L_0x010a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            r1.<init>()     // Catch:{ all -> 0x0110 }
            throw r1     // Catch:{ all -> 0x0110 }
        L_0x0110:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0114
        L_0x0113:
            throw r11
        L_0x0114:
            goto L_0x0113
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p098a.C5911b.m10817a(com.bumptech.glide.a.b$b, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m10824c() {
        int i = this.f10352k;
        return i >= 2000 && i >= this.f10351j.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo18535c(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.m10822b()     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r0 = r8.f10351j     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0090 }
            com.bumptech.glide.a.b$c r0 = (com.bumptech.glide.p098a.C5911b.C5914c) r0     // Catch:{ all -> 0x0090 }
            r1 = 0
            if (r0 == 0) goto L_0x008e
            com.bumptech.glide.a.b$b r2 = r0.f10365f     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0017
            goto L_0x008e
        L_0x0017:
        L_0x0018:
            int r2 = r8.f10348g     // Catch:{ all -> 0x0090 }
            if (r1 >= r2) goto L_0x005a
            java.io.File r2 = r0.mo18542a(r1)     // Catch:{ all -> 0x0090 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0090 }
            if (r3 == 0) goto L_0x0044
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0090 }
            if (r3 == 0) goto L_0x002d
            goto L_0x0044
        L_0x002d:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r4.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "failed to delete "
            r4.append(r5)     // Catch:{ all -> 0x0090 }
            r4.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0090 }
            r3.<init>(r4)     // Catch:{ all -> 0x0090 }
            throw r3     // Catch:{ all -> 0x0090 }
        L_0x0044:
            long r3 = r8.f10349h     // Catch:{ all -> 0x0090 }
            long[] r5 = r0.f10361b     // Catch:{ all -> 0x0090 }
            r6 = r5[r1]     // Catch:{ all -> 0x0090 }
            long r3 = r3 - r6
            r8.f10349h = r3     // Catch:{ all -> 0x0090 }
            long[] r3 = r0.f10361b     // Catch:{ all -> 0x0090 }
            r4 = 0
            r3[r1] = r4     // Catch:{ all -> 0x0090 }
            int r1 = r1 + 1
            goto L_0x0018
        L_0x005a:
            int r1 = r8.f10352k     // Catch:{ all -> 0x0090 }
            r2 = 1
            int r1 = r1 + r2
            r8.f10352k = r1     // Catch:{ all -> 0x0090 }
            java.io.Writer r1 = r8.f10350i     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "REMOVE"
            r1.append(r3)     // Catch:{ all -> 0x0090 }
            java.io.Writer r1 = r8.f10350i     // Catch:{ all -> 0x0090 }
            r3 = 32
            r1.append(r3)     // Catch:{ all -> 0x0090 }
            java.io.Writer r1 = r8.f10350i     // Catch:{ all -> 0x0090 }
            r1.append(r9)     // Catch:{ all -> 0x0090 }
            java.io.Writer r1 = r8.f10350i     // Catch:{ all -> 0x0090 }
            r3 = 10
            r1.append(r3)     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.b$c> r1 = r8.f10351j     // Catch:{ all -> 0x0090 }
            r1.remove(r9)     // Catch:{ all -> 0x0090 }
            boolean r1 = r8.m10824c()     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008c
            java.util.concurrent.ThreadPoolExecutor r1 = r8.f10354m     // Catch:{ all -> 0x0090 }
            java.util.concurrent.Callable<java.lang.Void> r3 = r8.f10355n     // Catch:{ all -> 0x0090 }
            r1.submit(r3)     // Catch:{ all -> 0x0090 }
        L_0x008c:
            monitor-exit(r8)
            return r2
        L_0x008e:
            monitor-exit(r8)
            return r1
        L_0x0090:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0094
        L_0x0093:
            throw r9
        L_0x0094:
            goto L_0x0093
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p098a.C5911b.mo18535c(java.lang.String):boolean");
    }

    /* renamed from: b */
    private void m10822b() {
        if (this.f10350i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (this.f10350i != null) {
            Iterator it = new ArrayList(this.f10351j.values()).iterator();
            while (it.hasNext()) {
                C5914c entry = (C5914c) it.next();
                if (entry.f10365f != null) {
                    entry.f10365f.mo18539a();
                }
            }
            m10832g();
            this.f10350i.close();
            this.f10350i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m10832g() throws IOException {
        while (this.f10349h > this.f10347f) {
            mo18535c((String) ((Map.Entry) this.f10351j.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: a */
    public void mo18533a() throws IOException {
        close();
        C5918e.m10863a(this.f10342a);
    }
}
