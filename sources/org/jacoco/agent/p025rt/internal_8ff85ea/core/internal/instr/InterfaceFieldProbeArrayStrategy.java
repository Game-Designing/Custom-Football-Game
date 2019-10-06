package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.InterfaceFieldProbeArrayStrategy */
class InterfaceFieldProbeArrayStrategy implements IProbeArrayStrategy {
    private static final Object[] FRAME_LOCALS_EMPTY = new Object[0];
    private static final Object[] FRAME_STACK_ARRZ = {InstrSupport.DATAFIELD_DESC};
    private final IExecutionDataAccessorGenerator accessorGenerator;
    private final long classId;
    private final String className;
    private final int probeCount;
    private boolean seenClinit = false;

    InterfaceFieldProbeArrayStrategy(String className2, long classId2, int probeCount2, IExecutionDataAccessorGenerator accessorGenerator2) {
        this.className = className2;
        this.classId = classId2;
        this.probeCount = probeCount2;
        this.accessorGenerator = accessorGenerator2;
    }

    public int storeInstance(MethodVisitor mv, boolean clinit, int variable) {
        if (clinit) {
            int maxStack = this.accessorGenerator.generateDataAccessor(this.classId, this.className, this.probeCount, mv);
            mv.visitInsn(89);
            mv.visitFieldInsn(Opcodes.PUTSTATIC, this.className, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC);
            mv.visitVarInsn(58, variable);
            this.seenClinit = true;
            return Math.max(maxStack, 2);
        }
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, this.className, InstrSupport.INITMETHOD_NAME, InstrSupport.INITMETHOD_DESC, true);
        mv.visitVarInsn(58, variable);
        return 1;
    }

    public void addMembers(ClassVisitor cv, int probeCount2) {
        createDataField(cv);
        createInitMethod(cv, probeCount2);
        if (!this.seenClinit) {
            createClinitMethod(cv, probeCount2);
        }
    }

    private void createDataField(ClassVisitor cv) {
        cv.visitField(InstrSupport.DATAFIELD_INTF_ACC, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC, null, null);
    }

    private void createInitMethod(ClassVisitor cv, int probeCount2) {
        MethodVisitor mv = cv.visitMethod(InstrSupport.INITMETHOD_ACC, InstrSupport.INITMETHOD_NAME, InstrSupport.INITMETHOD_DESC, null, null);
        mv.visitCode();
        mv.visitFieldInsn(Opcodes.GETSTATIC, this.className, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC);
        mv.visitInsn(89);
        Label alreadyInitialized = new Label();
        mv.visitJumpInsn(Opcodes.IFNONNULL, alreadyInitialized);
        mv.visitInsn(87);
        int size = this.accessorGenerator.generateDataAccessor(this.classId, this.className, probeCount2, mv);
        mv.visitFrame(-1, 0, FRAME_LOCALS_EMPTY, 1, FRAME_STACK_ARRZ);
        mv.visitLabel(alreadyInitialized);
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(Math.max(size, 2), 0);
        mv.visitEnd();
    }

    private void createClinitMethod(ClassVisitor cv, int probeCount2) {
        MethodVisitor mv = cv.visitMethod(4104, "<clinit>", "()V", null, null);
        mv.visitCode();
        int maxStack = this.accessorGenerator.generateDataAccessor(this.classId, this.className, probeCount2, mv);
        mv.visitFieldInsn(Opcodes.PUTSTATIC, this.className, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(maxStack, 0);
        mv.visitEnd();
    }
}
