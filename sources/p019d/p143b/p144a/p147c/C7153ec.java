package p019d.p143b.p144a.p147c;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.ec */
class C7153ec extends C7184mb {

    /* renamed from: f */
    private final C7248b f13509f;

    /* renamed from: g */
    private final JSONObject f13510g;

    C7153ec(JSONObject jSONObject, C7142c cVar, C7248b bVar) {
        super("TaskRenderNativeAd", cVar);
        this.f13509f = bVar;
        this.f13510g = jSONObject;
    }

    /* renamed from: a */
    private String m15164a(Map<String, String> map, String str) {
        String str2 = (String) map.get("simp_url");
        if (C7269s.m15819a(str2)) {
            return str2.replace("{CLCODE}", str);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    /* renamed from: a */
    private String m15165a(Map<String, String> map, String str, String str2) {
        String str3 = (String) map.get("click_url");
        if (C7269s.m15819a(str3)) {
            if (str2 == null) {
                str2 = "";
            }
            return str3.replace("{CLCODE}", str).replace("{EVENT_ID}", str2);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    /* renamed from: a */
    private void m15166a(JSONObject jSONObject) throws JSONException, MalformedURLException {
        List<Map> a = C7167ia.m15259a(jSONObject.getJSONArray("native_ads"));
        Map a2 = C7167ia.m15260a(jSONObject.getJSONObject("native_settings"));
        ArrayList arrayList = new ArrayList(a.size());
        for (Map map : a) {
            String str = (String) map.get("clcode");
            String a3 = C7167ia.m15258a(jSONObject, "zone_id", (String) null, (C7267q) this.f13625b);
            C7059Ec b = C7059Ec.m14676b(a3, this.f13625b);
            String str2 = (String) map.get("resource_cache_prefix");
            List a4 = str2 != null ? C7178l.m15309a(str2) : this.f13625b.mo23050b((C7204rb) C7196pb.f13734O);
            C7106Ra ra = new C7106Ra();
            ra.mo22928a(b);
            ra.mo22936e(a3);
            ra.mo22937f((String) map.get("title"));
            ra.mo22938g((String) map.get(Repo.COLUMN_DESCRIPTION));
            ra.mo22939h((String) map.get("caption"));
            ra.mo22948q((String) map.get("cta"));
            String str3 = "icon_url";
            ra.mo22930a((String) map.get(str3));
            String str4 = "image_url";
            ra.mo22933b((String) map.get(str4));
            String str5 = "video_url";
            ra.mo22935d((String) map.get(str5));
            ra.mo22934c((String) map.get("star_rating_url"));
            ra.mo22940i((String) map.get(str3));
            ra.mo22941j((String) map.get(str4));
            ra.mo22942k((String) map.get(str5));
            ra.mo22926a(Float.parseFloat((String) map.get("star_rating")));
            ra.mo22947p(str);
            ra.mo22943l(m15164a(a2, str));
            ra.mo22944m(m15165a(a2, str, (String) map.get("event_id")));
            ra.mo22945n(m15167b(a2, str));
            ra.mo22946o(m15168c(a2, str));
            ra.mo22927a(Long.parseLong((String) map.get("ad_id")));
            ra.mo22931a(a4);
            ra.mo22929a(this.f13625b);
            C7154f a5 = ra.mo22932a();
            arrayList.add(a5);
            C7262l b2 = this.f13625b.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Prepared native ad: ");
            sb.append(a5.mo23127m());
            b2.mo22918c("TaskRenderNativeAd", sb.toString());
        }
        C7248b bVar = this.f13509f;
        if (bVar != null) {
            bVar.onNativeAdsLoaded(arrayList);
        }
    }

    /* renamed from: b */
    private String m15167b(Map<String, String> map, String str) {
        String str2 = (String) map.get("video_start_url");
        if (str2 != null) {
            return str2.replace("{CLCODE}", str);
        }
        return null;
    }

    /* renamed from: c */
    private String m15168c(Map<String, String> map, String str) {
        String str2 = (String) map.get("video_end_url");
        if (str2 != null) {
            return str2.replace("{CLCODE}", str);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23109a(int i) {
        try {
            if (this.f13509f != null) {
                this.f13509f.onNativeAdsFailedToLoad(i);
            }
        } catch (Exception e) {
            this.f13625b.mo23049b().mo22917b("TaskRenderNativeAd", "Unable to notify listener about failure.", e);
        }
    }

    public void run() {
        try {
            if (this.f13510g != null) {
                if (this.f13510g.length() != 0) {
                    m15166a(this.f13510g);
                    return;
                }
            }
            mo23109a(-700);
        } catch (Exception e) {
            this.f13625b.mo23049b().mo22917b("TaskRenderNativeAd", "Unable to render widget.", e);
            mo23109a(-200);
        }
    }
}
