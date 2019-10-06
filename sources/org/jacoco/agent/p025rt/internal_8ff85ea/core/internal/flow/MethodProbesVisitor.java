package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor */
public abstract class MethodProbesVisitor extends MethodVisitor {
    public MethodProbesVisitor() {
        this(null);
    }

    public MethodProbesVisitor(MethodVisitor mv) {
        super(327680, mv);
    }

    public void visitProbe(int probeId) {
    }

    public void visitJumpInsnWithProbe(int opcode, Label label, int probeId, IFrame frame) {
    }

    public void visitInsnWithProbe(int opcode, int probeId) {
    }

    public void visitTableSwitchInsnWithProbes(int min, int max, Label dflt, Label[] labels, IFrame frame) {
    }

    public void visitLookupSwitchInsnWithProbes(Label dflt, int[] keys, Label[] labels, IFrame frame) {
    }
}
