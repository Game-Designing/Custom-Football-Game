package com.google.android.exoplayer2.upstream.cache;

import java.io.File;
import java.io.IOException;

public interface Cache {

    public static class CacheException extends IOException {
        public CacheException(String message) {
            super(message);
        }

        public CacheException(Throwable cause) {
            super(cause);
        }
    }

    /* renamed from: com.google.android.exoplayer2.upstream.cache.Cache$a */
    public interface C8463a {
        /* renamed from: a */
        void mo25947a(Cache cache, C8469e eVar);

        /* renamed from: a */
        void mo25948a(Cache cache, C8469e eVar, C8469e eVar2);

        /* renamed from: b */
        void mo25949b(Cache cache, C8469e eVar);
    }

    /* renamed from: a */
    long mo25936a();

    /* renamed from: a */
    C8473i mo25937a(String str);

    /* renamed from: a */
    File mo25938a(String str, long j, long j2) throws CacheException;

    /* renamed from: a */
    void mo25939a(C8469e eVar);

    /* renamed from: a */
    void mo25940a(File file) throws CacheException;

    /* renamed from: a */
    void mo25941a(String str, long j) throws CacheException;

    /* renamed from: a */
    void mo25942a(String str, C8475k kVar) throws CacheException;

    /* renamed from: b */
    long mo25943b(String str);

    /* renamed from: b */
    C8469e mo25944b(String str, long j) throws CacheException;

    /* renamed from: b */
    void mo25945b(C8469e eVar) throws CacheException;

    /* renamed from: c */
    C8469e mo25946c(String str, long j) throws InterruptedException, CacheException;
}
