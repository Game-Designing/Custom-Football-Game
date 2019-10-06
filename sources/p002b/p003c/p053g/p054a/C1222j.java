package p002b.p003c.p053g.p054a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: b.c.g.a.j */
/* compiled from: TypefaceCompatUtil */
public class C1222j {
    /* renamed from: a */
    public static File m5813a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(".font");
        sb.append(Process.myPid());
        String str = "-";
        sb.append(str);
        sb.append(Process.myTid());
        sb.append(str);
        String prefix = sb.toString();
        int i = 0;
        while (i < 100) {
            File cacheDir = context.getCacheDir();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(prefix);
            sb2.append(i);
            File file = new File(cacheDir, sb2.toString());
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i++;
            } catch (IOException e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private static ByteBuffer m5816a(File file) {
        Throwable th;
        Throwable th2;
        try {
            FileInputStream fis = new FileInputStream(file);
            try {
                FileChannel channel = fis.getChannel();
                MappedByteBuffer map = channel.map(MapMode.READ_ONLY, 0, channel.size());
                fis.close();
                return map;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                th = r2;
                th2 = th4;
            }
            if (th != null) {
                try {
                    fis.close();
                } catch (Throwable th5) {
                }
            } else {
                fis.close();
            }
            throw th2;
            throw th2;
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004c, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0051, code lost:
        r10 = r4;
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0014] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer m5815a(android.content.Context r11, android.os.CancellationSignal r12, android.net.Uri r13) {
        /*
            android.content.ContentResolver r0 = r11.getContentResolver()
            r1 = 0
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r2 = r0.openFileDescriptor(r13, r2, r12)     // Catch:{ IOException -> 0x0062 }
            if (r2 != 0) goto L_0x0014
            if (r2 == 0) goto L_0x0013
            r2.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0013:
            return r1
        L_0x0014:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            java.io.FileDescriptor r4 = r2.getFileDescriptor()     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            r3.<init>(r4)     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            java.nio.channels.FileChannel r4 = r3.getChannel()     // Catch:{ Throwable -> 0x0039, all -> 0x0036 }
            long r8 = r4.size()     // Catch:{ Throwable -> 0x0039, all -> 0x0036 }
            java.nio.channels.FileChannel$MapMode r5 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x0039, all -> 0x0036 }
            r6 = 0
            java.nio.MappedByteBuffer r5 = r4.map(r5, r6, r8)     // Catch:{ Throwable -> 0x0039, all -> 0x0036 }
            r3.close()     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            if (r2 == 0) goto L_0x0035
            r2.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0035:
            return r5
        L_0x0036:
            r4 = move-exception
            r5 = r1
            goto L_0x003f
        L_0x0039:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003b }
        L_0x003b:
            r5 = move-exception
            r10 = r5
            r5 = r4
            r4 = r10
        L_0x003f:
            if (r5 == 0) goto L_0x0047
            r3.close()     // Catch:{ Throwable -> 0x0045, all -> 0x004b }
            goto L_0x004a
        L_0x0045:
            r5 = move-exception
            goto L_0x004a
        L_0x0047:
            r3.close()     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
        L_0x004a:
            throw r4     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
        L_0x004b:
            r3 = move-exception
            r4 = r1
            goto L_0x0054
        L_0x004e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r4 = move-exception
            r10 = r4
            r4 = r3
            r3 = r10
        L_0x0054:
            if (r2 == 0) goto L_0x0061
            if (r4 == 0) goto L_0x005e
            r2.close()     // Catch:{ Throwable -> 0x005c }
            goto L_0x0061
        L_0x005c:
            r4 = move-exception
            goto L_0x0061
        L_0x005e:
            r2.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0061:
            throw r3     // Catch:{ IOException -> 0x0062 }
        L_0x0062:
            r2 = move-exception
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p054a.C1222j.m5815a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    /* renamed from: a */
    public static ByteBuffer m5814a(Context context, Resources res, int id) {
        File tmpFile = m5813a(context);
        ByteBuffer byteBuffer = null;
        if (tmpFile == null) {
            return null;
        }
        try {
            if (m5818a(tmpFile, res, id)) {
                byteBuffer = m5816a(tmpFile);
            }
            return byteBuffer;
        } finally {
            tmpFile.delete();
        }
    }

    /* renamed from: a */
    public static boolean m5819a(File file, InputStream is) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file, false);
            byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
            while (true) {
                int read = is.read(buffer);
                int readLen = read;
                if (read != -1) {
                    os.write(buffer, 0, readLen);
                } else {
                    return true;
                }
            }
        } catch (IOException e) {
            String str = "TypefaceCompatUtil";
            StringBuilder sb = new StringBuilder();
            sb.append("Error copying resource contents to temp file: ");
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
            return false;
        } finally {
            m5817a((Closeable) os);
        }
    }

    /* renamed from: a */
    public static boolean m5818a(File file, Resources res, int id) {
        InputStream is = null;
        try {
            is = res.openRawResource(id);
            return m5819a(file, is);
        } finally {
            m5817a((Closeable) is);
        }
    }

    /* renamed from: a */
    public static void m5817a(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
            }
        }
    }
}
