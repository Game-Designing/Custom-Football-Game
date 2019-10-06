package p346g.p347a.p356a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.jmdns.impl.DNSRecord;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p346g.p347a.C13817b.C13818a;
import p346g.p347a.p356a.C14138j.C14139a;
import p346g.p347a.p356a.C14138j.C14141c;
import p346g.p347a.p356a.C14138j.C14142d;
import p346g.p347a.p356a.C14138j.C14143e;
import p346g.p347a.p356a.C14146k.C14148b;
import p346g.p347a.p356a.C14173y.C14175b;
import p346g.p347a.p356a.C14173y.C14176c;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;
import p346g.p347a.p356a.p357a.C14107h;
import p346g.p347a.p356a.p358b.C14110a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.n */
/* compiled from: HostInfo */
public class C14155n implements C14146k {

    /* renamed from: a */
    private static C14236b f42990a = C14246c.m45851a(C14155n.class.getName());

    /* renamed from: b */
    protected String f42991b;

    /* renamed from: c */
    protected InetAddress f42992c;

    /* renamed from: d */
    protected NetworkInterface f42993d;

    /* renamed from: e */
    private final C14156a f42994e;

    /* renamed from: g.a.a.n$a */
    /* compiled from: HostInfo */
    private static final class C14156a extends C14148b {
        public C14156a(C14164v dns) {
            mo43815a(dns);
        }
    }

    /* renamed from: a */
    public static C14155n m45429a(InetAddress address, C14164v dns, String jmdnsName) {
        String aName = jmdnsName != null ? jmdnsName : "";
        InetAddress addr = address;
        if (addr == null) {
            try {
                String ip = System.getProperty("net.mdns.interface");
                if (ip != null) {
                    addr = InetAddress.getByName(ip);
                } else {
                    addr = InetAddress.getLocalHost();
                    if (addr.isLoopbackAddress()) {
                        InetAddress[] addresses = C13818a.m43916a().mo43163a();
                        if (addresses.length > 0) {
                            addr = addresses[0];
                        }
                    }
                }
                if (addr.isLoopbackAddress()) {
                    f42990a.mo44343b("Could not find any address beside the loopback.");
                }
            } catch (IOException e) {
                C14236b bVar = f42990a;
                StringBuilder sb = new StringBuilder();
                sb.append("Could not initialize the host network interface on ");
                sb.append(address);
                sb.append("because of an error: ");
                sb.append(e.getMessage());
                bVar.mo44344b(sb.toString(), e);
                addr = m45433q();
                aName = (jmdnsName == null || jmdnsName.length() <= 0) ? "computer" : jmdnsName;
            }
        }
        if (aName.length() == 0) {
            aName = addr.getHostName();
        }
        if (aName.contains("in-addr.arpa") || aName.equals(addr.getHostAddress())) {
            aName = (jmdnsName == null || jmdnsName.length() <= 0) ? addr.getHostAddress() : jmdnsName;
        }
        int index = aName.indexOf(".local");
        if (index > 0) {
            aName = aName.substring(0, index);
        }
        String aName2 = aName.replaceAll("[:%\\.]", "-");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aName2);
        sb2.append(".local.");
        return new C14155n(addr, sb2.toString(), dns);
    }

    /* renamed from: q */
    private static InetAddress m45433q() {
        try {
            return InetAddress.getByName(null);
        } catch (UnknownHostException e) {
            return null;
        }
    }

    private C14155n(InetAddress address, String name, C14164v dns) {
        this.f42994e = new C14156a(dns);
        this.f42992c = address;
        this.f42991b = name;
        if (address != null) {
            try {
                this.f42993d = NetworkInterface.getByInetAddress(address);
            } catch (Exception exception) {
                f42990a.mo44344b("LocalHostInfo() exception ", exception);
            }
        }
    }

    /* renamed from: g */
    public String mo44064g() {
        return this.f42991b;
    }

    /* renamed from: e */
    public InetAddress mo44062e() {
        return this.f42992c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Inet4Address mo44060c() {
        if (mo44062e() instanceof Inet4Address) {
            return (Inet4Address) this.f42992c;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Inet6Address mo44061d() {
        if (mo44062e() instanceof Inet6Address) {
            return (Inet6Address) this.f42992c;
        }
        return null;
    }

    /* renamed from: f */
    public NetworkInterface mo44063f() {
        return this.f42993d;
    }

    /* renamed from: a */
    public boolean mo44053a(C14139a record) {
        C14139a hostAddress = mo44048a(record.mo43862e(), record.mo43871k(), 3600);
        boolean z = false;
        if (hostAddress == null) {
            return false;
        }
        if (hostAddress.mo43984b((C14138j) record) && hostAddress.mo43996e(record) && !hostAddress.mo43987c(record)) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public synchronized String mo44065h() {
        this.f42991b = C14175b.m45548a().mo44157a(mo44062e(), this.f42991b, C14176c.HOST);
        return this.f42991b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo44054a(DatagramPacket packet) {
        boolean result = false;
        if (mo44062e() == null) {
            return false;
        }
        InetAddress from = packet.getAddress();
        if (from == null) {
            return false;
        }
        if ((mo44062e().isLinkLocalAddress() || mo44062e().isMCLinkLocal()) && !from.isLinkLocalAddress()) {
            result = true;
        }
        if (!from.isLoopbackAddress() || mo44062e().isLoopbackAddress()) {
            return result;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C14139a mo44048a(C14104e type, boolean unique, int ttl) {
        int i = C14154m.f42989a[type.ordinal()];
        if (i == 1) {
            return m45428a(unique, ttl);
        }
        if (i == 2 || i == 3) {
            return m45431c(unique, ttl);
        }
        return null;
    }

    /* renamed from: a */
    private C14139a m45428a(boolean unique, int ttl) {
        if (!(mo44062e() instanceof Inet4Address)) {
            return null;
        }
        C14141c cVar = new C14141c(mo44064g(), C14103d.CLASS_IN, unique, ttl, mo44062e());
        return cVar;
    }

    /* renamed from: c */
    private C14139a m45431c(boolean unique, int ttl) {
        if (!(mo44062e() instanceof Inet6Address)) {
            return null;
        }
        C14142d dVar = new C14142d(mo44064g(), C14103d.CLASS_IN, unique, ttl, mo44062e());
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C14143e mo44055b(C14104e type, boolean unique, int ttl) {
        int i = C14154m.f42989a[type.ordinal()];
        if (i == 1) {
            return m45430b(unique, ttl);
        }
        if (i == 2 || i == 3) {
            return m45432d(unique, ttl);
        }
        return null;
    }

    /* renamed from: b */
    private C14143e m45430b(boolean unique, int ttl) {
        if (!(mo44062e() instanceof Inet4Address)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo44062e().getHostAddress());
        sb.append(".in-addr.arpa.");
        C14143e eVar = new C14143e(sb.toString(), C14103d.CLASS_IN, unique, ttl, mo44064g());
        return eVar;
    }

    /* renamed from: d */
    private C14143e m45432d(boolean unique, int ttl) {
        if (!(mo44062e() instanceof Inet6Address)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo44062e().getHostAddress());
        sb.append(".ip6.arpa.");
        C14143e eVar = new C14143e(sb.toString(), C14103d.CLASS_IN, unique, ttl, mo44064g());
        return eVar;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(Opcodes.ACC_ABSTRACT);
        buf.append("local host info[");
        buf.append(mo44064g() != null ? mo44064g() : "no name");
        String str = ", ";
        buf.append(str);
        buf.append(mo44063f() != null ? mo44063f().getDisplayName() : "???");
        buf.append(":");
        buf.append(mo44062e() != null ? mo44062e().getHostAddress() : "no address");
        buf.append(str);
        buf.append(this.f42994e);
        buf.append("]");
        return buf.toString();
    }

    /* renamed from: a */
    public Collection<C14138j> mo44049a(C14103d recordClass, boolean unique, int ttl) {
        List<DNSRecord> list = new ArrayList<>();
        C14138j answer = m45428a(unique, ttl);
        if (answer != null && answer.mo43854a(recordClass)) {
            list.add(answer);
        }
        C14138j answer2 = m45431c(unique, ttl);
        if (answer2 != null && answer2.mo43854a(recordClass)) {
            list.add(answer2);
        }
        return list;
    }

    /* renamed from: a */
    public boolean mo43803a(C14110a task) {
        return this.f42994e.mo43803a(task);
    }

    /* renamed from: b */
    public void mo44056b(C14110a task) {
        this.f42994e.mo44011b(task);
    }

    /* renamed from: p */
    public boolean mo44073p() {
        return this.f42994e.mo44024l();
    }

    /* renamed from: a */
    public void mo44050a(C14110a task, C14107h state) {
        this.f42994e.mo44008a(task, state);
    }

    /* renamed from: b */
    public boolean mo44059b(C14110a task, C14107h state) {
        return this.f42994e.mo44014b(task, state);
    }

    /* renamed from: a */
    public boolean mo44051a() {
        return this.f42994e.mo44009a();
    }

    /* renamed from: b */
    public boolean mo44057b() {
        return this.f42994e.mo44012b();
    }

    /* renamed from: o */
    public boolean mo44072o() {
        return this.f42994e.mo44023k();
    }

    /* renamed from: n */
    public boolean mo44071n() {
        return this.f42994e.mo44022j();
    }

    /* renamed from: i */
    public boolean mo44066i() {
        return this.f42994e.mo44016d();
    }

    /* renamed from: k */
    public boolean mo44068k() {
        return this.f42994e.mo44019g();
    }

    /* renamed from: j */
    public boolean mo44067j() {
        return this.f42994e.mo44018f();
    }

    /* renamed from: m */
    public boolean mo44070m() {
        return this.f42994e.mo44021i();
    }

    /* renamed from: l */
    public boolean mo44069l() {
        return this.f42994e.mo44020h();
    }

    /* renamed from: a */
    public boolean mo44052a(long timeout) {
        return this.f42994e.mo44010a(timeout);
    }

    /* renamed from: b */
    public boolean mo44058b(long timeout) {
        if (this.f42992c == null) {
            return true;
        }
        return this.f42994e.mo44013b(timeout);
    }
}
