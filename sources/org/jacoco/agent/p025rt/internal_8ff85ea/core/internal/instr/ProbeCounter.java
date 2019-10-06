package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.ClassProbesVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ProbeCounter */
class ProbeCounter extends ClassProbesVisitor {
    private int count = 0;
    private boolean methods = false;

    ProbeCounter() {
    }

    public MethodProbesVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (!"<clinit>".equals(name) && (access & Opcodes.ACC_ABSTRACT) == 0) {
            this.methods = true;
        }
        return null;
    }

    public void visitTotalProbeCount(int count2) {
        this.count = count2;
    }

    /* access modifiers changed from: 0000 */
    public int getCount() {
        return this.count;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasMethods() {
        return this.methods;
    }
}
