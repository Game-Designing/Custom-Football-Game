package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor */
public abstract class AnnotationVisitor {
    protected final int api;

    /* renamed from: av */
    protected AnnotationVisitor f43237av;

    public AnnotationVisitor(int api2) {
        this(api2, null);
    }

    public AnnotationVisitor(int api2, AnnotationVisitor av) {
        if (api2 == 262144 || api2 == 327680) {
            this.api = api2;
            this.f43237av = av;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void visit(String name, Object value) {
        AnnotationVisitor annotationVisitor = this.f43237av;
        if (annotationVisitor != null) {
            annotationVisitor.visit(name, value);
        }
    }

    public void visitEnum(String name, String desc, String value) {
        AnnotationVisitor annotationVisitor = this.f43237av;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnum(name, desc, value);
        }
    }

    public AnnotationVisitor visitAnnotation(String name, String desc) {
        AnnotationVisitor annotationVisitor = this.f43237av;
        if (annotationVisitor != null) {
            return annotationVisitor.visitAnnotation(name, desc);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String name) {
        AnnotationVisitor annotationVisitor = this.f43237av;
        if (annotationVisitor != null) {
            return annotationVisitor.visitArray(name);
        }
        return null;
    }

    public void visitEnd() {
        AnnotationVisitor annotationVisitor = this.f43237av;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
    }
}
