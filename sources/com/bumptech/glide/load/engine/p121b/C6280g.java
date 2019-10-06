package com.bumptech.glide.load.engine.p121b;

import android.content.Context;

/* renamed from: com.bumptech.glide.load.engine.b.g */
/* compiled from: InternalCacheDiskCacheFactory */
public final class C6280g extends C6276d {
    public C6280g(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public C6280g(Context context, String diskCacheName, long diskCacheSize) {
        super(new C6279f(context, diskCacheName), diskCacheSize);
    }
}
