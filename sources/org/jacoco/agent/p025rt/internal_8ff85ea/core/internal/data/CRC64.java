package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.data;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.data.CRC64 */
public final class CRC64 {
    private static final long[] LOOKUPTABLE = new long[Opcodes.ACC_NATIVE];
    private static final long POLY64REV = -2882303761517117440L;

    static {
        for (int i = 0; i < 256; i++) {
            long v = (long) i;
            for (int j = 0; j < 8; j++) {
                if ((v & 1) == 1) {
                    v = (v >>> 1) ^ POLY64REV;
                } else {
                    v >>>= 1;
                }
            }
            LOOKUPTABLE[i] = v;
        }
    }

    public static long checksum(byte[] data) {
        long sum = 0;
        for (byte b : data) {
            sum = (sum >>> 8) ^ LOOKUPTABLE[(((int) sum) ^ b) & 255];
        }
        return sum;
    }

    private CRC64() {
    }
}
