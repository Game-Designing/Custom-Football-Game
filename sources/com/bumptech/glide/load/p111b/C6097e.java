package com.bumptech.glide.load.p111b;

import android.util.Log;
import com.bumptech.glide.load.C6229d;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.p107h.C6002a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.e */
/* compiled from: ByteBufferEncoder */
public class C6097e implements C6229d<ByteBuffer> {
    /* renamed from: a */
    public boolean mo18888a(ByteBuffer data, File file, C6349k options) {
        try {
            C6002a.m11213a(data, file);
            return true;
        } catch (IOException e) {
            String str = "ByteBufferEncoder";
            if (!Log.isLoggable(str, 3)) {
                return false;
            }
            Log.d(str, "Failed to write data", e);
            return false;
        }
    }
}
