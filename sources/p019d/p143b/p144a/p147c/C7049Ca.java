package p019d.p143b.p144a.p147c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Ca */
class C7049Ca {

    /* renamed from: a */
    private final String f13170a;

    /* renamed from: b */
    private final String f13171b;

    C7049Ca(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (str2 != null) {
            this.f13170a = str.toLowerCase(Locale.ENGLISH);
            this.f13171b = str2;
        } else {
            throw new IllegalArgumentException("No classname specified");
        }
    }

    /* renamed from: a */
    static C7049Ca m14622a(String str, C7262l lVar) {
        String str2 = "Unable to parse config '";
        if (!C7269s.m15819a(str)) {
            return null;
        }
        String str3 = "MediationAdapterManager";
        if (str.contains(":")) {
            try {
                int indexOf = str.indexOf(58);
                if (indexOf > 0 && indexOf < str.length() - 1) {
                    return new C7049Ca(str.substring(0, indexOf).toLowerCase(Locale.ENGLISH), str.substring(indexOf + 1, str.length()));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str);
                sb.append("': malformed string");
                lVar.mo22921e(str3, sb.toString());
                return null;
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(str);
                sb2.append("'");
                lVar.mo22919c(str3, sb2.toString(), th);
            }
        } else {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (C7045Ba.f13153a.containsKey(lowerCase)) {
                return new C7049Ca(lowerCase, (String) C7045Ba.f13153a.get(lowerCase));
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to create config '");
            sb3.append(str);
            sb3.append("': unknown name");
            lVar.mo22921e(str3, sb3.toString());
            return null;
        }
    }

    /* renamed from: a */
    static String m14623a(Collection<C7049Ca> collection) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (C7049Ca c : collection) {
            sb.append(c.mo22768c());
            sb.append(',');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    /* renamed from: b */
    static Collection<C7049Ca> m14624b(String str, C7262l lVar) {
        if (lVar != null) {
            ArrayList arrayList = new ArrayList();
            for (String a : C7178l.m15309a(str)) {
                C7049Ca a2 = m14622a(a, lVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No logger specified");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo22766a() {
        return this.f13171b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo22767b() {
        return this.f13170a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo22768c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13170a);
        sb.append(":");
        sb.append(this.f13171b);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || C7049Ca.class != obj.getClass()) {
            return false;
        }
        C7049Ca ca = (C7049Ca) obj;
        String str = this.f13170a;
        if (str == null ? ca.f13170a != null : !str.equals(ca.f13170a)) {
            return false;
        }
        String str2 = this.f13171b;
        if (str2 != null) {
            z = str2.equals(ca.f13171b);
        } else if (ca.f13171b != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f13170a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f13171b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Adapter Spec: ");
        sb.append(mo22768c());
        sb.append("]");
        return sb.toString();
    }
}
