package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TryCatchBlockNode */
public class TryCatchBlockNode {
    public LabelNode end;
    public LabelNode handler;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public LabelNode start;
    public String type;
    public List<TypeAnnotationNode> visibleTypeAnnotations;

    public TryCatchBlockNode(LabelNode start2, LabelNode end2, LabelNode handler2, String type2) {
        this.start = start2;
        this.end = end2;
        this.handler = handler2;
        this.type = type2;
    }

    public void updateIndex(int index) {
        int newTypeRef = (index << 8) | 1107296256;
        List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
        if (list != null) {
            for (TypeAnnotationNode tan : list) {
                tan.typeRef = newTypeRef;
            }
        }
        List<TypeAnnotationNode> list2 = this.invisibleTypeAnnotations;
        if (list2 != null) {
            for (TypeAnnotationNode tan2 : list2) {
                tan2.typeRef = newTypeRef;
            }
        }
    }

    public void accept(MethodVisitor mv) {
        Label label;
        int n;
        int i;
        Label label2 = this.start.getLabel();
        Label label3 = this.end.getLabel();
        LabelNode labelNode = this.handler;
        if (labelNode == null) {
            label = null;
        } else {
            label = labelNode.getLabel();
        }
        mv.visitTryCatchBlock(label2, label3, label, this.type);
        List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
        if (list == null) {
            n = 0;
        } else {
            n = list.size();
        }
        for (int i2 = 0; i2 < n; i2++) {
            TypeAnnotationNode an = (TypeAnnotationNode) this.visibleTypeAnnotations.get(i2);
            an.accept(mv.visitTryCatchAnnotation(an.typeRef, an.typePath, an.desc, true));
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
            an2.accept(mv.visitTryCatchAnnotation(an2.typeRef, an2.typePath, an2.desc, false));
        }
    }
}
