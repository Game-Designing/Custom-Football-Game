package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath */
public class TypePath {
    public static final int ARRAY_ELEMENT = 0;
    public static final int INNER_TYPE = 1;
    public static final int TYPE_ARGUMENT = 3;
    public static final int WILDCARD_BOUND = 2;

    /* renamed from: b */
    byte[] f43246b;
    int offset;

    TypePath(byte[] b, int offset2) {
        this.f43246b = b;
        this.offset = offset2;
    }

    public int getLength() {
        return this.f43246b[this.offset];
    }

    public int getStep(int index) {
        return this.f43246b[this.offset + (index * 2) + 1];
    }

    public int getStepArgument(int index) {
        return this.f43246b[this.offset + (index * 2) + 2];
    }

    public static TypePath fromString(String typePath) {
        if (typePath == null || typePath.length() == 0) {
            return null;
        }
        int n = typePath.length();
        ByteVector out = new ByteVector(n);
        out.putByte(0);
        int i = 0;
        while (i < n) {
            int i2 = i + 1;
            char c = typePath.charAt(i);
            if (c == '[') {
                out.put11(0, 0);
            } else if (c == '.') {
                out.put11(1, 0);
            } else if (c == '*') {
                out.put11(2, 0);
            } else if (c >= '0' && c <= '9') {
                int typeArg = c - '0';
                while (i2 < n) {
                    char charAt = typePath.charAt(i2);
                    char c2 = charAt;
                    if (charAt < '0' || c2 > '9') {
                        break;
                    }
                    typeArg = ((typeArg * 10) + c2) - 48;
                    i2++;
                }
                if (i2 < n && typePath.charAt(i2) == ';') {
                    i2++;
                }
                out.put11(3, typeArg);
                i = i2;
            }
            i = i2;
        }
        byte[] bArr = out.data;
        bArr[0] = (byte) (out.length / 2);
        return new TypePath(bArr, 0);
    }

    public String toString() {
        int length = getLength();
        StringBuilder result = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            int step = getStep(i);
            if (step == 0) {
                result.append('[');
            } else if (step == 1) {
                result.append('.');
            } else if (step == 2) {
                result.append('*');
            } else if (step != 3) {
                result.append('_');
            } else {
                result.append(getStepArgument(i));
                result.append(';');
            }
        }
        return result.toString();
    }
}
