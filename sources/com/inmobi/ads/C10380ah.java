package com.inmobi.ads;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.inmobi.ads.AdContainer.C10304a;
import com.inmobi.ads.AdContainer.RenderingProperties;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10391ai.C10395a;
import com.inmobi.ads.p214e.p215a.C10533a;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.C10689b;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderView.C10734a;
import com.integralads.avid.library.inmobi.session.AbstractAvidAdSession;
import com.mopub.common.MoPubBrowser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.ah */
/* compiled from: NativeAdContainer */
public class C10380ah implements ActivityLifecycleCallbacks, AdContainer {
    /* access modifiers changed from: private */

    /* renamed from: B */
    public static final String f31537B = C10380ah.class.getSimpleName();

    /* renamed from: A */
    C10395a f31538A = new C10395a() {
        /* renamed from: a */
        public final void mo34045a(View view, boolean z) {
            C10380ah.this.mo34016a(z);
        }
    };

    /* renamed from: C */
    private Set<Integer> f31539C = new HashSet();

    /* renamed from: D */
    private List<C10400ak> f31540D = new ArrayList();

    /* renamed from: E */
    private C10419au f31541E;

    /* renamed from: F */
    private int f31542F = -1;

    /* renamed from: G */
    private C10590o f31543G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public C10380ah f31544H;

    /* renamed from: I */
    private C10400ak f31545I = null;

    /* renamed from: J */
    private String f31546J = null;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C10380ah f31547K;

    /* renamed from: L */
    private C10734a f31548L;

    /* renamed from: M */
    private final C10304a f31549M = new C10304a() {
        /* renamed from: a */
        public final void mo33692a() {
            C10380ah.f31537B;
            C10390c e = C10380ah.this.mo34020e();
            if (e != null) {
                e.mo34059a();
            }
        }

        /* renamed from: a */
        public final void mo33693a(Object obj) {
            if (C10380ah.this.mo34027l() != null) {
                C10390c e = C10380ah.this.mo34020e();
                if (e != null) {
                    e.mo34063b();
                }
            }
        }

        /* renamed from: b */
        public final void mo33694b(Object obj) {
            C10390c e = C10380ah.this.mo34020e();
            if (e != null) {
                e.mo34067f();
            }
        }
    };

    /* renamed from: N */
    private ExecutorService f31550N;

    /* renamed from: O */
    private Runnable f31551O = new Runnable() {
        public final void run() {
            C10380ah ahVar = C10380ah.this;
            if (!ahVar.f31563l && PlacementType.PLACEMENT_TYPE_INLINE == ahVar.f31553b.f31249a && ahVar.f31552a.f31653c) {
                C10380ah.f31537B;
                C10380ah.m33925a(C10380ah.this);
            }
        }
    };

    /* renamed from: a */
    protected C10406ao f31552a;

    /* renamed from: b */
    public RenderingProperties f31553b;

    /* renamed from: c */
    C10478c f31554c;

    /* renamed from: d */
    final String f31555d;
    /* access modifiers changed from: 0000 */

    /* renamed from: e */
    public final long f31556e;
    /* access modifiers changed from: 0000 */

    /* renamed from: f */
    public final String f31557f;
    /* access modifiers changed from: 0000 */

    /* renamed from: g */
    public final boolean f31558g;

    /* renamed from: h */
    final String f31559h;

    /* renamed from: i */
    protected Set<C10465bq> f31560i;

    /* renamed from: j */
    protected C10503ca f31561j;

    /* renamed from: k */
    protected boolean f31562k;

    /* renamed from: l */
    public boolean f31563l = false;

    /* renamed from: m */
    protected boolean f31564m;

    /* renamed from: n */
    C10380ah f31565n;

    /* renamed from: o */
    protected C10390c f31566o;

    /* renamed from: p */
    protected WeakReference<Context> f31567p = new WeakReference<>(null);

    /* renamed from: q */
    WeakReference<Activity> f31568q;

    /* renamed from: r */
    boolean f31569r = false;

    /* renamed from: s */
    int f31570s = 0;

    /* renamed from: t */
    boolean f31571t = true;

    /* renamed from: u */
    boolean f31572u = false;

    /* renamed from: v */
    Intent f31573v = null;

    /* renamed from: w */
    RenderView f31574w;

    /* renamed from: x */
    RenderView f31575x;

    /* renamed from: y */
    int f31576y;

    /* renamed from: z */
    public List<RenderView> f31577z;

    /* renamed from: com.inmobi.ads.ah$a */
    /* compiled from: NativeAdContainer */
    final class C10388a extends Thread {

        /* renamed from: b */
        private WeakReference<C10380ah> f31586b;

        C10388a(C10380ah ahVar) {
            this.f31586b = new WeakReference<>(ahVar);
        }

        public final void run() {
            if (C10380ah.this.mo34027l() == null) {
                C10380ah.f31537B;
                return;
            }
            C10380ah ahVar = (C10380ah) this.f31586b.get();
            if (ahVar != null && !ahVar.f31563l) {
                try {
                    C10406ao h = ahVar.mo34023h();
                    if (C10380ah.this.mo34027l() != null) {
                        if (h.f31655e.length() != 0) {
                            C10380ah.f31537B;
                            JSONObject a = h.mo34104a();
                            if (a != null) {
                                C10406ao aoVar = new C10406ao(C10380ah.this.f31553b.f31249a, a, h, C10380ah.this.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE, C10380ah.this.f31554c, null);
                                if (aoVar.mo34108c()) {
                                    C10380ah a2 = C10389b.m33998a(C10380ah.this.mo34027l(), new RenderingProperties(PlacementType.PLACEMENT_TYPE_INLINE), aoVar, C10380ah.this.f31555d, C10380ah.this.f31559h, null, C10380ah.this.f31554c, C10380ah.this.f31556e, C10380ah.this.f31558g, C10380ah.this.f31557f);
                                    C10380ah.f31537B;
                                    a2.mo34011a((AdContainer) ahVar);
                                    a2.f31574w = ahVar.f31574w;
                                    ahVar.f31547K = a2;
                                    return;
                                }
                                C10380ah.f31537B;
                                return;
                            }
                            return;
                        }
                    }
                    C10380ah.f31537B;
                } catch (Exception e) {
                    C10380ah.f31537B;
                    new StringBuilder("Encountered unexpected error in EndCardBuilder: ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        }
    }

    /* renamed from: com.inmobi.ads.ah$b */
    /* compiled from: NativeAdContainer */
    static final class C10389b {
        /* renamed from: a */
        static C10380ah m33998a(Context context, RenderingProperties renderingProperties, C10406ao aoVar, String str, String str2, Set<C10465bq> set, C10478c cVar, long j, boolean z, String str3) {
            if (new ArrayList(aoVar.f31658h.keySet()).contains("VIDEO")) {
                C10445bd bdVar = new C10445bd(context, renderingProperties, aoVar, str, str2, set, cVar, j, z, str3);
                return bdVar;
            }
            C10380ah ahVar = new C10380ah(context, renderingProperties, aoVar, str, str2, set, cVar, j, z, str3);
            return ahVar;
        }
    }

    /* renamed from: com.inmobi.ads.ah$c */
    /* compiled from: NativeAdContainer */
    public interface C10390c {
        /* renamed from: a */
        void mo34059a();

        /* renamed from: a */
        void mo34060a(String str, Map<String, Object> map);

        /* renamed from: a */
        void mo34061a(Map<String, String> map);

        /* renamed from: a */
        void mo34062a(boolean z);

        /* renamed from: b */
        void mo34063b();

        /* renamed from: c */
        void mo34064c();

        /* renamed from: d */
        void mo34065d();

        /* renamed from: e */
        void mo34066e();

        /* renamed from: f */
        void mo34067f();

        /* renamed from: g */
        void mo34068g();

        /* renamed from: h */
        void mo34069h();

        /* renamed from: i */
        void mo34070i();
    }

    /* renamed from: a */
    static /* synthetic */ void m33925a(C10380ah ahVar) {
        C10380ah ahVar2 = ahVar;
        C10406ao aoVar = ahVar2.f31552a;
        if (aoVar.f31655e.length() != 0) {
            JSONObject a = aoVar.mo34104a();
            if (a != null) {
                C10406ao aoVar2 = new C10406ao(ahVar2.f31553b.f31249a, a, aoVar, ahVar2.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE, ahVar2.f31554c, null);
                aoVar2.f31653c = aoVar.f31653c;
                aoVar2.f31660j = aoVar.f31660j;
                Context context = (Context) ahVar2.f31567p.get();
                if (aoVar2.mo34108c() && context != null) {
                    ahVar2.f31544H = C10389b.m33998a(context, new RenderingProperties(PlacementType.PLACEMENT_TYPE_INLINE), aoVar2, ahVar2.f31555d, ahVar2.f31559h, ahVar2.f31560i, ahVar2.f31554c, ahVar2.f31556e, ahVar2.f31558g, ahVar2.f31557f);
                    ahVar2.f31544H.mo34011a((AdContainer) ahVar2);
                    C10390c cVar = ahVar2.f31566o;
                    if (cVar != null) {
                        ahVar2.f31544H.f31566o = cVar;
                    }
                    if (aoVar.f31653c) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                C10380ah.this.f31544H.getViewableAd().mo33956a(null, new RelativeLayout(C10380ah.this.mo34025j()), false);
                            }
                        });
                    }
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Object getDataModel() {
        return this.f31552a;
    }

    C10380ah(Context context, RenderingProperties renderingProperties, C10406ao aoVar, String str, String str2, Set<C10465bq> set, C10478c cVar, long j, boolean z, String str3) {
        this.f31553b = renderingProperties;
        this.f31552a = aoVar;
        this.f31555d = str;
        this.f31556e = j;
        this.f31558g = z;
        this.f31557f = str3;
        this.f31559h = str2;
        mo34011a((AdContainer) this);
        this.f31562k = false;
        this.f31563l = false;
        this.f31554c = cVar;
        this.f31543G = new C10590o();
        if (set != null) {
            this.f31560i = new HashSet(set);
        }
        this.f31552a.f31654d.f31647z = System.currentTimeMillis();
        mo34008a(context);
        this.f31576y = -1;
        this.f31550N = Executors.newSingleThreadExecutor();
        this.f31550N.submit(this.f31551O);
    }

    /* renamed from: a */
    public final void mo33679a(int i, Map<String, String> map) {
        if (!this.f31563l) {
            if (i == 1) {
                this.f31552a.f31654d.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_LOAD, map);
            } else if (i == 2) {
                this.f31552a.f31654d.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_CLIENT_FILL, map);
            } else if (i == 3) {
            }
        }
    }

    public void setRequestedScreenOrientation() {
        Activity l = mo34027l();
        if (l != null && !this.f31563l) {
            int i = this.f31552a.f31651a;
            if (i == 1) {
                l.setRequestedOrientation(1);
            } else if (i != 2) {
                l.setRequestedOrientation(l.getRequestedOrientation());
            } else {
                l.setRequestedOrientation(0);
            }
        }
    }

    public RenderingProperties getRenderingProperties() {
        return this.f31553b;
    }

    public C10304a getFullScreenEventsListener() {
        return this.f31549M;
    }

    /* renamed from: a */
    public final void mo33678a() {
    }

    public String getMarkupType() {
        return "inmobiJson";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34008a(Context context) {
        m33919B();
        this.f31567p = new WeakReference<>(context);
        C10619a.m34833a(context, (ActivityLifecycleCallbacks) this);
    }

    /* renamed from: d */
    public final Context mo34019d() {
        return (Context) this.f31567p.get();
    }

    /* renamed from: a */
    public final void mo34011a(AdContainer adContainer) {
        if (adContainer instanceof C10380ah) {
            this.f31565n = (C10380ah) adContainer;
        }
    }

    /* renamed from: e */
    public final C10390c mo34020e() {
        return this.f31566o;
    }

    /* renamed from: a */
    public final void mo34012a(C10390c cVar) {
        this.f31566o = cVar;
    }

    /* renamed from: f */
    public final View mo34021f() {
        C10503ca caVar = this.f31561j;
        if (caVar == null) {
            return null;
        }
        return caVar.mo33960b();
    }

    /* renamed from: a */
    private void m33924a(int i, C10402am amVar) {
        if (!this.f31563l) {
            this.f31539C.add(Integer.valueOf(i));
            amVar.f31647z = System.currentTimeMillis();
            if (this.f31562k) {
                m33935b((C10400ak) amVar, mo34006a((C10400ak) amVar));
            } else {
                this.f31540D.add(amVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final void mo34022g() {
        Map a = mo34006a((C10400ak) this.f31552a.f31654d);
        mo33679a(1, a);
        mo33679a(2, a);
    }

    @SuppressLint({"SwitchIntDef"})
    public C10503ca getViewableAd() {
        String str = "deferred";
        Context j = mo34025j();
        if (this.f31561j == null && j != null) {
            mo34022g();
            this.f31561j = new C10363aa(j, this, new C10521cc(this, this.f31574w));
            Set<C10465bq> set = this.f31560i;
            if (set != null) {
                if (j instanceof Activity) {
                    try {
                        Activity activity = (Activity) j;
                        for (C10465bq bqVar : set) {
                            int i = bqVar.f31835a;
                            if (i != 1) {
                                if (i != 3) {
                                    if (i == 6) {
                                        if (((List) bqVar.f31836b.get("trackerUrls")) != null) {
                                            this.f31561j = new C10533a(this.f31561j);
                                        }
                                    }
                                } else if (this.f31576y == 0) {
                                    AbstractAvidAdSession abstractAvidAdSession = (AbstractAvidAdSession) bqVar.f31836b.get("avidAdSession");
                                    boolean z = bqVar.f31836b.containsKey(str) && ((Boolean) bqVar.f31836b.get(str)).booleanValue();
                                    if (abstractAvidAdSession != null) {
                                        C10603v vVar = new C10603v(this, activity, this.f31561j, abstractAvidAdSession, z);
                                        this.f31561j = vVar;
                                    }
                                }
                            } else if (this.f31576y == 0) {
                                this.f31561j = new C10375ad(this, activity, this.f31561j, bqVar.f31836b);
                            } else {
                                bqVar.f31836b.put("zMoatIID", UUID.randomUUID().toString());
                                this.f31561j = new C10376ae(activity, this.f31561j, bqVar.f31836b);
                            }
                        }
                    } catch (Exception e) {
                        new StringBuilder("Exception occurred while creating the Display viewable ad : ").append(e.getMessage());
                        C10621a.m34854a().mo34423a(new C10658a(e));
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "native");
                    hashMap.put("impId", this.f31555d);
                    C10659b.m34983a();
                    C10659b.m34987a("ads", "TrackersForService", hashMap);
                }
            }
        }
        return this.f31561j;
    }

    public View getVideoContainerView() {
        return null;
    }

    /* renamed from: h */
    public final C10406ao mo34023h() {
        return this.f31552a;
    }

    /* renamed from: c */
    public final boolean mo33681c() {
        return this.f31563l;
    }

    public void destroy() {
        if (!this.f31563l) {
            this.f31563l = true;
            this.f31542F = -1;
            C10380ah ahVar = this.f31544H;
            if (ahVar != null) {
                ahVar.mo33680b();
            }
            this.f31563l = true;
            this.f31566o = null;
            C10419au A = m33918A();
            if (A != null) {
                C10586n nVar = A.f31710c;
                for (C10589a aVar : nVar.f32253a) {
                    aVar.f32261a.cancel();
                }
                nVar.f32253a.clear();
                A.mo34131b();
            }
            this.f31540D.clear();
            C10503ca caVar = this.f31561j;
            if (caVar != null) {
                caVar.mo33962d();
                this.f31561j.mo33963e();
            }
            m33919B();
            this.f31567p.clear();
            WeakReference<Activity> weakReference = this.f31568q;
            if (weakReference != null) {
                weakReference.clear();
            }
            List<RenderView> list = this.f31577z;
            if (list != null) {
                list.clear();
            }
            this.f31552a = null;
            this.f31574w = null;
            C10380ah ahVar2 = this.f31547K;
            if (ahVar2 != null) {
                ahVar2.destroy();
                this.f31547K = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo34024i() {
        return PlacementType.PLACEMENT_TYPE_INLINE == this.f31553b.f31249a && mo34027l() != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final Context mo34025j() {
        return (PlacementType.PLACEMENT_TYPE_FULLSCREEN == this.f31553b.f31249a || mo34024i()) ? mo34027l() : (Context) this.f31567p.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final boolean mo34026k() {
        return this.f31562k;
    }

    /* renamed from: b */
    private C10400ak m33934b(C10406ao aoVar, C10400ak akVar) {
        C10400ak akVar2 = null;
        if (aoVar == null) {
            return null;
        }
        String str = akVar.f31625r;
        String str2 = akVar.f31626s;
        if (str != null) {
            akVar2 = m33922a(akVar, aoVar, str);
        }
        if (akVar2 == null && str2 != null) {
            akVar2 = m33922a(akVar, aoVar, str2);
        }
        if (akVar2 != null) {
            StringBuilder sb = new StringBuilder("Referenced asset (");
            sb.append(akVar2.f31611d);
            sb.append(")");
        }
        return akVar2;
    }

    /* renamed from: a */
    private C10400ak m33922a(C10400ak akVar, C10406ao aoVar, String str) {
        if (C10689b.m35092a((Context) this.f31567p.get(), str)) {
            return akVar;
        }
        String[] split = str.split("\\|");
        C10400ak b = aoVar.mo34106b(split[0]);
        if (b == null) {
            return m33934b(aoVar.f31656f, akVar);
        }
        if (b.equals(akVar)) {
            return null;
        }
        if (1 == split.length || 2 == split.length) {
            b.f31620m = 1;
            return b;
        }
        if (split.length > 2) {
            b.f31620m = C10406ao.m34063a(split[2]);
        }
        return b;
    }

    /* renamed from: a */
    protected static C10400ak m33923a(C10406ao aoVar, C10400ak akVar) {
        while (aoVar != null) {
            String str = akVar.f31617j;
            if (str == null || str.length() == 0) {
                akVar.f31619l = 0;
                return akVar;
            }
            String[] split = str.split("\\|");
            if (1 == split.length) {
                akVar.f31619l = m33921a(split[0]);
                return akVar;
            }
            C10400ak b = aoVar.mo34106b(split[0]);
            if (b == null) {
                aoVar = aoVar.f31656f;
            } else if (b.equals(akVar)) {
                return null;
            } else {
                b.f31619l = m33921a(split[1]);
                StringBuilder sb = new StringBuilder("Referenced asset (");
                sb.append(b.f31611d);
                sb.append(")");
                return b;
            }
        }
        return null;
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m33921a(java.lang.String r6) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r6 = r6.toLowerCase(r0)
            java.lang.String r6 = r6.trim()
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 1
            r4 = 3
            r5 = 2
            switch(r0) {
                case -934641255: goto L_0x0053;
                case -934524953: goto L_0x0049;
                case 0: goto L_0x003f;
                case 3127582: goto L_0x0035;
                case 3443508: goto L_0x002b;
                case 3532159: goto L_0x0021;
                case 110066619: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x005d
        L_0x0017:
            java.lang.String r0 = "fullscreen"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0016
            r6 = 6
            goto L_0x005e
        L_0x0021:
            java.lang.String r0 = "skip"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0016
            r6 = 2
            goto L_0x005e
        L_0x002b:
            java.lang.String r0 = "play"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0016
            r6 = 7
            goto L_0x005e
        L_0x0035:
            java.lang.String r0 = "exit"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0016
            r6 = 5
            goto L_0x005e
        L_0x003f:
            java.lang.String r0 = ""
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0016
            r6 = 1
            goto L_0x005e
        L_0x0049:
            java.lang.String r0 = "replay"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0016
            r6 = 4
            goto L_0x005e
        L_0x0053:
            java.lang.String r0 = "reload"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0016
            r6 = 3
            goto L_0x005e
        L_0x005d:
            r6 = -1
        L_0x005e:
            switch(r6) {
                case 2: goto L_0x0067;
                case 3: goto L_0x0066;
                case 4: goto L_0x0066;
                case 5: goto L_0x0065;
                case 6: goto L_0x0064;
                case 7: goto L_0x0063;
                default: goto L_0x0061;
            }
        L_0x0061:
            r6 = 0
            return r6
        L_0x0063:
            return r1
        L_0x0064:
            return r2
        L_0x0065:
            return r3
        L_0x0066:
            return r4
        L_0x0067:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10380ah.m33921a(java.lang.String):int");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34010a(View view, C10400ak akVar) {
        if (!this.f31563l) {
            mo34154w();
            C10400ak b = m33934b(this.f31552a, akVar);
            if (b != null) {
                Map a = mo34006a(b);
                m33928a(b, a);
                if (!b.equals(akVar)) {
                    m33928a(akVar, a);
                }
            } else {
                m33928a(akVar, mo34006a(akVar));
            }
            C10380ah f = m33941f(this);
            if (f != null) {
                if (!akVar.f31625r.trim().isEmpty()) {
                    C10390c cVar = f.f31566o;
                    if (cVar != null) {
                        cVar.mo34066e();
                    }
                }
                C10400ak a2 = m33923a(this.f31552a, akVar);
                if (a2 != null) {
                    if (view != null) {
                        if ("VIDEO".equals(a2.f31609b) && 5 == a2.f31619l) {
                            view.setVisibility(4);
                            akVar.f31631x = 4;
                        }
                    }
                    mo34017b(a2);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34013a(C10400ak akVar, boolean z) {
        C10406ao aoVar = this.f31552a;
        if (aoVar.f31660j && !this.f31563l) {
            C10400ak b = m33934b(aoVar, akVar);
            String str = "DeeplinkFallbackFailed";
            String str2 = "DeeplinkFailed";
            if (b != null) {
                Map a = mo34006a(b);
                b.f31616i = akVar.f31616i;
                if ("VIDEO".equals(b.f31609b) || b.f31615h) {
                    C10503ca caVar = this.f31561j;
                    if (caVar != null) {
                        caVar.mo33957a(4);
                    }
                    int i = b.f31616i;
                    if (i != 0) {
                        String str3 = b.f31625r;
                        if (!this.f31571t || 4 != i) {
                            if (2 == b.f31620m) {
                                C10468bt f = ((C10449be) b).mo34158b().mo34202f();
                                if (f != null) {
                                    String str4 = f.f31843e;
                                    if (str4 != null && !str4.trim().isEmpty()) {
                                        str3 = f.f31843e;
                                    }
                                }
                            }
                            if (!C10689b.m35092a(m33920C(), str3)) {
                                StringBuilder sb = new StringBuilder("Invalid url:");
                                sb.append(str3);
                                sb.append(" will use fallback");
                                m33930a(str2, str3);
                                str3 = b.f31626s;
                                if (!C10689b.m35092a(m33920C(), str3)) {
                                    m33930a(str, str3);
                                    return;
                                }
                            }
                            String a2 = C10700d.m35142a(str3, a);
                            if (!this.f31572u || z) {
                                m33927a(b, i, a2);
                            } else {
                                C10380ah f2 = m33941f(this);
                                if (f2 != null) {
                                    C10390c cVar = f2.f31566o;
                                    if (cVar != null) {
                                        if (1 != i || !C10689b.m35094a(a2)) {
                                            cVar.mo34068g();
                                        } else {
                                            cVar.mo34064c();
                                        }
                                    }
                                    this.f31545I = b;
                                    this.f31546J = a2;
                                    return;
                                }
                            }
                        }
                    }
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String str5 = "url";
            hashMap.put(str5, akVar.f31625r);
            mo34015a(str2, (Map<String, Object>) hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str5, akVar.f31626s);
            mo34015a(str, (Map<String, Object>) hashMap2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34007a(int i, C10400ak akVar) {
        if (!this.f31539C.contains(Integer.valueOf(i)) && !this.f31563l) {
            mo34154w();
            m33924a(i, (C10402am) akVar);
        }
    }

    public void setFullScreenActivityContext(Activity activity) {
        this.f31568q = new WeakReference<>(activity);
    }

    /* renamed from: l */
    public final Activity mo34027l() {
        WeakReference<Activity> weakReference = this.f31568q;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    /* renamed from: w */
    private void mo34154w() {
        C10402am a = this.f31552a.mo34103a(0);
        if (!this.f31539C.contains(Integer.valueOf(0)) && a != null) {
            m33924a(0, a);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo34009a(View view) {
        if (!this.f31562k && !this.f31563l) {
            this.f31562k = true;
            C10402am amVar = this.f31552a.f31654d;
            amVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_RENDER, mo34006a((C10400ak) amVar));
            HashMap hashMap = new HashMap();
            hashMap.put("type", PlacementType.PLACEMENT_TYPE_FULLSCREEN == getRenderingProperties().f31249a ? "int" : "native");
            hashMap.put("clientRequestId", this.f31559h);
            hashMap.put("impId", this.f31555d);
            C10659b.m34983a();
            String str = "ads";
            C10659b.m34987a(str, "AdRendered", hashMap);
            C10659b.m34983a();
            C10659b.m34987a(str, "ViewableBeaconFired", hashMap);
            mo34154w();
            for (C10400ak akVar : this.f31540D) {
                m33935b(akVar, mo34006a(akVar));
            }
            this.f31540D.clear();
            C10380ah f = m33941f(this);
            if (f != null) {
                C10390c cVar = f.f31566o;
                if (cVar != null) {
                    cVar.mo34065d();
                }
            }
        }
    }

    /* renamed from: a */
    private void m33928a(C10400ak akVar, Map<String, String> map) {
        mo34015a("ReportClick", (Map<String, Object>) new HashMap<String,Object>());
        if (2 == akVar.f31620m) {
            C10468bt f = ((C10449be) akVar).mo34158b().mo34202f();
            if (f == null || (f.f31843e == null && akVar.f31625r != null)) {
                akVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_CLICK, map);
            } else if (f.f31842d.size() > 0) {
                for (NativeTracker a : f.mo34185a(TrackerEventType.TRACKER_EVENT_TYPE_CLICK)) {
                    C10400ak.m34047a(a, map);
                }
                return;
            }
            return;
        }
        akVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_CLICK, map);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Map<String, String> mo34006a(C10400ak akVar) {
        HashMap hashMap = new HashMap(3);
        if (!this.f31563l) {
            C10406ao aoVar = this.f31552a;
            if (aoVar != null) {
                hashMap.put("$LTS", String.valueOf(aoVar.f31654d.f31647z));
                C10402am a = C10406ao.m34070a(akVar);
                long currentTimeMillis = System.currentTimeMillis();
                if (a != null) {
                    long j = a.f31647z;
                    if (0 != j) {
                        currentTimeMillis = j;
                    }
                }
                hashMap.put("$STS", String.valueOf(currentTimeMillis));
                hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
                return hashMap;
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private void m33935b(C10400ak akVar, Map<String, String> map) {
        if (akVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", akVar.f31614g);
                jSONObject.put("asset", akVar.f31613f);
            } catch (JSONException e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "native");
            hashMap.put("impId", this.f31555d);
            hashMap.put("pageJson", jSONObject);
            C10659b.m34983a();
            C10659b.m34987a("ads", "PageRendered", hashMap);
            akVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_PAGE_VIEW, map);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34016a(boolean z) {
        if (z) {
            m33944x();
        } else {
            m33945y();
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(15)
    /* renamed from: b */
    public void mo34017b(C10400ak akVar) {
        int i = akVar.f31619l;
        if (i != 0) {
            String str = "InMobi";
            if (i == 1) {
                try {
                    if (this.f31574w != null) {
                        this.f31574w.mo34567d("window.imraid.broadcastEvent('close');");
                    }
                    mo33680b();
                } catch (Exception e) {
                    new StringBuilder("Encountered unexpected error in handling exit action on video: ").append(e.getMessage());
                    Logger.m35065a(InternalLogLevel.DEBUG, str, "SDK encountered unexpected error in exiting video");
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            } else if (i == 3) {
                try {
                    if (this.f31574w != null) {
                        this.f31574w.mo34567d("window.imraid.broadcastEvent('replay');");
                    }
                    if (mo34021f() != null) {
                        View f = mo34021f();
                        ViewGroup viewGroup = (ViewGroup) f.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(f);
                        }
                    }
                    C10380ah ahVar = this.f31565n;
                    NativeTimerView b = m33932b(ahVar.mo34021f());
                    if (!(b == null || b.f31362c == null || !b.f31362c.isRunning())) {
                        b.f31362c.setCurrentPlayTime(b.f31360a * 1000);
                        b.mo33860a(1.0f);
                    }
                    if (!"VIDEO".equals(akVar.f31609b)) {
                        new StringBuilder("Action 3 not valid for asset of type: ").append(akVar.f31609b);
                        return;
                    }
                    if (ahVar instanceof C10445bd) {
                        NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) ahVar.getVideoContainerView();
                        if (nativeVideoWrapper != null) {
                            NativeVideoView videoView = nativeVideoWrapper.getVideoView();
                            C10449be beVar = (C10449be) videoView.getTag();
                            if (beVar != null) {
                                if (beVar.mo34157a()) {
                                    videoView.mo33888e();
                                } else {
                                    videoView.mo33887d();
                                }
                            } else if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == this.f31553b.f31249a) {
                                videoView.mo33888e();
                            } else {
                                videoView.mo33887d();
                            }
                            m33929a(beVar, ahVar);
                            videoView.start();
                        }
                    }
                } catch (Exception e2) {
                    new StringBuilder("Encountered unexpected error in handling replay action on video: ").append(e2.getMessage());
                    Logger.m35065a(InternalLogLevel.DEBUG, str, "SDK encountered unexpected error in replaying video");
                    C10621a.m34854a().mo34423a(new C10658a(e2));
                }
            } else if (i == 4) {
                try {
                    if (PlacementType.PLACEMENT_TYPE_INLINE == this.f31553b.f31249a) {
                        mo34028m();
                    }
                } catch (Exception e3) {
                    new StringBuilder("Encountered unexpected error in handling fullscreen action ").append(e3.getMessage());
                    Logger.m35065a(InternalLogLevel.DEBUG, str, "SDK encountered unexpected error in launching fullscreen ad");
                    C10621a.m34854a().mo34423a(new C10658a(e3));
                }
            } else if (i != 5) {
                this.f31569r = true;
                RenderView renderView = this.f31574w;
                if (!(renderView == null || renderView == null)) {
                    renderView.mo34567d("window.imraid.broadcastEvent('skip');");
                }
                m33937c(mo34021f());
                mo34018c(akVar);
            }
        }
    }

    /* renamed from: b */
    static NativeTimerView m33932b(View view) {
        if (view != null) {
            return (NativeTimerView) view.findViewWithTag("timerView");
        }
        return null;
    }

    /* renamed from: c */
    protected static void m33937c(View view) {
        NativeTimerView b = m33932b(view);
        if (b != null) {
            ValueAnimator valueAnimator = b.f31362c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                b.f31361b = b.f31362c.getCurrentPlayTime();
                b.f31362c.cancel();
            }
        }
    }

    /* renamed from: d */
    protected static void m33938d(View view) {
        NativeTimerView b = m33932b(view);
        if (b != null) {
            ValueAnimator valueAnimator = b.f31362c;
            if (valueAnimator != null && !valueAnimator.isRunning()) {
                b.f31362c.setCurrentPlayTime(b.f31361b);
                b.f31362c.start();
            }
        }
    }

    /* renamed from: x */
    private void m33944x() {
        C10419au A = m33918A();
        if (A != null) {
            C10586n nVar = A.f31710c;
            if (!nVar.f32254b) {
                nVar.f32254b = true;
                nVar.mo34386a(nVar.f32253a);
            }
        }
    }

    /* renamed from: y */
    private void m33945y() {
        C10419au A = m33918A();
        if (A != null) {
            C10586n nVar = A.f31710c;
            if (nVar.f32254b) {
                nVar.f32254b = false;
                for (C10589a aVar : nVar.f32253a) {
                    ValueAnimator valueAnimator = (ValueAnimator) aVar.f32261a;
                    aVar.f32262b = valueAnimator.getCurrentPlayTime();
                    if (((double) valueAnimator.getAnimatedFraction()) == 1.0d) {
                        aVar.f32263c = true;
                    }
                    valueAnimator.cancel();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public final void mo34028m() {
        C10380ah f = m33941f(this);
        if (f != null) {
            C10390c cVar = f.f31566o;
            if (cVar != null) {
                cVar.mo34064c();
            }
            this.f31550N.submit(new Runnable() {
                public final void run() {
                    if (C10380ah.this.f31544H == null) {
                        C10380ah.m33925a(C10380ah.this);
                    }
                    int a = InMobiAdActivity.m35177a((AdContainer) C10380ah.this.f31544H);
                    Intent intent = new Intent((Context) C10380ah.this.f31567p.get(), InMobiAdActivity.class);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", a);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 201);
                    C10380ah ahVar = C10380ah.this;
                    if (ahVar.f31572u) {
                        ahVar.f31573v = intent;
                    } else {
                        C10619a.m34834a((Context) ahVar.f31567p.get(), intent);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo34029n() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final void mo34030o() {
        if (mo34029n()) {
            this.f31569r = true;
            C10390c cVar = this.f31566o;
            if (cVar != null) {
                Map<String, String> map = this.f31552a.f31657g;
                if (map != null) {
                    cVar.mo34061a(map);
                }
            }
        }
    }

    /* renamed from: a */
    private void m33929a(C10449be beVar, C10380ah ahVar) {
        C10468bt f = beVar.mo34158b().mo34202f();
        if (f != null && f.f31844g) {
            for (NativeTracker a : f.mo34185a(TrackerEventType.TRACKER_EVENT_TYPE_END_CARD_CLOSE)) {
                C10400ak.m34047a(a, mo34006a((C10400ak) beVar));
            }
            f.f31844g = false;
            ahVar.mo34015a("EndCardClosed", ahVar.m33946z());
        }
    }

    /* renamed from: z */
    private Map<String, Object> m33946z() {
        List c = this.f31547K.f31552a.mo34107c("WEBVIEW");
        C10451bf bfVar = c.size() > 0 ? (C10451bf) c.get(0) : null;
        String str = bfVar == null ? "Static" : "Rich";
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("dataType", bfVar == null ? MoPubBrowser.DESTINATION_URL_KEY : bfVar.f31795z);
        return hashMap;
    }

    /* renamed from: b */
    public final void mo33680b() {
        Activity activity;
        try {
            if (!this.f31563l) {
                C10380ah f = m33941f(this);
                if (f != null) {
                    f.mo34030o();
                    InMobiAdActivity.m35182a((Object) f);
                    if (f instanceof C10445bd) {
                        C10445bd bdVar = (C10445bd) f;
                        NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) bdVar.getVideoContainerView();
                        if (nativeVideoWrapper != null) {
                            NativeVideoView videoView = nativeVideoWrapper.getVideoView();
                            C10449be beVar = (C10449be) videoView.getTag();
                            beVar.f31629v.put("seekPosition", Integer.valueOf(videoView.getCurrentPosition()));
                            beVar.f31629v.put("lastMediaVolume", Integer.valueOf(videoView.getVolume()));
                            if (beVar.f31632y != null) {
                                ((C10449be) beVar.f31632y).mo34156a(beVar);
                            }
                            m33929a(beVar, (C10380ah) bdVar);
                        }
                    }
                    if (f.f31568q == null) {
                        activity = null;
                    } else {
                        activity = (Activity) f.f31568q.get();
                    }
                    if (activity != null && (activity instanceof InMobiAdActivity)) {
                        ((InMobiAdActivity) activity).f32695a = true;
                        activity.finish();
                        if (this.f31542F != -1) {
                            activity.overridePendingTransition(0, this.f31542F);
                        }
                    }
                    this.f31565n.f31544H = null;
                    this.f31565n.f31550N.submit(this.f31551O);
                }
            }
        } catch (Exception e) {
            new StringBuilder("Encountered unexpected error in handling exit action on video: ").append(e.getMessage());
            Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "SDK encountered unexpected error in exiting video");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34015a(String str, Map<String, Object> map) {
        C10380ah f = m33941f(this);
        String str2 = " ]";
        if (f != null) {
            C10390c cVar = f.f31566o;
            if (cVar != null) {
                cVar.mo34060a(str, map);
                return;
            }
            StringBuilder sb = new StringBuilder("InteractionCallback is null. Discarding telemetry event : [");
            sb.append(str);
            sb.append(str2);
            return;
        }
        StringBuilder sb2 = new StringBuilder("Target container is null. Discarding telemetry event : [");
        sb2.append(str);
        sb2.append(str2);
    }

    /* renamed from: f */
    private static C10380ah m33941f(C10380ah ahVar) {
        while (ahVar != null) {
            if (ahVar.mo34027l() == null) {
                C10380ah ahVar2 = ahVar.f31565n;
                if (ahVar != ahVar2) {
                    ahVar = ahVar2;
                }
            }
            return ahVar;
        }
        return null;
    }

    /* renamed from: A */
    private C10419au m33918A() {
        C10415at atVar;
        C10503ca caVar = this.f31561j;
        if (caVar == null) {
            atVar = null;
        } else {
            atVar = (C10415at) caVar.mo33964f();
        }
        if (atVar != null) {
            this.f31541E = atVar.f31698a;
        }
        return this.f31541E;
    }

    public C10590o getApkDownloader() {
        return this.f31543G;
    }

    /* renamed from: a */
    public final void mo34014a(RenderView renderView) {
        if (this.f31577z == null) {
            this.f31577z = new LinkedList();
        }
        if (!this.f31577z.contains(renderView)) {
            this.f31577z.add(renderView);
        }
    }

    /* renamed from: a */
    private void m33930a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str2);
        mo34015a(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m33927a(C10400ak akVar, int i, String str) {
        if (1 != i) {
            m33931a(str, akVar.f31626s, akVar);
        } else if (C10689b.m35094a(str)) {
            Context context = (Context) this.f31567p.get();
            if (context != null) {
                if (mo34027l() == null) {
                    C10390c cVar = this.f31566o;
                    if (cVar != null) {
                        cVar.mo34064c();
                    }
                }
                InMobiAdActivity.m35181a((RenderView) null);
                InMobiAdActivity.m35180a(mo34043u());
                Intent intent = new Intent(context, InMobiAdActivity.class);
                intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
                intent.putExtra("com.inmobi.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", str);
                intent.putExtra("placementId", this.f31556e);
                intent.putExtra("creativeId", this.f31557f);
                intent.putExtra("impressionId", this.f31555d);
                intent.putExtra("allowAutoRedirection", this.f31558g);
                C10619a.m34834a(context, intent);
            }
        } else {
            m33931a(str, (String) null, akVar);
        }
    }

    /* renamed from: a */
    private void m33931a(String str, String str2, C10400ak akVar) {
        if (this.f31567p.get() != null) {
            String a = C10689b.m35091a((Context) this.f31567p.get(), str, str2);
            if (a != null) {
                C10380ah f = m33941f(this);
                if (f != null) {
                    C10390c cVar = f.f31566o;
                    if (cVar != null && !this.f31572u) {
                        cVar.mo34068g();
                    }
                    if (a.equals(str2)) {
                        akVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_FALLBACK_URL, mo34006a(akVar));
                    }
                }
            }
        }
    }

    /* renamed from: B */
    private void m33919B() {
        Context context = (Context) this.f31567p.get();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        Context C = m33920C();
        if (C != null && C.equals(activity)) {
            mo34038p();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public final void mo34038p() {
        this.f31564m = false;
        m33938d(mo34021f());
        m33944x();
        C10503ca caVar = this.f31561j;
        if (caVar != null) {
            caVar.mo33958a(m33920C(), 0);
        }
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        Context C = m33920C();
        if (C != null && C.equals(activity)) {
            mo34039q();
        }
    }

    /* renamed from: C */
    private Context m33920C() {
        Activity l = mo34027l();
        if (l == null) {
            return (Context) this.f31567p.get();
        }
        return l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public void mo34039q() {
        this.f31564m = true;
        m33937c(mo34021f());
        m33945y();
        C10503ca caVar = this.f31561j;
        if (caVar != null) {
            caVar.mo33958a(m33920C(), 1);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        C10503ca caVar = this.f31561j;
        if (caVar != null) {
            caVar.mo33958a(activity, 2);
        }
        m33919B();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public final void mo34040r() {
        C10400ak akVar = this.f31545I;
        if (akVar != null) {
            String str = this.f31546J;
            if (str != null) {
                m33927a(akVar, akVar.f31616i, str);
                return;
            }
        }
        if (!(this.f31573v == null || this.f31567p.get() == null)) {
            C10619a.m34834a((Context) this.f31567p.get(), this.f31573v);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public final RenderView mo34041s() {
        RenderView renderView = this.f31574w;
        if (renderView == null) {
            return this.f31575x;
        }
        return renderView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public final void mo34042t() {
        new C10388a(this).start();
    }

    /* renamed from: c */
    public final void mo34018c(C10400ak akVar) {
        C10380ah ahVar = this.f31547K;
        if (ahVar == null || mo34021f() == null) {
            Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "Failed to show end card");
            mo33680b();
        } else {
            try {
                mo34015a("EndCardRequested", m33946z());
                ViewGroup viewGroup = (ViewGroup) mo34021f();
                View a = ahVar.getViewableAd().mo33956a(null, viewGroup, false);
                if (a != null) {
                    viewGroup.addView(a);
                    a.setClickable(true);
                    ahVar.m33944x();
                    mo34015a("EndCardDisplayed", m33946z());
                    if (akVar instanceof C10449be) {
                        C10468bt f = ((C10449be) akVar).mo34158b().mo34202f();
                        if (f != null) {
                            f.f31844g = true;
                        }
                    }
                } else {
                    mo33680b();
                }
            } catch (Exception e) {
                mo33680b();
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public final C10734a mo34043u() {
        if (this.f31548L == null) {
            this.f31548L = new C10734a() {
                /* renamed from: w */
                public final void mo34056w() {
                }

                /* renamed from: y */
                public final void mo34057y() {
                }

                /* renamed from: a */
                public final void mo33974a(RenderView renderView) {
                }

                /* renamed from: b */
                public final void mo34053b(RenderView renderView) {
                }

                /* renamed from: A */
                public final void mo34049A() {
                    C10390c e = C10380ah.this.mo34020e();
                    if (e != null) {
                        e.mo34059a();
                    }
                }

                /* renamed from: c */
                public final void mo33984c(RenderView renderView) {
                    C10390c e = C10380ah.this.mo34020e();
                    if (e != null) {
                        e.mo34063b();
                    }
                }

                /* renamed from: d */
                public final void mo33986d(RenderView renderView) {
                    C10390c e = C10380ah.this.mo34020e();
                    if (e != null) {
                        e.mo34067f();
                    }
                }

                /* renamed from: a */
                public final void mo34052a(HashMap<Object, Object> hashMap) {
                }

                /* renamed from: b */
                public final void mo34055b(HashMap<Object, Object> hashMap) {
                    C10390c e = C10380ah.this.mo34020e();
                    if (e != null) {
                        e.mo34066e();
                    }
                }

                /* renamed from: B */
                public final void mo34050B() {
                    C10390c e = C10380ah.this.mo34020e();
                    if (e != null) {
                        e.mo34068g();
                    }
                }

                /* renamed from: b */
                public final void mo34054b(String str, Map<String, Object> map) {
                    C10380ah.this.mo34015a(str, map);
                }

                /* renamed from: G */
                public final void mo34051G() {
                    C10390c e = C10380ah.this.mo34020e();
                    if (e != null && PlacementType.PLACEMENT_TYPE_INLINE == C10380ah.this.f31553b.f31249a) {
                        e.mo34064c();
                    }
                }
            };
        }
        return this.f31548L;
    }
}
