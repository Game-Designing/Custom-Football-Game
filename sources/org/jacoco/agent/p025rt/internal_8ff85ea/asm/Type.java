package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Type */
public class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final int BYTE = 3;
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final int CHAR = 2;
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final int DOUBLE = 8;
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
    public static final int FLOAT = 6;
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final int INT = 5;
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final int LONG = 7;
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final int METHOD = 11;
    public static final int OBJECT = 10;
    public static final int SHORT = 4;
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final int VOID = 0;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    private final char[] buf;
    private final int len;
    private final int off;
    private final int sort;

    private Type(int sort2, char[] buf2, int off2, int len2) {
        this.sort = sort2;
        this.buf = buf2;
        this.off = off2;
        this.len = len2;
    }

    public static Type getType(String typeDescriptor) {
        return getType(typeDescriptor.toCharArray(), 0);
    }

    public static Type getObjectType(String internalName) {
        char[] buf2 = internalName.toCharArray();
        return new Type(buf2[0] == '[' ? 9 : 10, buf2, 0, buf2.length);
    }

    public static Type getMethodType(String methodDescriptor) {
        return getType(methodDescriptor.toCharArray(), 0);
    }

    public static Type getMethodType(Type returnType, Type... argumentTypes) {
        return getType(getMethodDescriptor(returnType, argumentTypes));
    }

    public static Type getType(Class<?> c) {
        if (!c.isPrimitive()) {
            return getType(getDescriptor(c));
        }
        if (c == Integer.TYPE) {
            return INT_TYPE;
        }
        if (c == Void.TYPE) {
            return VOID_TYPE;
        }
        if (c == Boolean.TYPE) {
            return BOOLEAN_TYPE;
        }
        if (c == Byte.TYPE) {
            return BYTE_TYPE;
        }
        if (c == Character.TYPE) {
            return CHAR_TYPE;
        }
        if (c == Short.TYPE) {
            return SHORT_TYPE;
        }
        if (c == Double.TYPE) {
            return DOUBLE_TYPE;
        }
        if (c == Float.TYPE) {
            return FLOAT_TYPE;
        }
        return LONG_TYPE;
    }

    public static Type getType(Constructor<?> c) {
        return getType(getConstructorDescriptor(c));
    }

    public static Type getType(Method m) {
        return getType(getMethodDescriptor(m));
    }

    public static Type[] getArgumentTypes(String methodDescriptor) {
        int off2;
        char[] buf2 = methodDescriptor.toCharArray();
        int off3 = 1;
        int size = 0;
        while (true) {
            int off4 = off3 + 1;
            char car = buf2[off3];
            if (car == ')') {
                break;
            } else if (car == 'L') {
                while (true) {
                    off2 = off4 + 1;
                    if (buf2[off4] == ';') {
                        break;
                    }
                    off4 = off2;
                }
                size++;
                off3 = off2;
            } else if (car != '[') {
                size++;
                off3 = off4;
            } else {
                off3 = off4;
            }
        }
        Type[] args = new Type[size];
        int off5 = 1;
        int size2 = 0;
        while (buf2[off5] != ')') {
            args[size2] = getType(buf2, off5);
            off5 += args[size2].len + (args[size2].sort == 10 ? 2 : 0);
            size2++;
        }
        return args;
    }

    public static Type[] getArgumentTypes(Method method) {
        Class<?>[] classes = method.getParameterTypes();
        Type[] types = new Type[classes.length];
        for (int i = classes.length - 1; i >= 0; i--) {
            types[i] = getType(classes[i]);
        }
        return types;
    }

    public static Type getReturnType(String methodDescriptor) {
        int off2;
        char[] buf2 = methodDescriptor.toCharArray();
        int off3 = 1;
        while (true) {
            int off4 = off3 + 1;
            char car = buf2[off3];
            if (car == ')') {
                return getType(buf2, off4);
            }
            if (car == 'L') {
                while (true) {
                    off2 = off4 + 1;
                    if (buf2[off4] == ';') {
                        break;
                    }
                    off4 = off2;
                }
                off3 = off2;
            } else {
                off3 = off4;
            }
        }
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    public static int getArgumentsAndReturnSizes(String desc) {
        int c;
        char car;
        int c2;
        int n = 1;
        int c3 = 1;
        while (true) {
            c = c3 + 1;
            char car2 = desc.charAt(c3);
            if (car2 == ')') {
                break;
            } else if (car2 == 'L') {
                while (true) {
                    c2 = c + 1;
                    if (desc.charAt(c) == 59) {
                        break;
                    }
                    c = c2;
                }
                n++;
                c3 = c2;
            } else if (car2 == '[') {
                while (true) {
                    char charAt = desc.charAt(c);
                    car = charAt;
                    if (charAt != '[') {
                        break;
                    }
                    c++;
                }
                if (car == 'D' || car == 'J') {
                    n--;
                    c3 = c;
                } else {
                    c3 = c;
                }
            } else if (car2 == 'D' || car2 == 'J') {
                n += 2;
                c3 = c;
            } else {
                n++;
                c3 = c;
            }
        }
        char car3 = desc.charAt(c);
        int i = n << 2;
        int i2 = car3 == 'V' ? 0 : (car3 == 'D' || car3 == 'J') ? 2 : 1;
        return i | i2;
    }

    private static Type getType(char[] buf2, int off2) {
        char c = buf2[off2];
        if (c == 'F') {
            return FLOAT_TYPE;
        }
        if (c == 'L') {
            int len2 = 1;
            while (buf2[off2 + len2] != ';') {
                len2++;
            }
            return new Type(10, buf2, off2 + 1, len2 - 1);
        } else if (c == 'S') {
            return SHORT_TYPE;
        } else {
            if (c == 'V') {
                return VOID_TYPE;
            }
            if (c == 'I') {
                return INT_TYPE;
            }
            if (c == 'J') {
                return LONG_TYPE;
            }
            if (c == 'Z') {
                return BOOLEAN_TYPE;
            }
            if (c != '[') {
                switch (c) {
                    case 'B':
                        return BYTE_TYPE;
                    case 'C':
                        return CHAR_TYPE;
                    case 'D':
                        return DOUBLE_TYPE;
                    default:
                        return new Type(11, buf2, off2, buf2.length - off2);
                }
            } else {
                int len3 = 1;
                while (buf2[off2 + len3] == '[') {
                    len3++;
                }
                if (buf2[off2 + len3] == 'L') {
                    while (true) {
                        len3++;
                        if (buf2[off2 + len3] == ';') {
                            break;
                        }
                    }
                }
                return new Type(9, buf2, off2, len3 + 1);
            }
        }
    }

    public int getSort() {
        return this.sort;
    }

    public int getDimensions() {
        int i = 1;
        while (this.buf[this.off + i] == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return getType(this.buf, this.off + getDimensions());
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb = new StringBuilder(getElementType().getClassName());
                for (int i = getDimensions(); i > 0; i--) {
                    sb.append("[]");
                }
                return sb.toString();
            case 10:
                return new String(this.buf, this.off, this.len).replace('/', '.');
            default:
                return null;
        }
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public String getDescriptor() {
        StringBuilder buf2 = new StringBuilder();
        getDescriptor(buf2);
        return buf2.toString();
    }

    public static String getMethodDescriptor(Type returnType, Type... argumentTypes) {
        StringBuilder buf2 = new StringBuilder();
        buf2.append('(');
        for (Type descriptor : argumentTypes) {
            descriptor.getDescriptor(buf2);
        }
        buf2.append(')');
        returnType.getDescriptor(buf2);
        return buf2.toString();
    }

    private void getDescriptor(StringBuilder buf2) {
        char[] cArr = this.buf;
        if (cArr == null) {
            buf2.append((char) ((this.off & CtaButton.BACKGROUND_COLOR) >>> 24));
        } else if (this.sort == 10) {
            buf2.append('L');
            buf2.append(this.buf, this.off, this.len);
            buf2.append(';');
        } else {
            buf2.append(cArr, this.off, this.len);
        }
    }

    public static String getInternalName(Class<?> c) {
        return c.getName().replace('.', '/');
    }

    public static String getDescriptor(Class<?> c) {
        StringBuilder buf2 = new StringBuilder();
        getDescriptor(buf2, c);
        return buf2.toString();
    }

    public static String getConstructorDescriptor(Constructor<?> c) {
        Class<?>[] parameters = c.getParameterTypes();
        StringBuilder buf2 = new StringBuilder();
        buf2.append('(');
        for (Class<?> descriptor : parameters) {
            getDescriptor(buf2, descriptor);
        }
        buf2.append(")V");
        return buf2.toString();
    }

    public static String getMethodDescriptor(Method m) {
        Class<?>[] parameters = m.getParameterTypes();
        StringBuilder buf2 = new StringBuilder();
        buf2.append('(');
        for (Class<?> descriptor : parameters) {
            getDescriptor(buf2, descriptor);
        }
        buf2.append(')');
        getDescriptor(buf2, m.getReturnType());
        return buf2.toString();
    }

    private static void getDescriptor(StringBuilder buf2, Class<?> c) {
        char car;
        Class<?> d = c;
        while (!d.isPrimitive()) {
            if (d.isArray() != 0) {
                buf2.append('[');
                d = d.getComponentType();
            } else {
                buf2.append('L');
                String name = d.getName();
                int len2 = name.length();
                for (int i = 0; i < len2; i++) {
                    char car2 = name.charAt(i);
                    buf2.append(car2 == '.' ? '/' : car2);
                }
                buf2.append(';');
                return;
            }
        }
        if (d == Integer.TYPE) {
            car = 'I';
        } else if (d == Void.TYPE) {
            car = 'V';
        } else if (d == Boolean.TYPE) {
            car = 'Z';
        } else if (d == Byte.TYPE) {
            car = 'B';
        } else if (d == Character.TYPE) {
            car = 'C';
        } else if (d == Short.TYPE) {
            car = 'S';
        } else if (d == Double.TYPE) {
            car = 'D';
        } else if (d == Float.TYPE) {
            car = 'F';
        } else {
            car = 'J';
        }
        buf2.append(car);
    }

    public int getSize() {
        if (this.buf == null) {
            return this.off & 255;
        }
        return 1;
    }

    public int getOpcode(int opcode) {
        int i = 4;
        if (opcode == 46 || opcode == 79) {
            if (this.buf == null) {
                i = (this.off & 65280) >> 8;
            }
            return i + opcode;
        }
        if (this.buf == null) {
            i = (this.off & 16711680) >> 16;
        }
        return i + opcode;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Type)) {
            return false;
        }
        Type t = (Type) o;
        int i = this.sort;
        if (i != t.sort) {
            return false;
        }
        if (i >= 9) {
            int i2 = this.len;
            if (i2 != t.len) {
                return false;
            }
            int i3 = this.off;
            int j = t.off;
            int end = i2 + i3;
            while (i3 < end) {
                if (this.buf[i3] != t.buf[j]) {
                    return false;
                }
                i3++;
                j++;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.sort;
        int hc = i * 13;
        if (i >= 9) {
            int i2 = this.off;
            int end = this.len + i2;
            while (i2 < end) {
                hc = (this.buf[i2] + hc) * 17;
                i2++;
            }
        }
        return hc;
    }

    public String toString() {
        return getDescriptor();
    }
}
