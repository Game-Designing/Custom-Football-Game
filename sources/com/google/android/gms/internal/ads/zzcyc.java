package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public final class zzcyc {
    /* renamed from: a */
    public static ParcelFileDescriptor m29001a(InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzaxg.f24958a.execute(new C9629om(inputStream, createPipe[1]));
        return parcelFileDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0034, code lost:
        if (r4 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        m29003a(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0039, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0012, B:30:0x0033] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void m29002a(java.io.InputStream r4, android.os.ParcelFileDescriptor r5) {
        /*
            r0 = 0
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ Throwable -> 0x0031 }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x0031 }
            com.google.android.gms.common.util.IOUtils.m22099a(r4, r1)     // Catch:{ Throwable -> 0x001a, all -> 0x0017 }
            r1.close()     // Catch:{ Throwable -> 0x0031 }
            if (r4 == 0) goto L_0x0016
            m29003a(r0, r4)     // Catch:{ IOException -> 0x003a }
            return
        L_0x0016:
            return
        L_0x0017:
            r5 = move-exception
            r2 = r0
            goto L_0x0020
        L_0x001a:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x001c }
        L_0x001c:
            r2 = move-exception
            r3 = r2
            r2 = r5
            r5 = r3
        L_0x0020:
            if (r2 == 0) goto L_0x002b
            r1.close()     // Catch:{ Throwable -> 0x0026 }
            goto L_0x002e
        L_0x0026:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzdmb.m29637a(r2, r1)     // Catch:{ Throwable -> 0x0031 }
            goto L_0x002e
        L_0x002b:
            r1.close()     // Catch:{ Throwable -> 0x0031 }
        L_0x002e:
            throw r5     // Catch:{ Throwable -> 0x0031 }
        L_0x002f:
            r5 = move-exception
            goto L_0x0034
        L_0x0031:
            r5 = move-exception
            r0 = r5
            throw r0     // Catch:{ all -> 0x002f }
        L_0x0034:
            if (r4 == 0) goto L_0x0039
            m29003a(r0, r4)     // Catch:{ IOException -> 0x003a }
        L_0x0039:
            throw r5     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            r4 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyc.m29002a(java.io.InputStream, android.os.ParcelFileDescriptor):void");
    }

    /* renamed from: a */
    private static /* synthetic */ void m29003a(Throwable th, InputStream inputStream) {
        if (th != null) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                zzdmb.m29637a(th, th2);
            }
        } else {
            inputStream.close();
        }
    }
}
