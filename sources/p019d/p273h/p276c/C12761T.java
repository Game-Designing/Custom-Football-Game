package p019d.p273h.p276c;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.mopub.common.AdType;
import com.mopub.mobileads.VastIconXmlManager;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p278b.C12784h;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12816h;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p284h.C12906a;
import p019d.p273h.p276c.p284h.C12918l;
import p019d.p273h.p276c.p284h.C12919m;

/* renamed from: d.h.c.T */
/* compiled from: ProgIsManager */
class C12761T implements C12763U {

    /* renamed from: a */
    private C12918l f39196a;

    /* renamed from: b */
    private C12762a f39197b;

    /* renamed from: c */
    private final ConcurrentHashMap<String, C12765W> f39198c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private CopyOnWriteArrayList<C12765W> f39199d = new CopyOnWriteArrayList<>();

    /* renamed from: e */
    private ConcurrentHashMap<String, C12905h> f39200e = new ConcurrentHashMap<>();

    /* renamed from: f */
    private String f39201f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f39202g;

    /* renamed from: h */
    private int f39203h;

    /* renamed from: i */
    private C12831f f39204i;

    /* renamed from: j */
    private Context f39205j;

    /* renamed from: k */
    private long f39206k;

    /* renamed from: l */
    private long f39207l;

    /* renamed from: m */
    private long f39208m;

    /* renamed from: d.h.c.T$a */
    /* compiled from: ProgIsManager */
    enum C12762a {
        STATE_NOT_INITIALIZED,
        STATE_READY_TO_LOAD,
        STATE_AUCTION,
        STATE_LOADING_SMASHES,
        STATE_READY_TO_SHOW,
        STATE_SHOWING
    }

    public C12761T(Activity activity, List<C12826q> providersList, C12816h configs, String appKey, String userId) {
        m41307a(C12762a.STATE_NOT_INITIALIZED);
        String str = "";
        this.f39201f = str;
        this.f39202g = str;
        this.f39205j = activity.getApplicationContext();
        this.f39203h = configs.mo41488c();
        C12906a auctionSettings = configs.mo41491e();
        this.f39207l = auctionSettings.mo41682f();
        this.f39204i = new C12831f(this.f39205j, AdType.INTERSTITIAL, auctionSettings.mo41678b(), auctionSettings.mo41683g());
        HashSet hashSet = new HashSet();
        for (C12826q provider : providersList) {
            C12775b adapter = C12830ea.m41759a(provider);
            if (adapter != null && C12808e.m41634a().mo41450a(adapter)) {
                C12747I.m41186g().mo41222c(adapter);
                C12765W smash = new C12765W(activity, appKey, userId, provider, this, configs.mo41490d(), adapter);
                this.f39198c.put(smash.mo41444j(), smash);
                hashSet.add(smash.mo41447m());
            }
        }
        this.f39196a = new C12918l(new ArrayList(this.f39198c.values()));
        for (C12765W smash2 : this.f39198c.values()) {
            if (smash2.mo41449o()) {
                smash2.mo41280q();
            } else if (hashSet.contains(smash2.mo41447m())) {
                hashSet.remove(smash2.mo41447m());
                smash2.mo41283t();
            }
        }
        this.f39206k = new Date().getTime();
        m41307a(C12762a.STATE_READY_TO_LOAD);
    }

    /* renamed from: b */
    public void mo41270b(Activity activity) {
        synchronized (this.f39198c) {
            for (C12765W smash : this.f39198c.values()) {
                smash.mo41441b(activity);
            }
        }
    }

    /* renamed from: a */
    public void mo41264a(Activity activity) {
        synchronized (this.f39198c) {
            for (C12765W smash : this.f39198c.values()) {
                smash.mo41440a(activity);
            }
        }
    }

    /* renamed from: a */
    public void mo41269a(boolean consent) {
        synchronized (this.f39198c) {
            for (C12765W smash : this.f39198c.values()) {
                smash.mo41442b(consent);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41319c() {
        m41307a(C12762a.STATE_AUCTION);
        this.f39202g = "";
        StringBuilder waterfallStr = new StringBuilder();
        long timeToWaitBeforeAuction = this.f39207l - (new Date().getTime() - this.f39206k);
        if (timeToWaitBeforeAuction > 0) {
            new Handler().postDelayed(new C12759Q(this), timeToWaitBeforeAuction);
            return;
        }
        m41305a(2000, (Object[][]) null);
        Map<String, Object> bidderCandidates = new HashMap<>();
        List<String> noBidderCandidates = new ArrayList<>();
        synchronized (this.f39198c) {
            for (C12765W smash : this.f39198c.values()) {
                if (!this.f39196a.mo41700a(smash)) {
                    if (smash.mo41449o() && smash.mo41282s()) {
                        Map<String, Object> biddingData = smash.mo41279p();
                        if (biddingData != null) {
                            bidderCandidates.put(smash.mo41444j(), biddingData);
                            StringBuilder sb = new StringBuilder();
                            sb.append("2");
                            sb.append(smash.mo41444j());
                            sb.append(",");
                            waterfallStr.append(sb.toString());
                        }
                    } else if (!smash.mo41449o()) {
                        noBidderCandidates.add(smash.mo41444j());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("1");
                        sb2.append(smash.mo41444j());
                        sb2.append(",");
                        waterfallStr.append(sb2.toString());
                    }
                }
            }
        }
        if (bidderCandidates.size() == 0 && noBidderCandidates.size() == 0) {
            m41305a(2300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(1005)}, new Object[]{VastIconXmlManager.DURATION, Integer.valueOf(0)}});
            C12937p.m42122a().mo41746a(new C12799b(1005, "No candidates available for auctioning"));
            m41305a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(1005)}});
            m41307a(C12762a.STATE_READY_TO_LOAD);
            return;
        }
        if (waterfallStr.length() > 256) {
            waterfallStr.setLength(Opcodes.ACC_NATIVE);
        } else {
            waterfallStr.deleteCharAt(waterfallStr.length() - 1);
        }
        m41305a(2310, new Object[][]{new Object[]{"ext1", waterfallStr.toString()}});
        this.f39204i.mo41577a(bidderCandidates, noBidderCandidates, C12919m.m42012a().mo41701a(2), new C12760S(this));
    }

    /* renamed from: a */
    private String m41300a(C12905h item) {
        String isProgrammatic = TextUtils.isEmpty(item.mo41674b()) ? "1" : "2";
        StringBuilder sb = new StringBuilder();
        sb.append(isProgrammatic);
        sb.append(item.mo41673a());
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41314a(List<C12905h> waterfall) {
        synchronized (this.f39198c) {
            this.f39199d.clear();
            this.f39200e.clear();
            StringBuilder waterfallStr = new StringBuilder();
            for (C12905h item : waterfall) {
                StringBuilder sb = new StringBuilder();
                sb.append(m41300a(item));
                sb.append(",");
                waterfallStr.append(sb.toString());
                C12765W smash = (C12765W) this.f39198c.get(item.mo41673a());
                if (smash != null) {
                    smash.mo41443c(true);
                    this.f39199d.add(smash);
                    this.f39200e.put(smash.mo41444j(), item);
                }
            }
            if (waterfallStr.length() > 256) {
                waterfallStr.setLength(Opcodes.ACC_NATIVE);
            } else {
                waterfallStr.deleteCharAt(waterfallStr.length() - 1);
            }
            m41305a(2311, new Object[][]{new Object[]{"ext1", waterfallStr.toString()}});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41315b() {
        synchronized (this.f39198c) {
            m41307a(C12762a.STATE_LOADING_SMASHES);
            for (int i = 0; i < Math.min(this.f39203h, this.f39199d.size()); i++) {
                C12765W smash = (C12765W) this.f39199d.get(i);
                String serverData = ((C12905h) this.f39200e.get(smash.mo41444j())).mo41674b();
                m41302a(2002, smash);
                smash.mo41278a(serverData);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo41263a() {
        if (this.f39197b == C12762a.STATE_SHOWING) {
            C12802d.m41613c().mo41427b(C12801a.API, "loadInterstitial() cannot be invoked while showing", 3);
        } else if ((this.f39197b == C12762a.STATE_READY_TO_LOAD || this.f39197b == C12762a.STATE_READY_TO_SHOW) && !C12937p.m42122a().mo41751b()) {
            this.f39202g = "";
            this.f39201f = "";
            m41301a(2001);
            this.f39208m = new Date().getTime();
            m41319c();
        } else {
            m41313a("loadInterstitial() already in progress");
        }
    }

    /* renamed from: a */
    public void mo41266a(C12765W smash, long elapsedTime) {
        synchronized (this) {
            m41312a(smash, "onInterstitialAdReady");
            m41303a(2003, smash, new Object[][]{new Object[]{VastIconXmlManager.DURATION, Long.valueOf(elapsedTime)}});
            if (this.f39197b == C12762a.STATE_LOADING_SMASHES) {
                m41307a(C12762a.STATE_READY_TO_SHOW);
                C12950x.m42157a().mo41776e();
                m41305a(2004, new Object[][]{new Object[]{VastIconXmlManager.DURATION, Long.valueOf(new Date().getTime() - this.f39208m)}});
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f3, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo41268a(p019d.p273h.p276c.p280d.C12799b r11, p019d.p273h.p276c.C12765W r12, long r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r0.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = "onInterstitialAdLoadFailed error="
            r0.append(r1)     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = r11.mo41429b()     // Catch:{ all -> 0x00f7 }
            r0.append(r1)     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = " state="
            r0.append(r1)     // Catch:{ all -> 0x00f7 }
            d.h.c.T$a r1 = r10.f39197b     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = r1.name()     // Catch:{ all -> 0x00f7 }
            r0.append(r1)     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f7 }
            r10.m41312a(r12, r0)     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = r11.mo41429b()     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = r11.mo41429b()     // Catch:{ all -> 0x00f7 }
            int r1 = r1.length()     // Catch:{ all -> 0x00f7 }
            r2 = 39
            int r1 = java.lang.Math.min(r1, r2)     // Catch:{ all -> 0x00f7 }
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)     // Catch:{ all -> 0x00f7 }
            r1 = 2200(0x898, float:3.083E-42)
            r3 = 3
            java.lang.Object[][] r3 = new java.lang.Object[r3][]     // Catch:{ all -> 0x00f7 }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = "errorCode"
            r5[r2] = r6     // Catch:{ all -> 0x00f7 }
            int r6 = r11.mo41428a()     // Catch:{ all -> 0x00f7 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00f7 }
            r7 = 1
            r5[r7] = r6     // Catch:{ all -> 0x00f7 }
            r3[r2] = r5     // Catch:{ all -> 0x00f7 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = "reason"
            r5[r2] = r6     // Catch:{ all -> 0x00f7 }
            r5[r7] = r0     // Catch:{ all -> 0x00f7 }
            r3[r7] = r5     // Catch:{ all -> 0x00f7 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = "duration"
            r5[r2] = r6     // Catch:{ all -> 0x00f7 }
            java.lang.Long r6 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x00f7 }
            r5[r7] = r6     // Catch:{ all -> 0x00f7 }
            r3[r4] = r5     // Catch:{ all -> 0x00f7 }
            r10.m41303a(r1, r12, r3)     // Catch:{ all -> 0x00f7 }
            d.h.c.T$a r1 = r10.f39197b     // Catch:{ all -> 0x00f7 }
            d.h.c.T$a r3 = p019d.p273h.p276c.C12761T.C12762a.STATE_LOADING_SMASHES     // Catch:{ all -> 0x00f7 }
            if (r1 == r3) goto L_0x0080
            d.h.c.T$a r1 = r10.f39197b     // Catch:{ all -> 0x00f7 }
            d.h.c.T$a r3 = p019d.p273h.p276c.C12761T.C12762a.STATE_READY_TO_SHOW     // Catch:{ all -> 0x00f7 }
            if (r1 == r3) goto L_0x0080
            monitor-exit(r10)     // Catch:{ all -> 0x00f7 }
            return
        L_0x0080:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, d.h.c.W> r1 = r10.f39198c     // Catch:{ all -> 0x00f7 }
            monitor-enter(r1)     // Catch:{ all -> 0x00f7 }
            r3 = 0
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.W> r5 = r10.f39199d     // Catch:{ all -> 0x00f4 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00f4 }
        L_0x008a:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00f4 }
            if (r6 == 0) goto L_0x00bf
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00f4 }
            d.h.c.W r6 = (p019d.p273h.p276c.C12765W) r6     // Catch:{ all -> 0x00f4 }
            boolean r8 = r6.mo41445k()     // Catch:{ all -> 0x00f4 }
            if (r8 == 0) goto L_0x00b7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, d.h.c.h> r2 = r10.f39200e     // Catch:{ all -> 0x00f4 }
            java.lang.String r4 = r6.mo41444j()     // Catch:{ all -> 0x00f4 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x00f4 }
            d.h.c.h r2 = (p019d.p273h.p276c.C12905h) r2     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = r2.mo41674b()     // Catch:{ all -> 0x00f4 }
            r4 = 2002(0x7d2, float:2.805E-42)
            r10.m41302a(r4, r6)     // Catch:{ all -> 0x00f4 }
            r6.mo41278a(r2)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r10)     // Catch:{ all -> 0x00f7 }
            return
        L_0x00b7:
            boolean r8 = r6.mo41281r()     // Catch:{ all -> 0x00f4 }
            if (r8 == 0) goto L_0x00be
            r3 = 1
        L_0x00be:
            goto L_0x008a
        L_0x00bf:
            d.h.c.T$a r5 = r10.f39197b     // Catch:{ all -> 0x00f4 }
            d.h.c.T$a r6 = p019d.p273h.p276c.C12761T.C12762a.STATE_LOADING_SMASHES     // Catch:{ all -> 0x00f4 }
            if (r5 != r6) goto L_0x00f1
            if (r3 != 0) goto L_0x00f1
            d.h.c.p r5 = p019d.p273h.p276c.C12937p.m42122a()     // Catch:{ all -> 0x00f4 }
            d.h.c.d.b r6 = new d.h.c.d.b     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = "No ads to show"
            r9 = 509(0x1fd, float:7.13E-43)
            r6.<init>(r9, r8)     // Catch:{ all -> 0x00f4 }
            r5.mo41746a(r6)     // Catch:{ all -> 0x00f4 }
            r5 = 2110(0x83e, float:2.957E-42)
            java.lang.Object[][] r6 = new java.lang.Object[r7][]     // Catch:{ all -> 0x00f4 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = "errorCode"
            r4[r2] = r8     // Catch:{ all -> 0x00f4 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00f4 }
            r4[r7] = r8     // Catch:{ all -> 0x00f4 }
            r6[r2] = r4     // Catch:{ all -> 0x00f4 }
            r10.m41305a(r5, r6)     // Catch:{ all -> 0x00f4 }
            d.h.c.T$a r2 = p019d.p273h.p276c.C12761T.C12762a.STATE_READY_TO_LOAD     // Catch:{ all -> 0x00f4 }
            r10.m41307a(r2)     // Catch:{ all -> 0x00f4 }
        L_0x00f1:
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r10)     // Catch:{ all -> 0x00f7 }
            return
        L_0x00f4:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            throw r2     // Catch:{ all -> 0x00f7 }
        L_0x00f7:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00f7 }
            goto L_0x00fb
        L_0x00fa:
            throw r0
        L_0x00fb:
            goto L_0x00fa
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12761T.mo41268a(d.h.c.d.b, d.h.c.W, long):void");
    }

    /* renamed from: c */
    public void mo41273c(C12765W smash) {
        synchronized (this) {
            m41312a(smash, "onInterstitialAdOpened");
            C12950x.m42157a().mo41775d();
            m41316b(2005, smash);
        }
    }

    /* renamed from: d */
    public void mo41274d(C12765W smash) {
        synchronized (this) {
            m41312a(smash, "onInterstitialAdClosed");
            C12950x.m42157a().mo41774c();
            m41316b(2204, smash);
            m41307a(C12762a.STATE_READY_TO_LOAD);
        }
    }

    /* renamed from: f */
    public void mo41276f(C12765W smash) {
        synchronized (this) {
            m41312a(smash, "onInterstitialAdShowSucceeded");
            C12950x.m42157a().mo41777f();
            m41316b(2202, smash);
            if (this.f39200e.containsKey(smash.mo41444j())) {
                this.f39204i.mo41576a((C12905h) this.f39200e.get(smash.mo41444j()));
            }
        }
    }

    /* renamed from: a */
    public void mo41267a(C12799b error, C12765W smash) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("onInterstitialAdShowFailed error=");
            sb.append(error.mo41429b());
            m41312a(smash, sb.toString());
            C12950x.m42157a().mo41772a(error);
            m41317b(2203, smash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(error.mo41428a())}, new Object[]{"reason", error.mo41429b().substring(0, Math.min(error.mo41429b().length(), 39))}});
            m41307a(C12762a.STATE_READY_TO_LOAD);
        }
    }

    /* renamed from: e */
    public void mo41275e(C12765W smash) {
        synchronized (this) {
            m41312a(smash, "onInterstitialAdClicked");
            C12950x.m42157a().mo41773b();
            m41316b(2006, smash);
        }
    }

    /* renamed from: b */
    public void mo41271b(C12765W smash) {
        synchronized (this) {
            m41312a(smash, "onInterstitialAdVisible");
        }
    }

    /* renamed from: b */
    public void mo41272b(C12799b error, C12765W smash) {
        synchronized (this) {
            m41303a(2206, smash, new Object[][]{new Object[]{"reason", error.mo41429b().substring(0, Math.min(error.mo41429b().length(), 39))}});
        }
    }

    /* renamed from: a */
    public void mo41265a(C12765W smash) {
        synchronized (this) {
            m41302a(2205, smash);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41307a(C12762a state) {
        this.f39197b = state;
        StringBuilder sb = new StringBuilder();
        sb.append("state=");
        sb.append(state);
        m41313a(sb.toString());
    }

    /* renamed from: a */
    private void m41312a(C12765W smash, String line) {
        StringBuilder sb = new StringBuilder();
        sb.append("ProgIsManager ");
        sb.append(smash.mo41444j());
        sb.append(" : ");
        sb.append(line);
        C12802d.m41613c().mo41427b(C12801a.INTERNAL, sb.toString(), 0);
    }

    /* renamed from: a */
    private void m41313a(String text) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append("ProgIsManager ");
        sb.append(text);
        c.mo41427b(aVar, sb.toString(), 0);
    }

    /* renamed from: a */
    private void m41301a(int eventId) {
        m41306a(eventId, (Object[][]) null, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41305a(int eventId, Object[][] keyVals) {
        m41306a(eventId, keyVals, false);
    }

    /* renamed from: a */
    private void m41306a(int eventId, Object[][] keyVals, boolean isAddPlacement) {
        Map<String, Object> data = new HashMap<>();
        data.put("provider", "Mediation");
        data.put("programmatic", Integer.valueOf(1));
        if (!TextUtils.isEmpty(this.f39202g)) {
            data.put("auctionId", this.f39202g);
        }
        if (isAddPlacement && !TextUtils.isEmpty(this.f39201f)) {
            data.put(VungleActivity.PLACEMENT_EXTRA, this.f39201f);
        }
        if (keyVals != null) {
            try {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendMediationEvent ");
                sb.append(e.getMessage());
                m41313a(sb.toString());
            }
        }
        C12784h.m41502g().mo41369d(new C12733b(eventId, new JSONObject(data)));
    }

    /* renamed from: a */
    private void m41302a(int eventId, C12765W smash) {
        m41304a(eventId, smash, null, false);
    }

    /* renamed from: a */
    private void m41303a(int eventId, C12765W smash, Object[][] keyVals) {
        m41304a(eventId, smash, keyVals, false);
    }

    /* renamed from: b */
    private void m41317b(int eventId, C12765W smash, Object[][] keyVals) {
        m41304a(eventId, smash, keyVals, true);
    }

    /* renamed from: b */
    private void m41316b(int eventId, C12765W smash) {
        m41304a(eventId, smash, null, true);
    }

    /* renamed from: a */
    private void m41304a(int eventId, C12765W smash, Object[][] keyVals, boolean isAddPlacement) {
        Map<String, Object> data = smash.mo41448n();
        if (!TextUtils.isEmpty(this.f39202g)) {
            data.put("auctionId", this.f39202g);
        }
        if (isAddPlacement && !TextUtils.isEmpty(this.f39201f)) {
            data.put(VungleActivity.PLACEMENT_EXTRA, this.f39201f);
        }
        if (keyVals != null) {
            try {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.INTERNAL;
                StringBuilder sb = new StringBuilder();
                sb.append("IS sendProviderEvent ");
                sb.append(Log.getStackTraceString(e));
                c.mo41427b(aVar, sb.toString(), 3);
            }
        }
        C12784h.m41502g().mo41369d(new C12733b(eventId, new JSONObject(data)));
    }
}
