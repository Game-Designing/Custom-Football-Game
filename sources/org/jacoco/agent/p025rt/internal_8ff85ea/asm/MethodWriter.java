package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.MethodWriter */
class MethodWriter extends MethodVisitor {
    static final int ACC_CONSTRUCTOR = 524288;
    static final int APPEND_FRAME = 252;
    static final int CHOP_FRAME = 248;
    static final int FRAMES = 0;
    static final int FULL_FRAME = 255;
    static final int INSERTED_FRAMES = 1;
    static final int MAXS = 2;
    static final int NOTHING = 3;
    static final int RESERVED = 128;
    static final int SAME_FRAME = 0;
    static final int SAME_FRAME_EXTENDED = 251;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
    private int access;
    private ByteVector annd;
    private AnnotationWriter anns;
    private Attribute attrs;
    private Attribute cattrs;
    int classReaderLength;
    int classReaderOffset;
    private ByteVector code = new ByteVector();
    private final int compute;
    private AnnotationWriter ctanns;
    private Label currentBlock;
    private int currentLocals;

    /* renamed from: cw */
    final ClassWriter f43245cw;
    private final int desc;
    private final String descriptor;
    int exceptionCount;
    int[] exceptions;
    private Handler firstHandler;
    private int[] frame;
    private int frameCount;
    private int handlerCount;
    private AnnotationWriter ianns;
    private AnnotationWriter ictanns;
    private AnnotationWriter[] ipanns;
    private AnnotationWriter itanns;
    private Label labels;
    private int lastCodeOffset;
    private Handler lastHandler;
    private ByteVector lineNumber;
    private int lineNumberCount;
    private ByteVector localVar;
    private int localVarCount;
    private ByteVector localVarType;
    private int localVarTypeCount;
    private int maxLocals;
    private int maxStack;
    private int maxStackSize;
    private ByteVector methodParameters;
    private int methodParametersCount;
    private final int name;
    private AnnotationWriter[] panns;
    private Label previousBlock;
    private int[] previousFrame;
    private int previousFrameOffset;
    String signature;
    private ByteVector stackMap;
    private int stackSize;
    private int subroutines;
    private int synthetics;
    private AnnotationWriter tanns;

    MethodWriter(ClassWriter cw, int access2, String name2, String desc2, String signature2, String[] exceptions2, int compute2) {
        super(327680);
        if (cw.firstMethod == null) {
            cw.firstMethod = this;
        } else {
            cw.lastMethod.f149mv = this;
        }
        cw.lastMethod = this;
        this.f43245cw = cw;
        this.access = access2;
        if ("<init>".equals(name2)) {
            this.access |= ACC_CONSTRUCTOR;
        }
        this.name = cw.newUTF8(name2);
        this.desc = cw.newUTF8(desc2);
        this.descriptor = desc2;
        this.signature = signature2;
        if (exceptions2 != null && exceptions2.length > 0) {
            this.exceptionCount = exceptions2.length;
            this.exceptions = new int[this.exceptionCount];
            for (int i = 0; i < this.exceptionCount; i++) {
                this.exceptions[i] = cw.newClass(exceptions2[i]);
            }
        }
        this.compute = compute2;
        if (compute2 != 3) {
            int size = Type.getArgumentsAndReturnSizes(this.descriptor) >> 2;
            if ((access2 & 8) != 0) {
                size--;
            }
            this.maxLocals = size;
            this.currentLocals = size;
            this.labels = new Label();
            Label label = this.labels;
            label.status |= 8;
            visitLabel(label);
        }
    }

    public void visitParameter(String name2, int access2) {
        if (this.methodParameters == null) {
            this.methodParameters = new ByteVector();
        }
        this.methodParametersCount++;
        this.methodParameters.putShort(name2 == null ? 0 : this.f43245cw.newUTF8(name2)).putShort(access2);
    }

    public AnnotationVisitor visitAnnotationDefault() {
        this.annd = new ByteVector();
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f43245cw, false, this.annd, null, 0);
        return annotationWriter;
    }

    public AnnotationVisitor visitAnnotation(String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        bv.putShort(this.f43245cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43245cw, true, bv, bv, 2);
        if (visible) {
            aw.next = this.anns;
            this.anns = aw;
        } else {
            aw.next = this.ianns;
            this.ianns = aw;
        }
        return aw;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        AnnotationWriter.putTarget(typeRef, typePath, bv);
        bv.putShort(this.f43245cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43245cw, true, bv, bv, bv.length - 2);
        if (visible) {
            aw.next = this.tanns;
            this.tanns = aw;
        } else {
            aw.next = this.itanns;
            this.itanns = aw;
        }
        return aw;
    }

    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(desc2)) {
            this.synthetics = Math.max(this.synthetics, parameter + 1);
            AnnotationWriter annotationWriter = new AnnotationWriter(this.f43245cw, false, bv, null, 0);
            return annotationWriter;
        }
        bv.putShort(this.f43245cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43245cw, true, bv, bv, 2);
        if (visible) {
            if (this.panns == null) {
                this.panns = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            AnnotationWriter[] annotationWriterArr = this.panns;
            aw.next = annotationWriterArr[parameter];
            annotationWriterArr[parameter] = aw;
        } else {
            if (this.ipanns == null) {
                this.ipanns = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            AnnotationWriter[] annotationWriterArr2 = this.ipanns;
            aw.next = annotationWriterArr2[parameter];
            annotationWriterArr2[parameter] = aw;
        }
        return aw;
    }

    public void visitAttribute(Attribute attr) {
        if (attr.isCodeAttribute()) {
            attr.next = this.cattrs;
            this.cattrs = attr;
            return;
        }
        attr.next = this.attrs;
        this.attrs = attr;
    }

    public void visitCode() {
    }

    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        int delta;
        String str;
        int frameIndex;
        int i = this.compute;
        if (i != 0) {
            if (i == 1) {
                Label label = this.currentBlock;
                Frame frame2 = label.frame;
                if (frame2 == null) {
                    label.frame = new CurrentFrame();
                    Label label2 = this.currentBlock;
                    Frame frame3 = label2.frame;
                    frame3.owner = label2;
                    frame3.initInputFrame(this.f43245cw, this.access, Type.getArgumentTypes(this.descriptor), nLocal);
                    visitImplicitFirstFrame();
                } else {
                    if (type == -1) {
                        frame2.set(this.f43245cw, nLocal, local, nStack, stack);
                    }
                    visitFrame(this.currentBlock.frame);
                }
            } else if (type == -1) {
                if (this.previousFrame == null) {
                    visitImplicitFirstFrame();
                }
                this.currentLocals = nLocal;
                int frameIndex2 = startFrame(this.code.length, nLocal, nStack);
                int i2 = 0;
                while (true) {
                    str = "";
                    if (i2 >= nLocal) {
                        break;
                    }
                    if (local[i2] instanceof String) {
                        int frameIndex3 = frameIndex2 + 1;
                        this.frame[frameIndex2] = 24117248 | this.f43245cw.addType(local[i2]);
                        frameIndex2 = frameIndex3;
                    } else if (local[i2] instanceof Integer) {
                        int frameIndex4 = frameIndex2 + 1;
                        this.frame[frameIndex2] = local[i2].intValue();
                        frameIndex2 = frameIndex4;
                    } else {
                        int frameIndex5 = frameIndex2 + 1;
                        this.frame[frameIndex2] = this.f43245cw.addUninitializedType(str, local[i2].position) | 25165824;
                        frameIndex2 = frameIndex5;
                    }
                    i2++;
                }
                for (int i3 = 0; i3 < nStack; i3++) {
                    if (stack[i3] instanceof String) {
                        frameIndex = frameIndex2 + 1;
                        this.frame[frameIndex2] = this.f43245cw.addType(stack[i3]) | 24117248;
                    } else if (stack[i3] instanceof Integer) {
                        frameIndex = frameIndex2 + 1;
                        this.frame[frameIndex2] = stack[i3].intValue();
                    } else {
                        frameIndex = frameIndex2 + 1;
                        this.frame[frameIndex2] = this.f43245cw.addUninitializedType(str, stack[i3].position) | 25165824;
                    }
                    frameIndex2 = frameIndex;
                }
                endFrame();
            } else {
                if (this.stackMap == null) {
                    this.stackMap = new ByteVector();
                    delta = this.code.length;
                } else {
                    delta = (this.code.length - this.previousFrameOffset) - 1;
                    if (delta < 0) {
                        if (type != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                if (type == 0) {
                    this.currentLocals = nLocal;
                    this.stackMap.putByte(255).putShort(delta).putShort(nLocal);
                    for (int i4 = 0; i4 < nLocal; i4++) {
                        writeFrameType(local[i4]);
                    }
                    this.stackMap.putShort(nStack);
                    for (int i5 = 0; i5 < nStack; i5++) {
                        writeFrameType(stack[i5]);
                    }
                } else if (type == 1) {
                    this.currentLocals += nLocal;
                    this.stackMap.putByte(nLocal + SAME_FRAME_EXTENDED).putShort(delta);
                    for (int i6 = 0; i6 < nLocal; i6++) {
                        writeFrameType(local[i6]);
                    }
                } else if (type == 2) {
                    this.currentLocals -= nLocal;
                    this.stackMap.putByte(SAME_FRAME_EXTENDED - nLocal).putShort(delta);
                } else if (type != 3) {
                    if (type == 4) {
                        if (delta < 64) {
                            this.stackMap.putByte(delta + 64);
                        } else {
                            this.stackMap.putByte(SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED).putShort(delta);
                        }
                        writeFrameType(stack[0]);
                    }
                } else if (delta < 64) {
                    this.stackMap.putByte(delta);
                } else {
                    this.stackMap.putByte(SAME_FRAME_EXTENDED).putShort(delta);
                }
                this.previousFrameOffset = this.code.length;
                this.frameCount++;
            }
            this.maxStack = Math.max(this.maxStack, nStack);
            this.maxLocals = Math.max(this.maxLocals, this.currentLocals);
        }
    }

    public void visitInsn(int opcode) {
        ByteVector byteVector = this.code;
        this.lastCodeOffset = byteVector.length;
        byteVector.putByte(opcode);
        if (this.currentBlock != null) {
            int i = this.compute;
            if (i == 0 || i == 1) {
                this.currentBlock.frame.execute(opcode, 0, null, null);
            } else {
                int size = this.stackSize + Frame.SIZE[opcode];
                if (size > this.maxStackSize) {
                    this.maxStackSize = size;
                }
                this.stackSize = size;
            }
            if ((opcode >= 172 && opcode <= 177) || opcode == 191) {
                noSuccessor();
            }
        }
    }

    public void visitIntInsn(int opcode, int operand) {
        this.lastCodeOffset = this.code.length;
        if (this.currentBlock != null) {
            int i = this.compute;
            if (i == 0 || i == 1) {
                this.currentBlock.frame.execute(opcode, operand, null, null);
            } else if (opcode != 188) {
                int size = this.stackSize + 1;
                if (size > this.maxStackSize) {
                    this.maxStackSize = size;
                }
                this.stackSize = size;
            }
        }
        if (opcode == 17) {
            this.code.put12(opcode, operand);
        } else {
            this.code.put11(opcode, operand);
        }
    }

    public void visitVarInsn(int opcode, int var) {
        int opt;
        int n;
        this.lastCodeOffset = this.code.length;
        Label label = this.currentBlock;
        if (label != null) {
            int i = this.compute;
            if (i == 0 || i == 1) {
                this.currentBlock.frame.execute(opcode, var, null, null);
            } else if (opcode == 169) {
                label.status |= Opcodes.ACC_NATIVE;
                label.inputStackTop = this.stackSize;
                noSuccessor();
            } else {
                int size = this.stackSize + Frame.SIZE[opcode];
                if (size > this.maxStackSize) {
                    this.maxStackSize = size;
                }
                this.stackSize = size;
            }
        }
        if (this.compute != 3) {
            if (opcode == 22 || opcode == 24 || opcode == 55 || opcode == 57) {
                n = var + 2;
            } else {
                n = var + 1;
            }
            if (n > this.maxLocals) {
                this.maxLocals = n;
            }
        }
        if (var < 4 && opcode != 169) {
            if (opcode < 54) {
                opt = ((opcode - 21) << 2) + 26 + var;
            } else {
                opt = ((opcode - 54) << 2) + 59 + var;
            }
            this.code.putByte(opt);
        } else if (var >= 256) {
            this.code.putByte(196).put12(opcode, var);
        } else {
            this.code.put11(opcode, var);
        }
        if (opcode >= 54 && this.compute == 0 && this.handlerCount > 0) {
            visitLabel(new Label());
        }
    }

    public void visitTypeInsn(int opcode, String type) {
        this.lastCodeOffset = this.code.length;
        Item i = this.f43245cw.newClassItem(type);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(opcode, this.code.length, this.f43245cw, i);
            } else if (opcode == 187) {
                int size = this.stackSize + 1;
                if (size > this.maxStackSize) {
                    this.maxStackSize = size;
                }
                this.stackSize = size;
            }
        }
        this.code.put12(opcode, i.index);
    }

    public void visitFieldInsn(int opcode, String owner, String name2, String desc2) {
        int size;
        this.lastCodeOffset = this.code.length;
        Item i = this.f43245cw.newFieldItem(owner, name2, desc2);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            int i3 = 0;
            if (i2 != 0) {
                int i4 = 1;
                if (i2 != 1) {
                    char c = desc2.charAt(0);
                    int size2 = -2;
                    switch (opcode) {
                        case Opcodes.GETSTATIC /*178*/:
                            int i5 = this.stackSize;
                            if (c == 'D' || c == 'J') {
                                i4 = 2;
                            }
                            size = i5 + i4;
                            break;
                        case Opcodes.PUTSTATIC /*179*/:
                            int i6 = this.stackSize;
                            if (!(c == 'D' || c == 'J')) {
                                size2 = -1;
                            }
                            size = size2 + i6;
                            break;
                        case Opcodes.GETFIELD /*180*/:
                            int i7 = this.stackSize;
                            if (c == 'D' || c == 'J') {
                                i3 = 1;
                            }
                            size = i7 + i3;
                            break;
                        default:
                            int i8 = this.stackSize;
                            if (c == 'D' || c == 'J') {
                                size2 = -3;
                            }
                            size = size2 + i8;
                            break;
                    }
                    if (size > this.maxStackSize) {
                        this.maxStackSize = size;
                    }
                    this.stackSize = size;
                }
            }
            this.currentBlock.frame.execute(opcode, 0, this.f43245cw, i);
        }
        this.code.put12(opcode, i.index);
    }

    public void visitMethodInsn(int opcode, String owner, String name2, String desc2, boolean itf) {
        int size;
        this.lastCodeOffset = this.code.length;
        Item i = this.f43245cw.newMethodItem(owner, name2, desc2, itf);
        int argSize = i.intVal;
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(opcode, 0, this.f43245cw, i);
            } else {
                if (argSize == 0) {
                    argSize = Type.getArgumentsAndReturnSizes(desc2);
                    i.intVal = argSize;
                }
                if (opcode == 184) {
                    size = (this.stackSize - (argSize >> 2)) + (argSize & 3) + 1;
                } else {
                    size = (this.stackSize - (argSize >> 2)) + (argSize & 3);
                }
                if (size > this.maxStackSize) {
                    this.maxStackSize = size;
                }
                this.stackSize = size;
            }
        }
        if (opcode == 185) {
            if (argSize == 0) {
                argSize = Type.getArgumentsAndReturnSizes(desc2);
                i.intVal = argSize;
            }
            this.code.put12(Opcodes.INVOKEINTERFACE, i.index).put11(argSize >> 2, 0);
            return;
        }
        this.code.put12(opcode, i.index);
    }

    public void visitInvokeDynamicInsn(String name2, String desc2, Handle bsm, Object... bsmArgs) {
        this.lastCodeOffset = this.code.length;
        Item i = this.f43245cw.newInvokeDynamicItem(name2, desc2, bsm, bsmArgs);
        int argSize = i.intVal;
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(Opcodes.INVOKEDYNAMIC, 0, this.f43245cw, i);
            } else {
                if (argSize == 0) {
                    argSize = Type.getArgumentsAndReturnSizes(desc2);
                    i.intVal = argSize;
                }
                int size = (this.stackSize - (argSize >> 2)) + (argSize & 3) + 1;
                if (size > this.maxStackSize) {
                    this.maxStackSize = size;
                }
                this.stackSize = size;
            }
        }
        this.code.put12(Opcodes.INVOKEDYNAMIC, i.index);
        this.code.putShort(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitJumpInsn(int r11, org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label r12) {
        /*
            r10 = this;
            r0 = 200(0xc8, float:2.8E-43)
            r1 = 0
            r2 = 1
            if (r11 < r0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            if (r3 == 0) goto L_0x000e
            int r4 = r11 + -33
            goto L_0x000f
        L_0x000e:
            r4 = r11
        L_0x000f:
            r11 = r4
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r4 = r10.code
            int r4 = r4.length
            r10.lastCodeOffset = r4
            r4 = 0
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r10.currentBlock
            r6 = 168(0xa8, float:2.35E-43)
            r7 = 167(0xa7, float:2.34E-43)
            if (r5 == 0) goto L_0x007b
            int r8 = r10.compute
            r9 = 0
            if (r8 != 0) goto L_0x003f
            org.jacoco.agent.rt.internal_8ff85ea.asm.Frame r5 = r5.frame
            r5.execute(r11, r1, r9, r9)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r12.getFirst()
            int r8 = r5.status
            r8 = r8 | 16
            r5.status = r8
            r10.addSuccessor(r1, r12)
            if (r11 == r7) goto L_0x007b
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Label
            r5.<init>()
            r4 = r5
            goto L_0x007b
        L_0x003f:
            if (r8 != r2) goto L_0x0047
            org.jacoco.agent.rt.internal_8ff85ea.asm.Frame r5 = r5.frame
            r5.execute(r11, r1, r9, r9)
            goto L_0x007b
        L_0x0047:
            if (r11 != r6) goto L_0x006d
            int r5 = r12.status
            r8 = r5 & 512(0x200, float:7.175E-43)
            if (r8 != 0) goto L_0x0058
            r5 = r5 | 512(0x200, float:7.175E-43)
            r12.status = r5
            int r5 = r10.subroutines
            int r5 = r5 + r2
            r10.subroutines = r5
        L_0x0058:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r10.currentBlock
            int r8 = r5.status
            r8 = r8 | 128(0x80, float:1.794E-43)
            r5.status = r8
            int r5 = r10.stackSize
            int r5 = r5 + r2
            r10.addSuccessor(r5, r12)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Label
            r5.<init>()
            r4 = r5
            goto L_0x007b
        L_0x006d:
            int r5 = r10.stackSize
            int[] r8 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.Frame.SIZE
            r8 = r8[r11]
            int r5 = r5 + r8
            r10.stackSize = r5
            int r5 = r10.stackSize
            r10.addSuccessor(r5, r12)
        L_0x007b:
            int r5 = r12.status
            r5 = r5 & 2
            if (r5 == 0) goto L_0x00c7
            int r5 = r12.position
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r8 = r10.code
            int r9 = r8.length
            int r5 = r5 - r9
            r9 = -32768(0xffffffffffff8000, float:NaN)
            if (r5 >= r9) goto L_0x00c7
            if (r11 != r7) goto L_0x0092
            r8.putByte(r0)
            goto L_0x00be
        L_0x0092:
            if (r11 != r6) goto L_0x009a
            r0 = 201(0xc9, float:2.82E-43)
            r8.putByte(r0)
            goto L_0x00be
        L_0x009a:
            if (r4 == 0) goto L_0x00a2
            int r1 = r4.status
            r1 = r1 | 16
            r4.status = r1
        L_0x00a2:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r10.code
            r5 = 166(0xa6, float:2.33E-43)
            if (r11 > r5) goto L_0x00ad
            int r5 = r11 + 1
            r5 = r5 ^ r2
            int r5 = r5 - r2
            goto L_0x00af
        L_0x00ad:
            r5 = r11 ^ 1
        L_0x00af:
            r1.putByte(r5)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r10.code
            r5 = 8
            r1.putShort(r5)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r10.code
            r1.putByte(r0)
        L_0x00be:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r0 = r10.code
            int r1 = r0.length
            int r1 = r1 - r2
            r12.put(r10, r0, r1, r2)
            goto L_0x00e6
        L_0x00c7:
            if (r3 == 0) goto L_0x00d9
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r0 = r10.code
            int r1 = r11 + 33
            r0.putByte(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r0 = r10.code
            int r1 = r0.length
            int r1 = r1 - r2
            r12.put(r10, r0, r1, r2)
            goto L_0x00e6
        L_0x00d9:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r0 = r10.code
            r0.putByte(r11)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r0 = r10.code
            int r5 = r0.length
            int r5 = r5 - r2
            r12.put(r10, r0, r5, r1)
        L_0x00e6:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r0 = r10.currentBlock
            if (r0 == 0) goto L_0x00f4
            if (r4 == 0) goto L_0x00ef
            r10.visitLabel(r4)
        L_0x00ef:
            if (r11 != r7) goto L_0x00f4
            r10.noSuccessor()
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodWriter.visitJumpInsn(int, org.jacoco.agent.rt.internal_8ff85ea.asm.Label):void");
    }

    public void visitLabel(Label label) {
        ClassWriter classWriter = this.f43245cw;
        boolean z = classWriter.hasAsmInsns;
        ByteVector byteVector = this.code;
        classWriter.hasAsmInsns = z | label.resolve(this, byteVector.length, byteVector.data);
        int i = label.status;
        if ((i & 1) == 0) {
            int i2 = this.compute;
            if (i2 == 0) {
                Label label2 = this.currentBlock;
                if (label2 != null) {
                    if (label.position == label2.position) {
                        label2.status = (i & 16) | label2.status;
                        label.frame = label2.frame;
                        return;
                    }
                    addSuccessor(0, label);
                }
                this.currentBlock = label;
                if (label.frame == null) {
                    label.frame = new Frame();
                    label.frame.owner = label;
                }
                Label label3 = this.previousBlock;
                if (label3 != null) {
                    if (label.position == label3.position) {
                        label3.status |= label.status & 16;
                        label.frame = label3.frame;
                        this.currentBlock = label3;
                        return;
                    }
                    label3.successor = label;
                }
                this.previousBlock = label;
            } else if (i2 == 1) {
                Label label4 = this.currentBlock;
                if (label4 == null) {
                    this.currentBlock = label;
                } else {
                    label4.frame.owner = label;
                }
            } else if (i2 == 2) {
                Label label5 = this.currentBlock;
                if (label5 != null) {
                    label5.outputStackMax = this.maxStackSize;
                    addSuccessor(this.stackSize, label);
                }
                this.currentBlock = label;
                this.stackSize = 0;
                this.maxStackSize = 0;
                Label label6 = this.previousBlock;
                if (label6 != null) {
                    label6.successor = label;
                }
                this.previousBlock = label;
            }
        }
    }

    public void visitLdcInsn(Object cst) {
        int size;
        this.lastCodeOffset = this.code.length;
        Item i = this.f43245cw.newConstItem(cst);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(18, 0, this.f43245cw, i);
            } else {
                int i3 = i.type;
                if (i3 == 5 || i3 == 6) {
                    size = this.stackSize + 2;
                } else {
                    size = this.stackSize + 1;
                }
                if (size > this.maxStackSize) {
                    this.maxStackSize = size;
                }
                this.stackSize = size;
            }
        }
        int index = i.index;
        int i4 = i.type;
        if (i4 == 5 || i4 == 6) {
            this.code.put12(20, index);
        } else if (index >= 256) {
            this.code.put12(19, index);
        } else {
            this.code.put11(18, index);
        }
    }

    public void visitIincInsn(int var, int increment) {
        this.lastCodeOffset = this.code.length;
        if (this.currentBlock != null) {
            int i = this.compute;
            if (i == 0 || i == 1) {
                this.currentBlock.frame.execute(Opcodes.IINC, var, null, null);
            }
        }
        if (this.compute != 3) {
            int n = var + 1;
            if (n > this.maxLocals) {
                this.maxLocals = n;
            }
        }
        if (var > 255 || increment > 127 || increment < -128) {
            this.code.putByte(196).put12(Opcodes.IINC, var).putShort(increment);
        } else {
            this.code.putByte(Opcodes.IINC).put11(var, increment);
        }
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels2) {
        ByteVector byteVector = this.code;
        this.lastCodeOffset = byteVector.length;
        int source = byteVector.length;
        byteVector.putByte(Opcodes.TABLESWITCH);
        ByteVector byteVector2 = this.code;
        byteVector2.putByteArray(null, 0, (4 - (byteVector2.length % 4)) % 4);
        dflt.put(this, this.code, source, true);
        this.code.putInt(min).putInt(max);
        for (Label put : labels2) {
            put.put(this, this.code, source, true);
        }
        visitSwitchInsn(dflt, labels2);
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels2) {
        ByteVector byteVector = this.code;
        this.lastCodeOffset = byteVector.length;
        int source = byteVector.length;
        byteVector.putByte(Opcodes.LOOKUPSWITCH);
        ByteVector byteVector2 = this.code;
        byteVector2.putByteArray(null, 0, (4 - (byteVector2.length % 4)) % 4);
        dflt.put(this, this.code, source, true);
        this.code.putInt(labels2.length);
        for (int i = 0; i < labels2.length; i++) {
            this.code.putInt(keys[i]);
            labels2[i].put(this, this.code, source, true);
        }
        visitSwitchInsn(dflt, labels2);
    }

    private void visitSwitchInsn(Label dflt, Label[] labels2) {
        Label label = this.currentBlock;
        if (label != null) {
            if (this.compute == 0) {
                label.frame.execute(Opcodes.LOOKUPSWITCH, 0, null, null);
                addSuccessor(0, dflt);
                Label first = dflt.getFirst();
                first.status |= 16;
                for (int i = 0; i < labels2.length; i++) {
                    addSuccessor(0, labels2[i]);
                    Label first2 = labels2[i].getFirst();
                    first2.status |= 16;
                }
            } else {
                this.stackSize--;
                addSuccessor(this.stackSize, dflt);
                for (Label addSuccessor : labels2) {
                    addSuccessor(this.stackSize, addSuccessor);
                }
            }
            noSuccessor();
        }
    }

    public void visitMultiANewArrayInsn(String desc2, int dims) {
        this.lastCodeOffset = this.code.length;
        Item i = this.f43245cw.newClassItem(desc2);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(Opcodes.MULTIANEWARRAY, dims, this.f43245cw, i);
            } else {
                this.stackSize += 1 - dims;
            }
        }
        this.code.put12(Opcodes.MULTIANEWARRAY, i.index).putByte(dims);
    }

    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        AnnotationWriter.putTarget((-16776961 & typeRef) | (this.lastCodeOffset << 8), typePath, bv);
        bv.putShort(this.f43245cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43245cw, true, bv, bv, bv.length - 2);
        if (visible) {
            aw.next = this.ctanns;
            this.ctanns = aw;
        } else {
            aw.next = this.ictanns;
            this.ictanns = aw;
        }
        return aw;
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        this.handlerCount++;
        Handler h = new Handler();
        h.start = start;
        h.end = end;
        h.handler = handler;
        h.desc = type;
        h.type = type != null ? this.f43245cw.newClass(type) : 0;
        Handler handler2 = this.lastHandler;
        if (handler2 == null) {
            this.firstHandler = h;
        } else {
            handler2.next = h;
        }
        this.lastHandler = h;
    }

    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        AnnotationWriter.putTarget(typeRef, typePath, bv);
        bv.putShort(this.f43245cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43245cw, true, bv, bv, bv.length - 2);
        if (visible) {
            aw.next = this.ctanns;
            this.ctanns = aw;
        } else {
            aw.next = this.ictanns;
            this.ictanns = aw;
        }
        return aw;
    }

    public void visitLocalVariable(String name2, String desc2, String signature2, Label start, Label end, int index) {
        int i = 1;
        if (signature2 != null) {
            if (this.localVarType == null) {
                this.localVarType = new ByteVector();
            }
            this.localVarTypeCount++;
            this.localVarType.putShort(start.position).putShort(end.position - start.position).putShort(this.f43245cw.newUTF8(name2)).putShort(this.f43245cw.newUTF8(signature2)).putShort(index);
        }
        if (this.localVar == null) {
            this.localVar = new ByteVector();
        }
        this.localVarCount++;
        this.localVar.putShort(start.position).putShort(end.position - start.position).putShort(this.f43245cw.newUTF8(name2)).putShort(this.f43245cw.newUTF8(desc2)).putShort(index);
        if (this.compute != 3) {
            char c = desc2.charAt(0);
            if (c == 'J' || c == 'D') {
                i = 2;
            }
            int n = i + index;
            if (n > this.maxLocals) {
                this.maxLocals = n;
            }
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc2, boolean visible) {
        ByteVector bv = new ByteVector();
        bv.putByte(typeRef >>> 24).putShort(start.length);
        for (int i = 0; i < start.length; i++) {
            bv.putShort(start[i].position).putShort(end[i].position - start[i].position).putShort(index[i]);
        }
        if (typePath == null) {
            bv.putByte(0);
        } else {
            byte[] bArr = typePath.f43246b;
            int i2 = typePath.offset;
            bv.putByteArray(bArr, i2, (bArr[i2] * 2) + 1);
        }
        bv.putShort(this.f43245cw.newUTF8(desc2)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this.f43245cw, true, bv, bv, bv.length - 2);
        if (visible) {
            aw.next = this.ctanns;
            this.ctanns = aw;
        } else {
            aw.next = this.ictanns;
            this.ictanns = aw;
        }
        return aw;
    }

    public void visitLineNumber(int line, Label start) {
        if (this.lineNumber == null) {
            this.lineNumber = new ByteVector();
        }
        this.lineNumberCount++;
        this.lineNumber.putShort(start.position);
        this.lineNumber.putShort(line);
    }

    public void visitMaxs(int maxStack2, int maxLocals2) {
        String t;
        int i = maxStack2;
        int i2 = this.compute;
        Label label = null;
        if (i2 == 0) {
            Handler handler = this.firstHandler;
            while (true) {
                t = "java/lang/Throwable";
                if (handler == null) {
                    break;
                }
                Label h = handler.handler.getFirst();
                Label e = handler.end.getFirst();
                String str = handler.desc;
                if (str != null) {
                    t = str;
                }
                int kind = 24117248 | this.f43245cw.addType(t);
                h.status |= 16;
                for (Label l = handler.start.getFirst(); l != e; l = l.successor) {
                    Edge b = new Edge();
                    b.info = kind;
                    b.successor = h;
                    b.next = l.successors;
                    l.successors = b;
                }
                handler = handler.next;
            }
            Frame f = this.labels.frame;
            f.initInputFrame(this.f43245cw, this.access, Type.getArgumentTypes(this.descriptor), this.maxLocals);
            visitFrame(f);
            int max = 0;
            Label changed = this.labels;
            while (changed != null) {
                Label l2 = changed;
                changed = changed.next;
                l2.next = label;
                Frame f2 = l2.frame;
                int i3 = l2.status;
                if ((i3 & 16) != 0) {
                    l2.status = i3 | 32;
                }
                l2.status |= 64;
                int blockMax = f2.inputStack.length + l2.outputStackMax;
                if (blockMax > max) {
                    max = blockMax;
                }
                for (Edge e2 = l2.successors; e2 != null; e2 = e2.next) {
                    Label n = e2.successor.getFirst();
                    if (f2.merge(this.f43245cw, n.frame, e2.info) && n.next == null) {
                        n.next = changed;
                        changed = n;
                    }
                }
                label = null;
            }
            for (Label l3 = this.labels; l3 != null; l3 = l3.successor) {
                Frame f3 = l3.frame;
                if ((l3.status & 32) != 0) {
                    visitFrame(f3);
                }
                if ((l3.status & 64) == 0) {
                    Label k = l3.successor;
                    int start = l3.position;
                    int end = (k == null ? this.code.length : k.position) - 1;
                    if (end >= start) {
                        max = Math.max(max, 1);
                        for (int i4 = start; i4 < end; i4++) {
                            this.code.data[i4] = 0;
                        }
                        this.code.data[end] = -65;
                        this.frame[startFrame(start, 0, 1)] = this.f43245cw.addType(t) | 24117248;
                        endFrame();
                        this.firstHandler = Handler.remove(this.firstHandler, l3, k);
                    }
                }
            }
            this.handlerCount = 0;
            for (Handler handler2 = this.firstHandler; handler2 != null; handler2 = handler2.next) {
                this.handlerCount++;
            }
            this.maxStack = max;
            int i5 = maxLocals2;
        } else if (i2 == 2) {
            for (Handler handler3 = this.firstHandler; handler3 != null; handler3 = handler3.next) {
                Label h2 = handler3.handler;
                Label e3 = handler3.end;
                for (Label l4 = handler3.start; l4 != e3; l4 = l4.successor) {
                    Edge b2 = new Edge();
                    b2.info = MoPubClientPositioning.NO_REPEAT;
                    b2.successor = h2;
                    if ((l4.status & 128) == 0) {
                        b2.next = l4.successors;
                        l4.successors = b2;
                    } else {
                        Edge edge = l4.successors;
                        b2.next = edge.next.next;
                        edge.next.next = b2;
                    }
                }
            }
            int i6 = this.subroutines;
            if (i6 > 0) {
                int id = 0;
                this.labels.visitSubroutine(null, 1, i6);
                for (Label l5 = this.labels; l5 != null; l5 = l5.successor) {
                    if ((l5.status & 128) != 0) {
                        Label subroutine = l5.successors.next.successor;
                        if ((subroutine.status & Opcodes.ACC_ABSTRACT) == 0) {
                            id++;
                            subroutine.visitSubroutine(null, ((((long) id) / 32) << 32) | (1 << (id % 32)), this.subroutines);
                        }
                    }
                }
                for (Label l6 = this.labels; l6 != null; l6 = l6.successor) {
                    if ((l6.status & 128) != 0) {
                        Label L = this.labels;
                        while (L != null) {
                            L.status &= -2049;
                            L = L.successor;
                        }
                        l6.successors.next.successor.visitSubroutine(l6, 0, this.subroutines);
                    }
                }
            }
            int max2 = 0;
            Label stack = this.labels;
            while (stack != null) {
                Label l7 = stack;
                stack = stack.next;
                int start2 = l7.inputStackTop;
                int blockMax2 = l7.outputStackMax + start2;
                if (blockMax2 > max2) {
                    max2 = blockMax2;
                }
                Edge b3 = l7.successors;
                if ((l7.status & 128) != 0) {
                    b3 = b3.next;
                }
                while (b3 != null) {
                    Label l8 = b3.successor;
                    if ((l8.status & 8) == 0) {
                        int i7 = b3.info;
                        l8.inputStackTop = i7 == Integer.MAX_VALUE ? 1 : i7 + start2;
                        l8.status |= 8;
                        l8.next = stack;
                        stack = l8;
                    }
                    b3 = b3.next;
                }
            }
            this.maxStack = Math.max(i, max2);
            int i8 = maxLocals2;
        } else {
            this.maxStack = i;
            this.maxLocals = maxLocals2;
        }
    }

    public void visitEnd() {
    }

    private void addSuccessor(int info, Label successor) {
        Edge b = new Edge();
        b.info = info;
        b.successor = successor;
        Label label = this.currentBlock;
        b.next = label.successors;
        label.successors = b;
    }

    private void noSuccessor() {
        if (this.compute == 0) {
            Label l = new Label();
            l.frame = new Frame();
            l.frame.owner = l;
            ByteVector byteVector = this.code;
            l.resolve(this, byteVector.length, byteVector.data);
            this.previousBlock.successor = l;
            this.previousBlock = l;
        } else {
            this.currentBlock.outputStackMax = this.maxStackSize;
        }
        if (this.compute != 1) {
            this.currentBlock = null;
        }
    }

    private void visitFrame(Frame f) {
        int nTop = 0;
        int nLocal = 0;
        int nStack = 0;
        int[] locals = f.inputLocals;
        int[] stacks = f.inputStack;
        int i = 0;
        while (i < locals.length) {
            int t = locals[i];
            if (t == 16777216) {
                nTop++;
            } else {
                nLocal += nTop + 1;
                nTop = 0;
            }
            if (t == 16777220 || t == 16777219) {
                i++;
            }
            i++;
        }
        int i2 = 0;
        while (i2 < stacks.length) {
            int t2 = stacks[i2];
            nStack++;
            if (t2 == 16777220 || t2 == 16777219) {
                i2++;
            }
            i2++;
        }
        int frameIndex = startFrame(f.owner.position, nLocal, nStack);
        int i3 = 0;
        while (nLocal > 0) {
            int t3 = locals[i3];
            int frameIndex2 = frameIndex + 1;
            this.frame[frameIndex] = t3;
            if (t3 == 16777220 || t3 == 16777219) {
                i3++;
            }
            i3++;
            nLocal--;
            frameIndex = frameIndex2;
        }
        int i4 = 0;
        while (i4 < stacks.length) {
            int t4 = stacks[i4];
            int frameIndex3 = frameIndex + 1;
            this.frame[frameIndex] = t4;
            if (t4 == 16777220 || t4 == 16777219) {
                i4++;
            }
            i4++;
            frameIndex = frameIndex3;
        }
        endFrame();
    }

    private void visitImplicitFirstFrame() {
        int frameIndex;
        int frameIndex2;
        int frameIndex3 = startFrame(0, this.descriptor.length() + 1, 0);
        int i = this.access;
        if ((i & 8) != 0) {
            frameIndex = frameIndex3;
        } else if ((i & ACC_CONSTRUCTOR) == 0) {
            int[] iArr = this.frame;
            frameIndex = frameIndex3 + 1;
            ClassWriter classWriter = this.f43245cw;
            iArr[frameIndex3] = classWriter.addType(classWriter.thisName) | 24117248;
        } else {
            frameIndex = frameIndex3 + 1;
            this.frame[frameIndex3] = 6;
        }
        int i2 = 1;
        while (true) {
            int j = i2;
            int i3 = i2 + 1;
            int i4 = this.descriptor.charAt(i2);
            if (i4 == 70) {
                int frameIndex4 = frameIndex + 1;
                this.frame[frameIndex] = 2;
                frameIndex2 = frameIndex4;
                i2 = i3;
            } else if (i4 != 76) {
                if (!(i4 == 83 || i4 == 73)) {
                    if (i4 == 74) {
                        int frameIndex5 = frameIndex + 1;
                        this.frame[frameIndex] = 4;
                        frameIndex2 = frameIndex5;
                        i2 = i3;
                    } else if (i4 != 90) {
                        if (i4 != 91) {
                            switch (i4) {
                                case 66:
                                case 67:
                                    break;
                                case 68:
                                    int frameIndex6 = frameIndex + 1;
                                    this.frame[frameIndex] = 3;
                                    frameIndex2 = frameIndex6;
                                    i2 = i3;
                                    continue;
                                default:
                                    this.frame[1] = frameIndex - 3;
                                    endFrame();
                                    return;
                            }
                        } else {
                            while (this.descriptor.charAt(i3) == '[') {
                                i3++;
                            }
                            if (this.descriptor.charAt(i3) == 'L') {
                                while (true) {
                                    i3++;
                                    if (this.descriptor.charAt(i3) != ';') {
                                    }
                                }
                            }
                            int frameIndex7 = frameIndex + 1;
                            int i5 = i3 + 1;
                            this.frame[frameIndex] = this.f43245cw.addType(this.descriptor.substring(j, i5)) | 24117248;
                            frameIndex2 = frameIndex7;
                            i2 = i5;
                        }
                    }
                }
                int frameIndex8 = frameIndex + 1;
                this.frame[frameIndex] = 1;
                frameIndex2 = frameIndex8;
                i2 = i3;
            } else {
                while (this.descriptor.charAt(i3) != ';') {
                    i3++;
                }
                int frameIndex9 = frameIndex + 1;
                int i6 = i3 + 1;
                this.frame[frameIndex] = this.f43245cw.addType(this.descriptor.substring(j + 1, i3)) | 24117248;
                frameIndex2 = frameIndex9;
                i2 = i6;
            }
        }
    }

    private int startFrame(int offset, int nLocal, int nStack) {
        int n = nLocal + 3 + nStack;
        int[] iArr = this.frame;
        if (iArr == null || iArr.length < n) {
            this.frame = new int[n];
        }
        int[] iArr2 = this.frame;
        iArr2[0] = offset;
        iArr2[1] = nLocal;
        iArr2[2] = nStack;
        return 3;
    }

    private void endFrame() {
        if (this.previousFrame != null) {
            if (this.stackMap == null) {
                this.stackMap = new ByteVector();
            }
            writeFrame();
            this.frameCount++;
        }
        this.previousFrame = this.frame;
        this.frame = null;
    }

    private void writeFrame() {
        int delta;
        int[] iArr = this.frame;
        int clocalsSize = iArr[1];
        int cstackSize = iArr[2];
        char c = 0;
        if ((this.f43245cw.version & 65535) < 50) {
            this.stackMap.putShort(iArr[0]).putShort(clocalsSize);
            writeFrameTypes(3, clocalsSize + 3);
            this.stackMap.putShort(cstackSize);
            writeFrameTypes(clocalsSize + 3, clocalsSize + 3 + cstackSize);
            return;
        }
        int[] iArr2 = this.previousFrame;
        int localsSize = iArr2[1];
        int type = 255;
        int k = 0;
        if (this.frameCount == 0) {
            delta = iArr[0];
        } else {
            delta = (iArr[0] - iArr2[0]) - 1;
        }
        if (cstackSize == 0) {
            k = clocalsSize - localsSize;
            switch (k) {
                case -3:
                case -2:
                case -1:
                    type = CHOP_FRAME;
                    localsSize = clocalsSize;
                    break;
                case 0:
                    if (delta >= 64) {
                        c = 251;
                    }
                    type = c;
                    break;
                case 1:
                case 2:
                case 3:
                    type = APPEND_FRAME;
                    break;
            }
        } else if (clocalsSize == localsSize && cstackSize == 1) {
            type = delta < 63 ? '@' : 247;
        }
        if (type != 255) {
            int l = 3;
            int j = 0;
            while (true) {
                if (j < localsSize) {
                    if (this.frame[l] != this.previousFrame[l]) {
                        type = 255;
                    } else {
                        l++;
                        j++;
                    }
                }
            }
        }
        if (type == 0) {
            this.stackMap.putByte(delta);
        } else if (type == 64) {
            this.stackMap.putByte(delta + 64);
            writeFrameTypes(clocalsSize + 3, clocalsSize + 4);
        } else if (type == SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED) {
            this.stackMap.putByte(SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED).putShort(delta);
            writeFrameTypes(clocalsSize + 3, clocalsSize + 4);
        } else if (type == CHOP_FRAME) {
            this.stackMap.putByte(k + SAME_FRAME_EXTENDED).putShort(delta);
        } else if (type == SAME_FRAME_EXTENDED) {
            this.stackMap.putByte(SAME_FRAME_EXTENDED).putShort(delta);
        } else if (type != APPEND_FRAME) {
            this.stackMap.putByte(255).putShort(delta).putShort(clocalsSize);
            writeFrameTypes(3, clocalsSize + 3);
            this.stackMap.putShort(cstackSize);
            writeFrameTypes(clocalsSize + 3, clocalsSize + 3 + cstackSize);
        } else {
            this.stackMap.putByte(k + SAME_FRAME_EXTENDED).putShort(delta);
            writeFrameTypes(localsSize + 3, clocalsSize + 3);
        }
    }

    private void writeFrameTypes(int start, int end) {
        for (int i = start; i < end; i++) {
            int t = this.frame[i];
            int d = -268435456 & t;
            if (d == 0) {
                int v = 1048575 & t;
                int i2 = 267386880 & t;
                if (i2 == 24117248) {
                    ByteVector putByte = this.stackMap.putByte(7);
                    ClassWriter classWriter = this.f43245cw;
                    putByte.putShort(classWriter.newClass(classWriter.typeTable[v].strVal1));
                } else if (i2 != 25165824) {
                    this.stackMap.putByte(v);
                } else {
                    this.stackMap.putByte(8).putShort(this.f43245cw.typeTable[v].intVal);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                int d2 = d >> 28;
                while (true) {
                    int d3 = d2 - 1;
                    if (d2 > 0) {
                        sb.append('[');
                        d2 = d3;
                    } else {
                        if ((t & 267386880) == 24117248) {
                            sb.append('L');
                            sb.append(this.f43245cw.typeTable[t & 1048575].strVal1);
                            sb.append(';');
                        } else {
                            int i3 = t & 15;
                            if (i3 == 1) {
                                sb.append('I');
                            } else if (i3 == 2) {
                                sb.append('F');
                            } else if (i3 != 3) {
                                switch (i3) {
                                    case 9:
                                        sb.append('Z');
                                        break;
                                    case 10:
                                        sb.append('B');
                                        break;
                                    case 11:
                                        sb.append('C');
                                        break;
                                    case 12:
                                        sb.append('S');
                                        break;
                                    default:
                                        sb.append('J');
                                        break;
                                }
                            } else {
                                sb.append('D');
                            }
                        }
                        this.stackMap.putByte(7).putShort(this.f43245cw.newClass(sb.toString()));
                    }
                }
            }
        }
    }

    private void writeFrameType(Object type) {
        if (type instanceof String) {
            this.stackMap.putByte(7).putShort(this.f43245cw.newClass((String) type));
        } else if (type instanceof Integer) {
            this.stackMap.putByte(((Integer) type).intValue());
        } else {
            this.stackMap.putByte(8).putShort(((Label) type).position);
        }
    }

    /* access modifiers changed from: 0000 */
    public final int getSize() {
        if (this.classReaderOffset != 0) {
            return this.classReaderLength + 6;
        }
        int size = 8;
        int i = this.code.length;
        String str = "RuntimeInvisibleTypeAnnotations";
        String str2 = "RuntimeVisibleTypeAnnotations";
        if (i > 0) {
            if (i <= 65535) {
                this.f43245cw.newUTF8("Code");
                size = 8 + this.code.length + 18 + (this.handlerCount * 8);
                if (this.localVar != null) {
                    this.f43245cw.newUTF8("LocalVariableTable");
                    size += this.localVar.length + 8;
                }
                if (this.localVarType != null) {
                    this.f43245cw.newUTF8("LocalVariableTypeTable");
                    size += this.localVarType.length + 8;
                }
                if (this.lineNumber != null) {
                    this.f43245cw.newUTF8("LineNumberTable");
                    size += this.lineNumber.length + 8;
                }
                if (this.stackMap != null) {
                    this.f43245cw.newUTF8((this.f43245cw.version & 65535) >= 50 ? "StackMapTable" : "StackMap");
                    size += this.stackMap.length + 8;
                }
                if (this.ctanns != null) {
                    this.f43245cw.newUTF8(str2);
                    size += this.ctanns.getSize() + 8;
                }
                if (this.ictanns != null) {
                    this.f43245cw.newUTF8(str);
                    size += this.ictanns.getSize() + 8;
                }
                Attribute attribute = this.cattrs;
                if (attribute != null) {
                    ClassWriter classWriter = this.f43245cw;
                    ByteVector byteVector = this.code;
                    size += attribute.getSize(classWriter, byteVector.data, byteVector.length, this.maxStack, this.maxLocals);
                }
            } else {
                throw new RuntimeException("Method code too large!");
            }
        }
        if (this.exceptionCount > 0) {
            this.f43245cw.newUTF8("Exceptions");
            size += (this.exceptionCount * 2) + 8;
        }
        int i2 = this.access;
        if ((i2 & Opcodes.ACC_SYNTHETIC) != 0 && ((65535 & this.f43245cw.version) < 49 || (i2 & Opcodes.ASM4) != 0)) {
            this.f43245cw.newUTF8("Synthetic");
            size += 6;
        }
        if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
            this.f43245cw.newUTF8("Deprecated");
            size += 6;
        }
        if (this.signature != null) {
            this.f43245cw.newUTF8("Signature");
            this.f43245cw.newUTF8(this.signature);
            size += 8;
        }
        if (this.methodParameters != null) {
            this.f43245cw.newUTF8("MethodParameters");
            size += this.methodParameters.length + 7;
        }
        if (this.annd != null) {
            this.f43245cw.newUTF8("AnnotationDefault");
            size += this.annd.length + 6;
        }
        if (this.anns != null) {
            this.f43245cw.newUTF8("RuntimeVisibleAnnotations");
            size += this.anns.getSize() + 8;
        }
        if (this.ianns != null) {
            this.f43245cw.newUTF8("RuntimeInvisibleAnnotations");
            size += this.ianns.getSize() + 8;
        }
        if (this.tanns != null) {
            this.f43245cw.newUTF8(str2);
            size += this.tanns.getSize() + 8;
        }
        if (this.itanns != null) {
            this.f43245cw.newUTF8(str);
            size += this.itanns.getSize() + 8;
        }
        if (this.panns != null) {
            this.f43245cw.newUTF8("RuntimeVisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr = this.panns;
            int size2 = size + ((annotationWriterArr.length - this.synthetics) * 2) + 7;
            for (int i3 = annotationWriterArr.length - 1; i3 >= this.synthetics; i3--) {
                AnnotationWriter[] annotationWriterArr2 = this.panns;
                size2 = size + (annotationWriterArr2[i3] == null ? 0 : annotationWriterArr2[i3].getSize());
            }
        }
        if (this.ipanns != null) {
            this.f43245cw.newUTF8("RuntimeInvisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr3 = this.ipanns;
            int size3 = size + ((annotationWriterArr3.length - this.synthetics) * 2) + 7;
            for (int i4 = annotationWriterArr3.length - 1; i4 >= this.synthetics; i4--) {
                AnnotationWriter[] annotationWriterArr4 = this.ipanns;
                size3 = size + (annotationWriterArr4[i4] == null ? 0 : annotationWriterArr4[i4].getSize());
            }
        }
        Attribute attribute2 = this.attrs;
        if (attribute2 != null) {
            size += attribute2.getSize(this.f43245cw, null, 0, -1, -1);
        }
        return size;
    }

    /* access modifiers changed from: 0000 */
    public final void put(ByteVector out) {
        String str;
        int i;
        int i2;
        int size;
        int attributeCount;
        ByteVector byteVector = out;
        int i3 = this.access;
        byteVector.putShort(i3 & ((((i3 & Opcodes.ASM4) / 64) | 917504) ^ -1)).putShort(this.name).putShort(this.desc);
        int i4 = this.classReaderOffset;
        if (i4 != 0) {
            byteVector.putByteArray(this.f43245cw.f43242cr.f43240b, i4, this.classReaderLength);
            return;
        }
        int attributeCount2 = 0;
        if (this.code.length > 0) {
            attributeCount2 = 0 + 1;
        }
        if (this.exceptionCount > 0) {
            attributeCount2++;
        }
        int i5 = this.access;
        if ((i5 & Opcodes.ACC_SYNTHETIC) != 0 && ((this.f43245cw.version & 65535) < 49 || (i5 & Opcodes.ASM4) != 0)) {
            attributeCount2++;
        }
        if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
            attributeCount2++;
        }
        if (this.signature != null) {
            attributeCount2++;
        }
        if (this.methodParameters != null) {
            attributeCount2++;
        }
        if (this.annd != null) {
            attributeCount2++;
        }
        if (this.anns != null) {
            attributeCount2++;
        }
        if (this.ianns != null) {
            attributeCount2++;
        }
        if (this.tanns != null) {
            attributeCount2++;
        }
        if (this.itanns != null) {
            attributeCount2++;
        }
        if (this.panns != null) {
            attributeCount2++;
        }
        if (this.ipanns != null) {
            attributeCount2++;
        }
        Attribute attribute = this.attrs;
        if (attribute != null) {
            attributeCount2 += attribute.getCount();
        }
        byteVector.putShort(attributeCount2);
        int i6 = this.code.length;
        String str2 = "RuntimeInvisibleTypeAnnotations";
        String str3 = "RuntimeVisibleTypeAnnotations";
        if (i6 > 0) {
            int size2 = i6 + 12 + (this.handlerCount * 8);
            ByteVector byteVector2 = this.localVar;
            if (byteVector2 != null) {
                size2 += byteVector2.length + 8;
            }
            ByteVector byteVector3 = this.localVarType;
            if (byteVector3 != null) {
                size2 += byteVector3.length + 8;
            }
            ByteVector byteVector4 = this.lineNumber;
            if (byteVector4 != null) {
                size2 += byteVector4.length + 8;
            }
            ByteVector byteVector5 = this.stackMap;
            if (byteVector5 != null) {
                size2 += byteVector5.length + 8;
            }
            AnnotationWriter annotationWriter = this.ctanns;
            if (annotationWriter != null) {
                size2 += annotationWriter.getSize() + 8;
            }
            AnnotationWriter annotationWriter2 = this.ictanns;
            if (annotationWriter2 != null) {
                size2 += annotationWriter2.getSize() + 8;
            }
            Attribute attribute2 = this.cattrs;
            if (attribute2 != null) {
                ClassWriter classWriter = this.f43245cw;
                ByteVector byteVector6 = this.code;
                size = size2 + attribute2.getSize(classWriter, byteVector6.data, byteVector6.length, this.maxStack, this.maxLocals);
            } else {
                size = size2;
            }
            byteVector.putShort(this.f43245cw.newUTF8("Code")).putInt(size);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            ByteVector putInt = byteVector.putInt(this.code.length);
            ByteVector byteVector7 = this.code;
            putInt.putByteArray(byteVector7.data, 0, byteVector7.length);
            byteVector.putShort(this.handlerCount);
            if (this.handlerCount > 0) {
                for (Handler h = this.firstHandler; h != null; h = h.next) {
                    byteVector.putShort(h.start.position).putShort(h.end.position).putShort(h.handler.position).putShort(h.type);
                }
            }
            int attributeCount3 = 0;
            if (this.localVar != null) {
                attributeCount3 = 0 + 1;
            }
            if (this.localVarType != null) {
                attributeCount3++;
            }
            if (this.lineNumber != null) {
                attributeCount3++;
            }
            if (this.stackMap != null) {
                attributeCount3++;
            }
            if (this.ctanns != null) {
                attributeCount3++;
            }
            if (this.ictanns != null) {
                attributeCount3++;
            }
            Attribute attribute3 = this.cattrs;
            if (attribute3 != null) {
                attributeCount = attributeCount3 + attribute3.getCount();
            } else {
                attributeCount = attributeCount3;
            }
            byteVector.putShort(attributeCount);
            if (this.localVar != null) {
                byteVector.putShort(this.f43245cw.newUTF8("LocalVariableTable"));
                byteVector.putInt(this.localVar.length + 2).putShort(this.localVarCount);
                ByteVector byteVector8 = this.localVar;
                byteVector.putByteArray(byteVector8.data, 0, byteVector8.length);
            }
            if (this.localVarType != null) {
                byteVector.putShort(this.f43245cw.newUTF8("LocalVariableTypeTable"));
                byteVector.putInt(this.localVarType.length + 2).putShort(this.localVarTypeCount);
                ByteVector byteVector9 = this.localVarType;
                byteVector.putByteArray(byteVector9.data, 0, byteVector9.length);
            }
            if (this.lineNumber != null) {
                byteVector.putShort(this.f43245cw.newUTF8("LineNumberTable"));
                byteVector.putInt(this.lineNumber.length + 2).putShort(this.lineNumberCount);
                ByteVector byteVector10 = this.lineNumber;
                byteVector.putByteArray(byteVector10.data, 0, byteVector10.length);
            }
            if (this.stackMap != null) {
                byteVector.putShort(this.f43245cw.newUTF8((this.f43245cw.version & 65535) >= 50 ? "StackMapTable" : "StackMap"));
                byteVector.putInt(this.stackMap.length + 2).putShort(this.frameCount);
                ByteVector byteVector11 = this.stackMap;
                byteVector.putByteArray(byteVector11.data, 0, byteVector11.length);
            }
            if (this.ctanns != null) {
                byteVector.putShort(this.f43245cw.newUTF8(str3));
                this.ctanns.put(byteVector);
            }
            if (this.ictanns != null) {
                byteVector.putShort(this.f43245cw.newUTF8(str2));
                this.ictanns.put(byteVector);
            }
            Attribute attribute4 = this.cattrs;
            if (attribute4 != null) {
                ClassWriter classWriter2 = this.f43245cw;
                ByteVector byteVector12 = this.code;
                byte[] bArr = byteVector12.data;
                int i7 = byteVector12.length;
                byte[] bArr2 = bArr;
                int i8 = i7;
                i2 = 0;
                i = 2;
                str = str3;
                attribute4.put(classWriter2, bArr2, i8, this.maxLocals, this.maxStack, out);
            } else {
                str = str3;
                i2 = 0;
                i = 2;
            }
        } else {
            str = str3;
            i2 = 0;
            i = 2;
            int i9 = attributeCount2;
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.f43245cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + i);
            byteVector.putShort(this.exceptionCount);
            for (int i10 = 0; i10 < this.exceptionCount; i10++) {
                byteVector.putShort(this.exceptions[i10]);
            }
        }
        int i11 = this.access;
        if ((i11 & Opcodes.ACC_SYNTHETIC) != 0 && ((this.f43245cw.version & 65535) < 49 || (i11 & Opcodes.ASM4) != 0)) {
            byteVector.putShort(this.f43245cw.newUTF8("Synthetic")).putInt(i2);
        }
        if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
            byteVector.putShort(this.f43245cw.newUTF8("Deprecated")).putInt(i2);
        }
        if (this.signature != null) {
            byteVector.putShort(this.f43245cw.newUTF8("Signature")).putInt(i).putShort(this.f43245cw.newUTF8(this.signature));
        }
        if (this.methodParameters != null) {
            byteVector.putShort(this.f43245cw.newUTF8("MethodParameters"));
            byteVector.putInt(this.methodParameters.length + 1).putByte(this.methodParametersCount);
            ByteVector byteVector13 = this.methodParameters;
            byteVector.putByteArray(byteVector13.data, i2, byteVector13.length);
        }
        if (this.annd != null) {
            byteVector.putShort(this.f43245cw.newUTF8("AnnotationDefault"));
            byteVector.putInt(this.annd.length);
            ByteVector byteVector14 = this.annd;
            byteVector.putByteArray(byteVector14.data, i2, byteVector14.length);
        }
        if (this.anns != null) {
            byteVector.putShort(this.f43245cw.newUTF8("RuntimeVisibleAnnotations"));
            this.anns.put(byteVector);
        }
        if (this.ianns != null) {
            byteVector.putShort(this.f43245cw.newUTF8("RuntimeInvisibleAnnotations"));
            this.ianns.put(byteVector);
        }
        if (this.tanns != null) {
            byteVector.putShort(this.f43245cw.newUTF8(str));
            this.tanns.put(byteVector);
        }
        if (this.itanns != null) {
            byteVector.putShort(this.f43245cw.newUTF8(str2));
            this.itanns.put(byteVector);
        }
        if (this.panns != null) {
            byteVector.putShort(this.f43245cw.newUTF8("RuntimeVisibleParameterAnnotations"));
            AnnotationWriter.put(this.panns, this.synthetics, byteVector);
        }
        if (this.ipanns != null) {
            byteVector.putShort(this.f43245cw.newUTF8("RuntimeInvisibleParameterAnnotations"));
            AnnotationWriter.put(this.ipanns, this.synthetics, byteVector);
        }
        Attribute attribute5 = this.attrs;
        if (attribute5 != null) {
            attribute5.put(this.f43245cw, null, 0, -1, -1, out);
        }
    }
}
