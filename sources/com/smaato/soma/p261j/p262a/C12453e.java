package com.smaato.soma.p261j.p262a;

import com.smaato.soma.video.utilities.DiskLruCache.Entry;
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
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.smaato.soma.j.a.e */
/* compiled from: DiskLruCache */
public final class C12453e implements Closeable {

    /* renamed from: a */
    static final Pattern f38867a = Pattern.compile("[a-z0-9_-]{1,64}");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final OutputStream f38868b = new C12452d();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final File f38869c;

    /* renamed from: d */
    private final File f38870d;

    /* renamed from: e */
    private final File f38871e;

    /* renamed from: f */
    private final File f38872f;

    /* renamed from: g */
    private final int f38873g;

    /* renamed from: h */
    private long f38874h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final int f38875i;

    /* renamed from: j */
    private long f38876j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Writer f38877k;

    /* renamed from: l */
    private final LinkedHashMap<String, C12456b> f38878l = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f38879m;

    /* renamed from: n */
    private long f38880n = 0;

    /* renamed from: o */
    final ThreadPoolExecutor f38881o;

    /* renamed from: p */
    private final Callable<Void> f38882p;

    /* renamed from: com.smaato.soma.j.a.e$a */
    /* compiled from: DiskLruCache */
    public final class C12454a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C12456b f38883a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final boolean[] f38884b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f38885c;

        /* renamed from: d */
        private boolean f38886d;

        /* renamed from: com.smaato.soma.j.a.e$a$a */
        /* compiled from: DiskLruCache */
        private class C12455a extends FilterOutputStream {
            /* synthetic */ C12455a(C12454a x0, OutputStream x1, C12451c x2) {
                this(x1);
            }

            private C12455a(OutputStream out) {
                super(out);
            }

            public void write(int oneByte) {
                try {
                    this.out.write(oneByte);
                } catch (IOException e) {
                    C12454a.this.f38885c = true;
                }
            }

            public void write(byte[] buffer, int offset, int length) {
                try {
                    this.out.write(buffer, offset, length);
                } catch (IOException e) {
                    C12454a.this.f38885c = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C12454a.this.f38885c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C12454a.this.f38885c = true;
                }
            }
        }

        /* synthetic */ C12454a(C12453e x0, C12456b x1, C12451c x2) {
            this(x1);
        }

        private C12454a(C12456b entry) {
            this.f38883a = entry;
            this.f38884b = entry.f38891c ? null : new boolean[C12453e.this.f38875i];
        }

        /* renamed from: a */
        public OutputStream mo39984a(int index) throws IOException {
            FileOutputStream outputStream;
            C12455a aVar;
            synchronized (C12453e.this) {
                if (this.f38883a.f38892d == this) {
                    if (!this.f38883a.f38891c) {
                        this.f38884b[index] = true;
                    }
                    File dirtyFile = this.f38883a.mo39993b(index);
                    try {
                        outputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException e) {
                        C12453e.this.f38869c.mkdirs();
                        try {
                            outputStream = new FileOutputStream(dirtyFile);
                        } catch (FileNotFoundException e2) {
                            return C12453e.f38868b;
                        }
                    }
                    aVar = new C12455a(this, outputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }

        /* renamed from: b */
        public void mo39986b() throws IOException {
            if (this.f38885c) {
                C12453e.this.m40940a(this, false);
                C12453e.this.mo39981c(this.f38883a.f38889a);
            } else {
                C12453e.this.m40940a(this, true);
            }
            this.f38886d = true;
        }

        /* renamed from: a */
        public void mo39985a() throws IOException {
            C12453e.this.m40940a(this, false);
        }
    }

    /* renamed from: com.smaato.soma.j.a.e$b */
    /* compiled from: DiskLruCache */
    private final class C12456b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f38889a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long[] f38890b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f38891c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C12454a f38892d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f38893e;

        /* synthetic */ C12456b(C12453e x0, String x1, C12451c x2) {
            this(x1);
        }

        private C12456b(String key) {
            this.f38889a = key;
            this.f38890b = new long[C12453e.this.f38875i];
        }

        /* renamed from: a */
        public String mo39992a() throws IOException {
            long[] jArr;
            StringBuilder result = new StringBuilder();
            for (long size : this.f38890b) {
                result.append(' ');
                result.append(size);
            }
            return result.toString();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m40975b(String[] strings) throws IOException {
            if (strings.length == C12453e.this.f38875i) {
                int i = 0;
                while (i < strings.length) {
                    try {
                        this.f38890b[i] = Long.parseLong(strings[i]);
                        i++;
                    } catch (NumberFormatException e) {
                        m40970a(strings);
                        throw null;
                    }
                }
                return;
            }
            m40970a(strings);
            throw null;
        }

        /* renamed from: a */
        private IOException m40970a(String[] strings) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strings));
            throw new IOException(sb.toString());
        }

        /* renamed from: a */
        public File mo39991a(int i) {
            File d = C12453e.this.f38869c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f38889a);
            sb.append(".");
            sb.append(i);
            return new File(d, sb.toString());
        }

        /* renamed from: b */
        public File mo39993b(int i) {
            File d = C12453e.this.f38869c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f38889a);
            sb.append(".");
            sb.append(i);
            sb.append(".tmp");
            return new File(d, sb.toString());
        }
    }

    /* renamed from: com.smaato.soma.j.a.e$c */
    /* compiled from: DiskLruCache */
    public final class C12457c implements Closeable {

        /* renamed from: a */
        private final String f38895a;

        /* renamed from: b */
        private final long f38896b;

        /* renamed from: c */
        private final InputStream[] f38897c;

        /* renamed from: d */
        private final long[] f38898d;

        /* synthetic */ C12457c(C12453e x0, String x1, long x2, InputStream[] x3, long[] x4, C12451c x5) {
            this(x1, x2, x3, x4);
        }

        private C12457c(String key, long sequenceNumber, InputStream[] ins, long[] lengths) {
            this.f38895a = key;
            this.f38896b = sequenceNumber;
            this.f38897c = ins;
            this.f38898d = lengths;
        }

        public void close() {
            for (InputStream in : this.f38897c) {
                C12460h.m40985a((Closeable) in);
            }
        }
    }

    private C12453e(File directory, int appVersion, int valueCount, long maxSize) {
        File file = directory;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f38881o = threadPoolExecutor;
        this.f38882p = new C12451c(this);
        this.f38869c = file;
        this.f38873g = appVersion;
        this.f38870d = new File(file, "journal");
        this.f38871e = new File(file, "journal.tmp");
        this.f38872f = new File(file, "journal.bkp");
        this.f38875i = valueCount;
        this.f38874h = maxSize;
    }

    /* renamed from: a */
    public static C12453e m40937a(File directory, int appVersion, int valueCount, long maxSize) throws IOException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (valueCount > 0) {
            File backupFile = new File(directory, "journal.bkp");
            if (backupFile.exists()) {
                File journalFile = new File(directory, "journal");
                if (journalFile.exists()) {
                    backupFile.delete();
                } else {
                    m40943a(backupFile, journalFile, false);
                }
            }
            C12453e eVar = new C12453e(directory, appVersion, valueCount, maxSize);
            if (eVar.f38870d.exists()) {
                try {
                    eVar.m40954g();
                    eVar.m40952f();
                    eVar.f38877k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(eVar.f38870d, true), C12460h.f38906a));
                    return eVar;
                } catch (IOException journalIsCorrupt) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(directory);
                    sb.append(" is corrupt: ");
                    sb.append(journalIsCorrupt.getMessage());
                    sb.append(", removing");
                    printStream.println(sb.toString());
                    eVar.mo39979b();
                }
            }
            directory.mkdirs();
            C12453e eVar2 = new C12453e(directory, appVersion, valueCount, maxSize);
            C12453e cache = eVar2;
            cache.m40955h();
            return cache;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* renamed from: g */
    private void m40954g() throws IOException {
        int lineCount;
        String str = ", ";
        C12459g reader = new C12459g(new FileInputStream(this.f38870d), C12460h.f38906a);
        try {
            String magic = reader.mo39996a();
            String version = reader.mo39996a();
            String appVersionString = reader.mo39996a();
            String valueCountString = reader.mo39996a();
            String blank = reader.mo39996a();
            if (!"libcore.io.DiskLruCache".equals(magic) || !"1".equals(version) || !Integer.toString(this.f38873g).equals(appVersionString) || !Integer.toString(this.f38875i).equals(valueCountString) || !"".equals(blank)) {
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
                m40948d(reader.mo39996a());
                lineCount++;
            }
        } catch (EOFException e) {
            this.f38879m = lineCount - this.f38878l.size();
            C12460h.m40985a((Closeable) reader);
        } catch (Throwable th) {
            C12460h.m40985a((Closeable) reader);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
        if (r11.startsWith(r3) != false) goto L_0x0095;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m40948d(java.lang.String r11) throws java.io.IOException {
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
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r2 = r10.f38878l
            r2.remove(r5)
            return
        L_0x002b:
            java.lang.String r5 = r11.substring(r4, r0)
        L_0x002f:
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r6 = r10.f38878l
            java.lang.Object r6 = r6.get(r5)
            com.smaato.soma.j.a.e$b r6 = (com.smaato.soma.p261j.p262a.C12453e.C12456b) r6
            r7 = 0
            if (r6 != 0) goto L_0x0045
            com.smaato.soma.j.a.e$b r8 = new com.smaato.soma.j.a.e$b
            r8.<init>(r10, r5, r7)
            r6 = r8
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r8 = r10.f38878l
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
            r6.f38891c = r3
            r6.f38892d = r7
            r6.m40975b(r2)
            goto L_0x0095
        L_0x006c:
            if (r0 != r3) goto L_0x0085
            java.lang.String r8 = "DIRTY"
            int r9 = r8.length()
            if (r1 != r9) goto L_0x0085
            boolean r8 = r11.startsWith(r8)
            if (r8 == 0) goto L_0x0085
            com.smaato.soma.j.a.e$a r2 = new com.smaato.soma.j.a.e$a
            r2.<init>(r10, r6, r7)
            r6.f38892d = r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p261j.p262a.C12453e.m40948d(java.lang.String):void");
    }

    /* renamed from: f */
    private void m40952f() throws IOException {
        m40942a(this.f38871e);
        Iterator<Entry> i = this.f38878l.values().iterator();
        while (i.hasNext()) {
            C12456b entry = (C12456b) i.next();
            if (entry.f38892d == null) {
                for (int t = 0; t < this.f38875i; t++) {
                    this.f38876j += entry.f38890b[t];
                }
            } else {
                entry.f38892d = null;
                for (int t2 = 0; t2 < this.f38875i; t2++) {
                    m40942a(entry.mo39991a(t2));
                    m40942a(entry.mo39993b(t2));
                }
                i.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: h */
    public synchronized void m40955h() throws IOException {
        if (this.f38877k != null) {
            this.f38877k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f38871e), C12460h.f38906a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f38873g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f38875i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C12456b entry : this.f38878l.values()) {
                if (entry.f38892d != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(entry.f38889a);
                    sb.append(10);
                    bufferedWriter.write(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(entry.f38889a);
                    sb2.append(entry.mo39992a());
                    sb2.append(10);
                    bufferedWriter.write(sb2.toString());
                }
            }
            bufferedWriter.close();
            if (this.f38870d.exists()) {
                m40943a(this.f38870d, this.f38872f, true);
            }
            m40943a(this.f38871e, this.f38870d, false);
            this.f38872f.delete();
            this.f38877k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f38870d, true), C12460h.f38906a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m40942a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m40943a(File from, File to, boolean deleteDestination) throws IOException {
        if (deleteDestination) {
            m40942a(to);
        }
        if (!from.renameTo(to)) {
            throw new IOException();
        }
    }

    /* renamed from: b */
    public synchronized C12457c mo39978b(String key) throws IOException {
        m40947d();
        m40949e(key);
        C12456b entry = (C12456b) this.f38878l.get(key);
        if (entry == null) {
            return null;
        }
        if (!entry.f38891c) {
            return null;
        }
        InputStream[] ins = new InputStream[this.f38875i];
        int i = 0;
        int i2 = 0;
        while (i2 < this.f38875i) {
            try {
                ins[i2] = new FileInputStream(entry.mo39991a(i2));
                i2++;
            } catch (FileNotFoundException e) {
                while (i < this.f38875i && ins[i] != null) {
                    C12460h.m40985a((Closeable) ins[i]);
                    i++;
                }
                return null;
            }
        }
        this.f38879m++;
        Writer writer = this.f38877k;
        StringBuilder sb = new StringBuilder();
        sb.append("READ ");
        sb.append(key);
        sb.append(10);
        writer.append(sb.toString());
        if (m40950e()) {
            this.f38881o.submit(this.f38882p);
        }
        C12457c cVar = new C12457c(this, key, entry.f38893e, ins, entry.f38890b, null);
        return cVar;
    }

    /* renamed from: a */
    public C12454a mo39977a(String key) throws IOException {
        return m40936a(key, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.smaato.soma.p261j.p262a.C12453e.C12454a m40936a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m40947d()     // Catch:{ all -> 0x0062 }
            r5.m40949e(r6)     // Catch:{ all -> 0x0062 }
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r0 = r5.f38878l     // Catch:{ all -> 0x0062 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0062 }
            com.smaato.soma.j.a.e$b r0 = (com.smaato.soma.p261j.p262a.C12453e.C12456b) r0     // Catch:{ all -> 0x0062 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r1 = r0.f38893e     // Catch:{ all -> 0x0062 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r3
        L_0x0022:
            if (r0 != 0) goto L_0x0030
            com.smaato.soma.j.a.e$b r1 = new com.smaato.soma.j.a.e$b     // Catch:{ all -> 0x0062 }
            r1.<init>(r5, r6, r3)     // Catch:{ all -> 0x0062 }
            r0 = r1
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r1 = r5.f38878l     // Catch:{ all -> 0x0062 }
            r1.put(r6, r0)     // Catch:{ all -> 0x0062 }
            goto L_0x0038
        L_0x0030:
            com.smaato.soma.j.a.e$a r1 = r0.f38892d     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0038
            monitor-exit(r5)
            return r3
        L_0x0038:
            com.smaato.soma.j.a.e$a r1 = new com.smaato.soma.j.a.e$a     // Catch:{ all -> 0x0062 }
            r1.<init>(r5, r0, r3)     // Catch:{ all -> 0x0062 }
            r0.f38892d = r1     // Catch:{ all -> 0x0062 }
            java.io.Writer r2 = r5.f38877k     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r3.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "DIRTY "
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            r3.append(r6)     // Catch:{ all -> 0x0062 }
            r4 = 10
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0062 }
            r2.write(r3)     // Catch:{ all -> 0x0062 }
            java.io.Writer r2 = r5.f38877k     // Catch:{ all -> 0x0062 }
            r2.flush()     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)
            return r1
        L_0x0062:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p261j.p262a.C12453e.m40936a(java.lang.String, long):com.smaato.soma.j.a.e$a");
    }

    /* renamed from: c */
    public File mo39980c() {
        return this.f38869c;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010b, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m40940a(com.smaato.soma.p261j.p262a.C12453e.C12454a r11, boolean r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            com.smaato.soma.j.a.e$b r0 = r11.f38883a     // Catch:{ all -> 0x0112 }
            com.smaato.soma.j.a.e$a r1 = r0.f38892d     // Catch:{ all -> 0x0112 }
            if (r1 != r11) goto L_0x010c
            r1 = 0
            if (r12 == 0) goto L_0x004d
            boolean r2 = r0.f38891c     // Catch:{ all -> 0x0112 }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r10.f38875i     // Catch:{ all -> 0x0112 }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r11.f38884b     // Catch:{ all -> 0x0112 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.mo39993b(r2)     // Catch:{ all -> 0x0112 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0112 }
            if (r3 != 0) goto L_0x0030
            r11.mo39985a()     // Catch:{ all -> 0x0112 }
            monitor-exit(r10)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r11.mo39985a()     // Catch:{ all -> 0x0112 }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r3.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = "Newly created entry didn't create value for index "
            r3.append(r4)     // Catch:{ all -> 0x0112 }
            r3.append(r2)     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0112 }
            r1.<init>(r3)     // Catch:{ all -> 0x0112 }
            throw r1     // Catch:{ all -> 0x0112 }
        L_0x004d:
        L_0x004e:
            int r2 = r10.f38875i     // Catch:{ all -> 0x0112 }
            if (r1 >= r2) goto L_0x0083
            java.io.File r2 = r0.mo39993b(r1)     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x007d
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x0080
            java.io.File r3 = r0.mo39991a(r1)     // Catch:{ all -> 0x0112 }
            r2.renameTo(r3)     // Catch:{ all -> 0x0112 }
            long[] r4 = r0.f38890b     // Catch:{ all -> 0x0112 }
            r5 = r4[r1]     // Catch:{ all -> 0x0112 }
            r4 = r5
            long r6 = r3.length()     // Catch:{ all -> 0x0112 }
            long[] r8 = r0.f38890b     // Catch:{ all -> 0x0112 }
            r8[r1] = r6     // Catch:{ all -> 0x0112 }
            long r8 = r10.f38876j     // Catch:{ all -> 0x0112 }
            long r8 = r8 - r4
            long r8 = r8 + r6
            r10.f38876j = r8     // Catch:{ all -> 0x0112 }
            goto L_0x0080
        L_0x007d:
            m40942a(r2)     // Catch:{ all -> 0x0112 }
        L_0x0080:
            int r1 = r1 + 1
            goto L_0x004e
        L_0x0083:
            int r1 = r10.f38879m     // Catch:{ all -> 0x0112 }
            r2 = 1
            int r1 = r1 + r2
            r10.f38879m = r1     // Catch:{ all -> 0x0112 }
            r1 = 0
            r0.f38892d = r1     // Catch:{ all -> 0x0112 }
            boolean r1 = r0.f38891c     // Catch:{ all -> 0x0112 }
            r1 = r1 | r12
            r3 = 10
            if (r1 == 0) goto L_0x00ca
            r0.f38891c = r2     // Catch:{ all -> 0x0112 }
            java.io.Writer r1 = r10.f38877k     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r2.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = "CLEAN "
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r0.f38889a     // Catch:{ all -> 0x0112 }
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r0.mo39992a()     // Catch:{ all -> 0x0112 }
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            r2.append(r3)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0112 }
            r1.write(r2)     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x00f0
            long r1 = r10.f38880n     // Catch:{ all -> 0x0112 }
            r3 = 1
            long r3 = r3 + r1
            r10.f38880n = r3     // Catch:{ all -> 0x0112 }
            r0.f38893e = r1     // Catch:{ all -> 0x0112 }
            goto L_0x00f0
        L_0x00ca:
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r1 = r10.f38878l     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r0.f38889a     // Catch:{ all -> 0x0112 }
            r1.remove(r2)     // Catch:{ all -> 0x0112 }
            java.io.Writer r1 = r10.f38877k     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r2.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = "REMOVE "
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r0.f38889a     // Catch:{ all -> 0x0112 }
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            r2.append(r3)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0112 }
            r1.write(r2)     // Catch:{ all -> 0x0112 }
        L_0x00f0:
            java.io.Writer r1 = r10.f38877k     // Catch:{ all -> 0x0112 }
            r1.flush()     // Catch:{ all -> 0x0112 }
            long r1 = r10.f38876j     // Catch:{ all -> 0x0112 }
            long r3 = r10.f38874h     // Catch:{ all -> 0x0112 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0103
            boolean r1 = r10.m40950e()     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x010a
        L_0x0103:
            java.util.concurrent.ThreadPoolExecutor r1 = r10.f38881o     // Catch:{ all -> 0x0112 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r10.f38882p     // Catch:{ all -> 0x0112 }
            r1.submit(r2)     // Catch:{ all -> 0x0112 }
        L_0x010a:
            monitor-exit(r10)
            return
        L_0x010c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0112 }
            r1.<init>()     // Catch:{ all -> 0x0112 }
            throw r1     // Catch:{ all -> 0x0112 }
        L_0x0112:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0116
        L_0x0115:
            throw r11
        L_0x0116:
            goto L_0x0115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p261j.p262a.C12453e.m40940a(com.smaato.soma.j.a.e$a, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m40950e() {
        int i = this.f38879m;
        return i >= 2000 && i >= this.f38878l.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0091, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0093, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo39981c(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.m40947d()     // Catch:{ all -> 0x0094 }
            r8.m40949e(r9)     // Catch:{ all -> 0x0094 }
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r0 = r8.f38878l     // Catch:{ all -> 0x0094 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0094 }
            com.smaato.soma.j.a.e$b r0 = (com.smaato.soma.p261j.p262a.C12453e.C12456b) r0     // Catch:{ all -> 0x0094 }
            r1 = 0
            if (r0 == 0) goto L_0x0092
            com.smaato.soma.j.a.e$a r2 = r0.f38892d     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0092
        L_0x001a:
        L_0x001b:
            int r2 = r8.f38875i     // Catch:{ all -> 0x0094 }
            if (r1 >= r2) goto L_0x005d
            java.io.File r2 = r0.mo39991a(r1)     // Catch:{ all -> 0x0094 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x0047
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x0030
            goto L_0x0047
        L_0x0030:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r4.<init>()     // Catch:{ all -> 0x0094 }
            java.lang.String r5 = "failed to delete "
            r4.append(r5)     // Catch:{ all -> 0x0094 }
            r4.append(r2)     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0094 }
            r3.<init>(r4)     // Catch:{ all -> 0x0094 }
            throw r3     // Catch:{ all -> 0x0094 }
        L_0x0047:
            long r3 = r8.f38876j     // Catch:{ all -> 0x0094 }
            long[] r5 = r0.f38890b     // Catch:{ all -> 0x0094 }
            r6 = r5[r1]     // Catch:{ all -> 0x0094 }
            long r3 = r3 - r6
            r8.f38876j = r3     // Catch:{ all -> 0x0094 }
            long[] r3 = r0.f38890b     // Catch:{ all -> 0x0094 }
            r4 = 0
            r3[r1] = r4     // Catch:{ all -> 0x0094 }
            int r1 = r1 + 1
            goto L_0x001b
        L_0x005d:
            int r1 = r8.f38879m     // Catch:{ all -> 0x0094 }
            r2 = 1
            int r1 = r1 + r2
            r8.f38879m = r1     // Catch:{ all -> 0x0094 }
            java.io.Writer r1 = r8.f38877k     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r3.<init>()     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = "REMOVE "
            r3.append(r4)     // Catch:{ all -> 0x0094 }
            r3.append(r9)     // Catch:{ all -> 0x0094 }
            r4 = 10
            r3.append(r4)     // Catch:{ all -> 0x0094 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0094 }
            r1.append(r3)     // Catch:{ all -> 0x0094 }
            java.util.LinkedHashMap<java.lang.String, com.smaato.soma.j.a.e$b> r1 = r8.f38878l     // Catch:{ all -> 0x0094 }
            r1.remove(r9)     // Catch:{ all -> 0x0094 }
            boolean r1 = r8.m40950e()     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0090
            java.util.concurrent.ThreadPoolExecutor r1 = r8.f38881o     // Catch:{ all -> 0x0094 }
            java.util.concurrent.Callable<java.lang.Void> r3 = r8.f38882p     // Catch:{ all -> 0x0094 }
            r1.submit(r3)     // Catch:{ all -> 0x0094 }
        L_0x0090:
            monitor-exit(r8)
            return r2
        L_0x0092:
            monitor-exit(r8)
            return r1
        L_0x0094:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0098
        L_0x0097:
            throw r9
        L_0x0098:
            goto L_0x0097
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p261j.p262a.C12453e.mo39981c(java.lang.String):boolean");
    }

    /* renamed from: d */
    private void m40947d() {
        if (this.f38877k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        m40947d();
        m40956i();
        this.f38877k.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f38877k != null) {
            Iterator it = new ArrayList(this.f38878l.values()).iterator();
            while (it.hasNext()) {
                C12456b entry = (C12456b) it.next();
                if (entry.f38892d != null) {
                    entry.f38892d.mo39985a();
                }
            }
            m40956i();
            this.f38877k.close();
            this.f38877k = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m40956i() throws IOException {
        while (this.f38876j > this.f38874h) {
            mo39981c((String) ((Map.Entry) this.f38878l.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: b */
    public void mo39979b() throws IOException {
        close();
        C12460h.m40986a(this.f38869c);
    }

    /* renamed from: e */
    private void m40949e(String key) {
        if (!f38867a.matcher(key).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("keys must match regex [a-z0-9_-]{1,64}: \"");
            sb.append(key);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
