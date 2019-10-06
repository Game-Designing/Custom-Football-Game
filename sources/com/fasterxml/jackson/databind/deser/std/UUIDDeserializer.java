package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

public class UUIDDeserializer extends FromStringDeserializer<UUID> {
    static final int[] HEX_DIGITS = new int[Opcodes.LAND];

    static {
        Arrays.fill(HEX_DIGITS, -1);
        for (int i = 0; i < 10; i++) {
            HEX_DIGITS[i + 48] = i;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            int[] iArr = HEX_DIGITS;
            iArr[i2 + 97] = i2 + 10;
            iArr[i2 + 65] = i2 + 10;
        }
    }

    public UUIDDeserializer() {
        super(UUID.class);
    }

    /* access modifiers changed from: protected */
    public UUID _deserialize(String id, DeserializationContext ctxt) throws IOException {
        if (id.length() == 36) {
            if (!(id.charAt(8) == '-' && id.charAt(13) == '-' && id.charAt(18) == '-' && id.charAt(23) == '-')) {
                _badFormat(id, ctxt);
            }
            return new UUID((((long) intFromChars(id, 0, ctxt)) << 32) + ((((long) shortFromChars(id, 9, ctxt)) << 16) | ((long) shortFromChars(id, 14, ctxt))), (((long) (shortFromChars(id, 24, ctxt) | (shortFromChars(id, 19, ctxt) << 16))) << 32) | ((((long) intFromChars(id, 28, ctxt)) << 32) >>> 32));
        } else if (id.length() == 24) {
            return _fromBytes(Base64Variants.getDefaultVariant().decode(id), ctxt);
        } else {
            return _badFormat(id, ctxt);
        }
    }

    /* access modifiers changed from: protected */
    public UUID _deserializeEmbedded(Object ob, DeserializationContext ctxt) throws IOException {
        if (ob instanceof byte[]) {
            return _fromBytes((byte[]) ob, ctxt);
        }
        super._deserializeEmbedded(ob, ctxt);
        throw null;
    }

    private UUID _badFormat(String uuidStr, DeserializationContext ctxt) throws IOException {
        return (UUID) ctxt.handleWeirdStringValue(handledType(), uuidStr, "UUID has to be represented by standard 36-char representation", new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public int intFromChars(String str, int index, DeserializationContext ctxt) throws JsonMappingException {
        return (byteFromChars(str, index, ctxt) << 24) + (byteFromChars(str, index + 2, ctxt) << 16) + (byteFromChars(str, index + 4, ctxt) << 8) + byteFromChars(str, index + 6, ctxt);
    }

    /* access modifiers changed from: 0000 */
    public int shortFromChars(String str, int index, DeserializationContext ctxt) throws JsonMappingException {
        return (byteFromChars(str, index, ctxt) << 8) + byteFromChars(str, index + 2, ctxt);
    }

    /* access modifiers changed from: 0000 */
    public int byteFromChars(String str, int index, DeserializationContext ctxt) throws JsonMappingException {
        char c1 = str.charAt(index);
        char c2 = str.charAt(index + 1);
        if (c1 <= 127 && c2 <= 127) {
            int[] iArr = HEX_DIGITS;
            int hex = iArr[c2] | (iArr[c1] << 4);
            if (hex >= 0) {
                return hex;
            }
        }
        if (c1 > 127 || HEX_DIGITS[c1] < 0) {
            _badChar(str, index, ctxt, c1);
            throw null;
        }
        _badChar(str, index + 1, ctxt, c2);
        throw null;
    }

    /* access modifiers changed from: 0000 */
    public int _badChar(String uuidStr, int index, DeserializationContext ctxt, char c) throws JsonMappingException {
        throw ctxt.weirdStringException(uuidStr, handledType(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", new Object[]{Character.valueOf(c), Integer.toHexString(c)}));
    }

    private UUID _fromBytes(byte[] bytes, DeserializationContext ctxt) throws JsonMappingException {
        if (bytes.length == 16) {
            return new UUID(_long(bytes, 0), _long(bytes, 8));
        }
        JsonParser parser = ctxt.getParser();
        StringBuilder sb = new StringBuilder();
        sb.append("Can only construct UUIDs from byte[16]; got ");
        sb.append(bytes.length);
        sb.append(" bytes");
        throw InvalidFormatException.from(parser, sb.toString(), bytes, handledType());
    }

    private static long _long(byte[] b, int offset) {
        return (((long) _int(b, offset)) << 32) | ((((long) _int(b, offset + 4)) << 32) >>> 32);
    }

    private static int _int(byte[] b, int offset) {
        return (b[offset] << 24) | ((b[offset + 1] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((b[offset + 2] & 255) << 8) | (b[offset + 3] & 255);
    }
}
