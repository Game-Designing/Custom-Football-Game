package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.LocalProbeArrayStrategy */
class LocalProbeArrayStrategy implements IProbeArrayStrategy {
    private final IExecutionDataAccessorGenerator accessorGenerator;
    private final long classId;
    private final String className;
    private final int probeCount;

    LocalProbeArrayStrategy(String className2, long classId2, int probeCount2, IExecutionDataAccessorGenerator accessorGenerator2) {
        this.className = className2;
        this.classId = classId2;
        this.probeCount = probeCount2;
        this.accessorGenerator = accessorGenerator2;
    }

    public int storeInstance(MethodVisitor mv, boolean clinit, int variable) {
        int maxStack = this.accessorGenerator.generateDataAccessor(this.classId, this.className, this.probeCount, mv);
        mv.visitVarInsn(58, variable);
        return maxStack;
    }

    public void addMembers(ClassVisitor delegate, int probeCount2) {
    }
}
