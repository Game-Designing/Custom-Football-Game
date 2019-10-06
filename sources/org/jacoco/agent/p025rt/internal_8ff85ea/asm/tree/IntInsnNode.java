package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.IntInsnNode */
public class IntInsnNode extends AbstractInsnNode {
    public int operand;

    public IntInsnNode(int opcode, int operand2) {
        super(opcode);
        this.operand = operand2;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getType() {
        return 1;
    }

    public void accept(MethodVisitor mv) {
        mv.visitIntInsn(this.opcode, this.operand);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new IntInsnNode(this.opcode, this.operand).cloneAnnotations(this);
    }
}
