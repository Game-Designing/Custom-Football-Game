package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment.BundleKeys;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.nc */
class C7189nc extends C7172jb {

    /* renamed from: f */
    private final C7234z f13645f;

    /* renamed from: g */
    private final C7255e f13646g;

    /* renamed from: h */
    private final Object f13647h = new Object();

    /* renamed from: i */
    private volatile boolean f13648i = false;

    public C7189nc(C7234z zVar, C7255e eVar, C7142c cVar) {
        super("TaskValidateReward", cVar);
        this.f13645f = zVar;
        this.f13646g = eVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15358a(int i) {
        String str;
        if (!mo23212b()) {
            if (i < 400 || i > 500) {
                this.f13646g.validationRequestFailed(this.f13645f, i);
                str = "network_timeout";
            } else {
                this.f13646g.userRewardRejected(this.f13645f, new HashMap(0));
                str = "rejected";
            }
            C7140bb.m15035a().mo23022a(this.f13645f, str);
        }
    }

    /* renamed from: a */
    private void m15361a(String str, Map<String, String> map) {
        if (!mo23212b()) {
            C7140bb a = C7140bb.m15035a();
            a.mo23022a(this.f13645f, str);
            a.mo23023a(this.f13645f, map);
            if (str.equals("accepted")) {
                this.f13646g.userRewardVerified(this.f13645f, map);
            } else if (str.equals("quota_exceeded")) {
                this.f13646g.userOverQuota(this.f13645f, map);
            } else if (str.equals("rejected")) {
                this.f13646g.userRewardRejected(this.f13645f, map);
            } else {
                this.f13646g.validationRequestFailed(this.f13645f, -400);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15362a(JSONObject jSONObject) {
        Map map;
        String str;
        if (!mo23212b()) {
            try {
                JSONObject a = C7202r.m15402a(jSONObject);
                C7202r.m15404a(a, this.f13625b);
                try {
                    map = C7167ia.m15260a((JSONObject) a.get("params"));
                } catch (Throwable th) {
                    map = new HashMap(0);
                }
                try {
                    str = a.getString("result");
                } catch (Throwable th2) {
                    str = "network_timeout";
                }
                m15361a(str, map);
            } catch (JSONException e) {
                this.f13626c.mo22917b(this.f13624a, "Unable to parse API response", e);
            }
        }
    }

    /* renamed from: a */
    public void mo23211a(boolean z) {
        synchronized (this.f13647h) {
            this.f13648i = z;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo23212b() {
        boolean z;
        synchronized (this.f13647h) {
            z = this.f13648i;
        }
        return z;
    }

    public void run() {
        String D = this.f13625b.mo23028D();
        String h = this.f13645f.mo22761h();
        HashMap hashMap = new HashMap(3);
        hashMap.put("zone_id", this.f13645f.mo22762n().mo22799a());
        String str = "clcode";
        if (!C7269s.m15819a(h)) {
            h = "NO_CLCODE";
        }
        hashMap.put(str, h);
        if (!TextUtils.isEmpty(D)) {
            hashMap.put(BundleKeys.USER_ID, D);
        }
        mo23180a("vr", new JSONObject(hashMap), new C7193oc(this));
    }
}
