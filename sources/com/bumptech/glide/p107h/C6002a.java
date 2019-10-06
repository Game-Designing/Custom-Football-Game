package com.bumptech.glide.p107h;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.h.a */
/* compiled from: ByteBufferUtil */
public final class C6002a {

    /* renamed from: a */
    private static final AtomicReference<byte[]> f10638a = new AtomicReference<>();

    /* renamed from: com.bumptech.glide.h.a$a */
    /* compiled from: ByteBufferUtil */
    private static class C6003a extends InputStream {

        /* renamed from: a */
        private final ByteBuffer f10639a;

        /* renamed from: b */
        private int f10640b = -1;

        C6003a(ByteBuffer byteBuffer) {
            this.f10639a = byteBuffer;
        }

        public int available() {
            return this.f10639a.remaining();
        }

        public int read() {
            if (!this.f10639a.hasRemaining()) {
                return -1;
            }
            return this.f10639a.get();
        }

        public synchronized void mark(int readLimit) {
            this.f10640b = this.f10639a.position();
        }

        public boolean markSupported() {
            return true;
        }

        public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
            if (!this.f10639a.hasRemaining()) {
                return -1;
            }
            int toRead = Math.min(byteCount, available());
            this.f10639a.get(buffer, byteOffset, toRead);
            return toRead;
        }

        public synchronized void reset() throws IOException {
            if (this.f10640b != -1) {
                this.f10639a.position(this.f10640b);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        public long skip(long byteCount) throws IOException {
            if (!this.f10639a.hasRemaining()) {
                return -1;
            }
            long toSkip = Math.min(byteCount, (long) available());
            ByteBuffer byteBuffer = this.f10639a;
            byteBuffer.position((int) (((long) byteBuffer.position()) + toSkip));
            return toSkip;
        }
    }

    /* renamed from: com.bumptech.glide.h.a$b */
    /* compiled from: ByteBufferUtil */
    static final class C6004b {

        /* renamed from: a */
        final int f10641a;

        /* renamed from: b */
        final int f10642b;

        /* renamed from: c */
        final byte[] f10643c;

        C6004b(byte[] data, int offset, int limit) {
            this.f10643c = data;
            this.f10641a = offset;
            this.f10642b = limit;
        }
    }

    /* renamed from: a */
    public static ByteBuffer m11212a(File file) throws IOException {
        RandomAccessFile raf = null;
        FileChannel channel = null;
        try {
            long fileLength = file.length();
            if (fileLength > 2147483647L) {
                throw new IOException("File too large to map into memory");
            } else if (fileLength != 0) {
                RandomAccessFile raf2 = new RandomAccessFile(file, "r");
                FileChannel channel2 = raf2.getChannel();
                MappedByteBuffer load = channel2.map(MapMode.READ_ONLY, 0, fileLength).load();
                if (channel2 != null) {
                    try {
                        channel2.close();
                    } catch (IOException e) {
                    }
                }
                try {
                    raf2.close();
                } catch (IOException e2) {
                }
                return load;
            } else {
                throw new IOException("File unsuitable for memory mapping");
            }
        } catch (Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e3) {
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static void m11213a(ByteBuffer buffer, File file) throws IOException {
        buffer.position(0);
        RandomAccessFile raf = null;
        FileChannel channel = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            channel = raf.getChannel();
            channel.write(buffer);
            channel.force(false);
            channel.close();
            raf.close();
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                }
            }
            try {
                raf.close();
            } catch (IOException e2) {
            }
        } catch (Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e3) {
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static byte[] m11214a(ByteBuffer byteBuffer) {
        C6004b safeArray = m11216c(byteBuffer);
        if (safeArray != null && safeArray.f10641a == 0 && safeArray.f10642b == safeArray.f10643c.length) {
            return byteBuffer.array();
        }
        ByteBuffer toCopy = byteBuffer.asReadOnlyBuffer();
        byte[] result = new byte[toCopy.limit()];
        toCopy.position(0);
        toCopy.get(result);
        return result;
    }

    /* renamed from: b */
    public static InputStream m11215b(ByteBuffer buffer) {
        return new C6003a(buffer);
    }

    /* renamed from: c */
    private static C6004b m11216c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new C6004b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
