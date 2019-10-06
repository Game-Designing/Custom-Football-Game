package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzmr {

    /* renamed from: a */
    private static final int[] f28904a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b */
    private static final int[] f28905b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c */
    private static final int[] f28906c = {64, 112, 128, Opcodes.CHECKCAST, 224, Opcodes.ACC_NATIVE, 384, 448, 512, 640, 768, 896, Opcodes.ACC_ABSTRACT, 1152, 1280, 1536, 1920, Opcodes.ACC_STRICT, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, Opcodes.ACC_SYNTHETIC, 6144, 7680};

    /* renamed from: a */
    public static int m30735a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) << 5;
    }
}
