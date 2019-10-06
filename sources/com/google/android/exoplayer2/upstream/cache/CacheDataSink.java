package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.C8485g;
import com.google.android.exoplayer2.upstream.C8489j;
import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8538w;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements C8485g {

    /* renamed from: a */
    private final Cache f18633a;

    /* renamed from: b */
    private final long f18634b;

    /* renamed from: c */
    private final int f18635c;

    /* renamed from: d */
    private boolean f18636d;

    /* renamed from: e */
    private C8489j f18637e;

    /* renamed from: f */
    private File f18638f;

    /* renamed from: g */
    private OutputStream f18639g;

    /* renamed from: h */
    private FileOutputStream f18640h;

    /* renamed from: i */
    private long f18641i;

    /* renamed from: j */
    private long f18642j;

    /* renamed from: k */
    private C8538w f18643k;

    public static class CacheDataSinkException extends CacheException {
        public CacheDataSinkException(IOException cause) {
            super((Throwable) cause);
        }
    }

    public CacheDataSink(Cache cache, long maxCacheFileSize) {
        this(cache, maxCacheFileSize, 20480);
    }

    public CacheDataSink(Cache cache, long maxCacheFileSize, int bufferSize) {
        C8514e.m20486a(cache);
        this.f18633a = cache;
        this.f18634b = maxCacheFileSize;
        this.f18635c = bufferSize;
        this.f18636d = true;
    }

    /* renamed from: a */
    public void mo25950a(C8489j dataSpec) throws CacheDataSinkException {
        if (dataSpec.f18720g != -1 || dataSpec.mo26019b(2)) {
            this.f18637e = dataSpec;
            this.f18642j = 0;
            try {
                m20196b();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        } else {
            this.f18637e = null;
        }
    }

    public void write(byte[] buffer, int offset, int length) throws CacheDataSinkException {
        if (this.f18637e != null) {
            int bytesWritten = 0;
            while (bytesWritten < length) {
                try {
                    if (this.f18641i == this.f18634b) {
                        m20195a();
                        m20196b();
                    }
                    int bytesToWrite = (int) Math.min((long) (length - bytesWritten), this.f18634b - this.f18641i);
                    this.f18639g.write(buffer, offset + bytesWritten, bytesToWrite);
                    bytesWritten += bytesToWrite;
                    this.f18641i += (long) bytesToWrite;
                    this.f18642j += (long) bytesToWrite;
                } catch (IOException e) {
                    throw new CacheDataSinkException(e);
                }
            }
        }
    }

    public void close() throws CacheDataSinkException {
        if (this.f18637e != null) {
            try {
                m20195a();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    /* renamed from: b */
    private void m20196b() throws IOException {
        long maxLength;
        long j = this.f18637e.f18720g;
        if (j == -1) {
            maxLength = this.f18634b;
        } else {
            maxLength = Math.min(j - this.f18642j, this.f18634b);
        }
        Cache cache = this.f18633a;
        C8489j jVar = this.f18637e;
        this.f18638f = cache.mo25938a(jVar.f18721h, this.f18642j + jVar.f18718e, maxLength);
        this.f18640h = new FileOutputStream(this.f18638f);
        int i = this.f18635c;
        if (i > 0) {
            C8538w wVar = this.f18643k;
            if (wVar == null) {
                this.f18643k = new C8538w(this.f18640h, i);
            } else {
                wVar.mo26149a(this.f18640h);
            }
            this.f18639g = this.f18643k;
        } else {
            this.f18639g = this.f18640h;
        }
        this.f18641i = 0;
    }

    /* renamed from: a */
    private void m20195a() throws IOException {
        File fileToCommit;
        OutputStream outputStream = this.f18639g;
        if (outputStream != null) {
            boolean success = false;
            try {
                outputStream.flush();
                if (this.f18636d) {
                    this.f18640h.getFD().sync();
                }
                success = true;
            } finally {
                C8509F.m20451a((Closeable) this.f18639g);
                this.f18639g = null;
                fileToCommit = this.f18638f;
                this.f18638f = null;
                if (success) {
                    this.f18633a.mo25940a(fileToCommit);
                } else {
                    fileToCommit.delete();
                }
            }
        }
    }
}
