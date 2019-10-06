package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.ClassVisitor */
public abstract class ClassVisitor {
    protected final int api;

    /* renamed from: cv */
    protected ClassVisitor f43241cv;

    public ClassVisitor(int api2) {
        this(api2, null);
    }

    public ClassVisitor(int api2, ClassVisitor cv) {
        if (api2 == 262144 || api2 == 327680) {
            this.api = api2;
            this.f43241cv = cv;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            classVisitor.visit(version, access, name, signature, superName, interfaces);
        }
    }

    public void visitSource(String source, String debug) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            classVisitor.visitSource(source, debug);
        }
    }

    public void visitOuterClass(String owner, String name, String desc) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            classVisitor.visitOuterClass(owner, name, desc);
        }
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            return classVisitor.visitAnnotation(desc, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api >= 327680) {
            ClassVisitor classVisitor = this.f43241cv;
            if (classVisitor != null) {
                return classVisitor.visitTypeAnnotation(typeRef, typePath, desc, visible);
            }
            return null;
        }
        throw new RuntimeException();
    }

    public void visitAttribute(Attribute attr) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            classVisitor.visitAttribute(attr);
        }
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            classVisitor.visitInnerClass(name, outerName, innerName, access);
        }
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            return classVisitor.visitField(access, name, desc, signature, value);
        }
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            return classVisitor.visitMethod(access, name, desc, signature, exceptions);
        }
        return null;
    }

    public void visitEnd() {
        ClassVisitor classVisitor = this.f43241cv;
        if (classVisitor != null) {
            classVisitor.visitEnd();
        }
    }
}
