package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.C8534s;
import com.google.android.exoplayer2.util.C8535t;
import java.nio.ByteBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.audio.h */
/* compiled from: Ac3Util */
public final class C8122h {

    /* renamed from: a */
    private static final int[] f16656a = {1, 2, 3, 6};

    /* renamed from: b */
    private static final int[] f16657b = {48000, 44100, 32000};

    /* renamed from: c */
    private static final int[] f16658c = {24000, 22050, 16000};

    /* renamed from: d */
    private static final int[] f16659d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e */
    private static final int[] f16660e = {32, 40, 48, 56, 64, 80, 96, 112, 128, Opcodes.IF_ICMPNE, Opcodes.CHECKCAST, 224, Opcodes.ACC_NATIVE, 320, 384, 448, 512, 576, 640};

    /* renamed from: f */
    private static final int[] f16661f = {69, 87, 104, Opcodes.LSHL, Opcodes.F2I, Opcodes.FRETURN, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.audio.h$a */
    /* compiled from: Ac3Util */
    public static final class C8123a {

        /* renamed from: a */
        public final String f16662a;

        /* renamed from: b */
        public final int f16663b;

        /* renamed from: c */
        public final int f16664c;

        /* renamed from: d */
        public final int f16665d;

        /* renamed from: e */
        public final int f16666e;

        /* renamed from: f */
        public final int f16667f;

        private C8123a(String mimeType, int streamType, int channelCount, int sampleRate, int frameSize, int sampleCount) {
            this.f16662a = mimeType;
            this.f16663b = streamType;
            this.f16665d = channelCount;
            this.f16664c = sampleRate;
            this.f16666e = frameSize;
            this.f16667f = sampleCount;
        }
    }

    /* renamed from: a */
    public static Format m18395a(C8535t data, String trackId, String language, DrmInitData drmInitData) {
        int channelCount;
        int sampleRate = f16657b[(data.mo26131q() & Opcodes.CHECKCAST) >> 6];
        int nextByte = data.mo26131q();
        int channelCount2 = f16659d[(nextByte & 56) >> 3];
        if ((nextByte & 4) != 0) {
            channelCount = channelCount2 + 1;
        } else {
            channelCount = channelCount2;
        }
        return Format.m18250a(trackId, "audio/ac3", null, -1, -1, channelCount, sampleRate, null, drmInitData, 0, language);
    }

    /* renamed from: b */
    public static Format m18399b(C8535t data, String trackId, String language, DrmInitData drmInitData) {
        int channelCount;
        String mimeType;
        data.mo26120f(2);
        int sampleRate = f16657b[(data.mo26131q() & Opcodes.CHECKCAST) >> 6];
        int nextByte = data.mo26131q();
        int channelCount2 = f16659d[(nextByte & 14) >> 1];
        if ((nextByte & 1) != 0) {
            channelCount2++;
        }
        int nextByte2 = data.mo26131q();
        if (((nextByte2 & 30) >> 1) <= 0 || (data.mo26131q() & 2) == 0) {
            channelCount = channelCount2;
        } else {
            channelCount = channelCount2 + 2;
        }
        String mimeType2 = "audio/eac3";
        if (data.mo26104a() > 0) {
            int nextByte3 = data.mo26131q();
            if ((nextByte3 & 1) != 0) {
                int i = nextByte3;
                mimeType = "audio/eac3-joc";
            } else {
                int i2 = nextByte3;
                mimeType = mimeType2;
            }
        } else {
            int i3 = nextByte2;
            mimeType = mimeType2;
        }
        return Format.m18250a(trackId, mimeType, null, -1, -1, channelCount, sampleRate, null, drmInitData, 0, language);
    }

    /* renamed from: a */
    public static C8123a m18396a(C8534s data) {
        int channelCount;
        int sampleRate;
        int frameSize;
        int sampleCount;
        String mimeType;
        int i;
        int audioBlocks;
        int numblkscod;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        C8534s sVar = data;
        int initialPosition = data.mo26100c();
        sVar.mo26101c(40);
        boolean isEac3 = sVar.mo26092a(5) == 16;
        sVar.mo26099b(initialPosition);
        int streamType = -1;
        if (isEac3) {
            sVar.mo26101c(16);
            int a = sVar.mo26092a(2);
            if (a == 0) {
                streamType = 0;
            } else if (a == 1) {
                streamType = 1;
            } else if (a != 2) {
                streamType = -1;
            } else {
                streamType = 2;
            }
            sVar.mo26101c(3);
            frameSize = (sVar.mo26092a(11) + 1) * 2;
            int fscod = sVar.mo26092a(2);
            if (fscod == 3) {
                numblkscod = 3;
                sampleRate = f16658c[sVar.mo26092a(2)];
                audioBlocks = 6;
            } else {
                numblkscod = sVar.mo26092a(2);
                audioBlocks = f16656a[numblkscod];
                sampleRate = f16657b[fscod];
            }
            sampleCount = audioBlocks * Opcodes.ACC_NATIVE;
            int acmod = sVar.mo26092a(3);
            boolean lfeon = data.mo26102d();
            channelCount = f16659d[acmod] + (lfeon);
            sVar.mo26101c(10);
            if (data.mo26102d()) {
                sVar.mo26101c(8);
            }
            if (acmod == 0) {
                sVar.mo26101c(5);
                if (data.mo26102d()) {
                    sVar.mo26101c(8);
                }
            }
            if (streamType == 1 && data.mo26102d()) {
                sVar.mo26101c(16);
            }
            if (data.mo26102d()) {
                if (acmod > 2) {
                    sVar.mo26101c(2);
                }
                if ((acmod & 1) == 0 || acmod <= 2) {
                    i5 = 6;
                } else {
                    i5 = 6;
                    sVar.mo26101c(6);
                }
                if ((acmod & 4) != 0) {
                    sVar.mo26101c(i5);
                }
                if (lfeon && data.mo26102d()) {
                    sVar.mo26101c(5);
                }
                if (streamType == 0) {
                    if (data.mo26102d()) {
                        i6 = 6;
                        sVar.mo26101c(6);
                    } else {
                        i6 = 6;
                    }
                    if (acmod == 0 && data.mo26102d()) {
                        sVar.mo26101c(i6);
                    }
                    if (data.mo26102d()) {
                        sVar.mo26101c(i6);
                    }
                    int mixdef = sVar.mo26092a(2);
                    if (mixdef == 1) {
                        sVar.mo26101c(5);
                    } else if (mixdef == 2) {
                        sVar.mo26101c(12);
                    } else if (mixdef == 3) {
                        int mixdeflen = sVar.mo26092a(5);
                        if (data.mo26102d()) {
                            sVar.mo26101c(5);
                            if (data.mo26102d()) {
                                sVar.mo26101c(4);
                            }
                            if (data.mo26102d()) {
                                sVar.mo26101c(4);
                            }
                            if (data.mo26102d()) {
                                sVar.mo26101c(4);
                            }
                            if (data.mo26102d()) {
                                sVar.mo26101c(4);
                            }
                            if (data.mo26102d()) {
                                sVar.mo26101c(4);
                            }
                            if (data.mo26102d()) {
                                sVar.mo26101c(4);
                            }
                            if (data.mo26102d()) {
                                sVar.mo26101c(4);
                            }
                            if (data.mo26102d()) {
                                if (data.mo26102d()) {
                                    sVar.mo26101c(4);
                                }
                                if (data.mo26102d()) {
                                    sVar.mo26101c(4);
                                }
                            }
                        }
                        if (data.mo26102d()) {
                            sVar.mo26101c(5);
                            if (data.mo26102d()) {
                                sVar.mo26101c(7);
                                if (data.mo26102d()) {
                                    sVar.mo26101c(8);
                                }
                            }
                        }
                        sVar.mo26101c((mixdeflen + 2) * 8);
                        data.mo26098b();
                    }
                    if (acmod < 2) {
                        if (data.mo26102d()) {
                            sVar.mo26101c(14);
                        }
                        if (acmod == 0 && data.mo26102d()) {
                            sVar.mo26101c(14);
                        }
                    }
                    if (data.mo26102d()) {
                        if (numblkscod == 0) {
                            sVar.mo26101c(5);
                        } else {
                            for (int blk = 0; blk < audioBlocks; blk++) {
                                if (data.mo26102d()) {
                                    sVar.mo26101c(5);
                                }
                            }
                        }
                    }
                }
            }
            if (data.mo26102d() != 0) {
                sVar.mo26101c(5);
                if (acmod == 2) {
                    sVar.mo26101c(4);
                }
                if (acmod >= 6) {
                    sVar.mo26101c(2);
                }
                if (data.mo26102d()) {
                    i4 = 8;
                    sVar.mo26101c(8);
                } else {
                    i4 = 8;
                }
                if (acmod == 0 && data.mo26102d()) {
                    sVar.mo26101c(i4);
                }
                i2 = 3;
                if (fscod < 3) {
                    data.mo26103e();
                }
            } else {
                i2 = 3;
            }
            if (streamType == 0 && numblkscod != i2) {
                data.mo26103e();
            }
            if (streamType != 2) {
                i3 = 6;
            } else if (numblkscod == i2 || data.mo26102d()) {
                i3 = 6;
                sVar.mo26101c(6);
            } else {
                i3 = 6;
            }
            mimeType = "audio/eac3";
            if (data.mo26102d() && sVar.mo26092a(i3) == 1 && sVar.mo26092a(8) == 1) {
                mimeType = "audio/eac3-joc";
            }
        } else {
            mimeType = "audio/ac3";
            sVar.mo26101c(32);
            int fscod2 = sVar.mo26092a(2);
            frameSize = m18391a(fscod2, sVar.mo26092a(6));
            sVar.mo26101c(8);
            int acmod2 = sVar.mo26092a(3);
            if ((acmod2 & 1) == 0 || acmod2 == 1) {
                i = 2;
            } else {
                i = 2;
                sVar.mo26101c(2);
            }
            if ((acmod2 & 4) != 0) {
                sVar.mo26101c(i);
            }
            if (acmod2 == i) {
                sVar.mo26101c(i);
            }
            sampleRate = f16657b[fscod2];
            sampleCount = 1536;
            channelCount = f16659d[acmod2] + (data.mo26102d());
        }
        C8123a aVar = new C8123a(mimeType, streamType, channelCount, sampleRate, frameSize, sampleCount);
        return aVar;
    }

    /* renamed from: a */
    public static int m18394a(byte[] data) {
        if (data.length < 6) {
            return -1;
        }
        if (!(((data[5] & 255) >> 3) == 16)) {
            return m18391a((data[4] & 192) >> 6, data[4] & 63);
        }
        return (((data[3] & 255) | ((data[2] & 7) << 8)) + 1) * 2;
    }

    /* renamed from: a */
    public static int m18390a() {
        return 1536;
    }

    /* renamed from: b */
    public static int m18397b(ByteBuffer buffer) {
        int i = 6;
        if (((buffer.get(buffer.position() + 4) & 192) >> 6) != 3) {
            i = f16656a[(buffer.get(buffer.position() + 4) & 48) >> 4];
        }
        return i * Opcodes.ACC_NATIVE;
    }

    /* renamed from: a */
    public static int m18392a(ByteBuffer buffer) {
        int startIndex = buffer.position();
        int endIndex = buffer.limit() - 10;
        for (int i = startIndex; i <= endIndex; i++) {
            if ((buffer.getInt(i + 4) & -16777217) == -1167101192) {
                return i - startIndex;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static int m18398b(byte[] syncframe) {
        boolean isMlp = false;
        if (syncframe[4] != -8 || syncframe[5] != 114 || syncframe[6] != 111 || (syncframe[7] & 254) != 186) {
            return 0;
        }
        if ((syncframe[7] & 255) == 187) {
            isMlp = true;
        }
        return 40 << ((syncframe[isMlp ? (char) 9 : 8] >> 4) & 7);
    }

    /* renamed from: a */
    public static int m18393a(ByteBuffer buffer, int offset) {
        return 40 << ((buffer.get((buffer.position() + offset) + ((buffer.get((buffer.position() + offset) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    /* renamed from: a */
    private static int m18391a(int fscod, int frmsizecod) {
        int halfFrmsizecod = frmsizecod / 2;
        if (fscod >= 0) {
            int[] iArr = f16657b;
            if (fscod < iArr.length && frmsizecod >= 0) {
                int[] iArr2 = f16661f;
                if (halfFrmsizecod < iArr2.length) {
                    int sampleRate = iArr[fscod];
                    if (sampleRate == 44100) {
                        return (iArr2[halfFrmsizecod] + (frmsizecod % 2)) * 2;
                    }
                    int bitrate = f16660e[halfFrmsizecod];
                    if (sampleRate == 32000) {
                        return bitrate * 6;
                    }
                    return bitrate * 4;
                }
            }
        }
        return -1;
    }
}
