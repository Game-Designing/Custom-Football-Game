package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.MethodInsnNode */
public class MethodInsnNode extends AbstractInsnNode {
    public String desc;
    public boolean itf;
    public String name;
    public String owner;

    @Deprecated
    public MethodInsnNode(int opcode, String owner2, String name2, String desc2) {
        this(opcode, owner2, name2, desc2, opcode == 185);
    }

    public MethodInsnNode(int opcode, String owner2, String name2, String desc2, boolean itf2) {
        super(opcode);
        this.owner = owner2;
        this.name = name2;
        this.desc = desc2;
        this.itf = itf2;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getType() {
        return 5;
    }

    public void accept(MethodVisitor mv) {
        mv.visitMethodInsn(this.opcode, this.owner, this.name, this.desc, this.itf);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        MethodInsnNode methodInsnNode = new MethodInsnNode(this.opcode, this.owner, this.name, this.desc, this.itf);
        return methodInsnNode;
    }
}
