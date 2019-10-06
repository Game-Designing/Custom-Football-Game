package p019d.p143b.p144a.p147c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.b.a.c.J */
class C7076J {

    /* renamed from: a */
    private final C7142c f13255a;

    /* renamed from: b */
    private final Map<String, Long> f13256b = new HashMap();

    C7076J(C7142c cVar) {
        if (cVar != null) {
            this.f13255a = cVar;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: d */
    private void m14771d() {
        try {
            this.f13255a.mo23052b(C7216ub.f13981h, mo22865b().toString());
        } catch (Throwable th) {
            this.f13255a.mo23049b().mo22917b("GlobalStatsManager", "Unable to save stats", th);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo22861a(String str) {
        return mo22862a(str, 1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo22862a(String str, long j) {
        long longValue;
        synchronized (this.f13256b) {
            Long l = (Long) this.f13256b.get(str);
            if (l == null) {
                l = Long.valueOf(0);
            }
            longValue = l.longValue() + j;
            this.f13256b.put(str, Long.valueOf(longValue));
        }
        m14771d();
        return longValue;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22863a() {
        synchronized (this.f13256b) {
            this.f13256b.clear();
        }
        m14771d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo22864b(String str) {
        long longValue;
        synchronized (this.f13256b) {
            Long l = (Long) this.f13256b.get(str);
            if (l == null) {
                l = Long.valueOf(0);
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public JSONObject mo22865b() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.f13256b) {
            jSONObject = new JSONObject();
            for (Entry entry : this.f13256b.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22866b(String str, long j) {
        synchronized (this.f13256b) {
            this.f13256b.put(str, Long.valueOf(j));
        }
        m14771d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo22867c() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f13255a.mo23041a(C7216ub.f13981h, "{}"));
            synchronized (this.f13256b) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str = (String) keys.next();
                        this.f13256b.put(str, Long.valueOf(jSONObject.getLong(str)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f13255a.mo23049b().mo22917b("GlobalStatsManager", "Unable to load stats", th);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo22868c(String str) {
        synchronized (this.f13256b) {
            this.f13256b.remove(str);
        }
        m14771d();
    }
}
