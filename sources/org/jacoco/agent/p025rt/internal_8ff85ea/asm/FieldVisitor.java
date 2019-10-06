package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.FieldVisitor */
public abstract class FieldVisitor {
    protected final int api;

    /* renamed from: fv */
    protected FieldVisitor f43243fv;

    public FieldVisitor(int api2) {
        this(api2, null);
    }

    public FieldVisitor(int api2, FieldVisitor fv) {
        if (api2 == 262144 || api2 == 327680) {
            this.api = api2;
            this.f43243fv = fv;
            return;
        }
        throw new IllegalArgumentException();
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        FieldVisitor fieldVisitor = this.f43243fv;
        if (fieldVisitor != null) {
            return fieldVisitor.visitAnnotation(desc, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api >= 327680) {
            FieldVisitor fieldVisitor = this.f43243fv;
            if (fieldVisitor != null) {
                return fieldVisitor.visitTypeAnnotation(typeRef, typePath, desc, visible);
            }
            return null;
        }
        throw new RuntimeException();
    }

    public void visitAttribute(Attribute attr) {
        FieldVisitor fieldVisitor = this.f43243fv;
        if (fieldVisitor != null) {
            fieldVisitor.visitAttribute(attr);
        }
    }

    public void visitEnd() {
        FieldVisitor fieldVisitor = this.f43243fv;
        if (fieldVisitor != null) {
            fieldVisitor.visitEnd();
        }
    }
}
