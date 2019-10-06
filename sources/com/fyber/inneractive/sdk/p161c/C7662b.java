package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.config.C7710h;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.p160b.C7652b.C7654b;
import com.fyber.inneractive.sdk.p163d.C7716a;
import com.fyber.inneractive.sdk.p163d.C7716a.C7717a;
import com.fyber.inneractive.sdk.p165f.C7732d;
import com.fyber.inneractive.sdk.p165f.C7732d.C7733a;
import com.fyber.inneractive.sdk.p174i.C7903b;
import com.fyber.inneractive.sdk.p174i.C7907g;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.c.b */
public final class C7662b implements OnConfigurationReadyAndValidListener, C7717a, C7733a {

    /* renamed from: a */
    protected C7663a f15195a;

    /* renamed from: b */
    protected InneractiveAdRequest f15196b;

    /* renamed from: c */
    public C7732d f15197c;

    /* renamed from: d */
    C7716a f15198d;

    /* renamed from: com.fyber.inneractive.sdk.c.b$a */
    public interface C7663a {
        /* renamed from: a */
        void mo24106a(InneractiveAdRequest inneractiveAdRequest, C7668f fVar);

        /* renamed from: a */
        void mo24107a(InneractiveErrorCode inneractiveErrorCode);
    }

    /* renamed from: a */
    public final void mo24099a(InneractiveAdRequest inneractiveAdRequest, C7663a aVar) {
        this.f15196b = inneractiveAdRequest;
        this.f15195a = aVar;
        if (IAConfigManager.m17000n()) {
            m16912d();
            return;
        }
        IAConfigManager.addListener(this);
        IAConfigManager.m16993f();
    }

    /* renamed from: a */
    public final void mo24098a() {
        IAConfigManager.removeListener(this);
        C7732d dVar = this.f15197c;
        if (dVar != null) {
            dVar.mo24305b();
            this.f15197c = null;
        }
        C7716a aVar = this.f15198d;
        if (aVar != null) {
            aVar.mo24093a();
            this.f15198d = null;
        }
        this.f15196b = null;
    }

    /* renamed from: b */
    public final void mo24102b() {
        mo24098a();
        this.f15195a = null;
    }

    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (z) {
            m16912d();
        } else {
            mo24100a(InneractiveErrorCode.SDK_INTERNAL_ERROR);
        }
    }

    /* renamed from: a */
    public final void mo24101a(C7907g gVar) {
        C7716a aVar;
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("onAdDataAvailable: got response data: ");
        sb.append(gVar);
        IAlog.m18019a(sb.toString());
        C7903b a = C7903b.m17817a(gVar.f16038g);
        C7654b bVar = (C7654b) C7653a.f15185a.f15184a.get(a);
        if (bVar != null) {
            aVar = bVar.mo24085b();
        } else {
            aVar = null;
        }
        this.f15198d = aVar;
        if (this.f15198d == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("onAdDataAvailable: Cannot find content handler for ad type: ");
            sb2.append(a);
            IAlog.m18023d(sb2.toString());
            C7663a aVar2 = this.f15195a;
            if (aVar2 != null) {
                aVar2.mo24107a(InneractiveErrorCode.SDK_INTERNAL_ERROR);
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(IAlog.m18018a((Object) this));
        sb3.append("onAdDataAvailable: found response loader: ");
        sb3.append(this.f15198d);
        IAlog.m18019a(sb3.toString());
        this.f15198d.mo24094a(this.f15196b, gVar, this);
    }

    /* renamed from: a */
    public final void mo24100a(InneractiveErrorCode inneractiveErrorCode) {
        if (IAlog.f16291a <= 3) {
            Thread.dumpStack();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("got onAdRequestFailed! with: ");
        sb.append(inneractiveErrorCode);
        IAlog.m18019a(sb.toString());
        C7663a aVar = this.f15195a;
        if (aVar != null) {
            aVar.mo24107a(inneractiveErrorCode);
        }
    }

    /* renamed from: c */
    public final void mo24104c() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("got onAdLoaded!");
        IAlog.m18019a(sb.toString());
        C7716a aVar = this.f15198d;
        if (aVar != null) {
            this.f15195a.mo24106a(this.f15196b, aVar.mo24096c());
            this.f15198d = null;
        }
    }

    /* renamed from: b */
    public final void mo24103b(InneractiveErrorCode inneractiveErrorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("got onFailedLoading! with: ");
        sb.append(inneractiveErrorCode);
        IAlog.m18019a(sb.toString());
        this.f15195a.mo24107a(inneractiveErrorCode);
    }

    /* renamed from: d */
    private void m16912d() {
        C7710h b = IAConfigManager.m16978b(this.f15196b.getSpotId());
        if (b != null && !b.f15360c) {
            this.f15195a.mo24107a(InneractiveErrorCode.SPOT_DISABLED);
        } else if (b == null || !b.iterator().hasNext()) {
            if (b == null) {
                IAConfigManager.m16993f();
            }
            String str = "************************************************************************************************************************";
            IAlog.m18023d(str);
            StringBuilder sb = new StringBuilder("*** Requested spot id '");
            sb.append(this.f15196b.getSpotId());
            sb.append("' doesn't exist within this application config - application Id: '");
            sb.append(IAConfigManager.m16994h());
            sb.append("'");
            IAlog.m18023d(sb.toString());
            IAlog.m18023d("*** Are you sure that you are using the correct application and spot ids, as defined for this application in the Inneractive console?");
            IAlog.m18023d(str);
            this.f15195a.mo24107a(InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH);
        } else {
            this.f15197c = new C7732d(this.f15196b, this);
            this.f15197c.mo24304a();
        }
    }
}
