package p346g.p347a.p356a.p357a;

/* renamed from: g.a.a.a.c */
/* compiled from: DNSOptionCode */
public enum C14102c {
    f42775a(r2, 65535),
    f42776b(r2, 1),
    f42777c(r2, 2),
    f42778d(r2, 3),
    f42779e(r2, 4);
    

    /* renamed from: g */
    private final String f42781g;

    /* renamed from: h */
    private final int f42782h;

    private C14102c(String name, int index) {
        this.f42781g = name;
        this.f42782h = index;
    }

    /* renamed from: e */
    public int mo43830e() {
        return this.f42782h;
    }

    /* renamed from: a */
    public static C14102c m45111a(int optioncode) {
        C14102c[] arr$;
        int maskedIndex = optioncode;
        for (C14102c aCode : values()) {
            if (aCode.f42782h == maskedIndex) {
                return aCode;
            }
        }
        return f42775a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" index ");
        sb.append(mo43830e());
        return sb.toString();
    }
}
