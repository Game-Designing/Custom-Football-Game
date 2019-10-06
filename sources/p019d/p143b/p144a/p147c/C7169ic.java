package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment.BundleKeys;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.ic */
public class C7169ic extends C7172jb {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C7234z f13597f;

    public C7169ic(C7234z zVar, C7142c cVar) {
        super("TaskReportReward", cVar);
        this.f13597f = zVar;
    }

    public void run() {
        String b = C7140bb.m15035a().mo23024b(this.f13597f);
        if (b != null) {
            HashMap hashMap = new HashMap(6);
            hashMap.put("result", b);
            hashMap.put("zone_id", this.f13597f.mo22762n().mo22799a());
            hashMap.put("fire_percent", Integer.valueOf(this.f13597f.mo23414T()));
            String h = this.f13597f.mo22761h();
            if (!C7269s.m15819a(h)) {
                h = "NO_CLCODE";
            }
            hashMap.put("clcode", h);
            String D = this.f13625b.mo23028D();
            if (!TextUtils.isEmpty(D)) {
                hashMap.put(BundleKeys.USER_ID, D);
            }
            Map a = C7140bb.m15035a().mo23021a(this.f13597f);
            if (a != null) {
                hashMap.put("params", a);
            }
            mo23180a("cr", new JSONObject(hashMap), new C7173jc(this));
            return;
        }
        C7262l lVar = this.f13626c;
        StringBuilder sb = new StringBuilder();
        sb.append("No reward result was found for ad: ");
        sb.append(this.f13597f);
        lVar.mo22916b("TaskReportReward", sb.toString());
    }
}
