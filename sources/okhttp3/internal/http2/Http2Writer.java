package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p362h.C14191g;
import p362h.C14193h;

final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final C14191g hpackBuffer = new C14191g();
    final Writer hpackWriter = new Writer(this.hpackBuffer);
    private int maxFrameSize = Opcodes.ACC_ENUM;
    private final C14193h sink;

    Http2Writer(C14193h sink2, boolean client2) {
        this.sink = sink2;
        this.client = client2;
    }

    public synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (this.client) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.mo44280f()));
            }
            this.sink.write(Http2.CONNECTION_PREFACE.mo44288u());
            this.sink.flush();
        }
    }

    public synchronized void applyAndAckSettings(Settings peerSettings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(requestHeaders);
            long byteCount = this.hpackBuffer.size();
            byte flags = 4;
            int length = (int) Math.min((long) (this.maxFrameSize - 4), byteCount);
            if (byteCount != ((long) length)) {
                flags = 0;
            }
            frameHeader(streamId, length + 4, 5, flags);
            this.sink.writeInt(Integer.MAX_VALUE & promisedStreamId);
            this.sink.write(this.hpackBuffer, (long) length);
            if (byteCount > ((long) length)) {
                writeContinuationFrames(streamId, byteCount - ((long) length));
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synStream(boolean outFinished, int streamId, int associatedStreamId, List<Header> headerBlock) throws IOException {
        if (!this.closed) {
            headers(outFinished, streamId, headerBlock);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synReply(boolean outFinished, int streamId, List<Header> headerBlock) throws IOException {
        if (!this.closed) {
            headers(outFinished, streamId, headerBlock);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void headers(int streamId, List<Header> headerBlock) throws IOException {
        if (!this.closed) {
            headers(false, streamId, headerBlock);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void rstStream(int streamId, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(streamId, 4, 3, 0);
            this.sink.writeInt(errorCode.httpCode);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void data(boolean outFinished, int streamId, C14191g source, int byteCount) throws IOException {
        if (!this.closed) {
            byte flags = 0;
            if (outFinished) {
                flags = (byte) (0 | 1);
            }
            dataFrame(streamId, flags, source, byteCount);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: 0000 */
    public void dataFrame(int streamId, byte flags, C14191g buffer, int byteCount) throws IOException {
        frameHeader(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            this.sink.write(buffer, (long) byteCount);
        }
    }

    public synchronized void settings(Settings settings) throws IOException {
        if (!this.closed) {
            frameHeader(0, settings.size() * 6, 4, 0);
            for (int i = 0; i < 10; i++) {
                if (settings.isSet(i)) {
                    int id = i;
                    if (id == 4) {
                        id = 3;
                    } else if (id == 7) {
                        id = 4;
                    }
                    this.sink.writeShort(id);
                    this.sink.writeInt(settings.get(i));
                }
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void ping(boolean ack, int payload1, int payload2) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, 6, ack ? (byte) 1 : 0);
            this.sink.writeInt(payload1);
            this.sink.writeInt(payload2);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void goAway(int lastGoodStreamId, ErrorCode errorCode, byte[] debugData) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(0, debugData.length + 8, 7, 0);
            this.sink.writeInt(lastGoodStreamId);
            this.sink.writeInt(errorCode.httpCode);
            if (debugData.length > 0) {
                this.sink.write(debugData);
            }
            this.sink.flush();
        } else {
            Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public synchronized void windowUpdate(int streamId, long windowSizeIncrement) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (windowSizeIncrement == 0 || windowSizeIncrement > 2147483647L) {
            Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(windowSizeIncrement));
            throw null;
        } else {
            frameHeader(streamId, 4, 8, 0);
            this.sink.writeInt((int) windowSizeIncrement);
            this.sink.flush();
        }
    }

    public void frameHeader(int streamId, int length, byte type, byte flags) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, streamId, length, type, flags));
        }
        int i = this.maxFrameSize;
        if (length > i) {
            Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i), Integer.valueOf(length));
            throw null;
        } else if ((Integer.MIN_VALUE & streamId) == 0) {
            writeMedium(this.sink, length);
            this.sink.writeByte(type & 255);
            this.sink.writeByte(flags & 255);
            this.sink.writeInt(Integer.MAX_VALUE & streamId);
        } else {
            Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(streamId));
            throw null;
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    private static void writeMedium(C14193h sink2, int i) throws IOException {
        sink2.writeByte((i >>> 16) & 255);
        sink2.writeByte((i >>> 8) & 255);
        sink2.writeByte(i & 255);
    }

    private void writeContinuationFrames(int streamId, long byteCount) throws IOException {
        while (byteCount > 0) {
            int length = (int) Math.min((long) this.maxFrameSize, byteCount);
            byteCount -= (long) length;
            frameHeader(streamId, length, 9, byteCount == 0 ? (byte) 4 : 0);
            this.sink.write(this.hpackBuffer, (long) length);
        }
    }

    /* access modifiers changed from: 0000 */
    public void headers(boolean outFinished, int streamId, List<Header> headerBlock) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(headerBlock);
            long byteCount = this.hpackBuffer.size();
            int length = (int) Math.min((long) this.maxFrameSize, byteCount);
            byte flags = byteCount == ((long) length) ? (byte) 4 : 0;
            if (outFinished) {
                flags = (byte) (flags | 1);
            }
            frameHeader(streamId, length, 1, flags);
            this.sink.write(this.hpackBuffer, (long) length);
            if (byteCount > ((long) length)) {
                writeContinuationFrames(streamId, byteCount - ((long) length));
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
