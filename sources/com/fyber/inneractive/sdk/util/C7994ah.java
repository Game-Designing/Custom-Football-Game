package com.fyber.inneractive.sdk.util;

/* renamed from: com.fyber.inneractive.sdk.util.ah */
public final class C7994ah {

    /* renamed from: a */
    public int f16318a;

    /* renamed from: b */
    public int f16319b;

    public C7994ah(int i, int i2) {
        this.f16318a = i;
        this.f16319b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C7994ah.class != obj.getClass()) {
            return false;
        }
        C7994ah ahVar = (C7994ah) obj;
        if (this.f16318a == ahVar.f16318a && this.f16319b == ahVar.f16319b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f16318a * 31) + this.f16319b;
    }
}
