package p346g.p347a.p356a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.jmdns.ServiceInfo.Fields;
import p346g.p347a.C13820c;
import p346g.p347a.C13821d;
import p346g.p347a.C13821d.C13822a;
import p346g.p347a.p356a.C14127g.C14128a;
import p346g.p347a.p356a.C14173y.C14175b;
import p346g.p347a.p356a.C14173y.C14176c;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.j */
/* compiled from: DNSRecord */
public abstract class C14138j extends C14109b {

    /* renamed from: h */
    private static C14236b f42955h = C14246c.m45851a(C14138j.class.getName());

    /* renamed from: i */
    public static final byte[] f42956i = {0};

    /* renamed from: j */
    private int f42957j;

    /* renamed from: k */
    private long f42958k = System.currentTimeMillis();

    /* renamed from: l */
    private int f42959l = (this.f42960m + 80);

    /* renamed from: m */
    private final int f42960m = new Random().nextInt(3);

    /* renamed from: n */
    private InetAddress f42961n;

    /* renamed from: g.a.a.j$a */
    /* compiled from: DNSRecord */
    public static abstract class C14139a extends C14138j {

        /* renamed from: o */
        private static C14236b f42962o = C14246c.m45851a(C14139a.class.getName());

        /* renamed from: p */
        InetAddress f42963p;

        protected C14139a(String name, C14104e type, C14103d recordClass, boolean unique, int ttl, InetAddress addr) {
            super(name, type, recordClass, unique, ttl);
            this.f42963p = addr;
        }

        protected C14139a(String name, C14104e type, C14103d recordClass, boolean unique, int ttl, byte[] rawAddress) {
            super(name, type, recordClass, unique, ttl);
            try {
                this.f42963p = InetAddress.getByAddress(rawAddress);
            } catch (UnknownHostException exception) {
                f42962o.mo44344b("Address() exception ", exception);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public boolean mo43996e(C14138j other) {
            return mo43856b().equalsIgnoreCase(other.mo43856b());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo43987c(C14138j other) {
            try {
                if (!(other instanceof C14139a)) {
                    return false;
                }
                C14139a address = (C14139a) other;
                if (mo43997t() != null || address.mo43997t() == null) {
                    return mo43997t().equals(address.mo43997t());
                }
                return false;
            } catch (Exception e) {
                f42962o.mo44342a("Failed to compare addresses of DNSRecords", e);
                return false;
            }
        }

        /* renamed from: s */
        public boolean mo43995s() {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: t */
        public InetAddress mo43997t() {
            return this.f42963p;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43851a(DataOutputStream dout) throws IOException {
            super.mo43851a(dout);
            byte[] buffer = mo43997t().getAddress();
            for (byte writeByte : buffer) {
                dout.writeByte(writeByte);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo43982a(C14164v dns, long expirationTime) {
            if (dns.mo44086F().mo44053a(this)) {
                C14139a localAddress = dns.mo44086F().mo44048a(mo43862e(), mo43871k(), 3600);
                if (localAddress != null) {
                    int comparison = mo43849a((C14109b) localAddress);
                    if (comparison == 0) {
                        f42962o.mo44340a("handleQuery() Ignoring an identical address query");
                        return false;
                    }
                    f42962o.mo44340a("handleQuery() Conflicting query detected.");
                    if (dns.mo44098S() && comparison > 0) {
                        dns.mo44086F().mo44065h();
                        dns.mo44131z().clear();
                        for (C14096C info : dns.mo44089J().values()) {
                            info.mo43792I();
                        }
                    }
                    dns.mo44101V();
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo43985b(C14164v dns) {
            if (!dns.mo44086F().mo44053a(this)) {
                return false;
            }
            f42962o.mo44340a("handleResponse() Denial detected");
            if (dns.mo44098S()) {
                dns.mo44086F().mo44065h();
                dns.mo44131z().clear();
                for (C14096C info : dns.mo44089J().values()) {
                    info.mo43792I();
                }
            }
            dns.mo44101V();
            return true;
        }

        /* renamed from: a */
        public C13821d mo43977a(boolean persistent) {
            C14096C info = new C14096C(mo43858c(), 0, 0, 0, persistent, (byte[]) null);
            return info;
        }

        /* renamed from: a */
        public C13820c mo43976a(C14164v dns) {
            C13821d info = mo43977a(false);
            ((C14096C) info).mo43797a(dns);
            return new C14094A(dns, info.mo43185s(), info.mo43177k(), info);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43852a(StringBuilder aLog) {
            C14138j.super.mo43852a(aLog);
            StringBuilder sb = new StringBuilder();
            sb.append(" address: '");
            sb.append(mo43997t() != null ? mo43997t().getHostAddress() : "null");
            sb.append("'");
            aLog.append(sb.toString());
        }
    }

    /* renamed from: g.a.a.j$b */
    /* compiled from: DNSRecord */
    public static class C14140b extends C14138j {

        /* renamed from: o */
        String f42964o;

        /* renamed from: p */
        String f42965p;

        public C14140b(String name, C14103d recordClass, boolean unique, int ttl, String cpu, String os) {
            super(name, C14104e.TYPE_HINFO, recordClass, unique, ttl);
            this.f42965p = cpu;
            this.f42964o = os;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo43982a(C14164v dns, long expirationTime) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo43985b(C14164v dns) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo43987c(C14138j other) {
            boolean z = false;
            if (!(other instanceof C14140b)) {
                return false;
            }
            C14140b hinfo = (C14140b) other;
            if (this.f42965p == null && hinfo.f42965p != null) {
                return false;
            }
            if (this.f42964o == null && hinfo.f42964o != null) {
                return false;
            }
            if (this.f42965p.equals(hinfo.f42965p) && this.f42964o.equals(hinfo.f42964o)) {
                z = true;
            }
            return z;
        }

        /* renamed from: s */
        public boolean mo43995s() {
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43978a(C14128a out) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f42965p);
            sb.append(" ");
            sb.append(this.f42964o);
            String hostInfo = sb.toString();
            out.mo43965a(hostInfo, 0, hostInfo.length());
        }

        /* renamed from: a */
        public C13821d mo43977a(boolean persistent) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cpu", this.f42965p);
            hashMap.put("os", this.f42964o);
            C14096C c = new C14096C(mo43858c(), 0, 0, 0, persistent, (Map<String, ?>) hashMap);
            return c;
        }

        /* renamed from: a */
        public C13820c mo43976a(C14164v dns) {
            C13821d info = mo43977a(false);
            ((C14096C) info).mo43797a(dns);
            return new C14094A(dns, info.mo43185s(), info.mo43177k(), info);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43852a(StringBuilder aLog) {
            C14138j.super.mo43852a(aLog);
            StringBuilder sb = new StringBuilder();
            sb.append(" cpu: '");
            sb.append(this.f42965p);
            sb.append("' os: '");
            sb.append(this.f42964o);
            sb.append("'");
            aLog.append(sb.toString());
        }
    }

    /* renamed from: g.a.a.j$c */
    /* compiled from: DNSRecord */
    public static class C14141c extends C14139a {
        C14141c(String name, C14103d recordClass, boolean unique, int ttl, InetAddress addr) {
            super(name, C14104e.TYPE_A, recordClass, unique, ttl, addr);
        }

        C14141c(String name, C14103d recordClass, boolean unique, int ttl, byte[] rawAddress) {
            super(name, C14104e.TYPE_A, recordClass, unique, ttl, rawAddress);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43978a(C14128a out) {
            InetAddress inetAddress = this.f42963p;
            if (inetAddress != null) {
                byte[] buffer = inetAddress.getAddress();
                if (!(this.f42963p instanceof Inet4Address)) {
                    byte[] tempbuffer = buffer;
                    buffer = new byte[4];
                    System.arraycopy(tempbuffer, 12, buffer, 0, 4);
                }
                out.mo43967a(buffer, 0, buffer.length);
            }
        }

        /* renamed from: a */
        public C13821d mo43977a(boolean persistent) {
            C14096C info = (C14096C) super.mo43977a(persistent);
            info.mo43798a((Inet4Address) this.f42963p);
            return info;
        }
    }

    /* renamed from: g.a.a.j$d */
    /* compiled from: DNSRecord */
    public static class C14142d extends C14139a {
        C14142d(String name, C14103d recordClass, boolean unique, int ttl, InetAddress addr) {
            super(name, C14104e.TYPE_AAAA, recordClass, unique, ttl, addr);
        }

        C14142d(String name, C14103d recordClass, boolean unique, int ttl, byte[] rawAddress) {
            super(name, C14104e.TYPE_AAAA, recordClass, unique, ttl, rawAddress);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43978a(C14128a out) {
            InetAddress inetAddress = this.f42963p;
            if (inetAddress != null) {
                byte[] buffer = inetAddress.getAddress();
                if (this.f42963p instanceof Inet4Address) {
                    byte[] tempbuffer = buffer;
                    buffer = new byte[16];
                    for (int i = 0; i < 16; i++) {
                        if (i < 11) {
                            buffer[i] = tempbuffer[i - 12];
                        } else {
                            buffer[i] = 0;
                        }
                    }
                }
                out.mo43967a(buffer, 0, buffer.length);
            }
        }

        /* renamed from: a */
        public C13821d mo43977a(boolean persistent) {
            C14096C info = (C14096C) super.mo43977a(persistent);
            info.mo43799a((Inet6Address) this.f42963p);
            return info;
        }
    }

    /* renamed from: g.a.a.j$e */
    /* compiled from: DNSRecord */
    public static class C14143e extends C14138j {

        /* renamed from: o */
        private final String f42966o;

        public C14143e(String name, C14103d recordClass, boolean unique, int ttl, String alias) {
            super(name, C14104e.TYPE_PTR, recordClass, unique, ttl);
            this.f42966o = alias;
        }

        /* renamed from: b */
        public boolean mo43857b(C14109b entry) {
            return super.mo43857b(entry) && (entry instanceof C14143e) && mo43987c((C14143e) entry);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43978a(C14128a out) {
            out.mo43964a(this.f42966o);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo43987c(C14138j other) {
            if (!(other instanceof C14143e)) {
                return false;
            }
            C14143e pointer = (C14143e) other;
            if (this.f42966o != null || pointer.f42966o == null) {
                return this.f42966o.equals(pointer.f42966o);
            }
            return false;
        }

        /* renamed from: s */
        public boolean mo43995s() {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo43982a(C14164v dns, long expirationTime) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo43985b(C14164v dns) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: t */
        public String mo43998t() {
            return this.f42966o;
        }

        /* renamed from: a */
        public C13821d mo43977a(boolean persistent) {
            if (mo43870j()) {
                C14096C c = new C14096C(C14096C.m45045a(mo43998t()), 0, 0, 0, persistent, (byte[]) null);
                return c;
            } else if (mo43869i()) {
                C14096C c2 = new C14096C(mo43858c(), 0, 0, 0, persistent, (byte[]) null);
                return c2;
            } else if (mo43867h()) {
                C14096C c3 = new C14096C(mo43858c(), 0, 0, 0, persistent, (byte[]) null);
                return c3;
            } else {
                Map<Fields, String> map = C14096C.m45045a(mo43998t());
                map.put(C13822a.Subtype, mo43858c().get(C13822a.Subtype));
                C14096C c4 = new C14096C(map, 0, 0, 0, persistent, mo43998t());
                return c4;
            }
        }

        /* renamed from: a */
        public C13820c mo43976a(C14164v dns) {
            C13821d info = mo43977a(false);
            ((C14096C) info).mo43797a(dns);
            String domainName = info.mo43185s();
            return new C14094A(dns, domainName, C14164v.m45464a(domainName, mo43998t()), info);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43852a(StringBuilder aLog) {
            C14138j.super.mo43852a(aLog);
            StringBuilder sb = new StringBuilder();
            sb.append(" alias: '");
            String str = this.f42966o;
            sb.append(str != null ? str.toString() : "null");
            sb.append("'");
            aLog.append(sb.toString());
        }
    }

    /* renamed from: g.a.a.j$f */
    /* compiled from: DNSRecord */
    public static class C14144f extends C14138j {

        /* renamed from: o */
        private static C14236b f42967o = C14246c.m45851a(C14144f.class.getName());

        /* renamed from: p */
        private final int f42968p;

        /* renamed from: q */
        private final int f42969q;

        /* renamed from: r */
        private final int f42970r;

        /* renamed from: s */
        private final String f42971s;

        public C14144f(String name, C14103d recordClass, boolean unique, int ttl, int priority, int weight, int port, String server) {
            super(name, C14104e.TYPE_SRV, recordClass, unique, ttl);
            this.f42968p = priority;
            this.f42969q = weight;
            this.f42970r = port;
            this.f42971s = server;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43978a(C14128a out) {
            out.writeShort(this.f42968p);
            out.writeShort(this.f42969q);
            out.writeShort(this.f42970r);
            if (C14123d.f42928i) {
                out.mo43964a(this.f42971s);
                return;
            }
            String str = this.f42971s;
            out.mo43965a(str, 0, str.length());
            out.writeByte(0);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43851a(DataOutputStream dout) throws IOException {
            super.mo43851a(dout);
            dout.writeShort(this.f42968p);
            dout.writeShort(this.f42969q);
            dout.writeShort(this.f42970r);
            try {
                dout.write(this.f42971s.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: v */
        public String mo44001v() {
            return this.f42971s;
        }

        /* renamed from: u */
        public int mo44000u() {
            return this.f42968p;
        }

        /* renamed from: w */
        public int mo44002w() {
            return this.f42969q;
        }

        /* renamed from: t */
        public int mo43999t() {
            return this.f42970r;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo43987c(C14138j other) {
            boolean z = false;
            if (!(other instanceof C14144f)) {
                return false;
            }
            C14144f s = (C14144f) other;
            if (this.f42968p == s.f42968p && this.f42969q == s.f42969q && this.f42970r == s.f42970r && this.f42971s.equals(s.f42971s)) {
                z = true;
            }
            return z;
        }

        /* renamed from: s */
        public boolean mo43995s() {
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo43982a(C14164v dns, long expirationTime) {
            C14096C info = (C14096C) dns.mo44089J().get(mo43850a());
            if (info == null || ((!info.mo43788E() && !info.mo43787D()) || (this.f42970r == info.mo43178l() && this.f42971s.equalsIgnoreCase(dns.mo44086F().mo44064g())))) {
                return false;
            }
            C14236b bVar = f42967o;
            StringBuilder sb = new StringBuilder();
            sb.append("handleQuery() Conflicting probe detected from: ");
            sb.append(mo43991o());
            bVar.mo44340a(sb.toString());
            C14144f fVar = new C14144f(info.mo43181o(), C14103d.CLASS_IN, true, 3600, info.mo43179m(), info.mo43186t(), info.mo43178l(), dns.mo44086F().mo44064g());
            C14144f localService = fVar;
            try {
                if (dns.mo44084D().equals(mo43991o())) {
                    C14236b bVar2 = f42967o;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Got conflicting probe from ourselves\nincoming: ");
                    sb2.append(toString());
                    sb2.append("\n");
                    sb2.append("local   : ");
                    sb2.append(localService.toString());
                    bVar2.mo44343b(sb2.toString());
                }
            } catch (IOException e) {
                f42967o.mo44344b("IOException", e);
            }
            int comparison = mo43849a((C14109b) localService);
            if (comparison == 0) {
                f42967o.mo44340a("handleQuery() Ignoring a identical service query");
                return false;
            } else if (!info.mo43789F() || comparison <= 0) {
                return false;
            } else {
                String oldName = info.mo43181o().toLowerCase();
                info.mo43805b(C14175b.m45548a().mo44157a(dns.mo44086F().mo44062e(), info.mo43177k(), C14176c.SERVICE));
                dns.mo44089J().remove(oldName);
                dns.mo44089J().put(info.mo43181o().toLowerCase(), info);
                C14236b bVar3 = f42967o;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("handleQuery() Lost tie break: new unique name chosen:");
                sb3.append(info.mo43177k());
                bVar3.mo44340a(sb3.toString());
                info.mo43792I();
                return true;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo43985b(C14164v dns) {
            C14096C info = (C14096C) dns.mo44089J().get(mo43850a());
            if (info == null || (this.f42970r == info.mo43178l() && this.f42971s.equalsIgnoreCase(dns.mo44086F().mo44064g()))) {
                return false;
            }
            f42967o.mo44340a("handleResponse() Denial detected");
            if (info.mo43789F()) {
                String oldName = info.mo43181o().toLowerCase();
                info.mo43805b(C14175b.m45548a().mo44157a(dns.mo44086F().mo44062e(), info.mo43177k(), C14176c.SERVICE));
                dns.mo44089J().remove(oldName);
                dns.mo44089J().put(info.mo43181o().toLowerCase(), info);
                C14236b bVar = f42967o;
                StringBuilder sb = new StringBuilder();
                sb.append("handleResponse() New unique name chose:");
                sb.append(info.mo43177k());
                bVar.mo44340a(sb.toString());
            }
            info.mo43792I();
            return true;
        }

        /* renamed from: a */
        public C13821d mo43977a(boolean persistent) {
            C14096C c = new C14096C(mo43858c(), this.f42970r, this.f42969q, this.f42968p, persistent, (byte[]) null);
            return c;
        }

        /* renamed from: a */
        public C13820c mo43976a(C14164v dns) {
            C13821d info = mo43977a(false);
            ((C14096C) info).mo43797a(dns);
            return new C14094A(dns, info.mo43185s(), info.mo43177k(), info);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43852a(StringBuilder aLog) {
            C14138j.super.mo43852a(aLog);
            StringBuilder sb = new StringBuilder();
            sb.append(" server: '");
            sb.append(this.f42971s);
            sb.append(":");
            sb.append(this.f42970r);
            sb.append("'");
            aLog.append(sb.toString());
        }
    }

    /* renamed from: g.a.a.j$g */
    /* compiled from: DNSRecord */
    public static class C14145g extends C14138j {

        /* renamed from: o */
        private final byte[] f42972o;

        public C14145g(String name, C14103d recordClass, boolean unique, int ttl, byte[] text) {
            super(name, C14104e.TYPE_TXT, recordClass, unique, ttl);
            this.f42972o = (text == null || text.length <= 0) ? C14138j.f42956i : text;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: t */
        public byte[] mo44003t() {
            return this.f42972o;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43978a(C14128a out) {
            byte[] bArr = this.f42972o;
            out.mo43967a(bArr, 0, bArr.length);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo43987c(C14138j other) {
            if (!(other instanceof C14145g)) {
                return false;
            }
            C14145g txt = (C14145g) other;
            if (this.f42972o == null && txt.f42972o != null) {
                return false;
            }
            int length = txt.f42972o.length;
            byte[] bArr = this.f42972o;
            if (length != bArr.length) {
                return false;
            }
            int i = bArr.length;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (txt.f42972o[i2] != this.f42972o[i2]) {
                    return false;
                }
                i = i2;
            }
        }

        /* renamed from: s */
        public boolean mo43995s() {
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo43982a(C14164v dns, long expirationTime) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo43985b(C14164v dns) {
            return false;
        }

        /* renamed from: a */
        public C13821d mo43977a(boolean persistent) {
            C14096C c = new C14096C(mo43858c(), 0, 0, 0, persistent, this.f42972o);
            return c;
        }

        /* renamed from: a */
        public C13820c mo43976a(C14164v dns) {
            C13821d info = mo43977a(false);
            ((C14096C) info).mo43797a(dns);
            return new C14094A(dns, info.mo43185s(), info.mo43177k(), info);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43852a(StringBuilder aLog) {
            String str;
            C14138j.super.mo43852a(aLog);
            StringBuilder sb = new StringBuilder();
            sb.append(" text: '");
            byte[] bArr = this.f42972o;
            if (bArr.length > 20) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(new String(this.f42972o, 0, 17));
                sb2.append("...");
                str = sb2.toString();
            } else {
                str = new String(bArr);
            }
            sb.append(str);
            sb.append("'");
            aLog.append(sb.toString());
        }
    }

    /* renamed from: a */
    public abstract C13820c mo43976a(C14164v vVar);

    /* renamed from: a */
    public abstract C13821d mo43977a(boolean z);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo43978a(C14128a aVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract boolean mo43982a(C14164v vVar, long j);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract boolean mo43985b(C14164v vVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public abstract boolean mo43987c(C14138j jVar);

    /* renamed from: s */
    public abstract boolean mo43995s();

    C14138j(String name, C14104e type, C14103d recordClass, boolean unique, int ttl) {
        super(name, type, recordClass, unique);
        this.f42957j = ttl;
    }

    public boolean equals(Object other) {
        return (other instanceof C14138j) && super.equals(other) && mo43987c((C14138j) other);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo43984b(C14138j other) {
        return mo43862e() == other.mo43862e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo43981a(C14123d msg) {
        try {
            for (C14138j answer : msg.mo43932b()) {
                if (mo43989d(answer)) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            C14236b bVar = f42955h;
            StringBuilder sb = new StringBuilder();
            sb.append("suppressedBy() message ");
            sb.append(msg);
            sb.append(" exception ");
            bVar.mo44344b(sb.toString(), e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo43989d(C14138j other) {
        if (!equals(other) || other.f42957j <= this.f42957j / 2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo43975a(int percent) {
        return this.f42958k + (((long) (this.f42957j * percent)) * 10);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo43983b(long now) {
        return (int) Math.max(0, (mo43975a(100) - now) / 1000);
    }

    /* renamed from: a */
    public boolean mo43853a(long now) {
        return mo43975a(100) <= now;
    }

    /* renamed from: c */
    public boolean mo43986c(long now) {
        return mo43975a(50) <= now;
    }

    /* renamed from: d */
    public boolean mo43988d(long now) {
        return mo43975a(this.f42959l) <= now;
    }

    /* renamed from: r */
    public void mo43994r() {
        this.f42959l += 5;
        if (this.f42959l > 100) {
            this.f42959l = 100;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo43979a(C14138j other) {
        this.f42958k = other.f42958k;
        this.f42957j = other.f42957j;
        this.f42959l = this.f42960m + 80;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo43990e(long now) {
        this.f42958k = now;
        this.f42957j = 1;
    }

    /* renamed from: p */
    public C13821d mo43992p() {
        return mo43977a(false);
    }

    /* renamed from: a */
    public void mo43980a(InetAddress source) {
        this.f42961n = source;
    }

    /* renamed from: o */
    public InetAddress mo43991o() {
        return this.f42961n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo43852a(StringBuilder aLog) {
        super.mo43852a(aLog);
        StringBuilder sb = new StringBuilder();
        sb.append(" ttl: '");
        sb.append(mo43983b(System.currentTimeMillis()));
        sb.append("/");
        sb.append(this.f42957j);
        sb.append("'");
        aLog.append(sb.toString());
    }

    /* renamed from: q */
    public int mo43993q() {
        return this.f42957j;
    }
}
