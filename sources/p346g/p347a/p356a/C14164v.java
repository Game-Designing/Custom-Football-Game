package p346g.p347a.p356a;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceInfo.Fields;
import javax.jmdns.impl.DNSListener;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.ListenerStatus.ServiceListenerStatus;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p346g.p347a.C13815a;
import p346g.p347a.C13815a.C13816a;
import p346g.p347a.C13820c;
import p346g.p347a.C13821d;
import p346g.p347a.C13821d.C13822a;
import p346g.p347a.C13823e;
import p346g.p347a.p356a.C14138j.C14143e;
import p346g.p347a.p356a.C14149l.C14152b;
import p346g.p347a.p356a.C14169w.C14170a;
import p346g.p347a.p356a.C14169w.C14171b;
import p346g.p347a.p356a.p357a.C14100a;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;
import p346g.p347a.p356a.p357a.C14107h;
import p346g.p347a.p356a.p358b.C14110a;
import p346g.p347a.p356a.p361c.C14122a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.v */
/* compiled from: JmDNSImpl */
public class C14164v extends C13815a implements C14146k, C14149l {

    /* renamed from: b */
    private static C14236b f43012b = C14246c.m45851a(C14164v.class.getName());

    /* renamed from: c */
    private static final Random f43013c = new Random();

    /* renamed from: d */
    private volatile InetAddress f43014d;

    /* renamed from: e */
    private volatile MulticastSocket f43015e;

    /* renamed from: f */
    private final List<C14125e> f43016f;

    /* renamed from: g */
    final ConcurrentMap<String, List<C14170a>> f43017g;

    /* renamed from: h */
    private final Set<C14171b> f43018h;

    /* renamed from: i */
    private final C14099a f43019i;

    /* renamed from: j */
    private final ConcurrentMap<String, C13821d> f43020j;

    /* renamed from: k */
    private final ConcurrentMap<String, C14167c> f43021k;

    /* renamed from: l */
    private volatile C13816a f43022l;

    /* renamed from: m */
    protected Thread f43023m;

    /* renamed from: n */
    private C14155n f43024n;

    /* renamed from: o */
    private Thread f43025o;

    /* renamed from: p */
    private int f43026p;

    /* renamed from: q */
    private long f43027q;

    /* renamed from: r */
    private final ExecutorService f43028r = Executors.newSingleThreadExecutor(new C14122a("JmDNS"));

    /* renamed from: s */
    private final ReentrantLock f43029s = new ReentrantLock();

    /* renamed from: t */
    private C14123d f43030t;

    /* renamed from: u */
    private final ConcurrentMap<String, C14166b> f43031u;

    /* renamed from: v */
    private final String f43032v;

    /* renamed from: w */
    private final Object f43033w = new Object();

    /* renamed from: g.a.a.v$a */
    /* compiled from: JmDNSImpl */
    public enum C14165a {
        Remove,
        Update,
        Add,
        RegisterServiceType,
        Noop
    }

    /* renamed from: g.a.a.v$b */
    /* compiled from: JmDNSImpl */
    private static class C14166b implements C13823e {

        /* renamed from: a */
        private final ConcurrentMap<String, C13821d> f43040a = new ConcurrentHashMap();

        /* renamed from: b */
        private final ConcurrentMap<String, C13820c> f43041b = new ConcurrentHashMap();

        /* renamed from: c */
        private final String f43042c;

        /* renamed from: d */
        private volatile boolean f43043d;

        public C14166b(String type) {
            this.f43042c = type;
            this.f43043d = true;
        }

        public void serviceAdded(C13820c event) {
            synchronized (this) {
                C13821d info = event.mo43166b();
                if (info == null || !info.mo43187u()) {
                    C13821d info2 = ((C14164v) event.mo43165a()).mo44113b(event.mo43169d(), event.mo43167c(), info != null ? info.mo43183q() : "", true);
                    if (info2 != null) {
                        this.f43040a.put(event.mo43167c(), info2);
                    } else {
                        this.f43041b.put(event.mo43167c(), event);
                    }
                } else {
                    this.f43040a.put(event.mo43167c(), info);
                }
            }
        }

        public void serviceRemoved(C13820c event) {
            synchronized (this) {
                this.f43040a.remove(event.mo43167c());
                this.f43041b.remove(event.mo43167c());
            }
        }

        public void serviceResolved(C13820c event) {
            synchronized (this) {
                this.f43040a.put(event.mo43167c(), event.mo43166b());
                this.f43041b.remove(event.mo43167c());
            }
        }

        public String toString() {
            StringBuffer aLog = new StringBuffer();
            aLog.append("\n\tType: ");
            aLog.append(this.f43042c);
            String str = ": ";
            if (this.f43040a.isEmpty()) {
                aLog.append("\n\tNo services collected.");
            } else {
                aLog.append("\n\tServices");
                for (String key : this.f43040a.keySet()) {
                    aLog.append("\n\t\tService: ");
                    aLog.append(key);
                    aLog.append(str);
                    aLog.append(this.f43040a.get(key));
                }
            }
            if (this.f43041b.isEmpty()) {
                aLog.append("\n\tNo event queued.");
            } else {
                aLog.append("\n\tEvents");
                for (String key2 : this.f43041b.keySet()) {
                    aLog.append("\n\t\tEvent: ");
                    aLog.append(key2);
                    aLog.append(str);
                    aLog.append(this.f43041b.get(key2));
                }
            }
            return aLog.toString();
        }
    }

    /* renamed from: g.a.a.v$c */
    /* compiled from: JmDNSImpl */
    public static class C14167c extends AbstractMap<String, String> implements Cloneable {

        /* renamed from: a */
        private final Set<Entry<String, String>> f43044a = new HashSet();

        /* renamed from: b */
        private final String f43045b;

        /* renamed from: g.a.a.v$c$a */
        /* compiled from: JmDNSImpl */
        private static class C14168a implements Entry<String, String>, Serializable, Cloneable {

            /* renamed from: a */
            private final String f43046a;

            /* renamed from: b */
            private final String f43047b;

            public /* bridge */ /* synthetic */ Object setValue(Object x0) {
                mo44139a((String) x0);
                throw null;
            }

            public C14168a(String subtype) {
                this.f43047b = subtype != null ? subtype : "";
                this.f43046a = this.f43047b.toLowerCase();
            }

            public String getKey() {
                return this.f43046a;
            }

            public String getValue() {
                return this.f43047b;
            }

            /* renamed from: a */
            public String mo44139a(String value) {
                throw new UnsupportedOperationException();
            }

            public boolean equals(Object entry) {
                boolean z = false;
                if (!(entry instanceof Entry)) {
                    return false;
                }
                if (getKey().equals(((Entry) entry).getKey()) && getValue().equals(((Entry) entry).getValue())) {
                    z = true;
                }
                return z;
            }

            public int hashCode() {
                String str = this.f43046a;
                int i = 0;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f43047b;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode ^ i;
            }

            public C14168a clone() {
                return this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f43046a);
                sb.append("=");
                sb.append(this.f43047b);
                return sb.toString();
            }
        }

        public C14167c(String type) {
            this.f43045b = type;
        }

        /* renamed from: a */
        public String mo44133a() {
            return this.f43045b;
        }

        public Set<Entry<String, String>> entrySet() {
            return this.f43044a;
        }

        /* renamed from: b */
        public boolean mo44135b(String subtype) {
            return subtype != null && containsKey(subtype.toLowerCase());
        }

        /* renamed from: a */
        public boolean mo44134a(String subtype) {
            if (subtype == null || mo44135b(subtype)) {
                return false;
            }
            this.f43044a.add(new C14168a(subtype));
            return true;
        }

        public C14167c clone() {
            C14167c entry = new C14167c(mo44133a());
            for (Entry<String, String> subTypeEntry : entrySet()) {
                entry.mo44134a((String) subTypeEntry.getValue());
            }
            return entry;
        }

        public String toString() {
            StringBuilder aLog = new StringBuilder(200);
            if (isEmpty()) {
                aLog.append("empty");
            } else {
                for (String value : values()) {
                    aLog.append(value);
                    aLog.append(", ");
                }
                aLog.setLength(aLog.length() - 2);
            }
            return aLog.toString();
        }
    }

    public C14164v(InetAddress address, String name) throws IOException {
        if (f43012b.isDebugEnabled()) {
            f43012b.mo44340a("JmDNS instance created");
        }
        this.f43019i = new C14099a(100);
        this.f43016f = Collections.synchronizedList(new ArrayList());
        this.f43017g = new ConcurrentHashMap();
        this.f43018h = Collections.synchronizedSet(new HashSet());
        this.f43031u = new ConcurrentHashMap();
        this.f43020j = new ConcurrentHashMap(20);
        this.f43021k = new ConcurrentHashMap(20);
        this.f43024n = C14155n.m45429a(address, this, name);
        this.f43032v = name != null ? name : this.f43024n.mo44064g();
        m45466a(mo44086F());
        m45468a(mo44089J().values());
        mo44035g();
    }

    /* renamed from: a */
    private void m45468a(Collection<? extends C13821d> serviceInfos) {
        if (this.f43025o == null) {
            this.f43025o = new C14098D(this);
            this.f43025o.start();
        }
        mo44031c();
        for (C13821d info : serviceInfos) {
            try {
                mo44112a((C13821d) new C14096C(info));
            } catch (Exception exception) {
                f43012b.mo44344b("start() Registration exception ", exception);
            }
        }
    }

    /* renamed from: a */
    private void m45466a(C14155n hostInfo) throws IOException {
        if (this.f43014d == null) {
            if (hostInfo.mo44062e() instanceof Inet6Address) {
                this.f43014d = InetAddress.getByName("FF02::FB");
            } else {
                this.f43014d = InetAddress.getByName("224.0.0.251");
            }
        }
        if (this.f43015e != null) {
            m45462W();
        }
        this.f43015e = new MulticastSocket(C14100a.f42767a);
        if (!(hostInfo == null || hostInfo.mo44063f() == null)) {
            try {
                this.f43015e.setNetworkInterface(hostInfo.mo44063f());
            } catch (SocketException e) {
                if (f43012b.isDebugEnabled()) {
                    C14236b bVar = f43012b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("openMulticastSocket() Set network interface exception: ");
                    sb.append(e.getMessage());
                    bVar.mo44340a(sb.toString());
                }
            }
        }
        this.f43015e.setTimeToLive(255);
        this.f43015e.joinGroup(this.f43014d);
    }

    /* renamed from: W */
    private void m45462W() {
        if (f43012b.isDebugEnabled()) {
            f43012b.mo44340a("closeMulticastSocket()");
        }
        if (this.f43015e != null) {
            try {
                this.f43015e.leaveGroup(this.f43014d);
            } catch (SocketException e) {
            }
            try {
                this.f43015e.close();
                while (this.f43025o != null && this.f43025o.isAlive()) {
                    synchronized (this) {
                        try {
                            if (this.f43025o != null && this.f43025o.isAlive()) {
                                if (f43012b.isDebugEnabled()) {
                                    f43012b.mo44340a("closeMulticastSocket(): waiting for jmDNS monitor");
                                }
                                wait(1000);
                            }
                        } catch (InterruptedException e2) {
                        }
                    }
                }
                this.f43025o = null;
            } catch (Exception exception) {
                f43012b.mo44344b("closeMulticastSocket() Close socket exception ", exception);
            }
            this.f43015e = null;
        }
    }

    /* renamed from: a */
    public boolean mo43803a(C14110a task) {
        return this.f43024n.mo43803a(task);
    }

    /* renamed from: V */
    public boolean mo44101V() {
        return this.f43024n.mo44073p();
    }

    /* renamed from: w */
    public boolean mo44128w() {
        return this.f43024n.mo44051a();
    }

    /* renamed from: y */
    public boolean mo44130y() {
        return this.f43024n.mo44057b();
    }

    /* renamed from: U */
    public boolean mo44100U() {
        return this.f43024n.mo44072o();
    }

    /* renamed from: B */
    public C14164v mo44082B() {
        return this;
    }

    /* renamed from: a */
    public void mo44105a(C14110a task, C14107h state) {
        this.f43024n.mo44050a(task, state);
    }

    /* renamed from: b */
    public void mo44114b(C14110a task) {
        this.f43024n.mo44056b(task);
    }

    /* renamed from: b */
    public boolean mo44118b(C14110a task, C14107h state) {
        return this.f43024n.mo44059b(task, state);
    }

    /* renamed from: S */
    public boolean mo44098S() {
        return this.f43024n.mo44071n();
    }

    /* renamed from: O */
    public boolean mo44094O() {
        return this.f43024n.mo44066i();
    }

    /* renamed from: Q */
    public boolean mo44096Q() {
        return this.f43024n.mo44068k();
    }

    /* renamed from: P */
    public boolean mo44095P() {
        return this.f43024n.mo44067j();
    }

    /* renamed from: R */
    public boolean mo44097R() {
        return this.f43024n.mo44070m();
    }

    public boolean isClosed() {
        return this.f43024n.mo44069l();
    }

    /* renamed from: i */
    public boolean mo44123i(long timeout) {
        return this.f43024n.mo44052a(timeout);
    }

    /* renamed from: j */
    public boolean mo44125j(long timeout) {
        return this.f43024n.mo44058b(timeout);
    }

    /* renamed from: z */
    public C14099a mo44131z() {
        return this.f43019i;
    }

    /* renamed from: G */
    public String mo44087G() {
        return this.f43032v;
    }

    /* renamed from: F */
    public C14155n mo44086F() {
        return this.f43024n;
    }

    /* renamed from: D */
    public InetAddress mo44084D() throws IOException {
        return this.f43024n.mo44062e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C14096C mo44113b(String type, String name, String subtype, boolean persistent) {
        mo44129x();
        String loType = type.toLowerCase();
        mo44119b(type);
        if (this.f43031u.putIfAbsent(loType, new C14166b(type)) == null) {
            m45467a(loType, (C13823e) this.f43031u.get(loType), true);
        }
        C14096C info = mo44102a(type, name, subtype, persistent);
        mo44027a(info);
        return info;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C14096C mo44102a(String type, String name, String subtype, boolean persistent) {
        boolean z = persistent;
        C14096C c = new C14096C(type, name, subtype, 0, 0, 0, persistent, null);
        C14096C info = c;
        C14099a z2 = mo44131z();
        C14143e eVar = new C14143e(type, C14103d.CLASS_ANY, false, 0, info.mo43181o());
        C14109b pointerEntry = z2.mo43823b((C14109b) eVar);
        if (!(pointerEntry instanceof C14138j)) {
            return info;
        }
        C14096C cachedInfo = (C14096C) ((C14138j) pointerEntry).mo43977a(z);
        if (cachedInfo == null) {
            return info;
        }
        Map<Fields, String> map = cachedInfo.mo43785B();
        byte[] srvBytes = null;
        String server = "";
        C14109b serviceEntry = mo44131z().mo43818a(info.mo43181o(), C14104e.TYPE_SRV, C14103d.CLASS_ANY);
        if (serviceEntry instanceof C14138j) {
            C13821d cachedServiceEntryInfo = ((C14138j) serviceEntry).mo43977a(z);
            if (cachedServiceEntryInfo != null) {
                C14096C c2 = new C14096C(map, cachedServiceEntryInfo.mo43178l(), cachedServiceEntryInfo.mo43186t(), cachedServiceEntryInfo.mo43179m(), persistent, (byte[]) null);
                cachedInfo = c2;
                srvBytes = cachedServiceEntryInfo.mo43184r();
                server = cachedServiceEntryInfo.mo43182p();
            }
        }
        for (C14109b addressEntry : mo44131z().mo43824b(server, C14104e.TYPE_A, C14103d.CLASS_ANY)) {
            if (addressEntry instanceof C14138j) {
                C13821d cachedAddressInfo = ((C14138j) addressEntry).mo43977a(z);
                if (cachedAddressInfo != null) {
                    for (Inet4Address address : cachedAddressInfo.mo43173c()) {
                        cachedInfo.mo43798a(address);
                    }
                    cachedInfo.mo43801a(cachedAddressInfo.mo43184r());
                }
            }
        }
        for (C14109b addressEntry2 : mo44131z().mo43824b(server, C14104e.TYPE_AAAA, C14103d.CLASS_ANY)) {
            if (addressEntry2 instanceof C14138j) {
                C13821d cachedAddressInfo2 = ((C14138j) addressEntry2).mo43977a(z);
                if (cachedAddressInfo2 != null) {
                    for (Inet6Address address2 : cachedAddressInfo2.mo43175d()) {
                        cachedInfo.mo43799a(address2);
                    }
                    cachedInfo.mo43801a(cachedAddressInfo2.mo43184r());
                }
            }
        }
        C14109b textEntry = mo44131z().mo43818a(cachedInfo.mo43181o(), C14104e.TYPE_TXT, C14103d.CLASS_ANY);
        if (textEntry instanceof C14138j) {
            C13821d cachedTextInfo = ((C14138j) textEntry).mo43977a(z);
            if (cachedTextInfo != null) {
                cachedInfo.mo43801a(cachedTextInfo.mo43184r());
            }
        }
        if (cachedInfo.mo43184r().length == 0) {
            cachedInfo.mo43801a(srvBytes);
        }
        if (cachedInfo.mo43187u()) {
            return cachedInfo;
        }
        return info;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        r3 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r3.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r7.f43028r.submit(new p346g.p347a.p356a.C14157o(r7, (p346g.p347a.p356a.C14169w.C14170a) r3.next(), r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo44111a(p346g.p347a.C13820c r8) {
        /*
            r7 = this;
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.List<g.a.a.w$a>> r0 = r7.f43017g
            java.lang.String r1 = r8.mo43169d()
            java.lang.String r1 = r1.toLowerCase()
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0052
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0052
            g.a.d r1 = r8.mo43166b()
            if (r1 == 0) goto L_0x0052
            g.a.d r1 = r8.mo43166b()
            boolean r1 = r1.mo43187u()
            if (r1 == 0) goto L_0x0052
            r1 = r8
            monitor-enter(r0)
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r3.<init>(r0)     // Catch:{ all -> 0x004d }
            r2 = r3
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            java.util.Iterator r3 = r2.iterator()
        L_0x0036:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r3.next()
            g.a.a.w$a r4 = (p346g.p347a.p356a.C14169w.C14170a) r4
            java.util.concurrent.ExecutorService r5 = r7.f43028r
            g.a.a.o r6 = new g.a.a.o
            r6.<init>(r7, r4, r1)
            r5.submit(r6)
            goto L_0x0036
        L_0x004d:
            r3 = move-exception
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r3
        L_0x0050:
            r3 = move-exception
            goto L_0x004e
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p346g.p347a.p356a.C14164v.mo44111a(g.a.c):void");
    }

    /* renamed from: a */
    public void mo43160a(String type, C13823e listener) {
        m45467a(type, listener, false);
    }

    /* renamed from: a */
    private void m45467a(String type, C13823e listener, boolean synch) {
        C14170a status = new C14170a(listener, synch);
        String loType = type.toLowerCase();
        List<ServiceListenerStatus> list = (List) this.f43017g.get(loType);
        if (list == null) {
            if (this.f43017g.putIfAbsent(loType, new LinkedList()) == null && this.f43031u.putIfAbsent(loType, new C14166b(type)) == null) {
                m45467a(loType, (C13823e) this.f43031u.get(loType), true);
            }
            list = (List) this.f43017g.get(loType);
        }
        if (list != null) {
            synchronized (list) {
                if (!list.contains(status)) {
                    list.add(status);
                }
            }
        }
        List<ServiceEvent> serviceEvents = new ArrayList<>();
        Iterator i$ = mo44131z().mo43819a().iterator();
        while (i$.hasNext()) {
            C14138j record = (C14138j) i$.next();
            if (record.mo43862e() == C14104e.TYPE_SRV && record.mo43850a().endsWith(loType)) {
                serviceEvents.add(new C14094A(this, record.mo43866g(), m45464a(record.mo43866g(), record.mo43856b()), record.mo43992p()));
            }
        }
        Iterator i$2 = serviceEvents.iterator();
        while (i$2.hasNext()) {
            status.mo44152a((C13820c) i$2.next());
        }
        mo44029a(type);
    }

    /* renamed from: b */
    public void mo44117b(String type, C13823e listener) {
        String loType = type.toLowerCase();
        List<ServiceListenerStatus> list = (List) this.f43017g.get(loType);
        if (list != null) {
            synchronized (list) {
                list.remove(new C14170a(listener, false));
                if (list.isEmpty()) {
                    this.f43017g.remove(loType, list);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo44112a(C13821d infoAbstract) throws IOException {
        if (mo44097R() || isClosed()) {
            throw new IllegalStateException("This DNS is closed.");
        }
        C14096C info = (C14096C) infoAbstract;
        if (info.mo43813y() != null) {
            if (info.mo43813y() != this) {
                throw new IllegalStateException("A service information can only be registered with a single instamce of JmDNS.");
            } else if (this.f43020j.get(info.mo43814z()) != null) {
                throw new IllegalStateException("A service information can only be registered once.");
            }
        }
        info.mo43797a(this);
        mo44119b(info.mo43786C());
        info.mo43791H();
        info.mo43808c(this.f43024n.mo44064g());
        info.mo43798a(this.f43024n.mo44060c());
        info.mo43799a(this.f43024n.mo44061d());
        mo44123i(6000);
        m45469b(info);
        while (this.f43020j.putIfAbsent(info.mo43814z(), info) != null) {
            m45469b(info);
        }
        mo44031c();
        info.mo43802a(6000);
        if (f43012b.isDebugEnabled()) {
            C14236b bVar = f43012b;
            StringBuilder sb = new StringBuilder();
            sb.append("registerService() JmDNS registered service as ");
            sb.append(info);
            bVar.mo44340a(sb.toString());
        }
    }

    /* renamed from: j */
    public void mo43161j() {
        if (f43012b.isDebugEnabled()) {
            f43012b.mo44340a("unregisterAllServices()");
        }
        for (String name : this.f43020j.keySet()) {
            C14096C info = (C14096C) this.f43020j.get(name);
            if (info != null) {
                if (f43012b.isDebugEnabled()) {
                    C14236b bVar = f43012b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cancelling service info: ");
                    sb.append(info);
                    bVar.mo44340a(sb.toString());
                }
                info.mo43812x();
            }
        }
        mo44034f();
        for (String name2 : this.f43020j.keySet()) {
            C14096C info2 = (C14096C) this.f43020j.get(name2);
            if (info2 != null) {
                if (f43012b.isDebugEnabled()) {
                    C14236b bVar2 = f43012b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Wait for service info cancel: ");
                    sb2.append(info2);
                    bVar2.mo44340a(sb2.toString());
                }
                info2.mo43806b(5000);
                this.f43020j.remove(name2, info2);
            }
        }
    }

    /* renamed from: b */
    public boolean mo44119b(String type) {
        String str;
        String str2;
        boolean typeAdded;
        String str3;
        Map a = C14096C.m45045a(type);
        String domain = (String) a.get(C13822a.Domain);
        String protocol = (String) a.get(C13822a.Protocol);
        String application = (String) a.get(C13822a.Application);
        String subtype = (String) a.get(C13822a.Subtype);
        StringBuilder sb = new StringBuilder();
        if (application.length() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("_");
            sb2.append(application);
            sb2.append(".");
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        if (protocol.length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("_");
            sb3.append(protocol);
            sb3.append(".");
            str2 = sb3.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append(domain);
        sb.append(".");
        String name = sb.toString();
        String loname = name.toLowerCase();
        if (f43012b.isDebugEnabled()) {
            C14236b bVar = f43012b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo44087G());
            sb4.append(".registering service type: ");
            sb4.append(type);
            sb4.append(" as: ");
            sb4.append(name);
            if (subtype.length() > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" subtype: ");
                sb5.append(subtype);
                str3 = sb5.toString();
            } else {
                str3 = "";
            }
            sb4.append(str3);
            bVar.mo44340a(sb4.toString());
        } else {
            String str4 = type;
        }
        if (this.f43021k.containsKey(loname) || application.toLowerCase().equals("dns-sd") || domain.toLowerCase().endsWith("in-addr.arpa") || domain.toLowerCase().endsWith("ip6.arpa")) {
            Map map = a;
            typeAdded = false;
        } else {
            boolean typeAdded2 = this.f43021k.putIfAbsent(loname, new C14167c(name)) == null;
            if (typeAdded2) {
                Set<C14171b> set = this.f43018h;
                C14171b[] list = (C14171b[]) set.toArray(new C14171b[set.size()]);
                C13820c event = new C14094A(this, name, "", null);
                C14171b[] arr$ = list;
                int len$ = arr$.length;
                int i$ = 0;
                while (i$ < len$) {
                    boolean typeAdded3 = typeAdded2;
                    Map map2 = a;
                    this.f43028r.submit(new C14158p(this, arr$[i$], event));
                    i$++;
                    typeAdded2 = typeAdded3;
                    a = map2;
                }
                typeAdded = typeAdded2;
                Map map3 = a;
            } else {
                typeAdded = typeAdded2;
                Map map4 = a;
            }
        }
        if (subtype.length() > 0) {
            C14167c subtypes = (C14167c) this.f43021k.get(loname);
            if (subtypes != null && !subtypes.mo44135b(subtype)) {
                synchronized (subtypes) {
                    if (!subtypes.mo44135b(subtype)) {
                        typeAdded = true;
                        subtypes.mo44134a(subtype);
                        C14171b[] list2 = (C14171b[]) this.f43018h.toArray(new C14171b[this.f43018h.size()]);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("_");
                        sb6.append(subtype);
                        sb6.append("._sub.");
                        sb6.append(name);
                        C13820c event2 = new C14094A(this, sb6.toString(), "", null);
                        C14171b[] arr$2 = list2;
                        int len$2 = arr$2.length;
                        int i$2 = 0;
                        while (i$2 < len$2) {
                            C14171b[] list3 = list2;
                            this.f43028r.submit(new C14159q(this, arr$2[i$2], event2));
                            i$2++;
                            list2 = list3;
                        }
                    }
                }
            }
        }
        return typeAdded;
    }

    /* JADX INFO: used method not loaded: g.a.a.C.b(java.lang.String):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (f43012b.isDebugEnabled() == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        r7 = f43012b;
        r8 = new java.lang.StringBuilder();
        r8.append("makeServiceNameUnique() JmDNS.makeServiceNameUnique srv collision:");
        r8.append(r5);
        r8.append(" s.server=");
        r8.append(r6.mo44001v());
        r8.append(" ");
        r8.append(r11.f43024n.mo44064g());
        r8.append(" equals:");
        r8.append(r6.mo44001v().equals(r11.f43024n.mo44064g()));
        r7.mo44340a(r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a2, code lost:
        r12.mo43805b(p346g.p347a.p356a.C14173y.C14175b.m45548a().mo44157a(r11.f43024n.mo44062e(), r12.mo43177k(), p346g.p347a.p356a.C14173y.C14176c.f43057b));
        r3 = true;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m45469b(p346g.p347a.p356a.C14096C r12) {
        /*
            r11 = this;
            java.lang.String r0 = r12.mo43814z()
            long r1 = java.lang.System.currentTimeMillis()
        L_0x0008:
            r3 = 0
            g.a.a.a r4 = r11.mo44131z()
            java.lang.String r5 = r12.mo43814z()
            java.util.Collection r4 = r4.mo43820a(r5)
            java.util.Iterator r4 = r4.iterator()
        L_0x0019:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00bd
            java.lang.Object r5 = r4.next()
            g.a.a.b r5 = (p346g.p347a.p356a.C14109b) r5
            g.a.a.a.e r6 = p346g.p347a.p356a.p357a.C14104e.TYPE_SRV
            g.a.a.a.e r7 = r5.mo43862e()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00bb
            boolean r6 = r5.mo43853a(r1)
            if (r6 != 0) goto L_0x00bb
            r6 = r5
            g.a.a.j$f r6 = (p346g.p347a.p356a.C14138j.C14144f) r6
            int r7 = r6.mo43999t()
            int r8 = r12.mo43178l()
            if (r7 != r8) goto L_0x0054
            java.lang.String r7 = r6.mo44001v()
            g.a.a.n r8 = r11.f43024n
            java.lang.String r8 = r8.mo44064g()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00bb
        L_0x0054:
            i.c.b r7 = f43012b
            boolean r7 = r7.isDebugEnabled()
            if (r7 == 0) goto L_0x00a2
            i.c.b r7 = f43012b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "makeServiceNameUnique() JmDNS.makeServiceNameUnique srv collision:"
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = " s.server="
            r8.append(r9)
            java.lang.String r9 = r6.mo44001v()
            r8.append(r9)
            java.lang.String r9 = " "
            r8.append(r9)
            g.a.a.n r9 = r11.f43024n
            java.lang.String r9 = r9.mo44064g()
            r8.append(r9)
            java.lang.String r9 = " equals:"
            r8.append(r9)
            java.lang.String r9 = r6.mo44001v()
            g.a.a.n r10 = r11.f43024n
            java.lang.String r10 = r10.mo44064g()
            boolean r9 = r9.equals(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.mo44340a(r8)
        L_0x00a2:
            g.a.a.y r7 = p346g.p347a.p356a.C14173y.C14175b.m45548a()
            g.a.a.n r8 = r11.f43024n
            java.net.InetAddress r8 = r8.mo44062e()
            java.lang.String r9 = r12.mo43177k()
            g.a.a.y$c r10 = p346g.p347a.p356a.C14173y.C14176c.SERVICE
            java.lang.String r7 = r7.mo44157a(r8, r9, r10)
            r12.mo43805b(r7)
            r3 = 1
            goto L_0x00bd
        L_0x00bb:
            goto L_0x0019
        L_0x00bd:
            java.util.concurrent.ConcurrentMap<java.lang.String, g.a.d> r4 = r11.f43020j
            java.lang.String r5 = r12.mo43814z()
            java.lang.Object r4 = r4.get(r5)
            g.a.d r4 = (p346g.p347a.C13821d) r4
            if (r4 == 0) goto L_0x00e5
            if (r4 == r12) goto L_0x00e5
            g.a.a.y r5 = p346g.p347a.p356a.C14173y.C14175b.m45548a()
            g.a.a.n r6 = r11.f43024n
            java.net.InetAddress r6 = r6.mo44062e()
            java.lang.String r7 = r12.mo43177k()
            g.a.a.y$c r8 = p346g.p347a.p356a.C14173y.C14176c.SERVICE
            java.lang.String r5 = r5.mo44157a(r6, r7, r8)
            r12.mo43805b(r5)
            r3 = 1
        L_0x00e5:
            if (r3 != 0) goto L_0x00f2
            java.lang.String r4 = r12.mo43814z()
            boolean r4 = r0.equals(r4)
            r4 = r4 ^ 1
            return r4
        L_0x00f2:
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: p346g.p347a.p356a.C14164v.m45469b(g.a.a.C):boolean");
    }

    /* renamed from: a */
    public void mo44108a(C14125e listener, C14130i question) {
        long now = System.currentTimeMillis();
        this.f43016f.add(listener);
        if (question != null) {
            for (C14109b dnsEntry : mo44131z().mo43820a(question.mo43856b().toLowerCase())) {
                if (question.mo43974f(dnsEntry) && !dnsEntry.mo43853a(now)) {
                    listener.mo43795a(mo44131z(), now, dnsEntry);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo44107a(C14125e listener) {
        this.f43016f.remove(listener);
    }

    /* renamed from: c */
    public void mo44120c(String type) {
        if (this.f43031u.containsKey(type.toLowerCase())) {
            mo44029a(type);
        }
    }

    /* renamed from: a */
    public void mo44104a(long now, C14138j rec, C14165a operation) {
        List<DNSListener> listenerList;
        List<C14170a> list;
        synchronized (this.f43016f) {
            listenerList = new ArrayList<>(this.f43016f);
        }
        Iterator i$ = listenerList.iterator();
        while (i$.hasNext()) {
            ((C14125e) i$.next()).mo43795a(mo44131z(), now, rec);
        }
        if (C14104e.TYPE_PTR.equals(rec.mo43862e())) {
            C13820c event = rec.mo43976a(this);
            if (event.mo43166b() == null || !event.mo43166b().mo43187u()) {
                C14096C a = mo44102a(event.mo43169d(), event.mo43167c(), "", false);
                if (a.mo43187u()) {
                    event = new C14094A(this, event.mo43169d(), event.mo43167c(), a);
                }
            }
            List<ServiceListenerStatus> list2 = (List) this.f43017g.get(event.mo43169d().toLowerCase());
            if (list2 != null) {
                synchronized (list2) {
                    try {
                        list = new ArrayList<>(list2);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } else {
                list = Collections.emptyList();
            }
            if (f43012b.isTraceEnabled()) {
                C14236b bVar = f43012b;
                StringBuilder sb = new StringBuilder();
                sb.append(mo44087G());
                sb.append(".updating record for event: ");
                sb.append(event);
                sb.append(" list ");
                sb.append(list);
                sb.append(" operation: ");
                sb.append(operation);
                bVar.mo44345c(sb.toString());
            }
            if (!list.isEmpty()) {
                C13820c localEvent = event;
                int i = C14163u.f43011a[operation.ordinal()];
                if (i == 1) {
                    for (C14170a listener : list) {
                        if (listener.mo44148b()) {
                            listener.mo44152a(localEvent);
                        } else {
                            this.f43028r.submit(new C14160r(this, listener, localEvent));
                        }
                    }
                } else if (i == 2) {
                    for (C14170a listener2 : list) {
                        if (listener2.mo44148b()) {
                            listener2.mo44153b(localEvent);
                        } else {
                            this.f43028r.submit(new C14161s(this, listener2, localEvent));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo44110a(C14138j record, long now) {
        C14138j newRecord = record;
        C14165a cacheOperation = C14165a.Noop;
        boolean expired = newRecord.mo43853a(now);
        if (f43012b.isDebugEnabled()) {
            C14236b bVar = f43012b;
            StringBuilder sb = new StringBuilder();
            sb.append(mo44087G());
            sb.append(" handle response: ");
            sb.append(newRecord);
            bVar.mo44340a(sb.toString());
        }
        if (!newRecord.mo43870j() && !newRecord.mo43867h()) {
            boolean unique = newRecord.mo43871k();
            C14138j cachedRecord = (C14138j) mo44131z().mo43823b((C14109b) newRecord);
            if (f43012b.isDebugEnabled()) {
                C14236b bVar2 = f43012b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mo44087G());
                sb2.append(" handle response cached record: ");
                sb2.append(cachedRecord);
                bVar2.mo44340a(sb2.toString());
            }
            if (unique) {
                for (C14109b entry : mo44131z().mo43820a(newRecord.mo43850a())) {
                    if (newRecord.mo43862e().equals(entry.mo43862e()) && newRecord.mo43860d().equals(entry.mo43860d()) && entry != cachedRecord) {
                        ((C14138j) entry).mo43990e(now);
                    }
                }
            }
            if (cachedRecord != null) {
                if (expired) {
                    if (newRecord.mo43993q() == 0) {
                        cacheOperation = C14165a.Noop;
                        cachedRecord.mo43990e(now);
                    } else {
                        cacheOperation = C14165a.Remove;
                        mo44131z().mo43825c(cachedRecord);
                    }
                } else if (newRecord.mo43987c(cachedRecord) && (newRecord.mo43863e(cachedRecord) || newRecord.mo43865f().length() <= 0)) {
                    cachedRecord.mo43979a(newRecord);
                    newRecord = cachedRecord;
                } else if (newRecord.mo43995s()) {
                    cacheOperation = C14165a.Update;
                    mo44131z().mo43822a(newRecord, cachedRecord);
                } else {
                    cacheOperation = C14165a.Add;
                    mo44131z().mo43821a((C14109b) newRecord);
                }
            } else if (!expired) {
                cacheOperation = C14165a.Add;
                mo44131z().mo43821a((C14109b) newRecord);
            }
        }
        if (newRecord.mo43862e() == C14104e.TYPE_PTR) {
            if (newRecord.mo43870j()) {
                if (!expired) {
                    boolean typeAdded = mo44119b(((C14143e) newRecord).mo43998t());
                }
                return;
            } else if ((false || mo44119b(newRecord.mo43856b())) && cacheOperation == C14165a.Noop) {
                cacheOperation = C14165a.RegisterServiceType;
            }
        }
        if (cacheOperation != C14165a.Noop) {
            mo44104a(now, newRecord, cacheOperation);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo44106a(C14123d msg) throws IOException {
        long now = System.currentTimeMillis();
        boolean hostConflictDetected = false;
        boolean serviceConflictDetected = false;
        Iterator i$ = m45465a(msg.mo43932b()).iterator();
        while (i$.hasNext()) {
            C14138j newRecord = (C14138j) i$.next();
            mo44110a(newRecord, now);
            if (C14104e.TYPE_A.equals(newRecord.mo43862e()) || C14104e.TYPE_AAAA.equals(newRecord.mo43862e())) {
                hostConflictDetected |= newRecord.mo43985b(this);
            } else {
                serviceConflictDetected |= newRecord.mo43985b(this);
            }
        }
        if (hostConflictDetected || serviceConflictDetected) {
            mo44031c();
        }
    }

    /* renamed from: a */
    private List<C14138j> m45465a(List<C14138j> allAnswers) {
        ArrayList<DNSRecord> ret = new ArrayList<>(allAnswers.size());
        ArrayList<DNSRecord> arecords = new ArrayList<>();
        for (C14138j answer : allAnswers) {
            if (answer.mo43862e().equals(C14104e.TYPE_A) || answer.mo43862e().equals(C14104e.TYPE_AAAA)) {
                arecords.add(answer);
            } else {
                ret.add(answer);
            }
        }
        ret.addAll(arecords);
        return ret;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo44116b(C14123d in, InetAddress addr, int port) throws IOException {
        if (f43012b.isDebugEnabled()) {
            C14236b bVar = f43012b;
            StringBuilder sb = new StringBuilder();
            sb.append(mo44087G());
            sb.append(".handle query: ");
            sb.append(in);
            bVar.mo44340a(sb.toString());
        }
        boolean conflictDetected = false;
        long expirationTime = System.currentTimeMillis() + 120;
        for (C14138j answer : in.mo43932b()) {
            conflictDetected |= answer.mo43982a(this, expirationTime);
        }
        mo44092M();
        try {
            if (this.f43030t != null) {
                this.f43030t.mo43917a(in);
            } else {
                C14123d plannedAnswer = in.clone();
                if (in.mo43949r()) {
                    this.f43030t = plannedAnswer;
                }
                mo44028a(plannedAnswer, addr, port);
            }
            mo44093N();
            long now = System.currentTimeMillis();
            for (C14138j answer2 : in.mo43934c()) {
                mo44110a(answer2, now);
            }
            if (conflictDetected) {
                mo44031c();
            }
        } catch (Throwable th) {
            mo44093N();
            throw th;
        }
    }

    /* renamed from: b */
    public void mo44115b(C14123d in) {
        mo44092M();
        try {
            if (this.f43030t == in) {
                this.f43030t = null;
            }
        } finally {
            mo44093N();
        }
    }

    /* renamed from: a */
    public void mo44109a(C14127g out) throws IOException {
        int port;
        InetAddress addr;
        String str = "send(";
        if (!out.mo43945n()) {
            if (out.mo43960w() != null) {
                addr = out.mo43960w().getAddress();
                port = out.mo43960w().getPort();
            } else {
                addr = this.f43014d;
                port = C14100a.f42767a;
            }
            byte[] message = out.mo43959v();
            DatagramPacket packet = new DatagramPacket(message, message.length, addr, port);
            if (f43012b.isTraceEnabled()) {
                try {
                    C14123d msg = new C14123d(packet);
                    if (f43012b.isTraceEnabled()) {
                        C14236b bVar = f43012b;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(mo44087G());
                        sb.append(") JmDNS out:");
                        sb.append(msg.mo43916a(true));
                        bVar.mo44345c(sb.toString());
                    }
                } catch (IOException e) {
                    C14236b bVar2 = f43012b;
                    String cls = getClass().toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(mo44087G());
                    sb2.append(") - JmDNS can not parse what it sends!!!");
                    bVar2.mo44341a(cls, sb2.toString(), e);
                }
            }
            MulticastSocket ms = this.f43015e;
            if (ms != null && !ms.isClosed()) {
                ms.send(packet);
            }
        }
    }

    /* renamed from: e */
    public void mo44033e() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44033e();
    }

    /* renamed from: i */
    public void mo44037i() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44037i();
    }

    /* renamed from: b */
    public void mo44030b() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44030b();
    }

    /* renamed from: a */
    public void mo44026a() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44026a();
    }

    /* renamed from: c */
    public void mo44031c() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44031c();
    }

    /* renamed from: h */
    public void mo44036h() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44036h();
    }

    /* renamed from: d */
    public void mo44032d() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44032d();
    }

    /* renamed from: f */
    public void mo44034f() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44034f();
    }

    /* renamed from: g */
    public void mo44035g() {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44035g();
    }

    /* renamed from: a */
    public void mo44027a(C14096C info) {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44027a(info);
    }

    /* renamed from: a */
    public void mo44029a(String type) {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44029a(type);
    }

    /* renamed from: a */
    public void mo44028a(C14123d in, InetAddress addr, int port) {
        C14152b a = C14152b.m45423a();
        mo44082B();
        a.mo44046b(this).mo44028a(in, addr, port);
    }

    /* renamed from: T */
    public void mo44099T() {
        C14236b bVar = f43012b;
        StringBuilder sb = new StringBuilder();
        sb.append(mo44087G());
        sb.append("recover()");
        bVar.mo44340a(sb.toString());
        if (!mo44097R() && !isClosed() && !mo44096Q() && !mo44095P()) {
            synchronized (this.f43033w) {
                if (mo44128w()) {
                    C14236b bVar2 = f43012b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(mo44087G());
                    sb2.append("recover() thread ");
                    sb2.append(Thread.currentThread().getName());
                    bVar2.mo44340a(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(mo44087G());
                    sb3.append(".recover()");
                    new C14162t(this, sb3.toString()).start();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public void mo44127v() {
        if (f43012b.isDebugEnabled()) {
            C14236b bVar = f43012b;
            StringBuilder sb = new StringBuilder();
            sb.append(mo44087G());
            sb.append("recover() Cleanning up");
            bVar.mo44340a(sb.toString());
        }
        f43012b.mo44343b("RECOVERING");
        mo44033e();
        Collection<ServiceInfo> oldServiceInfos = new ArrayList<>(mo44089J().values());
        mo43161j();
        m45463X();
        mo44125j(5000);
        mo44037i();
        m45462W();
        mo44131z().clear();
        if (f43012b.isDebugEnabled()) {
            C14236b bVar2 = f43012b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo44087G());
            sb2.append("recover() All is clean");
            bVar2.mo44340a(sb2.toString());
        }
        if (mo44095P()) {
            Iterator i$ = oldServiceInfos.iterator();
            while (i$.hasNext()) {
                ((C14096C) i$.next()).mo43791H();
            }
            mo44100U();
            try {
                m45466a(mo44086F());
                m45468a(oldServiceInfos);
            } catch (Exception exception) {
                C14236b bVar3 = f43012b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(mo44087G());
                sb3.append("recover() Start services exception ");
                bVar3.mo44344b(sb3.toString(), exception);
            }
            C14236b bVar4 = f43012b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo44087G());
            sb4.append("recover() We are back!");
            bVar4.mo44343b(sb4.toString());
            return;
        }
        C14236b bVar5 = f43012b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(mo44087G());
        sb5.append("recover() Could not recover we are Down!");
        bVar5.mo44343b(sb5.toString());
        if (mo44081A() != null) {
            C13816a A = mo44081A();
            mo44082B();
            A.mo43162a(this, oldServiceInfos);
        }
    }

    /* renamed from: x */
    public void mo44129x() {
        long now = System.currentTimeMillis();
        Set<String> staleServiceTypesForRefresh = new HashSet<>();
        for (C14109b entry : mo44131z().mo43819a()) {
            try {
                C14138j record = (C14138j) entry;
                if (record.mo43853a(now)) {
                    mo44104a(now, record, C14165a.Remove);
                    mo44131z().mo43825c(record);
                } else if (record.mo43988d(now)) {
                    record.mo43994r();
                    String type = record.mo43992p().mo43185s().toLowerCase();
                    if (staleServiceTypesForRefresh.add(type)) {
                        mo44120c(type);
                    }
                }
            } catch (Exception exception) {
                C14236b bVar = f43012b;
                StringBuilder sb = new StringBuilder();
                sb.append(mo44087G());
                sb.append(".Error while reaping records: ");
                sb.append(entry);
                bVar.mo44344b(sb.toString(), exception);
                f43012b.mo44343b(toString());
            }
        }
    }

    public void close() {
        if (!mo44097R()) {
            if (f43012b.isDebugEnabled()) {
                C14236b bVar = f43012b;
                StringBuilder sb = new StringBuilder();
                sb.append("Cancelling JmDNS: ");
                sb.append(this);
                bVar.mo44340a(sb.toString());
            }
            if (mo44130y()) {
                f43012b.mo44340a("Canceling the timer");
                mo44030b();
                mo43161j();
                m45463X();
                if (f43012b.isDebugEnabled()) {
                    C14236b bVar2 = f43012b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Wait for JmDNS cancel: ");
                    sb2.append(this);
                    bVar2.mo44340a(sb2.toString());
                }
                mo44125j(5000);
                f43012b.mo44340a("Canceling the state timer");
                mo44026a();
                this.f43028r.shutdown();
                m45462W();
                if (this.f43023m != null) {
                    Runtime.getRuntime().removeShutdownHook(this.f43023m);
                }
                C14152b a = C14152b.m45423a();
                mo44082B();
                a.mo44045a(this);
                if (f43012b.isDebugEnabled()) {
                    f43012b.mo44340a("JmDNS closed.");
                }
            }
            mo43803a((C14110a) null);
        }
    }

    public String toString() {
        String str;
        StringBuilder aLog = new StringBuilder(Opcodes.ACC_STRICT);
        String str2 = "\n";
        aLog.append(str2);
        aLog.append("\t---- Local Host -----");
        aLog.append("\n\t");
        aLog.append(this.f43024n);
        aLog.append("\n\t---- Services -----");
        Iterator i$ = this.f43020j.keySet().iterator();
        while (true) {
            str = ": ";
            if (!i$.hasNext()) {
                break;
            }
            String key = (String) i$.next();
            aLog.append("\n\t\tService: ");
            aLog.append(key);
            aLog.append(str);
            aLog.append(this.f43020j.get(key));
        }
        aLog.append(str2);
        aLog.append("\t---- Types ----");
        for (String key2 : this.f43021k.keySet()) {
            C14167c subtypes = (C14167c) this.f43021k.get(key2);
            aLog.append("\n\t\tType: ");
            aLog.append(subtypes.mo44133a());
            aLog.append(str);
            aLog.append(subtypes.isEmpty() ? "no subtypes" : subtypes);
        }
        aLog.append(str2);
        aLog.append(this.f43019i.toString());
        aLog.append(str2);
        aLog.append("\t---- Service Collectors ----");
        for (String key3 : this.f43031u.keySet()) {
            aLog.append("\n\t\tService Collector: ");
            aLog.append(key3);
            aLog.append(str);
            aLog.append(this.f43031u.get(key3));
        }
        aLog.append(str2);
        aLog.append("\t---- Service Listeners ----");
        for (String key4 : this.f43017g.keySet()) {
            aLog.append("\n\t\tService Listener: ");
            aLog.append(key4);
            aLog.append(str);
            aLog.append(this.f43017g.get(key4));
        }
        return aLog.toString();
    }

    /* renamed from: X */
    private void m45463X() {
        if (f43012b.isDebugEnabled()) {
            f43012b.mo44340a("disposeServiceCollectors()");
        }
        for (String type : this.f43031u.keySet()) {
            C14166b collector = (C14166b) this.f43031u.get(type);
            if (collector != null) {
                mo44117b(type, (C13823e) collector);
                this.f43031u.remove(type, collector);
            }
        }
    }

    /* renamed from: a */
    static String m45464a(String type, String qualifiedName) {
        String loType = type.toLowerCase();
        String loQualifiedName = qualifiedName.toLowerCase();
        if (!loQualifiedName.endsWith(loType) || loQualifiedName.equals(loType)) {
            return qualifiedName;
        }
        return qualifiedName.substring(0, (qualifiedName.length() - type.length()) - 1);
    }

    /* renamed from: J */
    public Map<String, C13821d> mo44089J() {
        return this.f43020j;
    }

    /* renamed from: h */
    public void mo44122h(long lastThrottleIncrement) {
        this.f43027q = lastThrottleIncrement;
    }

    /* renamed from: E */
    public long mo44085E() {
        return this.f43027q;
    }

    /* renamed from: a */
    public void mo44103a(int throttle) {
        this.f43026p = throttle;
    }

    /* renamed from: L */
    public int mo44091L() {
        return this.f43026p;
    }

    /* renamed from: H */
    public static Random m45461H() {
        return f43013c;
    }

    /* renamed from: M */
    public void mo44092M() {
        this.f43029s.lock();
    }

    /* renamed from: N */
    public void mo44093N() {
        this.f43029s.unlock();
    }

    /* renamed from: I */
    public Map<String, C14167c> mo44088I() {
        return this.f43021k;
    }

    /* renamed from: K */
    public MulticastSocket mo44090K() {
        return this.f43015e;
    }

    /* renamed from: C */
    public InetAddress mo44083C() {
        return this.f43014d;
    }

    /* renamed from: A */
    public C13816a mo44081A() {
        return this.f43022l;
    }
}
