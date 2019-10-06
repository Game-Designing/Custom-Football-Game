package p019d.p143b.p144a.p145a;

import java.util.Set;
import org.json.JSONObject;
import p019d.p143b.p144a.p147c.C7047Bc;
import p019d.p143b.p144a.p147c.C7142c;

/* renamed from: d.b.a.a.c */
public class C6927c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public JSONObject f12740a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public JSONObject f12741b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C7047Bc f12742c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C7142c f12743d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f12744e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f12745f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f12746g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C6935k f12747h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C6939o f12748i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C6930f f12749j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Set<C6936l> f12750k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Set<C6936l> f12751l;

    private C6927c() {
    }

    /* renamed from: a */
    public C6925a mo22418a() {
        return new C6925a(this);
    }

    /* renamed from: a */
    public C6927c mo22419a(long j) {
        this.f12744e = j;
        return this;
    }

    /* renamed from: a */
    public C6927c mo22420a(C6930f fVar) {
        this.f12749j = fVar;
        return this;
    }

    /* renamed from: a */
    public C6927c mo22421a(C6935k kVar) {
        this.f12747h = kVar;
        return this;
    }

    /* renamed from: a */
    public C6927c mo22422a(C6939o oVar) {
        this.f12748i = oVar;
        return this;
    }

    /* renamed from: a */
    public C6927c mo22423a(C7047Bc bc) {
        this.f12742c = bc;
        return this;
    }

    /* renamed from: a */
    public C6927c mo22424a(C7142c cVar) {
        if (cVar != null) {
            this.f12743d = cVar;
            return this;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    public C6927c mo22425a(String str) {
        this.f12745f = str;
        return this;
    }

    /* renamed from: a */
    public C6927c mo22426a(Set<C6936l> set) {
        this.f12750k = set;
        return this;
    }

    /* renamed from: a */
    public C6927c mo22427a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f12740a = jSONObject;
            return this;
        }
        throw new IllegalArgumentException("No ad object specified.");
    }

    /* renamed from: b */
    public C6927c mo22428b(String str) {
        this.f12746g = str;
        return this;
    }

    /* renamed from: b */
    public C6927c mo22429b(Set<C6936l> set) {
        this.f12751l = set;
        return this;
    }

    /* renamed from: b */
    public C6927c mo22430b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f12741b = jSONObject;
            return this;
        }
        throw new IllegalArgumentException("No full ad response specified.");
    }
}
