package com.fyber.inneractive.sdk.p166g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.c.c;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.p164e.C7721a.C7722a;
import com.fyber.inneractive.sdk.p165f.C7742k;
import com.fyber.inneractive.sdk.p166g.C7746a.C7753a;
import com.fyber.inneractive.sdk.p166g.C7746a.C7754b;
import com.fyber.inneractive.sdk.p166g.p168b.C7796c;
import com.fyber.inneractive.sdk.p166g.p169c.C7837a;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.p174i.C7899a;
import com.fyber.inneractive.sdk.p174i.C7910l;
import com.fyber.inneractive.sdk.p174i.C7910l.C7911a;
import com.fyber.inneractive.sdk.p174i.C7912m;
import com.fyber.inneractive.sdk.p174i.C7914n;
import com.fyber.inneractive.sdk.p174i.C7915o.C7916a;
import com.fyber.inneractive.sdk.p179l.C7922a;
import com.fyber.inneractive.sdk.p179l.C7922a.C7925a;
import com.fyber.inneractive.sdk.p179l.C7927c;
import com.fyber.inneractive.sdk.util.C7987ab;
import com.fyber.inneractive.sdk.util.C7987ab.C7988a;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mopub.mobileads.VastResourceXmlManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import p019d.p268f.p269a.p270a.C12717b;

/* renamed from: com.fyber.inneractive.sdk.g.c */
public final class C7833c extends C7746a {

    /* renamed from: m */
    public UnitDisplayType f15782m;

    /* renamed from: n */
    public boolean f15783n;

    /* renamed from: o */
    public int f15784o;

    /* renamed from: p */
    public int f15785p;

    /* renamed from: q */
    public C7712j f15786q;

    /* renamed from: r */
    C7987ab f15787r;

    /* renamed from: s */
    View f15788s = null;

    /* renamed from: t */
    boolean f15789t;

    /* renamed from: u */
    protected C7712j f15790u;

    /* renamed from: v */
    private C7912m f15791v;

    /* renamed from: w */
    private C7837a f15792w = C7837a.Uninitialized;

    /* renamed from: x */
    private boolean f15793x;

    /* renamed from: y */
    private boolean f15794y;

    /* renamed from: z */
    private C7796c f15795z;

    /* renamed from: com.fyber.inneractive.sdk.g.c$3 */
    static /* synthetic */ class C78363 {

        /* renamed from: a */
        static final /* synthetic */ int[] f15799a = new int[C7838b.values().length];

        /* renamed from: b */
        static final /* synthetic */ int[] f15800b = new int[C7837a.values().length];

        /* renamed from: c */
        static final /* synthetic */ int[] f15801c = new int[C7911a.m17841a().length];

        static {
            try {
                f15801c[C7911a.f16059a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15801c[C7911a.f16061c - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15801c[C7911a.f16060b - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15801c[C7911a.f16062d - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15800b[C7837a.Uninitialized.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15800b[C7837a.Started.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15800b[C7837a.FirstQuarter.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f15800b[C7837a.MidPoint.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f15800b[C7837a.ThirdPQuarter.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f15800b[C7837a.Completed.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f15799a[C7838b.Prepared.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f15799a[C7838b.Playing.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f15799a[C7838b.Completed.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public C7833c(Context context, C7912m mVar, Set<Vendor> set) {
        super(context, set);
        this.f15789t = false;
        if (mVar != null) {
            this.f15791v = mVar;
            if (IAlog.f16291a <= 3) {
                IAlog.m18019a("IAVastMediaPlayerFlowManager:ctor - got media files: ");
                for (int i = 0; i < this.f15791v.mo24723a(); i++) {
                    StringBuilder sb = new StringBuilder("IAVastMediaPlayerFlowManager(");
                    sb.append(i);
                    sb.append("): ");
                    sb.append(this.f15791v.mo24724a(i).f15980a);
                    IAlog.m18021b(sb.toString());
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IAVastMediaPlayerFlowManager ctor - vastData can't be null");
    }

    /* renamed from: b */
    public final void mo24334b() {
        super.mo24334b();
        this.f15789t = false;
        View view = this.f15788s;
        if (view != null && (view instanceof C7927c)) {
            C7796c cVar = this.f15795z;
            cVar.f15688a.b();
            cVar.f15688a = null;
        }
        C7987ab abVar = this.f15787r;
        if (abVar != null) {
            abVar.mo24831a();
        }
        this.f15788s = null;
        this.f15795z = null;
    }

    /* renamed from: f */
    public final C7899a mo24339f() {
        IAlog.m18021b("IAVastMediaPlayerFlowManager: getNextIAMediaFile called");
        C7912m mVar = this.f15791v;
        if (mVar == null) {
            IAlog.m18021b("IAVastMediaPlayerFlowManager: vast data is null! Object must have already been destroyed");
            return null;
        } else if (mVar.mo24723a() == 0) {
            IAlog.m18024e("IAVastMediaPlayerFlowManager:getNextIAMediaFile - No media files found");
            return null;
        } else {
            C7899a a = this.f15791v.mo24724a(0);
            this.f15521l++;
            StringBuilder sb = new StringBuilder("IAVastMediaPlayerFlowManager: getNextIAMediaFile returning: ");
            sb.append(a.f15980a);
            IAlog.m18021b(sb.toString());
            return a;
        }
    }

    /* renamed from: g */
    public final View mo24340g() {
        if (this.f15789t) {
            return this.f15788s;
        }
        return null;
    }

    /* renamed from: h */
    public final C7796c mo24341h() {
        return this.f15795z;
    }

    /* renamed from: i */
    public final void mo24342i() {
        C7910l lVar = this.f15791v.f16071h;
        if (lVar != null && !this.f15793x) {
            m17541a((C7914n) lVar, C7916a.EVENT_CREATIVE_VIEW);
            this.f15793x = true;
        }
    }

    /* renamed from: m */
    public final C7910l mo24346m() {
        C7912m mVar = this.f15791v;
        if (mVar != null) {
            return mVar.f16071h;
        }
        return null;
    }

    /* renamed from: a */
    public final void mo24332a(C7916a... aVarArr) {
        m17541a((C7914n) this.f15791v, aVarArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo24343j() {
        C7912m mVar = this.f15791v;
        if (mVar != null && mVar.mo24723a() > 0) {
            C7912m mVar2 = this.f15791v;
            if (mVar2.f16068e.size() > 0) {
                mVar2.f16068e.remove(0);
            }
        }
    }

    /* renamed from: a */
    public final void mo24329a(C7838b bVar) {
        super.mo24329a(bVar);
        int i = C78363.f15799a[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    m17539a(C7837a.Completed);
                }
            } else if (this.f15792w.equals(C7837a.Completed)) {
                m17539a(C7837a.Restarted);
            }
        }
    }

    /* renamed from: q */
    public final void mo24467q() {
    }

    /* renamed from: a */
    public final void mo24323a(int i) {
        super.mo24323a(i);
        int i2 = this.f15512c.mo24429i();
        int i3 = C78363.f15800b[this.f15792w.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && i > (i2 / 4) * 3) {
                        m17539a(C7837a.ThirdPQuarter);
                    }
                } else if (i > i2 / 2) {
                    m17539a(C7837a.MidPoint);
                }
            } else if (i > i2 / 4) {
                m17539a(C7837a.FirstQuarter);
            }
        } else if (this.f15512c.mo24460l() != C7838b.Buffering) {
            m17539a(C7837a.Started);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24327a(C7753a aVar) {
        mo24332a(C7916a.EVENT_ERROR);
        if (!aVar.f15550g) {
            C7912m mVar = this.f15791v;
            if (mVar != null && mVar.mo24723a() > 0) {
                C7899a a = this.f15791v.mo24724a(0);
                if (a != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", a.f15980a);
                        jSONObject.put("bitrate", Integer.valueOf(a.f15985f));
                        jSONObject.put("mime", a.f15982c);
                        jSONObject.put("delivery", a.f15981b);
                        aVar.f15551h = jSONObject.toString();
                    } catch (Exception e) {
                        IAlog.m18021b("onReportError: Failed creating Json object from media file!");
                    }
                }
            }
        }
        super.mo24327a(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final void mo24344k() {
        mo24332a(C7916a.EVENT_CREATIVE_VIEW);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24324a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("fetchCompanion called with ");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        IAlog.m18021b(sb.toString());
        this.f15793x = false;
        this.f15788s = null;
        this.f15789t = false;
        C7910l a = this.f15791v.mo24725a(i, i2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(IAlog.m18018a((Object) this));
        sb2.append("selected companion is: ");
        sb2.append(a);
        IAlog.m18021b(sb2.toString());
        if (a != null) {
            if (VastResourceXmlManager.HTML_RESOURCE.equals(a.f16054c)) {
                m17540a(a, C7911a.f16060b);
                return;
            }
            if (!VastResourceXmlManager.STATIC_RESOURCE.equals(a.f16054c)) {
                if (VastResourceXmlManager.IFRAME_RESOURCE.equals(a.f16054c)) {
                    m17540a(a, C7911a.f16059a);
                }
            } else if (TextUtils.equals(a.f16055d, "image/gif")) {
                m17540a(a, C7911a.f16061c);
            } else {
                m17540a(a, C7911a.f16062d);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final C7722a mo24345l() {
        C7754b bVar = this.f15511b;
        if (bVar != null) {
            return bVar.mo24113c();
        }
        return null;
    }

    /* renamed from: a */
    private void m17540a(final C7910l lVar, int i) {
        String str;
        int i2 = C78363.f15801c[i - 1];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            C7796c cVar = new C7796c(this.f15510a, this.f15782m, this.f15783n, this.f15784o, this.f15785p, this.f15786q, i);
            this.f15795z = cVar;
            this.f15788s = cVar.f15688a.i();
            C78341 r9 = new C7925a() {
                /* renamed from: a */
                public final void mo24109a(C7922a aVar) {
                    if (aVar != null) {
                        C7833c.this.f15789t = true;
                    }
                }

                /* renamed from: a */
                public final void mo24108a(InneractiveErrorCode inneractiveErrorCode) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18018a((Object) C7833c.this));
                    sb.append(" Fetching companion html failed!");
                    IAlog.m18021b(sb.toString());
                    C7833c.this.f15789t = false;
                }
            };
            String str2 = lVar.f16056e;
            String str3 = "$__IMGSRC__$";
            if (i == C7911a.f16059a) {
                str = C8008a.m18082a("fyb_iframe_endcard_tmpl.html").replace(str3, lVar.f16056e).replace("$__SrcIframeUrl__$", lVar.f16056e);
            } else if (i == C7911a.f16061c) {
                WebSettings settings = this.f15795z.f15688a.i().getSettings();
                if (VERSION.SDK_INT >= 17) {
                    settings.setMediaPlaybackRequiresUserGesture(false);
                }
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(true);
                str = C8008a.m18082a("fyb_static_endcard_tmpl.html").replace(str3, lVar.f16056e).replace("$__IMGHREF__$", lVar.f16057f.replace("\"", "\\\""));
            } else {
                str = str2;
            }
            cVar.f15688a.setAutoplayMRAIDVideos(cVar.f15689b.isFullscreenUnit());
            cVar.f15688a.a(IAConfigManager.m16954E(), str, c.a(cVar.f15689b, cVar.f15690c), c.a(cVar.f15689b), r9, 10000);
            return;
        }
        if (i2 == 4) {
            this.f15788s = new ImageView(this.f15510a);
            this.f15788s.setId(C12717b.inneractive_vast_endcard_static);
            this.f15787r = new C7987ab(lVar.f16056e, new C7988a() {
                /* renamed from: a */
                public final void mo24563a(Bitmap bitmap) {
                    if (lVar != null && bitmap != null) {
                        View view = C7833c.this.f15788s;
                        if (view != null) {
                            ((ImageView) view).setImageBitmap(bitmap);
                            C7833c cVar = C7833c.this;
                            cVar.f15789t = true;
                            cVar.f15787r = null;
                        }
                    }
                }

                /* renamed from: a */
                public final void mo24562a() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18018a((Object) C7833c.this));
                    sb.append(" Fetching companion image failed!");
                    IAlog.m18021b(sb.toString());
                    C7833c.this.f15787r = null;
                }
            });
            C8006j.m18070a((AsyncTask<P, ?, ?>) this.f15787r, (P[]) new Void[0]);
        }
    }

    /* renamed from: a */
    private static void m17541a(C7914n nVar, C7916a... aVarArr) {
        if (aVarArr.length == 0) {
            IAlog.m18023d("IAVastMediaPlayerFlowManager: eventTypes array is empty");
        } else if (nVar == null) {
            IAlog.m18023d("IAVastMediaPlayerFlowManager: parser is null");
        } else {
            ArrayList arrayList = new ArrayList();
            for (C7916a aVar : aVarArr) {
                String str = aVar.f16104w;
                StringBuilder sb = new StringBuilder("IAVastMediaPlayerFlowManager: Firing events for type: ");
                sb.append(str);
                IAlog.m18021b(sb.toString());
                List<String> a = nVar.mo24720a(aVar);
                if (a.size() == 0) {
                    StringBuilder sb2 = new StringBuilder("IAVastMediaPlayerFlowManager: no events for type: ");
                    sb2.append(str);
                    IAlog.m18021b(sb2.toString());
                } else {
                    arrayList.addAll(a);
                    StringBuilder sb3 = new StringBuilder("found ");
                    sb3.append(a.size());
                    sb3.append(" events for type: ");
                    sb3.append(str);
                    IAlog.m18021b(sb3.toString());
                    for (String str2 : a) {
                        StringBuilder sb4 = new StringBuilder("   event url: ");
                        sb4.append(str2);
                        IAlog.m18021b(sb4.toString());
                        if (!TextUtils.isEmpty(str2)) {
                            C7639a.m16877a(String.format("Tracking URLs array: %s", new Object[]{str2}));
                        }
                    }
                }
            }
            new C7742k(true).mo24318a((List<String>) arrayList);
        }
    }

    /* renamed from: a */
    private void m17539a(C7837a aVar) {
        if (this.f15792w != aVar) {
            if (aVar == C7837a.Started) {
                this.f15794y = false;
                mo24332a(C7916a.EVENT_IMPRESSION, C7916a.EVENT_START);
            } else if (aVar == C7837a.FirstQuarter) {
                mo24332a(C7916a.EVENT_FIRSTQ);
            } else if (aVar == C7837a.MidPoint) {
                mo24332a(C7916a.EVENT_MID);
            } else if (aVar == C7837a.ThirdPQuarter) {
                mo24332a(C7916a.EVENT_THIRDQ);
            } else if (aVar == C7837a.Completed && !this.f15794y) {
                this.f15794y = true;
                mo24332a(C7916a.EVENT_COMPLETE);
            } else if (aVar == C7837a.Restarted) {
                mo24332a(C7916a.EVENT_REWIND);
            }
            this.f15792w = aVar;
        }
    }

    /* renamed from: a */
    public final void mo24561a(C7712j jVar) {
        this.f15790u = jVar;
    }
}
