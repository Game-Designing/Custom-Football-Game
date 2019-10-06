package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.FieldInsnNode */
public class FieldInsnNode extends AbstractInsnNode {
    public String desc;
    public String name;
    public String owner;

    public FieldInsnNode(int opcode, String owner2, String name2, String desc2) {
        super(opcode);
        this.owner = owner2;
        this.name = name2;
        this.desc = desc2;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getType() {
        return 4;
    }

    public void accept(MethodVisitor mv) {
        mv.visitFieldInsn(this.opcode, this.owner, this.name, this.desc);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new FieldInsnNode(this.opcode, this.owner, this.name, this.desc).cloneAnnotations(this);
    }
}
