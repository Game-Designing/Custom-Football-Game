package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.ClassProbesVisitor */
public abstract class ClassProbesVisitor extends ClassVisitor {
    public abstract MethodProbesVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr);

    public abstract void visitTotalProbeCount(int i);

    public ClassProbesVisitor() {
        this(null);
    }

    public ClassProbesVisitor(ClassVisitor cv) {
        super(327680, cv);
    }
}
