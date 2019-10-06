package com.google.gson.p192b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: com.google.gson.b.b */
/* compiled from: $Gson$Types */
public final class C10139b {

    /* renamed from: a */
    static final Type[] f30789a = new Type[0];

    /* renamed from: com.google.gson.b.b$a */
    /* compiled from: $Gson$Types */
    private static final class C10140a implements GenericArrayType, Serializable {

        /* renamed from: a */
        private final Type f30790a;

        public C10140a(Type componentType) {
            this.f30790a = C10139b.m33060b(componentType);
        }

        public Type getGenericComponentType() {
            return this.f30790a;
        }

        public boolean equals(Object o) {
            return (o instanceof GenericArrayType) && C10139b.m33059a((Type) this, (Type) (GenericArrayType) o);
        }

        public int hashCode() {
            return this.f30790a.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(C10139b.m33068h(this.f30790a));
            sb.append("[]");
            return sb.toString();
        }
    }

    /* renamed from: com.google.gson.b.b$b */
    /* compiled from: $Gson$Types */
    private static final class C10141b implements ParameterizedType, Serializable {

        /* renamed from: a */
        private final Type f30791a;

        /* renamed from: b */
        private final Type f30792b;

        /* renamed from: c */
        private final Type[] f30793c;

        public C10141b(Type ownerType, Type rawType, Type... typeArguments) {
            if (rawType instanceof Class) {
                Class<?> rawTypeAsClass = (Class) rawType;
                boolean z = false;
                boolean isStaticOrTopLevelClass = Modifier.isStatic(rawTypeAsClass.getModifiers()) || rawTypeAsClass.getEnclosingClass() == null;
                if (ownerType != null || isStaticOrTopLevelClass) {
                    z = true;
                }
                C10068a.m32843a(z);
            }
            this.f30791a = ownerType == null ? null : C10139b.m33060b(ownerType);
            this.f30792b = C10139b.m33060b(rawType);
            this.f30793c = (Type[]) typeArguments.clone();
            int length = this.f30793c.length;
            for (int t = 0; t < length; t++) {
                C10068a.m32842a(this.f30793c[t]);
                C10139b.m33063c(this.f30793c[t]);
                Type[] typeArr = this.f30793c;
                typeArr[t] = C10139b.m33060b(typeArr[t]);
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f30793c.clone();
        }

        public Type getRawType() {
            return this.f30792b;
        }

        public Type getOwnerType() {
            return this.f30791a;
        }

        public boolean equals(Object other) {
            return (other instanceof ParameterizedType) && C10139b.m33059a((Type) this, (Type) (ParameterizedType) other);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f30793c) ^ this.f30792b.hashCode()) ^ C10139b.m33048a((Object) this.f30791a);
        }

        public String toString() {
            int length = this.f30793c.length;
            if (length == 0) {
                return C10139b.m33068h(this.f30792b);
            }
            StringBuilder stringBuilder = new StringBuilder((length + 1) * 30);
            stringBuilder.append(C10139b.m33068h(this.f30792b));
            stringBuilder.append("<");
            stringBuilder.append(C10139b.m33068h(this.f30793c[0]));
            for (int i = 1; i < length; i++) {
                stringBuilder.append(", ");
                stringBuilder.append(C10139b.m33068h(this.f30793c[i]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.gson.b.b$c */
    /* compiled from: $Gson$Types */
    private static final class C10142c implements WildcardType, Serializable {

        /* renamed from: a */
        private final Type f30794a;

        /* renamed from: b */
        private final Type f30795b;

        public C10142c(Type[] upperBounds, Type[] lowerBounds) {
            boolean z = true;
            C10068a.m32843a(lowerBounds.length <= 1);
            C10068a.m32843a(upperBounds.length == 1);
            if (lowerBounds.length == 1) {
                C10068a.m32842a(lowerBounds[0]);
                C10139b.m33063c(lowerBounds[0]);
                if (upperBounds[0] != Object.class) {
                    z = false;
                }
                C10068a.m32843a(z);
                this.f30795b = C10139b.m33060b(lowerBounds[0]);
                this.f30794a = Object.class;
                return;
            }
            C10068a.m32842a(upperBounds[0]);
            C10139b.m33063c(upperBounds[0]);
            this.f30795b = null;
            this.f30794a = C10139b.m33060b(upperBounds[0]);
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f30794a};
        }

        public Type[] getLowerBounds() {
            Type type = this.f30795b;
            if (type == null) {
                return C10139b.f30789a;
            }
            return new Type[]{type};
        }

        public boolean equals(Object other) {
            return (other instanceof WildcardType) && C10139b.m33059a((Type) this, (Type) (WildcardType) other);
        }

        public int hashCode() {
            Type type = this.f30795b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f30794a.hashCode() + 31);
        }

        public String toString() {
            if (this.f30795b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("? super ");
                sb.append(C10139b.m33068h(this.f30795b));
                return sb.toString();
            } else if (this.f30794a == Object.class) {
                return "?";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("? extends ");
                sb2.append(C10139b.m33068h(this.f30794a));
                return sb2.toString();
            }
        }
    }

    /* renamed from: a */
    public static ParameterizedType m33052a(Type ownerType, Type rawType, Type... typeArguments) {
        return new C10141b(ownerType, rawType, typeArguments);
    }

    /* renamed from: a */
    public static GenericArrayType m33051a(Type componentType) {
        return new C10140a(componentType);
    }

    /* renamed from: f */
    public static WildcardType m33066f(Type bound) {
        return new C10142c(bound instanceof WildcardType ? ((WildcardType) bound).getUpperBounds() : new Type[]{bound}, f30789a);
    }

    /* renamed from: g */
    public static WildcardType m33067g(Type bound) {
        return new C10142c(new Type[]{Object.class}, bound instanceof WildcardType ? ((WildcardType) bound).getLowerBounds() : new Type[]{bound});
    }

    /* renamed from: b */
    public static Type m33060b(Type type) {
        if (type instanceof Class) {
            Class<?> c = (Class) type;
            return c.isArray() ? new C10140a(m33060b(c.getComponentType())) : c;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) type;
            return new C10141b(p.getOwnerType(), p.getRawType(), p.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C10140a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType w = (WildcardType) type;
            return new C10142c(w.getUpperBounds(), w.getLowerBounds());
        }
    }

    /* renamed from: e */
    public static Class<?> m33065e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C10068a.m32843a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(m33065e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return m33065e(((WildcardType) type).getUpperBounds()[0]);
            }
            String className = type == null ? "null" : type.getClass().getName();
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            sb.append(type);
            sb.append("> is of type ");
            sb.append(className);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    static boolean m33058a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    /* renamed from: a */
    public static boolean m33059a(Type a, Type b) {
        boolean z = true;
        if (a == b) {
            return true;
        }
        if (a instanceof Class) {
            return a.equals(b);
        }
        if (a instanceof ParameterizedType) {
            if (!(b instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType pa = (ParameterizedType) a;
            ParameterizedType pb = (ParameterizedType) b;
            if (!m33058a((Object) pa.getOwnerType(), (Object) pb.getOwnerType()) || !pa.getRawType().equals(pb.getRawType()) || !Arrays.equals(pa.getActualTypeArguments(), pb.getActualTypeArguments())) {
                z = false;
            }
            return z;
        } else if (a instanceof GenericArrayType) {
            if (!(b instanceof GenericArrayType)) {
                return false;
            }
            return m33059a(((GenericArrayType) a).getGenericComponentType(), ((GenericArrayType) b).getGenericComponentType());
        } else if (a instanceof WildcardType) {
            if (!(b instanceof WildcardType)) {
                return false;
            }
            WildcardType wa = (WildcardType) a;
            WildcardType wb = (WildcardType) b;
            if (!Arrays.equals(wa.getUpperBounds(), wb.getUpperBounds()) || !Arrays.equals(wa.getLowerBounds(), wb.getLowerBounds())) {
                z = false;
            }
            return z;
        } else if (!(a instanceof TypeVariable) || !(b instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable<?> va = (TypeVariable) a;
            TypeVariable<?> vb = (TypeVariable) b;
            if (va.getGenericDeclaration() != vb.getGenericDeclaration() || !va.getName().equals(vb.getName())) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: a */
    static int m33048a(Object o) {
        if (o != null) {
            return o.hashCode();
        }
        return 0;
    }

    /* renamed from: h */
    public static String m33068h(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: a */
    static Type m33054a(Type context, Class<?> rawType, Class<?> toResolve) {
        if (toResolve == rawType) {
            return context;
        }
        if (toResolve.isInterface()) {
            Class<?>[] interfaces = rawType.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == toResolve) {
                    return rawType.getGenericInterfaces()[i];
                }
                if (toResolve.isAssignableFrom(interfaces[i])) {
                    return m33054a(rawType.getGenericInterfaces()[i], interfaces[i], toResolve);
                }
            }
        }
        if (!rawType.isInterface()) {
            while (rawType != Object.class) {
                Class<?> rawSupertype = rawType.getSuperclass();
                if (rawSupertype == toResolve) {
                    return rawType.getGenericSuperclass();
                }
                if (toResolve.isAssignableFrom(rawSupertype)) {
                    return m33054a(rawType.getGenericSuperclass(), rawSupertype, toResolve);
                }
                rawType = rawSupertype;
            }
        }
        return toResolve;
    }

    /* renamed from: b */
    static Type m33061b(Type context, Class<?> contextRawType, Class<?> supertype) {
        C10068a.m32843a(supertype.isAssignableFrom(contextRawType));
        return m33055a(context, contextRawType, m33054a(context, contextRawType, supertype));
    }

    /* renamed from: d */
    public static Type m33064d(Type array) {
        if (array instanceof GenericArrayType) {
            return ((GenericArrayType) array).getGenericComponentType();
        }
        return ((Class) array).getComponentType();
    }

    /* renamed from: a */
    public static Type m33053a(Type context, Class<?> contextRawType) {
        Type collectionType = m33061b(context, contextRawType, Collection.class);
        if (collectionType instanceof WildcardType) {
            collectionType = ((WildcardType) collectionType).getUpperBounds()[0];
        }
        if (collectionType instanceof ParameterizedType) {
            return ((ParameterizedType) collectionType).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    /* renamed from: b */
    public static Type[] m33062b(Type context, Class<?> contextRawType) {
        if (context == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type mapType = m33061b(context, contextRawType, Map.class);
        if (mapType instanceof ParameterizedType) {
            return ((ParameterizedType) mapType).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    /* renamed from: a */
    public static Type m33055a(Type context, Class<?> contextRawType, Type toResolve) {
        return m33056a(context, contextRawType, toResolve, new HashSet());
    }

    /* renamed from: a */
    private static Type m33056a(Type context, Class<?> contextRawType, Type toResolve, Collection<TypeVariable> visitedTypeVariables) {
        GenericArrayType genericArrayType;
        Type type;
        while (toResolve instanceof TypeVariable) {
            TypeVariable<?> typeVariable = (TypeVariable) toResolve;
            if (visitedTypeVariables.contains(typeVariable)) {
                return toResolve;
            }
            visitedTypeVariables.add(typeVariable);
            toResolve = m33057a(context, contextRawType, typeVariable);
            if (toResolve == typeVariable) {
                return toResolve;
            }
        }
        if ((toResolve instanceof Class) && ((Class) toResolve).isArray()) {
            Class<?> original = (Class) toResolve;
            Type componentType = original.getComponentType();
            Type newComponentType = m33056a(context, contextRawType, componentType, visitedTypeVariables);
            if (componentType == newComponentType) {
                type = original;
            } else {
                type = m33051a(newComponentType);
            }
            return type;
        } else if (toResolve instanceof GenericArrayType) {
            GenericArrayType original2 = (GenericArrayType) toResolve;
            Type componentType2 = original2.getGenericComponentType();
            Type newComponentType2 = m33056a(context, contextRawType, componentType2, visitedTypeVariables);
            if (componentType2 == newComponentType2) {
                genericArrayType = original2;
            } else {
                genericArrayType = m33051a(newComponentType2);
            }
            return genericArrayType;
        } else {
            boolean changed = true;
            if (toResolve instanceof ParameterizedType) {
                ParameterizedType original3 = (ParameterizedType) toResolve;
                Type ownerType = original3.getOwnerType();
                Type newOwnerType = m33056a(context, contextRawType, ownerType, visitedTypeVariables);
                if (newOwnerType == ownerType) {
                    changed = false;
                }
                Type[] args = original3.getActualTypeArguments();
                int length = args.length;
                for (int t = 0; t < length; t++) {
                    Type resolvedTypeArgument = m33056a(context, contextRawType, args[t], visitedTypeVariables);
                    if (resolvedTypeArgument != args[t]) {
                        if (!changed) {
                            args = (Type[]) args.clone();
                            changed = true;
                        }
                        args[t] = resolvedTypeArgument;
                    }
                }
                return changed ? m33052a(newOwnerType, original3.getRawType(), args) : original3;
            } else if (!(toResolve instanceof WildcardType)) {
                return toResolve;
            } else {
                WildcardType original4 = (WildcardType) toResolve;
                Type[] originalLowerBound = original4.getLowerBounds();
                Type[] originalUpperBound = original4.getUpperBounds();
                if (originalLowerBound.length == 1) {
                    Type lowerBound = m33056a(context, contextRawType, originalLowerBound[0], visitedTypeVariables);
                    if (lowerBound != originalLowerBound[0]) {
                        return m33067g(lowerBound);
                    }
                } else if (originalUpperBound.length == 1) {
                    Type upperBound = m33056a(context, contextRawType, originalUpperBound[0], visitedTypeVariables);
                    if (upperBound != originalUpperBound[0]) {
                        return m33066f(upperBound);
                    }
                }
                return original4;
            }
        }
    }

    /* renamed from: a */
    static Type m33057a(Type context, Class<?> contextRawType, TypeVariable<?> unknown) {
        Class<?> declaredByRaw = m33050a(unknown);
        if (declaredByRaw == null) {
            return unknown;
        }
        Type declaredBy = m33054a(context, contextRawType, declaredByRaw);
        if (!(declaredBy instanceof ParameterizedType)) {
            return unknown;
        }
        return ((ParameterizedType) declaredBy).getActualTypeArguments()[m33049a((Object[]) declaredByRaw.getTypeParameters(), (Object) unknown)];
    }

    /* renamed from: a */
    private static int m33049a(Object[] array, Object toFind) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (toFind.equals(array[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private static Class<?> m33050a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* renamed from: c */
    static void m33063c(Type type) {
        C10068a.m32843a(!(type instanceof Class) || !((Class) type).isPrimitive());
    }
}
