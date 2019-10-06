package org.jacoco.agent.p025rt.internal_8ff85ea.asm.commons;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.AbstractInsnNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.InsnList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.InsnNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.JumpInsnNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.LabelNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.LocalVariableNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.LookupSwitchInsnNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.MethodNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.TableSwitchInsnNode;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree.TryCatchBlockNode;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.commons.JSRInlinerAdapter */
public class JSRInlinerAdapter extends MethodNode implements Opcodes {
    private static final boolean LOGGING = false;
    final BitSet dualCitizens;
    private final BitSet mainSubroutine;
    private final Map<LabelNode, BitSet> subroutineHeads;

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.commons.JSRInlinerAdapter$Instantiation */
    private class Instantiation extends AbstractMap<LabelNode, LabelNode> {
        final Instantiation previous;
        public final Map<LabelNode, LabelNode> rangeTable = new HashMap();
        public final LabelNode returnLabel;
        public final BitSet subroutine;

        Instantiation(Instantiation prev, BitSet sub) {
            this.previous = prev;
            this.subroutine = sub;
            Instantiation p = prev;
            while (p != null) {
                if (p.subroutine != sub) {
                    p = p.previous;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Recursive invocation of ");
                    sb.append(sub);
                    throw new RuntimeException(sb.toString());
                }
            }
            if (prev != null) {
                this.returnLabel = new LabelNode();
            } else {
                this.returnLabel = null;
            }
            LabelNode duplbl = null;
            int c = JSRInlinerAdapter.this.instructions.size();
            for (int i = 0; i < c; i++) {
                AbstractInsnNode insn = JSRInlinerAdapter.this.instructions.get(i);
                if (insn.getType() == 8) {
                    LabelNode ilbl = (LabelNode) insn;
                    if (duplbl == null) {
                        duplbl = new LabelNode();
                    }
                    this.rangeTable.put(ilbl, duplbl);
                } else if (findOwner(i) == this) {
                    duplbl = null;
                }
            }
        }

        public Instantiation findOwner(int i) {
            if (!this.subroutine.get(i)) {
                return null;
            }
            if (!JSRInlinerAdapter.this.dualCitizens.get(i)) {
                return this;
            }
            Instantiation own = this;
            for (Instantiation p = this.previous; p != null; p = p.previous) {
                if (p.subroutine.get(i)) {
                    own = p;
                }
            }
            return own;
        }

        public LabelNode gotoLabel(LabelNode l) {
            return (LabelNode) findOwner(JSRInlinerAdapter.this.instructions.indexOf(l)).rangeTable.get(l);
        }

        public LabelNode rangeLabel(LabelNode l) {
            return (LabelNode) this.rangeTable.get(l);
        }

        public Set<Entry<LabelNode, LabelNode>> entrySet() {
            return null;
        }

        public LabelNode get(Object o) {
            return gotoLabel((LabelNode) o);
        }
    }

    public JSRInlinerAdapter(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
        this(327680, mv, access, name, desc, signature, exceptions);
        if (getClass() != JSRInlinerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected JSRInlinerAdapter(int api, MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
        super(api, access, name, desc, signature, exceptions);
        this.subroutineHeads = new HashMap();
        this.mainSubroutine = new BitSet();
        this.dualCitizens = new BitSet();
        this.f149mv = mv;
    }

    public void visitJumpInsn(int opcode, Label lbl) {
        super.visitJumpInsn(opcode, lbl);
        LabelNode ln = ((JumpInsnNode) this.instructions.getLast()).label;
        if (opcode == 168 && !this.subroutineHeads.containsKey(ln)) {
            this.subroutineHeads.put(ln, new BitSet());
        }
    }

    public void visitEnd() {
        if (!this.subroutineHeads.isEmpty()) {
            markSubroutines();
            emitCode();
        }
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            accept(methodVisitor);
        }
    }

    private void markSubroutines() {
        BitSet anyvisited = new BitSet();
        markSubroutineWalk(this.mainSubroutine, 0, anyvisited);
        for (Entry<LabelNode, BitSet> entry : this.subroutineHeads.entrySet()) {
            markSubroutineWalk((BitSet) entry.getValue(), this.instructions.indexOf((LabelNode) entry.getKey()), anyvisited);
        }
    }

    private void markSubroutineWalk(BitSet sub, int index, BitSet anyvisited) {
        markSubroutineWalkDFS(sub, index, anyvisited);
        boolean loop = true;
        while (loop) {
            loop = false;
            for (TryCatchBlockNode trycatch : this.tryCatchBlocks) {
                int handlerindex = this.instructions.indexOf(trycatch.handler);
                if (!sub.get(handlerindex)) {
                    int startindex = this.instructions.indexOf(trycatch.start);
                    int endindex = this.instructions.indexOf(trycatch.end);
                    int nextbit = sub.nextSetBit(startindex);
                    if (nextbit != -1 && nextbit < endindex) {
                        markSubroutineWalkDFS(sub, handlerindex, anyvisited);
                        loop = true;
                    }
                }
            }
        }
    }

    private void markSubroutineWalkDFS(BitSet sub, int index, BitSet anyvisited) {
        do {
            AbstractInsnNode node = this.instructions.get(index);
            if (!sub.get(index)) {
                sub.set(index);
                if (anyvisited.get(index)) {
                    this.dualCitizens.set(index);
                }
                anyvisited.set(index);
                if (node.getType() == 7 && node.getOpcode() != 168) {
                    markSubroutineWalkDFS(sub, this.instructions.indexOf(((JumpInsnNode) node).label), anyvisited);
                }
                if (node.getType() == 11) {
                    TableSwitchInsnNode tsnode = (TableSwitchInsnNode) node;
                    markSubroutineWalkDFS(sub, this.instructions.indexOf(tsnode.dflt), anyvisited);
                    for (int i = tsnode.labels.size() - 1; i >= 0; i--) {
                        markSubroutineWalkDFS(sub, this.instructions.indexOf((LabelNode) tsnode.labels.get(i)), anyvisited);
                    }
                }
                if (node.getType() == 12) {
                    LookupSwitchInsnNode lsnode = (LookupSwitchInsnNode) node;
                    markSubroutineWalkDFS(sub, this.instructions.indexOf(lsnode.dflt), anyvisited);
                    for (int i2 = lsnode.labels.size() - 1; i2 >= 0; i2--) {
                        markSubroutineWalkDFS(sub, this.instructions.indexOf((LabelNode) lsnode.labels.get(i2)), anyvisited);
                    }
                }
                int opcode = this.instructions.get(index).getOpcode();
                if (!(opcode == 167 || opcode == 191)) {
                    switch (opcode) {
                        case Opcodes.RET /*169*/:
                        case Opcodes.TABLESWITCH /*170*/:
                        case Opcodes.LOOKUPSWITCH /*171*/:
                        case Opcodes.IRETURN /*172*/:
                        case Opcodes.LRETURN /*173*/:
                        case Opcodes.FRETURN /*174*/:
                        case Opcodes.DRETURN /*175*/:
                        case Opcodes.ARETURN /*176*/:
                        case Opcodes.RETURN /*177*/:
                            break;
                        default:
                            index++;
                            break;
                    }
                }
                return;
            }
            return;
        } while (index < this.instructions.size());
    }

    private void emitCode() {
        LinkedList<Instantiation> worklist = new LinkedList<>();
        worklist.add(new Instantiation(null, this.mainSubroutine));
        InsnList newInstructions = new InsnList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (!worklist.isEmpty()) {
            emitSubroutine((Instantiation) worklist.removeFirst(), worklist, newInstructions, arrayList, arrayList2);
        }
        this.instructions = newInstructions;
        this.tryCatchBlocks = arrayList;
        this.localVariables = arrayList2;
    }

    private void emitSubroutine(Instantiation instant, List<Instantiation> worklist, InsnList newInstructions, List<TryCatchBlockNode> newTryCatchBlocks, List<LocalVariableNode> newLocalVariables) {
        Instantiation instantiation = instant;
        InsnList insnList = newInstructions;
        LabelNode duplbl = null;
        int c = this.instructions.size();
        for (int i = 0; i < c; i++) {
            AbstractInsnNode insn = this.instructions.get(i);
            Instantiation owner = instantiation.findOwner(i);
            if (insn.getType() == 8) {
                LabelNode remap = instantiation.rangeLabel((LabelNode) insn);
                if (remap != duplbl) {
                    insnList.add((AbstractInsnNode) remap);
                    duplbl = remap;
                    List<Instantiation> list = worklist;
                } else {
                    List<Instantiation> list2 = worklist;
                }
            } else if (owner != instantiation) {
                List<Instantiation> list3 = worklist;
            } else if (insn.getOpcode() == 169) {
                LabelNode retlabel = null;
                for (Instantiation p = instant; p != null; p = p.previous) {
                    if (p.subroutine.get(i)) {
                        retlabel = p.returnLabel;
                    }
                }
                if (retlabel != null) {
                    insnList.add((AbstractInsnNode) new JumpInsnNode(Opcodes.GOTO, retlabel));
                    List<Instantiation> list4 = worklist;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Instruction #");
                    sb.append(i);
                    sb.append(" is a RET not owned by any subroutine");
                    throw new RuntimeException(sb.toString());
                }
            } else if (insn.getOpcode() == 168) {
                LabelNode lbl = ((JumpInsnNode) insn).label;
                Instantiation newinst = new Instantiation(instantiation, (BitSet) this.subroutineHeads.get(lbl));
                LabelNode startlbl = newinst.gotoLabel(lbl);
                insnList.add((AbstractInsnNode) new InsnNode(1));
                insnList.add((AbstractInsnNode) new JumpInsnNode(Opcodes.GOTO, startlbl));
                insnList.add((AbstractInsnNode) newinst.returnLabel);
                worklist.add(newinst);
            } else {
                List<Instantiation> list5 = worklist;
                insnList.add(insn.clone(instantiation));
            }
        }
        List<Instantiation> list6 = worklist;
        for (TryCatchBlockNode trycatch : this.tryCatchBlocks) {
            LabelNode start = instantiation.rangeLabel(trycatch.start);
            LabelNode end = instantiation.rangeLabel(trycatch.end);
            if (start != end) {
                LabelNode handler = instantiation.gotoLabel(trycatch.handler);
                if (start == null || end == null || handler == null) {
                    List<TryCatchBlockNode> list7 = newTryCatchBlocks;
                    throw new RuntimeException("Internal error!");
                } else {
                    newTryCatchBlocks.add(new TryCatchBlockNode(start, end, handler, trycatch.type));
                }
            }
        }
        List<TryCatchBlockNode> list8 = newTryCatchBlocks;
        for (LocalVariableNode lvnode : this.localVariables) {
            LabelNode start2 = instantiation.rangeLabel(lvnode.start);
            LabelNode end2 = instantiation.rangeLabel(lvnode.end);
            if (start2 != end2) {
                LocalVariableNode localVariableNode = new LocalVariableNode(lvnode.name, lvnode.desc, lvnode.signature, start2, end2, lvnode.index);
                newLocalVariables.add(localVariableNode);
            }
        }
        List<LocalVariableNode> list9 = newLocalVariables;
    }

    private static void log(String str) {
        System.err.println(str);
    }
}
