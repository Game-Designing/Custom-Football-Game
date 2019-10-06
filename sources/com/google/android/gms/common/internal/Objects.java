package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public final class Objects {

    @KeepForSdk
    public static final class ToStringHelper {

        /* renamed from: a */
        private final List<String> f20118a;

        /* renamed from: b */
        private final Object f20119b;

        private ToStringHelper(Object obj) {
            Preconditions.m21857a(obj);
            this.f20119b = obj;
            this.f20118a = new ArrayList();
        }

        @KeepForSdk
        /* renamed from: a */
        public final ToStringHelper mo27810a(String str, Object obj) {
            List<String> list = this.f20118a;
            Preconditions.m21857a(str);
            String str2 = str;
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @KeepForSdk
        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f20119b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f20118a.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.f20118a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public static boolean m21851a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @KeepForSdk
    /* renamed from: a */
    public static int m21849a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @KeepForSdk
    /* renamed from: a */
    public static ToStringHelper m21850a(Object obj) {
        return new ToStringHelper(obj);
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }
}
