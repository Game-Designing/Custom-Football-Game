package com.bumptech.glide.load.p111b;

import android.util.Log;
import com.bumptech.glide.load.C6229d;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.engine.p120a.C6245b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.A */
/* compiled from: StreamEncoder */
public class C6061A implements C6229d<InputStream> {

    /* renamed from: a */
    private final C6245b f10742a;

    public C6061A(C6245b byteArrayPool) {
        this.f10742a = byteArrayPool;
    }

    /* renamed from: a */
    public boolean mo18888a(InputStream data, File file, C6349k options) {
        String str = "StreamEncoder";
        byte[] buffer = (byte[]) this.f10742a.mo19127a(65536, byte[].class);
        boolean success = false;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            while (true) {
                int read = data.read(buffer);
                int read2 = read;
                if (read == -1) {
                    break;
                }
                fileOutputStream2.write(buffer, 0, read2);
            }
            fileOutputStream2.close();
            success = true;
            try {
                fileOutputStream2.close();
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to encode data onto the OutputStream", e2);
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                }
            }
            this.f10742a.put(buffer);
            throw th;
        }
        this.f10742a.put(buffer);
        return success;
    }
}
