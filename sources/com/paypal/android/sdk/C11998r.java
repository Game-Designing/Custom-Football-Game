package com.paypal.android.sdk;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.paypal.android.sdk.r */
public final class C11998r {

    /* renamed from: a */
    private boolean f37678a = false;

    /* renamed from: b */
    private boolean f37679b = false;

    /* renamed from: c */
    private File f37680c;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C11998r() {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r5.f37678a = r0
            r5.f37679b = r0
            java.lang.String r1 = android.os.Environment.getExternalStorageState()
            int r2 = r1.hashCode()
            r3 = 1242932856(0x4a15a678, float:2451870.0)
            r4 = 1
            if (r2 == r3) goto L_0x0026
            r3 = 1299749220(0x4d789964, float:2.60675136E8)
            if (r2 == r3) goto L_0x001c
            goto L_0x0030
        L_0x001c:
            java.lang.String r2 = "mounted_ro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0030
            r1 = 1
            goto L_0x0031
        L_0x0026:
            java.lang.String r2 = "mounted"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0030
            r1 = 0
            goto L_0x0031
        L_0x0030:
            r1 = -1
        L_0x0031:
            if (r1 == 0) goto L_0x003f
            if (r1 == r4) goto L_0x003a
            r5.f37679b = r0
            r5.f37678a = r0
            goto L_0x0043
        L_0x003a:
            r5.f37678a = r4
            r5.f37679b = r0
            goto L_0x0043
        L_0x003f:
            r5.f37679b = r4
            r5.f37678a = r4
        L_0x0043:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            r5.f37680c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.C11998r.<init>():void");
    }

    /* renamed from: a */
    public final void mo39181a(String str) {
        this.f37680c = new File(str);
    }

    /* renamed from: a */
    public final void mo39182a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (this.f37678a && this.f37679b) {
            FileOutputStream fileOutputStream2 = null;
            try {
                if (!this.f37680c.mkdirs()) {
                    if (!this.f37680c.isDirectory()) {
                        fileOutputStream = null;
                        C11723Fa.m38815a((Closeable) fileOutputStream);
                    }
                }
                fileOutputStream = new FileOutputStream(new File(this.f37680c, str));
                try {
                    fileOutputStream.write(bArr);
                    C11723Fa.m38815a((Closeable) fileOutputStream);
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    C11723Fa.m38815a((Closeable) fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C11723Fa.m38815a((Closeable) fileOutputStream2);
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final String mo39183b(String str) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[Opcodes.ACC_ABSTRACT];
        if (this.f37679b) {
            try {
                fileInputStream = new FileInputStream(new File(this.f37680c, str));
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int read = fileInputStream.read(bArr, 0, Opcodes.ACC_ABSTRACT); read != -1; read = fileInputStream.read(bArr, 0, Opcodes.ACC_ABSTRACT)) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    C11723Fa.m38815a((Closeable) fileInputStream);
                } catch (IOException e) {
                    C11723Fa.m38815a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    C11723Fa.m38815a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                fileInputStream = null;
                C11723Fa.m38815a((Closeable) fileInputStream);
                return "";
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                C11723Fa.m38815a((Closeable) fileInputStream);
                throw th;
            }
        }
        return new String(bArr, "UTF-8");
    }
}
