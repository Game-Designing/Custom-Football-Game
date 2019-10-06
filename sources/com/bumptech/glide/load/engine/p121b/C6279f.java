package com.bumptech.glide.load.engine.p121b;

import android.content.Context;
import com.bumptech.glide.load.engine.p121b.C6276d.C6277a;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.b.f */
/* compiled from: InternalCacheDiskCacheFactory */
class C6279f implements C6277a {

    /* renamed from: a */
    final /* synthetic */ Context f11108a;

    /* renamed from: b */
    final /* synthetic */ String f11109b;

    C6279f(Context context, String str) {
        this.f11108a = context;
        this.f11109b = str;
    }

    public File getCacheDirectory() {
        File cacheDirectory = this.f11108a.getCacheDir();
        if (cacheDirectory == null) {
            return null;
        }
        String str = this.f11109b;
        if (str != null) {
            return new File(cacheDirectory, str);
        }
        return cacheDirectory;
    }
}
