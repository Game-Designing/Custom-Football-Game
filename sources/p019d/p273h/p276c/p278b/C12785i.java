package p019d.p273h.p276c.p278b;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;

/* renamed from: d.h.c.b.i */
/* compiled from: IronbeastEventsFormatter */
class C12785i extends C12776a {

    /* renamed from: j */
    private final String f39337j = "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";

    /* renamed from: k */
    private final String f39338k = "super.dwh.mediation_events";

    /* renamed from: l */
    private final String f39339l = "table";

    /* renamed from: m */
    private final String f39340m = "data";

    C12785i(int adUnit) {
        this.f39291h = adUnit;
    }

    /* renamed from: a */
    public String mo41336a() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    }

    /* renamed from: c */
    public String mo41342c() {
        return "ironbeast";
    }

    /* renamed from: a */
    public String mo41337a(ArrayList<C12733b> toSend, JSONObject generalProperties) {
        JSONObject jsonBody = new JSONObject();
        if (generalProperties == null) {
            this.f39290g = new JSONObject();
        } else {
            this.f39290g = generalProperties;
        }
        try {
            JSONArray eventsArray = new JSONArray();
            if (toSend != null && !toSend.isEmpty()) {
                Iterator it = toSend.iterator();
                while (it.hasNext()) {
                    JSONObject jsonEvent = mo41339a((C12733b) it.next());
                    if (jsonEvent != null) {
                        eventsArray.put(jsonEvent);
                    }
                }
            }
            jsonBody.put("table", "super.dwh.mediation_events");
            jsonBody.put("data", mo41338a(eventsArray));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonBody.toString();
    }
}
