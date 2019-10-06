package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p053g.p061f.C1255d;

@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    /* renamed from: a */
    private static <T> Set<T> m22081a(int i, boolean z) {
        float f = z ? 0.75f : 1.0f;
        if (i <= (z ? 128 : Opcodes.ACC_NATIVE)) {
            return new C1255d(i);
        }
        return new HashSet(i, f);
    }

    @KeepForSdk
    @Deprecated
    /* renamed from: a */
    public static <T> Set<T> m22082a(T t, T t2, T t3) {
        Set a = m22081a(3, false);
        a.add(t);
        a.add(t2);
        a.add(t3);
        return Collections.unmodifiableSet(a);
    }

    @KeepForSdk
    @Deprecated
    /* renamed from: a */
    public static <T> Set<T> m22083a(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set a = m22081a(2, false);
            a.add(t);
            a.add(t2);
            return Collections.unmodifiableSet(a);
        } else if (length == 3) {
            return m22082a(tArr[0], tArr[1], tArr[2]);
        } else {
            if (length != 4) {
                Set a2 = m22081a(tArr.length, false);
                Collections.addAll(a2, tArr);
                return Collections.unmodifiableSet(a2);
            }
            T t3 = tArr[0];
            T t4 = tArr[1];
            T t5 = tArr[2];
            T t6 = tArr[3];
            Set a3 = m22081a(4, false);
            a3.add(t3);
            a3.add(t4);
            a3.add(t5);
            a3.add(t6);
            return Collections.unmodifiableSet(a3);
        }
    }

    /* renamed from: b */
    private static <K, V> Map<K, V> m22084b(int i, boolean z) {
        if (i <= 256) {
            return new C1253b(i);
        }
        return new HashMap(i, 1.0f);
    }

    @KeepForSdk
    /* renamed from: a */
    public static <K, V> Map<K, V> m22079a(K k, V v, K k2, V v2, K k3, V v3) {
        Map b = m22084b(3, false);
        b.put(k, v);
        b.put(k2, v2);
        b.put(k3, v3);
        return Collections.unmodifiableMap(b);
    }

    @KeepForSdk
    /* renamed from: a */
    public static <K, V> Map<K, V> m22080a(K[] kArr, V[] vArr) {
        if (kArr.length == vArr.length) {
            int length = kArr.length;
            if (length == 0) {
                return Collections.emptyMap();
            }
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map b = m22084b(kArr.length, false);
            for (int i = 0; i < kArr.length; i++) {
                b.put(kArr[i], vArr[i]);
            }
            return Collections.unmodifiableMap(b);
        }
        int length2 = kArr.length;
        int length3 = vArr.length;
        StringBuilder sb = new StringBuilder(66);
        sb.append("Key and values array lengths not equal: ");
        sb.append(length2);
        sb.append(" != ");
        sb.append(length3);
        throw new IllegalArgumentException(sb.toString());
    }
}
