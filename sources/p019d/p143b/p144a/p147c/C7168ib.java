package p019d.p143b.p144a.p147c;

import java.util.Map;

/* renamed from: d.b.a.c.ib */
public class C7168ib {

    /* renamed from: a */
    private final String f13593a;

    /* renamed from: b */
    private final Map<String, String> f13594b;

    /* renamed from: c */
    private final long f13595c;

    /* renamed from: d */
    private final String f13596d;

    public C7168ib(String str, Map<String, String> map, long j, String str2) {
        this.f13593a = str;
        this.f13594b = map;
        this.f13595c = j;
        this.f13596d = str2;
    }

    /* renamed from: a */
    public String mo23170a() {
        return this.f13593a;
    }

    /* renamed from: b */
    public Map<String, String> mo23171b() {
        return this.f13594b;
    }

    /* renamed from: c */
    public long mo23172c() {
        return this.f13595c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || C7168ib.class != obj.getClass()) {
            return false;
        }
        C7168ib ibVar = (C7168ib) obj;
        if (this.f13595c != ibVar.f13595c) {
            return false;
        }
        String str = this.f13593a;
        if (str == null ? ibVar.f13593a != null : !str.equals(ibVar.f13593a)) {
            return false;
        }
        Map<String, String> map = this.f13594b;
        if (map == null ? ibVar.f13594b != null : !map.equals(ibVar.f13594b)) {
            return false;
        }
        String str2 = this.f13596d;
        if (str2 == null ? ibVar.f13596d != null : !str2.equals(ibVar.f13596d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f13593a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.f13594b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j = this.f13595c;
        int i2 = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f13596d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SdkEvent{eventType='");
        sb.append(this.f13593a);
        sb.append('\'');
        sb.append(", parameters=");
        sb.append(this.f13594b);
        sb.append(", creationTsMillis=");
        sb.append(this.f13595c);
        sb.append(", uniqueIdentifier='");
        sb.append(this.f13596d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
