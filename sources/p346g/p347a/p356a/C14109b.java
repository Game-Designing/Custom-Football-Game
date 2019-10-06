package p346g.p347a.p356a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import p346g.p347a.C13821d.C13822a;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;

/* renamed from: g.a.a.b */
/* compiled from: DNSEntry */
public abstract class C14109b {

    /* renamed from: a */
    private final String f42896a;

    /* renamed from: b */
    private final String f42897b;

    /* renamed from: c */
    private final String f42898c;

    /* renamed from: d */
    private final C14104e f42899d;

    /* renamed from: e */
    private final C14103d f42900e;

    /* renamed from: f */
    private final boolean f42901f;

    /* renamed from: g */
    final Map<C13822a, String> f42902g = C14096C.m45045a(mo43856b());

    /* renamed from: a */
    public abstract boolean mo43853a(long j);

    C14109b(String name, C14104e type, C14103d recordClass, boolean unique) {
        String str;
        String str2;
        this.f42897b = name;
        this.f42899d = type;
        this.f42900e = recordClass;
        this.f42901f = unique;
        String domain = (String) this.f42902g.get(C13822a.Domain);
        String protocol = (String) this.f42902g.get(C13822a.Protocol);
        String application = (String) this.f42902g.get(C13822a.Application);
        String instance = ((String) this.f42902g.get(C13822a.Instance)).toLowerCase();
        StringBuilder sb = new StringBuilder();
        String str3 = "_";
        String str4 = "";
        String str5 = ".";
        if (application.length() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(application);
            sb2.append(str5);
            str = sb2.toString();
        } else {
            str = str4;
        }
        sb.append(str);
        if (protocol.length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(protocol);
            sb3.append(str5);
            str2 = sb3.toString();
        } else {
            str2 = str4;
        }
        sb.append(str2);
        sb.append(domain);
        sb.append(str5);
        this.f42898c = sb.toString();
        StringBuilder sb4 = new StringBuilder();
        if (instance.length() > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(instance);
            sb5.append(str5);
            str4 = sb5.toString();
        }
        sb4.append(str4);
        sb4.append(this.f42898c);
        this.f42896a = sb4.toString().toLowerCase();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C14109b)) {
            return false;
        }
        C14109b other = (C14109b) obj;
        return mo43850a().equals(other.mo43850a()) && mo43862e().equals(other.mo43862e()) && mo43860d() == other.mo43860d();
    }

    /* renamed from: b */
    public boolean mo43857b(C14109b entry) {
        return mo43850a().equals(entry.mo43850a()) && mo43855a(entry.mo43862e()) && mo43854a(entry.mo43860d());
    }

    /* renamed from: e */
    public boolean mo43863e(C14109b other) {
        return mo43865f().equals(other.mo43865f());
    }

    /* renamed from: a */
    public boolean mo43854a(C14103d recordClass) {
        C14103d dVar = C14103d.CLASS_ANY;
        return dVar == recordClass || dVar == mo43860d() || mo43860d().equals(recordClass);
    }

    /* renamed from: a */
    public boolean mo43855a(C14104e recordType) {
        return mo43862e().equals(recordType);
    }

    /* renamed from: f */
    public String mo43865f() {
        String subtype = (String) mo43858c().get(C13822a.Subtype);
        return subtype != null ? subtype : "";
    }

    /* renamed from: b */
    public String mo43856b() {
        String str = this.f42897b;
        return str != null ? str : "";
    }

    /* renamed from: g */
    public String mo43866g() {
        String str = this.f42898c;
        return str != null ? str : "";
    }

    /* renamed from: a */
    public String mo43850a() {
        String str = this.f42896a;
        return str != null ? str : "";
    }

    /* renamed from: e */
    public C14104e mo43862e() {
        C14104e eVar = this.f42899d;
        return eVar != null ? eVar : C14104e.TYPE_IGNORE;
    }

    /* renamed from: d */
    public C14103d mo43860d() {
        C14103d dVar = this.f42900e;
        return dVar != null ? dVar : C14103d.CLASS_UNKNOWN;
    }

    /* renamed from: k */
    public boolean mo43871k() {
        return this.f42901f;
    }

    /* renamed from: c */
    public Map<C13822a, String> mo43858c() {
        return Collections.unmodifiableMap(this.f42902g);
    }

    /* renamed from: j */
    public boolean mo43870j() {
        return ((String) this.f42902g.get(C13822a.Application)).equals("dns-sd") && ((String) this.f42902g.get(C13822a.Instance)).equals("_services");
    }

    /* renamed from: h */
    public boolean mo43867h() {
        boolean z = false;
        if (!((String) this.f42902g.get(C13822a.Application)).equals("dns-sd")) {
            return false;
        }
        String name = (String) this.f42902g.get(C13822a.Instance);
        if ("b".equals(name) || "db".equals(name) || "r".equals(name) || "dr".equals(name) || "lb".equals(name)) {
            z = true;
        }
        return z;
    }

    /* renamed from: i */
    public boolean mo43869i() {
        return mo43872l() || mo43873m();
    }

    /* renamed from: l */
    public boolean mo43872l() {
        return ((String) this.f42902g.get(C13822a.Domain)).endsWith("in-addr.arpa");
    }

    /* renamed from: m */
    public boolean mo43873m() {
        return ((String) this.f42902g.get(C13822a.Domain)).endsWith("ip6.arpa");
    }

    /* renamed from: c */
    public boolean mo43859c(C14109b entry) {
        return entry != null && entry.mo43860d() == mo43860d();
    }

    /* renamed from: d */
    public boolean mo43861d(C14109b entry) {
        return entry != null && entry.mo43862e() == mo43862e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo43851a(DataOutputStream dout) throws IOException {
        dout.write(mo43856b().getBytes("UTF8"));
        dout.writeShort(mo43862e().mo43835e());
        dout.writeShort(mo43860d().mo43833e());
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public byte[] mo43874n() {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            DataOutputStream dout = new DataOutputStream(bout);
            mo43851a(dout);
            dout.close();
            return bout.toByteArray();
        } catch (IOException e) {
            throw new InternalError();
        }
    }

    /* renamed from: a */
    public int mo43849a(C14109b that) {
        byte[] thisBytes = mo43874n();
        byte[] thatBytes = that.mo43874n();
        int n = Math.min(thisBytes.length, thatBytes.length);
        for (int i = 0; i < n; i++) {
            if (thisBytes[i] > thatBytes[i]) {
                return 1;
            }
            if (thisBytes[i] < thatBytes[i]) {
                return -1;
            }
        }
        return thisBytes.length - thatBytes.length;
    }

    public int hashCode() {
        return mo43850a().hashCode() + mo43862e().mo43835e() + mo43860d().mo43833e();
    }

    public String toString() {
        StringBuilder aLog = new StringBuilder(200);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(System.identityHashCode(this));
        aLog.append(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" type: ");
        sb2.append(mo43862e());
        aLog.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(", class: ");
        sb3.append(mo43860d());
        aLog.append(sb3.toString());
        aLog.append(this.f42901f ? "-unique," : ",");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" name: ");
        sb4.append(this.f42897b);
        aLog.append(sb4.toString());
        mo43852a(aLog);
        aLog.append("]");
        return aLog.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo43852a(StringBuilder aLog) {
    }
}
