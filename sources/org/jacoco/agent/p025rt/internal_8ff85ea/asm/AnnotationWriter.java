package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter */
final class AnnotationWriter extends AnnotationVisitor {

    /* renamed from: bv */
    private final ByteVector f43238bv;

    /* renamed from: cw */
    private final ClassWriter f43239cw;
    private final boolean named;
    AnnotationWriter next;
    private final int offset;
    private final ByteVector parent;
    AnnotationWriter prev;
    private int size;

    AnnotationWriter(ClassWriter cw, boolean named2, ByteVector bv, ByteVector parent2, int offset2) {
        super(327680);
        this.f43239cw = cw;
        this.named = named2;
        this.f43238bv = bv;
        this.parent = parent2;
        this.offset = offset2;
    }

    public void visit(String name, Object value) {
        this.size++;
        if (this.named) {
            this.f43238bv.putShort(this.f43239cw.newUTF8(name));
        }
        if (value instanceof String) {
            this.f43238bv.put12(115, this.f43239cw.newUTF8((String) value));
        } else if (value instanceof Byte) {
            this.f43238bv.put12(66, this.f43239cw.newInteger(((Byte) value).byteValue()).index);
        } else if (value instanceof Boolean) {
            this.f43238bv.put12(90, this.f43239cw.newInteger((int) ((Boolean) value).booleanValue()).index);
        } else if (value instanceof Character) {
            this.f43238bv.put12(67, this.f43239cw.newInteger(((Character) value).charValue()).index);
        } else if (value instanceof Short) {
            this.f43238bv.put12(83, this.f43239cw.newInteger(((Short) value).shortValue()).index);
        } else if (value instanceof Type) {
            this.f43238bv.put12(99, this.f43239cw.newUTF8(((Type) value).getDescriptor()));
        } else if (value instanceof byte[]) {
            byte[] v = (byte[]) value;
            this.f43238bv.put12(91, v.length);
            for (byte newInteger : v) {
                this.f43238bv.put12(66, this.f43239cw.newInteger(newInteger).index);
            }
        } else if (value instanceof boolean[]) {
            boolean[] v2 = (boolean[]) value;
            this.f43238bv.put12(91, v2.length);
            for (int i = 0; i < v2.length; i++) {
                this.f43238bv.put12(90, this.f43239cw.newInteger(v2[i] ? 1 : 0).index);
            }
        } else if (value instanceof short[]) {
            short[] v3 = (short[]) value;
            this.f43238bv.put12(91, v3.length);
            for (short newInteger2 : v3) {
                this.f43238bv.put12(83, this.f43239cw.newInteger(newInteger2).index);
            }
        } else if (value instanceof char[]) {
            char[] v4 = (char[]) value;
            this.f43238bv.put12(91, v4.length);
            for (char newInteger3 : v4) {
                this.f43238bv.put12(67, this.f43239cw.newInteger(newInteger3).index);
            }
        } else if (value instanceof int[]) {
            int[] v5 = (int[]) value;
            this.f43238bv.put12(91, v5.length);
            for (int newInteger4 : v5) {
                this.f43238bv.put12(73, this.f43239cw.newInteger(newInteger4).index);
            }
        } else if (value instanceof long[]) {
            long[] v6 = (long[]) value;
            this.f43238bv.put12(91, v6.length);
            for (long newLong : v6) {
                this.f43238bv.put12(74, this.f43239cw.newLong(newLong).index);
            }
        } else if (value instanceof float[]) {
            float[] v7 = (float[]) value;
            this.f43238bv.put12(91, v7.length);
            for (float newFloat : v7) {
                this.f43238bv.put12(70, this.f43239cw.newFloat(newFloat).index);
            }
        } else if (value instanceof double[]) {
            double[] v8 = (double[]) value;
            this.f43238bv.put12(91, v8.length);
            for (double newDouble : v8) {
                this.f43238bv.put12(68, this.f43239cw.newDouble(newDouble).index);
            }
        } else {
            Item i2 = this.f43239cw.newConstItem(value);
            this.f43238bv.put12(".s.IFJDCS".charAt(i2.type), i2.index);
        }
    }

    public void visitEnum(String name, String desc, String value) {
        this.size++;
        if (this.named) {
            this.f43238bv.putShort(this.f43239cw.newUTF8(name));
        }
        this.f43238bv.put12(101, this.f43239cw.newUTF8(desc)).putShort(this.f43239cw.newUTF8(value));
    }

    public AnnotationVisitor visitAnnotation(String name, String desc) {
        this.size++;
        if (this.named) {
            this.f43238bv.putShort(this.f43239cw.newUTF8(name));
        }
        this.f43238bv.put12(64, this.f43239cw.newUTF8(desc)).putShort(0);
        ClassWriter classWriter = this.f43239cw;
        ByteVector byteVector = this.f43238bv;
        AnnotationWriter annotationWriter = new AnnotationWriter(classWriter, true, byteVector, byteVector, byteVector.length - 2);
        return annotationWriter;
    }

    public AnnotationVisitor visitArray(String name) {
        this.size++;
        if (this.named) {
            this.f43238bv.putShort(this.f43239cw.newUTF8(name));
        }
        this.f43238bv.put12(91, 0);
        ClassWriter classWriter = this.f43239cw;
        ByteVector byteVector = this.f43238bv;
        AnnotationWriter annotationWriter = new AnnotationWriter(classWriter, false, byteVector, byteVector, byteVector.length - 2);
        return annotationWriter;
    }

    public void visitEnd() {
        ByteVector byteVector = this.parent;
        if (byteVector != null) {
            byte[] data = byteVector.data;
            int i = this.offset;
            int i2 = this.size;
            data[i] = (byte) (i2 >>> 8);
            data[i + 1] = (byte) i2;
        }
    }

    /* access modifiers changed from: 0000 */
    public int getSize() {
        int size2 = 0;
        for (AnnotationWriter aw = this; aw != null; aw = aw.next) {
            size2 += aw.f43238bv.length;
        }
        return size2;
    }

    /* access modifiers changed from: 0000 */
    public void put(ByteVector out) {
        int n = 0;
        int size2 = 2;
        AnnotationWriter last = null;
        for (AnnotationWriter aw = this; aw != null; aw = aw.next) {
            n++;
            size2 += aw.f43238bv.length;
            aw.visitEnd();
            aw.prev = last;
            last = aw;
        }
        out.putInt(size2);
        out.putShort(n);
        for (AnnotationWriter aw2 = last; aw2 != null; aw2 = aw2.prev) {
            ByteVector byteVector = aw2.f43238bv;
            out.putByteArray(byteVector.data, 0, byteVector.length);
        }
    }

    static void put(AnnotationWriter[] panns, int off, ByteVector out) {
        int size2 = ((panns.length - off) * 2) + 1;
        int i = off;
        while (true) {
            int i2 = 0;
            if (i >= panns.length) {
                break;
            }
            if (panns[i] != null) {
                i2 = panns[i].getSize();
            }
            size2 += i2;
            i++;
        }
        out.putInt(size2).putByte(panns.length - off);
        for (int i3 = off; i3 < panns.length; i3++) {
            AnnotationWriter last = null;
            int n = 0;
            for (AnnotationWriter aw = panns[i3]; aw != null; aw = aw.next) {
                n++;
                aw.visitEnd();
                aw.prev = last;
                last = aw;
            }
            out.putShort(n);
            for (AnnotationWriter aw2 = last; aw2 != null; aw2 = aw2.prev) {
                ByteVector byteVector = aw2.f43238bv;
                out.putByteArray(byteVector.data, 0, byteVector.length);
            }
        }
    }

    static void putTarget(int typeRef, TypePath typePath, ByteVector out) {
        int i = typeRef >>> 24;
        if (!(i == 0 || i == 1)) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                    out.putByte(typeRef >>> 24);
                    break;
                case 22:
                    break;
                default:
                    switch (i) {
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            out.putInt(typeRef);
                            break;
                        default:
                            out.put12(typeRef >>> 24, (16776960 & typeRef) >> 8);
                            break;
                    }
            }
        }
        out.putShort(typeRef >>> 16);
        if (typePath == null) {
            out.putByte(0);
            return;
        }
        byte[] bArr = typePath.f43246b;
        int i2 = typePath.offset;
        out.putByteArray(bArr, i2, (bArr[i2] * 2) + 1);
    }
}
