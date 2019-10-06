package com.fyber.inneractive.sdk.p166g.p167a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

/* renamed from: com.fyber.inneractive.sdk.g.a.k */
final class C7789k {

    /* renamed from: a */
    static final Charset f15667a = Charset.forName("US-ASCII");

    /* renamed from: b */
    static final Charset f15668b = Charset.forName("UTF-8");

    /* renamed from: a */
    static void m17289a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    m17289a(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder("failed to delete file: ");
                    sb.append(file2);
                    throw new IOException(sb.toString());
                }
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("not a readable directory: ");
        sb2.append(file);
        throw new IOException(sb2.toString());
    }

    /* renamed from: a */
    static void m17288a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    static void m17290a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }
}
