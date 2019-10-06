package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.MethodVisitor */
public abstract class MethodVisitor {
    protected final int api;

    /* renamed from: mv */
    protected MethodVisitor f149mv;

    public MethodVisitor(int api2) {
        this(api2, null);
    }

    public MethodVisitor(int api2, MethodVisitor mv) {
        if (api2 == 262144 || api2 == 327680) {
            this.api = api2;
            this.f149mv = mv;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void visitParameter(String name, int access) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.f149mv;
            if (methodVisitor != null) {
                methodVisitor.visitParameter(name, access);
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public AnnotationVisitor visitAnnotationDefault() {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            return methodVisitor.visitAnnotationDefault();
        }
        return null;
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            return methodVisitor.visitAnnotation(desc, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.f149mv;
            if (methodVisitor != null) {
                return methodVisitor.visitTypeAnnotation(typeRef, typePath, desc, visible);
            }
            return null;
        }
        throw new RuntimeException();
    }

    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            return methodVisitor.visitParameterAnnotation(parameter, desc, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attr) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitAttribute(attr);
        }
    }

    public void visitCode() {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitCode();
        }
    }

    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitFrame(type, nLocal, local, nStack, stack);
        }
    }

    public void visitInsn(int opcode) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitInsn(opcode);
        }
    }

    public void visitIntInsn(int opcode, int operand) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitIntInsn(opcode, operand);
        }
    }

    public void visitVarInsn(int opcode, int var) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitVarInsn(opcode, var);
        }
    }

    public void visitTypeInsn(int opcode, String type) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitTypeInsn(opcode, type);
        }
    }

    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitFieldInsn(opcode, owner, name, desc);
        }
    }

    @Deprecated
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        if (this.api >= 327680) {
            visitMethodInsn(opcode, owner, name, desc, opcode == 185);
            return;
        }
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitMethodInsn(opcode, owner, name, desc);
        }
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (this.api < 327680) {
            if (itf == (opcode == 185)) {
                visitMethodInsn(opcode, owner, name, desc);
                return;
            }
            throw new IllegalArgumentException("INVOKESPECIAL/STATIC on interfaces require ASM 5");
        }
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitMethodInsn(opcode, owner, name, desc, itf);
        }
    }

    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
        }
    }

    public void visitJumpInsn(int opcode, Label label) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitJumpInsn(opcode, label);
        }
    }

    public void visitLabel(Label label) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLabel(label);
        }
    }

    public void visitLdcInsn(Object cst) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLdcInsn(cst);
        }
    }

    public void visitIincInsn(int var, int increment) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitIincInsn(var, increment);
        }
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitTableSwitchInsn(min, max, dflt, labels);
        }
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLookupSwitchInsn(dflt, keys, labels);
        }
    }

    public void visitMultiANewArrayInsn(String desc, int dims) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitMultiANewArrayInsn(desc, dims);
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.f149mv;
            if (methodVisitor != null) {
                return methodVisitor.visitInsnAnnotation(typeRef, typePath, desc, visible);
            }
            return null;
        }
        throw new RuntimeException();
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitTryCatchBlock(start, end, handler, type);
        }
    }

    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.f149mv;
            if (methodVisitor != null) {
                return methodVisitor.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
            }
            return null;
        }
        throw new RuntimeException();
    }

    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLocalVariable(name, desc, signature, start, end, index);
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        if (this.api >= 327680) {
            MethodVisitor methodVisitor = this.f149mv;
            if (methodVisitor != null) {
                return methodVisitor.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
            }
            return null;
        }
        throw new RuntimeException();
    }

    public void visitLineNumber(int line, Label start) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLineNumber(line, start);
        }
    }

    public void visitMaxs(int maxStack, int maxLocals) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitMaxs(maxStack, maxLocals);
        }
    }

    public void visitEnd() {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitEnd();
        }
    }
}
