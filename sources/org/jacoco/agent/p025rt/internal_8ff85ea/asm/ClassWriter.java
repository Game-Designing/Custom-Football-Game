package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.ContentTypeDetector;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter */
public class ClassWriter extends ClassVisitor {
    static final int ACC_SYNTHETIC_ATTRIBUTE = 262144;
    static final int ASM_LABEL_INSN = 18;
    static final int BSM = 33;
    static final int CLASS = 7;
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;
    static final int DOUBLE = 6;
    static final int FIELD = 9;
    static final int FIELDORMETH_INSN = 6;
    static final int FLOAT = 4;
    static final int F_INSERT = 256;
    static final int HANDLE = 15;
    static final int HANDLE_BASE = 20;
    static final int IINC_INSN = 13;
    static final int IMETH = 11;
    static final int IMPLVAR_INSN = 4;
    static final int INDY = 18;
    static final int INDYMETH_INSN = 8;
    static final int INT = 3;
    static final int ITFMETH_INSN = 7;
    static final int LABELW_INSN = 10;
    static final int LABEL_INSN = 9;
    static final int LDCW_INSN = 12;
    static final int LDC_INSN = 11;
    static final int LONG = 5;
    static final int LOOK_INSN = 15;
    static final int MANA_INSN = 16;
    static final int METH = 10;
    static final int MTYPE = 16;
    static final int NAME_TYPE = 12;
    static final int NOARG_INSN = 0;
    static final int SBYTE_INSN = 1;
    static final int SHORT_INSN = 2;
    static final int STR = 8;
    static final int TABL_INSN = 14;
    static final int TO_ACC_SYNTHETIC = 64;
    static final byte[] TYPE;
    static final int TYPE_INSN = 5;
    static final int TYPE_MERGED = 32;
    static final int TYPE_NORMAL = 30;
    static final int TYPE_UNINIT = 31;
    static final int UTF8 = 1;
    static final int VAR_INSN = 3;
    static final int WIDE_INSN = 17;
    private int access;
    private AnnotationWriter anns;
    private Attribute attrs;
    ByteVector bootstrapMethods;
    int bootstrapMethodsCount;
    private int compute;

    /* renamed from: cr */
    ClassReader f43242cr;
    private int enclosingMethod;
    private int enclosingMethodOwner;
    FieldWriter firstField;
    MethodWriter firstMethod;
    boolean hasAsmInsns;
    private AnnotationWriter ianns;
    int index;
    private ByteVector innerClasses;
    private int innerClassesCount;
    private int interfaceCount;
    private int[] interfaces;
    private AnnotationWriter itanns;
    Item[] items;
    final Item key;
    final Item key2;
    final Item key3;
    final Item key4;
    FieldWriter lastField;
    MethodWriter lastMethod;
    private int name;
    final ByteVector pool;
    private int signature;
    private ByteVector sourceDebug;
    private int sourceFile;
    private int superName;
    private AnnotationWriter tanns;
    String thisName;
    int threshold;
    private short typeCount;
    Item[] typeTable;
    int version;

    static {
        byte[] b = new byte[220];
        String s = "AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKSSSSSSSSSSSSSSSSSS";
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (s.charAt(i) - 'A');
        }
        TYPE = b;
    }

    public ClassWriter(int flags) {
        super(327680);
        this.index = 1;
        this.pool = new ByteVector();
        this.items = new Item[256];
        double length = (double) this.items.length;
        Double.isNaN(length);
        this.threshold = (int) (length * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
        this.key4 = new Item();
        int i = (flags & 2) != 0 ? 0 : (flags & 1) != 0 ? 2 : 3;
        this.compute = i;
    }

    public ClassWriter(ClassReader classReader, int flags) {
        this(flags);
        classReader.copyPool(this);
        this.f43242cr = classReader;
    }

    public final void visit(int version2, int access2, String name2, String signature2, String superName2, String[] interfaces2) {
        this.version = version2;
        this.access = access2;
        this.name = newClass(name2);
        this.thisName = name2;
        if (signature2 != null) {
            this.signature = newUTF8(signature2);
        }
        this.superName = superName2 == null ? 0 : newClass(superName2);
        if (interfaces2 != null && interfaces2.length > 0) {
            this.interfaceCount = interfaces2.length;
            this.interfaces = new int[this.interfaceCount];
            for (int i = 0; i < this.interfaceCount; i++) {
                this.interfaces[i] = newClass(interfaces2[i]);
            }
        }
    }

    public final void visitSource(String file, String debug) {
        if (file != null) {
            this.sourceFile = newUTF8(file);
        }
        if (debug != null) {
            this.sourceDebug = new ByteVector().encodeUTF8(debug, 0, MoPubClientPositioning.NO_REPEAT);
        }
    }

    public final void visitOuterClass(String owner, String name2, String desc) {
        this.enclosingMethodOwner = newClass(owner);
        if (name2 != null && desc != null) {
            this.enclosingMethod = newNameType(name2, desc);
        }
    }

    public final AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        ByteVector bv = new ByteVector();
        bv.putShort(newUTF8(desc)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this, true, bv, bv, 2);
        if (visible) {
            aw.next = this.anns;
            this.anns = aw;
        } else {
            aw.next = this.ianns;
            this.ianns = aw;
        }
        return aw;
    }

    public final AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        ByteVector bv = new ByteVector();
        AnnotationWriter.putTarget(typeRef, typePath, bv);
        bv.putShort(newUTF8(desc)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this, true, bv, bv, bv.length - 2);
        if (visible) {
            aw.next = this.tanns;
            this.tanns = aw;
        } else {
            aw.next = this.itanns;
            this.itanns = aw;
        }
        return aw;
    }

    public final void visitAttribute(Attribute attr) {
        attr.next = this.attrs;
        this.attrs = attr;
    }

    public final void visitInnerClass(String name2, String outerName, String innerName, int access2) {
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        Item nameItem = newClassItem(name2);
        if (nameItem.intVal == 0) {
            this.innerClassesCount++;
            this.innerClasses.putShort(nameItem.index);
            int i = 0;
            this.innerClasses.putShort(outerName == null ? 0 : newClass(outerName));
            ByteVector byteVector = this.innerClasses;
            if (innerName != null) {
                i = newUTF8(innerName);
            }
            byteVector.putShort(i);
            this.innerClasses.putShort(access2);
            nameItem.intVal = this.innerClassesCount;
        }
    }

    public final FieldVisitor visitField(int access2, String name2, String desc, String signature2, Object value) {
        FieldWriter fieldWriter = new FieldWriter(this, access2, name2, desc, signature2, value);
        return fieldWriter;
    }

    public final MethodVisitor visitMethod(int access2, String name2, String desc, String signature2, String[] exceptions) {
        MethodWriter methodWriter = new MethodWriter(this, access2, name2, desc, signature2, exceptions, this.compute);
        return methodWriter;
    }

    public final void visitEnd() {
    }

    public byte[] toByteArray() {
        int size;
        String str;
        String str2;
        int attributeCount;
        boolean z;
        ByteVector out;
        if (this.index <= 65535) {
            int size2 = (this.interfaceCount * 2) + 24;
            int nbFields = 0;
            for (FieldWriter fb = this.firstField; fb != null; fb = (FieldWriter) fb.f43243fv) {
                nbFields++;
                size2 += fb.getSize();
            }
            int nbMethods = 0;
            for (MethodWriter mb = this.firstMethod; mb != null; mb = (MethodWriter) mb.f149mv) {
                nbMethods++;
                size2 += mb.getSize();
            }
            int attributeCount2 = 0;
            ByteVector byteVector = this.bootstrapMethods;
            String str3 = "BootstrapMethods";
            if (byteVector != null) {
                attributeCount2 = 0 + 1;
                size2 += byteVector.length + 8;
                newUTF8(str3);
            }
            String str4 = "Signature";
            if (this.signature != 0) {
                attributeCount2++;
                size2 += 8;
                newUTF8(str4);
            }
            String str5 = "SourceFile";
            if (this.sourceFile != 0) {
                attributeCount2++;
                size2 += 8;
                newUTF8(str5);
            }
            ByteVector byteVector2 = this.sourceDebug;
            String str6 = "SourceDebugExtension";
            if (byteVector2 != null) {
                attributeCount2++;
                size2 += byteVector2.length + 6;
                newUTF8(str6);
            }
            String str7 = "EnclosingMethod";
            if (this.enclosingMethodOwner != 0) {
                attributeCount2++;
                size2 += 10;
                newUTF8(str7);
            }
            if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
                attributeCount2++;
                size2 += 6;
                newUTF8("Deprecated");
            }
            int i = this.access;
            if ((i & Opcodes.ACC_SYNTHETIC) != 0 && ((this.version & 65535) < 49 || (i & 262144) != 0)) {
                attributeCount2++;
                size2 += 6;
                newUTF8("Synthetic");
            }
            ByteVector byteVector3 = this.innerClasses;
            if (byteVector3 != null) {
                attributeCount2++;
                size2 += byteVector3.length + 8;
                newUTF8("InnerClasses");
            }
            AnnotationWriter annotationWriter = this.anns;
            if (annotationWriter != null) {
                attributeCount2++;
                size2 += annotationWriter.getSize() + 8;
                newUTF8("RuntimeVisibleAnnotations");
            }
            AnnotationWriter annotationWriter2 = this.ianns;
            if (annotationWriter2 != null) {
                attributeCount2++;
                size2 += annotationWriter2.getSize() + 8;
                newUTF8("RuntimeInvisibleAnnotations");
            }
            AnnotationWriter annotationWriter3 = this.tanns;
            if (annotationWriter3 != null) {
                attributeCount2++;
                size2 += annotationWriter3.getSize() + 8;
                newUTF8("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter annotationWriter4 = this.itanns;
            if (annotationWriter4 != null) {
                attributeCount2++;
                int size3 = size2 + annotationWriter4.getSize() + 8;
                newUTF8("RuntimeInvisibleTypeAnnotations");
                size = size3;
            } else {
                size = size2;
            }
            Attribute attribute = this.attrs;
            if (attribute != null) {
                str2 = str7;
                str = str6;
                size += this.attrs.getSize(this, null, 0, -1, -1);
                attributeCount = attributeCount2 + attribute.getCount();
            } else {
                str2 = str7;
                str = str6;
                attributeCount = attributeCount2;
            }
            int size4 = size + this.pool.length;
            ByteVector out2 = new ByteVector(size4);
            out2.putInt(ContentTypeDetector.CLASSFILE).putInt(this.version);
            ByteVector putShort = out2.putShort(this.index);
            ByteVector byteVector4 = this.pool;
            putShort.putByteArray(byteVector4.data, 0, byteVector4.length);
            int i2 = this.access;
            out2.putShort(((((i2 & 262144) / 64) | 393216) ^ -1) & i2).putShort(this.name).putShort(this.superName);
            out2.putShort(this.interfaceCount);
            for (int i3 = 0; i3 < this.interfaceCount; i3++) {
                out2.putShort(this.interfaces[i3]);
            }
            out2.putShort(nbFields);
            for (FieldWriter fb2 = this.firstField; fb2 != null; fb2 = (FieldWriter) fb2.f43243fv) {
                fb2.put(out2);
            }
            out2.putShort(nbMethods);
            for (MethodWriter mb2 = this.firstMethod; mb2 != null; mb2 = (MethodWriter) mb2.f149mv) {
                mb2.put(out2);
            }
            out2.putShort(attributeCount);
            if (this.bootstrapMethods != null) {
                out2.putShort(newUTF8(str3));
                out2.putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodsCount);
                ByteVector byteVector5 = this.bootstrapMethods;
                out2.putByteArray(byteVector5.data, 0, byteVector5.length);
            }
            if (this.signature != 0) {
                out2.putShort(newUTF8(str4)).putInt(2).putShort(this.signature);
            }
            if (this.sourceFile != 0) {
                out2.putShort(newUTF8(str5)).putInt(2).putShort(this.sourceFile);
            }
            ByteVector byteVector6 = this.sourceDebug;
            if (byteVector6 != null) {
                int len = byteVector6.length;
                out2.putShort(newUTF8(str)).putInt(len);
                out2.putByteArray(this.sourceDebug.data, 0, len);
            }
            if (this.enclosingMethodOwner != 0) {
                out2.putShort(newUTF8(str2)).putInt(4);
                out2.putShort(this.enclosingMethodOwner).putShort(this.enclosingMethod);
            }
            if ((this.access & Opcodes.ACC_DEPRECATED) != 0) {
                out2.putShort(newUTF8("Deprecated")).putInt(0);
            }
            int i4 = this.access;
            if ((i4 & Opcodes.ACC_SYNTHETIC) != 0 && ((this.version & 65535) < 49 || (i4 & 262144) != 0)) {
                out2.putShort(newUTF8("Synthetic")).putInt(0);
            }
            if (this.innerClasses != null) {
                out2.putShort(newUTF8("InnerClasses"));
                out2.putInt(this.innerClasses.length + 2).putShort(this.innerClassesCount);
                ByteVector byteVector7 = this.innerClasses;
                out2.putByteArray(byteVector7.data, 0, byteVector7.length);
            }
            if (this.anns != null) {
                out2.putShort(newUTF8("RuntimeVisibleAnnotations"));
                this.anns.put(out2);
            }
            if (this.ianns != null) {
                out2.putShort(newUTF8("RuntimeInvisibleAnnotations"));
                this.ianns.put(out2);
            }
            if (this.tanns != null) {
                out2.putShort(newUTF8("RuntimeVisibleTypeAnnotations"));
                this.tanns.put(out2);
            }
            if (this.itanns != null) {
                out2.putShort(newUTF8("RuntimeInvisibleTypeAnnotations"));
                this.itanns.put(out2);
            }
            Attribute attribute2 = this.attrs;
            if (attribute2 != null) {
                z = false;
                out = out2;
                int i5 = attributeCount;
                int i6 = size4;
                attribute2.put(this, null, 0, -1, -1, out);
            } else {
                out = out2;
                int i7 = attributeCount;
                int i8 = size4;
                z = false;
            }
            if (!this.hasAsmInsns) {
                return out.data;
            }
            this.anns = null;
            this.ianns = null;
            this.attrs = null;
            this.innerClassesCount = z ? 1 : 0;
            this.innerClasses = null;
            this.firstField = null;
            this.lastField = null;
            this.firstMethod = null;
            this.lastMethod = null;
            this.compute = 1;
            this.hasAsmInsns = z;
            new ClassReader(out.data).accept(this, 264);
            return toByteArray();
        }
        throw new RuntimeException("Class file too large!");
    }

    /* access modifiers changed from: 0000 */
    public Item newConstItem(Object cst) {
        if (cst instanceof Integer) {
            return newInteger(((Integer) cst).intValue());
        }
        if ((cst instanceof Byte) != 0) {
            return newInteger(((Byte) cst).intValue());
        }
        if ((cst instanceof Character) != 0) {
            return newInteger(((Character) cst).charValue());
        }
        if ((cst instanceof Short) != 0) {
            return newInteger(((Short) cst).intValue());
        }
        if ((cst instanceof Boolean) != 0) {
            return newInteger((int) ((Boolean) cst).booleanValue());
        }
        if ((cst instanceof Float) != 0) {
            return newFloat(((Float) cst).floatValue());
        }
        if (cst instanceof Long) {
            return newLong(((Long) cst).longValue());
        }
        if (cst instanceof Double) {
            return newDouble(((Double) cst).doubleValue());
        }
        if (cst instanceof String) {
            return newString((String) cst);
        }
        if (cst instanceof Type) {
            Type t = (Type) cst;
            int s = t.getSort();
            if (s == 10) {
                return newClassItem(t.getInternalName());
            }
            if (s == 11) {
                return newMethodTypeItem(t.getDescriptor());
            }
            return newClassItem(t.getDescriptor());
        } else if (cst instanceof Handle) {
            Handle h = (Handle) cst;
            return newHandleItem(h.tag, h.owner, h.name, h.desc, h.itf);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("value ");
            sb.append(cst);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public int newConst(Object cst) {
        return newConstItem(cst).index;
    }

    public int newUTF8(String value) {
        this.key.set(1, value, null, null);
        Item result = get(this.key);
        if (result == null) {
            this.pool.putByte(1).putUTF8(value);
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key);
            put(result);
        }
        return result.index;
    }

    /* access modifiers changed from: 0000 */
    public Item newClassItem(String value) {
        this.key2.set(7, value, null, null);
        Item result = get(this.key2);
        if (result != null) {
            return result;
        }
        this.pool.put12(7, newUTF8(value));
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key2);
        put(result2);
        return result2;
    }

    public int newClass(String value) {
        return newClassItem(value).index;
    }

    /* access modifiers changed from: 0000 */
    public Item newMethodTypeItem(String methodDesc) {
        this.key2.set(16, methodDesc, null, null);
        Item result = get(this.key2);
        if (result != null) {
            return result;
        }
        this.pool.put12(16, newUTF8(methodDesc));
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key2);
        put(result2);
        return result2;
    }

    public int newMethodType(String methodDesc) {
        return newMethodTypeItem(methodDesc).index;
    }

    /* access modifiers changed from: 0000 */
    public Item newHandleItem(int tag, String owner, String name2, String desc, boolean itf) {
        this.key4.set(tag + 20, owner, name2, desc);
        Item result = get(this.key4);
        if (result != null) {
            return result;
        }
        if (tag <= 4) {
            put112(15, tag, newField(owner, name2, desc));
        } else {
            put112(15, tag, newMethod(owner, name2, desc, itf));
        }
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key4);
        put(result2);
        return result2;
    }

    @Deprecated
    public int newHandle(int tag, String owner, String name2, String desc) {
        return newHandle(tag, owner, name2, desc, tag == 9);
    }

    public int newHandle(int tag, String owner, String name2, String desc, boolean itf) {
        return newHandleItem(tag, owner, name2, desc, itf).index;
    }

    /* access modifiers changed from: 0000 */
    public Item newInvokeDynamicItem(String name2, String desc, Handle bsm, Object... bsmArgs) {
        int bootstrapMethodIndex;
        ByteVector bootstrapMethods2 = this.bootstrapMethods;
        if (bootstrapMethods2 == null) {
            ByteVector byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
            bootstrapMethods2 = byteVector;
        }
        int position = bootstrapMethods2.length;
        int hashCode = bsm.hashCode();
        bootstrapMethods2.putShort(newHandle(bsm.tag, bsm.owner, bsm.name, bsm.desc, bsm.isInterface()));
        bootstrapMethods2.putShort(argsLength);
        for (Object bsmArg : bsmArgs) {
            hashCode ^= bsmArg.hashCode();
            bootstrapMethods2.putShort(newConst(bsmArg));
        }
        byte[] data = bootstrapMethods2.data;
        int length = (argsLength + 2) << 1;
        int hashCode2 = hashCode & MoPubClientPositioning.NO_REPEAT;
        Item[] itemArr = this.items;
        Item result = itemArr[hashCode2 % itemArr.length];
        loop1:
        while (result != null) {
            if (result.type == 33 && result.hashCode == hashCode2) {
                int resultPosition = result.intVal;
                int p = 0;
                while (p < length) {
                    if (data[position + p] != data[resultPosition + p]) {
                        result = result.next;
                    } else {
                        p++;
                    }
                }
                break loop1;
            }
            result = result.next;
        }
        if (result != null) {
            bootstrapMethodIndex = result.index;
            bootstrapMethods2.length = position;
        } else {
            bootstrapMethodIndex = this.bootstrapMethodsCount;
            this.bootstrapMethodsCount = bootstrapMethodIndex + 1;
            Item result2 = new Item(bootstrapMethodIndex);
            result2.set(position, hashCode2);
            put(result2);
        }
        this.key3.set(name2, desc, bootstrapMethodIndex);
        Item result3 = get(this.key3);
        if (result3 != null) {
            return result3;
        }
        put122(18, bootstrapMethodIndex, newNameType(name2, desc));
        int i = this.index;
        this.index = i + 1;
        Item result4 = new Item(i, this.key3);
        put(result4);
        return result4;
    }

    public int newInvokeDynamic(String name2, String desc, Handle bsm, Object... bsmArgs) {
        return newInvokeDynamicItem(name2, desc, bsm, bsmArgs).index;
    }

    /* access modifiers changed from: 0000 */
    public Item newFieldItem(String owner, String name2, String desc) {
        this.key3.set(9, owner, name2, desc);
        Item result = get(this.key3);
        if (result != null) {
            return result;
        }
        put122(9, newClass(owner), newNameType(name2, desc));
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key3);
        put(result2);
        return result2;
    }

    public int newField(String owner, String name2, String desc) {
        return newFieldItem(owner, name2, desc).index;
    }

    /* access modifiers changed from: 0000 */
    public Item newMethodItem(String owner, String name2, String desc, boolean itf) {
        int type = itf ? 11 : 10;
        this.key3.set(type, owner, name2, desc);
        Item result = get(this.key3);
        if (result != null) {
            return result;
        }
        put122(type, newClass(owner), newNameType(name2, desc));
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key3);
        put(result2);
        return result2;
    }

    public int newMethod(String owner, String name2, String desc, boolean itf) {
        return newMethodItem(owner, name2, desc, itf).index;
    }

    /* access modifiers changed from: 0000 */
    public Item newInteger(int value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result != null) {
            return result;
        }
        this.pool.putByte(3).putInt(value);
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key);
        put(result2);
        return result2;
    }

    /* access modifiers changed from: 0000 */
    public Item newFloat(float value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result != null) {
            return result;
        }
        this.pool.putByte(4).putInt(this.key.intVal);
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key);
        put(result2);
        return result2;
    }

    /* access modifiers changed from: 0000 */
    public Item newLong(long value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result != null) {
            return result;
        }
        this.pool.putByte(5).putLong(value);
        Item result2 = new Item(this.index, this.key);
        this.index += 2;
        put(result2);
        return result2;
    }

    /* access modifiers changed from: 0000 */
    public Item newDouble(double value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result != null) {
            return result;
        }
        this.pool.putByte(6).putLong(this.key.longVal);
        Item result2 = new Item(this.index, this.key);
        this.index += 2;
        put(result2);
        return result2;
    }

    private Item newString(String value) {
        this.key2.set(8, value, null, null);
        Item result = get(this.key2);
        if (result != null) {
            return result;
        }
        this.pool.put12(8, newUTF8(value));
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key2);
        put(result2);
        return result2;
    }

    public int newNameType(String name2, String desc) {
        return newNameTypeItem(name2, desc).index;
    }

    /* access modifiers changed from: 0000 */
    public Item newNameTypeItem(String name2, String desc) {
        this.key2.set(12, name2, desc, null);
        Item result = get(this.key2);
        if (result != null) {
            return result;
        }
        put122(12, newUTF8(name2), newUTF8(desc));
        int i = this.index;
        this.index = i + 1;
        Item result2 = new Item(i, this.key2);
        put(result2);
        return result2;
    }

    /* access modifiers changed from: 0000 */
    public int addType(String type) {
        this.key.set(30, type, null, null);
        Item result = get(this.key);
        if (result == null) {
            result = addType(this.key);
        }
        return result.index;
    }

    /* access modifiers changed from: 0000 */
    public int addUninitializedType(String type, int offset) {
        Item item = this.key;
        item.type = 31;
        item.intVal = offset;
        item.strVal1 = type;
        item.hashCode = Integer.MAX_VALUE & (type.hashCode() + 31 + offset);
        Item result = get(this.key);
        if (result == null) {
            result = addType(this.key);
        }
        return result.index;
    }

    private Item addType(Item item) {
        this.typeCount = (short) (this.typeCount + 1);
        Item result = new Item(this.typeCount, this.key);
        put(result);
        if (this.typeTable == null) {
            this.typeTable = new Item[16];
        }
        short s = this.typeCount;
        Item[] itemArr = this.typeTable;
        if (s == itemArr.length) {
            Item[] newTable = new Item[(itemArr.length * 2)];
            System.arraycopy(itemArr, 0, newTable, 0, itemArr.length);
            this.typeTable = newTable;
        }
        this.typeTable[this.typeCount] = result;
        return result;
    }

    /* access modifiers changed from: 0000 */
    public int getMergedType(int type1, int type2) {
        Item item = this.key2;
        item.type = 32;
        item.longVal = ((long) type1) | (((long) type2) << 32);
        item.hashCode = (type1 + 32 + type2) & MoPubClientPositioning.NO_REPEAT;
        Item result = get(item);
        if (result == null) {
            Item[] itemArr = this.typeTable;
            String t = itemArr[type1].strVal1;
            String u = itemArr[type2].strVal1;
            this.key2.intVal = addType(getCommonSuperClass(t, u));
            result = new Item(0, this.key2);
            put(result);
        }
        return result.intVal;
    }

    /* access modifiers changed from: protected */
    public String getCommonSuperClass(String type1, String type2) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class<?> c = Class.forName(type1.replace('/', '.'), false, classLoader);
            Class<?> d = Class.forName(type2.replace('/', '.'), false, classLoader);
            if (c.isAssignableFrom(d)) {
                return type1;
            }
            if (d.isAssignableFrom(c)) {
                return type2;
            }
            if (c.isInterface() || d.isInterface()) {
                return "java/lang/Object";
            }
            do {
                c = c.getSuperclass();
            } while (!c.isAssignableFrom(d));
            return c.getName().replace('.', '/');
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    private Item get(Item key5) {
        Item[] itemArr = this.items;
        Item i = itemArr[key5.hashCode % itemArr.length];
        while (i != null && (i.type != key5.type || !key5.isEqualTo(i))) {
            i = i.next;
        }
        return i;
    }

    private void put(Item i) {
        if (this.index + this.typeCount > this.threshold) {
            int ll = this.items.length;
            int nl = (ll * 2) + 1;
            Item[] newItems = new Item[nl];
            for (int l = ll - 1; l >= 0; l--) {
                Item j = this.items[l];
                while (j != null) {
                    int index2 = j.hashCode % newItems.length;
                    Item k = j.next;
                    j.next = newItems[index2];
                    newItems[index2] = j;
                    j = k;
                }
            }
            this.items = newItems;
            double d = (double) nl;
            Double.isNaN(d);
            this.threshold = (int) (d * 0.75d);
        }
        int ll2 = i.hashCode;
        Item[] itemArr = this.items;
        int index3 = ll2 % itemArr.length;
        i.next = itemArr[index3];
        itemArr[index3] = i;
    }

    private void put122(int b, int s1, int s2) {
        this.pool.put12(b, s1).putShort(s2);
    }

    private void put112(int b1, int b2, int s) {
        this.pool.put11(b1, b2).putShort(s);
    }
}
