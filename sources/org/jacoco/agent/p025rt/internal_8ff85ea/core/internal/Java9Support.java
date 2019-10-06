package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.Java9Support */
public final class Java9Support {
    public static final int V1_9 = 53;

    private Java9Support() {
    }

    public static byte[] readFully(InputStream is) throws IOException {
        if (is != null) {
            byte[] buf = new byte[Opcodes.ACC_ABSTRACT];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            while (true) {
                int r = is.read(buf);
                if (r == -1) {
                    return out.toByteArray();
                }
                out.write(buf, 0, r);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void putShort(byte[] b, int index, int s) {
        b[index] = (byte) (s >>> 8);
        b[index + 1] = (byte) s;
    }

    private static short readShort(byte[] b, int index) {
        return (short) (((b[index] & 255) << 8) | (b[index + 1] & 255));
    }

    public static boolean isPatchRequired(byte[] buffer) {
        return readShort(buffer, 6) == 53;
    }

    public static byte[] downgradeIfRequired(byte[] buffer) {
        return isPatchRequired(buffer) ? downgrade(buffer) : buffer;
    }

    public static byte[] downgrade(byte[] b) {
        byte[] result = new byte[b.length];
        System.arraycopy(b, 0, result, 0, b.length);
        putShort(result, 6, 52);
        return result;
    }

    public static void upgrade(byte[] b) {
        putShort(b, 6, 53);
    }
}
