package com.inmobi.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.p001v7.widget.RecyclerView;
import com.inmobi.ads.AdContainer.RenderingProperties;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10380ah.C10390c;
import com.inmobi.ads.C10458bl.C10460a;
import com.inmobi.ads.C10478c.C10479a;
import com.inmobi.ads.C10540h.C10544a;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.cache.C10517d;
import com.inmobi.ads.p210a.C10361a;
import com.inmobi.ads.p210a.C10362b;
import com.inmobi.ads.p211b.C10439a;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.ads.p213d.C10529a;
import com.inmobi.ads.p213d.C10530b;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.configs.C10651g;
import com.inmobi.commons.core.configs.C10652h;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p221d.C10656b;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.p223f.C10671b;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.core.utilities.uid.C10709c;
import com.inmobi.commons.core.utilities.uid.C10711d;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.p207a.C10300o;
import com.inmobi.p216b.C10614a;
import com.inmobi.rendering.C10735a;
import com.inmobi.rendering.C10756b;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderView.C10734a;
import com.integralads.avid.library.inmobi.session.AbstractAvidAdSession;
import com.mopub.common.AdType;
import com.mopub.common.MoPubBrowser;
import com.mopub.mobileads.VastResourceXmlManager;
import com.squareup.picasso.Picasso;
import com.vungle.warren.model.Advertisement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.ads.i */
/* compiled from: AdUnit */
public abstract class C10545i implements C10460a, C10544a, C10644c, C10734a, C10735a {
    /* access modifiers changed from: private */

    /* renamed from: y */
    public static final String f32145y = C10545i.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f32146A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C10540h f32147B;

    /* renamed from: C */
    private long f32148C;

    /* renamed from: D */
    private long f32149D;

    /* renamed from: E */
    private WeakReference<C10575b> f32150E;

    /* renamed from: F */
    private RenderView f32151F;

    /* renamed from: G */
    private C10462bn f32152G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public long f32153H;

    /* renamed from: I */
    private long f32154I = 0;

    /* renamed from: J */
    private C10574a f32155J;

    /* renamed from: K */
    private Runnable f32156K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public Set<C10465bq> f32157L;

    /* renamed from: M */
    private MonetizationContext f32158M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public C10458bl f32159N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f32160O;

    /* renamed from: P */
    private C10529a f32161P;

    /* renamed from: Q */
    private boolean f32162Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public C10439a f32163R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public C10734a f32164S = new C10734a() {
        /* renamed from: w */
        public final void mo34056w() {
            C10545i.this.f32183s.post(new Runnable() {
                public final void run() {
                    C10545i iVar = C10545i.this;
                    if (2 == iVar.f32165a) {
                        iVar.f32160O = true;
                        C10545i.this.mo34282J();
                    }
                }
            });
        }

        /* renamed from: y */
        public final void mo34057y() {
            C10545i.this.f32183s.post(new Runnable() {
                public final void run() {
                    if (C10545i.this.f32175k != null) {
                        C10545i.this.mo34301i().mo34269a(C10545i.this.f32175k);
                    }
                    C10545i.this.mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
                }
            });
        }

        /* renamed from: a */
        public final void mo33974a(RenderView renderView) {
            C10545i.this.f32183s.post(new Runnable() {
                public final void run() {
                    C10545i iVar = C10545i.this;
                    if (2 == iVar.f32165a) {
                        iVar.mo33968L();
                    }
                }
            });
        }

        /* renamed from: b */
        public final void mo34053b(RenderView renderView) {
        }

        /* renamed from: A */
        public final void mo34049A() {
        }

        /* renamed from: c */
        public final void mo33984c(RenderView renderView) {
        }

        /* renamed from: d */
        public final void mo33986d(RenderView renderView) {
        }

        /* renamed from: a */
        public final void mo34052a(HashMap<Object, Object> hashMap) {
        }

        /* renamed from: b */
        public final void mo34055b(HashMap<Object, Object> hashMap) {
        }

        /* renamed from: B */
        public final void mo34050B() {
        }

        /* renamed from: b */
        public final void mo34054b(String str, Map<String, Object> map) {
        }

        /* renamed from: G */
        public final void mo34051G() {
        }
    };

    /* renamed from: a */
    int f32165a;

    /* renamed from: b */
    final JSONObject f32166b = new JSONObject();

    /* renamed from: c */
    final boolean f32167c = false;

    /* renamed from: d */
    public long f32168d;

    /* renamed from: e */
    public String f32169e;

    /* renamed from: f */
    public Map<String, String> f32170f;
    /* access modifiers changed from: 0000 */

    /* renamed from: g */
    public C10478c f32171g;

    /* renamed from: h */
    String f32172h;

    /* renamed from: i */
    JSONObject f32173i;

    /* renamed from: j */
    C10475bx f32174j;
    /* access modifiers changed from: 0000 */

    /* renamed from: k */
    public String f32175k;

    /* renamed from: l */
    public String f32176l;

    /* renamed from: m */
    String f32177m;

    /* renamed from: n */
    public boolean f32178n = false;

    /* renamed from: o */
    C10380ah f32179o;

    /* renamed from: p */
    ExecutorService f32180p;

    /* renamed from: q */
    public C10578e f32181q;

    /* renamed from: r */
    int f32182r;

    /* renamed from: s */
    Handler f32183s;

    /* renamed from: t */
    boolean f32184t;
    /* access modifiers changed from: 0000 */

    /* renamed from: u */
    public RenderView f32185u;

    /* renamed from: v */
    boolean f32186v;

    /* renamed from: w */
    boolean f32187w = false;
    /* access modifiers changed from: 0000 */

    /* renamed from: x */
    public String f32188x;

    /* renamed from: z */
    private WeakReference<Context> f32189z;

    /* renamed from: com.inmobi.ads.i$a */
    /* compiled from: AdUnit */
    static final class C10574a extends Handler {

        /* renamed from: a */
        private WeakReference<C10545i> f32233a;

        C10574a(C10545i iVar) {
            super(Looper.getMainLooper());
            this.f32233a = new WeakReference<>(iVar);
        }

        public final void handleMessage(Message message) {
            WeakReference<C10545i> weakReference = this.f32233a;
            C10545i iVar = weakReference == null ? null : (C10545i) weakReference.get();
            if (iVar != null) {
                Bundle data = message.getData();
                long j = data.getLong("placementId");
                int i = message.what;
                if (i == 1) {
                    iVar.mo33971a(j, data.getBoolean("adAvailable"), (C10359a) message.obj);
                } else if (i == 2) {
                    iVar.mo33982c(j, (C10359a) message.obj);
                } else if (i == 3) {
                } else {
                    if (i != 4) {
                        switch (i) {
                            case 11:
                                iVar.mo33996x();
                                return;
                            case 12:
                                iVar.mo33997z();
                                return;
                            case 13:
                                iVar.mo33978b((InMobiAdRequestStatus) message.obj);
                                return;
                            case 14:
                                iVar.mo33966H();
                                return;
                            default:
                                return;
                        }
                    } else {
                        iVar.mo33977b(j, data.getBoolean("assetAvailable"));
                    }
                }
            }
        }
    }

    /* renamed from: com.inmobi.ads.i$b */
    /* compiled from: AdUnit */
    public static abstract class C10575b {
        /* renamed from: a */
        public void mo33782a(boolean z) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo33781a(C10545i iVar) {
        }

        /* renamed from: a */
        public void mo33747a() {
        }

        /* renamed from: a */
        public void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo33783b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo33784c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo33753d() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo33754e() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo33749a(Map<Object, Object> map) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo33755f() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo33752b(Map<Object, Object> map) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo33828g() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public void mo33829h() {
        }

        /* renamed from: i */
        public boolean mo34222i() {
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: j */
        public void mo33830j() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo33750a(byte[] bArr) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo33827b(boolean z) {
        }
    }

    /* renamed from: com.inmobi.ads.i$c */
    /* compiled from: AdUnit */
    public static class C10576c {
        /* renamed from: a */
        public static Map<String, Object> m34705a(JSONArray jSONArray) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(jSONArray.getString(i));
                } catch (JSONException e) {
                    C10545i.f32145y;
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
            hashMap.put("trackerUrls", arrayList);
            return hashMap;
        }
    }

    /* renamed from: com.inmobi.ads.i$d */
    /* compiled from: AdUnit */
    static class C10577d {
        /* renamed from: a */
        static HashMap<String, String> m34706a(String str, String str2, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) {
            HashMap<String, String> hashMap = new HashMap<>();
            int i = 0;
            if (jSONArray != null) {
                try {
                    int length = jSONArray.length();
                    int i2 = 0;
                    while (i2 < length) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        int i3 = i2 + 1;
                        sb.append(i3);
                        hashMap.put(sb.toString(), jSONArray.getString(i2));
                        i2 = i3;
                    }
                } catch (Exception e) {
                    C10545i.f32145y;
                    new StringBuilder("Exception while parsing map details for Moat : ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
            if (jSONArray2 != null) {
                int length2 = jSONArray2.length();
                while (i < length2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    int i4 = i + 1;
                    sb2.append(i4);
                    hashMap.put(sb2.toString(), jSONArray2.getString(i));
                    i = i4;
                }
            }
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.optString(str3));
                }
            }
            return hashMap;
        }

        /* renamed from: a */
        static Map<String, Object> m34707a(JSONArray jSONArray) {
            JSONObject jSONObject;
            String str = "zMoatExtras";
            String str2 = "clientSlicers";
            String str3 = "clientLevels";
            String str4 = "partnerCode";
            String str5 = "instrumentVideo";
            String str6 = "enabled";
            String str7 = "moat";
            try {
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        jSONObject = null;
                        break;
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.has(str7)) {
                        jSONObject = jSONObject2.getJSONObject(str7);
                        break;
                    }
                    i++;
                }
                if (jSONObject == null) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(str6, Boolean.valueOf(jSONObject.getBoolean(str6)));
                hashMap.put(str5, Boolean.valueOf(jSONObject.optBoolean(str5, false)));
                hashMap.put(str4, jSONObject.optString(str4, null));
                hashMap.put(str3, jSONObject.optJSONArray(str3));
                hashMap.put(str2, jSONObject.optJSONArray(str2));
                hashMap.put(str, jSONObject.optJSONObject(str));
                return hashMap;
            } catch (JSONException e) {
                C10545i.f32145y;
                new StringBuilder("Exception while parsing MoatParams from response : ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
                return null;
            }
        }
    }

    /* renamed from: com.inmobi.ads.i$e */
    /* compiled from: AdUnit */
    public interface C10578e {
        /* renamed from: a */
        void mo33744a(C10545i iVar);

        /* renamed from: a */
        void mo33745a(C10545i iVar, InMobiAdRequestStatus inMobiAdRequestStatus);
    }

    /* renamed from: b */
    public abstract String mo33976b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo33979b(C10359a aVar);

    /* renamed from: c */
    public abstract String mo33981c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract PlacementType mo33985d();

    /* renamed from: e */
    static /* synthetic */ void m34576e(C10545i iVar) {
        iVar.mo34278C();
        iVar.f32152G.sendEmptyMessageDelayed(0, (long) (iVar.f32171g.f31897i.f31943a * 1000));
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        this.f32171g = (C10478c) aVar;
        mo34301i().f32137d = this.f32171g.mo34203a(mo33976b());
        C10458bl blVar = this.f32159N;
        if (blVar != null) {
            blVar.f31815b = this.f32171g.mo34203a(mo33976b());
        }
        C10659b.m34983a().mo34486a("ads", this.f32171g.f31900l);
    }

    public C10545i(Context context, long j, C10575b bVar) {
        this.f32189z = new WeakReference<>(context);
        this.f32168d = j;
        this.f32150E = new WeakReference<>(bVar);
        this.f32161P = new C10530b(C10614a.m34820a());
        this.f32177m = "unknown";
        this.f32171g = new C10478c();
        C10641b.m34915a().mo34452a((C10639a) new C10651g(), (C10644c) null);
        C10641b.m34915a().mo34452a((C10639a) this.f32171g, (C10644c) this);
        this.f32180p = Executors.newSingleThreadExecutor();
        this.f32180p.submit(new Runnable() {
            public final void run() {
                C10545i iVar = C10545i.this;
                iVar.f32147B = new C10540h(iVar, iVar.f32171g.mo34203a(C10545i.this.mo33976b()), C10545i.this.mo34307u());
            }
        });
        this.f32155J = new C10574a(this);
        this.f32152G = new C10462bn(this);
        this.f32157L = new HashSet();
        this.f32182r = -1;
        this.f32156K = new Runnable() {
            public final void run() {
                int r = C10545i.this.mo33994r();
                if (!(r == -2 || r == -1 || r == 0 || r == 1 || r == 2)) {
                    StringBuilder sb = new StringBuilder("Unknown return value (");
                    sb.append(r);
                    sb.append(") from #doAdLoadWork()");
                }
                C10545i.f32145y;
            }
        };
        C10659b.m34983a().mo34486a("ads", this.f32171g.f31900l);
        this.f32183s = new Handler(Looper.getMainLooper());
        this.f32184t = false;
        this.f32188x = "";
        this.f32173i = this.f32166b;
        this.f32146A = false;
        this.f32165a = 0;
    }

    /* renamed from: a */
    public final Context mo34283a() {
        WeakReference<Context> weakReference = this.f32189z;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    /* renamed from: a */
    public void mo34080a(Context context) {
        this.f32189z = new WeakReference<>(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Map<String, String> mo34082e() {
        HashMap hashMap = new HashMap();
        hashMap.put("preload-request", this.f32178n ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final C10575b mo34298f() {
        C10575b bVar = (C10575b) this.f32150E.get();
        if (bVar == null) {
            mo34299g();
        }
        return bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final void mo34299g() {
        Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "Listener was garbage collected. Unable to give callback");
        mo34296d("ListenerNotFound");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34285a(C10575b bVar) {
        this.f32150E = new WeakReference<>(bVar);
    }

    /* renamed from: h */
    public final boolean mo34300h() {
        if (1 == this.f32165a) {
            return false;
        }
        return this.f32149D == -1 ? this.f32148C != 0 && System.currentTimeMillis() - this.f32148C > TimeUnit.SECONDS.toMillis(this.f32171g.mo34203a(mo33976b()).f31926d) : this.f32148C != 0 && System.currentTimeMillis() > this.f32149D;
    }

    /* renamed from: i */
    public final C10540h mo34301i() {
        if (this.f32147B == null) {
            this.f32147B = new C10540h(this, this.f32171g.mo34203a(mo33976b()), mo34307u());
        }
        return this.f32147B;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.inmobi.ads.AdContainer mo34302j() {
        /*
            r6 = this;
            int r0 = r6.f32165a
            java.lang.String r1 = r6.f32177m
            int r2 = r1.hashCode()
            r3 = -1084172778(0xffffffffbf60d616, float:-0.8782667)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x0022
            r3 = 3213227(0x3107ab, float:4.50269E-39)
            if (r2 == r3) goto L_0x0018
        L_0x0017:
            goto L_0x002c
        L_0x0018:
            java.lang.String r2 = "html"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0017
            r1 = 1
            goto L_0x002d
        L_0x0022:
            java.lang.String r2 = "inmobiJson"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0017
            r1 = 2
            goto L_0x002d
        L_0x002c:
            r1 = -1
        L_0x002d:
            r2 = 3
            r3 = 0
            if (r1 == r5) goto L_0x0042
            if (r1 == r4) goto L_0x0034
            return r3
        L_0x0034:
            if (r0 == 0) goto L_0x0041
            if (r5 == r0) goto L_0x0041
            if (r2 == r0) goto L_0x0041
            if (r4 != r0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            com.inmobi.ads.ah r0 = r6.f32179o
            return r0
        L_0x0041:
            return r3
        L_0x0042:
            if (r0 == 0) goto L_0x004e
            if (r5 == r0) goto L_0x004e
            if (r2 != r0) goto L_0x0049
            goto L_0x004e
        L_0x0049:
            com.inmobi.rendering.RenderView r0 = r6.mo33990k()
            return r0
        L_0x004e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10545i.mo34302j():com.inmobi.ads.AdContainer");
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public RenderView mo33990k() {
        RenderView renderView = this.f32151F;
        if ((renderView == null || renderView.f32764s.get()) && mo34283a() != null) {
            this.f32151F = new RenderView(mo34283a(), new RenderingProperties(mo33985d()), this.f32157L, this.f32175k);
            this.f32151F.mo34554a((C10734a) this, this.f32171g);
            this.f32151F.setPlacementId(this.f32168d);
            this.f32151F.setCreativeId(this.f32188x);
            this.f32151F.setAllowAutoRedirection(this.f32146A);
        }
        return this.f32151F;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x019b A[Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee A[Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0187 A[Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x018e A[Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo33975a(com.inmobi.ads.C10359a r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            java.lang.String r2 = "adMasterSDKInfo"
            java.lang.String r3 = "iasEnabled"
            java.lang.String r4 = "tracking"
            java.lang.String r5 = "metaInfo"
            java.lang.String r6 = "viewability"
            java.lang.String r7 = "creativeType"
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r10 = r0.f31477c     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            long r10 = r0.f31479e     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            r1.f32148C = r10     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            long r10 = r20.mo33952c()     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            r1.f32149D = r10     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r10 = r0.f31481g     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            r1.f32175k = r10     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r10 = r0.f31482h     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            r1.f32176l = r10     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r10 = "markupType"
            java.lang.String r10 = r9.optString(r10)     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r12 = "inmobiJson"
            java.lang.String r13 = "html"
            java.lang.String r15 = "unknown"
            r11 = 1
            if (r10 == 0) goto L_0x0072
            int r16 = r10.length()     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            if (r16 != 0) goto L_0x0042
            goto L_0x0072
        L_0x0042:
            int r8 = r10.hashCode()     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            r14 = -1084172778(0xffffffffbf60d616, float:-0.8782667)
            if (r8 == r14) goto L_0x0059
            r14 = 3213227(0x3107ab, float:4.50269E-39)
            if (r8 == r14) goto L_0x0051
        L_0x0050:
            goto L_0x0061
        L_0x0051:
            boolean r8 = r10.equals(r13)     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            if (r8 == 0) goto L_0x0050
            r8 = 1
            goto L_0x0062
        L_0x0059:
            boolean r8 = r10.equals(r12)     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            if (r8 == 0) goto L_0x0050
            r8 = 2
            goto L_0x0062
        L_0x0061:
            r8 = -1
        L_0x0062:
            if (r8 == r11) goto L_0x006b
            r10 = 2
            if (r8 == r10) goto L_0x0069
            r13 = r15
            goto L_0x0073
        L_0x0069:
            r13 = r12
            goto L_0x0073
        L_0x006b:
            goto L_0x0073
        L_0x006c:
            r0 = move-exception
            goto L_0x0212
        L_0x006f:
            r0 = move-exception
            goto L_0x0222
        L_0x0072:
        L_0x0073:
            r1.f32177m = r13     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r8 = "allowAutoRedirection"
            r10 = 0
            boolean r8 = r9.optBoolean(r8, r10)     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            r1.f32146A = r8     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            org.json.JSONObject r0 = r20.mo33951b()     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            r1.f32173i = r0     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r0 = r1.f32177m     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            boolean r0 = r15.equals(r0)     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            if (r0 == 0) goto L_0x008e
            r2 = 0
            return r2
        L_0x008e:
            java.lang.String r0 = r1.f32177m     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            boolean r0 = r12.equals(r0)     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r8 = "pubContent"
            if (r0 == 0) goto L_0x00a3
            org.json.JSONObject r0 = r9.getJSONObject(r8)     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            r1.f32172h = r0     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            goto L_0x00ad
        L_0x00a3:
            java.lang.String r0 = r9.getString(r8)     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            java.lang.String r0 = r0.trim()     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            r1.f32172h = r0     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
        L_0x00ad:
            java.lang.String r0 = r1.f32172h     // Catch:{ JSONException -> 0x0220, IllegalArgumentException -> 0x0210 }
            if (r0 == 0) goto L_0x00db
            java.lang.String r0 = r1.f32172h     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            int r0 = r0.length()     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            if (r0 == 0) goto L_0x00db
            java.lang.String r0 = r1.f32177m     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            boolean r0 = r15.equals(r0)     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            if (r0 != 0) goto L_0x00db
            java.lang.String r0 = r1.f32172h     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            java.lang.String r8 = "@__imm_aft@"
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            r17 = r12
            long r11 = r1.f32153H     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            long r11 = r17 - r11
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            java.lang.String r0 = r0.replace(r8, r11)     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            r1.f32172h = r0     // Catch:{ JSONException -> 0x006f, IllegalArgumentException -> 0x006c }
            r8 = 1
            goto L_0x00dc
        L_0x00db:
            r8 = 0
        L_0x00dc:
            java.lang.String r0 = "creativeId"
            java.lang.String r11 = ""
            java.lang.String r0 = r9.optString(r0, r11)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r1.f32188x = r0     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.Set<com.inmobi.ads.bq> r0 = r1.f32157L     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            boolean r0 = r0.isEmpty()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r0 == 0) goto L_0x022f
            boolean r0 = r9.has(r6)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r0 == 0) goto L_0x0130
            com.inmobi.ads.bq r0 = new com.inmobi.ads.bq     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r10 = 1
            r0.<init>(r10)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            org.json.JSONArray r6 = r9.getJSONArray(r6)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.Map r6 = com.inmobi.ads.C10545i.C10577d.m34707a(r6)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r0.f31836b = r6     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.Set<com.inmobi.ads.bq> r6 = r1.f32157L     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r6.add(r0)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            android.content.Context r6 = r19.mo34283a()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r6 == 0) goto L_0x011c
            boolean r11 = r6 instanceof android.app.Activity     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r11 == 0) goto L_0x011c
            android.app.Activity r6 = (android.app.Activity) r6     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            android.app.Application r6 = r6.getApplication()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            com.inmobi.ads.C10613z.m34819a(r6)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
        L_0x011c:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r0.f31836b     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r6 == 0) goto L_0x0130
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.lang.String r11 = "Read out Moat params: "
            r6.<init>(r11)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.f31836b     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r6.append(r0)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
        L_0x0130:
            boolean r0 = r9.has(r5)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r0 == 0) goto L_0x01f5
            org.json.JSONObject r0 = r9.getJSONObject(r5)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            boolean r5 = r0.has(r7)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r5 == 0) goto L_0x0146
            java.lang.String r5 = r0.getString(r7)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            goto L_0x0147
        L_0x0146:
            r5 = r15
        L_0x0147:
            boolean r6 = r0.has(r3)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r6 == 0) goto L_0x01b0
            boolean r3 = r0.getBoolean(r3)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r3 == 0) goto L_0x01b0
            com.inmobi.ads.bq r3 = new com.inmobi.ads.bq     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r6 = 3
            r3.<init>(r6)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r6.<init>()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            int r11 = r5.hashCode()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r12 = 112202875(0x6b0147b, float:6.6233935E-35)
            java.lang.String r13 = "video"
            if (r11 == r12) goto L_0x017b
            r12 = 1425678798(0x54fa21ce, float:8.5944718E12)
            if (r11 == r12) goto L_0x0171
        L_0x0170:
            goto L_0x0183
        L_0x0171:
            java.lang.String r11 = "nonvideo"
            boolean r5 = r5.equals(r11)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r5 == 0) goto L_0x0170
            r5 = 1
            goto L_0x0184
        L_0x017b:
            boolean r5 = r5.equals(r13)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r5 == 0) goto L_0x0170
            r5 = 2
            goto L_0x0184
        L_0x0183:
            r5 = -1
        L_0x0184:
            r10 = 1
            if (r5 == r10) goto L_0x018e
            r10 = 2
            if (r5 == r10) goto L_0x018c
            goto L_0x0191
        L_0x018c:
            r15 = r13
            goto L_0x0191
        L_0x018e:
            java.lang.String r15 = "nonvideo"
        L_0x0191:
            r6.put(r7, r15)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r3.f31836b = r6     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r3.f31836b     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r5 == 0) goto L_0x01ab
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.lang.String r6 = "Read out IAS params: "
            r5.<init>(r6)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.Map<java.lang.String, java.lang.Object> r6 = r3.f31836b     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r5.append(r6)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
        L_0x01ab:
            java.util.Set<com.inmobi.ads.bq> r5 = r1.f32157L     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r5.add(r3)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
        L_0x01b0:
            boolean r3 = r0.has(r2)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r3 == 0) goto L_0x01f5
            com.inmobi.ads.c r3 = r1.f32171g     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            com.inmobi.ads.c$l r3 = r3.f31899k     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            com.inmobi.ads.c$f r3 = r3.f31974k     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            boolean r3 = r3.f31934a     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r3 == 0) goto L_0x01f5
            org.json.JSONObject r0 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.lang.String r2 = "enabled"
            boolean r2 = r0.has(r2)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r2 == 0) goto L_0x01f5
            java.lang.String r2 = "enabled"
            boolean r2 = r0.getBoolean(r2)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r2 == 0) goto L_0x01f5
            com.inmobi.ads.bq r2 = new com.inmobi.ads.bq     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r3 = 6
            r2.<init>(r3)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.lang.String r3 = "trackerUrls"
            org.json.JSONArray r0 = r0.getJSONArray(r3)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            java.util.Map r0 = com.inmobi.ads.C10545i.C10576c.m34705a(r0)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r2.f31836b = r0     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            android.content.Context r0 = r19.mo34283a()     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r0 == 0) goto L_0x01f0
            com.inmobi.ads.p214e.p215a.C10535c.C10536a.f32115a     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
        L_0x01f0:
            java.util.Set<com.inmobi.ads.bq> r0 = r1.f32157L     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            r0.add(r2)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
        L_0x01f5:
            boolean r0 = r9.has(r4)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r0 == 0) goto L_0x022f
            java.lang.String r0 = "web"
            java.lang.String r2 = r9.getString(r4)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            if (r0 == 0) goto L_0x022f
            r10 = 0
            r1.f32182r = r10     // Catch:{ JSONException -> 0x020e, IllegalArgumentException -> 0x020c }
            goto L_0x022f
        L_0x020c:
            r0 = move-exception
            goto L_0x0213
        L_0x020e:
            r0 = move-exception
            goto L_0x0223
        L_0x0210:
            r0 = move-exception
            r10 = 0
        L_0x0212:
            r8 = 0
        L_0x0213:
            com.inmobi.commons.core.a.a r2 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r3 = new com.inmobi.commons.core.e.a
            r3.<init>(r0)
            r2.mo34423a(r3)
            goto L_0x0230
        L_0x0220:
            r0 = move-exception
            r10 = 0
        L_0x0222:
            r8 = 0
        L_0x0223:
            com.inmobi.commons.core.a.a r2 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r3 = new com.inmobi.commons.core.e.a
            r3.<init>(r0)
            r2.mo34423a(r3)
        L_0x022f:
        L_0x0230:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10545i.mo33975a(com.inmobi.ads.a):boolean");
    }

    /* renamed from: a */
    public final void mo34275a(long j, boolean z) {
        if (!this.f32187w && mo34283a() != null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            Bundle bundle = new Bundle();
            bundle.putLong("placementId", j);
            bundle.putBoolean("assetAvailable", z);
            obtain.setData(bundle);
            this.f32155J.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo33977b(long j, boolean z) {
        StringBuilder sb = new StringBuilder("Asset availability changed (");
        sb.append(z);
        sb.append(") for placement ID (");
        sb.append(j);
        sb.append(")");
    }

    /* renamed from: b */
    public final void mo34277b(long j, C10359a aVar) {
        if (!this.f32187w && mo34283a() != null) {
            this.f32154I = SystemClock.elapsedRealtime();
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = aVar;
            Bundle bundle = new Bundle();
            bundle.putLong("placementId", j);
            bundle.putBoolean("adAvailable", true);
            obtain.setData(bundle);
            this.f32155J.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33971a(long j, boolean z, C10359a aVar) {
        if (j == this.f32168d && 1 == this.f32165a && z) {
            this.f32148C = aVar.f31479e;
            this.f32149D = aVar.mo33952c();
        }
    }

    /* renamed from: a */
    public final void mo34274a(long j, C10359a aVar) {
        if (!this.f32187w && mo34283a() != null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putLong("placementId", j);
            obtain.setData(bundle);
            obtain.obj = aVar;
            this.f32155J.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo33982c(long j, C10359a aVar) {
        if (j == this.f32168d && this.f32165a == 1) {
            if (mo33975a(aVar)) {
                mo34287a(mo34298f(), "ARF", "");
                this.f32154I = SystemClock.elapsedRealtime();
                this.f32165a = 2;
                return;
            }
            mo34292b("ParsingFailed");
            mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
        }
    }

    /* renamed from: a */
    public void mo33970a(final long j, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (!this.f32187w && mo34283a() != null) {
            this.f32183s.post(new Runnable() {
                public final void run() {
                    try {
                        if (j == C10545i.this.f32168d) {
                            C10545i.this.mo34287a(C10545i.this.mo34298f(), "ARN", "");
                            StringBuilder sb = new StringBuilder("Failed to fetch ad for placement id: ");
                            sb.append(C10545i.this.f32168d);
                            sb.append(", reason phrase available in onAdLoadFailed callback.");
                            Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", sb.toString());
                            C10545i.this.mo33973a(inMobiAdRequestStatus, true);
                        }
                    } catch (Exception e) {
                        Logger.m35065a(InternalLogLevel.ERROR, "[InMobi]", "Unable to load Ad; SDK encountered an unexpected error");
                        C10545i.f32145y;
                        new StringBuilder("onAdFetchFailed with error: ").append(e.getMessage());
                        C10621a.m34854a().mo34423a(new C10658a(e));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33973a(InMobiAdRequestStatus inMobiAdRequestStatus, boolean z) {
        if (this.f32165a == 1 && z) {
            this.f32165a = 3;
        }
        C10575b f = mo34298f();
        if (f != null) {
            f.mo33748a(inMobiAdRequestStatus);
        }
        mo34284a(inMobiAdRequestStatus);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34284a(InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (StatusCode.NO_FILL.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("NoFill");
        } else if (StatusCode.SERVER_ERROR.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("ServerError");
        } else if (StatusCode.NETWORK_UNREACHABLE.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("NetworkUnreachable");
        } else if (StatusCode.AD_ACTIVE.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("AdActive");
        } else if (StatusCode.REQUEST_PENDING.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("RequestPending");
        } else if (StatusCode.REQUEST_INVALID.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("RequestInvalid");
        } else if (StatusCode.REQUEST_TIMED_OUT.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("RequestTimedOut");
        } else if (StatusCode.EARLY_REFRESH_REQUEST.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("EarlyRefreshRequest");
        } else if (StatusCode.INTERNAL_ERROR.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34292b("InternalError");
        } else {
            if (StatusCode.MONETIZATION_DISABLED.equals(inMobiAdRequestStatus.getStatusCode())) {
                mo34292b("MonetizationDisabled");
            }
        }
    }

    /* renamed from: a */
    public void mo33972a(MonetizationContext monetizationContext) {
        this.f32158M = monetizationContext;
    }

    /* renamed from: l */
    public MonetizationContext mo33991l() {
        return this.f32158M;
    }

    /* renamed from: m */
    static boolean m34584m() {
        try {
            RecyclerView.class.getName();
            Picasso.class.getName();
            return false;
        } catch (NoClassDefFoundError e) {
            return true;
        }
    }

    /* renamed from: n */
    public void mo33992n() {
        mo34296d("AdLoadRequested");
        if (!C10700d.m35146a()) {
            mo33973a(new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE), true);
        } else if (this.f32162Q) {
            mo33973a(new InMobiAdRequestStatus(StatusCode.LOAD_CALLED_AFTER_GET_SIGNALS), false);
        } else {
            this.f32180p.execute(this.f32156K);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34291a(final byte[] bArr) {
        boolean z;
        if (!C10694e.m35115e()) {
            mo33995v();
            this.f32183s.post(new Runnable() {
                public final void run() {
                    C10545i.this.mo33973a(new InMobiAdRequestStatus(StatusCode.GDPR_COMPLIANCE_ENFORCED), false);
                }
            });
            z = true;
        } else {
            int i = this.f32165a;
            if (i == 1) {
                this.f32183s.post(new Runnable() {
                    public final void run() {
                        C10545i.this.mo33973a(new InMobiAdRequestStatus(StatusCode.LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING), false);
                    }
                });
                z = true;
            } else if (i == 6 || i == 7 || i == 8) {
                this.f32183s.post(new Runnable() {
                    public final void run() {
                        C10545i.this.mo33973a(new InMobiAdRequestStatus(StatusCode.AD_ACTIVE), false);
                    }
                });
                z = true;
            } else if (i == 10) {
                this.f32183s.post(new Runnable() {
                    public final void run() {
                        C10545i.this.mo33973a(new InMobiAdRequestStatus(StatusCode.FETCHING_SIGNALS_STATE_ERROR), false);
                    }
                });
                z = true;
            } else if (i != 11) {
                this.f32183s.post(new Runnable() {
                    public final void run() {
                        C10545i.this.mo33973a(new InMobiAdRequestStatus(StatusCode.GET_SIGNALS_NOT_CALLED_FOR_LOAD_WITH_RESPONSE), false);
                    }
                });
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            if (bArr == null || bArr.length == 0) {
                mo33973a(new InMobiAdRequestStatus(StatusCode.INVALID_RESPONSE_IN_LOAD), true);
            } else if (this.f32163R == null) {
                mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
            } else {
                this.f32180p.execute(new Runnable() {
                    public final void run() {
                        C10545i iVar = C10545i.this;
                        C10545i.m34569a(iVar, bArr, iVar.f32163R);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final void mo34303o() {
        boolean z;
        final C10575b f = mo34298f();
        final long currentTimeMillis = System.currentTimeMillis();
        String str = "AdGetSignalsFailed";
        String str2 = "ART";
        if (!C10700d.m35146a()) {
            if (f != null) {
                f.mo33751b(new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE));
            }
            mo34287a(f, str2, "NetworkNotAvailable");
            m34570a(str, currentTimeMillis);
            z = true;
        } else {
            int i = this.f32165a;
            if (i == 1 || i == 2 || i == 4) {
                if (f != null) {
                    f.mo33751b(new InMobiAdRequestStatus(StatusCode.GET_SIGNALS_CALLED_WHILE_LOADING));
                }
                mo34287a(f, str2, "LoadInProgress");
                m34570a(str, currentTimeMillis);
                z = true;
            } else if (i == 10) {
                if (f != null) {
                    f.mo33751b(new InMobiAdRequestStatus(StatusCode.FETCHING_SIGNALS_STATE_ERROR));
                }
                mo34287a(f, str2, "SignalsFetchInProgress");
                m34570a(str, currentTimeMillis);
                z = true;
            } else if (i == 6 || i == 7 || i == 8) {
                if (f != null) {
                    f.mo33751b(new InMobiAdRequestStatus(StatusCode.AD_ACTIVE));
                }
                mo34287a(f, str2, "ReloadNotPermitted");
                m34570a(str, currentTimeMillis);
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            this.f32162Q = true;
            mo34296d("AdGetSignalsRequested");
            this.f32180p.execute(new Runnable() {
                public final void run() {
                    C10545i iVar = C10545i.this;
                    iVar.f32165a = 10;
                    String a = C10491a.m34325a(iVar.f32170f);
                    if (C10545i.this.f32163R == null) {
                        C10545i iVar2 = C10545i.this;
                        iVar2.f32163R = new C10439a(iVar2, a);
                    } else {
                        C10545i.this.f32163R.f31755b = a;
                    }
                    if (f != null) {
                        try {
                            byte[] a2 = C10545i.this.f32163R.mo34142a();
                            if (a2 == null) {
                                C10545i.this.f32165a = 3;
                                f.mo33751b(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                                C10545i.this.mo34287a(C10545i.this.mo34298f(), "ART", "RequestCreationFailed");
                                C10545i.this.m34570a("AdGetSignalsFailed", currentTimeMillis);
                                return;
                            }
                            f.mo33750a(a2);
                            C10545i.this.f32165a = 11;
                            C10545i.this.mo34287a(C10545i.this.mo34298f(), "VAR", "");
                            C10545i.this.m34570a("AdGetSignalsSucceeded", currentTimeMillis);
                        } catch (C10362b e) {
                            C10545i.this.f32165a = 3;
                            f.mo33751b(new InMobiAdRequestStatus(StatusCode.GDPR_COMPLIANCE_ENFORCED));
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34570a(String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
        mo34177a(str, (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public final boolean mo34304p() {
        int i = this.f32165a;
        String str = "InMobi";
        if (1 == i) {
            mo34178b(this.f32168d, new InMobiAdRequestStatus(StatusCode.REQUEST_PENDING));
            InternalLogLevel internalLogLevel = InternalLogLevel.ERROR;
            StringBuilder sb = new StringBuilder("An ad prefetch is already in progress. Please wait for the prefetch to complete before requesting for another ad for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            return true;
        } else if (8 == i || 7 == i) {
            mo34178b(this.f32168d, new InMobiAdRequestStatus(StatusCode.AD_ACTIVE));
            InternalLogLevel internalLogLevel2 = InternalLogLevel.ERROR;
            StringBuilder sb2 = new StringBuilder("An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ");
            sb2.append(this.f32168d);
            Logger.m35065a(internalLogLevel2, str, sb2.toString());
            return true;
        } else {
            if (2 == i) {
                if (AdType.HTML.equals(this.f32177m)) {
                    mo34178b(this.f32168d, new InMobiAdRequestStatus(StatusCode.REQUEST_PENDING));
                    InternalLogLevel internalLogLevel3 = InternalLogLevel.ERROR;
                    StringBuilder sb3 = new StringBuilder("An ad load is already in progress. Please wait for the load to complete before requesting prefetch for another ad for placement id: ");
                    sb3.append(this.f32168d);
                    Logger.m35065a(internalLogLevel3, str, sb3.toString());
                    return true;
                }
                if ("inmobiJson".equals(this.f32177m)) {
                    mo34176a(this.f32168d);
                    return true;
                }
            }
            int i2 = this.f32165a;
            if (5 != i2 && 9 != i2) {
                return false;
            }
            mo34176a(this.f32168d);
            return true;
        }
    }

    /* renamed from: a */
    public void mo34081a(final boolean z) {
        mo34296d("AdPrefetchRequested");
        this.f32165a = 1;
        this.f32180p.execute(new Runnable() {
            public final void run() {
                try {
                    if (!C10700d.m35146a()) {
                        C10545i.this.mo34178b(C10545i.this.f32168d, new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE));
                        return;
                    }
                    C10300o.m33571a().mo33670e();
                    C10545i.m34559N();
                    C10652h hVar = new C10652h();
                    C10641b.m34915a().mo34452a((C10639a) hVar, (C10644c) null);
                    if (!hVar.f32477g) {
                        C10545i.this.f32153H = System.currentTimeMillis();
                        try {
                            if (C10545i.this.f32159N == null) {
                                C10545i.this.f32159N = new C10458bl(C10545i.this, C10545i.this.f32171g.mo34203a(C10545i.this.mo33976b()));
                            }
                            C10545i.this.f32176l = C10545i.this.f32159N.mo34171a(C10545i.this.mo34307u(), z, C10545i.this.f32171g.f31891c);
                        } catch (C10361a e) {
                            C10545i.f32145y;
                            e.getMessage();
                            if (!C10545i.this.f32159N.f31814a) {
                                C10545i.this.mo34178b(C10545i.this.f32168d, new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST));
                            }
                        }
                    }
                } catch (Exception e2) {
                    Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Unable to Prefetch ad; SDK encountered an unexpected error");
                    C10545i.f32145y;
                    new StringBuilder("Prefetch failed with unexpected error: ").append(e2.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e2));
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public void mo33993q() {
        mo34081a(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int mo33994r() {
        String str;
        boolean z = true;
        try {
            this.f32165a = 1;
            C10300o.m33571a().mo33670e();
            C10709c.m35160a();
            C10709c.m35162c();
            C10652h hVar = new C10652h();
            C10641b.m34915a().mo34452a((C10639a) hVar, (C10644c) null);
            if (!hVar.f32477g) {
                C10537f u = mo34307u();
                this.f32153H = System.currentTimeMillis();
                C10540h i = mo34301i();
                try {
                    int i2 = this.f32171g.f31891c;
                    C10540h.m34534a();
                    i.f32136c = u;
                    if ("int".equals(i.f32136c.f32121e)) {
                        C10540h.m34541c();
                        List c = i.f32135b.mo34257c(i.f32136c.f32117a, i.f32136c.f32119c, i.f32136c.f32126j, C10491a.m34325a(i.f32136c.f32123g));
                        if (c.size() == 0) {
                            if (SystemClock.elapsedRealtime() - i.f32138e >= ((long) (i2 * 1000))) {
                                z = false;
                            }
                            if (!z) {
                                str = i.mo34266a(i.f32136c, i.f32136c.mo34265c().equals("1"));
                            } else {
                                throw new C10361a("Ignoring request to fetch an ad from the network sooner than the minimum request interval");
                            }
                        } else {
                            str = ((C10359a) c.get(0)).f31482h;
                            if ("INMOBIJSON".equalsIgnoreCase(((C10359a) c.get(0)).mo33954e())) {
                                i.f32134a.mo34277b(i.f32136c.f32117a, (C10359a) c.get(0));
                                i.mo34270a(c);
                            } else {
                                str = i.mo34271b();
                            }
                        }
                    } else {
                        str = i.mo34271b();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("im-accid", C10619a.m34847e());
                    hashMap.put("isPreloaded", i.f32136c.mo34265c());
                    i.f32134a.mo34276a("AdCacheAdRequested", (Map<String, Object>) hashMap);
                    this.f32176l = str;
                    mo34287a(mo34298f(), "VAR", "");
                    if (this.f32178n) {
                        mo34296d("AdPreLoadRequested");
                    }
                } catch (C10361a e) {
                    e.getMessage();
                    this.f32183s.post(new Runnable() {
                        public final void run() {
                            C10545i.this.mo33973a(new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST), true);
                        }
                    });
                }
                return 0;
            }
            mo34296d("LoadAfterMonetizationDisabled");
            Logger.m35065a(InternalLogLevel.ERROR, f32145y, "SDK will not perform this load operation as monetization has been disabled. Please contact InMobi for further info.");
            mo33973a(new InMobiAdRequestStatus(StatusCode.MONETIZATION_DISABLED), true);
            return -1;
        } catch (Exception e2) {
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Unable to load ad; SDK encountered an unexpected error");
            new StringBuilder("Load failed with unexpected error: ").append(e2.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e2));
            return -2;
        }
    }

    /* renamed from: a */
    private void m34571a(final String str, final WeakReference<C10575b> weakReference) {
        this.f32183s.post(new Runnable() {
            public final void run() {
                C10545i iVar = C10545i.this;
                iVar.f32165a = 3;
                iVar.mo34292b(str);
                if (C10545i.this.f32187w) {
                    C10545i.f32145y;
                    return;
                }
                C10575b bVar = (C10575b) weakReference.get();
                if (bVar != null) {
                    if ("int".equals(C10545i.this.mo33976b())) {
                        C10545i.this.mo34287a(bVar, "AVFB", "");
                        bVar.mo33783b();
                        return;
                    }
                    bVar.mo33748a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                    return;
                }
                C10545i.this.mo34299g();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34286a(C10575b bVar, String str, Runnable runnable, Looper looper) {
        Runnable runnable2 = runnable;
        Looper looper2 = looper;
        String str2 = "InternalError";
        if (AdType.HTML.equals(this.f32177m)) {
            final String str3 = str;
            this.f32183s.post(new Runnable() {
                public final void run() {
                    C10545i.this.mo33990k().mo34555a(str3);
                    C10545i.m34576e(C10545i.this);
                }
            });
            return;
        }
        if ("inmobiJson".equals(this.f32177m)) {
            final WeakReference weakReference = new WeakReference(bVar);
            try {
                this.f32154I = SystemClock.elapsedRealtime();
                C10406ao aoVar = new C10406ao(mo33985d(), new JSONObject(this.f32172h), this.f32171g, this.f32174j);
                if (!aoVar.mo34108c() || mo34283a() == null) {
                    m34571a("DataModelValidationFailed", weakReference);
                    return;
                }
                C10380ah a = C10389b.m33998a(mo34283a(), new RenderingProperties(mo33985d()), aoVar, this.f32175k, this.f32176l, this.f32157L, this.f32171g, this.f32168d, this.f32146A, this.f32188x);
                a.mo34012a((C10390c) new C10390c() {
                    /* renamed from: a */
                    public final void mo34059a() {
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                C10545i.this.mo34287a(bVar, "AVFB", "");
                                bVar.mo33783b();
                                return;
                            }
                            C10545i.this.mo34299g();
                        }
                    }

                    /* renamed from: b */
                    public final void mo34063b() {
                        C10545i.this.mo34296d("AdRendered");
                        C10545i iVar = C10545i.this;
                        if (!iVar.f32187w) {
                            iVar.f32183s.post(new Runnable() {
                                public final void run() {
                                    C105686 r0 = C105686.this;
                                    C10545i.this.mo33980b((C10575b) weakReference.get());
                                }
                            });
                        }
                    }

                    /* renamed from: c */
                    public final void mo34064c() {
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33784c();
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }

                    /* renamed from: d */
                    public final void mo34065d() {
                        InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                        StringBuilder sb = new StringBuilder("Successfully impressed ad for placement id: ");
                        sb.append(C10545i.this.f32168d);
                        Logger.m35065a(internalLogLevel, "InMobi", sb.toString());
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33828g();
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }

                    /* renamed from: e */
                    public final void mo34066e() {
                        InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                        StringBuilder sb = new StringBuilder("Ad interaction for placement id: ");
                        sb.append(C10545i.this.f32168d);
                        Logger.m35065a(internalLogLevel, "InMobi", sb.toString());
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33749a((Map<Object, Object>) new HashMap<Object,Object>());
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }

                    /* renamed from: f */
                    public final void mo34067f() {
                        if (!C10545i.this.f32187w) {
                            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                            StringBuilder sb = new StringBuilder("Ad dismissed for placement id: ");
                            sb.append(C10545i.this.f32168d);
                            Logger.m35065a(internalLogLevel, "InMobi", sb.toString());
                            C10545i.this.f32183s.post(new Runnable() {
                                public final void run() {
                                    C105686 r0 = C105686.this;
                                    C10545i.this.mo33983c((C10575b) weakReference.get());
                                }
                            });
                        }
                    }

                    /* renamed from: a */
                    public final void mo34061a(Map<String, String> map) {
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33752b((Map<Object, Object>) new HashMap<Object,Object>(map));
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }

                    /* renamed from: g */
                    public final void mo34068g() {
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33755f();
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }

                    /* renamed from: h */
                    public final void mo34069h() {
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33829h();
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }

                    /* renamed from: a */
                    public final void mo34060a(String str, Map<String, Object> map) {
                        C10545i.this.mo34295c(str, map);
                    }

                    /* renamed from: i */
                    public final void mo34070i() {
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33830j();
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }

                    /* renamed from: a */
                    public final void mo34062a(boolean z) {
                        if (!C10545i.this.f32187w) {
                            C10575b bVar = (C10575b) weakReference.get();
                            if (bVar != null) {
                                bVar.mo33827b(z);
                            } else {
                                C10545i.this.mo34299g();
                            }
                        }
                    }
                });
                this.f32179o = a;
                if (!(runnable2 == null || looper2 == null)) {
                    new Handler(looper2).post(runnable2);
                }
            } catch (JSONException e) {
                m34571a(str2, weakReference);
                C10621a.m34854a().mo34423a(new C10658a(e));
            } catch (Exception e2) {
                new StringBuilder("Encountered unexpected error in loading ad markup into container: ").append(e2.getMessage());
                m34571a(str2, weakReference);
                C10621a.m34854a().mo34423a(new C10658a(e2));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo33980b(C10575b bVar) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo33983c(C10575b bVar) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public final void mo34305s() {
        AdContainer j = mo34302j();
        if (j != null) {
            j.mo33679a(2, null);
        }
    }

    /* renamed from: t */
    public final C10537f mo34306t() {
        C10537f u = mo34307u();
        u.f32128l = true;
        return u;
    }

    /* renamed from: u */
    public final C10537f mo34307u() {
        C10478c cVar = this.f32171g;
        String str = cVar.f31889a;
        long j = this.f32168d;
        C10711d dVar = new C10711d(cVar.f32441p.f32442a);
        C10517d.m34431a();
        C10537f fVar = new C10537f(str, j, dVar, C10517d.m34435c());
        fVar.f32122f = this.f32169e;
        fVar.f32123g = this.f32170f;
        fVar.f32121e = mo33976b();
        fVar.f32118b = "sdkJson";
        fVar.f32120d = this.f32171g.mo34203a(mo33976b()).f31924b;
        fVar.f32124h = mo34082e();
        fVar.f32119c = mo33981c();
        int i = this.f32171g.f31893e;
        fVar.f32580r = i * 1000;
        fVar.f32581s = i * 1000;
        fVar.f32126j = this.f32158M;
        fVar.f32587y = mo33969O();
        return fVar;
    }

    /* renamed from: v */
    public void mo33995v() {
        if (!this.f32187w) {
            this.f32187w = true;
            this.f32175k = null;
            this.f32148C = 0;
            this.f32149D = -1;
            this.f32157L.clear();
            AdContainer j = mo34302j();
            if (j != null) {
                j.destroy();
            }
            this.f32165a = 0;
            this.f32177m = "unknown";
            this.f32160O = false;
            this.f32185u = null;
            this.f32184t = false;
            this.f32186v = false;
            this.f32188x = "";
            this.f32173i = this.f32166b;
            this.f32146A = false;
            this.f32162Q = false;
        }
    }

    /* renamed from: w */
    public final void mo34056w() {
        if (!this.f32187w && mo34283a() != null) {
            this.f32155J.sendEmptyMessage(11);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void mo33996x() {
    }

    /* renamed from: y */
    public final void mo34057y() {
        if (!this.f32187w && mo34283a() != null) {
            this.f32155J.sendEmptyMessage(12);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void mo33997z() {
        mo34292b("RenderFailed");
    }

    /* renamed from: a */
    public void mo33974a(RenderView renderView) {
        if (!this.f32187w && mo34283a() != null) {
        }
    }

    /* renamed from: b */
    public void mo34053b(RenderView renderView) {
        if (!this.f32187w && mo34283a() != null) {
        }
    }

    /* renamed from: A */
    public final void mo34049A() {
        if (!this.f32187w && mo34283a() != null && 7 == this.f32165a) {
            this.f32165a = 3;
            mo34287a(mo34298f(), "AVFB", "");
            if (mo34298f() != null) {
                mo34298f().mo33783b();
            }
        }
    }

    /* renamed from: c */
    public void mo33984c(RenderView renderView) {
        if (!this.f32187w && mo34283a() != null) {
        }
    }

    /* renamed from: d */
    public void mo33986d(RenderView renderView) {
        if (!this.f32187w && mo34283a() != null) {
        }
    }

    /* renamed from: a */
    public final void mo34052a(HashMap<Object, Object> hashMap) {
        if (!this.f32187w && mo34283a() != null) {
            new StringBuilder("Ad reward action completed. Params:").append(hashMap.toString());
            if (mo34298f() != null) {
                mo34298f().mo33752b((Map<Object, Object>) hashMap);
            }
        }
    }

    /* renamed from: b */
    public final void mo34055b(HashMap<Object, Object> hashMap) {
        if (!this.f32187w && mo34283a() != null) {
            new StringBuilder("Ad interaction. Params:").append(hashMap.toString());
            mo34296d("AdInteracted");
            if (mo34298f() != null) {
                mo34298f().mo33749a((Map<Object, Object>) hashMap);
            }
        }
    }

    /* renamed from: B */
    public final void mo34050B() {
        if (!(this.f32187w || mo34283a() == null || mo34298f() == null)) {
            mo34298f().mo33755f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public final void mo34278C() {
        this.f32152G.removeMessages(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: D */
    public final void mo34279D() {
        this.f32183s.post(new Runnable() {
            public final void run() {
                C10545i.this.mo33965E();
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public void mo33965E() {
        mo34292b("RenderTimeOut");
        if (this.f32165a == 2) {
            this.f32165a = 3;
            if (mo34298f() != null) {
                mo34298f().mo33748a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34288a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", str);
        mo34295c("AdLoadRejected", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: F */
    public final void mo34280F() {
        HashMap hashMap = new HashMap();
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f32154I));
        mo34295c("AdLoadSuccessful", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo34292b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", str);
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f32154I));
        mo34295c("AdLoadFailed", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo34294c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", str);
        mo34295c("AdPrefetchRejected", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34287a(C10575b bVar, String str, String str2) {
        String str3;
        if (bVar != null && bVar.mo34222i()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            C10478c cVar = this.f32171g;
            String b = mo33976b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            sb2.append("Dict");
            C10479a aVar = (C10479a) cVar.f31895g.get(sb2.toString());
            if (aVar == null) {
                aVar = cVar.f31894f;
            }
            if (aVar.f31915h) {
                String str4 = this.f32175k;
                if (str4 != null) {
                    str3 = str4;
                } else {
                    str3 = "";
                }
                C10671b bVar2 = new C10671b(UUID.randomUUID().toString(), this.f32177m, str, this.f32168d, str3, str2, (String) C10691b.m35101a(mo33969O()).get("d-nettype-raw"), mo33976b(), System.currentTimeMillis());
                this.f32161P.mo34259a(bVar2);
            }
        }
    }

    /* renamed from: O */
    private boolean mo33969O() {
        return this.f32171g.f31897i.f31955m && C10619a.m34846d();
    }

    /* renamed from: b */
    public final void mo34054b(String str, Map<String, Object> map) {
        mo34295c(str, map);
    }

    /* renamed from: a */
    public final void mo34177a(String str, Map<String, Object> map) {
        mo34295c(str, map);
    }

    /* renamed from: G */
    public final void mo34051G() {
    }

    /* renamed from: d */
    public final void mo34296d(String str) {
        mo34295c(str, (Map<String, Object>) new HashMap<String,Object>());
    }

    /* renamed from: c */
    public final void mo34295c(String str, Map<String, Object> map) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("type", mo33976b());
        hashMap.put("plId", Long.valueOf(this.f32168d));
        hashMap.put("impId", this.f32175k);
        hashMap.put("isPreloaded", this.f32178n ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        int a = C10691b.m35099a();
        if (a == 0) {
            str2 = "carrier";
        } else if (a != 1) {
            str2 = "NIL";
        } else {
            str2 = "wifi";
        }
        hashMap.put("networkType", str2);
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        String str3 = "clientRequestId";
        if (map.get(str3) == null) {
            hashMap.put(str3, this.f32176l);
        }
        for (Entry entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        try {
            C10659b.m34983a();
            C10659b.m34987a("ads", str, hashMap);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
            sb.append(e.getMessage());
            sb.append(")");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo34293c(C10359a aVar) {
        if (aVar instanceof C10444bc) {
            C10444bc bcVar = (C10444bc) aVar;
            Context a = mo34283a();
            boolean z = this.f32171g.f31899k.f31973j;
            for (C10465bq bqVar : this.f32157L) {
                if (z && 3 == bqVar.f31835a && Advertisement.KEY_VIDEO == bqVar.f31836b.get(VastResourceXmlManager.CREATIVE_TYPE)) {
                    try {
                        C10475bx bxVar = new C10475bx(bcVar.f31769l, bcVar.f31770m, bcVar.f31771n, bcVar.mo34145h(), bcVar.mo34146i(), this.f32171g.f31901m);
                        C10449be beVar = (C10449be) new C10406ao(mo33985d(), new JSONObject(this.f32172h), this.f32171g, bxVar).mo34107c("VIDEO").get(0);
                        if (a != null) {
                            HashSet hashSet = new HashSet();
                            for (NativeTracker nativeTracker : beVar.f31628u) {
                                if (TrackerEventType.TRACKER_EVENT_TYPE_IAS == nativeTracker.f31378b) {
                                    hashSet.add(m34575d(nativeTracker.f31377a, nativeTracker.f31379c));
                                }
                            }
                            if (hashSet.size() != 0) {
                                bqVar.f31836b.put("avidAdSession", C10604w.m34783a(a, (Set<String>) hashSet));
                                bqVar.f31836b.put("deferred", Boolean.valueOf(true));
                            }
                        }
                    } catch (Exception e) {
                        new StringBuilder("Setting up impression tracking for AVID encountered an unexpected error: ").append(e.getMessage());
                        C10621a.m34854a().mo34423a(new C10658a(e));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34290a(boolean z, RenderView renderView) {
        boolean z2 = this.f32171g.f31899k.f31973j;
        for (C10465bq bqVar : this.f32157L) {
            if (z2 && 3 == bqVar.f31835a) {
                try {
                    AbstractAvidAdSession a = C10603v.m34772a(mo34283a(), z, (String) bqVar.f31836b.get(VastResourceXmlManager.CREATIVE_TYPE), renderView);
                    if (a != null) {
                        bqVar.f31836b.put("avidAdSession", a);
                        bqVar.f31836b.put("deferred", Boolean.valueOf(z));
                    }
                } catch (Exception e) {
                    new StringBuilder("Setting up impression tracking for IAS encountered an unexpected error: ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        }
    }

    /* renamed from: d */
    private static String m34575d(String str, Map<String, String> map) {
        if (map == null || str == null) {
            return str;
        }
        for (String str2 : map.keySet()) {
            str = str.replace(str2, (CharSequence) map.get(str2));
        }
        return str;
    }

    /* renamed from: a */
    public final void mo34176a(long j) {
        mo34296d("AdPrefetchSuccessful");
        if (!this.f32187w && mo34283a() != null) {
            Message obtain = Message.obtain();
            obtain.what = 14;
            Bundle bundle = new Bundle();
            bundle.putLong("placementId", j);
            obtain.setData(bundle);
            this.f32155J.sendMessage(obtain);
        }
    }

    /* renamed from: b */
    public final void mo34178b(long j, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (StatusCode.EARLY_REFRESH_REQUEST.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34294c("EarlyRefreshRequest");
        } else if (StatusCode.NETWORK_UNREACHABLE.equals(inMobiAdRequestStatus.getStatusCode())) {
            mo34294c("NetworkUnreachable");
        } else {
            mo34296d("AdPrefetchFailed");
        }
        if (!this.f32187w && mo34283a() != null) {
            Message obtain = Message.obtain();
            obtain.what = 13;
            obtain.obj = inMobiAdRequestStatus;
            Bundle bundle = new Bundle();
            bundle.putLong("placementId", j);
            obtain.setData(bundle);
            this.f32155J.sendMessage(obtain);
        }
    }

    /* renamed from: H */
    public void mo33966H() {
        if (1 == this.f32165a) {
            C10578e eVar = this.f32181q;
            if (eVar != null) {
                eVar.mo33744a(this);
            }
        }
    }

    /* renamed from: b */
    public void mo33978b(InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (1 == this.f32165a) {
            C10578e eVar = this.f32181q;
            if (eVar != null) {
                eVar.mo33745a(this, inMobiAdRequestStatus);
            }
        }
    }

    /* renamed from: e */
    public final void mo34297e(final String str) {
        this.f32180p.execute(new Runnable() {
            public final void run() {
                if (C10545i.this.f32175k == null || str == null) {
                    C10545i.f32145y;
                    return;
                }
                C10528d.m34485a();
                String f = C10545i.this.f32175k;
                String str = str;
                C10656b a = C10656b.m34962a();
                C10359a c = C10528d.m34491c(f);
                int i = 0;
                if (c != null) {
                    c.f31483i = str;
                    i = a.mo34474b("ad", c.mo33949a(), "imp_id=?", new String[]{f});
                }
                C10545i.f32145y;
                StringBuilder sb = new StringBuilder("Updated ");
                sb.append(i);
                sb.append("for blob ");
                sb.append(str);
            }
        });
    }

    /* renamed from: a */
    public final void mo34289a(final String str, final String str2, final C10756b bVar) {
        this.f32180p.execute(new Runnable() {
            public final void run() {
                try {
                    String str = "";
                    if (C10545i.this.f32175k != null) {
                        C10528d.m34485a();
                        C10359a c = C10528d.m34491c(C10545i.this.f32175k);
                        if (c != null) {
                            bVar.mo34557a(str, str2, c.f31483i);
                            C10545i.f32145y;
                            return;
                        }
                        C10545i.f32145y;
                        bVar.mo34557a(str, str2, str);
                        return;
                    }
                    C10545i.f32145y;
                    bVar.mo34557a(str, str2, str);
                } catch (Exception e) {
                    C10545i.f32145y;
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: I */
    public final void mo34281I() {
        this.f32180p.execute(new Runnable() {
            public final void run() {
                try {
                    final C10406ao aoVar = new C10406ao(C10545i.this.mo33985d(), new JSONObject(C10545i.this.f32172h), C10545i.this.f32171g, null);
                    C10545i.this.f32183s.post(new Runnable() {
                        public final void run() {
                            try {
                                C10451bf bfVar = aoVar.f31661k;
                                if (bfVar != null) {
                                    C10545i.this.f32185u = new RenderView(C10545i.this.mo34283a(), new RenderingProperties(C10545i.this.mo33985d()), C10545i.this.f32157L, C10545i.this.f32175k);
                                    C10545i.this.f32185u.mo34554a(C10545i.this.f32164S, C10545i.this.f32171g);
                                    C10545i.this.f32185u.f32755j = true;
                                    C10545i.this.f32185u.setBlobProvider(C10545i.this);
                                    C10545i.this.f32185u.setIsPreload(true);
                                    C10545i.this.f32185u.setPlacementId(C10545i.this.f32168d);
                                    C10545i.this.f32185u.setCreativeId(C10545i.this.f32188x);
                                    C10545i.this.f32185u.setAllowAutoRedirection(C10545i.this.f32146A);
                                    if (C10545i.this.f32182r == 0) {
                                        C10545i.this.mo34290a(true, C10545i.this.f32185u);
                                    }
                                    if (MoPubBrowser.DESTINATION_URL_KEY.equals(bfVar.f31795z)) {
                                        C10545i.this.f32185u.mo34562b((String) bfVar.f31612e);
                                    } else {
                                        C10545i.this.f32185u.mo34555a((String) bfVar.f31612e);
                                    }
                                }
                                C10545i.m34576e(C10545i.this);
                            } catch (Exception e) {
                                C10545i.f32145y;
                                C10545i iVar = C10545i.this;
                                iVar.f32165a = 3;
                                iVar.mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
                                C10621a.m34854a().mo34423a(new C10658a(e));
                            }
                        }
                    });
                } catch (Exception e) {
                    C10545i.f32145y;
                    C10545i.this.f32183s.post(new Runnable() {
                        public final void run() {
                            C10545i iVar = C10545i.this;
                            iVar.f32165a = 3;
                            iVar.mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
                        }
                    });
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: J */
    public final void mo34282J() {
        if (this.f32184t && this.f32186v && this.f32160O) {
            mo34278C();
            mo33967K();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: K */
    public void mo33967K() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: L */
    public void mo33968L() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[Catch:{ Exception -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ Exception -> 0x004c }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m34569a(com.inmobi.ads.C10545i r3, byte[] r4, com.inmobi.ads.p211b.C10439a r5) {
        /*
            java.lang.String r0 = "AdLoadWithResponseRequested"
            long r1 = r5.f31756c     // Catch:{ Exception -> 0x004c }
            r3.m34570a(r0, r1)     // Catch:{ Exception -> 0x004c }
            r0 = 1
            r3.f32165a = r0     // Catch:{ Exception -> 0x004c }
            com.inmobi.ads.b.b r0 = r5.f31757d     // Catch:{ Exception -> 0x004c }
            if (r0 == 0) goto L_0x0044
            com.inmobi.ads.b.b r0 = r5.f31757d     // Catch:{ Exception -> 0x004c }
            com.inmobi.ads.f r1 = r0.f31758a     // Catch:{ Exception -> 0x004c }
            byte[] r4 = r1.mo34503a(r4)     // Catch:{ Exception -> 0x004c }
            if (r4 == 0) goto L_0x002e
            int r1 = r4.length     // Catch:{ Exception -> 0x004c }
            if (r1 != 0) goto L_0x001e
            goto L_0x002e
        L_0x001e:
            com.inmobi.commons.core.network.d r1 = new com.inmobi.commons.core.network.d     // Catch:{ Exception -> 0x004c }
            r1.<init>()     // Catch:{ Exception -> 0x004c }
            r1.mo34512b(r4)     // Catch:{ Exception -> 0x004c }
            com.inmobi.ads.g r4 = new com.inmobi.ads.g     // Catch:{ Exception -> 0x004c }
            com.inmobi.ads.f r0 = r0.f31758a     // Catch:{ Exception -> 0x004c }
            r4.<init>(r0, r1)     // Catch:{ Exception -> 0x004c }
            goto L_0x002f
        L_0x002e:
            r4 = 0
        L_0x002f:
            if (r4 == 0) goto L_0x003c
            com.inmobi.ads.i r5 = r5.f31754a     // Catch:{ Exception -> 0x004c }
            com.inmobi.ads.h r5 = r5.mo34301i()     // Catch:{ Exception -> 0x004c }
            r5.mo34172a(r4)     // Catch:{ Exception -> 0x004c }
            return
        L_0x003c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = "Unable to decrypt response."
            r4.<init>(r5)     // Catch:{ Exception -> 0x004c }
            throw r4     // Catch:{ Exception -> 0x004c }
        L_0x0044:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = "GMARequest is null."
            r4.<init>(r5)     // Catch:{ Exception -> 0x004c }
            throw r4     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            r4 = move-exception
            android.os.Handler r4 = r3.f32183s
            com.inmobi.ads.i$16 r5 = new com.inmobi.ads.i$16
            r5.<init>()
            r4.post(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10545i.m34569a(com.inmobi.ads.i, byte[], com.inmobi.ads.b.a):void");
    }

    /* renamed from: N */
    static /* synthetic */ void m34559N() {
        C10709c.m35160a();
        C10709c.m35162c();
    }
}
