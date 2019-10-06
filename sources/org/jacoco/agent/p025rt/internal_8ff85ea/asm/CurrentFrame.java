package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.CurrentFrame */
class CurrentFrame extends Frame {
    CurrentFrame() {
    }

    /* access modifiers changed from: 0000 */
    public void execute(int opcode, int arg, ClassWriter cw, Item item) {
        super.execute(opcode, arg, cw, item);
        Frame successor = new Frame();
        merge(cw, successor, 0);
        set(successor);
        this.owner.inputStackTop = 0;
    }
}
