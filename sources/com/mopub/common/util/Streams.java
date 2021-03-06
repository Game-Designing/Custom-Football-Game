package com.mopub.common.util;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class Streams {
    public static void copyContent(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    public static void copyContent(InputStream inputStream, OutputStream outputStream, long maxBytes) throws IOException {
        if (inputStream == null || outputStream == null) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] buffer = new byte[Opcodes.ACC_ENUM];
        long totalRead = 0;
        while (true) {
            int read = inputStream.read(buffer);
            int length = read;
            if (read != -1) {
                totalRead += (long) length;
                if (totalRead < maxBytes) {
                    outputStream.write(buffer, 0, length);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error copying content: attempted to copy ");
                    sb.append(totalRead);
                    sb.append(" bytes, with ");
                    sb.append(maxBytes);
                    sb.append(" maximum.");
                    throw new IOException(sb.toString());
                }
            } else {
                return;
            }
        }
    }

    public static void readStream(InputStream inputStream, byte[] buffer) throws IOException {
        int offset = 0;
        int maxBytes = buffer.length;
        do {
            int read = inputStream.read(buffer, offset, maxBytes);
            int bytesRead = read;
            if (read != -1) {
                offset += bytesRead;
                maxBytes -= bytesRead;
            } else {
                return;
            }
        } while (maxBytes > 0);
    }

    public static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to close stream. Ignoring.");
            }
        }
    }
}
