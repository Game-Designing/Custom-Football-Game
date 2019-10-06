package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LabelNode */
public class LabelNode extends AbstractInsnNode {
    private Label label;

    public LabelNode() {
        super(-1);
    }

    public LabelNode(Label label2) {
        super(-1);
        this.label = label2;
    }

    public int getType() {
        return 8;
    }

    public Label getLabel() {
        if (this.label == null) {
            this.label = new Label();
        }
        return this.label;
    }

    public void accept(MethodVisitor cv) {
        cv.visitLabel(getLabel());
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels) {
        return (AbstractInsnNode) labels.get(this);
    }

    public void resetLabel() {
        this.label = null;
    }
}
