package com.fyber.inneractive.sdk.p173h;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.p161c.C7669g;
import com.fyber.inneractive.sdk.p161c.C7673i;
import com.fyber.inneractive.sdk.p161c.C7676n;
import com.fyber.inneractive.sdk.p161c.C7678p;
import com.fyber.inneractive.sdk.p161c.C7679q;
import com.fyber.inneractive.sdk.p163d.C7719c;
import com.fyber.inneractive.sdk.p163d.C7719c.C7720a;
import com.fyber.inneractive.sdk.p165f.C7738g;
import com.fyber.inneractive.sdk.p165f.C7739h.C7740a;
import com.fyber.inneractive.sdk.p165f.C7739h.C7741b;
import com.fyber.inneractive.sdk.p166g.C7746a;
import com.fyber.inneractive.sdk.p166g.C7746a.C7755c;
import com.fyber.inneractive.sdk.p166g.p168b.C7795b;
import com.fyber.inneractive.sdk.p166g.p168b.C7798d;
import com.fyber.inneractive.sdk.p166g.p168b.C7806f;
import com.fyber.inneractive.sdk.p166g.p168b.C7806f.C7809a;
import com.fyber.inneractive.sdk.p166g.p171e.C7856b;
import com.fyber.inneractive.sdk.p166g.p171e.C7858c;
import com.fyber.inneractive.sdk.p166g.p171e.C7859d;
import com.fyber.inneractive.sdk.p166g.p171e.C7862g;
import com.fyber.inneractive.sdk.p174i.C7908j;
import com.fyber.inneractive.sdk.p174i.C7910l;
import com.fyber.inneractive.sdk.p174i.C7912m;
import com.fyber.inneractive.sdk.p174i.C7915o.C7916a;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: com.fyber.inneractive.sdk.h.f */
public final class C7897f extends C7669g<C7678p, InneractiveFullscreenAdEventsListener> implements C7719c, C7809a {

    /* renamed from: f */
    C7720a f15973f;

    /* renamed from: g */
    C7862g f15974g;

    /* renamed from: h */
    C7795b f15975h;

    /* renamed from: i */
    WeakReference<InneractiveFullscreenVideoContentController> f15976i;

    /* renamed from: j */
    private boolean f15977j = false;

    /* renamed from: k */
    private boolean f15978k = false;

    /* renamed from: a */
    public final boolean mo24234a() {
        return this.f15975h.mo24439c();
    }

    /* renamed from: a */
    public final void mo24233a(C7720a aVar) {
        boolean z;
        Skip skip;
        InneractiveAdSpot inneractiveAdSpot = this.f15208a;
        if (inneractiveAdSpot == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("You must set the spot to render before calling renderAd");
            IAlog.m18023d(sb.toString());
            return;
        }
        this.f15973f = aVar;
        this.f15977j = false;
        this.f15978k = false;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        if (selectedUnitController != null) {
            if (!(selectedUnitController instanceof InneractiveFullscreenUnitController)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) this));
                sb2.append("Wrong type of unit controller found. Expecting InneractiveFullscreenUnitController");
                IAlog.m18023d(sb2.toString());
            } else {
                InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
                if (selectedContentController != null) {
                    if (selectedContentController instanceof InneractiveFullscreenVideoContentController) {
                        this.f15976i = new WeakReference<>((InneractiveFullscreenVideoContentController) selectedContentController);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(IAlog.m18018a((Object) this));
                        sb3.append("Content controller expected to be InneractiveFullscreenVideoContentController and is ");
                        sb3.append(selectedContentController.getClass().getSimpleName());
                        IAlog.m18023d(sb3.toString());
                    }
                }
            }
        }
        C7712j unitConfig = this.f15208a.getAdContent().getUnitConfig();
        AdContent adcontent = this.f15209b;
        if (((C7678p) adcontent).f15225a != null) {
            this.f15974g = new C7859d(this.f15973f.getLayout().getContext());
            InneractiveUnitController selectedUnitController2 = this.f15208a.getSelectedUnitController();
            if (selectedUnitController2 instanceof C7679q) {
                z = ((C7679q) selectedUnitController2).isOverlayOutside();
            } else {
                z = false;
            }
            InneractiveAdSpot inneractiveAdSpot2 = this.f15208a;
            if (inneractiveAdSpot2 instanceof C7676n) {
                skip = ((C7676n) inneractiveAdSpot2).mo24153a();
            } else {
                skip = null;
            }
            AdContent adcontent2 = this.f15209b;
            C7798d dVar = new C7798d(((C7678p) adcontent2).f15225a, (C7859d) this.f15974g, unitConfig, !TextUtils.isEmpty(((C7678p) adcontent2).getClickThroughUrl()), false, z, skip);
            this.f15975h = dVar;
            this.f15975h.mo24435a_(((C7678p) this.f15209b).f15225a.mo24348o());
            this.f15974g.mo24604c();
            this.f15975h.mo24434a(this);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.f15973f.getLayout().addView((View) this.f15974g, layoutParams);
            ((C7678p) this.f15209b).f15225a.mo24328a((C7755c) new C7755c() {
                /* renamed from: a */
                public final void mo24356a() {
                    C7897f.this.f15975h.mo24435a_(false);
                    C7897f.this.f15975h.mo24440d();
                }

                /* renamed from: a */
                public final void mo24357a(Bitmap bitmap) {
                    if (bitmap != null) {
                        C7897f.this.f15975h.mo24433a(bitmap);
                    }
                }

                /* renamed from: a */
                public final void mo24358a(C7746a aVar) {
                    C7795b bVar = C7897f.this.f15975h;
                    if (bVar != null) {
                        bVar.mo24432a();
                    }
                    if (C7897f.this.f15209b != null) {
                        ((C7678p) C7897f.this.f15209b).destroy();
                    }
                    aVar.mo24334b();
                    C7897f.this.mo24558j();
                }
            });
        } else if (((C7678p) adcontent).f15226b != null) {
            this.f15974g = new C7858c(this.f15973f.getLayout().getContext(), ((C7678p) this.f15209b).f15226b.mo24745i());
            this.f15975h = new C7806f((C7856b) this.f15974g, ((C7678p) this.f15209b).f15226b, unitConfig);
            this.f15975h.mo24435a_(false);
            this.f15975h.mo24434a(this);
            LayoutParams layoutParams2 = new LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            this.f15973f.getLayout().addView((View) this.f15974g, layoutParams2);
        }
        this.f15977j = true;
    }

    /* renamed from: e */
    public final void mo24237e() {
    }

    /* renamed from: d */
    public final void mo24227d() {
    }

    /* renamed from: f */
    public final void mo24554f() {
        mo24127i_();
        this.f15973f.showCloseButton(false);
    }

    /* renamed from: g */
    public final boolean mo24555g() {
        return mo24124a(this.f15974g.getContext(), ((C7678p) this.f15209b).getClickThroughUrl());
    }

    /* renamed from: a */
    public final boolean mo24552a(String str) {
        return mo24124a(this.f15974g.getContext(), str);
    }

    /* renamed from: l */
    public final void mo24560l() {
        this.f15973f.showCloseButton(false);
    }

    /* renamed from: b */
    public final boolean mo24553b(String str) {
        try {
            C7740a aVar = new C7740a(C7738g.VAST_EVENT_COMPANION_CLICKED, ((C7678p) this.f15209b).getAdRequest(), ((C7678p) this.f15209b).getResponseData());
            C7912m mVar = ((C7908j) ((C7678p) this.f15209b).getResponseData()).f16049s;
            if (mVar != null) {
                C7910l lVar = mVar.f16071h;
                if (lVar != null) {
                    aVar.mo24311a(new C7741b().mo24315a("mime", TextUtils.isEmpty(lVar.f16055d) ? "na" : lVar.f16055d));
                }
            }
            aVar.mo24314a();
        } catch (Exception e) {
        }
        return mo24124a(this.f15974g.getContext(), str);
    }

    /* renamed from: h */
    public final void mo24556h() {
        C7720a aVar = this.f15973f;
        if (aVar != null) {
            aVar.onClosedByAd(true);
        }
    }

    /* renamed from: a */
    public final void mo24550a(int i, int i2) {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) C8017o.m18094a((Reference<T>) this.f15976i);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onProgress(i, i2);
        }
    }

    /* renamed from: i */
    public final void mo24557i() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) C8017o.m18094a((Reference<T>) this.f15976i);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onCompleted();
        }
        if (((C7678p) this.f15209b).f15225a != null) {
            this.f15973f.showCloseButton(true);
        }
    }

    /* renamed from: j */
    public final void mo24558j() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) C8017o.m18094a((Reference<T>) this.f15976i);
        C7720a aVar = this.f15973f;
        if (aVar != null) {
            aVar.onClosedByAd(false);
        }
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onPlayerError();
        }
    }

    /* renamed from: a */
    public final void mo24551a(View view, String str) {
        if (view != null && view.getContext() != null) {
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
            mo24129j_();
        }
    }

    /* renamed from: k */
    public final void mo24559k() {
        mo24129j_();
    }

    /* renamed from: b */
    public final void mo24235b() {
        m17795m();
        InneractiveAdSpot inneractiveAdSpot = this.f15208a;
        if (inneractiveAdSpot != null && (inneractiveAdSpot instanceof C7673i)) {
            ((C7673i) inneractiveAdSpot).mo24131a();
        }
    }

    /* renamed from: m */
    private void m17795m() {
        if (!this.f15978k) {
            EventsListener eventslistener = this.f15210c;
            if (eventslistener != null) {
                this.f15978k = true;
                ((InneractiveFullscreenAdEventsListener) eventslistener).onAdDismissed(this.f15208a);
                C7720a aVar = this.f15973f;
                if (aVar != null && aVar.wasDismissedByUser()) {
                    m17793a(C7916a.EVENT_CLOSE);
                    m17793a(C7916a.EVENT_CLOSE_LINEAR);
                }
            }
        }
    }

    public final void destroy() {
        C7720a aVar = this.f15973f;
        if (aVar != null) {
            aVar.destroy();
        }
        if (this.f15977j) {
            m17795m();
        }
        C7795b bVar = this.f15975h;
        if (bVar != null) {
            bVar.mo24432a();
            this.f15975h = null;
        }
        C7862g gVar = this.f15974g;
        if (gVar != null) {
            gVar.mo24601a();
            this.f15974g = null;
        }
        this.f15973f = null;
        this.f15976i = null;
        super.destroy();
    }

    /* renamed from: a */
    private void m17793a(C7916a... aVarArr) {
        AdContent adcontent = this.f15209b;
        if (adcontent != null && ((C7678p) adcontent).f15225a != null) {
            ((C7678p) adcontent).f15225a.mo24332a(aVarArr);
        }
    }

    /* renamed from: c */
    public final void mo24476c() {
    }
}
