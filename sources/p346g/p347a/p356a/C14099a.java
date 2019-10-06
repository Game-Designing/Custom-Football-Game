package p346g.p347a.p356a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.jmdns.impl.DNSEntry;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;

/* renamed from: g.a.a.a */
/* compiled from: DNSCache */
public class C14099a extends ConcurrentHashMap<String, List<C14109b>> {
    public C14099a(C14099a map) {
        this(map != null ? map.size() : Opcodes.ACC_ABSTRACT);
        if (map != null) {
            putAll(map);
        }
    }

    public C14099a(int initialCapacity) {
        super(initialCapacity);
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return new C14099a(this);
    }

    /* renamed from: a */
    public Collection<C14109b> mo43819a() {
        List<DNSEntry> allValues = new ArrayList<>();
        for (List<? extends DNSEntry> entry : values()) {
            if (entry != null) {
                allValues.addAll(entry);
            }
        }
        return allValues;
    }

    /* renamed from: a */
    public Collection<? extends C14109b> mo43820a(String name) {
        Collection<? extends DNSEntry> entryList = m45099b(name);
        if (entryList == null) {
            return Collections.emptyList();
        }
        synchronized (entryList) {
            try {
                Collection<? extends DNSEntry> entryList2 = new ArrayList<>(entryList);
                return entryList2;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* renamed from: b */
    private Collection<? extends C14109b> m45099b(String name) {
        return (Collection) get(name != null ? name.toLowerCase() : null);
    }

    /* renamed from: b */
    public C14109b mo43823b(C14109b dnsEntry) {
        C14109b result = null;
        if (dnsEntry != null) {
            Collection<? extends DNSEntry> entryList = m45099b(dnsEntry.mo43850a());
            if (entryList != null) {
                synchronized (entryList) {
                    Iterator i$ = entryList.iterator();
                    while (true) {
                        if (!i$.hasNext()) {
                            break;
                        }
                        C14109b testDNSEntry = (C14109b) i$.next();
                        if (testDNSEntry.mo43857b(dnsEntry)) {
                            result = testDNSEntry;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    /* renamed from: a */
    public C14109b mo43818a(String name, C14104e type, C14103d recordClass) {
        C14109b result = null;
        Collection<? extends DNSEntry> entryList = m45099b(name);
        if (entryList != null) {
            synchronized (entryList) {
                Iterator i$ = entryList.iterator();
                while (true) {
                    if (!i$.hasNext()) {
                        break;
                    }
                    C14109b testDNSEntry = (C14109b) i$.next();
                    if (testDNSEntry.mo43855a(type) && testDNSEntry.mo43854a(recordClass)) {
                        result = testDNSEntry;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /* renamed from: b */
    public Collection<? extends C14109b> mo43824b(String name, C14104e type, C14103d recordClass) {
        Collection<? extends DNSEntry> entryList = m45099b(name);
        if (entryList == null) {
            return Collections.emptyList();
        }
        synchronized (entryList) {
            try {
                Collection<? extends DNSEntry> entryList2 = new ArrayList<>(entryList);
                Iterator<? extends DNSEntry> i = entryList2.iterator();
                while (i.hasNext()) {
                    C14109b testDNSEntry = (C14109b) i.next();
                    if (!testDNSEntry.mo43855a(type) || !testDNSEntry.mo43854a(recordClass)) {
                        i.remove();
                    }
                }
                return entryList2;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* renamed from: a */
    public boolean mo43821a(C14109b dnsEntry) {
        if (dnsEntry == null) {
            return false;
        }
        List<DNSEntry> entryList = (List) get(dnsEntry.mo43850a());
        if (entryList == null) {
            putIfAbsent(dnsEntry.mo43850a(), new ArrayList());
            entryList = (List) get(dnsEntry.mo43850a());
        }
        synchronized (entryList) {
            entryList.add(dnsEntry);
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo43825c(C14109b dnsEntry) {
        if (dnsEntry != null) {
            List<DNSEntry> entryList = (List) get(dnsEntry.mo43850a());
            if (entryList != null) {
                synchronized (entryList) {
                    entryList.remove(dnsEntry);
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo43822a(C14109b newDNSEntry, C14109b existingDNSEntry) {
        if (newDNSEntry == null || existingDNSEntry == null || !newDNSEntry.mo43850a().equals(existingDNSEntry.mo43850a())) {
            return false;
        }
        List<DNSEntry> entryList = (List) get(newDNSEntry.mo43850a());
        if (entryList == null) {
            putIfAbsent(newDNSEntry.mo43850a(), new ArrayList());
            entryList = (List) get(newDNSEntry.mo43850a());
        }
        synchronized (entryList) {
            entryList.remove(existingDNSEntry);
            entryList.add(newDNSEntry);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        r4 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String toString() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x006f }
            r1 = 2000(0x7d0, float:2.803E-42)
            r0.<init>(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = "\t---- cache ----"
            r0.append(r1)     // Catch:{ all -> 0x006f }
            java.util.Enumeration r1 = r7.keys()     // Catch:{ all -> 0x006f }
        L_0x0011:
            boolean r2 = r1.hasMoreElements()     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r1.nextElement()     // Catch:{ all -> 0x006f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "\n\t\t"
            r0.append(r3)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "\n\t\tname '"
            r0.append(r3)     // Catch:{ all -> 0x006f }
            r0.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "' "
            r0.append(r3)     // Catch:{ all -> 0x006f }
            java.lang.Object r3 = r7.get(r2)     // Catch:{ all -> 0x006f }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0063
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x006f }
            if (r4 != 0) goto L_0x0063
            monitor-enter(r3)     // Catch:{ all -> 0x006f }
            java.util.Iterator r4 = r3.iterator()     // Catch:{ all -> 0x005e }
        L_0x0042:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005c
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x005e }
            g.a.a.b r5 = (p346g.p347a.p356a.C14109b) r5     // Catch:{ all -> 0x005e }
            java.lang.String r6 = "\n\t\t\t"
            r0.append(r6)     // Catch:{ all -> 0x005e }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x005e }
            r0.append(r6)     // Catch:{ all -> 0x005e }
            goto L_0x0042
        L_0x005c:
            monitor-exit(r3)     // Catch:{ all -> 0x005e }
            goto L_0x0068
        L_0x005e:
            r4 = move-exception
        L_0x005f:
            monitor-exit(r3)     // Catch:{ all -> 0x0061 }
            throw r4     // Catch:{ all -> 0x006f }
        L_0x0061:
            r4 = move-exception
            goto L_0x005f
        L_0x0063:
            java.lang.String r4 = " no entries"
            r0.append(r4)     // Catch:{ all -> 0x006f }
        L_0x0068:
            goto L_0x0011
        L_0x0069:
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x006f }
            monitor-exit(r7)
            return r2
        L_0x006f:
            r0 = move-exception
            monitor-exit(r7)
            goto L_0x0073
        L_0x0072:
            throw r0
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: p346g.p347a.p356a.C14099a.toString():java.lang.String");
    }
}
