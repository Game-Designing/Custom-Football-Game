package p026rx.p390c.p395e.p397b;

import p026rx.p390c.p395e.p396a.C14826c;

/* renamed from: rx.c.e.b.b */
/* compiled from: BaseLinkedQueue */
abstract class C14841b<E> extends C14843d<E> {

    /* renamed from: b */
    protected static final long f44133b = C14839G.m46554a(C14841b.class, "consumerNode");
    protected C14826c<E> consumerNode = new C14826c<>();

    C14841b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo46041a(C14826c<E> node) {
        this.consumerNode = node;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final C14826c<E> mo46043c() {
        return (C14826c) C14839G.f44131a.getObjectVolatile(this, f44133b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C14826c<E> mo46042b() {
        return this.consumerNode;
    }
}
