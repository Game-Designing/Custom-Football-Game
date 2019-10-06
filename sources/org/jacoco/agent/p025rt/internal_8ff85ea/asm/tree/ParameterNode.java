package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.ParameterNode */
public class ParameterNode {
    public int access;
    public String name;

    public ParameterNode(String name2, int access2) {
        this.name = name2;
        this.access = access2;
    }

    public void accept(MethodVisitor mv) {
        mv.visitParameter(this.name, this.access);
    }
}
