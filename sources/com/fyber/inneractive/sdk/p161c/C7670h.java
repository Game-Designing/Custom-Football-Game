package com.fyber.inneractive.sdk.p161c;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.p161c.C7662b.C7663a;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* renamed from: com.fyber.inneractive.sdk.c.h */
public final class C7670h implements C7673i, C7675m {

    /* renamed from: a */
    RequestListener f15213a;

    /* renamed from: b */
    InneractiveAdRequest f15214b;

    /* renamed from: c */
    C7663a f15215c;

    /* renamed from: d */
    C7668f f15216d;

    /* renamed from: e */
    C7677o f15217e;

    /* renamed from: f */
    Set<C7677o> f15218f = new HashSet();

    /* renamed from: g */
    public C7662b f15219g;

    /* renamed from: h */
    InneractiveMediationName f15220h;

    /* renamed from: i */
    C7672a f15221i;

    /* renamed from: j */
    private String f15222j = UUID.randomUUID().toString();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f15223k = true;

    /* renamed from: com.fyber.inneractive.sdk.c.h$a */
    public interface C7672a {
        void onAdRefreshFailed(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode);

        void onAdRefreshed(InneractiveAdSpot inneractiveAdSpot);
    }

    public final void setRequestListener(RequestListener requestListener) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("setRequestListener called with: ");
        sb.append(requestListener);
        IAlog.m18021b(sb.toString());
        this.f15213a = requestListener;
    }

    public final void requestAd(InneractiveAdRequest inneractiveAdRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("requestAd called with request: ");
        sb.append(inneractiveAdRequest);
        IAlog.m18021b(sb.toString());
        if (inneractiveAdRequest == null && this.f15214b == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("requestAd called with a null request, but no previous request is available! Cannot continue");
            IAlog.m18024e(sb2.toString());
        } else if (this.f15218f.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(IAlog.m18018a((Object) this));
            sb3.append("requestAd called but no AdUnitControllers exist! Cannot continue");
            IAlog.m18024e(sb3.toString());
            RequestListener requestListener = this.f15213a;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
            }
        } else {
            C7662b bVar = this.f15219g;
            if (bVar != null) {
                bVar.mo24098a();
                this.f15219g.mo24102b();
            }
            if (inneractiveAdRequest != null) {
                InneractiveAdRequest inneractiveAdRequest2 = this.f15214b;
                if (inneractiveAdRequest2 != null) {
                    inneractiveAdRequest.setSelectedUnitConfig(inneractiveAdRequest2.getSelectedUnitConfig());
                }
                this.f15214b = inneractiveAdRequest;
                C7668f fVar = this.f15216d;
                if (fVar != null) {
                    fVar.destroy();
                    this.f15223k = true;
                }
                if (!m16939c()) {
                    this.f15214b.f15229f = false;
                }
            }
            this.f15219g = new C7662b();
            InneractiveMediationName inneractiveMediationName = this.f15220h;
            if (inneractiveMediationName != null) {
                this.f15214b.f15228e = inneractiveMediationName;
            }
            if (this.f15215c == null) {
                this.f15215c = new C7663a() {
                    /* renamed from: a */
                    public final void mo24106a(InneractiveAdRequest inneractiveAdRequest, C7668f fVar) {
                        if (!C7670h.this.f15223k) {
                            C7677o oVar = C7670h.this.f15217e;
                            if (oVar != null && oVar.supportsRefresh()) {
                                if (C7670h.this.f15217e.canRefreshAd()) {
                                    C7670h hVar = C7670h.this;
                                    hVar.f15216d = fVar;
                                    hVar.f15216d.setAdRequest(inneractiveAdRequest);
                                    C7670h hVar2 = C7670h.this;
                                    C7672a aVar = hVar2.f15221i;
                                    if (aVar != null) {
                                        aVar.onAdRefreshed(hVar2);
                                        return;
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(IAlog.m18018a((Object) C7670h.this));
                                sb.append("ad loaded successfully, but the selected unit controller has rejected the refresh!");
                                IAlog.m18021b(sb.toString());
                                C7670h hVar3 = C7670h.this;
                                hVar3.f15221i.onAdRefreshFailed(hVar3, InneractiveErrorCode.CANCELLED);
                                return;
                            }
                        }
                        C7670h.this.f15223k = false;
                        C7670h hVar4 = C7670h.this;
                        hVar4.f15216d = fVar;
                        hVar4.f15216d.setAdRequest(inneractiveAdRequest);
                        if (!C7670h.this.m16938b()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(IAlog.m18018a((Object) C7670h.this));
                            sb2.append("Cannot find appropriate unit controller for unit: ");
                            sb2.append(C7670h.this.f15216d.getUnitConfig());
                            IAlog.m18021b(sb2.toString());
                            mo24107a(InneractiveErrorCode.SERVER_INVALID_RESPONSE);
                            C7670h.this.f15216d = null;
                            return;
                        }
                        C7670h hVar5 = C7670h.this;
                        RequestListener requestListener = hVar5.f15213a;
                        if (requestListener != null) {
                            requestListener.onInneractiveSuccessfulAdRequest(hVar5);
                        }
                    }

                    /* renamed from: a */
                    public final void mo24107a(InneractiveErrorCode inneractiveErrorCode) {
                        C7670h hVar = C7670h.this;
                        if (hVar.f15213a != null) {
                            if (hVar.f15223k) {
                                C7670h hVar2 = C7670h.this;
                                hVar2.f15213a.onInneractiveFailedAdRequest(hVar2, inneractiveErrorCode);
                                return;
                            }
                            C7670h hVar3 = C7670h.this;
                            C7672a aVar = hVar3.f15221i;
                            if (aVar != null) {
                                aVar.onAdRefreshFailed(hVar3, inneractiveErrorCode);
                            }
                        }
                    }
                };
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(IAlog.m18018a((Object) this));
            sb4.append("Found ad source for request! ");
            sb4.append(this.f15219g);
            IAlog.m18021b(sb4.toString());
            this.f15219g.mo24099a(this.f15214b, this.f15215c);
        }
    }

    /* renamed from: a */
    public final void mo24132a(C7672a aVar) {
        this.f15221i = aVar;
        requestAd(null);
    }

    public final InneractiveMediationName getMediationName() {
        return this.f15220h;
    }

    public final void addUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            C7677o oVar = (C7677o) inneractiveUnitController;
            oVar.setAdSpot(this);
            if (this.f15218f.size() > 0) {
                for (InneractiveUnitController inneractiveUnitController2 : new HashSet(this.f15218f)) {
                    if (inneractiveUnitController2.getClass().equals(inneractiveUnitController.getClass())) {
                        removeUnitController(inneractiveUnitController2);
                    }
                }
            }
            this.f15218f.add(oVar);
            if (isReady()) {
                m16938b();
            }
        }
    }

    public final void removeUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            C7677o oVar = this.f15217e;
            if (oVar != null && oVar.equals(inneractiveUnitController)) {
                this.f15217e.destroy();
                this.f15217e = null;
            }
            this.f15218f.remove(inneractiveUnitController);
        }
    }

    public final InneractiveUnitController getSelectedUnitController() {
        return this.f15217e;
    }

    public final String getLocalUniqueId() {
        return this.f15222j;
    }

    public final boolean isReady() {
        return this.f15216d != null;
    }

    public final C7668f getAdContent() {
        return this.f15216d;
    }

    public final void setMediationName(InneractiveMediationName inneractiveMediationName) {
        if (inneractiveMediationName != null) {
            this.f15220h = inneractiveMediationName;
        }
    }

    /* renamed from: a */
    public final void mo24131a() {
        C7668f fVar = this.f15216d;
        if (fVar != null) {
            fVar.destroy();
            this.f15216d = null;
        }
        this.f15217e = null;
    }

    public final void destroy() {
        for (InneractiveUnitController destroy : this.f15218f) {
            destroy.destroy();
        }
        this.f15218f.clear();
        C7662b bVar = this.f15219g;
        if (bVar != null) {
            bVar.mo24102b();
            this.f15219g = null;
        }
        this.f15213a = null;
        this.f15220h = null;
        mo24131a();
        InneractiveAdSpotManager.get().removeSpot(this);
    }

    public final InneractiveAdRequest getCurrentProcessedRequest() {
        return this.f15214b;
    }

    public C7670h() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("InneractiveAdSpotImpl created with UID: ");
        sb.append(this.f15222j);
        IAlog.m18021b(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m16938b() {
        for (C7677o oVar : this.f15218f) {
            if (oVar.supports(this)) {
                this.f15217e = oVar;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m16939c() {
        for (C7677o oVar : this.f15218f) {
            if (oVar instanceof InneractiveFullscreenUnitController) {
                return true;
            }
        }
        return false;
    }
}
