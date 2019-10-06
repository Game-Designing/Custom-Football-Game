package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.IincInsnNode */
public class IincInsnNode extends AbstractInsnNode {
    public int incr;
    public int var;

    public IincInsnNode(int var2, int incr2) {
        super(Opcodes.IINC);
        this.var = var2;
        this.incr = incr2;
    }

    public int getType() {
        return 10;
    }

    public void accept(MethodVisitor mv) {
        mv.visitIincInsn(this.var, this.incr);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new IincInsnNode(this.var, this.incr).cloneAnnotations(this);
    }
}
