package com.facebook.internal;

import java.util.EnumSet;
import java.util.Iterator;

/* renamed from: com.facebook.internal.O */
/* compiled from: SmartLoginOption */
public enum C6691O {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    

    /* renamed from: d */
    public static final EnumSet<C6691O> f12217d = null;

    /* renamed from: f */
    private final long f12219f;

    static {
        f12217d = EnumSet.allOf(C6691O.class);
    }

    /* renamed from: a */
    public static EnumSet<C6691O> m13391a(long bitmask) {
        EnumSet<SmartLoginOption> result = EnumSet.noneOf(C6691O.class);
        Iterator it = f12217d.iterator();
        while (it.hasNext()) {
            C6691O opt = (C6691O) it.next();
            if ((opt.mo19906e() & bitmask) != 0) {
                result.add(opt);
            }
        }
        return result;
    }

    private C6691O(long value) {
        this.f12219f = value;
    }

    /* renamed from: e */
    public long mo19906e() {
        return this.f12219f;
    }
}
