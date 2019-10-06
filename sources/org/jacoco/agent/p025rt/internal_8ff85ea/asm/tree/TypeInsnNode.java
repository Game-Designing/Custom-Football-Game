package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TypeInsnNode */
public class TypeInsnNode extends AbstractInsnNode {
    public String desc;

    public TypeInsnNode(int opcode, String desc2) {
        super(opcode);
        this.desc = desc2;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getType() {
        return 3;
    }

    public void accept(MethodVisitor mv) {
        mv.visitTypeInsn(this.opcode, this.desc);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new TypeInsnNode(this.opcode, this.desc).cloneAnnotations(this);
    }
}
