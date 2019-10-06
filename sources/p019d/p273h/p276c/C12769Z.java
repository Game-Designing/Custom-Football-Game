package p019d.p273h.p276c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mopub.mobileads.VastIconXmlManager;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p278b.C12787k;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p281e.C12828s;
import p019d.p273h.p276c.p284h.C12906a;
import p019d.p273h.p276c.p284h.C12918l;
import p019d.p273h.p276c.p284h.C12919m;

/* renamed from: d.h.c.Z */
/* compiled from: ProgRvManager */
class C12769Z implements C12774aa, C12946ta {

    /* renamed from: a */
    private C12918l f39234a;

    /* renamed from: b */
    private Boolean f39235b = null;

    /* renamed from: c */
    private C12770a f39236c;

    /* renamed from: d */
    private final ConcurrentHashMap<String, C12795ca> f39237d;

    /* renamed from: e */
    private CopyOnWriteArrayList<C12795ca> f39238e;

    /* renamed from: f */
    private ConcurrentHashMap<String, C12905h> f39239f;

    /* renamed from: g */
    private String f39240g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f39241h;

    /* renamed from: i */
    private int f39242i;

    /* renamed from: j */
    private C12831f f39243j;

    /* renamed from: k */
    private Context f39244k;

    /* renamed from: l */
    private boolean f39245l;

    /* renamed from: m */
    private long f39246m;

    /* renamed from: n */
    private long f39247n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C12944sa f39248o;

    /* renamed from: d.h.c.Z$a */
    /* compiled from: ProgRvManager */
    private enum C12770a {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public C12769Z(Activity activity, List<C12826q> providersList, C12828s configs, String appKey, String userId) {
        m41376a(C12770a.RV_STATE_INITIATING);
        this.f39244k = activity.getApplicationContext();
        this.f39242i = configs.mo41569e();
        this.f39240g = "";
        C12906a auctionSettings = configs.mo41571g();
        this.f39245l = false;
        this.f39238e = new CopyOnWriteArrayList<>();
        this.f39239f = new ConcurrentHashMap<>();
        this.f39247n = new Date().getTime();
        this.f39243j = new C12831f(this.f39244k, "rewardedVideo", auctionSettings.mo41678b(), auctionSettings.mo41683g());
        this.f39248o = new C12944sa(auctionSettings, this);
        this.f39237d = new ConcurrentHashMap<>();
        for (C12826q provider : providersList) {
            C12775b adapter = C12830ea.m41759a(provider);
            if (adapter != null && C12808e.m41634a().mo41450a(adapter)) {
                C12747I.m41186g().mo41225d(adapter);
                C12795ca smash = new C12795ca(activity, appKey, userId, provider, this, configs.mo41570f(), adapter);
                this.f39237d.put(smash.mo41444j(), smash);
            }
        }
        this.f39234a = new C12918l(new ArrayList(this.f39237d.values()));
        for (C12795ca smash2 : this.f39237d.values()) {
            if (smash2.mo41449o()) {
                smash2.mo41421q();
            }
        }
        new Timer().schedule(new C12767X(this), auctionSettings.mo41682f());
    }

    /* renamed from: b */
    public void mo41293b(Activity activity) {
        synchronized (this.f39237d) {
            for (C12795ca smash : this.f39237d.values()) {
                smash.mo41441b(activity);
            }
        }
    }

    /* renamed from: a */
    public void mo41286a(Activity activity) {
        synchronized (this.f39237d) {
            for (C12795ca smash : this.f39237d.values()) {
                smash.mo41440a(activity);
            }
        }
    }

    /* renamed from: a */
    public void mo41291a(boolean consent) {
        synchronized (this.f39237d) {
            for (C12795ca smash : this.f39237d.values()) {
                smash.mo41442b(consent);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41389c() {
        m41376a(C12770a.RV_STATE_AUCTION_IN_PROGRESS);
        this.f39241h = "";
        this.f39246m = new Date().getTime();
        m41373a(1000);
        m41373a(1300);
        Map<String, Object> bidderCandidates = new HashMap<>();
        List<String> noBidderCandidates = new ArrayList<>();
        StringBuilder waterfallStr = new StringBuilder();
        synchronized (this.f39237d) {
            for (C12795ca smash : this.f39237d.values()) {
                smash.mo41425u();
                if (!this.f39234a.mo41700a(smash)) {
                    if (smash.mo41449o() && smash.mo41423s()) {
                        Map<String, Object> biddingData = smash.mo41420p();
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
        if (bidderCandidates.keySet().size() == 0 && noBidderCandidates.size() == 0) {
            m41387b(false);
            m41376a(C12770a.RV_STATE_NOT_LOADED);
            m41374a(1301, new Object[][]{new Object[]{"errorCode", Integer.valueOf(Opcodes.ACC_ABSTRACT)}, new Object[]{VastIconXmlManager.DURATION, Integer.valueOf(0)}});
            this.f39248o.mo41765a();
            return;
        }
        if (waterfallStr.length() > 256) {
            waterfallStr.setLength(Opcodes.ACC_NATIVE);
        } else {
            waterfallStr.deleteCharAt(waterfallStr.length() - 1);
        }
        m41374a(1310, new Object[][]{new Object[]{"ext1", waterfallStr.toString()}});
        this.f39243j.mo41577a(bidderCandidates, noBidderCandidates, C12919m.m42012a().mo41701a(1), new C12768Y(this));
    }

    /* renamed from: a */
    private String m41372a(C12905h item) {
        String isProgrammatic = TextUtils.isEmpty(item.mo41674b()) ? "1" : "2";
        StringBuilder sb = new StringBuilder();
        sb.append(isProgrammatic);
        sb.append(item.mo41673a());
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41383a(List<C12905h> waterfall) {
        synchronized (this.f39237d) {
            this.f39238e.clear();
            this.f39239f.clear();
            StringBuilder waterfallStr = new StringBuilder();
            for (C12905h item : waterfall) {
                StringBuilder sb = new StringBuilder();
                sb.append(m41372a(item));
                sb.append(",");
                waterfallStr.append(sb.toString());
                C12795ca smash = (C12795ca) this.f39237d.get(item.mo41673a());
                if (smash != null) {
                    smash.mo41443c(true);
                    this.f39238e.add(smash);
                    this.f39239f.put(smash.mo41444j(), item);
                }
            }
            if (waterfallStr.length() > 256) {
                waterfallStr.setLength(Opcodes.ACC_NATIVE);
            } else {
                waterfallStr.deleteCharAt(waterfallStr.length() - 1);
            }
            m41374a(1311, new Object[][]{new Object[]{"ext1", waterfallStr.toString()}});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41384b() {
        synchronized (this.f39237d) {
            m41376a(C12770a.RV_STATE_LOADING_SMASHES);
            for (int i = 0; i < Math.min(this.f39242i, this.f39238e.size()); i++) {
                C12795ca smash = (C12795ca) this.f39238e.get(i);
                smash.mo41412a(((C12905h) this.f39239f.get(smash.mo41444j())).mo41674b(), this.f39241h);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41376a(C12770a state) {
        StringBuilder sb = new StringBuilder();
        sb.append("current state=");
        sb.append(this.f39236c);
        sb.append(", new state=");
        sb.append(state);
        m41386b(sb.toString());
        this.f39236c = state;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41289a(p019d.p273h.p276c.C12795ca r9, java.lang.String r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            d.h.c.Z$a r0 = r8.f39236c     // Catch:{ all -> 0x0081 }
            d.h.c.Z$a r1 = p019d.p273h.p276c.C12769Z.C12770a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x0081 }
            if (r0 == r1) goto L_0x0025
            d.h.c.Z$a r0 = r8.f39236c     // Catch:{ all -> 0x0081 }
            d.h.c.Z$a r1 = p019d.p273h.p276c.C12769Z.C12770a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0081 }
            if (r0 == r1) goto L_0x0025
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r0.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "onLoadSuccess was invoked at the wrong manager state: "
            r0.append(r1)     // Catch:{ all -> 0x0081 }
            d.h.c.Z$a r1 = r8.f39236c     // Catch:{ all -> 0x0081 }
            r0.append(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0081 }
            r8.m41382a(r0)     // Catch:{ all -> 0x0081 }
            monitor-exit(r8)
            return
        L_0x0025:
            java.lang.String r0 = r8.f39241h     // Catch:{ all -> 0x0081 }
            boolean r0 = r10.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0081 }
            if (r0 != 0) goto L_0x004d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r0.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "onLoadSuccess was invoked with auctionId:"
            r0.append(r1)     // Catch:{ all -> 0x0081 }
            r0.append(r10)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = " and the current id is "
            r0.append(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = r8.f39241h     // Catch:{ all -> 0x0081 }
            r0.append(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0081 }
            r8.m41382a(r0)     // Catch:{ all -> 0x0081 }
            monitor-exit(r8)
            return
        L_0x004d:
            r0 = 1
            r8.m41387b(r0)     // Catch:{ all -> 0x0081 }
            d.h.c.Z$a r1 = r8.f39236c     // Catch:{ all -> 0x0081 }
            d.h.c.Z$a r2 = p019d.p273h.p276c.C12769Z.C12770a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0081 }
            if (r1 == r2) goto L_0x007f
            d.h.c.Z$a r1 = p019d.p273h.p276c.C12769Z.C12770a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0081 }
            r8.m41376a(r1)     // Catch:{ all -> 0x0081 }
            java.util.Date r1 = new java.util.Date     // Catch:{ all -> 0x0081 }
            r1.<init>()     // Catch:{ all -> 0x0081 }
            long r1 = r1.getTime()     // Catch:{ all -> 0x0081 }
            long r3 = r8.f39246m     // Catch:{ all -> 0x0081 }
            long r1 = r1 - r3
            r3 = 1003(0x3eb, float:1.406E-42)
            java.lang.Object[][] r4 = new java.lang.Object[r0][]     // Catch:{ all -> 0x0081 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0081 }
            java.lang.String r6 = "duration"
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x0081 }
            java.lang.Long r6 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0081 }
            r5[r0] = r6     // Catch:{ all -> 0x0081 }
            r4[r7] = r5     // Catch:{ all -> 0x0081 }
            r8.m41374a(r3, r4)     // Catch:{ all -> 0x0081 }
        L_0x007f:
            monitor-exit(r8)
            return
        L_0x0081:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12769Z.mo41289a(d.h.c.ca, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ad, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41296b(p019d.p273h.p276c.C12795ca r7, java.lang.String r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            d.h.c.Z$a r0 = r6.f39236c     // Catch:{ all -> 0x00ae }
            d.h.c.Z$a r1 = p019d.p273h.p276c.C12769Z.C12770a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x00ae }
            if (r0 == r1) goto L_0x0025
            d.h.c.Z$a r0 = r6.f39236c     // Catch:{ all -> 0x00ae }
            d.h.c.Z$a r1 = p019d.p273h.p276c.C12769Z.C12770a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x00ae }
            if (r0 == r1) goto L_0x0025
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r0.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "onRewardedVideoAvailabilityChanged was invoked at the wrong manager state: "
            r0.append(r1)     // Catch:{ all -> 0x00ae }
            d.h.c.Z$a r1 = r6.f39236c     // Catch:{ all -> 0x00ae }
            r0.append(r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ae }
            r6.m41382a(r0)     // Catch:{ all -> 0x00ae }
            monitor-exit(r6)
            return
        L_0x0025:
            java.lang.String r0 = r6.f39241h     // Catch:{ all -> 0x00ae }
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ all -> 0x00ae }
            if (r0 != 0) goto L_0x004d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r0.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "onLoadError was invoked with auctionId:"
            r0.append(r1)     // Catch:{ all -> 0x00ae }
            r0.append(r8)     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = " and the current id is "
            r0.append(r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = r6.f39241h     // Catch:{ all -> 0x00ae }
            r0.append(r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ae }
            r6.m41382a(r0)     // Catch:{ all -> 0x00ae }
            monitor-exit(r6)
            return
        L_0x004d:
            r0 = 0
            r1 = 0
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.ca> r2 = r6.f39238e     // Catch:{ all -> 0x00ae }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00ae }
        L_0x0055:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00ae }
            if (r3 == 0) goto L_0x009a
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00ae }
            d.h.c.ca r3 = (p019d.p273h.p276c.C12795ca) r3     // Catch:{ all -> 0x00ae }
            boolean r4 = r3.mo41445k()     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x008a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, d.h.c.h> r4 = r6.f39239f     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = r3.mo41444j()     // Catch:{ all -> 0x00ae }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0099
            java.util.concurrent.ConcurrentHashMap<java.lang.String, d.h.c.h> r2 = r6.f39239f     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = r3.mo41444j()     // Catch:{ all -> 0x00ae }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x00ae }
            d.h.c.h r2 = (p019d.p273h.p276c.C12905h) r2     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = r2.mo41674b()     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = r6.f39241h     // Catch:{ all -> 0x00ae }
            r3.mo41412a(r2, r4)     // Catch:{ all -> 0x00ae }
            monitor-exit(r6)
            return
        L_0x008a:
            boolean r4 = r3.mo41422r()     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0092
            r0 = 1
            goto L_0x0099
        L_0x0092:
            boolean r4 = r3.mo41424t()     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0099
            r1 = 1
        L_0x0099:
            goto L_0x0055
        L_0x009a:
            if (r1 != 0) goto L_0x00ac
            if (r0 != 0) goto L_0x00ac
            r2 = 0
            r6.m41387b(r2)     // Catch:{ all -> 0x00ae }
            d.h.c.Z$a r2 = p019d.p273h.p276c.C12769Z.C12770a.RV_STATE_NOT_LOADED     // Catch:{ all -> 0x00ae }
            r6.m41376a(r2)     // Catch:{ all -> 0x00ae }
            d.h.c.sa r2 = r6.f39248o     // Catch:{ all -> 0x00ae }
            r2.mo41765a()     // Catch:{ all -> 0x00ae }
        L_0x00ac:
            monitor-exit(r6)
            return
        L_0x00ae:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x00b2
        L_0x00b1:
            throw r7
        L_0x00b2:
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12769Z.mo41296b(d.h.c.ca, java.lang.String):void");
    }

    /* renamed from: a */
    public synchronized void mo41292a(boolean available, C12795ca smash) {
    }

    /* renamed from: a */
    public void mo41287a(C12795ca smash) {
        synchronized (this) {
            m41390c(smash, "onRewardedVideoAdOpened");
            C12929la.m42049a().mo41721c();
        }
    }

    /* renamed from: a */
    public void mo41290a(C12799b error, C12795ca smash) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRewardedVideoAdShowFailed error=");
            sb.append(error.mo41429b());
            m41390c(smash, sb.toString());
            C12929la.m42049a().mo41716a(error);
            this.f39245l = false;
            if (this.f39236c != C12770a.RV_STATE_READY_TO_SHOW) {
                m41387b(false);
            }
            this.f39248o.mo41767c();
        }
    }

    /* renamed from: b */
    public void mo41294b(C12795ca smash) {
        synchronized (this) {
            m41390c(smash, "onRewardedVideoAdClosed");
            C12929la.m42049a().mo41719b();
            this.f39245l = false;
            if (this.f39236c != C12770a.RV_STATE_READY_TO_SHOW) {
                m41387b(false);
            }
            this.f39248o.mo41766b();
        }
    }

    /* renamed from: a */
    public void mo41288a(C12795ca smash, C12820l placement) {
        synchronized (this) {
            m41390c(smash, "onRewardedVideoAdRewarded");
            C12929la.m42049a().mo41720b(placement);
        }
    }

    /* renamed from: b */
    public void mo41295b(C12795ca smash, C12820l placement) {
        synchronized (this) {
            m41390c(smash, "onRewardedVideoAdClicked");
            C12929la.m42049a().mo41717a(placement);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41387b(boolean isAvailable) {
        Boolean bool = this.f39235b;
        if (bool == null || bool.booleanValue() != isAvailable) {
            this.f39235b = Boolean.valueOf(isAvailable);
            long timeSpentInLastAvailability = new Date().getTime() - this.f39247n;
            this.f39247n = new Date().getTime();
            String str = VastIconXmlManager.DURATION;
            if (isAvailable) {
                m41374a(1111, new Object[][]{new Object[]{str, Long.valueOf(timeSpentInLastAvailability)}});
            } else {
                m41374a(1112, new Object[][]{new Object[]{str, Long.valueOf(timeSpentInLastAvailability)}});
            }
            C12929la.m42049a().mo41718a(isAvailable);
        }
    }

    /* renamed from: c */
    private void m41390c(C12795ca smash, String line) {
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41444j());
        sb.append(" : ");
        sb.append(line);
        C12802d.m41613c().mo41427b(C12801a.ADAPTER_CALLBACK, sb.toString(), 0);
    }

    /* renamed from: b */
    private void m41386b(String text) {
        C12802d.m41613c().mo41427b(C12801a.INTERNAL, text, 0);
    }

    /* renamed from: a */
    private void m41382a(String text) {
        C12802d.m41613c().mo41427b(C12801a.INTERNAL, text, 3);
    }

    /* renamed from: a */
    private void m41373a(int eventId) {
        m41374a(eventId, (Object[][]) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41374a(int eventId, Object[][] keyVals) {
        m41375a(eventId, keyVals, false);
    }

    /* renamed from: a */
    private void m41375a(int eventId, Object[][] keyVals, boolean isAddPlacement) {
        Map<String, Object> data = new HashMap<>();
        if (!TextUtils.isEmpty(this.f39241h)) {
            data.put("auctionId", this.f39241h);
        }
        if (isAddPlacement && !TextUtils.isEmpty(this.f39240g)) {
            data.put(VungleActivity.PLACEMENT_EXTRA, this.f39240g);
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
                sb.append("RV sendMediationEvent ");
                sb.append(Log.getStackTraceString(e));
                c.mo41427b(aVar, sb.toString(), 3);
            }
        }
        C12787k.m41517g().mo41369d(new C12733b(eventId, new JSONObject(data)));
    }

    /* renamed from: a */
    public void mo41285a() {
        if (this.f39236c == C12770a.RV_STATE_NOT_LOADED) {
            m41389c();
        }
    }
}
