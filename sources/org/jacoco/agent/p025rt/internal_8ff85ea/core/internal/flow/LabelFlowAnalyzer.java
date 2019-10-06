package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.MethodNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.TryCatchBlockNode;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.LabelFlowAnalyzer */
public final class LabelFlowAnalyzer extends MethodVisitor {
    boolean first = true;
    Label lineStart = null;
    boolean successor = false;

    public static void markLabels(MethodNode method) {
        MethodVisitor lfa = new LabelFlowAnalyzer();
        int i = method.tryCatchBlocks.size();
        while (true) {
            i--;
            if (i >= 0) {
                ((TryCatchBlockNode) method.tryCatchBlocks.get(i)).accept(lfa);
            } else {
                method.instructions.accept(lfa);
                return;
            }
        }
    }

    public LabelFlowAnalyzer() {
        super(327680);
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        LabelInfo.setTarget(start);
        LabelInfo.setTarget(handler);
    }

    public void visitJumpInsn(int opcode, Label label) {
        LabelInfo.setTarget(label);
        if (opcode != 168) {
            this.successor = opcode != 167;
            this.first = false;
            return;
        }
        throw new AssertionError("Subroutines not supported.");
    }

    public void visitLabel(Label label) {
        if (this.first) {
            LabelInfo.setTarget(label);
        }
        if (this.successor) {
            LabelInfo.setSuccessor(label);
        }
    }

    public void visitLineNumber(int line, Label start) {
        this.lineStart = start;
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        visitSwitchInsn(dflt, labels);
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        visitSwitchInsn(dflt, labels);
    }

    private void visitSwitchInsn(Label dflt, Label[] labels) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        setTargetIfNotDone(dflt);
        for (Label l : labels) {
            setTargetIfNotDone(l);
        }
        this.successor = false;
        this.first = false;
    }

    private static void setTargetIfNotDone(Label label) {
        if (!LabelInfo.isDone(label)) {
            LabelInfo.setTarget(label);
            LabelInfo.setDone(label);
        }
    }

    public void visitInsn(int opcode) {
        if (opcode != 169) {
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
                        this.successor = true;
                        break;
                }
            }
            this.successor = false;
            this.first = false;
            return;
        }
        throw new AssertionError("Subroutines not supported.");
    }

    public void visitIntInsn(int opcode, int operand) {
        this.successor = true;
        this.first = false;
    }

    public void visitVarInsn(int opcode, int var) {
        this.successor = true;
        this.first = false;
    }

    public void visitTypeInsn(int opcode, String type) {
        this.successor = true;
        this.first = false;
    }

    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        this.successor = true;
        this.first = false;
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        this.successor = true;
        this.first = false;
        markMethodInvocationLine();
    }

    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        this.successor = true;
        this.first = false;
        markMethodInvocationLine();
    }

    private void markMethodInvocationLine() {
        Label label = this.lineStart;
        if (label != null) {
            LabelInfo.setMethodInvocationLine(label);
        }
    }

    public void visitLdcInsn(Object cst) {
        this.successor = true;
        this.first = false;
    }

    public void visitIincInsn(int var, int increment) {
        this.successor = true;
        this.first = false;
    }

    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.successor = true;
        this.first = false;
    }
}
