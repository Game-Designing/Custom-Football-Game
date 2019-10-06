package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.NoneProbeArrayStrategy */
class NoneProbeArrayStrategy implements IProbeArrayStrategy {
    NoneProbeArrayStrategy() {
    }

    public int storeInstance(MethodVisitor mv, boolean clinit, int variable) {
        throw new UnsupportedOperationException();
    }

    public void addMembers(ClassVisitor delegate, int probeCount) {
    }
}
