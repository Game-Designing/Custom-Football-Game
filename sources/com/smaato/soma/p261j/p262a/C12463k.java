package com.smaato.soma.p261j.p262a;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.smaato.soma.j.a.k */
/* compiled from: Streams */
public class C12463k {
    /* renamed from: a */
    public static void m40995a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] buffer = new byte[Opcodes.ACC_ENUM];
        while (true) {
            int read = inputStream.read(buffer);
            int length = read;
            if (read != -1) {
                outputStream.write(buffer, 0, length);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m40994a(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
            }
        }
    }
}
