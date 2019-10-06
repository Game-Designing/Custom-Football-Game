package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.ClassProbesAdapter */
public class ClassProbesAdapter extends ClassVisitor implements IProbeIdGenerator {
    private static final MethodProbesVisitor EMPTY_METHOD_PROBES_VISITOR = new MethodProbesVisitor() {
    };
    private int counter = 0;

    /* renamed from: cv */
    private final ClassProbesVisitor f43248cv;
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public final boolean trackFrames;

    public ClassProbesAdapter(ClassProbesVisitor cv, boolean trackFrames2) {
        super(327680, cv);
        this.f43248cv = cv;
        this.trackFrames = trackFrames2;
    }

    public void visit(int version, int access, String name2, String signature, String superName, String[] interfaces) {
        this.name = name2;
        super.visit(version, access, name2, signature, superName, interfaces);
    }

    public final MethodVisitor visitMethod(int access, String name2, String desc, String signature, String[] exceptions) {
        MethodProbesVisitor methodProbes;
        MethodProbesVisitor mv = this.f43248cv.visitMethod(access, name2, desc, signature, exceptions);
        if (mv == null) {
            methodProbes = EMPTY_METHOD_PROBES_VISITOR;
        } else {
            methodProbes = mv;
        }
        final MethodProbesVisitor methodProbesVisitor = methodProbes;
        C143732 r0 = new MethodSanitizer(null, access, name2, desc, signature, exceptions) {
            public void visitEnd() {
                super.visitEnd();
                LabelFlowAnalyzer.markLabels(this);
                MethodProbesAdapter probesAdapter = new MethodProbesAdapter(methodProbesVisitor, ClassProbesAdapter.this);
                if (ClassProbesAdapter.this.trackFrames) {
                    AnalyzerAdapter analyzerAdapter = new AnalyzerAdapter(ClassProbesAdapter.this.name, this.access, this.name, this.desc, probesAdapter);
                    probesAdapter.setAnalyzer(analyzerAdapter);
                    accept((MethodVisitor) analyzerAdapter);
                    return;
                }
                accept((MethodVisitor) probesAdapter);
            }
        };
        return r0;
    }

    public void visitEnd() {
        this.f43248cv.visitTotalProbeCount(this.counter);
        super.visitEnd();
    }

    public int nextId() {
        int i = this.counter;
        this.counter = i + 1;
        return i;
    }
}
