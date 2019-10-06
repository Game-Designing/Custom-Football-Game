package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.InsnNode */
public class InsnNode extends AbstractInsnNode {
    public InsnNode(int opcode) {
        super(opcode);
    }

    public int getType() {
        return 0;
    }

    public void accept(MethodVisitor mv) {
        mv.visitInsn(this.opcode);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new InsnNode(this.opcode).cloneAnnotations(this);
    }
}
