package p363i.p364a.p365a;

/* renamed from: i.a.a.a */
public class C14212a implements C14217e {

    /* renamed from: a */
    public final int f43120a;

    /* renamed from: b */
    public final int f43121b;

    public C14212a(int i, int i2) {
        this.f43120a = i;
        this.f43121b = i2;
    }

    /* renamed from: a */
    public final int mo44319a() {
        return this.f43120a;
    }

    /* renamed from: b */
    public final int mo44320b() {
        return this.f43121b;
    }

    /* renamed from: c */
    public final int mo44321c() {
        return (this.f43121b - this.f43120a) + 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C14217e)) {
            return false;
        }
        C14217e eVar = (C14217e) obj;
        if (this.f43120a == eVar.mo44319a() && this.f43121b == eVar.mo44320b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f43120a % 100) + (this.f43121b % 100);
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof C14217e)) {
            return -1;
        }
        C14217e eVar = (C14217e) obj;
        int a = this.f43120a - eVar.mo44319a();
        return a != 0 ? a : this.f43121b - eVar.mo44320b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f43120a);
        sb.append(":");
        sb.append(this.f43121b);
        return sb.toString();
    }
}
