package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TableSwitchInsnNode */
public class TableSwitchInsnNode extends AbstractInsnNode {
    public LabelNode dflt;
    public List<LabelNode> labels = new ArrayList();
    public int max;
    public int min;

    public TableSwitchInsnNode(int min2, int max2, LabelNode dflt2, LabelNode... labels2) {
        super(Opcodes.TABLESWITCH);
        this.min = min2;
        this.max = max2;
        this.dflt = dflt2;
        if (labels2 != null) {
            this.labels.addAll(Arrays.asList(labels2));
        }
    }

    public int getType() {
        return 11;
    }

    public void accept(MethodVisitor mv) {
        Label[] labels2 = new Label[this.labels.size()];
        for (int i = 0; i < labels2.length; i++) {
            labels2[i] = ((LabelNode) this.labels.get(i)).getLabel();
        }
        mv.visitTableSwitchInsn(this.min, this.max, this.dflt.getLabel(), labels2);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels2) {
        return new TableSwitchInsnNode(this.min, this.max, AbstractInsnNode.clone(this.dflt, labels2), AbstractInsnNode.clone(this.labels, labels2)).cloneAnnotations(this);
    }
}
