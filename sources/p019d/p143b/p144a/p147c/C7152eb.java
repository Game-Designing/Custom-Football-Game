package p019d.p143b.p144a.p147c;

import java.util.Map;

/* renamed from: d.b.a.c.eb */
final class C7152eb {

    /* renamed from: a */
    private int f13505a;

    /* renamed from: b */
    private String f13506b;

    /* renamed from: c */
    private String f13507c;

    /* renamed from: d */
    private Map<String, String> f13508d;

    C7152eb(String str, Map<String, String> map, int i, String str2) {
        this.f13505a = i;
        this.f13508d = map;
        this.f13506b = str;
        this.f13507c = str2;
    }

    /* renamed from: a */
    public int mo23101a() {
        return this.f13505a;
    }

    /* renamed from: a */
    public void mo23102a(int i) {
        this.f13505a = i;
    }

    /* renamed from: b */
    public String mo23103b() {
        return this.f13506b;
    }

    /* renamed from: c */
    public String mo23104c() {
        return this.f13507c;
    }

    /* renamed from: d */
    public Map<String, String> mo23105d() {
        return this.f13508d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C7152eb.class != obj.getClass()) {
            return false;
        }
        C7152eb ebVar = (C7152eb) obj;
        if (this.f13505a != ebVar.f13505a) {
            return false;
        }
        String str = this.f13506b;
        if (str == null ? ebVar.f13506b != null : !str.equals(ebVar.f13506b)) {
            return false;
        }
        String str2 = this.f13507c;
        if (str2 == null ? ebVar.f13507c != null : !str2.equals(ebVar.f13507c)) {
            return false;
        }
        Map<String, String> map = this.f13508d;
        return map == null ? ebVar.f13508d == null : map.equals(ebVar.f13508d);
    }

    public int hashCode() {
        int i = this.f13505a * 31;
        String str = this.f13506b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13507c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.f13508d;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostbackRequest{attemptNumber=");
        sb.append(this.f13505a);
        sb.append(", targetUrl='");
        sb.append(this.f13506b);
        sb.append('\'');
        sb.append(", backupUrl='");
        sb.append(this.f13507c);
        sb.append('\'');
        sb.append(", requestBody=");
        sb.append(this.f13508d);
        sb.append('}');
        return sb.toString();
    }
}
