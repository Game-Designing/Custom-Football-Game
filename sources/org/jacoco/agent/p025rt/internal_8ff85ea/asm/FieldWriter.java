package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.FieldWriter */
final class FieldWriter extends FieldVisitor {
    private final int access;
    private AnnotationWriter anns;
    private Attribute attrs;

    /* renamed from: cw */
    private final ClassWriter f43244cw;
    private final int desc;
    private AnnotationWriter ianns;
    private AnnotationWriter itanns;
    private final int name;
    private int signature;
    private AnnotationWriter tanns;
    private int value;

    FieldWriter(ClassWriter cw, int access2, String name2, String desc2, String signature2, Object value2) {
        super(327680);
        if (cw.firstField == null) {
            cw.firstField = this;
        } else {
            cw.lastField.f43243fv = this;
        }
        cw.lastField = this;
        this.f43244cw = cw;
        this.access = access2;
        this.name = cw.newUTF8(name2);
        this.desc = cw.newUTF8(desc2);
        if (signature2 != null) {
            this.signature = cw.newUTF8(signature2);
        }
        if (value2 != null) {
            this.value = cw.newConstItem(value2).index;
        }
    }

    public AnnotationVisitor visitAnnotation(String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        bv.putShort(this.f43244cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43244cw, true, bv, bv, 2);
        if (visible) {
            aw.next = this.anns;
            this.anns = aw;
        } else {
            aw.next = this.ianns;
            this.ianns = aw;
        }
        return aw;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        AnnotationWriter.putTarget(typeRef, typePath, bv);
        bv.putShort(this.f43244cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43244cw, true, bv, bv, bv.length - 2);
        if (visible) {
            aw.next = this.tanns;
            this.tanns = aw;
        } else {
            aw.next = this.itanns;
            this.itanns = aw;
        }
        return aw;
    }

    public void visitAttribute(Attribute attr) {
        attr.next = this.attrs;
        this.attrs = attr;
    }

    public void visitEnd() {
    }

    /* access modifiers changed from: 0000 */
    public int getSize() {
        int size = 8;
        if (this.value != 0) {
            this.f43244cw.newUTF8("ConstantValue");
            size = 8 + 8;
        }
        int i = this.access;
        if ((i & Opcodes.ACC_SYNTHETIC) != 0 && ((this.f43244cw.version & 65535) < 49 || (i & Opcodes.ASM4) != 0)) {
            this.f43244cw.newUTF8("Synthetic");
            size += 6;
        }
        if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
            this.f43244cw.newUTF8("Deprecated");
            size += 6;
        }
        if (this.signature != 0) {
            this.f43244cw.newUTF8("Signature");
            size += 8;
        }
        if (this.anns != null) {
            this.f43244cw.newUTF8("RuntimeVisibleAnnotations");
            size += this.anns.getSize() + 8;
        }
        if (this.ianns != null) {
            this.f43244cw.newUTF8("RuntimeInvisibleAnnotations");
            size += this.ianns.getSize() + 8;
        }
        if (this.tanns != null) {
            this.f43244cw.newUTF8("RuntimeVisibleTypeAnnotations");
            size += this.tanns.getSize() + 8;
        }
        if (this.itanns != null) {
            this.f43244cw.newUTF8("RuntimeInvisibleTypeAnnotations");
            size += this.itanns.getSize() + 8;
        }
        Attribute attribute = this.attrs;
        if (attribute != null) {
            return size + attribute.getSize(this.f43244cw, null, 0, -1, -1);
        }
        return size;
    }

    /* access modifiers changed from: 0000 */
    public void put(ByteVector out) {
        int i = this.access;
        out.putShort(i & ((((i & Opcodes.ASM4) / 64) | 393216) ^ -1)).putShort(this.name).putShort(this.desc);
        int attributeCount = 0;
        if (this.value != 0) {
            attributeCount = 0 + 1;
        }
        int i2 = this.access;
        if ((i2 & Opcodes.ACC_SYNTHETIC) != 0 && ((this.f43244cw.version & 65535) < 49 || (i2 & Opcodes.ASM4) != 0)) {
            attributeCount++;
        }
        if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
            attributeCount++;
        }
        if (this.signature != 0) {
            attributeCount++;
        }
        if (this.anns != null) {
            attributeCount++;
        }
        if (this.ianns != null) {
            attributeCount++;
        }
        if (this.tanns != null) {
            attributeCount++;
        }
        if (this.itanns != null) {
            attributeCount++;
        }
        Attribute attribute = this.attrs;
        if (attribute != null) {
            attributeCount += attribute.getCount();
        }
        out.putShort(attributeCount);
        if (this.value != 0) {
            out.putShort(this.f43244cw.newUTF8("ConstantValue"));
            out.putInt(2).putShort(this.value);
        }
        int i3 = this.access;
        if ((i3 & Opcodes.ACC_SYNTHETIC) != 0 && ((65535 & this.f43244cw.version) < 49 || (262144 & i3) != 0)) {
            out.putShort(this.f43244cw.newUTF8("Synthetic")).putInt(0);
        }
        if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
            out.putShort(this.f43244cw.newUTF8("Deprecated")).putInt(0);
        }
        if (this.signature != 0) {
            out.putShort(this.f43244cw.newUTF8("Signature"));
            out.putInt(2).putShort(this.signature);
        }
        if (this.anns != null) {
            out.putShort(this.f43244cw.newUTF8("RuntimeVisibleAnnotations"));
            this.anns.put(out);
        }
        if (this.ianns != null) {
            out.putShort(this.f43244cw.newUTF8("RuntimeInvisibleAnnotations"));
            this.ianns.put(out);
        }
        if (this.tanns != null) {
            out.putShort(this.f43244cw.newUTF8("RuntimeVisibleTypeAnnotations"));
            this.tanns.put(out);
        }
        if (this.itanns != null) {
            out.putShort(this.f43244cw.newUTF8("RuntimeInvisibleTypeAnnotations"));
            this.itanns.put(out);
        }
        Attribute attribute2 = this.attrs;
        if (attribute2 != null) {
            attribute2.put(this.f43244cw, null, 0, -1, -1, out);
        }
    }
}
