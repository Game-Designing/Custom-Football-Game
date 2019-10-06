package p024io.fabric.sdk.android.p348a.p350b;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: io.fabric.sdk.android.a.b.C */
/* compiled from: QueueFile */
public class C13832C implements Closeable {

    /* renamed from: a */
    private static final Logger f41992a = Logger.getLogger(C13832C.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final RandomAccessFile f41993b;

    /* renamed from: c */
    int f41994c;

    /* renamed from: d */
    private int f41995d;

    /* renamed from: e */
    private C13833a f41996e;

    /* renamed from: f */
    private C13833a f41997f;

    /* renamed from: g */
    private final byte[] f41998g = new byte[16];

    /* renamed from: io.fabric.sdk.android.a.b.C$a */
    /* compiled from: QueueFile */
    static class C13833a {

        /* renamed from: a */
        static final C13833a f41999a = new C13833a(0, 0);

        /* renamed from: b */
        final int f42000b;

        /* renamed from: c */
        final int f42001c;

        C13833a(int position, int length) {
            this.f42000b = position;
            this.f42001c = length;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.f42000b);
            sb.append(", length = ");
            sb.append(this.f42001c);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: io.fabric.sdk.android.a.b.C$b */
    /* compiled from: QueueFile */
    private final class C13834b extends InputStream {

        /* renamed from: a */
        private int f42002a;

        /* renamed from: b */
        private int f42003b;

        /* synthetic */ C13834b(C13832C x0, C13833a x1, C13831B x2) {
            this(x1);
        }

        private C13834b(C13833a element) {
            this.f42002a = C13832C.this.m43969d(element.f42000b + 4);
            this.f42003b = element.f42001c;
        }

        public int read(byte[] buffer, int offset, int length) throws IOException {
            C13832C.m43965b(buffer, "buffer");
            if ((offset | length) < 0 || length > buffer.length - offset) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i = this.f42003b;
            if (i <= 0) {
                return -1;
            }
            if (length > i) {
                length = this.f42003b;
            }
            C13832C.this.m43959a(this.f42002a, buffer, offset, length);
            this.f42002a = C13832C.this.m43969d(this.f42002a + length);
            this.f42003b -= length;
            return length;
        }

        public int read() throws IOException {
            if (this.f42003b == 0) {
                return -1;
            }
            C13832C.this.f41993b.seek((long) this.f42002a);
            int b = C13832C.this.f41993b.read();
            this.f42002a = C13832C.this.m43969d(this.f42002a + 1);
            this.f42003b--;
            return b;
        }
    }

    /* renamed from: io.fabric.sdk.android.a.b.C$c */
    /* compiled from: QueueFile */
    public interface C13835c {
        /* renamed from: a */
        void mo19446a(InputStream inputStream, int i) throws IOException;
    }

    public C13832C(File file) throws IOException {
        if (!file.exists()) {
            m43961a(file);
        }
        this.f41993b = m43964b(file);
        m43970e();
    }

    /* renamed from: b */
    private static void m43967b(byte[] buffer, int offset, int value) {
        buffer[offset] = (byte) (value >> 24);
        buffer[offset + 1] = (byte) (value >> 16);
        buffer[offset + 2] = (byte) (value >> 8);
        buffer[offset + 3] = (byte) value;
    }

    /* renamed from: a */
    private static void m43962a(byte[] buffer, int... values) {
        int offset = 0;
        for (int value : values) {
            m43967b(buffer, offset, value);
            offset += 4;
        }
    }

    /* renamed from: a */
    private static int m43954a(byte[] buffer, int offset) {
        return ((buffer[offset] & 255) << 24) + ((buffer[offset + 1] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) + ((buffer[offset + 2] & 255) << 8) + (buffer[offset + 3] & 255);
    }

    /* renamed from: e */
    private void m43970e() throws IOException {
        this.f41993b.seek(0);
        this.f41993b.readFully(this.f41998g);
        this.f41994c = m43954a(this.f41998g, 0);
        if (((long) this.f41994c) <= this.f41993b.length()) {
            this.f41995d = m43954a(this.f41998g, 4);
            int firstOffset = m43954a(this.f41998g, 8);
            int lastOffset = m43954a(this.f41998g, 12);
            this.f41996e = m43963b(firstOffset);
            this.f41997f = m43963b(lastOffset);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File is truncated. Expected length: ");
        sb.append(this.f41994c);
        sb.append(", Actual length: ");
        sb.append(this.f41993b.length());
        throw new IOException(sb.toString());
    }

    /* renamed from: a */
    private void m43958a(int fileLength, int elementCount, int firstPosition, int lastPosition) throws IOException {
        m43962a(this.f41998g, fileLength, elementCount, firstPosition, lastPosition);
        this.f41993b.seek(0);
        this.f41993b.write(this.f41998g);
    }

    /* renamed from: b */
    private C13833a m43963b(int position) throws IOException {
        if (position == 0) {
            return C13833a.f41999a;
        }
        this.f41993b.seek((long) position);
        return new C13833a(position, this.f41993b.readInt());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static void m43961a(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append(".tmp");
        File tempFile = new File(sb.toString());
        RandomAccessFile raf = m43964b(tempFile);
        try {
            raf.setLength(4096);
            raf.seek(0);
            byte[] headerBuffer = new byte[16];
            m43962a(headerBuffer, 4096, 0, 0, 0);
            raf.write(headerBuffer);
            raf.close();
            if (!tempFile.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            raf.close();
            throw th;
        }
    }

    /* renamed from: b */
    private static RandomAccessFile m43964b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public int m43969d(int position) {
        int i = this.f41994c;
        return position < i ? position : (position + 16) - i;
    }

    /* renamed from: b */
    private void m43966b(int position, byte[] buffer, int offset, int count) throws IOException {
        int position2 = m43969d(position);
        int i = position2 + count;
        int i2 = this.f41994c;
        if (i <= i2) {
            this.f41993b.seek((long) position2);
            this.f41993b.write(buffer, offset, count);
            return;
        }
        int beforeEof = i2 - position2;
        this.f41993b.seek((long) position2);
        this.f41993b.write(buffer, offset, beforeEof);
        this.f41993b.seek(16);
        this.f41993b.write(buffer, offset + beforeEof, count - beforeEof);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43959a(int position, byte[] buffer, int offset, int count) throws IOException {
        int position2 = m43969d(position);
        int i = position2 + count;
        int i2 = this.f41994c;
        if (i <= i2) {
            this.f41993b.seek((long) position2);
            this.f41993b.readFully(buffer, offset, count);
            return;
        }
        int beforeEof = i2 - position2;
        this.f41993b.seek((long) position2);
        this.f41993b.readFully(buffer, offset, beforeEof);
        this.f41993b.seek(16);
        this.f41993b.readFully(buffer, offset + beforeEof, count - beforeEof);
    }

    /* renamed from: a */
    public void mo43205a(byte[] data) throws IOException {
        mo43206a(data, 0, data.length);
    }

    /* renamed from: a */
    public synchronized void mo43206a(byte[] data, int offset, int count) throws IOException {
        m43965b(data, "buffer");
        if ((offset | count) < 0 || count > data.length - offset) {
            throw new IndexOutOfBoundsException();
        }
        m43957a(count);
        boolean wasEmpty = mo43208b();
        C13833a newLast = new C13833a(wasEmpty ? 16 : m43969d(this.f41997f.f42000b + 4 + this.f41997f.f42001c), count);
        m43967b(this.f41998g, 0, count);
        m43966b(newLast.f42000b, this.f41998g, 0, 4);
        m43966b(newLast.f42000b + 4, data, offset, count);
        m43958a(this.f41994c, this.f41995d + 1, wasEmpty ? newLast.f42000b : this.f41996e.f42000b, newLast.f42000b);
        this.f41997f = newLast;
        this.f41995d++;
        if (wasEmpty) {
            this.f41996e = this.f41997f;
        }
    }

    /* renamed from: d */
    public int mo43211d() {
        if (this.f41995d == 0) {
            return 16;
        }
        C13833a aVar = this.f41997f;
        int i = aVar.f42000b;
        int i2 = this.f41996e.f42000b;
        if (i >= i2) {
            return (i - i2) + 4 + aVar.f42001c + 16;
        }
        return (((i + 4) + aVar.f42001c) + this.f41994c) - i2;
    }

    /* renamed from: f */
    private int m43971f() {
        return this.f41994c - mo43211d();
    }

    /* renamed from: b */
    public synchronized boolean mo43208b() {
        return this.f41995d == 0;
    }

    /* renamed from: a */
    private void m43957a(int dataLength) throws IOException {
        int newLength;
        int elementLength = dataLength + 4;
        int remainingBytes = m43971f();
        if (remainingBytes < elementLength) {
            int previousLength = this.f41994c;
            do {
                remainingBytes += previousLength;
                newLength = previousLength << 1;
                previousLength = newLength;
            } while (remainingBytes < elementLength);
            m43968c(newLength);
            C13833a aVar = this.f41997f;
            int endOfLastElement = m43969d(aVar.f42000b + 4 + aVar.f42001c);
            if (endOfLastElement < this.f41996e.f42000b) {
                FileChannel channel = this.f41993b.getChannel();
                channel.position((long) this.f41994c);
                int count = endOfLastElement - 4;
                if (channel.transferTo(16, (long) count, channel) != ((long) count)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i = this.f41997f.f42000b;
            int i2 = this.f41996e.f42000b;
            if (i < i2) {
                int newLastPosition = (this.f41994c + i) - 16;
                m43958a(newLength, this.f41995d, i2, newLastPosition);
                this.f41997f = new C13833a(newLastPosition, this.f41997f.f42001c);
            } else {
                m43958a(newLength, this.f41995d, i2, i);
            }
            this.f41994c = newLength;
        }
    }

    /* renamed from: c */
    private void m43968c(int newLength) throws IOException {
        this.f41993b.setLength((long) newLength);
        this.f41993b.getChannel().force(true);
    }

    /* renamed from: a */
    public synchronized void mo43204a(C13835c reader) throws IOException {
        int position = this.f41996e.f42000b;
        for (int i = 0; i < this.f41995d; i++) {
            C13833a current = m43963b(position);
            reader.mo19446a(new C13834b(this, current, null), current.f42001c);
            position = m43969d(current.f42000b + 4 + current.f42001c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m43965b(T t, String name) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(name);
    }

    /* renamed from: c */
    public synchronized void mo43209c() throws IOException {
        if (mo43208b()) {
            throw new NoSuchElementException();
        } else if (this.f41995d == 1) {
            mo43203a();
        } else {
            int newFirstPosition = m43969d(this.f41996e.f42000b + 4 + this.f41996e.f42001c);
            m43959a(newFirstPosition, this.f41998g, 0, 4);
            int length = m43954a(this.f41998g, 0);
            m43958a(this.f41994c, this.f41995d - 1, newFirstPosition, this.f41997f.f42000b);
            this.f41995d--;
            this.f41996e = new C13833a(newFirstPosition, length);
        }
    }

    /* renamed from: a */
    public synchronized void mo43203a() throws IOException {
        m43958a((int) Opcodes.ACC_SYNTHETIC, 0, 0, 0);
        this.f41995d = 0;
        this.f41996e = C13833a.f41999a;
        this.f41997f = C13833a.f41999a;
        if (this.f41994c > 4096) {
            m43968c(Opcodes.ACC_SYNTHETIC);
        }
        this.f41994c = Opcodes.ACC_SYNTHETIC;
    }

    public synchronized void close() throws IOException {
        this.f41993b.close();
    }

    /* renamed from: a */
    public boolean mo43207a(int dataSizeBytes, int maxSizeBytes) {
        return (mo43211d() + 4) + dataSizeBytes <= maxSizeBytes;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append('[');
        builder.append("fileLength=");
        builder.append(this.f41994c);
        builder.append(", size=");
        builder.append(this.f41995d);
        builder.append(", first=");
        builder.append(this.f41996e);
        builder.append(", last=");
        builder.append(this.f41997f);
        builder.append(", element lengths=[");
        try {
            mo43204a((C13835c) new C13831B(this, builder));
        } catch (IOException e) {
            f41992a.log(Level.WARNING, "read error", e);
        }
        builder.append("]]");
        return builder.toString();
    }
}
