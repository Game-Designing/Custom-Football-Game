package com.paypal.android.sdk;

import com.mopub.common.Constants;
import java.util.GregorianCalendar;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.V */
public class C11771V extends C12031za {

    /* renamed from: m */
    private final C11774W f37041m;

    static {
        C11771V.class.getSimpleName();
    }

    public C11771V(C12027ya yaVar, C11707Ba ba, C11706B b, C11774W w) {
        super(yaVar, ba, b, null);
        this.f37041m = w;
        mo38500a("Accept", "application/json; charset=utf-8");
        mo38500a("Accept-Language", "en_US");
        mo38500a("Content-Type", "application/json");
    }

    /* renamed from: a */
    private static JSONObject m38989a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            jSONObject.accumulate(str, map.get(str));
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final String mo38496a(C12027ya yaVar) {
        return "https://api.paypal.com/v1/tracking/events";
    }

    /* renamed from: a */
    public final boolean mo38502a() {
        return true;
    }

    /* renamed from: b */
    public final String mo38503b() {
        String a = C11723Fa.m38812a(mo38521s().mo38531d().mo38697e());
        String str = this.f37041m.f37047a;
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("tracking_visitor_id", a);
        jSONObject.accumulate("tracking_visit_id", str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate("actor", jSONObject);
        jSONObject2.accumulate("channel", "mobile");
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject2.accumulate("tracking_event", Long.toString(currentTimeMillis));
        String str2 = "t";
        this.f37041m.f37048b.put(str2, Long.toString(currentTimeMillis - ((long) new GregorianCalendar().getTimeZone().getRawOffset())));
        this.f37041m.f37048b.put("dsid", a);
        this.f37041m.f37048b.put("vid", str);
        jSONObject2.accumulate("event_params", m38989a(this.f37041m.f37048b));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.accumulate(Constants.VIDEO_TRACKING_EVENTS_KEY, jSONObject2);
        return jSONObject3.toString();
    }

    /* renamed from: c */
    public final void mo38505c() {
    }

    /* renamed from: d */
    public final void mo38507d() {
    }

    /* renamed from: e */
    public final String mo38508e() {
        return "mockResponse";
    }
}
