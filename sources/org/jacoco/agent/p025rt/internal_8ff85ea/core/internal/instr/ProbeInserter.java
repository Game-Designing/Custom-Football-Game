package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Type;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ProbeInserter */
class ProbeInserter extends MethodVisitor implements IProbeInserter {
    private int accessorStackSize;
    private final IProbeArrayStrategy arrayStrategy;
    private final boolean clinit;
    private final int variable;

    ProbeInserter(int access, String name, String desc, MethodVisitor mv, IProbeArrayStrategy arrayStrategy2) {
        super(327680, mv);
        this.clinit = "<clinit>".equals(name);
        this.arrayStrategy = arrayStrategy2;
        int pos = (access & 8) == 0 ? 1 : 0;
        for (Type t : Type.getArgumentTypes(desc)) {
            pos += t.getSize();
        }
        this.variable = pos;
    }

    public void insertProbe(int id) {
        this.f149mv.visitVarInsn(25, this.variable);
        InstrSupport.push(this.f149mv, id);
        this.f149mv.visitInsn(4);
        this.f149mv.visitInsn(84);
    }

    public void visitCode() {
        this.accessorStackSize = this.arrayStrategy.storeInstance(this.f149mv, this.clinit, this.variable);
        this.f149mv.visitCode();
    }

    public final void visitVarInsn(int opcode, int var) {
        this.f149mv.visitVarInsn(opcode, map(var));
    }

    public final void visitIincInsn(int var, int increment) {
        this.f149mv.visitIincInsn(map(var), increment);
    }

    public final void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        this.f149mv.visitLocalVariable(name, desc, signature, start, end, map(index));
    }

    public void visitMaxs(int maxStack, int maxLocals) {
        this.f149mv.visitMaxs(Math.max(maxStack + 3, this.accessorStackSize), maxLocals + 1);
    }

    private int map(int var) {
        if (var < this.variable) {
            return var;
        }
        return var + 1;
    }

    public final void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        if (type == -1) {
            Object[] newLocal = new Object[(Math.max(nLocal, this.variable) + 1)];
            int idx = 0;
            int newIdx = 0;
            int pos = 0;
            while (true) {
                if (idx >= nLocal && pos > this.variable) {
                    this.f149mv.visitFrame(type, newIdx, newLocal, nStack, stack);
                    return;
                } else if (pos == this.variable) {
                    int newIdx2 = newIdx + 1;
                    newLocal[newIdx] = InstrSupport.DATAFIELD_DESC;
                    pos++;
                    newIdx = newIdx2;
                } else if (idx < nLocal) {
                    int idx2 = idx + 1;
                    Object t = local[idx];
                    int newIdx3 = newIdx + 1;
                    newLocal[newIdx] = t;
                    pos++;
                    if (t == Opcodes.LONG || t == Opcodes.DOUBLE) {
                        pos++;
                    }
                    idx = idx2;
                    newIdx = newIdx3;
                } else {
                    int newIdx4 = newIdx + 1;
                    newLocal[newIdx] = Opcodes.TOP;
                    pos++;
                    newIdx = newIdx4;
                }
            }
        } else {
            throw new IllegalArgumentException("ClassReader.accept() should be called with EXPAND_FRAMES flag");
        }
    }
}
