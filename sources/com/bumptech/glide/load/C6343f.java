package com.bumptech.glide.load;

import com.bumptech.glide.load.C6230e.C6231a;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.p113c.p114a.C6177s;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.bumptech.glide.load.f */
/* compiled from: ImageHeaderParserUtils */
public final class C6343f {
    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public static C6231a m12242b(List<C6230e> parsers, InputStream is, C6245b byteArrayPool) throws IOException {
        if (is == null) {
            return C6231a.UNKNOWN;
        }
        if (!is.markSupported()) {
            is = new C6177s(is, byteArrayPool);
        }
        is.mark(5242880);
        int i = 0;
        int size = parsers.size();
        while (i < size) {
            try {
                C6231a type = ((C6230e) parsers.get(i)).mo18981a(is);
                if (type != C6231a.UNKNOWN) {
                    is.reset();
                    return type;
                }
                is.reset();
                i++;
            } catch (Throwable th) {
                is.reset();
                throw th;
            }
        }
        return C6231a.UNKNOWN;
    }

    /* renamed from: a */
    public static C6231a m12241a(List<C6230e> parsers, ByteBuffer buffer) throws IOException {
        if (buffer == null) {
            return C6231a.UNKNOWN;
        }
        int size = parsers.size();
        for (int i = 0; i < size; i++) {
            C6231a type = ((C6230e) parsers.get(i)).mo18982a(buffer);
            if (type != C6231a.UNKNOWN) {
                return type;
            }
        }
        return C6231a.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static int m12240a(List<C6230e> parsers, InputStream is, C6245b byteArrayPool) throws IOException {
        if (is == null) {
            return -1;
        }
        if (!is.markSupported()) {
            is = new C6177s(is, byteArrayPool);
        }
        is.mark(5242880);
        int i = 0;
        int size = parsers.size();
        while (i < size) {
            try {
                int orientation = ((C6230e) parsers.get(i)).mo18980a(is, byteArrayPool);
                if (orientation != -1) {
                    is.reset();
                    return orientation;
                }
                is.reset();
                i++;
            } catch (Throwable th) {
                is.reset();
                throw th;
            }
        }
        return -1;
    }
}
