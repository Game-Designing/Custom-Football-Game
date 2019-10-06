package p019d.p143b.p144a.p146b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.C5861g;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import p019d.p143b.p144a.p145a.C6925a;
import p019d.p143b.p144a.p145a.C6942r;
import p019d.p143b.p144a.p147c.C7044B;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p144a.p147c.C7177kc;
import p019d.p143b.p144a.p147c.C7182m;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p144a.p147c.C7234z;
import p019d.p143b.p144a.p147c.C7235za;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.ja */
class C7007ja implements C5861g {

    /* renamed from: a */
    private static final Map<String, C7007ja> f13016a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    public static volatile boolean f13017b = false;

    /* renamed from: c */
    public static volatile boolean f13018c = false;

    /* renamed from: d */
    private static volatile boolean f13019d;

    /* renamed from: e */
    protected final String f13020e;

    /* renamed from: f */
    protected final C7142c f13021f;

    /* renamed from: g */
    private final C7177kc f13022g;

    /* renamed from: h */
    protected final WeakReference<Context> f13023h;

    /* renamed from: i */
    private volatile C7253c f13024i;

    /* renamed from: j */
    private volatile C7260j f13025j;

    /* renamed from: k */
    private volatile C7252b f13026k;

    /* renamed from: l */
    private volatile C7234z f13027l;

    /* renamed from: m */
    private volatile C7044B f13028m;

    /* renamed from: n */
    private volatile C7028u f13029n;

    /* renamed from: o */
    private volatile String f13030o;

    C7007ja(C7267q qVar, Context context) {
        if (qVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.f13021f = (C7142c) qVar;
            this.f13020e = UUID.randomUUID().toString();
            this.f13022g = new C7177kc();
            this.f13023h = new WeakReference<>(context);
            f13017b = true;
            f13018c = false;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    public static C7007ja m14432a(String str) {
        return (C7007ja) f13016a.get(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14433a(Context context) {
        Intent intent = new Intent(context, AppLovinInterstitialActivity.class);
        intent.putExtra("com.applovin.interstitial.wrapper_id", this.f13020e);
        C6950D.f12836a = this;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            try {
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(0, 0);
            } catch (Throwable th) {
                this.f13021f.mo23049b().mo22917b("InterstitialAdDialogWrapper", "Unable to remove pending transition animations", th);
            }
        } else {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        mo22618a(true);
    }

    /* renamed from: a */
    private void m14435a(C7234z zVar, String str, Context context) {
        C7262l b;
        String str2;
        f13016a.put(this.f13020e, this);
        this.f13027l = zVar;
        this.f13030o = str;
        this.f13028m = this.f13027l != null ? this.f13027l.mo23433ka() : C7044B.DEFAULT;
        String str3 = "InterstitialAdDialogWrapper";
        if (!C7209sc.m15478a(zVar, context, this.f13021f)) {
            if (this.f13027l instanceof C6925a) {
                C6942r qa = ((C6925a) this.f13027l).mo22410qa();
                if (qa != null) {
                    C7262l b2 = this.f13021f.mo23049b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cached video removed from local filesystem for VAST ad. Setting videoUri to source: ");
                    sb.append(qa.mo22476a());
                    b2.mo22916b(str3, sb.toString());
                    qa.mo22477a(qa.mo22476a());
                } else {
                    b = this.f13021f.mo23049b();
                    str2 = "Cached video removed from local filesystem for VAST ad and source uri not found. Failing ad show.";
                }
            } else {
                b = this.f13021f.mo23049b();
                str2 = "Cached video removed from local filesystem for internal ad. Failing ad show.";
            }
            b.mo22916b(str3, str2);
            m14437b(zVar);
            return;
        }
        if (C7182m.m15320a(AppLovinInterstitialActivity.class, context)) {
            long max = Math.max(0, new C7212tb(this.f13021f).mo23307l());
            C7262l b3 = this.f13021f.mo23049b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Presenting ad with delay of ");
            sb2.append(max);
            b3.mo22918c(str3, sb2.toString());
            new Handler(context.getMainLooper()).postDelayed(new C7009ka(this, context), max);
        } else {
            this.f13021f.mo23049b().mo22921e("AppLovinInterstitialAdDialog", "Unable to launch ad.");
            m14437b(zVar);
        }
    }

    /* renamed from: a */
    private void m14436a(C7235za zaVar, String str, Activity activity) {
        this.f13021f.mo23076u().mo23097a(zaVar, str, activity, this.f13022g);
    }

    /* renamed from: b */
    private void m14437b(C7251a aVar) {
        if (this.f13024i != null) {
            this.f13024i.adHidden(aVar);
        }
        f13019d = false;
    }

    /* renamed from: j */
    private Context m14438j() {
        WeakReference<Context> weakReference = this.f13023h;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public C7267q mo22616a() {
        return this.f13021f;
    }

    /* renamed from: a */
    public void mo22617a(C7028u uVar) {
        this.f13029n = uVar;
    }

    /* renamed from: a */
    public void mo18320a(C7251a aVar) {
        mo18321a(aVar, (String) null);
    }

    /* renamed from: a */
    public void mo18321a(C7251a aVar, String str) {
        C7262l lVar;
        String str2;
        C7212tb tbVar = new C7212tb(this.f13021f);
        if (mo22626i() && !tbVar.mo23269K()) {
            this.f13021f.mo23049b().mo22921e("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
        } else if (!C7209sc.m15479a(aVar, this.f13021f)) {
            m14437b(aVar);
        } else {
            Context j = m14438j();
            String str3 = "InterstitialAdDialogWrapper";
            if (j != null) {
                C7251a a = C7209sc.m15466a(aVar, (C7267q) this.f13021f);
                if (a != null) {
                    if (a instanceof C7234z) {
                        m14435a((C7234z) a, str, j);
                    } else {
                        if (!(a instanceof C7235za)) {
                            C7262l b = this.f13021f.mo23049b();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to show interstitial: unknown ad type provided: '");
                            sb.append(a);
                            sb.append("'");
                            b.mo22916b(str3, sb.toString());
                        } else if (j instanceof Activity) {
                            m14436a((C7235za) a, str, (Activity) j);
                        } else {
                            this.f13021f.mo23049b().mo22921e(str3, "Failed to show interstitial: Activity required.");
                        }
                        m14437b(a);
                    }
                }
                lVar = this.f13021f.mo23049b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to show ad: ");
                sb2.append(aVar);
                str2 = sb2.toString();
            } else {
                lVar = this.f13021f.mo23049b();
                str2 = "Failed to show interstitial: stale activity reference provided";
            }
            lVar.mo22916b(str3, str2);
            m14437b(aVar);
        }
    }

    /* renamed from: a */
    public void mo18322a(C7252b bVar) {
        this.f13026k = bVar;
        this.f13022g.mo23194a(bVar);
    }

    /* renamed from: a */
    public void mo18323a(C7253c cVar) {
        this.f13024i = cVar;
        this.f13022g.mo23195a(cVar);
    }

    /* renamed from: a */
    public void mo18324a(C7260j jVar) {
        this.f13025j = jVar;
    }

    /* renamed from: a */
    public void mo22618a(boolean z) {
        f13019d = z;
    }

    /* renamed from: b */
    public C7251a mo22619b() {
        return this.f13027l;
    }

    /* renamed from: c */
    public C7260j mo22620c() {
        return this.f13025j;
    }

    /* renamed from: d */
    public C7253c mo22621d() {
        return this.f13024i;
    }

    /* renamed from: e */
    public C7252b mo22622e() {
        return this.f13026k;
    }

    /* renamed from: f */
    public C7044B mo22623f() {
        return this.f13028m;
    }

    /* renamed from: g */
    public String mo22624g() {
        return this.f13030o;
    }

    /* renamed from: h */
    public void mo22625h() {
        f13017b = false;
        f13018c = true;
        f13016a.remove(this.f13020e);
    }

    /* renamed from: i */
    public boolean mo22626i() {
        return f13019d;
    }
}
