package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.load.C6145c;
import com.bumptech.glide.load.C6347j;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.p109a.C6041c;
import com.bumptech.glide.p107h.C6020e;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.p107h.p108a.C6013e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.load.c.a.c */
/* compiled from: BitmapEncoder */
public class C6149c implements C6351m<Bitmap> {

    /* renamed from: a */
    public static final C6347j<Integer> f10853a = C6347j.m12245a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));

    /* renamed from: b */
    public static final C6347j<CompressFormat> f10854b = C6347j.m12244a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: c */
    private final C6245b f10855c;

    public C6149c(C6245b arrayPool) {
        this.f10855c = arrayPool;
    }

    /* renamed from: a */
    public boolean mo18888a(C6236E<Bitmap> resource, File file, C6349k options) {
        OutputStream os;
        String str = "BitmapEncoder";
        Bitmap bitmap = (Bitmap) resource.get();
        CompressFormat format = m11619a(bitmap, options);
        C6013e.m11234a("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), format);
        try {
            long start = C6020e.m11250a();
            int quality = ((Integer) options.mo19310a(f10853a)).intValue();
            boolean success = false;
            os = null;
            try {
                OutputStream os2 = new FileOutputStream(file);
                if (this.f10855c != null) {
                    os2 = new C6041c(os2, this.f10855c);
                }
                bitmap.compress(format, quality, os2);
                os2.close();
                success = true;
                try {
                    os2.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to encode Bitmap", e2);
                }
                if (os != null) {
                    os.close();
                }
            }
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Compressed with type: ");
                sb.append(format);
                sb.append(" of size ");
                sb.append(C6026k.m11274a(bitmap));
                sb.append(" in ");
                sb.append(C6020e.m11249a(start));
                sb.append(", options format: ");
                sb.append(options.mo19310a(f10854b));
                sb.append(", hasAlpha: ");
                sb.append(bitmap.hasAlpha());
                Log.v(str, sb.toString());
            }
            C6013e.m11231a();
            return success;
        } catch (Throwable th) {
            C6013e.m11231a();
            throw th;
        }
    }

    /* renamed from: a */
    private CompressFormat m11619a(Bitmap bitmap, C6349k options) {
        CompressFormat format = (CompressFormat) options.mo19310a(f10854b);
        if (format != null) {
            return format;
        }
        if (bitmap.hasAlpha()) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }

    /* renamed from: a */
    public C6145c mo18974a(C6349k options) {
        return C6145c.TRANSFORMED;
    }
}
