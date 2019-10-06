package com.mopub.nativeads;

import android.content.Context;
import com.google.android.exoplayer2.upstream.cache.C8477m;
import com.google.android.exoplayer2.upstream.cache.C8479o;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DeviceUtils;
import java.io.File;

/* renamed from: com.mopub.nativeads.L */
/* compiled from: MoPubCache */
class C11541L {

    /* renamed from: a */
    private static volatile Cache f35770a = null;

    C11541L() {
    }

    /* renamed from: a */
    static Cache m38197a(Context context) {
        Preconditions.checkNotNull(context);
        Cache instance = f35770a;
        if (instance == null) {
            synchronized (C11541L.class) {
                instance = f35770a;
                if (instance == null) {
                    File cacheDir = context.getApplicationContext().getCacheDir();
                    if (cacheDir != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(cacheDir.getPath());
                        sb.append(File.separator);
                        sb.append("mopub-native-cache");
                        instance = new C8479o(new File(sb.toString()), new C8477m(DeviceUtils.diskCacheSizeBytes(cacheDir)));
                        f35770a = instance;
                    }
                }
            }
        }
        return instance;
    }
}
