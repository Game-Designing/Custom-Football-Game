package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.FrameNode */
public class FrameNode extends AbstractInsnNode {
    public List<Object> local;
    public List<Object> stack;
    public int type;

    private FrameNode() {
        super(-1);
    }

    public FrameNode(int type2, int nLocal, Object[] local2, int nStack, Object[] stack2) {
        super(-1);
        this.type = type2;
        if (type2 == -1 || type2 == 0) {
            this.local = asList(nLocal, local2);
            this.stack = asList(nStack, stack2);
        } else if (type2 == 1) {
            this.local = asList(nLocal, local2);
        } else if (type2 == 2) {
            this.local = Arrays.asList(new Object[nLocal]);
        } else if (type2 != 3 && type2 == 4) {
            this.stack = asList(1, stack2);
        }
    }

    public int getType() {
        return 14;
    }

    public void accept(MethodVisitor mv) {
        int i = this.type;
        if (i == -1 || i == 0) {
            mv.visitFrame(this.type, this.local.size(), asArray(this.local), this.stack.size(), asArray(this.stack));
        } else if (i == 1) {
            mv.visitFrame(i, this.local.size(), asArray(this.local), 0, null);
        } else if (i == 2) {
            mv.visitFrame(i, this.local.size(), null, 0, null);
        } else if (i == 3) {
            mv.visitFrame(i, 0, null, 0, null);
        } else if (i == 4) {
            mv.visitFrame(i, 0, null, 1, asArray(this.stack));
        }
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels) {
        FrameNode clone = new FrameNode();
        clone.type = this.type;
        if (this.local != null) {
            clone.local = new ArrayList();
            for (int i = 0; i < this.local.size(); i++) {
                Object l = this.local.get(i);
                if (l instanceof LabelNode) {
                    l = labels.get(l);
                }
                clone.local.add(l);
            }
        }
        if (this.stack != null) {
            clone.stack = new ArrayList();
            for (int i2 = 0; i2 < this.stack.size(); i2++) {
                Object s = this.stack.get(i2);
                if (s instanceof LabelNode) {
                    s = labels.get(s);
                }
                clone.stack.add(s);
            }
        }
        return clone;
    }

    private static List<Object> asList(int n, Object[] o) {
        return Arrays.asList(o).subList(0, n);
    }

    private static Object[] asArray(List<Object> l) {
        Object[] objs = new Object[l.size()];
        for (int i = 0; i < objs.length; i++) {
            Object o = l.get(i);
            if (o instanceof LabelNode) {
                o = ((LabelNode) o).getLabel();
            }
            objs[i] = o;
        }
        return objs;
    }
}
