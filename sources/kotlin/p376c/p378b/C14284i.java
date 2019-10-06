package kotlin.p376c.p378b;

import kotlin.p381e.C14298b;
import kotlin.p381e.C14307i;

/* renamed from: kotlin.c.b.i */
/* compiled from: PropertyReference */
public abstract class C14284i extends C14274a implements C14307i {
    public C14284i() {
    }

    public C14284i(Object receiver) {
        super(receiver);
    }

    /* access modifiers changed from: protected */
    public C14307i getReflected() {
        return (C14307i) super.getReflected();
    }

    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C14284i) {
            C14284i other = (C14284i) obj;
            if (!getOwner().equals(other.getOwner()) || !getName().equals(other.getName()) || !getSignature().equals(other.getSignature()) || !C14281f.m45915a(getBoundReceiver(), other.getBoundReceiver())) {
                z = false;
            }
            return z;
        } else if (obj instanceof C14307i) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        C14298b reflected = compute();
        if (reflected != this) {
            return reflected.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("property ");
        sb.append(getName());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
