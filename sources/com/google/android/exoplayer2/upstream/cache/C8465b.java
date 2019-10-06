package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.C8485g;
import com.google.android.exoplayer2.upstream.C8487i;
import com.google.android.exoplayer2.upstream.C8489j;
import com.google.android.exoplayer2.upstream.C8501u;
import com.google.android.exoplayer2.upstream.C8502v;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.upstream.cache.b */
/* compiled from: CacheDataSource */
public final class C8465b implements C8487i {

    /* renamed from: a */
    private final Cache f18645a;

    /* renamed from: b */
    private final C8487i f18646b;

    /* renamed from: c */
    private final C8487i f18647c;

    /* renamed from: d */
    private final C8487i f18648d;

    /* renamed from: e */
    private final C8468d f18649e;

    /* renamed from: f */
    private final C8466a f18650f;

    /* renamed from: g */
    private final boolean f18651g;

    /* renamed from: h */
    private final boolean f18652h;

    /* renamed from: i */
    private final boolean f18653i;

    /* renamed from: j */
    private C8487i f18654j;

    /* renamed from: k */
    private boolean f18655k;

    /* renamed from: l */
    private Uri f18656l;

    /* renamed from: m */
    private Uri f18657m;

    /* renamed from: n */
    private int f18658n;

    /* renamed from: o */
    private int f18659o;

    /* renamed from: p */
    private String f18660p;

    /* renamed from: q */
    private long f18661q;

    /* renamed from: r */
    private long f18662r;

    /* renamed from: s */
    private C8469e f18663s;

    /* renamed from: t */
    private boolean f18664t;

    /* renamed from: u */
    private boolean f18665u;

    /* renamed from: v */
    private long f18666v;

    /* renamed from: w */
    private long f18667w;

    /* renamed from: com.google.android.exoplayer2.upstream.cache.b$a */
    /* compiled from: CacheDataSource */
    public interface C8466a {
        /* renamed from: a */
        void mo25956a(int i);

        /* renamed from: a */
        void mo25957a(long j, long j2);
    }

    public C8465b(Cache cache, C8487i upstream) {
        this(cache, upstream, 0, 2097152);
    }

    public C8465b(Cache cache, C8487i upstream, int flags, long maxCacheFileSize) {
        this(cache, upstream, new FileDataSource(), new CacheDataSink(cache, maxCacheFileSize), flags, null);
    }

    public C8465b(Cache cache, C8487i upstream, C8487i cacheReadDataSource, C8485g cacheWriteDataSink, int flags, C8466a eventListener) {
        this(cache, upstream, cacheReadDataSource, cacheWriteDataSink, flags, eventListener, null);
    }

    public C8465b(Cache cache, C8487i upstream, C8487i cacheReadDataSource, C8485g cacheWriteDataSink, int flags, C8466a eventListener, C8468d cacheKeyFactory) {
        this.f18645a = cache;
        this.f18646b = cacheReadDataSource;
        this.f18649e = cacheKeyFactory != null ? cacheKeyFactory : C8470f.f18674a;
        boolean z = false;
        this.f18651g = (flags & 1) != 0;
        this.f18652h = (flags & 2) != 0;
        if ((flags & 4) != 0) {
            z = true;
        }
        this.f18653i = z;
        this.f18648d = upstream;
        if (cacheWriteDataSink != null) {
            this.f18647c = new C8501u(upstream, cacheWriteDataSink);
        } else {
            this.f18647c = null;
        }
        this.f18650f = eventListener;
    }

    /* renamed from: a */
    public void mo25955a(C8502v transferListener) {
        this.f18646b.mo25955a(transferListener);
        this.f18648d.mo25955a(transferListener);
    }

    /* renamed from: a */
    public long mo25917a(C8489j dataSpec) throws IOException {
        try {
            this.f18660p = this.f18649e.mo25953a(dataSpec);
            this.f18656l = dataSpec.f18714a;
            this.f18657m = m20199a(this.f18645a, this.f18660p, this.f18656l);
            this.f18658n = dataSpec.f18715b;
            this.f18659o = dataSpec.f18722i;
            this.f18661q = dataSpec.f18719f;
            int reason = m20203b(dataSpec);
            this.f18665u = reason != -1;
            if (this.f18665u) {
                m20200a(reason);
            }
            if (dataSpec.f18720g == -1) {
                if (!this.f18665u) {
                    this.f18662r = this.f18645a.mo25943b(this.f18660p);
                    if (this.f18662r != -1) {
                        this.f18662r -= dataSpec.f18719f;
                        if (this.f18662r <= 0) {
                            throw new DataSourceException(0);
                        }
                    }
                    m20202a(false);
                    return this.f18662r;
                }
            }
            this.f18662r = dataSpec.f18720g;
            m20202a(false);
            return this.f18662r;
        } catch (IOException e) {
            m20201a(e);
            throw e;
        }
    }

    public int read(byte[] buffer, int offset, int readLength) throws IOException {
        if (readLength == 0) {
            return 0;
        }
        if (this.f18662r == 0) {
            return -1;
        }
        try {
            if (this.f18661q >= this.f18667w) {
                m20202a(true);
            }
            int bytesRead = this.f18654j.read(buffer, offset, readLength);
            if (bytesRead != -1) {
                if (m20207d()) {
                    this.f18666v += (long) bytesRead;
                }
                this.f18661q += (long) bytesRead;
                if (this.f18662r != -1) {
                    this.f18662r -= (long) bytesRead;
                }
            } else if (this.f18655k) {
                m20211h();
            } else {
                if (this.f18662r <= 0) {
                    if (this.f18662r == -1) {
                    }
                }
                m20204b();
                m20202a(false);
                return read(buffer, offset, readLength);
            }
            return bytesRead;
        } catch (IOException e) {
            if (!this.f18655k || !m20205b(e)) {
                m20201a(e);
                throw e;
            }
            m20211h();
            return -1;
        }
    }

    public Uri getUri() {
        return this.f18657m;
    }

    /* renamed from: a */
    public Map<String, List<String>> mo25954a() {
        if (m20208e()) {
            return this.f18648d.mo25954a();
        }
        return Collections.emptyMap();
    }

    public void close() throws IOException {
        this.f18656l = null;
        this.f18657m = null;
        this.f18658n = 1;
        m20210g();
        try {
            m20204b();
        } catch (IOException e) {
            m20201a(e);
            throw e;
        }
    }

    /* renamed from: a */
    private void m20202a(boolean checkCache) throws IOException {
        C8469e nextSpan;
        C8489j nextDataSpec;
        C8469e nextSpan2;
        C8487i nextDataSource;
        long length;
        long length2;
        if (this.f18665u) {
            nextSpan = null;
        } else if (this.f18651g) {
            try {
                nextSpan = this.f18645a.mo25946c(this.f18660p, this.f18661q);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            nextSpan = this.f18645a.mo25944b(this.f18660p, this.f18661q);
        }
        if (nextSpan == null) {
            nextDataSource = this.f18648d;
            Uri uri = this.f18656l;
            int i = this.f18658n;
            long j = this.f18661q;
            C8489j jVar = new C8489j(uri, i, null, j, j, this.f18662r, this.f18660p, this.f18659o);
            nextDataSpec = jVar;
            nextSpan2 = nextSpan;
        } else if (nextSpan.f18671d) {
            Uri fileUri = Uri.fromFile(nextSpan.f18672e);
            long filePosition = this.f18661q - nextSpan.f18669b;
            long length3 = nextSpan.f18670c - filePosition;
            long j2 = this.f18662r;
            if (j2 != -1) {
                length2 = Math.min(length3, j2);
            } else {
                length2 = length3;
            }
            C8489j nextDataSpec2 = new C8489j(fileUri, this.f18661q, filePosition, length2, this.f18660p, this.f18659o);
            nextDataSource = this.f18646b;
            nextDataSpec = nextDataSpec2;
            nextSpan2 = nextSpan;
        } else {
            if (nextSpan.mo25963f()) {
                length = this.f18662r;
            } else {
                length = nextSpan.f18670c;
                long j3 = this.f18662r;
                if (j3 != -1) {
                    length = Math.min(length, j3);
                }
            }
            Uri uri2 = this.f18656l;
            int i2 = this.f18658n;
            long j4 = this.f18661q;
            nextDataSpec = new C8489j(uri2, i2, null, j4, j4, length, this.f18660p, this.f18659o);
            if (this.f18647c != null) {
                nextSpan2 = nextSpan;
                nextDataSource = this.f18647c;
            } else {
                C8487i nextDataSource2 = this.f18648d;
                this.f18645a.mo25939a(nextSpan);
                nextSpan2 = null;
                nextDataSource = nextDataSource2;
            }
        }
        this.f18667w = (this.f18665u || nextDataSource != this.f18648d) ? Long.MAX_VALUE : this.f18661q + 102400;
        if (checkCache) {
            C8514e.m20490b(m20206c());
            if (nextDataSource != this.f18648d) {
                try {
                    m20204b();
                } catch (Throwable th) {
                    Throwable e2 = th;
                    if (nextSpan2.mo25962e()) {
                        this.f18645a.mo25939a(nextSpan2);
                    }
                    throw e2;
                }
            } else {
                return;
            }
        }
        if (nextSpan2 != null && nextSpan2.mo25962e()) {
            this.f18663s = nextSpan2;
        }
        this.f18654j = nextDataSource;
        this.f18655k = nextDataSpec.f18720g == -1;
        long resolvedLength = nextDataSource.mo25917a(nextDataSpec);
        C8475k mutations = new C8475k();
        if (this.f18655k && resolvedLength != -1) {
            this.f18662r = resolvedLength;
            C8474j.m20259a(mutations, this.f18661q + this.f18662r);
        }
        if (m20208e()) {
            this.f18657m = this.f18654j.getUri();
            if (true ^ this.f18656l.equals(this.f18657m)) {
                C8474j.m20260a(mutations, this.f18657m);
            } else {
                C8474j.m20258a(mutations);
            }
        }
        if (m20209f()) {
            this.f18645a.mo25942a(this.f18660p, mutations);
        }
    }

    /* renamed from: h */
    private void m20211h() throws IOException {
        this.f18662r = 0;
        if (m20209f()) {
            this.f18645a.mo25941a(this.f18660p, this.f18661q);
        }
    }

    /* renamed from: a */
    private static Uri m20199a(Cache cache, String key, Uri defaultUri) {
        Uri redirectedUri = C8474j.m20261b(cache.mo25937a(key));
        return redirectedUri == null ? defaultUri : redirectedUri;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.io.IOException, code=java.lang.Throwable, for r3v0, types: [java.lang.Throwable, java.io.IOException] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m20205b(java.lang.Throwable r3) {
        /*
            r0 = r3
        L_0x0001:
            if (r0 == 0) goto L_0x0015
            boolean r1 = r0 instanceof com.google.android.exoplayer2.upstream.DataSourceException
            if (r1 == 0) goto L_0x0010
            r1 = r0
            com.google.android.exoplayer2.upstream.DataSourceException r1 = (com.google.android.exoplayer2.upstream.DataSourceException) r1
            int r1 = r1.f18593a
            if (r1 != 0) goto L_0x0010
            r2 = 1
            return r2
        L_0x0010:
            java.lang.Throwable r0 = r0.getCause()
            goto L_0x0001
        L_0x0015:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.C8465b.m20205b(java.io.IOException):boolean");
    }

    /* renamed from: e */
    private boolean m20208e() {
        return !m20207d();
    }

    /* renamed from: c */
    private boolean m20206c() {
        return this.f18654j == this.f18648d;
    }

    /* renamed from: d */
    private boolean m20207d() {
        return this.f18654j == this.f18646b;
    }

    /* renamed from: f */
    private boolean m20209f() {
        return this.f18654j == this.f18647c;
    }

    /* renamed from: b */
    private void m20204b() throws IOException {
        C8487i iVar = this.f18654j;
        if (iVar != null) {
            try {
                iVar.close();
            } finally {
                this.f18654j = null;
                this.f18655k = false;
                C8469e eVar = this.f18663s;
                if (eVar != null) {
                    this.f18645a.mo25939a(eVar);
                    this.f18663s = null;
                }
            }
        }
    }

    /* renamed from: a */
    private void m20201a(IOException exception) {
        if (m20207d() || (exception instanceof CacheException)) {
            this.f18664t = true;
        }
    }

    /* renamed from: b */
    private int m20203b(C8489j dataSpec) {
        if (this.f18652h && this.f18664t) {
            return 0;
        }
        if (!this.f18653i || dataSpec.f18720g != -1) {
            return -1;
        }
        return 1;
    }

    /* renamed from: a */
    private void m20200a(int reason) {
        C8466a aVar = this.f18650f;
        if (aVar != null) {
            aVar.mo25956a(reason);
        }
    }

    /* renamed from: g */
    private void m20210g() {
        C8466a aVar = this.f18650f;
        if (aVar != null && this.f18666v > 0) {
            aVar.mo25957a(this.f18645a.mo25936a(), this.f18666v);
            this.f18666v = 0;
        }
    }
}
