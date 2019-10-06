package com.bumptech.glide.load.engine.p122c;

import android.util.Log;
import com.bumptech.glide.load.engine.p122c.C6295b.C6297b;

/* renamed from: com.bumptech.glide.load.engine.c.d */
/* compiled from: GlideExecutor */
class C6299d implements C6297b {
    C6299d() {
    }

    /* renamed from: a */
    public void mo19224a(Throwable t) {
        if (t != null) {
            String str = "GlideExecutor";
            if (Log.isLoggable(str, 6)) {
                Log.e(str, "Request threw uncaught throwable", t);
            }
        }
    }
}
