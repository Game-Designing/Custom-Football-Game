package com.google.android.gms.internal.ads;

import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzkg {

    /* renamed from: a */
    private static final int[] f28733a = {48000, 44100, 32000};

    /* renamed from: b */
    private static final int[] f28734b = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: c */
    private static final int[] f28735c = {32, 40, 48, 56, 64, 80, 96, 112, 128, Opcodes.IF_ICMPNE, Opcodes.CHECKCAST, 224, Opcodes.ACC_NATIVE, 320, 384, 448, 512, 576, 640};

    /* renamed from: d */
    private static final int[] f28736d = {69, 87, 104, Opcodes.LSHL, Opcodes.F2I, Opcodes.FRETURN, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: a */
    public static zzhj m30532a(zzkm zzkm) {
        int i;
        int i2 = f28733a[(zzkm.mo31897e() & Opcodes.CHECKCAST) >> 6];
        int e = zzkm.mo31897e();
        int i3 = f28734b[(e & 56) >> 3];
        if ((e & 4) != 0) {
            i = i3 + 1;
        } else {
            i = i3;
        }
        return zzhj.m30360b("audio/ac3", -1, -1, i, i2, Collections.emptyList());
    }

    /* renamed from: b */
    public static zzhj m30533b(zzkm zzkm) {
        zzkm.mo31894b(2);
        int i = f28733a[(zzkm.mo31897e() & Opcodes.CHECKCAST) >> 6];
        int e = zzkm.mo31897e();
        int i2 = f28734b[(e & 14) >> 1];
        if ((e & 1) != 0) {
            i2++;
        }
        return zzhj.m30356a("audio/eac3", -1, i2, i, Collections.emptyList());
    }

    /* renamed from: a */
    public static int m30531a(int i, int i2) {
        return (((i << 3) * i2) + 768000) / 1536000;
    }
}
