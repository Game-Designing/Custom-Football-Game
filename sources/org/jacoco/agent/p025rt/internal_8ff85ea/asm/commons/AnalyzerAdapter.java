package org.jacoco.agent.p025rt.internal_8ff85ea.asm.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Type;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.commons.AnalyzerAdapter */
public class AnalyzerAdapter extends MethodVisitor {
    private List<Label> labels;
    public List<Object> locals;
    private int maxLocals;
    private int maxStack;
    private String owner;
    public List<Object> stack;
    public Map<Object, Object> uninitializedTypes;

    public AnalyzerAdapter(String owner2, int access, String name, String desc, MethodVisitor mv) {
        this(327680, owner2, access, name, desc, mv);
        if (getClass() != AnalyzerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected AnalyzerAdapter(int api, String owner2, int access, String name, String desc, MethodVisitor mv) {
        super(api, mv);
        this.owner = owner2;
        this.locals = new ArrayList();
        this.stack = new ArrayList();
        this.uninitializedTypes = new HashMap();
        if ((access & 8) == 0) {
            if ("<init>".equals(name)) {
                this.locals.add(Opcodes.UNINITIALIZED_THIS);
            } else {
                this.locals.add(owner2);
            }
        }
        Type[] types = Type.getArgumentTypes(desc);
        for (int i = 0; i < types.length; i++) {
            switch (types[i].getSort()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    this.locals.add(Opcodes.INTEGER);
                    break;
                case 6:
                    this.locals.add(Opcodes.FLOAT);
                    break;
                case 7:
                    this.locals.add(Opcodes.LONG);
                    this.locals.add(Opcodes.TOP);
                    break;
                case 8:
                    this.locals.add(Opcodes.DOUBLE);
                    this.locals.add(Opcodes.TOP);
                    break;
                case 9:
                    this.locals.add(types[i].getDescriptor());
                    break;
                default:
                    this.locals.add(types[i].getInternalName());
                    break;
            }
        }
        this.maxLocals = this.locals.size();
    }

    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack2) {
        if (type == -1) {
            MethodVisitor methodVisitor = this.f149mv;
            if (methodVisitor != null) {
                methodVisitor.visitFrame(type, nLocal, local, nStack, stack2);
            }
            List<Object> list = this.locals;
            if (list != null) {
                list.clear();
                this.stack.clear();
            } else {
                this.locals = new ArrayList();
                this.stack = new ArrayList();
            }
            visitFrameTypes(nLocal, local, this.locals);
            visitFrameTypes(nStack, stack2, this.stack);
            this.maxStack = Math.max(this.maxStack, this.stack.size());
            return;
        }
        throw new IllegalStateException("ClassReader.accept() should be called with EXPAND_FRAMES flag");
    }

    private static void visitFrameTypes(int n, Object[] types, List<Object> result) {
        for (int i = 0; i < n; i++) {
            Object type = types[i];
            result.add(type);
            if (type == Opcodes.LONG || type == Opcodes.DOUBLE) {
                result.add(Opcodes.TOP);
            }
        }
    }

    public void visitInsn(int opcode) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitInsn(opcode);
        }
        execute(opcode, 0, null);
        if ((opcode >= 172 && opcode <= 177) || opcode == 191) {
            this.locals = null;
            this.stack = null;
        }
    }

    public void visitIntInsn(int opcode, int operand) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitIntInsn(opcode, operand);
        }
        execute(opcode, operand, null);
    }

    public void visitVarInsn(int opcode, int var) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitVarInsn(opcode, var);
        }
        execute(opcode, var, null);
    }

    public void visitTypeInsn(int opcode, String type) {
        if (opcode == 187) {
            if (this.labels == null) {
                Label l = new Label();
                this.labels = new ArrayList(3);
                this.labels.add(l);
                MethodVisitor methodVisitor = this.f149mv;
                if (methodVisitor != null) {
                    methodVisitor.visitLabel(l);
                }
            }
            for (int i = 0; i < this.labels.size(); i++) {
                this.uninitializedTypes.put(this.labels.get(i), type);
            }
        }
        MethodVisitor methodVisitor2 = this.f149mv;
        if (methodVisitor2 != null) {
            methodVisitor2.visitTypeInsn(opcode, type);
        }
        execute(opcode, 0, type);
    }

    public void visitFieldInsn(int opcode, String owner2, String name, String desc) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitFieldInsn(opcode, owner2, name, desc);
        }
        execute(opcode, 0, desc);
    }

    @Deprecated
    public void visitMethodInsn(int opcode, String owner2, String name, String desc) {
        if (this.api >= 327680) {
            super.visitMethodInsn(opcode, owner2, name, desc);
        } else {
            doVisitMethodInsn(opcode, owner2, name, desc, opcode == 185);
        }
    }

    public void visitMethodInsn(int opcode, String owner2, String name, String desc, boolean itf) {
        if (this.api < 327680) {
            super.visitMethodInsn(opcode, owner2, name, desc, itf);
        } else {
            doVisitMethodInsn(opcode, owner2, name, desc, itf);
        }
    }

    private void doVisitMethodInsn(int opcode, String owner2, String name, String desc, boolean itf) {
        Object u;
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitMethodInsn(opcode, owner2, name, desc, itf);
        }
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        pop(desc);
        if (opcode != 184) {
            Object t = pop();
            if (opcode == 183 && name.charAt(0) == '<') {
                if (t == Opcodes.UNINITIALIZED_THIS) {
                    u = this.owner;
                } else {
                    u = this.uninitializedTypes.get(t);
                }
                for (int i = 0; i < this.locals.size(); i++) {
                    if (this.locals.get(i) == t) {
                        this.locals.set(i, u);
                    }
                }
                for (int i2 = 0; i2 < this.stack.size(); i2++) {
                    if (this.stack.get(i2) == t) {
                        this.stack.set(i2, u);
                    }
                }
            }
        }
        pushDesc(desc);
        this.labels = null;
    }

    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
        }
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        pop(desc);
        pushDesc(desc);
        this.labels = null;
    }

    public void visitJumpInsn(int opcode, Label label) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitJumpInsn(opcode, label);
        }
        execute(opcode, 0, null);
        if (opcode == 167) {
            this.locals = null;
            this.stack = null;
        }
    }

    public void visitLabel(Label label) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLabel(label);
        }
        if (this.labels == null) {
            this.labels = new ArrayList(3);
        }
        this.labels.add(label);
    }

    public void visitLdcInsn(Object cst) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLdcInsn(cst);
        }
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        if (cst instanceof Integer) {
            push(Opcodes.INTEGER);
        } else if (cst instanceof Long) {
            push(Opcodes.LONG);
            push(Opcodes.TOP);
        } else if (cst instanceof Float) {
            push(Opcodes.FLOAT);
        } else if (cst instanceof Double) {
            push(Opcodes.DOUBLE);
            push(Opcodes.TOP);
        } else if (cst instanceof String) {
            push("java/lang/String");
        } else if (cst instanceof Type) {
            int sort = ((Type) cst).getSort();
            if (sort == 10 || sort == 9) {
                push("java/lang/Class");
            } else if (sort == 11) {
                push("java/lang/invoke/MethodType");
            } else {
                throw new IllegalArgumentException();
            }
        } else if (cst instanceof Handle) {
            push("java/lang/invoke/MethodHandle");
        } else {
            throw new IllegalArgumentException();
        }
        this.labels = null;
    }

    public void visitIincInsn(int var, int increment) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitIincInsn(var, increment);
        }
        execute(Opcodes.IINC, var, null);
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels2) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitTableSwitchInsn(min, max, dflt, labels2);
        }
        execute(Opcodes.TABLESWITCH, 0, null);
        this.locals = null;
        this.stack = null;
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels2) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitLookupSwitchInsn(dflt, keys, labels2);
        }
        execute(Opcodes.LOOKUPSWITCH, 0, null);
        this.locals = null;
        this.stack = null;
    }

    public void visitMultiANewArrayInsn(String desc, int dims) {
        MethodVisitor methodVisitor = this.f149mv;
        if (methodVisitor != null) {
            methodVisitor.visitMultiANewArrayInsn(desc, dims);
        }
        execute(Opcodes.MULTIANEWARRAY, dims, desc);
    }

    public void visitMaxs(int maxStack2, int maxLocals2) {
        if (this.f149mv != null) {
            this.maxStack = Math.max(this.maxStack, maxStack2);
            this.maxLocals = Math.max(this.maxLocals, maxLocals2);
            this.f149mv.visitMaxs(this.maxStack, this.maxLocals);
        }
    }

    private Object get(int local) {
        this.maxLocals = Math.max(this.maxLocals, local + 1);
        return local < this.locals.size() ? this.locals.get(local) : Opcodes.TOP;
    }

    private void set(int local, Object type) {
        this.maxLocals = Math.max(this.maxLocals, local + 1);
        while (local >= this.locals.size()) {
            this.locals.add(Opcodes.TOP);
        }
        this.locals.set(local, type);
    }

    private void push(Object type) {
        this.stack.add(type);
        this.maxStack = Math.max(this.maxStack, this.stack.size());
    }

    private void pushDesc(String desc) {
        int index = 0;
        if (desc.charAt(0) == '(') {
            index = desc.indexOf(41) + 1;
        }
        char charAt = desc.charAt(index);
        if (charAt != 'F') {
            if (charAt != 'S') {
                if (charAt == 'V') {
                    return;
                }
                if (charAt != 'I') {
                    if (charAt == 'J') {
                        push(Opcodes.LONG);
                        push(Opcodes.TOP);
                        return;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    push(Opcodes.DOUBLE);
                                    push(Opcodes.TOP);
                                    return;
                                default:
                                    if (index != 0) {
                                        push(desc.substring(index + 1, desc.length() - 1));
                                        break;
                                    } else {
                                        push(desc.substring(1, desc.length() - 1));
                                        break;
                                    }
                            }
                        } else if (index == 0) {
                            push(desc);
                        } else {
                            push(desc.substring(index, desc.length()));
                        }
                        return;
                    }
                }
            }
            push(Opcodes.INTEGER);
            return;
        }
        push(Opcodes.FLOAT);
    }

    private Object pop() {
        List<Object> list = this.stack;
        return list.remove(list.size() - 1);
    }

    private void pop(int n) {
        int size = this.stack.size();
        int end = size - n;
        for (int i = size - 1; i >= end; i--) {
            this.stack.remove(i);
        }
    }

    private void pop(String desc) {
        char c = desc.charAt(0);
        if (c == '(') {
            int n = 0;
            for (Type size : Type.getArgumentTypes(desc)) {
                n += size.getSize();
            }
            pop(n);
        } else if (c == 'J' || c == 'D') {
            pop(2);
        } else {
            pop(1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ce, code lost:
        pop(1);
        push(org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.INTEGER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025f, code lost:
        pop(2);
        push(org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.DOUBLE);
        push(org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0276, code lost:
        pop(2);
        push(org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG);
        push(org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void execute(int r6, int r7, java.lang.String r8) {
        /*
            r5 = this;
            java.util.List<java.lang.Object> r0 = r5.locals
            r1 = 0
            if (r0 != 0) goto L_0x0008
            r5.labels = r1
            return
        L_0x0008:
            r0 = 198(0xc6, float:2.77E-43)
            r2 = 1
            if (r6 == r0) goto L_0x02cb
            r0 = 199(0xc7, float:2.79E-43)
            if (r6 == r0) goto L_0x02cb
            switch(r6) {
                case 0: goto L_0x02ca;
                case 1: goto L_0x02c4;
                case 2: goto L_0x02be;
                case 3: goto L_0x02be;
                case 4: goto L_0x02be;
                case 5: goto L_0x02be;
                case 6: goto L_0x02be;
                case 7: goto L_0x02be;
                case 8: goto L_0x02be;
                case 9: goto L_0x02b3;
                case 10: goto L_0x02b3;
                case 11: goto L_0x02ad;
                case 12: goto L_0x02ad;
                case 13: goto L_0x02ad;
                case 14: goto L_0x02a2;
                case 15: goto L_0x02a2;
                case 16: goto L_0x02be;
                case 17: goto L_0x02be;
                default: goto L_0x0014;
            }
        L_0x0014:
            switch(r6) {
                case 21: goto L_0x029a;
                case 22: goto L_0x028d;
                case 23: goto L_0x029a;
                case 24: goto L_0x028d;
                case 25: goto L_0x029a;
                default: goto L_0x0017;
            }
        L_0x0017:
            r0 = 2
            switch(r6) {
                case 46: goto L_0x0284;
                case 47: goto L_0x0276;
                case 48: goto L_0x026d;
                case 49: goto L_0x025f;
                case 50: goto L_0x0241;
                case 51: goto L_0x0284;
                case 52: goto L_0x0284;
                case 53: goto L_0x0284;
                case 54: goto L_0x0221;
                case 55: goto L_0x01f7;
                case 56: goto L_0x0221;
                case 57: goto L_0x01f7;
                case 58: goto L_0x0221;
                default: goto L_0x001b;
            }
        L_0x001b:
            r3 = 3
            r4 = 4
            switch(r6) {
                case 79: goto L_0x01f2;
                case 80: goto L_0x01ed;
                case 81: goto L_0x01f2;
                case 82: goto L_0x01ed;
                case 83: goto L_0x01f2;
                case 84: goto L_0x01f2;
                case 85: goto L_0x01f2;
                case 86: goto L_0x01f2;
                case 87: goto L_0x02cb;
                case 88: goto L_0x01e8;
                case 89: goto L_0x01dc;
                case 90: goto L_0x01c9;
                case 91: goto L_0x01af;
                case 92: goto L_0x0199;
                case 93: goto L_0x017c;
                case 94: goto L_0x0158;
                case 95: goto L_0x0148;
                case 96: goto L_0x013e;
                case 97: goto L_0x012f;
                case 98: goto L_0x0125;
                case 99: goto L_0x0116;
                case 100: goto L_0x013e;
                case 101: goto L_0x012f;
                case 102: goto L_0x0125;
                case 103: goto L_0x0116;
                case 104: goto L_0x013e;
                case 105: goto L_0x012f;
                case 106: goto L_0x0125;
                case 107: goto L_0x0116;
                case 108: goto L_0x013e;
                case 109: goto L_0x012f;
                case 110: goto L_0x0125;
                case 111: goto L_0x0116;
                case 112: goto L_0x013e;
                case 113: goto L_0x012f;
                case 114: goto L_0x0125;
                case 115: goto L_0x0116;
                case 116: goto L_0x02ca;
                case 117: goto L_0x02ca;
                case 118: goto L_0x02ca;
                case 119: goto L_0x02ca;
                case 120: goto L_0x013e;
                case 121: goto L_0x0107;
                case 122: goto L_0x013e;
                case 123: goto L_0x0107;
                case 124: goto L_0x013e;
                case 125: goto L_0x0107;
                case 126: goto L_0x013e;
                case 127: goto L_0x012f;
                case 128: goto L_0x013e;
                case 129: goto L_0x012f;
                case 130: goto L_0x013e;
                case 131: goto L_0x012f;
                case 132: goto L_0x0100;
                case 133: goto L_0x00f1;
                case 134: goto L_0x00e7;
                case 135: goto L_0x00d8;
                case 136: goto L_0x013e;
                case 137: goto L_0x0125;
                case 138: goto L_0x025f;
                case 139: goto L_0x00ce;
                case 140: goto L_0x00f1;
                case 141: goto L_0x00d8;
                case 142: goto L_0x013e;
                case 143: goto L_0x0276;
                case 144: goto L_0x0125;
                case 145: goto L_0x02ca;
                case 146: goto L_0x02ca;
                case 147: goto L_0x02ca;
                case 148: goto L_0x00c4;
                case 149: goto L_0x013e;
                case 150: goto L_0x013e;
                case 151: goto L_0x00c4;
                case 152: goto L_0x00c4;
                case 153: goto L_0x02cb;
                case 154: goto L_0x02cb;
                case 155: goto L_0x02cb;
                case 156: goto L_0x02cb;
                case 157: goto L_0x02cb;
                case 158: goto L_0x02cb;
                case 159: goto L_0x01e8;
                case 160: goto L_0x01e8;
                case 161: goto L_0x01e8;
                case 162: goto L_0x01e8;
                case 163: goto L_0x01e8;
                case 164: goto L_0x01e8;
                case 165: goto L_0x01e8;
                case 166: goto L_0x01e8;
                case 167: goto L_0x02ca;
                case 168: goto L_0x00bc;
                case 169: goto L_0x00bc;
                case 170: goto L_0x02cb;
                case 171: goto L_0x02cb;
                case 172: goto L_0x02cb;
                case 173: goto L_0x01e8;
                case 174: goto L_0x02cb;
                case 175: goto L_0x01e8;
                case 176: goto L_0x02cb;
                case 177: goto L_0x02ca;
                case 178: goto L_0x00b7;
                case 179: goto L_0x00b2;
                case 180: goto L_0x00aa;
                case 181: goto L_0x00a2;
                default: goto L_0x0020;
            }
        L_0x0020:
            switch(r6) {
                case 187: goto L_0x0096;
                case 188: goto L_0x0058;
                case 189: goto L_0x003b;
                case 190: goto L_0x00ce;
                case 191: goto L_0x02cb;
                case 192: goto L_0x002b;
                case 193: goto L_0x00ce;
                case 194: goto L_0x02cb;
                case 195: goto L_0x02cb;
                default: goto L_0x0023;
            }
        L_0x0023:
            r5.pop(r7)
            r5.pushDesc(r8)
            goto L_0x02cf
        L_0x002b:
            r5.pop()
            org.jacoco.agent.rt.internal_8ff85ea.asm.Type r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Type.getObjectType(r8)
            java.lang.String r0 = r0.getDescriptor()
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x003b:
            r5.pop()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "["
            r0.append(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Type r2 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Type.getObjectType(r8)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x0058:
            r5.pop()
            switch(r7) {
                case 4: goto L_0x008f;
                case 5: goto L_0x0088;
                case 6: goto L_0x0081;
                case 7: goto L_0x007a;
                case 8: goto L_0x0073;
                case 9: goto L_0x006c;
                case 10: goto L_0x0065;
                default: goto L_0x005e;
            }
        L_0x005e:
            java.lang.String r0 = "[J"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x0065:
            java.lang.String r0 = "[I"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x006c:
            java.lang.String r0 = "[S"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x0073:
            java.lang.String r0 = "[B"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x007a:
            java.lang.String r0 = "[D"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x0081:
            java.lang.String r0 = "[F"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x0088:
            java.lang.String r0 = "[C"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x008f:
            java.lang.String r0 = "[Z"
            r5.pushDesc(r0)
            goto L_0x02cf
        L_0x0096:
            java.util.List<org.jacoco.agent.rt.internal_8ff85ea.asm.Label> r0 = r5.labels
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            r5.push(r0)
            goto L_0x02cf
        L_0x00a2:
            r5.pop(r8)
            r5.pop()
            goto L_0x02cf
        L_0x00aa:
            r5.pop(r2)
            r5.pushDesc(r8)
            goto L_0x02cf
        L_0x00b2:
            r5.pop(r8)
            goto L_0x02cf
        L_0x00b7:
            r5.pushDesc(r8)
            goto L_0x02cf
        L_0x00bc:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "JSR/RET are not supported"
            r0.<init>(r1)
            throw r0
        L_0x00c4:
            r5.pop(r4)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r0)
            goto L_0x02cf
        L_0x00ce:
            r5.pop(r2)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r0)
            goto L_0x02cf
        L_0x00d8:
            r5.pop(r2)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x00e7:
            r5.pop(r2)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r0)
            goto L_0x02cf
        L_0x00f1:
            r5.pop(r2)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x0100:
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.set(r7, r0)
            goto L_0x02cf
        L_0x0107:
            r5.pop(r3)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x0116:
            r5.pop(r4)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x0125:
            r5.pop(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r0)
            goto L_0x02cf
        L_0x012f:
            r5.pop(r4)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x013e:
            r5.pop(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r0)
            goto L_0x02cf
        L_0x0148:
            java.lang.Object r0 = r5.pop()
            java.lang.Object r2 = r5.pop()
            r5.push(r0)
            r5.push(r2)
            goto L_0x02cf
        L_0x0158:
            java.lang.Object r0 = r5.pop()
            java.lang.Object r2 = r5.pop()
            java.lang.Object r3 = r5.pop()
            java.lang.Object r4 = r5.pop()
            r5.push(r2)
            r5.push(r0)
            r5.push(r4)
            r5.push(r3)
            r5.push(r2)
            r5.push(r0)
            goto L_0x02cf
        L_0x017c:
            java.lang.Object r0 = r5.pop()
            java.lang.Object r2 = r5.pop()
            java.lang.Object r3 = r5.pop()
            r5.push(r2)
            r5.push(r0)
            r5.push(r3)
            r5.push(r2)
            r5.push(r0)
            goto L_0x02cf
        L_0x0199:
            java.lang.Object r0 = r5.pop()
            java.lang.Object r2 = r5.pop()
            r5.push(r2)
            r5.push(r0)
            r5.push(r2)
            r5.push(r0)
            goto L_0x02cf
        L_0x01af:
            java.lang.Object r0 = r5.pop()
            java.lang.Object r2 = r5.pop()
            java.lang.Object r3 = r5.pop()
            r5.push(r0)
            r5.push(r3)
            r5.push(r2)
            r5.push(r0)
            goto L_0x02cf
        L_0x01c9:
            java.lang.Object r0 = r5.pop()
            java.lang.Object r2 = r5.pop()
            r5.push(r0)
            r5.push(r2)
            r5.push(r0)
            goto L_0x02cf
        L_0x01dc:
            java.lang.Object r0 = r5.pop()
            r5.push(r0)
            r5.push(r0)
            goto L_0x02cf
        L_0x01e8:
            r5.pop(r0)
            goto L_0x02cf
        L_0x01ed:
            r5.pop(r4)
            goto L_0x02cf
        L_0x01f2:
            r5.pop(r3)
            goto L_0x02cf
        L_0x01f7:
            r5.pop(r2)
            java.lang.Object r0 = r5.pop()
            r5.set(r7, r0)
            int r2 = r7 + 1
            java.lang.Integer r3 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.set(r2, r3)
            if (r7 <= 0) goto L_0x02cf
            int r2 = r7 + -1
            java.lang.Object r2 = r5.get(r2)
            java.lang.Integer r3 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG
            if (r2 == r3) goto L_0x0218
            java.lang.Integer r3 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            if (r2 != r3) goto L_0x02cf
        L_0x0218:
            int r3 = r7 + -1
            java.lang.Integer r4 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.set(r3, r4)
            goto L_0x02cf
        L_0x0221:
            java.lang.Object r0 = r5.pop()
            r5.set(r7, r0)
            if (r7 <= 0) goto L_0x02cf
            int r2 = r7 + -1
            java.lang.Object r2 = r5.get(r2)
            java.lang.Integer r3 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG
            if (r2 == r3) goto L_0x0238
            java.lang.Integer r3 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            if (r2 != r3) goto L_0x02cf
        L_0x0238:
            int r3 = r7 + -1
            java.lang.Integer r4 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.set(r3, r4)
            goto L_0x02cf
        L_0x0241:
            r5.pop(r2)
            java.lang.Object r0 = r5.pop()
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L_0x0258
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r2 = r3.substring(r2)
            r5.pushDesc(r2)
            goto L_0x02cf
        L_0x0258:
            java.lang.String r2 = "java/lang/Object"
            r5.push(r2)
            goto L_0x02cf
        L_0x025f:
            r5.pop(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x026d:
            r5.pop(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r0)
            goto L_0x02cf
        L_0x0276:
            r5.pop(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x0284:
            r5.pop(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r0)
            goto L_0x02cf
        L_0x028d:
            java.lang.Object r0 = r5.get(r7)
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x029a:
            java.lang.Object r0 = r5.get(r7)
            r5.push(r0)
            goto L_0x02cf
        L_0x02a2:
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x02ad:
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r0)
            goto L_0x02cf
        L_0x02b3:
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r0)
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r0)
            goto L_0x02cf
        L_0x02be:
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r0)
            goto L_0x02cf
        L_0x02c4:
            java.lang.Integer r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.NULL
            r5.push(r0)
            goto L_0x02cf
        L_0x02ca:
            goto L_0x02cf
        L_0x02cb:
            r5.pop(r2)
        L_0x02cf:
            r5.labels = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.commons.AnalyzerAdapter.execute(int, int, java.lang.String):void");
    }
}
