package kotlin.p376c.p378b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.TypeCastException;

/* renamed from: kotlin.c.b.d */
/* compiled from: CollectionToArray.kt */
public final class C14279d {

    /* renamed from: a */
    private static final Object[] f43216a = new Object[0];

    /* renamed from: a */
    public static final Object[] m45909a(Collection<?> collection) {
        C14281f.m45916b(collection, "collection");
        int size$iv = collection.size();
        if (size$iv == 0) {
            return f43216a;
        }
        Iterator iter$iv = collection.iterator();
        if (!iter$iv.hasNext()) {
            return f43216a;
        }
        Object[] result$iv = new Object[size$iv];
        int i$iv = 0;
        while (true) {
            int i$iv2 = i$iv + 1;
            result$iv[i$iv] = iter$iv.next();
            if (i$iv2 >= result$iv.length) {
                if (!iter$iv.hasNext()) {
                    return result$iv;
                }
                int newSize$iv = ((i$iv2 * 3) + 1) >>> 1;
                if (newSize$iv <= i$iv2) {
                    if (i$iv2 < 2147483645) {
                        newSize$iv = 2147483645;
                    } else {
                        throw new OutOfMemoryError();
                    }
                }
                Object[] copyOf = Arrays.copyOf(result$iv, newSize$iv);
                C14281f.m45913a((Object) copyOf, "Arrays.copyOf(result, newSize)");
                result$iv = copyOf;
            } else if (!iter$iv.hasNext()) {
                Object[] copyOf2 = Arrays.copyOf(result$iv, i$iv2);
                C14281f.m45913a((Object) copyOf2, "Arrays.copyOf(result, size)");
                return copyOf2;
            }
            i$iv = i$iv2;
        }
    }

    /* renamed from: a */
    public static final Object[] m45910a(Collection<?> collection, Object[] a) {
        Object[] objArr;
        Object[] objArr2;
        C14281f.m45916b(collection, "collection");
        if (a != null) {
            int size$iv = collection.size();
            if (size$iv != 0) {
                Iterator iter$iv = collection.iterator();
                if (iter$iv.hasNext()) {
                    int size = size$iv;
                    if (size <= a.length) {
                        objArr = a;
                    } else {
                        Object newInstance = Array.newInstance(a.getClass().getComponentType(), size);
                        if (newInstance != null) {
                            objArr = (Object[]) newInstance;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                        }
                    }
                    Object[] result$iv = objArr;
                    int i$iv = 0;
                    while (true) {
                        int i$iv2 = i$iv + 1;
                        result$iv[i$iv] = iter$iv.next();
                        if (i$iv2 >= result$iv.length) {
                            if (!iter$iv.hasNext()) {
                                return result$iv;
                            }
                            int newSize$iv = ((i$iv2 * 3) + 1) >>> 1;
                            if (newSize$iv <= i$iv2) {
                                if (i$iv2 < 2147483645) {
                                    newSize$iv = 2147483645;
                                } else {
                                    throw new OutOfMemoryError();
                                }
                            }
                            Object[] copyOf = Arrays.copyOf(result$iv, newSize$iv);
                            C14281f.m45913a((Object) copyOf, "Arrays.copyOf(result, newSize)");
                            result$iv = copyOf;
                        } else if (!iter$iv.hasNext()) {
                            Object[] result = result$iv;
                            int size2 = i$iv2;
                            if (result == a) {
                                a[size2] = null;
                                objArr2 = a;
                            } else {
                                objArr2 = Arrays.copyOf(result, size2);
                                C14281f.m45913a((Object) objArr2, "Arrays.copyOf(result, size)");
                            }
                            return objArr2;
                        }
                        i$iv = i$iv2;
                    }
                } else if (a.length > 0) {
                    a[0] = null;
                }
            } else if (a.length > 0) {
                a[0] = null;
            }
            return a;
        }
        throw new NullPointerException();
    }
}
