package okhttp3.internal.p385ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p362h.C14191g;
import p362h.C14191g.C14192a;
import p362h.C14194i;
import p362h.C14195j;

/* renamed from: okhttp3.internal.ws.WebSocketReader */
final class WebSocketReader {
    boolean closed;
    private final C14191g controlFrameBuffer = new C14191g();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final C14192a maskCursor;
    private final byte[] maskKey;
    private final C14191g messageFrameBuffer = new C14191g();
    int opcode;
    final C14194i source;

    /* renamed from: okhttp3.internal.ws.WebSocketReader$FrameCallback */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(C14195j jVar) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(C14195j jVar);

        void onReadPong(C14195j jVar);
    }

    WebSocketReader(boolean isClient2, C14194i source2, FrameCallback frameCallback2) {
        if (source2 == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback2 != null) {
            this.isClient = isClient2;
            this.source = source2;
            this.frameCallback = frameCallback2;
            C14192a aVar = null;
            this.maskKey = isClient2 ? null : new byte[4];
            if (!isClient2) {
                aVar = new C14192a();
            }
            this.maskCursor = aVar;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* access modifiers changed from: 0000 */
    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    /* JADX INFO: finally extract failed */
    private void readHeader() throws IOException {
        String str;
        if (!this.closed) {
            long timeoutBefore = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                int b0 = this.source.readByte() & 255;
                this.source.timeout().timeout(timeoutBefore, TimeUnit.NANOSECONDS);
                this.opcode = b0 & 15;
                boolean isMasked = true;
                this.isFinalFrame = (b0 & 128) != 0;
                this.isControlFrame = (b0 & 8) != 0;
                if (!this.isControlFrame || this.isFinalFrame) {
                    boolean reservedFlag1 = (b0 & 64) != 0;
                    boolean reservedFlag2 = (b0 & 32) != 0;
                    boolean reservedFlag3 = (b0 & 16) != 0;
                    if (reservedFlag1 || reservedFlag2 || reservedFlag3) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    int b1 = this.source.readByte() & 255;
                    if ((b1 & 128) == 0) {
                        isMasked = false;
                    }
                    boolean z = this.isClient;
                    if (isMasked == z) {
                        if (z) {
                            str = "Server-sent frames must not be masked.";
                        } else {
                            str = "Client-sent frames must be masked.";
                        }
                        throw new ProtocolException(str);
                    }
                    this.frameLength = (long) (b1 & Opcodes.LAND);
                    long j = this.frameLength;
                    if (j == 126) {
                        this.frameLength = ((long) this.source.readShort()) & 65535;
                    } else if (j == 127) {
                        this.frameLength = this.source.readLong();
                        if (this.frameLength < 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Frame length 0x");
                            sb.append(Long.toHexString(this.frameLength));
                            sb.append(" > 0x7FFFFFFFFFFFFFFF");
                            throw new ProtocolException(sb.toString());
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (isMasked) {
                        this.source.readFully(this.maskKey);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutBefore, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void readControlFrame() throws IOException {
        long j = this.frameLength;
        if (j > 0) {
            this.source.mo44215a(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.mo44204a(this.maskCursor);
                this.maskCursor.mo44269h(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                int code = 1005;
                String reason = "";
                long bufferSize = this.controlFrameBuffer.size();
                if (bufferSize != 1) {
                    if (bufferSize != 0) {
                        code = this.controlFrameBuffer.readShort();
                        reason = this.controlFrameBuffer.mo44232h();
                        String codeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(code);
                        if (codeExceptionMessage != null) {
                            throw new ProtocolException(codeExceptionMessage);
                        }
                    }
                    this.frameCallback.onReadClose(code, reason);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.mo44225d());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.mo44225d());
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown control opcode: ");
                sb.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(sb.toString());
        }
    }

    private void readMessageFrame() throws IOException {
        int opcode2 = this.opcode;
        if (opcode2 == 1 || opcode2 == 2) {
            readMessage();
            if (opcode2 == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.mo44232h());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.mo44225d());
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown opcode: ");
            sb.append(Integer.toHexString(opcode2));
            throw new ProtocolException(sb.toString());
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.mo44215a(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.mo44204a(this.maskCursor);
                    this.maskCursor.mo44269h(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected continuation opcode. Got: ");
                    sb.append(Integer.toHexString(this.opcode));
                    throw new ProtocolException(sb.toString());
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}
