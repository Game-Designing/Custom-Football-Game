package p002b.p003c.p004f;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: b.c.f.d */
/* compiled from: ZipUtil */
final class C0028d {

    /* renamed from: b.c.f.d$a */
    /* compiled from: ZipUtil */
    static class C0029a {

        /* renamed from: a */
        long f28a;

        /* renamed from: b */
        long f29b;

        C0029a() {
        }
    }

    /* renamed from: a */
    static long m66a(File apk) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(apk, "r");
        try {
            return m67a(raf, m68a(raf));
        } finally {
            raf.close();
        }
    }

    /* renamed from: a */
    static C0029a m68a(RandomAccessFile raf) throws IOException, ZipException {
        long scanOffset = raf.length() - 22;
        if (scanOffset >= 0) {
            long stopOffset = scanOffset - 65536;
            if (stopOffset < 0) {
                stopOffset = 0;
            }
            int endSig = Integer.reverseBytes(101010256);
            do {
                raf.seek(scanOffset);
                if (raf.readInt() == endSig) {
                    raf.skipBytes(2);
                    raf.skipBytes(2);
                    raf.skipBytes(2);
                    raf.skipBytes(2);
                    C0029a dir = new C0029a();
                    dir.f29b = ((long) Integer.reverseBytes(raf.readInt())) & 4294967295L;
                    dir.f28a = ((long) Integer.reverseBytes(raf.readInt())) & 4294967295L;
                    return dir;
                }
                scanOffset--;
            } while (scanOffset >= stopOffset);
            throw new ZipException("End Of Central Directory signature not found");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File too short to be a zip file: ");
        sb.append(raf.length());
        throw new ZipException(sb.toString());
    }

    /* renamed from: a */
    static long m67a(RandomAccessFile raf, C0029a dir) throws IOException {
        CRC32 crc = new CRC32();
        long stillToRead = dir.f29b;
        raf.seek(dir.f28a);
        byte[] buffer = new byte[Opcodes.ACC_ENUM];
        int length = raf.read(buffer, 0, (int) Math.min(16384, stillToRead));
        while (length != -1) {
            crc.update(buffer, 0, length);
            stillToRead -= (long) length;
            if (stillToRead == 0) {
                break;
            }
            length = raf.read(buffer, 0, (int) Math.min(16384, stillToRead));
        }
        return crc.getValue();
    }
}
