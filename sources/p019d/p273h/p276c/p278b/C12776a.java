package p019d.p273h.p276c.p278b;

import android.text.TextUtils;
import com.mopub.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.b.a */
/* compiled from: AbstractEventsFormatter */
abstract class C12776a {

    /* renamed from: a */
    private final String f39284a = "eventId";

    /* renamed from: b */
    private final String f39285b = "timestamp";

    /* renamed from: c */
    private final String f39286c = "adUnit";

    /* renamed from: d */
    private final String f39287d = "InterstitialEvents";

    /* renamed from: e */
    private final String f39288e;

    /* renamed from: f */
    private final String f39289f;

    /* renamed from: g */
    JSONObject f39290g;

    /* renamed from: h */
    int f39291h;

    /* renamed from: i */
    private String f39292i;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo41336a();

    /* renamed from: a */
    public abstract String mo41337a(ArrayList<C12733b> arrayList, JSONObject jSONObject);

    /* renamed from: c */
    public abstract String mo41342c();

    C12776a() {
        String str = Constants.VIDEO_TRACKING_EVENTS_KEY;
        this.f39288e = str;
        this.f39289f = str;
    }

    /* renamed from: a */
    private String m41431a(int adUnit) {
        if (adUnit == 2) {
            return "InterstitialEvents";
        }
        String str = Constants.VIDEO_TRACKING_EVENTS_KEY;
        if (adUnit != 3) {
            return str;
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo41339a(C12733b event) {
        try {
            JSONObject jsonEvent = new JSONObject(event.mo41154a());
            jsonEvent.put("eventId", event.mo41158c());
            jsonEvent.put("timestamp", event.mo41159d());
            return jsonEvent;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo41338a(JSONArray eventsArray) {
        String result = "";
        try {
            if (this.f39290g == null) {
                return result;
            }
            JSONObject data = new JSONObject(this.f39290g.toString());
            data.put("timestamp", C12916j.m41983d());
            data.put("adUnit", this.f39291h);
            data.put(m41431a(this.f39291h), eventsArray);
            return data.toString();
        } catch (Exception e) {
            return result;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo41341b() {
        return TextUtils.isEmpty(this.f39292i) ? mo41336a() : this.f39292i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41340a(String url) {
        this.f39292i = url;
    }
}
