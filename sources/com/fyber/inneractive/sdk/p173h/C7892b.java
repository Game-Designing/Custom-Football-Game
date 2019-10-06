package com.fyber.inneractive.sdk.p173h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveAdViewVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController.Renderer;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.p161c.C7668f;
import com.fyber.inneractive.sdk.p161c.C7669g;
import com.fyber.inneractive.sdk.p161c.C7678p;
import com.fyber.inneractive.sdk.p163d.C7718b;
import com.fyber.inneractive.sdk.p165f.C7738g;
import com.fyber.inneractive.sdk.p165f.C7739h.C7740a;
import com.fyber.inneractive.sdk.p165f.C7739h.C7741b;
import com.fyber.inneractive.sdk.p166g.C7746a;
import com.fyber.inneractive.sdk.p166g.C7746a.C7755c;
import com.fyber.inneractive.sdk.p166g.p168b.C7812h;
import com.fyber.inneractive.sdk.p166g.p168b.C7822j;
import com.fyber.inneractive.sdk.p166g.p168b.C7822j.C7823a;
import com.fyber.inneractive.sdk.p166g.p168b.C7824k;
import com.fyber.inneractive.sdk.p166g.p171e.C7860e;
import com.fyber.inneractive.sdk.p166g.p171e.C7861f;
import com.fyber.inneractive.sdk.p166g.p171e.C7862g;
import com.fyber.inneractive.sdk.p174i.C7908j;
import com.fyber.inneractive.sdk.p174i.C7910l;
import com.fyber.inneractive.sdk.p174i.C7912m;
import com.fyber.inneractive.sdk.util.C8034w;
import com.fyber.inneractive.sdk.util.C8034w.C8039b;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.h.b */
public final class C7892b extends C7669g<C7678p, InneractiveAdViewEventsListener> implements C7718b, Renderer, C8039b {

    /* renamed from: f */
    FrameLayout f15954f;

    /* renamed from: g */
    C7862g f15955g;

    /* renamed from: h */
    C7822j f15956h;

    /* renamed from: i */
    VideoContentListener f15957i;

    /* renamed from: j */
    C7823a f15958j;

    /* renamed from: k */
    ViewGroup f15959k;

    /* renamed from: l */
    Runnable f15960l;

    /* renamed from: m */
    private float f15961m = 0.0f;

    /* renamed from: n */
    private Rect f15962n = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f15963o = false;

    /* renamed from: a */
    public final boolean mo24225a(C7668f fVar) {
        return fVar instanceof C7678p;
    }

    @TargetApi(11)
    /* renamed from: a */
    public final void mo24223a(ViewGroup viewGroup) {
        boolean z;
        InneractiveAdSpot inneractiveAdSpot = this.f15208a;
        if (inneractiveAdSpot == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("You must set the spot to render before calling renderAd");
            IAlog.m18023d(sb.toString());
            return;
        }
        this.f15959k = viewGroup;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        if (!(selectedUnitController instanceof InneractiveAdViewUnitController)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("Wrong type of unit controller found. Expecting InneractiveAdViewUnitController");
            IAlog.m18023d(sb2.toString());
        } else {
            InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
            if (selectedContentController != null) {
                if (selectedContentController instanceof InneractiveAdViewVideoContentController) {
                    this.f15957i = (VideoContentListener) ((InneractiveAdViewVideoContentController) selectedContentController).getEventsListener();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(IAlog.m18018a((Object) this));
                    sb3.append("Content controller expected to be InneractiveFullscreenVideoContentController and is ");
                    sb3.append(selectedContentController.getClass().getSimpleName());
                    IAlog.m18023d(sb3.toString());
                }
            }
        }
        this.f15954f = new FrameLayout(viewGroup.getContext());
        AdContent adcontent = this.f15209b;
        if (((C7678p) adcontent).f15225a != null) {
            this.f15955g = new C7861f(viewGroup.getContext());
            InneractiveUnitController selectedUnitController2 = this.f15208a.getSelectedUnitController();
            if (selectedUnitController2 instanceof InneractiveNativeVideoContentController) {
                z = ((InneractiveNativeVideoContentController) selectedUnitController2).isOverlayOutside();
            } else {
                z = false;
            }
            C7812h hVar = new C7812h(((C7678p) this.f15209b).f15225a, (C7861f) this.f15955g, IAConfigManager.m16965a(this.f15208a.getAdContent().getResponseData().f16044m), !TextUtils.isEmpty(((C7678p) this.f15209b).getClickThroughUrl()), z);
            this.f15956h = hVar;
            this.f15959k.addView(this.f15954f, new LayoutParams(-1, -2));
            this.f15954f.addView((View) this.f15955g, new FrameLayout.LayoutParams(-2, -2, 17));
            m17739h();
            this.f15956h.mo24434a(this.f15958j);
            this.f15956h.mo24435a_(((C7678p) this.f15209b).f15225a.mo24348o());
            ((C7678p) this.f15209b).f15225a.mo24328a((C7755c) new C7755c() {
                /* renamed from: a */
                public final void mo24356a() {
                    C7822j jVar = C7892b.this.f15956h;
                    if (jVar != null) {
                        jVar.mo24435a_(false);
                        C7892b.this.f15956h.mo24440d();
                    }
                }

                /* renamed from: a */
                public final void mo24357a(Bitmap bitmap) {
                    if (bitmap != null) {
                        C7822j jVar = C7892b.this.f15956h;
                        if (jVar != null) {
                            jVar.mo24433a(bitmap);
                        }
                    }
                }

                /* renamed from: a */
                public final void mo24358a(C7746a aVar) {
                    C7892b bVar = C7892b.this;
                    if (bVar.f15957i != null) {
                        C7862g gVar = bVar.f15955g;
                        if (gVar != null && gVar.mo24603b()) {
                            C7892b.this.f15957i.onPlayerError();
                        }
                    }
                }
            });
            Bitmap bitmap = ((C7678p) this.f15209b).f15225a.f15514e;
            if (bitmap != null) {
                this.f15956h.mo24433a(bitmap);
            }
            ((C7678p) this.f15209b).f15225a.mo24322a();
        } else if (((C7678p) adcontent).f15226b != null) {
            this.f15955g = new C7860e(viewGroup.getContext(), ((C7678p) this.f15209b).f15226b.mo24745i());
            C7860e eVar = (C7860e) this.f15955g;
            AdContent adcontent2 = this.f15209b;
            this.f15956h = new C7824k(eVar, ((C7678p) adcontent2).f15226b, ((C7678p) adcontent2).getUnitConfig());
            this.f15959k.setLayoutTransition(null);
            this.f15959k.addView(this.f15954f, new LayoutParams(-1, -2));
            this.f15954f.addView((View) this.f15955g, new FrameLayout.LayoutParams(-2, -2, 17));
            m17739h();
            this.f15956h.mo24434a(this.f15958j);
            this.f15956h.mo24435a_(false);
        }
        C8034w.m18120a().mo24870a((View) this.f15959k, (C8039b) this);
    }

    public final void destroy() {
        mo24232h_();
        super.destroy();
    }

    /* renamed from: f_ */
    public final void mo24230f_() {
    }

    public final void playVideo() {
        C7822j jVar = this.f15956h;
        if (jVar != null) {
            jVar.mo24437b(0);
        }
    }

    public final void pauseVideo() {
        C7822j jVar = this.f15956h;
        if (jVar != null) {
            jVar.mo24438b_();
        }
    }

    /* renamed from: a */
    public final void mo24708a(float f, Rect rect) {
        if (this.f15961m != f || !this.f15962n.equals(rect)) {
            this.f15961m = f;
            this.f15962n.set(rect);
            this.f15963o = false;
            C7822j jVar = this.f15956h;
            if (jVar != null) {
                jVar.mo24485d(false);
                this.f15955g.mo24604c();
                this.f15956h.mo24484a(f);
            }
            if (f > 0.0f) {
                m17736g();
                this.f15960l = new Runnable() {
                    public final void run() {
                        C7892b bVar = C7892b.this;
                        if (bVar.f15960l != null) {
                            bVar.f15963o = true;
                            StringBuilder sb = new StringBuilder();
                            sb.append(IAlog.m18018a((Object) C7892b.this));
                            sb.append("Idle state reached!");
                            IAlog.m18021b(sb.toString());
                            C7822j jVar = C7892b.this.f15956h;
                            if (jVar != null) {
                                jVar.mo24485d(true);
                            }
                            C7892b.this.f15960l = null;
                        }
                    }
                };
                this.f15959k.postDelayed(this.f15960l, 100);
                return;
            }
            m17736g();
        }
    }

    /* renamed from: g */
    private void m17736g() {
        Runnable runnable = this.f15960l;
        if (runnable != null) {
            ViewGroup viewGroup = this.f15959k;
            if (viewGroup != null) {
                viewGroup.removeCallbacks(runnable);
                this.f15960l = null;
            }
        }
    }

    @TargetApi(11)
    /* renamed from: h_ */
    public final void mo24232h_() {
        m17736g();
        C8034w.m18120a().mo24869a(this.f15959k);
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("unbind called. root is ");
        sb.append(this.f15959k);
        IAlog.m18021b(sb.toString());
        if (this.f15956h != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("destroying video ui controller");
            IAlog.m18021b(sb2.toString());
            this.f15956h.mo24434a(null);
            this.f15956h.mo24432a();
            this.f15956h = null;
            this.f15958j = null;
        }
        if (this.f15955g != null) {
            this.f15959k.setLayoutTransition(null);
            this.f15959k.removeView(this.f15954f);
            this.f15955g.mo24601a();
            this.f15955g = null;
        }
    }

    /* renamed from: h */
    private void m17739h() {
        this.f15958j = new C7823a() {
            /* renamed from: a */
            public final void mo24526a() {
                if (C7892b.this.f15210c != null) {
                    ((InneractiveAdViewEventsListener) C7892b.this.f15210c).onAdExpanded(C7892b.this.f15208a);
                }
                InneractiveFullscreenAdActivity.show(C7892b.this.f15959k.getContext(), C7892b.this.f15208a);
            }

            /* renamed from: a */
            public final void mo24551a(View view, String str) {
                if (view != null && view.getContext() != null) {
                    InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
                    C7892b.this.mo24129j_();
                }
            }

            /* renamed from: f */
            public final void mo24554f() {
                if (!((C7678p) C7892b.this.f15209b).f15227c) {
                    ((C7678p) C7892b.this.f15209b).f15227c = true;
                    C7892b.this.mo24127i_();
                }
            }

            /* renamed from: g */
            public final boolean mo24555g() {
                C7892b bVar = C7892b.this;
                return bVar.mo24124a(bVar.f15955g.getContext(), ((C7678p) C7892b.this.f15209b).getClickThroughUrl());
            }

            /* renamed from: a */
            public final boolean mo24552a(String str) {
                C7892b bVar = C7892b.this;
                return bVar.mo24124a(bVar.f15955g.getContext(), str);
            }

            /* renamed from: b */
            public final boolean mo24553b(String str) {
                try {
                    C7740a aVar = new C7740a(C7738g.VAST_EVENT_COMPANION_CLICKED, ((C7678p) C7892b.this.f15209b).getAdRequest(), ((C7678p) C7892b.this.f15209b).getResponseData());
                    C7912m mVar = ((C7908j) ((C7678p) C7892b.this.f15209b).getResponseData()).f16049s;
                    if (mVar != null) {
                        C7910l lVar = mVar.f16071h;
                        if (lVar != null) {
                            aVar.mo24311a(new C7741b().mo24315a("mime", TextUtils.isEmpty(lVar.f16055d) ? "na" : lVar.f16055d));
                        }
                    }
                    aVar.mo24314a();
                } catch (Exception e) {
                }
                if (C7892b.this.f15959k == null) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    str = ((C7678p) C7892b.this.f15209b).mo24166a();
                }
                C7892b bVar = C7892b.this;
                return bVar.mo24124a(bVar.f15959k.getContext(), str);
            }

            /* renamed from: h */
            public final void mo24556h() {
            }

            /* renamed from: a */
            public final void mo24550a(int i, int i2) {
                C7892b bVar = C7892b.this;
                if (bVar.f15957i != null) {
                    C7862g gVar = bVar.f15955g;
                    if (gVar != null && gVar.mo24603b()) {
                        C7892b.this.f15957i.onProgress(i, i2);
                    }
                }
            }

            /* renamed from: i */
            public final void mo24557i() {
                C7892b bVar = C7892b.this;
                if (bVar.f15957i != null) {
                    C7862g gVar = bVar.f15955g;
                    if (gVar != null && gVar.mo24603b()) {
                        C7892b.this.f15957i.onCompleted();
                    }
                }
            }

            /* renamed from: j */
            public final void mo24558j() {
                C7892b bVar = C7892b.this;
                if (bVar.f15957i != null) {
                    C7862g gVar = bVar.f15955g;
                    if (gVar != null && gVar.mo24603b()) {
                        C7892b.this.f15957i.onPlayerError();
                    }
                }
            }

            /* renamed from: k */
            public final void mo24559k() {
                if (C7892b.this.f15210c != null) {
                    C7892b.this.mo24129j_();
                }
            }

            /* renamed from: l */
            public final void mo24560l() {
            }
        };
    }

    /* renamed from: a */
    public final boolean mo24224a(View view) {
        return view.equals(this.f15959k);
    }

    /* renamed from: g_ */
    public final void mo24231g_() {
        C7822j jVar = this.f15956h;
        if (jVar != null) {
            jVar.mo24435a_(false);
        }
    }

    /* renamed from: d */
    public final void mo24227d() {
        C7822j jVar = this.f15956h;
        if (jVar != null) {
            jVar.mo24494z();
        }
    }

    /* renamed from: e */
    public final int mo24228e() {
        return 0;
    }

    /* renamed from: f */
    public final int mo24229f() {
        return 0;
    }

    /* renamed from: a_ */
    public final void mo24226a_(int i) {
    }
}
