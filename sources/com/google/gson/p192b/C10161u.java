package com.google.gson.p192b;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* renamed from: com.google.gson.b.u */
/* compiled from: LazilyParsedNumber */
public final class C10161u extends Number {

    /* renamed from: a */
    private final String f30833a;

    public C10161u(String value) {
        this.f30833a = value;
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f30833a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f30833a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f30833a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f30833a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f30833a).longValue();
        }
    }

    public float floatValue() {
        return Float.parseFloat(this.f30833a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f30833a);
    }

    public String toString() {
        return this.f30833a;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f30833a);
    }

    public int hashCode() {
        return this.f30833a.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10161u)) {
            return false;
        }
        C10161u other = (C10161u) obj;
        String str = this.f30833a;
        String str2 = other.f30833a;
        if (str != str2 && !str.equals(str2)) {
            z = false;
        }
        return z;
    }
}
