package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TypeAnnotationNode */
public class TypeAnnotationNode extends AnnotationNode {
    public TypePath typePath;
    public int typeRef;

    public TypeAnnotationNode(int typeRef2, TypePath typePath2, String desc) {
        this(327680, typeRef2, typePath2, desc);
        if (getClass() != TypeAnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public TypeAnnotationNode(int api, int typeRef2, TypePath typePath2, String desc) {
        super(api, desc);
        this.typeRef = typeRef2;
        this.typePath = typePath2;
    }
}
