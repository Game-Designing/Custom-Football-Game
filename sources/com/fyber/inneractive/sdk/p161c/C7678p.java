package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.p166g.C7746a;
import com.fyber.inneractive.sdk.p166g.p172f.C7870b;
import com.fyber.inneractive.sdk.p174i.C7908j;
import com.fyber.inneractive.sdk.p174i.C7910l;
import com.mopub.mobileads.VastResourceXmlManager;

/* renamed from: com.fyber.inneractive.sdk.c.p */
public final class C7678p extends C7668f<C7908j> {

    /* renamed from: a */
    public C7746a f15225a;

    /* renamed from: b */
    public C7870b f15226b;

    /* renamed from: c */
    public boolean f15227c = false;

    public C7678p(C7712j jVar, C7746a aVar) {
        super(jVar);
        this.f15225a = aVar;
    }

    public C7678p(C7712j jVar, C7870b bVar) {
        super(jVar);
        this.f15226b = bVar;
    }

    public final void destroy() {
        C7746a aVar = this.f15225a;
        if (aVar != null) {
            aVar.mo24334b();
            this.f15225a = null;
        }
        C7870b bVar = this.f15226b;
        if (bVar != null) {
            bVar.mo24652b();
            this.f15226b = null;
        }
    }

    public final String getClickThroughUrl() {
        T t = this.mResponseData;
        if (t != null) {
            return ((C7908j) t).mo24719a();
        }
        return null;
    }

    /* renamed from: a */
    public final String mo24166a() {
        T t = this.mResponseData;
        String str = null;
        if (t == null) {
            return null;
        }
        C7910l lVar = ((C7908j) t).f16049s.f16071h;
        if (!lVar.f16054c.equals(VastResourceXmlManager.STATIC_RESOURCE)) {
            return null;
        }
        if (lVar != null) {
            str = lVar.f16057f;
        }
        return str == null ? getClickThroughUrl() : str;
    }

    public final boolean isVideoAd() {
        return true;
    }

    public final boolean isFullscreenAd() {
        if (this.mUnitConfig.mo24210f() == null) {
            return false;
        }
        return this.mUnitConfig.mo24210f().mo24222i();
    }
}
