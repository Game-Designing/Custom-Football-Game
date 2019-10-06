package p346g.p347a.p356a.p357a;

import p005cm.aptoide.p006pt.database.realm.Notification;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.a.e */
/* compiled from: DNSRecordType */
public enum C14104e {
    TYPE_IGNORE("ignore", 0),
    TYPE_A("a", 1),
    TYPE_NS("ns", 2),
    TYPE_MD("md", 3),
    TYPE_MF("mf", 4),
    TYPE_CNAME("cname", 5),
    TYPE_SOA("soa", 6),
    TYPE_MB("mb", 7),
    TYPE_MG("mg", 8),
    TYPE_MR("mr", 9),
    TYPE_NULL("null", 10),
    TYPE_WKS("wks", 11),
    TYPE_PTR("ptr", 12),
    TYPE_HINFO("hinfo", 13),
    TYPE_MINFO("minfo", 14),
    TYPE_MX("mx", 15),
    TYPE_TXT("txt", 16),
    TYPE_RP("rp", 17),
    TYPE_AFSDB("afsdb", 18),
    TYPE_X25("x25", 19),
    TYPE_ISDN("isdn", 20),
    TYPE_RT("rt", 21),
    TYPE_NSAP("nsap", 22),
    TYPE_NSAP_PTR("nsap-otr", 23),
    TYPE_SIG("sig", 24),
    TYPE_KEY(Notification.KEY, 25),
    TYPE_PX("px", 26),
    TYPE_GPOS("gpos", 27),
    TYPE_AAAA("aaaa", 28),
    TYPE_LOC("loc", 29),
    TYPE_NXT("nxt", 30),
    TYPE_EID("eid", 31),
    TYPE_NIMLOC("nimloc", 32),
    TYPE_SRV("srv", 33),
    TYPE_ATMA("atma", 34),
    TYPE_NAPTR("naptr", 35),
    TYPE_KX("kx", 36),
    TYPE_CERT("cert", 37),
    TYPE_A6("a6", 38),
    TYPE_DNAME("dname", 39),
    TYPE_SINK("sink", 40),
    TYPE_OPT("opt", 41),
    TYPE_APL("apl", 42),
    TYPE_DS("ds", 43),
    TYPE_SSHFP("sshfp", 44),
    TYPE_RRSIG("rrsig", 46),
    TYPE_NSEC("nsec", 47),
    TYPE_DNSKEY("dnskey", 48),
    TYPE_UINFO("uinfo", 100),
    TYPE_UID("uid", 101),
    TYPE_GID("gid", 102),
    TYPE_UNSPEC("unspec", 103),
    TYPE_TKEY("tkey", 249),
    TYPE_TSIG("tsig", 250),
    TYPE_IXFR("ixfr", 251),
    TYPE_AXFR("axfr", 252),
    TYPE_MAILA("mails", 253),
    TYPE_MAILB("mailb", 254),
    TYPE_ANY("any", 255);
    

    /* renamed from: ha */
    private static C14236b f42835ha;

    /* renamed from: ja */
    private final String f42855ja;

    /* renamed from: ka */
    private final int f42856ka;

    static {
        f42835ha = C14246c.m45851a(C14104e.class.getName());
    }

    private C14104e(String name, int index) {
        this.f42855ja = name;
        this.f42856ka = index;
    }

    /* renamed from: e */
    public int mo43835e() {
        return this.f42856ka;
    }

    /* renamed from: a */
    public static C14104e m45116a(int index) {
        C14104e[] arr$;
        for (C14104e aType : values()) {
            if (aType.f42856ka == index) {
                return aType;
            }
        }
        C14236b bVar = f42835ha;
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find record type for index: ");
        sb.append(index);
        bVar.mo44343b(sb.toString());
        return TYPE_IGNORE;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" index ");
        sb.append(mo43835e());
        return sb.toString();
    }
}
