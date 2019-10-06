package p019d.p143b.p144a.p147c;

import android.content.Context;
import java.util.Map;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Q */
class C7103Q implements C7252b, C7253c, C7255e, C7260j {

    /* renamed from: a */
    private final Context f13333a;

    /* renamed from: b */
    private final C7253c f13334b;

    /* renamed from: c */
    private final C7252b f13335c;

    /* renamed from: d */
    private final C7260j f13336d;

    /* renamed from: e */
    private final C7255e f13337e;

    /* renamed from: f */
    final /* synthetic */ C7080K f13338f;

    private C7103Q(C7080K k, Context context, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar) {
        this.f13338f = k;
        this.f13334b = cVar;
        this.f13335c = bVar;
        this.f13336d = jVar;
        this.f13337e = eVar;
        this.f13333a = context;
    }

    /* synthetic */ C7103Q(C7080K k, Context context, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar, C7084L l) {
        this(k, context, eVar, jVar, cVar, bVar);
    }

    /* renamed from: a */
    private void m14867a(C7234z zVar) {
        String str;
        int i;
        String b = this.f13338f.mo22877b();
        if (!C7269s.m15819a(b) || !this.f13338f.f13268j) {
            this.f13338f.f13267i.mo23211a(true);
            if (this.f13338f.f13268j) {
                i = -500;
                str = "network_timeout";
            } else {
                i = -600;
                str = "user_closed_video";
            }
            C7140bb.m15035a().mo23022a(zVar, str);
            if (this.f13338f.f13268j) {
                this.f13338f.mo22875a(b, this.f13333a);
            }
            C7171ja.m15277a(this.f13337e, (C7251a) zVar, i, (C7267q) this.f13338f.f13259a);
        } else {
            this.f13338f.mo22875a(b, this.f13333a);
        }
        this.f13338f.m14791a((C7251a) zVar);
        C7171ja.m15284b(this.f13334b, zVar, this.f13338f.f13259a);
        if (!zVar.mo23416V().getAndSet(true)) {
            this.f13338f.f13259a.mo23027C().mo22970a((C7184mb) new C7169ic(zVar, this.f13338f.f13259a), C7113Tb.BACKGROUND);
        }
    }

    /* renamed from: a */
    private void m14868a(C7235za zaVar) {
        this.f13338f.f13259a.mo23049b().mo22918c("IncentivizedAdController", "Handling ad hidden for mediated ad...");
        C7171ja.m15284b(this.f13334b, zaVar, this.f13338f.f13259a);
    }

    public void adClicked(C7251a aVar) {
        C7171ja.m15275a(this.f13335c, aVar, (C7267q) this.f13338f.f13259a);
    }

    public void adDisplayed(C7251a aVar) {
        C7171ja.m15276a(this.f13334b, aVar, (C7267q) this.f13338f.f13259a);
    }

    public void adHidden(C7251a aVar) {
        if (aVar instanceof C7048C) {
            aVar = ((C7048C) aVar).mo22764q();
        }
        if (aVar instanceof C7234z) {
            m14867a((C7234z) aVar);
        } else if (aVar instanceof C7235za) {
            m14868a((C7235za) aVar);
        } else {
            C7262l b = this.f13338f.f13259a.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Something is terribly wrong. Received `adHidden` callback for invalid ad of type: ");
            sb.append(aVar);
            b.mo22916b("IncentivizedAdController", sb.toString());
        }
    }

    public void userDeclinedToViewAd(C7251a aVar) {
    }

    public void userOverQuota(C7251a aVar, Map<String, String> map) {
        this.f13338f.mo22874a("quota_exceeded");
        C7171ja.m15285b(this.f13337e, aVar, map, (C7267q) this.f13338f.f13259a);
    }

    public void userRewardRejected(C7251a aVar, Map<String, String> map) {
        this.f13338f.mo22874a("rejected");
        C7171ja.m15287c(this.f13337e, aVar, map, (C7267q) this.f13338f.f13259a);
    }

    public void userRewardVerified(C7251a aVar, Map<String, String> map) {
        this.f13338f.mo22874a("accepted");
        C7171ja.m15279a(this.f13337e, aVar, map, (C7267q) this.f13338f.f13259a);
    }

    public void validationRequestFailed(C7251a aVar, int i) {
        this.f13338f.mo22874a("network_timeout");
        C7171ja.m15277a(this.f13337e, aVar, i, (C7267q) this.f13338f.f13259a);
    }

    public void videoPlaybackBegan(C7251a aVar) {
        C7171ja.m15281a(this.f13336d, aVar, (C7267q) this.f13338f.f13259a);
    }

    public void videoPlaybackEnded(C7251a aVar, double d, boolean z) {
        C7171ja.m15280a(this.f13336d, aVar, d, z, this.f13338f.f13259a);
        this.f13338f.f13268j = z;
    }
}
