package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.FieldVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.ClassProbesVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ClassInstrumenter */
public class ClassInstrumenter extends ClassProbesVisitor {
    private String className;
    private final IProbeArrayStrategy probeArrayStrategy;

    public ClassInstrumenter(IProbeArrayStrategy probeArrayStrategy2, ClassVisitor cv) {
        super(cv);
        this.probeArrayStrategy = probeArrayStrategy2;
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        InstrSupport.assertNotInstrumented(name, this.className);
        return super.visitField(access, name, desc, signature, value);
    }

    public MethodProbesVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        InstrSupport.assertNotInstrumented(name, this.className);
        MethodVisitor mv = this.f43241cv.visitMethod(access, name, desc, signature, exceptions);
        if (mv == null) {
            return null;
        }
        ProbeInserter probeInserter = new ProbeInserter(access, name, desc, new DuplicateFrameEliminator(mv), this.probeArrayStrategy);
        return new MethodInstrumenter(probeInserter, probeInserter);
    }

    public void visitTotalProbeCount(int count) {
        this.probeArrayStrategy.addMembers(this.f43241cv, count);
    }
}
