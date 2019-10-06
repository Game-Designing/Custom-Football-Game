package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.data;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.data.CompactDataInput */
public class CompactDataInput extends DataInputStream {
    public CompactDataInput(InputStream in) {
        super(in);
    }

    public int readVarInt() throws IOException {
        int value = readByte() & 255;
        if ((value & 128) == 0) {
            return value;
        }
        return (value & Opcodes.LAND) | (readVarInt() << 7);
    }

    public boolean[] readBooleanArray() throws IOException {
        boolean[] value = new boolean[readVarInt()];
        int buffer = 0;
        for (int i = 0; i < value.length; i++) {
            if (i % 8 == 0) {
                buffer = readByte();
            }
            value[i] = (buffer & 1) != 0;
            buffer >>>= 1;
        }
        return value;
    }
}
