package p320f.p321a.p327d.p340j;

import java.util.ArrayList;

/* renamed from: f.a.d.j.m */
/* compiled from: LinkedArrayList */
public class C13752m {

    /* renamed from: a */
    final int f41860a;

    /* renamed from: b */
    Object[] f41861b;

    /* renamed from: c */
    Object[] f41862c;

    /* renamed from: d */
    volatile int f41863d;

    /* renamed from: e */
    int f41864e;

    public C13752m(int capacityHint) {
        this.f41860a = capacityHint;
    }

    /* renamed from: a */
    public void mo42737a(Object o) {
        if (this.f41863d == 0) {
            this.f41861b = new Object[(this.f41860a + 1)];
            Object[] objArr = this.f41861b;
            this.f41862c = objArr;
            objArr[0] = o;
            this.f41864e = 1;
            this.f41863d = 1;
            return;
        }
        int i = this.f41864e;
        int i2 = this.f41860a;
        if (i == i2) {
            Object[] t = new Object[(i2 + 1)];
            t[0] = o;
            this.f41862c[i2] = t;
            this.f41862c = t;
            this.f41864e = 1;
            this.f41863d++;
            return;
        }
        this.f41862c[i] = o;
        this.f41864e = i + 1;
        this.f41863d++;
    }

    /* renamed from: a */
    public Object[] mo42738a() {
        return this.f41861b;
    }

    /* renamed from: b */
    public int mo42739b() {
        return this.f41863d;
    }

    public String toString() {
        int cap = this.f41860a;
        int s = this.f41863d;
        ArrayList arrayList = new ArrayList(s + 1);
        Object[] h = mo42738a();
        int j = 0;
        int k = 0;
        while (j < s) {
            arrayList.add(h[k]);
            j++;
            k++;
            if (k == cap) {
                k = 0;
                h = (Object[]) h[cap];
            }
        }
        return arrayList.toString();
    }
}
