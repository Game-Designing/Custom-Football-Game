package com.smaato.soma.p239c.p246f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12066Oa;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12394h;
import com.smaato.soma.C12408ia;
import com.smaato.soma.exception.BannerHttpRequestFailed;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p242c.C12189b;
import com.smaato.soma.p239c.p242c.C12196i;
import com.smaato.soma.p239c.p246f.p249c.C12227j;
import com.smaato.soma.p239c.p246f.p249c.C12229k;
import com.smaato.soma.p239c.p252i.C12275a;
import com.smaato.soma.p256e.C12323A;
import com.smaato.soma.p256e.C12325B;
import com.smaato.soma.p256e.C12328D;
import com.smaato.soma.p256e.C12331a;
import com.smaato.soma.p256e.C12333c;
import com.smaato.soma.p256e.C12336e;
import com.smaato.soma.p256e.C12337f;
import com.smaato.soma.p256e.C12340h;
import com.smaato.soma.p256e.C12343j;
import com.smaato.soma.p256e.C12345k;
import com.smaato.soma.p256e.C12345k.C12346a;
import com.smaato.soma.p256e.C12348m;
import com.smaato.soma.p256e.C12351p;
import com.smaato.soma.p256e.C12351p.C12352a;
import com.smaato.soma.p256e.C12354r;
import com.smaato.soma.p256e.C12357u;
import com.smaato.soma.p256e.C12357u.C12358a;
import com.smaato.soma.p256e.C12360w;
import com.smaato.soma.p256e.C12362y;
import com.smaato.soma.p258g.C12389r;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.TreeMap;

/* renamed from: com.smaato.soma.c.f.k */
/* compiled from: AdDownloader */
public class C12239k implements C12322e, C12275a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Handler f38328a = new Handler(Looper.getMainLooper());

    /* renamed from: A */
    private TreeMap<Integer, C12360w> f38329A;

    /* renamed from: B */
    C12358a f38330B = new C12233e(this);

    /* renamed from: C */
    C12352a f38331C = new C12234f(this);

    /* renamed from: D */
    C12346a f38332D = new C12236h(this);

    /* renamed from: b */
    private C12340h f38333b;

    /* renamed from: c */
    private C12343j f38334c;

    /* renamed from: d */
    private C12348m f38335d;

    /* renamed from: e */
    private C12354r f38336e;

    /* renamed from: f */
    private C12337f f38337f;

    /* renamed from: g */
    private C12333c f38338g;

    /* renamed from: h */
    private C12336e f38339h;

    /* renamed from: i */
    private C12325B f38340i;

    /* renamed from: j */
    private C12328D f38341j;

    /* renamed from: k */
    private C12323A f38342k;

    /* renamed from: l */
    private C12362y f38343l;

    /* renamed from: m */
    private WeakReference<C12389r> f38344m;

    /* renamed from: n */
    private transient C12394h f38345n = new C12394h();

    /* renamed from: o */
    private transient C12229k f38346o = new C12229k();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f38347p = false;

    /* renamed from: q */
    private final C12189b f38348q = new C12189b();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final Context f38349r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final C12227j f38350s;

    /* renamed from: t */
    private final C12250u f38351t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final C12369fa f38352u;

    /* renamed from: v */
    private C12331a f38353v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C12196i f38354w;

    /* renamed from: x */
    private C12064Na f38355x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C12351p f38356y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C12360w f38357z = null;

    public C12239k(Context context, C12250u httpConnector, C12227j locationCollector, C12369fa baseView) {
        this.f38350s = locationCollector;
        C12252w.m40307b().mo39623a(context);
        this.f38351t = httpConnector;
        this.f38351t.mo39613a((C12275a) this);
        this.f38349r = context;
        this.f38352u = baseView;
    }

    /* renamed from: a */
    public void mo39603a(WeakReference<C12389r> nativeAdWeakReference) {
        this.f38344m = nativeAdWeakReference;
    }

    public void destroy() {
        try {
            if (this.f38350s != null) {
                this.f38350s.mo39573a();
            }
            this.f38355x = null;
            this.f38351t.mo39613a((C12275a) null);
            this.f38348q.mo39471a();
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final URL mo39599a(C12394h adSettings, C12229k userSettings, String subjectToGdpr, String consentString) {
        return C12252w.m40307b().mo39620a(adSettings, userSettings, this.f38350s, this.f38352u, subjectToGdpr, consentString);
    }

    /* renamed from: a */
    public final void mo39256a() {
        new C12211a(this).execute();
    }

    /* renamed from: a */
    public final boolean mo39604a(C12394h adSettings, C12229k userSettings) throws Exception {
        m40248a(userSettings);
        try {
            return this.f38351t.mo39614a(mo39599a(adSettings, userSettings, C12243o.m40289d(this.f38349r), C12243o.m40286b(this.f38349r)));
        } catch (Exception e) {
            C12146d.m39965a(new C12147e("SOMA", "Error occurred during AdDownloader:asyncLoadNewBanner()", 1, C12143a.DEBUG));
            throw e;
        }
    }

    public final C12394h getAdSettings() {
        return this.f38345n;
    }

    public final void setAdSettings(C12394h settings) {
        this.f38345n = settings;
    }

    /* renamed from: a */
    public final void mo39602a(C12367f adListener) {
        if (adListener != null) {
            this.f38348q.mo39473a(adListener);
            return;
        }
        throw new IllegalArgumentException("adListener must not be null");
    }

    public final C12229k getUserSettings() {
        return this.f38346o;
    }

    public void setUserSettings(C12229k userSettings) {
        this.f38346o = userSettings;
    }

    /* renamed from: a */
    public void mo39601a(C12196i mediationInterstitialAdDispatcher) {
        this.f38354w = mediationInterstitialAdDispatcher;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:153:0x036a, code lost:
        r5 = new java.lang.StringBuilder();
        r5.append("Exception happened with Mediation. Check configurations for ");
        r5.append(r4.mo39800h());
        com.smaato.soma.p238b.C12146d.m39965a(new com.smaato.soma.p238b.C12147e(r1, r5.toString(), 1, com.smaato.soma.p238b.C12143a.ERROR));
        mo39606c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x038e, code lost:
        r6 = new java.lang.StringBuilder();
        r6.append(r0);
        r6.append(r4.mo39800h());
        com.smaato.soma.p238b.C12146d.m39965a(new com.smaato.soma.p238b.C12147e(r1, r6.toString(), 1, com.smaato.soma.p238b.C12143a.ERROR));
        mo39606c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03b0, code lost:
        r6 = new java.lang.StringBuilder();
        r6.append(r0);
        r6.append(r4.mo39800h());
        com.smaato.soma.p238b.C12146d.m39965a(new com.smaato.soma.p238b.C12147e(r1, r6.toString(), 1, com.smaato.soma.p238b.C12143a.ERROR));
        mo39606c();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0369 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:23:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x038d A[ExcHandler: NoClassDefFoundError (e java.lang.NoClassDefFoundError), Splitter:B:23:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03af A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:23:0x00a1] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:141:0x0323=Splitter:B:141:0x0323, B:80:0x01b6=Splitter:B:80:0x01b6, B:101:0x0237=Splitter:B:101:0x0237, B:124:0x02d8=Splitter:B:124:0x02d8, B:64:0x014a=Splitter:B:64:0x014a, B:107:0x025e=Splitter:B:107:0x025e, B:110:0x026e=Splitter:B:110:0x026e, B:147:0x034f=Splitter:B:147:0x034f, B:150:0x035f=Splitter:B:150:0x035f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:141:0x0323=Splitter:B:141:0x0323, B:80:0x01b6=Splitter:B:80:0x01b6, B:101:0x0237=Splitter:B:101:0x0237, B:64:0x014a=Splitter:B:64:0x014a, B:127:0x02ec=Splitter:B:127:0x02ec, B:110:0x026e=Splitter:B:110:0x026e, B:150:0x035f=Splitter:B:150:0x035f} */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo39606c() {
        /*
            r12 = this;
            java.lang.String r0 = "NoClassDefFoundError happened with Mediation. Check configurations for "
            java.lang.String r1 = "SOMA"
            java.util.TreeMap<java.lang.Integer, com.smaato.soma.e.w> r2 = r12.f38329A
            r3 = 0
            if (r2 == 0) goto L_0x03d1
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x03d1
            java.util.TreeMap<java.lang.Integer, com.smaato.soma.e.w> r2 = r12.f38329A
            java.util.Map$Entry r2 = r2.firstEntry()
            java.lang.Object r2 = r2.getKey()
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.util.TreeMap<java.lang.Integer, com.smaato.soma.e.w> r4 = r12.f38329A
            java.util.Map$Entry r4 = r4.firstEntry()
            java.lang.Object r4 = r4.getValue()
            com.smaato.soma.e.w r4 = (com.smaato.soma.p256e.C12360w) r4
            java.util.TreeMap<java.lang.Integer, com.smaato.soma.e.w> r5 = r12.f38329A
            r5.remove(r2)
            com.smaato.soma.b.e r5 = new com.smaato.soma.b.e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r7 = " Priority => "
            r6.append(r7)
            java.lang.String r7 = r4.mo39800h()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.smaato.soma.b.a r7 = com.smaato.soma.p238b.C12143a.DEBUG
            r8 = 1
            java.lang.String r9 = "AdDowndloader_Med_Banner"
            r5.<init>(r9, r6, r8, r7)
            com.smaato.soma.p238b.C12146d.m39965a(r5)
            r12.f38357z = r4
            com.smaato.soma.fa r5 = r12.f38352u
            boolean r6 = r5 instanceof com.smaato.soma.C12042D
            if (r6 == 0) goto L_0x005e
            com.smaato.soma.e.a r5 = com.smaato.soma.p256e.C12331a.BANNER
            r12.f38353v = r5
            goto L_0x0094
        L_0x005e:
            boolean r5 = r5 instanceof com.smaato.soma.interstitial.C12428r
            if (r5 != 0) goto L_0x0090
            com.smaato.soma.h r5 = r12.getAdSettings()
            if (r5 == 0) goto L_0x0075
            com.smaato.soma.h r5 = r12.getAdSettings()
            com.smaato.soma.j r5 = r5.mo39885b()
            com.smaato.soma.j r6 = com.smaato.soma.C12431j.MULTI_AD_FORMAT_INTERSTITIAL
            if (r5 != r6) goto L_0x0075
            goto L_0x0090
        L_0x0075:
            com.smaato.soma.h r5 = r12.getAdSettings()
            if (r5 == 0) goto L_0x008c
            com.smaato.soma.h r5 = r12.getAdSettings()
            com.smaato.soma.j r5 = r5.mo39885b()
            com.smaato.soma.j r6 = com.smaato.soma.C12431j.NATIVE
            if (r5 != r6) goto L_0x008c
            com.smaato.soma.e.a r5 = com.smaato.soma.p256e.C12331a.NATIVE
            r12.f38353v = r5
            goto L_0x0094
        L_0x008c:
            r12.m40264f()
            return
        L_0x0090:
            com.smaato.soma.e.a r5 = com.smaato.soma.p256e.C12331a.INTERSTITIAL
            r12.f38353v = r5
        L_0x0094:
            com.smaato.soma.Na r5 = r12.f38355x
            com.smaato.soma.e.a r6 = r12.f38353v
            r5.mo39279a(r6)
            java.lang.String r5 = r4.mo39800h()
            if (r5 == 0) goto L_0x03d0
            java.lang.String r5 = r4.mo39800h()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r6 = -1
            int r7 = r5.hashCode()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r9 = 4
            r10 = 3
            r11 = 2
            switch(r7) {
                case -443504037: goto L_0x00d9;
                case -199077628: goto L_0x00cf;
                case -127757959: goto L_0x00c5;
                case 654750090: goto L_0x00bb;
                case 1123957943: goto L_0x00b1;
                default: goto L_0x00b0;
            }     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x00b0:
            goto L_0x00e3
        L_0x00b1:
            java.lang.String r7 = "MillennialMedia_CSM"
            boolean r5 = r5.equals(r7)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x00b0
            r5 = 3
            goto L_0x00e4
        L_0x00bb:
            java.lang.String r7 = "iAd_CSM"
            boolean r5 = r5.equals(r7)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x00b0
            r5 = 4
            goto L_0x00e4
        L_0x00c5:
            java.lang.String r7 = "MoPub_CSM"
            boolean r5 = r5.equals(r7)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x00b0
            r5 = 2
            goto L_0x00e4
        L_0x00cf:
            java.lang.String r7 = "Facebook_CSM"
            boolean r5 = r5.equals(r7)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x00b0
            r5 = 0
            goto L_0x00e4
        L_0x00d9:
            java.lang.String r7 = "AdMob_CSM"
            boolean r5 = r5.equals(r7)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x00b0
            r5 = 1
            goto L_0x00e4
        L_0x00e3:
            r5 = -1
        L_0x00e4:
            if (r5 == 0) goto L_0x02c2
            if (r5 == r8) goto L_0x0279
            if (r5 == r11) goto L_0x0212
            if (r5 == r10) goto L_0x01d3
            if (r5 == r9) goto L_0x01ce
            java.lang.String r3 = r4.mo39789c()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x01bd
            java.lang.String r3 = r4.mo39789c()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x0100
            goto L_0x01bd
        L_0x0100:
            com.smaato.soma.e.a r3 = r12.f38353v     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.a r5 = com.smaato.soma.p256e.C12331a.INTERSTITIAL     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 != r5) goto L_0x0177
            com.smaato.soma.e.r r3 = r12.f38336e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x011b
            com.smaato.soma.e.r r3 = r12.f38336e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p r3 = r3.mo39767b()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x011b
            com.smaato.soma.e.r r3 = r12.f38336e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p r3 = r3.mo39767b()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.m40252a(r3)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x011b:
            com.smaato.soma.e.s r3 = new com.smaato.soma.e.s     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r3.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r5 = new com.smaato.soma.interstitial.r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>(r6)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            java.lang.String r6 = r4.mo39789c()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r7 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.r r3 = r3.mo39772a(r5, r6, r4, r7)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38336e = r3     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.fa r3 = r12.f38352u     // Catch:{ NoClassDefFoundError -> 0x0148, Exception -> 0x0146 }
            com.smaato.soma.interstitial.r r3 = (com.smaato.soma.interstitial.C12428r) r3     // Catch:{ NoClassDefFoundError -> 0x0148, Exception -> 0x0146 }
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ NoClassDefFoundError -> 0x0148, Exception -> 0x0146 }
            com.smaato.soma.e.r r6 = r12.f38336e     // Catch:{ NoClassDefFoundError -> 0x0148, Exception -> 0x0146 }
            com.smaato.soma.e.p r6 = r6.mo39767b()     // Catch:{ NoClassDefFoundError -> 0x0148, Exception -> 0x0146 }
            r5.<init>(r6)     // Catch:{ NoClassDefFoundError -> 0x0148, Exception -> 0x0146 }
            r3.setCustomMediationReference(r5)     // Catch:{ NoClassDefFoundError -> 0x0148, Exception -> 0x0146 }
            goto L_0x0149
        L_0x0146:
            r3 = move-exception
            goto L_0x014a
        L_0x0148:
            r3 = move-exception
        L_0x0149:
        L_0x014a:
            com.smaato.soma.fa r3 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r3 = (com.smaato.soma.interstitial.C12428r) r3     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.l r3 = r3.getInterstitialParent()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r5 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r3.mo39914a(r5)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.r r3 = r12.f38336e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x0172
            com.smaato.soma.e.r r3 = r12.f38336e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p r3 = r3.mo39767b()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x0172
            com.smaato.soma.e.r r3 = r12.f38336e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p r3 = r3.mo39767b()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38356y = r3     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.r r3 = r12.f38336e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r3.mo39771f()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x0172:
            r12.mo39606c()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x0177:
            com.smaato.soma.e.m r3 = r12.f38335d     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x018c
            com.smaato.soma.e.m r3 = r12.f38335d     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.k r3 = r3.mo39759a()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r3 == 0) goto L_0x018c
            com.smaato.soma.e.m r3 = r12.f38335d     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.k r3 = r3.mo39759a()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.m40252a(r3)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x018c:
            com.smaato.soma.e.n r3 = new com.smaato.soma.e.n     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r3.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            java.lang.String r6 = r4.mo39789c()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.k$a r7 = r12.f38332D     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.m r3 = r3.mo39763a(r5, r6, r4, r7)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38335d = r3     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.fa r3 = r12.f38352u     // Catch:{ NoClassDefFoundError -> 0x01b4, Exception -> 0x01b2 }
            com.smaato.soma.D r3 = (com.smaato.soma.C12042D) r3     // Catch:{ NoClassDefFoundError -> 0x01b4, Exception -> 0x01b2 }
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ NoClassDefFoundError -> 0x01b4, Exception -> 0x01b2 }
            com.smaato.soma.e.m r6 = r12.f38335d     // Catch:{ NoClassDefFoundError -> 0x01b4, Exception -> 0x01b2 }
            com.smaato.soma.e.k r6 = r6.mo39759a()     // Catch:{ NoClassDefFoundError -> 0x01b4, Exception -> 0x01b2 }
            r5.<init>(r6)     // Catch:{ NoClassDefFoundError -> 0x01b4, Exception -> 0x01b2 }
            r3.setCustomMediationReference(r5)     // Catch:{ NoClassDefFoundError -> 0x01b4, Exception -> 0x01b2 }
            goto L_0x01b5
        L_0x01b2:
            r3 = move-exception
            goto L_0x01b6
        L_0x01b4:
            r3 = move-exception
        L_0x01b5:
        L_0x01b6:
            com.smaato.soma.e.m r3 = r12.f38335d     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r3.mo39762d()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x01bd:
            com.smaato.soma.b.e r3 = new com.smaato.soma.b.e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            java.lang.String r5 = "Mediation Network Class Name is empty"
            com.smaato.soma.b.a r6 = com.smaato.soma.p238b.C12143a.ERROR     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r3.<init>(r1, r5, r8, r6)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.p238b.C12146d.m39965a(r3)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.mo39606c()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x01ce:
            r12.mo39606c()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x01d3:
            com.smaato.soma.e.a r5 = r12.f38353v     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.a r6 = com.smaato.soma.p256e.C12331a.INTERSTITIAL     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != r6) goto L_0x0200
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x01ea
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r5 = (com.smaato.soma.interstitial.C12428r) r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.l r5 = r5.getInterstitialParent()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r6 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39914a(r6)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x01ea:
            com.smaato.soma.e.A r5 = new com.smaato.soma.e.A     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38342k = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.A r5 = r12.f38342k     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38356y = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.A r5 = r12.f38342k     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r7 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39738a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x0200:
            com.smaato.soma.e.y r5 = new com.smaato.soma.e.y     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38343l = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.y r5 = r12.f38343l     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.k$a r7 = r12.f38332D     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39804a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x0212:
            com.smaato.soma.e.a r5 = r12.f38353v     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.a r6 = com.smaato.soma.p256e.C12331a.INTERSTITIAL     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != r6) goto L_0x0253
            com.smaato.soma.e.D r5 = r12.f38341j     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != 0) goto L_0x0223
            com.smaato.soma.e.D r5 = new com.smaato.soma.e.D     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38341j = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x0223:
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x0244
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ NoClassDefFoundError -> 0x0236, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r5 = (com.smaato.soma.interstitial.C12428r) r5     // Catch:{ NoClassDefFoundError -> 0x0236, RuntimeException -> 0x03af, Exception -> 0x0369 }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ NoClassDefFoundError -> 0x0236, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.e.D r7 = r12.f38341j     // Catch:{ NoClassDefFoundError -> 0x0236, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r6.<init>(r7)     // Catch:{ NoClassDefFoundError -> 0x0236, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r5.setMediationReference(r6)     // Catch:{ NoClassDefFoundError -> 0x0236, RuntimeException -> 0x03af, Exception -> 0x0369 }
            goto L_0x0237
        L_0x0236:
            r5 = move-exception
        L_0x0237:
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r5 = (com.smaato.soma.interstitial.C12428r) r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.l r5 = r5.getInterstitialParent()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r6 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39914a(r6)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x0244:
            com.smaato.soma.e.D r5 = r12.f38341j     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38356y = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.D r5 = r12.f38341j     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r7 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39744a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x0253:
            com.smaato.soma.e.B r5 = r12.f38340i     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != 0) goto L_0x025e
            com.smaato.soma.e.B r5 = new com.smaato.soma.e.B     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38340i = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x025e:
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ NoClassDefFoundError -> 0x026d, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.D r5 = (com.smaato.soma.C12042D) r5     // Catch:{ NoClassDefFoundError -> 0x026d, RuntimeException -> 0x03af, Exception -> 0x0369 }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ NoClassDefFoundError -> 0x026d, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.e.B r7 = r12.f38340i     // Catch:{ NoClassDefFoundError -> 0x026d, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r6.<init>(r7)     // Catch:{ NoClassDefFoundError -> 0x026d, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r5.setMediationReference(r6)     // Catch:{ NoClassDefFoundError -> 0x026d, RuntimeException -> 0x03af, Exception -> 0x0369 }
            goto L_0x026e
        L_0x026d:
            r5 = move-exception
        L_0x026e:
            com.smaato.soma.e.B r5 = r12.f38340i     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.k$a r7 = r12.f38332D     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39741a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x0279:
            com.smaato.soma.e.a r5 = r12.f38353v     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.a r6 = com.smaato.soma.p256e.C12331a.INTERSTITIAL     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != r6) goto L_0x02ab
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x0290
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r5 = (com.smaato.soma.interstitial.C12428r) r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.l r5 = r5.getInterstitialParent()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r6 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39914a(r6)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x0290:
            com.smaato.soma.e.j r5 = r12.f38334c     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.m40252a(r5)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.j r5 = new com.smaato.soma.e.j     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38334c = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.j r5 = r12.f38334c     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38356y = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.j r5 = r12.f38334c     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r7 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39757a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x02ab:
            com.smaato.soma.e.h r5 = r12.f38333b     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.m40252a(r5)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.h r5 = new com.smaato.soma.e.h     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38333b = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.h r5 = r12.f38333b     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.k$a r7 = r12.f38332D     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39755a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x02c2:
            com.smaato.soma.e.a r5 = r12.f38353v     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.a r6 = com.smaato.soma.p256e.C12331a.NATIVE     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != r6) goto L_0x02f9
            com.smaato.soma.e.f r5 = r12.f38337f     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.m40252a(r5)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.f r5 = r12.f38337f     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != 0) goto L_0x02d8
            com.smaato.soma.e.f r5 = new com.smaato.soma.e.f     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38337f = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x02d8:
            java.lang.ref.WeakReference<com.smaato.soma.g.r> r5 = r12.f38344m     // Catch:{ NoClassDefFoundError -> 0x02eb, RuntimeException -> 0x03af, Exception -> 0x0369 }
            java.lang.Object r5 = r5.get()     // Catch:{ NoClassDefFoundError -> 0x02eb, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.g.r r5 = (com.smaato.soma.p258g.C12389r) r5     // Catch:{ NoClassDefFoundError -> 0x02eb, RuntimeException -> 0x03af, Exception -> 0x0369 }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ NoClassDefFoundError -> 0x02eb, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.e.f r7 = r12.f38337f     // Catch:{ NoClassDefFoundError -> 0x02eb, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r6.<init>(r7)     // Catch:{ NoClassDefFoundError -> 0x02eb, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r5.mo39864a(r6)     // Catch:{ NoClassDefFoundError -> 0x02eb, RuntimeException -> 0x03af, Exception -> 0x0369 }
            goto L_0x02ec
        L_0x02eb:
            r5 = move-exception
        L_0x02ec:
            com.smaato.soma.e.f r5 = r12.f38337f     // Catch:{ Exception -> 0x02f6, NoClassDefFoundError -> 0x038d }
            android.content.Context r6 = r12.f38349r     // Catch:{ Exception -> 0x02f6, NoClassDefFoundError -> 0x038d }
            com.smaato.soma.e.u$a r7 = r12.f38330B     // Catch:{ Exception -> 0x02f6, NoClassDefFoundError -> 0x038d }
            r5.mo39750a(r6, r7, r3, r4)     // Catch:{ Exception -> 0x02f6, NoClassDefFoundError -> 0x038d }
            goto L_0x02f7
        L_0x02f6:
            r0 = move-exception
        L_0x02f7:
            goto L_0x03d0
        L_0x02f9:
            com.smaato.soma.e.a r5 = r12.f38353v     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.a r6 = com.smaato.soma.p256e.C12331a.INTERSTITIAL     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != r6) goto L_0x033f
            com.smaato.soma.e.e r5 = r12.f38339h     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.m40252a(r5)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.e r5 = r12.f38339h     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != 0) goto L_0x030f
            com.smaato.soma.e.e r5 = new com.smaato.soma.e.e     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38339h = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x030f:
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 == 0) goto L_0x0330
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ NoClassDefFoundError -> 0x0322, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r5 = (com.smaato.soma.interstitial.C12428r) r5     // Catch:{ NoClassDefFoundError -> 0x0322, RuntimeException -> 0x03af, Exception -> 0x0369 }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ NoClassDefFoundError -> 0x0322, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.e.e r7 = r12.f38339h     // Catch:{ NoClassDefFoundError -> 0x0322, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r6.<init>(r7)     // Catch:{ NoClassDefFoundError -> 0x0322, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r5.setMediationReference(r6)     // Catch:{ NoClassDefFoundError -> 0x0322, RuntimeException -> 0x03af, Exception -> 0x0369 }
            goto L_0x0323
        L_0x0322:
            r5 = move-exception
        L_0x0323:
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.r r5 = (com.smaato.soma.interstitial.C12428r) r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.interstitial.l r5 = r5.getInterstitialParent()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r6 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39914a(r6)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x0330:
            com.smaato.soma.e.e r5 = r12.f38339h     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38356y = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.e r5 = r12.f38339h     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.p$a r7 = r12.f38331C     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39748a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x033f:
            com.smaato.soma.e.c r5 = r12.f38338g     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.m40252a(r5)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.c r5 = r12.f38338g     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            if (r5 != 0) goto L_0x034f
            com.smaato.soma.e.c r5 = new com.smaato.soma.e.c     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r12.f38338g = r5     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
        L_0x034f:
            com.smaato.soma.fa r5 = r12.f38352u     // Catch:{ NoClassDefFoundError -> 0x035e, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.D r5 = (com.smaato.soma.C12042D) r5     // Catch:{ NoClassDefFoundError -> 0x035e, RuntimeException -> 0x03af, Exception -> 0x0369 }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ NoClassDefFoundError -> 0x035e, RuntimeException -> 0x03af, Exception -> 0x0369 }
            com.smaato.soma.e.c r7 = r12.f38338g     // Catch:{ NoClassDefFoundError -> 0x035e, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r6.<init>(r7)     // Catch:{ NoClassDefFoundError -> 0x035e, RuntimeException -> 0x03af, Exception -> 0x0369 }
            r5.setMediationReference(r6)     // Catch:{ NoClassDefFoundError -> 0x035e, RuntimeException -> 0x03af, Exception -> 0x0369 }
            goto L_0x035f
        L_0x035e:
            r5 = move-exception
        L_0x035f:
            com.smaato.soma.e.c r5 = r12.f38338g     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            android.content.Context r6 = r12.f38349r     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            com.smaato.soma.e.k$a r7 = r12.f38332D     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            r5.mo39746a(r6, r7, r3, r4)     // Catch:{ RuntimeException -> 0x03af, NoClassDefFoundError -> 0x038d, Exception -> 0x0369 }
            goto L_0x03d0
        L_0x0369:
            r0 = move-exception
            com.smaato.soma.b.e r3 = new com.smaato.soma.b.e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Exception happened with Mediation. Check configurations for "
            r5.append(r6)
            java.lang.String r6 = r4.mo39800h()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.smaato.soma.b.a r6 = com.smaato.soma.p238b.C12143a.ERROR
            r3.<init>(r1, r5, r8, r6)
            com.smaato.soma.p238b.C12146d.m39965a(r3)
            r12.mo39606c()
            goto L_0x03d0
        L_0x038d:
            r3 = move-exception
            com.smaato.soma.b.e r5 = new com.smaato.soma.b.e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = r4.mo39800h()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.smaato.soma.b.a r6 = com.smaato.soma.p238b.C12143a.ERROR
            r5.<init>(r1, r0, r8, r6)
            com.smaato.soma.p238b.C12146d.m39965a(r5)
            r12.mo39606c()
            goto L_0x03d0
        L_0x03af:
            r3 = move-exception
            com.smaato.soma.b.e r5 = new com.smaato.soma.b.e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = r4.mo39800h()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.smaato.soma.b.a r6 = com.smaato.soma.p238b.C12143a.ERROR
            r5.<init>(r1, r0, r8, r6)
            com.smaato.soma.p238b.C12146d.m39965a(r5)
            r12.mo39606c()
        L_0x03d0:
            goto L_0x03e0
        L_0x03d1:
            boolean r0 = r12.m40260d()
            if (r0 == 0) goto L_0x03dd
            com.smaato.soma.Na r0 = r12.f38355x
            r0.mo39281a(r3)
            goto L_0x03e0
        L_0x03dd:
            r12.m40264f()
        L_0x03e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p239c.p246f.C12239k.mo39606c():void");
    }

    /* renamed from: a */
    private void m40248a(C12229k userSettings) {
        if (!C12066Oa.m39873b()) {
            f38328a.post(new C12216c(this, userSettings));
        }
    }

    /* renamed from: d */
    private boolean m40260d() {
        String str = "SOMA";
        C12064Na na = this.f38355x;
        if (na == null || TextUtils.isEmpty(na.mo39294i())) {
            return false;
        }
        try {
            this.f38351t.mo39614a(new URL(this.f38355x.mo39294i()));
            return true;
        } catch (BannerHttpRequestFailed e) {
            C12146d.m39965a(new C12147e(str, "BannerHttpRequestFailed @SOMA", 1, C12143a.DEBUG));
            return false;
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "MalformedURL PassBack URL?", 1, C12143a.DEBUG));
            return false;
        }
    }

    /* renamed from: f */
    private void m40264f() {
        C12146d.m39965a(new C12147e("SOMA", "Exiting through AdDownloader:exitMediationNetworkWithError()", 1, C12143a.DEBUG));
        m40266g();
        m40262e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40251a(C12331a format) {
        C12064Na na = this.f38355x;
        if (na != null) {
            na.mo39280a(C12408ia.NO_ERROR);
            this.f38355x.mo39278a(C12111b.f37994b);
            this.f38355x.mo39283a(true);
            this.f38355x.mo39279a(format);
        }
    }

    /* renamed from: g */
    private void m40266g() {
        C12064Na na = this.f38355x;
        if (na != null) {
            na.mo39280a(C12408ia.NO_AD_AVAILABLE);
            this.f38355x.mo39278a(C12111b.f37995c);
            this.f38355x.mo39283a(false);
            this.f38355x.mo39279a(C12331a.UNDEFINED);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m40262e() {
        String str = "SOMA";
        try {
            C12146d.m39965a(new C12147e(str, "Exiting through AdDownloader:exitMediationNetwork()", 1, C12143a.DEBUG));
            this.f38329A = null;
            if (this.f38355x != null) {
                this.f38355x.mo39281a((String) null);
                this.f38355x.mo39282a(null);
                this.f38348q.mo39472a(this, this.f38355x);
            }
        } catch (Exception e) {
            C12146d.m39965a(new C12147e(str, "Exception occured in AdDownloader:exitMediationNetwork()", 1, C12143a.DEBUG));
        }
    }

    /* renamed from: a */
    public final void mo39600a(C12064Na banner) {
        C12146d.m39966a((Object) new C12232d(this));
        String str = "SOMA";
        if (banner == null) {
            C12146d.m39965a(new C12147e(str, "No Banner Received !!", 1, C12143a.WARNING));
            return;
        }
        if (banner.mo39277a() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(banner.mo39277a());
            sb.append(" ErrorCode:");
            sb.append(banner.mo39290g());
            C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
        }
        C12146d.m39965a(new C12147e(str, "Banner download complete", 1, C12143a.DEBUG));
        if (this.f38349r == null || !m40257b(banner)) {
            this.f38348q.mo39472a(this, banner);
        } else {
            this.f38329A = banner.mo39299n();
            this.f38355x = banner;
            mo39606c();
        }
    }

    /* renamed from: b */
    private static boolean m40257b(C12064Na banner) {
        return (banner.mo39299n() != null && banner.mo39299n().size() > 0) || banner.mo39294i() != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40253a(String tag, String message) {
        C12146d.m39965a(new C12147e(tag, message, 1, C12143a.DEBUG));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo39605a(String stringURLs) {
        boolean executionSuccess = false;
        if (stringURLs == null) {
            return false;
        }
        if (stringURLs != null) {
            try {
                if (!stringURLs.isEmpty()) {
                    new C12242n(this.f38345n, this.f38355x).execute(new String[]{stringURLs});
                    executionSuccess = true;
                }
            } catch (RuntimeException e) {
            } catch (Exception e2) {
                C12146d.m39965a(new C12147e("SOMA", "Error during firing Mediation URL", 1, C12143a.ERROR));
            }
        }
        return executionSuccess;
    }

    /* renamed from: a */
    private void m40252a(Object mediationEventRef) {
        if (mediationEventRef != null) {
            try {
                if (mediationEventRef instanceof C12357u) {
                    ((C12357u) mediationEventRef).mo39749a();
                }
                if (mediationEventRef instanceof C12345k) {
                    ((C12345k) mediationEventRef).mo39740a();
                }
                if (mediationEventRef instanceof C12351p) {
                    ((C12351p) mediationEventRef).mo39737a();
                }
            } catch (Exception | NoClassDefFoundError | RuntimeException e) {
            }
        }
    }

    public final void setLocationUpdateEnabled(boolean isLocationUpdate) {
        C12146d.m39966a((Object) new C12237i(this));
        new C12238j(this, isLocationUpdate).execute();
    }
}
