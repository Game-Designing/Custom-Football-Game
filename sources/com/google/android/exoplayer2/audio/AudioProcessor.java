package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {

    /* renamed from: a */
    public static final ByteBuffer f16572a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledFormatException extends Exception {
        public UnhandledFormatException(int sampleRateHz, int channelCount, int encoding) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unhandled format: ");
            sb.append(sampleRateHz);
            sb.append(" Hz, ");
            sb.append(channelCount);
            sb.append(" channels in encoding ");
            sb.append(encoding);
            super(sb.toString());
        }
    }

    /* renamed from: a */
    void mo25035a(ByteBuffer byteBuffer);

    /* renamed from: a */
    boolean mo25036a();

    /* renamed from: a */
    boolean mo25037a(int i, int i2, int i3) throws UnhandledFormatException;

    /* renamed from: b */
    boolean mo25038b();

    /* renamed from: c */
    ByteBuffer mo25039c();

    /* renamed from: d */
    int mo25040d();

    /* renamed from: e */
    int mo25041e();

    /* renamed from: f */
    int mo25042f();

    void flush();

    /* renamed from: g */
    void mo25044g();

    void reset();
}
