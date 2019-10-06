package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.p161c.C7668f;
import com.fyber.inneractive.sdk.p163d.C7716a;
import com.fyber.inneractive.sdk.p163d.C7716a.C7717a;
import com.fyber.inneractive.sdk.p174i.C7907g;

/* renamed from: com.fyber.inneractive.sdk.c.a */
public abstract class C7661a<Response extends C7907g, Content extends C7668f> implements C7716a {

    /* renamed from: a */
    protected InneractiveAdRequest f15190a;

    /* renamed from: b */
    protected Response f15191b;

    /* renamed from: c */
    protected Content f15192c;

    /* renamed from: d */
    protected C7717a f15193d;

    /* renamed from: e */
    protected C7712j f15194e;

    /* renamed from: b */
    public abstract void mo24095b();

    /* renamed from: a */
    public void mo24093a() {
        this.f15190a = null;
        this.f15191b = null;
        this.f15192c = null;
        this.f15193d = null;
        this.f15194e = null;
    }

    /* renamed from: a */
    public final void mo24094a(InneractiveAdRequest inneractiveAdRequest, C7907g gVar, C7717a aVar) {
        this.f15190a = inneractiveAdRequest;
        this.f15191b = gVar;
        this.f15193d = aVar;
        if (this.f15190a == null) {
            this.f15194e = IAConfigManager.m16965a(gVar.f16044m);
        }
        mo24095b();
    }

    /* renamed from: c */
    public final Content mo24096c() {
        return this.f15192c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final C7712j mo24097d() {
        InneractiveAdRequest inneractiveAdRequest = this.f15190a;
        return inneractiveAdRequest == null ? this.f15194e : inneractiveAdRequest.getSelectedUnitConfig();
    }
}
