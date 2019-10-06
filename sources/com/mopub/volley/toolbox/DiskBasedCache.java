package com.mopub.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.volley.Cache;
import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Header;
import com.mopub.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiskBasedCache implements Cache {

    /* renamed from: a */
    private final Map<String, C11690a> f36487a;

    /* renamed from: b */
    private long f36488b;

    /* renamed from: c */
    private final File f36489c;

    /* renamed from: d */
    private final int f36490d;

    /* renamed from: com.mopub.volley.toolbox.DiskBasedCache$a */
    static class C11690a {

        /* renamed from: a */
        long f36491a;

        /* renamed from: b */
        final String f36492b;

        /* renamed from: c */
        final String f36493c;

        /* renamed from: d */
        final long f36494d;

        /* renamed from: e */
        final long f36495e;

        /* renamed from: f */
        final long f36496f;

        /* renamed from: g */
        final long f36497g;

        /* renamed from: h */
        final List<Header> f36498h;

        private C11690a(String key, String etag, long serverDate, long lastModified, long ttl, long softTtl, List<Header> allResponseHeaders) {
            this.f36492b = key;
            this.f36493c = "".equals(etag) ? null : etag;
            this.f36494d = serverDate;
            this.f36495e = lastModified;
            this.f36496f = ttl;
            this.f36497g = softTtl;
            this.f36498h = allResponseHeaders;
        }

        C11690a(String key, Entry entry) {
            this(key, entry.etag, entry.serverDate, entry.lastModified, entry.ttl, entry.softTtl, m38632a(entry));
        }

        /* renamed from: a */
        private static List<Header> m38632a(Entry entry) {
            List<Header> list = entry.allResponseHeaders;
            if (list != null) {
                return list;
            }
            return HttpHeaderParser.m38638a(entry.responseHeaders);
        }

        /* renamed from: a */
        static C11690a m38631a(C11691b is) throws IOException {
            if (DiskBasedCache.m38615a((InputStream) is) == 538247942) {
                C11690a aVar = new C11690a(DiskBasedCache.m38626b(is), DiskBasedCache.m38626b(is), DiskBasedCache.m38625b((InputStream) is), DiskBasedCache.m38625b((InputStream) is), DiskBasedCache.m38625b((InputStream) is), DiskBasedCache.m38625b((InputStream) is), DiskBasedCache.m38617a(is));
                return aVar;
            }
            throw new IOException();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Entry mo38445a(byte[] data) {
            Entry e = new Entry();
            e.data = data;
            e.etag = this.f36493c;
            e.serverDate = this.f36494d;
            e.lastModified = this.f36495e;
            e.ttl = this.f36496f;
            e.softTtl = this.f36497g;
            e.responseHeaders = HttpHeaderParser.m38639a(this.f36498h);
            e.allResponseHeaders = Collections.unmodifiableList(this.f36498h);
            return e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo38446a(OutputStream os) {
            try {
                DiskBasedCache.m38619a(os, 538247942);
                DiskBasedCache.m38621a(os, this.f36492b);
                DiskBasedCache.m38621a(os, this.f36493c == null ? "" : this.f36493c);
                DiskBasedCache.m38620a(os, this.f36494d);
                DiskBasedCache.m38620a(os, this.f36495e);
                DiskBasedCache.m38620a(os, this.f36496f);
                DiskBasedCache.m38620a(os, this.f36497g);
                DiskBasedCache.m38623a(this.f36498h, os);
                os.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.m38603d("%s", e.toString());
                return false;
            }
        }
    }

    /* renamed from: com.mopub.volley.toolbox.DiskBasedCache$b */
    static class C11691b extends FilterInputStream {

        /* renamed from: a */
        private final long f36499a;

        /* renamed from: b */
        private long f36500b;

        C11691b(InputStream in, long length) {
            super(in);
            this.f36499a = length;
        }

        public int read() throws IOException {
            int result = super.read();
            if (result != -1) {
                this.f36500b++;
            }
            return result;
        }

        public int read(byte[] buffer, int offset, int count) throws IOException {
            int result = super.read(buffer, offset, count);
            if (result != -1) {
                this.f36500b += (long) result;
            }
            return result;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public long mo38447a() {
            return this.f36499a - this.f36500b;
        }
    }

    public DiskBasedCache(File rootDirectory, int maxCacheSizeInBytes) {
        this.f36487a = new LinkedHashMap(16, 0.75f, true);
        this.f36488b = 0;
        this.f36489c = rootDirectory;
        this.f36490d = maxCacheSizeInBytes;
    }

    public DiskBasedCache(File rootDirectory) {
        this(rootDirectory, 5242880);
    }

    public synchronized void clear() {
        File[] files = this.f36489c.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
        this.f36487a.clear();
        this.f36488b = 0;
        VolleyLog.m38603d("Cache cleared.", new Object[0]);
    }

    public synchronized Entry get(String key) {
        C11691b cis;
        C11690a entry = (C11690a) this.f36487a.get(key);
        if (entry == null) {
            return null;
        }
        File file = getFileForKey(key);
        try {
            cis = new C11691b(new BufferedInputStream(mo38442a(file)), file.length());
            C11690a entryOnDisk = C11690a.m38631a(cis);
            if (!TextUtils.equals(key, entryOnDisk.f36492b)) {
                VolleyLog.m38603d("%s: key=%s, found=%s", file.getAbsolutePath(), key, entryOnDisk.f36492b);
                m38627b(key);
                cis.close();
                return null;
            }
            Entry a = entry.mo38445a(m38624a(cis, cis.mo38447a()));
            cis.close();
            return a;
        } catch (IOException e) {
            VolleyLog.m38603d("%s: %s", file.getAbsolutePath(), e.toString());
            remove(key);
            return null;
        } catch (Throwable th) {
            cis.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.io.File r0 = r9.f36489c     // Catch:{ all -> 0x0063 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0063 }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r9.f36489c     // Catch:{ all -> 0x0063 }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x0063 }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0063 }
            java.io.File r3 = r9.f36489c     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0063 }
            r2[r1] = r3     // Catch:{ all -> 0x0063 }
            com.mopub.volley.VolleyLog.m38604e(r0, r2)     // Catch:{ all -> 0x0063 }
        L_0x0022:
            monitor-exit(r9)
            return
        L_0x0024:
            java.io.File r0 = r9.f36489c     // Catch:{ all -> 0x0063 }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0063 }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x0063 }
        L_0x002f:
            if (r1 >= r2) goto L_0x0061
            r3 = r0[r1]     // Catch:{ all -> 0x0063 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x005a }
            com.mopub.volley.toolbox.DiskBasedCache$b r6 = new com.mopub.volley.toolbox.DiskBasedCache$b     // Catch:{ IOException -> 0x005a }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005a }
            java.io.InputStream r8 = r9.mo38442a(r3)     // Catch:{ IOException -> 0x005a }
            r7.<init>(r8)     // Catch:{ IOException -> 0x005a }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x005a }
            com.mopub.volley.toolbox.DiskBasedCache$a r7 = com.mopub.volley.toolbox.DiskBasedCache.C11690a.m38631a(r6)     // Catch:{ all -> 0x0055 }
            r7.f36491a = r4     // Catch:{ all -> 0x0055 }
            java.lang.String r8 = r7.f36492b     // Catch:{ all -> 0x0055 }
            r9.m38622a(r8, r7)     // Catch:{ all -> 0x0055 }
            r6.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x0055:
            r7 = move-exception
            r6.close()     // Catch:{ IOException -> 0x005a }
            throw r7     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            r4 = move-exception
            r3.delete()     // Catch:{ all -> 0x0063 }
        L_0x005e:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x0061:
            monitor-exit(r9)
            return
        L_0x0063:
            r0 = move-exception
            monitor-exit(r9)
            goto L_0x0067
        L_0x0066:
            throw r0
        L_0x0067:
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.DiskBasedCache.initialize():void");
    }

    public synchronized void invalidate(String key, boolean fullExpire) {
        Entry entry = get(key);
        if (entry != null) {
            entry.softTtl = 0;
            if (fullExpire) {
                entry.ttl = 0;
            }
            put(key, entry);
        }
    }

    public synchronized void put(String key, Entry entry) {
        if (this.f36488b + ((long) entry.data.length) <= ((long) this.f36490d) || ((float) entry.data.length) <= ((float) this.f36490d) * 0.9f) {
            File file = getFileForKey(key);
            try {
                BufferedOutputStream fos = new BufferedOutputStream(mo38443b(file));
                C11690a e = new C11690a(key, entry);
                if (e.mo38446a((OutputStream) fos)) {
                    fos.write(entry.data);
                    fos.close();
                    e.f36491a = file.length();
                    m38622a(key, e);
                    m38618a();
                    return;
                }
                fos.close();
                VolleyLog.m38603d("Failed to write header for %s", file.getAbsolutePath());
                throw new IOException();
            } catch (IOException e2) {
                if (!file.delete()) {
                    VolleyLog.m38603d("Could not clean up file %s", file.getAbsolutePath());
                }
            }
        }
    }

    public synchronized void remove(String key) {
        boolean deleted = getFileForKey(key).delete();
        m38627b(key);
        if (!deleted) {
            VolleyLog.m38603d("Could not delete cache entry for key=%s, filename=%s", key, m38616a(key));
        }
    }

    /* renamed from: a */
    private String m38616a(String key) {
        int firstHalfLength = key.length() / 2;
        String localFilename = String.valueOf(key.substring(0, firstHalfLength).hashCode());
        StringBuilder sb = new StringBuilder();
        sb.append(localFilename);
        sb.append(String.valueOf(key.substring(firstHalfLength).hashCode()));
        return sb.toString();
    }

    public File getFileForKey(String key) {
        return new File(this.f36489c, m38616a(key));
    }

    /* renamed from: a */
    private void m38618a() {
        long before;
        if (this.f36488b >= ((long) this.f36490d)) {
            if (VolleyLog.DEBUG) {
                VolleyLog.m38606v("Pruning old cache entries.", new Object[0]);
            }
            long before2 = this.f36488b;
            int prunedFiles = 0;
            long startTime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, CacheHeader>> iterator = this.f36487a.entrySet().iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    before = before2;
                    break;
                }
                C11690a e = (C11690a) ((Map.Entry) iterator.next()).getValue();
                if (getFileForKey(e.f36492b).delete()) {
                    before = before2;
                    this.f36488b -= e.f36491a;
                } else {
                    before = before2;
                    String str = e.f36492b;
                    VolleyLog.m38603d("Could not delete cache entry for key=%s, filename=%s", str, m38616a(str));
                }
                iterator.remove();
                prunedFiles++;
                if (((float) this.f36488b) < ((float) this.f36490d) * 0.9f) {
                    break;
                }
                before2 = before;
            }
            if (VolleyLog.DEBUG) {
                VolleyLog.m38606v("pruned %d files, %d bytes, %d ms", Integer.valueOf(prunedFiles), Long.valueOf(this.f36488b - before), Long.valueOf(SystemClock.elapsedRealtime() - startTime));
            }
        }
    }

    /* renamed from: a */
    private void m38622a(String key, C11690a entry) {
        if (!this.f36487a.containsKey(key)) {
            this.f36488b += entry.f36491a;
        } else {
            this.f36488b += entry.f36491a - ((C11690a) this.f36487a.get(key)).f36491a;
        }
        this.f36487a.put(key, entry);
    }

    /* renamed from: b */
    private void m38627b(String key) {
        C11690a removed = (C11690a) this.f36487a.remove(key);
        if (removed != null) {
            this.f36488b -= removed.f36491a;
        }
    }

    /* renamed from: a */
    static byte[] m38624a(C11691b cis, long length) throws IOException {
        long maxLength = cis.mo38447a();
        if (length < 0 || length > maxLength || ((long) ((int) length)) != length) {
            StringBuilder sb = new StringBuilder();
            sb.append("streamToBytes length=");
            sb.append(length);
            sb.append(", maxLength=");
            sb.append(maxLength);
            throw new IOException(sb.toString());
        }
        byte[] bytes = new byte[((int) length)];
        new DataInputStream(cis).readFully(bytes);
        return bytes;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public InputStream mo38442a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public OutputStream mo38443b(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    /* renamed from: c */
    private static int m38628c(InputStream is) throws IOException {
        int b = is.read();
        if (b != -1) {
            return b;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    static void m38619a(OutputStream os, int n) throws IOException {
        os.write((n >> 0) & 255);
        os.write((n >> 8) & 255);
        os.write((n >> 16) & 255);
        os.write((n >> 24) & 255);
    }

    /* renamed from: a */
    static int m38615a(InputStream is) throws IOException {
        return 0 | (m38628c(is) << 0) | (m38628c(is) << 8) | (m38628c(is) << 16) | (m38628c(is) << 24);
    }

    /* renamed from: a */
    static void m38620a(OutputStream os, long n) throws IOException {
        os.write((byte) ((int) (n >>> 0)));
        os.write((byte) ((int) (n >>> 8)));
        os.write((byte) ((int) (n >>> 16)));
        os.write((byte) ((int) (n >>> 24)));
        os.write((byte) ((int) (n >>> 32)));
        os.write((byte) ((int) (n >>> 40)));
        os.write((byte) ((int) (n >>> 48)));
        os.write((byte) ((int) (n >>> 56)));
    }

    /* renamed from: b */
    static long m38625b(InputStream is) throws IOException {
        return 0 | ((((long) m38628c(is)) & 255) << 0) | ((((long) m38628c(is)) & 255) << 8) | ((((long) m38628c(is)) & 255) << 16) | ((((long) m38628c(is)) & 255) << 24) | ((((long) m38628c(is)) & 255) << 32) | ((((long) m38628c(is)) & 255) << 40) | ((((long) m38628c(is)) & 255) << 48) | ((((long) m38628c(is)) & 255) << 56);
    }

    /* renamed from: a */
    static void m38621a(OutputStream os, String s) throws IOException {
        byte[] b = s.getBytes("UTF-8");
        m38620a(os, (long) b.length);
        os.write(b, 0, b.length);
    }

    /* renamed from: b */
    static String m38626b(C11691b cis) throws IOException {
        return new String(m38624a(cis, m38625b((InputStream) cis)), "UTF-8");
    }

    /* renamed from: a */
    static void m38623a(List<Header> headers, OutputStream os) throws IOException {
        if (headers != null) {
            m38619a(os, headers.size());
            for (Header header : headers) {
                m38621a(os, header.getName());
                m38621a(os, header.getValue());
            }
            return;
        }
        m38619a(os, 0);
    }

    /* renamed from: a */
    static List<Header> m38617a(C11691b cis) throws IOException {
        int size = m38615a((InputStream) cis);
        if (size >= 0) {
            List<Header> result = size == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < size; i++) {
                result.add(new Header(m38626b(cis).intern(), m38626b(cis).intern()));
            }
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("readHeaderList size=");
        sb.append(size);
        throw new IOException(sb.toString());
    }
}
