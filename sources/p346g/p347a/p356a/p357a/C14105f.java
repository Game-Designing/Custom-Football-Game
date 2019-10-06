package p346g.p347a.p356a.p357a;

/* renamed from: g.a.a.a.f */
/* compiled from: DNSResultCode */
public enum C14105f {
    f42857a(r1, 65535),
    NoError("No Error", 0),
    FormErr("Format Error", 1),
    ServFail("Server Failure", 2),
    NXDomain("Non-Existent Domain", 3),
    NotImp("Not Implemented", 4),
    Refused("Query Refused", 5),
    YXDomain("Name Exists when it should not", 6),
    YXRRSet("RR Set Exists when it should not", 7),
    NXRRSet("RR Set that should exist does not", 8),
    NotAuth("Server Not Authoritative for zone", 9),
    NotZone("NotZone Name not contained in zone", 10);
    

    /* renamed from: n */
    private final String f42870n;

    /* renamed from: o */
    private final int f42871o;

    private C14105f(String name, int index) {
        this.f42870n = name;
        this.f42871o = index;
    }

    /* renamed from: e */
    public int mo43837e() {
        return this.f42871o;
    }

    /* renamed from: a */
    public static C14105f m45118a(int flags, int extendedRCode) {
        C14105f[] arr$;
        int maskedIndex = ((extendedRCode >> 28) & 255) | (flags & 15);
        for (C14105f aCode : values()) {
            if (aCode.f42871o == maskedIndex) {
                return aCode;
            }
        }
        return f42857a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" index ");
        sb.append(mo43837e());
        return sb.toString();
    }
}
