package p019d.p143b.p144a.p147c;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Mb */
class C7090Mb extends C7184mb {

    /* renamed from: f */
    private final C7059Ec f13301f;

    /* renamed from: g */
    private final C7254d f13302g;

    /* renamed from: h */
    private boolean f13303h = false;

    C7090Mb(C7059Ec ec, C7254d dVar, C7142c cVar) {
        super("FetchNextAd", cVar);
        this.f13301f = ec;
        this.f13302g = dVar;
    }

    /* renamed from: a */
    private void m14832a(C7076J j) {
        String str = "ad_session_start";
        if (System.currentTimeMillis() - j.mo22864b(str) > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f13625b.mo23039a(C7196pb.f13669B)).intValue())) {
            j.mo22866b(str, System.currentTimeMillis());
            j.mo22868c("ad_imp_session");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14835b(int i) {
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to fetch ");
        sb.append(this.f13301f);
        sb.append(" ad: server returned ");
        sb.append(i);
        lVar.mo22916b(str, sb.toString());
        try {
            mo22902a(i);
        } catch (Throwable th) {
            this.f13626c.mo22919c(this.f13624a, "Unable process a failure to recieve an ad", th);
        }
        C7202r.m15409b(i, this.f13625b);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14836b(JSONObject jSONObject) {
        C7202r.m15404a(jSONObject, this.f13625b);
        this.f13625b.mo23031G();
        C7184mb a = mo22900a(jSONObject);
        if (((Boolean) this.f13625b.mo23039a(C7196pb.f13677Cc)).booleanValue()) {
            this.f13625b.mo23027C().mo22969a(a);
        } else {
            this.f13625b.mo23027C().mo22970a(a, C7113Tb.MAIN);
        }
        C7202r.m15410b(jSONObject, this.f13625b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C7184mb mo22900a(JSONObject jSONObject) {
        C7128Yb yb = new C7128Yb(jSONObject, this.f13301f, mo22906c(), this.f13302g, this.f13625b);
        return yb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo22901a(Map<String, String> map) {
        return C7202r.m15407b("3.0/ad", map, this.f13625b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22902a(int i) {
        C7254d dVar = this.f13302g;
        if (dVar == null) {
            return;
        }
        if (dVar instanceof C7060F) {
            ((C7060F) dVar).mo22816a(this.f13301f, i);
        } else {
            dVar.failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22903a(boolean z) {
        this.f13303h = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo22904b(Map<String, String> map) {
        return C7202r.m15412d("3.0/ad", map, this.f13625b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo22905b() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("zone_id", C7209sc.m15487d(this.f13301f.mo22799a()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C7047Bc mo22906c() {
        return this.f13301f.mo22814m() ? C7047Bc.APPLOVIN_PRIMARY_ZONE : C7047Bc.APPLOVIN_CUSTOM_ZONE;
    }

    public void run() {
        String str;
        StringBuilder sb;
        String str2;
        C7262l lVar;
        if (this.f13303h) {
            lVar = this.f13626c;
            str2 = this.f13624a;
            sb = new StringBuilder();
            str = "Preloading next ad of zone: ";
        } else {
            lVar = this.f13626c;
            str2 = this.f13624a;
            sb = new StringBuilder();
            str = "Fetching next ad of zone: ";
        }
        sb.append(str);
        sb.append(this.f13301f);
        lVar.mo22918c(str2, sb.toString());
        C7076J f = this.f13625b.mo23061f();
        f.mo22861a("ad_req");
        m14832a(f);
        try {
            C7094Nb nb = new C7094Nb(this, "GET", new JSONObject(), "RepeatFetchNextAd", this.f13625b);
            Map a = this.f13625b.mo23070o().mo23241a(mo22905b(), this.f13303h, false);
            nb.mo23150a(mo22901a(a));
            nb.mo23155b(mo22904b(a));
            nb.mo23153b(((Integer) this.f13625b.mo23039a(C7196pb.f13912z)).intValue());
            nb.mo23156c(((Integer) this.f13625b.mo23039a(C7196pb.f13847m)).intValue());
            nb.mo23149a(C7196pb.f13862p);
            nb.mo23154b(C7196pb.f13882t);
            nb.run();
        } catch (Throwable th) {
            C7262l lVar2 = this.f13626c;
            String str3 = this.f13624a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to fetch ad ");
            sb2.append(this.f13301f);
            lVar2.mo22917b(str3, sb2.toString(), th);
            m14835b(0);
        }
    }
}
