package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.commons.JSRInlinerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.MethodSanitizer */
class MethodSanitizer extends JSRInlinerAdapter {
    MethodSanitizer(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
        super(327680, mv, access, name, desc, signature, exceptions);
    }

    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        if (start.info != null && end.info != null) {
            super.visitLocalVariable(name, desc, signature, start, end, index);
        }
    }

    public void visitLineNumber(int line, Label start) {
        if (start.info != null) {
            super.visitLineNumber(line, start);
        }
    }
}
