package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.AbstractInsnNode */
public abstract class AbstractInsnNode {
    public static final int FIELD_INSN = 4;
    public static final int FRAME = 14;
    public static final int IINC_INSN = 10;
    public static final int INSN = 0;
    public static final int INT_INSN = 1;
    public static final int INVOKE_DYNAMIC_INSN = 6;
    public static final int JUMP_INSN = 7;
    public static final int LABEL = 8;
    public static final int LDC_INSN = 9;
    public static final int LINE = 15;
    public static final int LOOKUPSWITCH_INSN = 12;
    public static final int METHOD_INSN = 5;
    public static final int MULTIANEWARRAY_INSN = 13;
    public static final int TABLESWITCH_INSN = 11;
    public static final int TYPE_INSN = 3;
    public static final int VAR_INSN = 2;
    int index = -1;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    AbstractInsnNode next;
    protected int opcode;
    AbstractInsnNode prev;
    public List<TypeAnnotationNode> visibleTypeAnnotations;

    public abstract void accept(MethodVisitor methodVisitor);

    public abstract AbstractInsnNode clone(Map<LabelNode, LabelNode> map);

    public abstract int getType();

    protected AbstractInsnNode(int opcode2) {
        this.opcode = opcode2;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public AbstractInsnNode getPrevious() {
        return this.prev;
    }

    public AbstractInsnNode getNext() {
        return this.next;
    }

    /* access modifiers changed from: protected */
    public final void acceptAnnotations(MethodVisitor mv) {
        int n;
        int i;
        List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
        if (list == null) {
            n = 0;
        } else {
            n = list.size();
        }
        for (int i2 = 0; i2 < n; i2++) {
            TypeAnnotationNode an = (TypeAnnotationNode) this.visibleTypeAnnotations.get(i2);
            an.accept(mv.visitInsnAnnotation(an.typeRef, an.typePath, an.desc, true));
        }
        List<TypeAnnotationNode> list2 = this.invisibleTypeAnnotations;
        if (list2 == null) {
            i = 0;
        } else {
            i = list2.size();
        }
        int n2 = i;
        for (int i3 = 0; i3 < n2; i3++) {
            TypeAnnotationNode an2 = (TypeAnnotationNode) this.invisibleTypeAnnotations.get(i3);
            an2.accept(mv.visitInsnAnnotation(an2.typeRef, an2.typePath, an2.desc, false));
        }
    }

    static LabelNode clone(LabelNode label, Map<LabelNode, LabelNode> map) {
        return (LabelNode) map.get(label);
    }

    static LabelNode[] clone(List<LabelNode> labels, Map<LabelNode, LabelNode> map) {
        LabelNode[] clones = new LabelNode[labels.size()];
        for (int i = 0; i < clones.length; i++) {
            clones[i] = (LabelNode) map.get(labels.get(i));
        }
        return clones;
    }

    /* access modifiers changed from: protected */
    public final AbstractInsnNode cloneAnnotations(AbstractInsnNode insn) {
        if (insn.visibleTypeAnnotations != null) {
            this.visibleTypeAnnotations = new ArrayList();
            for (int i = 0; i < insn.visibleTypeAnnotations.size(); i++) {
                TypeAnnotationNode src = (TypeAnnotationNode) insn.visibleTypeAnnotations.get(i);
                TypeAnnotationNode ann = new TypeAnnotationNode(src.typeRef, src.typePath, src.desc);
                src.accept(ann);
                this.visibleTypeAnnotations.add(ann);
            }
        }
        if (insn.invisibleTypeAnnotations != null) {
            this.invisibleTypeAnnotations = new ArrayList();
            for (int i2 = 0; i2 < insn.invisibleTypeAnnotations.size(); i2++) {
                TypeAnnotationNode src2 = (TypeAnnotationNode) insn.invisibleTypeAnnotations.get(i2);
                TypeAnnotationNode ann2 = new TypeAnnotationNode(src2.typeRef, src2.typePath, src2.desc);
                src2.accept(ann2);
                this.invisibleTypeAnnotations.add(ann2);
            }
        }
        return this;
    }
}
