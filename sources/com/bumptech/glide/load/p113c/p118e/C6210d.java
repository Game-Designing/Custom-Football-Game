package com.bumptech.glide.load.p113c.p118e;

import android.util.Log;
import com.bumptech.glide.load.C6145c;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.p107h.C6002a;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.c.e.d */
/* compiled from: GifDrawableEncoder */
public class C6210d implements C6351m<C6208c> {
    /* renamed from: a */
    public C6145c mo18974a(C6349k options) {
        return C6145c.SOURCE;
    }

    /* renamed from: a */
    public boolean mo18888a(C6236E<C6208c> data, File file, C6349k options) {
        try {
            C6002a.m11213a(((C6208c) data.get()).mo19046b(), file);
            return true;
        } catch (IOException e) {
            String str = "GifEncoder";
            if (!Log.isLoggable(str, 5)) {
                return false;
            }
            Log.w(str, "Failed to encode GIF drawable data", e);
            return false;
        }
    }
}
