package p026rx.p390c.p395e.p397b;

import p026rx.p390c.p395e.p396a.C14826c;

/* renamed from: rx.c.e.b.e */
/* compiled from: BaseLinkedQueue */
abstract class C14844e<E> extends C14842c<E> {

    /* renamed from: a */
    protected static final long f44134a = C14839G.m46554a(C14844e.class, "producerNode");
    protected C14826c<E> producerNode;

    C14844e() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C14826c<E> mo46044a() {
        return (C14826c) C14839G.f44131a.getObjectVolatile(this, f44134a);
    }
}
