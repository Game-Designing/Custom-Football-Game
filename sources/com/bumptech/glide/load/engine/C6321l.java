package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6145c;

/* renamed from: com.bumptech.glide.load.engine.l */
/* compiled from: DiskCacheStrategy */
class C6321l extends C6326q {
    C6321l() {
    }

    /* renamed from: a */
    public boolean mo19274a(C6031a dataSource) {
        return dataSource == C6031a.REMOTE;
    }

    /* renamed from: a */
    public boolean mo19275a(boolean isFromAlternateCacheKey, C6031a dataSource, C6145c encodeStrategy) {
        return (dataSource == C6031a.RESOURCE_DISK_CACHE || dataSource == C6031a.MEMORY_CACHE) ? false : true;
    }

    /* renamed from: b */
    public boolean mo19276b() {
        return true;
    }

    /* renamed from: a */
    public boolean mo19273a() {
        return true;
    }
}
