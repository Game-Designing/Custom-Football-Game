package p346g.p347a.p356a;

import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: g.a.a.y */
/* compiled from: NameRegister */
public interface C14173y {

    /* renamed from: g.a.a.y$a */
    /* compiled from: NameRegister */
    public static abstract class C14174a implements C14173y {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String mo44158a(String name) {
            int hostNameCount;
            StringBuilder givenName = new StringBuilder(name.length() + 5);
            String str = ".local.";
            int plocal = name.indexOf(str);
            int punder = name.lastIndexOf(45);
            if (punder < 0) {
                hostNameCount = 1;
                givenName.append(name.substring(0, plocal));
            } else {
                try {
                    hostNameCount = Integer.parseInt(name.substring(punder + 1, plocal)) + 1;
                    givenName.append(name.substring(0, punder));
                } catch (Exception e) {
                    hostNameCount = 1;
                    givenName.append(name.substring(0, plocal));
                }
            }
            givenName.append('-');
            givenName.append(hostNameCount);
            givenName.append(str);
            return givenName.toString();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo44159b(String name) {
            StringBuilder givenName = new StringBuilder(name.length() + 5);
            int l = name.lastIndexOf(40);
            int r = name.lastIndexOf(41);
            String str = " (2)";
            if (l < 0 || l >= r) {
                givenName.append(name);
                givenName.append(str);
            } else {
                try {
                    givenName.append(name.substring(0, l));
                    givenName.append('(');
                    givenName.append(Integer.parseInt(name.substring(l + 1, r)) + 1);
                    givenName.append(')');
                } catch (NumberFormatException e) {
                    givenName.setLength(0);
                    givenName.append(name);
                    givenName.append(str);
                }
            }
            return givenName.toString();
        }
    }

    /* renamed from: g.a.a.y$b */
    /* compiled from: NameRegister */
    public static class C14175b {

        /* renamed from: a */
        private static volatile C14173y f43055a;

        /* renamed from: a */
        public static C14173y m45548a() {
            if (f43055a == null) {
                f43055a = new C14177d();
            }
            return f43055a;
        }
    }

    /* renamed from: g.a.a.y$c */
    /* compiled from: NameRegister */
    public enum C14176c {
        HOST,
        SERVICE
    }

    /* renamed from: g.a.a.y$d */
    /* compiled from: NameRegister */
    public static class C14177d extends C14174a {

        /* renamed from: a */
        private final ConcurrentMap<InetAddress, String> f43059a = new ConcurrentHashMap();

        /* renamed from: b */
        private final ConcurrentMap<InetAddress, Set<String>> f43060b = new ConcurrentHashMap();

        /* renamed from: a */
        public String mo44157a(InetAddress networkInterface, String name, C14176c type) {
            int i = C14172x.f43054a[type.ordinal()];
            if (i == 1) {
                return mo44158a(name);
            }
            if (i != 2) {
                return name;
            }
            return mo44159b(name);
        }
    }

    /* renamed from: a */
    String mo44157a(InetAddress inetAddress, String str, C14176c cVar);
}
