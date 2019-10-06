package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.AnnotationVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Attribute;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Type;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.MethodNode */
public class MethodNode extends MethodVisitor {
    public int access;
    public Object annotationDefault;
    public List<Attribute> attrs;
    public String desc;
    public List<String> exceptions;
    public InsnList instructions;
    public List<AnnotationNode> invisibleAnnotations;
    public List<LocalVariableAnnotationNode> invisibleLocalVariableAnnotations;
    public List<AnnotationNode>[] invisibleParameterAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public List<LocalVariableNode> localVariables;
    public int maxLocals;
    public int maxStack;
    public String name;
    public List<ParameterNode> parameters;
    public String signature;
    public List<TryCatchBlockNode> tryCatchBlocks;
    public List<AnnotationNode> visibleAnnotations;
    public List<LocalVariableAnnotationNode> visibleLocalVariableAnnotations;
    public List<AnnotationNode>[] visibleParameterAnnotations;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    private boolean visited;

    public MethodNode() {
        this(327680);
        if (getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int api) {
        super(api);
        this.instructions = new InsnList();
    }

    public MethodNode(int access2, String name2, String desc2, String signature2, String[] exceptions2) {
        this(327680, access2, name2, desc2, signature2, exceptions2);
        if (getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int api, int access2, String name2, String desc2, String signature2, String[] exceptions2) {
        super(api);
        this.access = access2;
        this.name = name2;
        this.desc = desc2;
        this.signature = signature2;
        boolean z = false;
        this.exceptions = new ArrayList(exceptions2 == null ? 0 : exceptions2.length);
        if ((access2 & Opcodes.ACC_ABSTRACT) != 0) {
            z = true;
        }
        if (!z) {
            this.localVariables = new ArrayList(5);
        }
        this.tryCatchBlocks = new ArrayList();
        if (exceptions2 != null) {
            this.exceptions.addAll(Arrays.asList(exceptions2));
        }
        this.instructions = new InsnList();
    }

    public void visitParameter(String name2, int access2) {
        if (this.parameters == null) {
            this.parameters = new ArrayList(5);
        }
        this.parameters.add(new ParameterNode(name2, access2));
    }

    public AnnotationVisitor visitAnnotationDefault() {
        return new AnnotationNode((List<Object>) new ArrayList<Object>(0) {
            public boolean add(Object o) {
                MethodNode.this.annotationDefault = o;
                return super.add(o);
            }
        });
    }

    public AnnotationVisitor visitAnnotation(String desc2, boolean visible) {
        AnnotationNode an = new AnnotationNode(desc2);
        if (visible) {
            if (this.visibleAnnotations == null) {
                this.visibleAnnotations = new ArrayList(1);
            }
            this.visibleAnnotations.add(an);
        } else {
            if (this.invisibleAnnotations == null) {
                this.invisibleAnnotations = new ArrayList(1);
            }
            this.invisibleAnnotations.add(an);
        }
        return an;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc2, boolean visible) {
        TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc2);
        if (visible) {
            if (this.visibleTypeAnnotations == null) {
                this.visibleTypeAnnotations = new ArrayList(1);
            }
            this.visibleTypeAnnotations.add(an);
        } else {
            if (this.invisibleTypeAnnotations == null) {
                this.invisibleTypeAnnotations = new ArrayList(1);
            }
            this.invisibleTypeAnnotations.add(an);
        }
        return an;
    }

    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc2, boolean visible) {
        AnnotationNode an = new AnnotationNode(desc2);
        if (visible) {
            if (this.visibleParameterAnnotations == null) {
                this.visibleParameterAnnotations = new List[Type.getArgumentTypes(this.desc).length];
            }
            List<AnnotationNode>[] listArr = this.visibleParameterAnnotations;
            if (listArr[parameter] == null) {
                listArr[parameter] = new ArrayList(1);
            }
            this.visibleParameterAnnotations[parameter].add(an);
        } else {
            if (this.invisibleParameterAnnotations == null) {
                this.invisibleParameterAnnotations = new List[Type.getArgumentTypes(this.desc).length];
            }
            List<AnnotationNode>[] listArr2 = this.invisibleParameterAnnotations;
            if (listArr2[parameter] == null) {
                listArr2[parameter] = new ArrayList(1);
            }
            this.invisibleParameterAnnotations[parameter].add(an);
        }
        return an;
    }

    public void visitAttribute(Attribute attr) {
        if (this.attrs == null) {
            this.attrs = new ArrayList(1);
        }
        this.attrs.add(attr);
    }

    public void visitCode() {
    }

    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        Object[] objArr;
        Object[] objArr2;
        InsnList insnList = this.instructions;
        if (local == null) {
            objArr = null;
        } else {
            objArr = getLabelNodes(local);
        }
        if (stack == null) {
            objArr2 = null;
        } else {
            objArr2 = getLabelNodes(stack);
        }
        FrameNode frameNode = new FrameNode(type, nLocal, objArr, nStack, objArr2);
        insnList.add((AbstractInsnNode) frameNode);
    }

    public void visitInsn(int opcode) {
        this.instructions.add((AbstractInsnNode) new InsnNode(opcode));
    }

    public void visitIntInsn(int opcode, int operand) {
        this.instructions.add((AbstractInsnNode) new IntInsnNode(opcode, operand));
    }

    public void visitVarInsn(int opcode, int var) {
        this.instructions.add((AbstractInsnNode) new VarInsnNode(opcode, var));
    }

    public void visitTypeInsn(int opcode, String type) {
        this.instructions.add((AbstractInsnNode) new TypeInsnNode(opcode, type));
    }

    public void visitFieldInsn(int opcode, String owner, String name2, String desc2) {
        this.instructions.add((AbstractInsnNode) new FieldInsnNode(opcode, owner, name2, desc2));
    }

    @Deprecated
    public void visitMethodInsn(int opcode, String owner, String name2, String desc2) {
        if (this.api >= 327680) {
            super.visitMethodInsn(opcode, owner, name2, desc2);
        } else {
            this.instructions.add((AbstractInsnNode) new MethodInsnNode(opcode, owner, name2, desc2));
        }
    }

    public void visitMethodInsn(int opcode, String owner, String name2, String desc2, boolean itf) {
        if (this.api < 327680) {
            super.visitMethodInsn(opcode, owner, name2, desc2, itf);
            return;
        }
        InsnList insnList = this.instructions;
        MethodInsnNode methodInsnNode = new MethodInsnNode(opcode, owner, name2, desc2, itf);
        insnList.add((AbstractInsnNode) methodInsnNode);
    }

    public void visitInvokeDynamicInsn(String name2, String desc2, Handle bsm, Object... bsmArgs) {
        this.instructions.add((AbstractInsnNode) new InvokeDynamicInsnNode(name2, desc2, bsm, bsmArgs));
    }

    public void visitJumpInsn(int opcode, Label label) {
        this.instructions.add((AbstractInsnNode) new JumpInsnNode(opcode, getLabelNode(label)));
    }

    public void visitLabel(Label label) {
        this.instructions.add((AbstractInsnNode) getLabelNode(label));
    }

    public void visitLdcInsn(Object cst) {
        this.instructions.add((AbstractInsnNode) new LdcInsnNode(cst));
    }

    public void visitIincInsn(int var, int increment) {
        this.instructions.add((AbstractInsnNode) new IincInsnNode(var, increment));
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        this.instructions.add((AbstractInsnNode) new TableSwitchInsnNode(min, max, getLabelNode(dflt), getLabelNodes(labels)));
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        this.instructions.add((AbstractInsnNode) new LookupSwitchInsnNode(getLabelNode(dflt), keys, getLabelNodes(labels)));
    }

    public void visitMultiANewArrayInsn(String desc2, int dims) {
        this.instructions.add((AbstractInsnNode) new MultiANewArrayInsnNode(desc2, dims));
    }

    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc2, boolean visible) {
        AbstractInsnNode insn = this.instructions.getLast();
        while (insn.getOpcode() == -1) {
            insn = insn.getPrevious();
        }
        TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc2);
        if (visible) {
            if (insn.visibleTypeAnnotations == null) {
                insn.visibleTypeAnnotations = new ArrayList(1);
            }
            insn.visibleTypeAnnotations.add(an);
        } else {
            if (insn.invisibleTypeAnnotations == null) {
                insn.invisibleTypeAnnotations = new ArrayList(1);
            }
            insn.invisibleTypeAnnotations.add(an);
        }
        return an;
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        this.tryCatchBlocks.add(new TryCatchBlockNode(getLabelNode(start), getLabelNode(end), getLabelNode(handler), type));
    }

    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc2, boolean visible) {
        TryCatchBlockNode tcb = (TryCatchBlockNode) this.tryCatchBlocks.get((16776960 & typeRef) >> 8);
        TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc2);
        if (visible) {
            if (tcb.visibleTypeAnnotations == null) {
                tcb.visibleTypeAnnotations = new ArrayList(1);
            }
            tcb.visibleTypeAnnotations.add(an);
        } else {
            if (tcb.invisibleTypeAnnotations == null) {
                tcb.invisibleTypeAnnotations = new ArrayList(1);
            }
            tcb.invisibleTypeAnnotations.add(an);
        }
        return an;
    }

    public void visitLocalVariable(String name2, String desc2, String signature2, Label start, Label end, int index) {
        List<LocalVariableNode> list = this.localVariables;
        LocalVariableNode localVariableNode = new LocalVariableNode(name2, desc2, signature2, getLabelNode(start), getLabelNode(end), index);
        list.add(localVariableNode);
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc2, boolean visible) {
        LocalVariableAnnotationNode an = new LocalVariableAnnotationNode(typeRef, typePath, getLabelNodes(start), getLabelNodes(end), index, desc2);
        if (visible) {
            if (this.visibleLocalVariableAnnotations == null) {
                this.visibleLocalVariableAnnotations = new ArrayList(1);
            }
            this.visibleLocalVariableAnnotations.add(an);
        } else {
            if (this.invisibleLocalVariableAnnotations == null) {
                this.invisibleLocalVariableAnnotations = new ArrayList(1);
            }
            this.invisibleLocalVariableAnnotations.add(an);
        }
        return an;
    }

    public void visitLineNumber(int line, Label start) {
        this.instructions.add((AbstractInsnNode) new LineNumberNode(line, getLabelNode(start)));
    }

    public void visitMaxs(int maxStack2, int maxLocals2) {
        this.maxStack = maxStack2;
        this.maxLocals = maxLocals2;
    }

    public void visitEnd() {
    }

    /* access modifiers changed from: protected */
    public LabelNode getLabelNode(Label l) {
        if (!(l.info instanceof LabelNode)) {
            l.info = new LabelNode();
        }
        return (LabelNode) l.info;
    }

    private LabelNode[] getLabelNodes(Label[] l) {
        LabelNode[] nodes = new LabelNode[l.length];
        for (int i = 0; i < l.length; i++) {
            nodes[i] = getLabelNode(l[i]);
        }
        return nodes;
    }

    private Object[] getLabelNodes(Object[] objs) {
        Object[] nodes = new Object[objs.length];
        for (int i = 0; i < objs.length; i++) {
            Object o = objs[i];
            if (o instanceof Label) {
                o = getLabelNode((Label) o);
            }
            nodes[i] = o;
        }
        return nodes;
    }

    public void check(int api) {
        if (api == 262144) {
            List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
            if (list == null || list.size() <= 0) {
                List<TypeAnnotationNode> list2 = this.invisibleTypeAnnotations;
                if (list2 == null || list2.size() <= 0) {
                    List<TryCatchBlockNode> list3 = this.tryCatchBlocks;
                    int n = list3 == null ? 0 : list3.size();
                    int i = 0;
                    while (i < n) {
                        TryCatchBlockNode tcb = (TryCatchBlockNode) this.tryCatchBlocks.get(i);
                        List<TypeAnnotationNode> list4 = tcb.visibleTypeAnnotations;
                        if (list4 == null || list4.size() <= 0) {
                            List<TypeAnnotationNode> list5 = tcb.invisibleTypeAnnotations;
                            if (list5 == null || list5.size() <= 0) {
                                i++;
                            } else {
                                throw new RuntimeException();
                            }
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    int i2 = 0;
                    while (i2 < this.instructions.size()) {
                        AbstractInsnNode insn = this.instructions.get(i2);
                        List<TypeAnnotationNode> list6 = insn.visibleTypeAnnotations;
                        if (list6 == null || list6.size() <= 0) {
                            List<TypeAnnotationNode> list7 = insn.invisibleTypeAnnotations;
                            if (list7 == null || list7.size() <= 0) {
                                if (insn instanceof MethodInsnNode) {
                                    if (((MethodInsnNode) insn).itf != (insn.opcode == 185)) {
                                        throw new RuntimeException();
                                    }
                                }
                                i2++;
                            } else {
                                throw new RuntimeException();
                            }
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    List<LocalVariableAnnotationNode> list8 = this.visibleLocalVariableAnnotations;
                    if (list8 == null || list8.size() <= 0) {
                        List<LocalVariableAnnotationNode> list9 = this.invisibleLocalVariableAnnotations;
                        if (list9 != null && list9.size() > 0) {
                            throw new RuntimeException();
                        }
                        return;
                    }
                    throw new RuntimeException();
                }
                throw new RuntimeException();
            }
            throw new RuntimeException();
        }
    }

    public void accept(ClassVisitor cv) {
        String[] exceptions2 = new String[this.exceptions.size()];
        this.exceptions.toArray(exceptions2);
        MethodVisitor mv = cv.visitMethod(this.access, this.name, this.desc, this.signature, exceptions2);
        if (mv != null) {
            accept(mv);
        }
    }

    public void accept(MethodVisitor mv) {
        int i;
        int i2;
        int i3;
        List<ParameterNode> list = this.parameters;
        int n = list == null ? 0 : list.size();
        for (int i4 = 0; i4 < n; i4++) {
            ParameterNode parameter = (ParameterNode) this.parameters.get(i4);
            mv.visitParameter(parameter.name, parameter.access);
        }
        if (this.annotationDefault != null) {
            AnnotationVisitor av = mv.visitAnnotationDefault();
            AnnotationNode.accept(av, null, this.annotationDefault);
            if (av != null) {
                av.visitEnd();
            }
        }
        List<AnnotationNode> list2 = this.visibleAnnotations;
        int n2 = list2 == null ? 0 : list2.size();
        for (int i5 = 0; i5 < n2; i5++) {
            AnnotationNode an = (AnnotationNode) this.visibleAnnotations.get(i5);
            an.accept(mv.visitAnnotation(an.desc, true));
        }
        List<AnnotationNode> list3 = this.invisibleAnnotations;
        int n3 = list3 == null ? 0 : list3.size();
        for (int i6 = 0; i6 < n3; i6++) {
            AnnotationNode an2 = (AnnotationNode) this.invisibleAnnotations.get(i6);
            an2.accept(mv.visitAnnotation(an2.desc, false));
        }
        List<TypeAnnotationNode> list4 = this.visibleTypeAnnotations;
        int n4 = list4 == null ? 0 : list4.size();
        for (int i7 = 0; i7 < n4; i7++) {
            TypeAnnotationNode an3 = (TypeAnnotationNode) this.visibleTypeAnnotations.get(i7);
            an3.accept(mv.visitTypeAnnotation(an3.typeRef, an3.typePath, an3.desc, true));
        }
        List<TypeAnnotationNode> list5 = this.invisibleTypeAnnotations;
        if (list5 == null) {
            i = 0;
        } else {
            i = list5.size();
        }
        int n5 = i;
        for (int i8 = 0; i8 < n5; i8++) {
            TypeAnnotationNode an4 = (TypeAnnotationNode) this.invisibleTypeAnnotations.get(i8);
            an4.accept(mv.visitTypeAnnotation(an4.typeRef, an4.typePath, an4.desc, false));
        }
        List<AnnotationNode>[] listArr = this.visibleParameterAnnotations;
        int n6 = listArr == null ? 0 : listArr.length;
        for (int i9 = 0; i9 < n6; i9++) {
            List<AnnotationNode> list6 = this.visibleParameterAnnotations[i9];
            if (list6 != null) {
                for (int j = 0; j < list6.size(); j++) {
                    AnnotationNode an5 = (AnnotationNode) list6.get(j);
                    an5.accept(mv.visitParameterAnnotation(i9, an5.desc, true));
                }
            }
        }
        List<AnnotationNode>[] listArr2 = this.invisibleParameterAnnotations;
        int n7 = listArr2 == null ? 0 : listArr2.length;
        for (int i10 = 0; i10 < n7; i10++) {
            List<AnnotationNode> list7 = this.invisibleParameterAnnotations[i10];
            if (list7 != null) {
                for (int j2 = 0; j2 < list7.size(); j2++) {
                    AnnotationNode an6 = (AnnotationNode) list7.get(j2);
                    an6.accept(mv.visitParameterAnnotation(i10, an6.desc, false));
                }
            }
        }
        if (this.visited) {
            this.instructions.resetLabels();
        }
        List<Attribute> list8 = this.attrs;
        int n8 = list8 == null ? 0 : list8.size();
        for (int i11 = 0; i11 < n8; i11++) {
            mv.visitAttribute((Attribute) this.attrs.get(i11));
        }
        if (this.instructions.size() > 0) {
            mv.visitCode();
            List<TryCatchBlockNode> list9 = this.tryCatchBlocks;
            int n9 = list9 == null ? 0 : list9.size();
            for (int i12 = 0; i12 < n9; i12++) {
                ((TryCatchBlockNode) this.tryCatchBlocks.get(i12)).updateIndex(i12);
                ((TryCatchBlockNode) this.tryCatchBlocks.get(i12)).accept(mv);
            }
            this.instructions.accept(mv);
            List<LocalVariableNode> list10 = this.localVariables;
            int n10 = list10 == null ? 0 : list10.size();
            for (int i13 = 0; i13 < n10; i13++) {
                ((LocalVariableNode) this.localVariables.get(i13)).accept(mv);
            }
            List<LocalVariableAnnotationNode> list11 = this.visibleLocalVariableAnnotations;
            if (list11 == null) {
                i2 = 0;
            } else {
                i2 = list11.size();
            }
            int n11 = i2;
            for (int i14 = 0; i14 < n11; i14++) {
                ((LocalVariableAnnotationNode) this.visibleLocalVariableAnnotations.get(i14)).accept(mv, true);
            }
            List<LocalVariableAnnotationNode> list12 = this.invisibleLocalVariableAnnotations;
            if (list12 == null) {
                i3 = 0;
            } else {
                i3 = list12.size();
            }
            int n12 = i3;
            for (int i15 = 0; i15 < n12; i15++) {
                ((LocalVariableAnnotationNode) this.invisibleLocalVariableAnnotations.get(i15)).accept(mv, false);
            }
            mv.visitMaxs(this.maxStack, this.maxLocals);
            this.visited = true;
        }
        mv.visitEnd();
    }
}
