package com.mopub.common;

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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
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

public final class DiskLruCache implements Closeable {

    /* renamed from: a */
    static final Pattern f34279a = Pattern.compile("[a-z0-9_-]{1,64}");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final OutputStream f34280b = new C11249j();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final File f34281c;

    /* renamed from: d */
    private final File f34282d;

    /* renamed from: e */
    private final File f34283e;

    /* renamed from: f */
    private final File f34284f;

    /* renamed from: g */
    private final int f34285g;

    /* renamed from: h */
    private long f34286h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final int f34287i;

    /* renamed from: j */
    private long f34288j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Writer f34289k;

    /* renamed from: l */
    private final LinkedHashMap<String, C11225a> f34290l = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f34291m;

    /* renamed from: n */
    private long f34292n = 0;

    /* renamed from: o */
    final ThreadPoolExecutor f34293o;

    /* renamed from: p */
    private final Callable<Void> f34294p;

    public final class Editor {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C11225a f34295a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final boolean[] f34296b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f34297c;

        /* renamed from: d */
        private boolean f34298d;

        /* renamed from: com.mopub.common.DiskLruCache$Editor$a */
        private class C11224a extends FilterOutputStream {
            /* synthetic */ C11224a(Editor x0, OutputStream x1, C11248i x2) {
                this(x1);
            }

            private C11224a(OutputStream out) {
                super(out);
            }

            public void write(int oneByte) {
                try {
                    this.out.write(oneByte);
                } catch (IOException e) {
                    Editor.this.f34297c = true;
                }
            }

            public void write(byte[] buffer, int offset, int length) {
                try {
                    this.out.write(buffer, offset, length);
                } catch (IOException e) {
                    Editor.this.f34297c = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    Editor.this.f34297c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    Editor.this.f34297c = true;
                }
            }
        }

        /* synthetic */ Editor(DiskLruCache x0, C11225a x1, C11248i x2) {
            this(x1);
        }

        private Editor(C11225a entry) {
            this.f34295a = entry;
            this.f34296b = entry.f34308c ? null : new boolean[DiskLruCache.this.f34287i];
        }

        public InputStream newInputStream(int index) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f34295a.f34309d != this) {
                    throw new IllegalStateException();
                } else if (!this.f34295a.f34308c) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.f34295a.getCleanFile(index));
                        return fileInputStream;
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                }
            }
        }

        public String getString(int index) throws IOException {
            InputStream in = newInputStream(index);
            if (in != null) {
                return DiskLruCache.m36974b(in);
            }
            return null;
        }

        public OutputStream newOutputStream(int index) throws IOException {
            FileOutputStream outputStream;
            C11224a aVar;
            synchronized (DiskLruCache.this) {
                if (this.f34295a.f34309d == this) {
                    if (!this.f34295a.f34308c) {
                        this.f34296b[index] = true;
                    }
                    File dirtyFile = this.f34295a.getDirtyFile(index);
                    try {
                        outputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException e) {
                        DiskLruCache.this.f34281c.mkdirs();
                        try {
                            outputStream = new FileOutputStream(dirtyFile);
                        } catch (FileNotFoundException e2) {
                            return DiskLruCache.f34280b;
                        }
                    }
                    aVar = new C11224a(this, outputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }

        public void set(int index, String value) throws IOException {
            Writer writer = null;
            try {
                writer = new OutputStreamWriter(newOutputStream(index), DiskLruCacheUtil.f34313b);
                writer.write(value);
            } finally {
                DiskLruCacheUtil.m37002a((Closeable) writer);
            }
        }

        public void commit() throws IOException {
            if (this.f34297c) {
                DiskLruCache.this.m36969a(this, false);
                DiskLruCache.this.remove(this.f34295a.f34306a);
            } else {
                DiskLruCache.this.m36969a(this, true);
            }
            this.f34298d = true;
        }

        public void abort() throws IOException {
            DiskLruCache.this.m36969a(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.f34298d) {
                try {
                    abort();
                } catch (IOException e) {
                }
            }
        }
    }

    public final class Snapshot implements Closeable {

        /* renamed from: a */
        private final String f34301a;

        /* renamed from: b */
        private final long f34302b;

        /* renamed from: c */
        private final InputStream[] f34303c;

        /* renamed from: d */
        private final long[] f34304d;

        /* synthetic */ Snapshot(DiskLruCache x0, String x1, long x2, InputStream[] x3, long[] x4, C11248i x5) {
            this(x1, x2, x3, x4);
        }

        private Snapshot(String key, long sequenceNumber, InputStream[] ins, long[] lengths) {
            this.f34301a = key;
            this.f34302b = sequenceNumber;
            this.f34303c = ins;
            this.f34304d = lengths;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.m36965a(this.f34301a, this.f34302b);
        }

        public InputStream getInputStream(int index) {
            return this.f34303c[index];
        }

        public String getString(int index) throws IOException {
            return DiskLruCache.m36974b(getInputStream(index));
        }

        public long getLength(int index) {
            return this.f34304d[index];
        }

        public void close() {
            for (InputStream in : this.f34303c) {
                DiskLruCacheUtil.m37002a((Closeable) in);
            }
        }
    }

    /* renamed from: com.mopub.common.DiskLruCache$a */
    private final class C11225a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f34306a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long[] f34307b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f34308c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Editor f34309d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f34310e;

        /* synthetic */ C11225a(DiskLruCache x0, String x1, C11248i x2) {
            this(x1);
        }

        private C11225a(String key) {
            this.f34306a = key;
            this.f34307b = new long[DiskLruCache.this.f34287i];
        }

        public String getLengths() throws IOException {
            long[] jArr;
            StringBuilder result = new StringBuilder();
            for (long size : this.f34307b) {
                result.append(' ');
                result.append(size);
            }
            return result.toString();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m36997b(String[] strings) throws IOException {
            if (strings.length == DiskLruCache.this.f34287i) {
                int i = 0;
                while (i < strings.length) {
                    try {
                        this.f34307b[i] = Long.parseLong(strings[i]);
                        i++;
                    } catch (NumberFormatException e) {
                        m36992a(strings);
                        throw null;
                    }
                }
                return;
            }
            m36992a(strings);
            throw null;
        }

        /* renamed from: a */
        private IOException m36992a(String[] strings) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strings));
            throw new IOException(sb.toString());
        }

        public File getCleanFile(int i) {
            File d = DiskLruCache.this.f34281c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f34306a);
            sb.append(".");
            sb.append(i);
            return new File(d, sb.toString());
        }

        public File getDirtyFile(int i) {
            File d = DiskLruCache.this.f34281c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f34306a);
            sb.append(".");
            sb.append(i);
            sb.append(".tmp");
            return new File(d, sb.toString());
        }
    }

    private DiskLruCache(File directory, int appVersion, int valueCount, long maxSize) {
        File file = directory;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f34293o = threadPoolExecutor;
        this.f34294p = new C11248i(this);
        this.f34281c = file;
        this.f34285g = appVersion;
        this.f34282d = new File(file, "journal");
        this.f34283e = new File(file, "journal.tmp");
        this.f34284f = new File(file, "journal.bkp");
        this.f34287i = valueCount;
        this.f34286h = maxSize;
    }

    public static DiskLruCache open(File directory, int appVersion, int valueCount, long maxSize) throws IOException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (valueCount > 0) {
            File backupFile = new File(directory, "journal.bkp");
            if (backupFile.exists()) {
                File journalFile = new File(directory, "journal");
                if (journalFile.exists()) {
                    backupFile.delete();
                } else {
                    m36972a(backupFile, journalFile, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(directory, appVersion, valueCount, maxSize);
            if (diskLruCache.f34282d.exists()) {
                try {
                    diskLruCache.m36982e();
                    diskLruCache.m36981d();
                    diskLruCache.f34289k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f34282d, true), DiskLruCacheUtil.f34312a));
                    return diskLruCache;
                } catch (IOException journalIsCorrupt) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(directory);
                    sb.append(" is corrupt: ");
                    sb.append(journalIsCorrupt.getMessage());
                    sb.append(", removing");
                    printStream.println(sb.toString());
                    diskLruCache.delete();
                }
            }
            directory.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(directory, appVersion, valueCount, maxSize);
            DiskLruCache cache = diskLruCache2;
            cache.m36984f();
            return cache;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* renamed from: e */
    private void m36982e() throws IOException {
        int lineCount;
        String str = ", ";
        C11251l reader = new C11251l(new FileInputStream(this.f34282d), DiskLruCacheUtil.f34312a);
        try {
            String magic = reader.readLine();
            String version = reader.readLine();
            String appVersionString = reader.readLine();
            String valueCountString = reader.readLine();
            String blank = reader.readLine();
            if (!"libcore.io.DiskLruCache".equals(magic) || !"1".equals(version) || !Integer.toString(this.f34285g).equals(appVersionString) || !Integer.toString(this.f34287i).equals(valueCountString) || !"".equals(blank)) {
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
                m36973a(reader.readLine());
                lineCount++;
            }
        } catch (EOFException e) {
            this.f34291m = lineCount - this.f34290l.size();
            DiskLruCacheUtil.m37002a((Closeable) reader);
        } catch (Throwable th) {
            DiskLruCacheUtil.m37002a((Closeable) reader);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
        if (r11.startsWith(r3) != false) goto L_0x0095;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m36973a(java.lang.String r11) throws java.io.IOException {
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
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r2 = r10.f34290l
            r2.remove(r5)
            return
        L_0x002b:
            java.lang.String r5 = r11.substring(r4, r0)
        L_0x002f:
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r6 = r10.f34290l
            java.lang.Object r6 = r6.get(r5)
            com.mopub.common.DiskLruCache$a r6 = (com.mopub.common.DiskLruCache.C11225a) r6
            r7 = 0
            if (r6 != 0) goto L_0x0045
            com.mopub.common.DiskLruCache$a r8 = new com.mopub.common.DiskLruCache$a
            r8.<init>(r10, r5, r7)
            r6 = r8
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r8 = r10.f34290l
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
            r6.f34308c = r3
            r6.f34309d = r7
            r6.m36997b(r2)
            goto L_0x0095
        L_0x006c:
            if (r0 != r3) goto L_0x0085
            java.lang.String r8 = "DIRTY"
            int r9 = r8.length()
            if (r1 != r9) goto L_0x0085
            boolean r8 = r11.startsWith(r8)
            if (r8 == 0) goto L_0x0085
            com.mopub.common.DiskLruCache$Editor r2 = new com.mopub.common.DiskLruCache$Editor
            r2.<init>(r10, r6, r7)
            r6.f34309d = r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.DiskLruCache.m36973a(java.lang.String):void");
    }

    /* renamed from: d */
    private void m36981d() throws IOException {
        m36971a(this.f34283e);
        Iterator<Entry> i = this.f34290l.values().iterator();
        while (i.hasNext()) {
            C11225a entry = (C11225a) i.next();
            if (entry.f34309d == null) {
                for (int t = 0; t < this.f34287i; t++) {
                    this.f34288j += entry.f34307b[t];
                }
            } else {
                entry.f34309d = null;
                for (int t2 = 0; t2 < this.f34287i; t2++) {
                    m36971a(entry.getCleanFile(t2));
                    m36971a(entry.getDirtyFile(t2));
                }
                i.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m36984f() throws IOException {
        if (this.f34289k != null) {
            this.f34289k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f34283e), DiskLruCacheUtil.f34312a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f34285g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f34287i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C11225a entry : this.f34290l.values()) {
                if (entry.f34309d != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(entry.f34306a);
                    sb.append(10);
                    bufferedWriter.write(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(entry.f34306a);
                    sb2.append(entry.getLengths());
                    sb2.append(10);
                    bufferedWriter.write(sb2.toString());
                }
            }
            bufferedWriter.close();
            if (this.f34282d.exists()) {
                m36972a(this.f34282d, this.f34284f, true);
            }
            m36972a(this.f34283e, this.f34282d, false);
            this.f34284f.delete();
            this.f34289k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f34282d, true), DiskLruCacheUtil.f34312a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m36971a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m36972a(File from, File to, boolean deleteDestination) throws IOException {
        if (deleteDestination) {
            m36971a(to);
        }
        if (!from.renameTo(to)) {
            throw new IOException();
        }
    }

    public synchronized Snapshot get(String key) throws IOException {
        m36975b();
        m36977b(key);
        C11225a entry = (C11225a) this.f34290l.get(key);
        if (entry == null) {
            return null;
        }
        if (!entry.f34308c) {
            return null;
        }
        InputStream[] ins = new InputStream[this.f34287i];
        int i = 0;
        int i2 = 0;
        while (i2 < this.f34287i) {
            try {
                ins[i2] = new FileInputStream(entry.getCleanFile(i2));
                i2++;
            } catch (FileNotFoundException e) {
                while (i < this.f34287i && ins[i] != null) {
                    DiskLruCacheUtil.m37002a((Closeable) ins[i]);
                    i++;
                }
                return null;
            }
        }
        this.f34291m++;
        Writer writer = this.f34289k;
        StringBuilder sb = new StringBuilder();
        sb.append("READ ");
        sb.append(key);
        sb.append(10);
        writer.append(sb.toString());
        if (m36979c()) {
            this.f34293o.submit(this.f34294p);
        }
        Snapshot snapshot = new Snapshot(this, key, entry.f34310e, ins, entry.f34307b, null);
        return snapshot;
    }

    public Editor edit(String key) throws IOException {
        return m36965a(key, -1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.mopub.common.DiskLruCache.Editor m36965a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m36975b()     // Catch:{ all -> 0x0062 }
            r5.m36977b(r6)     // Catch:{ all -> 0x0062 }
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r0 = r5.f34290l     // Catch:{ all -> 0x0062 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0062 }
            com.mopub.common.DiskLruCache$a r0 = (com.mopub.common.DiskLruCache.C11225a) r0     // Catch:{ all -> 0x0062 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r1 = r0.f34310e     // Catch:{ all -> 0x0062 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r3
        L_0x0022:
            if (r0 != 0) goto L_0x0030
            com.mopub.common.DiskLruCache$a r1 = new com.mopub.common.DiskLruCache$a     // Catch:{ all -> 0x0062 }
            r1.<init>(r5, r6, r3)     // Catch:{ all -> 0x0062 }
            r0 = r1
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r1 = r5.f34290l     // Catch:{ all -> 0x0062 }
            r1.put(r6, r0)     // Catch:{ all -> 0x0062 }
            goto L_0x0038
        L_0x0030:
            com.mopub.common.DiskLruCache$Editor r1 = r0.f34309d     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0038
            monitor-exit(r5)
            return r3
        L_0x0038:
            com.mopub.common.DiskLruCache$Editor r1 = new com.mopub.common.DiskLruCache$Editor     // Catch:{ all -> 0x0062 }
            r1.<init>(r5, r0, r3)     // Catch:{ all -> 0x0062 }
            r0.f34309d = r1     // Catch:{ all -> 0x0062 }
            java.io.Writer r2 = r5.f34289k     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r3.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "DIRTY "
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            r3.append(r6)     // Catch:{ all -> 0x0062 }
            r4 = 10
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0062 }
            r2.write(r3)     // Catch:{ all -> 0x0062 }
            java.io.Writer r2 = r5.f34289k     // Catch:{ all -> 0x0062 }
            r2.flush()     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)
            return r1
        L_0x0062:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.DiskLruCache.m36965a(java.lang.String, long):com.mopub.common.DiskLruCache$Editor");
    }

    public File getDirectory() {
        return this.f34281c;
    }

    public synchronized long getMaxSize() {
        return this.f34286h;
    }

    public synchronized void setMaxSize(long maxSize) {
        this.f34286h = maxSize;
        this.f34293o.submit(this.f34294p);
    }

    public synchronized long size() {
        return this.f34288j;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010b, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m36969a(com.mopub.common.DiskLruCache.Editor r11, boolean r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            com.mopub.common.DiskLruCache$a r0 = r11.f34295a     // Catch:{ all -> 0x0112 }
            com.mopub.common.DiskLruCache$Editor r1 = r0.f34309d     // Catch:{ all -> 0x0112 }
            if (r1 != r11) goto L_0x010c
            r1 = 0
            if (r12 == 0) goto L_0x004d
            boolean r2 = r0.f34308c     // Catch:{ all -> 0x0112 }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r10.f34287i     // Catch:{ all -> 0x0112 }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r11.f34296b     // Catch:{ all -> 0x0112 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.getDirtyFile(r2)     // Catch:{ all -> 0x0112 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0112 }
            if (r3 != 0) goto L_0x0030
            r11.abort()     // Catch:{ all -> 0x0112 }
            monitor-exit(r10)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r11.abort()     // Catch:{ all -> 0x0112 }
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
            int r2 = r10.f34287i     // Catch:{ all -> 0x0112 }
            if (r1 >= r2) goto L_0x0083
            java.io.File r2 = r0.getDirtyFile(r1)     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x007d
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x0080
            java.io.File r3 = r0.getCleanFile(r1)     // Catch:{ all -> 0x0112 }
            r2.renameTo(r3)     // Catch:{ all -> 0x0112 }
            long[] r4 = r0.f34307b     // Catch:{ all -> 0x0112 }
            r5 = r4[r1]     // Catch:{ all -> 0x0112 }
            r4 = r5
            long r6 = r3.length()     // Catch:{ all -> 0x0112 }
            long[] r8 = r0.f34307b     // Catch:{ all -> 0x0112 }
            r8[r1] = r6     // Catch:{ all -> 0x0112 }
            long r8 = r10.f34288j     // Catch:{ all -> 0x0112 }
            long r8 = r8 - r4
            long r8 = r8 + r6
            r10.f34288j = r8     // Catch:{ all -> 0x0112 }
            goto L_0x0080
        L_0x007d:
            m36971a(r2)     // Catch:{ all -> 0x0112 }
        L_0x0080:
            int r1 = r1 + 1
            goto L_0x004e
        L_0x0083:
            int r1 = r10.f34291m     // Catch:{ all -> 0x0112 }
            r2 = 1
            int r1 = r1 + r2
            r10.f34291m = r1     // Catch:{ all -> 0x0112 }
            r1 = 0
            r0.f34309d = r1     // Catch:{ all -> 0x0112 }
            boolean r1 = r0.f34308c     // Catch:{ all -> 0x0112 }
            r1 = r1 | r12
            r3 = 10
            if (r1 == 0) goto L_0x00ca
            r0.f34308c = r2     // Catch:{ all -> 0x0112 }
            java.io.Writer r1 = r10.f34289k     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r2.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = "CLEAN "
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r0.f34306a     // Catch:{ all -> 0x0112 }
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r0.getLengths()     // Catch:{ all -> 0x0112 }
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            r2.append(r3)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0112 }
            r1.write(r2)     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x00f0
            long r1 = r10.f34292n     // Catch:{ all -> 0x0112 }
            r3 = 1
            long r3 = r3 + r1
            r10.f34292n = r3     // Catch:{ all -> 0x0112 }
            r0.f34310e = r1     // Catch:{ all -> 0x0112 }
            goto L_0x00f0
        L_0x00ca:
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r1 = r10.f34290l     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r0.f34306a     // Catch:{ all -> 0x0112 }
            r1.remove(r2)     // Catch:{ all -> 0x0112 }
            java.io.Writer r1 = r10.f34289k     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r2.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = "REMOVE "
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r0.f34306a     // Catch:{ all -> 0x0112 }
            r2.append(r4)     // Catch:{ all -> 0x0112 }
            r2.append(r3)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0112 }
            r1.write(r2)     // Catch:{ all -> 0x0112 }
        L_0x00f0:
            java.io.Writer r1 = r10.f34289k     // Catch:{ all -> 0x0112 }
            r1.flush()     // Catch:{ all -> 0x0112 }
            long r1 = r10.f34288j     // Catch:{ all -> 0x0112 }
            long r3 = r10.f34286h     // Catch:{ all -> 0x0112 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0103
            boolean r1 = r10.m36979c()     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x010a
        L_0x0103:
            java.util.concurrent.ThreadPoolExecutor r1 = r10.f34293o     // Catch:{ all -> 0x0112 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r10.f34294p     // Catch:{ all -> 0x0112 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.DiskLruCache.m36969a(com.mopub.common.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m36979c() {
        int i = this.f34291m;
        return i >= 2000 && i >= this.f34290l.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0091, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0093, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.m36975b()     // Catch:{ all -> 0x0094 }
            r8.m36977b(r9)     // Catch:{ all -> 0x0094 }
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r0 = r8.f34290l     // Catch:{ all -> 0x0094 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0094 }
            com.mopub.common.DiskLruCache$a r0 = (com.mopub.common.DiskLruCache.C11225a) r0     // Catch:{ all -> 0x0094 }
            r1 = 0
            if (r0 == 0) goto L_0x0092
            com.mopub.common.DiskLruCache$Editor r2 = r0.f34309d     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0092
        L_0x001a:
        L_0x001b:
            int r2 = r8.f34287i     // Catch:{ all -> 0x0094 }
            if (r1 >= r2) goto L_0x005d
            java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x0094 }
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
            long r3 = r8.f34288j     // Catch:{ all -> 0x0094 }
            long[] r5 = r0.f34307b     // Catch:{ all -> 0x0094 }
            r6 = r5[r1]     // Catch:{ all -> 0x0094 }
            long r3 = r3 - r6
            r8.f34288j = r3     // Catch:{ all -> 0x0094 }
            long[] r3 = r0.f34307b     // Catch:{ all -> 0x0094 }
            r4 = 0
            r3[r1] = r4     // Catch:{ all -> 0x0094 }
            int r1 = r1 + 1
            goto L_0x001b
        L_0x005d:
            int r1 = r8.f34291m     // Catch:{ all -> 0x0094 }
            r2 = 1
            int r1 = r1 + r2
            r8.f34291m = r1     // Catch:{ all -> 0x0094 }
            java.io.Writer r1 = r8.f34289k     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r3.<init>()     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = "REMOVE "
            r3.append(r4)     // Catch:{ all -> 0x0094 }
            r3.append(r9)     // Catch:{ all -> 0x0094 }
            r4 = 10
            r3.append(r4)     // Catch:{ all -> 0x0094 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0094 }
            r1.append(r3)     // Catch:{ all -> 0x0094 }
            java.util.LinkedHashMap<java.lang.String, com.mopub.common.DiskLruCache$a> r1 = r8.f34290l     // Catch:{ all -> 0x0094 }
            r1.remove(r9)     // Catch:{ all -> 0x0094 }
            boolean r1 = r8.m36979c()     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0090
            java.util.concurrent.ThreadPoolExecutor r1 = r8.f34293o     // Catch:{ all -> 0x0094 }
            java.util.concurrent.Callable<java.lang.Void> r3 = r8.f34294p     // Catch:{ all -> 0x0094 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized boolean isClosed() {
        return this.f34289k == null;
    }

    /* renamed from: b */
    private void m36975b() {
        if (this.f34289k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        m36975b();
        m36986g();
        this.f34289k.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f34289k != null) {
            Iterator it = new ArrayList(this.f34290l.values()).iterator();
            while (it.hasNext()) {
                C11225a entry = (C11225a) it.next();
                if (entry.f34309d != null) {
                    entry.f34309d.abort();
                }
            }
            m36986g();
            this.f34289k.close();
            this.f34289k = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m36986g() throws IOException {
        while (this.f34288j > this.f34286h) {
            remove((String) ((Entry) this.f34290l.entrySet().iterator().next()).getKey());
        }
    }

    public void delete() throws IOException {
        close();
        DiskLruCacheUtil.m37003a(this.f34281c);
    }

    /* renamed from: b */
    private void m36977b(String key) {
        if (!f34279a.matcher(key).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("keys must match regex [a-z0-9_-]{1,64}: \"");
            sb.append(key);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m36974b(InputStream in) throws IOException {
        return DiskLruCacheUtil.m37001a((Reader) new InputStreamReader(in, DiskLruCacheUtil.f34313b));
    }
}
