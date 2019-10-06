package com.bumptech.glide.load.engine.p121b;

import com.bumptech.glide.load.engine.p121b.C6269a.C6270a;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.b.d */
/* compiled from: DiskLruCacheFactory */
public class C6276d implements C6270a {

    /* renamed from: a */
    private final long f11101a;

    /* renamed from: b */
    private final C6277a f11102b;

    /* renamed from: com.bumptech.glide.load.engine.b.d$a */
    /* compiled from: DiskLruCacheFactory */
    public interface C6277a {
        File getCacheDirectory();
    }

    public C6276d(C6277a cacheDirectoryGetter, long diskCacheSize) {
        this.f11101a = diskCacheSize;
        this.f11102b = cacheDirectoryGetter;
    }

    public C6269a build() {
        File cacheDir = this.f11102b.getCacheDirectory();
        if (cacheDir == null) {
            return null;
        }
        if (cacheDir.mkdirs() || (cacheDir.exists() && cacheDir.isDirectory())) {
            return C6278e.m12040a(cacheDir, this.f11101a);
        }
        return null;
    }
}
