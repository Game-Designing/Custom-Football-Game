package com.smaato.soma.p261j.p262a;

import android.content.Context;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import java.io.File;
import java.io.IOException;

/* renamed from: com.smaato.soma.j.a.a */
/* compiled from: DiskCacheService */
class C12449a extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ Context f38864a;

    C12449a(Context context) {
        this.f38864a = context;
    }

    public Boolean process() throws Exception {
        File cacheDirectory = C12450b.m40933c(this.f38864a);
        if (cacheDirectory == null) {
            return Boolean.valueOf(false);
        }
        try {
            C12450b.f38865a = C12453e.m40937a(cacheDirectory, 1, 1, C12450b.m40925a(cacheDirectory));
        } catch (IOException e) {
            C12146d.m39965a(new C12147e("DiskCacheService", "DiskCacheServiceUnable to create DiskLruCache.", 1, C12143a.DEBUG));
        }
        return Boolean.valueOf(true);
    }
}
