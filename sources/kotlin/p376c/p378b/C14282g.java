package kotlin.p376c.p378b;

import kotlin.p381e.C14298b;
import kotlin.p381e.C14305h;
import kotlin.p381e.C14305h.C14306a;
import kotlin.p381e.C14310j.C14311a;

/* renamed from: kotlin.c.b.g */
/* compiled from: MutablePropertyReference0 */
public abstract class C14282g extends C14283h implements C14305h {
    public C14282g() {
    }

    public C14282g(Object receiver) {
        super(receiver);
    }

    /* access modifiers changed from: protected */
    public C14298b computeReflected() {
        C14285j.m45920a(this);
        return this;
    }

    public Object invoke() {
        return get();
    }

    public C14311a getGetter() {
        return ((C14305h) getReflected()).getGetter();
    }

    public C14306a getSetter() {
        return ((C14305h) getReflected()).getSetter();
    }

    public Object getDelegate() {
        return ((C14305h) getReflected()).getDelegate();
    }
}
