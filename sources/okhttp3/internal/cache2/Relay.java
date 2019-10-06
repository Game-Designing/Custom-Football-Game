package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import p362h.C14180B;
import p362h.C14182D;
import p362h.C14191g;
import p362h.C14195j;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final C14195j PREFIX_CLEAN = C14195j.m45649c("OkHttp cache v1\n");
    static final C14195j PREFIX_DIRTY = C14195j.m45649c("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final C14191g buffer = new C14191g();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final C14195j metadata;
    int sourceCount;
    C14180B upstream;
    final C14191g upstreamBuffer = new C14191g();
    long upstreamPos;
    Thread upstreamReader;

    class RelaySource implements C14180B {
        private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
        private long sourcePos;
        private final C14182D timeout = new C14182D();

        RelaySource() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
            r5 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
            r5 = r9 - r1.this$0.buffer.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
            if (r1.sourcePos >= r5) goto L_0x0131;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
            r5 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            r7 = java.lang.Math.min(r2, r9 - r1.sourcePos);
            r1.this$0.buffer.mo44206a(r22, r1.sourcePos - r5, r7);
            r1.sourcePos += r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x014e, code lost:
            return r7;
         */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0122 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(p362h.C14191g r22, long r23) throws java.io.IOException {
            /*
                r21 = this;
                r1 = r21
                r2 = r23
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x0152
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x014f }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x014f }
                long r7 = r0.upstreamPos     // Catch:{ all -> 0x014f }
                r9 = r7
                r11 = -1
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 != 0) goto L_0x003a
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x014f }
                boolean r0 = r0.complete     // Catch:{ all -> 0x014f }
                if (r0 == 0) goto L_0x0020
                monitor-exit(r4)     // Catch:{ all -> 0x014f }
                return r11
            L_0x0020:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x014f }
                java.lang.Thread r0 = r0.upstreamReader     // Catch:{ all -> 0x014f }
                if (r0 == 0) goto L_0x002e
                h.D r0 = r1.timeout     // Catch:{ all -> 0x014f }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x014f }
                r0.waitUntilNotified(r5)     // Catch:{ all -> 0x014f }
                goto L_0x000b
            L_0x002e:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x014f }
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x014f }
                r0.upstreamReader = r5     // Catch:{ all -> 0x014f }
                r0 = 1
                monitor-exit(r4)     // Catch:{ all -> 0x014f }
                r5 = r0
                goto L_0x004d
            L_0x003a:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x014f }
                h.g r0 = r0.buffer     // Catch:{ all -> 0x014f }
                long r5 = r0.size()     // Catch:{ all -> 0x014f }
                long r5 = r9 - r5
                long r7 = r1.sourcePos     // Catch:{ all -> 0x014f }
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0131
                r0 = 2
                monitor-exit(r4)     // Catch:{ all -> 0x014f }
                r5 = r0
            L_0x004d:
                r0 = 2
                r6 = 32
                if (r5 != r0) goto L_0x006c
                long r11 = r1.sourcePos
                long r11 = r9 - r11
                long r11 = java.lang.Math.min(r2, r11)
                okhttp3.internal.cache2.FileOperator r13 = r1.fileOperator
                long r14 = r1.sourcePos
                long r14 = r14 + r6
                r16 = r22
                r17 = r11
                r13.read(r14, r16, r17)
                long r6 = r1.sourcePos
                long r6 = r6 + r11
                r1.sourcePos = r6
                return r11
            L_0x006c:
                r4 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x011d }
                h.B r0 = r0.upstream     // Catch:{ all -> 0x011d }
                okhttp3.internal.cache2.Relay r8 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x011d }
                h.g r8 = r8.upstreamBuffer     // Catch:{ all -> 0x011d }
                okhttp3.internal.cache2.Relay r13 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x011d }
                long r13 = r13.bufferMaxSize     // Catch:{ all -> 0x011d }
                long r13 = r0.read(r8, r13)     // Catch:{ all -> 0x011d }
                int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r0 != 0) goto L_0x009c
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0098 }
                r0.commit(r9)     // Catch:{ all -> 0x0098 }
                okhttp3.internal.cache2.Relay r6 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r6)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0095 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x0095 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0095 }
                r0.notifyAll()     // Catch:{ all -> 0x0095 }
                monitor-exit(r6)     // Catch:{ all -> 0x0095 }
                return r11
            L_0x0095:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0095 }
                throw r0
            L_0x0098:
                r0 = move-exception
                r15 = r5
                goto L_0x011f
            L_0x009c:
                long r11 = java.lang.Math.min(r13, r2)     // Catch:{ all -> 0x011d }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x011d }
                h.g r15 = r0.upstreamBuffer     // Catch:{ all -> 0x011d }
                r17 = 0
                r16 = r22
                r19 = r11
                r15.mo44206a(r16, r17, r19)     // Catch:{ all -> 0x011d }
                r8 = r5
                long r4 = r1.sourcePos     // Catch:{ all -> 0x011a }
                long r4 = r4 + r11
                r1.sourcePos = r4     // Catch:{ all -> 0x011a }
                okhttp3.internal.cache2.FileOperator r15 = r1.fileOperator     // Catch:{ all -> 0x011a }
                long r16 = r9 + r6
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x011a }
                h.g r0 = r0.upstreamBuffer     // Catch:{ all -> 0x011a }
                h.g r18 = r0.clone()     // Catch:{ all -> 0x011a }
                r19 = r13
                r15.write(r16, r18, r19)     // Catch:{ all -> 0x011a }
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x011a }
                monitor-enter(r4)     // Catch:{ all -> 0x011a }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0112 }
                h.g r0 = r0.buffer     // Catch:{ all -> 0x0112 }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0112 }
                h.g r5 = r5.upstreamBuffer     // Catch:{ all -> 0x0112 }
                r0.write(r5, r13)     // Catch:{ all -> 0x0112 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0112 }
                h.g r0 = r0.buffer     // Catch:{ all -> 0x0112 }
                long r5 = r0.size()     // Catch:{ all -> 0x0112 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0112 }
                r15 = r8
                long r7 = r0.bufferMaxSize     // Catch:{ all -> 0x0118 }
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 <= 0) goto L_0x00f7
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                h.g r0 = r0.buffer     // Catch:{ all -> 0x0118 }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                h.g r5 = r5.buffer     // Catch:{ all -> 0x0118 }
                long r5 = r5.size()     // Catch:{ all -> 0x0118 }
                okhttp3.internal.cache2.Relay r7 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                long r7 = r7.bufferMaxSize     // Catch:{ all -> 0x0118 }
                long r5 = r5 - r7
                r0.skip(r5)     // Catch:{ all -> 0x0118 }
            L_0x00f7:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                long r5 = r0.upstreamPos     // Catch:{ all -> 0x0118 }
                long r5 = r5 + r13
                r0.upstreamPos = r5     // Catch:{ all -> 0x0118 }
                monitor-exit(r4)     // Catch:{ all -> 0x0118 }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r5)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x010f }
                r4 = 0
                r0.upstreamReader = r4     // Catch:{ all -> 0x010f }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x010f }
                r0.notifyAll()     // Catch:{ all -> 0x010f }
                monitor-exit(r5)     // Catch:{ all -> 0x010f }
                return r11
            L_0x010f:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x010f }
                throw r0
            L_0x0112:
                r0 = move-exception
                r15 = r8
            L_0x0114:
                monitor-exit(r4)     // Catch:{ all -> 0x0118 }
                throw r0     // Catch:{ all -> 0x0116 }
            L_0x0116:
                r0 = move-exception
                goto L_0x011f
            L_0x0118:
                r0 = move-exception
                goto L_0x0114
            L_0x011a:
                r0 = move-exception
                r15 = r8
                goto L_0x011f
            L_0x011d:
                r0 = move-exception
                r15 = r5
            L_0x011f:
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r5)
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012e }
                r6 = 0
                r4.upstreamReader = r6     // Catch:{ all -> 0x012e }
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012e }
                r4.notifyAll()     // Catch:{ all -> 0x012e }
                monitor-exit(r5)     // Catch:{ all -> 0x012e }
                throw r0
            L_0x012e:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x012e }
                throw r0
            L_0x0131:
                long r7 = r1.sourcePos     // Catch:{ all -> 0x014f }
                long r7 = r9 - r7
                long r7 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x014f }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x014f }
                h.g r11 = r0.buffer     // Catch:{ all -> 0x014f }
                long r12 = r1.sourcePos     // Catch:{ all -> 0x014f }
                long r14 = r12 - r5
                r12 = r22
                r13 = r14
                r15 = r7
                r11.mo44206a(r12, r13, r15)     // Catch:{ all -> 0x014f }
                long r11 = r1.sourcePos     // Catch:{ all -> 0x014f }
                long r11 = r11 + r7
                r1.sourcePos = r11     // Catch:{ all -> 0x014f }
                monitor-exit(r4)     // Catch:{ all -> 0x014f }
                return r7
            L_0x014f:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x014f }
                throw r0
            L_0x0152:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r4 = "closed"
                r0.<init>(r4)
                goto L_0x015b
            L_0x015a:
                throw r0
            L_0x015b:
                goto L_0x015a
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(h.g, long):long");
        }

        public C14182D timeout() {
            return this.timeout;
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                this.fileOperator = null;
                RandomAccessFile fileToClose = null;
                synchronized (Relay.this) {
                    Relay.this.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        fileToClose = Relay.this.file;
                        Relay.this.file = null;
                    }
                }
                if (fileToClose != null) {
                    Util.closeQuietly((Closeable) fileToClose);
                }
            }
        }
    }

    private Relay(RandomAccessFile file2, C14180B upstream2, long upstreamPos2, C14195j metadata2, long bufferMaxSize2) {
        this.file = file2;
        this.upstream = upstream2;
        this.complete = upstream2 == null;
        this.upstreamPos = upstreamPos2;
        this.metadata = metadata2;
        this.bufferMaxSize = bufferMaxSize2;
    }

    public static Relay edit(File file2, C14180B upstream2, C14195j metadata2, long bufferMaxSize2) throws IOException {
        File file3 = file2;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, upstream2, 0, metadata2, bufferMaxSize2);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        C14191g header = new C14191g();
        fileOperator.read(0, header, FILE_HEADER_SIZE);
        if (header.mo44230f((long) PREFIX_CLEAN.mo44285s()).equals(PREFIX_CLEAN)) {
            long upstreamSize = header.readLong();
            long metadataSize = header.readLong();
            C14191g metadataBuffer = new C14191g();
            fileOperator.read(upstreamSize + FILE_HEADER_SIZE, metadataBuffer, metadataSize);
            Relay relay = new Relay(randomAccessFile, null, upstreamSize, metadataBuffer.mo44225d(), 0);
            return relay;
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(C14195j prefix, long upstreamSize, long metadataSize) throws IOException {
        C14191g header = new C14191g();
        header.mo44207a(prefix);
        header.mo44237j(upstreamSize);
        header.mo44237j(metadataSize);
        if (header.size() == FILE_HEADER_SIZE) {
            new FileOperator(this.file.getChannel()).write(0, header, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long upstreamSize) throws IOException {
        C14191g metadataBuffer = new C14191g();
        metadataBuffer.mo44207a(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + upstreamSize, metadataBuffer, (long) this.metadata.mo44285s());
    }

    /* access modifiers changed from: 0000 */
    public void commit(long upstreamSize) throws IOException {
        writeMetadata(upstreamSize);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, upstreamSize, (long) this.metadata.mo44285s());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    /* access modifiers changed from: 0000 */
    public boolean isClosed() {
        return this.file == null;
    }

    public C14195j metadata() {
        return this.metadata;
    }

    public C14180B newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
