package p019d.p273h.p276c.p278b;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;

/* renamed from: d.h.c.b.j */
/* compiled from: OutcomeEventsFormatter */
class C12786j extends C12776a {

    /* renamed from: j */
    private final String f39341j = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";

    C12786j(int adUnit) {
        this.f39291h = adUnit;
    }

    /* renamed from: a */
    public String mo41336a() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";
    }

    /* renamed from: c */
    public String mo41342c() {
        return "outcome";
    }

    /* renamed from: a */
    public String mo41337a(ArrayList<C12733b> toSend, JSONObject generalProperties) {
        if (generalProperties == null) {
            this.f39290g = new JSONObject();
        } else {
            this.f39290g = generalProperties;
        }
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
        return mo41338a(eventsArray);
    }
}
