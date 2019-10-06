package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.InstrSupport */
public final class InstrSupport {
    public static final int ASM_API_VERSION = 327680;
    static final int CLINIT_ACC = 4104;
    static final String CLINIT_DESC = "()V";
    static final String CLINIT_NAME = "<clinit>";
    public static final int DATAFIELD_ACC = 4234;
    public static final String DATAFIELD_DESC = "[Z";
    public static final int DATAFIELD_INTF_ACC = 4121;
    public static final String DATAFIELD_NAME = "$jacocoData";
    public static final int INITMETHOD_ACC = 4106;
    public static final String INITMETHOD_DESC = "()[Z";
    public static final String INITMETHOD_NAME = "$jacocoInit";

    private InstrSupport() {
    }

    public static void assertNotInstrumented(String member, String owner) throws IllegalStateException {
        if (member.equals(DATAFIELD_NAME) || member.equals(INITMETHOD_NAME)) {
            throw new IllegalStateException(String.format("Class %s is already instrumented.", new Object[]{owner}));
        }
    }

    public static void push(MethodVisitor mv, int value) {
        if (value >= -1 && value <= 5) {
            mv.visitInsn(value + 3);
        } else if (value >= -128 && value <= 127) {
            mv.visitIntInsn(16, value);
        } else if (value < -32768 || value > 32767) {
            mv.visitLdcInsn(Integer.valueOf(value));
        } else {
            mv.visitIntInsn(17, value);
        }
    }
}
