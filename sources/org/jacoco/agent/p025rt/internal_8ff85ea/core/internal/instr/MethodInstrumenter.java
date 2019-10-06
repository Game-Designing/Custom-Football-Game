package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.IFrame;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.LabelInfo;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.MethodInstrumenter */
class MethodInstrumenter extends MethodProbesVisitor {
    private final IProbeInserter probeInserter;

    public MethodInstrumenter(MethodVisitor mv, IProbeInserter probeInserter2) {
        super(mv);
        this.probeInserter = probeInserter2;
    }

    public void visitProbe(int probeId) {
        this.probeInserter.insertProbe(probeId);
    }

    public void visitInsnWithProbe(int opcode, int probeId) {
        this.probeInserter.insertProbe(probeId);
        this.f149mv.visitInsn(opcode);
    }

    public void visitJumpInsnWithProbe(int opcode, Label label, int probeId, IFrame frame) {
        if (opcode == 167) {
            this.probeInserter.insertProbe(probeId);
            this.f149mv.visitJumpInsn(Opcodes.GOTO, label);
            return;
        }
        Label intermediate = new Label();
        this.f149mv.visitJumpInsn(getInverted(opcode), intermediate);
        this.probeInserter.insertProbe(probeId);
        this.f149mv.visitJumpInsn(Opcodes.GOTO, label);
        this.f149mv.visitLabel(intermediate);
        frame.accept(this.f149mv);
    }

    private int getInverted(int opcode) {
        if (opcode == 198) {
            return Opcodes.IFNONNULL;
        }
        if (opcode == 199) {
            return Opcodes.IFNULL;
        }
        switch (opcode) {
            case Opcodes.IFEQ /*153*/:
                return Opcodes.IFNE;
            case Opcodes.IFNE /*154*/:
                return Opcodes.IFEQ;
            case Opcodes.IFLT /*155*/:
                return Opcodes.IFGE;
            case Opcodes.IFGE /*156*/:
                return Opcodes.IFLT;
            case Opcodes.IFGT /*157*/:
                return Opcodes.IFLE;
            case Opcodes.IFLE /*158*/:
                return Opcodes.IFGT;
            case Opcodes.IF_ICMPEQ /*159*/:
                return Opcodes.IF_ICMPNE;
            case Opcodes.IF_ICMPNE /*160*/:
                return Opcodes.IF_ICMPEQ;
            case Opcodes.IF_ICMPLT /*161*/:
                return Opcodes.IF_ICMPGE;
            case Opcodes.IF_ICMPGE /*162*/:
                return Opcodes.IF_ICMPLT;
            case Opcodes.IF_ICMPGT /*163*/:
                return Opcodes.IF_ICMPLE;
            case Opcodes.IF_ICMPLE /*164*/:
                return Opcodes.IF_ICMPGT;
            case Opcodes.IF_ACMPEQ /*165*/:
                return Opcodes.IF_ACMPNE;
            case Opcodes.IF_ACMPNE /*166*/:
                return Opcodes.IF_ACMPEQ;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void visitTableSwitchInsnWithProbes(int min, int max, Label dflt, Label[] labels, IFrame frame) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        this.f149mv.visitTableSwitchInsn(min, max, createIntermediate(dflt), createIntermediates(labels));
        insertIntermediateProbes(dflt, labels, frame);
    }

    public void visitLookupSwitchInsnWithProbes(Label dflt, int[] keys, Label[] labels, IFrame frame) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        this.f149mv.visitLookupSwitchInsn(createIntermediate(dflt), keys, createIntermediates(labels));
        insertIntermediateProbes(dflt, labels, frame);
    }

    private Label[] createIntermediates(Label[] labels) {
        Label[] intermediates = new Label[labels.length];
        for (int i = 0; i < labels.length; i++) {
            intermediates[i] = createIntermediate(labels[i]);
        }
        return intermediates;
    }

    private Label createIntermediate(Label label) {
        if (LabelInfo.getProbeId(label) == -1) {
            return label;
        }
        if (LabelInfo.isDone(label)) {
            return LabelInfo.getIntermediateLabel(label);
        }
        Label intermediate = new Label();
        LabelInfo.setIntermediateLabel(label, intermediate);
        LabelInfo.setDone(label);
        return intermediate;
    }

    private void insertIntermediateProbe(Label label, IFrame frame) {
        int probeId = LabelInfo.getProbeId(label);
        if (probeId != -1 && !LabelInfo.isDone(label)) {
            this.f149mv.visitLabel(LabelInfo.getIntermediateLabel(label));
            frame.accept(this.f149mv);
            this.probeInserter.insertProbe(probeId);
            this.f149mv.visitJumpInsn(Opcodes.GOTO, label);
            LabelInfo.setDone(label);
        }
    }

    private void insertIntermediateProbes(Label dflt, Label[] labels, IFrame frame) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        insertIntermediateProbe(dflt, frame);
        for (Label l : labels) {
            insertIntermediateProbe(l, frame);
        }
    }
}
