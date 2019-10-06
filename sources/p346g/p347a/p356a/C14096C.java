package p346g.p347a.p356a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.jmdns.ServiceInfo.Fields;
import javax.jmdns.impl.DNSRecord;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p346g.p347a.C13821d;
import p346g.p347a.C13821d.C13822a;
import p346g.p347a.p356a.C14138j.C14139a;
import p346g.p347a.p356a.C14138j.C14143e;
import p346g.p347a.p356a.C14138j.C14144f;
import p346g.p347a.p356a.C14138j.C14145g;
import p346g.p347a.p356a.C14146k.C14148b;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;
import p346g.p347a.p356a.p357a.C14107h;
import p346g.p347a.p356a.p358b.C14110a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.C */
/* compiled from: ServiceInfoImpl */
public class C14096C extends C13821d implements C14125e, C14146k {

    /* renamed from: b */
    private static C14236b f42746b = C14246c.m45851a(C14096C.class.getName());

    /* renamed from: c */
    private String f42747c;

    /* renamed from: d */
    private String f42748d;

    /* renamed from: e */
    private String f42749e;

    /* renamed from: f */
    private String f42750f;

    /* renamed from: g */
    private String f42751g;

    /* renamed from: h */
    private String f42752h;

    /* renamed from: i */
    private int f42753i;

    /* renamed from: j */
    private int f42754j;

    /* renamed from: k */
    private int f42755k;

    /* renamed from: l */
    private byte[] f42756l;

    /* renamed from: m */
    private Map<String, byte[]> f42757m;

    /* renamed from: n */
    private final Set<Inet4Address> f42758n;

    /* renamed from: o */
    private final Set<Inet6Address> f42759o;

    /* renamed from: p */
    private transient String f42760p;

    /* renamed from: q */
    private boolean f42761q;

    /* renamed from: r */
    private boolean f42762r;

    /* renamed from: s */
    private final C14097a f42763s;

    /* renamed from: g.a.a.C$a */
    /* compiled from: ServiceInfoImpl */
    private static final class C14097a extends C14148b {

        /* renamed from: g */
        private final C14096C f42764g;

        public C14097a(C14096C info) {
            this.f42764g = info;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo43816c(C14110a task) {
            super.mo43816c(task);
            if (this.f42978c == null && this.f42764g.mo43790G()) {
                lock();
                try {
                    if (this.f42978c == null && this.f42764g.mo43790G()) {
                        if (this.f42979d.mo43840f()) {
                            mo44007a(C14107h.ANNOUNCING_1);
                            if (mo44015c() != null) {
                                mo44015c().mo44036h();
                            }
                        }
                        this.f42764g.mo43800a(false);
                    }
                } finally {
                    unlock();
                }
            }
        }

        /* renamed from: a */
        public void mo43815a(C14164v dns) {
            super.mo43815a(dns);
        }
    }

    public C14096C(String type, String name, String subtype, int port, int weight, int priority, boolean persistent, byte[] text) {
        this(m45046a(type, name, subtype), port, weight, priority, persistent, text);
    }

    public C14096C(Map<C13822a, String> qualifiedNameMap, int port, int weight, int priority, boolean persistent, Map<String, ?> props) {
        this(qualifiedNameMap, port, weight, priority, persistent, m45049b(props));
    }

    C14096C(Map<C13822a, String> qualifiedNameMap, int port, int weight, int priority, boolean persistent, String text) {
        this(qualifiedNameMap, port, weight, priority, persistent, (byte[]) null);
        this.f42752h = text;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream(text.length());
            m45048a((OutputStream) out, text);
            this.f42756l = out.toByteArray();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected exception: ");
            sb.append(e);
            throw new RuntimeException(sb.toString());
        }
    }

    C14096C(Map<C13822a, String> qualifiedNameMap, int port, int weight, int priority, boolean persistent, byte[] text) {
        Map<Fields, String> map = m45047a(qualifiedNameMap);
        this.f42747c = (String) map.get(C13822a.Domain);
        this.f42748d = (String) map.get(C13822a.Protocol);
        this.f42749e = (String) map.get(C13822a.Application);
        this.f42750f = (String) map.get(C13822a.Instance);
        this.f42751g = (String) map.get(C13822a.Subtype);
        this.f42753i = port;
        this.f42754j = weight;
        this.f42755k = priority;
        this.f42756l = text;
        mo43800a(false);
        this.f42763s = new C14097a(this);
        this.f42761q = persistent;
        this.f42758n = Collections.synchronizedSet(new LinkedHashSet());
        this.f42759o = Collections.synchronizedSet(new LinkedHashSet());
    }

    C14096C(C13821d info) {
        this.f42758n = Collections.synchronizedSet(new LinkedHashSet());
        this.f42759o = Collections.synchronizedSet(new LinkedHashSet());
        if (info != null) {
            this.f42747c = info.mo43172b();
            this.f42748d = info.mo43180n();
            this.f42749e = info.mo43170a();
            this.f42750f = info.mo43177k();
            this.f42751g = info.mo43183q();
            this.f42753i = info.mo43178l();
            this.f42754j = info.mo43186t();
            this.f42755k = info.mo43179m();
            this.f42756l = info.mo43184r();
            this.f42761q = info.mo43188w();
            for (Inet6Address address : info.mo43175d()) {
                this.f42759o.add(address);
            }
            for (Inet4Address address2 : info.mo43173c()) {
                this.f42758n.add(address2);
            }
        }
        this.f42763s = new C14097a(this);
    }

    /* renamed from: a */
    public static Map<C13822a, String> m45046a(String type, String name, String subtype) {
        Map<Fields, String> qualifiedNameMap = m45045a(type);
        qualifiedNameMap.put(C13822a.Instance, name);
        qualifiedNameMap.put(C13822a.Subtype, subtype);
        return m45047a(qualifiedNameMap);
    }

    /* renamed from: a */
    public static Map<C13822a, String> m45045a(String type) {
        String casePreservedType = type;
        String aType = type.toLowerCase();
        String application = aType;
        String protocol = "";
        String subtype = "";
        String name = "";
        String domain = "";
        String str = "in-addr.arpa";
        String str2 = "ip6.arpa";
        if (aType.contains(str) || aType.contains(str2)) {
            int index = aType.contains(str) != 0 ? aType.indexOf(str) : aType.indexOf(str2);
            name = m45050d(casePreservedType.substring(0, index));
            domain = casePreservedType.substring(index);
            application = "";
        } else {
            String str3 = "_";
            String str4 = ".";
            if (aType.contains(str3) || !aType.contains(str4)) {
                String str5 = "._";
                if (!aType.startsWith(str3) || aType.startsWith("_services")) {
                    int index2 = aType.indexOf(str5);
                    if (index2 > 0) {
                        name = casePreservedType.substring(0, index2);
                        if (index2 + 1 < aType.length()) {
                            aType = aType.substring(index2 + 1);
                            casePreservedType = casePreservedType.substring(index2 + 1);
                        }
                    }
                }
                int index3 = aType.lastIndexOf(str5);
                if (index3 > 0) {
                    int start = index3 + 2;
                    protocol = casePreservedType.substring(start, aType.indexOf(46, start));
                }
                if (protocol.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(protocol.toLowerCase());
                    sb.append(str4);
                    int index4 = aType.indexOf(sb.toString());
                    int start2 = protocol.length() + index4 + 2;
                    int end = aType.length() - (aType.endsWith(str4) ? 1 : 0);
                    if (end > start2) {
                        domain = casePreservedType.substring(start2, end);
                    }
                    if (index4 > 0) {
                        application = casePreservedType.substring(0, index4 - 1);
                    } else {
                        application = "";
                    }
                }
                int index5 = application.toLowerCase().indexOf("._sub");
                if (index5 > 0) {
                    int start3 = index5 + 5;
                    subtype = m45050d(application.substring(0, index5));
                    application = application.substring(start3);
                }
            } else {
                int index6 = aType.indexOf(46);
                name = m45050d(casePreservedType.substring(0, index6));
                domain = m45050d(casePreservedType.substring(index6));
                application = "";
            }
        }
        Map<Fields, String> qualifiedNameMap = new HashMap<>(5);
        qualifiedNameMap.put(C13822a.Domain, m45050d(domain));
        qualifiedNameMap.put(C13822a.Protocol, protocol);
        qualifiedNameMap.put(C13822a.Application, m45050d(application));
        qualifiedNameMap.put(C13822a.Instance, name);
        qualifiedNameMap.put(C13822a.Subtype, subtype);
        return qualifiedNameMap;
    }

    /* renamed from: a */
    protected static Map<C13822a, String> m45047a(Map<C13822a, String> qualifiedNameMap) {
        Map<Fields, String> checkedQualifiedNameMap = new HashMap<>(5);
        String domain = qualifiedNameMap.containsKey(C13822a.Domain) ? (String) qualifiedNameMap.get(C13822a.Domain) : "local";
        if (domain == null || domain.length() == 0) {
            domain = "local";
        }
        checkedQualifiedNameMap.put(C13822a.Domain, m45050d(domain));
        String protocol = qualifiedNameMap.containsKey(C13822a.Protocol) ? (String) qualifiedNameMap.get(C13822a.Protocol) : "tcp";
        if (protocol == null || protocol.length() == 0) {
            protocol = "tcp";
        }
        checkedQualifiedNameMap.put(C13822a.Protocol, m45050d(protocol));
        String subtype = "";
        String application = qualifiedNameMap.containsKey(C13822a.Application) ? (String) qualifiedNameMap.get(C13822a.Application) : subtype;
        if (application == null || application.length() == 0) {
            application = "";
        }
        checkedQualifiedNameMap.put(C13822a.Application, m45050d(application));
        String instance = qualifiedNameMap.containsKey(C13822a.Instance) ? (String) qualifiedNameMap.get(C13822a.Instance) : subtype;
        if (instance == null || instance.length() == 0) {
            instance = "";
        }
        checkedQualifiedNameMap.put(C13822a.Instance, m45050d(instance));
        if (qualifiedNameMap.containsKey(C13822a.Subtype)) {
            subtype = (String) qualifiedNameMap.get(C13822a.Subtype);
        }
        if (subtype == null || subtype.length() == 0) {
            subtype = "";
        }
        checkedQualifiedNameMap.put(C13822a.Subtype, m45050d(subtype));
        return checkedQualifiedNameMap;
    }

    /* renamed from: d */
    private static String m45050d(String name) {
        if (name == null) {
            return "";
        }
        String newName = name.trim();
        String str = ".";
        if (newName.startsWith(str)) {
            newName = newName.substring(1);
        }
        if (newName.startsWith("_")) {
            newName = newName.substring(1);
        }
        if (newName.endsWith(str)) {
            newName = newName.substring(0, newName.length() - 1);
        }
        return newName;
    }

    /* renamed from: s */
    public String mo43185s() {
        String str;
        String domain = mo43172b();
        String protocol = mo43180n();
        String application = mo43170a();
        StringBuilder sb = new StringBuilder();
        String str2 = "_";
        String str3 = "";
        String str4 = ".";
        if (application.length() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(application);
            sb2.append(str4);
            str = sb2.toString();
        } else {
            str = str3;
        }
        sb.append(str);
        if (protocol.length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(protocol);
            sb3.append(str4);
            str3 = sb3.toString();
        }
        sb.append(str3);
        sb.append(domain);
        sb.append(str4);
        return sb.toString();
    }

    /* renamed from: C */
    public String mo43786C() {
        String str;
        String subtype = mo43183q();
        StringBuilder sb = new StringBuilder();
        if (subtype.length() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("_");
            sb2.append(subtype.toLowerCase());
            sb2.append("._sub.");
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(mo43185s());
        return sb.toString();
    }

    /* renamed from: k */
    public String mo43177k() {
        String str = this.f42750f;
        return str != null ? str : "";
    }

    /* renamed from: z */
    public String mo43814z() {
        if (this.f42760p == null) {
            this.f42760p = mo43181o().toLowerCase();
        }
        return this.f42760p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo43805b(String name) {
        this.f42750f = name;
        this.f42760p = null;
    }

    /* renamed from: o */
    public String mo43181o() {
        String str;
        String str2;
        String domain = mo43172b();
        String protocol = mo43180n();
        String application = mo43170a();
        String instance = mo43177k();
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        String str4 = ".";
        if (instance.length() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(instance);
            sb2.append(str4);
            str = sb2.toString();
        } else {
            str = str3;
        }
        sb.append(str);
        String str5 = "_";
        if (application.length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str5);
            sb3.append(application);
            sb3.append(str4);
            str2 = sb3.toString();
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (protocol.length() > 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str5);
            sb4.append(protocol);
            sb4.append(str4);
            str3 = sb4.toString();
        }
        sb.append(str3);
        sb.append(domain);
        sb.append(str4);
        return sb.toString();
    }

    /* renamed from: p */
    public String mo43182p() {
        String str = this.f42752h;
        return str != null ? str : "";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo43808c(String server) {
        this.f42752h = server;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo43798a(Inet4Address addr) {
        this.f42758n.add(addr);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo43799a(Inet6Address addr) {
        this.f42759o.add(addr);
    }

    /* renamed from: h */
    public InetAddress[] mo43176h() {
        List<InetAddress> aList = new ArrayList<>(this.f42758n.size() + this.f42759o.size());
        aList.addAll(this.f42758n);
        aList.addAll(this.f42759o);
        return (InetAddress[]) aList.toArray(new InetAddress[aList.size()]);
    }

    /* renamed from: c */
    public Inet4Address[] mo43173c() {
        Set<Inet4Address> set = this.f42758n;
        return (Inet4Address[]) set.toArray(new Inet4Address[set.size()]);
    }

    /* renamed from: d */
    public Inet6Address[] mo43175d() {
        Set<Inet6Address> set = this.f42759o;
        return (Inet6Address[]) set.toArray(new Inet6Address[set.size()]);
    }

    /* renamed from: l */
    public int mo43178l() {
        return this.f42753i;
    }

    /* renamed from: m */
    public int mo43179m() {
        return this.f42755k;
    }

    /* renamed from: t */
    public int mo43186t() {
        return this.f42754j;
    }

    /* renamed from: r */
    public byte[] mo43184r() {
        byte[] bArr = this.f42756l;
        return (bArr == null || bArr.length <= 0) ? C14138j.f42956i : bArr;
    }

    /* renamed from: a */
    public String mo43170a() {
        String str = this.f42749e;
        return str != null ? str : "";
    }

    /* renamed from: b */
    public String mo43172b() {
        String str = this.f42747c;
        return str != null ? str : "local";
    }

    /* renamed from: n */
    public String mo43180n() {
        String str = this.f42748d;
        return str != null ? str : "tcp";
    }

    /* renamed from: q */
    public String mo43183q() {
        String str = this.f42751g;
        return str != null ? str : "";
    }

    /* renamed from: B */
    public Map<C13822a, String> mo43785B() {
        Map<Fields, String> map = new HashMap<>(5);
        map.put(C13822a.Domain, mo43172b());
        map.put(C13822a.Protocol, mo43180n());
        map.put(C13822a.Application, mo43170a());
        map.put(C13822a.Instance, mo43177k());
        map.put(C13822a.Subtype, mo43183q());
        return map;
    }

    /* renamed from: a */
    static void m45048a(OutputStream out, String str) throws IOException {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int c = str.charAt(i);
            if (c >= 1 && c <= 127) {
                out.write(c);
            } else if (c > 2047) {
                out.write(((c >> 12) & 15) | 224);
                out.write(((c >> 6) & 63) | 128);
                out.write(((c >> 0) & 63) | 128);
            } else {
                out.write(((c >> 6) & 31) | Opcodes.CHECKCAST);
                out.write(((c >> 0) & 63) | 128);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo43793a(byte[] data, int off, int len) {
        int offset;
        int ch = off;
        StringBuffer buf = new StringBuffer();
        int end = ch + len;
        while (ch < end) {
            int offset2 = ch + 1;
            int ch2 = data[ch] & 255;
            switch (ch2 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    offset = offset2;
                    break;
                case 12:
                case 13:
                    if (offset2 < len) {
                        offset = offset2 + 1;
                        ch2 = ((ch2 & 31) << 6) | (data[offset2] & 63);
                        break;
                    } else {
                        return null;
                    }
                case 14:
                    if (offset2 + 2 < len) {
                        int offset3 = offset2 + 1;
                        int i = ((data[offset2] & 63) << 6) | ((ch2 & 15) << 12);
                        ch2 = i | (data[offset3] & 63);
                        offset = offset3 + 1;
                        break;
                    } else {
                        return null;
                    }
                default:
                    if (offset2 + 1 < len) {
                        offset = offset2 + 1;
                        ch2 = ((ch2 & 63) << 4) | (data[offset2] & 15);
                        break;
                    } else {
                        return null;
                    }
            }
            buf.append((char) ch2);
            ch = offset;
        }
        return buf.toString();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        r0.clear();
     */
    /* renamed from: A */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.Map<java.lang.String, byte[]> mo43784A() {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.Map<java.lang.String, byte[]> r0 = r10.f42757m     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x007b
            byte[] r0 = r10.mo43184r()     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x007b
            java.util.Hashtable r0 = new java.util.Hashtable     // Catch:{ all -> 0x0088 }
            r0.<init>()     // Catch:{ all -> 0x0088 }
            r1 = 0
            r2 = r1
        L_0x0012:
            byte[] r3 = r10.mo43184r()     // Catch:{ Exception -> 0x0071 }
            int r3 = r3.length     // Catch:{ Exception -> 0x0071 }
            if (r2 >= r3) goto L_0x0070
            byte[] r3 = r10.mo43184r()     // Catch:{ Exception -> 0x0071 }
            int r4 = r2 + 1
            byte r2 = r3[r2]     // Catch:{ Exception -> 0x0071 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            if (r2 == 0) goto L_0x006d
            int r3 = r4 + r2
            byte[] r5 = r10.mo43184r()     // Catch:{ Exception -> 0x0071 }
            int r5 = r5.length     // Catch:{ Exception -> 0x0071 }
            if (r3 <= r5) goto L_0x002f
            goto L_0x006d
        L_0x002f:
            r3 = 0
        L_0x0030:
            if (r3 >= r2) goto L_0x0041
            byte[] r5 = r10.mo43184r()     // Catch:{ Exception -> 0x0071 }
            int r6 = r4 + r3
            byte r5 = r5[r6]     // Catch:{ Exception -> 0x0071 }
            r6 = 61
            if (r5 == r6) goto L_0x0041
            int r3 = r3 + 1
            goto L_0x0030
        L_0x0041:
            byte[] r5 = r10.mo43184r()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r5 = r10.mo43793a(r5, r4, r3)     // Catch:{ Exception -> 0x0071 }
            if (r5 != 0) goto L_0x004f
            r0.clear()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0070
        L_0x004f:
            if (r3 != r2) goto L_0x0057
            byte[] r6 = p346g.p347a.C13821d.f41976a     // Catch:{ Exception -> 0x0071 }
            r0.put(r5, r6)     // Catch:{ Exception -> 0x0071 }
            goto L_0x006b
        L_0x0057:
            int r3 = r3 + 1
            int r6 = r2 - r3
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0071 }
            byte[] r7 = r10.mo43184r()     // Catch:{ Exception -> 0x0071 }
            int r8 = r4 + r3
            int r9 = r2 - r3
            java.lang.System.arraycopy(r7, r8, r6, r1, r9)     // Catch:{ Exception -> 0x0071 }
            r0.put(r5, r6)     // Catch:{ Exception -> 0x0071 }
        L_0x006b:
            int r2 = r2 + r4
            goto L_0x0012
        L_0x006d:
            r0.clear()     // Catch:{ Exception -> 0x0071 }
        L_0x0070:
            goto L_0x0079
        L_0x0071:
            r1 = move-exception
            i.c.b r2 = f42746b     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = "Malformed TXT Field "
            r2.mo44344b(r3, r1)     // Catch:{ all -> 0x0088 }
        L_0x0079:
            r10.f42757m = r0     // Catch:{ all -> 0x0088 }
        L_0x007b:
            java.util.Map<java.lang.String, byte[]> r0 = r10.f42757m     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0082
            java.util.Map<java.lang.String, byte[]> r0 = r10.f42757m     // Catch:{ all -> 0x0088 }
            goto L_0x0086
        L_0x0082:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0088 }
        L_0x0086:
            monitor-exit(r10)
            return r0
        L_0x0088:
            r0 = move-exception
            monitor-exit(r10)
            goto L_0x008c
        L_0x008b:
            throw r0
        L_0x008c:
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: p346g.p347a.p356a.C14096C.mo43784A():java.util.Map");
    }

    /* renamed from: a */
    public void mo43795a(C14099a dnsCache, long now, C14109b rec) {
        if ((rec instanceof C14138j) && !rec.mo43853a(now)) {
            boolean serviceUpdated = false;
            int i = C14095B.f42745a[rec.mo43862e().ordinal()];
            boolean serverChanged = true;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5 && mo43183q().length() == 0 && rec.mo43865f().length() != 0) {
                                this.f42751g = rec.mo43865f();
                                serviceUpdated = true;
                            }
                        } else if (rec.mo43856b().equalsIgnoreCase(mo43181o())) {
                            this.f42756l = ((C14145g) rec).mo44003t();
                            this.f42757m = null;
                            serviceUpdated = true;
                        }
                    } else if (rec.mo43856b().equalsIgnoreCase(mo43181o())) {
                        C14144f srv = (C14144f) rec;
                        String str = this.f42752h;
                        if (str != null && str.equalsIgnoreCase(srv.mo44001v())) {
                            serverChanged = false;
                        }
                        this.f42752h = srv.mo44001v();
                        this.f42753i = srv.mo43999t();
                        this.f42754j = srv.mo44002w();
                        this.f42755k = srv.mo44000u();
                        if (serverChanged) {
                            this.f42758n.clear();
                            this.f42759o.clear();
                            for (C14109b entry : dnsCache.mo43824b(this.f42752h, C14104e.TYPE_A, C14103d.CLASS_IN)) {
                                mo43795a(dnsCache, now, entry);
                            }
                            for (C14109b entry2 : dnsCache.mo43824b(this.f42752h, C14104e.TYPE_AAAA, C14103d.CLASS_IN)) {
                                mo43795a(dnsCache, now, entry2);
                            }
                        } else {
                            serviceUpdated = true;
                        }
                    }
                } else if (rec.mo43856b().equalsIgnoreCase(mo43182p())) {
                    this.f42759o.add((Inet6Address) ((C14139a) rec).mo43997t());
                    serviceUpdated = true;
                }
            } else if (rec.mo43856b().equalsIgnoreCase(mo43182p())) {
                this.f42758n.add((Inet4Address) ((C14139a) rec).mo43997t());
                serviceUpdated = true;
            }
            if (serviceUpdated && mo43187u()) {
                C14164v dns = mo43813y();
                if (dns != null) {
                    dns.mo44111a(new C14094A(dns, mo43185s(), mo43177k(), this));
                }
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* renamed from: u */
    public synchronized boolean mo43187u() {
        return mo43182p() != null && m45044J() && mo43184r() != null && mo43184r().length > 0;
    }

    /* renamed from: J */
    private final boolean m45044J() {
        return this.f42758n.size() > 0 || this.f42759o.size() > 0;
    }

    /* renamed from: a */
    public boolean mo43803a(C14110a task) {
        return this.f42763s.mo43803a(task);
    }

    /* renamed from: I */
    public boolean mo43792I() {
        return this.f42763s.mo44024l();
    }

    /* renamed from: x */
    public boolean mo43812x() {
        return this.f42763s.mo44009a();
    }

    /* renamed from: H */
    public boolean mo43791H() {
        return this.f42763s.mo44023k();
    }

    /* renamed from: b */
    public void mo43804b(C14110a task) {
        this.f42763s.mo44011b(task);
    }

    /* renamed from: a */
    public void mo43796a(C14110a task, C14107h state) {
        this.f42763s.mo44008a(task, state);
    }

    /* renamed from: b */
    public boolean mo43807b(C14110a task, C14107h state) {
        return this.f42763s.mo44014b(task, state);
    }

    /* renamed from: F */
    public boolean mo43789F() {
        return this.f42763s.mo44022j();
    }

    /* renamed from: E */
    public boolean mo43788E() {
        return this.f42763s.mo44017e();
    }

    /* renamed from: D */
    public boolean mo43787D() {
        return this.f42763s.mo44016d();
    }

    /* renamed from: a */
    public boolean mo43802a(long timeout) {
        return this.f42763s.mo44010a(timeout);
    }

    /* renamed from: b */
    public boolean mo43806b(long timeout) {
        return this.f42763s.mo44013b(timeout);
    }

    public int hashCode() {
        return mo43181o().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C14096C) && mo43181o().equals(((C14096C) obj).mo43181o());
    }

    public C14096C clone() {
        C14096C serviceInfo = new C14096C(mo43785B(), this.f42753i, this.f42754j, this.f42755k, this.f42761q, this.f42756l);
        for (Inet6Address address : mo43175d()) {
            serviceInfo.f42759o.add(address);
        }
        for (Inet4Address address2 : mo43173c()) {
            serviceInfo.f42758n.add(address2);
        }
        return serviceInfo;
    }

    public String toString() {
        String str;
        StringBuilder buf = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(System.identityHashCode(this));
        sb.append(" ");
        buf.append(sb.toString());
        buf.append("name: '");
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (mo43177k().length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo43177k());
            sb3.append(".");
            str = sb3.toString();
        } else {
            str = str2;
        }
        sb2.append(str);
        sb2.append(mo43786C());
        buf.append(sb2.toString());
        buf.append("' address: '");
        InetAddress[] addresses = mo43176h();
        if (addresses.length > 0) {
            for (InetAddress address : addresses) {
                buf.append(address);
                buf.append(':');
                buf.append(mo43178l());
                buf.append(' ');
            }
        } else {
            buf.append("(null):");
            buf.append(mo43178l());
        }
        buf.append("' status: '");
        buf.append(this.f42763s.toString());
        buf.append(mo43188w() ? "' is persistent," : "',");
        buf.append(" has ");
        if (!mo43187u()) {
            str2 = "NO ";
        }
        buf.append(str2);
        buf.append("data");
        if (mo43184r().length > 0) {
            Map<String, byte[]> properties = mo43784A();
            if (!properties.isEmpty()) {
                String str3 = "\n";
                buf.append(str3);
                for (String key : properties.keySet()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("\t");
                    sb4.append(key);
                    sb4.append(": ");
                    sb4.append(new String((byte[]) properties.get(key)));
                    sb4.append(str3);
                    buf.append(sb4.toString());
                }
            } else {
                buf.append(" empty");
            }
        }
        buf.append(']');
        return buf.toString();
    }

    /* renamed from: a */
    public Collection<C14138j> mo43794a(C14103d recordClass, boolean unique, int ttl, C14155n localHost) {
        C14103d dVar = recordClass;
        List<DNSRecord> list = new ArrayList<>();
        if (dVar == C14103d.CLASS_ANY || dVar == C14103d.CLASS_IN) {
            if (mo43183q().length() > 0) {
                C14143e eVar = new C14143e(mo43786C(), C14103d.CLASS_IN, false, ttl, mo43181o());
                list.add(eVar);
            }
            C14143e eVar2 = new C14143e(mo43185s(), C14103d.CLASS_IN, false, ttl, mo43181o());
            list.add(eVar2);
            String o = mo43181o();
            C14103d dVar2 = C14103d.CLASS_IN;
            int i = this.f42755k;
            int i2 = this.f42754j;
            C14144f fVar = new C14144f(o, dVar2, unique, ttl, i, i2, this.f42753i, localHost.mo44064g());
            list.add(fVar);
            C14145g gVar = new C14145g(mo43181o(), C14103d.CLASS_IN, unique, ttl, mo43184r());
            list.add(gVar);
        }
        return list;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo43801a(byte[] text) {
        this.f42756l = text;
        this.f42757m = null;
    }

    /* renamed from: b */
    private static byte[] m45049b(Map<String, ?> props) {
        String str;
        byte[] text = null;
        if (props != null) {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream(Opcodes.ACC_NATIVE);
                for (String key : props.keySet()) {
                    Object val = props.get(key);
                    ByteArrayOutputStream out2 = new ByteArrayOutputStream(100);
                    m45048a((OutputStream) out2, key);
                    if (val != null) {
                        if (val instanceof String) {
                            out2.write(61);
                            m45048a((OutputStream) out2, (String) val);
                        } else if (val instanceof byte[]) {
                            byte[] bval = (byte[]) val;
                            if (bval.length > 0) {
                                out2.write(61);
                                out2.write(bval, 0, bval.length);
                            } else {
                                val = null;
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("invalid property value: ");
                            sb.append(val);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    byte[] data = out2.toByteArray();
                    if (data.length > 255) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Cannot have individual values larger that 255 chars. Offending value: ");
                        sb2.append(key);
                        if (val != null) {
                            str = "";
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("=");
                            sb3.append(val);
                            str = sb3.toString();
                        }
                        sb2.append(str);
                        throw new IOException(sb2.toString());
                    }
                    out.write((byte) data.length);
                    out.write(data, 0, data.length);
                }
                text = out.toByteArray();
            } catch (IOException e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("unexpected exception: ");
                sb4.append(e);
                throw new RuntimeException(sb4.toString());
            }
        }
        return (text == null || text.length <= 0) ? C14138j.f42956i : text;
    }

    /* renamed from: a */
    public void mo43797a(C14164v dns) {
        this.f42763s.mo43815a(dns);
    }

    /* renamed from: y */
    public C14164v mo43813y() {
        return this.f42763s.mo44015c();
    }

    /* renamed from: w */
    public boolean mo43188w() {
        return this.f42761q;
    }

    /* renamed from: a */
    public void mo43800a(boolean needTextAnnouncing) {
        this.f42762r = needTextAnnouncing;
        if (this.f42762r) {
            this.f42763s.mo43816c(null);
        }
    }

    /* renamed from: G */
    public boolean mo43790G() {
        return this.f42762r;
    }

    /* renamed from: a */
    public boolean mo43171a(C13821d other) {
        boolean z = false;
        if (other == null) {
            return false;
        }
        if (other instanceof C14096C) {
            C14096C otherImpl = (C14096C) other;
            if (this.f42758n.size() == otherImpl.f42758n.size() && this.f42759o.size() == otherImpl.f42759o.size() && this.f42758n.equals(otherImpl.f42758n) && this.f42759o.equals(otherImpl.f42759o)) {
                z = true;
            }
            return z;
        }
        InetAddress[] addresses = mo43176h();
        InetAddress[] otherAddresses = other.mo43176h();
        if (addresses.length == otherAddresses.length && new HashSet(Arrays.asList(addresses)).equals(new HashSet(Arrays.asList(otherAddresses)))) {
            z = true;
        }
        return z;
    }
}
