package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LookupSwitchInsnNode */
public class LookupSwitchInsnNode extends AbstractInsnNode {
    public LabelNode dflt;
    public List<Integer> keys;
    public List<LabelNode> labels;

    public LookupSwitchInsnNode(LabelNode dflt2, int[] keys2, LabelNode[] labels2) {
        super(Opcodes.LOOKUPSWITCH);
        this.dflt = dflt2;
        int i = 0;
        this.keys = new ArrayList(keys2 == null ? 0 : keys2.length);
        if (labels2 != null) {
            i = labels2.length;
        }
        this.labels = new ArrayList(i);
        if (keys2 != null) {
            for (int valueOf : keys2) {
                this.keys.add(Integer.valueOf(valueOf));
            }
        }
        if (labels2 != null) {
            this.labels.addAll(Arrays.asList(labels2));
        }
    }

    public int getType() {
        return 12;
    }

    public void accept(MethodVisitor mv) {
        int[] keys2 = new int[this.keys.size()];
        for (int i = 0; i < keys2.length; i++) {
            keys2[i] = ((Integer) this.keys.get(i)).intValue();
        }
        Label[] labels2 = new Label[this.labels.size()];
        for (int i2 = 0; i2 < labels2.length; i2++) {
            labels2[i2] = ((LabelNode) this.labels.get(i2)).getLabel();
        }
        mv.visitLookupSwitchInsn(this.dflt.getLabel(), keys2, labels2);
        acceptAnnotations(mv);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels2) {
        LookupSwitchInsnNode clone = new LookupSwitchInsnNode(AbstractInsnNode.clone(this.dflt, labels2), null, AbstractInsnNode.clone(this.labels, labels2));
        clone.keys.addAll(this.keys);
        return clone.cloneAnnotations(this);
    }
}
