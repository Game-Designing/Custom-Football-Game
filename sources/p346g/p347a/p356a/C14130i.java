package p346g.p347a.p356a;

import java.net.InetAddress;
import java.util.Set;
import p346g.p347a.C13821d.C13822a;
import p346g.p347a.p356a.C14138j.C14143e;
import p346g.p347a.p356a.C14164v.C14167c;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.i */
/* compiled from: DNSQuestion */
public class C14130i extends C14109b {

    /* renamed from: h */
    private static C14236b f42954h = C14246c.m45851a(C14130i.class.getName());

    /* renamed from: g.a.a.i$a */
    /* compiled from: DNSQuestion */
    private static class C14131a extends C14130i {
        C14131a(String name, C14104e type, C14103d recordClass, boolean unique) {
            super(name, type, recordClass, unique);
        }

        /* renamed from: d */
        public boolean mo43861d(C14109b entry) {
            return entry != null;
        }

        /* renamed from: a */
        public void mo43971a(C14164v jmDNSImpl, Set<C14138j> answers) {
            String loname = mo43856b().toLowerCase();
            if (jmDNSImpl.mo44086F().mo44064g().equalsIgnoreCase(loname)) {
                answers.addAll(jmDNSImpl.mo44086F().mo44049a(mo43860d(), mo43871k(), 3600));
            } else if (jmDNSImpl.mo44088I().containsKey(loname)) {
                new C14135e(mo43856b(), C14104e.TYPE_PTR, mo43860d(), mo43871k()).mo43971a(jmDNSImpl, answers);
            } else {
                for (C14096C a : jmDNSImpl.mo44089J().values()) {
                    mo43972a(jmDNSImpl, answers, a);
                }
            }
        }

        /* renamed from: a */
        public boolean mo43973a(C14164v jmDNSImpl) {
            String name = mo43856b().toLowerCase();
            return jmDNSImpl.mo44086F().mo44064g().equals(name) || jmDNSImpl.mo44089J().keySet().contains(name);
        }
    }

    /* renamed from: g.a.a.i$b */
    /* compiled from: DNSQuestion */
    private static class C14132b extends C14130i {
        C14132b(String name, C14104e type, C14103d recordClass, boolean unique) {
            super(name, type, recordClass, unique);
        }

        /* renamed from: a */
        public void mo43971a(C14164v jmDNSImpl, Set<C14138j> answers) {
            C14138j answer = jmDNSImpl.mo44086F().mo44048a(mo43862e(), true, 3600);
            if (answer != null) {
                answers.add(answer);
            }
        }

        /* renamed from: a */
        public boolean mo43973a(C14164v jmDNSImpl) {
            String name = mo43856b().toLowerCase();
            return jmDNSImpl.mo44086F().mo44064g().equals(name) || jmDNSImpl.mo44089J().keySet().contains(name);
        }
    }

    /* renamed from: g.a.a.i$c */
    /* compiled from: DNSQuestion */
    private static class C14133c extends C14130i {
        C14133c(String name, C14104e type, C14103d recordClass, boolean unique) {
            super(name, type, recordClass, unique);
        }

        /* renamed from: a */
        public void mo43971a(C14164v jmDNSImpl, Set<C14138j> answers) {
            C14138j answer = jmDNSImpl.mo44086F().mo44048a(mo43862e(), true, 3600);
            if (answer != null) {
                answers.add(answer);
            }
        }

        /* renamed from: a */
        public boolean mo43973a(C14164v jmDNSImpl) {
            String name = mo43856b().toLowerCase();
            return jmDNSImpl.mo44086F().mo44064g().equals(name) || jmDNSImpl.mo44089J().keySet().contains(name);
        }
    }

    /* renamed from: g.a.a.i$d */
    /* compiled from: DNSQuestion */
    private static class C14134d extends C14130i {
        C14134d(String name, C14104e type, C14103d recordClass, boolean unique) {
            super(name, type, recordClass, unique);
        }
    }

    /* renamed from: g.a.a.i$e */
    /* compiled from: DNSQuestion */
    private static class C14135e extends C14130i {
        C14135e(String name, C14104e type, C14103d recordClass, boolean unique) {
            super(name, type, recordClass, unique);
        }

        /* renamed from: a */
        public void mo43971a(C14164v jmDNSImpl, Set<C14138j> answers) {
            for (C14096C a : jmDNSImpl.mo44089J().values()) {
                mo43972a(jmDNSImpl, answers, a);
            }
            if (mo43870j()) {
                for (String serviceType : jmDNSImpl.mo44088I().keySet()) {
                    C14143e eVar = new C14143e("_services._dns-sd._udp.local.", C14103d.CLASS_IN, false, 3600, ((C14167c) jmDNSImpl.mo44088I().get(serviceType)).mo44133a());
                    answers.add(eVar);
                }
            } else if (mo43869i()) {
                String ipValue = (String) mo43858c().get(C13822a.Instance);
                if (ipValue != null && ipValue.length() > 0) {
                    InetAddress address = jmDNSImpl.mo44086F().mo44062e();
                    if (ipValue.equalsIgnoreCase(address != null ? address.getHostAddress() : "")) {
                        if (mo43872l()) {
                            answers.add(jmDNSImpl.mo44086F().mo44055b(C14104e.TYPE_A, false, 3600));
                        }
                        if (mo43873m()) {
                            answers.add(jmDNSImpl.mo44086F().mo44055b(C14104e.TYPE_AAAA, false, 3600));
                        }
                    }
                }
            } else {
                mo43867h();
            }
        }
    }

    /* renamed from: g.a.a.i$f */
    /* compiled from: DNSQuestion */
    private static class C14136f extends C14130i {
        C14136f(String name, C14104e type, C14103d recordClass, boolean unique) {
            super(name, type, recordClass, unique);
        }

        /* renamed from: a */
        public void mo43971a(C14164v jmDNSImpl, Set<C14138j> answers) {
            String loname = mo43856b().toLowerCase();
            if (jmDNSImpl.mo44086F().mo44064g().equalsIgnoreCase(loname)) {
                answers.addAll(jmDNSImpl.mo44086F().mo44049a(mo43860d(), mo43871k(), 3600));
            } else if (jmDNSImpl.mo44088I().containsKey(loname)) {
                new C14135e(mo43856b(), C14104e.TYPE_PTR, mo43860d(), mo43871k()).mo43971a(jmDNSImpl, answers);
            } else {
                mo43972a(jmDNSImpl, answers, (C14096C) jmDNSImpl.mo44089J().get(loname));
            }
        }

        /* renamed from: a */
        public boolean mo43973a(C14164v jmDNSImpl) {
            String name = mo43856b().toLowerCase();
            return jmDNSImpl.mo44086F().mo44064g().equals(name) || jmDNSImpl.mo44089J().keySet().contains(name);
        }
    }

    /* renamed from: g.a.a.i$g */
    /* compiled from: DNSQuestion */
    private static class C14137g extends C14130i {
        C14137g(String name, C14104e type, C14103d recordClass, boolean unique) {
            super(name, type, recordClass, unique);
        }

        /* renamed from: a */
        public void mo43971a(C14164v jmDNSImpl, Set<C14138j> answers) {
            mo43972a(jmDNSImpl, answers, (C14096C) jmDNSImpl.mo44089J().get(mo43856b().toLowerCase()));
        }

        /* renamed from: a */
        public boolean mo43973a(C14164v jmDNSImpl) {
            String name = mo43856b().toLowerCase();
            return jmDNSImpl.mo44086F().mo44064g().equals(name) || jmDNSImpl.mo44089J().keySet().contains(name);
        }
    }

    C14130i(String name, C14104e type, C14103d recordClass, boolean unique) {
        super(name, type, recordClass, unique);
    }

    /* renamed from: a */
    public static C14130i m45277a(String name, C14104e type, C14103d recordClass, boolean unique) {
        switch (C14129h.f42953a[type.ordinal()]) {
            case 1:
                return new C14132b(name, type, recordClass, unique);
            case 2:
                return new C14133c(name, type, recordClass, unique);
            case 3:
                return new C14133c(name, type, recordClass, unique);
            case 4:
                return new C14131a(name, type, recordClass, unique);
            case 5:
                return new C14134d(name, type, recordClass, unique);
            case 6:
                return new C14135e(name, type, recordClass, unique);
            case 7:
                return new C14136f(name, type, recordClass, unique);
            case 8:
                return new C14137g(name, type, recordClass, unique);
            default:
                return new C14130i(name, type, recordClass, unique);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo43974f(C14109b rec) {
        return mo43859c(rec) && mo43861d(rec) && mo43856b().equals(rec.mo43856b());
    }

    /* renamed from: a */
    public void mo43971a(C14164v jmDNSImpl, Set<C14138j> set) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo43972a(C14164v jmDNSImpl, Set<C14138j> answers, C14096C info) {
        if (info != null && info.mo43787D()) {
            if (mo43856b().equalsIgnoreCase(info.mo43181o()) || mo43856b().equalsIgnoreCase(info.mo43185s()) || mo43856b().equalsIgnoreCase(info.mo43786C())) {
                answers.addAll(jmDNSImpl.mo44086F().mo44049a(mo43860d(), true, 3600));
                answers.addAll(info.mo43794a(mo43860d(), true, 3600, jmDNSImpl.mo44086F()));
            }
            if (f42954h.isDebugEnabled()) {
                C14236b bVar = f42954h;
                StringBuilder sb = new StringBuilder();
                sb.append(jmDNSImpl.mo44087G());
                sb.append(" DNSQuestion(");
                sb.append(mo43856b());
                sb.append(").addAnswersForServiceInfo(): info: ");
                sb.append(info);
                sb.append("\n");
                sb.append(answers);
                bVar.mo44340a(sb.toString());
            }
        }
    }

    /* renamed from: a */
    public boolean mo43853a(long now) {
        return false;
    }

    /* renamed from: a */
    public boolean mo43973a(C14164v jmDNSImpl) {
        return false;
    }

    /* renamed from: a */
    public void mo43852a(StringBuilder aLog) {
    }
}
