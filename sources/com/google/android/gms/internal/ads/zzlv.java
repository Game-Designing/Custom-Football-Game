package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzlv {

    /* renamed from: a */
    private static final int[] f28832a = {1, 2, 3, 6};

    /* renamed from: b */
    private static final int[] f28833b = {48000, 44100, 32000};

    /* renamed from: c */
    private static final int[] f28834c = {24000, 22050, 16000};

    /* renamed from: d */
    private static final int[] f28835d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e */
    private static final int[] f28836e = {32, 40, 48, 56, 64, 80, 96, 112, 128, Opcodes.IF_ICMPNE, Opcodes.CHECKCAST, 224, Opcodes.ACC_NATIVE, 320, 384, 448, 512, 576, 640};

    /* renamed from: f */
    private static final int[] f28837f = {69, 87, 104, Opcodes.LSHL, Opcodes.F2I, Opcodes.FRETURN, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: a */
    public static zzlh m30676a(zzst zzst, String str, String str2, zzne zzne) {
        int i;
        int i2 = f28833b[(zzst.mo32207g() & Opcodes.CHECKCAST) >> 6];
        int g = zzst.mo32207g();
        int i3 = f28835d[(g & 56) >> 3];
        if ((g & 4) != 0) {
            i = i3 + 1;
        } else {
            i = i3;
        }
        return zzlh.m30627a(str, "audio/ac3", null, -1, -1, i, i2, null, null, 0, str2);
    }

    /* renamed from: b */
    public static zzlh m30677b(zzst zzst, String str, String str2, zzne zzne) {
        int i;
        zzst.mo32201c(2);
        int i2 = f28833b[(zzst.mo32207g() & Opcodes.CHECKCAST) >> 6];
        int g = zzst.mo32207g();
        int i3 = f28835d[(g & 14) >> 1];
        if ((g & 1) != 0) {
            i = i3 + 1;
        } else {
            i = i3;
        }
        return zzlh.m30627a(str, "audio/eac3", null, -1, -1, i, i2, null, null, 0, str2);
    }

    /* renamed from: a */
    public static int m30674a() {
        return 1536;
    }

    /* renamed from: a */
    public static int m30675a(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = f28832a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * Opcodes.ACC_NATIVE;
    }
}
