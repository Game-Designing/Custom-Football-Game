package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.UUID;

public class UUIDSerializer extends StdScalarSerializer<UUID> {
    static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    public UUIDSerializer() {
        super(UUID.class);
    }

    public boolean isEmpty(SerializerProvider prov, UUID value) {
        if (value.getLeastSignificantBits() == 0 && value.getMostSignificantBits() == 0) {
            return true;
        }
        return false;
    }

    public void serialize(UUID value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (!gen.canWriteBinaryNatively() || (gen instanceof TokenBuffer)) {
            char[] ch = new char[36];
            long msb = value.getMostSignificantBits();
            _appendInt((int) (msb >> 32), ch, 0);
            ch[8] = '-';
            int i = (int) msb;
            _appendShort(i >>> 16, ch, 9);
            ch[13] = '-';
            _appendShort(i, ch, 14);
            ch[18] = '-';
            long lsb = value.getLeastSignificantBits();
            _appendShort((int) (lsb >>> 48), ch, 19);
            ch[23] = '-';
            _appendShort((int) (lsb >>> 32), ch, 24);
            _appendInt((int) lsb, ch, 28);
            gen.writeString(ch, 0, 36);
            return;
        }
        gen.writeBinary(_asBytes(value));
    }

    private static void _appendInt(int bits, char[] ch, int offset) {
        _appendShort(bits >> 16, ch, offset);
        _appendShort(bits, ch, offset + 4);
    }

    private static void _appendShort(int bits, char[] ch, int offset) {
        char[] cArr = HEX_CHARS;
        ch[offset] = cArr[(bits >> 12) & 15];
        int offset2 = offset + 1;
        ch[offset2] = cArr[(bits >> 8) & 15];
        int offset3 = offset2 + 1;
        ch[offset3] = cArr[(bits >> 4) & 15];
        ch[offset3 + 1] = cArr[bits & 15];
    }

    private static final byte[] _asBytes(UUID uuid) {
        byte[] buffer = new byte[16];
        long hi = uuid.getMostSignificantBits();
        long lo = uuid.getLeastSignificantBits();
        _appendInt((int) (hi >> 32), buffer, 0);
        _appendInt((int) hi, buffer, 4);
        _appendInt((int) (lo >> 32), buffer, 8);
        _appendInt((int) lo, buffer, 12);
        return buffer;
    }

    private static final void _appendInt(int value, byte[] buffer, int offset) {
        buffer[offset] = (byte) (value >> 24);
        int offset2 = offset + 1;
        buffer[offset2] = (byte) (value >> 16);
        int offset3 = offset2 + 1;
        buffer[offset3] = (byte) (value >> 8);
        buffer[offset3 + 1] = (byte) value;
    }
}
