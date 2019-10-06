package org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassReader;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassWriter;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.Java9Support;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.ModifiedSystemClassRuntime */
public class ModifiedSystemClassRuntime extends AbstractRuntime {
    private static final String ACCESS_FIELD_TYPE = "Ljava/lang/Object;";
    private final String accessFieldName;
    private final Class<?> systemClass;
    private final String systemClassName;

    public ModifiedSystemClassRuntime(Class<?> systemClass2, String accessFieldName2) {
        this.systemClass = systemClass2;
        this.systemClassName = systemClass2.getName().replace('.', '/');
        this.accessFieldName = accessFieldName2;
    }

    public void startup(RuntimeData data) throws Exception {
        super.startup(data);
        this.systemClass.getField(this.accessFieldName).set(null, data);
    }

    public void shutdown() {
    }

    public int generateDataAccessor(long classid, String classname, int probecount, MethodVisitor mv) {
        mv.visitFieldInsn(Opcodes.GETSTATIC, this.systemClassName, this.accessFieldName, ACCESS_FIELD_TYPE);
        RuntimeData.generateAccessCall(classid, classname, probecount, mv);
        return 6;
    }

    public static IRuntime createFor(Instrumentation inst, String className) throws ClassNotFoundException {
        return createFor(inst, className, "$jacocoAccess");
    }

    public static IRuntime createFor(Instrumentation inst, final String className, final String accessFieldName2) throws ClassNotFoundException {
        ClassFileTransformer transformer = new ClassFileTransformer() {
            public byte[] transform(ClassLoader loader, String name, Class<?> cls, ProtectionDomain protectionDomain, byte[] source) throws IllegalClassFormatException {
                if (name.equals(className)) {
                    return ModifiedSystemClassRuntime.instrument(source, accessFieldName2);
                }
                return null;
            }
        };
        inst.addTransformer(transformer);
        Class<?> clazz = Class.forName(className.replace('/', '.'));
        inst.removeTransformer(transformer);
        try {
            clazz.getField(accessFieldName2);
            return new ModifiedSystemClassRuntime(clazz, accessFieldName2);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(String.format("Class %s could not be instrumented.", new Object[]{className}), e);
        }
    }

    public static byte[] instrument(byte[] source, final String accessFieldName2) {
        ClassReader reader = new ClassReader(Java9Support.downgradeIfRequired(source));
        ClassWriter writer = new ClassWriter(reader, 0);
        reader.accept(new ClassVisitor(327680, writer) {
            public void visitEnd() {
                ModifiedSystemClassRuntime.createDataField(this.f43241cv, accessFieldName2);
                super.visitEnd();
            }
        }, 8);
        return writer.toByteArray();
    }

    /* access modifiers changed from: private */
    public static void createDataField(ClassVisitor visitor, String dataField) {
        visitor.visitField(4233, dataField, ACCESS_FIELD_TYPE, null, null);
    }
}
