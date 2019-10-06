package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.InvokeDynamicInsnNode */
public class InvokeDynamicInsnNode extends AbstractInsnNode {
    public Handle bsm;
    public Object[] bsmArgs;
    public String desc;
    public String name;

    public InvokeDynamicInsnNode(String name2, String desc2, Handle bsm2, Object... bsmArgs2) {
        super(Opcodes.INVOKEDYNAMIC);
        this.name = name2;
        this.desc = desc2;
        this.bsm = bsm2;
        this.bsmArgs = bsmArgs2;
    }

    public int getType() {
        return 6;
    }

    public void accept(MethodVisitor mv) {
        mv.visitInvokeDynamicInsn(this.name, this.desc, this.bsm, this.bsmArgs);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new InvokeDynamicInsnNode(this.name, this.desc, this.bsm, this.bsmArgs).cloneAnnotations(this);
    }
}
