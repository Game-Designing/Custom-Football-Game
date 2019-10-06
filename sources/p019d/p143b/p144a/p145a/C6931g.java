package p019d.p143b.p144a.p145a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import p019d.p143b.p144a.p147c.C7047Bc;
import p019d.p143b.p144a.p147c.C7059Ec;
import p019d.p143b.p144a.p147c.C7063Fc;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p144a.p147c.C7167ia;
import p019d.p143b.p144a.p147c.C7178l;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.a.g */
public class C6931g {

    /* renamed from: a */
    private static final List<String> f12768a = Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});

    /* renamed from: b */
    private final C7142c f12769b;

    /* renamed from: c */
    protected List<C7217uc> f12770c = new ArrayList();

    /* renamed from: d */
    private final JSONObject f12771d;

    /* renamed from: e */
    private final JSONObject f12772e;

    /* renamed from: f */
    private final C7047Bc f12773f;

    /* renamed from: g */
    private final long f12774g = System.currentTimeMillis();

    public C6931g(JSONObject jSONObject, JSONObject jSONObject2, C7047Bc bc, C7142c cVar) {
        this.f12769b = cVar;
        this.f12771d = jSONObject;
        this.f12772e = jSONObject2;
        this.f12773f = bc;
    }

    /* renamed from: a */
    public int mo22438a() {
        return this.f12770c.size();
    }

    /* renamed from: b */
    public List<C7217uc> mo22439b() {
        return this.f12770c;
    }

    /* renamed from: c */
    public JSONObject mo22440c() {
        return this.f12771d;
    }

    /* renamed from: d */
    public JSONObject mo22441d() {
        return this.f12772e;
    }

    /* renamed from: e */
    public C7047Bc mo22442e() {
        return this.f12773f;
    }

    /* renamed from: f */
    public long mo22443f() {
        return this.f12774g;
    }

    /* renamed from: g */
    public C7059Ec mo22444g() {
        String a = C7167ia.m15258a(this.f12772e, "zone_id", (String) null, (C7267q) this.f12769b);
        return C7059Ec.m14671a(C7257g.m15776a(C7167ia.m15258a(this.f12772e, "ad_size", (String) null, (C7267q) this.f12769b)), C7258h.m15781a(C7167ia.m15258a(this.f12772e, "ad_type", (String) null, (C7267q) this.f12769b)), C7063Fc.f13210b, a, this.f12769b);
    }

    /* renamed from: h */
    public List<String> mo22445h() {
        List<String> a = C7178l.m15309a(C7167ia.m15258a(this.f12771d, "vast_preferred_video_types", (String) null, (C7267q) null));
        return !a.isEmpty() ? a : f12768a;
    }

    /* renamed from: i */
    public int mo22446i() {
        return C7209sc.m15462a(this.f12771d);
    }
}
