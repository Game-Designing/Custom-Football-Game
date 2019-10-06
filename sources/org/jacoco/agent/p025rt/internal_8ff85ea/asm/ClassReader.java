package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.ClassReader */
public class ClassReader {
    static final boolean ANNOTATIONS = true;
    static final int EXPAND_ASM_INSNS = 256;
    public static final int EXPAND_FRAMES = 8;
    static final boolean FRAMES = true;
    static final boolean RESIZE = true;
    static final boolean SIGNATURES = true;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    static final boolean WRITER = true;

    /* renamed from: b */
    public final byte[] f43240b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private final String[] strings;

    public ClassReader(byte[] b) {
        this(b, 0, b.length);
    }

    public ClassReader(byte[] b, int off, int len) {
        int size;
        this.f43240b = b;
        if (readShort(off + 6) <= 52) {
            this.items = new int[readUnsignedShort(off + 8)];
            int n = this.items.length;
            this.strings = new String[n];
            int max = 0;
            int index = off + 10;
            int i = 1;
            while (i < n) {
                this.items[i] = index + 1;
                byte b2 = b[index];
                if (b2 == 1) {
                    size = readUnsignedShort(index + 1) + 3;
                    if (size > max) {
                        max = size;
                    }
                } else if (b2 != 15) {
                    if (!(b2 == 18 || b2 == 3 || b2 == 4)) {
                        if (b2 == 5 || b2 == 6) {
                            size = 9;
                            i++;
                        } else {
                            switch (b2) {
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                    break;
                                default:
                                    size = 3;
                                    continue;
                            }
                        }
                    }
                    size = 5;
                } else {
                    size = 4;
                }
                index += size;
                i++;
            }
            this.maxStringLength = max;
            this.header = index;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public String[] getInterfaces() {
        int index = this.header + 6;
        int n = readUnsignedShort(index);
        String[] interfaces = new String[n];
        if (n > 0) {
            char[] buf = new char[this.maxStringLength];
            for (int i = 0; i < n; i++) {
                index += 2;
                interfaces[i] = readClass(index, buf);
            }
        }
        return interfaces;
    }

    /* access modifiers changed from: 0000 */
    public void copyPool(ClassWriter classWriter) {
        char[] buf = new char[this.maxStringLength];
        int ll = this.items.length;
        Item[] items2 = new Item[ll];
        int i = 1;
        while (i < ll) {
            int index = this.items[i];
            byte tag = this.f43240b[index - 1];
            Item item = new Item(i);
            if (tag == 1) {
                String[] strArr = this.strings;
                String s = strArr[i];
                if (s == null) {
                    int index2 = this.items[i];
                    String readUTF = readUTF(index2 + 2, readUnsignedShort(index2), buf);
                    strArr[i] = readUTF;
                    s = readUTF;
                }
                item.set(tag, s, null, null);
            } else if (tag == 15) {
                int fieldOrMethodRef = this.items[readUnsignedShort(index + 1)];
                int nameType = this.items[readUnsignedShort(fieldOrMethodRef + 2)];
                item.set(readByte(index) + 20, readClass(fieldOrMethodRef, buf), readUTF8(nameType, buf), readUTF8(nameType + 2, buf));
            } else if (tag == 18) {
                if (classWriter.bootstrapMethods == null) {
                    copyBootstrapMethods(classWriter, items2, buf);
                }
                int nameType2 = this.items[readUnsignedShort(index + 2)];
                item.set(readUTF8(nameType2, buf), readUTF8(nameType2 + 2, buf), readUnsignedShort(index));
            } else if (tag == 3) {
                item.set(readInt(index));
            } else if (tag == 4) {
                item.set(Float.intBitsToFloat(readInt(index)));
            } else if (tag == 5) {
                item.set(readLong(index));
                i++;
            } else if (tag != 6) {
                switch (tag) {
                    case 9:
                    case 10:
                    case 11:
                        int nameType3 = this.items[readUnsignedShort(index + 2)];
                        item.set(tag, readClass(index, buf), readUTF8(nameType3, buf), readUTF8(nameType3 + 2, buf));
                        break;
                    case 12:
                        item.set(tag, readUTF8(index, buf), readUTF8(index + 2, buf), null);
                        break;
                    default:
                        item.set(tag, readUTF8(index, buf), null, null);
                        break;
                }
            } else {
                item.set(Double.longBitsToDouble(readLong(index)));
                i++;
            }
            int index22 = item.hashCode % items2.length;
            item.next = items2[index22];
            items2[index22] = item;
            i++;
        }
        int off = this.items[1] - 1;
        classWriter.pool.putByteArray(this.f43240b, off, this.header - off);
        classWriter.items = items2;
        double d = (double) ll;
        Double.isNaN(d);
        classWriter.threshold = (int) (d * 0.75d);
        classWriter.index = ll;
    }

    private void copyBootstrapMethods(ClassWriter classWriter, Item[] items2, char[] c) {
        int u = getAttributes();
        boolean found = false;
        int i = readUnsignedShort(u);
        while (true) {
            if (i <= 0) {
                break;
            }
            if ("BootstrapMethods".equals(readUTF8(u + 2, c))) {
                found = true;
                break;
            } else {
                u += readInt(u + 4) + 6;
                i--;
            }
        }
        if (found) {
            int boostrapMethodCount = readUnsignedShort(u + 8);
            int v = u + 10;
            for (int j = 0; j < boostrapMethodCount; j++) {
                int position = (v - u) - 10;
                int hashCode = readConst(readUnsignedShort(v), c).hashCode();
                for (int k = readUnsignedShort(v + 2); k > 0; k--) {
                    hashCode ^= readConst(readUnsignedShort(v + 4), c).hashCode();
                    v += 2;
                }
                v += 4;
                Item item = new Item(j);
                item.set(position, Integer.MAX_VALUE & hashCode);
                int index = item.hashCode % items2.length;
                item.next = items2[index];
                items2[index] = item;
            }
            int attrSize = readInt(u + 4);
            ByteVector bootstrapMethods = new ByteVector(attrSize + 62);
            bootstrapMethods.putByteArray(this.f43240b, u + 10, attrSize - 2);
            classWriter.bootstrapMethodsCount = boostrapMethodCount;
            classWriter.bootstrapMethods = bootstrapMethods;
        }
    }

    public ClassReader(InputStream is) throws IOException {
        this(readClass(is, false));
    }

    public ClassReader(String name) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(name.replace('.', '/'));
        sb.append(".class");
        this(readClass(ClassLoader.getSystemResourceAsStream(sb.toString()), true));
    }

    private static byte[] readClass(InputStream is, boolean close) throws IOException {
        if (is != null) {
            try {
                byte[] b = new byte[is.available()];
                int len = 0;
                while (true) {
                    int n = is.read(b, len, b.length - len);
                    if (n == -1) {
                        if (len < b.length) {
                            byte[] c = new byte[len];
                            System.arraycopy(b, 0, c, 0, len);
                            b = c;
                        }
                        if (close) {
                            is.close();
                        }
                        return b;
                    }
                    len += n;
                    if (len == b.length) {
                        int last = is.read();
                        if (last < 0) {
                            return b;
                        }
                        byte[] c2 = new byte[(b.length + 1000)];
                        System.arraycopy(b, 0, c2, 0, len);
                        int len2 = len + 1;
                        c2[len] = (byte) last;
                        b = c2;
                        len = len2;
                    }
                }
            } finally {
                if (close) {
                    is.close();
                }
            }
        } else {
            throw new IOException("Class not found");
        }
    }

    public void accept(ClassVisitor classVisitor, int flags) {
        accept(classVisitor, new Attribute[0], flags);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0289, code lost:
        if (r4 != null) goto L_0x028e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accept(org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassVisitor r40, org.jacoco.agent.p025rt.internal_8ff85ea.asm.Attribute[] r41, int r42) {
        /*
            r39 = this;
            r8 = r39
            r9 = r40
            r10 = r42
            int r0 = r8.header
            int r1 = r8.maxStringLength
            char[] r11 = new char[r1]
            org.jacoco.agent.rt.internal_8ff85ea.asm.Context r1 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Context
            r1.<init>()
            r12 = r1
            r13 = r41
            r12.attrs = r13
            r12.flags = r10
            r12.buffer = r11
            int r1 = r8.readUnsignedShort(r0)
            int r2 = r0 + 2
            java.lang.String r14 = r8.readClass(r2, r11)
            int r2 = r0 + 4
            java.lang.String r15 = r8.readClass(r2, r11)
            int r2 = r0 + 6
            int r2 = r8.readUnsignedShort(r2)
            java.lang.String[] r7 = new java.lang.String[r2]
            int r0 = r0 + 8
            r2 = 0
        L_0x0035:
            int r3 = r7.length
            if (r2 >= r3) goto L_0x0043
            java.lang.String r3 = r8.readClass(r0, r11)
            r7[r2] = r3
            int r0 = r0 + 2
            int r2 = r2 + 1
            goto L_0x0035
        L_0x0043:
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            int r0 = r39.getAttributes()
            int r23 = r8.readUnsignedShort(r0)
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r22
            r18 = r0
            r0 = r6
            r6 = r3
            r3 = r16
            r16 = r1
            r1 = r5
            r5 = r4
            r4 = r21
            r38 = r17
            r17 = r2
            r2 = r38
        L_0x0078:
            r19 = r7
            if (r23 <= 0) goto L_0x0258
            int r7 = r18 + 2
            java.lang.String r7 = r8.readUTF8(r7, r11)
            r21 = r0
            java.lang.String r0 = "SourceFile"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x009b
            int r0 = r18 + 8
            java.lang.String r0 = r8.readUTF8(r0, r11)
            r6 = r0
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x009b:
            java.lang.String r0 = "InnerClasses"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00ae
            int r0 = r18 + 8
            r4 = r0
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x00ae:
            java.lang.String r0 = "EnclosingMethod"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00e7
            int r0 = r18 + 8
            java.lang.String r0 = r8.readClass(r0, r11)
            int r1 = r18 + 10
            int r1 = r8.readUnsignedShort(r1)
            if (r1 == 0) goto L_0x00db
            r20 = r0
            int[] r0 = r8.items
            r0 = r0[r1]
            java.lang.String r0 = r8.readUTF8(r0, r11)
            r21 = r0
            int[] r0 = r8.items
            r0 = r0[r1]
            int r0 = r0 + 2
            java.lang.String r3 = r8.readUTF8(r0, r11)
            goto L_0x00dd
        L_0x00db:
            r20 = r0
        L_0x00dd:
            r1 = r20
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x00e7:
            java.lang.String r0 = "Signature"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00fd
            int r0 = r18 + 8
            java.lang.String r17 = r8.readUTF8(r0, r11)
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x00fd:
            java.lang.String r0 = "RuntimeVisibleAnnotations"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0111
            int r0 = r18 + 8
            r2 = r0
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x0111:
            java.lang.String r0 = "RuntimeVisibleTypeAnnotations"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0126
            int r0 = r18 + 8
            r25 = r0
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x0126:
            java.lang.String r0 = "Deprecated"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x013a
            r0 = 131072(0x20000, float:1.83671E-40)
            r16 = r16 | r0
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x013a:
            java.lang.String r0 = "Synthetic"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x014f
            r0 = 266240(0x41000, float:3.73082E-40)
            r16 = r16 | r0
            r0 = r21
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x014f:
            java.lang.String r0 = "SourceDebugExtension"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0176
            int r0 = r18 + 4
            int r0 = r8.readInt(r0)
            r22 = r1
            int r1 = r18 + 8
            r28 = r2
            char[] r2 = new char[r0]
            java.lang.String r0 = r8.readUTF(r1, r0, r2)
            r5 = r0
            r0 = r21
            r1 = r22
            r2 = r28
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x0176:
            r22 = r1
            r28 = r2
            java.lang.String r0 = "RuntimeInvisibleAnnotations"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0192
            int r0 = r18 + 8
            r24 = r0
            r0 = r21
            r1 = r22
            r2 = r28
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x0192:
            java.lang.String r0 = "RuntimeInvisibleTypeAnnotations"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x01ab
            int r0 = r18 + 8
            r26 = r0
            r0 = r21
            r1 = r22
            r2 = r28
            r21 = r19
            r19 = r7
            goto L_0x0246
        L_0x01ab:
            java.lang.String r0 = "BootstrapMethods"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x01ed
            int r0 = r18 + 8
            int r0 = r8.readUnsignedShort(r0)
            int[] r0 = new int[r0]
            r1 = 0
            int r2 = r18 + 10
        L_0x01be:
            r29 = r3
            int r3 = r0.length
            if (r1 >= r3) goto L_0x01d7
            r0[r1] = r2
            int r3 = r2 + 2
            int r3 = r8.readUnsignedShort(r3)
            int r3 = r3 + 2
            r20 = 1
            int r3 = r3 << 1
            int r2 = r2 + r3
            int r1 = r1 + 1
            r3 = r29
            goto L_0x01be
        L_0x01d7:
            r12.bootstrapMethods = r0
            r36 = r4
            r37 = r5
            r13 = r6
            r34 = r21
            r32 = r22
            r33 = r28
            r35 = r29
            r21 = r19
            r19 = r7
            r7 = r27
            goto L_0x0237
        L_0x01ed:
            r29 = r3
            int r3 = r18 + 8
            int r0 = r18 + 4
            int r20 = r8.readInt(r0)
            r30 = -1
            r31 = 0
            r2 = r21
            r0 = r39
            r32 = r22
            r1 = r41
            r34 = r2
            r33 = r28
            r2 = r7
            r35 = r29
            r36 = r4
            r4 = r20
            r37 = r5
            r5 = r11
            r13 = r6
            r6 = r30
            r21 = r19
            r19 = r7
            r7 = r31
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r0 = r0.readAttribute(r1, r2, r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x0235
            r7 = r27
            r0.next = r7
            r1 = r0
            r27 = r1
            r6 = r13
            r1 = r32
            r2 = r33
            r0 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            goto L_0x0246
        L_0x0235:
            r7 = r27
        L_0x0237:
            r27 = r7
            r6 = r13
            r1 = r32
            r2 = r33
            r0 = r34
            r3 = r35
            r4 = r36
            r5 = r37
        L_0x0246:
            int r7 = r18 + 4
            int r7 = r8.readInt(r7)
            int r7 = r7 + 6
            int r18 = r18 + r7
            int r23 = r23 + -1
            r13 = r41
            r7 = r21
            goto L_0x0078
        L_0x0258:
            r34 = r0
            r32 = r1
            r33 = r2
            r35 = r3
            r36 = r4
            r37 = r5
            r13 = r6
            r21 = r19
            r7 = r27
            int[] r0 = r8.items
            r1 = 1
            r0 = r0[r1]
            int r0 = r0 + -7
            int r1 = r8.readInt(r0)
            r0 = r40
            r2 = r16
            r3 = r14
            r4 = r17
            r5 = r15
            r6 = r21
            r0.visit(r1, r2, r3, r4, r5, r6)
            r0 = r10 & 2
            if (r0 != 0) goto L_0x0292
            if (r13 != 0) goto L_0x028c
            r4 = r37
            if (r4 == 0) goto L_0x0294
            goto L_0x028e
        L_0x028c:
            r4 = r37
        L_0x028e:
            r9.visitSource(r13, r4)
            goto L_0x0294
        L_0x0292:
            r4 = r37
        L_0x0294:
            r1 = r32
            if (r1 == 0) goto L_0x02a0
            r0 = r34
            r3 = r35
            r9.visitOuterClass(r1, r0, r3)
            goto L_0x02a4
        L_0x02a0:
            r0 = r34
            r3 = r35
        L_0x02a4:
            r2 = r33
            if (r2 == 0) goto L_0x02d5
            int r5 = r8.readUnsignedShort(r2)
            int r6 = r2 + 2
        L_0x02ae:
            if (r5 <= 0) goto L_0x02ce
            r34 = r0
            int r0 = r6 + 2
            r32 = r1
            java.lang.String r1 = r8.readUTF8(r6, r11)
            r33 = r2
            r2 = 1
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r1 = r9.visitAnnotation(r1, r2)
            int r6 = r8.readAnnotationValues(r0, r11, r2, r1)
            int r5 = r5 + -1
            r1 = r32
            r2 = r33
            r0 = r34
            goto L_0x02ae
        L_0x02ce:
            r34 = r0
            r32 = r1
            r33 = r2
            goto L_0x02db
        L_0x02d5:
            r34 = r0
            r32 = r1
            r33 = r2
        L_0x02db:
            r0 = 0
            r1 = r24
            if (r1 == 0) goto L_0x0304
            int r2 = r8.readUnsignedShort(r1)
            int r24 = r1 + 2
            r5 = r24
        L_0x02e8:
            if (r2 <= 0) goto L_0x0301
            int r6 = r5 + 2
            r19 = r1
            java.lang.String r1 = r8.readUTF8(r5, r11)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r1 = r9.visitAnnotation(r1, r0)
            r0 = 1
            int r5 = r8.readAnnotationValues(r6, r11, r0, r1)
            int r2 = r2 + -1
            r1 = r19
            r0 = 0
            goto L_0x02e8
        L_0x0301:
            r19 = r1
            goto L_0x0306
        L_0x0304:
            r19 = r1
        L_0x0306:
            r0 = r25
            if (r0 == 0) goto L_0x033e
            int r1 = r8.readUnsignedShort(r0)
            int r25 = r0 + 2
            r2 = r25
        L_0x0312:
            if (r1 <= 0) goto L_0x0339
            int r2 = r8.readAnnotationTarget(r12, r2)
            int r5 = r2 + 2
            int r6 = r12.typeRef
            r23 = r0
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r0 = r12.typePath
            r35 = r3
            java.lang.String r3 = r8.readUTF8(r2, r11)
            r24 = r2
            r2 = 1
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r0 = r9.visitTypeAnnotation(r6, r0, r3, r2)
            int r0 = r8.readAnnotationValues(r5, r11, r2, r0)
            int r1 = r1 + -1
            r2 = r0
            r0 = r23
            r3 = r35
            goto L_0x0312
        L_0x0339:
            r23 = r0
            r35 = r3
            goto L_0x0342
        L_0x033e:
            r23 = r0
            r35 = r3
        L_0x0342:
            r0 = r26
            if (r0 == 0) goto L_0x0376
            int r1 = r8.readUnsignedShort(r0)
            int r26 = r0 + 2
            r2 = r26
        L_0x034e:
            if (r1 <= 0) goto L_0x0372
            int r2 = r8.readAnnotationTarget(r12, r2)
            int r3 = r2 + 2
            int r5 = r12.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r6 = r12.typePath
            r24 = r0
            java.lang.String r0 = r8.readUTF8(r2, r11)
            r25 = r2
            r2 = 0
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r0 = r9.visitTypeAnnotation(r5, r6, r0, r2)
            r5 = 1
            int r0 = r8.readAnnotationValues(r3, r11, r5, r0)
            int r1 = r1 + -1
            r2 = r0
            r0 = r24
            goto L_0x034e
        L_0x0372:
            r24 = r0
            r0 = r2
            goto L_0x0378
        L_0x0376:
            r24 = r0
        L_0x0378:
            if (r7 == 0) goto L_0x0384
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r0 = r7.next
            r1 = 0
            r7.next = r1
            r9.visitAttribute(r7)
            r7 = r0
            goto L_0x0378
        L_0x0384:
            r0 = r36
            if (r0 == 0) goto L_0x03b5
            int r1 = r0 + 2
            int r2 = r8.readUnsignedShort(r0)
        L_0x038e:
            if (r2 <= 0) goto L_0x03b2
            java.lang.String r3 = r8.readClass(r1, r11)
            int r5 = r1 + 2
            java.lang.String r5 = r8.readClass(r5, r11)
            int r6 = r1 + 4
            java.lang.String r6 = r8.readUTF8(r6, r11)
            r36 = r0
            int r0 = r1 + 6
            int r0 = r8.readUnsignedShort(r0)
            r9.visitInnerClass(r3, r5, r6, r0)
            int r1 = r1 + 8
            int r2 = r2 + -1
            r0 = r36
            goto L_0x038e
        L_0x03b2:
            r36 = r0
            goto L_0x03b7
        L_0x03b5:
            r36 = r0
        L_0x03b7:
            int r0 = r8.header
            int r0 = r0 + 10
            r1 = r21
            int r2 = r1.length
            int r2 = r2 * 2
            int r0 = r0 + r2
            int r2 = r0 + -2
            int r2 = r8.readUnsignedShort(r2)
        L_0x03c7:
            if (r2 <= 0) goto L_0x03d0
            int r0 = r8.readField(r9, r12, r0)
            int r2 = r2 + -1
            goto L_0x03c7
        L_0x03d0:
            int r0 = r0 + 2
            int r2 = r0 + -2
            int r2 = r8.readUnsignedShort(r2)
        L_0x03d8:
            if (r2 <= 0) goto L_0x03e1
            int r0 = r8.readMethod(r9, r12, r0)
            int r2 = r2 + -1
            goto L_0x03d8
        L_0x03e1:
            r40.visitEnd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassReader.accept(org.jacoco.agent.rt.internal_8ff85ea.asm.ClassVisitor, org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute[], int):void");
    }

    private int readField(ClassVisitor classVisitor, Context context, int u) {
        Context context2;
        Context context3 = context;
        int i = u;
        char[] c = context3.buffer;
        int access = readUnsignedShort(i);
        String name = readUTF8(i + 2, c);
        String desc = readUTF8(i + 4, c);
        int u2 = i + 6;
        int itanns = 0;
        int i2 = readUnsignedShort(u2);
        int access2 = access;
        String signature = null;
        int anns = 0;
        int ianns = 0;
        Object value = null;
        Attribute attributes = null;
        int u3 = u2;
        int tanns = 0;
        while (i2 > 0) {
            String attrName = readUTF8(u3 + 2, c);
            if ("ConstantValue".equals(attrName)) {
                int item = readUnsignedShort(u3 + 8);
                value = item == 0 ? null : readConst(item, c);
                String str = attrName;
            } else if ("Signature".equals(attrName)) {
                signature = readUTF8(u3 + 8, c);
                String str2 = attrName;
            } else if ("Deprecated".equals(attrName)) {
                access2 |= Opcodes.ACC_DEPRECATED;
                String str3 = attrName;
            } else if ("Synthetic".equals(attrName)) {
                access2 |= 266240;
                String str4 = attrName;
            } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                anns = u3 + 8;
                String str5 = attrName;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = u3 + 8;
                String str6 = attrName;
            } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                ianns = u3 + 8;
                String str7 = attrName;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = u3 + 8;
                String str8 = attrName;
            } else {
                String str9 = attrName;
                int itanns2 = itanns;
                int tanns2 = tanns;
                Attribute attr = readAttribute(context3.attrs, attrName, u3 + 8, readInt(u3 + 4), c, -1, null);
                if (attr != null) {
                    attr.next = attributes;
                    attributes = attr;
                    tanns = tanns2;
                    itanns = itanns2;
                } else {
                    tanns = tanns2;
                    itanns = itanns2;
                }
            }
            u3 += readInt(u3 + 4) + 6;
            i2--;
            context3 = context;
        }
        int itanns3 = itanns;
        int tanns3 = tanns;
        int u4 = u3 + 2;
        int ianns2 = ianns;
        Attribute attributes2 = attributes;
        int anns2 = anns;
        FieldVisitor fv = classVisitor.visitField(access2, name, desc, signature, value);
        if (fv == null) {
            return u4;
        }
        if (anns2 != 0) {
            int v = anns2 + 2;
            for (int i3 = readUnsignedShort(anns2); i3 > 0; i3--) {
                v = readAnnotationValues(v + 2, c, true, fv.visitAnnotation(readUTF8(v, c), true));
            }
        }
        if (ianns2 != 0) {
            int v2 = ianns2 + 2;
            for (int i4 = readUnsignedShort(ianns2); i4 > 0; i4--) {
                v2 = readAnnotationValues(v2 + 2, c, true, fv.visitAnnotation(readUTF8(v2, c), false));
            }
        }
        if (tanns3 != 0) {
            int i5 = readUnsignedShort(tanns3);
            int v3 = tanns3 + 2;
            while (i5 > 0) {
                int tanns4 = tanns3;
                Context context4 = context;
                int v4 = readAnnotationTarget(context4, v3);
                v3 = readAnnotationValues(v4 + 2, c, true, fv.visitTypeAnnotation(context4.typeRef, context4.typePath, readUTF8(v4, c), true));
                i5--;
                tanns3 = tanns4;
            }
            context2 = context;
        } else {
            context2 = context;
        }
        int itanns4 = itanns3;
        if (itanns4 != 0) {
            int i6 = readUnsignedShort(itanns4);
            int v5 = itanns4 + 2;
            while (i6 > 0) {
                int v6 = readAnnotationTarget(context2, v5);
                int itanns5 = itanns4;
                v5 = readAnnotationValues(v6 + 2, c, true, fv.visitTypeAnnotation(context2.typeRef, context2.typePath, readUTF8(v6, c), false));
                i6--;
                itanns4 = itanns5;
            }
        }
        while (attributes2 != null) {
            Attribute attr2 = attributes2.next;
            attributes2.next = null;
            fv.visitAttribute(attributes2);
            attributes2 = attr2;
        }
        fv.visitEnd();
        return u4;
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int u) {
        int firstAttribute;
        int tanns;
        int itanns;
        int dann;
        int impanns;
        int mpanns;
        int ianns;
        int impanns2;
        int code;
        int dann2;
        Context context2 = context;
        int i = u;
        char[] c = context2.buffer;
        context2.access = readUnsignedShort(i);
        context2.name = readUTF8(i + 2, c);
        context2.desc = readUTF8(i + 4, c);
        int u2 = i + 6;
        int firstAttribute2 = u2;
        int methodParameters = 0;
        int tanns2 = 0;
        int u3 = u2;
        int code2 = 0;
        int impanns3 = 0;
        int exception = 0;
        int exception2 = 0;
        Attribute attributes = null;
        String[] exceptions = null;
        int dann3 = 0;
        String signature = null;
        int itanns2 = 0;
        int anns = 0;
        int ianns2 = 0;
        for (int i2 = readUnsignedShort(u2); i2 > 0; i2--) {
            String attrName = readUTF8(u3 + 2, c);
            int impanns4 = impanns3;
            if (!"Code".equals(attrName)) {
                if ("Exceptions".equals(attrName)) {
                    String[] exceptions2 = new String[readUnsignedShort(u3 + 8)];
                    int mpanns2 = exception2;
                    int exception3 = u3 + 10;
                    int j = 0;
                    while (true) {
                        dann2 = dann3;
                        if (j >= exceptions2.length) {
                            break;
                        }
                        exceptions2[j] = readClass(exception3, c);
                        exception3 += 2;
                        j++;
                        dann3 = dann2;
                    }
                    String str = attrName;
                    exceptions = exceptions2;
                    exception = exception3;
                    impanns3 = impanns4;
                    exception2 = mpanns2;
                    dann3 = dann2;
                } else {
                    int mpanns3 = exception2;
                    int dann4 = dann3;
                    if ("Signature".equals(attrName)) {
                        String str2 = attrName;
                        signature = readUTF8(u3 + 8, c);
                        impanns3 = impanns4;
                        exception2 = mpanns3;
                        dann3 = dann4;
                    } else if ("Deprecated".equals(attrName)) {
                        context2.access |= Opcodes.ACC_DEPRECATED;
                        String str3 = attrName;
                        itanns = itanns2;
                        tanns = tanns2;
                        impanns = impanns4;
                        mpanns = mpanns3;
                        dann = dann4;
                        ianns = ianns2;
                        impanns2 = code2;
                        code = anns;
                    } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                        String str4 = attrName;
                        anns = u3 + 8;
                        impanns3 = impanns4;
                        exception2 = mpanns3;
                        dann3 = dann4;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                        String str5 = attrName;
                        tanns2 = u3 + 8;
                        impanns3 = impanns4;
                        exception2 = mpanns3;
                        dann3 = dann4;
                    } else if ("AnnotationDefault".equals(attrName)) {
                        String str6 = attrName;
                        dann3 = u3 + 8;
                        impanns3 = impanns4;
                        exception2 = mpanns3;
                    } else if ("Synthetic".equals(attrName)) {
                        context2.access |= 266240;
                        String str7 = attrName;
                        itanns = itanns2;
                        tanns = tanns2;
                        impanns = impanns4;
                        mpanns = mpanns3;
                        dann = dann4;
                        ianns = ianns2;
                        impanns2 = code2;
                        code = anns;
                    } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                        String str8 = attrName;
                        ianns2 = u3 + 8;
                        impanns3 = impanns4;
                        exception2 = mpanns3;
                        dann3 = dann4;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                        String str9 = attrName;
                        itanns2 = u3 + 8;
                        impanns3 = impanns4;
                        exception2 = mpanns3;
                        dann3 = dann4;
                    } else if ("RuntimeVisibleParameterAnnotations".equals(attrName)) {
                        String str10 = attrName;
                        exception2 = u3 + 8;
                        impanns3 = impanns4;
                        dann3 = dann4;
                    } else if ("RuntimeInvisibleParameterAnnotations".equals(attrName)) {
                        impanns3 = u3 + 8;
                        String str11 = attrName;
                        exception2 = mpanns3;
                        dann3 = dann4;
                    } else if ("MethodParameters".equals(attrName)) {
                        String str12 = attrName;
                        methodParameters = u3 + 8;
                        impanns3 = impanns4;
                        exception2 = mpanns3;
                        dann3 = dann4;
                    } else {
                        impanns = impanns4;
                        mpanns = mpanns3;
                        dann = dann4;
                        itanns = itanns2;
                        tanns = tanns2;
                        impanns2 = code2;
                        ianns = ianns2;
                        code = anns;
                        Attribute attr = readAttribute(context2.attrs, attrName, u3 + 8, readInt(u3 + 4), c, -1, null);
                        if (attr != null) {
                            attr.next = attributes;
                            attributes = attr;
                            anns = code;
                            code2 = impanns2;
                            ianns2 = ianns;
                            exception2 = mpanns;
                            impanns3 = impanns;
                            dann3 = dann;
                            itanns2 = itanns;
                            tanns2 = tanns;
                        }
                    }
                }
                u3 += readInt(u3 + 4) + 6;
            } else if ((context2.flags & 1) == 0) {
                String str13 = attrName;
                code2 = u3 + 8;
                impanns3 = impanns4;
                u3 += readInt(u3 + 4) + 6;
            } else {
                String str14 = attrName;
                mpanns = exception2;
                dann = dann3;
                itanns = itanns2;
                tanns = tanns2;
                ianns = ianns2;
                impanns = impanns4;
                impanns2 = code2;
                code = anns;
            }
            anns = code;
            code2 = impanns2;
            ianns2 = ianns;
            exception2 = mpanns;
            impanns3 = impanns;
            dann3 = dann;
            itanns2 = itanns;
            tanns2 = tanns;
            u3 += readInt(u3 + 4) + 6;
        }
        int impanns5 = impanns3;
        int mpanns4 = exception2;
        int dann5 = dann3;
        int itanns3 = itanns2;
        int tanns3 = tanns2;
        int ianns3 = ianns2;
        int code3 = code2;
        int code4 = anns;
        int u4 = u3 + 2;
        MethodVisitor mv = classVisitor.visitMethod(context2.access, context2.name, context2.desc, signature, exceptions);
        if (mv == null) {
            return u4;
        }
        if (mv instanceof MethodWriter) {
            MethodWriter mw = (MethodWriter) mv;
            if (mw.f43245cw.f43242cr == this && signature == mw.signature) {
                boolean sameExceptions = false;
                if (exceptions == null) {
                    sameExceptions = mw.exceptionCount == 0;
                } else if (exceptions.length == mw.exceptionCount) {
                    sameExceptions = true;
                    int j2 = exceptions.length - 1;
                    while (true) {
                        if (j2 < 0) {
                            break;
                        }
                        int exception4 = exception - 2;
                        if (mw.exceptions[j2] != readUnsignedShort(exception4)) {
                            sameExceptions = false;
                            int i3 = exception4;
                            break;
                        }
                        j2--;
                        exception = exception4;
                    }
                }
                if (sameExceptions) {
                    int firstAttribute3 = firstAttribute2;
                    mw.classReaderOffset = firstAttribute3;
                    mw.classReaderLength = u4 - firstAttribute3;
                    return u4;
                }
                firstAttribute = firstAttribute2;
            } else {
                firstAttribute = firstAttribute2;
            }
        } else {
            firstAttribute = firstAttribute2;
        }
        if (methodParameters != 0) {
            int i4 = this.f43240b[methodParameters] & 255;
            int v = methodParameters + 1;
            while (i4 > 0) {
                mv.visitParameter(readUTF8(v, c), readUnsignedShort(v + 2));
                i4--;
                v += 4;
            }
        }
        int v2 = dann5;
        if (v2 != 0) {
            AnnotationVisitor dv = mv.visitAnnotationDefault();
            readAnnotationValue(v2, c, null, dv);
            if (dv != null) {
                dv.visitEnd();
            }
        }
        if (code4 != 0) {
            int v3 = code4 + 2;
            for (int i5 = readUnsignedShort(code4); i5 > 0; i5--) {
                v3 = readAnnotationValues(v3 + 2, c, true, mv.visitAnnotation(readUTF8(v3, c), true));
            }
        }
        if (ianns3 != 0) {
            int ianns4 = ianns3;
            int i6 = readUnsignedShort(ianns4);
            int v4 = ianns4 + 2;
            while (i6 > 0) {
                int firstAttribute4 = firstAttribute;
                v4 = readAnnotationValues(v4 + 2, c, true, mv.visitAnnotation(readUTF8(v4, c), false));
                i6--;
                firstAttribute = firstAttribute4;
            }
        } else {
            int ianns5 = firstAttribute;
        }
        int tanns4 = tanns3;
        if (tanns4 != 0) {
            int i7 = readUnsignedShort(tanns4);
            int v5 = tanns4 + 2;
            while (i7 > 0) {
                int v6 = readAnnotationTarget(context2, v5);
                int dann6 = v2;
                int tanns5 = tanns4;
                int i8 = v6;
                i7--;
                v5 = readAnnotationValues(v6 + 2, c, true, mv.visitTypeAnnotation(context2.typeRef, context2.typePath, readUTF8(v6, c), true));
                v2 = dann6;
                tanns4 = tanns5;
            }
            int dann7 = v2;
            int i9 = tanns4;
        } else {
            int dann8 = v2;
            int i10 = tanns4;
        }
        int itanns4 = itanns3;
        if (itanns4 != 0) {
            int i11 = readUnsignedShort(itanns4);
            int v7 = itanns4 + 2;
            while (i11 > 0) {
                int v8 = readAnnotationTarget(context2, v7);
                int itanns5 = itanns4;
                int i12 = v8;
                i11--;
                v7 = readAnnotationValues(v8 + 2, c, true, mv.visitTypeAnnotation(context2.typeRef, context2.typePath, readUTF8(v8, c), false));
                itanns4 = itanns5;
            }
        }
        int mpanns5 = mpanns4;
        if (mpanns5 != 0) {
            readParameterAnnotations(mv, context2, mpanns5, true);
        }
        int impanns6 = impanns5;
        if (impanns6 != 0) {
            readParameterAnnotations(mv, context2, impanns6, false);
        }
        while (attributes != null) {
            Attribute attr2 = attributes.next;
            attributes.next = null;
            mv.visitAttribute(attributes);
            attributes = attr2;
        }
        if (code3 != 0) {
            mv.visitCode();
            readCode(mv, context2, code3);
        }
        mv.visitEnd();
        return u4;
    }

    /* JADX WARNING: type inference failed for: r4v27 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r4v90 */
    /* JADX WARNING: type inference failed for: r4v91 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v27
      assigns: []
      uses: []
      mth insns count: 1364
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readCode(org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor r48, org.jacoco.agent.p025rt.internal_8ff85ea.asm.Context r49, int r50) {
        /*
            r47 = this;
            r7 = r47
            r15 = r48
            r14 = r49
            r0 = r50
            byte[] r13 = r7.f43240b
            char[] r12 = r14.buffer
            int r11 = r7.readUnsignedShort(r0)
            int r1 = r0 + 2
            int r10 = r7.readUnsignedShort(r1)
            int r1 = r0 + 4
            int r9 = r7.readInt(r1)
            r8 = 8
            int r0 = r0 + r8
            r16 = r0
            int r6 = r0 + r9
            int r1 = r9 + 2
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r1 = new org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label[r1]
            r14.labels = r1
            r5 = r1
            int r1 = r9 + 1
            r7.readLabel(r1, r5)
        L_0x002f:
            r4 = 132(0x84, float:1.85E-43)
            r3 = 1
            if (r0 >= r6) goto L_0x00e6
            int r1 = r0 - r16
            byte r2 = r13[r0]
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r17 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassWriter.TYPE
            byte r17 = r17[r2]
            switch(r17) {
                case 0: goto L_0x00df;
                case 1: goto L_0x00dc;
                case 2: goto L_0x00d9;
                case 3: goto L_0x00dc;
                case 4: goto L_0x00df;
                case 5: goto L_0x00d9;
                case 6: goto L_0x00d9;
                case 7: goto L_0x00d6;
                case 8: goto L_0x00d6;
                case 9: goto L_0x00c9;
                case 10: goto L_0x00bc;
                case 11: goto L_0x00dc;
                case 12: goto L_0x00d9;
                case 13: goto L_0x00d9;
                case 14: goto L_0x008b;
                case 15: goto L_0x0063;
                case 16: goto L_0x0041;
                case 17: goto L_0x0053;
                case 18: goto L_0x0045;
                default: goto L_0x0041;
            }
        L_0x0041:
            int r0 = r0 + 4
            goto L_0x00e2
        L_0x0045:
            int r3 = r0 + 1
            int r3 = r7.readUnsignedShort(r3)
            int r3 = r3 + r1
            r7.readLabel(r3, r5)
            int r0 = r0 + 3
            goto L_0x00e2
        L_0x0053:
            int r3 = r0 + 1
            byte r3 = r13[r3]
            r2 = r3 & 255(0xff, float:3.57E-43)
            if (r2 != r4) goto L_0x005f
            int r0 = r0 + 6
            goto L_0x00e2
        L_0x005f:
            int r0 = r0 + 4
            goto L_0x00e2
        L_0x0063:
            int r3 = r0 + 4
            r4 = r1 & 3
            int r3 = r3 - r4
            int r0 = r7.readInt(r3)
            int r0 = r0 + r1
            r7.readLabel(r0, r5)
            int r0 = r3 + 4
            int r0 = r7.readInt(r0)
        L_0x0076:
            if (r0 <= 0) goto L_0x0087
            int r4 = r3 + 12
            int r4 = r7.readInt(r4)
            int r4 = r4 + r1
            r7.readLabel(r4, r5)
            int r3 = r3 + 8
            int r0 = r0 + -1
            goto L_0x0076
        L_0x0087:
            int r3 = r3 + 8
            r0 = r3
            goto L_0x00e2
        L_0x008b:
            int r4 = r0 + 4
            r17 = r1 & 3
            int r4 = r4 - r17
            int r0 = r7.readInt(r4)
            int r0 = r0 + r1
            r7.readLabel(r0, r5)
            int r0 = r4 + 8
            int r0 = r7.readInt(r0)
            int r8 = r4 + 4
            int r8 = r7.readInt(r8)
            int r0 = r0 - r8
            int r0 = r0 + r3
        L_0x00a7:
            if (r0 <= 0) goto L_0x00b8
            int r3 = r4 + 12
            int r3 = r7.readInt(r3)
            int r3 = r3 + r1
            r7.readLabel(r3, r5)
            int r4 = r4 + 4
            int r0 = r0 + -1
            goto L_0x00a7
        L_0x00b8:
            int r4 = r4 + 12
            r0 = r4
            goto L_0x00e2
        L_0x00bc:
            int r3 = r0 + 1
            int r3 = r7.readInt(r3)
            int r3 = r3 + r1
            r7.readLabel(r3, r5)
            int r0 = r0 + 5
            goto L_0x00e2
        L_0x00c9:
            int r3 = r0 + 1
            short r3 = r7.readShort(r3)
            int r3 = r3 + r1
            r7.readLabel(r3, r5)
            int r0 = r0 + 3
            goto L_0x00e2
        L_0x00d6:
            int r0 = r0 + 5
            goto L_0x00e2
        L_0x00d9:
            int r0 = r0 + 3
            goto L_0x00e2
        L_0x00dc:
            int r0 = r0 + 2
            goto L_0x00e2
        L_0x00df:
            int r0 = r0 + 1
        L_0x00e2:
            r8 = 8
            goto L_0x002f
        L_0x00e6:
            int r1 = r7.readUnsignedShort(r0)
        L_0x00ea:
            if (r1 <= 0) goto L_0x0128
            int r2 = r0 + 2
            int r2 = r7.readUnsignedShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r2 = r7.readLabel(r2, r5)
            int r8 = r0 + 4
            int r8 = r7.readUnsignedShort(r8)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r8 = r7.readLabel(r8, r5)
            int r4 = r0 + 6
            int r4 = r7.readUnsignedShort(r4)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r4 = r7.readLabel(r4, r5)
            int[] r3 = r7.items
            r19 = r6
            int r6 = r0 + 8
            int r6 = r7.readUnsignedShort(r6)
            r3 = r3[r6]
            java.lang.String r3 = r7.readUTF8(r3, r12)
            r15.visitTryCatchBlock(r2, r8, r4, r3)
            int r0 = r0 + 8
            int r1 = r1 + -1
            r6 = r19
            r3 = 1
            r4 = 132(0x84, float:1.85E-43)
            goto L_0x00ea
        L_0x0128:
            r19 = r6
            int r0 = r0 + 2
            r1 = 0
            r2 = 0
            r8 = 0
            r20 = 0
            r3 = -1
            r4 = -1
            r6 = 0
            r21 = 0
            r22 = 1
            r23 = r1
            int r1 = r14.flags
            r17 = 8
            r1 = r1 & 8
            r24 = r8
            if (r1 == 0) goto L_0x0146
            r1 = 1
            goto L_0x0147
        L_0x0146:
            r1 = 0
        L_0x0147:
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            int r30 = r7.readUnsignedShort(r0)
            r46 = r21
            r21 = r0
            r0 = r22
            r22 = r3
            r3 = r23
            r23 = r4
            r4 = r6
            r6 = r46
        L_0x0164:
            r31 = r4
            r32 = r3
            if (r30 <= 0) goto L_0x043c
            int r3 = r21 + 2
            java.lang.String r3 = r7.readUTF8(r3, r12)
            java.lang.String r4 = "LocalVariableTable"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x01ed
            int r4 = r14.flags
            r4 = r4 & 2
            if (r4 != 0) goto L_0x01e4
            int r4 = r21 + 8
            int r8 = r21 + 8
            int r8 = r7.readUnsignedShort(r8)
            r31 = r21
        L_0x0188:
            if (r8 <= 0) goto L_0x01ce
            r36 = r0
            int r0 = r31 + 10
            int r0 = r7.readUnsignedShort(r0)
            r33 = r5[r0]
            if (r33 != 0) goto L_0x01a7
            r37 = r1
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r7.readLabel(r0, r5)
            r38 = r2
            int r2 = r1.status
            r18 = 1
            r2 = r2 | 1
            r1.status = r2
            goto L_0x01ab
        L_0x01a7:
            r37 = r1
            r38 = r2
        L_0x01ab:
            int r1 = r31 + 12
            int r1 = r7.readUnsignedShort(r1)
            int r0 = r0 + r1
            r1 = r5[r0]
            if (r1 != 0) goto L_0x01c2
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r7.readLabel(r0, r5)
            int r2 = r1.status
            r18 = 1
            r2 = r2 | 1
            r1.status = r2
        L_0x01c2:
            int r31 = r31 + 10
            int r8 = r8 + -1
            r0 = r36
            r1 = r37
            r2 = r38
            goto L_0x0188
        L_0x01ce:
            r36 = r0
            r37 = r1
            r38 = r2
            r18 = r3
            r50 = r5
            r34 = r9
            r31 = r12
            r12 = r19
            r3 = r32
            r15 = r37
            goto L_0x0423
        L_0x01e4:
            r36 = r0
            r37 = r1
            r38 = r2
            r4 = 1
            goto L_0x0365
        L_0x01ed:
            r36 = r0
            r37 = r1
            r38 = r2
            java.lang.String r0 = "LocalVariableTypeTable"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0214
            int r0 = r21 + 8
            r6 = r0
            r18 = r3
            r50 = r5
            r34 = r9
            r4 = r31
            r3 = r32
            r0 = r36
            r15 = r37
            r2 = r38
            r31 = r12
            r12 = r19
            goto L_0x0423
        L_0x0214:
            java.lang.String r0 = "LineNumberTable"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x026a
            int r0 = r14.flags
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0267
            int r0 = r21 + 8
            int r0 = r7.readUnsignedShort(r0)
            r1 = r21
        L_0x022a:
            if (r0 <= 0) goto L_0x0264
            int r2 = r1 + 10
            int r2 = r7.readUnsignedShort(r2)
            r4 = r5[r2]
            if (r4 != 0) goto L_0x0242
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r4 = r7.readLabel(r2, r5)
            int r8 = r4.status
            r18 = 1
            r8 = r8 | 1
            r4.status = r8
        L_0x0242:
            r4 = r5[r2]
        L_0x0244:
            int r8 = r4.line
            if (r8 <= 0) goto L_0x0256
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r8 = r4.next
            if (r8 != 0) goto L_0x0253
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r8 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Label
            r8.<init>()
            r4.next = r8
        L_0x0253:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r4 = r4.next
            goto L_0x0244
        L_0x0256:
            int r8 = r1 + 12
            int r8 = r7.readUnsignedShort(r8)
            r4.line = r8
            int r1 = r1 + 4
            int r0 = r0 + -1
            goto L_0x022a
        L_0x0264:
            r4 = 1
            goto L_0x0365
        L_0x0267:
            r4 = 1
            goto L_0x0365
        L_0x026a:
            java.lang.String r0 = "RuntimeVisibleTypeAnnotations"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x02af
            int r0 = r21 + 8
            r1 = 1
            int[] r0 = r7.readTypeAnnotations(r15, r14, r0, r1)
            int r1 = r0.length
            if (r1 == 0) goto L_0x0294
            r1 = 0
            r2 = r0[r1]
            int r2 = r7.readByte(r2)
            r4 = 67
            if (r2 >= r4) goto L_0x0289
            goto L_0x0294
        L_0x0289:
            r2 = r0[r1]
            r1 = 1
            int r2 = r2 + r1
            int r1 = r7.readUnsignedShort(r2)
            r33 = r1
            goto L_0x0296
        L_0x0294:
            r33 = -1
        L_0x0296:
            r1 = r33
            r22 = r1
            r18 = r3
            r50 = r5
            r34 = r9
            r4 = r31
            r15 = r37
            r2 = r38
            r3 = r0
            r31 = r12
            r12 = r19
            r0 = r36
            goto L_0x0423
        L_0x02af:
            java.lang.String r0 = "RuntimeInvisibleTypeAnnotations"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x02f5
            int r0 = r21 + 8
            r1 = 0
            int[] r0 = r7.readTypeAnnotations(r15, r14, r0, r1)
            int r2 = r0.length
            if (r2 == 0) goto L_0x02d9
            r2 = r0[r1]
            int r2 = r7.readByte(r2)
            r4 = 67
            if (r2 >= r4) goto L_0x02ce
            r4 = 1
            goto L_0x02da
        L_0x02ce:
            r2 = r0[r1]
            r4 = 1
            int r2 = r2 + r4
            int r1 = r7.readUnsignedShort(r2)
            r33 = r1
            goto L_0x02dc
        L_0x02d9:
            r4 = 1
        L_0x02da:
            r33 = -1
        L_0x02dc:
            r1 = r33
            r2 = r0
            r23 = r1
            r18 = r3
            r50 = r5
            r34 = r9
            r4 = r31
            r3 = r32
            r0 = r36
            r15 = r37
            r31 = r12
            r12 = r19
            goto L_0x0423
        L_0x02f5:
            r4 = 1
            java.lang.String r0 = "StackMapTable"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x032e
            int r0 = r14.flags
            r0 = r0 & 4
            if (r0 != 0) goto L_0x0365
            int r0 = r21 + 10
            int r1 = r21 + 4
            int r1 = r7.readInt(r1)
            int r2 = r21 + 8
            int r2 = r7.readUnsignedShort(r2)
            r25 = r0
            r26 = r1
            r27 = r2
            r18 = r3
            r50 = r5
            r34 = r9
            r4 = r31
            r3 = r32
            r0 = r36
            r15 = r37
            r2 = r38
            r31 = r12
            r12 = r19
            goto L_0x0423
        L_0x032e:
            java.lang.String r0 = "StackMap"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x037b
            int r0 = r14.flags
            r0 = r0 & 4
            if (r0 != 0) goto L_0x0365
            r0 = 0
            int r1 = r21 + 10
            int r2 = r21 + 4
            int r2 = r7.readInt(r2)
            int r8 = r21 + 8
            int r8 = r7.readUnsignedShort(r8)
            r25 = r1
            r26 = r2
            r18 = r3
            r50 = r5
            r27 = r8
            r34 = r9
            r4 = r31
            r3 = r32
            r15 = r37
            r2 = r38
            r31 = r12
            r12 = r19
            goto L_0x0423
        L_0x0365:
            r18 = r3
            r50 = r5
            r34 = r9
            r4 = r31
            r3 = r32
            r0 = r36
            r15 = r37
            r2 = r38
            r31 = r12
            r12 = r19
            goto L_0x0423
        L_0x037b:
            r0 = 0
            r8 = r0
            r2 = r29
        L_0x037f:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute[] r0 = r14.attrs
            int r1 = r0.length
            if (r8 >= r1) goto L_0x0402
            r0 = r0[r8]
            java.lang.String r0 = r0.type
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x03cd
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute[] r0 = r14.attrs
            r0 = r0[r8]
            int r18 = r21 + 8
            int r1 = r21 + 4
            int r29 = r7.readInt(r1)
            int r33 = r16 + -8
            r1 = r36
            r39 = r1
            r15 = r37
            r1 = r47
            r34 = r9
            r40 = r38
            r9 = r2
            r2 = r18
            r18 = r3
            r4 = r32
            r3 = r29
            r42 = r4
            r41 = r31
            r4 = r12
            r50 = r5
            r5 = r33
            r43 = r6
            r31 = r12
            r12 = r19
            r6 = r50
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r0 = r0.read(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x03e4
            r0.next = r9
            r1 = r0
            r2 = r1
            goto L_0x03e5
        L_0x03cd:
            r18 = r3
            r50 = r5
            r43 = r6
            r34 = r9
            r41 = r31
            r42 = r32
            r39 = r36
            r15 = r37
            r40 = r38
            r9 = r2
            r31 = r12
            r12 = r19
        L_0x03e4:
            r2 = r9
        L_0x03e5:
            int r8 = r8 + 1
            r5 = r50
            r19 = r12
            r37 = r15
            r3 = r18
            r12 = r31
            r9 = r34
            r36 = r39
            r38 = r40
            r31 = r41
            r32 = r42
            r6 = r43
            r4 = 1
            r15 = r48
            goto L_0x037f
        L_0x0402:
            r18 = r3
            r50 = r5
            r43 = r6
            r34 = r9
            r41 = r31
            r42 = r32
            r39 = r36
            r15 = r37
            r40 = r38
            r9 = r2
            r31 = r12
            r12 = r19
            r29 = r9
            r0 = r39
            r2 = r40
            r4 = r41
            r3 = r42
        L_0x0423:
            int r1 = r21 + 4
            int r1 = r7.readInt(r1)
            int r1 = r1 + 6
            int r21 = r21 + r1
            int r30 = r30 + -1
            r5 = r50
            r19 = r12
            r1 = r15
            r12 = r31
            r9 = r34
            r15 = r48
            goto L_0x0164
        L_0x043c:
            r39 = r0
            r15 = r1
            r40 = r2
            r50 = r5
            r43 = r6
            r34 = r9
            r41 = r31
            r42 = r32
            r4 = 67
            r31 = r12
            r12 = r19
            int r21 = r21 + 2
            if (r25 == 0) goto L_0x04b7
            r0 = r49
            r3 = -1
            r0.offset = r3
            r1 = 0
            r0.mode = r1
            r0.localCount = r1
            r0.localDiff = r1
            r0.stackCount = r1
            java.lang.Object[] r1 = new java.lang.Object[r10]
            r0.local = r1
            java.lang.Object[] r1 = new java.lang.Object[r11]
            r0.stack = r1
            if (r15 == 0) goto L_0x0470
            r7.getImplicitFrame(r14)
        L_0x0470:
            r1 = r25
        L_0x0472:
            int r2 = r25 + r26
            int r2 = r2 + -2
            if (r1 >= r2) goto L_0x04b0
            byte r2 = r13[r1]
            r5 = 8
            if (r2 != r5) goto L_0x04a5
            int r2 = r1 + 1
            int r2 = r7.readUnsignedShort(r2)
            if (r2 < 0) goto L_0x04a0
            r9 = r34
            if (r2 >= r9) goto L_0x049d
            int r5 = r16 + r2
            byte r5 = r13[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = 187(0xbb, float:2.62E-43)
            if (r5 != r6) goto L_0x049a
            r8 = r50
            r7.readLabel(r2, r8)
            goto L_0x04a9
        L_0x049a:
            r8 = r50
            goto L_0x04a9
        L_0x049d:
            r8 = r50
            goto L_0x04a9
        L_0x04a0:
            r8 = r50
            r9 = r34
            goto L_0x04a9
        L_0x04a5:
            r8 = r50
            r9 = r34
        L_0x04a9:
            int r1 = r1 + 1
            r50 = r8
            r34 = r9
            goto L_0x0472
        L_0x04b0:
            r8 = r50
            r9 = r34
            r28 = r0
            goto L_0x04bc
        L_0x04b7:
            r8 = r50
            r9 = r34
            r3 = -1
        L_0x04bc:
            int r0 = r14.flags
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x04d6
            r1 = -1
            r5 = 0
            r6 = 0
            r18 = 0
            r0 = r48
            r2 = r10
            r3 = r5
            r5 = 67
            r4 = r6
            r6 = 67
            r5 = r18
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x04d8
        L_0x04d6:
            r6 = 67
        L_0x04d8:
            int r0 = r14.flags
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x04e1
            r0 = -33
            goto L_0x04e2
        L_0x04e1:
            r0 = 0
        L_0x04e2:
            r18 = r0
            r0 = r16
            r5 = r0
        L_0x04e7:
            if (r5 >= r12) goto L_0x0a70
            int r4 = r5 - r16
            r3 = r8[r4]
            if (r3 == 0) goto L_0x0511
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r0 = r3.next
            r1 = 0
            r3.next = r1
            r2 = r15
            r15 = r48
            r15.visitLabel(r3)
            int r1 = r14.flags
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0514
            int r1 = r3.line
            if (r1 <= 0) goto L_0x0514
            r15.visitLineNumber(r1, r3)
        L_0x0507:
            if (r0 == 0) goto L_0x0514
            int r1 = r0.line
            r15.visitLineNumber(r1, r3)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r0 = r0.next
            goto L_0x0507
        L_0x0511:
            r2 = r15
            r15 = r48
        L_0x0514:
            r0 = r25
            r1 = r28
        L_0x0518:
            if (r1 == 0) goto L_0x05db
            int r6 = r1.offset
            if (r6 == r4) goto L_0x0536
            r19 = r10
            r10 = -1
            if (r6 != r10) goto L_0x0524
            goto L_0x0539
        L_0x0524:
            r10 = r2
            r25 = r3
            r21 = r5
            r36 = r9
            r32 = r11
            r33 = r12
            r6 = r39
            r11 = r0
            r12 = r1
            r9 = r4
            goto L_0x05ed
        L_0x0536:
            r19 = r10
            r10 = -1
        L_0x0539:
            int r6 = r1.offset
            if (r6 == r10) goto L_0x0598
            r6 = r39
            if (r6 == 0) goto L_0x057b
            if (r2 == 0) goto L_0x0552
            r10 = r2
            r25 = r3
            r21 = r5
            r36 = r9
            r32 = r11
            r33 = r12
            r11 = r0
            r12 = r1
            r9 = r4
            goto L_0x0589
        L_0x0552:
            int r10 = r1.mode
            r37 = r2
            int r2 = r1.localDiff
            r50 = r3
            java.lang.Object[] r3 = r1.local
            r21 = r4
            int r4 = r1.stackCount
            r30 = r5
            java.lang.Object[] r5 = r1.stack
            r32 = r11
            r11 = r0
            r0 = r48
            r33 = r12
            r12 = r1
            r1 = r10
            r10 = r37
            r25 = r50
            r36 = r9
            r9 = r21
            r21 = r30
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x05a8
        L_0x057b:
            r10 = r2
            r25 = r3
            r21 = r5
            r36 = r9
            r32 = r11
            r33 = r12
            r11 = r0
            r12 = r1
            r9 = r4
        L_0x0589:
            r1 = -1
            int r2 = r12.localCount
            java.lang.Object[] r3 = r12.local
            int r4 = r12.stackCount
            java.lang.Object[] r5 = r12.stack
            r0 = r48
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x05a8
        L_0x0598:
            r10 = r2
            r25 = r3
            r21 = r5
            r36 = r9
            r32 = r11
            r33 = r12
            r6 = r39
            r11 = r0
            r12 = r1
            r9 = r4
        L_0x05a8:
            if (r27 <= 0) goto L_0x05c5
            int r0 = r7.readFrame(r11, r6, r10, r12)
            int r27 = r27 + -1
            r39 = r6
            r4 = r9
            r2 = r10
            r1 = r12
            r10 = r19
            r5 = r21
            r3 = r25
            r11 = r32
            r12 = r33
            r9 = r36
            r6 = 67
            goto L_0x0518
        L_0x05c5:
            r1 = 0
            r39 = r6
            r4 = r9
            r2 = r10
            r0 = r11
            r10 = r19
            r5 = r21
            r3 = r25
            r11 = r32
            r12 = r33
            r9 = r36
            r6 = 67
            goto L_0x0518
        L_0x05db:
            r25 = r3
            r21 = r5
            r36 = r9
            r19 = r10
            r32 = r11
            r33 = r12
            r6 = r39
            r11 = r0
            r12 = r1
            r10 = r2
            r9 = r4
        L_0x05ed:
            byte r0 = r13[r21]
            r4 = r0 & 255(0xff, float:3.57E-43)
            byte[] r0 = org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassWriter.TYPE
            byte r0 = r0[r4]
            switch(r0) {
                case 0: goto L_0x097a;
                case 1: goto L_0x0963;
                case 2: goto L_0x094a;
                case 3: goto L_0x0931;
                case 4: goto L_0x0905;
                case 5: goto L_0x08eb;
                case 6: goto L_0x0879;
                case 7: goto L_0x0879;
                case 8: goto L_0x0812;
                case 9: goto L_0x07f6;
                case 10: goto L_0x07d8;
                case 11: goto L_0x07bb;
                case 12: goto L_0x079e;
                case 13: goto L_0x0781;
                case 14: goto L_0x0737;
                case 15: goto L_0x06e8;
                case 16: goto L_0x05f8;
                case 17: goto L_0x06a8;
                case 18: goto L_0x0618;
                default: goto L_0x05f8;
            }
        L_0x05f8:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            r6 = r4
            int r5 = r21 + 1
            java.lang.String r0 = r7.readClass(r5, r10)
            int r5 = r21 + 3
            byte r1 = r13[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r15.visitMultiANewArrayInsn(r0, r1)
            int r5 = r21 + 4
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x0618:
            r0 = 218(0xda, float:3.05E-43)
            if (r4 >= r0) goto L_0x061f
            int r0 = r4 + -49
            goto L_0x0621
        L_0x061f:
            int r0 = r4 + -20
        L_0x0621:
            int r5 = r21 + 1
            int r1 = r7.readUnsignedShort(r5)
            int r4 = r9 + r1
            r5 = r8[r4]
            r1 = 167(0xa7, float:2.34E-43)
            if (r0 == r1) goto L_0x0691
            r1 = 168(0xa8, float:2.35E-43)
            if (r0 != r1) goto L_0x0638
            r50 = r6
            r6 = r5
            goto L_0x0694
        L_0x0638:
            r1 = 166(0xa6, float:2.33E-43)
            if (r0 > r1) goto L_0x0642
            int r1 = r0 + 1
            r4 = 1
            r1 = r1 ^ r4
            int r1 = r1 - r4
            goto L_0x0645
        L_0x0642:
            r4 = 1
            r1 = r0 ^ 1
        L_0x0645:
            r3 = r1
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r0 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Label
            r0.<init>()
            r2 = r0
            r15.visitJumpInsn(r3, r2)
            r0 = 200(0xc8, float:2.8E-43)
            r15.visitJumpInsn(r0, r5)
            r15.visitLabel(r2)
            if (r11 == 0) goto L_0x0687
            if (r12 == 0) goto L_0x0668
            int r0 = r12.offset
            int r1 = r9 + 3
            if (r0 == r1) goto L_0x0662
            goto L_0x0668
        L_0x0662:
            r28 = r3
            r50 = r6
            r6 = r5
            goto L_0x068e
        L_0x0668:
            r1 = 256(0x100, float:3.59E-43)
            r28 = 0
            r30 = 0
            r37 = 0
            r38 = 0
            r0 = r48
            r39 = r2
            r2 = r28
            r28 = r3
            r3 = r30
            r4 = r37
            r50 = r6
            r6 = r5
            r5 = r38
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x068e
        L_0x0687:
            r39 = r2
            r28 = r3
            r50 = r6
            r6 = r5
        L_0x068e:
            r4 = r28
            goto L_0x069a
        L_0x0691:
            r50 = r6
            r6 = r5
        L_0x0694:
            int r1 = r0 + 33
            r15.visitJumpInsn(r1, r6)
            r4 = r0
        L_0x069a:
            int r5 = r21 + 3
            r37 = r10
            r1 = r22
            r0 = r24
            r10 = r31
            r17 = 8
            goto L_0x098c
        L_0x06a8:
            r50 = r6
            int r5 = r21 + 1
            byte r0 = r13[r5]
            r4 = r0 & 255(0xff, float:3.57E-43)
            r6 = 132(0x84, float:1.85E-43)
            if (r4 != r6) goto L_0x06d1
            int r5 = r21 + 2
            int r0 = r7.readUnsignedShort(r5)
            int r5 = r21 + 4
            short r1 = r7.readShort(r5)
            r15.visitIincInsn(r0, r1)
            int r5 = r21 + 6
            r37 = r10
            r1 = r22
            r0 = r24
            r10 = r31
            r17 = 8
            goto L_0x098c
        L_0x06d1:
            int r5 = r21 + 2
            int r0 = r7.readUnsignedShort(r5)
            r15.visitVarInsn(r4, r0)
            int r5 = r21 + 4
            r37 = r10
            r1 = r22
            r0 = r24
            r10 = r31
            r17 = 8
            goto L_0x098c
        L_0x06e8:
            r50 = r6
            r6 = 132(0x84, float:1.85E-43)
            int r5 = r21 + 4
            r0 = r9 & 3
            int r5 = r5 - r0
            int r0 = r7.readInt(r5)
            int r0 = r0 + r9
            int r1 = r5 + 4
            int r1 = r7.readInt(r1)
            int[] r2 = new int[r1]
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r3 = new org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label[r1]
            r17 = 8
            int r5 = r5 + 8
            r21 = 0
            r6 = r5
            r5 = r21
        L_0x0709:
            if (r5 >= r1) goto L_0x0725
            int r21 = r7.readInt(r6)
            r2[r5] = r21
            r21 = r1
            int r1 = r6 + 4
            int r1 = r7.readInt(r1)
            int r1 = r1 + r9
            r1 = r8[r1]
            r3[r5] = r1
            int r6 = r6 + 8
            int r5 = r5 + 1
            r1 = r21
            goto L_0x0709
        L_0x0725:
            r21 = r1
            r1 = r8[r0]
            r15.visitLookupSwitchInsn(r1, r2, r3)
            r5 = r6
            r37 = r10
            r1 = r22
            r0 = r24
            r10 = r31
            goto L_0x098c
        L_0x0737:
            r50 = r6
            r17 = 8
            int r5 = r21 + 4
            r0 = r9 & 3
            int r5 = r5 - r0
            int r0 = r7.readInt(r5)
            int r0 = r0 + r9
            int r1 = r5 + 4
            int r1 = r7.readInt(r1)
            int r2 = r5 + 8
            int r2 = r7.readInt(r2)
            int r3 = r2 - r1
            r6 = 1
            int r3 = r3 + r6
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r3 = new org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label[r3]
            int r5 = r5 + 12
            r21 = 0
            r6 = r5
            r5 = r21
        L_0x075e:
            r37 = r10
            int r10 = r3.length
            if (r5 >= r10) goto L_0x0773
            int r10 = r7.readInt(r6)
            int r10 = r10 + r9
            r10 = r8[r10]
            r3[r5] = r10
            int r6 = r6 + 4
            int r5 = r5 + 1
            r10 = r37
            goto L_0x075e
        L_0x0773:
            r5 = r8[r0]
            r15.visitTableSwitchInsn(r1, r2, r5, r3)
            r5 = r6
            r1 = r22
            r0 = r24
            r10 = r31
            goto L_0x098c
        L_0x0781:
            r50 = r6
            r37 = r10
            r17 = 8
            int r5 = r21 + 1
            byte r0 = r13[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r5 = r21 + 2
            byte r1 = r13[r5]
            r15.visitIincInsn(r0, r1)
            int r5 = r21 + 3
            r1 = r22
            r0 = r24
            r10 = r31
            goto L_0x098c
        L_0x079e:
            r50 = r6
            r37 = r10
            r17 = 8
            int r5 = r21 + 1
            int r0 = r7.readUnsignedShort(r5)
            r10 = r31
            java.lang.Object r0 = r7.readConst(r0, r10)
            r15.visitLdcInsn(r0)
            int r5 = r21 + 3
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x07bb:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            int r5 = r21 + 1
            byte r0 = r13[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            java.lang.Object r0 = r7.readConst(r0, r10)
            r15.visitLdcInsn(r0)
            int r5 = r21 + 2
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x07d8:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            int r0 = r4 + r18
            int r5 = r21 + 1
            int r1 = r7.readInt(r5)
            int r1 = r1 + r9
            r1 = r8[r1]
            r15.visitJumpInsn(r0, r1)
            int r5 = r21 + 5
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x07f6:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            int r5 = r21 + 1
            short r0 = r7.readShort(r5)
            int r0 = r0 + r9
            r0 = r8[r0]
            r15.visitJumpInsn(r4, r0)
            int r5 = r21 + 3
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x0812:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            int[] r0 = r7.items
            int r5 = r21 + 1
            int r1 = r7.readUnsignedShort(r5)
            r0 = r0[r1]
            int[] r1 = r14.bootstrapMethods
            int r2 = r7.readUnsignedShort(r0)
            r1 = r1[r2]
            int r2 = r7.readUnsignedShort(r1)
            java.lang.Object r2 = r7.readConst(r2, r10)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handle r2 = (org.jacoco.agent.p025rt.internal_8ff85ea.asm.Handle) r2
            int r3 = r1 + 2
            int r3 = r7.readUnsignedShort(r3)
            java.lang.Object[] r5 = new java.lang.Object[r3]
            int r1 = r1 + 4
            r6 = 0
        L_0x0841:
            if (r6 >= r3) goto L_0x0856
            r28 = r3
            int r3 = r7.readUnsignedShort(r1)
            java.lang.Object r3 = r7.readConst(r3, r10)
            r5[r6] = r3
            int r1 = r1 + 2
            int r6 = r6 + 1
            r3 = r28
            goto L_0x0841
        L_0x0856:
            r28 = r3
            int[] r3 = r7.items
            int r6 = r0 + 2
            int r6 = r7.readUnsignedShort(r6)
            r0 = r3[r6]
            java.lang.String r3 = r7.readUTF8(r0, r10)
            int r6 = r0 + 2
            java.lang.String r6 = r7.readUTF8(r6, r10)
            r15.visitInvokeDynamicInsn(r3, r6, r2, r5)
            int r21 = r21 + 5
            r5 = r21
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x0879:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            int[] r0 = r7.items
            int r5 = r21 + 1
            int r1 = r7.readUnsignedShort(r5)
            r0 = r0[r1]
            int r1 = r0 + -1
            byte r1 = r13[r1]
            r2 = 11
            if (r1 != r2) goto L_0x0895
            r5 = 1
            goto L_0x0896
        L_0x0895:
            r5 = 0
        L_0x0896:
            java.lang.String r6 = r7.readClass(r0, r10)
            int[] r1 = r7.items
            int r2 = r0 + 2
            int r2 = r7.readUnsignedShort(r2)
            r3 = r1[r2]
            java.lang.String r2 = r7.readUTF8(r3, r10)
            int r0 = r3 + 2
            java.lang.String r1 = r7.readUTF8(r0, r10)
            r0 = 182(0xb6, float:2.55E-43)
            if (r4 >= r0) goto L_0x08bf
            r15.visitFieldInsn(r4, r6, r2, r1)
            r28 = r1
            r30 = r2
            r31 = r3
            r38 = r6
            r6 = r4
            goto L_0x08d3
        L_0x08bf:
            r0 = r48
            r28 = r1
            r1 = r4
            r30 = r2
            r2 = r6
            r31 = r3
            r3 = r30
            r38 = r6
            r6 = r4
            r4 = r28
            r0.visitMethodInsn(r1, r2, r3, r4, r5)
        L_0x08d3:
            r0 = 185(0xb9, float:2.59E-43)
            if (r6 != r0) goto L_0x08e1
            int r0 = r21 + 5
            r5 = r0
            r4 = r6
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x08e1:
            int r0 = r21 + 3
            r5 = r0
            r4 = r6
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x08eb:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            r6 = r4
            int r5 = r21 + 1
            java.lang.String r0 = r7.readClass(r5, r10)
            r15.visitTypeInsn(r6, r0)
            int r5 = r21 + 3
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x0905:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            r6 = r4
            r0 = 54
            if (r6 <= r0) goto L_0x091e
            int r4 = r6 + -59
            int r0 = r4 >> 2
            int r0 = r0 + 54
            r1 = r4 & 3
            r15.visitVarInsn(r0, r1)
            goto L_0x0929
        L_0x091e:
            int r4 = r6 + -26
            int r0 = r4 >> 2
            int r0 = r0 + 21
            r1 = r4 & 3
            r15.visitVarInsn(r0, r1)
        L_0x0929:
            int r5 = r21 + 1
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x0931:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            r6 = r4
            int r5 = r21 + 1
            byte r0 = r13[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r15.visitVarInsn(r6, r0)
            int r5 = r21 + 2
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x094a:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            r6 = r4
            int r5 = r21 + 1
            short r0 = r7.readShort(r5)
            r15.visitIntInsn(r6, r0)
            int r5 = r21 + 3
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x0963:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            r6 = r4
            int r5 = r21 + 1
            byte r0 = r13[r5]
            r15.visitIntInsn(r6, r0)
            int r5 = r21 + 2
            r1 = r22
            r0 = r24
            goto L_0x098c
        L_0x097a:
            r50 = r6
            r37 = r10
            r10 = r31
            r17 = 8
            r6 = r4
            r15.visitInsn(r6)
            int r5 = r21 + 1
            r1 = r22
            r0 = r24
        L_0x098c:
            r6 = r42
            if (r6 == 0) goto L_0x09e0
            int r2 = r6.length
            if (r0 >= r2) goto L_0x09e0
            if (r1 > r9) goto L_0x09e0
            if (r1 != r9) goto L_0x09b8
            r2 = r6[r0]
            int r2 = r7.readAnnotationTarget(r14, r2)
            int r3 = r2 + 2
            r21 = r1
            int r1 = r14.typeRef
            r22 = r4
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r4 = r14.typePath
            r24 = r5
            java.lang.String r5 = r7.readUTF8(r2, r10)
            r28 = r2
            r2 = 1
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r1 = r15.visitInsnAnnotation(r1, r4, r5, r2)
            r7.readAnnotationValues(r3, r10, r2, r1)
            goto L_0x09be
        L_0x09b8:
            r21 = r1
            r22 = r4
            r24 = r5
        L_0x09be:
            int r0 = r0 + 1
            int r1 = r6.length
            if (r0 >= r1) goto L_0x09d7
            r1 = r6[r0]
            int r1 = r7.readByte(r1)
            r2 = 67
            if (r1 >= r2) goto L_0x09ce
            goto L_0x09d7
        L_0x09ce:
            r1 = r6[r0]
            r2 = 1
            int r1 = r1 + r2
            int r3 = r7.readUnsignedShort(r1)
            goto L_0x09d8
        L_0x09d7:
            r3 = -1
        L_0x09d8:
            r1 = r3
            r42 = r6
            r4 = r22
            r5 = r24
            goto L_0x098c
        L_0x09e0:
            r21 = r1
            r22 = r4
            r24 = r5
            r1 = r20
            r2 = r23
        L_0x09ea:
            r5 = r40
            if (r5 == 0) goto L_0x0a44
            int r3 = r5.length
            if (r1 >= r3) goto L_0x0a44
            if (r2 > r9) goto L_0x0a44
            if (r2 != r9) goto L_0x0a17
            r3 = r5[r1]
            int r3 = r7.readAnnotationTarget(r14, r3)
            int r4 = r3 + 2
            r28 = r0
            int r0 = r14.typeRef
            r20 = r2
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r2 = r14.typePath
            r42 = r6
            java.lang.String r6 = r7.readUTF8(r3, r10)
            r23 = r3
            r3 = 0
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r0 = r15.visitInsnAnnotation(r0, r2, r6, r3)
            r2 = 1
            r7.readAnnotationValues(r4, r10, r2, r0)
            goto L_0x0a1e
        L_0x0a17:
            r28 = r0
            r20 = r2
            r42 = r6
            r3 = 0
        L_0x0a1e:
            int r1 = r1 + 1
            int r0 = r5.length
            if (r1 >= r0) goto L_0x0a38
            r0 = r5[r1]
            int r0 = r7.readByte(r0)
            r2 = 67
            if (r0 >= r2) goto L_0x0a2f
            r6 = 1
            goto L_0x0a3b
        L_0x0a2f:
            r0 = r5[r1]
            r6 = 1
            int r0 = r0 + r6
            int r0 = r7.readUnsignedShort(r0)
            goto L_0x0a3c
        L_0x0a38:
            r2 = 67
            r6 = 1
        L_0x0a3b:
            r0 = -1
        L_0x0a3c:
            r2 = r0
            r40 = r5
            r0 = r28
            r6 = r42
            goto L_0x09ea
        L_0x0a44:
            r28 = r0
            r20 = r2
            r42 = r6
            r2 = 67
            r3 = 0
            r6 = 1
            r39 = r50
            r40 = r5
            r31 = r10
            r25 = r11
            r10 = r19
            r23 = r20
            r22 = r21
            r5 = r24
            r24 = r28
            r11 = r32
            r9 = r36
            r15 = r37
            r6 = 67
            r20 = r1
            r28 = r12
            r12 = r33
            goto L_0x04e7
        L_0x0a70:
            r21 = r5
            r36 = r9
            r19 = r10
            r32 = r11
            r33 = r12
            r37 = r15
            r10 = r31
            r50 = r39
            r5 = r40
            r6 = 1
            r15 = r48
            r0 = r8[r36]
            if (r0 == 0) goto L_0x0a8e
            r0 = r8[r36]
            r15.visitLabel(r0)
        L_0x0a8e:
            int r0 = r14.flags
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0b5c
            r12 = r41
            if (r12 == 0) goto L_0x0b50
            r0 = 0
            r11 = r43
            if (r11 == 0) goto L_0x0ac6
            int r1 = r11 + 2
            int r2 = r7.readUnsignedShort(r11)
            int r2 = r2 * 3
            int[] r0 = new int[r2]
            int r2 = r0.length
        L_0x0aa8:
            if (r2 <= 0) goto L_0x0ac4
            int r2 = r2 + -1
            int r3 = r1 + 6
            r0[r2] = r3
            r3 = -1
            int r2 = r2 + r3
            int r4 = r1 + 8
            int r4 = r7.readUnsignedShort(r4)
            r0[r2] = r4
            int r2 = r2 + r3
            int r4 = r7.readUnsignedShort(r1)
            r0[r2] = r4
            int r1 = r1 + 10
            goto L_0x0aa8
        L_0x0ac4:
            r9 = r0
            goto L_0x0ac9
        L_0x0ac6:
            r9 = r0
            r1 = r21
        L_0x0ac9:
            int r4 = r12 + 2
            int r0 = r7.readUnsignedShort(r12)
            r17 = r0
        L_0x0ad1:
            if (r17 <= 0) goto L_0x0b42
            int r3 = r7.readUnsignedShort(r4)
            int r0 = r4 + 2
            int r21 = r7.readUnsignedShort(r0)
            int r0 = r4 + 8
            int r2 = r7.readUnsignedShort(r0)
            r0 = 0
            if (r9 == 0) goto L_0x0b03
            r1 = 0
        L_0x0ae7:
            int r6 = r9.length
            if (r1 >= r6) goto L_0x0b03
            r6 = r9[r1]
            if (r6 != r3) goto L_0x0aff
            int r6 = r1 + 1
            r6 = r9[r6]
            if (r6 != r2) goto L_0x0aff
            int r6 = r1 + 2
            r6 = r9[r6]
            java.lang.String r0 = r7.readUTF8(r6, r10)
            r30 = r0
            goto L_0x0b05
        L_0x0aff:
            int r1 = r1 + 3
            r6 = 1
            goto L_0x0ae7
        L_0x0b03:
            r30 = r0
        L_0x0b05:
            int r0 = r4 + 4
            java.lang.String r1 = r7.readUTF8(r0, r10)
            int r0 = r4 + 6
            java.lang.String r6 = r7.readUTF8(r0, r10)
            r31 = r8[r3]
            int r0 = r3 + r21
            r34 = r8[r0]
            r0 = r48
            r35 = r2
            r2 = r6
            r38 = r3
            r3 = r30
            r39 = r4
            r4 = r31
            r6 = r5
            r5 = r34
            r31 = r50
            r44 = r6
            r34 = r13
            r15 = r42
            r13 = 1
            r6 = r35
            r0.visitLocalVariable(r1, r2, r3, r4, r5, r6)
            int r4 = r39 + 10
            int r17 = r17 + -1
            r13 = r34
            r5 = r44
            r6 = 1
            r15 = r48
            goto L_0x0ad1
        L_0x0b42:
            r31 = r50
            r39 = r4
            r44 = r5
            r34 = r13
            r15 = r42
            r13 = 1
            r21 = r39
            goto L_0x0b69
        L_0x0b50:
            r31 = r50
            r44 = r5
            r34 = r13
            r15 = r42
            r11 = r43
            r13 = 1
            goto L_0x0b69
        L_0x0b5c:
            r31 = r50
            r44 = r5
            r34 = r13
            r12 = r41
            r15 = r42
            r11 = r43
            r13 = 1
        L_0x0b69:
            if (r15 == 0) goto L_0x0c0d
            r0 = 0
        L_0x0b6c:
            int r1 = r15.length
            if (r0 >= r1) goto L_0x0bf3
            r1 = r15[r0]
            int r1 = r7.readByte(r1)
            int r1 = r1 >> r13
            r2 = 32
            if (r1 != r2) goto L_0x0bbf
            r1 = r15[r0]
            int r1 = r7.readAnnotationTarget(r14, r1)
            int r2 = r1 + 2
            int r9 = r14.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r3 = r14.typePath
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r4 = r14.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r5 = r14.end
            int[] r6 = r14.index
            java.lang.String r1 = r7.readUTF8(r1, r10)
            r17 = 1
            r30 = r8
            r8 = r48
            r35 = r36
            r45 = r19
            r36 = r37
            r19 = r10
            r10 = r3
            r3 = r32
            r32 = r11
            r11 = r4
            r4 = r19
            r19 = r33
            r33 = r12
            r12 = r5
            r5 = r34
            r13 = r6
            r6 = r14
            r14 = r1
            r1 = r48
            r34 = r15
            r15 = r17
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r8 = r8.visitLocalVariableAnnotation(r9, r10, r11, r12, r13, r14, r15)
            r15 = 1
            r7.readAnnotationValues(r2, r4, r15, r8)
            goto L_0x0bd8
        L_0x0bbf:
            r1 = r48
            r30 = r8
            r4 = r10
            r6 = r14
            r45 = r19
            r3 = r32
            r19 = r33
            r5 = r34
            r35 = r36
            r36 = r37
            r32 = r11
            r33 = r12
            r34 = r15
            r15 = 1
        L_0x0bd8:
            int r0 = r0 + 1
            r10 = r4
            r14 = r6
            r8 = r30
            r11 = r32
            r12 = r33
            r15 = r34
            r37 = r36
            r13 = 1
            r32 = r3
            r34 = r5
            r33 = r19
            r36 = r35
            r19 = r45
            goto L_0x0b6c
        L_0x0bf3:
            r1 = r48
            r30 = r8
            r4 = r10
            r6 = r14
            r45 = r19
            r3 = r32
            r19 = r33
            r5 = r34
            r35 = r36
            r36 = r37
            r32 = r11
            r33 = r12
            r34 = r15
            r15 = 1
            goto L_0x0c26
        L_0x0c0d:
            r1 = r48
            r30 = r8
            r4 = r10
            r6 = r14
            r45 = r19
            r3 = r32
            r19 = r33
            r5 = r34
            r35 = r36
            r36 = r37
            r32 = r11
            r33 = r12
            r34 = r15
            r15 = 1
        L_0x0c26:
            r2 = r44
            if (r2 == 0) goto L_0x0c77
            r0 = 0
        L_0x0c2b:
            int r8 = r2.length
            if (r0 >= r8) goto L_0x0c72
            r8 = r2[r0]
            int r8 = r7.readByte(r8)
            int r8 = r8 >> r15
            r9 = 32
            if (r8 != r9) goto L_0x0c65
            r8 = r2[r0]
            int r8 = r7.readAnnotationTarget(r6, r8)
            int r14 = r8 + 2
            int r9 = r6.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r10 = r6.typePath
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r11 = r6.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r12 = r6.end
            int[] r13 = r6.index
            java.lang.String r17 = r7.readUTF8(r8, r4)
            r37 = 0
            r8 = r48
            r40 = r2
            r2 = r14
            r14 = r17
            r50 = r5
            r5 = 1
            r15 = r37
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r8 = r8.visitLocalVariableAnnotation(r9, r10, r11, r12, r13, r14, r15)
            r7.readAnnotationValues(r2, r4, r5, r8)
            goto L_0x0c6a
        L_0x0c65:
            r40 = r2
            r50 = r5
            r5 = 1
        L_0x0c6a:
            int r0 = r0 + 1
            r5 = r50
            r2 = r40
            r15 = 1
            goto L_0x0c2b
        L_0x0c72:
            r40 = r2
            r50 = r5
            goto L_0x0c7b
        L_0x0c77:
            r40 = r2
            r50 = r5
        L_0x0c7b:
            r0 = r29
        L_0x0c7d:
            if (r0 == 0) goto L_0x0c89
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r2 = r0.next
            r5 = 0
            r0.next = r5
            r1.visitAttribute(r0)
            r0 = r2
            goto L_0x0c7d
        L_0x0c89:
            r2 = r45
            r1.visitMaxs(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassReader.readCode(org.jacoco.agent.rt.internal_8ff85ea.asm.MethodVisitor, org.jacoco.agent.rt.internal_8ff85ea.asm.Context, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] readTypeAnnotations(org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor r11, org.jacoco.agent.p025rt.internal_8ff85ea.asm.Context r12, int r13, boolean r14) {
        /*
            r10 = this;
            char[] r0 = r12.buffer
            int r1 = r10.readUnsignedShort(r13)
            int[] r1 = new int[r1]
            int r13 = r13 + 2
            r2 = 0
        L_0x000b:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0094
            r1[r2] = r13
            int r3 = r10.readInt(r13)
            int r4 = r3 >>> 24
            r5 = 1
            if (r4 == 0) goto L_0x005b
            if (r4 == r5) goto L_0x005b
            r6 = 64
            if (r4 == r6) goto L_0x0032
            r6 = 65
            if (r4 == r6) goto L_0x0032
            switch(r4) {
                case 19: goto L_0x002f;
                case 20: goto L_0x002f;
                case 21: goto L_0x002f;
                case 22: goto L_0x005b;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r4) {
                case 71: goto L_0x002c;
                case 72: goto L_0x002c;
                case 73: goto L_0x002c;
                case 74: goto L_0x002c;
                case 75: goto L_0x002c;
                default: goto L_0x0029;
            }
        L_0x0029:
            int r13 = r13 + 3
            goto L_0x005e
        L_0x002c:
            int r13 = r13 + 4
            goto L_0x005e
        L_0x002f:
            int r13 = r13 + 1
            goto L_0x005e
        L_0x0032:
            int r4 = r13 + 1
            int r4 = r10.readUnsignedShort(r4)
        L_0x0038:
            if (r4 <= 0) goto L_0x0058
            int r6 = r13 + 3
            int r6 = r10.readUnsignedShort(r6)
            int r7 = r13 + 5
            int r7 = r10.readUnsignedShort(r7)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r8 = r12.labels
            r10.readLabel(r6, r8)
            int r8 = r6 + r7
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r9 = r12.labels
            r10.readLabel(r8, r9)
            int r13 = r13 + 6
            int r4 = r4 + -1
            goto L_0x0038
        L_0x0058:
            int r13 = r13 + 3
            goto L_0x005e
        L_0x005b:
            int r13 = r13 + 2
        L_0x005e:
            int r4 = r10.readByte(r13)
            int r6 = r3 >>> 24
            r7 = 66
            r8 = 0
            if (r6 != r7) goto L_0x0087
            if (r4 != 0) goto L_0x006c
            goto L_0x0073
        L_0x006c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r8 = new org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath
            byte[] r6 = r10.f43240b
            r8.<init>(r6, r13)
        L_0x0073:
            r6 = r8
            int r7 = r4 * 2
            int r7 = r7 + r5
            int r13 = r13 + r7
            int r7 = r13 + 2
            java.lang.String r8 = r10.readUTF8(r13, r0)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r8 = r11.visitTryCatchAnnotation(r3, r6, r8, r14)
            int r13 = r10.readAnnotationValues(r7, r0, r5, r8)
            goto L_0x0090
        L_0x0087:
            int r6 = r13 + 3
            int r7 = r4 * 2
            int r6 = r6 + r7
            int r13 = r10.readAnnotationValues(r6, r0, r5, r8)
        L_0x0090:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassReader.readTypeAnnotations(org.jacoco.agent.rt.internal_8ff85ea.asm.MethodVisitor, org.jacoco.agent.rt.internal_8ff85ea.asm.Context, int, boolean):int[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readAnnotationTarget(org.jacoco.agent.p025rt.internal_8ff85ea.asm.Context r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.readInt(r10)
            int r1 = r0 >>> 24
            if (r1 == 0) goto L_0x007a
            r2 = 1
            if (r1 == r2) goto L_0x007a
            r3 = 64
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r1 == r3) goto L_0x0031
            r3 = 65
            if (r1 == r3) goto L_0x0031
            switch(r1) {
                case 19: goto L_0x002e;
                case 20: goto L_0x002e;
                case 21: goto L_0x002e;
                case 22: goto L_0x007a;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r1) {
                case 71: goto L_0x0027;
                case 72: goto L_0x0027;
                case 73: goto L_0x0027;
                case 74: goto L_0x0027;
                case 75: goto L_0x0027;
                default: goto L_0x001b;
            }
        L_0x001b:
            int r1 = r0 >>> 24
            r2 = 67
            if (r1 >= r2) goto L_0x0023
            r4 = -256(0xffffffffffffff00, float:NaN)
        L_0x0023:
            r0 = r0 & r4
            int r10 = r10 + 3
            goto L_0x0080
        L_0x0027:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r10 = r10 + 4
            goto L_0x0080
        L_0x002e:
            r0 = r0 & r4
            int r10 = r10 + r2
            goto L_0x0080
        L_0x0031:
            r0 = r0 & r4
            int r1 = r10 + 1
            int r1 = r8.readUnsignedShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r2 = new org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label[r1]
            r9.start = r2
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r2 = new org.jacoco.agent.p025rt.internal_8ff85ea.asm.Label[r1]
            r9.end = r2
            int[] r2 = new int[r1]
            r9.index = r2
            int r10 = r10 + 3
            r2 = 0
        L_0x0047:
            if (r2 >= r1) goto L_0x0079
            int r3 = r8.readUnsignedShort(r10)
            int r4 = r10 + 2
            int r4 = r8.readUnsignedShort(r4)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r5 = r9.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r6 = r9.labels
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r6 = r8.readLabel(r3, r6)
            r5[r2] = r6
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r5 = r9.end
            int r6 = r3 + r4
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r7 = r9.labels
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r6 = r8.readLabel(r6, r7)
            r5[r2] = r6
            int[] r5 = r9.index
            int r6 = r10 + 4
            int r6 = r8.readUnsignedShort(r6)
            r5[r2] = r6
            int r10 = r10 + 6
            int r2 = r2 + 1
            goto L_0x0047
        L_0x0079:
            goto L_0x0080
        L_0x007a:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r10 = r10 + 2
        L_0x0080:
            int r1 = r8.readByte(r10)
            r9.typeRef = r0
            if (r1 != 0) goto L_0x008a
            r2 = 0
            goto L_0x0091
        L_0x008a:
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r2 = new org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath
            byte[] r3 = r8.f43240b
            r2.<init>(r3, r10)
        L_0x0091:
            r9.typePath = r2
            int r2 = r10 + 1
            int r3 = r1 * 2
            int r2 = r2 + r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassReader.readAnnotationTarget(org.jacoco.agent.rt.internal_8ff85ea.asm.Context, int):int");
    }

    private void readParameterAnnotations(MethodVisitor mv, Context context, int v, boolean visible) {
        int v2 = v + 1;
        int n = this.f43240b[v] & 255;
        int synthetics = Type.getArgumentTypes(context.desc).length - n;
        int i = 0;
        while (i < synthetics) {
            AnnotationVisitor av = mv.visitParameterAnnotation(i, "Ljava/lang/Synthetic;", false);
            if (av != null) {
                av.visitEnd();
            }
            i++;
        }
        char[] c = context.buffer;
        while (i < n + synthetics) {
            v2 += 2;
            for (int j = readUnsignedShort(v2); j > 0; j--) {
                v2 = readAnnotationValues(v2 + 2, c, true, mv.visitParameterAnnotation(i, readUTF8(v2, c), visible));
            }
            i++;
        }
    }

    private int readAnnotationValues(int v, char[] buf, boolean named, AnnotationVisitor av) {
        int i = readUnsignedShort(v);
        int v2 = v + 2;
        if (named) {
            while (i > 0) {
                v2 = readAnnotationValue(v2 + 2, buf, readUTF8(v2, buf), av);
                i--;
            }
        } else {
            while (i > 0) {
                v2 = readAnnotationValue(v2, buf, null, av);
                i--;
            }
        }
        if (av != null) {
            av.visitEnd();
        }
        return v2;
    }

    private int readAnnotationValue(int v, char[] buf, String name, AnnotationVisitor av) {
        if (av == null) {
            byte b = this.f43240b[v] & 255;
            if (b == 64) {
                return readAnnotationValues(v + 3, buf, true, null);
            }
            if (b == 91) {
                return readAnnotationValues(v + 1, buf, false, null);
            }
            if (b != 101) {
                return v + 3;
            }
            return v + 5;
        }
        int v2 = v + 1;
        byte b2 = this.f43240b[v] & 255;
        if (b2 != 64) {
            if (b2 != 70) {
                if (b2 == 83) {
                    av.visit(name, Short.valueOf((short) readInt(this.items[readUnsignedShort(v2)])));
                    v2 += 2;
                } else if (b2 == 99) {
                    av.visit(name, Type.getType(readUTF8(v2, buf)));
                    v2 += 2;
                } else if (b2 == 101) {
                    av.visitEnum(name, readUTF8(v2, buf), readUTF8(v2 + 2, buf));
                    v2 += 4;
                } else if (b2 == 115) {
                    av.visit(name, readUTF8(v2, buf));
                    v2 += 2;
                } else if (!(b2 == 73 || b2 == 74)) {
                    if (b2 == 90) {
                        av.visit(name, readInt(this.items[readUnsignedShort(v2)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                        v2 += 2;
                    } else if (b2 != 91) {
                        switch (b2) {
                            case 66:
                                av.visit(name, Byte.valueOf((byte) readInt(this.items[readUnsignedShort(v2)])));
                                v2 += 2;
                                break;
                            case 67:
                                av.visit(name, Character.valueOf((char) readInt(this.items[readUnsignedShort(v2)])));
                                v2 += 2;
                                break;
                            case 68:
                                break;
                        }
                    } else {
                        int size = readUnsignedShort(v2);
                        int v3 = v2 + 2;
                        if (size == 0) {
                            return readAnnotationValues(v3 - 2, buf, false, av.visitArray(name));
                        }
                        int v4 = v3 + 1;
                        byte b3 = this.f43240b[v3] & 255;
                        if (b3 == 70) {
                            float[] fv = new float[size];
                            for (int i = 0; i < size; i++) {
                                fv[i] = Float.intBitsToFloat(readInt(this.items[readUnsignedShort(v4)]));
                                v4 += 3;
                            }
                            av.visit(name, fv);
                            v2 = v4 - 1;
                        } else if (b3 == 83) {
                            short[] zv = new short[size];
                            for (int i2 = 0; i2 < size; i2++) {
                                zv[i2] = (short) readInt(this.items[readUnsignedShort(v4)]);
                                v4 += 3;
                            }
                            av.visit(name, zv);
                            v2 = v4 - 1;
                        } else if (b3 == 90) {
                            boolean[] zv2 = new boolean[size];
                            for (int i3 = 0; i3 < size; i3++) {
                                zv2[i3] = readInt(this.items[readUnsignedShort(v4)]) != 0;
                                v4 += 3;
                            }
                            av.visit(name, zv2);
                            v2 = v4 - 1;
                        } else if (b3 == 73) {
                            int[] iv = new int[size];
                            for (int i4 = 0; i4 < size; i4++) {
                                iv[i4] = readInt(this.items[readUnsignedShort(v4)]);
                                v4 += 3;
                            }
                            av.visit(name, iv);
                            v2 = v4 - 1;
                        } else if (b3 != 74) {
                            switch (b3) {
                                case 66:
                                    byte[] bv = new byte[size];
                                    for (int i5 = 0; i5 < size; i5++) {
                                        bv[i5] = (byte) readInt(this.items[readUnsignedShort(v4)]);
                                        v4 += 3;
                                    }
                                    av.visit(name, bv);
                                    v2 = v4 - 1;
                                    break;
                                case 67:
                                    char[] dv = new char[size];
                                    for (int i6 = 0; i6 < size; i6++) {
                                        dv[i6] = (char) readInt(this.items[readUnsignedShort(v4)]);
                                        v4 += 3;
                                    }
                                    av.visit(name, dv);
                                    v2 = v4 - 1;
                                    break;
                                case 68:
                                    double[] dv2 = new double[size];
                                    for (int i7 = 0; i7 < size; i7++) {
                                        dv2[i7] = Double.longBitsToDouble(readLong(this.items[readUnsignedShort(v4)]));
                                        v4 += 3;
                                    }
                                    av.visit(name, dv2);
                                    v2 = v4 - 1;
                                    break;
                                default:
                                    v2 = readAnnotationValues(v4 - 3, buf, false, av.visitArray(name));
                                    break;
                            }
                        } else {
                            long[] lv = new long[size];
                            for (int i8 = 0; i8 < size; i8++) {
                                lv[i8] = readLong(this.items[readUnsignedShort(v4)]);
                                v4 += 3;
                            }
                            av.visit(name, lv);
                            v2 = v4 - 1;
                        }
                    }
                }
            }
            av.visit(name, readConst(readUnsignedShort(v2), buf));
            v2 += 2;
        } else {
            v2 = readAnnotationValues(v2 + 2, buf, true, av.visitAnnotation(name, readUTF8(v2, buf)));
        }
        return v2;
    }

    private void getImplicitFrame(Context frame) {
        int local;
        int local2;
        String desc = frame.desc;
        Object[] locals = frame.local;
        if ((frame.access & 8) == 0) {
            if ("<init>".equals(frame.name)) {
                local = 0 + 1;
                locals[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                local = 0 + 1;
                locals[0] = readClass(this.header + 2, frame.buffer);
            }
        } else {
            local = 0;
        }
        int local3 = 1;
        while (true) {
            int j = local3;
            int i = local3 + 1;
            int i2 = desc.charAt(local3);
            if (i2 == 70) {
                int local4 = local + 1;
                locals[local] = Opcodes.FLOAT;
                local2 = local4;
                local3 = i;
            } else if (i2 != 76) {
                if (!(i2 == 83 || i2 == 73)) {
                    if (i2 == 74) {
                        int local5 = local + 1;
                        locals[local] = Opcodes.LONG;
                        local2 = local5;
                        local3 = i;
                    } else if (i2 != 90) {
                        if (i2 != 91) {
                            switch (i2) {
                                case 66:
                                case 67:
                                    break;
                                case 68:
                                    int local6 = local + 1;
                                    locals[local] = Opcodes.DOUBLE;
                                    local2 = local6;
                                    local3 = i;
                                    continue;
                                default:
                                    frame.localCount = local;
                                    return;
                            }
                        } else {
                            while (desc.charAt(i) == 91) {
                                i++;
                            }
                            if (desc.charAt(i) == 'L') {
                                while (true) {
                                    i++;
                                    if (desc.charAt(i) != ';') {
                                    }
                                }
                            }
                            int local7 = local + 1;
                            int i3 = i + 1;
                            locals[local] = desc.substring(j, i3);
                            local2 = local7;
                            local3 = i3;
                        }
                    }
                }
                int local8 = local + 1;
                locals[local] = Opcodes.INTEGER;
                local2 = local8;
                local3 = i;
            } else {
                while (desc.charAt(i) != 59) {
                    i++;
                }
                int local9 = local + 1;
                int i4 = i + 1;
                locals[local] = desc.substring(j + 1, i);
                local2 = local9;
                local3 = i4;
            }
        }
    }

    private int readFrame(int stackMap, boolean zip, boolean unzip, Context frame) {
        int stackMap2;
        byte b;
        int delta;
        Context context = frame;
        char[] c = context.buffer;
        Label[] labels = context.labels;
        if (zip) {
            b = this.f43240b[stackMap] & 255;
            stackMap2 = stackMap + 1;
        } else {
            context.offset = -1;
            stackMap2 = stackMap;
            b = 255;
        }
        context.localDiff = 0;
        if (b < 64) {
            int delta2 = b;
            context.mode = 3;
            context.stackCount = 0;
            delta = delta2;
        } else if (b < 128) {
            int delta3 = b - 64;
            stackMap2 = readFrameType(context.stack, 0, stackMap2, c, labels);
            context.mode = 4;
            context.stackCount = 1;
            delta = delta3;
        } else {
            delta = readUnsignedShort(stackMap2);
            stackMap2 += 2;
            if (b == 247) {
                stackMap2 = readFrameType(context.stack, 0, stackMap2, c, labels);
                context.mode = 4;
                context.stackCount = 1;
            } else if (b >= 248 && b < 251) {
                context.mode = 2;
                context.localDiff = 251 - b;
                context.localCount -= context.localDiff;
                context.stackCount = 0;
            } else if (b == 251) {
                context.mode = 3;
                context.stackCount = 0;
            } else if (b < 255) {
                int local = unzip ? context.localCount : 0;
                int stackMap3 = stackMap2;
                int i = b - 251;
                while (i > 0) {
                    int local2 = local + 1;
                    stackMap3 = readFrameType(context.local, local, stackMap3, c, labels);
                    i--;
                    local = local2;
                }
                context.mode = 1;
                context.localDiff = b - 251;
                context.localCount += context.localDiff;
                context.stackCount = 0;
                stackMap2 = stackMap3;
            } else {
                context.mode = 0;
                int n = readUnsignedShort(stackMap2);
                int stackMap4 = stackMap2 + 2;
                context.localDiff = n;
                context.localCount = n;
                int local3 = 0;
                int stackMap5 = stackMap4;
                int n2 = n;
                while (n2 > 0) {
                    int local4 = local3 + 1;
                    stackMap5 = readFrameType(context.local, local3, stackMap5, c, labels);
                    n2--;
                    local3 = local4;
                }
                int n3 = readUnsignedShort(stackMap5);
                int stackMap6 = stackMap5 + 2;
                context.stackCount = n3;
                int n4 = n3;
                int stack = 0;
                while (n4 > 0) {
                    int stack2 = stack + 1;
                    stackMap6 = readFrameType(context.stack, stack, stackMap6, c, labels);
                    n4--;
                    stack = stack2;
                }
                stackMap2 = stackMap6;
            }
        }
        context.offset += delta + 1;
        readLabel(context.offset, labels);
        return stackMap2;
    }

    private int readFrameType(Object[] frame, int index, int v, char[] buf, Label[] labels) {
        int v2 = v + 1;
        switch (this.f43240b[v] & 255) {
            case 0:
                frame[index] = Opcodes.TOP;
                return v2;
            case 1:
                frame[index] = Opcodes.INTEGER;
                return v2;
            case 2:
                frame[index] = Opcodes.FLOAT;
                return v2;
            case 3:
                frame[index] = Opcodes.DOUBLE;
                return v2;
            case 4:
                frame[index] = Opcodes.LONG;
                return v2;
            case 5:
                frame[index] = Opcodes.NULL;
                return v2;
            case 6:
                frame[index] = Opcodes.UNINITIALIZED_THIS;
                return v2;
            case 7:
                frame[index] = readClass(v2, buf);
                return v2 + 2;
            default:
                frame[index] = readLabel(readUnsignedShort(v2), labels);
                return v2 + 2;
        }
    }

    /* access modifiers changed from: protected */
    public Label readLabel(int offset, Label[] labels) {
        if (labels[offset] == null) {
            labels[offset] = new Label();
        }
        return labels[offset];
    }

    private int getAttributes() {
        int i = this.header;
        int u = i + 8 + (readUnsignedShort(i + 6) * 2);
        for (int i2 = readUnsignedShort(u); i2 > 0; i2--) {
            for (int j = readUnsignedShort(u + 8); j > 0; j--) {
                u += readInt(u + 12) + 6;
            }
            u += 8;
        }
        int u2 = u + 2;
        for (int i3 = readUnsignedShort(u2); i3 > 0; i3--) {
            for (int j2 = readUnsignedShort(u2 + 8); j2 > 0; j2--) {
                u2 += readInt(u2 + 12) + 6;
            }
            u2 += 8;
        }
        return u2 + 2;
    }

    private Attribute readAttribute(Attribute[] attrs, String type, int off, int len, char[] buf, int codeOff, Label[] labels) {
        Attribute[] attributeArr = attrs;
        String str = type;
        for (int i = 0; i < attributeArr.length; i++) {
            if (attributeArr[i].type.equals(type)) {
                return attributeArr[i].read(this, off, len, buf, codeOff, labels);
            }
        }
        return new Attribute(type).read(this, off, len, null, -1, null);
    }

    public int getItemCount() {
        return this.items.length;
    }

    public int getItem(int item) {
        return this.items[item];
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int readByte(int index) {
        return this.f43240b[index] & 255;
    }

    public int readUnsignedShort(int index) {
        byte[] b = this.f43240b;
        return ((b[index] & 255) << 8) | (b[index + 1] & 255);
    }

    public short readShort(int index) {
        byte[] b = this.f43240b;
        return (short) (((b[index] & 255) << 8) | (b[index + 1] & 255));
    }

    public int readInt(int index) {
        byte[] b = this.f43240b;
        return ((b[index] & 255) << 24) | ((b[index + 1] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((b[index + 2] & 255) << 8) | (b[index + 3] & 255);
    }

    public long readLong(int index) {
        return (((long) readInt(index)) << 32) | (((long) readInt(index + 4)) & 4294967295L);
    }

    public String readUTF8(int index, char[] buf) {
        int item = readUnsignedShort(index);
        if (index == 0 || item == 0) {
            return null;
        }
        String[] strArr = this.strings;
        String s = strArr[item];
        if (s != null) {
            return s;
        }
        int index2 = this.items[item];
        String readUTF = readUTF(index2 + 2, readUnsignedShort(index2), buf);
        strArr[item] = readUTF;
        return readUTF;
    }

    private String readUTF(int c, int utfLen, char[] buf) {
        int endIndex = c + utfLen;
        byte[] b = this.f43240b;
        int st = 0;
        char c2 = 0;
        char cc = 0;
        while (c < endIndex) {
            int index = c + 1;
            byte c3 = b[c];
            if (c2 == 0) {
                int c4 = c3 & 255;
                if (c4 < 128) {
                    int strLen = st + 1;
                    buf[st] = (char) c4;
                    st = strLen;
                } else if (c4 >= 224 || c4 <= 191) {
                    cc = (char) (c4 & 15);
                    c2 = 2;
                } else {
                    cc = (char) (c4 & 31);
                    c2 = 1;
                }
            } else if (c2 == 1) {
                int strLen2 = st + 1;
                buf[st] = (char) ((cc << 6) | (c3 & 63));
                c2 = 0;
                st = strLen2;
            } else if (c2 == 2) {
                cc = (char) ((cc << 6) | (c3 & 63));
                c2 = 1;
            }
            c = index;
        }
        return new String(buf, 0, st);
    }

    public String readClass(int index, char[] buf) {
        return readUTF8(this.items[readUnsignedShort(index)], buf);
    }

    public Object readConst(int item, char[] buf) {
        char[] cArr = buf;
        int index = this.items[item];
        byte b = this.f43240b[index - 1];
        if (b == 16) {
            return Type.getMethodType(readUTF8(index, cArr));
        }
        switch (b) {
            case 3:
                return Integer.valueOf(readInt(index));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(index)));
            case 5:
                return Long.valueOf(readLong(index));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(index)));
            case 7:
                return Type.getObjectType(readUTF8(index, cArr));
            case 8:
                return readUTF8(index, cArr);
            default:
                int tag = readByte(index);
                int[] items2 = this.items;
                int cpIndex = items2[readUnsignedShort(index + 1)];
                boolean itf = this.f43240b[cpIndex + -1] == 11;
                String owner = readClass(cpIndex, cArr);
                int cpIndex2 = items2[readUnsignedShort(cpIndex + 2)];
                Handle handle = new Handle(tag, owner, readUTF8(cpIndex2, cArr), readUTF8(cpIndex2 + 2, cArr), itf);
                return handle;
        }
    }
}
