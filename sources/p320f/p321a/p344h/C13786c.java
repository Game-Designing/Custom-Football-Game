package p320f.p321a.p344h;

import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.h.c */
/* compiled from: Timed */
public final class C13786c<T> {

    /* renamed from: a */
    final T f41932a;

    /* renamed from: b */
    final long f41933b;

    /* renamed from: c */
    final TimeUnit f41934c;

    public C13786c(T value, long time, TimeUnit unit) {
        this.f41932a = value;
        this.f41933b = time;
        C13264b.m43226a(unit, "unit is null");
        this.f41934c = unit;
    }

    /* renamed from: b */
    public T mo42797b() {
        return this.f41932a;
    }

    /* renamed from: a */
    public long mo42796a() {
        return this.f41933b;
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof C13786c)) {
            return false;
        }
        Timed<?> o = (C13786c) other;
        if (C13264b.m43227a((Object) this.f41932a, (Object) o.f41932a) && this.f41933b == o.f41933b && C13264b.m43227a((Object) this.f41934c, (Object) o.f41934c)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        T t = this.f41932a;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        long j = this.f41933b;
        return ((hashCode + ((int) (j ^ (j >>> 31)))) * 31) + this.f41934c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Timed[time=");
        sb.append(this.f41933b);
        sb.append(", unit=");
        sb.append(this.f41934c);
        sb.append(", value=");
        sb.append(this.f41932a);
        sb.append("]");
        return sb.toString();
    }
}
