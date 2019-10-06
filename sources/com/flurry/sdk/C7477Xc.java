package com.flurry.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.flurry.sdk.Xc */
public final class C7477Xc<ObjectType> extends C7473Wc<ObjectType> {
    public C7477Xc(C7493ad<ObjectType> adVar) {
        super(adVar);
    }

    /* renamed from: a */
    public final void mo23856a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                try {
                    super.mo23856a(gZIPOutputStream2, objecttype);
                    C7354Ad.m16261a((Closeable) gZIPOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    C7354Ad.m16261a((Closeable) gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C7354Ad.m16261a((Closeable) gZIPOutputStream);
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final ObjectType mo23855a(InputStream inputStream) throws IOException {
        GZIPInputStream gZIPInputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                ObjectType a = super.mo23855a(gZIPInputStream2);
                C7354Ad.m16261a((Closeable) gZIPInputStream2);
                return a;
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                C7354Ad.m16261a((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C7354Ad.m16261a((Closeable) gZIPInputStream);
            throw th;
        }
    }
}
