package com.flurry.sdk;

/* renamed from: com.flurry.sdk.lc */
public final class C7554lc<RequestObjectType, ResponseObjectType> extends C7577pc {

    /* renamed from: C */
    public C7555a<RequestObjectType, ResponseObjectType> f14934C;

    /* renamed from: D */
    public RequestObjectType f14935D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public ResponseObjectType f14936E;

    /* renamed from: F */
    public C7493ad<RequestObjectType> f14937F;

    /* renamed from: G */
    public C7493ad<ResponseObjectType> f14938G;

    /* renamed from: com.flurry.sdk.lc$a */
    public interface C7555a<RequestObjectType, ResponseObjectType> {
        /* renamed from: a */
        void mo23837a(C7554lc<RequestObjectType, ResponseObjectType> lcVar, ResponseObjectType responseobjecttype);
    }

    /* renamed from: d */
    static /* synthetic */ void m16735d(C7554lc lcVar) {
        if (lcVar.f14934C != null && !lcVar.mo23994h()) {
            lcVar.f14934C.mo23837a(lcVar, lcVar.f14936E);
        }
    }

    /* renamed from: a */
    public final void mo23803a() {
        this.f15009p = new C7549kc(this);
        super.mo23803a();
    }
}
