package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Label */
public class Label {
    static final int DEBUG = 1;
    static final int JSR = 128;
    static final int PUSHED = 8;
    static final int REACHABLE = 64;
    static final int RESIZED = 4;
    static final int RESOLVED = 2;
    static final int RET = 256;
    static final int STORE = 32;
    static final int SUBROUTINE = 512;
    static final int TARGET = 16;
    static final int VISITED = 1024;
    static final int VISITED2 = 2048;
    Frame frame;
    public Object info;
    int inputStackTop;
    int line;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;
    Edge successors;

    public int getOffset() {
        if ((this.status & 2) != 0) {
            return this.position;
        }
        throw new IllegalStateException("Label offset position has not been resolved yet");
    }

    /* access modifiers changed from: 0000 */
    public void put(MethodWriter owner, ByteVector out, int source, boolean wideOffset) {
        if ((this.status & 2) == 0) {
            if (wideOffset) {
                addReference(-1 - source, out.length);
                out.putInt(-1);
                return;
            }
            addReference(source, out.length);
            out.putShort(-1);
        } else if (wideOffset) {
            out.putInt(this.position - source);
        } else {
            out.putShort(this.position - source);
        }
    }

    private void addReference(int sourcePosition, int referencePosition) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i >= iArr.length) {
            int[] a = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, a, 0, iArr.length);
            this.srcAndRefPositions = a;
        }
        int[] a2 = this.srcAndRefPositions;
        int i2 = this.referenceCount;
        this.referenceCount = i2 + 1;
        a2[i2] = sourcePosition;
        int i3 = this.referenceCount;
        this.referenceCount = i3 + 1;
        a2[i3] = referencePosition;
    }

    /* access modifiers changed from: 0000 */
    public boolean resolve(MethodWriter owner, int position2, byte[] data) {
        boolean needUpdate = false;
        this.status |= 2;
        this.position = position2;
        int source = 0;
        while (source < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i = source + 1;
            int source2 = iArr[source];
            int i2 = i + 1;
            int reference = iArr[i];
            if (source2 >= 0) {
                int offset = position2 - source2;
                if (offset < -32768 || offset > 32767) {
                    int opcode = data[reference - 1] & 255;
                    if (opcode <= 168) {
                        data[reference - 1] = (byte) (opcode + 49);
                    } else {
                        data[reference - 1] = (byte) (opcode + 20);
                    }
                    needUpdate = true;
                }
                int opcode2 = reference + 1;
                data[reference] = (byte) (offset >>> 8);
                data[opcode2] = (byte) offset;
            } else {
                int offset2 = position2 + source2 + 1;
                int reference2 = reference + 1;
                data[reference] = (byte) (offset2 >>> 24);
                int reference3 = reference2 + 1;
                data[reference2] = (byte) (offset2 >>> 16);
                int reference4 = reference3 + 1;
                data[reference3] = (byte) (offset2 >>> 8);
                data[reference4] = (byte) offset2;
            }
            source = i2;
        }
        return needUpdate;
    }

    /* access modifiers changed from: 0000 */
    public Label getFirst() {
        Frame frame2 = this.frame;
        return frame2 == null ? this : frame2.owner;
    }

    /* access modifiers changed from: 0000 */
    public boolean inSubroutine(long id) {
        boolean z = false;
        if ((this.status & 1024) == 0) {
            return false;
        }
        if ((this.srcAndRefPositions[(int) (id >>> 32)] & ((int) id)) != 0) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean inSameSubroutine(Label block) {
        if ((this.status & 1024) == 0 || (block.status & 1024) == 0) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.srcAndRefPositions;
            if (i >= iArr.length) {
                return false;
            }
            if ((iArr[i] & block.srcAndRefPositions[i]) != 0) {
                return true;
            }
            i++;
        }
    }

    /* access modifiers changed from: 0000 */
    public void addToSubroutine(long id, int nbSubroutines) {
        int i = this.status;
        if ((i & 1024) == 0) {
            this.status = i | 1024;
            this.srcAndRefPositions = new int[((nbSubroutines / 32) + 1)];
        }
        int[] iArr = this.srcAndRefPositions;
        int i2 = (int) (id >>> 32);
        iArr[i2] = iArr[i2] | ((int) id);
    }

    /* access modifiers changed from: 0000 */
    public void visitSubroutine(Label JSR2, long id, int nbSubroutines) {
        Label stack = this;
        while (stack != null) {
            Label l = stack;
            stack = l.next;
            l.next = null;
            if (JSR2 != null) {
                int i = l.status;
                if ((i & 2048) == 0) {
                    l.status = i | 2048;
                    if ((l.status & 256) != 0 && !l.inSameSubroutine(JSR2)) {
                        Edge e = new Edge();
                        e.info = l.inputStackTop;
                        e.successor = JSR2.successors.successor;
                        e.next = l.successors;
                        l.successors = e;
                    }
                }
            } else if (!l.inSubroutine(id)) {
                l.addToSubroutine(id, nbSubroutines);
            }
            for (Edge e2 = l.successors; e2 != null; e2 = e2.next) {
                if ((l.status & 128) == 0 || e2 != l.successors.next) {
                    Label label = e2.successor;
                    if (label.next == null) {
                        label.next = stack;
                        stack = e2.successor;
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("L");
        sb.append(System.identityHashCode(this));
        return sb.toString();
    }
}
