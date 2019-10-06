package p019d.p143b.p144a.p147c;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import com.applovin.adview.C5856b;
import java.util.HashMap;
import java.util.Map;
import p019d.p143b.p144a.p146b.C6988a;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7256f;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7259i;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.a */
public class C7134a implements C7256f {

    /* renamed from: a */
    public static String f13430a = "/adservice/no_op";

    /* renamed from: b */
    public static String f13431b = "/adservice/track_click_now";

    /* renamed from: c */
    public static String f13432c = "/adservice/skip";

    /* renamed from: d */
    public static String f13433d = "/adservice/load_url";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C7142c f13434e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C7262l f13435f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f13436g;

    /* renamed from: h */
    private final Map<C7059Ec, C7091Mc> f13437h;

    /* renamed from: i */
    private final Object f13438i = new Object();

    C7134a(C7142c cVar) {
        if (cVar != null) {
            this.f13434e = cVar;
            this.f13435f = cVar.mo23049b();
            this.f13436g = new Handler(Looper.getMainLooper());
            this.f13437h = new HashMap(8);
            this.f13437h.put(C7059Ec.m14678c(cVar), new C7091Mc(null));
            this.f13437h.put(C7059Ec.m14679d(cVar), new C7091Mc(null));
            this.f13437h.put(C7059Ec.m14680e(cVar), new C7091Mc(null));
            this.f13437h.put(C7059Ec.m14681f(cVar), new C7091Mc(null));
            this.f13437h.put(C7059Ec.m14682g(cVar), new C7091Mc(null));
            this.f13437h.put(C7059Ec.m14683h(cVar), new C7091Mc(null));
            this.f13437h.put(C7059Ec.m14684i(cVar), new C7091Mc(null));
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14998a(Uri uri, C7234z zVar, C5856b bVar, C6988a aVar) {
        if (bVar != null) {
            aVar.mo22596o();
            mo23006a((C7251a) zVar);
            if (C7269s.m15818a(bVar.getContext(), uri, this.f13434e)) {
                C7171ja.m15286c(aVar.mo22589h(), (C7251a) zVar, bVar, (C7267q) this.f13434e);
            }
            aVar.mo22587f();
            return;
        }
        this.f13435f.mo22916b("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14999a(C7059Ec ec, C7087Lc lc) {
        C7251a aVar = (C7251a) this.f13434e.mo23063h().mo22961e(ec);
        if (aVar != null) {
            C7262l lVar = this.f13435f;
            StringBuilder sb = new StringBuilder();
            sb.append("Using pre-loaded ad: ");
            sb.append(aVar);
            sb.append(" for ");
            sb.append(ec);
            lVar.mo22918c("AppLovinAdService", sb.toString());
            lc.adReceived(aVar);
        } else {
            m15004a((C7184mb) new C7090Mb(ec, lc, this.f13434e), (C7254d) lc);
        }
        if (ec.mo22813l() && aVar == null) {
            return;
        }
        if (ec.mo22814m() || (aVar != null && ec.mo22808h() > 0)) {
            this.f13434e.mo23063h().mo22965i(ec);
        }
    }

    /* renamed from: a */
    private void m15000a(C7059Ec ec, C7254d dVar) {
        C7251a aVar;
        C7262l lVar;
        String str;
        String str2;
        int i;
        if (ec == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (dVar != null) {
            if (!C7202r.m15406a(this.f13434e.mo23068m(), this.f13434e) && !((Boolean) this.f13434e.mo23039a(C7196pb.f13692Fc)).booleanValue()) {
                this.f13435f.mo22921e("AppLovinAdService", "Failing ad load due to no internet connection.");
                i = -103;
            } else if (!((Boolean) this.f13434e.mo23039a(C7196pb.f13783Zc)).booleanValue() || ec.mo22814m() || !this.f13434e.mo23029E().mo22821a() || this.f13434e.mo23029E().mo22822a(ec)) {
                C7262l b = this.f13434e.mo23049b();
                StringBuilder sb = new StringBuilder();
                sb.append("Loading next ad of zone {");
                sb.append(ec);
                sb.append("}...");
                b.mo22918c("AppLovinAdService", sb.toString());
                C7091Mc c = m15009c(ec);
                synchronized (c.f13304a) {
                    boolean z = System.currentTimeMillis() > c.f13306c;
                    aVar = null;
                    if (c.f13305b == null || z) {
                        c.f13309f.add(dVar);
                        if (!c.f13307d) {
                            this.f13435f.mo22918c("AppLovinAdService", "Loading next ad...");
                            c.f13307d = true;
                            C7087Lc lc = new C7087Lc(this, c, null);
                            if (!ec.mo22812k()) {
                                this.f13435f.mo22918c("AppLovinAdService", "Task merge not necessary.");
                            } else if (this.f13434e.mo23063h().mo23140a(ec, (Object) lc)) {
                                lVar = this.f13435f;
                                str = "AppLovinAdService";
                                str2 = "Attaching load listener to initial preload task...";
                            } else {
                                this.f13435f.mo22918c("AppLovinAdService", "Skipped attach of initial preload callback.");
                            }
                            m14999a(ec, lc);
                        } else {
                            lVar = this.f13435f;
                            str = "AppLovinAdService";
                            str2 = "Already waiting on an ad load...";
                        }
                        lVar.mo22918c(str, str2);
                    } else {
                        aVar = c.f13305b;
                    }
                }
                if (aVar != null) {
                    dVar.adReceived(aVar);
                }
                return;
            } else {
                C7262l lVar2 = this.f13435f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to load ad for zone (");
                sb2.append(ec.mo22799a());
                sb2.append("). Please check that the zone has been added to your AppLovin account.");
                lVar2.mo22921e("AppLovinAdService", sb2.toString());
                i = -7;
            }
            dVar.failedToReceiveAd(i);
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    /* renamed from: a */
    private void m15004a(C7184mb mbVar, C7254d dVar) {
        String str = "AppLovinAdService";
        if (C7202r.m15406a(this.f13434e.mo23068m(), this.f13434e) || ((Boolean) this.f13434e.mo23039a(C7196pb.f13692Fc)).booleanValue()) {
            this.f13434e.mo23066k();
            C7262l lVar = this.f13435f;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading ad using '");
            sb.append(mbVar.getClass().getSimpleName());
            sb.append("'...");
            lVar.mo22920d(str, sb.toString());
            this.f13434e.mo23027C().mo22970a(mbVar, C7113Tb.MAIN);
            return;
        }
        this.f13435f.mo22921e(str, "Failing ad load due to no internet connection.");
        dVar.failedToReceiveAd(-103);
    }

    /* renamed from: a */
    private void m15005a(C7234z zVar, String str) {
        String a = zVar.mo23423a(str);
        if (C7269s.m15819a(a)) {
            this.f13434e.mo23077v().mo23084a(a, null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m15008b() {
        return ((PowerManager) this.f13434e.mo23068m().getSystemService("power")).isScreenOn();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C7091Mc m15009c(C7059Ec ec) {
        C7091Mc mc;
        synchronized (this.f13438i) {
            mc = (C7091Mc) this.f13437h.get(ec);
            if (mc == null) {
                mc = new C7091Mc(null);
                this.f13437h.put(ec, mc);
            }
        }
        return mc;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m15011d(C7059Ec ec) {
        long j = ec.mo22811j();
        if (j > 0) {
            this.f13434e.mo23027C().mo22971a((C7184mb) new C7095Nc(this, ec, null), C7113Tb.MAIN, (j + 2) * 1000);
        }
    }

    /* renamed from: a */
    public C7251a mo23002a(C7059Ec ec) {
        C7251a aVar = (C7251a) this.f13434e.mo23063h().mo23146d(ec);
        C7262l lVar = this.f13435f;
        StringBuilder sb = new StringBuilder();
        sb.append("Dequeued ad: ");
        sb.append(aVar);
        sb.append(" for zone: ");
        sb.append(ec);
        sb.append("...");
        lVar.mo22918c("AppLovinAdService", sb.toString());
        return aVar;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public String mo23003a() {
        C7170j jVar;
        String str = "AppLovinAdService";
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            jVar = this.f13434e.mo23070o().mo23239a(((Integer) this.f13434e.mo23039a(C7196pb.f13876rd)).intValue());
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        if (jVar == null) {
            return "";
        }
        if (!TextUtils.isEmpty(jVar.mo23177a())) {
            C7262l lVar = this.f13435f;
            StringBuilder sb = new StringBuilder();
            sb.append("Generated bid token: ");
            sb.append(jVar);
            lVar.mo22918c(str, sb.toString());
        } else {
            this.f13435f.mo22916b(str, "Failed to generate bid token");
        }
        if (!jVar.mo23178b()) {
            this.f13435f.mo22921e(str, "Bid token generated too early in session - please initialize the SDK first. Not doing so can negatively impact your eCPMs!");
        }
        return jVar.mo23177a();
    }

    /* renamed from: a */
    public void mo23004a(C7234z zVar, String str, C5856b bVar, Uri uri) {
        m15005a(zVar, str);
        C7269s.m15818a(bVar.getContext(), uri, this.f13434e);
    }

    /* renamed from: a */
    public void mo23005a(C7234z zVar, String str, C5856b bVar, C6988a aVar, Uri uri) {
        m15005a(zVar, str);
        m14998a(uri, zVar, bVar, aVar);
    }

    /* renamed from: a */
    public void mo23006a(C7251a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (aVar instanceof C7071Hc) {
            C7091Mc c = m15009c(((C7071Hc) aVar).mo22762n());
            synchronized (c.f13304a) {
                c.f13305b = null;
                c.f13306c = 0;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown ad type specified: ");
            sb.append(aVar.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23007a(C7254d dVar) {
        m15000a(C7059Ec.m14683h(this.f13434e), dVar);
    }

    /* renamed from: a */
    public void mo23008a(C7257g gVar, C7254d dVar) {
        m15000a(C7059Ec.m14670a(gVar, C7258h.f14102a, C7063Fc.f13210b, this.f13434e), dVar);
    }

    /* renamed from: a */
    public void mo23009a(C7259i iVar, C7257g gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else if (iVar != null) {
            C7091Mc c = m15009c(C7059Ec.m14670a(gVar, C7258h.f14102a, C7063Fc.f13210b, this.f13434e));
            synchronized (c.f13304a) {
                if (c.f13308e.contains(iVar)) {
                    c.f13308e.remove(iVar);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Removed update listener: ");
                    sb.append(iVar);
                    this.f13435f.mo22918c("AppLovinAdService", sb.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo23010a(String str, C7254d dVar) {
        if (!TextUtils.isEmpty(str)) {
            C7262l lVar = this.f13435f;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading next ad of zone {");
            sb.append(str);
            sb.append("}");
            lVar.mo22918c("AppLovinAdService", sb.toString());
            m15000a(C7059Ec.m14672a(str, this.f13434e), dVar);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    /* renamed from: b */
    public void mo23011b(C7059Ec ec) {
        this.f13434e.mo23063h().mo22964h(ec);
        int h = ec.mo22808h();
        if (h == 0 && this.f13434e.mo23063h().mo23142b(ec)) {
            h = 1;
        }
        this.f13434e.mo23063h().mo22959b(ec, h);
    }

    /* renamed from: b */
    public void mo23012b(C7234z zVar, String str, C5856b bVar, C6988a aVar, Uri uri) {
        if (zVar != null) {
            this.f13435f.mo22918c("AppLovinAdService", "Tracking foreground click on an ad...");
            int intValue = ((Integer) this.f13434e.mo23039a(C7196pb.f13778Yb)).intValue();
            int intValue2 = ((Integer) this.f13434e.mo23039a(C7196pb.f13782Zb)).intValue();
            int intValue3 = ((Integer) this.f13434e.mo23039a(C7196pb.f13785_b)).intValue();
            C7158g w = this.f13434e.mo23078w();
            String a = zVar.mo23423a(str);
            long j = (long) intValue2;
            C7075Ic ic = new C7075Ic(this, aVar, uri, zVar, bVar);
            w.mo23137a(a, null, null, intValue, j, intValue3, ic);
            return;
        }
        throw new IllegalArgumentException("No ad specified");
    }

    /* renamed from: b */
    public void mo23013b(C7259i iVar, C7257g gVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("No ad listener specified");
        } else if (gVar != null) {
            C7059Ec a = C7059Ec.m14670a(gVar, C7258h.f14102a, C7063Fc.f13210b, this.f13434e);
            C7091Mc c = m15009c(a);
            boolean z = false;
            synchronized (c.f13304a) {
                if (c.f13306c > 0 && !c.f13308e.contains(iVar)) {
                    c.f13308e.add(iVar);
                    z = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Added update listener: ");
                    sb.append(iVar);
                    this.f13435f.mo22918c("AppLovinAdService", sb.toString());
                }
            }
            if (z) {
                this.f13434e.mo23027C().mo22970a((C7184mb) new C7095Nc(this, a, null), C7113Tb.MAIN);
            }
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    /* JADX WARNING: type inference failed for: r11v14, types: [d.b.a.c.mb] */
    /* JADX WARNING: type inference failed for: r11v16, types: [d.b.a.c.Pb] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo23014b(java.lang.String r11, p019d.p143b.p150d.C7254d r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            java.lang.String r11 = r11.trim()
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = -8
            java.lang.String r2 = "AppLovinAdService"
            if (r0 == 0) goto L_0x001c
            d.b.d.l r11 = r10.f13435f
            java.lang.String r0 = "Invalid ad token specified"
            r11.mo22921e(r2, r0)
            r12.failedToReceiveAd(r1)
            return
        L_0x001c:
            d.b.a.c.Cc r0 = new d.b.a.c.Cc
            d.b.a.c.c r3 = r10.f13434e
            r0.<init>(r11, r3)
            d.b.a.c.Dc r11 = r0.mo22774b()
            d.b.a.c.Dc r3 = p019d.p143b.p144a.p147c.C7055Dc.f13185b
            if (r11 != r3) goto L_0x004d
            d.b.d.l r11 = r10.f13435f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Loading next ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.mo22918c(r2, r1)
            d.b.a.c.Pb r11 = new d.b.a.c.Pb
            d.b.a.c.c r1 = r10.f13434e
            r11.<init>(r0, r12, r1)
        L_0x0048:
            r10.m15004a(r11, r12)
            goto L_0x00e2
        L_0x004d:
            d.b.a.c.Dc r11 = r0.mo22774b()
            d.b.a.c.Dc r3 = p019d.p143b.p144a.p147c.C7055Dc.f13186c
            if (r11 != r3) goto L_0x00c9
            org.json.JSONObject r5 = r0.mo22776d()
            if (r5 == 0) goto L_0x00b2
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            d.b.a.c.c r1 = r10.f13434e
            java.lang.String r3 = "ads"
            org.json.JSONArray r11 = p019d.p143b.p144a.p147c.C7167ia.m15261a(r5, r3, r11, r1)
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x0096
            d.b.d.l r11 = r10.f13435f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Rendering ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo22918c(r2, r0)
            d.b.a.c.c r11 = r10.f13434e
            d.b.a.c.Ec r6 = p019d.p143b.p144a.p147c.C7209sc.m15465a(r5, r11)
            d.b.a.c.Yb r11 = new d.b.a.c.Yb
            d.b.a.c.Bc r7 = p019d.p143b.p144a.p147c.C7047Bc.DECODED_AD_TOKEN_JSON
            d.b.a.c.c r9 = r10.f13434e
            r4 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0048
        L_0x0096:
            d.b.d.l r11 = r10.f13435f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "No ad returned from the server for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo22916b(r2, r0)
            r11 = 204(0xcc, float:2.86E-43)
            r12.failedToReceiveAd(r11)
            goto L_0x00e2
        L_0x00b2:
            d.b.d.l r11 = r10.f13435f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to retrieve ad response JSON from token: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r11.mo22916b(r2, r0)
            goto L_0x00df
        L_0x00c9:
            d.b.d.l r11 = r10.f13435f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid ad token specified: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r11.mo22921e(r2, r0)
        L_0x00df:
            r12.failedToReceiveAd(r1)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7134a.mo23014b(java.lang.String, d.b.d.d):void");
    }
}
