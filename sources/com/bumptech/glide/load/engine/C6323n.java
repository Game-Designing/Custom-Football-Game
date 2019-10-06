package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6145c;

/* renamed from: com.bumptech.glide.load.engine.n */
/* compiled from: DiskCacheStrategy */
class C6323n extends C6326q {
    C6323n() {
    }

    /* renamed from: a */
    public boolean mo19274a(C6031a dataSource) {
        return (dataSource == C6031a.DATA_DISK_CACHE || dataSource == C6031a.MEMORY_CACHE) ? false : true;
    }

    /* renamed from: a */
    public boolean mo19275a(boolean isFromAlternateCacheKey, C6031a dataSource, C6145c encodeStrategy) {
        return false;
    }

    /* renamed from: b */
    public boolean mo19276b() {
        return false;
    }

    /* renamed from: a */
    public boolean mo19273a() {
        return true;
    }
}
