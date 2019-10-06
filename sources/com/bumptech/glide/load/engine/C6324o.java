package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6145c;

/* renamed from: com.bumptech.glide.load.engine.o */
/* compiled from: DiskCacheStrategy */
class C6324o extends C6326q {
    C6324o() {
    }

    /* renamed from: a */
    public boolean mo19274a(C6031a dataSource) {
        return false;
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
        return false;
    }
}
