package p019d.p273h.p276c;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.unity3d.ads.BuildConfig;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p278b.C12784h;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12814f;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12864c;
import p019d.p273h.p276c.p284h.C12908c;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.l */
/* compiled from: BannerManager */
public class C12927l implements C12864c {

    /* renamed from: a */
    private C12932n f39771a;

    /* renamed from: b */
    private C12745G f39772b;

    /* renamed from: c */
    private C12814f f39773c;

    /* renamed from: d */
    private C12928a f39774d = C12928a.NOT_INITIATED;

    /* renamed from: e */
    private C12802d f39775e = C12802d.m41613c();

    /* renamed from: f */
    private String f39776f;

    /* renamed from: g */
    private String f39777g;

    /* renamed from: h */
    private Activity f39778h;

    /* renamed from: i */
    private final CopyOnWriteArrayList<C12932n> f39779i = new CopyOnWriteArrayList<>();

    /* renamed from: j */
    private long f39780j;

    /* renamed from: k */
    private Timer f39781k;

    /* renamed from: l */
    private Boolean f39782l = Boolean.valueOf(true);

    /* renamed from: m */
    AtomicBoolean f39783m = new AtomicBoolean();

    /* renamed from: n */
    AtomicBoolean f39784n = new AtomicBoolean();

    /* renamed from: d.h.c.l$a */
    /* compiled from: BannerManager */
    private enum C12928a {
        NOT_INITIATED,
        READY_TO_LOAD,
        FIRST_LOAD_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        RELOAD_IN_PROGRESS
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        r1 = th;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41714a(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.n> r0 = r3.f39779i     // Catch:{ all -> 0x0022 }
            monitor-enter(r0)     // Catch:{ all -> 0x0022 }
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.n> r1 = r3.f39779i     // Catch:{ all -> 0x001d }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x001d }
        L_0x000a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x001d }
            if (r2 == 0) goto L_0x001a
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x001d }
            d.h.c.n r2 = (p019d.p273h.p276c.C12932n) r2     // Catch:{ all -> 0x001d }
            r2.mo41726a(r4)     // Catch:{ all -> 0x001d }
            goto L_0x000a
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            monitor-exit(r3)
            return
        L_0x001d:
            r1 = move-exception
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r1     // Catch:{ all -> 0x0022 }
        L_0x0020:
            r1 = move-exception
            goto L_0x001e
        L_0x0022:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0026
        L_0x0025:
            throw r4
        L_0x0026:
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12927l.mo41714a(boolean):void");
    }

    /* renamed from: a */
    public synchronized void mo41713a(List<C12826q> adaptersConfigs, Activity activity, String appKey, String userId, long timeout, int reloadInterval) {
        String str = appKey;
        String str2 = userId;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("initBannerManager(appKey: ");
            sb.append(str);
            sb.append(", userId: ");
            sb.append(str2);
            sb.append(")");
            m42028a(sb.toString());
            this.f39776f = str;
            this.f39777g = str2;
            this.f39778h = activity;
            this.f39780j = (long) reloadInterval;
            for (int i = 0; i < adaptersConfigs.size(); i++) {
                C12826q config = (C12826q) adaptersConfigs.get(i);
                C12775b adapter = m42020a(config);
                if (adapter == null || !C12808e.m41634a().mo41451b(adapter)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(config.mo41550g());
                    sb2.append(" can't load adapter or wrong version");
                    m42028a(sb2.toString());
                } else {
                    C12932n nVar = new C12932n(this, config, adapter, timeout, i + 1);
                    this.f39779i.add(nVar);
                }
            }
            List<C12826q> list = adaptersConfigs;
            this.f39773c = null;
            m42026a(C12928a.READY_TO_LOAD);
        }
    }

    /* renamed from: a */
    public synchronized void mo41712a(C12745G banner, C12814f placement) {
        try {
            if (this.f39774d == C12928a.READY_TO_LOAD) {
                if (!C12923j.m42015a().mo41707b()) {
                    m42026a(C12928a.FIRST_LOAD_IN_PROGRESS);
                    this.f39772b = banner;
                    this.f39773c = placement;
                    m42022a((int) BuildConfig.VERSION_CODE);
                    if (C12908c.m41897b((Context) this.f39778h, placement.mo41496c())) {
                        C12923j a = C12923j.m42015a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("placement ");
                        sb.append(placement.mo41496c());
                        sb.append(" is capped");
                        a.mo41706a(banner, new C12799b(604, sb.toString()));
                        m42025a(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf(604)}});
                        m42026a(C12928a.READY_TO_LOAD);
                        return;
                    }
                    synchronized (this.f39779i) {
                        Iterator it = this.f39779i.iterator();
                        while (it.hasNext()) {
                            ((C12932n) it.next()).mo41729b(true);
                        }
                        C12932n smash = (C12932n) this.f39779i.get(0);
                        m42023a(3002, smash);
                        smash.mo41725a(banner, this.f39778h, this.f39776f, this.f39777g);
                    }
                }
            }
            this.f39775e.mo41427b(C12801a.API, "A banner is already loaded", 3);
            return;
        } catch (Exception e) {
            C12923j a2 = C12923j.m42015a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadBanner() failed ");
            sb2.append(e.getMessage());
            a2.mo41706a(banner, new C12799b(605, sb2.toString()));
            String message = e.getMessage();
            m42025a(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf(605)}, new Object[]{"reason", message.substring(0, Math.min(message.length(), 39))}});
            m42026a(C12928a.READY_TO_LOAD);
        }
    }

    /* renamed from: b */
    private void m42034b(String text) {
        C12802d dVar = this.f39775e;
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append("BannerManager ");
        sb.append(text);
        dVar.mo41427b(aVar, sb.toString(), 3);
    }

    /* renamed from: a */
    private void m42028a(String text) {
        C12802d dVar = this.f39775e;
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append("BannerManager ");
        sb.append(text);
        dVar.mo41427b(aVar, sb.toString(), 0);
    }

    /* renamed from: a */
    private void m42026a(C12928a state) {
        this.f39774d = state;
        StringBuilder sb = new StringBuilder();
        sb.append("state=");
        sb.append(state.name());
        m42028a(sb.toString());
    }

    /* renamed from: a */
    private void m42029a(String text, C12932n smash) {
        C12802d dVar = this.f39775e;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("BannerManager ");
        sb.append(text);
        sb.append(" ");
        sb.append(smash.mo41731d());
        dVar.mo41427b(aVar, sb.toString(), 0);
    }

    /* renamed from: b */
    private void m42033b(C12932n smash, View adView, LayoutParams frameLayoutParams) {
        this.f39771a = smash;
        this.f39772b.mo41191a(adView, frameLayoutParams);
    }

    /* renamed from: a */
    public void mo41633a(C12932n smash, View adView, LayoutParams frameLayoutParams) {
        m42029a("onBannerAdLoaded", smash);
        C12928a aVar = this.f39774d;
        if (aVar == C12928a.FIRST_LOAD_IN_PROGRESS) {
            m42023a(3005, smash);
            m42033b(smash, adView, frameLayoutParams);
            C12908c.m41891a((Context) this.f39778h, this.f39773c.mo41496c());
            if (C12908c.m41897b((Context) this.f39778h, this.f39773c.mo41496c())) {
                m42022a(3400);
            }
            this.f39772b.mo41193a(smash);
            m42022a(3110);
            m42026a(C12928a.RELOAD_IN_PROGRESS);
            m42036d();
        } else if (aVar == C12928a.LOAD_IN_PROGRESS) {
            m42023a(3015, smash);
            m42033b(smash, adView, frameLayoutParams);
            m42026a(C12928a.RELOAD_IN_PROGRESS);
            m42036d();
        }
    }

    /* renamed from: a */
    public void mo41631a(C12799b error, C12932n smash, boolean isNoFillError) {
        StringBuilder sb = new StringBuilder();
        String str = "onBannerAdLoadFailed ";
        sb.append(str);
        sb.append(error.mo41429b());
        m42029a(sb.toString(), smash);
        C12928a aVar = this.f39774d;
        if (aVar == C12928a.FIRST_LOAD_IN_PROGRESS || aVar == C12928a.LOAD_IN_PROGRESS) {
            String str2 = "errorCode";
            if (isNoFillError) {
                m42023a(3306, smash);
            } else {
                m42024a(3300, smash, new Object[][]{new Object[]{str2, Integer.valueOf(error.mo41428a())}});
            }
            if (!m42031a()) {
                if (this.f39774d == C12928a.FIRST_LOAD_IN_PROGRESS) {
                    C12923j.m42015a().mo41706a(this.f39772b, new C12799b(606, "No ads to show"));
                    m42025a(3111, new Object[][]{new Object[]{str2, Integer.valueOf(606)}});
                    m42026a(C12928a.READY_TO_LOAD);
                } else {
                    m42022a(3201);
                    m42026a(C12928a.RELOAD_IN_PROGRESS);
                    m42036d();
                }
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(smash.mo41731d());
        sb2.append(" wrong state=");
        sb2.append(this.f39774d.name());
        m42028a(sb2.toString());
    }

    /* renamed from: a */
    public void mo41632a(C12932n smash) {
        m42029a("onBannerAdReloaded", smash);
        if (this.f39774d != C12928a.RELOAD_IN_PROGRESS) {
            StringBuilder sb = new StringBuilder();
            sb.append("onBannerAdReloaded ");
            sb.append(smash.mo41731d());
            sb.append(" wrong state=");
            sb.append(this.f39774d.name());
            m42028a(sb.toString());
            return;
        }
        C12916j.m41981c("bannerReloadSucceeded");
        m42023a(3015, smash);
        m42036d();
    }

    /* renamed from: b */
    public void mo41634b(C12799b error, C12932n smash, boolean isNoFillError) {
        StringBuilder sb = new StringBuilder();
        sb.append("onBannerAdReloadFailed ");
        sb.append(error.mo41429b());
        m42029a(sb.toString(), smash);
        if (this.f39774d != C12928a.RELOAD_IN_PROGRESS) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onBannerAdReloadFailed ");
            sb2.append(smash.mo41731d());
            sb2.append(" wrong state=");
            sb2.append(this.f39774d.name());
            m42028a(sb2.toString());
            return;
        }
        if (isNoFillError) {
            m42023a(3307, smash);
        } else {
            m42024a(3301, smash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(error.mo41428a())}});
        }
        synchronized (this.f39779i) {
            if (this.f39779i.size() == 1) {
                m42022a(3201);
                m42036d();
            }
        }
        m42026a(C12928a.LOAD_IN_PROGRESS);
        m42035c();
        m42031a();
    }

    /* renamed from: b */
    public void mo41635b(C12932n smash) {
        m42029a("onBannerAdClicked", smash);
        m42022a(3112);
        this.f39772b.mo41190a();
        m42023a(3008, smash);
    }

    /* renamed from: a */
    private void m42022a(int eventId) {
        m42025a(eventId, (Object[][]) null);
    }

    /* renamed from: a */
    private void m42025a(int eventId, Object[][] keyVals) {
        JSONObject data = C12916j.m41965a(false);
        try {
            if (this.f39772b != null) {
                m42030a(data, this.f39772b.getSize());
            }
            if (this.f39773c != null) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39773c.mo41496c());
            }
            if (keyVals != null) {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            }
        } catch (Exception e) {
            C12802d dVar = this.f39775e;
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append("sendMediationEvent ");
            sb.append(Log.getStackTraceString(e));
            dVar.mo41427b(aVar, sb.toString(), 3);
        }
        C12784h.m41502g().mo41369d(new C12733b(eventId, data));
    }

    /* renamed from: a */
    private void m42023a(int eventId, C12932n smash) {
        m42024a(eventId, smash, (Object[][]) null);
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m42030a(org.json.JSONObject r8, p019d.p273h.p276c.C12939q r9) {
        /*
            r7 = this;
            r0 = 3
            java.lang.String r1 = r9.mo41758a()     // Catch:{ Exception -> 0x0089 }
            r2 = -1
            int r3 = r1.hashCode()     // Catch:{ Exception -> 0x0089 }
            r4 = 4
            r5 = 2
            r6 = 1
            switch(r3) {
                case -387072689: goto L_0x0039;
                case 72205083: goto L_0x002f;
                case 79011241: goto L_0x0025;
                case 1951953708: goto L_0x001b;
                case 1999208305: goto L_0x0011;
                default: goto L_0x0010;
            }     // Catch:{ Exception -> 0x0089 }
        L_0x0010:
            goto L_0x0043
        L_0x0011:
            java.lang.String r3 = "CUSTOM"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x0010
            r1 = 4
            goto L_0x0044
        L_0x001b:
            java.lang.String r3 = "BANNER"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x0010
            r1 = 0
            goto L_0x0044
        L_0x0025:
            java.lang.String r3 = "SMART"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x0010
            r1 = 3
            goto L_0x0044
        L_0x002f:
            java.lang.String r3 = "LARGE"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x0010
            r1 = 1
            goto L_0x0044
        L_0x0039:
            java.lang.String r3 = "RECTANGLE"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x0010
            r1 = 2
            goto L_0x0044
        L_0x0043:
            r1 = -1
        L_0x0044:
            java.lang.String r2 = "bannerAdSize"
            if (r1 == 0) goto L_0x0084
            if (r1 == r6) goto L_0x0080
            if (r1 == r5) goto L_0x007c
            if (r1 == r0) goto L_0x0077
            if (r1 == r4) goto L_0x0051
            goto L_0x0088
        L_0x0051:
            r1 = 6
            r8.put(r2, r1)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = "custom_banner_size"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089 }
            r2.<init>()     // Catch:{ Exception -> 0x0089 }
            int r3 = r9.mo41760c()     // Catch:{ Exception -> 0x0089 }
            r2.append(r3)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ Exception -> 0x0089 }
            int r3 = r9.mo41759b()     // Catch:{ Exception -> 0x0089 }
            r2.append(r3)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0089 }
            r8.put(r1, r2)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0088
        L_0x0077:
            r1 = 5
            r8.put(r2, r1)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0088
        L_0x007c:
            r8.put(r2, r0)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0088
        L_0x0080:
            r8.put(r2, r5)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0088
        L_0x0084:
            r8.put(r2, r6)     // Catch:{ Exception -> 0x0089 }
        L_0x0088:
            goto L_0x00a6
        L_0x0089:
            r1 = move-exception
            d.h.c.d.d r2 = r7.f39775e
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "sendProviderEvent "
            r4.append(r5)
            java.lang.String r5 = android.util.Log.getStackTraceString(r1)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.mo41427b(r3, r4, r0)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12927l.m42030a(org.json.JSONObject, d.h.c.q):void");
    }

    /* renamed from: a */
    private void m42024a(int eventId, C12932n smash, Object[][] keyVals) {
        JSONObject data = C12916j.m41963a(smash);
        try {
            if (this.f39772b != null) {
                m42030a(data, this.f39772b.getSize());
            }
            if (this.f39773c != null) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39773c.mo41496c());
            }
            if (keyVals != null) {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            }
        } catch (Exception e) {
            C12802d dVar = this.f39775e;
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append("sendProviderEvent ");
            sb.append(Log.getStackTraceString(e));
            dVar.mo41427b(aVar, sb.toString(), 3);
        }
        C12784h.m41502g().mo41369d(new C12733b(eventId, data));
    }

    /* renamed from: c */
    private void m42035c() {
        synchronized (this.f39779i) {
            Iterator it = this.f39779i.iterator();
            while (it.hasNext()) {
                ((C12932n) it.next()).mo41729b(true);
            }
        }
    }

    /* renamed from: a */
    private boolean m42031a() {
        synchronized (this.f39779i) {
            Iterator it = this.f39779i.iterator();
            while (it.hasNext()) {
                C12932n smash = (C12932n) it.next();
                if (smash.mo41734g() && this.f39771a != smash) {
                    if (this.f39774d == C12928a.FIRST_LOAD_IN_PROGRESS) {
                        m42023a(3002, smash);
                    } else {
                        m42023a(3012, smash);
                    }
                    smash.mo41725a(this.f39772b, this.f39778h, this.f39776f, this.f39777g);
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void mo41711a(Activity activity) {
        synchronized (this.f39779i) {
            this.f39782l = Boolean.valueOf(false);
            Iterator it = this.f39779i.iterator();
            while (it.hasNext()) {
                ((C12932n) it.next()).mo41724a(activity);
            }
        }
    }

    /* renamed from: b */
    public void mo41715b(Activity activity) {
        synchronized (this.f39779i) {
            this.f39782l = Boolean.valueOf(true);
            Iterator it = this.f39779i.iterator();
            while (it.hasNext()) {
                ((C12932n) it.next()).mo41728b(activity);
            }
        }
    }

    /* renamed from: d */
    private void m42036d() {
        try {
            m42037e();
            this.f39781k = new Timer();
            this.f39781k.schedule(new C12925k(this), this.f39780j * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m42037e() {
        Timer timer = this.f39781k;
        if (timer != null) {
            timer.cancel();
            this.f39781k = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m42032b() {
        if (this.f39774d != C12928a.RELOAD_IN_PROGRESS) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReloadTimer wrong state=");
            sb.append(this.f39774d.name());
            m42028a(sb.toString());
            return;
        }
        if (this.f39782l.booleanValue()) {
            m42022a(3011);
            m42023a(3012, this.f39771a);
            this.f39771a.mo41735h();
        } else {
            m42025a(3200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(614)}});
            m42036d();
        }
    }

    /* renamed from: a */
    private C12775b m42021a(String name, String reflectionName) {
        try {
            C12775b providerAdapter = C12747I.m41186g().mo41216b(name);
            if (providerAdapter != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("using previously loaded ");
                sb.append(name);
                m42028a(sb.toString());
                return providerAdapter;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loading ");
            sb2.append(name);
            sb2.append(" with reflection");
            m42028a(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("com.ironsource.adapters.");
            sb3.append(reflectionName.toLowerCase());
            sb3.append(".");
            sb3.append(reflectionName);
            sb3.append("Adapter");
            Class<?> mAdapterClass = Class.forName(sb3.toString());
            return (C12775b) mAdapterClass.getMethod("startAdapter", new Class[]{String.class}).invoke(mAdapterClass, new Object[]{name});
        } catch (Exception ex) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("getLoadedAdapterOrFetchByReflection ");
            sb4.append(ex.getMessage());
            m42034b(sb4.toString());
            return null;
        }
    }

    /* renamed from: a */
    private C12775b m42020a(C12826q config) {
        String name = config.mo41556m() ? config.mo41552i() : config.mo41551h();
        String reflectionName = config.mo41552i();
        StringBuilder sb = new StringBuilder();
        String str = "loadAdapter(";
        sb.append(str);
        sb.append(name);
        sb.append(")");
        m42028a(sb.toString());
        try {
            C12775b providerAdapter = m42021a(name, reflectionName);
            if (providerAdapter == null) {
                return null;
            }
            C12747I.m41186g().mo41219b(providerAdapter);
            providerAdapter.setLogListener(this.f39775e);
            return providerAdapter;
        } catch (Throwable e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(name);
            sb2.append(") ");
            sb2.append(e.getMessage());
            m42034b(sb2.toString());
            return null;
        }
    }
}
