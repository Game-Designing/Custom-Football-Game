package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.C8438u;
import java.nio.ByteBuffer;

public interface AudioSink {

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable cause) {
            super(cause);
        }

        public ConfigurationException(String message) {
            super(message);
        }
    }

    public static final class InitializationException extends Exception {

        /* renamed from: a */
        public final int f16573a;

        public InitializationException(int audioTrackState, int sampleRate, int channelConfig, int bufferSize) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed: ");
            sb.append(audioTrackState);
            sb.append(", Config(");
            sb.append(sampleRate);
            String str = ", ";
            sb.append(str);
            sb.append(channelConfig);
            sb.append(str);
            sb.append(bufferSize);
            sb.append(")");
            super(sb.toString());
            this.f16573a = audioTrackState;
        }
    }

    public static final class WriteException extends Exception {

        /* renamed from: a */
        public final int f16574a;

        public WriteException(int errorCode) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack write failed: ");
            sb.append(errorCode);
            super(sb.toString());
            this.f16574a = errorCode;
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.AudioSink$a */
    public interface C8109a {
        /* renamed from: a */
        void mo25068a();

        /* renamed from: a */
        void mo25069a(int i);

        /* renamed from: a */
        void mo25070a(int i, long j, long j2);
    }

    /* renamed from: a */
    long mo25048a(boolean z);

    /* renamed from: a */
    C8438u mo25049a(C8438u uVar);

    /* renamed from: a */
    void mo25050a();

    /* renamed from: a */
    void mo25051a(float f);

    /* renamed from: a */
    void mo25052a(int i);

    /* renamed from: a */
    void mo25053a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws ConfigurationException;

    /* renamed from: a */
    void mo25054a(C8109a aVar);

    /* renamed from: a */
    void mo25055a(C8125j jVar);

    /* renamed from: a */
    void mo25056a(C8134o oVar);

    /* renamed from: a */
    boolean mo25057a(int i, int i2);

    /* renamed from: a */
    boolean mo25058a(ByteBuffer byteBuffer, long j) throws InitializationException, WriteException;

    /* renamed from: b */
    boolean mo25059b();

    /* renamed from: e */
    C8438u mo25060e();

    /* renamed from: f */
    boolean mo25061f();

    /* renamed from: g */
    void mo25062g();

    /* renamed from: h */
    void mo25063h() throws WriteException;

    /* renamed from: i */
    void mo25064i();

    void pause();

    void play();

    void reset();
}
