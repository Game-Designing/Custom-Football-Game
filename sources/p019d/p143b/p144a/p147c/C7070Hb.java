package p019d.p143b.p144a.p147c;

import java.util.Map;
import org.json.JSONObject;
import p019d.p143b.p150d.C7264n;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Hb */
public class C7070Hb extends C7184mb {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f13226f;

    /* renamed from: g */
    private final Map<String, String> f13227g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C7264n f13228h;

    /* renamed from: i */
    private String f13229i;

    /* renamed from: j */
    private int f13230j;

    /* renamed from: k */
    private long f13231k;

    /* renamed from: l */
    private int f13232l = -1;

    public C7070Hb(C7142c cVar, String str, Map<String, String> map, C7264n nVar) {
        super("TaskDispatchPostback", cVar);
        this.f13226f = str;
        this.f13228h = nVar;
        this.f13227g = map;
    }

    /* renamed from: a */
    public void mo22839a(int i) {
        this.f13230j = i;
    }

    /* renamed from: a */
    public void mo22840a(long j) {
        this.f13231k = j;
    }

    /* renamed from: a */
    public void mo22841a(String str) {
        this.f13229i = str;
    }

    /* renamed from: b */
    public void mo22842b(int i) {
        this.f13232l = i;
    }

    public void run() {
        if (!C7269s.m15819a(this.f13226f)) {
            this.f13625b.mo23049b().mo22920d("TaskDispatchPostback", "Requested URL is not valid; nothing to do...");
            this.f13228h.onPostbackFailure(this.f13226f, -900);
            return;
        }
        C7074Ib ib = new C7074Ib(this, this.f13227g == null ? "GET" : "POST", new JSONObject(), "RepeatTaskDispatchPostback", this.f13625b);
        ib.mo23150a(this.f13226f);
        ib.mo23155b(this.f13229i);
        Map<String, String> map = this.f13227g;
        ib.mo23151a(map == null ? null : new JSONObject(map));
        ib.mo23148a(this.f13231k);
        int i = this.f13230j;
        if (i < 0) {
            i = ((Integer) this.f13625b.mo23039a(C7196pb.f13859ob)).intValue();
        }
        ib.mo23156c(i);
        int i2 = this.f13232l;
        if (i2 < 0) {
            i2 = ((Integer) this.f13625b.mo23039a(C7196pb.f13854nb)).intValue();
        }
        ib.mo23153b(i2);
        ib.mo23152a(false);
        ib.run();
    }
}
