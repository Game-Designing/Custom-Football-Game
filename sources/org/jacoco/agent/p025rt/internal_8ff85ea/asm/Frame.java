package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Frame */
class Frame {
    static final int ARRAY_OF = 268435456;
    static final int BASE = 16777216;
    static final int BASE_KIND = 267386880;
    static final int BASE_VALUE = 1048575;
    static final int BOOLEAN = 16777225;
    static final int BYTE = 16777226;
    static final int CHAR = 16777227;
    static final int DIM = -268435456;
    static final int DOUBLE = 16777219;
    static final int ELEMENT_OF = -268435456;
    static final int FLOAT = 16777218;
    static final int INTEGER = 16777217;
    static final int KIND = 251658240;
    private static final int LOCAL = 33554432;
    static final int LONG = 16777220;
    static final int NULL = 16777221;
    static final int OBJECT = 24117248;
    static final int SHORT = 16777228;
    static final int[] SIZE;
    private static final int STACK = 50331648;
    static final int TOP = 16777216;
    static final int TOP_IF_LONG_OR_DOUBLE = 8388608;
    static final int UNINITIALIZED = 25165824;
    static final int UNINITIALIZED_THIS = 16777222;
    static final int VALUE = 8388607;
    private int initializationCount;
    private int[] initializations;
    int[] inputLocals;
    int[] inputStack;
    private int[] outputLocals;
    private int[] outputStack;
    int outputStackTop;
    Label owner;

    Frame() {
    }

    static {
        int[] b = new int[202];
        String s = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE";
        for (int i = 0; i < b.length; i++) {
            b[i] = s.charAt(i) - 'E';
        }
        SIZE = b;
    }

    /* access modifiers changed from: 0000 */
    public final void set(ClassWriter cw, int nLocal, Object[] local, int nStack, Object[] stack) {
        int i = convert(cw, nLocal, local, this.inputLocals);
        while (i < local.length) {
            int i2 = i + 1;
            this.inputLocals[i] = 16777216;
            i = i2;
        }
        int nStackTop = 0;
        for (int j = 0; j < nStack; j++) {
            if (stack[j] == Opcodes.LONG || stack[j] == Opcodes.DOUBLE) {
                nStackTop++;
            }
        }
        this.inputStack = new int[(nStack + nStackTop)];
        convert(cw, nStack, stack, this.inputStack);
        this.outputStackTop = 0;
        this.initializationCount = 0;
    }

    private static int convert(ClassWriter cw, int nInput, Object[] input, int[] output) {
        int i = 0;
        for (int j = 0; j < nInput; j++) {
            if (input[j] instanceof Integer) {
                int i2 = i + 1;
                output[i] = input[j].intValue() | 16777216;
                if (input[j] == Opcodes.LONG || input[j] == Opcodes.DOUBLE) {
                    i = i2 + 1;
                    output[i2] = 16777216;
                } else {
                    i = i2;
                }
            } else if (input[j] instanceof String) {
                int i3 = i + 1;
                output[i] = type(cw, Type.getObjectType(input[j]).getDescriptor());
                i = i3;
            } else {
                int i4 = i + 1;
                output[i] = UNINITIALIZED | cw.addUninitializedType("", input[j].position);
                i = i4;
            }
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public final void set(Frame f) {
        this.inputLocals = f.inputLocals;
        this.inputStack = f.inputStack;
        this.outputLocals = f.outputLocals;
        this.outputStack = f.outputStack;
        this.outputStackTop = f.outputStackTop;
        this.initializationCount = f.initializationCount;
        this.initializations = f.initializations;
    }

    private int get(int local) {
        int[] iArr = this.outputLocals;
        if (iArr == null || local >= iArr.length) {
            return local | LOCAL;
        }
        int type = iArr[local];
        if (type == 0) {
            int i = LOCAL | local;
            iArr[local] = i;
            type = i;
        }
        return type;
    }

    private void set(int local, int type) {
        if (this.outputLocals == null) {
            this.outputLocals = new int[10];
        }
        int n = this.outputLocals.length;
        if (local >= n) {
            int[] t = new int[Math.max(local + 1, n * 2)];
            System.arraycopy(this.outputLocals, 0, t, 0, n);
            this.outputLocals = t;
        }
        this.outputLocals[local] = type;
    }

    private void push(int type) {
        if (this.outputStack == null) {
            this.outputStack = new int[10];
        }
        int n = this.outputStack.length;
        int i = this.outputStackTop;
        if (i >= n) {
            int[] t = new int[Math.max(i + 1, n * 2)];
            System.arraycopy(this.outputStack, 0, t, 0, n);
            this.outputStack = t;
        }
        int[] t2 = this.outputStack;
        int i2 = this.outputStackTop;
        this.outputStackTop = i2 + 1;
        t2[i2] = type;
        Label label = this.owner;
        int top = label.inputStackTop + this.outputStackTop;
        if (top > label.outputStackMax) {
            label.outputStackMax = top;
        }
    }

    private void push(ClassWriter cw, String desc) {
        int type = type(cw, desc);
        if (type != 0) {
            push(type);
            if (type == LONG || type == DOUBLE) {
                push(16777216);
            }
        }
    }

    private static int type(ClassWriter cw, String desc) {
        int data;
        int index = desc.charAt(0) == '(' ? desc.indexOf(41) + 1 : 0;
        char charAt = desc.charAt(index);
        if (charAt == 'F') {
            return FLOAT;
        }
        if (charAt == 'L') {
            return cw.addType(desc.substring(index + 1, desc.length() - 1)) | OBJECT;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (!(charAt == 'Z' || charAt == 'I')) {
                if (charAt == 'J') {
                    return LONG;
                }
                switch (charAt) {
                    case 'B':
                    case 'C':
                        break;
                    case 'D':
                        return DOUBLE;
                    default:
                        int dims = index + 1;
                        while (desc.charAt(dims) == '[') {
                            dims++;
                        }
                        char charAt2 = desc.charAt(dims);
                        if (charAt2 == 'F') {
                            data = FLOAT;
                        } else if (charAt2 == 'S') {
                            data = SHORT;
                        } else if (charAt2 == 'Z') {
                            data = BOOLEAN;
                        } else if (charAt2 == 'I') {
                            data = INTEGER;
                        } else if (charAt2 != 'J') {
                            switch (charAt2) {
                                case 'B':
                                    data = BYTE;
                                    break;
                                case 'C':
                                    data = CHAR;
                                    break;
                                case 'D':
                                    data = DOUBLE;
                                    break;
                                default:
                                    data = cw.addType(desc.substring(dims + 1, desc.length() - 1)) | OBJECT;
                                    break;
                            }
                        } else {
                            data = LONG;
                        }
                        return ((dims - index) << 28) | data;
                }
            }
        }
        return INTEGER;
    }

    private int pop() {
        int i = this.outputStackTop;
        if (i > 0) {
            int[] iArr = this.outputStack;
            int i2 = i - 1;
            this.outputStackTop = i2;
            return iArr[i2];
        }
        Label label = this.owner;
        int i3 = label.inputStackTop - 1;
        label.inputStackTop = i3;
        return STACK | (-i3);
    }

    private void pop(int elements) {
        int i = this.outputStackTop;
        if (i >= elements) {
            this.outputStackTop = i - elements;
            return;
        }
        this.owner.inputStackTop -= elements - i;
        this.outputStackTop = 0;
    }

    private void pop(String desc) {
        char c = desc.charAt(0);
        if (c == '(') {
            pop((Type.getArgumentsAndReturnSizes(desc) >> 2) - 1);
        } else if (c == 'J' || c == 'D') {
            pop(2);
        } else {
            pop(1);
        }
    }

    private void init(int var) {
        if (this.initializations == null) {
            this.initializations = new int[2];
        }
        int n = this.initializations.length;
        int i = this.initializationCount;
        if (i >= n) {
            int[] t = new int[Math.max(i + 1, n * 2)];
            System.arraycopy(this.initializations, 0, t, 0, n);
            this.initializations = t;
        }
        int[] t2 = this.initializations;
        int i2 = this.initializationCount;
        this.initializationCount = i2 + 1;
        t2[i2] = var;
    }

    private int init(ClassWriter cw, int t) {
        int s;
        if (t == UNINITIALIZED_THIS) {
            s = OBJECT | cw.addType(cw.thisName);
        } else if ((-1048576 & t) != UNINITIALIZED) {
            return t;
        } else {
            s = OBJECT | cw.addType(cw.typeTable[BASE_VALUE & t].strVal1);
        }
        for (int j = 0; j < this.initializationCount; j++) {
            int u = this.initializations[j];
            int dim = -268435456 & u;
            int kind = KIND & u;
            if (kind == LOCAL) {
                u = dim + this.inputLocals[VALUE & u];
            } else if (kind == STACK) {
                int[] iArr = this.inputStack;
                u = dim + iArr[iArr.length - (VALUE & u)];
            }
            if (t == u) {
                return s;
            }
        }
        return t;
    }

    /* access modifiers changed from: 0000 */
    public final void initInputFrame(ClassWriter cw, int access, Type[] args, int maxLocals) {
        int i;
        int i2;
        this.inputLocals = new int[maxLocals];
        this.inputStack = new int[0];
        if ((access & 8) != 0) {
            i = 0;
        } else if ((524288 & access) == 0) {
            i = 0 + 1;
            this.inputLocals[0] = OBJECT | cw.addType(cw.thisName);
        } else {
            i = 0 + 1;
            this.inputLocals[0] = UNINITIALIZED_THIS;
        }
        for (Type descriptor : args) {
            int t = type(cw, descriptor.getDescriptor());
            int i3 = i + 1;
            this.inputLocals[i] = t;
            if (t == LONG || t == DOUBLE) {
                int i4 = i3 + 1;
                this.inputLocals[i3] = 16777216;
                i2 = i4;
            } else {
                i2 = i3;
            }
        }
        while (i < maxLocals) {
            int i5 = i + 1;
            this.inputLocals[i] = 16777216;
            i = i5;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0333, code lost:
        push(DOUBLE);
        push(16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x033a, code lost:
        push(FLOAT);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x033e, code lost:
        push(LONG);
        push(16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0345, code lost:
        push(INTEGER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02b6, code lost:
        pop(2);
        push(DOUBLE);
        push(16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02cb, code lost:
        pop(2);
        push(LONG);
        push(16777216);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(int r17, int r18, org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassWriter r19, org.jacoco.agent.p025rt.internal_8ff85ea.asm.Item r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = 198(0xc6, float:2.77E-43)
            r6 = 1
            if (r1 == r5) goto L_0x0351
            r5 = 199(0xc7, float:2.79E-43)
            if (r1 == r5) goto L_0x0351
            r5 = 24117248(0x1700000, float:4.4081038E-38)
            r7 = 16777218(0x1000002, float:2.3509893E-38)
            r8 = 16777219(0x1000003, float:2.3509895E-38)
            r9 = 16777217(0x1000001, float:2.350989E-38)
            r10 = 16777220(0x1000004, float:2.3509898E-38)
            r11 = 16777216(0x1000000, float:2.3509887E-38)
            switch(r1) {
                case 0: goto L_0x0350;
                case 1: goto L_0x0349;
                case 2: goto L_0x0345;
                case 3: goto L_0x0345;
                case 4: goto L_0x0345;
                case 5: goto L_0x0345;
                case 6: goto L_0x0345;
                case 7: goto L_0x0345;
                case 8: goto L_0x0345;
                case 9: goto L_0x033e;
                case 10: goto L_0x033e;
                case 11: goto L_0x033a;
                case 12: goto L_0x033a;
                case 13: goto L_0x033a;
                case 14: goto L_0x0333;
                case 15: goto L_0x0333;
                case 16: goto L_0x0345;
                case 17: goto L_0x0345;
                case 18: goto L_0x02e8;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r1) {
                case 21: goto L_0x0345;
                case 22: goto L_0x033e;
                case 23: goto L_0x033a;
                case 24: goto L_0x0333;
                case 25: goto L_0x02df;
                default: goto L_0x0029;
            }
        L_0x0029:
            r12 = 8388608(0x800000, float:1.17549435E-38)
            r13 = 251658240(0xf000000, float:6.3108872E-30)
            switch(r1) {
                case 46: goto L_0x02d6;
                case 47: goto L_0x013e;
                case 48: goto L_0x02c2;
                case 49: goto L_0x02b6;
                case 50: goto L_0x02a7;
                case 51: goto L_0x02d6;
                case 52: goto L_0x02d6;
                case 53: goto L_0x02d6;
                case 54: goto L_0x027f;
                case 55: goto L_0x024f;
                case 56: goto L_0x027f;
                case 57: goto L_0x024f;
                case 58: goto L_0x027f;
                default: goto L_0x0030;
            }
        L_0x0030:
            r12 = 3
            r13 = 91
            r15 = 0
            r14 = 4
            switch(r1) {
                case 79: goto L_0x024a;
                case 80: goto L_0x0245;
                case 81: goto L_0x024a;
                case 82: goto L_0x0245;
                case 83: goto L_0x024a;
                case 84: goto L_0x024a;
                case 85: goto L_0x024a;
                case 86: goto L_0x024a;
                case 87: goto L_0x0351;
                case 88: goto L_0x023f;
                case 89: goto L_0x0233;
                case 90: goto L_0x0220;
                case 91: goto L_0x0206;
                case 92: goto L_0x01f0;
                case 93: goto L_0x01d3;
                case 94: goto L_0x01af;
                case 95: goto L_0x019f;
                case 96: goto L_0x0196;
                case 97: goto L_0x018b;
                case 98: goto L_0x0182;
                case 99: goto L_0x0177;
                case 100: goto L_0x0196;
                case 101: goto L_0x018b;
                case 102: goto L_0x0182;
                case 103: goto L_0x0177;
                case 104: goto L_0x0196;
                case 105: goto L_0x018b;
                case 106: goto L_0x0182;
                case 107: goto L_0x0177;
                case 108: goto L_0x0196;
                case 109: goto L_0x018b;
                case 110: goto L_0x0182;
                case 111: goto L_0x0177;
                case 112: goto L_0x0196;
                case 113: goto L_0x018b;
                case 114: goto L_0x0182;
                case 115: goto L_0x0177;
                case 116: goto L_0x0350;
                case 117: goto L_0x0350;
                case 118: goto L_0x0350;
                case 119: goto L_0x0350;
                case 120: goto L_0x0196;
                case 121: goto L_0x016c;
                case 122: goto L_0x0196;
                case 123: goto L_0x016c;
                case 124: goto L_0x0196;
                case 125: goto L_0x016c;
                case 126: goto L_0x0196;
                case 127: goto L_0x018b;
                case 128: goto L_0x0196;
                case 129: goto L_0x018b;
                case 130: goto L_0x0196;
                case 131: goto L_0x018b;
                case 132: goto L_0x0167;
                case 133: goto L_0x015c;
                case 134: goto L_0x0154;
                case 135: goto L_0x0149;
                case 136: goto L_0x0196;
                case 137: goto L_0x0182;
                case 138: goto L_0x02b6;
                case 139: goto L_0x0141;
                case 140: goto L_0x015c;
                case 141: goto L_0x0149;
                case 142: goto L_0x0196;
                case 143: goto L_0x013e;
                case 144: goto L_0x0182;
                case 145: goto L_0x0350;
                case 146: goto L_0x0350;
                case 147: goto L_0x0350;
                case 148: goto L_0x0136;
                case 149: goto L_0x0196;
                case 150: goto L_0x0196;
                case 151: goto L_0x0136;
                case 152: goto L_0x0136;
                case 153: goto L_0x0351;
                case 154: goto L_0x0351;
                case 155: goto L_0x0351;
                case 156: goto L_0x0351;
                case 157: goto L_0x0351;
                case 158: goto L_0x0351;
                case 159: goto L_0x023f;
                case 160: goto L_0x023f;
                case 161: goto L_0x023f;
                case 162: goto L_0x023f;
                case 163: goto L_0x023f;
                case 164: goto L_0x023f;
                case 165: goto L_0x023f;
                case 166: goto L_0x023f;
                case 167: goto L_0x0350;
                case 168: goto L_0x012e;
                case 169: goto L_0x012e;
                case 170: goto L_0x0351;
                case 171: goto L_0x0351;
                case 172: goto L_0x0351;
                case 173: goto L_0x023f;
                case 174: goto L_0x0351;
                case 175: goto L_0x023f;
                case 176: goto L_0x0351;
                case 177: goto L_0x0350;
                case 178: goto L_0x0127;
                case 179: goto L_0x0120;
                case 180: goto L_0x0116;
                case 181: goto L_0x010c;
                case 182: goto L_0x00e7;
                case 183: goto L_0x00e7;
                case 184: goto L_0x00e7;
                case 185: goto L_0x00e7;
                case 186: goto L_0x00db;
                case 187: goto L_0x00cd;
                case 188: goto L_0x0087;
                case 189: goto L_0x005c;
                case 190: goto L_0x0141;
                case 191: goto L_0x0351;
                case 192: goto L_0x0042;
                case 193: goto L_0x0141;
                case 194: goto L_0x0351;
                case 195: goto L_0x0351;
                default: goto L_0x0038;
            }
        L_0x0038:
            r0.pop(r2)
            java.lang.String r5 = r4.strVal1
            r0.push(r3, r5)
            goto L_0x0355
        L_0x0042:
            java.lang.String r6 = r4.strVal1
            r16.pop()
            char r7 = r6.charAt(r15)
            if (r7 != r13) goto L_0x0052
            r0.push(r3, r6)
            goto L_0x0355
        L_0x0052:
            int r7 = r3.addType(r6)
            r5 = r5 | r7
            r0.push(r5)
            goto L_0x0355
        L_0x005c:
            java.lang.String r5 = r4.strVal1
            r16.pop()
            char r6 = r5.charAt(r15)
            if (r6 != r13) goto L_0x007b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r13)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r0.push(r3, r6)
            goto L_0x0355
        L_0x007b:
            r6 = 292552704(0x11700000, float:1.8932662E-28)
            int r7 = r3.addType(r5)
            r6 = r6 | r7
            r0.push(r6)
            goto L_0x0355
        L_0x0087:
            r16.pop()
            switch(r2) {
                case 4: goto L_0x00c5;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00b5;
                case 7: goto L_0x00ad;
                case 8: goto L_0x00a5;
                case 9: goto L_0x009d;
                case 10: goto L_0x0095;
                default: goto L_0x008d;
            }
        L_0x008d:
            r5 = 285212676(0x11000004, float:1.0097424E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x0095:
            r5 = 285212673(0x11000001, float:1.0097421E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x009d:
            r5 = 285212684(0x1100000c, float:1.0097434E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x00a5:
            r5 = 285212682(0x1100000a, float:1.0097432E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x00ad:
            r5 = 285212675(0x11000003, float:1.0097423E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x00b5:
            r5 = 285212674(0x11000002, float:1.0097422E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x00bd:
            r5 = 285212683(0x1100000b, float:1.0097433E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x00c5:
            r5 = 285212681(0x11000009, float:1.009743E-28)
            r0.push(r5)
            goto L_0x0355
        L_0x00cd:
            r5 = 25165824(0x1800000, float:4.7019774E-38)
            java.lang.String r6 = r4.strVal1
            int r6 = r3.addUninitializedType(r6, r2)
            r5 = r5 | r6
            r0.push(r5)
            goto L_0x0355
        L_0x00db:
            java.lang.String r5 = r4.strVal2
            r0.pop(r5)
            java.lang.String r5 = r4.strVal2
            r0.push(r3, r5)
            goto L_0x0355
        L_0x00e7:
            java.lang.String r5 = r4.strVal3
            r0.pop(r5)
            r5 = 184(0xb8, float:2.58E-43)
            if (r1 == r5) goto L_0x0105
            int r5 = r16.pop()
            r6 = 183(0xb7, float:2.56E-43)
            if (r1 != r6) goto L_0x0105
            java.lang.String r6 = r4.strVal2
            char r6 = r6.charAt(r15)
            r7 = 60
            if (r6 != r7) goto L_0x0105
            r0.init(r5)
        L_0x0105:
            java.lang.String r5 = r4.strVal3
            r0.push(r3, r5)
            goto L_0x0355
        L_0x010c:
            java.lang.String r5 = r4.strVal3
            r0.pop(r5)
            r16.pop()
            goto L_0x0355
        L_0x0116:
            r0.pop(r6)
            java.lang.String r5 = r4.strVal3
            r0.push(r3, r5)
            goto L_0x0355
        L_0x0120:
            java.lang.String r5 = r4.strVal3
            r0.pop(r5)
            goto L_0x0355
        L_0x0127:
            java.lang.String r5 = r4.strVal3
            r0.push(r3, r5)
            goto L_0x0355
        L_0x012e:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "JSR/RET are not supported with computeFrames option"
            r5.<init>(r6)
            throw r5
        L_0x0136:
            r0.pop(r14)
            r0.push(r9)
            goto L_0x0355
        L_0x013e:
            r5 = 2
            goto L_0x02cb
        L_0x0141:
            r0.pop(r6)
            r0.push(r9)
            goto L_0x0355
        L_0x0149:
            r0.pop(r6)
            r0.push(r8)
            r0.push(r11)
            goto L_0x0355
        L_0x0154:
            r0.pop(r6)
            r0.push(r7)
            goto L_0x0355
        L_0x015c:
            r0.pop(r6)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0355
        L_0x0167:
            r0.set(r2, r9)
            goto L_0x0355
        L_0x016c:
            r0.pop(r12)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0355
        L_0x0177:
            r0.pop(r14)
            r0.push(r8)
            r0.push(r11)
            goto L_0x0355
        L_0x0182:
            r5 = 2
            r0.pop(r5)
            r0.push(r7)
            goto L_0x0355
        L_0x018b:
            r0.pop(r14)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0355
        L_0x0196:
            r5 = 2
            r0.pop(r5)
            r0.push(r9)
            goto L_0x0355
        L_0x019f:
            int r5 = r16.pop()
            int r6 = r16.pop()
            r0.push(r5)
            r0.push(r6)
            goto L_0x0355
        L_0x01af:
            int r5 = r16.pop()
            int r6 = r16.pop()
            int r7 = r16.pop()
            int r8 = r16.pop()
            r0.push(r6)
            r0.push(r5)
            r0.push(r8)
            r0.push(r7)
            r0.push(r6)
            r0.push(r5)
            goto L_0x0355
        L_0x01d3:
            int r5 = r16.pop()
            int r6 = r16.pop()
            int r7 = r16.pop()
            r0.push(r6)
            r0.push(r5)
            r0.push(r7)
            r0.push(r6)
            r0.push(r5)
            goto L_0x0355
        L_0x01f0:
            int r5 = r16.pop()
            int r6 = r16.pop()
            r0.push(r6)
            r0.push(r5)
            r0.push(r6)
            r0.push(r5)
            goto L_0x0355
        L_0x0206:
            int r5 = r16.pop()
            int r6 = r16.pop()
            int r7 = r16.pop()
            r0.push(r5)
            r0.push(r7)
            r0.push(r6)
            r0.push(r5)
            goto L_0x0355
        L_0x0220:
            int r5 = r16.pop()
            int r6 = r16.pop()
            r0.push(r5)
            r0.push(r6)
            r0.push(r5)
            goto L_0x0355
        L_0x0233:
            int r5 = r16.pop()
            r0.push(r5)
            r0.push(r5)
            goto L_0x0355
        L_0x023f:
            r5 = 2
            r0.pop(r5)
            goto L_0x0355
        L_0x0245:
            r0.pop(r14)
            goto L_0x0355
        L_0x024a:
            r0.pop(r12)
            goto L_0x0355
        L_0x024f:
            r0.pop(r6)
            int r5 = r16.pop()
            r0.set(r2, r5)
            int r6 = r2 + 1
            r0.set(r6, r11)
            if (r2 <= 0) goto L_0x0355
            int r6 = r2 + -1
            int r6 = r0.get(r6)
            if (r6 == r10) goto L_0x0278
            if (r6 != r8) goto L_0x026b
            goto L_0x0278
        L_0x026b:
            r7 = r6 & r13
            if (r7 == r11) goto L_0x0355
            int r7 = r2 + -1
            r8 = r6 | r12
            r0.set(r7, r8)
            goto L_0x0355
        L_0x0278:
            int r7 = r2 + -1
            r0.set(r7, r11)
            goto L_0x0355
        L_0x027f:
            int r5 = r16.pop()
            r0.set(r2, r5)
            if (r2 <= 0) goto L_0x0355
            int r6 = r2 + -1
            int r6 = r0.get(r6)
            if (r6 == r10) goto L_0x02a0
            if (r6 != r8) goto L_0x0293
            goto L_0x02a0
        L_0x0293:
            r7 = r6 & r13
            if (r7 == r11) goto L_0x0355
            int r7 = r2 + -1
            r8 = r6 | r12
            r0.set(r7, r8)
            goto L_0x0355
        L_0x02a0:
            int r7 = r2 + -1
            r0.set(r7, r11)
            goto L_0x0355
        L_0x02a7:
            r0.pop(r6)
            int r5 = r16.pop()
            r6 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            int r6 = r6 + r5
            r0.push(r6)
            goto L_0x0355
        L_0x02b6:
            r5 = 2
            r0.pop(r5)
            r0.push(r8)
            r0.push(r11)
            goto L_0x0355
        L_0x02c2:
            r5 = 2
            r0.pop(r5)
            r0.push(r7)
            goto L_0x0355
        L_0x02cb:
            r0.pop(r5)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0355
        L_0x02d6:
            r5 = 2
            r0.pop(r5)
            r0.push(r9)
            goto L_0x0355
        L_0x02df:
            int r5 = r0.get(r2)
            r0.push(r5)
            goto L_0x0355
        L_0x02e8:
            int r6 = r4.type
            r12 = 16
            if (r6 == r12) goto L_0x0328
            switch(r6) {
                case 3: goto L_0x0324;
                case 4: goto L_0x0320;
                case 5: goto L_0x0319;
                case 6: goto L_0x0312;
                case 7: goto L_0x0307;
                case 8: goto L_0x02fc;
                default: goto L_0x02f1;
            }
        L_0x02f1:
            java.lang.String r6 = "java/lang/invoke/MethodHandle"
            int r6 = r3.addType(r6)
            r5 = r5 | r6
            r0.push(r5)
            goto L_0x0355
        L_0x02fc:
            java.lang.String r6 = "java/lang/String"
            int r6 = r3.addType(r6)
            r5 = r5 | r6
            r0.push(r5)
            goto L_0x0355
        L_0x0307:
            java.lang.String r6 = "java/lang/Class"
            int r6 = r3.addType(r6)
            r5 = r5 | r6
            r0.push(r5)
            goto L_0x0355
        L_0x0312:
            r0.push(r8)
            r0.push(r11)
            goto L_0x0355
        L_0x0319:
            r0.push(r10)
            r0.push(r11)
            goto L_0x0355
        L_0x0320:
            r0.push(r7)
            goto L_0x0355
        L_0x0324:
            r0.push(r9)
            goto L_0x0355
        L_0x0328:
            java.lang.String r6 = "java/lang/invoke/MethodType"
            int r6 = r3.addType(r6)
            r5 = r5 | r6
            r0.push(r5)
            goto L_0x0355
        L_0x0333:
            r0.push(r8)
            r0.push(r11)
            goto L_0x0355
        L_0x033a:
            r0.push(r7)
            goto L_0x0355
        L_0x033e:
            r0.push(r10)
            r0.push(r11)
            goto L_0x0355
        L_0x0345:
            r0.push(r9)
            goto L_0x0355
        L_0x0349:
            r5 = 16777221(0x1000005, float:2.35099E-38)
            r0.push(r5)
            goto L_0x0355
        L_0x0350:
            goto L_0x0355
        L_0x0351:
            r0.pop(r6)
        L_0x0355:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.Frame.execute(int, int, org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter, org.jacoco.agent.rt.internal_8ff85ea.asm.Item):void");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010b, code lost:
        if (r11 == DOUBLE) goto L_0x0111;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean merge(org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassWriter r20, org.jacoco.agent.p025rt.internal_8ff85ea.asm.Frame r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = 0
            int[] r5 = r0.inputLocals
            int r5 = r5.length
            int[] r6 = r0.inputStack
            int r6 = r6.length
            int[] r7 = r2.inputLocals
            if (r7 != 0) goto L_0x0018
            int[] r7 = new int[r5]
            r2.inputLocals = r7
            r4 = 1
        L_0x0018:
            r7 = 0
        L_0x0019:
            r10 = 8388608(0x800000, float:1.17549435E-38)
            r11 = 33554432(0x2000000, float:9.403955E-38)
            r12 = 16777216(0x1000000, float:2.3509887E-38)
            r13 = 251658240(0xf000000, float:6.3108872E-30)
            r14 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r15 = 8388607(0x7fffff, float:1.1754942E-38)
            if (r7 >= r5) goto L_0x007c
            int[] r8 = r0.outputLocals
            if (r8 == 0) goto L_0x0066
            int r9 = r8.length
            if (r7 >= r9) goto L_0x0066
            r8 = r8[r7]
            if (r8 != 0) goto L_0x0038
            int[] r9 = r0.inputLocals
            r9 = r9[r7]
            goto L_0x006a
        L_0x0038:
            r9 = r8 & r14
            r13 = r13 & r8
            if (r13 != r12) goto L_0x0040
            r10 = r8
            r9 = r10
            goto L_0x006a
        L_0x0040:
            if (r13 != r11) goto L_0x004a
            int[] r11 = r0.inputLocals
            r12 = r8 & r15
            r11 = r11[r12]
            int r11 = r11 + r9
            goto L_0x0053
        L_0x004a:
            int[] r11 = r0.inputStack
            r12 = r8 & r15
            int r12 = r6 - r12
            r11 = r11[r12]
            int r11 = r11 + r9
        L_0x0053:
            r10 = r10 & r8
            if (r10 == 0) goto L_0x0064
            r10 = 16777220(0x1000004, float:2.3509898E-38)
            if (r11 == r10) goto L_0x0060
            r10 = 16777219(0x1000003, float:2.3509895E-38)
            if (r11 != r10) goto L_0x0064
        L_0x0060:
            r10 = 16777216(0x1000000, float:2.3509887E-38)
            r9 = r10
            goto L_0x006a
        L_0x0064:
            r9 = r11
            goto L_0x006a
        L_0x0066:
            int[] r8 = r0.inputLocals
            r9 = r8[r7]
        L_0x006a:
            int[] r8 = r0.initializations
            if (r8 == 0) goto L_0x0072
            int r9 = r0.init(r1, r9)
        L_0x0072:
            int[] r8 = r2.inputLocals
            boolean r8 = merge(r1, r9, r8, r7)
            r4 = r4 | r8
            int r7 = r7 + 1
            goto L_0x0019
        L_0x007c:
            if (r3 <= 0) goto L_0x00a2
            r7 = 0
        L_0x007f:
            if (r7 >= r5) goto L_0x008f
            int[] r8 = r0.inputLocals
            r8 = r8[r7]
            int[] r9 = r2.inputLocals
            boolean r9 = merge(r1, r8, r9, r7)
            r4 = r4 | r9
            int r7 = r7 + 1
            goto L_0x007f
        L_0x008f:
            int[] r8 = r2.inputStack
            if (r8 != 0) goto L_0x0099
            r8 = 1
            int[] r8 = new int[r8]
            r2.inputStack = r8
            r4 = 1
        L_0x0099:
            int[] r8 = r2.inputStack
            r9 = 0
            boolean r8 = merge(r1, r3, r8, r9)
            r4 = r4 | r8
            return r4
        L_0x00a2:
            int[] r8 = r0.inputStack
            int r8 = r8.length
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r9 = r0.owner
            int r9 = r9.inputStackTop
            int r8 = r8 + r9
            int[] r9 = r2.inputStack
            if (r9 != 0) goto L_0x00b6
            int r9 = r0.outputStackTop
            int r9 = r9 + r8
            int[] r9 = new int[r9]
            r2.inputStack = r9
            r4 = 1
        L_0x00b6:
            r7 = 0
        L_0x00b7:
            if (r7 >= r8) goto L_0x00d1
            int[] r9 = r0.inputStack
            r9 = r9[r7]
            int[] r10 = r0.initializations
            if (r10 == 0) goto L_0x00c5
            int r9 = r0.init(r1, r9)
        L_0x00c5:
            int[] r10 = r2.inputStack
            boolean r10 = merge(r1, r9, r10, r7)
            r4 = r4 | r10
            int r7 = r7 + 1
            r10 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b7
        L_0x00d1:
            r7 = 0
        L_0x00d2:
            int r9 = r0.outputStackTop
            if (r7 >= r9) goto L_0x0133
            int[] r9 = r0.outputStack
            r9 = r9[r7]
            r10 = r9 & r14
            r14 = r9 & r13
            if (r14 != r12) goto L_0x00ea
            r17 = r9
            r11 = r17
            r12 = 16777219(0x1000003, float:2.3509895E-38)
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0117
        L_0x00ea:
            if (r14 != r11) goto L_0x00f4
            int[] r11 = r0.inputLocals
            r18 = r9 & r15
            r11 = r11[r18]
            int r11 = r11 + r10
            goto L_0x00fd
        L_0x00f4:
            int[] r11 = r0.inputStack
            r18 = r9 & r15
            int r18 = r6 - r18
            r11 = r11[r18]
            int r11 = r11 + r10
        L_0x00fd:
            r16 = 8388608(0x800000, float:1.17549435E-38)
            r18 = r9 & r16
            if (r18 == 0) goto L_0x0114
            r12 = 16777220(0x1000004, float:2.3509898E-38)
            if (r11 == r12) goto L_0x010e
            r12 = 16777219(0x1000003, float:2.3509895E-38)
            if (r11 != r12) goto L_0x0117
            goto L_0x0111
        L_0x010e:
            r12 = 16777219(0x1000003, float:2.3509895E-38)
        L_0x0111:
            r11 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x0117
        L_0x0114:
            r12 = 16777219(0x1000003, float:2.3509895E-38)
        L_0x0117:
            int[] r12 = r0.initializations
            if (r12 == 0) goto L_0x011f
            int r11 = r0.init(r1, r11)
        L_0x011f:
            int[] r12 = r2.inputStack
            int r13 = r8 + r7
            boolean r12 = merge(r1, r11, r12, r13)
            r4 = r4 | r12
            int r7 = r7 + 1
            r11 = 33554432(0x2000000, float:9.403955E-38)
            r12 = 16777216(0x1000000, float:2.3509887E-38)
            r13 = 251658240(0xf000000, float:6.3108872E-30)
            r14 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            goto L_0x00d2
        L_0x0133:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.Frame.merge(org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter, org.jacoco.agent.rt.internal_8ff85ea.asm.Frame, int):boolean");
    }

    private static boolean merge(ClassWriter cw, int t, int[] types, int index) {
        int v;
        int u = types[index];
        if (u == t) {
            return false;
        }
        if ((268435455 & t) == NULL) {
            if (u == NULL) {
                return false;
            }
            t = NULL;
        }
        if (u == 0) {
            types[index] = t;
            return true;
        }
        if ((u & BASE_KIND) != OBJECT && (u & -268435456) == 0) {
            v = u == NULL ? ((t & BASE_KIND) == OBJECT || (t & -268435456) != 0) ? t : 16777216 : 16777216;
        } else if (t == NULL) {
            return false;
        } else {
            String str = "java/lang/Object";
            if ((t & -1048576) == (-1048576 & u)) {
                v = (u & BASE_KIND) == OBJECT ? (t & -268435456) | OBJECT | cw.getMergedType(t & BASE_VALUE, BASE_VALUE & u) : ((u & -268435456) - 268435456) | OBJECT | cw.addType(str);
            } else if ((t & BASE_KIND) == OBJECT || (t & -268435456) != 0) {
                v = Math.min((((t & -268435456) == 0 || (t & BASE_KIND) == OBJECT) ? 0 : -268435456) + (t & -268435456), (((u & -268435456) == 0 || (BASE_KIND & u) == OBJECT) ? 0 : -268435456) + (u & -268435456)) | OBJECT | cw.addType(str);
            } else {
                v = 16777216;
            }
        }
        if (u == v) {
            return false;
        }
        types[index] = v;
        return true;
    }
}
