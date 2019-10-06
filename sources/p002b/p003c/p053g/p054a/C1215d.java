package p002b.p003c.p053g.p054a;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;

/* renamed from: b.c.g.a.d */
/* compiled from: TypefaceCompatApi21Impl */
class C1215d extends C1220i {
    C1215d() {
    }

    /* renamed from: a */
    private File m5778a(ParcelFileDescriptor fd) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/proc/self/fd/");
            sb.append(fd.getFd());
            String path = Os.readlink(sb.toString());
            if (OsConstants.S_ISREG(Os.stat(path).st_mode)) {
                return new File(path);
            }
            return null;
        } catch (ErrnoException e) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005c, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005d, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0061, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0062, code lost:
        r8 = r5;
        r5 = r4;
        r4 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x001a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface mo8977a(android.content.Context r10, android.os.CancellationSignal r11, p002b.p003c.p053g.p059d.C1232f.C1234b[] r12, int r13) {
        /*
            r9 = this;
            int r0 = r12.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L_0x0006
            return r1
        L_0x0006:
            b.c.g.d.f$b r0 = r9.mo8986a(r12, r13)
            android.content.ContentResolver r2 = r10.getContentResolver()
            android.net.Uri r3 = r0.mo9004c()     // Catch:{ IOException -> 0x0073 }
            java.lang.String r4 = "r"
            android.os.ParcelFileDescriptor r3 = r2.openFileDescriptor(r3, r4, r11)     // Catch:{ IOException -> 0x0073 }
            java.io.File r4 = r9.m5778a(r3)     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r4 == 0) goto L_0x0031
            boolean r5 = r4.canRead()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r5 != 0) goto L_0x0027
            goto L_0x0031
        L_0x0027:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r4)     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r3 == 0) goto L_0x0030
            r3.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0030:
            return r5
        L_0x0031:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            java.io.FileDescriptor r6 = r3.getFileDescriptor()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            r5.<init>(r6)     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            android.graphics.Typeface r6 = super.mo8985a(r10, r5)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r5.close()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r3 == 0) goto L_0x0046
            r3.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0046:
            return r6
        L_0x0047:
            r6 = move-exception
            r7 = r1
            goto L_0x0050
        L_0x004a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x004c }
        L_0x004c:
            r7 = move-exception
            r8 = r7
            r7 = r6
            r6 = r8
        L_0x0050:
            if (r7 == 0) goto L_0x0058
            r5.close()     // Catch:{ Throwable -> 0x0056, all -> 0x005c }
            goto L_0x005b
        L_0x0056:
            r7 = move-exception
            goto L_0x005b
        L_0x0058:
            r5.close()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
        L_0x005b:
            throw r6     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
        L_0x005c:
            r4 = move-exception
            r5 = r1
            goto L_0x0065
        L_0x005f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r5 = move-exception
            r8 = r5
            r5 = r4
            r4 = r8
        L_0x0065:
            if (r3 == 0) goto L_0x0072
            if (r5 == 0) goto L_0x006f
            r3.close()     // Catch:{ Throwable -> 0x006d }
            goto L_0x0072
        L_0x006d:
            r5 = move-exception
            goto L_0x0072
        L_0x006f:
            r3.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0072:
            throw r4     // Catch:{ IOException -> 0x0073 }
        L_0x0073:
            r3 = move-exception
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p054a.C1215d.mo8977a(android.content.Context, android.os.CancellationSignal, b.c.g.d.f$b[], int):android.graphics.Typeface");
    }
}
