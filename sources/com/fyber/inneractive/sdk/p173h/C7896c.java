package com.fyber.inneractive.sdk.p173h;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveAdViewVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveNativeAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.p161c.C7669g;
import com.fyber.inneractive.sdk.p161c.C7678p;
import com.fyber.inneractive.sdk.p161c.C7679q;
import com.fyber.inneractive.sdk.p163d.C7719c;
import com.fyber.inneractive.sdk.p163d.C7719c.C7720a;
import com.fyber.inneractive.sdk.p165f.C7738g;
import com.fyber.inneractive.sdk.p165f.C7739h.C7740a;
import com.fyber.inneractive.sdk.p165f.C7739h.C7741b;
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
import com.fyber.inneractive.sdk.util.C7993ag;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.h.c */
public final class C7896c extends C7669g<C7678p, InneractiveNativeAdEventsListener> implements C7719c, C7809a {

    /* renamed from: f */
    C7720a f15967f;

    /* renamed from: g */
    C7862g f15968g;

    /* renamed from: h */
    C7795b f15969h;

    /* renamed from: i */
    VideoContentListener f15970i;

    /* renamed from: j */
    InneractiveAdViewUnitController f15971j;

    /* renamed from: k */
    private boolean f15972k = false;

    /* renamed from: a */
    public final boolean mo24234a() {
        return true;
    }

    /* renamed from: a */
    public final void mo24233a(C7720a aVar) {
        boolean z;
        InneractiveAdSpot inneractiveAdSpot = this.f15208a;
        if (inneractiveAdSpot == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("You must set the spot to render before calling renderAd");
            IAlog.m18023d(sb.toString());
            return;
        }
        this.f15967f = aVar;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        if (selectedUnitController != null) {
            if (!(selectedUnitController instanceof InneractiveAdViewUnitController)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) this));
                sb2.append("Wrong type of unit controller found. Expecting InneractiveFullscreenUnitController");
                IAlog.m18023d(sb2.toString());
            } else {
                this.f15971j = (InneractiveAdViewUnitController) selectedUnitController;
                InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
                if (selectedContentController != null) {
                    if (selectedContentController instanceof InneractiveAdViewVideoContentController) {
                        this.f15970i = (VideoContentListener) ((InneractiveAdViewVideoContentController) selectedContentController).getEventsListener();
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
        boolean z2 = true;
        if (((C7678p) adcontent).f15225a != null) {
            this.f15968g = new C7859d(this.f15967f.getLayout().getContext());
            InneractiveUnitController selectedUnitController2 = this.f15208a.getSelectedUnitController();
            if (selectedUnitController2 instanceof C7679q) {
                z = ((C7679q) selectedUnitController2).isOverlayOutside();
            } else {
                z = false;
            }
            AdContent adcontent2 = this.f15209b;
            C7798d dVar = new C7798d(((C7678p) adcontent2).f15225a, (C7859d) this.f15968g, unitConfig, !TextUtils.isEmpty(((C7678p) adcontent2).getClickThroughUrl()), true, z, null);
            this.f15969h = dVar;
        } else if (((C7678p) adcontent).f15226b != null) {
            this.f15968g = new C7858c(this.f15967f.getLayout().getContext(), ((C7678p) this.f15209b).f15226b.mo24745i());
            this.f15969h = new C7806f((C7856b) this.f15968g, ((C7678p) this.f15209b).f15226b, unitConfig);
        }
        C7795b bVar = this.f15969h;
        AdContent adcontent3 = this.f15209b;
        if (((C7678p) adcontent3).f15225a == null || !((C7678p) adcontent3).f15225a.mo24348o()) {
            z2 = false;
        }
        bVar.mo24435a_(z2);
        this.f15969h.mo24434a(this);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f15967f.getLayout().addView((View) this.f15968g, layoutParams);
    }

    /* renamed from: e */
    public final void mo24237e() {
    }

    /* renamed from: d */
    public final void mo24227d() {
    }

    /* renamed from: f */
    public final void mo24554f() {
    }

    /* renamed from: g */
    public final boolean mo24555g() {
        return mo24124a(this.f15968g.getContext(), ((C7678p) this.f15209b).getClickThroughUrl());
    }

    /* renamed from: a */
    public final boolean mo24552a(String str) {
        return mo24124a(this.f15968g.getContext(), str);
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
        return mo24124a(this.f15968g.getContext(), str);
    }

    /* renamed from: h */
    public final void mo24556h() {
        C7720a aVar = this.f15967f;
        if (aVar != null) {
            aVar.onClosedByAd(true);
        }
    }

    /* renamed from: a */
    public final void mo24550a(int i, int i2) {
        VideoContentListener videoContentListener = this.f15970i;
        if (videoContentListener != null) {
            videoContentListener.onProgress(i, i2);
        }
    }

    /* renamed from: i */
    public final void mo24557i() {
        VideoContentListener videoContentListener = this.f15970i;
        if (videoContentListener != null) {
            videoContentListener.onCompleted();
        }
    }

    /* renamed from: j */
    public final void mo24558j() {
        C7720a aVar = this.f15967f;
        if (aVar != null) {
            aVar.onClosedByAd(false);
        }
        VideoContentListener videoContentListener = this.f15970i;
        if (videoContentListener != null) {
            videoContentListener.onPlayerError();
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

    /* renamed from: l */
    public final void mo24560l() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("nShownCloseButton");
        IAlog.m18021b(sb.toString());
    }

    /* renamed from: b */
    public final void mo24235b() {
        this.f15972k = true;
        AdContent adcontent = this.f15209b;
        if (!(adcontent == null || ((C7678p) adcontent).f15225a == null)) {
            C7720a aVar = this.f15967f;
            if (aVar != null && aVar.wasDismissedByUser()) {
                C7916a[] aVarArr = {C7916a.EVENT_COLLAPSE};
                AdContent adcontent2 = this.f15209b;
                if (!(adcontent2 == null || ((C7678p) adcontent2).f15225a == null)) {
                    ((C7678p) adcontent2).f15225a.mo24332a(aVarArr);
                }
            }
        }
        C7795b bVar = this.f15969h;
        if (bVar != null && (bVar instanceof C7993ag)) {
            ((C7993ag) bVar).mo24472f();
        }
        C7795b bVar2 = this.f15969h;
        if (bVar2 != null) {
            bVar2.mo24436b(false);
            this.f15969h.mo24432a();
        }
        if (this.f15971j != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("unbinding native full screen ad renderer");
            IAlog.m18021b(sb.toString());
            this.f15971j.unbindFullscreenRenderer(this);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(IAlog.m18018a((Object) this));
        sb2.append("unit controller is null!");
        IAlog.m18021b(sb2.toString());
    }

    public final void destroy() {
        if (!this.f15972k) {
            mo24235b();
        }
        C7720a aVar = this.f15967f;
        if (aVar != null) {
            aVar.destroy();
            this.f15967f = null;
        }
        C7795b bVar = this.f15969h;
        if (bVar != null) {
            bVar.mo24432a();
            this.f15969h = null;
        }
        C7862g gVar = this.f15968g;
        if (gVar != null) {
            gVar.mo24601a();
            this.f15968g = null;
        }
        this.f15970i = null;
        this.f15209b = null;
        super.destroy();
    }

    /* renamed from: c */
    public final void mo24476c() {
        C7720a aVar = this.f15967f;
        if (aVar != null) {
            aVar.onClosedByAd(true);
        }
    }
}
