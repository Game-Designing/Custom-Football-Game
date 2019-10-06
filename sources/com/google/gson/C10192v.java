package com.google.gson;

import com.google.gson.p192b.C10068a;
import com.google.gson.p192b.C10161u;
import java.math.BigInteger;

/* renamed from: com.google.gson.v */
/* compiled from: JsonPrimitive */
public final class C10192v extends C10188s {

    /* renamed from: a */
    private static final Class<?>[] f30876a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b */
    private Object f30877b;

    public C10192v(Boolean bool) {
        mo33477a((Object) bool);
    }

    public C10192v(Number number) {
        mo33477a((Object) number);
    }

    public C10192v(String string) {
        mo33477a((Object) string);
    }

    C10192v(Object primitive) {
        mo33477a(primitive);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33477a(Object primitive) {
        if (primitive instanceof Character) {
            this.f30877b = String.valueOf(((Character) primitive).charValue());
            return;
        }
        C10068a.m32843a((primitive instanceof Number) || m33179b(primitive));
        this.f30877b = primitive;
    }

    /* renamed from: p */
    public boolean mo33483p() {
        return this.f30877b instanceof Boolean;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public Boolean mo33480m() {
        return (Boolean) this.f30877b;
    }

    /* renamed from: a */
    public boolean mo33433a() {
        if (mo33483p()) {
            return mo33480m().booleanValue();
        }
        return Boolean.parseBoolean(mo33439h());
    }

    /* renamed from: q */
    public boolean mo33484q() {
        return this.f30877b instanceof Number;
    }

    /* renamed from: o */
    public Number mo33482o() {
        Object obj = this.f30877b;
        return obj instanceof String ? new C10161u((String) obj) : (Number) obj;
    }

    /* renamed from: r */
    public boolean mo33485r() {
        return this.f30877b instanceof String;
    }

    /* renamed from: h */
    public String mo33439h() {
        if (mo33484q()) {
            return mo33482o().toString();
        }
        if (mo33483p()) {
            return mo33480m().toString();
        }
        return (String) this.f30877b;
    }

    /* renamed from: n */
    public double mo33481n() {
        return mo33484q() ? mo33482o().doubleValue() : Double.parseDouble(mo33439h());
    }

    /* renamed from: b */
    public float mo33434b() {
        return mo33484q() ? mo33482o().floatValue() : Float.parseFloat(mo33439h());
    }

    /* renamed from: g */
    public long mo33437g() {
        return mo33484q() ? mo33482o().longValue() : Long.parseLong(mo33439h());
    }

    /* renamed from: c */
    public int mo33435c() {
        return mo33484q() ? mo33482o().intValue() : Integer.parseInt(mo33439h());
    }

    /* renamed from: b */
    private static boolean m33179b(Object target) {
        if (target instanceof String) {
            return true;
        }
        Class<?> classOfPrimitive = target.getClass();
        for (Class<?> standardPrimitive : f30876a) {
            if (standardPrimitive.isAssignableFrom(classOfPrimitive)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f30877b == null) {
            return 31;
        }
        if (m33178a(this)) {
            long value = mo33482o().longValue();
            return (int) ((value >>> 32) ^ value);
        }
        Object obj = this.f30877b;
        if (!(obj instanceof Number)) {
            return obj.hashCode();
        }
        long value2 = Double.doubleToLongBits(mo33482o().doubleValue());
        return (int) ((value2 >>> 32) ^ value2);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C10192v other = (C10192v) obj;
        if (this.f30877b == null) {
            if (other.f30877b != null) {
                z = false;
            }
            return z;
        } else if (m33178a(this) && m33178a(other)) {
            if (mo33482o().longValue() != other.mo33482o().longValue()) {
                z = false;
            }
            return z;
        } else if (!(this.f30877b instanceof Number) || !(other.f30877b instanceof Number)) {
            return this.f30877b.equals(other.f30877b);
        } else {
            double a = mo33482o().doubleValue();
            double b = other.mo33482o().doubleValue();
            if (a != b && (!Double.isNaN(a) || !Double.isNaN(b))) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: a */
    private static boolean m33178a(C10192v primitive) {
        Object obj = primitive.f30877b;
        boolean z = false;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            z = true;
        }
        return z;
    }
}
