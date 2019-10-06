package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.MethodProbesAdapter */
public final class MethodProbesAdapter extends MethodVisitor {
    private AnalyzerAdapter analyzer;
    private final IProbeIdGenerator idGenerator;
    private final MethodProbesVisitor probesVisitor;
    private final Map<Label, Label> tryCatchProbeLabels = new HashMap();

    public MethodProbesAdapter(MethodProbesVisitor probesVisitor2, IProbeIdGenerator idGenerator2) {
        super(327680, probesVisitor2);
        this.probesVisitor = probesVisitor2;
        this.idGenerator = idGenerator2;
    }

    public void setAnalyzer(AnalyzerAdapter analyzer2) {
        this.analyzer = analyzer2;
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        if (this.tryCatchProbeLabels.containsKey(start)) {
            start = (Label) this.tryCatchProbeLabels.get(start);
        } else if (LabelInfo.needsProbe(start)) {
            Label probeLabel = new Label();
            LabelInfo.setSuccessor(probeLabel);
            this.tryCatchProbeLabels.put(start, probeLabel);
            start = probeLabel;
        }
        this.probesVisitor.visitTryCatchBlock(start, end, handler, type);
    }

    public void visitLabel(Label label) {
        if (LabelInfo.needsProbe(label)) {
            if (this.tryCatchProbeLabels.containsKey(label)) {
                this.probesVisitor.visitLabel((Label) this.tryCatchProbeLabels.get(label));
            }
            this.probesVisitor.visitProbe(this.idGenerator.nextId());
        }
        this.probesVisitor.visitLabel(label);
    }

    public void visitInsn(int opcode) {
        if (opcode != 191) {
            switch (opcode) {
                case Opcodes.IRETURN /*172*/:
                case Opcodes.LRETURN /*173*/:
                case Opcodes.FRETURN /*174*/:
                case Opcodes.DRETURN /*175*/:
                case Opcodes.ARETURN /*176*/:
                case Opcodes.RETURN /*177*/:
                    break;
                default:
                    this.probesVisitor.visitInsn(opcode);
                    return;
            }
        }
        this.probesVisitor.visitInsnWithProbe(opcode, this.idGenerator.nextId());
    }

    public void visitJumpInsn(int opcode, Label label) {
        if (LabelInfo.isMultiTarget(label)) {
            this.probesVisitor.visitJumpInsnWithProbe(opcode, label, this.idGenerator.nextId(), frame(jumpPopCount(opcode)));
        } else {
            this.probesVisitor.visitJumpInsn(opcode, label);
        }
    }

    private int jumpPopCount(int opcode) {
        if (opcode == 167) {
            return 0;
        }
        if (!(opcode == 198 || opcode == 199)) {
            switch (opcode) {
                case Opcodes.IFEQ /*153*/:
                case Opcodes.IFNE /*154*/:
                case Opcodes.IFLT /*155*/:
                case Opcodes.IFGE /*156*/:
                case Opcodes.IFGT /*157*/:
                case Opcodes.IFLE /*158*/:
                    break;
                default:
                    return 2;
            }
        }
        return 1;
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        if (markLabels(dflt, labels)) {
            this.probesVisitor.visitLookupSwitchInsnWithProbes(dflt, keys, labels, frame(1));
        } else {
            this.probesVisitor.visitLookupSwitchInsn(dflt, keys, labels);
        }
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        if (markLabels(dflt, labels)) {
            this.probesVisitor.visitTableSwitchInsnWithProbes(min, max, dflt, labels, frame(1));
            return;
        }
        this.probesVisitor.visitTableSwitchInsn(min, max, dflt, labels);
    }

    private boolean markLabels(Label dflt, Label[] labels) {
        Label[] arr$;
        boolean probe = false;
        LabelInfo.resetDone(labels);
        if (LabelInfo.isMultiTarget(dflt)) {
            LabelInfo.setProbeId(dflt, this.idGenerator.nextId());
            probe = true;
        }
        LabelInfo.setDone(dflt);
        for (Label l : labels) {
            if (LabelInfo.isMultiTarget(l) && !LabelInfo.isDone(l)) {
                LabelInfo.setProbeId(l, this.idGenerator.nextId());
                probe = true;
            }
            LabelInfo.setDone(l);
        }
        return probe;
    }

    private IFrame frame(int popCount) {
        return FrameSnapshot.create(this.analyzer, popCount);
    }
}
