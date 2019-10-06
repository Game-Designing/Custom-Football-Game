package p320f.p321a.p327d.p340j;

import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13214p;

/* renamed from: f.a.d.j.a */
/* compiled from: AppendOnlyLinkedArrayList */
public class C13738a<T> {

    /* renamed from: a */
    final int f41844a;

    /* renamed from: b */
    final Object[] f41845b;

    /* renamed from: c */
    Object[] f41846c = this.f41845b;

    /* renamed from: d */
    int f41847d;

    /* renamed from: f.a.d.j.a$a */
    /* compiled from: AppendOnlyLinkedArrayList */
    public interface C13739a<T> extends C13214p<T> {
        boolean test(T t);
    }

    public C13738a(int capacity) {
        this.f41844a = capacity;
        this.f41845b = new Object[(capacity + 1)];
    }

    /* renamed from: a */
    public void mo42728a(T value) {
        int c = this.f41844a;
        int o = this.f41847d;
        if (o == c) {
            Object[] next = new Object[(c + 1)];
            this.f41846c[c] = next;
            this.f41846c = next;
            o = 0;
        }
        this.f41846c[o] = value;
        this.f41847d = o + 1;
    }

    /* renamed from: b */
    public void mo42730b(T value) {
        this.f41845b[0] = value;
    }

    /* renamed from: a */
    public void mo42727a(C13739a<? super T> consumer) {
        int c = this.f41844a;
        for (Object[] a = this.f41845b; a != null; a = a[c]) {
            for (int i = 0; i < c; i++) {
                Object[] objArr = a[i];
                if (objArr == null || consumer.test(objArr)) {
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    public <U> boolean mo42729a(C13804t<? super U> observer) {
        int c = this.f41844a;
        for (Object[] a = this.f41845b; a != null; a = a[c]) {
            int i = 0;
            while (i < c) {
                Object[] objArr = a[i];
                if (objArr == null) {
                    continue;
                    break;
                } else if (C13753n.m43779b(objArr, observer)) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
