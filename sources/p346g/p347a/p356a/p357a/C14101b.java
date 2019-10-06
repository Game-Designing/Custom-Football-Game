package p346g.p347a.p356a.p357a;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: g.a.a.a.b */
/* compiled from: DNSLabel */
public enum C14101b {
    Unknown("", 128),
    Standard("standard label", 0),
    Compressed("compressed label", Opcodes.CHECKCAST),
    Extended("extended label", 64);
    

    /* renamed from: f */
    private final String f42773f;

    /* renamed from: g */
    private final int f42774g;

    private C14101b(String name, int index) {
        this.f42773f = name;
        this.f42774g = index;
    }

    /* renamed from: e */
    public int mo43828e() {
        return this.f42774g;
    }

    /* renamed from: a */
    public static C14101b m45108a(int index) {
        C14101b[] arr$;
        int maskedIndex = index & Opcodes.CHECKCAST;
        for (C14101b aLabel : values()) {
            if (aLabel.f42774g == maskedIndex) {
                return aLabel;
            }
        }
        return Unknown;
    }

    /* renamed from: b */
    public static int m45109b(int index) {
        return index & 63;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" index ");
        sb.append(mo43828e());
        return sb.toString();
    }
}
