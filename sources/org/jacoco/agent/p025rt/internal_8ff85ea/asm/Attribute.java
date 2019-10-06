package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute */
public class Attribute {
    Attribute next;
    public final String type;
    byte[] value;

    protected Attribute(String type2) {
        this.type = type2;
    }

    public boolean isUnknown() {
        return true;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Label[] getLabels() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader cr, int off, int len, char[] buf, int codeOff, Label[] labels) {
        Attribute attr = new Attribute(this.type);
        attr.value = new byte[len];
        System.arraycopy(cr.f43240b, off, attr.value, 0, len);
        return attr;
    }

    /* access modifiers changed from: protected */
    public ByteVector write(ClassWriter cw, byte[] code, int len, int maxStack, int maxLocals) {
        ByteVector v = new ByteVector();
        byte[] bArr = this.value;
        v.data = bArr;
        v.length = bArr.length;
        return v;
    }

    /* access modifiers changed from: 0000 */
    public final int getCount() {
        int count = 0;
        for (Attribute attr = this; attr != null; attr = attr.next) {
            count++;
        }
        return count;
    }

    /* access modifiers changed from: 0000 */
    public final int getSize(ClassWriter cw, byte[] code, int len, int maxStack, int maxLocals) {
        int size = 0;
        for (Attribute attr = this; attr != null; attr = attr.next) {
            cw.newUTF8(attr.type);
            size += attr.write(cw, code, len, maxStack, maxLocals).length + 6;
        }
        return size;
    }

    /* access modifiers changed from: 0000 */
    public final void put(ClassWriter cw, byte[] code, int len, int maxStack, int maxLocals, ByteVector out) {
        for (Attribute attr = this; attr != null; attr = attr.next) {
            ByteVector b = attr.write(cw, code, len, maxStack, maxLocals);
            out.putShort(cw.newUTF8(attr.type)).putInt(b.length);
            out.putByteArray(b.data, 0, b.length);
        }
    }
}
