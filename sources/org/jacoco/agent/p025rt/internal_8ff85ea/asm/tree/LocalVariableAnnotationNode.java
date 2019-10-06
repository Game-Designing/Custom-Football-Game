package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LocalVariableAnnotationNode */
public class LocalVariableAnnotationNode extends TypeAnnotationNode {
    public List<LabelNode> end;
    public List<Integer> index;
    public List<LabelNode> start;

    public LocalVariableAnnotationNode(int typeRef, TypePath typePath, LabelNode[] start2, LabelNode[] end2, int[] index2, String desc) {
        this(327680, typeRef, typePath, start2, end2, index2, desc);
    }

    public LocalVariableAnnotationNode(int api, int typeRef, TypePath typePath, LabelNode[] start2, LabelNode[] end2, int[] index2, String desc) {
        super(api, typeRef, typePath, desc);
        this.start = new ArrayList(start2.length);
        this.start.addAll(Arrays.asList(start2));
        this.end = new ArrayList(end2.length);
        this.end.addAll(Arrays.asList(end2));
        this.index = new ArrayList(index2.length);
        for (int i : index2) {
            this.index.add(Integer.valueOf(i));
        }
    }

    public void accept(MethodVisitor mv, boolean visible) {
        Label[] start2 = new Label[this.start.size()];
        Label[] end2 = new Label[this.end.size()];
        int[] index2 = new int[this.index.size()];
        for (int i = 0; i < start2.length; i++) {
            start2[i] = ((LabelNode) this.start.get(i)).getLabel();
            end2[i] = ((LabelNode) this.end.get(i)).getLabel();
            index2[i] = ((Integer) this.index.get(i)).intValue();
        }
        accept(mv.visitLocalVariableAnnotation(this.typeRef, this.typePath, start2, end2, index2, this.desc, true));
    }
}
