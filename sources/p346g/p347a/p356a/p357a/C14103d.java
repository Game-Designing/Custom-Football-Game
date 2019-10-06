package p346g.p347a.p356a.p357a;

import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.a.d */
/* compiled from: DNSRecordClass */
public enum C14103d {
    CLASS_UNKNOWN("?", 0),
    CLASS_IN("in", 1),
    CLASS_CS("cs", 2),
    CLASS_CH("ch", 3),
    CLASS_HS("hs", 4),
    CLASS_NONE("none", 254),
    CLASS_ANY("any", 255);
    

    /* renamed from: h */
    private static C14236b f42790h;

    /* renamed from: j */
    private final String f42792j;

    /* renamed from: k */
    private final int f42793k;

    static {
        f42790h = C14246c.m45851a(C14103d.class.getName());
    }

    private C14103d(String name, int index) {
        this.f42792j = name;
        this.f42793k = index;
    }

    /* renamed from: e */
    public int mo43833e() {
        return this.f42793k;
    }

    /* renamed from: b */
    public boolean mo43832b(int index) {
        return (this == CLASS_UNKNOWN || (32768 & index) == 0) ? false : true;
    }

    /* renamed from: a */
    public static C14103d m45113a(int index) {
        C14103d[] arr$;
        int maskedIndex = index & 32767;
        for (C14103d aClass : values()) {
            if (aClass.f42793k == maskedIndex) {
                return aClass;
            }
        }
        C14236b bVar = f42790h;
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find record class for index: ");
        sb.append(index);
        bVar.mo44343b(sb.toString());
        return CLASS_UNKNOWN;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" index ");
        sb.append(mo43833e());
        return sb.toString();
    }
}
