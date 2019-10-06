package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.annotation.NoClass;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ClassUtil {
    private static final Class<?> CLS_OBJECT = Object.class;
    private static final Iterator<?> EMPTY_ITERATOR = Collections.emptyIterator();
    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    private static final Ctor[] NO_CTORS = new Ctor[0];

    public static final class Ctor {
        public final Constructor<?> _ctor;
        private Annotation[][] _paramAnnotations;
        private int _paramCount = -1;

        public Ctor(Constructor<?> ctor) {
            this._ctor = ctor;
        }

        public Constructor<?> getConstructor() {
            return this._ctor;
        }

        public int getParamCount() {
            int c = this._paramCount;
            if (c >= 0) {
                return c;
            }
            int c2 = this._ctor.getParameterTypes().length;
            this._paramCount = c2;
            return c2;
        }

        public Class<?> getDeclaringClass() {
            return this._ctor.getDeclaringClass();
        }

        public Annotation[][] getParameterAnnotations() {
            Annotation[][] result = this._paramAnnotations;
            if (result != null) {
                return result;
            }
            Annotation[][] result2 = this._ctor.getParameterAnnotations();
            this._paramAnnotations = result2;
            return result2;
        }
    }

    private static class EnumTypeLocator {
        static final EnumTypeLocator instance = new EnumTypeLocator();
        private final Field enumMapTypeField;
        private final Field enumSetTypeField;

        private EnumTypeLocator() {
            String str = "elementType";
            this.enumSetTypeField = locateField(EnumSet.class, str, Class.class);
            this.enumMapTypeField = locateField(EnumMap.class, str, Class.class);
        }

        public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> set) {
            Field field = this.enumSetTypeField;
            if (field != null) {
                return (Class) get(set, field);
            }
            throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
        }

        public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> set) {
            Field field = this.enumMapTypeField;
            if (field != null) {
                return (Class) get(set, field);
            }
            throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
        }

        private Object get(Object bean, Field field) {
            try {
                return field.get(bean);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        private static Field locateField(Class<?> fromClass, String expectedName, Class<?> type) {
            Field[] arr$;
            Field found = null;
            Field[] fields = ClassUtil.getDeclaredFields(fromClass);
            Field[] arr$2 = fields;
            int len$ = arr$2.length;
            int i$ = 0;
            while (true) {
                if (i$ >= len$) {
                    break;
                }
                Field f = arr$2[i$];
                if (expectedName.equals(f.getName()) && f.getType() == type) {
                    found = f;
                    break;
                }
                i$++;
            }
            if (found == null) {
                for (Field f2 : fields) {
                    if (f2.getType() == type) {
                        if (found != null) {
                            return null;
                        }
                        found = f2;
                    }
                }
            }
            if (found != null) {
                try {
                    found.setAccessible(true);
                } catch (Throwable th) {
                }
            }
            return found;
        }
    }

    public static <T> Iterator<T> emptyIterator() {
        return EMPTY_ITERATOR;
    }

    public static List<JavaType> findSuperTypes(JavaType type, Class<?> endBefore, boolean addClassItself) {
        if (type == null || type.hasRawClass(endBefore) || type.hasRawClass(Object.class)) {
            return Collections.emptyList();
        }
        List<JavaType> result = new ArrayList<>(8);
        _addSuperTypes(type, endBefore, result, addClassItself);
        return result;
    }

    public static List<Class<?>> findRawSuperTypes(Class<?> cls, Class<?> endBefore, boolean addClassItself) {
        if (cls == null || cls == endBefore || cls == Object.class) {
            return Collections.emptyList();
        }
        List<Class<?>> result = new ArrayList<>(8);
        _addRawSuperTypes(cls, endBefore, result, addClassItself);
        return result;
    }

    public static List<Class<?>> findSuperClasses(Class<?> cls, Class<?> endBefore, boolean addClassItself) {
        List<Class<?>> result = new LinkedList<>();
        if (cls != null && cls != endBefore) {
            if (addClassItself) {
                result.add(cls);
            }
            while (true) {
                Class<?> superclass = cls.getSuperclass();
                cls = superclass;
                if (superclass == null || cls == endBefore) {
                    break;
                }
                result.add(cls);
            }
        }
        return result;
    }

    private static void _addSuperTypes(JavaType type, Class<?> endBefore, Collection<JavaType> result, boolean addClassItself) {
        if (type != null) {
            Class<?> cls = type.getRawClass();
            if (cls != endBefore && cls != Object.class) {
                if (addClassItself) {
                    if (!result.contains(type)) {
                        result.add(type);
                    } else {
                        return;
                    }
                }
                for (JavaType intCls : type.getInterfaces()) {
                    _addSuperTypes(intCls, endBefore, result, true);
                }
                _addSuperTypes(type.getSuperClass(), endBefore, result, true);
            }
        }
    }

    private static void _addRawSuperTypes(Class<?> cls, Class<?> endBefore, Collection<Class<?>> result, boolean addClassItself) {
        if (cls != endBefore && cls != null && cls != Object.class) {
            if (addClassItself) {
                if (!result.contains(cls)) {
                    result.add(cls);
                } else {
                    return;
                }
            }
            for (Class<?> intCls : _interfaces(cls)) {
                _addRawSuperTypes(intCls, endBefore, result, true);
            }
            _addRawSuperTypes(cls.getSuperclass(), endBefore, result, true);
        }
    }

    public static String canBeABeanType(Class<?> type) {
        if (type.isAnnotation()) {
            return "annotation";
        }
        if (type.isArray()) {
            return "array";
        }
        if (type.isEnum()) {
            return "enum";
        }
        if (type.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static String isLocalType(Class<?> type, boolean allowNonStatic) {
        try {
            if (hasEnclosingMethod(type)) {
                return "local/anonymous";
            }
            if (!allowNonStatic && !Modifier.isStatic(type.getModifiers()) && getEnclosingClass(type) != null) {
                return "non-static member class";
            }
            return null;
        } catch (NullPointerException | SecurityException e) {
        }
    }

    public static Class<?> getOuterClass(Class<?> type) {
        try {
            if (!hasEnclosingMethod(type) && !Modifier.isStatic(type.getModifiers())) {
                return getEnclosingClass(type);
            }
        } catch (SecurityException e) {
        }
        return null;
    }

    public static boolean isProxyType(Class<?> type) {
        String name = type.getName();
        if (name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.")) {
            return true;
        }
        return false;
    }

    public static boolean isConcrete(Class<?> type) {
        return (type.getModifiers() & 1536) == 0;
    }

    public static boolean isBogusClass(Class<?> cls) {
        return cls == Void.class || cls == Void.TYPE || cls == NoClass.class;
    }

    public static boolean isNonStaticInnerClass(Class<?> cls) {
        return !Modifier.isStatic(cls.getModifiers()) && getEnclosingClass(cls) != null;
    }

    public static boolean isObjectOrPrimitive(Class<?> cls) {
        return cls == CLS_OBJECT || cls.isPrimitive();
    }

    public static boolean hasClass(Object inst, Class<?> raw) {
        return inst != null && inst.getClass() == raw;
    }

    public static void verifyMustOverride(Class<?> expType, Object instance, String method) {
        if (instance.getClass() != expType) {
            throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", new Object[]{instance.getClass().getName(), expType.getName(), method}));
        }
    }

    public static Throwable throwIfError(Throwable t) {
        if (!(t instanceof Error)) {
            return t;
        }
        throw ((Error) t);
    }

    public static Throwable throwIfRTE(Throwable t) {
        if (!(t instanceof RuntimeException)) {
            return t;
        }
        throw ((RuntimeException) t);
    }

    public static Throwable throwIfIOE(Throwable t) throws IOException {
        if (!(t instanceof IOException)) {
            return t;
        }
        throw ((IOException) t);
    }

    public static Throwable getRootCause(Throwable t) {
        while (t.getCause() != null) {
            t = t.getCause();
        }
        return t;
    }

    public static Throwable throwRootCauseIfIOE(Throwable t) throws IOException {
        Throwable rootCause = getRootCause(t);
        throwIfIOE(rootCause);
        return rootCause;
    }

    public static void throwAsIAE(Throwable t) {
        throwAsIAE(t, t.getMessage());
        throw null;
    }

    public static void throwAsIAE(Throwable t, String msg) {
        throwIfRTE(t);
        throwIfError(t);
        throw new IllegalArgumentException(msg, t);
    }

    public static <T> T throwAsMappingException(DeserializationContext ctxt, IOException e0) throws JsonMappingException {
        if (e0 instanceof JsonMappingException) {
            throw ((JsonMappingException) e0);
        }
        JsonMappingException e = JsonMappingException.from(ctxt, e0.getMessage());
        e.initCause(e0);
        throw e;
    }

    public static void unwrapAndThrowAsIAE(Throwable t) {
        throwAsIAE(getRootCause(t));
        throw null;
    }

    public static void unwrapAndThrowAsIAE(Throwable t, String msg) {
        throwAsIAE(getRootCause(t), msg);
        throw null;
    }

    public static void closeOnFailAndThrowAsIOE(JsonGenerator g, Exception fail) throws IOException {
        g.disable(Feature.AUTO_CLOSE_JSON_CONTENT);
        try {
            g.close();
        } catch (Exception e) {
        }
        throwIfIOE(fail);
        throwIfRTE(fail);
        throw new RuntimeException(fail);
    }

    public static void closeOnFailAndThrowAsIOE(JsonGenerator g, Closeable toClose, Exception fail) throws IOException {
        if (g != null) {
            g.disable(Feature.AUTO_CLOSE_JSON_CONTENT);
            try {
                g.close();
            } catch (Exception e) {
            }
        }
        if (toClose != null) {
            try {
                toClose.close();
            } catch (Exception e2) {
            }
        }
        throwIfIOE(fail);
        throwIfRTE(fail);
        throw new RuntimeException(fail);
    }

    public static <T> T createInstance(Class<T> cls, boolean canFixAccess) throws IllegalArgumentException {
        Constructor<T> ctor = findConstructor(cls, canFixAccess);
        if (ctor != null) {
            try {
                return ctor.newInstance(new Object[0]);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to instantiate class ");
                sb.append(cls.getName());
                sb.append(", problem: ");
                sb.append(e.getMessage());
                unwrapAndThrowAsIAE(e, sb.toString());
                throw null;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Class ");
            sb2.append(cls.getName());
            sb2.append(" has no default (no arg) constructor");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("Failed to find default constructor of class ");
        r0.append(r5.getName());
        r0.append(", problem: ");
        r0.append(r6.getMessage());
        unwrapAndThrowAsIAE(r6, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0060, code lost:
        throw null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[ExcHandler: Exception (r6v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.lang.reflect.Constructor<T> findConstructor(java.lang.Class<T> r5, boolean r6) throws java.lang.IllegalArgumentException {
        /*
            r0 = 0
            r1 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x0061, Exception -> 0x003b }
            java.lang.reflect.Constructor r0 = r5.getDeclaredConstructor(r0)     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            if (r6 == 0) goto L_0x000e
            checkAndFixAccess(r0, r6)     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            goto L_0x0018
        L_0x000e:
            int r2 = r0.getModifiers()     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            if (r2 == 0) goto L_0x0019
        L_0x0018:
            return r0
        L_0x0019:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            r3.<init>()     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            java.lang.String r4 = "Default constructor for "
            r3.append(r4)     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            java.lang.String r4 = r5.getName()     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            r3.append(r4)     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            java.lang.String r4 = " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type"
            r3.append(r4)     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            java.lang.String r3 = r3.toString()     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            r2.<init>(r3)     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
            throw r2     // Catch:{ NoSuchMethodException -> 0x0039, Exception -> 0x003b }
        L_0x0039:
            r0 = move-exception
            goto L_0x0062
        L_0x003b:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Failed to find default constructor of class "
            r0.append(r2)
            java.lang.String r5 = r5.getName()
            r0.append(r5)
            java.lang.String r5 = ", problem: "
            r0.append(r5)
            java.lang.String r5 = r6.getMessage()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            unwrapAndThrowAsIAE(r6, r5)
            throw r1
        L_0x0061:
            r0 = move-exception
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.ClassUtil.findConstructor(java.lang.Class, boolean):java.lang.reflect.Constructor");
    }

    public static Class<?> classOf(Object inst) {
        if (inst == null) {
            return null;
        }
        return inst.getClass();
    }

    public static Class<?> rawClass(JavaType t) {
        if (t == null) {
            return null;
        }
        return t.getRawClass();
    }

    public static <T> T nonNull(T valueOrNull, T defaultValue) {
        return valueOrNull == null ? defaultValue : valueOrNull;
    }

    public static String nullOrToString(Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static String nonNullString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String quotedOr(Object str, String forNull) {
        if (str == null) {
            return forNull;
        }
        return String.format("\"%s\"", new Object[]{str});
    }

    public static String classNameOf(Object inst) {
        if (inst == null) {
            return "[null]";
        }
        return nameOf(inst.getClass());
    }

    public static String nameOf(Class<?> cls) {
        if (cls == null) {
            return "[null]";
        }
        int index = 0;
        while (cls.isArray()) {
            index++;
            cls = cls.getComponentType();
        }
        String base = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (index > 0) {
            StringBuilder sb = new StringBuilder(base);
            do {
                sb.append("[]");
                index--;
            } while (index > 0);
            base = sb.toString();
        }
        return backticked(base);
    }

    public static String nameOf(Named named) {
        if (named == null) {
            return "[null]";
        }
        return backticked(named.getName());
    }

    public static String backticked(String text) {
        if (text == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(text.length() + 2);
        sb.append('`');
        sb.append(text);
        sb.append('`');
        return sb.toString();
    }

    public static Object defaultValue(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return Integer.valueOf(0);
        }
        if (cls == Long.TYPE) {
            return Long.valueOf(0);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Byte.TYPE) {
            return Byte.valueOf(0);
        }
        if (cls == Short.TYPE) {
            return Short.valueOf(0);
        }
        if (cls == Character.TYPE) {
            return Character.valueOf(0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Class ");
        sb.append(cls.getName());
        sb.append(" is not a primitive type");
        throw new IllegalArgumentException(sb.toString());
    }

    public static Class<?> wrapperType(Class<?> primitiveType) {
        if (primitiveType == Integer.TYPE) {
            return Integer.class;
        }
        if (primitiveType == Long.TYPE) {
            return Long.class;
        }
        if (primitiveType == Boolean.TYPE) {
            return Boolean.class;
        }
        if (primitiveType == Double.TYPE) {
            return Double.class;
        }
        if (primitiveType == Float.TYPE) {
            return Float.class;
        }
        if (primitiveType == Byte.TYPE) {
            return Byte.class;
        }
        if (primitiveType == Short.TYPE) {
            return Short.class;
        }
        if (primitiveType == Character.TYPE) {
            return Character.class;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Class ");
        sb.append(primitiveType.getName());
        sb.append(" is not a primitive type");
        throw new IllegalArgumentException(sb.toString());
    }

    public static Class<?> primitiveType(Class<?> type) {
        if (type.isPrimitive()) {
            return type;
        }
        if (type == Integer.class) {
            return Integer.TYPE;
        }
        if (type == Long.class) {
            return Long.TYPE;
        }
        if (type == Boolean.class) {
            return Boolean.TYPE;
        }
        if (type == Double.class) {
            return Double.TYPE;
        }
        if (type == Float.class) {
            return Float.TYPE;
        }
        if (type == Byte.class) {
            return Byte.TYPE;
        }
        if (type == Short.class) {
            return Short.TYPE;
        }
        if (type == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    public static void checkAndFixAccess(Member member, boolean force) {
        AccessibleObject ao = (AccessibleObject) member;
        if (!force) {
            try {
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return;
                }
            } catch (SecurityException se) {
                if (!ao.isAccessible()) {
                    Class<?> declClass = member.getDeclaringClass();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot access ");
                    sb.append(member);
                    sb.append(" (from class ");
                    sb.append(declClass.getName());
                    sb.append("; failed to set access: ");
                    sb.append(se.getMessage());
                    throw new IllegalArgumentException(sb.toString());
                }
                return;
            }
        }
        ao.setAccessible(true);
    }

    public static Class<? extends Enum<?>> findEnumType(EnumSet<?> s) {
        if (!s.isEmpty()) {
            return findEnumType((Enum) s.iterator().next());
        }
        return EnumTypeLocator.instance.enumTypeFor(s);
    }

    public static Class<? extends Enum<?>> findEnumType(EnumMap<?, ?> m) {
        if (!m.isEmpty()) {
            return findEnumType((Enum) m.keySet().iterator().next());
        }
        return EnumTypeLocator.instance.enumTypeFor(m);
    }

    public static Class<? extends Enum<?>> findEnumType(Enum<?> en) {
        Class<?> ec = en.getClass();
        if (ec.getSuperclass() != Enum.class) {
            return ec.getSuperclass();
        }
        return ec;
    }

    public static Class<? extends Enum<?>> findEnumType(Class<?> cls) {
        if (cls.getSuperclass() != Enum.class) {
            return cls.getSuperclass();
        }
        return cls;
    }

    public static <T extends Annotation> Enum<?> findFirstAnnotatedEnumValue(Class<Enum<?>> enumClass, Class<T> annotationClass) {
        Field[] arr$;
        Enum<?>[] arr$2;
        for (Field field : getDeclaredFields(enumClass)) {
            if (field.isEnumConstant() && field.getAnnotation(annotationClass) != null) {
                String name = field.getName();
                for (Enum<?> enumValue : (Enum[]) enumClass.getEnumConstants()) {
                    if (name.equals(enumValue.name())) {
                        return enumValue;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static boolean isJacksonStdImpl(Object impl) {
        return impl == null || isJacksonStdImpl(impl.getClass());
    }

    public static boolean isJacksonStdImpl(Class<?> implClass) {
        return implClass.getAnnotation(JacksonStdImpl.class) != null;
    }

    public static String getPackageName(Class<?> cls) {
        Package pkg = cls.getPackage();
        if (pkg == null) {
            return null;
        }
        return pkg.getName();
    }

    public static boolean hasEnclosingMethod(Class<?> cls) {
        return !isObjectOrPrimitive(cls) && cls.getEnclosingMethod() != null;
    }

    public static Field[] getDeclaredFields(Class<?> cls) {
        return cls.getDeclaredFields();
    }

    public static Method[] getDeclaredMethods(Class<?> cls) {
        return cls.getDeclaredMethods();
    }

    public static Annotation[] findClassAnnotations(Class<?> cls) {
        if (isObjectOrPrimitive(cls)) {
            return NO_ANNOTATIONS;
        }
        return cls.getDeclaredAnnotations();
    }

    public static Method[] getClassMethods(Class<?> cls) {
        try {
            return getDeclaredMethods(cls);
        } catch (NoClassDefFoundError ex) {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader != null) {
                try {
                    return loader.loadClass(cls.getName()).getDeclaredMethods();
                } catch (ClassNotFoundException e) {
                    throw ex;
                }
            } else {
                throw ex;
            }
        }
    }

    public static Ctor[] getConstructors(Class<?> cls) {
        if (cls.isInterface() || isObjectOrPrimitive(cls)) {
            return NO_CTORS;
        }
        Constructor<?>[] rawCtors = cls.getDeclaredConstructors();
        int len = rawCtors.length;
        Ctor[] result = new Ctor[len];
        for (int i = 0; i < len; i++) {
            result[i] = new Ctor(rawCtors[i]);
        }
        return result;
    }

    public static Type getGenericSuperclass(Class<?> cls) {
        return cls.getGenericSuperclass();
    }

    public static Type[] getGenericInterfaces(Class<?> cls) {
        return cls.getGenericInterfaces();
    }

    public static Class<?> getEnclosingClass(Class<?> cls) {
        if (isObjectOrPrimitive(cls)) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    private static Class<?>[] _interfaces(Class<?> cls) {
        return cls.getInterfaces();
    }
}
