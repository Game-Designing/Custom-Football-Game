package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Handle */
public final class Handle {
    final String desc;
    final boolean itf;
    final String name;
    final String owner;
    final int tag;

    @Deprecated
    public Handle(int tag2, String owner2, String name2, String desc2) {
        this(tag2, owner2, name2, desc2, tag2 == 9);
    }

    public Handle(int tag2, String owner2, String name2, String desc2, boolean itf2) {
        this.tag = tag2;
        this.owner = owner2;
        this.name = name2;
        this.desc = desc2;
        this.itf = itf2;
    }

    public int getTag() {
        return this.tag;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isInterface() {
        return this.itf;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle)) {
            return false;
        }
        Handle h = (Handle) obj;
        if (this.tag != h.tag || this.itf != h.itf || !this.owner.equals(h.owner) || !this.name.equals(h.name) || !this.desc.equals(h.desc)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.tag + (this.itf ? 64 : 0) + (this.owner.hashCode() * this.name.hashCode() * this.desc.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.owner);
        sb.append('.');
        sb.append(this.name);
        sb.append(this.desc);
        sb.append(" (");
        sb.append(this.tag);
        sb.append(this.itf ? " itf" : "");
        sb.append(')');
        return sb.toString();
    }
}
