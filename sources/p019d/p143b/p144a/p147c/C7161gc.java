package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: d.b.a.c.gc */
abstract class C7161gc<T> extends C7184mb implements C7198q<T> {

    /* renamed from: f */
    private final String f13548f;

    /* renamed from: g */
    private final T f13549g;

    /* renamed from: h */
    private final C7198q<T> f13550h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f13551i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f13552j;

    /* renamed from: k */
    private JSONObject f13553k;

    /* renamed from: l */
    private int f13554l;

    /* renamed from: m */
    private boolean f13555m = true;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f13556n = 1;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public long f13557o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C7204rb<String> f13558p = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C7204rb<String> f13559q = null;

    /* renamed from: r */
    protected C7194p f13560r;

    C7161gc(String str, T t, String str2, C7142c cVar) {
        super(str2, cVar);
        this.f13548f = str;
        this.f13549g = t;
        this.f13554l = ((Integer) cVar.mo23039a(C7196pb.f13907y)).intValue();
        this.f13557o = ((Long) cVar.mo23039a(C7196pb.f13892v)).longValue();
        this.f13560r = new C7194p();
        this.f13550h = new C7165hc(this, str2, cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public <T> void m15223c(C7204rb<T> rbVar) {
        if (rbVar != null) {
            C7208sb A = this.f13625b.mo23026A();
            A.mo23251a(rbVar, rbVar.mo23237c());
            A.mo23250a();
        }
    }

    /* renamed from: a */
    public abstract void mo22856a(int i);

    /* renamed from: a */
    public void mo23148a(long j) {
        this.f13557o = j;
    }

    /* renamed from: a */
    public void mo23149a(C7204rb<String> rbVar) {
        this.f13558p = rbVar;
    }

    /* renamed from: a */
    public abstract void mo22857a(T t, int i);

    /* renamed from: a */
    public void mo23150a(String str) {
        this.f13551i = str;
    }

    /* renamed from: a */
    public void mo23151a(JSONObject jSONObject) {
        this.f13553k = jSONObject;
    }

    /* renamed from: a */
    public void mo23152a(boolean z) {
        this.f13555m = z;
    }

    /* renamed from: b */
    public void mo23153b(int i) {
        this.f13554l = i;
    }

    /* renamed from: b */
    public void mo23154b(C7204rb<String> rbVar) {
        this.f13559q = rbVar;
    }

    /* renamed from: b */
    public void mo23155b(String str) {
        this.f13552j = str;
    }

    /* renamed from: c */
    public void mo23156c(int i) {
        this.f13556n = i;
    }

    public void run() {
        int i;
        C7190o n = this.f13625b.mo23069n();
        if (!this.f13625b.mo23065j() && !this.f13625b.mo23032H()) {
            String str = "AppLovin SDK is disabled: please check your connection";
            this.f13626c.mo22916b(mo23203a(), str);
            this.f13626c.mo22916b("AppLovinSdk", str);
            i = -22;
        } else if (TextUtils.isEmpty(this.f13551i) || this.f13551i.length() < 4) {
            this.f13626c.mo22916b(mo23203a(), "Task has an invalid or null request endpoint.");
            i = -900;
        } else {
            String str2 = this.f13548f;
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f13553k == null ? "GET" : "POST";
            }
            n.mo23215a(this.f13551i, str2, this.f13554l, this.f13553k, this.f13549g, this.f13555m, this.f13560r, this.f13550h);
            return;
        }
        mo22856a(i);
    }
}
