package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LocalVariableNode */
public class LocalVariableNode {
    public String desc;
    public LabelNode end;
    public int index;
    public String name;
    public String signature;
    public LabelNode start;

    public LocalVariableNode(String name2, String desc2, String signature2, LabelNode start2, LabelNode end2, int index2) {
        this.name = name2;
        this.desc = desc2;
        this.signature = signature2;
        this.start = start2;
        this.end = end2;
        this.index = index2;
    }

    public void accept(MethodVisitor mv) {
        mv.visitLocalVariable(this.name, this.desc, this.signature, this.start.getLabel(), this.end.getLabel(), this.index);
    }
}
