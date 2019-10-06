package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.IProbeArrayStrategy */
public interface IProbeArrayStrategy {
    void addMembers(ClassVisitor classVisitor, int i);

    int storeInstance(MethodVisitor methodVisitor, boolean z, int i);
}
